package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4243wx;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class LazySaveableStateHolderKt$LazySaveableStateHolderProvider$holder$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ SaveableStateRegistry $currentRegistry;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazySaveableStateHolderKt$LazySaveableStateHolderProvider$holder$1(SaveableStateRegistry saveableStateRegistry) {
        super(0);
        this.$currentRegistry = saveableStateRegistry;
    }

    @Override // defpackage.InterfaceC3588op
    public final LazySaveableStateHolder invoke() {
        return new LazySaveableStateHolder(this.$currentRegistry, AbstractC4243wx.g());
    }
}
