package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ExcludeFromSystemGesture_androidKt {
    public static final Modifier excludeFromSystemGesture(Modifier modifier) {
        AbstractC4492zt.h(modifier, "<this>");
        return SystemGestureExclusionKt.systemGestureExclusion(modifier);
    }

    public static final Modifier excludeFromSystemGesture(Modifier modifier, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "exclusion");
        return SystemGestureExclusionKt.systemGestureExclusion(modifier, interfaceC3750qp);
    }
}
