package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public final class XE extends V implements RandomAccess {
    public static final a c = new a(null);
    public final W8[] a;
    public final int[] b;

    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public static /* synthetic */ void b(a aVar, long j, H8 h8, int i, List list, int i2, int i3, List list2, int i4, Object obj) {
            aVar.a((i4 & 1) != 0 ? 0L : j, h8, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        public final void a(long j, H8 h8, int i, List list, int i2, int i3, List list2) {
            int i4;
            int i5;
            int i6;
            int i7 = i;
            if (i2 >= i3) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            for (int i8 = i2; i8 < i3; i8++) {
                if (((W8) list.get(i8)).u() < i7) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            W8 w8 = (W8) list.get(i2);
            W8 w9 = (W8) list.get(i3 - 1);
            if (i7 == w8.u()) {
                int iIntValue = ((Number) list2.get(i2)).intValue();
                int i9 = i2 + 1;
                W8 w10 = (W8) list.get(i9);
                i4 = i9;
                i5 = iIntValue;
                w8 = w10;
            } else {
                i4 = i2;
                i5 = -1;
            }
            if (w8.e(i7) == w9.e(i7)) {
                int iMin = Math.min(w8.u(), w9.u());
                int i10 = 0;
                for (int i11 = i7; i11 < iMin && w8.e(i11) == w9.e(i11); i11++) {
                    i10++;
                }
                long jC = j + c(h8) + ((long) 2) + ((long) i10) + 1;
                h8.writeInt(-i10);
                h8.writeInt(i5);
                int i12 = i10 + i7;
                while (i7 < i12) {
                    h8.writeInt(w8.e(i7) & UnsignedBytes.MAX_VALUE);
                    i7++;
                }
                if (i4 + 1 == i3) {
                    if (i12 != ((W8) list.get(i4)).u()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    h8.writeInt(((Number) list2.get(i4)).intValue());
                    return;
                } else {
                    H8 h9 = new H8();
                    h8.writeInt(((int) (c(h9) + jC)) * (-1));
                    a(jC, h9, i12, list, i4, i3, list2);
                    h8.Y(h9);
                    return;
                }
            }
            int i13 = 1;
            for (int i14 = i4 + 1; i14 < i3; i14++) {
                if (((W8) list.get(i14 - 1)).e(i7) != ((W8) list.get(i14)).e(i7)) {
                    i13++;
                }
            }
            long jC2 = j + c(h8) + ((long) 2) + ((long) (i13 * 2));
            h8.writeInt(i13);
            h8.writeInt(i5);
            for (int i15 = i4; i15 < i3; i15++) {
                byte bE = ((W8) list.get(i15)).e(i7);
                if (i15 == i4 || bE != ((W8) list.get(i15 - 1)).e(i7)) {
                    h8.writeInt(bE & UnsignedBytes.MAX_VALUE);
                }
            }
            H8 h10 = new H8();
            while (i4 < i3) {
                byte bE2 = ((W8) list.get(i4)).e(i7);
                int i16 = i4 + 1;
                int i17 = i16;
                while (true) {
                    if (i17 >= i3) {
                        i6 = i3;
                        break;
                    } else {
                        if (bE2 != ((W8) list.get(i17)).e(i7)) {
                            i6 = i17;
                            break;
                        }
                        i17++;
                    }
                }
                if (i16 == i6 && i7 + 1 == ((W8) list.get(i4)).u()) {
                    h8.writeInt(((Number) list2.get(i4)).intValue());
                } else {
                    h8.writeInt(((int) (jC2 + c(h10))) * (-1));
                    a(jC2, h10, i7 + 1, list, i4, i6, list2);
                }
                h10 = h10;
                i4 = i6;
            }
            h8.Y(h10);
        }

        public final long c(H8 h8) {
            return h8.R() / ((long) 4);
        }

        public final XE d(W8... w8Arr) {
            AbstractC4492zt.h(w8Arr, "byteStrings");
            AbstractC0419Di abstractC0419Di = null;
            int i = 0;
            if (w8Arr.length == 0) {
                return new XE(new W8[0], new int[]{0, -1}, abstractC0419Di);
            }
            List listN0 = R5.n0(w8Arr);
            AbstractC2289gc.A(listN0);
            ArrayList arrayList = new ArrayList(w8Arr.length);
            for (W8 w8 : w8Arr) {
                arrayList.add(-1);
            }
            Integer[] numArr = (Integer[]) arrayList.toArray(new Integer[0]);
            List listS = AbstractC1886cc.s(Arrays.copyOf(numArr, numArr.length));
            int length = w8Arr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                listS.set(AbstractC1886cc.l(listN0, w8Arr[i2], 0, 0, 6, null), Integer.valueOf(i3));
                i2++;
                i3++;
            }
            if (((W8) listN0.get(0)).u() <= 0) {
                throw new IllegalArgumentException("the empty byte string is not a supported option");
            }
            int i4 = 0;
            while (i4 < listN0.size()) {
                W8 w9 = (W8) listN0.get(i4);
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < listN0.size()) {
                    W8 w10 = (W8) listN0.get(i6);
                    if (!w10.v(w9)) {
                        break;
                    }
                    if (w10.u() == w9.u()) {
                        throw new IllegalArgumentException(("duplicate option: " + w10).toString());
                    }
                    if (((Number) listS.get(i6)).intValue() > ((Number) listS.get(i4)).intValue()) {
                        listN0.remove(i6);
                        listS.remove(i6);
                    } else {
                        i6++;
                    }
                }
                i4 = i5;
            }
            H8 h8 = new H8();
            b(this, 0L, h8, 0, listN0, 0, 0, listS, 53, null);
            int[] iArr = new int[(int) c(h8)];
            while (!h8.h()) {
                iArr[i] = h8.readInt();
                i++;
            }
            Object[] objArrCopyOf = Arrays.copyOf(w8Arr, w8Arr.length);
            AbstractC4492zt.g(objArrCopyOf, "copyOf(this, size)");
            return new XE((W8[]) objArrCopyOf, iArr, abstractC0419Di);
        }

        public a() {
        }
    }

    public /* synthetic */ XE(W8[] w8Arr, int[] iArr, AbstractC0419Di abstractC0419Di) {
        this(w8Arr, iArr);
    }

    public /* bridge */ boolean a(W8 w8) {
        return super.contains(w8);
    }

    @Override // defpackage.V, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public W8 get(int i) {
        return this.a[i];
    }

    public final W8[] c() {
        return this.a;
    }

    @Override // defpackage.D, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof W8) {
            return a((W8) obj);
        }
        return false;
    }

    public final int[] e() {
        return this.b;
    }

    public /* bridge */ int f(W8 w8) {
        return super.indexOf(w8);
    }

    @Override // defpackage.V, defpackage.D
    public int getSize() {
        return this.a.length;
    }

    public /* bridge */ int h(W8 w8) {
        return super.lastIndexOf(w8);
    }

    @Override // defpackage.V, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof W8) {
            return f((W8) obj);
        }
        return -1;
    }

    @Override // defpackage.V, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof W8) {
            return h((W8) obj);
        }
        return -1;
    }

    public XE(W8[] w8Arr, int[] iArr) {
        this.a = w8Arr;
        this.b = iArr;
    }
}
