package com.itextpdf.text.pdf.fonts.otf;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.pdf.Glyph;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class GlyphSubstitutionTableReader extends OpenTypeFontTableReader {
    private final Map<Integer, Character> glyphToCharacterMap;
    private final int[] glyphWidthsByIndex;
    private Map<Integer, List<Integer>> rawLigatureSubstitutionMap;

    public GlyphSubstitutionTableReader(RandomAccessFileOrArray randomAccessFileOrArray, int i, Map<Integer, Character> map, int[] iArr) {
        super(randomAccessFileOrArray, i);
        this.glyphWidthsByIndex = iArr;
        this.glyphToCharacterMap = map;
    }

    private String getTextFromGlyph(int i, Map<Integer, Character> map) throws FontReadingException {
        StringBuilder sb = new StringBuilder(1);
        Character ch = map.get(Integer.valueOf(i));
        if (ch == null) {
            List<Integer> list = this.rawLigatureSubstitutionMap.get(Integer.valueOf(i));
            if (list == null || list.isEmpty()) {
                throw new FontReadingException("No corresponding character or simple glyphs found for GlyphID=" + i);
            }
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                sb.append(getTextFromGlyph(it.next().intValue(), map));
            }
        } else {
            sb.append(ch.charValue());
        }
        return sb.toString();
    }

    private void readLigatureSetTable(int i, int i2) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        OpenTypeFontTableReader.LOG.debug("ligatureCount=" + ((int) s));
        ArrayList arrayList = new ArrayList(s);
        for (int i3 = 0; i3 < s; i3++) {
            arrayList.add(Integer.valueOf(this.rf.readShort()));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            readLigatureTable(((Integer) it.next()).intValue() + i, i2);
        }
    }

    private void readLigatureSubstitutionSubtable(int i) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        Logger logger = OpenTypeFontTableReader.LOG;
        logger.debug("substFormat=" + ((int) s));
        if (s != 1) {
            throw new IllegalArgumentException("The expected SubstFormat is 1");
        }
        short s2 = this.rf.readShort();
        logger.debug("coverage=" + ((int) s2));
        short s3 = this.rf.readShort();
        ArrayList arrayList = new ArrayList(s3);
        for (int i2 = 0; i2 < s3; i2++) {
            arrayList.add(Integer.valueOf(this.rf.readShort()));
        }
        List<Integer> coverageFormat = readCoverageFormat(s2 + i);
        if (s3 != coverageFormat.size()) {
            throw new IllegalArgumentException("According to the OpenTypeFont specifications, the coverage count should be equal to the no. of LigatureSetTables");
        }
        for (int i3 = 0; i3 < s3; i3++) {
            int iIntValue = coverageFormat.get(i3).intValue();
            int iIntValue2 = ((Integer) arrayList.get(i3)).intValue();
            OpenTypeFontTableReader.LOG.debug("ligatureOffset=" + iIntValue2);
            readLigatureSetTable(iIntValue2 + i, iIntValue);
        }
    }

    private void readLigatureTable(int i, int i2) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        OpenTypeFontTableReader.LOG.debug("ligGlyph=" + ((int) s));
        short s2 = this.rf.readShort();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i2));
        for (int i3 = 0; i3 < s2 - 1; i3++) {
            arrayList.add(Integer.valueOf(this.rf.readShort()));
        }
        Logger logger = OpenTypeFontTableReader.LOG;
        logger.debug("glyphIdList=" + arrayList);
        List<Integer> listPut = this.rawLigatureSubstitutionMap.put(Integer.valueOf(s), arrayList);
        if (listPut != null) {
            logger.warn("!!!!!!!!!!glyphId=" + ((int) s) + ",\npreviousValue=" + listPut + ",\ncurrentVal=" + arrayList);
        }
    }

    private void readSingleSubstitutionSubtable(int i) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        Logger logger = OpenTypeFontTableReader.LOG;
        logger.debug("substFormat=" + ((int) s));
        if (s == 1) {
            short s2 = this.rf.readShort();
            logger.debug("coverage=" + ((int) s2));
            short s3 = this.rf.readShort();
            logger.debug("deltaGlyphID=" + ((int) s3));
            for (Integer num : readCoverageFormat(i + s2)) {
                this.rawLigatureSubstitutionMap.put(Integer.valueOf(num.intValue() + s3), Arrays.asList(num));
            }
            return;
        }
        if (s != 2) {
            throw new IllegalArgumentException("Bad substFormat: " + ((int) s));
        }
        short s4 = this.rf.readShort();
        logger.debug("coverage=" + ((int) s4));
        int unsignedShort = this.rf.readUnsignedShort();
        int[] iArr = new int[unsignedShort];
        for (int i2 = 0; i2 < unsignedShort; i2++) {
            iArr[i2] = this.rf.readUnsignedShort();
        }
        List<Integer> coverageFormat = readCoverageFormat(i + s4);
        for (int i3 = 0; i3 < unsignedShort; i3++) {
            this.rawLigatureSubstitutionMap.put(Integer.valueOf(iArr[i3]), Arrays.asList(coverageFormat.get(i3)));
        }
    }

    public Map<String, Glyph> getGlyphSubstitutionMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Integer num : this.rawLigatureSubstitutionMap.keySet()) {
            List<Integer> list = this.rawLigatureSubstitutionMap.get(num);
            StringBuilder sb = new StringBuilder(list.size());
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                sb.append(getTextFromGlyph(it.next().intValue(), this.glyphToCharacterMap));
            }
            Glyph glyph = new Glyph(num.intValue(), this.glyphWidthsByIndex[num.intValue()], sb.toString());
            linkedHashMap.put(glyph.chars, glyph);
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public void read() throws FontReadingException {
        this.rawLigatureSubstitutionMap = new LinkedHashMap();
        startReadingTable();
    }

    @Override // com.itextpdf.text.pdf.fonts.otf.OpenTypeFontTableReader
    public void readSubTable(int i, int i2) throws EOFException {
        if (i == 1) {
            readSingleSubstitutionSubtable(i2);
            return;
        }
        if (i == 4) {
            readLigatureSubstitutionSubtable(i2);
            return;
        }
        System.err.println("LookupType " + i + " is not yet handled for " + GlyphSubstitutionTableReader.class.getSimpleName());
    }
}
