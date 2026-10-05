package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

/* JADX INFO: loaded from: classes3.dex */
public class TagAttributeState implements State {
    protected final XMLParser parser;

    public TagAttributeState(XMLParser xMLParser) {
        this.parser = xMLParser;
    }

    public void checkAttributeWithNoValue() {
        if (setAttribute()) {
            this.parser.memory().putCurrentAttrValue("");
        }
    }

    @Override // com.itextpdf.tool.xml.parser.State
    public void process(char c) {
        if (c == '/') {
            this.parser.selectState().selfClosing();
            return;
        }
        if (c == '=') {
            this.parser.memory().currentAttr(this.parser.bufferToString());
            this.parser.flush();
            this.parser.selectState().attributeValue();
            return;
        }
        if (Character.isWhitespace(c)) {
            setAttribute();
            return;
        }
        if (c == '>') {
            checkAttributeWithNoValue();
            this.parser.startElement();
            this.parser.flush();
            this.parser.selectState().inTag();
            return;
        }
        if (!this.parser.memory().hasCurrentAttribute() || Character.isWhitespace(c)) {
            this.parser.append(c);
        } else {
            this.parser.memory().putCurrentAttrValue("");
            this.parser.append(c);
        }
    }

    public boolean setAttribute() {
        String strBufferToString = this.parser.bufferToString();
        if (strBufferToString.length() <= 0) {
            return false;
        }
        this.parser.memory().currentAttr(strBufferToString);
        this.parser.flush();
        return true;
    }
}
