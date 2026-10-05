package com.itextpdf.text.pdf.codec.wmf;

import com.google.android.material.internal.ViewUtils;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.codec.BmpImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class MetaDo {
    public static final int META_ANIMATEPALETTE = 1078;
    public static final int META_ARC = 2071;
    public static final int META_BITBLT = 2338;
    public static final int META_CHORD = 2096;
    public static final int META_CREATEBRUSHINDIRECT = 764;
    public static final int META_CREATEFONTINDIRECT = 763;
    public static final int META_CREATEPALETTE = 247;
    public static final int META_CREATEPATTERNBRUSH = 505;
    public static final int META_CREATEPENINDIRECT = 762;
    public static final int META_CREATEREGION = 1791;
    public static final int META_DELETEOBJECT = 496;
    public static final int META_DIBBITBLT = 2368;
    public static final int META_DIBCREATEPATTERNBRUSH = 322;
    public static final int META_DIBSTRETCHBLT = 2881;
    public static final int META_ELLIPSE = 1048;
    public static final int META_ESCAPE = 1574;
    public static final int META_EXCLUDECLIPRECT = 1045;
    public static final int META_EXTFLOODFILL = 1352;
    public static final int META_EXTTEXTOUT = 2610;
    public static final int META_FILLREGION = 552;
    public static final int META_FLOODFILL = 1049;
    public static final int META_FRAMEREGION = 1065;
    public static final int META_INTERSECTCLIPRECT = 1046;
    public static final int META_INVERTREGION = 298;
    public static final int META_LINETO = 531;
    public static final int META_MOVETO = 532;
    public static final int META_OFFSETCLIPRGN = 544;
    public static final int META_OFFSETVIEWPORTORG = 529;
    public static final int META_OFFSETWINDOWORG = 527;
    public static final int META_PAINTREGION = 299;
    public static final int META_PATBLT = 1565;
    public static final int META_PIE = 2074;
    public static final int META_POLYGON = 804;
    public static final int META_POLYLINE = 805;
    public static final int META_POLYPOLYGON = 1336;
    public static final int META_REALIZEPALETTE = 53;
    public static final int META_RECTANGLE = 1051;
    public static final int META_RESIZEPALETTE = 313;
    public static final int META_RESTOREDC = 295;
    public static final int META_ROUNDRECT = 1564;
    public static final int META_SAVEDC = 30;
    public static final int META_SCALEVIEWPORTEXT = 1042;
    public static final int META_SCALEWINDOWEXT = 1040;
    public static final int META_SELECTCLIPREGION = 300;
    public static final int META_SELECTOBJECT = 301;
    public static final int META_SELECTPALETTE = 564;
    public static final int META_SETBKCOLOR = 513;
    public static final int META_SETBKMODE = 258;
    public static final int META_SETDIBTODEV = 3379;
    public static final int META_SETMAPMODE = 259;
    public static final int META_SETMAPPERFLAGS = 561;
    public static final int META_SETPALENTRIES = 55;
    public static final int META_SETPIXEL = 1055;
    public static final int META_SETPOLYFILLMODE = 262;
    public static final int META_SETRELABS = 261;
    public static final int META_SETROP2 = 260;
    public static final int META_SETSTRETCHBLTMODE = 263;
    public static final int META_SETTEXTALIGN = 302;
    public static final int META_SETTEXTCHAREXTRA = 264;
    public static final int META_SETTEXTCOLOR = 521;
    public static final int META_SETTEXTJUSTIFICATION = 522;
    public static final int META_SETVIEWPORTEXT = 526;
    public static final int META_SETVIEWPORTORG = 525;
    public static final int META_SETWINDOWEXT = 524;
    public static final int META_SETWINDOWORG = 523;
    public static final int META_STRETCHBLT = 2851;
    public static final int META_STRETCHDIB = 3907;
    public static final int META_TEXTOUT = 1313;
    int bottom;
    public PdfContentByte cb;
    public InputMeta in;
    int inch;
    int left;
    int right;
    MetaState state = new MetaState();
    int top;

    public MetaDo(InputStream inputStream, PdfContentByte pdfContentByte) {
        this.cb = pdfContentByte;
        this.in = new InputMeta(inputStream);
    }

    public static float getArc(float f, float f2, float f3, float f4) {
        return (float) getArc(f, f2, f3, f4);
    }

    public static byte[] wrapBMP(Image image) throws IOException {
        byte[] originalData;
        if (image.getOriginalType() != 4) {
            throw new IOException(MessageLocalization.getComposedMessage("only.bmp.can.be.wrapped.in.wmf", new Object[0]));
        }
        if (image.getOriginalData() == null) {
            InputStream inputStreamOpenStream = image.getUrl().openStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i = inputStreamOpenStream.read();
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(i);
            }
            inputStreamOpenStream.close();
            originalData = byteArrayOutputStream.toByteArray();
        } else {
            originalData = image.getOriginalData();
        }
        int length = (originalData.length - 13) >>> 1;
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        writeWord(byteArrayOutputStream2, 1);
        writeWord(byteArrayOutputStream2, 9);
        writeWord(byteArrayOutputStream2, ViewUtils.EDGE_TO_EDGE_FLAGS);
        writeDWord(byteArrayOutputStream2, length + 39);
        writeWord(byteArrayOutputStream2, 1);
        writeDWord(byteArrayOutputStream2, length + 14);
        writeWord(byteArrayOutputStream2, 0);
        writeDWord(byteArrayOutputStream2, 4);
        writeWord(byteArrayOutputStream2, 259);
        writeWord(byteArrayOutputStream2, 8);
        writeDWord(byteArrayOutputStream2, 5);
        writeWord(byteArrayOutputStream2, META_SETWINDOWORG);
        writeWord(byteArrayOutputStream2, 0);
        writeWord(byteArrayOutputStream2, 0);
        writeDWord(byteArrayOutputStream2, 5);
        writeWord(byteArrayOutputStream2, META_SETWINDOWEXT);
        writeWord(byteArrayOutputStream2, (int) image.getHeight());
        writeWord(byteArrayOutputStream2, (int) image.getWidth());
        writeDWord(byteArrayOutputStream2, length + 13);
        writeWord(byteArrayOutputStream2, META_DIBSTRETCHBLT);
        writeDWord(byteArrayOutputStream2, 13369376);
        writeWord(byteArrayOutputStream2, (int) image.getHeight());
        writeWord(byteArrayOutputStream2, (int) image.getWidth());
        writeWord(byteArrayOutputStream2, 0);
        writeWord(byteArrayOutputStream2, 0);
        writeWord(byteArrayOutputStream2, (int) image.getHeight());
        writeWord(byteArrayOutputStream2, (int) image.getWidth());
        writeWord(byteArrayOutputStream2, 0);
        writeWord(byteArrayOutputStream2, 0);
        byteArrayOutputStream2.write(originalData, 14, originalData.length - 14);
        if ((originalData.length & 1) == 1) {
            byteArrayOutputStream2.write(0);
        }
        writeDWord(byteArrayOutputStream2, 3);
        writeWord(byteArrayOutputStream2, 0);
        byteArrayOutputStream2.close();
        return byteArrayOutputStream2.toByteArray();
    }

    public static void writeDWord(OutputStream outputStream, int i) throws IOException {
        writeWord(outputStream, i & 65535);
        writeWord(outputStream, (i >>> 16) & 65535);
    }

    public static void writeWord(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >>> 8) & 255);
    }

    public boolean isNullStrokeFill(boolean z) {
        MetaPen currentPen = this.state.getCurrentPen();
        MetaBrush currentBrush = this.state.getCurrentBrush();
        boolean z2 = false;
        boolean z3 = currentPen.getStyle() == 5;
        int style = currentBrush.getStyle();
        boolean z4 = style == 0 || (style == 2 && this.state.getBackgroundMode() == 2);
        if (z3 && !z4) {
            z2 = true;
        }
        if (!z3) {
            if (z) {
                this.state.setLineJoinRectangle(this.cb);
            } else {
                this.state.setLineJoinPolygon(this.cb);
            }
        }
        return z2;
    }

    public void outputText(int i, int i2, int i3, int i4, int i5, int i6, int i7, String str) {
        float f;
        MetaFont currentFont = this.state.getCurrentFont();
        float fTransformX = this.state.transformX(i);
        float fTransformY = this.state.transformY(i2);
        double dTransformAngle = this.state.transformAngle(currentFont.getAngle());
        float fSin = (float) Math.sin(dTransformAngle);
        float fCos = (float) Math.cos(dTransformAngle);
        float fontSize = currentFont.getFontSize(this.state);
        BaseFont font = currentFont.getFont();
        int textAlign = this.state.getTextAlign();
        float widthPoint = font.getWidthPoint(str, fontSize);
        float fontDescriptor = font.getFontDescriptor(3, fontSize);
        float fontDescriptor2 = font.getFontDescriptor(8, fontSize);
        this.cb.saveState();
        this.cb.concatCTM(fCos, fSin, -fSin, fCos, fTransformX, fTransformY);
        float f2 = 0.0f;
        if ((textAlign & 6) == 6) {
            f = (-widthPoint) / 2.0f;
        } else {
            f = (textAlign & 2) == 2 ? -widthPoint : 0.0f;
        }
        if ((textAlign & 24) != 24) {
            f2 = (textAlign & 8) == 8 ? -fontDescriptor : -fontDescriptor2;
        }
        if (this.state.getBackgroundMode() == 2) {
            this.cb.setColorFill(this.state.getCurrentBackgroundColor());
            this.cb.rectangle(f, f2 + fontDescriptor, widthPoint, fontDescriptor2 - fontDescriptor);
            this.cb.fill();
        }
        this.cb.setColorFill(this.state.getCurrentTextColor());
        this.cb.beginText();
        this.cb.setFontAndSize(font, fontSize);
        this.cb.setTextMatrix(f, f2);
        this.cb.showText(str);
        this.cb.endText();
        if (currentFont.isUnderline()) {
            this.cb.rectangle(f, f2 - (fontSize / 4.0f), widthPoint, fontSize / 15.0f);
            this.cb.fill();
        }
        if (currentFont.isStrikeout()) {
            this.cb.rectangle(f, f2 + (fontSize / 3.0f), widthPoint, fontSize / 15.0f);
            this.cb.fill();
        }
        this.cb.restoreState();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x00c1  */
    public void readAll() throws DocumentException, IOException {
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        String str2;
        int i9 = 0;
        if (this.in.readInt() != -1698247209) {
            throw new DocumentException(MessageLocalization.getComposedMessage("not.a.placeable.windows.metafile", new Object[0]));
        }
        this.in.readWord();
        this.left = this.in.readShort();
        this.top = this.in.readShort();
        this.right = this.in.readShort();
        this.bottom = this.in.readShort();
        int word = this.in.readWord();
        this.inch = word;
        this.state.setScalingX(((this.right - this.left) / word) * 72.0f);
        this.state.setScalingY(((this.bottom - this.top) / this.inch) * 72.0f);
        this.state.setOffsetWx(this.left);
        this.state.setOffsetWy(this.top);
        this.state.setExtentWx(this.right - this.left);
        this.state.setExtentWy(this.bottom - this.top);
        this.in.readInt();
        this.in.readWord();
        this.in.skip(18);
        boolean z = true;
        this.cb.setLineCap(1);
        this.cb.setLineJoin(1);
        while (true) {
            int length = this.in.getLength();
            int i10 = this.in.readInt();
            if (i10 < 3) {
                this.state.cleanup(this.cb);
                return;
            }
            int word2 = this.in.readWord();
            switch (word2) {
                case 30:
                    i = length;
                    i2 = i10;
                    this.state.saveState(this.cb);
                    break;
                case META_CREATEPALETTE /* 247 */:
                case 322:
                case META_CREATEREGION /* 1791 */:
                    i = length;
                    i2 = i10;
                    this.state.addMetaObject(new MetaObject());
                    break;
                case 258:
                    i = length;
                    i2 = i10;
                    this.state.setBackgroundMode(this.in.readWord());
                    break;
                case 262:
                    i = length;
                    i2 = i10;
                    this.state.setPolyFillMode(this.in.readWord());
                    break;
                case META_RESTOREDC /* 295 */:
                    i = length;
                    i2 = i10;
                    this.state.restoreState(this.in.readShort(), this.cb);
                    break;
                case 301:
                    i = length;
                    i2 = i10;
                    this.state.selectMetaObject(this.in.readWord(), this.cb);
                    break;
                case 302:
                    i = length;
                    i2 = i10;
                    this.state.setTextAlign(this.in.readWord());
                    break;
                case META_DELETEOBJECT /* 496 */:
                    i = length;
                    i2 = i10;
                    this.state.deleteMetaObject(this.in.readWord());
                    break;
                case 513:
                    i = length;
                    i2 = i10;
                    this.state.setCurrentBackgroundColor(this.in.readColor());
                    break;
                case 521:
                    i = length;
                    i2 = i10;
                    this.state.setCurrentTextColor(this.in.readColor());
                    break;
                case META_SETWINDOWORG /* 523 */:
                    i = length;
                    i2 = i10;
                    this.state.setOffsetWy(this.in.readShort());
                    this.state.setOffsetWx(this.in.readShort());
                    break;
                case META_SETWINDOWEXT /* 524 */:
                    i = length;
                    i2 = i10;
                    this.state.setExtentWy(this.in.readShort());
                    this.state.setExtentWx(this.in.readShort());
                    break;
                case 531:
                    i = length;
                    i2 = i10;
                    int i11 = this.in.readShort();
                    int i12 = this.in.readShort();
                    Point currentPoint = this.state.getCurrentPoint();
                    this.cb.moveTo(this.state.transformX(currentPoint.x), this.state.transformY(currentPoint.y));
                    this.cb.lineTo(this.state.transformX(i12), this.state.transformY(i11));
                    this.cb.stroke();
                    this.state.setCurrentPoint(new Point(i12, i11));
                    break;
                case 532:
                    i = length;
                    i2 = i10;
                    this.state.setCurrentPoint(new Point(this.in.readShort(), this.in.readShort()));
                    break;
                case META_CREATEPENINDIRECT /* 762 */:
                    i = length;
                    i2 = i10;
                    MetaPen metaPen = new MetaPen();
                    metaPen.init(this.in);
                    this.state.addMetaObject(metaPen);
                    break;
                case META_CREATEFONTINDIRECT /* 763 */:
                    i = length;
                    i2 = i10;
                    MetaFont metaFont = new MetaFont();
                    metaFont.init(this.in);
                    this.state.addMetaObject(metaFont);
                    break;
                case META_CREATEBRUSHINDIRECT /* 764 */:
                    i = length;
                    i2 = i10;
                    MetaBrush metaBrush = new MetaBrush();
                    metaBrush.init(this.in);
                    this.state.addMetaObject(metaBrush);
                    break;
                case META_POLYGON /* 804 */:
                    i = length;
                    i2 = i10;
                    if (!isNullStrokeFill(false)) {
                        int word3 = this.in.readWord();
                        int i13 = this.in.readShort();
                        int i14 = this.in.readShort();
                        this.cb.moveTo(this.state.transformX(i13), this.state.transformY(i14));
                        for (int i15 = 1; i15 < word3; i15++) {
                            this.cb.lineTo(this.state.transformX(this.in.readShort()), this.state.transformY(this.in.readShort()));
                        }
                        this.cb.lineTo(this.state.transformX(i13), this.state.transformY(i14));
                        strokeAndFill();
                    }
                    break;
                case META_POLYLINE /* 805 */:
                    i = length;
                    i2 = i10;
                    this.state.setLineJoinPolygon(this.cb);
                    int word4 = this.in.readWord();
                    this.cb.moveTo(this.state.transformX(this.in.readShort()), this.state.transformY(this.in.readShort()));
                    for (int i16 = 1; i16 < word4; i16++) {
                        this.cb.lineTo(this.state.transformX(this.in.readShort()), this.state.transformY(this.in.readShort()));
                    }
                    this.cb.stroke();
                    break;
                case META_INTERSECTCLIPRECT /* 1046 */:
                    i = length;
                    i2 = i10;
                    float fTransformY = this.state.transformY(this.in.readShort());
                    float fTransformX = this.state.transformX(this.in.readShort());
                    float fTransformY2 = this.state.transformY(this.in.readShort());
                    float fTransformX2 = this.state.transformX(this.in.readShort());
                    this.cb.rectangle(fTransformX2, fTransformY, fTransformX - fTransformX2, fTransformY2 - fTransformY);
                    this.cb.eoClip();
                    this.cb.newPath();
                    break;
                case META_ELLIPSE /* 1048 */:
                    i = length;
                    i2 = i10;
                    if (!isNullStrokeFill(this.state.getLineNeutral())) {
                        this.cb.arc(this.state.transformX(this.in.readShort()), this.state.transformY(this.in.readShort()), this.state.transformX(this.in.readShort()), this.state.transformY(this.in.readShort()), 0.0f, 360.0f);
                        strokeAndFill();
                    }
                    break;
                case META_RECTANGLE /* 1051 */:
                    i = length;
                    i2 = i10;
                    if (!isNullStrokeFill(true)) {
                        float fTransformY3 = this.state.transformY(this.in.readShort());
                        float fTransformX3 = this.state.transformX(this.in.readShort());
                        float fTransformY4 = this.state.transformY(this.in.readShort());
                        float fTransformX4 = this.state.transformX(this.in.readShort());
                        this.cb.rectangle(fTransformX4, fTransformY3, fTransformX3 - fTransformX4, fTransformY4 - fTransformY3);
                        strokeAndFill();
                    }
                    break;
                case META_SETPIXEL /* 1055 */:
                    i = length;
                    i2 = i10;
                    BaseColor color = this.in.readColor();
                    int i17 = this.in.readShort();
                    int i18 = this.in.readShort();
                    this.cb.saveState();
                    this.cb.setColorFill(color);
                    this.cb.rectangle(this.state.transformX(i18), this.state.transformY(i17), 0.2f, 0.2f);
                    this.cb.fill();
                    this.cb.restoreState();
                    break;
                case META_TEXTOUT /* 1313 */:
                    i = length;
                    i2 = i10;
                    int word5 = this.in.readWord();
                    byte[] bArr = new byte[word5];
                    int i19 = 0;
                    while (i19 < word5) {
                        byte b = (byte) this.in.readByte();
                        if (b != 0) {
                            bArr[i19] = b;
                            i19++;
                        }
                    }
                    try {
                        i3 = 0;
                        try {
                            str = new String(bArr, 0, i19, "Cp1252");
                        } catch (UnsupportedEncodingException unused) {
                            str = new String(bArr, i3, i19);
                        }
                    } catch (UnsupportedEncodingException unused2) {
                        i3 = 0;
                    }
                    String str3 = str;
                    this.in.skip(((word5 + 1) & 65534) - i19);
                    outputText(this.in.readShort(), this.in.readShort(), 0, 0, 0, 0, 0, str3);
                    break;
                case META_POLYPOLYGON /* 1336 */:
                    i = length;
                    i2 = i10;
                    if (!isNullStrokeFill(false)) {
                        int word6 = this.in.readWord();
                        int[] iArr = new int[word6];
                        for (int i20 = 0; i20 < word6; i20++) {
                            iArr[i20] = this.in.readWord();
                        }
                        for (int i21 = 0; i21 < word6; i21++) {
                            int i22 = iArr[i21];
                            int i23 = this.in.readShort();
                            int i24 = this.in.readShort();
                            this.cb.moveTo(this.state.transformX(i23), this.state.transformY(i24));
                            for (int i25 = 1; i25 < i22; i25++) {
                                this.cb.lineTo(this.state.transformX(this.in.readShort()), this.state.transformY(this.in.readShort()));
                            }
                            this.cb.lineTo(this.state.transformX(i23), this.state.transformY(i24));
                        }
                        strokeAndFill();
                    }
                    break;
                case META_ROUNDRECT /* 1564 */:
                    i = length;
                    i2 = i10;
                    if (!isNullStrokeFill(true)) {
                        float fTransformY5 = this.state.transformY(0) - this.state.transformY(this.in.readShort());
                        float fTransformX5 = this.state.transformX(this.in.readShort()) - this.state.transformX(0);
                        float fTransformY6 = this.state.transformY(this.in.readShort());
                        float fTransformX6 = this.state.transformX(this.in.readShort());
                        float fTransformY7 = this.state.transformY(this.in.readShort());
                        float fTransformX7 = this.state.transformX(this.in.readShort());
                        this.cb.roundRectangle(fTransformX7, fTransformY6, fTransformX6 - fTransformX7, fTransformY7 - fTransformY6, (fTransformY5 + fTransformX5) / 4.0f);
                        strokeAndFill();
                    }
                    break;
                case META_ARC /* 2071 */:
                    i = length;
                    i2 = i10;
                    if (!isNullStrokeFill(this.state.getLineNeutral())) {
                        float fTransformY8 = this.state.transformY(this.in.readShort());
                        float fTransformX8 = this.state.transformX(this.in.readShort());
                        float fTransformY9 = this.state.transformY(this.in.readShort());
                        float fTransformX9 = this.state.transformX(this.in.readShort());
                        float fTransformY10 = this.state.transformY(this.in.readShort());
                        float fTransformX10 = this.state.transformX(this.in.readShort());
                        float fTransformY11 = this.state.transformY(this.in.readShort());
                        float fTransformX11 = this.state.transformX(this.in.readShort());
                        float f = (fTransformX10 + fTransformX11) / 2.0f;
                        float f2 = (fTransformY11 + fTransformY10) / 2.0f;
                        float arc = getArc(f, f2, fTransformX9, fTransformY9);
                        float arc2 = getArc(f, f2, fTransformX8, fTransformY8) - arc;
                        if (arc2 <= 0.0f) {
                            arc2 += 360.0f;
                        }
                        this.cb.arc(fTransformX11, fTransformY10, fTransformX10, fTransformY11, arc, arc2);
                        this.cb.stroke();
                    }
                    break;
                case META_PIE /* 2074 */:
                    i = length;
                    i2 = i10;
                    if (!isNullStrokeFill(this.state.getLineNeutral())) {
                        float fTransformY12 = this.state.transformY(this.in.readShort());
                        float fTransformX12 = this.state.transformX(this.in.readShort());
                        float fTransformY13 = this.state.transformY(this.in.readShort());
                        float fTransformX13 = this.state.transformX(this.in.readShort());
                        float fTransformY14 = this.state.transformY(this.in.readShort());
                        float fTransformX14 = this.state.transformX(this.in.readShort());
                        float fTransformY15 = this.state.transformY(this.in.readShort());
                        float fTransformX15 = this.state.transformX(this.in.readShort());
                        float f3 = (fTransformX14 + fTransformX15) / 2.0f;
                        float f4 = (fTransformY15 + fTransformY14) / 2.0f;
                        double arc3 = getArc(f3, f4, fTransformX13, fTransformY13);
                        double arc4 = ((double) getArc(f3, f4, fTransformX12, fTransformY12)) - arc3;
                        if (arc4 <= 0.0d) {
                            arc4 += 360.0d;
                        }
                        ArrayList<double[]> arrayListBezierArc = PdfContentByte.bezierArc(fTransformX15, fTransformY14, fTransformX14, fTransformY15, arc3, arc4);
                        if (!arrayListBezierArc.isEmpty()) {
                            double[] dArr = arrayListBezierArc.get(0);
                            this.cb.moveTo(f3, f4);
                            this.cb.lineTo(dArr[0], dArr[1]);
                            for (int i26 = 0; i26 < arrayListBezierArc.size(); i26++) {
                                double[] dArr2 = arrayListBezierArc.get(i26);
                                this.cb.curveTo(dArr2[2], dArr2[3], dArr2[4], dArr2[5], dArr2[6], dArr2[7]);
                            }
                            this.cb.lineTo(f3, f4);
                            strokeAndFill();
                        }
                    }
                    break;
                case META_CHORD /* 2096 */:
                    if (isNullStrokeFill(this.state.getLineNeutral())) {
                        i = length;
                        i2 = i10;
                    } else {
                        float fTransformY16 = this.state.transformY(this.in.readShort());
                        float fTransformX16 = this.state.transformX(this.in.readShort());
                        float fTransformY17 = this.state.transformY(this.in.readShort());
                        float fTransformX17 = this.state.transformX(this.in.readShort());
                        float fTransformY18 = this.state.transformY(this.in.readShort());
                        float fTransformX18 = this.state.transformX(this.in.readShort());
                        float fTransformY19 = this.state.transformY(this.in.readShort());
                        float fTransformX19 = this.state.transformX(this.in.readShort());
                        double d = (fTransformX18 + fTransformX19) / 2.0f;
                        double d2 = (fTransformY19 + fTransformY18) / 2.0f;
                        i = length;
                        i2 = i10;
                        double arc5 = getArc(d, d2, fTransformX17, fTransformY17);
                        double arc6 = getArc(d, d2, fTransformX16, fTransformY16) - arc5;
                        if (arc6 <= 0.0d) {
                            arc6 += 360.0d;
                        }
                        ArrayList<double[]> arrayListBezierArc2 = PdfContentByte.bezierArc(fTransformX19, fTransformY18, fTransformX18, fTransformY19, arc5, arc6);
                        if (!arrayListBezierArc2.isEmpty()) {
                            double[] dArr3 = arrayListBezierArc2.get(0);
                            double d3 = dArr3[0];
                            double d4 = dArr3[1];
                            this.cb.moveTo(d3, d4);
                            for (int i27 = 0; i27 < arrayListBezierArc2.size(); i27++) {
                                double[] dArr4 = arrayListBezierArc2.get(i27);
                                this.cb.curveTo(dArr4[2], dArr4[3], dArr4[4], dArr4[5], dArr4[6], dArr4[7]);
                            }
                            this.cb.lineTo(d3, d4);
                            strokeAndFill();
                        }
                    }
                    break;
                case META_EXTTEXTOUT /* 2610 */:
                    int i28 = this.in.readShort();
                    int i29 = this.in.readShort();
                    int word7 = this.in.readWord();
                    int word8 = this.in.readWord();
                    if ((word8 & 6) != 0) {
                        i4 = this.in.readShort();
                        i5 = this.in.readShort();
                        i6 = this.in.readShort();
                        i7 = this.in.readShort();
                    } else {
                        i4 = 0;
                        i5 = 0;
                        i6 = 0;
                        i7 = 0;
                    }
                    byte[] bArr2 = new byte[word7];
                    int i30 = 0;
                    while (i30 < word7) {
                        byte b2 = (byte) this.in.readByte();
                        if (b2 != 0) {
                            bArr2[i30] = b2;
                            i30++;
                        }
                    }
                    try {
                        i8 = 0;
                        try {
                            str2 = new String(bArr2, 0, i30, "Cp1252");
                        } catch (UnsupportedEncodingException unused3) {
                            str2 = new String(bArr2, i8, i30);
                        }
                    } catch (UnsupportedEncodingException unused4) {
                        i8 = 0;
                    }
                    outputText(i29, i28, word8, i4, i5, i6, i7, str2);
                    i = length;
                    i2 = i10;
                    break;
                case META_DIBSTRETCHBLT /* 2881 */:
                case META_STRETCHDIB /* 3907 */:
                    this.in.readInt();
                    if (word2 == 3907) {
                        this.in.readWord();
                    }
                    int i31 = this.in.readShort();
                    int i32 = this.in.readShort();
                    int i33 = this.in.readShort();
                    int i34 = this.in.readShort();
                    float fTransformY20 = this.state.transformY(this.in.readShort()) - this.state.transformY(i9);
                    float fTransformX20 = this.state.transformX(this.in.readShort()) - this.state.transformX(i9);
                    float fTransformY21 = this.state.transformY(this.in.readShort());
                    float fTransformX21 = this.state.transformX(this.in.readShort());
                    int length2 = (i10 * 2) - (this.in.getLength() - length);
                    byte[] bArr3 = new byte[length2];
                    for (int i35 = 0; i35 < length2; i35++) {
                        bArr3[i35] = (byte) this.in.readByte();
                    }
                    try {
                        Image image = BmpImage.getImage(new ByteArrayInputStream(bArr3), z, length2);
                        this.cb.saveState();
                        this.cb.rectangle(fTransformX21, fTransformY21, fTransformX20, fTransformY20);
                        this.cb.clip();
                        this.cb.newPath();
                        float f5 = i32;
                        float f6 = i31;
                        image.scaleAbsolute((image.getWidth() * fTransformX20) / f5, ((-fTransformY20) * image.getHeight()) / f6);
                        image.setAbsolutePosition(fTransformX21 - ((fTransformX20 * i34) / f5), (fTransformY21 + ((fTransformY20 * i33) / f6)) - image.getScaledHeight());
                        this.cb.addImage(image);
                        this.cb.restoreState();
                        break;
                    } catch (Exception unused5) {
                    }
                    i = length;
                    i2 = i10;
                    break;
                default:
                    i = length;
                    i2 = i10;
                    break;
            }
            InputMeta inputMeta = this.in;
            inputMeta.skip((i2 * 2) - (inputMeta.getLength() - i));
            i9 = 0;
            z = true;
        }
    }

    public void strokeAndFill() {
        MetaPen currentPen = this.state.getCurrentPen();
        MetaBrush currentBrush = this.state.getCurrentBrush();
        int style = currentPen.getStyle();
        int style2 = currentBrush.getStyle();
        if (style == 5) {
            this.cb.closePath();
            if (this.state.getPolyFillMode() == 1) {
                this.cb.eoFill();
                return;
            } else {
                this.cb.fill();
                return;
            }
        }
        if (style2 != 0 && (style2 != 2 || this.state.getBackgroundMode() != 2)) {
            this.cb.closePathStroke();
        } else if (this.state.getPolyFillMode() == 1) {
            this.cb.closePathEoFillStroke();
        } else {
            this.cb.closePathFillStroke();
        }
    }

    public static double getArc(double d, double d2, double d3, double d4) {
        double dAtan2 = Math.atan2(d4 - d2, d3 - d);
        if (dAtan2 < 0.0d) {
            dAtan2 += 6.283185307179586d;
        }
        return (float) ((dAtan2 / 3.141592653589793d) * 180.0d);
    }
}
