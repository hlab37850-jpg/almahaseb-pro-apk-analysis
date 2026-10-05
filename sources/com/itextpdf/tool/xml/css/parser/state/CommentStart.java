package com.itextpdf.tool.xml.css.parser.state;

import com.itextpdf.tool.xml.css.parser.CssStateController;
import com.itextpdf.tool.xml.css.parser.State;

/* JADX INFO: loaded from: classes3.dex */
public class CommentStart implements State {
    private final CssStateController controller;

    public CommentStart(CssStateController cssStateController) {
        this.controller = cssStateController;
    }

    @Override // com.itextpdf.tool.xml.css.parser.State
    public void process(char c) {
        if ('*' == c) {
            this.controller.stateCommentInside();
            return;
        }
        this.controller.append('/');
        this.controller.append(c);
        this.controller.previous();
    }
}
