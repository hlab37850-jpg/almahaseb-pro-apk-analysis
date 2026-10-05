package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.codec.wmf.InputMeta;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class ImgWMF extends Image {
    public ImgWMF(Image image) {
        super(image);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    private void processParameters() throws IOException {
        String string;
        InputStream byteArrayInputStream;
        this.type = 35;
        this.originalType = 6;
        InputStream inputStream = null;
        try {
            if (this.rawData == null) {
                byteArrayInputStream = this.url.openStream();
                string = this.url.toString();
            } else {
                string = "Byte array";
                byteArrayInputStream = new ByteArrayInputStream(this.rawData);
            }
            InputMeta inputMeta = new InputMeta(byteArrayInputStream);
            if (inputMeta.readInt() != -1698247209) {
                throw new BadElementException(MessageLocalization.getComposedMessage("1.is.not.a.valid.placeable.windows.metafile", string));
            }
            inputMeta.readWord();
            int i = inputMeta.readShort();
            int i2 = inputMeta.readShort();
            int i3 = inputMeta.readShort();
            int i4 = inputMeta.readShort();
            int word = inputMeta.readWord();
            this.dpiX = 72;
            this.dpiY = 72;
            float f = word;
            float f2 = ((i4 - i2) / f) * 72.0f;
            this.scaledHeight = f2;
            setTop(f2);
            float f3 = ((i3 - i) / f) * 72.0f;
            this.scaledWidth = f3;
            setRight(f3);
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            this.plainWidth = getWidth();
            this.plainHeight = getHeight();
        } catch (Throwable th) {
            if (0 != 0) {
                inputStream.close();
            }
            this.plainWidth = getWidth();
            this.plainHeight = getHeight();
            throw th;
        }
    }

    public void readWMF(PdfTemplate pdfTemplate) {
        setTemplateData(pdfTemplate);
        pdfTemplate.setWidth(getWidth());
        pdfTemplate.setHeight(getHeight());
        InputStream inputStreamOpenStream = null;
        try {
            inputStreamOpenStream = this.rawData == null ? this.url.openStream() : new ByteArrayInputStream(this.rawData);
            new MetaDo(inputStreamOpenStream, pdfTemplate).readAll();
        } finally {
            if (inputStreamOpenStream != null) {
                inputStreamOpenStream.close();
            }
        }
    }

    public ImgWMF(URL url) throws IOException {
        super(url);
        processParameters();
    }

    public ImgWMF(String str) {
        this(Utilities.toURL(str));
    }

    public ImgWMF(byte[] bArr) throws IOException {
        super((URL) null);
        this.rawData = bArr;
        this.originalData = bArr;
        processParameters();
    }
}
