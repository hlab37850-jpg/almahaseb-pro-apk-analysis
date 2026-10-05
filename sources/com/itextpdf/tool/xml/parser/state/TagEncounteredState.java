package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

/* JADX INFO: loaded from: classes3.dex */
public class TagEncounteredState implements State {
    private final XMLParser parser;

    public TagEncounteredState(XMLParser xMLParser) {
        this.parser = xMLParser;
    }

    @Override // com.itextpdf.tool.xml.parser.State
    public void process(char c) {
        String strBufferToString = this.parser.bufferToString();
        if (!Character.isWhitespace(c) && c != '>' && c != '/' && c != ':' && c != '?' && !strBufferToString.equals("!--") && (!strBufferToString.equals("![CDATA") || c != '[')) {
            this.parser.append(c);
            return;
        }
        if (strBufferToString.length() <= 0) {
            if (c == '/') {
                this.parser.selectState().closingTag();
                return;
            } else {
                if (c == '?') {
                    this.parser.append(c);
                    this.parser.selectState().processingInstructions();
                    return;
                }
                return;
            }
        }
        if (strBufferToString.equals("!--")) {
            this.parser.flush();
            this.parser.memory().comment().setLength(0);
            this.parser.selectState().comment();
            if (c != '-') {
                this.parser.append(c);
                return;
            } else {
                this.parser.memory().comment().append(c);
                return;
            }
        }
        if (strBufferToString.equals("![CDATA") && c == '[') {
            this.parser.flush();
            this.parser.selectState().cdata();
            return;
        }
        if (strBufferToString.equals("!DOCTYPE")) {
            this.parser.flush();
            this.parser.selectState().doctype();
            this.parser.append(c);
            return;
        }
        if (Character.isWhitespace(c)) {
            this.parser.memory().currentTag(this.parser.bufferToString());
            this.parser.flush();
            this.parser.selectState().tagAttributes();
            return;
        }
        if (c == '>') {
            this.parser.memory().currentTag(strBufferToString);
            this.parser.flush();
            this.parser.startElement();
            this.parser.selectState().inTag();
            return;
        }
        if (c == '/') {
            this.parser.memory().currentTag(strBufferToString);
            this.parser.flush();
            this.parser.selectState().selfClosing();
        } else if (c == ':') {
            this.parser.memory().namespace(strBufferToString);
            this.parser.flush();
        }
    }
}
