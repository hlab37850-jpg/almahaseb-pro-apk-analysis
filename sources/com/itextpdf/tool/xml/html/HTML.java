package com.itextpdf.tool.xml.html;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class HTML {

    public static final class Attribute {
        public static final String ALIGN = "align";
        public static final String ALT = "alt";
        public static final String CELLPADDING = "cellpadding";
        public static final String CELLSPACING = "cellspacing";
        public static final String CLASS = "class";
        public static final String COLOR = "color";
        public static final String COLSPAN = "colspan";
        public static final String DIR = "dir";
        public static final String FACE = "face";
        public static final String HEIGHT = "height";
        public static final String HREF = "href";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String ROWSPAN = "rowspan";
        public static final String SIZE = "size";
        public static final String SRC = "src";
        public static final String START = "start";
        public static final String STYLE = "style";
        public static final String TYPE = "type";
        public static final String VALIGN = "valign";
        public static final String WIDTH = "width";

        public static final class Value {
            public static final String TEXTCSS = "text/css";

            private Value() {
            }
        }

        private Attribute() {
        }
    }

    public static final class Category {
        public static final Set<String> NOT_VISIBLE = new HashSet(Arrays.asList(Tag.HTML, Tag.HEAD, Tag.META, Tag.SCRIPT, Tag.LINK, "style", "title"));
        public static final Set<String> BLOCK_LEVEL = new HashSet(Arrays.asList(Tag.ADDRESS, Tag.ARTICLE, Tag.ASIDE, Tag.AUDIO, "blockquote", Tag.CANVAS, Tag.DD, "div", Tag.FIELDSET, Tag.FIGCAPTION, Tag.FIGURE, Tag.FOOTER, Tag.FORM, "h1", "h2", "h3", "h4", "h5", "h6", Tag.HEADER, Tag.HGROUP, "hr", Tag.NOSCRIPT, "ol", Tag.OUTPUT, "p", "pre", Tag.SECTION, "table", "ul", Tag.VIDEO));
        public static final Set<String> METADATA = new HashSet(Arrays.asList(Tag.BASE, Tag.COMMAND, Tag.LINK, Tag.META, Tag.NOSCRIPT, "style", "title"));
        public static final Set<String> FLOW_CONTENT = new HashSet(Arrays.asList("a", Tag.ABBR, Tag.ADDRESS, Tag.ARTICLE, Tag.ASIDE, Tag.AUDIO, "b", Tag.BDO, "blockquote", "br", Tag.BUTTON, Tag.CANVAS, Tag.CITE, Tag.CODE, Tag.COMMAND, Tag.DATALIST, Tag.DEL, Tag.DETAILS, Tag.DFN, "div", Tag.DL, "em", Tag.EMBED, Tag.FIELDSET, Tag.FIGURE, Tag.FOOTER, Tag.FORM, "h1", "h2", "h3", "h4", "h5", "h6", Tag.HEADER, Tag.HGROUP, "hr", "i", Tag.IFRAME, "img", Tag.INPUT, Tag.INS, Tag.KBD, Tag.KEYGEN, Tag.LABEL, Tag.MAP, Tag.MARK, Tag.MATH, Tag.MENU, Tag.METER, Tag.NAV, Tag.NOSCRIPT, Tag.OBJECT, "ol", Tag.OUTPUT, "p", "pre", "progress", Tag.Q, Tag.RUBY, Tag.SAMP, Tag.SCRIPT, Tag.SECTION, Tag.SELECT, "small", "span", "font", "strong", "sub", "sup", Tag.SVG, "table", Tag.TEXTAREA, Tag.TIME, "ul", Tag.VAR, Tag.VIDEO, Tag.WBR));
        public static final Set<String> SECTIONING_CONTENT = new HashSet(Arrays.asList(Tag.ARTICLE, Tag.ASIDE, Tag.NAV, Tag.SECTION));
        public static final Set<String> HEADING_CONTENT = new HashSet(Arrays.asList("h1", "h2", "h3", "h4", "h5", "h6", Tag.HGROUP));
        public static final Set<String> PHRASING_CONTENT = new HashSet(Arrays.asList(Tag.ABBR, Tag.AUDIO, "b", Tag.BDO, "br", Tag.BUTTON, Tag.CANVAS, Tag.CITE, Tag.CODE, Tag.COMMAND, Tag.DATALIST, Tag.DFN, "em", Tag.EMBED, "i", Tag.IFRAME, "img", Tag.INPUT, Tag.KBD, Tag.KEYGEN, Tag.LABEL, Tag.MARK, Tag.MATH, Tag.METER, Tag.NOSCRIPT, Tag.OBJECT, Tag.OUTPUT, "progress", Tag.Q, Tag.RUBY, Tag.SAMP, Tag.SCRIPT, Tag.SELECT, "small", "span", "font", "strong", "sub", "sup", Tag.SVG, Tag.TEXTAREA, Tag.TIME, Tag.VAR, Tag.VIDEO, Tag.WBR));
        public static final Set<String> EMBEDDED_CONTENT = new HashSet(Arrays.asList(Tag.AUDIO, Tag.CANVAS, Tag.EMBED, Tag.IFRAME, "img", Tag.MATH, Tag.OBJECT, Tag.SVG, Tag.VIDEO));

        private Category() {
        }
    }

    public static final class Tag {
        public static final String A = "a";
        public static final String ABBR = "abbr";
        public static final String ADDRESS = "address";
        public static final String ARTICLE = "article";
        public static final String ASIDE = "aside";
        public static final String AUDIO = "audio";
        public static final String B = "b";
        public static final String BASE = "base";
        public static final String BDO = "bdo";
        public static final String BIG = "big";
        public static final String BLOCKQUOTE = "blockquote";
        public static final String BODY = "body";
        public static final String BR = "br";
        public static final String BUTTON = "button";
        public static final String CANVAS = "canvas";
        public static final String CAPTION = "caption";
        public static final String CITE = "cite";
        public static final String CODE = "code";
        public static final String COMMAND = "command";
        public static final String DATALIST = "datalist";
        public static final String DD = "dd";
        public static final String DEL = "del";
        public static final String DETAILS = "details";
        public static final String DFN = "dfn";
        public static final String DIV = "div";
        public static final String DL = "dl";
        public static final String DT = "dt";
        public static final String EM = "em";
        public static final String EMBED = "embed";
        public static final String FIELDSET = "fieldset";
        public static final String FIGCAPTION = "figcaption";
        public static final String FIGURE = "figure";
        public static final String FONT = "font";
        public static final String FOOTER = "footer";
        public static final String FORM = "form";
        public static final String H1 = "h1";
        public static final String H2 = "h2";
        public static final String H3 = "h3";
        public static final String H4 = "h4";
        public static final String H5 = "h5";
        public static final String H6 = "h6";
        public static final String HEAD = "head";
        public static final String HEADER = "header";
        public static final String HGROUP = "hgroup";
        public static final String HR = "hr";
        public static final String HTML = "html";
        public static final String I = "i";
        public static final String IFRAME = "iframe";
        public static final String IMG = "img";
        public static final String INPUT = "input";
        public static final String INS = "ins";
        public static final String KBD = "kbd";
        public static final String KEYGEN = "keygen";
        public static final String LABEL = "label";
        public static final String LI = "li";
        public static final String LINK = "link";
        public static final String MAP = "map";
        public static final String MARK = "mark";
        public static final String MATH = "math";
        public static final String MENU = "menu";
        public static final String META = "meta";
        public static final String METER = "meter";
        public static final String NAV = "nav";
        public static final String NOSCRIPT = "noscript";
        public static final String OBJECT = "object";
        public static final String OL = "ol";
        public static final String OUTPUT = "output";
        public static final String P = "p";
        public static final String PRE = "pre";
        public static final String PROGRESS = "progress";
        public static final String Q = "q";
        public static final String RUBY = "ruby";
        public static final String S = "s";
        public static final String SAMP = "samp";
        public static final String SCRIPT = "script";
        public static final String SECTION = "section";
        public static final String SELECT = "select";
        public static final String SMALL = "small";
        public static final String SPAN = "span";
        public static final String STRIKE = "strike";
        public static final String STRONG = "strong";
        public static final String STYLE = "style";
        public static final String SUB = "sub";
        public static final String SUP = "sup";
        public static final String SVG = "svg";
        public static final String TABLE = "table";
        public static final String TBODY = "tbody";
        public static final String TD = "td";
        public static final String TEXTAREA = "textarea";
        public static final String TFOOT = "tfoot";
        public static final String TH = "th";
        public static final String THEAD = "thead";
        public static final String TIME = "time";
        public static final String TITLE = "title";
        public static final String TR = "tr";
        public static final String TT = "tt";
        public static final String U = "u";
        public static final String UL = "ul";
        public static final String VAR = "var";
        public static final String VIDEO = "video";
        public static final String WBR = "wbr";
        public static final String XML = "xml";

        private Tag() {
        }
    }

    private HTML() {
    }
}
