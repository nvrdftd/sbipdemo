package io.lungchen.sbipdemo.util;

import org.hyperledger.fabric.gateway.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class Connection {
    public static Contract getContract(String networkName, String contractName) throws Exception {

        Path walletPath = Paths.get("wallet");
        Wallet wallet = Wallets.newFileSystemWallet(walletPath);

        Path networkConfigPath = Paths.get("network", "connection-org1.yaml");

        Gateway.Builder builder = Gateway.createBuilder();
        builder.identity(wallet, "appUser").networkConfig(networkConfigPath);

        Gateway gateway = builder.connect();

        Network network = gateway.getNetwork(networkName);
        return network.getContract(contractName);
    }
}
