package com.itextpdf.tool.xml.parser.io;

import java.io.BufferedReader;
import java.io.Reader;

/* JADX INFO: loaded from: classes3.dex */
public class MonitorInputReader extends BufferedReader {
    private final ParserMonitor monitor;

    public MonitorInputReader(Reader reader, ParserMonitor parserMonitor) {
        super(reader);
        this.monitor = parserMonitor;
    }

    @Override // java.io.Reader
    public int read(char[] cArr) {
        int i = super.read(cArr);
        this.monitor.read(cArr);
        return i;
    }
}
