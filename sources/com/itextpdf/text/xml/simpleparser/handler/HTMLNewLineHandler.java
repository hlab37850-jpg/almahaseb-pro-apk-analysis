package com.itextpdf.text.xml.simpleparser.handler;

import com.itextpdf.text.xml.simpleparser.NewLineHandler;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class HTMLNewLineHandler implements NewLineHandler {
    private final Set<String> newLineTags;

    public HTMLNewLineHandler() {
        HashSet hashSet = new HashSet();
        this.newLineTags = hashSet;
        hashSet.add("p");
        hashSet.add("blockquote");
        hashSet.add("br");
    }

    @Override // com.itextpdf.text.xml.simpleparser.NewLineHandler
    public boolean isNewLineTag(String str) {
        return this.newLineTags.contains(str);
    }
}
