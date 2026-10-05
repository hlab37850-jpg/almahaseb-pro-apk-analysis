package defpackage;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.Path;

/* JADX INFO: renamed from: rG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC3787rG {
    static {
        Path.Companion companion = Path.Companion;
    }

    public static void a(Path path, Rect rect, float f, float f2, boolean z) {
        AbstractC4492zt.h(rect, "rect");
        path.arcTo(rect, DegreesKt.degrees(f), DegreesKt.degrees(f2), z);
    }

    public static void b(Path path) {
        path.reset();
    }

    public static void c(Path path, float[] fArr) {
        AbstractC4492zt.h(fArr, "matrix");
    }

    public static /* synthetic */ void g(Path path, Path path2, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPath-Uv8p0NA");
        }
        if ((i & 2) != 0) {
            j = Offset.Companion.m2814getZeroF1C5BW0();
        }
        path.mo2930addPathUv8p0NA(path2, j);
    }
}
