package io.lungchen.sbipdemo.crypto;

import io.lungchen.sbipdemo.request.RequestBody;
import io.lungchen.sbipdemo.util.Connection;
import org.hyperledger.fabric.gateway.Contract;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class CryptoService {
    private static CryptoService cryptoService;

    private final Connection connection;

    private CryptoService() {
        this.connection = Connection.getConnection("sbipdemochannel", "sbipsc");
    }

    public static CryptoService getCryptoService() {
        if (cryptoService == null) {
            cryptoService = new CryptoService();
        }

        return cryptoService;
    }

    public boolean verify(RequestBody requestBody) {

        try {
            String key = requestBody.getKey();
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(key));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initVerify(keyFactory.generatePublic(keySpec));
            signature.update(requestBody.toString().getBytes());
            signature.verify(Base64.getDecoder().decode(requestBody.getSignature()));

        } catch (Exception e) {
            return false;
        }

        return true;
    }


    public String getPublicKey(String accountId) {

        String publicKey = "";

        try {

            publicKey = new String(connection.getContract().evaluateTransaction("peekPublicKey", accountId));

        } catch (Exception e) {
            e.getMessage();
        }

        return publicKey;
    }

}
