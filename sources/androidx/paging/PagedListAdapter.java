package androidx.paging;

import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PagedListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private final AsyncPagedListDiffer<T> differ;
    private final InterfaceC0526Fp listener;

    /* JADX INFO: renamed from: androidx.paging.PagedListAdapter$withLoadStateFooter$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ LoadStateAdapter<?> $footer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LoadStateAdapter<?> loadStateAdapter) {
            super(2);
            this.$footer = loadStateAdapter;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((LoadType) obj, (LoadState) obj2);
            return FW.a;
        }

        public final void invoke(LoadType loadType, LoadState loadState) {
            AbstractC4492zt.h(loadType, "loadType");
            AbstractC4492zt.h(loadState, "loadState");
            if (loadType == LoadType.APPEND) {
                this.$footer.setLoadState(loadState);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagedListAdapter$withLoadStateHeader$1, reason: invalid class name and case insensitive filesystem */
    public static final class C17111 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ LoadStateAdapter<?> $header;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17111(LoadStateAdapter<?> loadStateAdapter) {
            super(2);
            this.$header = loadStateAdapter;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((LoadType) obj, (LoadState) obj2);
            return FW.a;
        }

        public final void invoke(LoadType loadType, LoadState loadState) {
            AbstractC4492zt.h(loadType, "loadType");
            AbstractC4492zt.h(loadState, "loadState");
            if (loadType == LoadType.PREPEND) {
                this.$header.setLoadState(loadState);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagedListAdapter$withLoadStateHeaderAndFooter$1, reason: invalid class name and case insensitive filesystem */
    public static final class C17121 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ LoadStateAdapter<?> $footer;
        final /* synthetic */ LoadStateAdapter<?> $header;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17121(LoadStateAdapter<?> loadStateAdapter, LoadStateAdapter<?> loadStateAdapter2) {
            super(2);
            this.$header = loadStateAdapter;
            this.$footer = loadStateAdapter2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((LoadType) obj, (LoadState) obj2);
            return FW.a;
        }

        public final void invoke(LoadType loadType, LoadState loadState) {
            AbstractC4492zt.h(loadType, "loadType");
            AbstractC4492zt.h(loadState, "loadState");
            if (loadType == LoadType.PREPEND) {
                this.$header.setLoadState(loadState);
            } else if (loadType == LoadType.APPEND) {
                this.$footer.setLoadState(loadState);
            }
        }
    }

    public PagedListAdapter(DiffUtil.ItemCallback<T> itemCallback) {
        AbstractC4492zt.h(itemCallback, "diffCallback");
        PagedListAdapter$listener$1 pagedListAdapter$listener$1 = new PagedListAdapter$listener$1(this);
        this.listener = pagedListAdapter$listener$1;
        AsyncPagedListDiffer<T> asyncPagedListDiffer = new AsyncPagedListDiffer<>(this, itemCallback);
        this.differ = asyncPagedListDiffer;
        asyncPagedListDiffer.addPagedListListener(pagedListAdapter$listener$1);
    }

    public static /* synthetic */ void getCurrentList$annotations() {
    }

    public static /* synthetic */ void getDiffer$paging_runtime_release$annotations() {
    }

    private static /* synthetic */ void getListener$annotations() {
    }

    public void addLoadStateListener(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.differ.addLoadStateListener(interfaceC0526Fp);
    }

    public PagedList<T> getCurrentList() {
        return this.differ.getCurrentList();
    }

    public final AsyncPagedListDiffer<T> getDiffer$paging_runtime_release() {
        return this.differ;
    }

    public T getItem(int i) {
        return this.differ.getItem(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.differ.getItemCount();
    }

    public void onCurrentListChanged(PagedList<T> pagedList) {
    }

    public void removeLoadStateListener(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.differ.removeLoadStateListener(interfaceC0526Fp);
    }

    public void submitList(PagedList<T> pagedList) {
        this.differ.submitList(pagedList);
    }

    public final ConcatAdapter withLoadStateFooter(LoadStateAdapter<?> loadStateAdapter) {
        AbstractC4492zt.h(loadStateAdapter, HTML.Tag.FOOTER);
        addLoadStateListener(new AnonymousClass1(loadStateAdapter));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this, loadStateAdapter});
    }

    public final ConcatAdapter withLoadStateHeader(LoadStateAdapter<?> loadStateAdapter) {
        AbstractC4492zt.h(loadStateAdapter, HTML.Tag.HEADER);
        addLoadStateListener(new C17111(loadStateAdapter));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{loadStateAdapter, this});
    }

    public final ConcatAdapter withLoadStateHeaderAndFooter(LoadStateAdapter<?> loadStateAdapter, LoadStateAdapter<?> loadStateAdapter2) {
        AbstractC4492zt.h(loadStateAdapter, HTML.Tag.HEADER);
        AbstractC4492zt.h(loadStateAdapter2, HTML.Tag.FOOTER);
        addLoadStateListener(new C17121(loadStateAdapter, loadStateAdapter2));
        return new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{loadStateAdapter, this, loadStateAdapter2});
    }

    public void onCurrentListChanged(PagedList<T> pagedList, PagedList<T> pagedList2) {
    }

    public void submitList(PagedList<T> pagedList, Runnable runnable) {
        this.differ.submitList(pagedList, runnable);
    }

    public PagedListAdapter(AsyncDifferConfig<T> asyncDifferConfig) {
        AbstractC4492zt.h(asyncDifferConfig, "config");
        PagedListAdapter$listener$1 pagedListAdapter$listener$1 = new PagedListAdapter$listener$1(this);
        this.listener = pagedListAdapter$listener$1;
        AsyncPagedListDiffer<T> asyncPagedListDiffer = new AsyncPagedListDiffer<>(new AdapterListUpdateCallback(this), asyncDifferConfig);
        this.differ = asyncPagedListDiffer;
        asyncPagedListDiffer.addPagedListListener(pagedListAdapter$listener$1);
    }
}
