package defpackage;

import androidx.compose.material.AnchoredDragScope;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class C2 {
    public static /* synthetic */ void a(AnchoredDragScope anchoredDragScope, float f, float f2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dragTo");
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        anchoredDragScope.dragTo(f, f2);
    }
}
