package com.itextpdf.tool.xml.css.parser.state;

import com.itextpdf.tool.xml.css.parser.CssStateController;
import com.itextpdf.tool.xml.css.parser.State;

/* JADX INFO: loaded from: classes3.dex */
public class Unknown implements State {
    private final CssStateController controller;

    public Unknown(CssStateController cssStateController) {
        this.controller = cssStateController;
    }

    @Override // com.itextpdf.tool.xml.css.parser.State
    public void process(char c) {
        if ('/' == c) {
            this.controller.stateCommentStart();
            return;
        }
        if ('{' == c) {
            this.controller.storeSelector();
            this.controller.stateProperties();
        } else if ('@' == c) {
            this.controller.stateRule();
        } else {
            this.controller.append(c);
        }
    }
}
