package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;

/* JADX INFO: loaded from: classes3.dex */
public interface CssSelectorItem {
    char getSeparator();

    int getSpecificity();

    boolean matches(Tag tag);
}
