package defpackage;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Random;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: h8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2337h8 extends AbstractC2255g8 {
    public final String a;
    public final String b;
    public int[][] c;
    public final int d;
    public final int e;

    public C2337h8(int i, int i2) {
        this.a = "matrixWidth and matrixHeight must be > 0";
        this.b = "values of threshould must be between 0 and 255";
        if (i < 1) {
            throw new IllegalArgumentException("matrixWidth and matrixHeight must be > 0");
        }
        if (i2 < 1) {
            throw new IllegalArgumentException("matrixWidth and matrixHeight must be > 0");
        }
        this.d = i;
        this.e = i2;
        this.c = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i, i2);
    }

    public final int[] a(int i, Random random) {
        HashSet hashSet = new HashSet();
        int[] iArr = new int[i];
        int i2 = 0;
        while (hashSet.size() < i) {
            int iNextInt = random.nextInt(i);
            if (!hashSet.contains(Integer.valueOf(iNextInt))) {
                hashSet.add(Integer.valueOf(iNextInt));
                iArr[i2] = iNextInt;
                i2++;
            }
        }
        return iArr;
    }

    public C2337h8(int i, int i2, int i3, int i4) {
        this(i, i2);
        if (i3 < 0 || i3 > 255) {
            throw new IllegalArgumentException("values of threshould must be between 0 and 255");
        }
        if (i4 < 0 || i4 > 255) {
            throw new IllegalArgumentException("values of threshould must be between 0 and 255");
        }
        if (i4 >= i3) {
            float f = (i4 - i3) / ((i * i2) - 1.0f);
            float f2 = i3;
            Random random = new Random(1L);
            int[] iArrA = a(i, random);
            int[] iArrA2 = a(i2, random);
            for (int i5 = 0; i5 < i; i5++) {
                for (int i6 = 0; i6 < i2; i6++) {
                    this.c[iArrA[i5]][iArrA2[i6]] = Math.round(f2);
                    f2 += f;
                }
            }
            return;
        }
        throw new IllegalArgumentException("thresholdMax must be >= thresholdMin");
    }

    public C2337h8() {
        this(2, 2, 64, ShapeTypes.VERTICAL_SCROLL);
    }
}
