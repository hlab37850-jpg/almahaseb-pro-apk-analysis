package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CSSFileWrapper implements CssFile {
    private final CssFile css;
    private final boolean persistent;

    public CSSFileWrapper(CssFile cssFile, boolean z) {
        this.css = cssFile;
        this.persistent = z;
    }

    @Override // com.itextpdf.tool.xml.css.CssFile
    public boolean add(String str, Map<String, String> map) {
        throw new UnsupportedOperationException();
    }

    @Override // com.itextpdf.tool.xml.css.CssFile
    public List<CssRule> get(Tag tag) {
        return this.css.get(tag);
    }

    @Override // com.itextpdf.tool.xml.css.CssFile
    public boolean isPersistent() {
        return this.persistent;
    }

    @Override // com.itextpdf.tool.xml.css.CssFile
    public void isPersistent(boolean z) {
        throw new UnsupportedOperationException();
    }
}
