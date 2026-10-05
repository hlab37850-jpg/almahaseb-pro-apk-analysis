package com.itextpdf.tool.xml.html.table;

import com.itextpdf.text.BaseColor;

/* JADX INFO: loaded from: classes3.dex */
public class TableStyleValues {
    private BaseColor background;
    private BaseColor borderBottomColor;
    private BaseColor borderLeftColor;
    private BaseColor borderRightColor;
    private BaseColor borderTopColor;
    private float horBorderSpacing;
    private float verBorderSpacing;
    private Float borderLeftWidth = null;
    private Float borderRightWidth = null;
    private Float borderTopWidth = null;
    private Float borderBottomWidth = null;
    private boolean isLastInRow = false;

    public BaseColor getBackground() {
        return this.background;
    }

    public BaseColor getBorderColorBottom() {
        return this.borderBottomColor;
    }

    public BaseColor getBorderColorLeft() {
        return this.borderLeftColor;
    }

    public BaseColor getBorderColorRight() {
        return this.borderRightColor;
    }

    public BaseColor getBorderColorTop() {
        return this.borderTopColor;
    }

    public float getBorderWidthBottom() {
        return getBorderWidthBottom(true).floatValue();
    }

    public float getBorderWidthLeft() {
        return getBorderWidthLeft(true).floatValue();
    }

    public float getBorderWidthRight() {
        return getBorderWidthRight(true).floatValue();
    }

    public float getBorderWidthTop() {
        return getBorderWidthTop(true).floatValue();
    }

    public float getHorBorderSpacing() {
        return this.horBorderSpacing;
    }

    public float getVerBorderSpacing() {
        return this.verBorderSpacing;
    }

    public boolean isLastInRow() {
        return this.isLastInRow;
    }

    public void setBackground(BaseColor baseColor) {
        this.background = baseColor;
    }

    public void setBorderColor(BaseColor baseColor) {
        this.borderBottomColor = baseColor;
        this.borderLeftColor = baseColor;
        this.borderRightColor = baseColor;
        this.borderTopColor = baseColor;
    }

    public void setBorderColorBottom(BaseColor baseColor) {
        this.borderBottomColor = baseColor;
    }

    public void setBorderColorLeft(BaseColor baseColor) {
        this.borderLeftColor = baseColor;
    }

    public void setBorderColorRight(BaseColor baseColor) {
        this.borderRightColor = baseColor;
    }

    public void setBorderColorTop(BaseColor baseColor) {
        this.borderTopColor = baseColor;
    }

    public void setBorderWidth(float f) {
        this.borderBottomWidth = Float.valueOf(f);
        this.borderLeftWidth = Float.valueOf(f);
        this.borderRightWidth = Float.valueOf(f);
        this.borderTopWidth = Float.valueOf(f);
    }

    public void setBorderWidthBottom(float f) {
        this.borderBottomWidth = Float.valueOf(f);
    }

    public void setBorderWidthLeft(float f) {
        this.borderLeftWidth = Float.valueOf(f);
    }

    public void setBorderWidthRight(float f) {
        this.borderRightWidth = Float.valueOf(f);
    }

    public void setBorderWidthTop(float f) {
        this.borderTopWidth = Float.valueOf(f);
    }

    public void setHorBorderSpacing(float f) {
        this.horBorderSpacing = f;
    }

    public void setLastInRow(boolean z) {
        this.isLastInRow = z;
    }

    public void setVerBorderSpacing(float f) {
        this.verBorderSpacing = f;
    }

    public Float getBorderWidthBottom(boolean z) {
        Float f = this.borderBottomWidth;
        return (f == null && z) ? Float.valueOf(0.0f) : f;
    }

    public Float getBorderWidthLeft(boolean z) {
        Float f = this.borderLeftWidth;
        return (f == null && z) ? Float.valueOf(0.0f) : f;
    }

    public Float getBorderWidthRight(boolean z) {
        Float f = this.borderRightWidth;
        return (f == null && z) ? Float.valueOf(0.0f) : f;
    }

    public Float getBorderWidthTop(boolean z) {
        Float f = this.borderTopWidth;
        return (f == null && z) ? Float.valueOf(0.0f) : f;
    }
}
