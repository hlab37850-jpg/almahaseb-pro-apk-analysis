package androidx.compose.material3;

import androidx.compose.foundation.text.KeyboardActionScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SearchBarKt$SearchBarInputField$4$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3750qp $onSearch;
    final /* synthetic */ String $query;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBarKt$SearchBarInputField$4$1(InterfaceC3750qp interfaceC3750qp, String str) {
        super(1);
        this.$onSearch = interfaceC3750qp;
        this.$query = str;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyboardActionScope) obj);
        return FW.a;
    }

    public final void invoke(KeyboardActionScope keyboardActionScope) {
        AbstractC4492zt.h(keyboardActionScope, "$this$$receiver");
        this.$onSearch.invoke(this.$query);
    }
}
