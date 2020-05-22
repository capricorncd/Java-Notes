package md.test;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

/**
 * keyed-Hash Message Authentication Code
 * @author Capricorncd
 * https://github.com/capricorncd
 */
public class TestMAC {

	private static final String HMAC_MD2 = "HmacMD2";
	private static final String HMAC_MD4 = "HmacMD4";
	private static final String HMAC_MD5 = "HmacMD5";
	
	private static final String HMAC_SHA = "HmacSHA1";
	private static final String HMAC_SHA_224 = "HmacSHA224";
	private static final String HMAC_SHA_256 = "HmacSHA256";
	private static final String HMAC_SHA_384 = "HmacSHA384";
	private static final String HMAC_SHA_512 = "HmacSHA512";

	public static void main(String[] args) {
		String src = "keyed-Hash Message Authentication Code";
		// secret key, length = 10.
		String secretKey = "aaaaaaaaaa";
		byte[] secretKeyBytes = org.bouncycastle.util.encoders.Hex.decode(secretKey);

		jdkHmac(src, HMAC_MD2, secretKeyBytes);
		jdkHmac(src, HMAC_MD4, secretKeyBytes);
		jdkHmac(src, HMAC_MD5, secretKeyBytes);

		println();
		bcHmac(src, HMAC_MD2, new MD2Digest(), secretKeyBytes);
		bcHmac(src, HMAC_MD4, new MD4Digest(), secretKeyBytes);
		bcHmac(src, HMAC_MD5, new MD5Digest(), secretKeyBytes);
		
		println();
		jdkHmac(src, HMAC_SHA, secretKeyBytes);
		jdkHmac(src, HMAC_SHA_224, secretKeyBytes);
		jdkHmac(src, HMAC_SHA_256, secretKeyBytes);
		jdkHmac(src, HMAC_SHA_384, secretKeyBytes);
		jdkHmac(src, HMAC_SHA_512, secretKeyBytes);
		
		println();
		bcHmac(src, HMAC_SHA, new SHA1Digest(), secretKeyBytes);
		bcHmac(src, HMAC_SHA_224, new SHA224Digest(), secretKeyBytes);
		bcHmac(src, HMAC_SHA_256, new SHA256Digest(), secretKeyBytes);
		bcHmac(src, HMAC_SHA_384, new SHA384Digest(), secretKeyBytes);
		bcHmac(src, HMAC_SHA_512, new SHA512Digest(), secretKeyBytes);
	}

	/**
	 * JDK HMAC
	 * @param src source
	 * @param algorithm
	 * @param secretKeyBytes secret key bytes
	 */
	public static void jdkHmac(String src, String algorithm, byte[] secretKeyBytes) {
		String result = null;
		try {
			// restore secret key
			SecretKey restoreSecretKey = new SecretKeySpec(secretKeyBytes, algorithm);
			// instance MAC
			Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());
			// initial MAC
			mac.init(restoreSecretKey);
			// run
			byte[] resultBytes = mac.doFinal(src.getBytes());
			result = Hex.encodeHexString(resultBytes);
		} catch (Exception e) {
			// e.printStackTrace();
			result = e.getMessage();
		}
		println(algorithm + ":", result, "by JDK");
	}

	/**
	 * JDK HMAC
	 * Automatically generate a secret key
	 * @param src
	 * @param algorithm
	 */
	public static void jdkHmac(String src, String algorithm) {
		try {
			// Automatically generate a secret key
			// initial KeyGenerator
			KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
			// create secret key
			SecretKey secretKey = keyGenerator.generateKey();
			// get secret key
			byte[] secretKeyBytes = secretKey.getEncoded();

			jdkHmac(src, algorithm, secretKeyBytes);
		} catch (Exception e) {
			// e.printStackTrace();
			println(algorithm + ":", e.getMessage(), "by JDK");
		}
		
	}

	/**
	 * bouncy castle HMAC
	 * @param <T> Digest
	 * @param src source
	 * @param algorithm
	 * @param digest Digest
	 * @param secretKeyBytes secret key bytes
	 */
	public static <T extends Digest> void bcHmac(String src, String algorithm, T digest, byte[] secretKeyBytes) {
		HMac hmac = new HMac(digest);
		// byte[] secretKeyBytes = org.bouncycastle.util.encoders.Hex.decode("aaaaaaaaaa");
		hmac.init(new KeyParameter(secretKeyBytes));

		byte[] srcBytes = src.getBytes();
		hmac.update(srcBytes, 0, srcBytes.length);

		byte[] resultBytes = new byte[hmac.getMacSize()];
		hmac.doFinal(resultBytes, 0);

		String result = org.bouncycastle.util.encoders.Hex.toHexString(resultBytes);
		println(algorithm + ":", result, "by Bouncy Castle.");
	}

	/**
	 * System.out.println
	 * 
	 * @param args
	 */
	public static void println(Object... args) {
		for (Object o : args) {
			System.out.print(o + " ");
		}
		System.out.print("\n");
	}
}
