package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.FW;
import defpackage.GC;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.XS;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$2", f = "PageFetcherSnapshot.kt", l = {645, ShapeTypes.MATH_DIVIDE}, m = "invokeSuspend")
public final class PageFetcherSnapshot$pageEventFlow$2 extends XS implements InterfaceC0526Fp {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$pageEventFlow$2(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.this$0 = pageFetcherSnapshot;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        PageFetcherSnapshot$pageEventFlow$2 pageFetcherSnapshot$pageEventFlow$2 = new PageFetcherSnapshot$pageEventFlow$2(this.this$0, interfaceC0793Of);
        pageFetcherSnapshot$pageEventFlow$2.L$0 = obj;
        return pageFetcherSnapshot$pageEventFlow$2;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
        return ((PageFetcherSnapshot$pageEventFlow$2) create(interfaceC0995Vm, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        InterfaceC0995Vm interfaceC0995Vm;
        PageFetcherSnapshotState.Holder holder;
        GC gc;
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    interfaceC0995Vm = (InterfaceC0995Vm) this.L$2;
                    gc = (GC) this.L$1;
                    holder = (PageFetcherSnapshotState.Holder) this.L$0;
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
            interfaceC0995Vm = (InterfaceC0995Vm) this.L$0;
            holder = ((PageFetcherSnapshot) this.this$0).stateHolder;
            GC gc2 = holder.lock;
            this.L$0 = holder;
            this.L$1 = gc2;
            this.L$2 = interfaceC0995Vm;
            this.label = 1;
            if (gc2.c(null, this) == objD) {
                return objD;
            }
            gc = gc2;
            LoadStates loadStatesSnapshot = holder.state.getSourceLoadStates$paging_common().snapshot();
            gc.b(null);
            PageEvent.LoadStateUpdate loadStateUpdate = new PageEvent.LoadStateUpdate(loadStatesSnapshot, null, 2, null);
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (interfaceC0995Vm.emit(loadStateUpdate, this) == objD) {
                return objD;
            }
            return FW.a;
        } catch (Throwable th) {
            gc.b(null);
            throw th;
        }
    }
}
