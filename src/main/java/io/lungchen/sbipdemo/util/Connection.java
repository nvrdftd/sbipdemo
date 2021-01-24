package io.lungchen.sbipdemo.util;

import org.hyperledger.fabric.gateway.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Connection {

    private static Connection connection;

    private Contract contract;

    private Connection(String networkName, String contractName) {

        try {

            Path walletPath = Paths.get("wallet");
            Wallet wallet = Wallets.newFileSystemWallet(walletPath);

            Path networkConfigPath = Paths.get("network", "connection-org1.yaml");

            Gateway.Builder builder = Gateway.createBuilder();
            builder.identity(wallet, "appUser").networkConfig(networkConfigPath);

            Gateway gateway = builder.connect();

            Network network = gateway.getNetwork(networkName);

            contract = network.getContract(contractName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(String networkName, String contractName) {
        if (connection == null) {
            connection = new Connection(networkName, contractName);
        }

        return connection;
    }

    public Contract getContract() {
        return contract;
    }
}
