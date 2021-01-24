package io.lungchen.sbipdemo.account;

import io.lungchen.sbipdemo.util.Connection;
import org.hyperledger.fabric.gateway.Contract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AccountService {

    private final Connection connection;
    private final Logger logger;

    public AccountService() {
        this.connection = Connection.getConnection("sbipdemochannel", "sbipsc");
        this.logger = LoggerFactory.getLogger(AccountService.class);
    }

    public Double getAmount(String accountId, String publicKey) {

        Double amount = 0.0;

        try {

            Long startTime = System.nanoTime();

            amount = Double.parseDouble(new String(connection.getContract().evaluateTransaction("peekBalance", accountId, publicKey)));

            Long endTime = System.nanoTime();

            Long timeElapsed = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

            logger.info("get-balance time elapsed to chaincode: " + timeElapsed.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return amount;
    }

    public boolean createAccount(String accountId, String publicKey, Double initialBalance) {

        try {
            connection.getContract().submitTransaction("createAccount", accountId, publicKey, initialBalance.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
