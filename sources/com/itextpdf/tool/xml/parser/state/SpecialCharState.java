package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.text.xml.simpleparser.EntitiesToUnicode;
import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

/* JADX INFO: loaded from: classes3.dex */
public class SpecialCharState implements State {
    private final XMLParser parser;

    public SpecialCharState(XMLParser xMLParser) {
        this.parser = xMLParser;
    }

    @Override // com.itextpdf.tool.xml.parser.State
    public void process(char c) {
        StringBuilder sbCurrentEntity = this.parser.memory().currentEntity();
        if (c == ';') {
            char cDecodeEntity = EntitiesToUnicode.decodeEntity(sbCurrentEntity.toString());
            if (cDecodeEntity == 0) {
                this.parser.append('&').append(sbCurrentEntity.toString()).append(';');
                this.parser.memory().lastChar(';');
            } else {
                this.parser.append(Character.toString(cDecodeEntity));
                this.parser.memory().lastChar(cDecodeEntity);
            }
            this.parser.selectState().previousState();
            this.parser.memory().currentEntity().setLength(0);
            return;
        }
        if ((c == '#' || ((c >= '0' && c <= '9') || ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')))) && sbCurrentEntity.length() < 7) {
            sbCurrentEntity.append(c);
            return;
        }
        this.parser.append('&').append(sbCurrentEntity.toString()).append(c);
        this.parser.selectState().previousState();
        this.parser.memory().currentEntity().setLength(0);
    }
}
