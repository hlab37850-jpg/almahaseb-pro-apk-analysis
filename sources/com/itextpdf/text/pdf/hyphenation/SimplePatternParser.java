package com.itextpdf.text.pdf.hyphenation;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
public class SimplePatternParser implements SimpleXMLDocHandler, PatternConsumer {
    static final int ELEM_CLASSES = 1;
    static final int ELEM_EXCEPTIONS = 2;
    static final int ELEM_HYPHEN = 4;
    static final int ELEM_PATTERNS = 3;
    PatternConsumer consumer;
    int currElement;
    ArrayList<Object> exception;
    SimpleXMLParser parser;
    StringBuffer token = new StringBuffer();
    char hyphenChar = '-';

    public static String getInterletterValues(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = str + "a";
        int length = str2.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str2.charAt(i);
            if (Character.isDigit(cCharAt)) {
                stringBuffer.append(cCharAt);
                i++;
            } else {
                stringBuffer.append('0');
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static String getPattern(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.itextpdf.text.pdf.hyphenation.PatternConsumer
    public void addClass(String str) {
        System.out.println("class: " + str);
    }

    @Override // com.itextpdf.text.pdf.hyphenation.PatternConsumer
    public void addException(String str, ArrayList<Object> arrayList) {
        System.out.println("exception: " + str + " : " + arrayList.toString());
    }

    @Override // com.itextpdf.text.pdf.hyphenation.PatternConsumer
    public void addPattern(String str, String str2) {
        System.out.println("pattern: " + str + " : " + str2);
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endDocument() {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endElement(String str) {
        if (this.token.length() > 0) {
            String string = this.token.toString();
            int i = this.currElement;
            if (i == 1) {
                this.consumer.addClass(string);
            } else if (i == 2) {
                this.exception.add(string);
                ArrayList<Object> arrayListNormalizeException = normalizeException(this.exception);
                this.exception = arrayListNormalizeException;
                this.consumer.addException(getExceptionWord(arrayListNormalizeException), (ArrayList) this.exception.clone());
            } else if (i == 3) {
                this.consumer.addPattern(getPattern(string), getInterletterValues(string));
            }
            if (this.currElement != 4) {
                this.token.setLength(0);
            }
        }
        if (this.currElement == 4) {
            this.currElement = 2;
        } else {
            this.currElement = 0;
        }
    }

    public String getExceptionWord(ArrayList<Object> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof String) {
                stringBuffer.append((String) obj);
            } else {
                String str = ((Hyphen) obj).noBreak;
                if (str != null) {
                    stringBuffer.append(str);
                }
            }
        }
        return stringBuffer.toString();
    }

    public ArrayList<Object> normalizeException(ArrayList<Object> arrayList) {
        ArrayList<Object> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof String) {
                String str = (String) obj;
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char cCharAt = str.charAt(i2);
                    if (cCharAt != this.hyphenChar) {
                        stringBuffer.append(cCharAt);
                    } else {
                        arrayList2.add(stringBuffer.toString());
                        stringBuffer.setLength(0);
                        arrayList2.add(new Hyphen(new String(new char[]{this.hyphenChar}), null, null));
                    }
                }
                if (stringBuffer.length() > 0) {
                    arrayList2.add(stringBuffer.toString());
                }
            } else {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public void parse(InputStream inputStream, PatternConsumer patternConsumer) {
        this.consumer = patternConsumer;
        try {
            try {
                SimpleXMLParser.parse(this, inputStream);
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startDocument() {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startElement(String str, Map<String, String> map) {
        if (str.equals("hyphen-char")) {
            String str2 = map.get("value");
            if (str2 != null && str2.length() == 1) {
                this.hyphenChar = str2.charAt(0);
            }
        } else if (str.equals("classes")) {
            this.currElement = 1;
        } else if (str.equals("patterns")) {
            this.currElement = 3;
        } else if (str.equals("exceptions")) {
            this.currElement = 2;
            this.exception = new ArrayList<>();
        } else if (str.equals("hyphen")) {
            if (this.token.length() > 0) {
                this.exception.add(this.token.toString());
            }
            this.exception.add(new Hyphen(map.get("pre"), map.get("no"), map.get("post")));
            this.currElement = 4;
        }
        this.token.setLength(0);
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void text(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            int i = this.currElement;
            if (i == 1) {
                this.consumer.addClass(strNextToken);
            } else if (i == 2) {
                this.exception.add(strNextToken);
                ArrayList<Object> arrayListNormalizeException = normalizeException(this.exception);
                this.exception = arrayListNormalizeException;
                this.consumer.addException(getExceptionWord(arrayListNormalizeException), (ArrayList) this.exception.clone());
                this.exception.clear();
            } else if (i == 3) {
                this.consumer.addPattern(getPattern(strNextToken), getInterletterValues(strNextToken));
            }
        }
    }
}
