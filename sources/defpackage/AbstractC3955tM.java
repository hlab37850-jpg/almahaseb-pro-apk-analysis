package defpackage;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.ui.Modifier;

/* JADX INFO: renamed from: tM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC3955tM {
    public static /* synthetic */ Modifier a(RowScope rowScope, Modifier modifier, float f, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: weight");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return rowScope.weight(modifier, f, z);
    }
}
