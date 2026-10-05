package com.itextpdf.text.pdf.parser.clipper;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class Paths extends ArrayList<Path> {
    private static final long serialVersionUID = 1910552127810480852L;

    /* JADX INFO: renamed from: com.itextpdf.text.pdf.parser.clipper.Paths$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$pdf$parser$clipper$PolyNode$NodeType;

        static {
            int[] iArr = new int[PolyNode.NodeType.values().length];
            $SwitchMap$com$itextpdf$text$pdf$parser$clipper$PolyNode$NodeType = iArr;
            try {
                iArr[PolyNode.NodeType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$parser$clipper$PolyNode$NodeType[PolyNode.NodeType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public Paths() {
    }

    public static Paths closedPathsFromPolyTree(PolyTree polyTree) {
        Paths paths = new Paths();
        paths.addPolyNode(polyTree, PolyNode.NodeType.CLOSED);
        return paths;
    }

    public static Paths makePolyTreeToPaths(PolyTree polyTree) {
        Paths paths = new Paths();
        paths.addPolyNode(polyTree, PolyNode.NodeType.ANY);
        return paths;
    }

    public static Paths openPathsFromPolyTree(PolyTree polyTree) {
        Paths paths = new Paths();
        for (PolyNode polyNode : polyTree.getChilds()) {
            if (polyNode.isOpen()) {
                paths.add(polyNode.getPolygon());
            }
        }
        return paths;
    }

    public void addPolyNode(PolyNode polyNode, PolyNode.NodeType nodeType) {
        int i = AnonymousClass1.$SwitchMap$com$itextpdf$text$pdf$parser$clipper$PolyNode$NodeType[nodeType.ordinal()];
        if (i != 1) {
            boolean zIsOpen = i == 2 ? true ^ polyNode.isOpen() : true;
            if (polyNode.getPolygon().size() > 0 && zIsOpen) {
                add(polyNode.getPolygon());
            }
            Iterator<PolyNode> it = polyNode.getChilds().iterator();
            while (it.hasNext()) {
                addPolyNode(it.next(), nodeType);
            }
        }
    }

    public Paths cleanPolygons() {
        return cleanPolygons(1.415d);
    }

    public LongRect getBounds() {
        int size = size();
        LongRect longRect = new LongRect();
        int i = 0;
        while (i < size && get(i).isEmpty()) {
            i++;
        }
        if (i == size) {
            return longRect;
        }
        long x = get(i).get(0).getX();
        longRect.left = x;
        longRect.right = x;
        long y = get(i).get(0).getY();
        longRect.top = y;
        longRect.bottom = y;
        while (i < size) {
            for (int i2 = 0; i2 < get(i).size(); i2++) {
                if (get(i).get(i2).getX() < longRect.left) {
                    longRect.left = get(i).get(i2).getX();
                } else if (get(i).get(i2).getX() > longRect.right) {
                    longRect.right = get(i).get(i2).getX();
                }
                if (get(i).get(i2).getY() < longRect.top) {
                    longRect.top = get(i).get(i2).getY();
                } else if (get(i).get(i2).getY() > longRect.bottom) {
                    longRect.bottom = get(i).get(i2).getY();
                }
            }
            i++;
        }
        return longRect;
    }

    public void reversePaths() {
        Iterator<Path> it = iterator();
        while (it.hasNext()) {
            it.next().reverse();
        }
    }

    public Paths(int i) {
        super(i);
    }

    public Paths cleanPolygons(double d) {
        Paths paths = new Paths(size());
        for (int i = 0; i < size(); i++) {
            paths.add(get(i).cleanPolygon(d));
        }
        return paths;
    }
}
