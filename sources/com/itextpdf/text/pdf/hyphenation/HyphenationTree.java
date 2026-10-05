package com.itextpdf.text.pdf.hyphenation;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class HyphenationTree extends TernaryTree implements PatternConsumer {
    private static final long serialVersionUID = -7763254239309429432L;
    private transient TernaryTree ivalues;
    protected ByteVector vspace;
    protected HashMap<String, ArrayList<Object>> stoplist = new HashMap<>(23);
    protected TernaryTree classmap = new TernaryTree();

    public HyphenationTree() {
        ByteVector byteVector = new ByteVector();
        this.vspace = byteVector;
        byteVector.alloc(1);
    }

    @Override // com.itextpdf.text.pdf.hyphenation.PatternConsumer
    public void addClass(String str) {
        if (str.length() > 0) {
            char cCharAt = str.charAt(0);
            char[] cArr = new char[2];
            cArr[1] = 0;
            for (int i = 0; i < str.length(); i++) {
                cArr[0] = str.charAt(i);
                this.classmap.insert(cArr, 0, cCharAt);
            }
        }
    }

    @Override // com.itextpdf.text.pdf.hyphenation.PatternConsumer
    public void addException(String str, ArrayList<Object> arrayList) {
        this.stoplist.put(str, arrayList);
    }

    @Override // com.itextpdf.text.pdf.hyphenation.PatternConsumer
    public void addPattern(String str, String str2) {
        int iFind = this.ivalues.find(str2);
        if (iFind <= 0) {
            iFind = packValues(str2);
            this.ivalues.insert(str2, (char) iFind);
        }
        insert(str, (char) iFind);
    }

    public String findPattern(String str) {
        int iFind = super.find(str);
        return iFind >= 0 ? unpackValues(iFind) : "";
    }

    public byte[] getValues(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = i + 1;
        byte b = this.vspace.get(i);
        while (b != 0) {
            stringBuffer.append((char) ((b >>> 4) - 1));
            char c = (char) (b & 15);
            if (c == 0) {
                break;
            }
            stringBuffer.append((char) (c - 1));
            b = this.vspace.get(i2);
            i2++;
        }
        int length = stringBuffer.length();
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i3] = (byte) stringBuffer.charAt(i3);
        }
        return bArr;
    }

    public int hstrcmp(char[] cArr, int i, char[] cArr2, int i2) {
        while (true) {
            char c = cArr[i];
            char c2 = cArr2[i2];
            if (c != c2) {
                if (c2 == 0) {
                    return 0;
                }
                return c - c2;
            }
            if (c == 0) {
                return 0;
            }
            i++;
            i2++;
        }
    }

    public Hyphenation hyphenate(String str, int i, int i2) {
        char[] charArray = str.toCharArray();
        return hyphenate(charArray, 0, charArray.length, i, i2);
    }

    public void loadSimplePatterns(InputStream inputStream) {
        SimplePatternParser simplePatternParser = new SimplePatternParser();
        this.ivalues = new TernaryTree();
        simplePatternParser.parse(inputStream, this);
        trimToSize();
        this.vspace.trimToSize();
        this.classmap.trimToSize();
        this.ivalues = null;
    }

    public int packValues(String str) {
        int length = str.length();
        int i = (length & 1) == 1 ? (length >> 1) + 2 : (length >> 1) + 1;
        int iAlloc = this.vspace.alloc(i);
        byte[] array = this.vspace.getArray();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 >> 1;
            byte bCharAt = (byte) ((str.charAt(i2) - '/') & 15);
            if ((i2 & 1) == 1) {
                int i4 = i3 + iAlloc;
                array[i4] = (byte) (bCharAt | array[i4]);
            } else {
                array[i3 + iAlloc] = (byte) (bCharAt << 4);
            }
        }
        array[(i - 1) + iAlloc] = 0;
        return iAlloc;
    }

    @Override // com.itextpdf.text.pdf.hyphenation.TernaryTree
    public void printStats() {
        System.out.println("Value space size = " + Integer.toString(this.vspace.length()));
        super.printStats();
    }

    public void searchPatterns(char[] cArr, int i, byte[] bArr) {
        char c;
        char c2 = cArr[i];
        char c3 = this.root;
        int i2 = i;
        while (c3 > 0) {
            char[] cArr2 = this.sc;
            if (c3 >= cArr2.length) {
                return;
            }
            char c4 = cArr2[c3];
            int i3 = 0;
            if (c4 == 65535) {
                if (hstrcmp(cArr, i2, this.kv.getArray(), this.lo[c3]) == 0) {
                    byte[] values = getValues(this.eq[c3]);
                    int length = values.length;
                    while (i3 < length) {
                        byte b = values[i3];
                        if (i < bArr.length && b > bArr[i]) {
                            bArr[i] = b;
                        }
                        i++;
                        i3++;
                    }
                    return;
                }
                return;
            }
            int i4 = c2 - c4;
            if (i4 != 0) {
                c3 = i4 < 0 ? this.lo[c3] : this.hi[c3];
            } else {
                if (c2 == 0) {
                    return;
                }
                i2++;
                c2 = cArr[i2];
                c3 = this.eq[c3];
                char c5 = c3;
                while (c5 > 0) {
                    char[] cArr3 = this.sc;
                    if (c5 >= cArr3.length || (c = cArr3[c5]) == 65535) {
                        break;
                    }
                    if (c == 0) {
                        byte[] values2 = getValues(this.eq[c5]);
                        int length2 = values2.length;
                        int i5 = i;
                        while (i3 < length2) {
                            byte b2 = values2[i3];
                            if (i5 < bArr.length && b2 > bArr[i5]) {
                                bArr[i5] = b2;
                            }
                            i5++;
                            i3++;
                        }
                        break;
                    }
                    c5 = this.lo[c5];
                }
            }
        }
    }

    public String unpackValues(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = i + 1;
        byte b = this.vspace.get(i);
        while (b != 0) {
            stringBuffer.append((char) ((b >>> 4) + 47));
            char c = (char) (b & 15);
            if (c == 0) {
                break;
            }
            stringBuffer.append((char) (c + '/'));
            b = this.vspace.get(i2);
            i2++;
        }
        return stringBuffer.toString();
    }

    public Hyphenation hyphenate(char[] cArr, int i, int i2, int i3, int i4) {
        int i5;
        char[] cArr2 = new char[i2 + 3];
        char[] cArr3 = new char[2];
        int i6 = i2;
        boolean z = false;
        int i7 = 0;
        for (int i8 = 1; i8 <= i2; i8++) {
            cArr3[0] = cArr[(i + i8) - 1];
            int iFind = this.classmap.find(cArr3, 0);
            if (iFind < 0) {
                int i9 = i7 + 1;
                if (i8 == i9) {
                    i7 = i9;
                } else {
                    z = true;
                }
                i6--;
            } else {
                if (z) {
                    return null;
                }
                cArr2[i8 - i7] = (char) iFind;
            }
        }
        if (i6 < i3 + i4) {
            return null;
        }
        int i10 = i6 + 1;
        int[] iArr = new int[i10];
        String str = new String(cArr2, 1, i6);
        if (this.stoplist.containsKey(str)) {
            ArrayList<Object> arrayList = this.stoplist.get(str);
            int length = 0;
            i5 = 0;
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                Object obj = arrayList.get(i11);
                if ((obj instanceof String) && (length = length + ((String) obj).length()) >= i3 && length < i6 - i4) {
                    iArr[i5] = length + i7;
                    i5++;
                }
            }
        } else {
            cArr2[0] = '.';
            cArr2[i10] = '.';
            cArr2[i6 + 2] = 0;
            byte[] bArr = new byte[i6 + 3];
            for (int i12 = 0; i12 < i10; i12++) {
                searchPatterns(cArr2, i12, bArr);
            }
            int i13 = 0;
            int i14 = 0;
            while (i14 < i6) {
                int i15 = i14 + 1;
                if ((bArr[i15] & 1) == 1 && i14 >= i3 && i14 <= i6 - i4) {
                    iArr[i13] = i14 + i7;
                    i13++;
                }
                i14 = i15;
            }
            i5 = i13;
        }
        if (i5 <= 0) {
            return null;
        }
        int[] iArr2 = new int[i5];
        System.arraycopy(iArr, 0, iArr2, 0, i5);
        return new Hyphenation(new String(cArr, i, i2), iArr2);
    }
}
