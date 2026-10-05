package com.itextpdf.awt.geom;

import com.itextpdf.awt.geom.misc.HashCode;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class Dimension extends Dimension2D implements Serializable {
    private static final long serialVersionUID = 4723952579491349524L;
    public double height;
    public double width;

    public Dimension(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Dimension)) {
            return false;
        }
        Dimension dimension = (Dimension) obj;
        return dimension.width == this.width && dimension.height == this.height;
    }

    @Override // com.itextpdf.awt.geom.Dimension2D
    public double getHeight() {
        return this.height;
    }

    public Dimension getSize() {
        return new Dimension(this.width, this.height);
    }

    @Override // com.itextpdf.awt.geom.Dimension2D
    public double getWidth() {
        return this.width;
    }

    public int hashCode() {
        HashCode hashCode = new HashCode();
        hashCode.append(this.width);
        hashCode.append(this.height);
        return hashCode.hashCode();
    }

    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public String toString() {
        return getClass().getName() + "[width=" + this.width + ",height=" + this.height + "]";
    }

    public Dimension() {
        this(0, 0);
    }

    public Dimension(double d, double d2) {
        setSize(d, d2);
    }

    public void setSize(Dimension dimension) {
        setSize(dimension.width, dimension.height);
    }

    @Override // com.itextpdf.awt.geom.Dimension2D
    public void setSize(double d, double d2) {
        setSize((int) Math.ceil(d), (int) Math.ceil(d2));
    }

    public Dimension(int i, int i2) {
        setSize(i, i2);
    }
}
