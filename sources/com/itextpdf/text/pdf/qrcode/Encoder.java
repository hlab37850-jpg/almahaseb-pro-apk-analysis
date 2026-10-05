package com.itextpdf.text.pdf.qrcode;

import com.google.common.primitives.UnsignedBytes;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Encoder {
    private static final int[] ALPHANUMERIC_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    static final String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";

    private Encoder() {
    }

    public static void append8BitBytes(String str, BitVector bitVector, String str2) throws WriterException {
        try {
            byte[] bytes = str.getBytes(str2);
            for (byte b : bytes) {
                bitVector.appendBits(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e.toString());
        }
    }

    public static void appendAlphanumericBytes(String str, BitVector bitVector) throws WriterException {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int alphanumericCode = getAlphanumericCode(str.charAt(i));
            if (alphanumericCode == -1) {
                throw new WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int alphanumericCode2 = getAlphanumericCode(str.charAt(i2));
                if (alphanumericCode2 == -1) {
                    throw new WriterException();
                }
                bitVector.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                i += 2;
            } else {
                bitVector.appendBits(alphanumericCode, 6);
                i = i2;
            }
        }
    }

    public static void appendBytes(String str, Mode mode, BitVector bitVector, String str2) throws WriterException {
        if (mode.equals(Mode.NUMERIC)) {
            appendNumericBytes(str, bitVector);
            return;
        }
        if (mode.equals(Mode.ALPHANUMERIC)) {
            appendAlphanumericBytes(str, bitVector);
            return;
        }
        if (mode.equals(Mode.BYTE)) {
            append8BitBytes(str, bitVector, str2);
        } else {
            if (mode.equals(Mode.KANJI)) {
                appendKanjiBytes(str, bitVector);
                return;
            }
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    private static void appendECI(CharacterSetECI characterSetECI, BitVector bitVector) {
        bitVector.appendBits(Mode.ECI.getBits(), 4);
        bitVector.appendBits(characterSetECI.getValue(), 8);
    }

    public static void appendKanjiBytes(String str, BitVector bitVector) throws WriterException {
        int i;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = ((bytes[i2] & UnsignedBytes.MAX_VALUE) << 8) | (bytes[i2 + 1] & UnsignedBytes.MAX_VALUE);
                int i4 = 33088;
                if (i3 >= 33088 && i3 <= 40956) {
                    i = i3 - i4;
                } else if (i3 < 57408 || i3 > 60351) {
                    i = -1;
                } else {
                    i4 = 49472;
                    i = i3 - i4;
                }
                if (i == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                bitVector.appendBits(((i >> 8) * 192) + (i & 255), 13);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e.toString());
        }
    }

    public static void appendLengthInfo(int i, int i2, Mode mode, BitVector bitVector) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(Version.getVersionForNumber(i2));
        int i3 = (1 << characterCountBits) - 1;
        if (i <= i3) {
            bitVector.appendBits(i, characterCountBits);
            return;
        }
        throw new WriterException(i + "is bigger than" + i3);
    }

    public static void appendModeInfo(Mode mode, BitVector bitVector) {
        bitVector.appendBits(mode.getBits(), 4);
    }

    public static void appendNumericBytes(String str, BitVector bitVector) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int iCharAt = str.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                bitVector.appendBits((iCharAt * 100) + ((str.charAt(i + 1) - '0') * 10) + (str.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    bitVector.appendBits((iCharAt * 10) + (str.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    bitVector.appendBits(iCharAt, 4);
                }
            }
        }
    }

    private static int calculateMaskPenalty(ByteMatrix byteMatrix) {
        return MaskUtil.applyMaskPenaltyRule1(byteMatrix) + MaskUtil.applyMaskPenaltyRule2(byteMatrix) + MaskUtil.applyMaskPenaltyRule3(byteMatrix) + MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }

    private static int chooseMaskPattern(BitVector bitVector, ErrorCorrectionLevel errorCorrectionLevel, int i, ByteMatrix byteMatrix) throws WriterException {
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < 8; i4++) {
            MatrixUtil.buildMatrix(bitVector, errorCorrectionLevel, i, i4, byteMatrix);
            int iCalculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (iCalculateMaskPenalty < i2) {
                i3 = i4;
                i2 = iCalculateMaskPenalty;
            }
        }
        return i3;
    }

    public static Mode chooseMode(String str) {
        return chooseMode(str, null);
    }

    public static void encode(String str, ErrorCorrectionLevel errorCorrectionLevel, QRCode qRCode) throws WriterException {
        encode(str, errorCorrectionLevel, null, qRCode);
    }

    public static ByteArray generateECBytes(ByteArray byteArray, int i) {
        int size = byteArray.size();
        int[] iArr = new int[size + i];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = byteArray.at(i2);
        }
        new ReedSolomonEncoder(GF256.QR_CODE_FIELD).encode(iArr, i);
        ByteArray byteArray2 = new ByteArray(i);
        for (int i3 = 0; i3 < i; i3++) {
            byteArray2.set(i3, iArr[size + i3]);
        }
        return byteArray2;
    }

    public static int getAlphanumericCode(int i) {
        int[] iArr = ALPHANUMERIC_TABLE;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    public static void getNumDataBytesAndNumECBytesForBlockID(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 >= i3) {
            throw new WriterException("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        int i11 = i7 - i9;
        int i12 = i8 - i10;
        if (i11 != i12) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i3 != i6 + i5) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i4 < i6) {
            iArr[0] = i9;
            iArr2[0] = i11;
        } else {
            iArr[0] = i10;
            iArr2[0] = i12;
        }
    }

    private static void initQRCode(int i, ErrorCorrectionLevel errorCorrectionLevel, Mode mode, QRCode qRCode) throws WriterException {
        qRCode.setECLevel(errorCorrectionLevel);
        qRCode.setMode(mode);
        for (int i2 = 1; i2 <= 40; i2++) {
            Version versionForNumber = Version.getVersionForNumber(i2);
            int totalCodewords = versionForNumber.getTotalCodewords();
            Version.ECBlocks eCBlocksForLevel = versionForNumber.getECBlocksForLevel(errorCorrectionLevel);
            int totalECCodewords = eCBlocksForLevel.getTotalECCodewords();
            int numBlocks = eCBlocksForLevel.getNumBlocks();
            int i3 = totalCodewords - totalECCodewords;
            if (i3 >= i + 3) {
                qRCode.setVersion(i2);
                qRCode.setNumTotalBytes(totalCodewords);
                qRCode.setNumDataBytes(i3);
                qRCode.setNumRSBlocks(numBlocks);
                qRCode.setNumECBytes(totalECCodewords);
                qRCode.setMatrixWidth(versionForNumber.getDimensionForVersion());
                return;
            }
        }
        throw new WriterException("Cannot find proper rs block info (input data too big?)");
    }

    public static void interleaveWithECBytes(BitVector bitVector, int i, int i2, int i3, BitVector bitVector2) throws WriterException {
        if (bitVector.sizeInBytes() != i2) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        int iMax = 0;
        int iMax2 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            getNumDataBytesAndNumECBytesForBlockID(i, i2, i3, i5, iArr, iArr2);
            ByteArray byteArray = new ByteArray();
            byteArray.set(bitVector.getArray(), i4, iArr[0]);
            ByteArray byteArrayGenerateECBytes = generateECBytes(byteArray, iArr2[0]);
            arrayList.add(new BlockPair(byteArray, byteArrayGenerateECBytes));
            iMax = Math.max(iMax, byteArray.size());
            iMax2 = Math.max(iMax2, byteArrayGenerateECBytes.size());
            i4 += iArr[0];
        }
        if (i2 != i4) {
            throw new WriterException("Data bytes does not match offset");
        }
        for (int i6 = 0; i6 < iMax; i6++) {
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                ByteArray dataBytes = ((BlockPair) arrayList.get(i7)).getDataBytes();
                if (i6 < dataBytes.size()) {
                    bitVector2.appendBits(dataBytes.at(i6), 8);
                }
            }
        }
        for (int i8 = 0; i8 < iMax2; i8++) {
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                ByteArray errorCorrectionBytes = ((BlockPair) arrayList.get(i9)).getErrorCorrectionBytes();
                if (i8 < errorCorrectionBytes.size()) {
                    bitVector2.appendBits(errorCorrectionBytes.at(i8), 8);
                }
            }
        }
        if (i == bitVector2.sizeInBytes()) {
            return;
        }
        throw new WriterException("Interleaving error: " + i + " and " + bitVector2.sizeInBytes() + " differ.");
    }

    private static boolean isOnlyDoubleByteKanji(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & UnsignedBytes.MAX_VALUE;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    public static void terminateBits(int i, BitVector bitVector) throws WriterException {
        int i2 = i << 3;
        if (bitVector.size() > i2) {
            throw new WriterException("data bits cannot fit in the QR Code" + bitVector.size() + " > " + i2);
        }
        for (int i3 = 0; i3 < 4 && bitVector.size() < i2; i3++) {
            bitVector.appendBit(0);
        }
        int size = bitVector.size() % 8;
        if (size > 0) {
            int i4 = 8 - size;
            for (int i5 = 0; i5 < i4; i5++) {
                bitVector.appendBit(0);
            }
        }
        if (bitVector.size() % 8 != 0) {
            throw new WriterException("Number of bits is not a multiple of 8");
        }
        int iSizeInBytes = i - bitVector.sizeInBytes();
        for (int i6 = 0; i6 < iSizeInBytes; i6++) {
            if (i6 % 2 == 0) {
                bitVector.appendBits(236, 8);
            } else {
                bitVector.appendBits(17, 8);
            }
        }
        if (bitVector.size() != i2) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    public static Mode chooseMode(String str, String str2) {
        if ("Shift_JIS".equals(str2)) {
            return isOnlyDoubleByteKanji(str) ? Mode.KANJI : Mode.BYTE;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z2 = true;
            } else {
                if (getAlphanumericCode(cCharAt) == -1) {
                    return Mode.BYTE;
                }
                z = true;
            }
        }
        if (z) {
            return Mode.ALPHANUMERIC;
        }
        return z2 ? Mode.NUMERIC : Mode.BYTE;
    }

    public static void encode(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, Object> map, QRCode qRCode) throws WriterException {
        CharacterSetECI characterSetECIByName;
        String str2 = map == null ? null : (String) map.get(EncodeHintType.CHARACTER_SET);
        if (str2 == null) {
            str2 = DEFAULT_BYTE_MODE_ENCODING;
        }
        Mode modeChooseMode = chooseMode(str, str2);
        BitVector bitVector = new BitVector();
        appendBytes(str, modeChooseMode, bitVector, str2);
        initQRCode(bitVector.sizeInBytes(), errorCorrectionLevel, modeChooseMode, qRCode);
        BitVector bitVector2 = new BitVector();
        Mode mode = Mode.BYTE;
        if (modeChooseMode == mode && !DEFAULT_BYTE_MODE_ENCODING.equals(str2) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(str2)) != null) {
            appendECI(characterSetECIByName, bitVector2);
        }
        appendModeInfo(modeChooseMode, bitVector2);
        appendLengthInfo(modeChooseMode.equals(mode) ? bitVector.sizeInBytes() : str.length(), qRCode.getVersion(), modeChooseMode, bitVector2);
        bitVector2.appendBitVector(bitVector);
        terminateBits(qRCode.getNumDataBytes(), bitVector2);
        BitVector bitVector3 = new BitVector();
        interleaveWithECBytes(bitVector2, qRCode.getNumTotalBytes(), qRCode.getNumDataBytes(), qRCode.getNumRSBlocks(), bitVector3);
        ByteMatrix byteMatrix = new ByteMatrix(qRCode.getMatrixWidth(), qRCode.getMatrixWidth());
        qRCode.setMaskPattern(chooseMaskPattern(bitVector3, qRCode.getECLevel(), qRCode.getVersion(), byteMatrix));
        MatrixUtil.buildMatrix(bitVector3, qRCode.getECLevel(), qRCode.getVersion(), qRCode.getMaskPattern(), byteMatrix);
        qRCode.setMatrix(byteMatrix);
        if (qRCode.isValid()) {
            return;
        }
        throw new WriterException("Invalid QR code: " + qRCode.toString());
    }
}
