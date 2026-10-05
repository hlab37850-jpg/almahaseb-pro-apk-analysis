package com.itextpdf.text.pdf.fonts.otf;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OpenTypeFontTableReader {
    protected static final Logger LOG = LoggerFactory.getLogger((Class<?>) OpenTypeFontTableReader.class);
    protected final RandomAccessFileOrArray rf;
    private List<String> supportedLanguages;
    protected final int tableLocation;

    public OpenTypeFontTableReader(RandomAccessFileOrArray randomAccessFileOrArray, int i) {
        this.rf = randomAccessFileOrArray;
        this.tableLocation = i;
    }

    private void readFeatureListTable(int i) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        LOG.debug("featureCount=" + ((int) s));
        LinkedHashMap linkedHashMap = new LinkedHashMap(s);
        for (int i2 = 0; i2 < s; i2++) {
            linkedHashMap.put(this.rf.readString(4, "utf-8"), Short.valueOf(this.rf.readShort()));
        }
        for (String str : linkedHashMap.keySet()) {
            LOG.debug("*************featureName=" + str);
            readFeatureTable(((Short) linkedHashMap.get(str)).shortValue() + i);
        }
    }

    private void readFeatureTable(int i) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        Logger logger = LOG;
        logger.debug("featureParamsOffset=" + ((int) s));
        short s2 = this.rf.readShort();
        logger.debug("lookupCount=" + ((int) s2));
        ArrayList arrayList = new ArrayList(s2);
        for (int i2 = 0; i2 < s2; i2++) {
            arrayList.add(Short.valueOf(this.rf.readShort()));
        }
    }

    private TableHeader readHeader() {
        this.rf.seek(this.tableLocation);
        return new TableHeader(this.rf.readInt(), this.rf.readUnsignedShort(), this.rf.readUnsignedShort(), this.rf.readUnsignedShort());
    }

    private void readLangSysRecord(Map<String, Integer> map) {
        map.put(this.rf.readString(4, "utf-8"), Integer.valueOf(this.rf.readShort()));
    }

    private void readLangSysTable(int i) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        Logger logger = LOG;
        logger.debug("lookupOrderOffset=" + ((int) s));
        logger.debug("reqFeatureIndex=" + ((int) this.rf.readShort()));
        short s2 = this.rf.readShort();
        ArrayList arrayList = new ArrayList(s2);
        for (int i2 = 0; i2 < s2; i2++) {
            arrayList.add(Short.valueOf(this.rf.readShort()));
        }
        LOG.debug("featureListIndices=" + arrayList);
    }

    private void readLookupListTable(int i) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < s; i2++) {
            arrayList.add(Integer.valueOf(this.rf.readShort()));
        }
        for (int i3 = 0; i3 < s; i3++) {
            readLookupTable(((Integer) arrayList.get(i3)).intValue() + i);
        }
    }

    private void readLookupTable(int i) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        this.rf.skipBytes(2);
        short s2 = this.rf.readShort();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < s2; i2++) {
            arrayList.add(Integer.valueOf(this.rf.readShort()));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            readSubTable(s, ((Integer) it.next()).intValue() + i);
        }
    }

    private void readRangeRecord(List<Integer> list) throws EOFException {
        short s = this.rf.readShort();
        this.rf.readShort();
        for (int i = this.rf.readShort(); i <= s; i++) {
            list.add(Integer.valueOf(i));
        }
    }

    private void readScriptListTable(int i) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        HashMap map = new HashMap(s);
        for (int i2 = 0; i2 < s; i2++) {
            readScriptRecord(i, map);
        }
        ArrayList arrayList = new ArrayList(s);
        for (String str : map.keySet()) {
            readScriptTable(map.get(str).intValue());
            arrayList.add(str);
        }
        this.supportedLanguages = Collections.unmodifiableList(arrayList);
    }

    private void readScriptRecord(int i, Map<String, Integer> map) {
        map.put(this.rf.readString(4, "utf-8"), Integer.valueOf(i + this.rf.readShort()));
    }

    private void readScriptTable(int i) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        short s2 = this.rf.readShort();
        if (s2 > 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(s2);
            for (int i2 = 0; i2 < s2; i2++) {
                readLangSysRecord(linkedHashMap);
            }
            Iterator<String> it = linkedHashMap.keySet().iterator();
            while (it.hasNext()) {
                readLangSysTable(linkedHashMap.get(it.next()).intValue() + i);
            }
        }
        readLangSysTable(i + s);
    }

    public Language getSupportedLanguage() throws FontReadingException {
        Language[] languageArrValues = Language.values();
        for (String str : this.supportedLanguages) {
            for (Language language : languageArrValues) {
                if (language.isSupported(str)) {
                    return language;
                }
            }
        }
        throw new FontReadingException("Unsupported languages " + this.supportedLanguages);
    }

    public final List<Integer> readCoverageFormat(int i) throws EOFException {
        ArrayList arrayList;
        this.rf.seek(i);
        short s = this.rf.readShort();
        int i2 = 0;
        if (s == 1) {
            short s2 = this.rf.readShort();
            arrayList = new ArrayList(s2);
            while (i2 < s2) {
                arrayList.add(Integer.valueOf(this.rf.readShort()));
                i2++;
            }
        } else {
            if (s != 2) {
                throw new UnsupportedOperationException("Invalid coverage format: " + ((int) s));
            }
            short s3 = this.rf.readShort();
            arrayList = new ArrayList();
            while (i2 < s3) {
                readRangeRecord(arrayList);
                i2++;
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public abstract void readSubTable(int i, int i2);

    public final void startReadingTable() throws FontReadingException {
        try {
            TableHeader header = readHeader();
            readScriptListTable(this.tableLocation + header.scriptListOffset);
            readFeatureListTable(this.tableLocation + header.featureListOffset);
            readLookupListTable(this.tableLocation + header.lookupListOffset);
        } catch (IOException e) {
            throw new FontReadingException("Error reading font file", e);
        }
    }
}
