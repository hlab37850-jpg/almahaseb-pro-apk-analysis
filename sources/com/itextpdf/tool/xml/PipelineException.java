package com.itextpdf.tool.xml;

/* JADX INFO: loaded from: classes3.dex */
public class PipelineException extends Exception {
    private static final long serialVersionUID = 1;

    public PipelineException(Exception exc) {
        super(exc);
    }

    public PipelineException(String str, Exception exc) {
        super(str, exc);
    }

    public PipelineException(String str) {
        super(str);
    }
}
