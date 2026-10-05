package com.itextpdf.text.io;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class MapFailedException extends IOException {
    public MapFailedException(IOException iOException) {
        super(iOException.getMessage());
        initCause(iOException);
    }
}
