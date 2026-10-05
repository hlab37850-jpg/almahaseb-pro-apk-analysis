package com.itextpdf.awt.geom;

import com.itextpdf.awt.geom.gl.Crossing;
import com.itextpdf.awt.geom.misc.Messages;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class GeneralPath implements Shape, Cloneable {
    private static final int BUFFER_CAPACITY = 10;
    private static final int BUFFER_SIZE = 10;
    public static final int WIND_EVEN_ODD = 0;
    public static final int WIND_NON_ZERO = 1;
    static int[] pointShift = {2, 2, 4, 6, 0};
    int pointSize;
    float[] points;
    int rule;
    int typeSize;
    byte[] types;

    public class Iterator implements PathIterator {
        GeneralPath p;
        int pointIndex;
        AffineTransform t;
        int typeIndex;

        public Iterator(GeneralPath generalPath, GeneralPath generalPath2) {
            this(generalPath2, null);
        }

        @Override // com.itextpdf.awt.geom.PathIterator
        public int currentSegment(double[] dArr) {
            if (isDone()) {
                throw new NoSuchElementException(Messages.getString("awt.4B"));
            }
            byte b = this.p.types[this.typeIndex];
            int i = GeneralPath.pointShift[b];
            for (int i2 = 0; i2 < i; i2++) {
                dArr[i2] = this.p.points[this.pointIndex + i2];
            }
            AffineTransform affineTransform = this.t;
            if (affineTransform != null) {
                affineTransform.transform(dArr, 0, dArr, 0, i / 2);
            }
            this.pointIndex += i;
            return b;
        }

        @Override // com.itextpdf.awt.geom.PathIterator
        public int getWindingRule() {
            return this.p.getWindingRule();
        }

        @Override // com.itextpdf.awt.geom.PathIterator
        public boolean isDone() {
            return this.typeIndex >= this.p.typeSize;
        }

        @Override // com.itextpdf.awt.geom.PathIterator
        public void next() {
            this.typeIndex++;
        }

        public Iterator(GeneralPath generalPath, AffineTransform affineTransform) {
            this.p = generalPath;
            this.t = affineTransform;
        }

        @Override // com.itextpdf.awt.geom.PathIterator
        public int currentSegment(float[] fArr) {
            if (!isDone()) {
                GeneralPath generalPath = this.p;
                byte b = generalPath.types[this.typeIndex];
                int i = GeneralPath.pointShift[b];
                System.arraycopy(generalPath.points, this.pointIndex, fArr, 0, i);
                AffineTransform affineTransform = this.t;
                if (affineTransform != null) {
                    affineTransform.transform(fArr, 0, fArr, 0, i / 2);
                }
                this.pointIndex += i;
                return b;
            }
            throw new NoSuchElementException(Messages.getString("awt.4B"));
        }
    }

    public GeneralPath() {
        this(1, 10);
    }

    public void append(Shape shape, boolean z) {
        append(shape.getPathIterator(null), z);
    }

    public void checkBuf(int i, boolean z) {
        if (z && this.typeSize == 0) {
            throw new IllegalPathStateException(Messages.getString("awt.20A"));
        }
        int i2 = this.typeSize;
        byte[] bArr = this.types;
        if (i2 == bArr.length) {
            byte[] bArr2 = new byte[i2 + 10];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.types = bArr2;
        }
        int i3 = this.pointSize;
        if (i3 + i > this.points.length) {
            float[] fArr = new float[i3 + Math.max(20, i)];
            System.arraycopy(this.points, 0, fArr, 0, this.pointSize);
            this.points = fArr;
        }
    }

    public Object clone() {
        try {
            GeneralPath generalPath = (GeneralPath) super.clone();
            generalPath.types = (byte[]) this.types.clone();
            generalPath.points = (float[]) this.points.clone();
            return generalPath;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public void closePath() {
        int i = this.typeSize;
        if (i == 0 || this.types[i - 1] != 4) {
            checkBuf(0, true);
            byte[] bArr = this.types;
            int i2 = this.typeSize;
            this.typeSize = i2 + 1;
            bArr[i2] = 4;
        }
    }

    @Override // com.itextpdf.awt.geom.Shape
    public boolean contains(double d, double d2) {
        return isInside(Crossing.crossShape(this, d, d2));
    }

    public Shape createTransformedShape(AffineTransform affineTransform) {
        GeneralPath generalPath = (GeneralPath) clone();
        if (affineTransform != null) {
            generalPath.transform(affineTransform);
        }
        return generalPath;
    }

    public void curveTo(float f, float f2, float f3, float f4, float f5, float f6) {
        checkBuf(6, true);
        byte[] bArr = this.types;
        int i = this.typeSize;
        this.typeSize = i + 1;
        bArr[i] = 3;
        float[] fArr = this.points;
        int i2 = this.pointSize;
        int i3 = i2 + 1;
        this.pointSize = i3;
        fArr[i2] = f;
        int i4 = i2 + 2;
        this.pointSize = i4;
        fArr[i3] = f2;
        int i5 = i2 + 3;
        this.pointSize = i5;
        fArr[i4] = f3;
        int i6 = i2 + 4;
        this.pointSize = i6;
        fArr[i5] = f4;
        int i7 = i2 + 5;
        this.pointSize = i7;
        fArr[i6] = f5;
        this.pointSize = i2 + 6;
        fArr[i7] = f6;
    }

    @Override // com.itextpdf.awt.geom.Shape
    public Rectangle getBounds() {
        return getBounds2D().getBounds();
    }

    @Override // com.itextpdf.awt.geom.Shape
    public Rectangle2D getBounds2D() {
        float f;
        float f2;
        float f3;
        float f4;
        int i = this.pointSize;
        if (i == 0) {
            f4 = 0.0f;
            f = 0.0f;
            f3 = 0.0f;
            f2 = 0.0f;
        } else {
            float[] fArr = this.points;
            int i2 = i - 2;
            f = fArr[i - 1];
            int i3 = i - 3;
            float f5 = fArr[i2];
            f2 = f;
            f3 = f5;
            while (i3 > 0) {
                float[] fArr2 = this.points;
                int i4 = i3 - 1;
                float f6 = fArr2[i3];
                i3 -= 2;
                float f7 = fArr2[i4];
                if (f7 < f5) {
                    f5 = f7;
                } else if (f7 > f3) {
                    f3 = f7;
                }
                if (f6 < f) {
                    f = f6;
                } else if (f6 > f2) {
                    f2 = f6;
                }
            }
            f4 = f5;
        }
        return new Rectangle2D.Float(f4, f, f3 - f4, f2 - f);
    }

    public Point2D getCurrentPoint() {
        int i = this.typeSize;
        if (i == 0) {
            return null;
        }
        int i2 = this.pointSize - 2;
        if (this.types[i - 1] == 4) {
            for (int i3 = i - 2; i3 > 0; i3--) {
                byte b = this.types[i3];
                if (b == 0) {
                    break;
                }
                i2 -= pointShift[b];
            }
        }
        float[] fArr = this.points;
        return new Point2D.Float(fArr[i2], fArr[i2 + 1]);
    }

    @Override // com.itextpdf.awt.geom.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new Iterator(this, affineTransform);
    }

    public int getWindingRule() {
        return this.rule;
    }

    @Override // com.itextpdf.awt.geom.Shape
    public boolean intersects(double d, double d2, double d3, double d4) {
        int iIntersectShape = Crossing.intersectShape(this, d, d2, d3, d4);
        return iIntersectShape == 255 || isInside(iIntersectShape);
    }

    public boolean isInside(int i) {
        return this.rule == 1 ? Crossing.isInsideNonZero(i) : Crossing.isInsideEvenOdd(i);
    }

    public void lineTo(float f, float f2) {
        checkBuf(2, true);
        byte[] bArr = this.types;
        int i = this.typeSize;
        this.typeSize = i + 1;
        bArr[i] = 1;
        float[] fArr = this.points;
        int i2 = this.pointSize;
        int i3 = i2 + 1;
        this.pointSize = i3;
        fArr[i2] = f;
        this.pointSize = i2 + 2;
        fArr[i3] = f2;
    }

    public void moveTo(float f, float f2) {
        int i = this.typeSize;
        if (i > 0 && this.types[i - 1] == 0) {
            float[] fArr = this.points;
            int i2 = this.pointSize;
            fArr[i2 - 2] = f;
            fArr[i2 - 1] = f2;
            return;
        }
        checkBuf(2, false);
        byte[] bArr = this.types;
        int i3 = this.typeSize;
        this.typeSize = i3 + 1;
        bArr[i3] = 0;
        float[] fArr2 = this.points;
        int i4 = this.pointSize;
        int i5 = i4 + 1;
        this.pointSize = i5;
        fArr2[i4] = f;
        this.pointSize = i4 + 2;
        fArr2[i5] = f2;
    }

    public void quadTo(float f, float f2, float f3, float f4) {
        checkBuf(4, true);
        byte[] bArr = this.types;
        int i = this.typeSize;
        this.typeSize = i + 1;
        bArr[i] = 2;
        float[] fArr = this.points;
        int i2 = this.pointSize;
        int i3 = i2 + 1;
        this.pointSize = i3;
        fArr[i2] = f;
        int i4 = i2 + 2;
        this.pointSize = i4;
        fArr[i3] = f2;
        int i5 = i2 + 3;
        this.pointSize = i5;
        fArr[i4] = f3;
        this.pointSize = i2 + 4;
        fArr[i5] = f4;
    }

    public void reset() {
        this.typeSize = 0;
        this.pointSize = 0;
    }

    public void setWindingRule(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(Messages.getString("awt.209"));
        }
        this.rule = i;
    }

    public void transform(AffineTransform affineTransform) {
        float[] fArr = this.points;
        affineTransform.transform(fArr, 0, fArr, 0, this.pointSize / 2);
    }

    public GeneralPath(int i) {
        this(i, 10);
    }

    @Override // com.itextpdf.awt.geom.Shape
    public boolean contains(double d, double d2, double d3, double d4) {
        int iIntersectShape = Crossing.intersectShape(this, d, d2, d3, d4);
        return iIntersectShape != 255 && isInside(iIntersectShape);
    }

    @Override // com.itextpdf.awt.geom.Shape
    public PathIterator getPathIterator(AffineTransform affineTransform, double d) {
        return new FlatteningPathIterator(getPathIterator(affineTransform), d);
    }

    public GeneralPath(int i, int i2) {
        setWindingRule(i);
        this.types = new byte[i2];
        this.points = new float[i2 * 2];
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0067  */
    public void append(PathIterator pathIterator, boolean z) {
        int i;
        while (!pathIterator.isDone()) {
            float[] fArr = new float[6];
            int iCurrentSegment = pathIterator.currentSegment(fArr);
            if (iCurrentSegment != 0) {
                if (iCurrentSegment == 1) {
                    lineTo(fArr[0], fArr[1]);
                } else if (iCurrentSegment == 2) {
                    quadTo(fArr[0], fArr[1], fArr[2], fArr[3]);
                } else if (iCurrentSegment == 3) {
                    curveTo(fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5]);
                } else if (iCurrentSegment == 4) {
                    closePath();
                }
            } else if (z && (i = this.typeSize) != 0) {
                if (this.types[i - 1] != 4) {
                    float[] fArr2 = this.points;
                    int i2 = this.pointSize;
                    if (fArr2[i2 - 2] != fArr[0] || fArr2[i2 - 1] != fArr[1]) {
                        lineTo(fArr[0], fArr[1]);
                    }
                } else {
                    lineTo(fArr[0], fArr[1]);
                }
            } else {
                moveTo(fArr[0], fArr[1]);
            }
            pathIterator.next();
            z = false;
        }
    }

    @Override // com.itextpdf.awt.geom.Shape
    public boolean intersects(Rectangle2D rectangle2D) {
        return intersects(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    @Override // com.itextpdf.awt.geom.Shape
    public boolean contains(Point2D point2D) {
        return contains(point2D.getX(), point2D.getY());
    }

    @Override // com.itextpdf.awt.geom.Shape
    public boolean contains(Rectangle2D rectangle2D) {
        return contains(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public GeneralPath(Shape shape) {
        this(1, 10);
        PathIterator pathIterator = shape.getPathIterator(null);
        setWindingRule(pathIterator.getWindingRule());
        append(pathIterator, false);
    }
}
