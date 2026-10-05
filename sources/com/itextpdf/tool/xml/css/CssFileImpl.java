package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.parser.CssSelectorParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CssFileImpl implements CssFile {
    private boolean persistent = false;
    private final List<CssRule> rules = new ArrayList();

    @Override // com.itextpdf.tool.xml.css.CssFile
    public boolean add(String str, Map<String, String> map) {
        List<CssSelectorItem> listCreateCssSelector = CssSelectorParser.createCssSelector(str);
        if (listCreateCssSelector == null) {
            return false;
        }
        this.rules.add(new CssRule(listCreateCssSelector, map));
        return true;
    }

    @Override // com.itextpdf.tool.xml.css.CssFile
    public List<CssRule> get(Tag tag) {
        ArrayList arrayList = new ArrayList();
        for (CssRule cssRule : this.rules) {
            if (cssRule.getSelector().matches(tag)) {
                arrayList.add(cssRule);
            }
        }
        return arrayList;
    }

    @Override // com.itextpdf.tool.xml.css.CssFile
    public boolean isPersistent() {
        return this.persistent;
    }

    @Override // com.itextpdf.tool.xml.css.CssFile
    public void isPersistent(boolean z) {
        this.persistent = z;
    }
}
