package defpackage;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.ui.Modifier;

/* JADX INFO: renamed from: Id, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0592Id {
    public static /* synthetic */ Modifier a(ColumnScope columnScope, Modifier modifier, float f, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: weight");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return columnScope.weight(modifier, f, z);
    }
}
