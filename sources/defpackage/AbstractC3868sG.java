package defpackage;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;

/* JADX INFO: renamed from: sG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC3868sG {
    public static /* synthetic */ boolean a(PathMeasure pathMeasure, float f, float f2, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSegment");
        }
        if ((i & 8) != 0) {
            z = true;
        }
        return pathMeasure.getSegment(f, f2, path, z);
    }
}
