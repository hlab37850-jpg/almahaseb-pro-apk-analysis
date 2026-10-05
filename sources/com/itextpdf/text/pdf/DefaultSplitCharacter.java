package com.itextpdf.text.pdf;

import com.itextpdf.text.SplitCharacter;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultSplitCharacter implements SplitCharacter {
    public static final SplitCharacter DEFAULT = new DefaultSplitCharacter();
    protected char[] characters;

    public DefaultSplitCharacter() {
    }

    public char getCurrentCharacter(int i, char[] cArr, PdfChunk[] pdfChunkArr) {
        return pdfChunkArr == null ? cArr[i] : (char) pdfChunkArr[Math.min(i, pdfChunkArr.length - 1)].getUnicodeEquivalent(cArr[i]);
    }

    @Override // com.itextpdf.text.SplitCharacter
    public boolean isSplitCharacter(int i, int i2, int i3, char[] cArr, PdfChunk[] pdfChunkArr) {
        char currentCharacter = getCurrentCharacter(i2, cArr, pdfChunkArr);
        if (this.characters == null) {
            if (currentCharacter <= ' ' || currentCharacter == '-' || currentCharacter == 8208) {
                return true;
            }
            if (currentCharacter < 8194) {
                return false;
            }
            if (currentCharacter >= 8194 && currentCharacter <= 8203) {
                return true;
            }
            if (currentCharacter >= 11904 && currentCharacter < 55200) {
                return true;
            }
            if (currentCharacter >= 63744 && currentCharacter < 64256) {
                return true;
            }
            if (currentCharacter < 65072 || currentCharacter >= 65104) {
                return currentCharacter >= 65377 && currentCharacter < 65440;
            }
            return true;
        }
        int i4 = 0;
        while (true) {
            char[] cArr2 = this.characters;
            if (i4 >= cArr2.length) {
                return false;
            }
            if (currentCharacter == cArr2[i4]) {
                return true;
            }
            i4++;
        }
    }

    public DefaultSplitCharacter(char c) {
        this(new char[]{c});
    }

    public DefaultSplitCharacter(char[] cArr) {
        this.characters = cArr;
    }
}
