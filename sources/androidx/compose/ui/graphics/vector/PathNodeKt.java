package androidx.compose.ui.graphics.vector;

import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PathNodeKt {
    private static final char ArcToKey = 'A';
    private static final char CloseKey = 'Z';
    private static final char CurveToKey = 'C';
    private static final char HorizontalToKey = 'H';
    private static final char LineToKey = 'L';
    private static final char MoveToKey = 'M';
    private static final int NUM_ARC_TO_ARGS = 7;
    private static final int NUM_CURVE_TO_ARGS = 6;
    private static final int NUM_HORIZONTAL_TO_ARGS = 1;
    private static final int NUM_LINE_TO_ARGS = 2;
    private static final int NUM_MOVE_TO_ARGS = 2;
    private static final int NUM_QUAD_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_CURVE_TO_ARGS = 4;
    private static final int NUM_REFLECTIVE_QUAD_TO_ARGS = 2;
    private static final int NUM_VERTICAL_TO_ARGS = 1;
    private static final char QuadToKey = 'Q';
    private static final char ReflectiveCurveToKey = 'S';
    private static final char ReflectiveQuadToKey = 'T';
    private static final char RelativeArcToKey = 'a';
    private static final char RelativeCloseKey = 'z';
    private static final char RelativeCurveToKey = 'c';
    private static final char RelativeHorizontalToKey = 'h';
    private static final char RelativeLineToKey = 'l';
    private static final char RelativeMoveToKey = 'm';
    private static final char RelativeQuadToKey = 'q';
    private static final char RelativeReflectiveCurveToKey = 's';
    private static final char RelativeReflectiveQuadToKey = 't';
    private static final char RelativeVerticalToKey = 'v';
    private static final char VerticalToKey = 'V';

    public static final void addPathNodes(char c, List<PathNode> list, float[] fArr, int i) {
        AbstractC4492zt.h(list, "nodes");
        AbstractC4492zt.h(fArr, "args");
        if (c == 'z' || c == 'Z') {
            list.add(PathNode.Close.INSTANCE);
            return;
        }
        int i2 = 0;
        if (c == 'm') {
            int i3 = i - 2;
            while (i2 <= i3) {
                int i4 = i2 + 1;
                PathNode relativeMoveTo = new PathNode.RelativeMoveTo(fArr[i2], fArr[i4]);
                if (i2 > 0) {
                    relativeMoveTo = new PathNode.RelativeLineTo(fArr[i2], fArr[i4]);
                }
                list.add(relativeMoveTo);
                i2 += 2;
            }
            return;
        }
        if (c == 'M') {
            int i5 = i - 2;
            while (i2 <= i5) {
                int i6 = i2 + 1;
                PathNode moveTo = new PathNode.MoveTo(fArr[i2], fArr[i6]);
                if (i2 > 0) {
                    moveTo = new PathNode.LineTo(fArr[i2], fArr[i6]);
                }
                list.add(moveTo);
                i2 += 2;
            }
            return;
        }
        if (c == 'l') {
            int i7 = i - 2;
            while (i2 <= i7) {
                list.add(new PathNode.RelativeLineTo(fArr[i2], fArr[i2 + 1]));
                i2 += 2;
            }
            return;
        }
        if (c == 'L') {
            int i8 = i - 2;
            while (i2 <= i8) {
                list.add(new PathNode.LineTo(fArr[i2], fArr[i2 + 1]));
                i2 += 2;
            }
            return;
        }
        if (c == 'h') {
            int i9 = i - 1;
            while (i2 <= i9) {
                list.add(new PathNode.RelativeHorizontalTo(fArr[i2]));
                i2++;
            }
            return;
        }
        if (c == 'H') {
            int i10 = i - 1;
            while (i2 <= i10) {
                list.add(new PathNode.HorizontalTo(fArr[i2]));
                i2++;
            }
            return;
        }
        if (c == 'v') {
            int i11 = i - 1;
            while (i2 <= i11) {
                list.add(new PathNode.RelativeVerticalTo(fArr[i2]));
                i2++;
            }
            return;
        }
        if (c == 'V') {
            int i12 = i - 1;
            while (i2 <= i12) {
                list.add(new PathNode.VerticalTo(fArr[i2]));
                i2++;
            }
            return;
        }
        if (c == 'c') {
            int i13 = i - 6;
            while (i2 <= i13) {
                list.add(new PathNode.RelativeCurveTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3], fArr[i2 + 4], fArr[i2 + 5]));
                i2 += 6;
            }
            return;
        }
        if (c == 'C') {
            int i14 = i - 6;
            while (i2 <= i14) {
                list.add(new PathNode.CurveTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3], fArr[i2 + 4], fArr[i2 + 5]));
                i2 += 6;
            }
            return;
        }
        if (c == 's') {
            int i15 = i - 4;
            while (i2 <= i15) {
                list.add(new PathNode.RelativeReflectiveCurveTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3]));
                i2 += 4;
            }
            return;
        }
        if (c == 'S') {
            int i16 = i - 4;
            while (i2 <= i16) {
                list.add(new PathNode.ReflectiveCurveTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3]));
                i2 += 4;
            }
            return;
        }
        if (c == 'q') {
            int i17 = i - 4;
            while (i2 <= i17) {
                list.add(new PathNode.RelativeQuadTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3]));
                i2 += 4;
            }
            return;
        }
        if (c == 'Q') {
            int i18 = i - 4;
            while (i2 <= i18) {
                list.add(new PathNode.QuadTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3]));
                i2 += 4;
            }
            return;
        }
        if (c == 't') {
            int i19 = i - 2;
            while (i2 <= i19) {
                list.add(new PathNode.RelativeReflectiveQuadTo(fArr[i2], fArr[i2 + 1]));
                i2 += 2;
            }
            return;
        }
        if (c == 'T') {
            int i20 = i - 2;
            while (i2 <= i20) {
                list.add(new PathNode.ReflectiveQuadTo(fArr[i2], fArr[i2 + 1]));
                i2 += 2;
            }
            return;
        }
        if (c == 'a') {
            int i21 = i - 7;
            for (int i22 = 0; i22 <= i21; i22 += 7) {
                list.add(new PathNode.RelativeArcTo(fArr[i22], fArr[i22 + 1], fArr[i22 + 2], Float.compare(fArr[i22 + 3], 0.0f) != 0, Float.compare(fArr[i22 + 4], 0.0f) != 0, fArr[i22 + 5], fArr[i22 + 6]));
            }
            return;
        }
        if (c != 'A') {
            throw new IllegalArgumentException("Unknown command for: " + c);
        }
        int i23 = i - 7;
        for (int i24 = 0; i24 <= i23; i24 += 7) {
            list.add(new PathNode.ArcTo(fArr[i24], fArr[i24 + 1], fArr[i24 + 2], Float.compare(fArr[i24 + 3], 0.0f) != 0, Float.compare(fArr[i24 + 4], 0.0f) != 0, fArr[i24 + 5], fArr[i24 + 6]));
        }
    }

    private static final void pathNodesFromArgs(List<PathNode> list, float[] fArr, int i, int i2, InterfaceC0526Fp interfaceC0526Fp) {
        int i3 = i - i2;
        int i4 = 0;
        while (i4 <= i3) {
            PathNode relativeLineTo = (PathNode) interfaceC0526Fp.mo13invoke(fArr, Integer.valueOf(i4));
            if ((relativeLineTo instanceof PathNode.MoveTo) && i4 > 0) {
                relativeLineTo = new PathNode.LineTo(fArr[i4], fArr[i4 + 1]);
            } else if ((relativeLineTo instanceof PathNode.RelativeMoveTo) && i4 > 0) {
                relativeLineTo = new PathNode.RelativeLineTo(fArr[i4], fArr[i4 + 1]);
            }
            list.add(relativeLineTo);
            i4 += i2;
        }
    }
}
