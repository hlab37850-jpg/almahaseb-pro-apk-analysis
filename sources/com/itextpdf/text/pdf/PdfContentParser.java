package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class PdfContentParser {
    public static final int COMMAND_TYPE = 200;
    private PRTokeniser tokeniser;

    /* JADX INFO: renamed from: com.itextpdf.text.pdf.PdfContentParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType;

        static {
            int[] iArr = new int[PRTokeniser.TokenType.values().length];
            $SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType = iArr;
            try {
                iArr[PRTokeniser.TokenType.START_DIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType[PRTokeniser.TokenType.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType[PRTokeniser.TokenType.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType[PRTokeniser.TokenType.NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType[PRTokeniser.TokenType.NUMBER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType[PRTokeniser.TokenType.OTHER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public PdfContentParser(PRTokeniser pRTokeniser) {
        this.tokeniser = pRTokeniser;
    }

    public PRTokeniser getTokeniser() {
        return this.tokeniser;
    }

    public boolean nextValidToken() {
        while (this.tokeniser.nextToken()) {
            if (this.tokeniser.getTokenType() != PRTokeniser.TokenType.COMMENT) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<PdfObject> parse(ArrayList<PdfObject> arrayList) {
        PdfObject pRObject;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        do {
            pRObject = readPRObject();
            if (pRObject == null) {
                break;
            }
            arrayList.add(pRObject);
        } while (pRObject.type() != 200);
        return arrayList;
    }

    public PdfArray readArray() throws IOException {
        PdfArray pdfArray = new PdfArray();
        while (true) {
            PdfObject pRObject = readPRObject();
            int i = -pRObject.type();
            if (i == PRTokeniser.TokenType.END_ARRAY.ordinal()) {
                return pdfArray;
            }
            if (i == PRTokeniser.TokenType.END_DIC.ordinal()) {
                throw new IOException(MessageLocalization.getComposedMessage("unexpected.gt.gt", new Object[0]));
            }
            pdfArray.add(pRObject);
        }
    }

    public PdfDictionary readDictionary() throws IOException {
        PdfDictionary pdfDictionary = new PdfDictionary();
        while (nextValidToken()) {
            PRTokeniser.TokenType tokenType = this.tokeniser.getTokenType();
            PRTokeniser.TokenType tokenType2 = PRTokeniser.TokenType.END_DIC;
            if (tokenType == tokenType2) {
                return pdfDictionary;
            }
            if (this.tokeniser.getTokenType() != PRTokeniser.TokenType.OTHER || !"def".equals(this.tokeniser.getStringValue())) {
                if (this.tokeniser.getTokenType() != PRTokeniser.TokenType.NAME) {
                    throw new IOException(MessageLocalization.getComposedMessage("dictionary.key.1.is.not.a.name", this.tokeniser.getStringValue()));
                }
                PdfName pdfName = new PdfName(this.tokeniser.getStringValue(), false);
                PdfObject pRObject = readPRObject();
                int i = -pRObject.type();
                if (i == tokenType2.ordinal()) {
                    throw new IOException(MessageLocalization.getComposedMessage("unexpected.gt.gt", new Object[0]));
                }
                if (i == PRTokeniser.TokenType.END_ARRAY.ordinal()) {
                    throw new IOException(MessageLocalization.getComposedMessage("unexpected.close.bracket", new Object[0]));
                }
                pdfDictionary.put(pdfName, pRObject);
            }
        }
        throw new IOException(MessageLocalization.getComposedMessage("unexpected.end.of.file", new Object[0]));
    }

    public PdfObject readPRObject() {
        if (!nextValidToken()) {
            return null;
        }
        PRTokeniser.TokenType tokenType = this.tokeniser.getTokenType();
        switch (AnonymousClass1.$SwitchMap$com$itextpdf$text$pdf$PRTokeniser$TokenType[tokenType.ordinal()]) {
            case 1:
                return readDictionary();
            case 2:
                return readArray();
            case 3:
                return new PdfString(this.tokeniser.getStringValue(), null).setHexWriting(this.tokeniser.isHexString());
            case 4:
                return new PdfName(this.tokeniser.getStringValue(), false);
            case 5:
                return new PdfNumber(this.tokeniser.getStringValue());
            case 6:
                return new PdfLiteral(200, this.tokeniser.getStringValue());
            default:
                return new PdfLiteral(-tokenType.ordinal(), this.tokeniser.getStringValue());
        }
    }

    public void setTokeniser(PRTokeniser pRTokeniser) {
        this.tokeniser = pRTokeniser;
    }
}
