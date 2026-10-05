package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.tool.xml.css.CSS;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class ChainedProperties {
    public List<TagAttributes> chain = new ArrayList();

    public static final class TagAttributes {
        final Map<String, String> attrs;
        final String tag;

        public TagAttributes(String str, Map<String, String> map) {
            this.tag = str;
            this.attrs = map;
        }
    }

    public void addToChain(String str, Map<String, String> map) {
        adjustFontSize(map);
        this.chain.add(new TagAttributes(str, map));
    }

    public void adjustFontSize(Map<String, String> map) {
        String str = map.get("size");
        if (str == null) {
            return;
        }
        if (str.endsWith(CSS.Value.PT)) {
            map.put("size", str.substring(0, str.length() - 2));
        } else {
            map.put("size", Integer.toString(HtmlUtilities.getIndexedFontSize(str, getProperty("size"))));
        }
    }

    public String getProperty(String str) {
        for (int size = this.chain.size() - 1; size >= 0; size--) {
            String str2 = this.chain.get(size).attrs.get(str);
            if (str2 != null) {
                return str2;
            }
        }
        return null;
    }

    public boolean hasProperty(String str) {
        for (int size = this.chain.size() - 1; size >= 0; size--) {
            if (this.chain.get(size).attrs.containsKey(str)) {
                return true;
            }
        }
        return false;
    }

    public void removeChain(String str) {
        for (int size = this.chain.size() - 1; size >= 0; size--) {
            if (str.equals(this.chain.get(size).tag)) {
                this.chain.remove(size);
                return;
            }
        }
    }
}
