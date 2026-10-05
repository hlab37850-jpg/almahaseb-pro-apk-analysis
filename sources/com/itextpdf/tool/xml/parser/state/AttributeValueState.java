package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

/* JADX INFO: loaded from: classes3.dex */
public class AttributeValueState implements State {
    private final XMLParser parser;

    public AttributeValueState(XMLParser xMLParser) {
        this.parser = xMLParser;
    }

    @Override // com.itextpdf.tool.xml.parser.State
    public void process(char c) {
        if (c == '\'') {
            this.parser.selectState().singleQuotedAttr();
            return;
        }
        if (c == '\"') {
            this.parser.selectState().doubleQuotedAttr();
        } else {
            if (Character.isWhitespace(c)) {
                return;
            }
            this.parser.append(c);
            this.parser.selectState().unquotedAttr();
        }
    }
}
