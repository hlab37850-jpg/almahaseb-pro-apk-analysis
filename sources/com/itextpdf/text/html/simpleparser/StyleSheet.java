package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.tool.xml.css.CSS;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class StyleSheet {
    protected Map<String, Map<String, String>> tagMap = new HashMap();
    protected Map<String, Map<String, String>> classMap = new HashMap();

    public static void resolveStyleAttribute(Map<String, String> map, ChainedProperties chainedProperties) {
        String str = map.get("style");
        if (str == null) {
            return;
        }
        Properties attributes = HtmlUtilities.parseAttributes(str);
        for (String str2 : attributes.keySet()) {
            if (str2.equals("font-family")) {
                map.put("face", attributes.getProperty(str2));
            } else if (str2.equals("font-size")) {
                float length = HtmlUtilities.parseLength(chainedProperties.getProperty("size"), 12.0f);
                map.put("size", Float.toString(HtmlUtilities.parseLength(attributes.getProperty(str2), length > 0.0f ? length : 12.0f)) + CSS.Value.PT);
            } else if (str2.equals("font-style")) {
                String lowerCase = attributes.getProperty(str2).trim().toLowerCase();
                if (lowerCase.equals("italic") || lowerCase.equals("oblique")) {
                    map.put("i", null);
                }
            } else if (str2.equals("font-weight")) {
                String lowerCase2 = attributes.getProperty(str2).trim().toLowerCase();
                if (lowerCase2.equals("bold") || lowerCase2.equals("700") || lowerCase2.equals("800") || lowerCase2.equals("900")) {
                    map.put("b", null);
                }
            } else if (str2.equals("text-decoration")) {
                if (attributes.getProperty(str2).trim().toLowerCase().equals("underline")) {
                    map.put("u", null);
                }
            } else if (str2.equals("color")) {
                BaseColor baseColorDecodeColor = HtmlUtilities.decodeColor(attributes.getProperty(str2));
                if (baseColorDecodeColor != null) {
                    String str3 = "000000" + Integer.toHexString(baseColorDecodeColor.getRGB());
                    map.put("color", "#" + str3.substring(str3.length() - 6));
                }
            } else if (str2.equals("line-height")) {
                String strTrim = attributes.getProperty(str2).trim();
                float length2 = HtmlUtilities.parseLength(chainedProperties.getProperty("size"), 12.0f);
                float length3 = HtmlUtilities.parseLength(attributes.getProperty(str2), length2 > 0.0f ? length2 : 12.0f);
                if (strTrim.endsWith(CSS.Value.PERCENTAGE)) {
                    map.put(HtmlTags.LEADING, "0," + (length3 / 100.0f));
                    return;
                }
                if (HtmlTags.NORMAL.equalsIgnoreCase(strTrim)) {
                    map.put(HtmlTags.LEADING, "0,1.5");
                    return;
                }
                map.put(HtmlTags.LEADING, length3 + ",0");
            } else if (str2.equals("text-align")) {
                map.put("align", attributes.getProperty(str2).trim().toLowerCase());
            } else if (str2.equals("padding-left")) {
                map.put(HtmlTags.INDENT, Float.toString(HtmlUtilities.parseLength(attributes.getProperty(str2).trim().toLowerCase())));
            }
        }
    }

    public void applyStyle(String str, Map<String, String> map) {
        Map<String, String> map2;
        Map<String, String> map3 = this.tagMap.get(str.toLowerCase());
        if (map3 != null) {
            HashMap map4 = new HashMap(map3);
            map4.putAll(map);
            map.putAll(map4);
        }
        String str2 = map.get("class");
        if (str2 == null || (map2 = this.classMap.get(str2.toLowerCase())) == null) {
            return;
        }
        map.remove("class");
        HashMap map5 = new HashMap(map2);
        map5.putAll(map);
        map.putAll(map5);
    }

    public void loadStyle(String str, HashMap<String, String> map) {
        this.classMap.put(str.toLowerCase(), map);
    }

    public void loadTagStyle(String str, Map<String, String> map) {
        this.tagMap.put(str.toLowerCase(), map);
    }

    public void loadStyle(String str, String str2, String str3) {
        String lowerCase = str.toLowerCase();
        Map<String, String> map = this.classMap.get(lowerCase);
        if (map == null) {
            map = new HashMap<>();
            this.classMap.put(lowerCase, map);
        }
        map.put(str2, str3);
    }

    public void loadTagStyle(String str, String str2, String str3) {
        String lowerCase = str.toLowerCase();
        Map<String, String> map = this.tagMap.get(lowerCase);
        if (map == null) {
            map = new HashMap<>();
            this.tagMap.put(lowerCase, map);
        }
        map.put(str2, str3);
    }
}
