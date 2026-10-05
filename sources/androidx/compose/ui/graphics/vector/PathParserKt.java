package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.AbstractC4492zt;
import java.util.List;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
public final class PathParserKt {
    private static final float[] EmptyArray = new float[0];

    private static final void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d3;
        double d11 = 4;
        int iCeil = (int) Math.ceil(Math.abs((d9 * d11) / 3.141592653589793d));
        double dCos = Math.cos(d7);
        double dSin = Math.sin(d7);
        double dCos2 = Math.cos(d8);
        double dSin2 = Math.sin(d8);
        double d12 = -d10;
        double d13 = d12 * dCos;
        double d14 = d4 * dSin;
        double d15 = (d13 * dSin2) - (d14 * dCos2);
        double d16 = d12 * dSin;
        double d17 = d4 * dCos;
        double d18 = (dSin2 * d16) + (dCos2 * d17);
        double d19 = d9 / ((double) iCeil);
        double d20 = d5;
        double d21 = d8;
        double d22 = d18;
        double d23 = d15;
        int i = 0;
        double d24 = d6;
        while (i < iCeil) {
            double d25 = d21 + d19;
            double dSin3 = Math.sin(d25);
            double dCos3 = Math.cos(d25);
            int i2 = iCeil;
            double d26 = (d + ((d10 * dCos) * dCos3)) - (d14 * dSin3);
            double d27 = d2 + (d10 * dSin * dCos3) + (d17 * dSin3);
            double d28 = (d13 * dSin3) - (d14 * dCos3);
            double d29 = (dSin3 * d16) + (dCos3 * d17);
            double d30 = d25 - d21;
            double dTan = Math.tan(d30 / ((double) 2));
            double dSin4 = (Math.sin(d30) * (Math.sqrt(d11 + ((3.0d * dTan) * dTan)) - ((double) 1))) / ((double) 3);
            path.cubicTo((float) (d20 + (d23 * dSin4)), (float) (d24 + (d22 * dSin4)), (float) (d26 - (dSin4 * d28)), (float) (d27 - (dSin4 * d29)), (float) d26, (float) d27);
            i++;
            d19 = d19;
            dSin = dSin;
            d20 = d26;
            d16 = d16;
            d21 = d25;
            d22 = d29;
            d11 = d11;
            d23 = d28;
            dCos = dCos;
            iCeil = i2;
            d24 = d27;
            d10 = d3;
        }
    }

    private static final void drawArc(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, boolean z, boolean z2) {
        double d8;
        double d9;
        double d10 = (d7 / ((double) ShapeTypes.MATH_EQUAL)) * 3.141592653589793d;
        double dCos = Math.cos(d10);
        double dSin = Math.sin(d10);
        double d11 = ((d * dCos) + (d2 * dSin)) / d5;
        double d12 = (((-d) * dSin) + (d2 * dCos)) / d6;
        double d13 = ((d3 * dCos) + (d4 * dSin)) / d5;
        double d14 = (((-d3) * dSin) + (d4 * dCos)) / d6;
        double d15 = d11 - d13;
        double d16 = d12 - d14;
        double d17 = 2;
        double d18 = (d11 + d13) / d17;
        double d19 = (d12 + d14) / d17;
        double d20 = (d15 * d15) + (d16 * d16);
        if (d20 == 0.0d) {
            return;
        }
        double d21 = (1.0d / d20) - 0.25d;
        if (d21 < 0.0d) {
            double dSqrt = (float) (Math.sqrt(d20) / 1.99999d);
            drawArc(path, d, d2, d3, d4, d5 * dSqrt, d6 * dSqrt, d7, z, z2);
            return;
        }
        double dSqrt2 = Math.sqrt(d21);
        double d22 = d15 * dSqrt2;
        double d23 = dSqrt2 * d16;
        if (z == z2) {
            d8 = d18 - d23;
            d9 = d19 + d22;
        } else {
            d8 = d18 + d23;
            d9 = d19 - d22;
        }
        double dAtan2 = Math.atan2(d12 - d9, d11 - d8);
        double dAtan3 = Math.atan2(d14 - d9, d13 - d8) - dAtan2;
        if (z2 != (dAtan3 >= 0.0d)) {
            dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
        }
        double d24 = d8 * d5;
        double d25 = d9 * d6;
        arcToBezier(path, (d24 * dCos) - (d25 * dSin), (d24 * dSin) + (d25 * dCos), d5, d6, d, d2, d10, dAtan2, dAtan3);
    }

    public static final float[] getEmptyArray() {
        return EmptyArray;
    }

    public static final Path toPath(List<? extends PathNode> list, Path path) {
        PathNode pathNode;
        float f;
        float f2;
        float x1;
        float dy1;
        float dy;
        float y1;
        float x2;
        float y2;
        float f3;
        float f4;
        float f5;
        float f6;
        float dy2;
        List<? extends PathNode> list2 = list;
        Path path2 = path;
        AbstractC4492zt.h(list2, "<this>");
        AbstractC4492zt.h(path2, TypedValues.AttributesType.S_TARGET);
        int iMo2931getFillTypeRgk1Os = path.mo2931getFillTypeRgk1Os();
        path.rewind();
        path2.mo2933setFillTypeoQ8Xj4U(iMo2931getFillTypeRgk1Os);
        PathNode pathNode2 = list.isEmpty() ? PathNode.Close.INSTANCE : list2.get(0);
        int size = list.size();
        float f7 = 0.0f;
        float f8 = 0.0f;
        float arcStartY = 0.0f;
        float arcStartX = 0.0f;
        float y = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        int i = 0;
        while (i < size) {
            PathNode pathNode3 = list2.get(i);
            if (pathNode3 instanceof PathNode.Close) {
                path.close();
                path2.moveTo(f9, f10);
                f8 = f9;
                arcStartX = f8;
                arcStartY = f10;
                y = arcStartY;
            } else if (pathNode3 instanceof PathNode.RelativeMoveTo) {
                PathNode.RelativeMoveTo relativeMoveTo = (PathNode.RelativeMoveTo) pathNode3;
                arcStartX += relativeMoveTo.getDx();
                y += relativeMoveTo.getDy();
                path2.relativeMoveTo(relativeMoveTo.getDx(), relativeMoveTo.getDy());
                f9 = arcStartX;
                f10 = y;
            } else if (pathNode3 instanceof PathNode.MoveTo) {
                PathNode.MoveTo moveTo = (PathNode.MoveTo) pathNode3;
                float x = moveTo.getX();
                float y3 = moveTo.getY();
                path2.moveTo(moveTo.getX(), moveTo.getY());
                arcStartX = x;
                f9 = arcStartX;
                y = y3;
                f10 = y;
            } else {
                if (pathNode3 instanceof PathNode.RelativeLineTo) {
                    PathNode.RelativeLineTo relativeLineTo = (PathNode.RelativeLineTo) pathNode3;
                    path2.relativeLineTo(relativeLineTo.getDx(), relativeLineTo.getDy());
                    arcStartX += relativeLineTo.getDx();
                    dy2 = relativeLineTo.getDy();
                } else if (pathNode3 instanceof PathNode.LineTo) {
                    PathNode.LineTo lineTo = (PathNode.LineTo) pathNode3;
                    path2.lineTo(lineTo.getX(), lineTo.getY());
                    float x3 = lineTo.getX();
                    y = lineTo.getY();
                    arcStartX = x3;
                } else if (pathNode3 instanceof PathNode.RelativeHorizontalTo) {
                    PathNode.RelativeHorizontalTo relativeHorizontalTo = (PathNode.RelativeHorizontalTo) pathNode3;
                    path2.relativeLineTo(relativeHorizontalTo.getDx(), f7);
                    arcStartX += relativeHorizontalTo.getDx();
                } else if (pathNode3 instanceof PathNode.HorizontalTo) {
                    PathNode.HorizontalTo horizontalTo = (PathNode.HorizontalTo) pathNode3;
                    path2.lineTo(horizontalTo.getX(), y);
                    arcStartX = horizontalTo.getX();
                } else {
                    if (pathNode3 instanceof PathNode.RelativeVerticalTo) {
                        PathNode.RelativeVerticalTo relativeVerticalTo = (PathNode.RelativeVerticalTo) pathNode3;
                        path2.relativeLineTo(f7, relativeVerticalTo.getDy());
                        dy2 = relativeVerticalTo.getDy();
                    } else if (pathNode3 instanceof PathNode.VerticalTo) {
                        PathNode.VerticalTo verticalTo = (PathNode.VerticalTo) pathNode3;
                        path2.lineTo(arcStartX, verticalTo.getY());
                        y = verticalTo.getY();
                    } else {
                        if (pathNode3 instanceof PathNode.RelativeCurveTo) {
                            PathNode.RelativeCurveTo relativeCurveTo = (PathNode.RelativeCurveTo) pathNode3;
                            pathNode = pathNode3;
                            path.relativeCubicTo(relativeCurveTo.getDx1(), relativeCurveTo.getDy1(), relativeCurveTo.getDx2(), relativeCurveTo.getDy2(), relativeCurveTo.getDx3(), relativeCurveTo.getDy3());
                            x1 = relativeCurveTo.getDx2() + arcStartX;
                            dy1 = relativeCurveTo.getDy2() + y;
                            arcStartX += relativeCurveTo.getDx3();
                            dy = relativeCurveTo.getDy3();
                        } else {
                            pathNode = pathNode3;
                            if (pathNode instanceof PathNode.CurveTo) {
                                PathNode.CurveTo curveTo = (PathNode.CurveTo) pathNode;
                                path.cubicTo(curveTo.getX1(), curveTo.getY1(), curveTo.getX2(), curveTo.getY2(), curveTo.getX3(), curveTo.getY3());
                                x1 = curveTo.getX2();
                                y1 = curveTo.getY2();
                                x2 = curveTo.getX3();
                                y2 = curveTo.getY3();
                            } else if (pathNode instanceof PathNode.RelativeReflectiveCurveTo) {
                                if (pathNode2.isCurve()) {
                                    f6 = y - arcStartY;
                                    f5 = arcStartX - f8;
                                } else {
                                    f5 = 0.0f;
                                    f6 = 0.0f;
                                }
                                PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo = (PathNode.RelativeReflectiveCurveTo) pathNode;
                                path.relativeCubicTo(f5, f6, relativeReflectiveCurveTo.getDx1(), relativeReflectiveCurveTo.getDy1(), relativeReflectiveCurveTo.getDx2(), relativeReflectiveCurveTo.getDy2());
                                x1 = relativeReflectiveCurveTo.getDx1() + arcStartX;
                                dy1 = relativeReflectiveCurveTo.getDy1() + y;
                                arcStartX += relativeReflectiveCurveTo.getDx2();
                                dy = relativeReflectiveCurveTo.getDy2();
                            } else if (pathNode instanceof PathNode.ReflectiveCurveTo) {
                                if (pathNode2.isCurve()) {
                                    float f11 = 2;
                                    f4 = (f11 * y) - arcStartY;
                                    f3 = (arcStartX * f11) - f8;
                                } else {
                                    f3 = arcStartX;
                                    f4 = y;
                                }
                                PathNode.ReflectiveCurveTo reflectiveCurveTo = (PathNode.ReflectiveCurveTo) pathNode;
                                path.cubicTo(f3, f4, reflectiveCurveTo.getX1(), reflectiveCurveTo.getY1(), reflectiveCurveTo.getX2(), reflectiveCurveTo.getY2());
                                x1 = reflectiveCurveTo.getX1();
                                y1 = reflectiveCurveTo.getY1();
                                x2 = reflectiveCurveTo.getX2();
                                y2 = reflectiveCurveTo.getY2();
                            } else if (pathNode instanceof PathNode.RelativeQuadTo) {
                                PathNode.RelativeQuadTo relativeQuadTo = (PathNode.RelativeQuadTo) pathNode;
                                path2.relativeQuadraticBezierTo(relativeQuadTo.getDx1(), relativeQuadTo.getDy1(), relativeQuadTo.getDx2(), relativeQuadTo.getDy2());
                                x1 = relativeQuadTo.getDx1() + arcStartX;
                                dy1 = relativeQuadTo.getDy1() + y;
                                arcStartX += relativeQuadTo.getDx2();
                                dy = relativeQuadTo.getDy2();
                            } else if (pathNode instanceof PathNode.QuadTo) {
                                PathNode.QuadTo quadTo = (PathNode.QuadTo) pathNode;
                                path2.quadraticBezierTo(quadTo.getX1(), quadTo.getY1(), quadTo.getX2(), quadTo.getY2());
                                x1 = quadTo.getX1();
                                y1 = quadTo.getY1();
                                x2 = quadTo.getX2();
                                y2 = quadTo.getY2();
                            } else if (pathNode instanceof PathNode.RelativeReflectiveQuadTo) {
                                if (pathNode2.isQuad()) {
                                    f = arcStartX - f8;
                                    f2 = y - arcStartY;
                                } else {
                                    f = 0.0f;
                                    f2 = 0.0f;
                                }
                                PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo = (PathNode.RelativeReflectiveQuadTo) pathNode;
                                path2.relativeQuadraticBezierTo(f, f2, relativeReflectiveQuadTo.getDx(), relativeReflectiveQuadTo.getDy());
                                x1 = f + arcStartX;
                                dy1 = f2 + y;
                                arcStartX += relativeReflectiveQuadTo.getDx();
                                dy = relativeReflectiveQuadTo.getDy();
                            } else if (pathNode instanceof PathNode.ReflectiveQuadTo) {
                                if (pathNode2.isQuad()) {
                                    float f12 = 2;
                                    arcStartX = (arcStartX * f12) - f8;
                                    y = (f12 * y) - arcStartY;
                                }
                                PathNode.ReflectiveQuadTo reflectiveQuadTo = (PathNode.ReflectiveQuadTo) pathNode;
                                path2.quadraticBezierTo(arcStartX, y, reflectiveQuadTo.getX(), reflectiveQuadTo.getY());
                                float x4 = reflectiveQuadTo.getX();
                                pathNode3 = pathNode;
                                arcStartY = y;
                                i = i;
                                size = size;
                                y = reflectiveQuadTo.getY();
                                f8 = arcStartX;
                                arcStartX = x4;
                            } else if (pathNode instanceof PathNode.RelativeArcTo) {
                                PathNode.RelativeArcTo relativeArcTo = (PathNode.RelativeArcTo) pathNode;
                                float arcStartDx = relativeArcTo.getArcStartDx() + arcStartX;
                                float arcStartDy = relativeArcTo.getArcStartDy() + y;
                                pathNode3 = pathNode;
                                i = i;
                                size = size;
                                drawArc(path, arcStartX, y, arcStartDx, arcStartDy, relativeArcTo.getHorizontalEllipseRadius(), relativeArcTo.getVerticalEllipseRadius(), relativeArcTo.getTheta(), relativeArcTo.isMoreThanHalf(), relativeArcTo.isPositiveArc());
                                f8 = arcStartDx;
                                arcStartX = f8;
                                f9 = f9;
                                f10 = f10;
                                arcStartY = arcStartDy;
                                y = arcStartY;
                            } else {
                                float f13 = f9;
                                float f14 = f10;
                                i = i;
                                size = size;
                                if (pathNode instanceof PathNode.ArcTo) {
                                    PathNode.ArcTo arcTo = (PathNode.ArcTo) pathNode;
                                    pathNode3 = pathNode;
                                    drawArc(path, arcStartX, y, arcTo.getArcStartX(), arcTo.getArcStartY(), arcTo.getHorizontalEllipseRadius(), arcTo.getVerticalEllipseRadius(), arcTo.getTheta(), arcTo.isMoreThanHalf(), arcTo.isPositiveArc());
                                    arcStartX = arcTo.getArcStartX();
                                    arcStartY = arcTo.getArcStartY();
                                    y = arcStartY;
                                    f9 = f13;
                                    f10 = f14;
                                    f8 = arcStartX;
                                } else {
                                    pathNode3 = pathNode;
                                    f9 = f13;
                                    f10 = f14;
                                }
                            }
                            pathNode3 = pathNode;
                            arcStartX = x2;
                            y = y2;
                            arcStartY = y1;
                            f8 = x1;
                        }
                        y += dy;
                        pathNode3 = pathNode;
                        arcStartY = dy1;
                        f8 = x1;
                    }
                    i++;
                    path2 = path;
                    size = size;
                    pathNode2 = pathNode3;
                    f7 = 0.0f;
                    list2 = list;
                }
                y += dy2;
            }
            i = i;
            size = size;
            i++;
            path2 = path;
            size = size;
            pathNode2 = pathNode3;
            f7 = 0.0f;
            list2 = list;
        }
        return path;
    }

    public static /* synthetic */ Path toPath$default(List list, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return toPath(list, path);
    }

    private static final double toRadians(double d) {
        return (d / ((double) ShapeTypes.MATH_EQUAL)) * 3.141592653589793d;
    }
}
