package fd.main.blockchain.model;

import lombok.SneakyThrows;
import org.apache.logging.log4j.util.Base64Util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class Hashing {

    @SneakyThrows
    public static String SHA256(String data){
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(
                data.getBytes(StandardCharsets.UTF_8));
        return new String(Base64.getEncoder().encode(encodedHash));
    }

}
