package com.itextpdf.text.pdf.fonts.cmaps;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class CMapByteCid extends AbstractCMap {
    private ArrayList<char[]> planes;

    public CMapByteCid() {
        ArrayList<char[]> arrayList = new ArrayList<>();
        this.planes = arrayList;
        arrayList.add(new char[256]);
    }

    private void encodeSequence(byte[] bArr, char c) {
        int length = bArr.length - 1;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char[] cArr = this.planes.get(i);
            int i3 = bArr[i2] & UnsignedBytes.MAX_VALUE;
            char size = cArr[i3];
            if (size != 0 && (size & 32768) == 0) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("inconsistent.mapping", new Object[0]));
            }
            if (size == 0) {
                this.planes.add(new char[256]);
                size = (char) ((this.planes.size() - 1) | 32768);
                cArr[i3] = size;
            }
            i = size & BaseFont.CID_NEWLINE;
        }
        char[] cArr2 = this.planes.get(i);
        int i4 = bArr[length] & UnsignedBytes.MAX_VALUE;
        if ((cArr2[i4] & 32768) != 0) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("inconsistent.mapping", new Object[0]));
        }
        cArr2[i4] = c;
    }

    @Override // com.itextpdf.text.pdf.fonts.cmaps.AbstractCMap
    public void addChar(PdfString pdfString, PdfObject pdfObject) {
        if (pdfObject instanceof PdfNumber) {
            encodeSequence(AbstractCMap.decodeStringToByte(pdfString), (char) ((PdfNumber) pdfObject).intValue());
        }
    }

    public String decodeSequence(CMapSequence cMapSequence) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int iDecodeSingle = decodeSingle(cMapSequence);
            if (iDecodeSingle < 0) {
                return sb.toString();
            }
            sb.append((char) iDecodeSingle);
        }
    }

    public int decodeSingle(CMapSequence cMapSequence) {
        int i = cMapSequence.off + cMapSequence.len;
        int i2 = 0;
        while (true) {
            int i3 = cMapSequence.off;
            if (i3 >= i) {
                return -1;
            }
            byte[] bArr = cMapSequence.seq;
            cMapSequence.off = i3 + 1;
            int i4 = bArr[i3] & UnsignedBytes.MAX_VALUE;
            cMapSequence.len--;
            char c = this.planes.get(i2)[i4];
            if ((32768 & c) == 0) {
                return c;
            }
            i2 = c & BaseFont.CID_NEWLINE;
        }
    }
}
