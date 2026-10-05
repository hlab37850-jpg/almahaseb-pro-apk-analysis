package org.apache.poi;

/* JADX INFO: loaded from: classes.dex */
public abstract class POITextExtractor {
    protected POIDocument document;

    public POITextExtractor(POIDocument pOIDocument) {
        this.document = pOIDocument;
    }

    public abstract POITextExtractor getMetadataTextExtractor();

    public abstract String getText();

    public POITextExtractor(POITextExtractor pOITextExtractor) {
        this.document = pOITextExtractor.document;
    }
}
