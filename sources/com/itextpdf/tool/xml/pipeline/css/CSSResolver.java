package com.itextpdf.tool.xml.pipeline.css;

import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.net.FileRetrieve;

/* JADX INFO: loaded from: classes3.dex */
public interface CSSResolver {
    void addCss(CssFile cssFile);

    void addCss(String str, String str2, boolean z);

    void addCss(String str, boolean z);

    void addCssFile(String str, boolean z);

    CSSResolver clear();

    void resolveStyles(Tag tag);

    void setFileRetrieve(FileRetrieve fileRetrieve);
}
