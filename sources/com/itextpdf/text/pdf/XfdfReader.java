package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public class XfdfReader implements SimpleXMLDocHandler {
    private final Stack<String> fieldNames;
    private final Stack<String> fieldValues;
    HashMap<String, String> fields;
    String fileSpec;
    private boolean foundRoot;
    protected HashMap<String, List<String>> listFields;

    public XfdfReader(String str) throws Throwable {
        this.foundRoot = false;
        this.fieldNames = new Stack<>();
        this.fieldValues = new Stack<>();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                SimpleXMLParser.parse(this, fileInputStream2);
                try {
                    fileInputStream2.close();
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endDocument() {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endElement(String str) {
        if (!str.equals("value")) {
            if (!str.equals("field") || this.fieldNames.isEmpty()) {
                return;
            }
            this.fieldNames.pop();
            return;
        }
        String strSubstring = "";
        for (int i = 0; i < this.fieldNames.size(); i++) {
            strSubstring = strSubstring + "." + this.fieldNames.elementAt(i);
        }
        if (strSubstring.startsWith(".")) {
            strSubstring = strSubstring.substring(1);
        }
        String strPop = this.fieldValues.pop();
        String strPut = this.fields.put(strSubstring, strPop);
        if (strPut != null) {
            List<String> arrayList = this.listFields.get(strSubstring);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                arrayList.add(strPut);
            }
            arrayList.add(strPop);
            this.listFields.put(strSubstring, arrayList);
        }
    }

    public String getField(String str) {
        return this.fields.get(str);
    }

    public String getFieldValue(String str) {
        String str2 = this.fields.get(str);
        if (str2 == null) {
            return null;
        }
        return str2;
    }

    public HashMap<String, String> getFields() {
        return this.fields;
    }

    public String getFileSpec() {
        return this.fileSpec;
    }

    public List<String> getListValues(String str) {
        return this.listFields.get(str);
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startDocument() {
        this.fileSpec = "";
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startElement(String str, Map<String, String> map) {
        if (!this.foundRoot) {
            if (!str.equals("xfdf")) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("root.element.is.not.xfdf.1", str));
            }
            this.foundRoot = true;
        }
        if (str.equals("xfdf")) {
            return;
        }
        if (str.equals("f")) {
            this.fileSpec = map.get("href");
            return;
        }
        if (str.equals("fields")) {
            this.fields = new HashMap<>();
            this.listFields = new HashMap<>();
        } else if (str.equals("field")) {
            this.fieldNames.push(map.get("name"));
        } else if (str.equals("value")) {
            this.fieldValues.push("");
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void text(String str) {
        if (this.fieldNames.isEmpty() || this.fieldValues.isEmpty()) {
            return;
        }
        this.fieldValues.push(this.fieldValues.pop() + str);
    }

    public XfdfReader(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }

    public XfdfReader(InputStream inputStream) throws IOException {
        this.foundRoot = false;
        this.fieldNames = new Stack<>();
        this.fieldValues = new Stack<>();
        SimpleXMLParser.parse(this, inputStream);
    }
}
