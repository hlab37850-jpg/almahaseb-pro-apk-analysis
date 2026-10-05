package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: hh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2381hh {
    public static T8 a(BF bf, T8 t8, BF bf2) throws EF {
        t8.H();
        int iF = t8.F();
        byte[] bArr = new byte[iF];
        t8.j(bArr);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, iF);
        if (bitmapDecodeByteArray == null) {
            throw new EF("could not decode image of compressed size " + iF);
        }
        Bitmap.Config config = bitmapDecodeByteArray.getConfig();
        Log.e("ANDPDF.dctdecode", "decoded image type" + config);
        int width = bitmapDecodeByteArray.getWidth() * 4 * bitmapDecodeByteArray.getHeight();
        if (config == Bitmap.Config.RGB_565) {
            width = bitmapDecodeByteArray.getHeight() * bitmapDecodeByteArray.getWidth() * 2;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(width);
        bitmapDecodeByteArray.copyPixelsToBuffer(byteBufferAllocate);
        T8 t8G = T8.g(byteBufferAllocate);
        t8G.H();
        return t8G;
    }
}
