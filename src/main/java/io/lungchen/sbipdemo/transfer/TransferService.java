package io.lungchen.sbipdemo.transfer;

import io.lungchen.sbipdemo.util.Connection;
import org.hyperledger.fabric.gateway.*;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    private final Connection connection;

    public TransferService() {
        this.connection = Connection.getConnection("sbipdemochannel", "sbipsc");
    }

    public boolean transfer(String from, String to, Double amount, String publicKey) {
        try {

            connection.getContract().submitTransaction("transfer", from, to, amount.toString(), publicKey);

        } catch (Exception e) {
            e.getMessage();
            return false;
        }
        return true;
    }
}
