package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollModifierKt {
    public static final Modifier nestedScroll(Modifier modifier, NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(nestedScrollConnection, "connection");
        return modifier.then(new NestedScrollElement(nestedScrollConnection, nestedScrollDispatcher));
    }

    public static /* synthetic */ Modifier nestedScroll$default(Modifier modifier, NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher, int i, Object obj) {
        if ((i & 2) != 0) {
            nestedScrollDispatcher = null;
        }
        return nestedScroll(modifier, nestedScrollConnection, nestedScrollDispatcher);
    }
}
