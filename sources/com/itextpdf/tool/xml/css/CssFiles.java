package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface CssFiles {
    void add(CssFile cssFile);

    void clear();

    Map<String, String> getCSS(Tag tag);

    boolean hasFiles();
}
