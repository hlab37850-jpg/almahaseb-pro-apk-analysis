package com.itextpdf.tool.xml.net.exc;

import com.itextpdf.tool.xml.exceptions.LocaleMessages;

/* JADX INFO: loaded from: classes3.dex */
public class NoImageException extends Exception {
    private static final long serialVersionUID = 1;

    public NoImageException(String str) {
        this(str, null);
    }

    public NoImageException(String str, Exception exc) {
        super(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.IMG_SRC_NOTCONVERTED), str), exc);
    }
}
