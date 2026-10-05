package defpackage;

import com.google.zxing.common.BitArray;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Z7 {
    public static BitArray a(List list) {
        int size = list.size() << 1;
        int i = size - 1;
        if (((C1822bm) list.get(list.size() - 1)).c() == null) {
            i = size - 2;
        }
        BitArray bitArray = new BitArray(i * 12);
        int i2 = 0;
        int value = ((C1822bm) list.get(0)).c().getValue();
        for (int i3 = 11; i3 >= 0; i3--) {
            if (((1 << i3) & value) != 0) {
                bitArray.set(i2);
            }
            i2++;
        }
        for (int i4 = 1; i4 < list.size(); i4++) {
            C1822bm c1822bm = (C1822bm) list.get(i4);
            int value2 = c1822bm.b().getValue();
            for (int i5 = 11; i5 >= 0; i5--) {
                if (((1 << i5) & value2) != 0) {
                    bitArray.set(i2);
                }
                i2++;
            }
            if (c1822bm.c() != null) {
                int value3 = c1822bm.c().getValue();
                for (int i6 = 11; i6 >= 0; i6--) {
                    if (((1 << i6) & value3) != 0) {
                        bitArray.set(i2);
                    }
                    i2++;
                }
            }
        }
        return bitArray;
    }
}
