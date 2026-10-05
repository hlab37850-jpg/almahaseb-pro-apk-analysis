package defpackage;

import com.zebra.sdk.util.internal.StringUtilities;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: ev, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2151ev {
    public final int a;
    public final int b;
    public final double c;

    public C2151ev(int i, int i2) {
        double d;
        double d2;
        this.a = i;
        i2 = i2 <= 0 ? 203 : i2;
        this.b = i2;
        if (i2 == 300) {
            d = i;
            d2 = 12.0d;
        } else {
            d = i;
            d2 = 8.0d;
        }
        this.c = d / d2;
    }

    public static Integer a(String str) {
        Matcher matcher = Pattern.compile("(\\d{2,6})").matcher(str);
        if (matcher.find()) {
            return Integer.valueOf(Integer.parseInt(matcher.group(1)));
        }
        return null;
    }

    public static C2151ev b(InputStream inputStream, OutputStream outputStream) throws IOException {
        Integer numA;
        Integer numA2;
        d(outputStream, "AUTOSET");
        try {
            Thread.sleep(800L);
        } catch (InterruptedException unused) {
        }
        try {
            d(outputStream, "! U1 getvar \"device.dpi\"");
            numA = a(c(inputStream, 800));
            if (numA != null) {
                try {
                    if (numA.intValue() != 203 && numA.intValue() != 300 && numA.intValue() != 305 && numA.intValue() != 600) {
                        numA = null;
                    }
                } catch (Exception unused2) {
                }
            }
        } catch (Exception unused3) {
        }
        try {
            d(outputStream, "! U1 getvar \"media.label_length\"");
            numA2 = a(c(inputStream, 800));
        } catch (Exception unused4) {
            numA2 = null;
        }
        if (numA2 == null) {
            try {
                d(outputStream, "! U1 getvar \"ezpl.media_length\"");
                numA2 = a(c(inputStream, 800));
            } catch (Exception unused5) {
            }
        }
        if (numA2 == null) {
            try {
                d(outputStream, "~HS");
                Integer numA3 = a(c(inputStream, 1200));
                if (numA3 != null && numA3.intValue() >= 50 && numA3.intValue() <= 4000) {
                    numA2 = numA3;
                }
            } catch (Exception unused6) {
            }
        }
        if (numA2 == null) {
            return null;
        }
        return new C2151ev(numA2.intValue(), numA != null ? numA.intValue() : 203);
    }

    public static String c(InputStream inputStream, int i) throws IOException {
        long jCurrentTimeMillis = System.currentTimeMillis() + ((long) i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[256];
        while (System.currentTimeMillis() < jCurrentTimeMillis) {
            int iAvailable = inputStream.available();
            if (iAvailable > 0) {
                int i2 = inputStream.read(bArr, 0, Math.min(iAvailable, 256));
                if (i2 > 0) {
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
                if (byteArrayOutputStream.toString("US-ASCII").contains(StringUtilities.CRLF)) {
                    break;
                }
            } else {
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException unused) {
                }
            }
        }
        return byteArrayOutputStream.toString("US-ASCII").trim();
    }

    public static void d(OutputStream outputStream, String str) throws IOException {
        outputStream.write((str + StringUtilities.CRLF).getBytes(StandardCharsets.US_ASCII));
        outputStream.flush();
    }

    public String toString() {
        return "height=" + this.a + " dots (" + String.format(Locale.US, "%.2f", Double.valueOf(this.c)) + " mm) @ " + this.b + "dpi";
    }
}
