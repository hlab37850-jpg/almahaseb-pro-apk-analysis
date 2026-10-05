package androidx.paging;

import androidx.annotation.VisibleForTesting;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.paging.AsyncPagedListDiffer;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2371hc;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0730Lu;
import defpackage.InterfaceC3750qp;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class AsyncPagedListDiffer<T> {
    private final AsyncDifferConfig<T> config;
    private final CopyOnWriteArrayList<PagedListListener<T>> listeners;
    private final InterfaceC0730Lu loadStateListener;
    private final List<InterfaceC0526Fp> loadStateListeners;
    private final PagedList.LoadStateManager loadStateManager;
    private Executor mainThreadExecutor;
    private int maxScheduledGeneration;
    private PagedList<T> pagedList;
    private final PagedList.Callback pagedListCallback;
    private PagedList<T> snapshot;
    public ListUpdateCallback updateCallback;

    public static final class OnCurrentListChangedWrapper<T> implements PagedListListener<T> {
        private final InterfaceC0526Fp callback;

        public OnCurrentListChangedWrapper(InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(interfaceC0526Fp, "callback");
            this.callback = interfaceC0526Fp;
        }

        public final InterfaceC0526Fp getCallback() {
            return this.callback;
        }

        @Override // androidx.paging.AsyncPagedListDiffer.PagedListListener
        public void onCurrentListChanged(PagedList<T> pagedList, PagedList<T> pagedList2) {
            this.callback.mo13invoke(pagedList, pagedList2);
        }
    }

    public interface PagedListListener<T> {
        void onCurrentListChanged(PagedList<T> pagedList, PagedList<T> pagedList2);
    }

    /* JADX INFO: renamed from: androidx.paging.AsyncPagedListDiffer$removePagedListListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC0526Fp $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC0526Fp interfaceC0526Fp) {
            super(1);
            this.$callback = interfaceC0526Fp;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(PagedListListener<T> pagedListListener) {
            return Boolean.valueOf((pagedListListener instanceof OnCurrentListChangedWrapper) && ((OnCurrentListChangedWrapper) pagedListListener).getCallback() == this.$callback);
        }
    }

    public AsyncPagedListDiffer(RecyclerView.Adapter<?> adapter, DiffUtil.ItemCallback<T> itemCallback) {
        AbstractC4492zt.h(adapter, "adapter");
        AbstractC4492zt.h(itemCallback, "diffCallback");
        Executor mainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
        AbstractC4492zt.g(mainThreadExecutor, "getMainThreadExecutor()");
        this.mainThreadExecutor = mainThreadExecutor;
        this.listeners = new CopyOnWriteArrayList<>();
        PagedList.LoadStateManager loadStateManager = new PagedList.LoadStateManager(this) { // from class: androidx.paging.AsyncPagedListDiffer$loadStateManager$1
            final /* synthetic */ AsyncPagedListDiffer<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.paging.PagedList.LoadStateManager
            public void onStateChanged(LoadType loadType, LoadState loadState) {
                AbstractC4492zt.h(loadType, "type");
                AbstractC4492zt.h(loadState, "state");
                Iterator<T> it = this.this$0.getLoadStateListeners$paging_runtime_release().iterator();
                while (it.hasNext()) {
                    ((InterfaceC0526Fp) it.next()).mo13invoke(loadType, loadState);
                }
            }
        };
        this.loadStateManager = loadStateManager;
        this.loadStateListener = new AsyncPagedListDiffer$loadStateListener$1(loadStateManager);
        this.loadStateListeners = new CopyOnWriteArrayList();
        this.pagedListCallback = new PagedList.Callback(this) { // from class: androidx.paging.AsyncPagedListDiffer$pagedListCallback$1
            final /* synthetic */ AsyncPagedListDiffer<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.paging.PagedList.Callback
            public void onChanged(int i, int i2) {
                this.this$0.getUpdateCallback$paging_runtime_release().onChanged(i, i2, null);
            }

            @Override // androidx.paging.PagedList.Callback
            public void onInserted(int i, int i2) {
                this.this$0.getUpdateCallback$paging_runtime_release().onInserted(i, i2);
            }

            @Override // androidx.paging.PagedList.Callback
            public void onRemoved(int i, int i2) {
                this.this$0.getUpdateCallback$paging_runtime_release().onRemoved(i, i2);
            }
        };
        setUpdateCallback$paging_runtime_release(new AdapterListUpdateCallback(adapter));
        AsyncDifferConfig<T> asyncDifferConfigBuild = new AsyncDifferConfig.Builder(itemCallback).build();
        AbstractC4492zt.g(asyncDifferConfigBuild, "Builder(diffCallback).build()");
        this.config = asyncDifferConfigBuild;
    }

    public static /* synthetic */ void getConfig$paging_runtime_release$annotations() {
    }

    public static /* synthetic */ void getCurrentList$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getListeners$paging_runtime_release$annotations() {
    }

    private static /* synthetic */ void getLoadStateManager$annotations() {
    }

    public static /* synthetic */ void getMaxScheduledGeneration$paging_runtime_release$annotations() {
    }

    private static /* synthetic */ void getPagedList$annotations() {
    }

    private static /* synthetic */ void getPagedListCallback$annotations() {
    }

    private static /* synthetic */ void getSnapshot$annotations() {
    }

    private final void onCurrentListChanged(PagedList<T> pagedList, PagedList<T> pagedList2, Runnable runnable) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((PagedListListener) it.next()).onCurrentListChanged(pagedList, pagedList2);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitList$lambda$2(final PagedList pagedList, final PagedList pagedList2, final AsyncPagedListDiffer asyncPagedListDiffer, final int i, final PagedList pagedList3, final RecordingCallback recordingCallback, final Runnable runnable) {
        AbstractC4492zt.h(pagedList2, "$newSnapshot");
        AbstractC4492zt.h(asyncPagedListDiffer, "this$0");
        AbstractC4492zt.h(recordingCallback, "$recordingCallback");
        NullPaddedList<T> nullPaddedList = pagedList.getNullPaddedList();
        NullPaddedList<T> nullPaddedList2 = pagedList2.getNullPaddedList();
        DiffUtil.ItemCallback<T> diffCallback = asyncPagedListDiffer.config.getDiffCallback();
        AbstractC4492zt.g(diffCallback, "config.diffCallback");
        final NullPaddedDiffResult nullPaddedDiffResultComputeDiff = NullPaddedListDiffHelperKt.computeDiff(nullPaddedList, nullPaddedList2, diffCallback);
        asyncPagedListDiffer.mainThreadExecutor.execute(new Runnable() { // from class: U5
            @Override // java.lang.Runnable
            public final void run() {
                AsyncPagedListDiffer.submitList$lambda$2$lambda$1(this.a, i, pagedList3, pagedList2, nullPaddedDiffResultComputeDiff, recordingCallback, pagedList, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitList$lambda$2$lambda$1(AsyncPagedListDiffer asyncPagedListDiffer, int i, PagedList pagedList, PagedList pagedList2, NullPaddedDiffResult nullPaddedDiffResult, RecordingCallback recordingCallback, PagedList pagedList3, Runnable runnable) {
        AbstractC4492zt.h(asyncPagedListDiffer, "this$0");
        AbstractC4492zt.h(pagedList2, "$newSnapshot");
        AbstractC4492zt.h(nullPaddedDiffResult, "$result");
        AbstractC4492zt.h(recordingCallback, "$recordingCallback");
        if (asyncPagedListDiffer.maxScheduledGeneration == i) {
            asyncPagedListDiffer.latchPagedList$paging_runtime_release(pagedList, pagedList2, nullPaddedDiffResult, recordingCallback, pagedList3.lastLoad(), runnable);
        }
    }

    public void addLoadStateListener(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        PagedList<T> pagedList = this.pagedList;
        if (pagedList != null) {
            pagedList.addWeakLoadStateListener(interfaceC0526Fp);
        } else {
            this.loadStateManager.dispatchCurrentLoadState(interfaceC0526Fp);
        }
        this.loadStateListeners.add(interfaceC0526Fp);
    }

    public void addPagedListListener(PagedListListener<T> pagedListListener) {
        AbstractC4492zt.h(pagedListListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.add(pagedListListener);
    }

    public final AsyncDifferConfig<T> getConfig$paging_runtime_release() {
        return this.config;
    }

    public PagedList<T> getCurrentList() {
        PagedList<T> pagedList = this.snapshot;
        return pagedList == null ? this.pagedList : pagedList;
    }

    public T getItem(int i) {
        PagedList<T> pagedList = this.snapshot;
        PagedList<T> pagedList2 = this.pagedList;
        if (pagedList != null) {
            return pagedList.get(i);
        }
        if (pagedList2 == null) {
            throw new IndexOutOfBoundsException("Item count is zero, getItem() call is invalid");
        }
        pagedList2.loadAround(i);
        return pagedList2.get(i);
    }

    public int getItemCount() {
        PagedList<T> currentList = getCurrentList();
        if (currentList != null) {
            return currentList.size();
        }
        return 0;
    }

    public final CopyOnWriteArrayList<PagedListListener<T>> getListeners$paging_runtime_release() {
        return this.listeners;
    }

    public final List<InterfaceC0526Fp> getLoadStateListeners$paging_runtime_release() {
        return this.loadStateListeners;
    }

    public final Executor getMainThreadExecutor$paging_runtime_release() {
        return this.mainThreadExecutor;
    }

    public final int getMaxScheduledGeneration$paging_runtime_release() {
        return this.maxScheduledGeneration;
    }

    public final ListUpdateCallback getUpdateCallback$paging_runtime_release() {
        ListUpdateCallback listUpdateCallback = this.updateCallback;
        if (listUpdateCallback != null) {
            return listUpdateCallback;
        }
        AbstractC4492zt.x("updateCallback");
        return null;
    }

    public final void latchPagedList$paging_runtime_release(PagedList<T> pagedList, PagedList<T> pagedList2, NullPaddedDiffResult nullPaddedDiffResult, RecordingCallback recordingCallback, int i, Runnable runnable) {
        AbstractC4492zt.h(pagedList, "newList");
        AbstractC4492zt.h(pagedList2, "diffSnapshot");
        AbstractC4492zt.h(nullPaddedDiffResult, "diffResult");
        AbstractC4492zt.h(recordingCallback, "recordingCallback");
        PagedList<T> pagedList3 = this.snapshot;
        if (pagedList3 == null || this.pagedList != null) {
            throw new IllegalStateException("must be in snapshot state to apply diff");
        }
        this.pagedList = pagedList;
        pagedList.addWeakLoadStateListener((InterfaceC0526Fp) this.loadStateListener);
        this.snapshot = null;
        NullPaddedListDiffHelperKt.dispatchDiff(pagedList3.getNullPaddedList(), getUpdateCallback$paging_runtime_release(), pagedList2.getNullPaddedList(), nullPaddedDiffResult);
        recordingCallback.dispatchRecordingTo(this.pagedListCallback);
        pagedList.addWeakCallback(this.pagedListCallback);
        if (!pagedList.isEmpty()) {
            pagedList.loadAround(AbstractC3871sJ.l(NullPaddedListDiffHelperKt.transformAnchorIndex(pagedList3.getNullPaddedList(), nullPaddedDiffResult, pagedList2.getNullPaddedList(), i), 0, pagedList.size() - 1));
        }
        onCurrentListChanged(pagedList3, this.pagedList, runnable);
    }

    public void removeLoadStateListener(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.loadStateListeners.remove(interfaceC0526Fp);
        PagedList<T> pagedList = this.pagedList;
        if (pagedList != null) {
            pagedList.removeWeakLoadStateListener(interfaceC0526Fp);
        }
    }

    public void removePagedListListener(PagedListListener<T> pagedListListener) {
        AbstractC4492zt.h(pagedListListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.remove(pagedListListener);
    }

    public final void setMainThreadExecutor$paging_runtime_release(Executor executor) {
        AbstractC4492zt.h(executor, "<set-?>");
        this.mainThreadExecutor = executor;
    }

    public final void setMaxScheduledGeneration$paging_runtime_release(int i) {
        this.maxScheduledGeneration = i;
    }

    public final void setUpdateCallback$paging_runtime_release(ListUpdateCallback listUpdateCallback) {
        AbstractC4492zt.h(listUpdateCallback, "<set-?>");
        this.updateCallback = listUpdateCallback;
    }

    public void submitList(PagedList<T> pagedList) {
        submitList(pagedList, null);
    }

    public final void addPagedListListener(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, "callback");
        this.listeners.add(new OnCurrentListChangedWrapper(interfaceC0526Fp));
    }

    public final void removePagedListListener(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, "callback");
        AbstractC2371hc.M(this.listeners, new AnonymousClass1(interfaceC0526Fp));
    }

    public void submitList(final PagedList<T> pagedList, final Runnable runnable) {
        final int i = this.maxScheduledGeneration + 1;
        this.maxScheduledGeneration = i;
        PagedList<T> pagedList2 = this.pagedList;
        if (pagedList == pagedList2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (pagedList2 != null && (pagedList instanceof InitialPagedList)) {
            pagedList2.removeWeakCallback(this.pagedListCallback);
            pagedList2.removeWeakLoadStateListener((InterfaceC0526Fp) this.loadStateListener);
            this.loadStateManager.setState(LoadType.REFRESH, LoadState.Loading.INSTANCE);
            this.loadStateManager.setState(LoadType.PREPEND, new LoadState.NotLoading(false));
            this.loadStateManager.setState(LoadType.APPEND, new LoadState.NotLoading(false));
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        PagedList<T> currentList = getCurrentList();
        if (pagedList == null) {
            int itemCount = getItemCount();
            if (pagedList2 != null) {
                pagedList2.removeWeakCallback(this.pagedListCallback);
                pagedList2.removeWeakLoadStateListener((InterfaceC0526Fp) this.loadStateListener);
                this.pagedList = null;
            } else if (this.snapshot != null) {
                this.snapshot = null;
            }
            getUpdateCallback$paging_runtime_release().onRemoved(0, itemCount);
            onCurrentListChanged(currentList, null, runnable);
            return;
        }
        if (getCurrentList() == null) {
            this.pagedList = pagedList;
            pagedList.addWeakLoadStateListener((InterfaceC0526Fp) this.loadStateListener);
            pagedList.addWeakCallback(this.pagedListCallback);
            getUpdateCallback$paging_runtime_release().onInserted(0, pagedList.size());
            onCurrentListChanged(null, pagedList, runnable);
            return;
        }
        PagedList<T> pagedList3 = this.pagedList;
        if (pagedList3 != null) {
            pagedList3.removeWeakCallback(this.pagedListCallback);
            pagedList3.removeWeakLoadStateListener((InterfaceC0526Fp) this.loadStateListener);
            List<T> listSnapshot = pagedList3.snapshot();
            AbstractC4492zt.f(listSnapshot, "null cannot be cast to non-null type androidx.paging.PagedList<T of androidx.paging.AsyncPagedListDiffer.submitList$lambda$0>");
            this.snapshot = (PagedList) listSnapshot;
            this.pagedList = null;
        }
        final PagedList<T> pagedList4 = this.snapshot;
        if (pagedList4 == null || this.pagedList != null) {
            throw new IllegalStateException("must be in snapshot state to diff");
        }
        List<T> listSnapshot2 = pagedList.snapshot();
        AbstractC4492zt.f(listSnapshot2, "null cannot be cast to non-null type androidx.paging.PagedList<T of androidx.paging.AsyncPagedListDiffer>");
        final PagedList pagedList5 = (PagedList) listSnapshot2;
        final RecordingCallback recordingCallback = new RecordingCallback();
        pagedList.addWeakCallback(recordingCallback);
        this.config.getBackgroundThreadExecutor().execute(new Runnable() { // from class: V5
            @Override // java.lang.Runnable
            public final void run() {
                AsyncPagedListDiffer.submitList$lambda$2(pagedList4, pagedList5, this, i, pagedList, recordingCallback, runnable);
            }
        });
    }

    public AsyncPagedListDiffer(ListUpdateCallback listUpdateCallback, AsyncDifferConfig<T> asyncDifferConfig) {
        AbstractC4492zt.h(listUpdateCallback, "listUpdateCallback");
        AbstractC4492zt.h(asyncDifferConfig, "config");
        Executor mainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
        AbstractC4492zt.g(mainThreadExecutor, "getMainThreadExecutor()");
        this.mainThreadExecutor = mainThreadExecutor;
        this.listeners = new CopyOnWriteArrayList<>();
        PagedList.LoadStateManager loadStateManager = new PagedList.LoadStateManager(this) { // from class: androidx.paging.AsyncPagedListDiffer$loadStateManager$1
            final /* synthetic */ AsyncPagedListDiffer<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.paging.PagedList.LoadStateManager
            public void onStateChanged(LoadType loadType, LoadState loadState) {
                AbstractC4492zt.h(loadType, "type");
                AbstractC4492zt.h(loadState, "state");
                Iterator<T> it = this.this$0.getLoadStateListeners$paging_runtime_release().iterator();
                while (it.hasNext()) {
                    ((InterfaceC0526Fp) it.next()).mo13invoke(loadType, loadState);
                }
            }
        };
        this.loadStateManager = loadStateManager;
        this.loadStateListener = new AsyncPagedListDiffer$loadStateListener$1(loadStateManager);
        this.loadStateListeners = new CopyOnWriteArrayList();
        this.pagedListCallback = new PagedList.Callback(this) { // from class: androidx.paging.AsyncPagedListDiffer$pagedListCallback$1
            final /* synthetic */ AsyncPagedListDiffer<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.paging.PagedList.Callback
            public void onChanged(int i, int i2) {
                this.this$0.getUpdateCallback$paging_runtime_release().onChanged(i, i2, null);
            }

            @Override // androidx.paging.PagedList.Callback
            public void onInserted(int i, int i2) {
                this.this$0.getUpdateCallback$paging_runtime_release().onInserted(i, i2);
            }

            @Override // androidx.paging.PagedList.Callback
            public void onRemoved(int i, int i2) {
                this.this$0.getUpdateCallback$paging_runtime_release().onRemoved(i, i2);
            }
        };
        setUpdateCallback$paging_runtime_release(listUpdateCallback);
        this.config = asyncDifferConfig;
    }
}
