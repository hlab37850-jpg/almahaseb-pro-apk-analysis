package defpackage;

import android.util.Base64;
import android.util.LruCache;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: renamed from: uI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4032uI {
    public static String a = "c.19242891123456";
    public static String b = "online.891123456";
    public static final LruCache c = new LruCache(64);

    public static String a(String str, String str2) {
        try {
            String[] strArrSplit = str.split(":");
            byte[] bArrDecode = Base64.decode(strArrSplit[0], 0);
            byte[] bArrDecode2 = Base64.decode(strArrSplit[1], 0);
            SecretKey secretKeyD = d(str2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeyD, new IvParameterSpec(bArrDecode));
            return new String(cipher.doFinal(bArrDecode2), XmpWriter.UTF8);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(a.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes(XmpWriter.UTF8)), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(String str, String str2) {
        try {
            SecretKey secretKeyD = d(str2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            cipher.init(1, secretKeyD, new IvParameterSpec(bArr));
            return Base64.encodeToString(bArr, 0) + ":" + Base64.encodeToString(cipher.doFinal(str.getBytes(XmpWriter.UTF8)), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static SecretKey d(String str) {
        LruCache lruCache = c;
        SecretKey secretKey = (SecretKey) lruCache.get(str);
        if (secretKey != null) {
            return secretKey;
        }
        PBEKeySpec pBEKeySpec = new PBEKeySpec(str.toCharArray(), (b + str).getBytes(StandardCharsets.UTF_8), 65536, 256);
        SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(pBEKeySpec).getEncoded(), "AES");
        pBEKeySpec.clearPassword();
        lruCache.put(str, secretKeySpec);
        return secretKeySpec;
    }
}
