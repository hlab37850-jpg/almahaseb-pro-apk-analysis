package com.itextpdf.tool.xml.css.parser;

import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.css.parser.state.CommentEnd;
import com.itextpdf.tool.xml.css.parser.state.CommentInside;
import com.itextpdf.tool.xml.css.parser.state.CommentStart;
import com.itextpdf.tool.xml.css.parser.state.Properties;
import com.itextpdf.tool.xml.css.parser.state.Rule;
import com.itextpdf.tool.xml.css.parser.state.Unknown;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class CssStateController {
    private final CssFile css;
    private State current;
    private String currentSelector;
    private State previous;
    private final State properties;
    private final State rule;
    private final State unknown;
    private final CssUtils utils = CssUtils.getInstance();
    private final StringBuilder buffer = new StringBuilder();
    private final State commentStart = new CommentStart(this);
    private final State commentEnd = new CommentEnd(this);
    private final State commentInside = new CommentInside(this);

    public CssStateController(CssFile cssFile) {
        this.css = cssFile;
        Unknown unknown = new Unknown(this);
        this.unknown = unknown;
        this.properties = new Properties(this);
        this.rule = new Rule(this);
        this.current = unknown;
    }

    private void processProps(String str) {
        String[] strArrSplit = str.split(";");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split(":");
            if (strArrSplit2.length == 2) {
                linkedHashMap.put(this.utils.stripDoubleSpacesTrimAndToLowerCase(strArrSplit2[0]), this.utils.stripDoubleSpacesAndTrim(strArrSplit2[1]));
            }
        }
        if (!this.currentSelector.contains(",")) {
            this.css.add(this.utils.stripDoubleSpacesAndTrim(this.currentSelector), linkedHashMap);
            return;
        }
        String[] strArrSplit3 = this.currentSelector.split(",");
        for (int i = 0; i < strArrSplit3.length; i++) {
            String strStripDoubleSpacesAndTrim = this.utils.stripDoubleSpacesAndTrim(strArrSplit3[i]);
            strArrSplit3[i] = strStripDoubleSpacesAndTrim;
            if (strStripDoubleSpacesAndTrim.length() == 0) {
                return;
            }
        }
        for (String str3 : strArrSplit3) {
            if (!this.css.add(str3, linkedHashMap)) {
                linkedHashMap.clear();
            }
        }
    }

    private void setPrevious() {
        this.previous = this.current;
    }

    private void setState(State state) {
        this.current = state;
    }

    public void append(char c) {
        this.buffer.append(c);
    }

    public void previous() {
        this.current = this.previous;
    }

    public void process(char c) {
        this.current.process(c);
    }

    public void stateCommentEnd() {
        setState(this.commentEnd);
    }

    public void stateCommentInside() {
        setState(this.commentInside);
    }

    public void stateCommentStart() {
        setPrevious();
        setState(this.commentStart);
    }

    public void stateProperties() {
        this.previous = this.current;
        setState(this.properties);
    }

    public void stateRule() {
        setState(this.rule);
    }

    public void stateUnknown() {
        setState(this.unknown);
    }

    public void storeProperties() {
        processProps(this.buffer.toString());
        this.buffer.setLength(0);
    }

    public void storeSelector() {
        this.currentSelector = this.buffer.toString();
        this.buffer.setLength(0);
    }
}
