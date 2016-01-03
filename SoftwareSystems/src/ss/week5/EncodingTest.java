package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.Base64;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello Big World";

        System.out.println(Hex.encodeHexString(input.getBytes()));
        byte[] bytes = Hex.decodeHex("4d6f64756c652032".toCharArray());
        System.out.println(new String(bytes));
        
        System.out.println(Base64.encodeBase64String("Hello World".getBytes()));
        byte[] hexbytes = Hex.decodeHex("010203040506".toCharArray());
        System.out.println(Base64.encodeBase64String(hexbytes));
        
        System.out.println(Base64.decodeBase64("U29mdHdhcmUgU31zdGVtcw==".getBytes()));
        
        System.out.println(Base64.encodeBase64String("a".getBytes()));
        System.out.println(Base64.encodeBase64String("aa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaaa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaaaa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaaaaa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaaaaaa".getBytes()));
    }
}
