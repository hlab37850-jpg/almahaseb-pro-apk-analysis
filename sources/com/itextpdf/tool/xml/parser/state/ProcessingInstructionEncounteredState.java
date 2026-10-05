package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.XMLParser;

/* JADX INFO: loaded from: classes3.dex */
public class ProcessingInstructionEncounteredState extends TagAttributeState {
    protected String name;

    public ProcessingInstructionEncounteredState(XMLParser xMLParser) {
        super(xMLParser);
        this.name = null;
    }

    @Override // com.itextpdf.tool.xml.parser.state.TagAttributeState, com.itextpdf.tool.xml.parser.State
    public void process(char c) {
        String strBufferToString = this.parser.bufferToString();
        if (this.name == null && Character.isWhitespace(c)) {
            if (Character.isWhitespace(c)) {
                this.name = strBufferToString;
                this.parser.memory().currentTag(this.name);
                this.parser.flush();
                return;
            } else {
                if (c == '?') {
                    this.parser.flush();
                    this.parser.selectState().selfClosing();
                    return;
                }
                return;
            }
        }
        if (Character.isWhitespace(c)) {
            checkAttributeWithNoValue();
            this.parser.flush();
        } else {
            if (c != '?') {
                this.parser.append(c);
                return;
            }
            this.name = null;
            checkAttributeWithNoValue();
            this.parser.flush();
            this.parser.selectState().selfClosing();
        }
    }
}
