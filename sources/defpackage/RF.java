package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class RF extends DH {
    public RF() {
        super(1);
    }

    @Override // defpackage.DH
    public T8 h(T8 t8) {
        ArrayList arrayList = new ArrayList();
        int iCeil = (int) Math.ceil(((double) ((c() * b()) * a())) / 8.0d);
        byte[] bArr = null;
        while (t8.F() >= iCeil + 1) {
            int iH = t8.h() & UnsignedBytes.MAX_VALUE;
            byte[] bArr2 = new byte[iCeil];
            t8.j(bArr2);
            if (iH == 1) {
                k(bArr2);
            } else if (iH == 2) {
                l(bArr2, bArr);
            } else if (iH == 3) {
                i(bArr2, bArr);
            } else if (iH == 4) {
                j(bArr2, bArr);
            }
            arrayList.add(bArr2);
            bArr = bArr2;
        }
        T8 t8B = T8.b(arrayList.size() * iCeil);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            t8B.z((byte[]) it.next());
        }
        t8B.f();
        return t8B;
    }

    public void i(byte[] bArr, byte[] bArr2) {
        int iCeil = (int) Math.ceil(((double) (a() * b())) / 8.0d);
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i - iCeil;
            bArr[i] = (byte) (bArr[i] + ((byte) Math.floor(((i2 >= 0 ? bArr[i2] & UnsignedBytes.MAX_VALUE : 0) + (bArr2 != null ? bArr2[i] & UnsignedBytes.MAX_VALUE : 0)) / 2)));
        }
    }

    public void j(byte[] bArr, byte[] bArr2) {
        int iCeil = (int) Math.ceil(((double) (a() * b())) / 8.0d);
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i - iCeil;
            bArr[i] = (byte) (bArr[i] + ((byte) m(i2 >= 0 ? bArr[i2] & UnsignedBytes.MAX_VALUE : 0, bArr2 != null ? bArr2[i] & UnsignedBytes.MAX_VALUE : 0, (i2 <= 0 || bArr2 == null) ? 0 : bArr2[i2] & UnsignedBytes.MAX_VALUE)));
        }
    }

    public void k(byte[] bArr) {
        int iCeil = (int) Math.ceil(((double) (a() * b())) / 8.0d);
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i - iCeil;
            if (i2 >= 0) {
                bArr[i] = (byte) (bArr[i] + bArr[i2]);
            }
        }
    }

    public void l(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null) {
            return;
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] + bArr2[i]);
        }
    }

    public int m(int i, int i2, int i3) {
        int i4 = (i + i2) - i3;
        int iAbs = Math.abs(i4 - i);
        int iAbs2 = Math.abs(i4 - i2);
        int iAbs3 = Math.abs(i4 - i3);
        if (iAbs > iAbs2 || iAbs > iAbs3) {
            return iAbs2 <= iAbs3 ? i2 : i3;
        }
        return i;
    }
}
