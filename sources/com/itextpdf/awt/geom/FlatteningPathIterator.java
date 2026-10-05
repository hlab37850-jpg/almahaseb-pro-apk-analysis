package com.itextpdf.awt.geom;

import com.itextpdf.awt.geom.misc.Messages;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public class FlatteningPathIterator implements PathIterator {
    private static final int BUFFER_CAPACITY = 16;
    private static final int BUFFER_LIMIT = 16;
    private static final int BUFFER_SIZE = 16;
    double[] buf;
    boolean bufEmpty;
    int bufIndex;
    int bufLimit;
    int bufSize;
    int bufSubdiv;
    int bufType;
    double[] coords;
    double flatness;
    double flatness2;
    PathIterator p;
    double px;
    double py;

    public FlatteningPathIterator(PathIterator pathIterator, double d) {
        this(pathIterator, d, 16);
    }

    @Override // com.itextpdf.awt.geom.PathIterator
    public int currentSegment(float[] fArr) {
        if (isDone()) {
            throw new NoSuchElementException(Messages.getString("awt.4Bx"));
        }
        evaluate();
        int i = this.bufType;
        if (i == 4) {
            return i;
        }
        fArr[0] = (float) this.px;
        fArr[1] = (float) this.py;
        if (i != 0) {
            return 1;
        }
        return i;
    }

    public void evaluate() {
        boolean z;
        if (this.bufEmpty) {
            this.bufType = this.p.currentSegment(this.coords);
        }
        int i = this.bufType;
        if (i == 0 || i == 1) {
            double[] dArr = this.coords;
            this.px = dArr[0];
            this.py = dArr[1];
            return;
        }
        if (i == 2) {
            if (this.bufEmpty) {
                int i2 = this.bufIndex;
                int i3 = i2 - 6;
                this.bufIndex = i3;
                double[] dArr2 = this.buf;
                dArr2[i3] = this.px;
                dArr2[i2 - 5] = this.py;
                System.arraycopy(this.coords, 0, dArr2, i2 - 4, 4);
                this.bufSubdiv = 0;
            }
            while (this.bufSubdiv < this.bufLimit && QuadCurve2D.getFlatnessSq(this.buf, this.bufIndex) >= this.flatness2) {
                int i4 = this.bufIndex;
                if (i4 <= 4) {
                    int i5 = this.bufSize;
                    double[] dArr3 = new double[i5 + 16];
                    System.arraycopy(this.buf, i4, dArr3, i4 + 16, i5 - i4);
                    this.buf = dArr3;
                    this.bufSize += 16;
                    this.bufIndex += 16;
                }
                double[] dArr4 = this.buf;
                int i6 = this.bufIndex;
                QuadCurve2D.subdivide(dArr4, i6, dArr4, i6 - 4, dArr4, i6);
                this.bufIndex -= 4;
                this.bufSubdiv++;
            }
            int i7 = this.bufIndex;
            int i8 = i7 + 4;
            this.bufIndex = i8;
            double[] dArr5 = this.buf;
            this.px = dArr5[i8];
            this.py = dArr5[i7 + 5];
            int i9 = this.bufSize;
            z = i8 == i9 + (-2);
            this.bufEmpty = z;
            if (z) {
                this.bufIndex = i9;
                this.bufType = 1;
                return;
            }
            return;
        }
        if (i != 3) {
            return;
        }
        if (this.bufEmpty) {
            int i10 = this.bufIndex;
            int i11 = i10 - 8;
            this.bufIndex = i11;
            double[] dArr6 = this.buf;
            dArr6[i11] = this.px;
            dArr6[i10 - 7] = this.py;
            System.arraycopy(this.coords, 0, dArr6, i10 - 6, 6);
            this.bufSubdiv = 0;
        }
        while (this.bufSubdiv < this.bufLimit && CubicCurve2D.getFlatnessSq(this.buf, this.bufIndex) >= this.flatness2) {
            int i12 = this.bufIndex;
            if (i12 <= 6) {
                int i13 = this.bufSize;
                double[] dArr7 = new double[i13 + 16];
                System.arraycopy(this.buf, i12, dArr7, i12 + 16, i13 - i12);
                this.buf = dArr7;
                this.bufSize += 16;
                this.bufIndex += 16;
            }
            double[] dArr8 = this.buf;
            int i14 = this.bufIndex;
            CubicCurve2D.subdivide(dArr8, i14, dArr8, i14 - 6, dArr8, i14);
            this.bufIndex -= 6;
            this.bufSubdiv++;
        }
        int i15 = this.bufIndex;
        int i16 = i15 + 6;
        this.bufIndex = i16;
        double[] dArr9 = this.buf;
        this.px = dArr9[i16];
        this.py = dArr9[i15 + 7];
        int i17 = this.bufSize;
        z = i16 == i17 + (-2);
        this.bufEmpty = z;
        if (z) {
            this.bufIndex = i17;
            this.bufType = 1;
        }
    }

    public double getFlatness() {
        return this.flatness;
    }

    public int getRecursionLimit() {
        return this.bufLimit;
    }

    @Override // com.itextpdf.awt.geom.PathIterator
    public int getWindingRule() {
        return this.p.getWindingRule();
    }

    @Override // com.itextpdf.awt.geom.PathIterator
    public boolean isDone() {
        return this.bufEmpty && this.p.isDone();
    }

    @Override // com.itextpdf.awt.geom.PathIterator
    public void next() {
        if (this.bufEmpty) {
            this.p.next();
        }
    }

    public FlatteningPathIterator(PathIterator pathIterator, double d, int i) {
        this.bufEmpty = true;
        this.coords = new double[6];
        if (d < 0.0d) {
            throw new IllegalArgumentException(Messages.getString("awt.206"));
        }
        if (i < 0) {
            throw new IllegalArgumentException(Messages.getString("awt.207"));
        }
        if (pathIterator == null) {
            throw new NullPointerException(Messages.getString("awt.208"));
        }
        this.p = pathIterator;
        this.flatness = d;
        this.flatness2 = d * d;
        this.bufLimit = i;
        int iMin = Math.min(i, 16);
        this.bufSize = iMin;
        this.buf = new double[iMin];
        this.bufIndex = iMin;
    }

    @Override // com.itextpdf.awt.geom.PathIterator
    public int currentSegment(double[] dArr) {
        if (!isDone()) {
            evaluate();
            int i = this.bufType;
            if (i == 4) {
                return i;
            }
            dArr[0] = this.px;
            dArr[1] = this.py;
            if (i != 0) {
                return 1;
            }
            return i;
        }
        throw new NoSuchElementException(Messages.getString("awt.4B"));
    }
}
