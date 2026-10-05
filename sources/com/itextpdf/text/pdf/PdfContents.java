package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* JADX INFO: loaded from: classes3.dex */
class PdfContents extends PdfStream {
    static final byte[] SAVESTATE = DocWriter.getISOBytes("q\n");
    static final byte[] RESTORESTATE = DocWriter.getISOBytes("Q\n");
    static final byte[] ROTATE90 = DocWriter.getISOBytes("0 1 -1 0 ");
    static final byte[] ROTATE180 = DocWriter.getISOBytes("-1 0 0 -1 ");
    static final byte[] ROTATE270 = DocWriter.getISOBytes("0 -1 1 0 ");
    static final byte[] ROTATEFINAL = DocWriter.getISOBytes(" cm\n");

    public PdfContents(PdfContentByte pdfContentByte, PdfContentByte pdfContentByte2, PdfContentByte pdfContentByte3, PdfContentByte pdfContentByte4, Rectangle rectangle) throws BadPdfFormatException {
        Deflater deflater;
        OutputStream deflaterOutputStream;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.streamBytes = byteArrayOutputStream;
            if (Document.compress) {
                this.compressed = true;
                if (pdfContentByte3 != null) {
                    this.compressionLevel = pdfContentByte3.getPdfWriter().getCompressionLevel();
                } else if (pdfContentByte2 != null) {
                    this.compressionLevel = pdfContentByte2.getPdfWriter().getCompressionLevel();
                }
                Deflater deflater2 = new Deflater(this.compressionLevel);
                deflater = deflater2;
                deflaterOutputStream = new DeflaterOutputStream(this.streamBytes, deflater2);
            } else {
                deflater = null;
                deflaterOutputStream = byteArrayOutputStream;
            }
            int rotation = rectangle.getRotation();
            if (rotation == 90) {
                deflaterOutputStream.write(ROTATE90);
                deflaterOutputStream.write(DocWriter.getISOBytes(ByteBuffer.formatDouble(rectangle.getTop())));
                deflaterOutputStream.write(32);
                deflaterOutputStream.write(48);
                deflaterOutputStream.write(ROTATEFINAL);
            } else if (rotation == 180) {
                deflaterOutputStream.write(ROTATE180);
                deflaterOutputStream.write(DocWriter.getISOBytes(ByteBuffer.formatDouble(rectangle.getRight())));
                deflaterOutputStream.write(32);
                deflaterOutputStream.write(DocWriter.getISOBytes(ByteBuffer.formatDouble(rectangle.getTop())));
                deflaterOutputStream.write(ROTATEFINAL);
            } else if (rotation == 270) {
                deflaterOutputStream.write(ROTATE270);
                deflaterOutputStream.write(48);
                deflaterOutputStream.write(32);
                deflaterOutputStream.write(DocWriter.getISOBytes(ByteBuffer.formatDouble(rectangle.getRight())));
                deflaterOutputStream.write(ROTATEFINAL);
            }
            if (pdfContentByte.size() > 0) {
                deflaterOutputStream.write(SAVESTATE);
                pdfContentByte.getInternalBuffer().writeTo(deflaterOutputStream);
                deflaterOutputStream.write(RESTORESTATE);
            }
            if (pdfContentByte2.size() > 0) {
                deflaterOutputStream.write(SAVESTATE);
                pdfContentByte2.getInternalBuffer().writeTo(deflaterOutputStream);
                deflaterOutputStream.write(RESTORESTATE);
            }
            if (pdfContentByte3 != null) {
                deflaterOutputStream.write(SAVESTATE);
                pdfContentByte3.getInternalBuffer().writeTo(deflaterOutputStream);
                deflaterOutputStream.write(RESTORESTATE);
            }
            if (pdfContentByte4.size() > 0) {
                pdfContentByte4.getInternalBuffer().writeTo(deflaterOutputStream);
            }
            deflaterOutputStream.close();
            if (deflater != null) {
                deflater.end();
            }
            put(PdfName.LENGTH, new PdfNumber(this.streamBytes.size()));
            if (this.compressed) {
                put(PdfName.FILTER, PdfName.FLATEDECODE);
            }
        } catch (Exception e) {
            throw new BadPdfFormatException(e.getMessage());
        }
    }
}
