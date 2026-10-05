package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.File;

/* JADX INFO: renamed from: o10, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3521o10 {
    public static byte[] a() {
        byte[] bytes = "AUTOSET\r\n".getBytes();
        Log.d("label=", "print=AUTOSET\r\n");
        return bytes;
    }

    public static byte[] b(int i, int i2, int i3, int i4, int i5) {
        String str = "BITMAP " + (i + "," + i2) + "," + ("" + i3) + "," + ("" + i4) + "," + ("" + i5) + ",";
        Log.d("label=", "bitmap=" + str);
        return str.getBytes();
    }

    public static byte[] c() {
        byte[] bytes = "CLS\r\n".getBytes();
        Log.d("label=", "print=CLS\r\n");
        return bytes;
    }

    public static Bitmap d(String str) {
        new File(Z00.L, str).length();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeFile(Z00.L + "/" + str, options);
    }

    public static byte[] e(int i, int i2) {
        String str = "PRINT " + i + ", " + i2 + StringUtilities.CRLF;
        Log.d("label=", "print=" + str);
        return str.getBytes();
    }

    public static byte[] f(int i, int i2, int i3, int i4, int i5, int i6, int i7, String str) {
        String str2;
        String str3 = "SIZE " + i + " mm, " + i2 + " mm";
        String str4 = "SPEED " + i3;
        String str5 = "DENSITY " + i4;
        if (i5 == 0) {
            str2 = "GAP " + i6 + " mm, " + i7 + " mm";
        } else {
            str2 = "";
        }
        String str6 = str3 + StringUtilities.CRLF + str4 + StringUtilities.CRLF + str5 + StringUtilities.CRLF + str2 + StringUtilities.CRLF;
        Log.d("label=", "setup=" + str6);
        return str6.getBytes();
    }
}
