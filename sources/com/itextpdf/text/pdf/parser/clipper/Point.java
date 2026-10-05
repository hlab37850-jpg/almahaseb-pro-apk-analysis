package com.itextpdf.text.pdf.parser.clipper;

import java.lang.Comparable;
import java.lang.Number;
import java.math.BigInteger;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Point<T extends Number & Comparable<T>> {
    private static final NumberComparator NUMBER_COMPARATOR = new NumberComparator();
    protected T x;
    protected T y;
    protected T z;

    public static class DoublePoint extends Point<Double> {
        public DoublePoint() {
            this(0.0d, 0.0d);
        }

        public double getX() {
            return ((Double) this.x).doubleValue();
        }

        public double getY() {
            return ((Double) this.y).doubleValue();
        }

        public double getZ() {
            return ((Double) this.z).doubleValue();
        }

        public DoublePoint(double d, double d2) {
            this(d, d2, 0.0d);
        }

        public DoublePoint(double d, double d2, double d3) {
            super(Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3));
        }

        public DoublePoint(DoublePoint doublePoint) {
            super(doublePoint);
        }
    }

    public static class LongPoint extends Point<Long> {
        public LongPoint() {
            this(0L, 0L);
        }

        public static double getDeltaX(LongPoint longPoint, LongPoint longPoint2) {
            if (longPoint.getY() == longPoint2.getY()) {
                return -3.4E38d;
            }
            return (longPoint2.getX() - longPoint.getX()) / (longPoint2.getY() - longPoint.getY());
        }

        public long getX() {
            return ((Long) this.x).longValue();
        }

        public long getY() {
            return ((Long) this.y).longValue();
        }

        public long getZ() {
            return ((Long) this.z).longValue();
        }

        public LongPoint(long j, long j2) {
            this(j, j2, 0L);
        }

        public LongPoint(double d, double d2) {
            this((long) d, (long) d2);
        }

        public LongPoint(long j, long j2, long j3) {
            super(Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
        }

        public LongPoint(LongPoint longPoint) {
            super(longPoint);
        }
    }

    public static class NumberComparator<T extends Number & Comparable<T>> implements Comparator<T> {
        private NumberComparator() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            return ((Comparable) t).compareTo(t2);
        }
    }

    public Point(Point<T> point) {
        this(point.x, point.y, point.z);
    }

    public static boolean arePointsClose(Point<? extends Number> point, Point<? extends Number> point2, double d) {
        double dDoubleValue = point.x.doubleValue() - point2.x.doubleValue();
        double dDoubleValue2 = point.y.doubleValue() - point2.y.doubleValue();
        return (dDoubleValue * dDoubleValue) + (dDoubleValue2 * dDoubleValue2) <= d;
    }

    public static double distanceFromLineSqrd(Point<? extends Number> point, Point<? extends Number> point2, Point<? extends Number> point3) {
        double dDoubleValue = point2.y.doubleValue() - point3.y.doubleValue();
        double dDoubleValue2 = point3.x.doubleValue() - point2.x.doubleValue();
        double dDoubleValue3 = ((point.x.doubleValue() * dDoubleValue) + (point.y.doubleValue() * dDoubleValue2)) - ((point2.x.doubleValue() * dDoubleValue) + (point2.y.doubleValue() * dDoubleValue2));
        return (dDoubleValue3 * dDoubleValue3) / ((dDoubleValue * dDoubleValue) + (dDoubleValue2 * dDoubleValue2));
    }

    public static DoublePoint getUnitNormal(LongPoint longPoint, LongPoint longPoint2) {
        double dLongValue = ((Long) longPoint2.x).longValue() - ((Long) longPoint.x).longValue();
        double dLongValue2 = ((Long) longPoint2.y).longValue() - ((Long) longPoint.y).longValue();
        if (dLongValue == 0.0d && dLongValue2 == 0.0d) {
            return new DoublePoint();
        }
        double dSqrt = 1.0d / Math.sqrt((dLongValue * dLongValue) + (dLongValue2 * dLongValue2));
        return new DoublePoint(dLongValue2 * dSqrt, -(dLongValue * dSqrt));
    }

    public static boolean isPt2BetweenPt1AndPt3(LongPoint longPoint, LongPoint longPoint2, LongPoint longPoint3) {
        if (longPoint.equals(longPoint3) || longPoint.equals(longPoint2) || longPoint3.equals(longPoint2)) {
            return false;
        }
        if (longPoint.x != longPoint3.x) {
            return ((((Long) longPoint2.x).longValue() > ((Long) longPoint.x).longValue() ? 1 : (((Long) longPoint2.x).longValue() == ((Long) longPoint.x).longValue() ? 0 : -1)) > 0) == ((((Long) longPoint2.x).longValue() > ((Long) longPoint3.x).longValue() ? 1 : (((Long) longPoint2.x).longValue() == ((Long) longPoint3.x).longValue() ? 0 : -1)) < 0);
        }
        return ((((Long) longPoint2.y).longValue() > ((Long) longPoint.y).longValue() ? 1 : (((Long) longPoint2.y).longValue() == ((Long) longPoint.y).longValue() ? 0 : -1)) > 0) == ((((Long) longPoint2.y).longValue() > ((Long) longPoint3.y).longValue() ? 1 : (((Long) longPoint2.y).longValue() == ((Long) longPoint3.y).longValue() ? 0 : -1)) < 0);
    }

    public static boolean slopesEqual(LongPoint longPoint, LongPoint longPoint2, LongPoint longPoint3, boolean z) {
        if (z) {
            return BigInteger.valueOf(longPoint.getY() - longPoint2.getY()).multiply(BigInteger.valueOf(longPoint2.getX() - longPoint3.getX())).equals(BigInteger.valueOf(longPoint.getX() - longPoint2.getX()).multiply(BigInteger.valueOf(longPoint2.getY() - longPoint3.getY())));
        }
        return ((longPoint.getY() - longPoint2.getY()) * (longPoint2.getX() - longPoint3.getX())) - ((longPoint.getX() - longPoint2.getX()) * (longPoint2.getY() - longPoint3.getY())) == 0;
    }

    public static boolean slopesNearCollinear(LongPoint longPoint, LongPoint longPoint2, LongPoint longPoint3, double d) {
        if (Math.abs(((Long) longPoint.x).longValue() - ((Long) longPoint2.x).longValue()) > Math.abs(((Long) longPoint.y).longValue() - ((Long) longPoint2.y).longValue())) {
            if ((((Long) longPoint.x).longValue() > ((Long) longPoint2.x).longValue()) == (((Long) longPoint.x).longValue() < ((Long) longPoint3.x).longValue())) {
                return distanceFromLineSqrd(longPoint, longPoint2, longPoint3) < d;
            }
            if ((((Long) longPoint2.x).longValue() > ((Long) longPoint.x).longValue()) == (((Long) longPoint2.x).longValue() < ((Long) longPoint3.x).longValue())) {
                return distanceFromLineSqrd(longPoint2, longPoint, longPoint3) < d;
            }
            return distanceFromLineSqrd(longPoint3, longPoint, longPoint2) < d;
        }
        if ((((Long) longPoint.y).longValue() > ((Long) longPoint2.y).longValue()) == (((Long) longPoint.y).longValue() < ((Long) longPoint3.y).longValue())) {
            return distanceFromLineSqrd(longPoint, longPoint2, longPoint3) < d;
        }
        if ((((Long) longPoint2.y).longValue() > ((Long) longPoint.y).longValue()) == (((Long) longPoint2.y).longValue() < ((Long) longPoint3.y).longValue())) {
            return distanceFromLineSqrd(longPoint2, longPoint, longPoint3) < d;
        }
        return distanceFromLineSqrd(longPoint3, longPoint, longPoint2) < d;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        NumberComparator numberComparator = NUMBER_COMPARATOR;
        return numberComparator.compare((Number) this.x, (Number) point.x) == 0 && numberComparator.compare((Number) this.y, (Number) point.y) == 0;
    }

    public void set(Point<T> point) {
        this.x = point.x;
        this.y = point.y;
        this.z = point.z;
    }

    public void setX(T t) {
        this.x = t;
    }

    public void setY(T t) {
        this.y = t;
    }

    public void setZ(T t) {
        this.z = t;
    }

    public String toString() {
        return "Point [x=" + this.x + ", y=" + this.y + ", z=" + this.z + "]";
    }

    public Point(T t, T t2, T t3) {
        this.x = t;
        this.y = t2;
        this.z = t3;
    }

    public static boolean slopesEqual(LongPoint longPoint, LongPoint longPoint2, LongPoint longPoint3, LongPoint longPoint4, boolean z) {
        if (z) {
            return BigInteger.valueOf(longPoint.getY() - longPoint2.getY()).multiply(BigInteger.valueOf(longPoint3.getX() - longPoint4.getX())).equals(BigInteger.valueOf(longPoint.getX() - longPoint2.getX()).multiply(BigInteger.valueOf(longPoint3.getY() - longPoint4.getY())));
        }
        return ((longPoint.getY() - longPoint2.getY()) * (longPoint3.getX() - longPoint4.getX())) - ((longPoint.getX() - longPoint2.getX()) * (longPoint3.getY() - longPoint4.getY())) == 0;
    }
}
