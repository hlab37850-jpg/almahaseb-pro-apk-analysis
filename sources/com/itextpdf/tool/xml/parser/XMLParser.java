package com.itextpdf.tool.xml.parser;

import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.text.xml.simpleparser.IanaEncodings;
import com.itextpdf.text.xml.xmp.XmpWriter;
import com.itextpdf.tool.xml.parser.io.EncodingUtil;
import com.itextpdf.tool.xml.parser.io.MonitorInputReader;
import com.itextpdf.tool.xml.parser.io.ParserMonitor;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class XMLParser {
    private Charset charset;
    private final StateController controller;
    private final List<XMLParserListener> listeners;
    private final XMLParserMemory memory;
    private ParserMonitor monitor;
    private State state;
    private TagState tagState;
    private String text;

    public XMLParser() {
        this(true, Charset.defaultCharset());
    }

    private void callText() {
        String str = this.text;
        if (str == null || str.length() <= 0) {
            return;
        }
        Iterator<XMLParserListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().text(this.text);
        }
        this.text = null;
    }

    private void parseWithReader(Reader reader) throws IOException {
        Iterator<XMLParserListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().init();
        }
        if (this.monitor != null) {
            reader = new MonitorInputReader(reader, this.monitor);
        }
        char[] cArr = new char[1];
        while (-1 != reader.read(cArr)) {
            try {
                this.state.process(cArr[0]);
            } catch (Throwable th) {
                Iterator<XMLParserListener> it2 = this.listeners.iterator();
                while (it2.hasNext()) {
                    it2.next().close();
                }
                reader.close();
                throw th;
            }
        }
        Iterator<XMLParserListener> it3 = this.listeners.iterator();
        while (it3.hasNext()) {
            it3.next().close();
        }
        reader.close();
    }

    public XMLParser addListener(XMLParserListener xMLParserListener) {
        this.listeners.add(xMLParserListener);
        return this;
    }

    public XMLParser append(char c) {
        this.memory.current().append(c);
        return this;
    }

    public int bufferSize() {
        if (this.memory.current() != null) {
            return this.memory.current().length();
        }
        return 0;
    }

    public String bufferToString() {
        return this.memory.current().toString();
    }

    public void comment() {
        callText();
        Iterator<XMLParserListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().comment(this.memory.current().toString());
        }
    }

    public String current() {
        return this.memory.current().toString();
    }

    public char currentLastChar() {
        StringBuilder sbCurrent = this.memory.current();
        int length = sbCurrent.length();
        CharSequence charSequenceSubSequence = sbCurrent.subSequence(length - 2, length - 1);
        if (charSequenceSubSequence.length() > 0) {
            return (char) (charSequenceSubSequence.length() - 1);
        }
        return ' ';
    }

    public String currentTag() {
        return this.memory.getCurrentTag();
    }

    public TagState currentTagState() {
        return this.tagState;
    }

    public InputStreamReader detectEncoding(InputStream inputStream) throws IOException {
        String str;
        String declaredEncoding;
        inputStream.mark(1028);
        byte[] bArr = new byte[4];
        if (inputStream.read(bArr) != 4) {
            throw new IOException("Insufficient length");
        }
        String encodingName = XMLUtil.getEncodingName(bArr);
        if (encodingName.equals(XmpWriter.UTF8)) {
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                int i = inputStream.read();
                if (i == -1 || i == 62) {
                    break;
                }
                stringBuffer.append((char) i);
            }
            str = stringBuffer.toString();
        } else if (encodingName.equals("CP037")) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i2 = inputStream.read();
                if (i2 == -1 || i2 == 110) {
                    break;
                }
                byteArrayOutputStream.write(i2);
            }
            str = new String(byteArrayOutputStream.toByteArray(), "CP037");
        } else {
            str = null;
        }
        if (str != null && (declaredEncoding = EncodingUtil.getDeclaredEncoding(str)) != null) {
            encodingName = declaredEncoding;
        }
        inputStream.reset();
        return new InputStreamReader(inputStream, IanaEncodings.getJavaEncoding(encodingName));
    }

    public void endElement() {
        currentTagState(TagState.CLOSE);
        callText();
        Iterator<XMLParserListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().endElement(this.memory.getCurrentTag(), this.memory.getNameSpace());
        }
    }

    public void flush() {
        this.memory.resetBuffer();
    }

    public Charset getCharset() {
        return this.charset;
    }

    public XMLParserMemory memory() {
        return this.memory;
    }

    public void parse(InputStream inputStream) throws IOException {
        parse(new InputStreamReader(inputStream));
    }

    public XMLParser removeListener(XMLParserListener xMLParserListener) {
        this.listeners.remove(xMLParserListener);
        return this;
    }

    public StateController selectState() {
        return this.controller;
    }

    public void setMonitor(ParserMonitor parserMonitor) {
        this.monitor = parserMonitor;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void startElement() {
        currentTagState(TagState.OPEN);
        callText();
        Iterator<XMLParserListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().startElement(this.memory.getCurrentTag(), this.memory.getAttributes(), this.memory.getNameSpace());
        }
        memory().flushNameSpace();
    }

    public void text(String str) {
        this.text = str;
    }

    public void unknownData() {
        Iterator<XMLParserListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().unknownText(this.memory.current().toString());
        }
    }

    public XMLParser(boolean z, Charset charset) {
        this.text = null;
        this.charset = charset;
        StateController stateController = new StateController(this, z);
        this.controller = stateController;
        stateController.unknown();
        this.memory = new XMLParserMemory(z);
        this.listeners = new CopyOnWriteArrayList();
    }

    private void currentTagState(TagState tagState) {
        this.tagState = tagState;
    }

    public XMLParser append(char[] cArr) {
        this.memory.current().append(cArr);
        return this;
    }

    public void parse(InputStream inputStream, boolean z) throws IOException {
        if (z) {
            parse(detectEncoding(new BufferedInputStream(inputStream)));
        } else {
            parse(inputStream);
        }
    }

    public XMLParser append(String str) {
        this.memory.current().append(str);
        return this;
    }

    public void parse(InputStream inputStream, Charset charset) throws IOException {
        this.charset = charset;
        parse(new InputStreamReader(inputStream, charset));
    }

    public void parse(Reader reader) throws IOException {
        parseWithReader(reader);
    }

    public XMLParser(XMLParserListener xMLParserListener, Charset charset) {
        this(true, charset);
        this.listeners.add(xMLParserListener);
    }

    public XMLParser(boolean z, XMLParserListener xMLParserListener, Charset charset) {
        this(z, charset);
        this.listeners.add(xMLParserListener);
    }

    public XMLParser(boolean z, XMLParserListener xMLParserListener) {
        this(z, Charset.defaultCharset());
        this.listeners.add(xMLParserListener);
    }

    public XMLParser(XMLParserListener xMLParserListener) {
        this(true, Charset.defaultCharset());
        this.listeners.add(xMLParserListener);
    }
}
