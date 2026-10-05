package com.zebra.sdk.graphics.internal;

import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import com.zebra.sdk.comm.ConnectionException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public class CompressedBitmapOutputStreamZpl extends CompressedBitmapOutputStreamA {
    private static final int[] charMap = {380, 360, TIFFConstants.TIFFTAG_SMINSAMPLEVALUE, TIFFConstants.TIFFTAG_COLORMAP, 300, TIFFConstants.TIFFTAG_MINSAMPLEVALUE, MetaDo.META_SETROP2, 240, 220, 200, ShapeTypes.MATH_EQUAL, 160, ShapeTypes.FLOW_CHART_PREPARATION, 120, 100, 80, 60, 40, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private static final char[] charVal = {'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', Barcode128.START_C, Barcode128.START_B, Barcode128.START_A, 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G'};
    private byte previousByteWritten = 0;
    private int previousByteWrittenRepeatCount = 0;

    public CompressedBitmapOutputStreamZpl(OutputStream outputStream) {
        this.outputStream = outputStream;
        this.internalEncodedBuffer = new ByteArrayOutputStream();
    }

    private void computeAndOutput() throws IOException {
        int i = this.previousByteWrittenRepeatCount;
        if (i > 1) {
            int i2 = i / 400;
            int i3 = i % 400;
            for (int i4 = 0; i4 < i2; i4++) {
                bufferAndWrite('z');
            }
            int i5 = 0;
            while (true) {
                int[] iArr = charMap;
                if (i5 >= iArr.length) {
                    break;
                }
                if (i3 >= iArr[i5]) {
                    bufferAndWrite(charVal[i5]);
                    i3 -= iArr[i5];
                }
                i5++;
            }
        }
        bufferAndWrite(Integer.toHexString(this.previousByteWritten & 15).toUpperCase().charAt(0));
    }

    private byte[] extractNibblesFromByte(byte b) {
        int i = ~b;
        return new byte[]{(byte) ((i >> 4) & 15), (byte) (i & 15)};
    }

    private void sendBufferedDataToPrinter() throws IOException {
        try {
            computeAndOutput();
        } catch (ConnectionException e) {
            throw new IOException(e.getMessage());
        }
    }

    private void writeNibbleToStream(byte b) throws IOException {
        int i = this.previousByteWrittenRepeatCount;
        if (i == 0) {
            this.previousByteWritten = b;
        } else if (this.previousByteWritten != b) {
            sendBufferedDataToPrinter();
            this.previousByteWritten = b;
            this.previousByteWrittenRepeatCount = 1;
            return;
        }
        this.previousByteWrittenRepeatCount = i + 1;
    }

    private void writeNibblesToStream(byte[] bArr) throws IOException {
        for (byte b : bArr) {
            writeNibbleToStream(b);
        }
    }

    @Override // com.zebra.sdk.graphics.internal.CompressedBitmapOutputStreamA, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.previousByteWrittenRepeatCount > 0) {
            sendBufferedDataToPrinter();
            this.previousByteWrittenRepeatCount = 0;
        }
        super.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        for (byte b : bArr) {
            writeNibblesToStream(extractNibblesFromByte(b));
        }
    }
}
