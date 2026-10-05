package com.zebra.sdk.util.fileConversion.internal;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class AsciiDecoderStream extends InputStream {
    private int[] previousRow;
    private int previousRowIndex;
    private InputStream sourceStream;
    private int rleRepeatCount = 0;
    private int rleRepeatChar = -1;
    private int nibbleCounter = 0;

    public AsciiDecoderStream(InputStream inputStream, int i) {
        this.previousRow = null;
        this.previousRowIndex = -1;
        this.sourceStream = inputStream;
        int[] iArr = i < 0 ? new int[2] : new int[i * 2];
        this.previousRow = iArr;
        this.previousRowIndex = iArr.length;
    }

    private void fillRemainderOfRow(int i, char c) {
        while (true) {
            int[] iArr = this.previousRow;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = c;
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0072 A[EDGE_INSN: B:38:0x0072->B:36:0x0072 BREAK  A[LOOP:0: B:9:0x001f->B:40:?], SYNTHETIC] */
    private int getNextChar() throws IOException {
        int previousRowNibbleAt;
        int i;
        int i2;
        int i3 = this.previousRowIndex;
        int[] iArr = this.previousRow;
        if (i3 < iArr.length) {
            return getPreviousRowNibbleAt(i3);
        }
        int i4 = this.rleRepeatCount;
        if (i4 > 1) {
            this.rleRepeatCount = i4 - 1;
            return this.rleRepeatChar;
        }
        this.rleRepeatCount = 0;
        int length = this.nibbleCounter % iArr.length;
        do {
            previousRowNibbleAt = this.sourceStream.read();
            if (previousRowNibbleAt != 44) {
                if (previousRowNibbleAt == 33) {
                    fillRemainderOfRow(length, 'F');
                } else if (previousRowNibbleAt == 58) {
                    previousRowNibbleAt = getPreviousRowNibbleAt(0);
                } else {
                    if (previousRowNibbleAt > 70 && previousRowNibbleAt < 90) {
                        i = this.rleRepeatCount;
                        i2 = previousRowNibbleAt - 70;
                    } else if (previousRowNibbleAt > 102 && previousRowNibbleAt < 123) {
                        i = this.rleRepeatCount;
                        i2 = (previousRowNibbleAt - 102) * 20;
                    } else if (this.rleRepeatCount > 0) {
                        this.rleRepeatChar = previousRowNibbleAt;
                    }
                    this.rleRepeatCount = i + i2;
                }
                if (previousRowNibbleAt != -1) {
                    break;
                }
            } else {
                fillRemainderOfRow(length, '0');
            }
            previousRowNibbleAt = getPreviousRowNibbleAt(length);
            if (previousRowNibbleAt != -1) {
                break;
                break;
            }
        } while (!isAsciiHex(previousRowNibbleAt));
        return previousRowNibbleAt;
    }

    private int getPreviousRowNibbleAt(int i) {
        int[] iArr = this.previousRow;
        this.previousRowIndex = i + 1;
        return iArr[i];
    }

    private static int hexToInt(int i) {
        if (97 <= i && i <= 102) {
            return i - 87;
        }
        if (65 <= i && i <= 70) {
            return i - 55;
        }
        if (48 > i || i > 57) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        return i - 48;
    }

    private boolean isAsciiHex(int i) {
        try {
            hexToInt(i);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    private void saveCurrentNibble(int i) {
        int[] iArr = this.previousRow;
        int i2 = this.nibbleCounter;
        this.nibbleCounter = i2 + 1;
        iArr[i2 % iArr.length] = i;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int nextChar = getNextChar();
        saveCurrentNibble(nextChar);
        int nextChar2 = getNextChar();
        saveCurrentNibble(nextChar2);
        if (nextChar == -1 || nextChar2 == -1) {
            return -1;
        }
        return (char) ((hexToInt(nextChar) << 4) | hexToInt(nextChar2));
    }
}
