package com.itextpdf.text.pdf;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes3.dex */
public class SequenceList {
    protected static final int COMMA = 1;
    private static final int DIGIT = 1;
    private static final int DIGIT2 = 3;
    protected static final int END = 6;
    protected static final char EOT = 65535;
    private static final int FIRST = 0;
    protected static final int MINUS = 2;
    protected static final int NOT = 3;
    private static final String NOT_OTHER = "-,!0123456789";
    protected static final int NUMBER = 5;
    private static final int OTHER = 2;
    protected static final int TEXT = 4;
    protected boolean even;
    protected int high;
    protected boolean inverse;
    protected int low;
    protected int number;
    protected boolean odd;
    protected String other;
    protected int ptr = 0;
    protected char[] text;

    public SequenceList(String str) {
        this.text = str.toCharArray();
    }

    public static List<Integer> expand(String str, int i) {
        SequenceList sequenceList = new SequenceList(str);
        LinkedList linkedList = new LinkedList();
        boolean attributes = false;
        while (!attributes) {
            attributes = sequenceList.getAttributes();
            int i2 = sequenceList.low;
            int i3 = -1;
            if (i2 != -1 || sequenceList.high != -1 || sequenceList.even || sequenceList.odd) {
                int i4 = 1;
                if (i2 < 1) {
                    sequenceList.low = 1;
                }
                int i5 = sequenceList.high;
                if (i5 < 1 || i5 > i) {
                    sequenceList.high = i;
                }
                if (sequenceList.low > i) {
                    sequenceList.low = i;
                }
                if (sequenceList.inverse) {
                    int i6 = sequenceList.low;
                    int i7 = sequenceList.high;
                    if (i6 > i7) {
                        sequenceList.low = i7;
                        sequenceList.high = i6;
                    }
                    ListIterator listIterator = linkedList.listIterator();
                    while (listIterator.hasNext()) {
                        int iIntValue = ((Integer) listIterator.next()).intValue();
                        if (!sequenceList.even || (iIntValue & 1) != 1) {
                            if (!sequenceList.odd || (iIntValue & 1) != 0) {
                                if (iIntValue >= sequenceList.low && iIntValue <= sequenceList.high) {
                                    listIterator.remove();
                                }
                            }
                        }
                    }
                } else {
                    int i8 = sequenceList.low;
                    if (i8 > sequenceList.high) {
                        if (sequenceList.odd || sequenceList.even) {
                            if (sequenceList.even) {
                                sequenceList.low = i8 & (-2);
                            } else {
                                sequenceList.low = i8 - ((i8 & 1) == 1 ? 0 : 1);
                            }
                            i3 = -2;
                        }
                        for (int i9 = sequenceList.low; i9 >= sequenceList.high; i9 += i3) {
                            linkedList.add(Integer.valueOf(i9));
                        }
                    } else {
                        boolean z = sequenceList.odd;
                        if (z || sequenceList.even) {
                            if (z) {
                                sequenceList.low = i8 | 1;
                            } else {
                                sequenceList.low = i8 + ((i8 & 1) != 1 ? 0 : 1);
                            }
                            i4 = 2;
                        }
                        for (int i10 = sequenceList.low; i10 <= sequenceList.high; i10 += i4) {
                            linkedList.add(Integer.valueOf(i10));
                        }
                    }
                }
            }
        }
        return linkedList;
    }

    private void otherProc() {
        if (this.other.equals("odd") || this.other.equals("o")) {
            this.odd = true;
            this.even = false;
        } else if (this.other.equals("even") || this.other.equals("e")) {
            this.odd = false;
            this.even = true;
        }
    }

    public boolean getAttributes() {
        char c;
        int type;
        this.low = -1;
        this.high = -1;
        this.inverse = false;
        this.even = false;
        this.odd = false;
        loop0: while (true) {
            c = 2;
            while (true) {
                type = getType();
                if (type == 6 || type == 1) {
                    break loop0;
                }
                if (c == 1) {
                    if (type != 2) {
                        if (type == 3) {
                            this.inverse = true;
                            this.high = this.low;
                            break;
                        }
                        this.high = this.low;
                        otherProc();
                        break;
                    }
                    c = 3;
                } else if (c != 2) {
                    if (c == 3 && type != 2) {
                        if (type == 3) {
                            this.inverse = true;
                            break;
                        }
                        if (type == 5) {
                            this.high = this.number;
                            break;
                        }
                        otherProc();
                        break;
                    }
                } else if (type == 2) {
                    c = 3;
                } else if (type == 3) {
                    this.inverse = true;
                } else if (type == 5) {
                    this.low = this.number;
                    c = 1;
                } else {
                    otherProc();
                }
            }
        }
        if (c == 1) {
            this.high = this.low;
        }
        return type == 6;
    }

    public int getType() {
        StringBuffer stringBuffer = new StringBuffer();
        char c = 0;
        while (true) {
            char cNextChar = nextChar();
            if (cNextChar == 65535) {
                if (c == 1) {
                    String string = stringBuffer.toString();
                    this.other = string;
                    this.number = Integer.parseInt(string);
                    return 5;
                }
                if (c != 2) {
                    return 6;
                }
                this.other = stringBuffer.toString().toLowerCase();
                return 4;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        continue;
                    } else {
                        if (NOT_OTHER.indexOf(cNextChar) >= 0) {
                            putBack();
                            this.other = stringBuffer.toString().toLowerCase();
                            return 4;
                        }
                        stringBuffer.append(cNextChar);
                    }
                } else {
                    if (cNextChar < '0' || cNextChar > '9') {
                        putBack();
                        String string2 = stringBuffer.toString();
                        this.other = string2;
                        this.number = Integer.parseInt(string2);
                        return 5;
                    }
                    stringBuffer.append(cNextChar);
                }
            } else {
                if (cNextChar == '!') {
                    return 3;
                }
                if (cNextChar == ',') {
                    return 1;
                }
                if (cNextChar == '-') {
                    return 2;
                }
                stringBuffer.append(cNextChar);
                c = (cNextChar < '0' || cNextChar > '9') ? (char) 2 : (char) 1;
            }
        }
    }

    public char nextChar() {
        char c;
        do {
            int i = this.ptr;
            char[] cArr = this.text;
            if (i >= cArr.length) {
                return EOT;
            }
            this.ptr = i + 1;
            c = cArr[i];
        } while (c <= ' ');
        return c;
    }

    public void putBack() {
        int i = this.ptr - 1;
        this.ptr = i;
        if (i < 0) {
            this.ptr = 0;
        }
    }
}
