package com.itextpdf.text.xml.simpleparser;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.text.xml.simpleparser.handler.HTMLNewLineHandler;
import com.itextpdf.text.xml.simpleparser.handler.NeverNewLineHandler;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public final class SimpleXMLParser {
    private static final int ATTRIBUTE_EQUAL = 13;
    private static final int ATTRIBUTE_KEY = 12;
    private static final int ATTRIBUTE_VALUE = 14;
    private static final int CDATA = 7;
    private static final int COMMENT = 8;
    private static final int ENTITY = 10;
    private static final int EXAMIN_TAG = 3;
    private static final int IN_CLOSETAG = 5;
    private static final int PI = 9;
    private static final int QUOTE = 11;
    private static final int SINGLE_TAG = 6;
    private static final int TAG_ENCOUNTERED = 2;
    private static final int TAG_EXAMINED = 4;
    private static final int TEXT = 1;
    private static final int UNKNOWN = 0;
    private final SimpleXMLDocHandlerComment comment;
    private final SimpleXMLDocHandler doc;
    private final boolean html;
    private NewLineHandler newLineHandler;
    private final Stack<Integer> stack;
    private int state;
    private int character = 0;
    private int previousCharacter = -1;
    private int lines = 1;
    private int columns = 0;
    private boolean eol = false;
    private boolean nowhite = false;
    private final StringBuffer text = new StringBuffer();
    private final StringBuffer entity = new StringBuffer();
    private String tag = null;
    private HashMap<String, String> attributes = null;
    private int nested = 0;
    private int quoteCharacter = 34;
    private String attributekey = null;
    private String attributevalue = null;

    private SimpleXMLParser(SimpleXMLDocHandler simpleXMLDocHandler, SimpleXMLDocHandlerComment simpleXMLDocHandlerComment, boolean z) {
        this.doc = simpleXMLDocHandler;
        this.comment = simpleXMLDocHandlerComment;
        this.html = z;
        if (z) {
            this.newLineHandler = new HTMLNewLineHandler();
        } else {
            this.newLineHandler = new NeverNewLineHandler();
        }
        this.stack = new Stack<>();
        this.state = z ? 1 : 0;
    }

    private void doTag() {
        if (this.tag == null) {
            this.tag = this.text.toString();
        }
        if (this.html) {
            this.tag = this.tag.toLowerCase();
        }
        this.text.setLength(0);
    }

    @Deprecated
    public static String escapeXML(String str, boolean z) {
        return XMLUtil.escapeXML(str, z);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003a  */
    /* JADX WARN: Code duplicated, block: B:22:0x004a  */
    /* JADX WARN: Code duplicated, block: B:24:0x0052  */
    private void flush() {
        int i = this.state;
        if (i == 1) {
            if (this.text.length() > 0) {
                this.doc.text(this.text.toString());
            }
        } else if (i == 14) {
            String string = this.text.toString();
            this.attributevalue = string;
            this.attributes.put(this.attributekey, string);
        } else if (i != 7) {
            if (i == 8) {
                SimpleXMLDocHandlerComment simpleXMLDocHandlerComment = this.comment;
                if (simpleXMLDocHandlerComment != null) {
                    simpleXMLDocHandlerComment.comment(this.text.toString());
                }
            } else if (i == 11) {
                String string2 = this.text.toString();
                this.attributevalue = string2;
                this.attributes.put(this.attributekey, string2);
            } else if (i == 12) {
                String string3 = this.text.toString();
                this.attributekey = string3;
                if (this.html) {
                    this.attributekey = string3.toLowerCase();
                }
            }
        } else if (this.text.length() > 0) {
            this.doc.text(this.text.toString());
        }
        this.text.setLength(0);
    }

    private static String getDeclaredEncoding(String str) {
        int iIndexOf;
        int iIndexOf2;
        int iIndexOf3;
        int i;
        int iIndexOf4;
        if (str == null || (iIndexOf = str.indexOf(HtmlTags.ENCODING)) < 0 || (iIndexOf2 = str.indexOf(34, iIndexOf)) == (iIndexOf3 = str.indexOf(39, iIndexOf))) {
            return null;
        }
        if ((iIndexOf2 < 0 && iIndexOf3 > 0) || (iIndexOf3 > 0 && iIndexOf3 < iIndexOf2)) {
            int i2 = iIndexOf3 + 1;
            int iIndexOf5 = str.indexOf(39, i2);
            if (iIndexOf5 < 0) {
                return null;
            }
            return str.substring(i2, iIndexOf5);
        }
        if (((iIndexOf3 >= 0 || iIndexOf2 <= 0) && (iIndexOf2 <= 0 || iIndexOf2 >= iIndexOf3)) || (iIndexOf4 = str.indexOf(34, (i = iIndexOf2 + 1))) < 0) {
            return null;
        }
        return str.substring(i, iIndexOf4);
    }

    private void go(Reader reader) throws IOException {
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
        this.doc.startDocument();
        while (true) {
            int i = this.previousCharacter;
            if (i == -1) {
                this.character = bufferedReader.read();
            } else {
                this.character = i;
                this.previousCharacter = -1;
            }
            int i2 = this.character;
            if (i2 == -1) {
                boolean z = this.html;
                if (!z) {
                    throwException(MessageLocalization.getComposedMessage("missing.end.tag", new Object[0]));
                    return;
                }
                if (z && this.state == 1) {
                    flush();
                }
                this.doc.endDocument();
                return;
            }
            if (i2 != 10 || !this.eol) {
                if (this.eol) {
                    this.eol = false;
                } else if (i2 == 10) {
                    this.lines++;
                    this.columns = 0;
                } else if (i2 == 13) {
                    this.eol = true;
                    this.character = 10;
                    this.lines++;
                    this.columns = 0;
                } else {
                    this.columns++;
                }
                int i3 = this.state;
                switch (i3) {
                    case 0:
                        if (this.character == 60) {
                            saveState(1);
                            this.state = 2;
                        }
                        break;
                    case 1:
                        int i4 = this.character;
                        if (i4 == 60) {
                            flush();
                            saveState(this.state);
                            this.state = 2;
                        } else if (i4 == 38) {
                            saveState(i3);
                            this.entity.setLength(0);
                            this.state = 10;
                            this.nowhite = true;
                        } else if (i4 != 32) {
                            if (!Character.isWhitespace((char) i4)) {
                                this.text.append((char) this.character);
                                this.nowhite = true;
                            } else if (!this.html) {
                                if (this.nowhite) {
                                    this.text.append((char) this.character);
                                }
                                this.nowhite = false;
                            }
                        } else if (this.html && this.nowhite) {
                            this.text.append(' ');
                            this.nowhite = false;
                        } else {
                            if (this.nowhite) {
                                this.text.append((char) i4);
                            }
                            this.nowhite = false;
                        }
                        break;
                    case 2:
                        initTag();
                        int i5 = this.character;
                        if (i5 == 47) {
                            this.state = 5;
                        } else if (i5 != 63) {
                            this.text.append((char) i5);
                            this.state = 3;
                        } else {
                            restoreState();
                            this.state = 9;
                        }
                        break;
                    case 3:
                        int i6 = this.character;
                        if (i6 == 62) {
                            doTag();
                            processTag(true);
                            initTag();
                            this.state = restoreState();
                        } else if (i6 == 47) {
                            this.state = 6;
                        } else if (i6 == 45 && this.text.toString().equals("!-")) {
                            flush();
                            this.state = 8;
                        } else if (this.character == 91 && this.text.toString().equals("![CDATA")) {
                            flush();
                            this.state = 7;
                        } else if (this.character == 69 && this.text.toString().equals("!DOCTYP")) {
                            flush();
                            this.state = 9;
                        } else if (!Character.isWhitespace((char) this.character)) {
                            this.text.append((char) this.character);
                        } else {
                            doTag();
                            this.state = 4;
                        }
                        break;
                    case 4:
                        int i7 = this.character;
                        if (i7 == 62) {
                            processTag(true);
                            initTag();
                            this.state = restoreState();
                        } else if (i7 == 47) {
                            this.state = 6;
                        } else if (!Character.isWhitespace((char) i7)) {
                            this.text.append((char) this.character);
                            this.state = 12;
                        }
                        break;
                    case 5:
                        int i8 = this.character;
                        if (i8 == 62) {
                            doTag();
                            processTag(false);
                            if (!this.html && this.nested == 0) {
                                return;
                            } else {
                                this.state = restoreState();
                            }
                        } else if (!Character.isWhitespace((char) i8)) {
                            this.text.append((char) this.character);
                        }
                        break;
                    case 6:
                        if (this.character != 62) {
                            throwException(MessageLocalization.getComposedMessage("expected.gt.for.tag.lt.1.gt", this.tag));
                        }
                        doTag();
                        processTag(true);
                        processTag(false);
                        initTag();
                        if (!this.html && this.nested == 0) {
                            this.doc.endDocument();
                            return;
                        }
                        this.state = restoreState();
                        break;
                    case 7:
                        if (this.character == 62 && this.text.toString().endsWith("]]")) {
                            StringBuffer stringBuffer = this.text;
                            stringBuffer.setLength(stringBuffer.length() - 2);
                            flush();
                            this.state = restoreState();
                        } else {
                            this.text.append((char) this.character);
                        }
                        break;
                    case 8:
                        if (this.character == 62 && this.text.toString().endsWith("--")) {
                            StringBuffer stringBuffer2 = this.text;
                            stringBuffer2.setLength(stringBuffer2.length() - 2);
                            flush();
                            this.state = restoreState();
                        } else {
                            this.text.append((char) this.character);
                        }
                        break;
                    case 9:
                        if (this.character == 62) {
                            int iRestoreState = restoreState();
                            this.state = iRestoreState;
                            if (iRestoreState == 1) {
                                this.state = 0;
                            }
                        }
                        break;
                    case 10:
                        int i9 = this.character;
                        if (i9 == 59) {
                            this.state = restoreState();
                            String string = this.entity.toString();
                            this.entity.setLength(0);
                            char cDecodeEntity = EntitiesToUnicode.decodeEntity(string);
                            if (cDecodeEntity != 0) {
                                this.text.append(cDecodeEntity);
                            } else {
                                StringBuffer stringBuffer3 = this.text;
                                stringBuffer3.append('&');
                                stringBuffer3.append(string);
                                stringBuffer3.append(';');
                            }
                        } else if ((i9 != 35 && ((i9 < 48 || i9 > 57) && ((i9 < 97 || i9 > 122) && (i9 < 65 || i9 > 90)))) || this.entity.length() >= 7) {
                            this.state = restoreState();
                            this.previousCharacter = this.character;
                            StringBuffer stringBuffer4 = this.text;
                            stringBuffer4.append('&');
                            stringBuffer4.append(this.entity.toString());
                            this.entity.setLength(0);
                        } else {
                            this.entity.append((char) this.character);
                        }
                        break;
                    case 11:
                        boolean z2 = this.html;
                        if (z2 && this.quoteCharacter == 32 && this.character == 62) {
                            flush();
                            processTag(true);
                            initTag();
                            this.state = restoreState();
                        } else if (z2 && this.quoteCharacter == 32 && Character.isWhitespace((char) this.character)) {
                            flush();
                            this.state = 4;
                        } else if (this.html && this.quoteCharacter == 32) {
                            this.text.append((char) this.character);
                        } else {
                            int i10 = this.character;
                            if (i10 == this.quoteCharacter) {
                                flush();
                                this.state = 4;
                            } else if (" \r\n\t".indexOf(i10) < 0) {
                                int i11 = this.character;
                                if (i11 != 38) {
                                    this.text.append((char) i11);
                                } else {
                                    saveState(this.state);
                                    this.state = 10;
                                    this.entity.setLength(0);
                                }
                            } else {
                                this.text.append(' ');
                            }
                        }
                        break;
                    case 12:
                        if (!Character.isWhitespace((char) this.character)) {
                            int i12 = this.character;
                            if (i12 == 61) {
                                flush();
                                this.state = 14;
                            } else if (this.html && i12 == 62) {
                                this.text.setLength(0);
                                processTag(true);
                                initTag();
                                this.state = restoreState();
                            } else {
                                this.text.append((char) i12);
                            }
                        } else {
                            flush();
                            this.state = 13;
                        }
                        break;
                    case 13:
                        int i13 = this.character;
                        if (i13 == 61) {
                            this.state = 14;
                        } else if (!Character.isWhitespace((char) i13)) {
                            boolean z3 = this.html;
                            if (z3 && this.character == 62) {
                                this.text.setLength(0);
                                processTag(true);
                                initTag();
                                this.state = restoreState();
                            } else if (z3 && this.character == 47) {
                                flush();
                                this.state = 6;
                            } else if (!z3) {
                                throwException(MessageLocalization.getComposedMessage("error.in.attribute.processing", new Object[0]));
                            } else {
                                flush();
                                this.text.append((char) this.character);
                                this.state = 12;
                            }
                        }
                        break;
                    case 14:
                        int i14 = this.character;
                        if (i14 == 34 || i14 == 39) {
                            this.quoteCharacter = i14;
                            this.state = 11;
                        } else if (!Character.isWhitespace((char) i14)) {
                            boolean z4 = this.html;
                            if (z4 && this.character == 62) {
                                flush();
                                processTag(true);
                                initTag();
                                this.state = restoreState();
                            } else if (!z4) {
                                throwException(MessageLocalization.getComposedMessage("error.in.attribute.processing", new Object[0]));
                            } else {
                                this.text.append((char) this.character);
                                this.quoteCharacter = 32;
                                this.state = 11;
                            }
                        }
                        break;
                }
            } else {
                this.eol = false;
            }
        }
    }

    private void initTag() {
        this.tag = null;
        this.attributes = new HashMap<>();
    }

    public static void parse(SimpleXMLDocHandler simpleXMLDocHandler, SimpleXMLDocHandlerComment simpleXMLDocHandlerComment, Reader reader, boolean z) throws IOException {
        new SimpleXMLParser(simpleXMLDocHandler, simpleXMLDocHandlerComment, z).go(reader);
    }

    private void processTag(boolean z) {
        if (z) {
            this.nested++;
            this.doc.startElement(this.tag, this.attributes);
        } else {
            if (this.newLineHandler.isNewLineTag(this.tag)) {
                this.nowhite = false;
            }
            this.nested--;
            this.doc.endElement(this.tag);
        }
    }

    private int restoreState() {
        if (this.stack.empty()) {
            return 0;
        }
        return this.stack.pop().intValue();
    }

    private void saveState(int i) {
        this.stack.push(Integer.valueOf(i));
    }

    private void throwException(String str) throws IOException {
        throw new IOException(MessageLocalization.getComposedMessage("1.near.line.2.column.3", str, String.valueOf(this.lines), String.valueOf(this.columns)));
    }

    public static void parse(SimpleXMLDocHandler simpleXMLDocHandler, InputStream inputStream) throws IOException {
        String str;
        String declaredEncoding;
        byte[] bArr = new byte[4];
        if (inputStream.read(bArr) == 4) {
            String encodingName = XMLUtil.getEncodingName(bArr);
            if (encodingName.equals(XmpWriter.UTF8)) {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int i = inputStream.read();
                    if (i == -1 || i == 62) {
                        break;
                    } else {
                        stringBuffer.append((char) i);
                    }
                }
                str = stringBuffer.toString();
            } else if (encodingName.equals("CP037")) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int i2 = inputStream.read();
                    if (i2 == -1 || i2 == 110) {
                        break;
                    } else {
                        byteArrayOutputStream.write(i2);
                    }
                }
                str = new String(byteArrayOutputStream.toByteArray(), "CP037");
            } else {
                str = null;
            }
            if (str != null && (declaredEncoding = getDeclaredEncoding(str)) != null) {
                encodingName = declaredEncoding;
            }
            parse(simpleXMLDocHandler, new InputStreamReader(inputStream, IanaEncodings.getJavaEncoding(encodingName)));
            return;
        }
        throw new IOException(MessageLocalization.getComposedMessage("insufficient.length", new Object[0]));
    }

    public static void parse(SimpleXMLDocHandler simpleXMLDocHandler, Reader reader) throws IOException {
        parse(simpleXMLDocHandler, null, reader, false);
    }
}
