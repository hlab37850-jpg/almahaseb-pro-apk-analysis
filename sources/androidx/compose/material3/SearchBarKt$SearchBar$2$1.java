package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SearchBarKt$SearchBar$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ MutableWindowInsets $unconsumedInsets;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBarKt$SearchBar$2$1(MutableWindowInsets mutableWindowInsets, WindowInsets windowInsets) {
        super(1);
        this.$unconsumedInsets = mutableWindowInsets;
        this.$windowInsets = windowInsets;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WindowInsets) obj);
        return FW.a;
    }

    public final void invoke(WindowInsets windowInsets) {
        AbstractC4492zt.h(windowInsets, "consumedInsets");
        this.$unconsumedInsets.setInsets(WindowInsetsKt.exclude(this.$windowInsets, windowInsets));
    }
}
