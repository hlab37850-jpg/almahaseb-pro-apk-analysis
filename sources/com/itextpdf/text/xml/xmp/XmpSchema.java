package com.itextpdf.text.xml.xmp;

import com.itextpdf.text.xml.XMLUtil;
import java.util.Enumeration;
import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class XmpSchema extends Properties {
    private static final long serialVersionUID = -176374295948945272L;
    protected String xmlns;

    public XmpSchema(String str) {
        this.xmlns = str;
    }

    public static String escape(String str) {
        return XMLUtil.escapeXML(str, false);
    }

    public Object addProperty(String str, String str2) {
        return setProperty(str, str2);
    }

    public String getXmlns() {
        return this.xmlns;
    }

    public void process(StringBuffer stringBuffer, Object obj) {
        stringBuffer.append('<');
        stringBuffer.append(obj);
        stringBuffer.append('>');
        stringBuffer.append(get(obj));
        stringBuffer.append("</");
        stringBuffer.append(obj);
        stringBuffer.append('>');
    }

    @Override // java.util.Properties
    public Object setProperty(String str, String str2) {
        return super.setProperty(str, XMLUtil.escapeXML(str2, false));
    }

    @Override // java.util.Hashtable
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration<?> enumerationPropertyNames = propertyNames();
        while (enumerationPropertyNames.hasMoreElements()) {
            process(stringBuffer, enumerationPropertyNames.nextElement());
        }
        return stringBuffer.toString();
    }

    public Object setProperty(String str, XmpArray xmpArray) {
        return super.setProperty(str, xmpArray.toString());
    }

    public Object setProperty(String str, LangAlt langAlt) {
        return super.setProperty(str, langAlt.toString());
    }
}
