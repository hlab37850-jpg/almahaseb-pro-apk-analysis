package com.itextpdf.tool.xml.css.parser.state;

import com.itextpdf.tool.xml.css.parser.CssStateController;
import com.itextpdf.tool.xml.css.parser.State;

/* JADX INFO: loaded from: classes3.dex */
public class Properties implements State {
    private final CssStateController controller;

    public Properties(CssStateController cssStateController) {
        this.controller = cssStateController;
    }

    @Override // com.itextpdf.tool.xml.css.parser.State
    public void process(char c) {
        if ('}' == c) {
            this.controller.storeProperties();
            this.controller.stateUnknown();
        } else if ('/' == c) {
            this.controller.stateCommentStart();
        } else {
            this.controller.append(c);
        }
    }
}
