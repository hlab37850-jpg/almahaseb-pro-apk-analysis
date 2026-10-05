package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
public class PdfAcroForm extends PdfDictionary {
    private PdfWriter writer;
    private HashSet<PdfTemplate> fieldTemplates = new HashSet<>();
    private PdfArray documentFields = new PdfArray();
    private PdfArray calculationOrder = new PdfArray();
    private int sigFlags = 0;

    public PdfAcroForm(PdfWriter pdfWriter) {
        this.writer = pdfWriter;
    }

    public void addCalculationOrder(PdfFormField pdfFormField) {
        this.calculationOrder.add(pdfFormField.getIndirectReference());
    }

    public PdfFormField addCheckBox(String str, String str2, boolean z, float f, float f2, float f3, float f4) {
        PdfFormField pdfFormFieldCreateCheckBox = PdfFormField.createCheckBox(this.writer);
        setCheckBoxParams(pdfFormFieldCreateCheckBox, str, str2, z, f, f2, f3, f4);
        drawCheckBoxAppearences(pdfFormFieldCreateCheckBox, str2, f, f2, f3, f4);
        addFormField(pdfFormFieldCreateCheckBox);
        return pdfFormFieldCreateCheckBox;
    }

    public PdfFormField addComboBox(String str, String[] strArr, String str2, boolean z, BaseFont baseFont, float f, float f2, float f3, float f4, float f5) {
        PdfFormField pdfFormFieldCreateCombo = PdfFormField.createCombo(this.writer, z, strArr, 0);
        setChoiceParams(pdfFormFieldCreateCombo, str, str2, f2, f3, f4, f5);
        drawSingleLineOfText(pdfFormFieldCreateCombo, str2 == null ? strArr[0] : str2, baseFont, f, f2, f3, f4, f5);
        addFormField(pdfFormFieldCreateCombo);
        return pdfFormFieldCreateCombo;
    }

    public void addDocumentField(PdfIndirectReference pdfIndirectReference) {
        this.documentFields.add(pdfIndirectReference);
    }

    public void addFieldTemplates(HashSet<PdfTemplate> hashSet) {
        this.fieldTemplates.addAll(hashSet);
    }

    public void addFormField(PdfFormField pdfFormField) {
        this.writer.addAnnotation(pdfFormField);
    }

    public PdfFormField addHiddenField(String str, String str2) {
        PdfFormField pdfFormFieldCreateEmpty = PdfFormField.createEmpty(this.writer);
        pdfFormFieldCreateEmpty.setFieldName(str);
        pdfFormFieldCreateEmpty.setValueAsName(str2);
        addFormField(pdfFormFieldCreateEmpty);
        return pdfFormFieldCreateEmpty;
    }

    public PdfFormField addHtmlPostButton(String str, String str2, String str3, String str4, BaseFont baseFont, float f, float f2, float f3, float f4, float f5) {
        PdfFormField pdfFormField = new PdfFormField(this.writer, f2, f3, f4, f5, PdfAction.createSubmitForm(str4, null, 4));
        setButtonParams(pdfFormField, 65536, str, str3);
        drawButton(pdfFormField, str2, baseFont, f, f2, f3, f4, f5);
        addFormField(pdfFormField);
        return pdfFormField;
    }

    public PdfFormField addMap(String str, String str2, String str3, PdfContentByte pdfContentByte, float f, float f2, float f3, float f4) {
        PdfFormField pdfFormField = new PdfFormField(this.writer, f, f2, f3, f4, PdfAction.createSubmitForm(str3, null, 20));
        setButtonParams(pdfFormField, 65536, str, null);
        PdfAppearance pdfAppearanceCreateAppearance = PdfAppearance.createAppearance(this.writer, f3 - f, f4 - f2);
        pdfAppearanceCreateAppearance.add(pdfContentByte);
        pdfFormField.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, pdfAppearanceCreateAppearance);
        addFormField(pdfFormField);
        return pdfFormField;
    }

    public PdfFormField addMultiLineTextField(String str, String str2, BaseFont baseFont, float f, float f2, float f3, float f4, float f5) {
        PdfFormField pdfFormFieldCreateTextField = PdfFormField.createTextField(this.writer, true, false, 0);
        setTextFieldParams(pdfFormFieldCreateTextField, str2, str, f2, f3, f4, f5);
        drawMultiLineOfText(pdfFormFieldCreateTextField, str2, baseFont, f, f2, f3, f4, f5);
        addFormField(pdfFormFieldCreateTextField);
        return pdfFormFieldCreateTextField;
    }

    public PdfFormField addRadioButton(PdfFormField pdfFormField, String str, float f, float f2, float f3, float f4) {
        PdfFormField pdfFormFieldCreateEmpty = PdfFormField.createEmpty(this.writer);
        pdfFormFieldCreateEmpty.setWidget(new Rectangle(f, f2, f3, f4), PdfAnnotation.HIGHLIGHT_TOGGLE);
        if (((PdfName) pdfFormField.get(PdfName.V)).toString().substring(1).equals(str)) {
            pdfFormFieldCreateEmpty.setAppearanceState(str);
        } else {
            pdfFormFieldCreateEmpty.setAppearanceState("Off");
        }
        drawRadioAppearences(pdfFormFieldCreateEmpty, str, f, f2, f3, f4);
        pdfFormField.addKid(pdfFormFieldCreateEmpty);
        return pdfFormFieldCreateEmpty;
    }

    public void addRadioGroup(PdfFormField pdfFormField) {
        addFormField(pdfFormField);
    }

    public PdfFormField addResetButton(String str, String str2, String str3, BaseFont baseFont, float f, float f2, float f3, float f4, float f5) {
        PdfFormField pdfFormField = new PdfFormField(this.writer, f2, f3, f4, f5, PdfAction.createResetForm(null, 0));
        setButtonParams(pdfFormField, 65536, str, str3);
        drawButton(pdfFormField, str2, baseFont, f, f2, f3, f4, f5);
        addFormField(pdfFormField);
        return pdfFormField;
    }

    public PdfFormField addSelectList(String str, String[] strArr, String str2, BaseFont baseFont, float f, float f2, float f3, float f4, float f5) {
        PdfFormField pdfFormFieldCreateList = PdfFormField.createList(this.writer, strArr, 0);
        setChoiceParams(pdfFormFieldCreateList, str, str2, f2, f3, f4, f5);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str3 : strArr) {
            stringBuffer.append(str3);
            stringBuffer.append('\n');
        }
        drawMultiLineOfText(pdfFormFieldCreateList, stringBuffer.toString(), baseFont, f, f2, f3, f4, f5);
        addFormField(pdfFormFieldCreateList);
        return pdfFormFieldCreateList;
    }

    public PdfFormField addSignature(String str, float f, float f2, float f3, float f4) {
        PdfFormField pdfFormFieldCreateSignature = PdfFormField.createSignature(this.writer);
        setSignatureParams(pdfFormFieldCreateSignature, str, f, f2, f3, f4);
        drawSignatureAppearences(pdfFormFieldCreateSignature, f, f2, f3, f4);
        addFormField(pdfFormFieldCreateSignature);
        return pdfFormFieldCreateSignature;
    }

    public PdfFormField addSingleLinePasswordField(String str, String str2, BaseFont baseFont, float f, float f2, float f3, float f4, float f5) {
        PdfFormField pdfFormFieldCreateTextField = PdfFormField.createTextField(this.writer, false, true, 0);
        setTextFieldParams(pdfFormFieldCreateTextField, str2, str, f2, f3, f4, f5);
        drawSingleLineOfText(pdfFormFieldCreateTextField, str2, baseFont, f, f2, f3, f4, f5);
        addFormField(pdfFormFieldCreateTextField);
        return pdfFormFieldCreateTextField;
    }

    public PdfFormField addSingleLineTextField(String str, String str2, BaseFont baseFont, float f, float f2, float f3, float f4, float f5) {
        PdfFormField pdfFormFieldCreateTextField = PdfFormField.createTextField(this.writer, false, false, 0);
        setTextFieldParams(pdfFormFieldCreateTextField, str2, str, f2, f3, f4, f5);
        drawSingleLineOfText(pdfFormFieldCreateTextField, str2, baseFont, f, f2, f3, f4, f5);
        addFormField(pdfFormFieldCreateTextField);
        return pdfFormFieldCreateTextField;
    }

    public void drawButton(PdfFormField pdfFormField, String str, BaseFont baseFont, float f, float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        PdfAppearance pdfAppearanceCreateAppearance = PdfAppearance.createAppearance(this.writer, f6, f7);
        pdfAppearanceCreateAppearance.drawButton(0.0f, 0.0f, f6, f7, str, baseFont, f);
        pdfFormField.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, pdfAppearanceCreateAppearance);
    }

    public void drawCheckBoxAppearences(PdfFormField pdfFormField, String str, float f, float f2, float f3, float f4) {
        try {
            BaseFont baseFontCreateFont = BaseFont.createFont("ZapfDingbats", "Cp1252", false);
            float f5 = f4 - f2;
            float f6 = f3 - f;
            PdfAppearance pdfAppearanceCreateAppearance = PdfAppearance.createAppearance(this.writer, f6, f5);
            PdfAppearance pdfAppearance = (PdfAppearance) pdfAppearanceCreateAppearance.getDuplicate();
            pdfAppearance.setFontAndSize(baseFontCreateFont, f5);
            pdfAppearance.resetRGBColorFill();
            pdfFormField.setDefaultAppearanceString(pdfAppearance);
            pdfAppearanceCreateAppearance.drawTextField(0.0f, 0.0f, f6, f5);
            pdfAppearanceCreateAppearance.saveState();
            pdfAppearanceCreateAppearance.resetRGBColorFill();
            pdfAppearanceCreateAppearance.beginText();
            pdfAppearanceCreateAppearance.setFontAndSize(baseFontCreateFont, f5);
            pdfAppearanceCreateAppearance.showTextAligned(1, "4", f6 / 2.0f, (f5 / 2.0f) - (0.3f * f5), 0.0f);
            pdfAppearanceCreateAppearance.endText();
            pdfAppearanceCreateAppearance.restoreState();
            PdfName pdfName = PdfAnnotation.APPEARANCE_NORMAL;
            pdfFormField.setAppearance(pdfName, str, pdfAppearanceCreateAppearance);
            PdfAppearance pdfAppearanceCreateAppearance2 = PdfAppearance.createAppearance(this.writer, f6, f5);
            pdfAppearanceCreateAppearance2.drawTextField(0.0f, 0.0f, f6, f5);
            pdfFormField.setAppearance(pdfName, "Off", pdfAppearanceCreateAppearance2);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public void drawMultiLineOfText(PdfFormField pdfFormField, String str, BaseFont baseFont, float f, float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        PdfAppearance pdfAppearanceCreateAppearance = PdfAppearance.createAppearance(this.writer, f6, f7);
        PdfAppearance pdfAppearance = (PdfAppearance) pdfAppearanceCreateAppearance.getDuplicate();
        pdfAppearance.setFontAndSize(baseFont, f);
        pdfAppearance.resetRGBColorFill();
        pdfFormField.setDefaultAppearanceString(pdfAppearance);
        pdfAppearanceCreateAppearance.drawTextField(0.0f, 0.0f, f6, f7);
        pdfAppearanceCreateAppearance.beginVariableText();
        pdfAppearanceCreateAppearance.saveState();
        pdfAppearanceCreateAppearance.rectangle(3.0f, 3.0f, f6 - 6.0f, f7 - 6.0f);
        pdfAppearanceCreateAppearance.clip();
        pdfAppearanceCreateAppearance.newPath();
        pdfAppearanceCreateAppearance.beginText();
        pdfAppearanceCreateAppearance.setFontAndSize(baseFont, f);
        pdfAppearanceCreateAppearance.resetRGBColorFill();
        pdfAppearanceCreateAppearance.setTextMatrix(4.0f, 5.0f);
        StringTokenizer stringTokenizer = new StringTokenizer(str, StringUtilities.LF);
        while (stringTokenizer.hasMoreTokens()) {
            f7 -= 1.2f * f;
            pdfAppearanceCreateAppearance.showTextAligned(0, stringTokenizer.nextToken(), 3.0f, f7, 0.0f);
        }
        pdfAppearanceCreateAppearance.endText();
        pdfAppearanceCreateAppearance.restoreState();
        pdfAppearanceCreateAppearance.endVariableText();
        pdfFormField.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, pdfAppearanceCreateAppearance);
    }

    public void drawRadioAppearences(PdfFormField pdfFormField, String str, float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        PdfAppearance pdfAppearanceCreateAppearance = PdfAppearance.createAppearance(this.writer, f5, f6);
        pdfAppearanceCreateAppearance.drawRadioField(0.0f, 0.0f, f5, f6, true);
        PdfName pdfName = PdfAnnotation.APPEARANCE_NORMAL;
        pdfFormField.setAppearance(pdfName, str, pdfAppearanceCreateAppearance);
        PdfAppearance pdfAppearanceCreateAppearance2 = PdfAppearance.createAppearance(this.writer, f5, f6);
        pdfAppearanceCreateAppearance2.drawRadioField(0.0f, 0.0f, f5, f6, false);
        pdfFormField.setAppearance(pdfName, "Off", pdfAppearanceCreateAppearance2);
    }

    public void drawSignatureAppearences(PdfFormField pdfFormField, float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        PdfAppearance pdfAppearanceCreateAppearance = PdfAppearance.createAppearance(this.writer, f5, f6);
        pdfAppearanceCreateAppearance.setGrayFill(1.0f);
        pdfAppearanceCreateAppearance.rectangle(0.0f, 0.0f, f5, f6);
        pdfAppearanceCreateAppearance.fill();
        pdfAppearanceCreateAppearance.setGrayStroke(0.0f);
        pdfAppearanceCreateAppearance.setLineWidth(1.0f);
        pdfAppearanceCreateAppearance.rectangle(0.5f, 0.5f, f5 - 0.5f, f6 - 0.5f);
        pdfAppearanceCreateAppearance.closePathStroke();
        pdfAppearanceCreateAppearance.saveState();
        pdfAppearanceCreateAppearance.rectangle(1.0f, 1.0f, f5 - 2.0f, f6 - 2.0f);
        pdfAppearanceCreateAppearance.clip();
        pdfAppearanceCreateAppearance.newPath();
        pdfAppearanceCreateAppearance.restoreState();
        pdfFormField.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, pdfAppearanceCreateAppearance);
    }

    public void drawSingleLineOfText(PdfFormField pdfFormField, String str, BaseFont baseFont, float f, float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        PdfAppearance pdfAppearanceCreateAppearance = PdfAppearance.createAppearance(this.writer, f6, f7);
        PdfAppearance pdfAppearance = (PdfAppearance) pdfAppearanceCreateAppearance.getDuplicate();
        pdfAppearance.setFontAndSize(baseFont, f);
        pdfAppearance.resetRGBColorFill();
        pdfFormField.setDefaultAppearanceString(pdfAppearance);
        pdfAppearanceCreateAppearance.drawTextField(0.0f, 0.0f, f6, f7);
        pdfAppearanceCreateAppearance.beginVariableText();
        pdfAppearanceCreateAppearance.saveState();
        pdfAppearanceCreateAppearance.rectangle(3.0f, 3.0f, f6 - 6.0f, f7 - 6.0f);
        pdfAppearanceCreateAppearance.clip();
        pdfAppearanceCreateAppearance.newPath();
        pdfAppearanceCreateAppearance.beginText();
        pdfAppearanceCreateAppearance.setFontAndSize(baseFont, f);
        pdfAppearanceCreateAppearance.resetRGBColorFill();
        pdfAppearanceCreateAppearance.setTextMatrix(4.0f, (f7 / 2.0f) - (f * 0.3f));
        pdfAppearanceCreateAppearance.showText(str);
        pdfAppearanceCreateAppearance.endText();
        pdfAppearanceCreateAppearance.restoreState();
        pdfAppearanceCreateAppearance.endVariableText();
        pdfFormField.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, pdfAppearanceCreateAppearance);
    }

    public PdfFormField getRadioGroup(String str, String str2, boolean z) {
        PdfFormField pdfFormFieldCreateRadioButton = PdfFormField.createRadioButton(this.writer, z);
        pdfFormFieldCreateRadioButton.setFieldName(str);
        pdfFormFieldCreateRadioButton.setValueAsName(str2);
        return pdfFormFieldCreateRadioButton;
    }

    public boolean isValid() {
        if (this.documentFields.size() == 0) {
            return false;
        }
        put(PdfName.FIELDS, this.documentFields);
        int i = this.sigFlags;
        if (i != 0) {
            put(PdfName.SIGFLAGS, new PdfNumber(i));
        }
        if (this.calculationOrder.size() > 0) {
            put(PdfName.CO, this.calculationOrder);
        }
        if (this.fieldTemplates.isEmpty()) {
            return true;
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        Iterator<PdfTemplate> it = this.fieldTemplates.iterator();
        while (it.hasNext()) {
            PdfFormField.mergeResources(pdfDictionary, (PdfDictionary) it.next().getResources());
        }
        put(PdfName.DR, pdfDictionary);
        put(PdfName.DA, new PdfString("/Helv 0 Tf 0 g "));
        PdfDictionary pdfDictionary2 = (PdfDictionary) pdfDictionary.get(PdfName.FONT);
        if (pdfDictionary2 != null) {
            this.writer.eliminateFontSubset(pdfDictionary2);
        }
        return true;
    }

    public void setButtonParams(PdfFormField pdfFormField, int i, String str, String str2) {
        pdfFormField.setButton(i);
        pdfFormField.setFlags(4);
        pdfFormField.setPage();
        pdfFormField.setFieldName(str);
        if (str2 != null) {
            pdfFormField.setValueAsString(str2);
        }
    }

    public void setCheckBoxParams(PdfFormField pdfFormField, String str, String str2, boolean z, float f, float f2, float f3, float f4) {
        pdfFormField.setWidget(new Rectangle(f, f2, f3, f4), PdfAnnotation.HIGHLIGHT_TOGGLE);
        pdfFormField.setFieldName(str);
        if (z) {
            pdfFormField.setValueAsName(str2);
            pdfFormField.setAppearanceState(str2);
        } else {
            pdfFormField.setValueAsName("Off");
            pdfFormField.setAppearanceState("Off");
        }
        pdfFormField.setFlags(4);
        pdfFormField.setPage();
        pdfFormField.setBorderStyle(new PdfBorderDictionary(1.0f, 0));
    }

    public void setChoiceParams(PdfFormField pdfFormField, String str, String str2, float f, float f2, float f3, float f4) {
        pdfFormField.setWidget(new Rectangle(f, f2, f3, f4), PdfAnnotation.HIGHLIGHT_INVERT);
        if (str2 != null) {
            pdfFormField.setValueAsString(str2);
            pdfFormField.setDefaultValueAsString(str2);
        }
        pdfFormField.setFieldName(str);
        pdfFormField.setFlags(4);
        pdfFormField.setPage();
        pdfFormField.setBorderStyle(new PdfBorderDictionary(2.0f, 0));
    }

    public void setNeedAppearances(boolean z) {
        put(PdfName.NEEDAPPEARANCES, new PdfBoolean(z));
    }

    public void setSigFlags(int i) {
        this.sigFlags = i | this.sigFlags;
    }

    public void setSignatureParams(PdfFormField pdfFormField, String str, float f, float f2, float f3, float f4) {
        pdfFormField.setWidget(new Rectangle(f, f2, f3, f4), PdfAnnotation.HIGHLIGHT_INVERT);
        pdfFormField.setFieldName(str);
        pdfFormField.setFlags(4);
        pdfFormField.setPage();
        pdfFormField.setMKBorderColor(BaseColor.BLACK);
        pdfFormField.setMKBackgroundColor(BaseColor.WHITE);
    }

    public void setTextFieldParams(PdfFormField pdfFormField, String str, String str2, float f, float f2, float f3, float f4) {
        pdfFormField.setWidget(new Rectangle(f, f2, f3, f4), PdfAnnotation.HIGHLIGHT_INVERT);
        pdfFormField.setValueAsString(str);
        pdfFormField.setDefaultValueAsString(str);
        pdfFormField.setFieldName(str2);
        pdfFormField.setFlags(4);
        pdfFormField.setPage();
    }

    @Override // com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) {
        PdfWriter.checkPdfIsoConformance(pdfWriter, 15, this);
        super.toPdf(pdfWriter, outputStream);
    }

    public PdfFormField addComboBox(String str, String[][] strArr, String str2, boolean z, BaseFont baseFont, float f, float f2, float f3, float f4, float f5) {
        String str3;
        PdfFormField pdfFormFieldCreateCombo = PdfFormField.createCombo(this.writer, z, strArr, 0);
        setChoiceParams(pdfFormFieldCreateCombo, str, str2, f2, f3, f4, f5);
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str3 = null;
                break;
            }
            String[] strArr2 = strArr[i];
            if (strArr2[0].equals(str2)) {
                str3 = strArr2[1];
                break;
            }
            i++;
        }
        if (str3 == null) {
            str3 = strArr[0][1];
        }
        drawSingleLineOfText(pdfFormFieldCreateCombo, str3, baseFont, f, f2, f3, f4, f5);
        addFormField(pdfFormFieldCreateCombo);
        return pdfFormFieldCreateCombo;
    }

    public PdfFormField addSelectList(String str, String[][] strArr, String str2, BaseFont baseFont, float f, float f2, float f3, float f4, float f5) {
        PdfFormField pdfFormFieldCreateList = PdfFormField.createList(this.writer, strArr, 0);
        setChoiceParams(pdfFormFieldCreateList, str, str2, f2, f3, f4, f5);
        StringBuffer stringBuffer = new StringBuffer();
        for (String[] strArr2 : strArr) {
            stringBuffer.append(strArr2[1]);
            stringBuffer.append('\n');
        }
        drawMultiLineOfText(pdfFormFieldCreateList, stringBuffer.toString(), baseFont, f, f2, f3, f4, f5);
        addFormField(pdfFormFieldCreateList);
        return pdfFormFieldCreateList;
    }
}
