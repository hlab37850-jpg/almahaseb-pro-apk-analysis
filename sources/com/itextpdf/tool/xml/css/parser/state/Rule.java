package com.itextpdf.tool.xml.css.parser.state;

import com.itextpdf.tool.xml.css.parser.CssStateController;
import com.itextpdf.tool.xml.css.parser.State;

/* JADX INFO: loaded from: classes3.dex */
public class Rule implements State {
    private final CssStateController controller;
    private boolean isCss3AtRule;
    private int openParenthesesCount = 0;

    public Rule(CssStateController cssStateController) {
        this.controller = cssStateController;
    }

    @Override // com.itextpdf.tool.xml.css.parser.State
    public void process(char c) {
        if ('}' == c && this.isCss3AtRule) {
            int i = this.openParenthesesCount - 1;
            this.openParenthesesCount = i;
            if (i == 0) {
                this.controller.stateUnknown();
                this.isCss3AtRule = false;
                return;
            }
            return;
        }
        if (';' == c && !this.isCss3AtRule) {
            this.controller.stateUnknown();
        } else if ('{' == c) {
            this.openParenthesesCount++;
            this.isCss3AtRule = true;
        }
    }
}
