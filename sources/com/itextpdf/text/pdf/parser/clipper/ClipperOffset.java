package com.itextpdf.text.pdf.parser.clipper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ClipperOffset {
    private static final double DEFAULT_ARC_TOLERANCE = 0.25d;
    private static final double TOLERANCE = 1.0E-20d;
    private static final double TWO_PI = 6.283185307179586d;
    private final double arcTolerance;
    private double cos;
    private double delta;
    private Path destPoly;
    private Paths destPolys;
    private double inA;
    private Point.LongPoint lowest;
    private double miterLim;
    private final double miterLimit;
    private final List<Point.DoublePoint> normals;
    private final PolyNode polyNodes;
    private double sin;
    private Path srcPoly;
    private double stepsPerRad;

    /* JADX INFO: renamed from: com.itextpdf.text.pdf.parser.clipper.ClipperOffset$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$JoinType;

        static {
            int[] iArr = new int[Clipper.JoinType.values().length];
            $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$JoinType = iArr;
            try {
                iArr[Clipper.JoinType.MITER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$JoinType[Clipper.JoinType.BEVEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$JoinType[Clipper.JoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ClipperOffset() {
        this(2.0d, DEFAULT_ARC_TOLERANCE);
    }

    private void doMiter(int i, int i2, double d) {
        double d2 = this.delta / d;
        this.destPoly.add(new Point.LongPoint(Math.round(this.srcPoly.get(i).getX() + ((this.normals.get(i2).getX() + this.normals.get(i).getX()) * d2)), Math.round(this.srcPoly.get(i).getY() + ((this.normals.get(i2).getY() + this.normals.get(i).getY()) * d2))));
    }

    private void doOffset(double d) {
        int i;
        int i2;
        double d2;
        double d3;
        int i3;
        this.destPolys = new Paths();
        this.delta = d;
        int i4 = 0;
        if (nearZero(d)) {
            while (i4 < this.polyNodes.getChildCount()) {
                PolyNode polyNode = this.polyNodes.getChilds().get(i4);
                if (polyNode.getEndType() == Clipper.EndType.CLOSED_POLYGON) {
                    this.destPolys.add(polyNode.getPolygon());
                }
                i4++;
            }
            return;
        }
        double d4 = this.miterLimit;
        if (d4 > 2.0d) {
            this.miterLim = 2.0d / (d4 * d4);
        } else {
            this.miterLim = 0.5d;
        }
        double d5 = this.arcTolerance;
        double dAbs = DEFAULT_ARC_TOLERANCE;
        double d6 = 0.0d;
        if (d5 > 0.0d) {
            dAbs = d5 > Math.abs(d) * DEFAULT_ARC_TOLERANCE ? DEFAULT_ARC_TOLERANCE * Math.abs(d) : this.arcTolerance;
        }
        double dAcos = 3.141592653589793d / Math.acos(1.0d - (dAbs / Math.abs(d)));
        double d7 = TWO_PI / dAcos;
        this.sin = Math.sin(d7);
        this.cos = Math.cos(d7);
        this.stepsPerRad = dAcos / TWO_PI;
        int i5 = (d > 0.0d ? 1 : (d == 0.0d ? 0 : -1));
        if (i5 < 0) {
            this.sin = -this.sin;
        }
        int i6 = 0;
        while (i6 < this.polyNodes.getChildCount()) {
            PolyNode polyNode2 = this.polyNodes.getChilds().get(i6);
            Path polygon = polyNode2.getPolygon();
            this.srcPoly = polygon;
            int size = polygon.size();
            if (size == 0 || (i5 <= 0 && (size < 3 || polyNode2.getEndType() != Clipper.EndType.CLOSED_POLYGON))) {
                i = i5;
                i2 = i6;
                d2 = d6;
                d3 = dAcos;
            } else {
                this.destPoly = new Path();
                int i7 = 1;
                if (size == 1) {
                    if (polyNode2.getJoinType() == Clipper.JoinType.ROUND) {
                        double d8 = d6;
                        double d9 = 1.0d;
                        while (i7 <= dAcos) {
                            int i8 = i5;
                            double d10 = dAcos;
                            this.destPoly.add(new Point.LongPoint(Math.round(this.srcPoly.get(i4).getX() + (d9 * d)), Math.round(this.srcPoly.get(0).getY() + (d8 * d))));
                            double d11 = this.cos;
                            double d12 = this.sin;
                            double d13 = (d9 * d11) - (d12 * d8);
                            d8 = (d8 * d11) + (d9 * d12);
                            i7++;
                            d9 = d13;
                            i6 = i6;
                            i5 = i8;
                            dAcos = d10;
                            i4 = 0;
                        }
                        i = i5;
                        i2 = i6;
                        d3 = dAcos;
                    } else {
                        i = i5;
                        i2 = i6;
                        d3 = dAcos;
                        double d14 = -1.0d;
                        double d15 = -1.0d;
                        for (int i9 = 0; i9 < 4; i9++) {
                            this.destPoly.add(new Point.LongPoint(Math.round(this.srcPoly.get(0).getX() + (d14 * d)), Math.round(this.srcPoly.get(0).getY() + (d15 * d))));
                            if (d14 < 0.0d) {
                                d14 = 1.0d;
                            } else if (d15 < 0.0d) {
                                d15 = 1.0d;
                            } else {
                                d14 = -1.0d;
                            }
                        }
                    }
                    this.destPolys.add(this.destPoly);
                } else {
                    i = i5;
                    i2 = i6;
                    d3 = dAcos;
                    this.normals.clear();
                    int i10 = 0;
                    while (true) {
                        i3 = size - 1;
                        if (i10 >= i3) {
                            break;
                        }
                        List<Point.DoublePoint> list = this.normals;
                        Point.LongPoint longPoint = this.srcPoly.get(i10);
                        i10++;
                        list.add(Point.getUnitNormal(longPoint, this.srcPoly.get(i10)));
                    }
                    Clipper.EndType endType = polyNode2.getEndType();
                    Clipper.EndType endType2 = Clipper.EndType.CLOSED_LINE;
                    if (endType == endType2 || polyNode2.getEndType() == Clipper.EndType.CLOSED_POLYGON) {
                        this.normals.add(Point.getUnitNormal(this.srcPoly.get(i3), this.srcPoly.get(0)));
                    } else {
                        this.normals.add(new Point.DoublePoint(this.normals.get(size - 2)));
                    }
                    if (polyNode2.getEndType() == Clipper.EndType.CLOSED_POLYGON) {
                        int[] iArr = {i3};
                        for (int i11 = 0; i11 < size; i11++) {
                            offsetPoint(i11, iArr, polyNode2.getJoinType());
                        }
                        this.destPolys.add(this.destPoly);
                    } else {
                        if (polyNode2.getEndType() == endType2) {
                            int[] iArr2 = {i3};
                            for (int i12 = 0; i12 < size; i12++) {
                                offsetPoint(i12, iArr2, polyNode2.getJoinType());
                            }
                            this.destPolys.add(this.destPoly);
                            this.destPoly = new Path();
                            Point.DoublePoint doublePoint = this.normals.get(i3);
                            for (int i13 = i3; i13 > 0; i13--) {
                                int i14 = i13 - 1;
                                this.normals.set(i13, new Point.DoublePoint(-this.normals.get(i14).getX(), -this.normals.get(i14).getY()));
                            }
                            this.normals.set(0, new Point.DoublePoint(-doublePoint.getX(), -doublePoint.getY(), 0.0d));
                            iArr2[0] = 0;
                            while (i3 >= 0) {
                                offsetPoint(i3, iArr2, polyNode2.getJoinType());
                                i3--;
                            }
                            this.destPolys.add(this.destPoly);
                        } else {
                            int[] iArr3 = new int[1];
                            for (int i15 = 1; i15 < i3; i15++) {
                                offsetPoint(i15, iArr3, polyNode2.getJoinType());
                            }
                            if (polyNode2.getEndType() == Clipper.EndType.OPEN_BUTT) {
                                this.destPoly.add(new Point.LongPoint(Math.round(this.srcPoly.get(i3).getX() + (this.normals.get(i3).getX() * d)), Math.round(this.srcPoly.get(i3).getY() + (this.normals.get(i3).getY() * d)), 0L));
                                this.destPoly.add(new Point.LongPoint(Math.round(this.srcPoly.get(i3).getX() - (this.normals.get(i3).getX() * d)), Math.round(this.srcPoly.get(i3).getY() - (this.normals.get(i3).getY() * d)), 0L));
                            } else {
                                iArr3[0] = size - 2;
                                this.inA = 0.0d;
                                this.normals.set(i3, new Point.DoublePoint(-this.normals.get(i3).getX(), -this.normals.get(i3).getY()));
                                if (polyNode2.getEndType() == Clipper.EndType.OPEN_SQUARE) {
                                    doSquare(i3, iArr3[0], true);
                                } else {
                                    doRound(i3, iArr3[0]);
                                }
                            }
                            for (int i16 = i3; i16 > 0; i16--) {
                                int i17 = i16 - 1;
                                this.normals.set(i16, new Point.DoublePoint(-this.normals.get(i17).getX(), -this.normals.get(i17).getY()));
                            }
                            this.normals.set(0, new Point.DoublePoint(-this.normals.get(1).getX(), -this.normals.get(1).getY()));
                            iArr3[0] = i3;
                            for (int i18 = size - 2; i18 > 0; i18--) {
                                offsetPoint(i18, iArr3, polyNode2.getJoinType());
                            }
                            if (polyNode2.getEndType() == Clipper.EndType.OPEN_BUTT) {
                                this.destPoly.add(new Point.LongPoint(Math.round(this.srcPoly.get(0).getX() - (this.normals.get(0).getX() * d)), Math.round(this.srcPoly.get(0).getY() - (this.normals.get(0).getY() * d))));
                                this.destPoly.add(new Point.LongPoint(Math.round(this.srcPoly.get(0).getX() + (this.normals.get(0).getX() * d)), Math.round(this.srcPoly.get(0).getY() + (this.normals.get(0).getY() * d))));
                                d2 = 0.0d;
                            } else {
                                iArr3[0] = 1;
                                d2 = 0.0d;
                                this.inA = 0.0d;
                                if (polyNode2.getEndType() == Clipper.EndType.OPEN_SQUARE) {
                                    doSquare(0, 1, true);
                                } else {
                                    doRound(0, 1);
                                }
                            }
                            this.destPolys.add(this.destPoly);
                        }
                        d6 = d2;
                        i6 = i2 + 1;
                        i5 = i;
                        dAcos = d3;
                        i4 = 0;
                    }
                }
                d2 = 0.0d;
            }
            d6 = d2;
            i6 = i2 + 1;
            i5 = i;
            dAcos = d3;
            i4 = 0;
        }
    }

    private void doRound(int i, int i2) {
        int iMax = Math.max((int) Math.round(this.stepsPerRad * Math.abs(Math.atan2(this.inA, (this.normals.get(i2).getX() * this.normals.get(i).getX()) + (this.normals.get(i2).getY() * this.normals.get(i).getY())))), 1);
        double x = this.normals.get(i2).getX();
        double y = this.normals.get(i2).getY();
        int i3 = 0;
        while (i3 < iMax) {
            this.destPoly.add(new Point.LongPoint(Math.round(this.srcPoly.get(i).getX() + (this.delta * x)), Math.round(this.srcPoly.get(i).getY() + (this.delta * y))));
            double d = this.cos;
            double d2 = this.sin;
            double d3 = (x * d) - (d2 * y);
            y = (y * d) + (x * d2);
            i3++;
            x = d3;
        }
        this.destPoly.add(new Point.LongPoint(Math.round(this.srcPoly.get(i).getX() + (this.normals.get(i).getX() * this.delta)), Math.round(this.srcPoly.get(i).getY() + (this.normals.get(i).getY() * this.delta))));
    }

    private void doSquare(int i, int i2, boolean z) {
        double x = this.normals.get(i2).getX();
        double y = this.normals.get(i2).getY();
        double x2 = this.normals.get(i).getX();
        double y2 = this.normals.get(i).getY();
        double x3 = this.srcPoly.get(i).getX();
        double y3 = this.srcPoly.get(i).getY();
        double dTan = Math.tan(Math.atan2(this.inA, (x * x2) + (y * y2)) / 4.0d);
        this.destPoly.add(new Point.LongPoint(Math.round((this.delta * (x - (z ? y * dTan : 0.0d))) + x3), Math.round((this.delta * (y + (z ? x * dTan : 0.0d))) + y3), 0L));
        this.destPoly.add(new Point.LongPoint(Math.round(x3 + (this.delta * (x2 + (z ? y2 * dTan : 0.0d)))), Math.round(y3 + (this.delta * (y2 - (z ? x2 * dTan : 0.0d)))), 0L));
    }

    private void fixOrientations() {
        int i = 0;
        if (this.lowest.getX() < 0 || this.polyNodes.childs.get((int) this.lowest.getX()).getPolygon().orientation()) {
            while (i < this.polyNodes.getChildCount()) {
                PolyNode polyNode = this.polyNodes.childs.get(i);
                if (polyNode.getEndType() == Clipper.EndType.CLOSED_LINE && !polyNode.getPolygon().orientation()) {
                    Collections.reverse(polyNode.getPolygon());
                }
                i++;
            }
            return;
        }
        while (i < this.polyNodes.getChildCount()) {
            PolyNode polyNode2 = this.polyNodes.childs.get(i);
            if (polyNode2.getEndType() == Clipper.EndType.CLOSED_POLYGON || (polyNode2.getEndType() == Clipper.EndType.CLOSED_LINE && polyNode2.getPolygon().orientation())) {
                Collections.reverse(polyNode2.getPolygon());
            }
            i++;
        }
    }

    private static boolean nearZero(double d) {
        return d > -1.0E-20d && d < TOLERANCE;
    }

    private void offsetPoint(int i, int[] iArr, Clipper.JoinType joinType) {
        long j;
        double d;
        char c;
        int i2 = iArr[0];
        double x = this.normals.get(i2).getX();
        double y = this.normals.get(i2).getY();
        double y2 = this.normals.get(i).getY();
        double x2 = this.normals.get(i).getX();
        long x3 = this.srcPoly.get(i).getX();
        long y3 = this.srcPoly.get(i).getY();
        double d2 = (x * y2) - (x2 * y);
        this.inA = d2;
        if (Math.abs(d2 * this.delta) >= 1.0d) {
            j = y3;
            d = y2;
            double d3 = this.inA;
            if (d3 > 1.0d) {
                this.inA = 1.0d;
            } else if (d3 < -1.0d) {
                this.inA = -1.0d;
            }
        } else if ((x * x2) + (y2 * y) > 0.0d) {
            this.destPoly.add(new Point.LongPoint(Math.round(x3 + (x * this.delta)), Math.round(y3 + (y * this.delta)), 0L));
            return;
        } else {
            j = y3;
            d = y2;
        }
        if (this.inA * this.delta >= 0.0d) {
            int i3 = AnonymousClass1.$SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$JoinType[joinType.ordinal()];
            if (i3 == 1) {
                c = 0;
                double d4 = (x2 * x) + 1.0d + (d * y);
                if (d4 >= this.miterLim) {
                    doMiter(i, i2, d4);
                } else {
                    doSquare(i, i2, false);
                }
            } else if (i3 == 2) {
                c = 0;
                doSquare(i, i2, false);
            } else if (i3 == 3) {
                doRound(i, i2);
            }
            iArr[c] = i;
        }
        double d5 = x3;
        double d6 = j;
        this.destPoly.add(new Point.LongPoint(Math.round((x * this.delta) + d5), Math.round((y * this.delta) + d6)));
        this.destPoly.add(this.srcPoly.get(i));
        this.destPoly.add(new Point.LongPoint(Math.round(d5 + (x2 * this.delta)), Math.round(d6 + (this.delta * d))));
        c = 0;
        iArr[c] = i;
    }

    public void addPath(Path path, Clipper.JoinType joinType, Clipper.EndType endType) {
        int size = path.size() - 1;
        if (size < 0) {
            return;
        }
        PolyNode polyNode = new PolyNode();
        polyNode.setJoinType(joinType);
        polyNode.setEndType(endType);
        int i = 0;
        if (endType == Clipper.EndType.CLOSED_LINE || endType == Clipper.EndType.CLOSED_POLYGON) {
            while (size > 0 && path.get(0) == path.get(size)) {
                size--;
            }
        }
        polyNode.getPolygon().add(path.get(0));
        int i2 = 0;
        for (int i3 = 1; i3 <= size; i3++) {
            if (polyNode.getPolygon().get(i) != path.get(i3)) {
                i++;
                polyNode.getPolygon().add(path.get(i3));
                if (path.get(i3).getY() > polyNode.getPolygon().get(i2).getY() || (path.get(i3).getY() == polyNode.getPolygon().get(i2).getY() && path.get(i3).getX() < polyNode.getPolygon().get(i2).getX())) {
                    i2 = i;
                }
            }
        }
        Clipper.EndType endType2 = Clipper.EndType.CLOSED_POLYGON;
        if (endType != endType2 || i >= 2) {
            this.polyNodes.addChild(polyNode);
            if (endType != endType2) {
                return;
            }
            if (this.lowest.getX() < 0) {
                this.lowest = new Point.LongPoint(this.polyNodes.getChildCount() - 1, i2);
                return;
            }
            Point.LongPoint longPoint = this.polyNodes.getChilds().get((int) this.lowest.getX()).getPolygon().get((int) this.lowest.getY());
            if (polyNode.getPolygon().get(i2).getY() > longPoint.getY() || (polyNode.getPolygon().get(i2).getY() == longPoint.getY() && polyNode.getPolygon().get(i2).getX() < longPoint.getX())) {
                this.lowest = new Point.LongPoint(this.polyNodes.getChildCount() - 1, i2);
            }
        }
    }

    public void addPaths(Paths paths, Clipper.JoinType joinType, Clipper.EndType endType) {
        Iterator<Path> it = paths.iterator();
        while (it.hasNext()) {
            addPath(it.next(), joinType, endType);
        }
    }

    public void clear() {
        this.polyNodes.getChilds().clear();
        this.lowest.setX(-1L);
    }

    public void execute(Paths paths, double d) {
        paths.clear();
        fixOrientations();
        doOffset(d);
        DefaultClipper defaultClipper = new DefaultClipper(1);
        Paths paths2 = this.destPolys;
        Clipper.PolyType polyType = Clipper.PolyType.SUBJECT;
        defaultClipper.addPaths(paths2, polyType, true);
        if (d > 0.0d) {
            Clipper.ClipType clipType = Clipper.ClipType.UNION;
            Clipper.PolyFillType polyFillType = Clipper.PolyFillType.POSITIVE;
            defaultClipper.execute(clipType, paths, polyFillType, polyFillType);
            return;
        }
        LongRect bounds = this.destPolys.getBounds();
        Path path = new Path(4);
        path.add(new Point.LongPoint(bounds.left - 10, bounds.bottom + 10, 0L));
        path.add(new Point.LongPoint(bounds.right + 10, bounds.bottom + 10, 0L));
        path.add(new Point.LongPoint(bounds.right + 10, bounds.top - 10, 0L));
        path.add(new Point.LongPoint(bounds.left - 10, bounds.top - 10, 0L));
        defaultClipper.addPath(path, polyType, true);
        Clipper.ClipType clipType2 = Clipper.ClipType.UNION;
        Clipper.PolyFillType polyFillType2 = Clipper.PolyFillType.NEGATIVE;
        defaultClipper.execute(clipType2, paths, polyFillType2, polyFillType2);
        if (paths.size() > 0) {
            paths.remove(0);
        }
    }

    public ClipperOffset(double d) {
        this(d, DEFAULT_ARC_TOLERANCE);
    }

    public ClipperOffset(double d, double d2) {
        this.miterLimit = d;
        this.arcTolerance = d2;
        Point.LongPoint longPoint = new Point.LongPoint();
        this.lowest = longPoint;
        longPoint.setX(-1L);
        this.polyNodes = new PolyNode();
        this.normals = new ArrayList();
    }

    public void execute(PolyTree polyTree, double d) {
        polyTree.Clear();
        fixOrientations();
        doOffset(d);
        DefaultClipper defaultClipper = new DefaultClipper(1);
        Paths paths = this.destPolys;
        Clipper.PolyType polyType = Clipper.PolyType.SUBJECT;
        defaultClipper.addPaths(paths, polyType, true);
        if (d > 0.0d) {
            Clipper.ClipType clipType = Clipper.ClipType.UNION;
            Clipper.PolyFillType polyFillType = Clipper.PolyFillType.POSITIVE;
            defaultClipper.execute(clipType, polyTree, polyFillType, polyFillType);
            return;
        }
        LongRect bounds = this.destPolys.getBounds();
        Path path = new Path(4);
        path.add(new Point.LongPoint(bounds.left - 10, bounds.bottom + 10, 0L));
        path.add(new Point.LongPoint(bounds.right + 10, bounds.bottom + 10, 0L));
        path.add(new Point.LongPoint(bounds.right + 10, bounds.top - 10, 0L));
        path.add(new Point.LongPoint(bounds.left - 10, bounds.top - 10, 0L));
        defaultClipper.addPath(path, polyType, true);
        Clipper.ClipType clipType2 = Clipper.ClipType.UNION;
        Clipper.PolyFillType polyFillType2 = Clipper.PolyFillType.NEGATIVE;
        defaultClipper.execute(clipType2, polyTree, polyFillType2, polyFillType2);
        if (polyTree.getChildCount() == 1 && polyTree.getChilds().get(0).getChildCount() > 0) {
            PolyNode polyNode = polyTree.getChilds().get(0);
            polyTree.getChilds().set(0, polyNode.getChilds().get(0));
            polyTree.getChilds().get(0).setParent(polyTree);
            for (int i = 1; i < polyNode.getChildCount(); i++) {
                polyTree.addChild(polyNode.getChilds().get(i));
            }
            return;
        }
        polyTree.Clear();
    }
}
