package com.itextpdf.text.pdf.parser.clipper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public class Path extends ArrayList<Point.LongPoint> {
    private static final long serialVersionUID = -7120161578077546673L;

    public static class Join {
        private Point.LongPoint offPt;
        OutPt outPt1;
        OutPt outPt2;

        public Point.LongPoint getOffPt() {
            return this.offPt;
        }

        public void setOffPt(Point.LongPoint longPoint) {
            this.offPt = longPoint;
        }
    }

    public static class Maxima {
        protected Maxima Next;
        protected Maxima Prev;
        protected long X;
    }

    public static class OutPt {
        int idx;
        OutPt next;
        OutPt prev;
        protected Point.LongPoint pt;

        public static OutRec getLowerMostRec(OutRec outRec, OutRec outRec2) {
            if (outRec.bottomPt == null) {
                outRec.bottomPt = outRec.pts.getBottomPt();
            }
            if (outRec2.bottomPt == null) {
                outRec2.bottomPt = outRec2.pts.getBottomPt();
            }
            OutPt outPt = outRec.bottomPt;
            OutPt outPt2 = outRec2.bottomPt;
            if (outPt.getPt().getY() > outPt2.getPt().getY()) {
                return outRec;
            }
            if (outPt.getPt().getY() < outPt2.getPt().getY()) {
                return outRec2;
            }
            if (outPt.getPt().getX() < outPt2.getPt().getX()) {
                return outRec;
            }
            if (outPt.getPt().getX() <= outPt2.getPt().getX() && outPt.next != outPt) {
                return (outPt2.next == outPt2 || isFirstBottomPt(outPt, outPt2)) ? outRec : outRec2;
            }
            return outRec2;
        }

        private static boolean isFirstBottomPt(OutPt outPt, OutPt outPt2) {
            OutPt outPt3 = outPt.prev;
            while (outPt3.getPt().equals(outPt.getPt()) && !outPt3.equals(outPt)) {
                outPt3 = outPt3.prev;
            }
            double dAbs = Math.abs(Point.LongPoint.getDeltaX(outPt.getPt(), outPt3.getPt()));
            OutPt outPt4 = outPt.next;
            while (outPt4.getPt().equals(outPt.getPt()) && !outPt4.equals(outPt)) {
                outPt4 = outPt4.next;
            }
            double dAbs2 = Math.abs(Point.LongPoint.getDeltaX(outPt.getPt(), outPt4.getPt()));
            OutPt outPt5 = outPt2.prev;
            while (outPt5.getPt().equals(outPt2.getPt()) && !outPt5.equals(outPt2)) {
                outPt5 = outPt5.prev;
            }
            double dAbs3 = Math.abs(Point.LongPoint.getDeltaX(outPt2.getPt(), outPt5.getPt()));
            OutPt outPt6 = outPt2.next;
            while (outPt6.getPt().equals(outPt2.getPt()) && outPt6.equals(outPt2)) {
                outPt6 = outPt6.next;
            }
            double dAbs4 = Math.abs(Point.LongPoint.getDeltaX(outPt2.getPt(), outPt6.getPt()));
            return (dAbs >= dAbs3 && dAbs >= dAbs4) || (dAbs2 >= dAbs3 && dAbs2 >= dAbs4);
        }

        public OutPt duplicate(boolean z) {
            OutPt outPt = new OutPt();
            outPt.setPt(new Point.LongPoint(getPt()));
            outPt.idx = this.idx;
            if (z) {
                outPt.next = this.next;
                outPt.prev = this;
                this.next.prev = outPt;
                this.next = outPt;
            } else {
                outPt.prev = this.prev;
                outPt.next = this;
                this.prev.next = outPt;
                this.prev = outPt;
            }
            return outPt;
        }

        /* JADX WARN: Code duplicated, block: B:6:0x001b  */
        public OutPt getBottomPt() {
            OutPt outPt = this.next;
            OutPt outPt2 = this;
            OutPt outPt3 = null;
            while (outPt != outPt2) {
                if (outPt.getPt().getY() > outPt2.getPt().getY()) {
                    outPt2 = outPt;
                    outPt3 = null;
                } else if (outPt.getPt().getY() == outPt2.getPt().getY() && outPt.getPt().getX() <= outPt2.getPt().getX()) {
                    if (outPt.getPt().getX() < outPt2.getPt().getX()) {
                        outPt2 = outPt;
                        outPt3 = null;
                    } else if (outPt.next != outPt2 && outPt.prev != outPt2) {
                        outPt3 = outPt;
                    }
                }
                outPt = outPt.next;
            }
            if (outPt3 != null) {
                while (outPt3 != outPt) {
                    if (!isFirstBottomPt(outPt, outPt3)) {
                        outPt2 = outPt3;
                    }
                    outPt3 = outPt3.next;
                    while (!outPt3.getPt().equals(outPt2.getPt())) {
                        outPt3 = outPt3.next;
                    }
                }
            }
            return outPt2;
        }

        public int getPointCount() {
            int i = 0;
            OutPt outPt = this;
            do {
                i++;
                outPt = outPt.next;
                if (outPt == this) {
                    break;
                }
            } while (outPt != null);
            return i;
        }

        public Point.LongPoint getPt() {
            return this.pt;
        }

        public void reversePolyPtLinks() {
            OutPt outPt = this;
            while (true) {
                OutPt outPt2 = outPt.next;
                outPt.next = outPt.prev;
                outPt.prev = outPt2;
                if (outPt2 == this) {
                    return;
                } else {
                    outPt = outPt2;
                }
            }
        }

        public void setPt(Point.LongPoint longPoint) {
            this.pt = longPoint;
        }
    }

    public static class OutRec {
        int Idx;
        OutPt bottomPt;
        OutRec firstLeft;
        boolean isHole;
        boolean isOpen;
        PolyNode polyNode;
        protected OutPt pts;

        public double area() {
            OutPt outPt = this.pts;
            double x = 0.0d;
            if (outPt == null) {
                return 0.0d;
            }
            do {
                x += (outPt.prev.getPt().getX() + outPt.getPt().getX()) * (outPt.prev.getPt().getY() - outPt.getPt().getY());
                outPt = outPt.next;
            } while (outPt != this.pts);
            return x * 0.5d;
        }

        public void fixHoleLinkage() {
            OutRec outRec = this.firstLeft;
            if (outRec != null) {
                if (this.isHole == outRec.isHole || outRec.pts == null) {
                    while (outRec != null && (outRec.isHole == this.isHole || outRec.pts == null)) {
                        outRec = outRec.firstLeft;
                    }
                    this.firstLeft = outRec;
                }
            }
        }

        public OutPt getPoints() {
            return this.pts;
        }

        public void setPoints(OutPt outPt) {
            this.pts = outPt;
        }
    }

    public Path() {
    }

    private static OutPt excludeOp(OutPt outPt) {
        OutPt outPt2 = outPt.prev;
        outPt2.next = outPt.next;
        outPt.next.prev = outPt2;
        outPt2.idx = 0;
        return outPt2;
    }

    public Path TranslatePath(Point.LongPoint longPoint) {
        Path path = new Path(size());
        for (int i = 0; i < size(); i++) {
            path.add(new Point.LongPoint(get(i).getX() + longPoint.getX(), get(i).getY() + longPoint.getY()));
        }
        return path;
    }

    public double area() {
        int size = size();
        if (size < 3) {
            return 0.0d;
        }
        double x = 0.0d;
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            x += (get(i).getX() + get(i2).getX()) * (get(i).getY() - get(i2).getY());
            i = i2;
        }
        return (-x) * 0.5d;
    }

    public Path cleanPolygon() {
        return cleanPolygon(1.415d);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00a3  */
    public int isPointInPolygon(Point.LongPoint longPoint) {
        int size = size();
        int i = 0;
        if (size < 3) {
            return 0;
        }
        Point.LongPoint longPoint2 = get(0);
        int i2 = 1;
        int i3 = 0;
        while (i2 <= size) {
            Point.LongPoint longPoint3 = i2 == size ? get(i) : get(i2);
            if (longPoint3.getY() == longPoint.getY()) {
                if (longPoint3.getX() != longPoint.getX()) {
                    if (longPoint2.getY() == longPoint.getY()) {
                        if ((longPoint3.getX() > longPoint.getX()) == (longPoint2.getX() < longPoint.getX())) {
                        }
                    }
                }
                return -1;
            }
            if ((longPoint2.getY() < longPoint.getY()) != (longPoint3.getY() < longPoint.getY())) {
                if (longPoint2.getX() >= longPoint.getX()) {
                    if (longPoint3.getX() > longPoint.getX()) {
                        i3 = 1 - i3;
                    } else {
                        double x = ((longPoint2.getX() - longPoint.getX()) * (longPoint3.getY() - longPoint.getY())) - ((longPoint3.getX() - longPoint.getX()) * (longPoint2.getY() - longPoint.getY()));
                        if (x == 0.0d) {
                            return -1;
                        }
                        if ((x > 0.0d) == (longPoint3.getY() > longPoint2.getY())) {
                            i3 = 1 - i3;
                        }
                    }
                } else if (longPoint3.getX() > longPoint.getX()) {
                    double x2 = ((longPoint2.getX() - longPoint.getX()) * (longPoint3.getY() - longPoint.getY())) - ((longPoint3.getX() - longPoint.getX()) * (longPoint2.getY() - longPoint.getY()));
                    if (x2 == 0.0d) {
                        return -1;
                    }
                    if ((x2 > 0.0d) == (longPoint3.getY() > longPoint2.getY())) {
                        i3 = 1 - i3;
                    }
                } else {
                    continue;
                }
            }
            i2++;
            longPoint2 = longPoint3;
            i = 0;
        }
        return i3;
    }

    public boolean orientation() {
        return area() >= 0.0d;
    }

    public void reverse() {
        Collections.reverse(this);
    }

    public Path(Point.LongPoint[] longPointArr) {
        this();
        for (Point.LongPoint longPoint : longPointArr) {
            add(longPoint);
        }
    }

    public Path cleanPolygon(double d) {
        int size = size();
        if (size == 0) {
            return new Path();
        }
        OutPt[] outPtArr = new OutPt[size];
        for (int i = 0; i < size; i++) {
            outPtArr[i] = new OutPt();
        }
        int i2 = 0;
        while (i2 < size) {
            outPtArr[i2].pt = get(i2);
            OutPt outPt = outPtArr[i2];
            i2++;
            OutPt outPt2 = outPtArr[i2 % size];
            outPt.next = outPt2;
            outPt2.prev = outPt;
            outPt.idx = 0;
        }
        double d2 = d * d;
        OutPt outPtExcludeOp = outPtArr[0];
        while (outPtExcludeOp.idx == 0) {
            OutPt outPt3 = outPtExcludeOp.next;
            OutPt outPt4 = outPtExcludeOp.prev;
            if (outPt3 == outPt4) {
                break;
            }
            if (Point.arePointsClose(outPtExcludeOp.pt, outPt4.pt, d2)) {
                outPtExcludeOp = excludeOp(outPtExcludeOp);
            } else if (Point.arePointsClose(outPtExcludeOp.prev.pt, outPtExcludeOp.next.pt, d2)) {
                excludeOp(outPtExcludeOp.next);
                outPtExcludeOp = excludeOp(outPtExcludeOp);
                size -= 2;
            } else if (Point.slopesNearCollinear(outPtExcludeOp.prev.pt, outPtExcludeOp.pt, outPtExcludeOp.next.pt, d2)) {
                outPtExcludeOp = excludeOp(outPtExcludeOp);
            } else {
                outPtExcludeOp.idx = 1;
                outPtExcludeOp = outPtExcludeOp.next;
            }
            size--;
        }
        if (size < 3) {
            size = 0;
        }
        Path path = new Path(size);
        for (int i3 = 0; i3 < size; i3++) {
            path.add(outPtExcludeOp.pt);
            outPtExcludeOp = outPtExcludeOp.next;
        }
        return path;
    }

    public Path(int i) {
        super(i);
    }

    public Path(Collection<? extends Point.LongPoint> collection) {
        super(collection);
    }
}
