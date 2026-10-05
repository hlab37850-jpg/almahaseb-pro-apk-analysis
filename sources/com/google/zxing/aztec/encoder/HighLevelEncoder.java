package com.google.zxing.aztec.encoder;

import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.common.BitArray;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public final class HighLevelEncoder {
    private static final int[][] CHAR_MAP;
    static final int MODE_DIGIT = 2;
    static final int MODE_LOWER = 1;
    static final int MODE_MIXED = 3;
    static final int MODE_PUNCT = 4;
    static final int MODE_UPPER = 0;
    static final int[][] SHIFT_TABLE;
    private final byte[] text;
    static final String[] MODE_NAMES = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int[][] LATCH_TABLE = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.google.zxing.aztec.encoder.a aVar, com.google.zxing.aztec.encoder.a aVar2) {
            return aVar.e() - aVar2.e();
        }
    }

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 5, 256);
        CHAR_MAP = iArr;
        iArr[0][32] = 1;
        for (int i = 65; i <= 90; i++) {
            CHAR_MAP[0][i] = i - 63;
        }
        CHAR_MAP[1][32] = 1;
        for (int i2 = 97; i2 <= 122; i2++) {
            CHAR_MAP[1][i2] = i2 - 95;
        }
        CHAR_MAP[2][32] = 1;
        for (int i3 = 48; i3 <= 57; i3++) {
            CHAR_MAP[2][i3] = i3 - 46;
        }
        int[] iArr2 = CHAR_MAP[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, ShapeTypes.VERTICAL_SCROLL};
        int i4 = 0;
        for (int i5 = 28; i4 < i5; i5 = 28) {
            CHAR_MAP[3][iArr3[i4]] = i4;
            i4++;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i6 = 0; i6 < 31; i6++) {
            int i7 = iArr4[i6];
            if (i7 > 0) {
                CHAR_MAP[4][i7] = i6;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, 6);
        SHIFT_TABLE = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = SHIFT_TABLE;
        iArr7[0][4] = 0;
        int[] iArr8 = iArr7[1];
        iArr8[4] = 0;
        iArr8[0] = 28;
        iArr7[3][4] = 0;
        int[] iArr9 = iArr7[2];
        iArr9[4] = 0;
        iArr9[0] = 15;
    }

    public HighLevelEncoder(byte[] bArr) {
        this.text = bArr;
    }

    private static Collection<com.google.zxing.aztec.encoder.a> simplifyStates(Iterable<com.google.zxing.aztec.encoder.a> iterable) {
        LinkedList linkedList = new LinkedList();
        for (com.google.zxing.aztec.encoder.a aVar : iterable) {
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedList.add(aVar);
                    break;
                }
                com.google.zxing.aztec.encoder.a aVar2 = (com.google.zxing.aztec.encoder.a) it.next();
                if (aVar2.g(aVar)) {
                    break;
                }
                if (aVar.g(aVar2)) {
                    it.remove();
                }
            }
        }
        return linkedList;
    }

    private void updateStateForChar(com.google.zxing.aztec.encoder.a aVar, int i, Collection<com.google.zxing.aztec.encoder.a> collection) {
        char c = (char) (this.text[i] & UnsignedBytes.MAX_VALUE);
        boolean z = CHAR_MAP[aVar.f()][c] > 0;
        com.google.zxing.aztec.encoder.a aVarC = null;
        for (int i2 = 0; i2 <= 4; i2++) {
            int i3 = CHAR_MAP[i2][c];
            if (i3 > 0) {
                if (aVarC == null) {
                    aVarC = aVar.c(i);
                }
                if (!z || i2 == aVar.f() || i2 == 2) {
                    collection.add(aVarC.h(i2, i3));
                }
                if (!z && SHIFT_TABLE[aVar.f()][i2] >= 0) {
                    collection.add(aVarC.i(i2, i3));
                }
            }
        }
        if (aVar.d() > 0 || CHAR_MAP[aVar.f()][c] == 0) {
            collection.add(aVar.a(i));
        }
    }

    private static void updateStateForPair(com.google.zxing.aztec.encoder.a aVar, int i, int i2, Collection<com.google.zxing.aztec.encoder.a> collection) {
        com.google.zxing.aztec.encoder.a aVarC = aVar.c(i);
        collection.add(aVarC.h(4, i2));
        if (aVar.f() != 4) {
            collection.add(aVarC.i(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(aVarC.h(2, 16 - i2).h(2, 1));
        }
        if (aVar.d() > 0) {
            collection.add(aVar.a(i).a(i + 1));
        }
    }

    private Collection<com.google.zxing.aztec.encoder.a> updateStateListForChar(Iterable<com.google.zxing.aztec.encoder.a> iterable, int i) {
        LinkedList linkedList = new LinkedList();
        Iterator<com.google.zxing.aztec.encoder.a> it = iterable.iterator();
        while (it.hasNext()) {
            updateStateForChar(it.next(), i, linkedList);
        }
        return simplifyStates(linkedList);
    }

    private static Collection<com.google.zxing.aztec.encoder.a> updateStateListForPair(Iterable<com.google.zxing.aztec.encoder.a> iterable, int i, int i2) {
        LinkedList linkedList = new LinkedList();
        Iterator<com.google.zxing.aztec.encoder.a> it = iterable.iterator();
        while (it.hasNext()) {
            updateStateForPair(it.next(), i, i2, linkedList);
        }
        return simplifyStates(linkedList);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002a  */
    public BitArray encode() {
        int i;
        Collection<com.google.zxing.aztec.encoder.a> collectionSingletonList = Collections.singletonList(com.google.zxing.aztec.encoder.a.e);
        int i2 = 0;
        while (true) {
            byte[] bArr = this.text;
            if (i2 >= bArr.length) {
                return ((com.google.zxing.aztec.encoder.a) Collections.min(collectionSingletonList, new a())).j(this.text);
            }
            int i3 = i2 + 1;
            byte b = i3 < bArr.length ? bArr[i3] : (byte) 0;
            byte b2 = bArr[i2];
            if (b2 != 13) {
                if (b2 != 44) {
                    if (b2 != 46) {
                        if (b2 == 58 && b == 32) {
                            i = 5;
                        } else {
                            i = 0;
                        }
                    } else if (b == 32) {
                        i = 3;
                    } else {
                        i = 0;
                    }
                } else if (b == 32) {
                    i = 4;
                } else {
                    i = 0;
                }
            } else if (b == 10) {
                i = 2;
            } else {
                i = 0;
            }
            if (i > 0) {
                collectionSingletonList = updateStateListForPair(collectionSingletonList, i2, i);
                i2 = i3;
            } else {
                collectionSingletonList = updateStateListForChar(collectionSingletonList, i2);
            }
            i2++;
        }
    }
}
