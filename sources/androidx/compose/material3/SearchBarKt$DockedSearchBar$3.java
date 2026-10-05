package androidx.compose.material3;

import androidx.compose.ui.focus.FocusManager;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1043Xi;
import defpackage.AbstractC4233wn;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.material3.SearchBarKt$DockedSearchBar$3", f = "SearchBar.kt", l = {411}, m = "invokeSuspend")
public final class SearchBarKt$DockedSearchBar$3 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ boolean $active;
    final /* synthetic */ FocusManager $focusManager;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBarKt$DockedSearchBar$3(boolean z, FocusManager focusManager, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$active = z;
        this.$focusManager = focusManager;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        return new SearchBarKt$DockedSearchBar$3(this.$active, this.$focusManager, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
        return ((SearchBarKt$DockedSearchBar$3) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            if (!this.$active) {
                this.label = 1;
                if (AbstractC1043Xi.a(100L, this) == objD) {
                    return objD;
                }
            }
            return FW.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LL.b(obj);
        AbstractC4233wn.a(this.$focusManager, false, 1, null);
        return FW.a;
    }
}
