package com.google.zxing.pdf417.encoder;

import defpackage.Z6;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public final class BarcodeMatrix {
    private int currentRow;
    private final int height;
    private final Z6[] matrix;
    private final int width;

    public BarcodeMatrix(int i, int i2) {
        Z6[] z6Arr = new Z6[i];
        this.matrix = z6Arr;
        int length = z6Arr.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.matrix[i3] = new Z6(((i2 + 4) * 17) + 1);
        }
        this.width = i2 * 17;
        this.height = i;
        this.currentRow = -1;
    }

    public Z6 getCurrentRow() {
        return this.matrix[this.currentRow];
    }

    public byte[][] getMatrix() {
        return getScaledMatrix(1, 1);
    }

    public byte[][] getScaledMatrix(int i, int i2) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.height * i2, this.width * i);
        int i3 = this.height * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.matrix[i4 / i2].b(i);
        }
        return bArr;
    }

    public void set(int i, int i2, byte b) {
        this.matrix[i2].c(i, b);
    }

    public void startRow() {
        this.currentRow++;
    }
}
