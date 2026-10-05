package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

/* JADX INFO: loaded from: classes3.dex */
public class CommentState implements State {
    private final XMLParser parser;

    public CommentState(XMLParser xMLParser) {
        this.parser = xMLParser;
    }

    @Override // com.itextpdf.tool.xml.parser.State
    public void process(char c) {
        if (c != '-') {
            this.parser.append(c);
        } else {
            this.parser.memory().comment().append('-');
            this.parser.selectState().closeComment();
        }
    }
}
