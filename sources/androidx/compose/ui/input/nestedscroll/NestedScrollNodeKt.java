package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.DelegatableNode;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollNodeKt {
    private static final ProvidableModifierLocal<NestedScrollNode> ModifierLocalNestedScroll = ModifierLocalKt.modifierLocalOf(NestedScrollNodeKt$ModifierLocalNestedScroll$1.INSTANCE);

    public static final ProvidableModifierLocal<NestedScrollNode> getModifierLocalNestedScroll() {
        return ModifierLocalNestedScroll;
    }

    public static final DelegatableNode nestedScrollModifierNode(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        AbstractC4492zt.h(nestedScrollConnection, "connection");
        return new NestedScrollNode(nestedScrollConnection, nestedScrollDispatcher);
    }
}
