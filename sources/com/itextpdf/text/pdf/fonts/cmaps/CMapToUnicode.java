package com.itextpdf.text.pdf.fonts.cmaps;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CMapToUnicode extends AbstractCMap {
    private Map<Integer, String> singleByteMappings = new HashMap();
    private Map<Integer, String> doubleByteMappings = new HashMap();

    private int convertToInt(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes(XmpWriter.UTF16BE);
        int i = 0;
        for (int i2 = 0; i2 < bytes.length - 1; i2++) {
            i = (i + (bytes[i2] & UnsignedBytes.MAX_VALUE)) << 8;
        }
        return i + (bytes[bytes.length - 1] & UnsignedBytes.MAX_VALUE);
    }

    private String createStringFromBytes(byte[] bArr) {
        return bArr.length == 1 ? new String(bArr) : new String(bArr, XmpWriter.UTF16BE);
    }

    public static CMapToUnicode getIdentity() {
        CMapToUnicode cMapToUnicode = new CMapToUnicode();
        for (int i = 0; i < 65537; i++) {
            cMapToUnicode.addChar(i, Utilities.convertFromUtf32(i));
        }
        return cMapToUnicode;
    }

    public void addChar(int i, String str) {
        this.doubleByteMappings.put(Integer.valueOf(i), str);
    }

    public Map<Integer, Integer> createDirectMapping() {
        HashMap map = new HashMap();
        for (Map.Entry<Integer, String> entry : this.singleByteMappings.entrySet()) {
            map.put(entry.getKey(), Integer.valueOf(convertToInt(entry.getValue())));
        }
        for (Map.Entry<Integer, String> entry2 : this.doubleByteMappings.entrySet()) {
            map.put(entry2.getKey(), Integer.valueOf(convertToInt(entry2.getValue())));
        }
        return map;
    }

    public Map<Integer, Integer> createReverseMapping() {
        HashMap map = new HashMap();
        for (Map.Entry<Integer, String> entry : this.singleByteMappings.entrySet()) {
            map.put(Integer.valueOf(convertToInt(entry.getValue())), entry.getKey());
        }
        for (Map.Entry<Integer, String> entry2 : this.doubleByteMappings.entrySet()) {
            map.put(Integer.valueOf(convertToInt(entry2.getValue())), entry2.getKey());
        }
        return map;
    }

    public boolean hasOneByteMappings() {
        return !this.singleByteMappings.isEmpty();
    }

    public boolean hasTwoByteMappings() {
        return !this.doubleByteMappings.isEmpty();
    }

    public String lookup(byte[] bArr, int i, int i2) {
        if (i2 == 1) {
            return this.singleByteMappings.get(Integer.valueOf(bArr[i] & UnsignedBytes.MAX_VALUE));
        }
        if (i2 != 2) {
            return null;
        }
        return this.doubleByteMappings.get(Integer.valueOf(((bArr[i] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[i + 1] & UnsignedBytes.MAX_VALUE)));
    }

    @Override // com.itextpdf.text.pdf.fonts.cmaps.AbstractCMap
    public void addChar(PdfString pdfString, PdfObject pdfObject) {
        try {
            byte[] bytes = pdfString.getBytes();
            String strCreateStringFromBytes = createStringFromBytes(pdfObject.getBytes());
            if (bytes.length == 1) {
                this.singleByteMappings.put(Integer.valueOf(bytes[0] & UnsignedBytes.MAX_VALUE), strCreateStringFromBytes);
            } else {
                if (bytes.length != 2) {
                    throw new IOException(MessageLocalization.getComposedMessage("mapping.code.should.be.1.or.two.bytes.and.not.1", bytes.length));
                }
                this.doubleByteMappings.put(Integer.valueOf((bytes[1] & UnsignedBytes.MAX_VALUE) | ((bytes[0] & UnsignedBytes.MAX_VALUE) << 8)), strCreateStringFromBytes);
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
