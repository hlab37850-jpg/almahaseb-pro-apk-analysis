package org.apache.poi.poifs.eventfilesystem;

import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSDocumentPath;

/* JADX INFO: loaded from: classes4.dex */
public class POIFSReaderEvent {
    private String documentName;
    private POIFSDocumentPath path;
    private DocumentInputStream stream;

    public POIFSReaderEvent(DocumentInputStream documentInputStream, POIFSDocumentPath pOIFSDocumentPath, String str) {
        this.stream = documentInputStream;
        this.path = pOIFSDocumentPath;
        this.documentName = str;
    }

    public String getName() {
        return this.documentName;
    }

    public POIFSDocumentPath getPath() {
        return this.path;
    }

    public DocumentInputStream getStream() {
        return this.stream;
    }
}
