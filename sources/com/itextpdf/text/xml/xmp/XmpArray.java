package com.itextpdf.text.xml.xmp;

import com.itextpdf.text.xml.XMLUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class XmpArray extends ArrayList<String> {
    public static final String ALTERNATIVE = "rdf:Alt";
    public static final String ORDERED = "rdf:Seq";
    public static final String UNORDERED = "rdf:Bag";
    private static final long serialVersionUID = 5722854116328732742L;
    protected String type;

    public XmpArray(String str) {
        this.type = str;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("<");
        stringBuffer.append(this.type);
        stringBuffer.append('>');
        for (String str : this) {
            stringBuffer.append("<rdf:li>");
            stringBuffer.append(XMLUtil.escapeXML(str, false));
            stringBuffer.append("</rdf:li>");
        }
        stringBuffer.append("</");
        stringBuffer.append(this.type);
        stringBuffer.append('>');
        return stringBuffer.toString();
    }
}
