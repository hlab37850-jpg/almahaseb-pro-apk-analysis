package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

/* JADX INFO: loaded from: classes3.dex */
public class UnknownState implements State {
    private final XMLParser parser;

    public UnknownState(XMLParser xMLParser) {
        this.parser = xMLParser;
    }

    @Override // com.itextpdf.tool.xml.parser.State
    public void process(char c) {
        if (c != '<') {
            this.parser.append(c);
            return;
        }
        this.parser.unknownData();
        this.parser.flush();
        this.parser.selectState().tagEncountered();
    }
}
