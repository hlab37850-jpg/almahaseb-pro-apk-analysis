package defpackage;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.ParcelUuid;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.pdf.ByteBuffer;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import org.apache.poi.hssf.record.PaletteRecord;

/* JADX INFO: loaded from: classes3.dex */
public class XH {
    public static int d = 384;
    public static int e = 384;
    public static int f = 48;
    public static final byte[] g = {10};
    public static final byte[] h = {Ascii.ESC, 97, 1};
    public static final byte[] i = {Ascii.ESC, 97, 2};
    public static final byte[] j = {Ascii.ESC, 97, 0};
    public static final byte[] k = {29, 86, 66, 0};
    public static final byte[] l = {Ascii.ESC, 33, 1};
    public static final byte[] m = {Ascii.ESC, 33, 0};
    public static final byte[] n = {Ascii.ESC, 33, 8};
    public static final byte[] o = {Ascii.ESC, 33, 32};
    public static final byte[] p = {Ascii.ESC, 33, 16};
    public static final byte[] q = {Ascii.ESC, 33, UnsignedBytes.MAX_POWER_OF_TWO};
    public static final byte[] r = {Ascii.ESC, 33, 64};
    public static final byte[] s = {Ascii.ESC, 33, 40};
    public static final byte[] t = {Ascii.ESC, 33, Ascii.CAN};
    public static final byte[] u = {Ascii.ESC, 33, ByteBuffer.ZERO};
    public static final byte[] v = {Ascii.ESC, 33, PaletteRecord.STANDARD_PALETTE_SIZE};
    public final BluetoothDevice a;
    public BluetoothSocket b = null;
    public OutputStream c = null;

    public class a implements b.a {
        public final /* synthetic */ d a;
        public final /* synthetic */ c b;

        public a(d dVar, c cVar) {
            this.a = dVar;
            this.b = cVar;
        }

        @Override // XH.b.a
        public void a() {
            this.b.a();
        }

        @Override // XH.b.a
        public void b(BluetoothSocket bluetoothSocket) {
            XH.this.b = bluetoothSocket;
            try {
                XH.this.c = bluetoothSocket.getOutputStream();
                this.a.onConnected();
            } catch (IOException unused) {
                this.b.a();
            }
        }
    }

    public static class b extends AsyncTask {
        public final a a;

        public interface a {
            void a();

            void b(BluetoothSocket bluetoothSocket);
        }

        public /* synthetic */ b(a aVar, a aVar2) {
            this(aVar);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BluetoothSocket doInBackground(BluetoothDevice... bluetoothDeviceArr) {
            BluetoothSocket bluetoothSocketCreateRfcommSocketToServiceRecord;
            boolean z = false;
            BluetoothDevice bluetoothDevice = bluetoothDeviceArr[0];
            if (bluetoothDevice == null) {
                return null;
            }
            ParcelUuid[] uuids = bluetoothDevice.getUuids();
            try {
                bluetoothSocketCreateRfcommSocketToServiceRecord = bluetoothDevice.createRfcommSocketToServiceRecord((uuids == null || uuids.length <= 0) ? UUID.randomUUID() : uuids[0].getUuid());
                try {
                    bluetoothSocketCreateRfcommSocketToServiceRecord.connect();
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                } catch (Exception unused) {
                }
            } catch (IOException e2) {
                e = e2;
                bluetoothSocketCreateRfcommSocketToServiceRecord = null;
            } catch (Exception unused2) {
                bluetoothSocketCreateRfcommSocketToServiceRecord = null;
            }
            z = true;
            if (z) {
                return bluetoothSocketCreateRfcommSocketToServiceRecord;
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(BluetoothSocket bluetoothSocket) {
            a aVar = this.a;
            if (aVar != null) {
                if (bluetoothSocket != null) {
                    aVar.b(bluetoothSocket);
                } else {
                    aVar.a();
                }
            }
        }

        public b(a aVar) {
            this.a = aVar;
        }
    }

    public interface c {
        void a();
    }

    public interface d {
        void onConnected();
    }

    public XH(BluetoothDevice bluetoothDevice) {
        this.a = bluetoothDevice;
    }

    public static byte[] d(Bitmap bitmap, int i2, int i3) {
        int i4;
        byte[] bArr = new byte[((bitmap.getHeight() + i3) * f) + 8];
        for (int i5 = 0; i5 < bitmap.getHeight(); i5++) {
            for (int i6 = 0; i6 < bitmap.getWidth() && (i4 = i6 + i2) < e; i6++) {
                int pixel = bitmap.getPixel(i6, i5);
                int iAlpha = Color.alpha(pixel);
                int iRed = Color.red(pixel);
                int iGreen = Color.green(pixel);
                int iBlue = Color.blue(pixel);
                if (iAlpha > 128 && (iRed < 128 || iGreen < 128 || iBlue < 128)) {
                    int i7 = i4 / 8;
                    int i8 = ((i5 + i3) * f) + 8 + i7;
                    bArr[i8] = (byte) ((128 >> (i4 - (i7 * 8))) | bArr[i8]);
                }
            }
        }
        return bArr;
    }

    public boolean c() {
        return h(g);
    }

    public void e(d dVar, c cVar) {
        new b(new a(dVar, cVar), null).execute(this.a);
    }

    public boolean f(int i2, Bitmap bitmap, int i3) {
        int width;
        if (i3 == -1) {
            i3 = d;
        }
        Bitmap bitmapI = i(bitmap, i3);
        if (bitmapI == null) {
            return false;
        }
        if (i2 == -1) {
            width = (d - bitmapI.getWidth()) / 2;
        } else {
            width = i2 == -2 ? d - bitmapI.getWidth() : 0;
        }
        byte[] bArrD = d(bitmapI, width, 5);
        int length = (bArrD.length - 8) / f;
        System.arraycopy(new byte[]{29, 118, ByteBuffer.ZERO, 0, ByteBuffer.ZERO, 0, (byte) (length & 255), (byte) ((length >> 8) & 255)}, 0, bArrD, 0, 8);
        return h(bArrD);
    }

    public boolean g(Bitmap bitmap, int i2) {
        return f(-1, bitmap, i2);
    }

    public final boolean h(byte[] bArr) {
        try {
            this.c.write(bArr);
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:5:0x000a A[Catch: NullPointerException -> 0x002b, TryCatch #0 {NullPointerException -> 0x002b, blocks: (B:3:0x0002, B:7:0x0010, B:11:0x0016, B:5:0x000a), top: B:15:0x0002 }] */
    public final Bitmap i(Bitmap bitmap, int i2) {
        int width;
        if (i2 != 0) {
            try {
                int width2 = bitmap.getWidth();
                width = d;
                if (width2 <= width) {
                    width = bitmap.getWidth();
                }
            } catch (NullPointerException unused) {
                Log.e("PRINTAMA", "Maybe resource is vector or mipmap?");
                return null;
            }
        } else {
            width = bitmap.getWidth();
        }
        if (i2 <= 0 || i2 > d) {
            i2 = width;
        }
        return Bitmap.createScaledBitmap(bitmap, i2, (int) (bitmap.getHeight() * (i2 / bitmap.getWidth())), true);
    }

    public void j() {
        h(m);
    }
}
