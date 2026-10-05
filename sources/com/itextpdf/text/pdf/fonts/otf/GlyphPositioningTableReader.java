package com.itextpdf.text.pdf.fonts.otf;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GlyphPositioningTableReader extends OpenTypeFontTableReader {

    public static class MarkRecord {
        final int markAnchorOffset;
        final int markClass;

        public MarkRecord(int i, int i2) {
            this.markClass = i;
            this.markAnchorOffset = i2;
        }
    }

    public static class PosLookupRecord {
        final int lookupListIndex;
        final int sequenceIndex;

        public PosLookupRecord(int i, int i2) {
            this.sequenceIndex = i;
            this.lookupListIndex = i2;
        }
    }

    public GlyphPositioningTableReader(RandomAccessFileOrArray randomAccessFileOrArray, int i) {
        super(randomAccessFileOrArray, i);
    }

    private void readAnchorTable(int i) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        if (s != 1) {
            System.err.println("The extra features of the AnchorFormat " + ((int) s) + " will not be used");
        }
        this.rf.readShort();
        this.rf.readShort();
    }

    private void readBaseArrayTable(int i, int i2) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < s; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                hashSet.add(Integer.valueOf(this.rf.readShort()));
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            readAnchorTable(((Integer) it.next()).intValue() + i);
        }
    }

    private void readChainingContextPositioningFormat_3(int i) throws EOFException {
        short s = this.rf.readShort();
        OpenTypeFontTableReader.LOG.debug("backtrackGlyphCount=" + ((int) s));
        ArrayList arrayList = new ArrayList(s);
        for (int i2 = 0; i2 < s; i2++) {
            arrayList.add(Integer.valueOf(this.rf.readShort()));
        }
        short s2 = this.rf.readShort();
        OpenTypeFontTableReader.LOG.debug("inputGlyphCount=" + ((int) s2));
        ArrayList arrayList2 = new ArrayList(s2);
        for (int i3 = 0; i3 < s2; i3++) {
            arrayList2.add(Integer.valueOf(this.rf.readShort()));
        }
        short s3 = this.rf.readShort();
        OpenTypeFontTableReader.LOG.debug("lookaheadGlyphCount=" + ((int) s3));
        ArrayList arrayList3 = new ArrayList(s3);
        for (int i4 = 0; i4 < s3; i4++) {
            arrayList3.add(Integer.valueOf(this.rf.readShort()));
        }
        short s4 = this.rf.readShort();
        OpenTypeFontTableReader.LOG.debug("posCount=" + ((int) s4));
        ArrayList arrayList4 = new ArrayList(s4);
        for (int i5 = 0; i5 < s4; i5++) {
            short s5 = this.rf.readShort();
            short s6 = this.rf.readShort();
            OpenTypeFontTableReader.LOG.debug("sequenceIndex=" + ((int) s5) + ", lookupListIndex=" + ((int) s6));
            arrayList4.add(new PosLookupRecord(s5, s6));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            List<Integer> coverageFormat = readCoverageFormat(((Integer) it.next()).intValue() + i);
            OpenTypeFontTableReader.LOG.debug("backtrackGlyphs=" + coverageFormat);
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            List<Integer> coverageFormat2 = readCoverageFormat(((Integer) it2.next()).intValue() + i);
            OpenTypeFontTableReader.LOG.debug("inputGlyphs=" + coverageFormat2);
        }
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            List<Integer> coverageFormat3 = readCoverageFormat(((Integer) it3.next()).intValue() + i);
            OpenTypeFontTableReader.LOG.debug("lookaheadGlyphs=" + coverageFormat3);
        }
    }

    private void readLookUpType_1(int i) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        if (s != 1) {
            System.err.println("The PosFormat " + ((int) s) + " for `LookupType 1` is not yet supported by " + GlyphPositioningTableReader.class.getSimpleName());
            return;
        }
        Logger logger = OpenTypeFontTableReader.LOG;
        logger.debug("Reading `Look Up Type 1, Format 1` ....");
        short s2 = this.rf.readShort();
        short s3 = this.rf.readShort();
        if ((s3 & 1) == 1) {
            logger.debug("xPlacement=" + ((int) this.rf.readShort()));
        }
        if ((s3 & 2) == 2) {
            logger.debug("yPlacement=" + ((int) this.rf.readShort()));
        }
        logger.debug("glyphCodes=" + readCoverageFormat(i + s2));
    }

    private void readLookUpType_4(int i) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        if (s != 1) {
            System.err.println("The posFormat " + ((int) s) + " is not supported by " + GlyphPositioningTableReader.class.getSimpleName());
            return;
        }
        Logger logger = OpenTypeFontTableReader.LOG;
        logger.debug("Reading `Look Up Type 4, Format 1` ....");
        short s2 = this.rf.readShort();
        short s3 = this.rf.readShort();
        short s4 = this.rf.readShort();
        short s5 = this.rf.readShort();
        short s6 = this.rf.readShort();
        logger.debug("markCoverages=" + readCoverageFormat(s2 + i));
        logger.debug("baseCoverages=" + readCoverageFormat(s3 + i));
        readMarkArrayTable(s5 + i);
        readBaseArrayTable(i + s6, s4);
    }

    private void readLookUpType_8(int i) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        if (s == 3) {
            OpenTypeFontTableReader.LOG.debug("Reading `Look Up Type 8, Format 3` ....");
            readChainingContextPositioningFormat_3(i);
            return;
        }
        System.err.println("The posFormat " + ((int) s) + " for `Look Up Type 8` is not supported by " + GlyphPositioningTableReader.class.getSimpleName());
    }

    private void readMarkArrayTable(int i) throws EOFException {
        this.rf.seek(i);
        short s = this.rf.readShort();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < s; i2++) {
            arrayList.add(readMarkRecord());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            readAnchorTable(((MarkRecord) it.next()).markAnchorOffset + i);
        }
    }

    private MarkRecord readMarkRecord() {
        return new MarkRecord(this.rf.readShort(), this.rf.readShort());
    }

    public void read() throws FontReadingException {
        startReadingTable();
    }

    @Override // com.itextpdf.text.pdf.fonts.otf.OpenTypeFontTableReader
    public void readSubTable(int i, int i2) throws EOFException {
        if (i == 1) {
            readLookUpType_1(i2);
            return;
        }
        if (i == 4) {
            readLookUpType_4(i2);
            return;
        }
        if (i == 8) {
            readLookUpType_8(i2);
            return;
        }
        System.err.println("The lookupType " + i + " is not yet supported by " + GlyphPositioningTableReader.class.getSimpleName());
    }
}
