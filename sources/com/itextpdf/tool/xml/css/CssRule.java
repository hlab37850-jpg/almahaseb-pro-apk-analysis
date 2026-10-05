package com.itextpdf.tool.xml.css;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class CssRule implements Comparable<CssRule> {
    private static final Pattern importantMatcher = Pattern.compile(".*!\\s*important$");
    private Map<String, String> importantDeclarations = new LinkedHashMap();
    private Map<String, String> normalDeclarations;
    private CssSelector selector;

    public CssRule(List<CssSelectorItem> list, Map<String, String> map) {
        this.selector = new CssSelector(list);
        this.normalDeclarations = map;
        for (Map.Entry<String, String> entry : this.normalDeclarations.entrySet()) {
            int iIndexOf = entry.getValue().indexOf(33);
            if (iIndexOf > 0 && importantMatcher.matcher(entry.getValue()).matches()) {
                this.importantDeclarations.put(entry.getKey(), entry.getValue().substring(0, iIndexOf).trim());
            }
        }
        Iterator<String> it = this.importantDeclarations.keySet().iterator();
        while (it.hasNext()) {
            this.normalDeclarations.remove(it.next());
        }
    }

    public Map<String, String> getImportantDeclarations() {
        return this.importantDeclarations;
    }

    public Map<String, String> getNormalDeclarations() {
        return this.normalDeclarations;
    }

    public CssSelector getSelector() {
        return this.selector;
    }

    public String toString() {
        return String.format("%s { count: %d } #spec:%d", this.selector.toString(), Integer.valueOf(this.normalDeclarations.size() + this.importantDeclarations.size()), Integer.valueOf(this.selector.calculateSpecifity()));
    }

    @Override // java.lang.Comparable
    public int compareTo(CssRule cssRule) {
        return this.selector.calculateSpecifity() - cssRule.selector.calculateSpecifity();
    }
}
