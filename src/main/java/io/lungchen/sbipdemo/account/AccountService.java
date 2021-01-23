package io.lungchen.sbipdemo.account;

import io.lungchen.sbipdemo.util.Connection;
import org.hyperledger.fabric.gateway.Contract;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public Double getAmount(String accountId, String publicKey) {

        Double amount = 0.0;

        try {

            Contract contract = Connection.getContract("sbipdemochannel", "sbipsc");
            amount = Double.parseDouble(new String(contract.evaluateTransaction("peekBalance", accountId, publicKey)));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return amount;
    }

    public boolean createAccount(String accountId, String publicKey, Double initialBalance) {

        try {

            Contract contract = Connection.getContract("sbipdemochannel", "sbipsc");
            contract.submitTransaction("createAccount", accountId, publicKey, initialBalance.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
