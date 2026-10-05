package com.itextpdf.tool.xml.css.parser;

import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CssSelectorItem;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class CssSelectorParser {
    private static final int a = 65536;
    private static final int b = 256;
    private static final int c = 1;
    private static final String selectorPatternString = "(\\*)|([_a-zA-Z][\\w-]*)|(\\.[_a-zA-Z][\\w-]*)|(#[_a-z][\\w-]*)|(\\[[_a-zA-Z][\\w-]*(([~^$*|])?=((\"[\\w-]+\")|([\\w-]+)))?\\])|(:[\\w()-]*)|( )|(\\+)|(>)|(~)";
    private static final Pattern selectorPattern = Pattern.compile(selectorPatternString);

    public static class CssAttributeSelector implements CssSelectorItem {
        private char matchSymbol;
        private String property;
        private String value;

        public CssAttributeSelector(String str) {
            this.matchSymbol = (char) 0;
            this.value = null;
            int iIndexOf = str.indexOf(61);
            if (iIndexOf == -1) {
                this.property = str.substring(1, str.length() - 1);
                return;
            }
            int i = iIndexOf + 1;
            if (str.charAt(i) == '\"') {
                this.value = str.substring(iIndexOf + 2, str.length() - 2);
            } else {
                this.value = str.substring(i, str.length() - 1);
            }
            int i2 = iIndexOf - 1;
            char cCharAt = str.charAt(i2);
            this.matchSymbol = cCharAt;
            if ("~^$*|".indexOf(cCharAt) != -1) {
                this.property = str.substring(1, i2);
            } else {
                this.matchSymbol = (char) 0;
                this.property = str.substring(1, iIndexOf);
            }
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public char getSeparator() {
            return (char) 0;
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public int getSpecificity() {
            return 256;
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public boolean matches(Tag tag) {
            String str;
            if (tag == null || (str = tag.getAttributes().get(this.property)) == null) {
                return false;
            }
            String str2 = this.value;
            if (str2 == null) {
                return true;
            }
            char c = this.matchSymbol;
            if (c != 0) {
                if (c != '$') {
                    if (c != '*') {
                        if (c != '^') {
                            if (c != '|') {
                                if (c == '~' && Pattern.compile(String.format("(^%s\\s+)|(\\s+%s\\s+)|(\\s+%s$)", str2, str2, str2)).matcher(str).find()) {
                                    return true;
                                }
                            } else if (Pattern.compile(String.format("^%s-?", str2)).matcher(str).find()) {
                                return true;
                            }
                        } else if (str.startsWith(str2)) {
                            return true;
                        }
                    } else if (str.contains(str2)) {
                        return true;
                    }
                } else if (str.endsWith(str2)) {
                    return true;
                }
            } else if (str.equals(str2)) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            sb.append(this.property);
            char c = this.matchSymbol;
            if (c != 0) {
                sb.append(c);
            }
            if (this.value != null) {
                sb.append('=');
                sb.append('\"');
                sb.append(this.value);
                sb.append('\"');
            }
            sb.append(']');
            return sb.toString();
        }
    }

    public static class CssClassSelector implements CssSelectorItem {
        private String className;

        public CssClassSelector(String str) {
            this.className = str;
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public char getSeparator() {
            return (char) 0;
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public int getSpecificity() {
            return 256;
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public boolean matches(Tag tag) {
            String str = tag.getAttributes().get("class");
            if (str != null && str.length() != 0) {
                for (String str2 : str.split(" ")) {
                    if (this.className.equals(str2.trim())) {
                        return true;
                    }
                }
            }
            return false;
        }

        public String toString() {
            return "." + this.className;
        }
    }

    public static class CssIdSelector implements CssSelectorItem {
        private String id;

        public CssIdSelector(String str) {
            this.id = str;
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public char getSeparator() {
            return (char) 0;
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public int getSpecificity() {
            return 65536;
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public boolean matches(Tag tag) {
            String str = tag.getAttributes().get(HTML.Attribute.ID);
            return str != null && this.id.equals(str.trim());
        }

        public String toString() {
            return "#" + this.id;
        }
    }

    public static class CssPseudoSelector implements CssSelectorItem {
        private String selector;

        public CssPseudoSelector(String str) {
            this.selector = str;
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public char getSeparator() {
            return (char) 0;
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public int getSpecificity() {
            return 0;
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public boolean matches(Tag tag) {
            return false;
        }

        public String toString() {
            return this.selector;
        }
    }

    public static class CssSeparatorSelector implements CssSelectorItem {
        private char separator;

        public CssSeparatorSelector(char c) {
            this.separator = c;
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public char getSeparator() {
            return this.separator;
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public int getSpecificity() {
            return 0;
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public boolean matches(Tag tag) {
            return false;
        }

        public String toString() {
            return String.valueOf(this.separator);
        }
    }

    public static class CssTagSelector implements CssSelectorItem {
        private boolean isUniversal;
        private String t;

        public CssTagSelector(String str) {
            this.t = str;
            this.isUniversal = str.equals("*");
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public char getSeparator() {
            return (char) 0;
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public int getSpecificity() {
            return this.isUniversal ? 0 : 1;
        }

        @Override // com.itextpdf.tool.xml.css.CssSelectorItem
        public boolean matches(Tag tag) {
            return this.isUniversal || this.t.equals(tag.getName());
        }

        public String toString() {
            return this.t;
        }
    }

    public static List<CssSelectorItem> createCssSelector(String str) {
        CssSeparatorSelector cssSeparatorSelector;
        ArrayList arrayList = new ArrayList();
        Matcher matcher = selectorPattern.matcher(str);
        int length = 0;
        while (true) {
            boolean z = false;
            while (true) {
                if (!matcher.find()) {
                    if (str.length() == 0 || str.length() != length) {
                        return null;
                    }
                    return arrayList;
                }
                String strGroup = matcher.group(0);
                length += strGroup.length();
                char cCharAt = strGroup.charAt(0);
                if (cCharAt != ' ') {
                    if (cCharAt == '#') {
                        arrayList.add(new CssIdSelector(strGroup.substring(1)));
                    } else if (cCharAt != '+') {
                        if (cCharAt == '.') {
                            arrayList.add(new CssClassSelector(strGroup.substring(1)));
                        } else if (cCharAt == ':') {
                            arrayList.add(new CssPseudoSelector(strGroup));
                        } else if (cCharAt != '>') {
                            if (cCharAt == '[') {
                                arrayList.add(new CssAttributeSelector(strGroup));
                            } else if (cCharAt != '~') {
                                if (z) {
                                    return null;
                                }
                                arrayList.add(new CssTagSelector(strGroup));
                                z = true;
                            }
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    return null;
                }
                CssSelectorItem cssSelectorItem = (CssSelectorItem) arrayList.get(arrayList.size() - 1);
                cssSeparatorSelector = new CssSeparatorSelector(strGroup.charAt(0));
                if (cssSelectorItem instanceof CssSeparatorSelector) {
                    if (strGroup.charAt(0) == ' ') {
                        continue;
                    } else {
                        if (cssSelectorItem.getSeparator() != ' ') {
                            return null;
                        }
                        arrayList.set(arrayList.size() - 1, cssSeparatorSelector);
                    }
                }
            }
            arrayList.add(cssSeparatorSelector);
        }
    }
}
