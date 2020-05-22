package md.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * Message Digest
 * @author Capricorncd
 * https://github.com/capricorncd
 *
 */
public class TestMessageDigest {
	
	private static final String MD2 = "MD2";
	private static final String MD4 = "MD4";
	private static final String MD5 = "MD5";

	public static void main(String[] args) {
		String src = "I love the world.";
		
		jdkMD(src, MD2);
		jdkMD(src, MD4);
		jdkMD(src, MD5);
		
		bcMD(src, MD2, new MD2Digest());
		bcMD(src, MD4, new MD4Digest());
		bcMD(src, MD5, new MD5Digest());
		
		bouncyCastleMD(src, MD2);
		bouncyCastleMD(src, MD4);
		bouncyCastleMD(src, MD5);
		
		ccMD(src, MD2);
		ccMD(src, MD4);
		ccMD(src, MD5);
	}
	
	/**
	 * JDK MD
	 * @param src source
	 * @param mdType MD2,MD5
	 * @return String result
	 */
	public static String jdkMD(String src, String mdType) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance(mdType);
			byte[] mdBytes = md.digest(src.getBytes());
			// toHex
			result = Hex.encodeHexString(mdBytes);
		} catch (NoSuchAlgorithmException e) {
			// e.printStackTrace();
			result = e.getMessage();
		}
		println(mdType + ":", result, "by JDK");
		return result;
	}
	
	/**
	 * bouncy castle MD
	 * @param src source
	 * @param mdType message digest type
	 * @param digest org.bouncycastle.crypto.Digest
	 * @return String result
	 */
	public static<T extends Digest> String bcMD(String src, String mdType, T digest) {
		byte[] srcBytes = src.getBytes();
		digest.update(srcBytes, 0, srcBytes.length);
		byte[] resBytes = new byte[digest.getDigestSize()];
		digest.doFinal(resBytes, 0);
		String result = org.bouncycastle.util.encoders.Hex.toHexString(resBytes);
		println(mdType + ":", result, "by Bouncycastle");
		return result;
	}
	
	/**
	 * bouncy castle provider MD
	 * @param src source
	 * @param mdType message digest type
	 * @return String result
	 */
	public static String bouncyCastleMD(String src, String mdType) {
		String result = null;
		Security.addProvider(new BouncyCastleProvider());
		try {
			MessageDigest md = MessageDigest.getInstance(mdType);
			byte[] mdBytes = md.digest(src.getBytes());
			result = Hex.encodeHexString(mdBytes);
		} catch (NoSuchAlgorithmException e) {
			// e.printStackTrace();
			result = e.getMessage();
		}
		println(mdType + ":", result, "by BouncyCastleProvider");
		return result;
	}
	
	/**
	 * org.apache.commons.codec.digest.DigestUtils
	 * @param src source
	 * @param mdType message digest type
	 * @return String result
	 */
	public static String ccMD(String src, String mdType) {
		String result = null;
		switch(mdType) {
		case MD2:
			result = DigestUtils.md2Hex(src.getBytes());
			break;
		case MD4:
			result = "The MD4 method is not implemented.";
			break;
		case MD5:
			result = DigestUtils.md5Hex(src.getBytes());
			break;
		}
		println(mdType + ":", result, "by org.apache.commons.codec.digest.DigestUtils");
		return result;
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
