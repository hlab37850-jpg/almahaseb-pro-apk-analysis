package androidx.compose.material3;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalMaterial3Api
public final class SwipeToDismissDefaults {
    public static final int $stable = 0;
    public static final SwipeToDismissDefaults INSTANCE = new SwipeToDismissDefaults();
    private static final InterfaceC0526Fp FixedPositionalThreshold = SwipeToDismissDefaults$FixedPositionalThreshold$1.INSTANCE;

    private SwipeToDismissDefaults() {
    }

    public final InterfaceC0526Fp getFixedPositionalThreshold() {
        return FixedPositionalThreshold;
    }
}
