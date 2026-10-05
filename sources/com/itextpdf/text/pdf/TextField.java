package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class TextField extends BaseField {
    private String[] choiceExports;
    private ArrayList<Integer> choiceSelections;
    private String[] choices;
    private String defaultText;
    private BaseFont extensionFont;
    private float extraMarginLeft;
    private float extraMarginTop;
    private ArrayList<BaseFont> substitutionFonts;
    private int topFirst;
    private int visibleTopChoice;

    public TextField(PdfWriter pdfWriter, Rectangle rectangle, String str) {
        super(pdfWriter, rectangle, str);
        this.choiceSelections = new ArrayList<>();
        this.visibleTopChoice = -1;
    }

    private static void changeFontSize(Phrase phrase, float f) {
        for (int i = 0; i < phrase.size(); i++) {
            ((Chunk) phrase.get(i)).getFont().setSize(f);
        }
    }

    private static boolean checkRTL(String str) {
        if (str != null && str.length() != 0) {
            for (char c : str.toCharArray()) {
                if (c >= 1424 && c < 1920) {
                    return true;
                }
            }
        }
        return false;
    }

    private Phrase composePhrase(String str, BaseFont baseFont, BaseColor baseColor, float f) {
        ArrayList<BaseFont> arrayList;
        if (this.extensionFont == null && ((arrayList = this.substitutionFonts) == null || arrayList.isEmpty())) {
            return new Phrase(new Chunk(str, new Font(baseFont, f, 0, baseColor)));
        }
        FontSelector fontSelector = new FontSelector();
        fontSelector.addFont(new Font(baseFont, f, 0, baseColor));
        BaseFont baseFont2 = this.extensionFont;
        if (baseFont2 != null) {
            fontSelector.addFont(new Font(baseFont2, f, 0, baseColor));
        }
        if (this.substitutionFonts != null) {
            for (int i = 0; i < this.substitutionFonts.size(); i++) {
                fontSelector.addFont(new Font(this.substitutionFonts.get(i), f, 0, baseColor));
            }
        }
        return fontSelector.process(str);
    }

    private int getTopChoice() {
        Integer num;
        ArrayList<Integer> arrayList = this.choiceSelections;
        if (arrayList == null || arrayList.size() == 0 || (num = this.choiceSelections.get(0)) == null || this.choices == null) {
            return 0;
        }
        int i = this.visibleTopChoice;
        return i != -1 ? i : Math.max(0, Math.min(num.intValue(), this.choices.length));
    }

    public static String obfuscatePassword(String str) {
        char[] cArr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            cArr[i] = '*';
        }
        return new String(cArr);
    }

    public static String removeCRLF(String str) {
        if (str.indexOf(10) < 0 && str.indexOf(13) < 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer(charArray.length);
        int i = 0;
        while (i < charArray.length) {
            char c = charArray[i];
            if (c == '\n') {
                stringBuffer.append(' ');
            } else if (c == '\r') {
                stringBuffer.append(' ');
                if (i < charArray.length - 1) {
                    int i2 = i + 1;
                    if (charArray[i2] == '\n') {
                        i = i2;
                    }
                }
            } else {
                stringBuffer.append(c);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    private void writeMultipleValues(PdfFormField pdfFormField, String[][] strArr) {
        PdfArray pdfArray = new PdfArray();
        PdfArray pdfArray2 = new PdfArray();
        for (int i = 0; i < this.choiceSelections.size(); i++) {
            int iIntValue = this.choiceSelections.get(i).intValue();
            pdfArray.add(new PdfNumber(iIntValue));
            if (strArr != null) {
                pdfArray2.add(new PdfString(strArr[iIntValue][0]));
            } else {
                String[] strArr2 = this.choices;
                if (strArr2 != null) {
                    pdfArray2.add(new PdfString(strArr2[iIntValue]));
                }
            }
        }
        pdfFormField.put(PdfName.V, pdfArray2);
        pdfFormField.put(PdfName.I, pdfArray);
    }

    public void addChoiceSelection(int i) {
        if ((this.options & 2097152) != 0) {
            this.choiceSelections.add(Integer.valueOf(i));
        }
    }

    public PdfAppearance getAppearance() {
        int i;
        PdfAppearance borderAppearance = getBorderAppearance();
        borderAppearance.beginVariableText();
        String str = this.text;
        if (str == null || str.length() == 0) {
            borderAppearance.endVariableText();
            return borderAppearance;
        }
        int i2 = this.borderStyle;
        boolean z = i2 == 2 || i2 == 3;
        float height = this.box.getHeight();
        float f = this.borderWidth;
        float f2 = (height - (f * 2.0f)) - this.extraMarginTop;
        if (z) {
            f2 -= f * 2.0f;
            f *= 2.0f;
        }
        float fMax = Math.max(f, 1.0f);
        float fMin = Math.min(f, fMax);
        borderAppearance.saveState();
        float f3 = fMin * 2.0f;
        borderAppearance.rectangle(fMin, fMin, this.box.getWidth() - f3, this.box.getHeight() - f3);
        borderAppearance.clip();
        borderAppearance.newPath();
        int i3 = this.options;
        String strObfuscatePassword = (i3 & 8192) != 0 ? obfuscatePassword(this.text) : (i3 & 4096) == 0 ? removeCRLF(this.text) : this.text;
        BaseFont realFont = getRealFont();
        BaseColor baseColor = this.textColor;
        if (baseColor == null) {
            baseColor = GrayColor.GRAYBLACK;
        }
        int i4 = checkRTL(strObfuscatePassword) ? 2 : 1;
        float fMin2 = this.fontSize;
        Phrase phraseComposePhrase = composePhrase(strObfuscatePassword, realFont, baseColor, fMin2);
        if ((this.options & 4096) != 0) {
            float width = (this.box.getWidth() - (fMax * 4.0f)) - this.extraMarginLeft;
            float fontDescriptor = realFont.getFontDescriptor(8, 1.0f) - realFont.getFontDescriptor(6, 1.0f);
            ColumnText columnText = new ColumnText(null);
            if (fMin2 == 0.0f) {
                fMin2 = f2 / fontDescriptor;
                if (fMin2 > 4.0f) {
                    if (fMin2 > 12.0f) {
                        fMin2 = 12.0f;
                    }
                    float fMax2 = Math.max((fMin2 - 4.0f) / 10.0f, 0.2f);
                    columnText.setSimpleColumn(0.0f, -f2, width, 0.0f);
                    columnText.setAlignment(this.alignment);
                    columnText.setRunDirection(i4);
                    while (fMin2 > 4.0f) {
                        columnText.setYLine(0.0f);
                        changeFontSize(phraseComposePhrase, fMin2);
                        columnText.setText(phraseComposePhrase);
                        columnText.setLeading(fontDescriptor * fMin2);
                        if ((columnText.go(true) & 2) == 0) {
                            break;
                        }
                        fMin2 -= fMax2;
                    }
                }
                if (fMin2 < 4.0f) {
                    fMin2 = 4.0f;
                }
            }
            changeFontSize(phraseComposePhrase, fMin2);
            columnText.setCanvas(borderAppearance);
            float f4 = fontDescriptor * fMin2;
            float fontDescriptor2 = (f2 + fMax) - realFont.getFontDescriptor(8, fMin2);
            float f5 = fMax * 2.0f;
            columnText.setSimpleColumn(this.extraMarginLeft + f5, -20000.0f, this.box.getWidth() - f5, fontDescriptor2 + f4);
            columnText.setLeading(f4);
            columnText.setAlignment(this.alignment);
            columnText.setRunDirection(i4);
            columnText.setText(phraseComposePhrase);
            columnText.go();
        } else {
            if (fMin2 == 0.0f) {
                float fontDescriptor3 = f2 / (realFont.getFontDescriptor(7, 1.0f) - realFont.getFontDescriptor(6, 1.0f));
                changeFontSize(phraseComposePhrase, 1.0f);
                float width2 = ColumnText.getWidth(phraseComposePhrase, i4, 0);
                fMin2 = width2 == 0.0f ? fontDescriptor3 : Math.min(fontDescriptor3, ((this.box.getWidth() - this.extraMarginLeft) - (fMax * 4.0f)) / width2);
                if (fMin2 < 4.0f) {
                    fMin2 = 4.0f;
                }
            }
            changeFontSize(phraseComposePhrase, fMin2);
            float height2 = (((this.box.getHeight() - f3) - realFont.getFontDescriptor(1, fMin2)) / 2.0f) + fMin;
            if (height2 < fMin) {
                height2 = fMin;
            }
            if (height2 - fMin < (-realFont.getFontDescriptor(3, fMin2))) {
                height2 = Math.min((-realFont.getFontDescriptor(3, fMin2)) + fMin, Math.max(height2, (this.box.getHeight() - fMin) - realFont.getFontDescriptor(1, fMin2)));
            }
            if ((this.options & 16777216) == 0 || (i = this.maxCharacterLength) <= 0) {
                int i5 = this.alignment;
                ColumnText.showTextAligned(borderAppearance, this.alignment, phraseComposePhrase, i5 != 1 ? i5 != 2 ? this.extraMarginLeft + (fMax * 2.0f) : (this.extraMarginLeft + this.box.getWidth()) - (fMax * 2.0f) : this.extraMarginLeft + (this.box.getWidth() / 2.0f), height2 - this.extraMarginTop, 0.0f, i4, 0);
            } else {
                int iMin = Math.min(i, strObfuscatePassword.length());
                int i6 = this.alignment;
                int i7 = i6 == 2 ? this.maxCharacterLength - iMin : i6 == 1 ? (this.maxCharacterLength - iMin) / 2 : 0;
                float width3 = (this.box.getWidth() - this.extraMarginLeft) / this.maxCharacterLength;
                float f6 = (width3 / 2.0f) + (i7 * width3);
                BaseColor baseColor2 = this.textColor;
                if (baseColor2 == null) {
                    borderAppearance.setGrayFill(0.0f);
                } else {
                    borderAppearance.setColorFill(baseColor2);
                }
                borderAppearance.beginText();
                for (int i8 = 0; i8 < phraseComposePhrase.size(); i8++) {
                    Chunk chunk = (Chunk) phraseComposePhrase.get(i8);
                    BaseFont baseFont = chunk.getFont().getBaseFont();
                    borderAppearance.setFontAndSize(baseFont, fMin2);
                    StringBuffer stringBufferAppend = chunk.append("");
                    int i9 = 0;
                    while (i9 < stringBufferAppend.length()) {
                        int i10 = i9 + 1;
                        String strSubstring = stringBufferAppend.substring(i9, i10);
                        borderAppearance.setTextMatrix((this.extraMarginLeft + f6) - (baseFont.getWidthPoint(strSubstring, fMin2) / 2.0f), height2 - this.extraMarginTop);
                        borderAppearance.showText(strSubstring);
                        f6 += width3;
                        i9 = i10;
                    }
                }
                borderAppearance.endText();
            }
        }
        borderAppearance.restoreState();
        borderAppearance.endVariableText();
        return borderAppearance;
    }

    public String[] getChoiceExports() {
        return this.choiceExports;
    }

    public PdfFormField getChoiceField(boolean z) {
        String[][] strArr;
        PdfFormField pdfFormFieldCreateList;
        PdfAppearance appearance;
        this.options &= -16781313;
        String[] strArr2 = this.choices;
        if (strArr2 == null) {
            strArr2 = new String[0];
        }
        int topChoice = getTopChoice();
        if (strArr2.length > 0 && topChoice >= 0) {
            this.text = strArr2[topChoice];
        }
        if (this.text == null) {
            this.text = "";
        }
        if (this.choiceExports == null) {
            pdfFormFieldCreateList = z ? PdfFormField.createList(this.writer, strArr2, topChoice) : PdfFormField.createCombo(this.writer, (262144 & this.options) != 0, strArr2, topChoice);
            strArr = null;
        } else {
            String[][] strArr3 = (String[][]) Array.newInstance((Class<?>) String.class, strArr2.length, 2);
            for (int i = 0; i < strArr3.length; i++) {
                String[] strArr4 = strArr3[i];
                String str = strArr2[i];
                strArr4[1] = str;
                strArr4[0] = str;
            }
            int iMin = Math.min(strArr2.length, this.choiceExports.length);
            for (int i2 = 0; i2 < iMin; i2++) {
                String str2 = this.choiceExports[i2];
                if (str2 != null) {
                    strArr3[i2][0] = str2;
                }
            }
            PdfFormField pdfFormFieldCreateList2 = z ? PdfFormField.createList(this.writer, strArr3, topChoice) : PdfFormField.createCombo(this.writer, (262144 & this.options) != 0, strArr3, topChoice);
            strArr = strArr3;
            pdfFormFieldCreateList = pdfFormFieldCreateList2;
        }
        pdfFormFieldCreateList.setWidget(this.box, PdfAnnotation.HIGHLIGHT_INVERT);
        int i3 = this.rotation;
        if (i3 != 0) {
            pdfFormFieldCreateList.setMKRotation(i3);
        }
        String str3 = this.fieldName;
        if (str3 != null) {
            pdfFormFieldCreateList.setFieldName(str3);
            if (strArr2.length > 0) {
                if (strArr != null) {
                    if (this.choiceSelections.size() < 2) {
                        pdfFormFieldCreateList.setValueAsString(strArr[topChoice][0]);
                        pdfFormFieldCreateList.setDefaultValueAsString(strArr[topChoice][0]);
                    } else {
                        writeMultipleValues(pdfFormFieldCreateList, strArr);
                    }
                } else if (this.choiceSelections.size() < 2) {
                    pdfFormFieldCreateList.setValueAsString(this.text);
                    pdfFormFieldCreateList.setDefaultValueAsString(this.text);
                } else {
                    writeMultipleValues(pdfFormFieldCreateList, null);
                }
            }
            if ((this.options & 1) != 0) {
                pdfFormFieldCreateList.setFieldFlags(1);
            }
            if ((this.options & 2) != 0) {
                pdfFormFieldCreateList.setFieldFlags(2);
            }
            if ((this.options & 4194304) != 0) {
                pdfFormFieldCreateList.setFieldFlags(4194304);
            }
            if ((this.options & 2097152) != 0) {
                pdfFormFieldCreateList.setFieldFlags(2097152);
            }
        }
        pdfFormFieldCreateList.setBorderStyle(new PdfBorderDictionary(this.borderWidth, this.borderStyle, new PdfDashPattern(3.0f)));
        if (z) {
            appearance = getListAppearance();
            int i4 = this.topFirst;
            if (i4 > 0) {
                pdfFormFieldCreateList.put(PdfName.TI, new PdfNumber(i4));
            }
        } else {
            appearance = getAppearance();
        }
        pdfFormFieldCreateList.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, appearance);
        PdfAppearance pdfAppearance = (PdfAppearance) appearance.getDuplicate();
        pdfAppearance.setFontAndSize(getRealFont(), this.fontSize);
        BaseColor baseColor = this.textColor;
        if (baseColor == null) {
            pdfAppearance.setGrayFill(0.0f);
        } else {
            pdfAppearance.setColorFill(baseColor);
        }
        pdfFormFieldCreateList.setDefaultAppearanceString(pdfAppearance);
        BaseColor baseColor2 = this.borderColor;
        if (baseColor2 != null) {
            pdfFormFieldCreateList.setMKBorderColor(baseColor2);
        }
        BaseColor baseColor3 = this.backgroundColor;
        if (baseColor3 != null) {
            pdfFormFieldCreateList.setMKBackgroundColor(baseColor3);
        }
        int i5 = this.visibility;
        if (i5 == 1) {
            pdfFormFieldCreateList.setFlags(6);
        } else if (i5 != 2) {
            if (i5 != 3) {
                pdfFormFieldCreateList.setFlags(4);
            } else {
                pdfFormFieldCreateList.setFlags(36);
            }
        }
        return pdfFormFieldCreateList;
    }

    public int getChoiceSelection() {
        return getTopChoice();
    }

    public ArrayList<Integer> getChoiceSelections() {
        return this.choiceSelections;
    }

    public String[] getChoices() {
        return this.choices;
    }

    public PdfFormField getComboField() {
        return getChoiceField(false);
    }

    public String getDefaultText() {
        return this.defaultText;
    }

    public BaseFont getExtensionFont() {
        return this.extensionFont;
    }

    public PdfAppearance getListAppearance() {
        PdfAppearance borderAppearance = getBorderAppearance();
        String[] strArr = this.choices;
        if (strArr != null && strArr.length != 0) {
            borderAppearance.beginVariableText();
            int topChoice = getTopChoice();
            BaseFont realFont = getRealFont();
            float f = this.fontSize;
            float f2 = f == 0.0f ? 12.0f : f;
            int i = this.borderStyle;
            boolean z = i == 2 || i == 3;
            float height = this.box.getHeight();
            float f3 = this.borderWidth;
            float f4 = height - (f3 * 2.0f);
            if (z) {
                f4 -= f3 * 2.0f;
                f3 *= 2.0f;
            }
            float fontDescriptor = realFont.getFontDescriptor(8, f2) - realFont.getFontDescriptor(6, f2);
            int length = ((int) (f4 / fontDescriptor)) + 1 + topChoice;
            String[] strArr2 = this.choices;
            if (length > strArr2.length) {
                length = strArr2.length;
            }
            int i2 = length;
            this.topFirst = topChoice;
            borderAppearance.saveState();
            float f5 = f3 * 2.0f;
            borderAppearance.rectangle(f3, f3, this.box.getWidth() - f5, this.box.getHeight() - f5);
            borderAppearance.clip();
            borderAppearance.newPath();
            BaseColor baseColor = this.textColor;
            if (baseColor == null) {
                baseColor = GrayColor.GRAYBLACK;
            }
            BaseColor baseColor2 = baseColor;
            borderAppearance.setColorFill(new BaseColor(10, 36, 106));
            for (int i3 = 0; i3 < this.choiceSelections.size(); i3++) {
                int iIntValue = this.choiceSelections.get(i3).intValue();
                if (iIntValue >= topChoice && iIntValue <= i2) {
                    borderAppearance.rectangle(f3, (f3 + f4) - (((iIntValue - topChoice) + 1) * fontDescriptor), this.box.getWidth() - f5, fontDescriptor);
                    borderAppearance.fill();
                }
            }
            int i4 = topChoice;
            float fontDescriptor2 = (f3 + f4) - realFont.getFontDescriptor(8, f2);
            while (i4 < i2) {
                String str = this.choices[i4];
                ColumnText.showTextAligned(borderAppearance, 0, composePhrase(removeCRLF(str), realFont, this.choiceSelections.contains(Integer.valueOf(i4)) ? GrayColor.GRAYWHITE : baseColor2, f2), f5, fontDescriptor2, 0.0f, checkRTL(str) ? 2 : 1, 0);
                i4++;
                fontDescriptor2 -= fontDescriptor;
            }
            borderAppearance.restoreState();
            borderAppearance.endVariableText();
        }
        return borderAppearance;
    }

    public PdfFormField getListField() {
        return getChoiceField(true);
    }

    public ArrayList<BaseFont> getSubstitutionFonts() {
        return this.substitutionFonts;
    }

    public PdfFormField getTextField() {
        int i = this.maxCharacterLength;
        if (i <= 0) {
            this.options &= -16777217;
        }
        int i2 = this.options;
        if ((i2 & 16777216) != 0) {
            this.options = i2 & (-4097);
        }
        PdfFormField pdfFormFieldCreateTextField = PdfFormField.createTextField(this.writer, false, false, i);
        pdfFormFieldCreateTextField.setWidget(this.box, PdfAnnotation.HIGHLIGHT_INVERT);
        int i3 = this.alignment;
        if (i3 == 1) {
            pdfFormFieldCreateTextField.setQuadding(1);
        } else if (i3 == 2) {
            pdfFormFieldCreateTextField.setQuadding(2);
        }
        int i4 = this.rotation;
        if (i4 != 0) {
            pdfFormFieldCreateTextField.setMKRotation(i4);
        }
        String str = this.fieldName;
        if (str != null) {
            pdfFormFieldCreateTextField.setFieldName(str);
            if (!"".equals(this.text)) {
                pdfFormFieldCreateTextField.setValueAsString(this.text);
            }
            String str2 = this.defaultText;
            if (str2 != null) {
                pdfFormFieldCreateTextField.setDefaultValueAsString(str2);
            }
            if ((this.options & 1) != 0) {
                pdfFormFieldCreateTextField.setFieldFlags(1);
            }
            if ((this.options & 2) != 0) {
                pdfFormFieldCreateTextField.setFieldFlags(2);
            }
            if ((this.options & 4096) != 0) {
                pdfFormFieldCreateTextField.setFieldFlags(4096);
            }
            if ((this.options & 8388608) != 0) {
                pdfFormFieldCreateTextField.setFieldFlags(8388608);
            }
            if ((this.options & 8192) != 0) {
                pdfFormFieldCreateTextField.setFieldFlags(8192);
            }
            if ((this.options & 1048576) != 0) {
                pdfFormFieldCreateTextField.setFieldFlags(1048576);
            }
            if ((this.options & 4194304) != 0) {
                pdfFormFieldCreateTextField.setFieldFlags(4194304);
            }
            if ((this.options & 16777216) != 0) {
                pdfFormFieldCreateTextField.setFieldFlags(16777216);
            }
        }
        pdfFormFieldCreateTextField.setBorderStyle(new PdfBorderDictionary(this.borderWidth, this.borderStyle, new PdfDashPattern(3.0f)));
        PdfAppearance appearance = getAppearance();
        pdfFormFieldCreateTextField.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, appearance);
        PdfAppearance pdfAppearance = (PdfAppearance) appearance.getDuplicate();
        pdfAppearance.setFontAndSize(getRealFont(), this.fontSize);
        BaseColor baseColor = this.textColor;
        if (baseColor == null) {
            pdfAppearance.setGrayFill(0.0f);
        } else {
            pdfAppearance.setColorFill(baseColor);
        }
        pdfFormFieldCreateTextField.setDefaultAppearanceString(pdfAppearance);
        BaseColor baseColor2 = this.borderColor;
        if (baseColor2 != null) {
            pdfFormFieldCreateTextField.setMKBorderColor(baseColor2);
        }
        BaseColor baseColor3 = this.backgroundColor;
        if (baseColor3 != null) {
            pdfFormFieldCreateTextField.setMKBackgroundColor(baseColor3);
        }
        int i5 = this.visibility;
        if (i5 == 1) {
            pdfFormFieldCreateTextField.setFlags(6);
        } else if (i5 != 2) {
            if (i5 != 3) {
                pdfFormFieldCreateTextField.setFlags(4);
            } else {
                pdfFormFieldCreateTextField.setFlags(36);
            }
        }
        return pdfFormFieldCreateTextField;
    }

    public int getTopFirst() {
        return this.topFirst;
    }

    public int getVisibleTopChoice() {
        return this.visibleTopChoice;
    }

    public void setChoiceExports(String[] strArr) {
        this.choiceExports = strArr;
    }

    public void setChoiceSelection(int i) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.choiceSelections = arrayList;
        arrayList.add(Integer.valueOf(i));
    }

    public void setChoiceSelections(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            this.choiceSelections.clear();
            return;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>(arrayList);
        this.choiceSelections = arrayList2;
        if (arrayList2.size() <= 1 || (this.options & 2097152) != 0) {
            return;
        }
        while (this.choiceSelections.size() > 1) {
            this.choiceSelections.remove(1);
        }
    }

    public void setChoices(String[] strArr) {
        this.choices = strArr;
    }

    public void setDefaultText(String str) {
        this.defaultText = str;
    }

    public void setExtensionFont(BaseFont baseFont) {
        this.extensionFont = baseFont;
    }

    public void setExtraMargin(float f, float f2) {
        this.extraMarginLeft = f;
        this.extraMarginTop = f2;
    }

    public void setSubstitutionFonts(ArrayList<BaseFont> arrayList) {
        this.substitutionFonts = arrayList;
    }

    public void setVisibleTopChoice(int i) {
        String[] strArr;
        if (i >= 0 && (strArr = this.choices) != null && i < strArr.length) {
            this.visibleTopChoice = i;
        }
    }
}
