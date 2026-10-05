package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.AbstractC4492zt;
import defpackage.Q5;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PathParser {
    private final List<PathNode> nodes = new ArrayList();
    private final FloatResult floatResult = new FloatResult(0.0f, false, 3, null);
    private float[] nodeData = new float[64];

    private final void addNodes(char c, float[] fArr, int i) {
        PathNodeKt.addPathNodes(c, this.nodes, fArr, i);
    }

    private final void resizeNodeData(int i) {
        float[] fArr = this.nodeData;
        if (i >= fArr.length) {
            float[] fArr2 = new float[i * 2];
            this.nodeData = fArr2;
            Q5.f(fArr, fArr2, 0, 0, fArr.length);
        }
    }

    public static /* synthetic */ Path toPath$default(PathParser pathParser, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return pathParser.toPath(path);
    }

    public final PathParser addPathNodes(List<? extends PathNode> list) {
        AbstractC4492zt.h(list, "nodes");
        this.nodes.addAll(list);
        return this;
    }

    public final void clear() {
        this.nodes.clear();
    }

    public final PathParser parsePathString(String str) {
        int iNextFloat;
        char cCharAt;
        AbstractC4492zt.h(str, "pathData");
        this.nodes.clear();
        int length = str.length();
        int i = 0;
        while (i < length && AbstractC4492zt.j(str.charAt(i), 32) <= 0) {
            i++;
        }
        while (length > i && AbstractC4492zt.j(str.charAt(length - 1), 32) <= 0) {
            length--;
        }
        int i2 = 0;
        while (i < length) {
            while (true) {
                iNextFloat = i + 1;
                cCharAt = str.charAt(i);
                int i3 = cCharAt | ' ';
                if ((i3 - 97) * (i3 - 122) <= 0 && i3 != 101) {
                    break;
                }
                if (iNextFloat >= length) {
                    cCharAt = 0;
                    break;
                }
                i = iNextFloat;
            }
            if (cCharAt != 0) {
                if ((cCharAt | ' ') != 122) {
                    i2 = 0;
                    while (true) {
                        if (iNextFloat >= length || AbstractC4492zt.j(str.charAt(iNextFloat), 32) > 0) {
                            iNextFloat = FastFloatParser.Companion.nextFloat(str, iNextFloat, length, this.floatResult);
                            if (this.floatResult.isValid()) {
                                int i4 = i2 + 1;
                                this.nodeData[i2] = this.floatResult.getValue();
                                float[] fArr = this.nodeData;
                                if (i4 >= fArr.length) {
                                    float[] fArr2 = new float[i4 * 2];
                                    this.nodeData = fArr2;
                                    Q5.f(fArr, fArr2, 0, 0, fArr.length);
                                }
                                i2 = i4;
                            }
                            while (iNextFloat < length && str.charAt(iNextFloat) == ',') {
                                iNextFloat++;
                            }
                            if (iNextFloat >= length || !this.floatResult.isValid()) {
                                break;
                            }
                        } else {
                            iNextFloat++;
                        }
                    }
                }
                PathNodeKt.addPathNodes(cCharAt, this.nodes, this.nodeData, i2);
            }
            i = iNextFloat;
        }
        return this;
    }

    public final List<PathNode> toNodes() {
        return this.nodes;
    }

    public final Path toPath(Path path) {
        AbstractC4492zt.h(path, TypedValues.AttributesType.S_TARGET);
        return PathParserKt.toPath(this.nodes, path);
    }
}
