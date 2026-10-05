package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import com.google.api.client.http.HttpStatusCodes;
import defpackage.AO;
import defpackage.AbstractC0378Bt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC4362yO;
import defpackage.JL;
import defpackage.LL;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {HttpStatusCodes.STATUS_CODE_CONFLICT, 411}, m = "invokeSuspend")
public final class ViewKt$allViews$1 extends JL implements InterfaceC0526Fp {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$this_allViews = view;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, interfaceC0793Of);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(AO ao, InterfaceC0793Of interfaceC0793Of) {
        return ((ViewKt$allViews$1) create(ao, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        AO ao;
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ao = (AO) this.L$0;
                LL.b(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
        LL.b(obj);
        ao = (AO) this.L$0;
        View view = this.$this_allViews;
        this.L$0 = ao;
        this.label = 1;
        if (ao.b(view, this) == objD) {
            return objD;
        }
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            InterfaceC4362yO descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            if (ao.c(descendants, this) == objD) {
                return objD;
            }
        }
        return FW.a;
    }
}
