package androidx.paging;

import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1040Xf;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C0368Bj;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PagingDataAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private final AsyncPagingDataDiffer<T> differ;
    private final InterfaceC0939Tm loadStateFlow;
    private final InterfaceC0939Tm onPagesUpdatedFlow;
    private boolean userSetRestorationPolicy;

    /* JADX INFO: renamed from: androidx.paging.PagingDataAdapter$withLoadStateFooter$1, reason: invalid class name and case insensitive filesystem */
    public static final class C17131 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ LoadStateAdapter<?> $footer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17131(LoadStateAdapter<?> loadStateAdapter) {
            super(1);
            this.$footer = loadStateAdapter;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CombinedLoadStates) obj);
            return FW.a;
        }

        public final void invoke(CombinedLoadStates combinedLoadStates) {
            AbstractC4492zt.h(combinedLoadStates, "loadStates");
            this.$footer.setLoadState(combinedLoadStates.getAppend());
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagingDataAdapter$withLoadStateHeader$1, reason: invalid class name and case insensitive filesystem */
    public static final class C17141 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ LoadStateAdapter<?> $header;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17141(LoadStateAdapter<?> loadStateAdapter) {
            super(1);
            this.$header = loadStateAdapter;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CombinedLoadStates) obj);
            return FW.a;
        }

        public final void invoke(CombinedLoadStates combinedLoadStates) {
            AbstractC4492zt.h(combinedLoadStates, "loadStates");
            this.$header.setLoadState(combinedLoadStates.getPrepend());
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagingDataAdapter$withLoadStateHeaderAndFooter$1, reason: invalid class name and case insensitive filesystem */
    public static final class C17151 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ LoadStateAdapter<?> $footer;
        final /* synthetic */ LoadStateAdapter<?> $header;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17151(LoadStateAdapter<?> loadStateAdapter, LoadStateAdapter<?> loadStateAdapter2) {
            super(1);
            this.$header = loadStateAdapter;
            this.$footer = loadStateAdapter2;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CombinedLoadStates) obj);
            return FW.a;
        }

        public final void invoke(CombinedLoadStates combinedLoadStates) {
            AbstractC4492zt.h(combinedLoadStates, "loadStates");
            this.$header.setLoadState(combinedLoadStates.getPrepend());
            this.$footer.setLoadState(combinedLoadStates.getAppend());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagingDataAdapter(DiffUtil.ItemCallback<T> itemCallback) {
        this(itemCallback, (InterfaceC0988Vf) null, (InterfaceC0988Vf) null, 6, (AbstractC0419Di) null);
        AbstractC4492zt.h(itemCallback, "diffCallback");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, VH extends RecyclerView.ViewHolder> void _init_$considerAllowingStateRestoration(PagingDataAdapter<T, VH> pagingDataAdapter) {
        if (pagingDataAdapter.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT || ((PagingDataAdapter) pagingDataAdapter).userSetRestorationPolicy) {
            return;
        }
        pagingDataAdapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.ALLOW);
    }

    public final void addLoadStateListener(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.differ.addLoadStateListener(interfaceC3750qp);
    }

    public final void addOnPagesUpdatedListener(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.differ.addOnPagesUpdatedListener(interfaceC3588op);
    }

    @MainThread
    public final T getItem(@IntRange(from = 0) int i) {
        return this.differ.getItem(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.differ.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        return super.getItemId(i);
    }

    public final InterfaceC0939Tm getLoadStateFlow() {
        return this.loadStateFlow;
    }

    public final InterfaceC0939Tm getOnPagesUpdatedFlow() {
        return this.onPagesUpdatedFlow;
    }

    @MainThread
    public final T peek(@IntRange(from = 0) int i) {
        return this.differ.peek(i);
    }

    public final void refresh() {
        this.differ.refresh();
    }

    public final void removeLoadStateListener(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.differ.removeLoadStateListener(interfaceC3750qp);
    }

    public final void removeOnPagesUpdatedListener(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.differ.removeOnPagesUpdatedListener(interfaceC3588op);
    }

    public final void retry() {
        this.differ.retry();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable ids are unsupported on PagingDataAdapter.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        AbstractC4492zt.h(stateRestorationPolicy, "strategy");
        this.userSetRestorationPolicy = true;
        super.setStateRestorationPolicy(stateRestorationPolicy);
    }

    public final ItemSnapshotList<T> snapshot() {
        return this.differ.snapshot();
    }

    public final Object submitData(PagingData<T> pagingData, InterfaceC0793Of interfaceC0793Of) {
        Object objSubmitData = this.differ.submitData(pagingData, interfaceC0793Of);
        return objSubmitData == AbstractC0378Bt.d() ? objSubmitData : FW.a;
    }

    public final ConcatAdapter withLoadStateFooter(LoadStateAdapter<?> loadStateAdapter) {
        AbstractC4492zt.h(loadStateAdapter, HTML.Tag.FOOTER);
        addLoadStateListener(new C17131(loadStateAdapter));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this, loadStateAdapter});
    }

    public final ConcatAdapter withLoadStateHeader(LoadStateAdapter<?> loadStateAdapter) {
        AbstractC4492zt.h(loadStateAdapter, HTML.Tag.HEADER);
        addLoadStateListener(new C17141(loadStateAdapter));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{loadStateAdapter, this});
    }

    public final ConcatAdapter withLoadStateHeaderAndFooter(LoadStateAdapter<?> loadStateAdapter, LoadStateAdapter<?> loadStateAdapter2) {
        AbstractC4492zt.h(loadStateAdapter, HTML.Tag.HEADER);
        AbstractC4492zt.h(loadStateAdapter2, HTML.Tag.FOOTER);
        addLoadStateListener(new C17151(loadStateAdapter, loadStateAdapter2));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{loadStateAdapter, this, loadStateAdapter2});
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagingDataAdapter(DiffUtil.ItemCallback<T> itemCallback, InterfaceC0988Vf interfaceC0988Vf) {
        this(itemCallback, interfaceC0988Vf, (InterfaceC0988Vf) null, 4, (AbstractC0419Di) null);
        AbstractC4492zt.h(itemCallback, "diffCallback");
        AbstractC4492zt.h(interfaceC0988Vf, "mainDispatcher");
    }

    public final void submitData(Lifecycle lifecycle, PagingData<T> pagingData) {
        AbstractC4492zt.h(lifecycle, "lifecycle");
        AbstractC4492zt.h(pagingData, "pagingData");
        this.differ.submitData(lifecycle, pagingData);
    }

    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback itemCallback, InterfaceC0988Vf interfaceC0988Vf, InterfaceC0988Vf interfaceC0988Vf2, int i, AbstractC0419Di abstractC0419Di) {
        this(itemCallback, (i & 2) != 0 ? C0368Bj.c() : interfaceC0988Vf, (i & 4) != 0 ? C0368Bj.a() : interfaceC0988Vf2);
    }

    public PagingDataAdapter(DiffUtil.ItemCallback<T> itemCallback, InterfaceC0988Vf interfaceC0988Vf, InterfaceC0988Vf interfaceC0988Vf2) {
        AbstractC4492zt.h(itemCallback, "diffCallback");
        AbstractC4492zt.h(interfaceC0988Vf, "mainDispatcher");
        AbstractC4492zt.h(interfaceC0988Vf2, "workerDispatcher");
        AsyncPagingDataDiffer<T> asyncPagingDataDiffer = new AsyncPagingDataDiffer<>(itemCallback, new AdapterListUpdateCallback(this), interfaceC0988Vf, interfaceC0988Vf2);
        this.differ = asyncPagingDataDiffer;
        super.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT);
        registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(this) { // from class: androidx.paging.PagingDataAdapter.1
            final /* synthetic */ PagingDataAdapter<T, VH> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                PagingDataAdapter._init_$considerAllowingStateRestoration(this.this$0);
                this.this$0.unregisterAdapterDataObserver(this);
                super.onItemRangeInserted(i, i2);
            }
        });
        addLoadStateListener(new InterfaceC3750qp(this) { // from class: androidx.paging.PagingDataAdapter.2
            private boolean ignoreNextEvent = true;
            final /* synthetic */ PagingDataAdapter<T, VH> this$0;

            {
                this.this$0 = this;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CombinedLoadStates) obj);
                return FW.a;
            }

            public void invoke(CombinedLoadStates combinedLoadStates) {
                AbstractC4492zt.h(combinedLoadStates, "loadStates");
                if (this.ignoreNextEvent) {
                    this.ignoreNextEvent = false;
                } else if (combinedLoadStates.getSource().getRefresh() instanceof LoadState.NotLoading) {
                    PagingDataAdapter._init_$considerAllowingStateRestoration(this.this$0);
                    this.this$0.removeLoadStateListener(this);
                }
            }
        });
        this.loadStateFlow = asyncPagingDataDiffer.getLoadStateFlow();
        this.onPagesUpdatedFlow = asyncPagingDataDiffer.getOnPagesUpdatedFlow();
    }

    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback itemCallback, AbstractC1040Xf abstractC1040Xf, int i, AbstractC0419Di abstractC0419Di) {
        this(itemCallback, (i & 2) != 0 ? C0368Bj.c() : abstractC1040Xf);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback itemCallback, AbstractC1040Xf abstractC1040Xf) {
        this(itemCallback, (InterfaceC0988Vf) abstractC1040Xf, (InterfaceC0988Vf) C0368Bj.a());
        AbstractC4492zt.h(itemCallback, "diffCallback");
        AbstractC4492zt.h(abstractC1040Xf, "mainDispatcher");
    }

    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback itemCallback, AbstractC1040Xf abstractC1040Xf, AbstractC1040Xf abstractC1040Xf2, int i, AbstractC0419Di abstractC0419Di) {
        this(itemCallback, (i & 2) != 0 ? C0368Bj.c() : abstractC1040Xf, (i & 4) != 0 ? C0368Bj.a() : abstractC1040Xf2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagingDataAdapter(DiffUtil.ItemCallback itemCallback, AbstractC1040Xf abstractC1040Xf, AbstractC1040Xf abstractC1040Xf2) {
        this(itemCallback, (InterfaceC0988Vf) abstractC1040Xf, (InterfaceC0988Vf) abstractC1040Xf2);
        AbstractC4492zt.h(itemCallback, "diffCallback");
        AbstractC4492zt.h(abstractC1040Xf, "mainDispatcher");
        AbstractC4492zt.h(abstractC1040Xf2, "workerDispatcher");
    }
}
