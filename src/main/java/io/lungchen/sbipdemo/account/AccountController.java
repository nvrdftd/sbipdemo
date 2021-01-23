package io.lungchen.sbipdemo.account;

import io.lungchen.sbipdemo.crypto.CryptoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private Logger logger;

    private final CryptoService cryptoService;

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
        this.logger = LoggerFactory.getLogger(AccountController.class);
        this.cryptoService = CryptoService.getCryptoService();
    }

    @GetMapping("/get-balance")
    @ResponseBody
    public Balance getBalance(@RequestBody BalanceRequestBody requestBody) {

        boolean isVerified = cryptoService.verify(requestBody);

        if (!isVerified) {
            return new Balance(requestBody.getId(), 0.0, "error");
        }

        Double amount = accountService.getAmount(requestBody.getAccountId(), requestBody.getKey());
        return new Balance(requestBody.getId(), 0.0, "ok");
    }

    @PostMapping("/account")
    @ResponseBody
    public Account createAccount(@RequestBody AccountRequestBody requestBody) {


        boolean isCreated = accountService.createAccount(requestBody.getAccountId(), requestBody.getKey(), requestBody.getInitialBalance());

        if (!isCreated) {
            return new Account(requestBody.getId(), requestBody.getAccountId(), requestBody.getKey(), "error");
        }

        return new Account(requestBody.getId(), requestBody.getAccountId(), requestBody.getKey(), "ok");
    }
}
