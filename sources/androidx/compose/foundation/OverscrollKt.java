package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class OverscrollKt {
    @ExperimentalFoundationApi
    public static final Modifier overscroll(Modifier modifier, OverscrollEffect overscrollEffect) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(overscrollEffect, "overscrollEffect");
        return modifier.then(overscrollEffect.getEffectModifier());
    }
}
