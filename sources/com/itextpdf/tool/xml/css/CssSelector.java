package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public class CssSelector {
    private List<CssSelectorItem> selectorItems;

    public CssSelector(List<CssSelectorItem> list) {
        this.selectorItems = list;
    }

    public int calculateSpecifity() {
        Iterator<CssSelectorItem> it = this.selectorItems.iterator();
        int specificity = 0;
        while (it.hasNext()) {
            specificity += it.next().getSpecificity();
        }
        return specificity;
    }

    public boolean matches(Tag tag) {
        return matches(tag, this.selectorItems.size() - 1);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<CssSelectorItem> it = this.selectorItems.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toString());
        }
        return stringBuffer.toString();
    }

    private boolean matches(Tag tag, int i) {
        int iIndexOf;
        if (tag == null) {
            return false;
        }
        Stack stack = new Stack();
        while (i >= 0 && this.selectorItems.get(i).getSeparator() == 0) {
            stack.push(this.selectorItems.get(i));
            i--;
        }
        while (!stack.empty()) {
            if (!((CssSelectorItem) stack.pop()).matches(tag)) {
                return false;
            }
        }
        if (i == -1) {
            return true;
        }
        char separator = this.selectorItems.get(i).getSeparator();
        if (separator == 0) {
            return false;
        }
        int i2 = i - 1;
        if (separator == ' ') {
            while (tag != null) {
                if (matches(tag.getParent(), i2)) {
                    return true;
                }
                tag = tag.getParent();
            }
            return false;
        }
        if (separator == '+') {
            return tag.hasParent() && (iIndexOf = tag.getParent().getChildren().indexOf(tag) - 1) >= 0 && matches(tag.getParent().getChildren().get(iIndexOf), i2);
        }
        if (separator == '>') {
            return matches(tag.getParent(), i2);
        }
        if (separator != '~' || !tag.hasParent()) {
            return false;
        }
        for (int iIndexOf2 = tag.getParent().getChildren().indexOf(tag) - 1; iIndexOf2 >= 0; iIndexOf2--) {
            if (matches(tag.getParent().getChildren().get(iIndexOf2), i2)) {
                return true;
            }
        }
        return false;
    }
}
