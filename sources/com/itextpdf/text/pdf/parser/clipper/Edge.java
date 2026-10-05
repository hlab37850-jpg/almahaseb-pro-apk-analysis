package com.itextpdf.text.pdf.parser.clipper;

import java.math.BigInteger;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
class Edge {
    protected static final double HORIZONTAL = -3.4E38d;
    private static final Logger LOGGER = Logger.getLogger(Edge.class.getName());
    protected static final int SKIP = -2;
    protected static final int UNASSIGNED = -1;
    double deltaX;
    Edge next;
    Edge nextInAEL;
    Edge nextInLML;
    Edge nextInSEL;
    int outIdx;
    Clipper.PolyType polyTyp;
    Edge prev;
    Edge prevInAEL;
    Edge prevInSEL;
    Side side;
    int windCnt;
    int windCnt2;
    int windDelta;
    private final Point.LongPoint delta = new Point.LongPoint();
    private final Point.LongPoint top = new Point.LongPoint();
    private final Point.LongPoint bot = new Point.LongPoint();
    private final Point.LongPoint current = new Point.LongPoint();

    /* JADX INFO: renamed from: com.itextpdf.text.pdf.parser.clipper.Edge$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$ClipType;
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$PolyFillType;

        static {
            int[] iArr = new int[Clipper.ClipType.values().length];
            $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$ClipType = iArr;
            try {
                iArr[Clipper.ClipType.INTERSECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$ClipType[Clipper.ClipType.UNION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$ClipType[Clipper.ClipType.DIFFERENCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$ClipType[Clipper.ClipType.XOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Clipper.PolyFillType.values().length];
            $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$PolyFillType = iArr2;
            try {
                iArr2[Clipper.PolyFillType.EVEN_ODD.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$PolyFillType[Clipper.PolyFillType.NON_ZERO.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$PolyFillType[Clipper.PolyFillType.POSITIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public enum Side {
        LEFT,
        RIGHT
    }

    public static boolean doesE2InsertBeforeE1(Edge edge, Edge edge2) {
        if (edge2.current.getX() != edge.current.getX()) {
            return edge2.current.getX() < edge.current.getX();
        }
        if (edge2.top.getY() > edge.top.getY()) {
            return edge2.top.getX() < topX(edge, edge2.top.getY());
        }
        return edge.top.getX() > topX(edge2, edge.top.getY());
    }

    public static boolean slopesEqual(Edge edge, Edge edge2, boolean z) {
        if (z) {
            return BigInteger.valueOf(edge.getDelta().getY()).multiply(BigInteger.valueOf(edge2.getDelta().getX())).equals(BigInteger.valueOf(edge.getDelta().getX()).multiply(BigInteger.valueOf(edge2.getDelta().getY())));
        }
        return edge.getDelta().getY() * edge2.getDelta().getX() == edge.getDelta().getX() * edge2.getDelta().getY();
    }

    public static void swapPolyIndexes(Edge edge, Edge edge2) {
        int i = edge.outIdx;
        edge.outIdx = edge2.outIdx;
        edge2.outIdx = i;
    }

    public static void swapSides(Edge edge, Edge edge2) {
        Side side = edge.side;
        edge.side = edge2.side;
        edge2.side = side;
    }

    public static long topX(Edge edge, long j) {
        return j == edge.getTop().getY() ? edge.getTop().getX() : edge.getBot().getX() + Math.round(edge.deltaX * (j - edge.getBot().getY()));
    }

    public Edge findNextLocMin() {
        Edge edge = this;
        while (true) {
            if (!edge.bot.equals(edge.prev.bot) || edge.current.equals(edge.top)) {
                edge = edge.next;
            } else {
                if (edge.deltaX != HORIZONTAL && edge.prev.deltaX != HORIZONTAL) {
                    return edge;
                }
                while (true) {
                    Edge edge2 = edge.prev;
                    if (edge2.deltaX != HORIZONTAL) {
                        break;
                    }
                    edge = edge2;
                }
                Edge edge3 = edge;
                while (edge3.deltaX == HORIZONTAL) {
                    edge3 = edge3.next;
                }
                if (edge3.top.getY() != edge3.prev.bot.getY()) {
                    return edge.prev.bot.getX() < edge3.bot.getX() ? edge : edge3;
                }
                edge = edge3;
            }
        }
    }

    public Point.LongPoint getBot() {
        return this.bot;
    }

    public Point.LongPoint getCurrent() {
        return this.current;
    }

    public Point.LongPoint getDelta() {
        return this.delta;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0027  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code duplicated, block: B:9:0x0020  */
    public Edge getMaximaPair() {
        Edge edge;
        if (this.next.top.equals(this.top)) {
            edge = this.next;
            if (edge.nextInLML != null) {
                if (this.prev.top.equals(this.top)) {
                    edge = this.prev;
                    if (edge.nextInLML != null) {
                        edge = null;
                    }
                } else {
                    edge = null;
                }
            }
        } else if (this.prev.top.equals(this.top)) {
            edge = this.prev;
            if (edge.nextInLML != null) {
                edge = null;
            }
        } else {
            edge = null;
        }
        if (edge == null || (edge.outIdx != -2 && (edge.nextInAEL != edge.prevInAEL || edge.isHorizontal()))) {
            return edge;
        }
        return null;
    }

    public Edge getNextInAEL(Clipper.Direction direction) {
        return direction == Clipper.Direction.LEFT_TO_RIGHT ? this.nextInAEL : this.prevInAEL;
    }

    public Point.LongPoint getTop() {
        return this.top;
    }

    public boolean isContributing(Clipper.PolyFillType polyFillType, Clipper.PolyFillType polyFillType2, Clipper.ClipType clipType) {
        LOGGER.entering(Edge.class.getName(), "isContributing");
        Clipper.PolyType polyType = this.polyTyp;
        Clipper.PolyType polyType2 = Clipper.PolyType.SUBJECT;
        if (polyType == polyType2) {
            polyFillType2 = polyFillType;
            polyFillType = polyFillType2;
        }
        int[] iArr = AnonymousClass1.$SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$PolyFillType;
        int i = iArr[polyFillType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (this.windCnt != -1) {
                        return false;
                    }
                } else if (this.windCnt != 1) {
                    return false;
                }
            } else if (Math.abs(this.windCnt) != 1) {
                return false;
            }
        } else if (this.windDelta == 0 && this.windCnt != 1) {
            return false;
        }
        int i2 = AnonymousClass1.$SwitchMap$com$itextpdf$text$pdf$parser$clipper$Clipper$ClipType[clipType.ordinal()];
        if (i2 == 1) {
            int i3 = iArr[polyFillType2.ordinal()];
            if (i3 == 1 || i3 == 2) {
                return this.windCnt2 != 0;
            }
            if (i3 != 3) {
                return this.windCnt2 < 0;
            }
            return this.windCnt2 > 0;
        }
        if (i2 == 2) {
            int i4 = iArr[polyFillType2.ordinal()];
            if (i4 == 1 || i4 == 2) {
                return this.windCnt2 == 0;
            }
            if (i4 != 3) {
                return this.windCnt2 >= 0;
            }
            return this.windCnt2 <= 0;
        }
        if (i2 != 3) {
            if (i2 != 4 || this.windDelta != 0) {
                return true;
            }
            int i5 = iArr[polyFillType2.ordinal()];
            if (i5 == 1 || i5 == 2) {
                return this.windCnt2 == 0;
            }
            if (i5 != 3) {
                return this.windCnt2 >= 0;
            }
            return this.windCnt2 <= 0;
        }
        if (this.polyTyp == polyType2) {
            int i6 = iArr[polyFillType2.ordinal()];
            if (i6 == 1 || i6 == 2) {
                return this.windCnt2 == 0;
            }
            if (i6 != 3) {
                return this.windCnt2 >= 0;
            }
            return this.windCnt2 <= 0;
        }
        int i7 = iArr[polyFillType2.ordinal()];
        if (i7 == 1 || i7 == 2) {
            return this.windCnt2 != 0;
        }
        if (i7 != 3) {
            return this.windCnt2 < 0;
        }
        return this.windCnt2 > 0;
    }

    public boolean isEvenOddAltFillType(Clipper.PolyFillType polyFillType, Clipper.PolyFillType polyFillType2) {
        if (this.polyTyp == Clipper.PolyType.SUBJECT) {
            return polyFillType == Clipper.PolyFillType.EVEN_ODD;
        }
        return polyFillType2 == Clipper.PolyFillType.EVEN_ODD;
    }

    public boolean isEvenOddFillType(Clipper.PolyFillType polyFillType, Clipper.PolyFillType polyFillType2) {
        if (this.polyTyp == Clipper.PolyType.SUBJECT) {
            return polyFillType2 == Clipper.PolyFillType.EVEN_ODD;
        }
        return polyFillType == Clipper.PolyFillType.EVEN_ODD;
    }

    public boolean isHorizontal() {
        return this.delta.getY() == 0;
    }

    public boolean isIntermediate(double d) {
        return ((double) this.top.getY()) == d && this.nextInLML != null;
    }

    public boolean isMaxima(double d) {
        return ((double) this.top.getY()) == d && this.nextInLML == null;
    }

    public void reverseHorizontal() {
        long x = this.top.getX();
        this.top.setX(Long.valueOf(this.bot.getX()));
        this.bot.setX(Long.valueOf(x));
        long z = this.top.getZ();
        this.top.setZ(Long.valueOf(this.bot.getZ()));
        this.bot.setZ(Long.valueOf(z));
    }

    public void setBot(Point.LongPoint longPoint) {
        this.bot.set(longPoint);
    }

    public void setCurrent(Point.LongPoint longPoint) {
        this.current.set(longPoint);
    }

    public void setTop(Point.LongPoint longPoint) {
        this.top.set(longPoint);
    }

    public String toString() {
        return "TEdge [Bot=" + this.bot + ", Curr=" + this.current + ", Top=" + this.top + ", Delta=" + this.delta + ", Dx=" + this.deltaX + ", PolyTyp=" + this.polyTyp + ", Side=" + this.side + ", WindDelta=" + this.windDelta + ", WindCnt=" + this.windCnt + ", WindCnt2=" + this.windCnt2 + ", OutIdx=" + this.outIdx + ", Next=" + this.next + ", Prev=" + this.prev + ", NextInLML=" + this.nextInLML + ", NextInAEL=" + this.nextInAEL + ", PrevInAEL=" + this.prevInAEL + ", NextInSEL=" + this.nextInSEL + ", PrevInSEL=" + this.prevInSEL + "]";
    }

    public void updateDeltaX() {
        this.delta.setX(Long.valueOf(this.top.getX() - this.bot.getX()));
        this.delta.setY(Long.valueOf(this.top.getY() - this.bot.getY()));
        if (this.delta.getY() == 0) {
            this.deltaX = HORIZONTAL;
        } else {
            this.deltaX = this.delta.getX() / this.delta.getY();
        }
    }
}
