package com.itextpdf.text.xml.simpleparser.handler;

import com.itextpdf.text.xml.simpleparser.NewLineHandler;

/* JADX INFO: loaded from: classes3.dex */
public class NeverNewLineHandler implements NewLineHandler {
    @Override // com.itextpdf.text.xml.simpleparser.NewLineHandler
    public boolean isNewLineTag(String str) {
        return false;
    }
}
