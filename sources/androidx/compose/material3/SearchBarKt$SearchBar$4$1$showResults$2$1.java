package androidx.compose.material3;

import androidx.compose.runtime.State;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class SearchBarKt$SearchBar$4$1$showResults$2$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ State<Float> $animationProgress;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBarKt$SearchBar$4$1$showResults$2$1(State<Float> state) {
        super(0);
        this.$animationProgress = state;
    }

    @Override // defpackage.InterfaceC3588op
    public final Boolean invoke() {
        return Boolean.valueOf(this.$animationProgress.getValue().floatValue() > 0.0f);
    }
}
