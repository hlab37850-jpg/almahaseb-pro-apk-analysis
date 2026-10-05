package com.itextpdf.tool.xml.css.parser.state;

import com.itextpdf.tool.xml.css.parser.CssStateController;
import com.itextpdf.tool.xml.css.parser.State;

/* JADX INFO: loaded from: classes3.dex */
public class CommentEnd implements State {
    private final CssStateController controller;

    public CommentEnd(CssStateController cssStateController) {
        this.controller = cssStateController;
    }

    @Override // com.itextpdf.tool.xml.css.parser.State
    public void process(char c) {
        if ('/' == c) {
            this.controller.previous();
        } else {
            this.controller.stateCommentInside();
        }
    }
}
