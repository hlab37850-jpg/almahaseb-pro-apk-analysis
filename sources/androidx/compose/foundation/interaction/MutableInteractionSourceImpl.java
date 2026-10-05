package androidx.compose.foundation.interaction;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1224aP;
import defpackage.AbstractC4492zt;
import defpackage.CC;
import defpackage.FW;
import defpackage.I8;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes.dex */
@Stable
final class MutableInteractionSourceImpl implements MutableInteractionSource {
    private final CC interactions = AbstractC1224aP.b(0, 16, I8.DROP_OLDEST, 1, null);

    @Override // androidx.compose.foundation.interaction.MutableInteractionSource
    public Object emit(Interaction interaction, InterfaceC0793Of interfaceC0793Of) {
        Object objEmit = getInteractions().emit(interaction, interfaceC0793Of);
        return objEmit == AbstractC0378Bt.d() ? objEmit : FW.a;
    }

    @Override // androidx.compose.foundation.interaction.MutableInteractionSource
    public boolean tryEmit(Interaction interaction) {
        AbstractC4492zt.h(interaction, "interaction");
        return getInteractions().f(interaction);
    }

    @Override // androidx.compose.foundation.interaction.InteractionSource
    public CC getInteractions() {
        return this.interactions;
    }
}
