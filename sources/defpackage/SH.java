package defpackage;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes3.dex */
public class SH {
    public static Bitmap a;

    public class b {
        public C3706qF a;
        public CF b;

        public b() {
        }

        public void c(File file) {
            FileChannel channel = new RandomAccessFile(file, "r").getChannel();
            this.a = new C3706qF(T8.a(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size())));
        }

        public final void d(String str) throws C2346hF {
            try {
                File file = new File(str);
                if (file.length() == 0) {
                    Log.i("No File", "File length is 0");
                } else {
                    c(file);
                    Log.i("ParsePDF", "parse pdf called f =" + file.toString());
                }
            } catch (C2346hF e) {
                throw e;
            } catch (Throwable th) {
                th.printStackTrace();
                Log.i("Error", "Cant Read File");
            }
        }

        public final Bitmap e(int i, int i2) {
            try {
                System.gc();
                this.b = this.a.h(i, true);
                Log.i("File Page", "mPdfPage creates width = " + this.b.B());
                return this.b.x((int) (((double) this.b.B()) * 1.25d), (int) (((double) this.b.w()) * 1.25d), null, true, true);
            } catch (Throwable th) {
                Log.e("Error", th.getMessage(), th);
                return null;
            }
        }
    }

    public SH(String str) {
        b bVar = new b();
        try {
            bVar.d(str);
            if (bVar.e(1, 1) != null) {
                a = bVar.e(1, 1);
            }
        } catch (C2346hF e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Bitmap a() {
        return a;
    }
}
