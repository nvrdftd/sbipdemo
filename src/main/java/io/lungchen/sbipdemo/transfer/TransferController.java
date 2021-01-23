package io.lungchen.sbipdemo.transfer;

import io.lungchen.sbipdemo.crypto.CryptoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransferController {
    private Logger logger;
    private final TransferService transferService;
    private final CryptoService cryptoService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
        this.cryptoService = CryptoService.getCryptoService();
        this.logger = LoggerFactory.getLogger(TransferController.class);
    }

    @PostMapping("/send")
    @ResponseBody
    public Transfer send(@RequestBody TransferRequestBody requestBody) {

        boolean isVerified = cryptoService.verify(requestBody);

        logger.info(requestBody.getSignature() + " verified with " + requestBody.getKey());

        if (!isVerified) {
            return new Transfer(requestBody.getId(), "error: not authenticated");
        }

        boolean isTransferred = transferService.transfer(requestBody.getFrom(), requestBody.getTo(), requestBody.getAmount(), requestBody.getKey());

        if (!isTransferred) {
            return new Transfer(requestBody.getId(), "error: not enough balance");
        }

        logger.info("Request " + requestBody.getId().toString() + " succeeded.");

        return new Transfer(requestBody.getId(), "ok");
    }
}
