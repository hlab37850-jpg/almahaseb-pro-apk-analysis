package org.apache.poi.hssf.usermodel;

import java.util.Iterator;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;

/* JADX INFO: loaded from: classes4.dex */
public final class HSSFRichTextString implements Comparable<HSSFRichTextString>, RichTextString {
    public static final short NO_FONT = 0;
    private InternalWorkbook _book;
    private LabelSSTRecord _record;
    private UnicodeString _string;

    public HSSFRichTextString() {
        this("");
    }

    private void addToSSTIfRequired() {
        InternalWorkbook internalWorkbook = this._book;
        if (internalWorkbook != null) {
            int iAddSSTString = internalWorkbook.addSSTString(this._string);
            this._record.setSSTIndex(iAddSSTString);
            this._string = this._book.getSSTString(iAddSSTString);
        }
    }

    private UnicodeString cloneStringIfRequired() {
        return this._book == null ? this._string : (UnicodeString) this._string.clone();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void applyFont(int i, int i2, short s) {
        if (i > i2) {
            throw new IllegalArgumentException("Start index must be less than end index.");
        }
        if (i < 0 || i2 > length()) {
            throw new IllegalArgumentException("Start and end index not in range.");
        }
        if (i == i2) {
            return;
        }
        short fontAtIndex = i2 != length() ? getFontAtIndex(i2) : (short) 0;
        UnicodeString unicodeStringCloneStringIfRequired = cloneStringIfRequired();
        this._string = unicodeStringCloneStringIfRequired;
        Iterator<UnicodeString.FormatRun> iterator = unicodeStringCloneStringIfRequired.formatIterator();
        if (iterator != null) {
            while (iterator.hasNext()) {
                UnicodeString.FormatRun next = iterator.next();
                if (next.getCharacterPos() >= i && next.getCharacterPos() < i2) {
                    iterator.remove();
                }
            }
        }
        this._string.addFormatRun(new UnicodeString.FormatRun((short) i, s));
        if (i2 != length()) {
            this._string.addFormatRun(new UnicodeString.FormatRun((short) i2, fontAtIndex));
        }
        addToSSTIfRequired();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void clearFormatting() {
        UnicodeString unicodeStringCloneStringIfRequired = cloneStringIfRequired();
        this._string = unicodeStringCloneStringIfRequired;
        unicodeStringCloneStringIfRequired.clearFormatting();
        addToSSTIfRequired();
    }

    public boolean equals(Object obj) {
        if (obj instanceof HSSFRichTextString) {
            return this._string.equals(((HSSFRichTextString) obj)._string);
        }
        return false;
    }

    public short getFontAtIndex(int i) {
        int formatRunCount = this._string.getFormatRunCount();
        UnicodeString.FormatRun formatRun = null;
        int i2 = 0;
        while (i2 < formatRunCount) {
            UnicodeString.FormatRun formatRun2 = this._string.getFormatRun(i2);
            if (formatRun2.getCharacterPos() > i) {
                break;
            }
            i2++;
            formatRun = formatRun2;
        }
        if (formatRun == null) {
            return (short) 0;
        }
        return formatRun.getFontIndex();
    }

    public short getFontOfFormattingRun(int i) {
        return this._string.getFormatRun(i).getFontIndex();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public int getIndexOfFormattingRun(int i) {
        return this._string.getFormatRun(i).getCharacterPos();
    }

    public UnicodeString getRawUnicodeString() {
        return this._string;
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public String getString() {
        return this._string.getString();
    }

    public UnicodeString getUnicodeString() {
        return cloneStringIfRequired();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public int length() {
        return this._string.getCharCount();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public int numFormattingRuns() {
        return this._string.getFormatRunCount();
    }

    public void setUnicodeString(UnicodeString unicodeString) {
        this._string = unicodeString;
    }

    public void setWorkbookReferences(InternalWorkbook internalWorkbook, LabelSSTRecord labelSSTRecord) {
        this._book = internalWorkbook;
        this._record = labelSSTRecord;
    }

    public String toString() {
        return this._string.toString();
    }

    public HSSFRichTextString(String str) {
        if (str == null) {
            this._string = new UnicodeString("");
        } else {
            this._string = new UnicodeString(str);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(HSSFRichTextString hSSFRichTextString) {
        return this._string.compareTo(hSSFRichTextString._string);
    }

    public HSSFRichTextString(InternalWorkbook internalWorkbook, LabelSSTRecord labelSSTRecord) {
        setWorkbookReferences(internalWorkbook, labelSSTRecord);
        this._string = internalWorkbook.getSSTString(labelSSTRecord.getSSTIndex());
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void applyFont(int i, int i2, Font font) {
        applyFont(i, i2, ((HSSFFont) font).getIndex());
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void applyFont(Font font) {
        applyFont(0, this._string.getCharCount(), font);
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public void applyFont(short s) {
        applyFont(0, this._string.getCharCount(), s);
    }
}
