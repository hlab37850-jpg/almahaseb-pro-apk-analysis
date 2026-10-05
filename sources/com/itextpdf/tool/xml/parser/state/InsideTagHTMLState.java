package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.TagState;
import com.itextpdf.tool.xml.parser.XMLParser;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class InsideTagHTMLState implements State {
    private final List<String> ignoreLastChars;
    private final List<String> noSanitize;
    private final XMLParser parser;

    public InsideTagHTMLState(XMLParser xMLParser) {
        ArrayList arrayList = new ArrayList(1);
        this.noSanitize = arrayList;
        ArrayList arrayList2 = new ArrayList(9);
        this.ignoreLastChars = arrayList2;
        this.parser = xMLParser;
        arrayList.add("pre");
        arrayList2.add("p");
        arrayList2.add("div");
        arrayList2.add("h1");
        arrayList2.add("h2");
        arrayList2.add("h3");
        arrayList2.add("h4");
        arrayList2.add("h5");
        arrayList2.add("h6");
        arrayList2.add("td");
        arrayList2.add("th");
        arrayList2.add("ul");
        arrayList2.add("ol");
        arrayList2.add("li");
        arrayList2.add(HTML.Tag.DD);
        arrayList2.add(HTML.Tag.DT);
        arrayList2.add("hr");
        arrayList2.add("br");
    }

    @Override // com.itextpdf.tool.xml.parser.State
    public void process(char c) {
        if (c == '<') {
            if (this.parser.bufferSize() > 0) {
                XMLParser xMLParser = this.parser;
                xMLParser.text(xMLParser.current());
            }
            this.parser.flush();
            this.parser.selectState().tagEncountered();
            return;
        }
        if (c == '&') {
            this.parser.selectState().specialChar();
            return;
        }
        if (c == '*' && this.parser.memory().lastChar() == '/') {
            this.parser.selectState().starComment();
            this.parser.memory().current().deleteCharAt(this.parser.memory().current().lastIndexOf("/"));
            if (this.parser.bufferSize() > 0) {
                this.parser.memory().setStoredString(this.parser.current());
            }
            this.parser.flush();
            return;
        }
        String strCurrentTag = this.parser.currentTag();
        TagState tagStateCurrentTagState = this.parser.currentTagState();
        if (this.noSanitize.contains(strCurrentTag) && TagState.OPEN == tagStateCurrentTagState) {
            this.parser.append(c);
            return;
        }
        if (this.parser.memory().whitespaceTag().length() != 0) {
            if (this.ignoreLastChars.contains(this.parser.memory().whitespaceTag().toLowerCase())) {
                this.parser.memory().lastChar(' ');
            }
            this.parser.memory().whitespaceTag("");
        }
        boolean zIsWhitespace = Character.isWhitespace(this.parser.memory().lastChar());
        boolean zIsWhitespace2 = Character.isWhitespace(c);
        if (!zIsWhitespace || (zIsWhitespace && !zIsWhitespace2)) {
            if (zIsWhitespace2) {
                this.parser.append(' ');
            } else {
                this.parser.append(c);
            }
        }
        this.parser.memory().lastChar(c);
    }
}
