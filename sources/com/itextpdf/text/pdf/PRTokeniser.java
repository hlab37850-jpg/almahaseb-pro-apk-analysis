package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.InvalidPdfException;
import com.itextpdf.text.io.RandomAccessSourceFactory;

/* JADX INFO: loaded from: classes3.dex */
public class PRTokeniser {
    static final String EMPTY = "";
    public static final boolean[] delims = {true, true, false, false, false, false, false, false, false, false, true, true, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, true, false, false, true, true, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
    private final RandomAccessFileOrArray file;
    protected int generation;
    protected boolean hexString;
    private final StringBuilder outBuf = new StringBuilder();
    protected int reference;
    protected String stringValue;
    protected TokenType type;

    public enum TokenType {
        NUMBER,
        STRING,
        NAME,
        COMMENT,
        START_ARRAY,
        END_ARRAY,
        START_DIC,
        END_DIC,
        REF,
        OTHER,
        ENDOFFILE
    }

    public PRTokeniser(RandomAccessFileOrArray randomAccessFileOrArray) {
        this.file = randomAccessFileOrArray;
    }

    public static long[] checkObjectStart(byte[] bArr) {
        try {
            PRTokeniser pRTokeniser = new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().createSource(bArr)));
            if (pRTokeniser.nextToken()) {
                TokenType tokenType = pRTokeniser.getTokenType();
                TokenType tokenType2 = TokenType.NUMBER;
                if (tokenType == tokenType2) {
                    int iIntValue = pRTokeniser.intValue();
                    if (pRTokeniser.nextToken() && pRTokeniser.getTokenType() == tokenType2) {
                        int iIntValue2 = pRTokeniser.intValue();
                        if (pRTokeniser.nextToken() && pRTokeniser.getStringValue().equals("obj")) {
                            return new long[]{iIntValue, iIntValue2};
                        }
                        return null;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static int getHex(int i) {
        if (i >= 48 && i <= 57) {
            return i - 48;
        }
        if (i >= 65 && i <= 70) {
            return i - 55;
        }
        if (i < 97 || i > 102) {
            return -1;
        }
        return i - 87;
    }

    public static final boolean isDelimiter(int i) {
        return i == 40 || i == 41 || i == 60 || i == 62 || i == 91 || i == 93 || i == 47 || i == 37;
    }

    public static final boolean isDelimiterWhitespace(int i) {
        return delims[i + 1];
    }

    public static final boolean isWhitespace(int i, boolean z) {
        return (z && i == 0) || i == 9 || i == 10 || i == 12 || i == 13 || i == 32;
    }

    public void backOnePosition(int i) {
        if (i != -1) {
            this.file.pushBack((byte) i);
        }
    }

    public void checkFdfHeader() throws InvalidPdfException {
        this.file.seek(0L);
        if (readString(1024).indexOf("%FDF-") != 0) {
            throw new InvalidPdfException(MessageLocalization.getComposedMessage("fdf.header.not.found", new Object[0]));
        }
    }

    public char checkPdfHeader() throws InvalidPdfException {
        this.file.seek(0L);
        String string = readString(1024);
        if (string.indexOf("%PDF-") == 0) {
            return string.charAt(7);
        }
        throw new InvalidPdfException(MessageLocalization.getComposedMessage("pdf.header.not.found", new Object[0]));
    }

    public void close() {
        this.file.close();
    }

    public RandomAccessFileOrArray getFile() {
        return this.file;
    }

    public long getFilePointer() {
        return this.file.getFilePointer();
    }

    public int getGeneration() {
        return this.generation;
    }

    public int getHeaderOffset() throws InvalidPdfException {
        String string = readString(1024);
        int iIndexOf = string.indexOf("%PDF-");
        if (iIndexOf >= 0 || (iIndexOf = string.indexOf("%FDF-")) >= 0) {
            return iIndexOf;
        }
        throw new InvalidPdfException(MessageLocalization.getComposedMessage("pdf.header.not.found", new Object[0]));
    }

    public int getReference() {
        return this.reference;
    }

    public RandomAccessFileOrArray getSafeFile() {
        return new RandomAccessFileOrArray(this.file);
    }

    public long getStartxref() throws InvalidPdfException {
        long j = 1024;
        long length = this.file.length() - j;
        if (length < 1) {
            length = 1;
        }
        while (length > 0) {
            this.file.seek(length);
            int iLastIndexOf = readString(1024).lastIndexOf("startxref");
            if (iLastIndexOf >= 0) {
                return length + ((long) iLastIndexOf);
            }
            length = (length - j) + 9;
        }
        throw new InvalidPdfException(MessageLocalization.getComposedMessage("pdf.startxref.not.found", new Object[0]));
    }

    public String getStringValue() {
        return this.stringValue;
    }

    public TokenType getTokenType() {
        return this.type;
    }

    public int intValue() {
        return Integer.parseInt(this.stringValue);
    }

    public boolean isHexString() {
        return this.hexString;
    }

    public long length() {
        return this.file.length();
    }

    public long longValue() {
        return Long.parseLong(this.stringValue);
    }

    public boolean nextToken() throws InvalidPdfException {
        int i;
        int i2;
        int i3;
        boolean z;
        int hex;
        int i4;
        int i5;
        do {
            i = this.file.read();
            if (i == -1) {
                break;
            }
        } while (isWhitespace(i));
        if (i == -1) {
            this.type = TokenType.ENDOFFILE;
            return false;
        }
        this.outBuf.setLength(0);
        this.stringValue = "";
        if (i == 37) {
            this.type = TokenType.COMMENT;
            do {
                i2 = this.file.read();
                if (i2 == -1 || i2 == 13) {
                    break;
                }
            } while (i2 != 10);
        } else if (i == 40) {
            this.outBuf.setLength(0);
            this.type = TokenType.STRING;
            this.hexString = false;
            int i6 = 0;
            while (true) {
                i3 = this.file.read();
                if (i3 == -1) {
                    break;
                }
                if (i3 != 40) {
                    if (i3 != 41) {
                        if (i3 != 92) {
                            if (i3 == 13) {
                                i3 = this.file.read();
                                if (i3 < 0) {
                                    break;
                                }
                                if (i3 != 10) {
                                    backOnePosition(i3);
                                    i3 = 10;
                                }
                            }
                        } else {
                            i3 = this.file.read();
                            if (i3 == 10) {
                                z = true;
                            } else if (i3 != 13) {
                                if (i3 != 92) {
                                    if (i3 == 98) {
                                        i3 = 8;
                                    } else if (i3 == 102) {
                                        i3 = 12;
                                    } else if (i3 == 110) {
                                        i3 = 10;
                                    } else if (i3 == 114) {
                                        i3 = 13;
                                    } else if (i3 == 116) {
                                        i3 = 9;
                                    } else if (i3 != 40 && i3 != 41 && i3 >= 48 && i3 <= 55) {
                                        i3 -= 48;
                                        int i7 = this.file.read();
                                        if (i7 < 48 || i7 > 55) {
                                            backOnePosition(i7);
                                        } else {
                                            i3 = ((i3 << 3) + i7) - 48;
                                            int i8 = this.file.read();
                                            if (i8 < 48 || i8 > 55) {
                                                backOnePosition(i8);
                                            } else {
                                                i3 = (((i3 << 3) + i8) - 48) & 255;
                                            }
                                        }
                                    }
                                }
                                z = false;
                            } else {
                                i3 = this.file.read();
                                if (i3 != 10) {
                                    backOnePosition(i3);
                                }
                                z = true;
                            }
                            if (!z) {
                                if (i3 >= 0) {
                                    break;
                                }
                                break;
                            }
                            continue;
                        }
                    } else {
                        i6--;
                    }
                } else {
                    i6++;
                }
                if (i6 == -1) {
                    break;
                }
                this.outBuf.append((char) i3);
            }
            if (i3 == -1) {
                throwError(MessageLocalization.getComposedMessage("error.reading.string", new Object[0]));
            }
        } else if (i == 47) {
            this.outBuf.setLength(0);
            this.type = TokenType.NAME;
            while (true) {
                hex = this.file.read();
                if (delims[hex + 1]) {
                    break;
                }
                if (hex == 35) {
                    hex = (getHex(this.file.read()) << 4) + getHex(this.file.read());
                }
                this.outBuf.append((char) hex);
            }
            backOnePosition(hex);
        } else if (i == 60) {
            int hex2 = this.file.read();
            if (hex2 == 60) {
                this.type = TokenType.START_DIC;
            } else {
                this.outBuf.setLength(0);
                this.type = TokenType.STRING;
                this.hexString = true;
                int hex3 = 0;
                while (true) {
                    if (!isWhitespace(hex2)) {
                        if (hex2 == 62 || (hex2 = getHex(hex2)) < 0) {
                            break;
                        }
                        hex3 = this.file.read();
                        while (isWhitespace(hex3)) {
                            hex3 = this.file.read();
                        }
                        if (hex3 == 62) {
                            this.outBuf.append((char) (hex2 << 4));
                            break;
                        }
                        hex3 = getHex(hex3);
                        if (hex3 < 0) {
                            break;
                        }
                        this.outBuf.append((char) ((hex2 << 4) + hex3));
                        hex2 = this.file.read();
                    } else {
                        hex2 = this.file.read();
                    }
                }
                if (hex2 < 0 || hex3 < 0) {
                    throwError(MessageLocalization.getComposedMessage("error.reading.string", new Object[0]));
                }
            }
        } else if (i == 62) {
            if (this.file.read() != 62) {
                throwError(MessageLocalization.getComposedMessage("greaterthan.not.expected", new Object[0]));
            }
            this.type = TokenType.END_DIC;
        } else if (i == 91) {
            this.type = TokenType.START_ARRAY;
        } else if (i != 93) {
            this.outBuf.setLength(0);
            if (i == 45 || i == 43 || i == 46 || (i >= 48 && i <= 57)) {
                this.type = TokenType.NUMBER;
                if (i == 45) {
                    int i9 = 0;
                    do {
                        i9++;
                        i5 = this.file.read();
                    } while (i5 == 45);
                    this.outBuf.append('-');
                    i4 = i9;
                    i = i5;
                } else {
                    this.outBuf.append((char) i);
                    i = this.file.read();
                    i4 = 0;
                }
                boolean z2 = false;
                while (i != -1 && ((i >= 48 && i <= 57) || i == 46)) {
                    if (i == 46) {
                        z2 = true;
                    }
                    this.outBuf.append((char) i);
                    i = this.file.read();
                }
                if (i4 > 1 && !z2) {
                    this.outBuf.setLength(0);
                    this.outBuf.append('0');
                }
            } else {
                this.type = TokenType.OTHER;
                do {
                    this.outBuf.append((char) i);
                    i = this.file.read();
                } while (!delims[i + 1]);
            }
            if (i != -1) {
                backOnePosition(i);
            }
        } else {
            this.type = TokenType.END_ARRAY;
        }
        StringBuilder sb = this.outBuf;
        if (sb != null) {
            this.stringValue = sb.toString();
        }
        return true;
    }

    public void nextValidToken() {
        int i = 0;
        String str = null;
        long filePointer = 0;
        String str2 = null;
        while (nextToken()) {
            TokenType tokenType = this.type;
            if (tokenType != TokenType.COMMENT) {
                if (i != 0) {
                    if (i != 1) {
                        if (tokenType == TokenType.OTHER && this.stringValue.equals("R")) {
                            this.type = TokenType.REF;
                            this.reference = Integer.parseInt(str);
                            this.generation = Integer.parseInt(str2);
                            return;
                        } else {
                            this.file.seek(filePointer);
                            this.type = TokenType.NUMBER;
                            this.stringValue = str;
                            return;
                        }
                    }
                    TokenType tokenType2 = TokenType.NUMBER;
                    if (tokenType != tokenType2) {
                        this.file.seek(filePointer);
                        this.type = tokenType2;
                        this.stringValue = str;
                        return;
                    }
                    str2 = this.stringValue;
                } else {
                    if (tokenType != TokenType.NUMBER) {
                        return;
                    }
                    filePointer = this.file.getFilePointer();
                    str = this.stringValue;
                }
                i++;
            }
        }
        if (i == 1) {
            this.type = TokenType.NUMBER;
        }
    }

    public int read() {
        return this.file.read();
    }

    public boolean readLineSegment(byte[] bArr) {
        return readLineSegment(bArr, true);
    }

    public String readString(int i) {
        int i2;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i3 = i - 1;
            if (i <= 0 || (i2 = read()) == -1) {
                break;
            }
            sb.append((char) i2);
            i = i3;
        }
        return sb.toString();
    }

    public void seek(long j) {
        this.file.seek(j);
    }

    public void throwError(String str) throws InvalidPdfException {
        throw new InvalidPdfException(MessageLocalization.getComposedMessage("1.at.file.pointer.2", str, String.valueOf(this.file.getFilePointer())));
    }

    public static final boolean isWhitespace(int i) {
        return isWhitespace(i, true);
    }

    public boolean readLineSegment(byte[] bArr, boolean z) {
        boolean z2;
        int i;
        int length = bArr.length;
        if (length > 0) {
            do {
                i = read();
            } while (isWhitespace(i, z));
            z2 = false;
        } else {
            z2 = false;
            i = -1;
        }
        int i2 = 0;
        while (!z2 && i2 < length) {
            if (i == -1 || i == 10) {
                z2 = true;
            } else if (i != 13) {
                bArr[i2] = (byte) i;
                i2++;
            } else {
                long filePointer = getFilePointer();
                if (read() != 10) {
                    seek(filePointer);
                }
                z2 = true;
            }
            if (z2 || length <= i2) {
                break;
            }
            i = read();
        }
        if (i2 >= length) {
            boolean z3 = false;
            while (!z3) {
                i = read();
                if (i != -1 && i != 10) {
                    if (i == 13) {
                        long filePointer2 = getFilePointer();
                        if (read() != 10) {
                            seek(filePointer2);
                        }
                    }
                }
                z3 = true;
            }
        }
        if (i == -1 && i2 == 0) {
            return false;
        }
        if (i2 + 2 <= length) {
            bArr[i2] = 32;
            bArr[i2 + 1] = 88;
        }
        return true;
    }
}
