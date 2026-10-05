package defpackage;

import com.google.android.gms.internal.vision.zzjk;
import com.google.common.base.Ascii;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Ng0 {
    public static void f(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzjk {
        if (o(b2) || (((b << Ascii.FS) + (b2 + 112)) >> 30) != 0 || o(b3) || o(b4)) {
            throw zzjk.zzh();
        }
        int i2 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
        cArr[i] = (char) ((i2 >>> 10) + 55232);
        cArr[i + 1] = (char) ((i2 & IEEEDouble.EXPONENT_BIAS) + 56320);
    }

    public static void g(byte b, byte b2, byte b3, char[] cArr, int i) throws zzjk {
        if (o(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || o(b3)))) {
            throw zzjk.zzh();
        }
        cArr[i] = (char) (((b & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
    }

    public static void h(byte b, byte b2, char[] cArr, int i) throws zzjk {
        if (b < -62 || o(b2)) {
            throw zzjk.zzh();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
    }

    public static void i(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    public static boolean l(byte b) {
        return b >= 0;
    }

    public static boolean m(byte b) {
        return b < -32;
    }

    public static boolean n(byte b) {
        return b < -16;
    }

    public static boolean o(byte b) {
        return b > -65;
    }
}
