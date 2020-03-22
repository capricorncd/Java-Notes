package md.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;

/**
 * Secure Hash Algorithm
 * @author Capricorncd
 * https://github.com/capricorncd
 */
public class TestSHA {
	
	private static final String SHA = "SHA";
	private static final String SHA_224 = "SHA-224";
	private static final String SHA_256 = "SHA-256";
	private static final String SHA_384 = "SHA-384";
	private static final String SHA_512 = "SHA-512";

	public static void main(String[] args) {
		String src = "Test Secure Hash Algorithm.";
		// JDK
		jdkSHA(src, SHA);
		jdkSHA(src, SHA_224);
		jdkSHA(src, SHA_256);
		jdkSHA(src, SHA_384);
		jdkSHA(src, SHA_512);
		// Bouncy Castle
		println("");
		bcSHA(src, SHA, new SHA1Digest());
		bcSHA(src, SHA_224, new SHA224Digest());
		bcSHA(src, SHA_256, new SHA256Digest());
		bcSHA(src, SHA_384, new SHA384Digest());
		bcSHA(src, SHA_512, new SHA512Digest());
		// org.apache.commons.codec.digest.DigestUtils 
		println("");
		ccSHA(src, SHA);
		ccSHA(src, SHA_224);
		ccSHA(src, SHA_256);
		ccSHA(src, SHA_384);
		ccSHA(src, SHA_512);
	}
	
	/**
	 * JDK SHA
	 * @param src source
	 * @param algorithm algorithm type
	 */
	public static void jdkSHA(String src, String algorithm) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			byte[] mdBytes = md.digest(src.getBytes());
			result = Hex.encodeHexString(mdBytes);
		} catch (NoSuchAlgorithmException e) {
			// e.printStackTrace();
			result = e.getMessage();
		}
		println(algorithm + ":", result, "by JDK");
	}
	
	/**
	 * Bouncy Castle SHA
	 * @param <T> Digest
	 * @param src source
	 * @param algorithm
	 * @param digest Digest
	 */
	public static<T extends Digest> void bcSHA(String src, String algorithm, T digest) {
		// input bytes
		byte[] srcBytes = src.getBytes();
		digest.update(srcBytes, 0, srcBytes.length);
		// result bytes
		byte[] resBytes = new byte[digest.getDigestSize()];
		digest.doFinal(resBytes, 0);
		// to Hex
		String result = org.bouncycastle.util.encoders.Hex.toHexString(resBytes);
		println(algorithm + ":", result, "by Bouncy Castle");
	}
	
	/**
	 * org.apache.commons.codec.digest.DigestUtils
	 * @param src
	 * @param algorithm
	 */
	public static void ccSHA(String src, String algorithm) {
		String result = null;
		try {
			switch(algorithm) {
			case SHA:
				result = DigestUtils.sha1Hex(src);
				break;
			case SHA_224:
				result = DigestUtils.sha3_224Hex(src);
				break;
			case SHA_256:
				result = DigestUtils.sha256Hex(src);
				break;
			case SHA_384:
				result = DigestUtils.sha384Hex(src);
				break;
			case SHA_512:
				result = DigestUtils.sha512Hex(src);
				break;
			}
		} catch (Exception e) {
			result = e.getMessage();
		}
		println(algorithm + ":", result, "by org.apache.commons.codec.digest.DigestUtils");
	}

	/**
	 * System.out.println
	 * @param args
	 */
	public static void println(Object ...args) {
		for (Object o : args) {
			System.out.print(o + " ");
		}		
		System.out.print("\n");
	}
}
