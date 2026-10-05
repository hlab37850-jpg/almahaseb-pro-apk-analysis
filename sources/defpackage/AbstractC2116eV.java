package defpackage;

import androidx.compose.foundation.gestures.TransformScope;
import androidx.compose.ui.geometry.Offset;

/* JADX INFO: renamed from: eV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC2116eV {
    public static /* synthetic */ void a(TransformScope transformScope, float f, long j, float f2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transformBy-d-4ec7I");
        }
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            j = Offset.Companion.m2814getZeroF1C5BW0();
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        transformScope.mo263transformByd4ec7I(f, j, f2);
    }
}
