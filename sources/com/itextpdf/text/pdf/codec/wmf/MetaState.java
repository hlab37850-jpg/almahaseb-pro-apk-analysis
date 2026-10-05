package com.itextpdf.text.pdf.codec.wmf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PdfContentByte;
import java.util.ArrayList;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public class MetaState {
    public static final int ALTERNATE = 1;
    public static final int OPAQUE = 2;
    public static final int TA_BASELINE = 24;
    public static final int TA_BOTTOM = 8;
    public static final int TA_CENTER = 6;
    public static final int TA_LEFT = 0;
    public static final int TA_NOUPDATECP = 0;
    public static final int TA_RIGHT = 2;
    public static final int TA_TOP = 0;
    public static final int TA_UPDATECP = 1;
    public static final int TRANSPARENT = 1;
    public static final int WINDING = 2;
    public ArrayList<MetaObject> MetaObjects;
    public int backgroundMode;
    public BaseColor currentBackgroundColor;
    public MetaBrush currentBrush;
    public MetaFont currentFont;
    public MetaPen currentPen;
    public Point currentPoint;
    public BaseColor currentTextColor;
    public int extentWx;
    public int extentWy;
    public int lineJoin;
    public int offsetWx;
    public int offsetWy;
    public int polyFillMode;
    public Stack<MetaState> savedStates;
    public float scalingX;
    public float scalingY;
    public int textAlign;

    public MetaState() {
        this.currentBackgroundColor = BaseColor.WHITE;
        this.currentTextColor = BaseColor.BLACK;
        this.backgroundMode = 2;
        this.polyFillMode = 1;
        this.lineJoin = 1;
        this.savedStates = new Stack<>();
        this.MetaObjects = new ArrayList<>();
        this.currentPoint = new Point(0, 0);
        this.currentPen = new MetaPen();
        this.currentBrush = new MetaBrush();
        this.currentFont = new MetaFont();
    }

    public void addMetaObject(MetaObject metaObject) {
        for (int i = 0; i < this.MetaObjects.size(); i++) {
            if (this.MetaObjects.get(i) == null) {
                this.MetaObjects.set(i, metaObject);
                return;
            }
        }
        this.MetaObjects.add(metaObject);
    }

    public void cleanup(PdfContentByte pdfContentByte) {
        int size = this.savedStates.size();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            pdfContentByte.restoreState();
            size = i;
        }
    }

    public void deleteMetaObject(int i) {
        this.MetaObjects.set(i, null);
    }

    public int getBackgroundMode() {
        return this.backgroundMode;
    }

    public BaseColor getCurrentBackgroundColor() {
        return this.currentBackgroundColor;
    }

    public MetaBrush getCurrentBrush() {
        return this.currentBrush;
    }

    public MetaFont getCurrentFont() {
        return this.currentFont;
    }

    public MetaPen getCurrentPen() {
        return this.currentPen;
    }

    public Point getCurrentPoint() {
        return this.currentPoint;
    }

    public BaseColor getCurrentTextColor() {
        return this.currentTextColor;
    }

    public boolean getLineNeutral() {
        return this.lineJoin == 0;
    }

    public int getPolyFillMode() {
        return this.polyFillMode;
    }

    public int getTextAlign() {
        return this.textAlign;
    }

    public void restoreState(int i, PdfContentByte pdfContentByte) {
        int iMin = i < 0 ? Math.min(-i, this.savedStates.size()) : Math.max(this.savedStates.size() - i, 0);
        if (iMin == 0) {
            return;
        }
        MetaState metaStatePop = null;
        while (true) {
            int i2 = iMin - 1;
            if (iMin == 0) {
                setMetaState(metaStatePop);
                return;
            } else {
                pdfContentByte.restoreState();
                metaStatePop = this.savedStates.pop();
                iMin = i2;
            }
        }
    }

    public void saveState(PdfContentByte pdfContentByte) {
        pdfContentByte.saveState();
        this.savedStates.push(new MetaState(this));
    }

    public void selectMetaObject(int i, PdfContentByte pdfContentByte) {
        MetaObject metaObject = this.MetaObjects.get(i);
        if (metaObject == null) {
            return;
        }
        int type = metaObject.getType();
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    return;
                }
                this.currentFont = (MetaFont) metaObject;
                return;
            }
            MetaBrush metaBrush = (MetaBrush) metaObject;
            this.currentBrush = metaBrush;
            int style = metaBrush.getStyle();
            if (style == 0) {
                pdfContentByte.setColorFill(this.currentBrush.getColor());
                return;
            } else {
                if (style == 2) {
                    pdfContentByte.setColorFill(this.currentBackgroundColor);
                    return;
                }
                return;
            }
        }
        MetaPen metaPen = (MetaPen) metaObject;
        this.currentPen = metaPen;
        int style2 = metaPen.getStyle();
        if (style2 != 5) {
            pdfContentByte.setColorStroke(this.currentPen.getColor());
            pdfContentByte.setLineWidth(Math.abs((this.currentPen.getPenWidth() * this.scalingX) / this.extentWx));
            if (style2 == 1) {
                pdfContentByte.setLineDash(18.0f, 6.0f, 0.0f);
                return;
            }
            if (style2 == 2) {
                pdfContentByte.setLineDash(3.0f, 0.0f);
                return;
            }
            if (style2 == 3) {
                pdfContentByte.setLiteral("[9 6 3 6]0 d\n");
            } else if (style2 != 4) {
                pdfContentByte.setLineDash(0.0f);
            } else {
                pdfContentByte.setLiteral("[9 3 3 3 3 3]0 d\n");
            }
        }
    }

    public void setBackgroundMode(int i) {
        this.backgroundMode = i;
    }

    public void setCurrentBackgroundColor(BaseColor baseColor) {
        this.currentBackgroundColor = baseColor;
    }

    public void setCurrentPoint(Point point) {
        this.currentPoint = point;
    }

    public void setCurrentTextColor(BaseColor baseColor) {
        this.currentTextColor = baseColor;
    }

    public void setExtentWx(int i) {
        this.extentWx = i;
    }

    public void setExtentWy(int i) {
        this.extentWy = i;
    }

    public void setLineJoinPolygon(PdfContentByte pdfContentByte) {
        if (this.lineJoin == 0) {
            this.lineJoin = 1;
            pdfContentByte.setLineJoin(1);
        }
    }

    public void setLineJoinRectangle(PdfContentByte pdfContentByte) {
        if (this.lineJoin != 0) {
            this.lineJoin = 0;
            pdfContentByte.setLineJoin(0);
        }
    }

    public void setMetaState(MetaState metaState) {
        this.savedStates = metaState.savedStates;
        this.MetaObjects = metaState.MetaObjects;
        this.currentPoint = metaState.currentPoint;
        this.currentPen = metaState.currentPen;
        this.currentBrush = metaState.currentBrush;
        this.currentFont = metaState.currentFont;
        this.currentBackgroundColor = metaState.currentBackgroundColor;
        this.currentTextColor = metaState.currentTextColor;
        this.backgroundMode = metaState.backgroundMode;
        this.polyFillMode = metaState.polyFillMode;
        this.textAlign = metaState.textAlign;
        this.lineJoin = metaState.lineJoin;
        this.offsetWx = metaState.offsetWx;
        this.offsetWy = metaState.offsetWy;
        this.extentWx = metaState.extentWx;
        this.extentWy = metaState.extentWy;
        this.scalingX = metaState.scalingX;
        this.scalingY = metaState.scalingY;
    }

    public void setOffsetWx(int i) {
        this.offsetWx = i;
    }

    public void setOffsetWy(int i) {
        this.offsetWy = i;
    }

    public void setPolyFillMode(int i) {
        this.polyFillMode = i;
    }

    public void setScalingX(float f) {
        this.scalingX = f;
    }

    public void setScalingY(float f) {
        this.scalingY = f;
    }

    public void setTextAlign(int i) {
        this.textAlign = i;
    }

    public float transformAngle(float f) {
        if (this.scalingY < 0.0f) {
            f = -f;
        }
        return (float) (this.scalingX < 0.0f ? 3.141592653589793d - ((double) f) : f);
    }

    public float transformX(int i) {
        return ((i - this.offsetWx) * this.scalingX) / this.extentWx;
    }

    public float transformY(int i) {
        return (1.0f - ((i - this.offsetWy) / this.extentWy)) * this.scalingY;
    }

    public MetaState(MetaState metaState) {
        this.currentBackgroundColor = BaseColor.WHITE;
        this.currentTextColor = BaseColor.BLACK;
        this.backgroundMode = 2;
        this.polyFillMode = 1;
        this.lineJoin = 1;
        setMetaState(metaState);
    }
}
