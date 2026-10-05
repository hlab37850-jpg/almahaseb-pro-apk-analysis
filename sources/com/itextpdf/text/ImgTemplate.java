package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfTemplate;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class ImgTemplate extends Image {
    public ImgTemplate(Image image) {
        super(image);
    }

    public ImgTemplate(PdfTemplate pdfTemplate) throws BadElementException {
        super((URL) null);
        if (pdfTemplate == null) {
            throw new BadElementException(MessageLocalization.getComposedMessage("the.template.can.not.be.null", new Object[0]));
        }
        if (pdfTemplate.getType() == 3) {
            throw new BadElementException(MessageLocalization.getComposedMessage("a.pattern.can.not.be.used.as.a.template.to.create.an.image", new Object[0]));
        }
        this.type = 35;
        float height = pdfTemplate.getHeight();
        this.scaledHeight = height;
        setTop(height);
        float width = pdfTemplate.getWidth();
        this.scaledWidth = width;
        setRight(width);
        setTemplateData(pdfTemplate);
        this.plainWidth = getWidth();
        this.plainHeight = getHeight();
    }
}
