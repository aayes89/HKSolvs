import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class ECDSAGenerator {

    public static void main(String[] args) throws Exception {
        KeyPair keyPair = generateECDSAKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        String ecdsaPublicKey = encodeECDSAPublicKey(publicKey);
        String ecdsaPrivateKey = encodeECDSAPrivateKey(privateKey);

        System.out.println("Clave ECDSA Pública: " + ecdsaPublicKey);
        System.out.println("Clave ECDSA Privada: " + ecdsaPrivateKey);

        // Ejemplo de firma y verificación
        String mensaje = "Hola, mundo!";
        byte[] firma = signECDSA(privateKey, mensaje);
        boolean verificado = verifyECDSA(publicKey, mensaje, firma);

        System.out.println("Mensaje verificado: " + verificado);
    }

    private static KeyPair generateECDSAKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(256); // Tamaño de clave, puede ajustarse según tus necesidades
        return keyPairGenerator.generateKeyPair();
    }

    private static String encodeECDSAPublicKey(PublicKey publicKey) {
        byte[] keyBytes = publicKey.getEncoded();
        return "ecdsa-sha2-nistp256 " + Base64.getEncoder().encodeToString(keyBytes);
    }

    private static String encodeECDSAPrivateKey(PrivateKey privateKey) {
        byte[] keyBytes = privateKey.getEncoded();
        return Base64.getEncoder().encodeToString(keyBytes);
    }

    private static byte[] signECDSA(PrivateKey privateKey, String data) throws Exception {
        Signature signature = Signature.getInstance("SHA256withECDSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes());
        return signature.sign();
    }

    private static boolean verifyECDSA(PublicKey publicKey, String data, byte[] signature) throws Exception {
        Signature verifier = Signature.getInstance("SHA256withECDSA");
        verifier.initVerify(publicKey);
        verifier.update(data.getBytes());
        return verifier.verify(signature);
    }
}
