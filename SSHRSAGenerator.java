import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class SSHRSAGenerator {

    public static void main(String[] args) throws Exception {
        KeyPair keyPair = generateSSHKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        String sshRSAPublicKey = encodeSSHRSAPublicKey(publicKey);
        String sshRSAPrivateKey = encodeSSHRSAPrivateKey(privateKey);

        System.out.println("Clave SSH-RSA Pública: " + sshRSAPublicKey);
        System.out.println("Clave SSH-RSA Privada: " + sshRSAPrivateKey);
    }

    private static KeyPair generateSSHKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Tamaño de clave, puedes ajustarlo según tus necesidades
        return keyPairGenerator.generateKeyPair();
    }

    private static String encodeSSHRSAPublicKey(PublicKey publicKey) {
        byte[] keyBytes = publicKey.getEncoded();
        return "ssh-rsa " + Base64.getEncoder().encodeToString(keyBytes);
    }

    private static String encodeSSHRSAPrivateKey(PrivateKey privateKey) {
        byte[] keyBytes = privateKey.getEncoded();
        return Base64.getEncoder().encodeToString(keyBytes);
    }
}
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class SSHRSAGenerator {

    public static void main(String[] args) throws Exception {
        KeyPair keyPair = generateSSHKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        String sshRSAPublicKey = encodeSSHRSAPublicKey(publicKey);
        String sshRSAPrivateKey = encodeSSHRSAPrivateKey(privateKey);

        System.out.println("Clave SSH-RSA Pública: " + sshRSAPublicKey);
        System.out.println("Clave SSH-RSA Privada: " + sshRSAPrivateKey);
    }

    private static KeyPair generateSSHKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Tamaño de clave, puedes ajustarlo según tus necesidades
        return keyPairGenerator.generateKeyPair();
    }

    private static String encodeSSHRSAPublicKey(PublicKey publicKey) {
        byte[] keyBytes = publicKey.getEncoded();
        return "ssh-rsa " + Base64.getEncoder().encodeToString(keyBytes);
    }

    private static String encodeSSHRSAPrivateKey(PrivateKey privateKey) {
        byte[] keyBytes = privateKey.getEncoded();
        return Base64.getEncoder().encodeToString(keyBytes);
    }
}
