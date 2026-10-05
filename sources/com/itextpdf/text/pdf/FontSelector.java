package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class FontSelector {
    protected ArrayList<Font> fonts = new ArrayList<>();
    protected Font currentFont = null;

    public void addFont(Font font) {
        if (font.getBaseFont() != null) {
            this.fonts.add(font);
        } else {
            this.fonts.add(new Font(font.getCalculatedBaseFont(true), font.getSize(), font.getCalculatedStyle(), font.getColor()));
        }
    }

    public Phrase process(String str) {
        if (this.fonts.size() == 0) {
            throw new IndexOutOfBoundsException(MessageLocalization.getComposedMessage("no.font.is.defined", new Object[0]));
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        Phrase phrase = new Phrase();
        this.currentFont = null;
        for (int i = 0; i < length; i++) {
            Chunk chunkProcessChar = processChar(charArray, i, stringBuffer);
            if (chunkProcessChar != null) {
                phrase.add((Element) chunkProcessChar);
            }
        }
        if (stringBuffer.length() > 0) {
            String string = stringBuffer.toString();
            Font font = this.currentFont;
            if (font == null) {
                font = this.fonts.get(0);
            }
            phrase.add((Element) new Chunk(string, font));
        }
        return phrase;
    }

    public Chunk processChar(char[] cArr, int i, StringBuffer stringBuffer) {
        char c = cArr[i];
        Chunk chunk = null;
        if (c == '\n' || c == '\r') {
            stringBuffer.append(c);
        } else if (Utilities.isSurrogatePair(cArr, i)) {
            int iConvertToUtf32 = Utilities.convertToUtf32(cArr, i);
            for (int i2 = 0; i2 < this.fonts.size(); i2++) {
                Font font = this.fonts.get(i2);
                if (font.getBaseFont().charExists(iConvertToUtf32) || Character.getType(iConvertToUtf32) == 16) {
                    if (this.currentFont != font) {
                        if (stringBuffer.length() > 0 && this.currentFont != null) {
                            chunk = new Chunk(stringBuffer.toString(), this.currentFont);
                            stringBuffer.setLength(0);
                        }
                        this.currentFont = font;
                    }
                    stringBuffer.append(c);
                    stringBuffer.append(cArr[i + 1]);
                    break;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.fonts.size(); i3++) {
                Font font2 = this.fonts.get(i3);
                if (font2.getBaseFont().charExists(c) || Character.getType(c) == 16) {
                    if (this.currentFont != font2) {
                        if (stringBuffer.length() > 0 && this.currentFont != null) {
                            chunk = new Chunk(stringBuffer.toString(), this.currentFont);
                            stringBuffer.setLength(0);
                        }
                        this.currentFont = font2;
                    }
                    stringBuffer.append(c);
                    break;
                }
            }
        }
        return chunk;
    }
}
