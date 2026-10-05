package com.itextpdf.text.pdf;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public class CFFFontSubset extends CFFFont {
    static final byte ENDCHAR_OP = 14;
    static final byte RETURN_OP = 11;
    HashSet<Integer> FDArrayUsed;
    int GBias;
    HashMap<Integer, int[]> GlyphsUsed;
    byte[] NewCharStringsIndex;
    byte[] NewGSubrsIndex;
    byte[][] NewLSubrsIndex;
    byte[] NewSubrsIndexNonCID;
    int NumOfHints;
    LinkedList<CFFFont.Item> OutputList;
    ArrayList<Integer> glyphsInList;
    HashMap<Integer, int[]> hGSubrsUsed;
    HashMap<Integer, int[]>[] hSubrsUsed;
    HashMap<Integer, int[]> hSubrsUsedNonCID;
    ArrayList<Integer> lGSubrsUsed;
    ArrayList<Integer>[] lSubrsUsed;
    ArrayList<Integer> lSubrsUsedNonCID;
    static final String[] SubrsFunctions = {"RESERVED_0", "hstem", "RESERVED_2", "vstem", "vmoveto", "rlineto", "hlineto", "vlineto", "rrcurveto", "RESERVED_9", "callsubr", "return", "escape", "RESERVED_13", "endchar", "RESERVED_15", "RESERVED_16", "RESERVED_17", "hstemhm", "hintmask", "cntrmask", "rmoveto", "hmoveto", "vstemhm", "rcurveline", "rlinecurve", "vvcurveto", "hhcurveto", "shortint", "callgsubr", "vhcurveto", "hvcurveto"};
    static final String[] SubrsEscapeFuncs = {"RESERVED_0", "RESERVED_1", "RESERVED_2", "and", "or", "not", "RESERVED_6", "RESERVED_7", "RESERVED_8", "abs", "add", "sub", "div", "RESERVED_13", "neg", "eq", "RESERVED_16", "RESERVED_17", "drop", "RESERVED_19", "put", "get", "ifelse", "random", "mul", "RESERVED_25", "sqrt", "dup", "exch", "index", "roll", "RESERVED_31", "RESERVED_32", "RESERVED_33", "hflex", "flex", "hflex1", "flex1", "RESERVED_REST"};

    public CFFFontSubset(RandomAccessFileOrArray randomAccessFileOrArray, HashMap<Integer, int[]> map) {
        super(randomAccessFileOrArray);
        this.FDArrayUsed = new HashSet<>();
        this.hGSubrsUsed = new HashMap<>();
        this.lGSubrsUsed = new ArrayList<>();
        this.hSubrsUsedNonCID = new HashMap<>();
        this.lSubrsUsedNonCID = new ArrayList<>();
        int i = 0;
        this.GBias = 0;
        this.NumOfHints = 0;
        this.GlyphsUsed = map;
        this.glyphsInList = new ArrayList<>(map.keySet());
        while (true) {
            CFFFont.Font[] fontArr = this.fonts;
            if (i >= fontArr.length) {
                return;
            }
            seek(fontArr[i].charstringsOffset);
            this.fonts[i].nglyphs = getCard16();
            seek(this.stringIndexOffset);
            this.fonts[i].nstrings = getCard16() + CFFFont.standardStrings.length;
            CFFFont.Font font = this.fonts[i];
            font.charstringsOffsets = getIndex(font.charstringsOffset);
            if (this.fonts[i].fdselectOffset >= 0) {
                readFDSelect(i);
                BuildFDArrayUsed(i);
            }
            if (this.fonts[i].isCID) {
                ReadFDArray(i);
            }
            CFFFont.Font font2 = this.fonts[i];
            font2.CharsetLength = CountCharset(font2.charsetOffset, font2.nglyphs);
            i++;
        }
    }

    public byte[] AssembleIndex(int[] iArr, byte[] bArr) {
        byte b;
        char length = (char) (iArr.length - 1);
        int i = iArr[iArr.length - 1];
        if (i <= 255) {
            b = 1;
        } else if (i <= 65535) {
            b = 2;
        } else {
            b = i <= 16777215 ? (byte) 3 : (byte) 4;
        }
        byte[] bArr2 = new byte[((length + 1) * b) + 3 + bArr.length];
        int i2 = 0;
        bArr2[0] = (byte) ((length >>> '\b') & 255);
        bArr2[1] = (byte) (length & 255);
        bArr2[2] = b;
        int i3 = 3;
        for (int i4 : iArr) {
            int i5 = (i4 - iArr[0]) + 1;
            if (b == 1) {
                bArr2[i3] = (byte) (i5 & 255);
                i3++;
            } else {
                if (b != 2) {
                    if (b != 3) {
                        if (b == 4) {
                            bArr2[i3] = (byte) ((i5 >>> 24) & 255);
                            i3++;
                        }
                    }
                    bArr2[i3] = (byte) ((i5 >>> 16) & 255);
                    i3++;
                }
                bArr2[i3] = (byte) ((i5 >>> 8) & 255);
                i3++;
                bArr2[i3] = (byte) (i5 & 255);
                i3++;
            }
        }
        int length2 = bArr.length;
        while (i2 < length2) {
            bArr2[i3] = bArr[i2];
            i2++;
            i3++;
        }
        return bArr2;
    }

    public void BuildFDArrayUsed(int i) {
        int[] iArr = this.fonts[i].FDSelect;
        for (int i2 = 0; i2 < this.glyphsInList.size(); i2++) {
            this.FDArrayUsed.add(Integer.valueOf(iArr[this.glyphsInList.get(i2).intValue()]));
        }
    }

    public void BuildFDSubrsOffsets(int i, int i2) {
        CFFFont.Font font;
        CFFFont.Font font2 = this.fonts[i];
        font2.PrivateSubrsOffset[i2] = -1;
        seek(font2.fdprivateOffsets[i2]);
        while (true) {
            int position = getPosition();
            font = this.fonts[i];
            if (position >= font.fdprivateOffsets[i2] + font.fdprivateLengths[i2]) {
                break;
            }
            getDictItem();
            if (this.key == "Subrs") {
                this.fonts[i].PrivateSubrsOffset[i2] = ((Integer) this.args[0]).intValue() + this.fonts[i].fdprivateOffsets[i2];
            }
        }
        int i3 = font.PrivateSubrsOffset[i2];
        if (i3 >= 0) {
            font.PrivateSubrsOffsetsArray[i2] = getIndex(i3);
        }
    }

    public void BuildGSubrsUsed(int i) {
        int iCalcBias;
        int size;
        int i2 = this.fonts[i].privateSubrs;
        if (i2 >= 0) {
            iCalcBias = CalcBias(i2, i);
            size = this.lSubrsUsedNonCID.size();
        } else {
            iCalcBias = 0;
            size = 0;
        }
        for (int i3 = 0; i3 < this.lGSubrsUsed.size(); i3++) {
            int iIntValue = this.lGSubrsUsed.get(i3).intValue();
            int[] iArr = this.gsubrOffsets;
            if (iIntValue < iArr.length - 1 && iIntValue >= 0) {
                int i4 = iArr[iIntValue];
                int i5 = iArr[iIntValue + 1];
                CFFFont.Font font = this.fonts[i];
                if (font.isCID) {
                    ReadASubr(i4, i5, this.GBias, 0, this.hGSubrsUsed, this.lGSubrsUsed, null);
                } else {
                    ReadASubr(i4, i5, this.GBias, iCalcBias, this.hSubrsUsedNonCID, this.lSubrsUsedNonCID, font.SubrsOffsets);
                    if (size < this.lSubrsUsedNonCID.size()) {
                        while (size < this.lSubrsUsedNonCID.size()) {
                            int iIntValue2 = this.lSubrsUsedNonCID.get(size).intValue();
                            int[] iArr2 = this.fonts[i].SubrsOffsets;
                            if (iIntValue2 < iArr2.length - 1 && iIntValue2 >= 0) {
                                ReadASubr(iArr2[iIntValue2], iArr2[iIntValue2 + 1], this.GBias, iCalcBias, this.hSubrsUsedNonCID, this.lSubrsUsedNonCID, iArr2);
                            }
                            size++;
                        }
                        size = this.lSubrsUsedNonCID.size();
                    }
                }
            }
        }
    }

    public void BuildIndexHeader(int i, int i2, int i3) {
        this.OutputList.addLast(new CFFFont.UInt16Item((char) i));
        this.OutputList.addLast(new CFFFont.UInt8Item((char) i2));
        if (i2 == 1) {
            this.OutputList.addLast(new CFFFont.UInt8Item((char) i3));
            return;
        }
        if (i2 == 2) {
            this.OutputList.addLast(new CFFFont.UInt16Item((char) i3));
        } else if (i2 == 3) {
            this.OutputList.addLast(new CFFFont.UInt24Item((char) i3));
        } else {
            if (i2 != 4) {
                return;
            }
            this.OutputList.addLast(new CFFFont.UInt32Item((char) i3));
        }
    }

    public void BuildNewCharString(int i) {
        this.NewCharStringsIndex = BuildNewIndex(this.fonts[i].charstringsOffsets, this.GlyphsUsed, (byte) 14);
    }

    public byte[] BuildNewFile(int i) {
        this.OutputList = new LinkedList<>();
        CopyHeader();
        BuildIndexHeader(1, 1, 1);
        this.OutputList.addLast(new CFFFont.UInt8Item((char) (this.fonts[i].name.length() + 1)));
        this.OutputList.addLast(new CFFFont.StringItem(this.fonts[i].name));
        BuildIndexHeader(1, 2, 1);
        CFFFont.IndexOffsetItem indexOffsetItem = new CFFFont.IndexOffsetItem(2);
        this.OutputList.addLast(indexOffsetItem);
        CFFFont.IndexBaseItem indexBaseItem = new CFFFont.IndexBaseItem();
        this.OutputList.addLast(indexBaseItem);
        CFFFont.DictOffsetItem dictOffsetItem = new CFFFont.DictOffsetItem();
        CFFFont.DictOffsetItem dictOffsetItem2 = new CFFFont.DictOffsetItem();
        CFFFont.DictOffsetItem dictOffsetItem3 = new CFFFont.DictOffsetItem();
        CFFFont.DictOffsetItem dictOffsetItem4 = new CFFFont.DictOffsetItem();
        CFFFont.DictOffsetItem dictOffsetItem5 = new CFFFont.DictOffsetItem();
        CFFFont.Font font = this.fonts[i];
        if (!font.isCID) {
            this.OutputList.addLast(new CFFFont.DictNumberItem(font.nstrings));
            this.OutputList.addLast(new CFFFont.DictNumberItem(this.fonts[i].nstrings + 1));
            this.OutputList.addLast(new CFFFont.DictNumberItem(0));
            this.OutputList.addLast(new CFFFont.UInt8Item('\f'));
            this.OutputList.addLast(new CFFFont.UInt8Item((char) 30));
            this.OutputList.addLast(new CFFFont.DictNumberItem(this.fonts[i].nglyphs));
            this.OutputList.addLast(new CFFFont.UInt8Item('\f'));
            this.OutputList.addLast(new CFFFont.UInt8Item('\"'));
        }
        seek(this.topdictOffsets[i]);
        while (getPosition() < this.topdictOffsets[i + 1]) {
            int position = getPosition();
            getDictItem();
            int position2 = getPosition();
            String str = this.key;
            if (str != "Encoding" && str != "Private" && str != "FDSelect" && str != "FDArray" && str != "charset" && str != "CharStrings") {
                this.OutputList.add(new CFFFont.RangeItem(this.buf, position, position2 - position));
            }
        }
        CreateKeys(dictOffsetItem3, dictOffsetItem4, dictOffsetItem, dictOffsetItem2);
        this.OutputList.addLast(new CFFFont.IndexMarkerItem(indexOffsetItem, indexBaseItem));
        if (this.fonts[i].isCID) {
            this.OutputList.addLast(getEntireIndexRange(this.stringIndexOffset));
        } else {
            CreateNewStringIndex(i);
        }
        this.OutputList.addLast(new CFFFont.RangeItem(new RandomAccessFileOrArray(this.NewGSubrsIndex), 0, this.NewGSubrsIndex.length));
        CFFFont.Font font2 = this.fonts[i];
        if (font2.isCID) {
            this.OutputList.addLast(new CFFFont.MarkerItem(dictOffsetItem4));
            CFFFont.Font font3 = this.fonts[i];
            int i2 = font3.fdselectOffset;
            if (i2 >= 0) {
                this.OutputList.addLast(new CFFFont.RangeItem(this.buf, i2, font3.FDSelectLength));
            } else {
                CreateFDSelect(dictOffsetItem4, font3.nglyphs);
            }
            this.OutputList.addLast(new CFFFont.MarkerItem(dictOffsetItem));
            LinkedList<CFFFont.Item> linkedList = this.OutputList;
            RandomAccessFileOrArray randomAccessFileOrArray = this.buf;
            CFFFont.Font font4 = this.fonts[i];
            linkedList.addLast(new CFFFont.RangeItem(randomAccessFileOrArray, font4.charsetOffset, font4.CharsetLength));
            if (this.fonts[i].fdarrayOffset >= 0) {
                this.OutputList.addLast(new CFFFont.MarkerItem(dictOffsetItem3));
                Reconstruct(i);
            } else {
                CreateFDArray(dictOffsetItem3, dictOffsetItem5, i);
            }
        } else {
            CreateFDSelect(dictOffsetItem4, font2.nglyphs);
            CreateCharset(dictOffsetItem, this.fonts[i].nglyphs);
            CreateFDArray(dictOffsetItem3, dictOffsetItem5, i);
        }
        if (this.fonts[i].privateOffset >= 0) {
            CFFFont.IndexBaseItem indexBaseItem2 = new CFFFont.IndexBaseItem();
            this.OutputList.addLast(indexBaseItem2);
            this.OutputList.addLast(new CFFFont.MarkerItem(dictOffsetItem5));
            CFFFont.DictOffsetItem dictOffsetItem6 = new CFFFont.DictOffsetItem();
            CreateNonCIDPrivate(i, dictOffsetItem6);
            CreateNonCIDSubrs(i, indexBaseItem2, dictOffsetItem6);
        }
        this.OutputList.addLast(new CFFFont.MarkerItem(dictOffsetItem2));
        this.OutputList.addLast(new CFFFont.RangeItem(new RandomAccessFileOrArray(this.NewCharStringsIndex), 0, this.NewCharStringsIndex.length));
        int[] iArr = {0};
        Iterator<CFFFont.Item> it = this.OutputList.iterator();
        while (it.hasNext()) {
            it.next().increment(iArr);
        }
        Iterator<CFFFont.Item> it2 = this.OutputList.iterator();
        while (it2.hasNext()) {
            it2.next().xref();
        }
        byte[] bArr = new byte[iArr[0]];
        Iterator<CFFFont.Item> it3 = this.OutputList.iterator();
        while (it3.hasNext()) {
            it3.next().emit(bArr);
        }
        return bArr;
    }

    public byte[] BuildNewIndex(int[] iArr, HashMap<Integer, int[]> map, byte b) throws EOFException {
        int[] iArr2 = new int[iArr.length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            iArr2[i4] = i2;
            if (map.containsKey(Integer.valueOf(i4))) {
                i2 += iArr[i4 + 1] - iArr[i4];
            } else {
                i3++;
            }
        }
        byte[] bArr = new byte[i2 + i3];
        int i5 = 0;
        while (i < iArr.length - 1) {
            int i6 = iArr2[i];
            int i7 = i + 1;
            int i8 = iArr2[i7];
            int i9 = i6 + i5;
            iArr2[i] = i9;
            if (i6 != i8) {
                this.buf.seek(iArr[i]);
                this.buf.readFully(bArr, i9, i8 - i6);
            } else {
                bArr[i9] = b;
                i5++;
            }
            i = i7;
        }
        int length = iArr.length - 1;
        iArr2[length] = iArr2[length] + i5;
        return AssembleIndex(iArr2, bArr);
    }

    public void BuildNewLGSubrs(int i) {
        CFFFont.Font font = this.fonts[i];
        if (font.isCID) {
            int[] iArr = font.fdprivateOffsets;
            this.hSubrsUsed = new HashMap[iArr.length];
            this.lSubrsUsed = new ArrayList[iArr.length];
            this.NewLSubrsIndex = new byte[iArr.length][];
            font.PrivateSubrsOffset = new int[iArr.length];
            font.PrivateSubrsOffsetsArray = new int[iArr.length][];
            ArrayList arrayList = new ArrayList(this.FDArrayUsed);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                int iIntValue = ((Integer) arrayList.get(i2)).intValue();
                this.hSubrsUsed[iIntValue] = new HashMap<>();
                this.lSubrsUsed[iIntValue] = new ArrayList<>();
                BuildFDSubrsOffsets(i, iIntValue);
                CFFFont.Font font2 = this.fonts[i];
                int i3 = font2.PrivateSubrsOffset[iIntValue];
                if (i3 >= 0) {
                    BuildSubrUsed(i, iIntValue, i3, font2.PrivateSubrsOffsetsArray[iIntValue], this.hSubrsUsed[iIntValue], this.lSubrsUsed[iIntValue]);
                    this.NewLSubrsIndex[iIntValue] = BuildNewIndex(this.fonts[i].PrivateSubrsOffsetsArray[iIntValue], this.hSubrsUsed[iIntValue], (byte) 11);
                }
            }
        } else {
            int i4 = font.privateSubrs;
            if (i4 >= 0) {
                font.SubrsOffsets = getIndex(i4);
                CFFFont.Font font3 = this.fonts[i];
                BuildSubrUsed(i, -1, font3.privateSubrs, font3.SubrsOffsets, this.hSubrsUsedNonCID, this.lSubrsUsedNonCID);
            }
        }
        BuildGSubrsUsed(i);
        CFFFont.Font font4 = this.fonts[i];
        if (font4.privateSubrs >= 0) {
            this.NewSubrsIndexNonCID = BuildNewIndex(font4.SubrsOffsets, this.hSubrsUsedNonCID, (byte) 11);
        }
        this.NewGSubrsIndex = BuildNewIndex(this.gsubrOffsets, this.hGSubrsUsed, (byte) 11);
    }

    public void BuildSubrUsed(int i, int i2, int i3, int[] iArr, HashMap<Integer, int[]> map, ArrayList<Integer> arrayList) {
        int iCalcBias = CalcBias(i3, i);
        for (int i4 = 0; i4 < this.glyphsInList.size(); i4++) {
            int iIntValue = this.glyphsInList.get(i4).intValue();
            int[] iArr2 = this.fonts[i].charstringsOffsets;
            int i5 = iArr2[iIntValue];
            int i6 = iArr2[iIntValue + 1];
            if (i2 >= 0) {
                EmptyStack();
                this.NumOfHints = 0;
                if (this.fonts[i].FDSelect[iIntValue] == i2) {
                    ReadASubr(i5, i6, this.GBias, iCalcBias, map, arrayList, iArr);
                }
            } else {
                ReadASubr(i5, i6, this.GBias, iCalcBias, map, arrayList, iArr);
            }
        }
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            int iIntValue2 = arrayList.get(i7).intValue();
            if (iIntValue2 < iArr.length - 1 && iIntValue2 >= 0) {
                ReadASubr(iArr[iIntValue2], iArr[iIntValue2 + 1], this.GBias, iCalcBias, map, arrayList, iArr);
            }
        }
    }

    public int CalcBias(int i, int i2) {
        seek(i);
        char card16 = getCard16();
        if (this.fonts[i2].CharstringType == 1) {
            return 0;
        }
        if (card16 < 1240) {
            return 107;
        }
        return card16 < 33900 ? 1131 : 32768;
    }

    public int CalcHints(int i, int i2, int i3, int i4, int[] iArr) {
        seek(i);
        while (getPosition() < i2) {
            ReadCommand();
            int position = getPosition();
            int i5 = this.arg_count;
            Object obj = i5 > 0 ? this.args[i5 - 1] : null;
            HandelStack();
            String str = this.key;
            if (str == "callsubr") {
                if (i5 > 0) {
                    int iIntValue = ((Integer) obj).intValue() + i3;
                    CalcHints(iArr[iIntValue], iArr[iIntValue + 1], i3, i4, iArr);
                    seek(position);
                }
            } else if (str == "callgsubr") {
                if (i5 > 0) {
                    int iIntValue2 = ((Integer) obj).intValue() + i4;
                    int[] iArr2 = this.gsubrOffsets;
                    CalcHints(iArr2[iIntValue2], iArr2[iIntValue2 + 1], i3, i4, iArr);
                    seek(position);
                }
            } else if (str == "hstem" || str == "vstem" || str == "hstemhm" || str == "vstemhm") {
                this.NumOfHints += i5 / 2;
            } else if (str == "hintmask" || str == "cntrmask") {
                int i6 = this.NumOfHints;
                int i7 = i6 / 8;
                if (i6 % 8 != 0 || i7 == 0) {
                    i7++;
                }
                for (int i8 = 0; i8 < i7; i8++) {
                    getCard8();
                }
            }
        }
        return this.NumOfHints;
    }

    public int CalcSubrOffsetSize(int i, int i2) {
        seek(i);
        int i3 = 0;
        while (getPosition() < i + i2) {
            int position = getPosition();
            getDictItem();
            int position2 = getPosition();
            if (this.key == "Subrs") {
                i3 = (position2 - position) - 1;
            }
        }
        return i3;
    }

    public void CopyHeader() {
        seek(0);
        getCard8();
        getCard8();
        char card8 = getCard8();
        getCard8();
        this.nextIndexOffset = card8;
        this.OutputList.addLast(new CFFFont.RangeItem(this.buf, 0, card8));
    }

    public int CountCharset(int i, int i2) {
        int iCountRange;
        seek(i);
        char card8 = getCard8();
        if (card8 == 0) {
            return (i2 * 2) + 1;
        }
        if (card8 == 1) {
            iCountRange = CountRange(i2, 1) * 3;
        } else {
            if (card8 != 2) {
                return 0;
            }
            iCountRange = CountRange(i2, 2) * 4;
        }
        return iCountRange + 1;
    }

    public int CountRange(int i, int i2) {
        int i3 = 0;
        int card8 = 1;
        while (card8 < i) {
            i3++;
            getCard16();
            card8 += (i2 == 1 ? getCard8() : getCard16()) + 1;
        }
        return i3;
    }

    public void CreateCharset(CFFFont.OffsetItem offsetItem, int i) {
        this.OutputList.addLast(new CFFFont.MarkerItem(offsetItem));
        this.OutputList.addLast(new CFFFont.UInt8Item((char) 2));
        this.OutputList.addLast(new CFFFont.UInt16Item((char) 1));
        this.OutputList.addLast(new CFFFont.UInt16Item((char) (i - 1)));
    }

    public void CreateFDArray(CFFFont.OffsetItem offsetItem, CFFFont.OffsetItem offsetItem2, int i) {
        this.OutputList.addLast(new CFFFont.MarkerItem(offsetItem));
        BuildIndexHeader(1, 1, 1);
        CFFFont.IndexOffsetItem indexOffsetItem = new CFFFont.IndexOffsetItem(1);
        this.OutputList.addLast(indexOffsetItem);
        CFFFont.IndexBaseItem indexBaseItem = new CFFFont.IndexBaseItem();
        this.OutputList.addLast(indexBaseItem);
        CFFFont.Font font = this.fonts[i];
        int i2 = font.privateLength;
        int iCalcSubrOffsetSize = CalcSubrOffsetSize(font.privateOffset, i2);
        if (iCalcSubrOffsetSize != 0) {
            i2 += 5 - iCalcSubrOffsetSize;
        }
        this.OutputList.addLast(new CFFFont.DictNumberItem(i2));
        this.OutputList.addLast(offsetItem2);
        this.OutputList.addLast(new CFFFont.UInt8Item((char) 18));
        this.OutputList.addLast(new CFFFont.IndexMarkerItem(indexOffsetItem, indexBaseItem));
    }

    public void CreateFDSelect(CFFFont.OffsetItem offsetItem, int i) {
        this.OutputList.addLast(new CFFFont.MarkerItem(offsetItem));
        this.OutputList.addLast(new CFFFont.UInt8Item((char) 3));
        this.OutputList.addLast(new CFFFont.UInt16Item((char) 1));
        this.OutputList.addLast(new CFFFont.UInt16Item((char) 0));
        this.OutputList.addLast(new CFFFont.UInt8Item((char) 0));
        this.OutputList.addLast(new CFFFont.UInt16Item((char) i));
    }

    public void CreateKeys(CFFFont.OffsetItem offsetItem, CFFFont.OffsetItem offsetItem2, CFFFont.OffsetItem offsetItem3, CFFFont.OffsetItem offsetItem4) {
        this.OutputList.addLast(offsetItem);
        this.OutputList.addLast(new CFFFont.UInt8Item('\f'));
        this.OutputList.addLast(new CFFFont.UInt8Item('$'));
        this.OutputList.addLast(offsetItem2);
        this.OutputList.addLast(new CFFFont.UInt8Item('\f'));
        this.OutputList.addLast(new CFFFont.UInt8Item('%'));
        this.OutputList.addLast(offsetItem3);
        this.OutputList.addLast(new CFFFont.UInt8Item((char) 15));
        this.OutputList.addLast(offsetItem4);
        this.OutputList.addLast(new CFFFont.UInt8Item((char) 17));
    }

    public void CreateNewStringIndex(int i) {
        int i2;
        String strSubstring = this.fonts[i].name + "-OneRange";
        if (strSubstring.length() > 127) {
            strSubstring = strSubstring.substring(0, ShapeTypes.VERTICAL_SCROLL);
        }
        String str = "AdobeIdentity" + strSubstring;
        int[] iArr = this.stringOffsets;
        int i3 = iArr[iArr.length - 1];
        int i4 = iArr[0];
        int i5 = i3 - i4;
        int i6 = i4 - 1;
        if (str.length() + i5 <= 255) {
            i2 = 1;
        } else if (str.length() + i5 <= 65535) {
            i2 = 2;
        } else {
            i2 = str.length() + i5 <= 16777215 ? 3 : 4;
        }
        this.OutputList.addLast(new CFFFont.UInt16Item((char) (this.stringOffsets.length + 2)));
        this.OutputList.addLast(new CFFFont.UInt8Item((char) i2));
        for (int i7 : this.stringOffsets) {
            this.OutputList.addLast(new CFFFont.IndexOffsetItem(i2, i7 - i6));
        }
        int[] iArr2 = this.stringOffsets;
        int i8 = iArr2[iArr2.length - 1] - i6;
        this.OutputList.addLast(new CFFFont.IndexOffsetItem(i2, i8 + 5));
        int i9 = i8 + 13;
        this.OutputList.addLast(new CFFFont.IndexOffsetItem(i2, i9));
        this.OutputList.addLast(new CFFFont.IndexOffsetItem(i2, i9 + strSubstring.length()));
        this.OutputList.addLast(new CFFFont.RangeItem(this.buf, this.stringOffsets[0], i5));
        this.OutputList.addLast(new CFFFont.StringItem(str));
    }

    public void CreateNonCIDPrivate(int i, CFFFont.OffsetItem offsetItem) {
        seek(this.fonts[i].privateOffset);
        while (true) {
            int position = getPosition();
            CFFFont.Font font = this.fonts[i];
            if (position >= font.privateOffset + font.privateLength) {
                return;
            }
            int position2 = getPosition();
            getDictItem();
            int position3 = getPosition();
            if (this.key == "Subrs") {
                this.OutputList.addLast(offsetItem);
                this.OutputList.addLast(new CFFFont.UInt8Item((char) 19));
            } else {
                this.OutputList.addLast(new CFFFont.RangeItem(this.buf, position2, position3 - position2));
            }
        }
    }

    public void CreateNonCIDSubrs(int i, CFFFont.IndexBaseItem indexBaseItem, CFFFont.OffsetItem offsetItem) {
        this.OutputList.addLast(new CFFFont.SubrMarkerItem(offsetItem, indexBaseItem));
        byte[] bArr = this.NewSubrsIndexNonCID;
        if (bArr != null) {
            this.OutputList.addLast(new CFFFont.RangeItem(new RandomAccessFileOrArray(bArr), 0, this.NewSubrsIndexNonCID.length));
        }
    }

    public void EmptyStack() {
        for (int i = 0; i < this.arg_count; i++) {
            this.args[i] = null;
        }
        this.arg_count = 0;
    }

    public void HandelStack() {
        int iStackOpp = StackOpp();
        if (iStackOpp >= 2) {
            EmptyStack();
            return;
        }
        if (iStackOpp == 1) {
            PushStack();
            return;
        }
        int i = iStackOpp * (-1);
        for (int i2 = 0; i2 < i; i2++) {
            PopStack();
        }
    }

    public void PopStack() {
        int i = this.arg_count;
        if (i > 0) {
            this.args[i - 1] = null;
            this.arg_count = i - 1;
        }
    }

    public byte[] Process(String str) {
        try {
            this.buf.reOpen();
            int i = 0;
            while (true) {
                CFFFont.Font[] fontArr = this.fonts;
                if (i >= fontArr.length || str.equals(fontArr[i].name)) {
                    break;
                    break;
                }
                i++;
            }
            if (i == this.fonts.length) {
                try {
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            int i2 = this.gsubrIndexOffset;
            if (i2 >= 0) {
                this.GBias = CalcBias(i2, i);
            }
            BuildNewCharString(i);
            BuildNewLGSubrs(i);
            return BuildNewFile(i);
        } finally {
            try {
                this.buf.close();
            } catch (Exception unused2) {
            }
        }
    }

    public void PushStack() {
        this.arg_count++;
    }

    public void ReadASubr(int i, int i2, int i3, int i4, HashMap<Integer, int[]> map, ArrayList<Integer> arrayList, int[] iArr) {
        EmptyStack();
        this.NumOfHints = 0;
        seek(i);
        while (getPosition() < i2) {
            ReadCommand();
            int position = getPosition();
            int i5 = this.arg_count;
            Object obj = i5 > 0 ? this.args[i5 - 1] : null;
            HandelStack();
            String str = this.key;
            if (str == "callsubr") {
                if (i5 > 0) {
                    int iIntValue = ((Integer) obj).intValue() + i4;
                    if (!map.containsKey(Integer.valueOf(iIntValue))) {
                        map.put(Integer.valueOf(iIntValue), null);
                        arrayList.add(Integer.valueOf(iIntValue));
                    }
                    CalcHints(iArr[iIntValue], iArr[iIntValue + 1], i4, i3, iArr);
                    seek(position);
                }
            } else if (str == "callgsubr") {
                if (i5 > 0) {
                    int iIntValue2 = ((Integer) obj).intValue() + i3;
                    if (!this.hGSubrsUsed.containsKey(Integer.valueOf(iIntValue2))) {
                        this.hGSubrsUsed.put(Integer.valueOf(iIntValue2), null);
                        this.lGSubrsUsed.add(Integer.valueOf(iIntValue2));
                    }
                    int[] iArr2 = this.gsubrOffsets;
                    CalcHints(iArr2[iIntValue2], iArr2[iIntValue2 + 1], i4, i3, iArr);
                    seek(position);
                }
            } else if (str == "hstem" || str == "vstem" || str == "hstemhm" || str == "vstemhm") {
                this.NumOfHints += i5 / 2;
            } else if (str == "hintmask" || str == "cntrmask") {
                int i6 = this.NumOfHints + (i5 / 2);
                this.NumOfHints = i6;
                int i7 = i6 / 8;
                if (i6 % 8 != 0 || i7 == 0) {
                    i7++;
                }
                for (int i8 = 0; i8 < i7; i8++) {
                    getCard8();
                }
            }
        }
    }

    public void ReadCommand() {
        this.key = null;
        boolean z = false;
        while (!z) {
            char card8 = getCard8();
            if (card8 == 28) {
                this.args[this.arg_count] = Integer.valueOf((getCard8() << '\b') | getCard8());
                this.arg_count++;
            } else if (card8 >= ' ' && card8 <= 246) {
                this.args[this.arg_count] = Integer.valueOf(card8 - 139);
                this.arg_count++;
            } else if (card8 >= 247 && card8 <= 250) {
                this.args[this.arg_count] = Integer.valueOf(((card8 - 247) * 256) + getCard8() + 108);
                this.arg_count++;
            } else if (card8 >= 251 && card8 <= 254) {
                this.args[this.arg_count] = Integer.valueOf((((-(card8 - 251)) * 256) - getCard8()) - 108);
                this.arg_count++;
            } else if (card8 == 255) {
                this.args[this.arg_count] = Integer.valueOf((getCard8() << 24) | (getCard8() << 16) | (getCard8() << '\b') | getCard8());
                this.arg_count++;
            } else if (card8 <= 31 && card8 != 28) {
                if (card8 == '\f') {
                    int card9 = getCard8();
                    String[] strArr = SubrsEscapeFuncs;
                    if (card9 > strArr.length - 1) {
                        card9 = strArr.length - 1;
                    }
                    this.key = strArr[card9];
                } else {
                    this.key = SubrsFunctions[card8];
                }
                z = true;
            }
        }
    }

    public void ReadFDArray(int i) {
        seek(this.fonts[i].fdarrayOffset);
        this.fonts[i].FDArrayCount = getCard16();
        this.fonts[i].FDArrayOffsize = getCard8();
        CFFFont.Font font = this.fonts[i];
        int i2 = font.FDArrayOffsize;
        if (i2 < 4) {
            font.FDArrayOffsize = i2 + 1;
        }
        font.FDArrayOffsets = getIndex(font.fdarrayOffset);
    }

    public void Reconstruct(int i) {
        CFFFont.Font font = this.fonts[i];
        CFFFont.DictOffsetItem[] dictOffsetItemArr = new CFFFont.DictOffsetItem[font.FDArrayOffsets.length - 1];
        int[] iArr = font.fdprivateOffsets;
        CFFFont.IndexBaseItem[] indexBaseItemArr = new CFFFont.IndexBaseItem[iArr.length];
        CFFFont.DictOffsetItem[] dictOffsetItemArr2 = new CFFFont.DictOffsetItem[iArr.length];
        ReconstructFDArray(i, dictOffsetItemArr);
        ReconstructPrivateDict(i, dictOffsetItemArr, indexBaseItemArr, dictOffsetItemArr2);
        ReconstructPrivateSubrs(i, indexBaseItemArr, dictOffsetItemArr2);
    }

    public void ReconstructFDArray(int i, CFFFont.OffsetItem[] offsetItemArr) {
        int i2;
        CFFFont.Font font = this.fonts[i];
        BuildIndexHeader(font.FDArrayCount, font.FDArrayOffsize, 1);
        CFFFont.IndexOffsetItem[] indexOffsetItemArr = new CFFFont.IndexOffsetItem[this.fonts[i].FDArrayOffsets.length - 1];
        int i3 = 0;
        while (true) {
            CFFFont.Font font2 = this.fonts[i];
            if (i3 >= font2.FDArrayOffsets.length - 1) {
                break;
            }
            CFFFont.IndexOffsetItem indexOffsetItem = new CFFFont.IndexOffsetItem(font2.FDArrayOffsize);
            indexOffsetItemArr[i3] = indexOffsetItem;
            this.OutputList.addLast(indexOffsetItem);
            i3++;
        }
        CFFFont.IndexBaseItem indexBaseItem = new CFFFont.IndexBaseItem();
        this.OutputList.addLast(indexBaseItem);
        int i4 = 0;
        while (true) {
            int[] iArr = this.fonts[i].FDArrayOffsets;
            if (i4 >= iArr.length - 1) {
                return;
            }
            seek(iArr[i4]);
            while (true) {
                i2 = i4 + 1;
                if (getPosition() < this.fonts[i].FDArrayOffsets[i2]) {
                    int position = getPosition();
                    getDictItem();
                    int position2 = getPosition();
                    if (this.key == "Private") {
                        int iIntValue = ((Integer) this.args[0]).intValue();
                        CFFFont.Font font3 = this.fonts[i];
                        int iCalcSubrOffsetSize = CalcSubrOffsetSize(font3.fdprivateOffsets[i4], font3.fdprivateLengths[i4]);
                        if (iCalcSubrOffsetSize != 0) {
                            iIntValue += 5 - iCalcSubrOffsetSize;
                        }
                        this.OutputList.addLast(new CFFFont.DictNumberItem(iIntValue));
                        CFFFont.DictOffsetItem dictOffsetItem = new CFFFont.DictOffsetItem();
                        offsetItemArr[i4] = dictOffsetItem;
                        this.OutputList.addLast(dictOffsetItem);
                        this.OutputList.addLast(new CFFFont.UInt8Item((char) 18));
                        seek(position2);
                    } else {
                        this.OutputList.addLast(new CFFFont.RangeItem(this.buf, position, position2 - position));
                    }
                }
            }
            this.OutputList.addLast(new CFFFont.IndexMarkerItem(indexOffsetItemArr[i4], indexBaseItem));
            i4 = i2;
        }
    }

    public void ReconstructPrivateDict(int i, CFFFont.OffsetItem[] offsetItemArr, CFFFont.IndexBaseItem[] indexBaseItemArr, CFFFont.OffsetItem[] offsetItemArr2) {
        for (int i2 = 0; i2 < this.fonts[i].fdprivateOffsets.length; i2++) {
            this.OutputList.addLast(new CFFFont.MarkerItem(offsetItemArr[i2]));
            CFFFont.IndexBaseItem indexBaseItem = new CFFFont.IndexBaseItem();
            indexBaseItemArr[i2] = indexBaseItem;
            this.OutputList.addLast(indexBaseItem);
            seek(this.fonts[i].fdprivateOffsets[i2]);
            while (true) {
                int position = getPosition();
                CFFFont.Font font = this.fonts[i];
                if (position < font.fdprivateOffsets[i2] + font.fdprivateLengths[i2]) {
                    int position2 = getPosition();
                    getDictItem();
                    int position3 = getPosition();
                    if (this.key == "Subrs") {
                        CFFFont.DictOffsetItem dictOffsetItem = new CFFFont.DictOffsetItem();
                        offsetItemArr2[i2] = dictOffsetItem;
                        this.OutputList.addLast(dictOffsetItem);
                        this.OutputList.addLast(new CFFFont.UInt8Item((char) 19));
                    } else {
                        this.OutputList.addLast(new CFFFont.RangeItem(this.buf, position2, position3 - position2));
                    }
                }
            }
        }
    }

    public void ReconstructPrivateSubrs(int i, CFFFont.IndexBaseItem[] indexBaseItemArr, CFFFont.OffsetItem[] offsetItemArr) {
        int i2 = 0;
        while (true) {
            CFFFont.Font font = this.fonts[i];
            if (i2 >= font.fdprivateLengths.length) {
                return;
            }
            CFFFont.OffsetItem offsetItem = offsetItemArr[i2];
            if (offsetItem != null && font.PrivateSubrsOffset[i2] >= 0) {
                this.OutputList.addLast(new CFFFont.SubrMarkerItem(offsetItem, indexBaseItemArr[i2]));
                byte[] bArr = this.NewLSubrsIndex[i2];
                if (bArr != null) {
                    this.OutputList.addLast(new CFFFont.RangeItem(new RandomAccessFileOrArray(bArr), 0, this.NewLSubrsIndex[i2].length));
                }
            }
            i2++;
        }
    }

    public int StackOpp() {
        String str = this.key;
        if (str == "ifelse") {
            return -3;
        }
        if (str == "roll" || str == "put") {
            return -2;
        }
        if (str == "callsubr" || str == "callgsubr" || str == "add" || str == "sub" || str == "div" || str == "mul" || str == "drop" || str == "and" || str == "or" || str == "eq") {
            return -1;
        }
        if (str == "abs" || str == "neg" || str == "sqrt" || str == "exch" || str == "index" || str == "get" || str == "not" || str == "return") {
            return 0;
        }
        return (str == "random" || str == "dup") ? 1 : 2;
    }

    public int countEntireIndexRange(int i) {
        seek(i);
        char card16 = getCard16();
        if (card16 == 0) {
            return 2;
        }
        char card8 = getCard8();
        seek(i + 3 + (card16 * card8));
        return ((card16 + 1) * card8) + 3 + (getOffset(card8) - 1);
    }

    public void readFDSelect(int i) {
        CFFFont.Font font = this.fonts[i];
        int i2 = font.nglyphs;
        int[] iArr = new int[i2];
        seek(font.fdselectOffset);
        this.fonts[i].FDSelectFormat = getCard8();
        int i3 = this.fonts[i].FDSelectFormat;
        if (i3 == 0) {
            for (int i4 = 0; i4 < i2; i4++) {
                iArr[i4] = getCard8();
            }
            CFFFont.Font font2 = this.fonts[i];
            font2.FDSelectLength = font2.nglyphs + 1;
        } else if (i3 == 3) {
            char card16 = getCard16();
            char card17 = getCard16();
            int i5 = 0;
            int i6 = 0;
            while (i5 < card16) {
                char card8 = getCard8();
                char card18 = getCard16();
                int i7 = card18 - card17;
                for (int i8 = 0; i8 < i7; i8++) {
                    iArr[i6] = card8;
                    i6++;
                }
                i5++;
                card17 = card18;
            }
            this.fonts[i].FDSelectLength = (card16 * 3) + 5;
        }
        this.fonts[i].FDSelect = iArr;
    }
}
