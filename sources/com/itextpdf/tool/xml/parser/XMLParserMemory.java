package com.itextpdf.tool.xml.parser;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class XMLParserMemory {
    private String currentAttr;
    private String currentTag;
    private final boolean isHtml;
    private char lastChar;
    private String storedString;
    private final StringBuilder currentEntity = new StringBuilder();
    private final StringBuilder comment = new StringBuilder();
    private final StringBuilder baos = new StringBuilder();
    private String wsTag = "";
    private String currentNameSpace = "";
    private final Map<String, String> attr = new LinkedHashMap();

    public XMLParserMemory(boolean z) {
        this.isHtml = z;
    }

    public StringBuilder comment() {
        return this.comment;
    }

    public StringBuilder current() {
        return this.baos;
    }

    public void currentAttr(String str) {
        this.currentAttr = str;
    }

    public StringBuilder currentEntity() {
        return this.currentEntity;
    }

    public void currentTag(String str) {
        this.currentTag = str;
        this.wsTag = str;
        this.attr.clear();
    }

    public void flushNameSpace() {
        this.currentNameSpace = "";
    }

    public Map<String, String> getAttributes() {
        return new LinkedHashMap(this.attr);
    }

    public String getCurrentTag() {
        return this.currentTag;
    }

    public String getNameSpace() {
        return this.currentNameSpace;
    }

    public String getStoredString() {
        return this.storedString;
    }

    public boolean hasCurrentAttribute() {
        return this.currentAttr != null;
    }

    public void lastChar(char c) {
        this.lastChar = c;
    }

    public void namespace(String str) {
        this.currentNameSpace = str;
    }

    public void putCurrentAttrValue(String str) {
        String str2 = this.currentAttr;
        if (str2 != null) {
            if (this.isHtml) {
                this.attr.put(str2.toLowerCase(), str);
            } else {
                this.attr.put(str2, str);
            }
            this.currentAttr = null;
        }
    }

    public void resetBuffer() {
        this.baos.setLength(0);
    }

    public void setStoredString(String str) {
        this.storedString = str;
    }

    public String whitespaceTag() {
        return this.wsTag;
    }

    public char lastChar() {
        return this.lastChar;
    }

    public void whitespaceTag(String str) {
        this.wsTag = str;
    }
}
