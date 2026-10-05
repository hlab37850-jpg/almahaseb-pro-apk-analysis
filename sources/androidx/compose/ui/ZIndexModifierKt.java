package androidx.compose.ui;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class ZIndexModifierKt {
    @Stable
    public static final Modifier zIndex(Modifier modifier, float f) {
        AbstractC4492zt.h(modifier, "<this>");
        return modifier.then(new ZIndexElement(f));
    }
}
