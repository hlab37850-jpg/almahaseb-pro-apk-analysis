package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface CssFile {
    boolean add(String str, Map<String, String> map);

    List<CssRule> get(Tag tag);

    void isPersistent(boolean z);

    boolean isPersistent();
}
