package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;

/* JADX INFO: renamed from: vM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4117vM {
    public T8 a;

    public C4117vM(T8 t8) {
        this.a = t8;
    }

    public static T8 b(T8 t8, BF bf) {
        return new C4117vM(t8).a();
    }

    public final T8 a() {
        this.a.H();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[128];
        while (true) {
            byte bH = this.a.h();
            if (bH == -1 || bH == 128) {
                break;
            }
            if (bH <= 127) {
                int i = bH + 1;
                while (i > 0) {
                    this.a.k(bArr, 0, i);
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            } else {
                byte bH2 = this.a.h();
                for (int i2 = 0; i2 < 257 - (bH & UnsignedBytes.MAX_VALUE); i2++) {
                    byteArrayOutputStream.write(bH2);
                }
            }
        }
        return T8.K(byteArrayOutputStream.toByteArray());
    }
}
