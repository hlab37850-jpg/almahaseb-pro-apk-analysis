package androidx.paging;

import androidx.annotation.CheckResult;
import androidx.core.app.NotificationCompat;
import com.itextpdf.text.Annotation;
import defpackage.AD;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC1805bc;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2287gb;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.E8;
import defpackage.FW;
import defpackage.GC;
import defpackage.IC;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC1009Wa;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.XS;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class PageFetcherSnapshotState<Key, Value> {
    private final List<PagingSource.LoadResult.Page<Key, Value>> _pages;
    private int _placeholdersAfter;
    private int _placeholdersBefore;
    private int appendGenerationId;
    private final InterfaceC1009Wa appendGenerationIdCh;
    private final PagingConfig config;
    private final Map<LoadType, ViewportHint> failedHintsByLoadType;
    private int initialPageIndex;
    private final List<PagingSource.LoadResult.Page<Key, Value>> pages;
    private int prependGenerationId;
    private final InterfaceC1009Wa prependGenerationIdCh;
    private MutableLoadStateCollection sourceLoadStates;

    public static final class Holder<Key, Value> {
        private final PagingConfig config;
        private final GC lock;
        private final PageFetcherSnapshotState<Key, Value> state;

        public Holder(PagingConfig pagingConfig) {
            AbstractC4492zt.h(pagingConfig, "config");
            this.config = pagingConfig;
            this.lock = IC.b(false, 1, null);
            this.state = new PageFetcherSnapshotState<>(pagingConfig, null);
        }

        private final <T> Object withLock$$forInline(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
            GC gc = this.lock;
            AbstractC0703Ks.c(0);
            gc.c(null, interfaceC0793Of);
            AbstractC0703Ks.c(1);
            try {
                return interfaceC3750qp.invoke(this.state);
            } finally {
                AbstractC0703Ks.b(1);
                gc.b(null);
                AbstractC0703Ks.a(1);
            }
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final <T> Object withLock(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            PageFetcherSnapshotState$Holder$withLock$1 pageFetcherSnapshotState$Holder$withLock$1;
            GC gc;
            Holder<Key, Value> holder;
            if (interfaceC0793Of instanceof PageFetcherSnapshotState$Holder$withLock$1) {
                pageFetcherSnapshotState$Holder$withLock$1 = (PageFetcherSnapshotState$Holder$withLock$1) interfaceC0793Of;
                int i = pageFetcherSnapshotState$Holder$withLock$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    pageFetcherSnapshotState$Holder$withLock$1.label = i - Integer.MIN_VALUE;
                } else {
                    pageFetcherSnapshotState$Holder$withLock$1 = new PageFetcherSnapshotState$Holder$withLock$1(this, interfaceC0793Of);
                }
            } else {
                pageFetcherSnapshotState$Holder$withLock$1 = new PageFetcherSnapshotState$Holder$withLock$1(this, interfaceC0793Of);
            }
            Object obj = pageFetcherSnapshotState$Holder$withLock$1.result;
            Object objD = AbstractC0378Bt.d();
            int i2 = pageFetcherSnapshotState$Holder$withLock$1.label;
            if (i2 == 0) {
                LL.b(obj);
                gc = this.lock;
                pageFetcherSnapshotState$Holder$withLock$1.L$0 = this;
                pageFetcherSnapshotState$Holder$withLock$1.L$1 = interfaceC3750qp;
                pageFetcherSnapshotState$Holder$withLock$1.L$2 = gc;
                pageFetcherSnapshotState$Holder$withLock$1.label = 1;
                if (gc.c(null, pageFetcherSnapshotState$Holder$withLock$1) == objD) {
                    return objD;
                }
                holder = this;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                GC gc2 = (GC) pageFetcherSnapshotState$Holder$withLock$1.L$2;
                InterfaceC3750qp interfaceC3750qp2 = (InterfaceC3750qp) pageFetcherSnapshotState$Holder$withLock$1.L$1;
                holder = (Holder) pageFetcherSnapshotState$Holder$withLock$1.L$0;
                LL.b(obj);
                gc = gc2;
                interfaceC3750qp = interfaceC3750qp2;
            }
            try {
                return interfaceC3750qp.invoke(holder.state);
            } finally {
                AbstractC0703Ks.b(1);
                gc.b(null);
                AbstractC0703Ks.a(1);
            }
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1", f = "PageFetcherSnapshotState.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        int label;
        final /* synthetic */ PageFetcherSnapshotState<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = pageFetcherSnapshotState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.this$0, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC0995Vm, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            ((PageFetcherSnapshotState) this.this$0).appendGenerationIdCh.mo0trySendJP2dKIU(E8.c(((PageFetcherSnapshotState) this.this$0).appendGenerationId));
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1", f = "PageFetcherSnapshotState.kt", l = {}, m = "invokeSuspend")
    public static final class C17071 extends XS implements InterfaceC0526Fp {
        int label;
        final /* synthetic */ PageFetcherSnapshotState<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17071(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = pageFetcherSnapshotState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new C17071(this.this$0, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            return ((C17071) create(interfaceC0995Vm, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            ((PageFetcherSnapshotState) this.this$0).prependGenerationIdCh.mo0trySendJP2dKIU(E8.c(((PageFetcherSnapshotState) this.this$0).prependGenerationId));
            return FW.a;
        }
    }

    public /* synthetic */ PageFetcherSnapshotState(PagingConfig pagingConfig, AbstractC0419Di abstractC0419Di) {
        this(pagingConfig);
    }

    public final InterfaceC0939Tm consumeAppendGenerationIdAsFlow() {
        return AbstractC1047Xm.B(AbstractC1047Xm.i(this.appendGenerationIdCh), new AnonymousClass1(this, null));
    }

    public final InterfaceC0939Tm consumePrependGenerationIdAsFlow() {
        return AbstractC1047Xm.B(AbstractC1047Xm.i(this.prependGenerationIdCh), new C17071(this, null));
    }

    public final PagingState<Key, Value> currentPagingState$paging_common(ViewportHint.Access access) {
        Integer numValueOf;
        List listC0 = AbstractC3240kc.C0(this.pages);
        if (access != null) {
            int placeholdersBefore$paging_common = getPlaceholdersBefore$paging_common();
            int i = -this.initialPageIndex;
            int iO = AbstractC1886cc.o(this.pages) - this.initialPageIndex;
            int pageOffset = access.getPageOffset();
            int i2 = i;
            while (i2 < pageOffset) {
                placeholdersBefore$paging_common += i2 > iO ? this.config.pageSize : this.pages.get(this.initialPageIndex + i2).getData().size();
                i2++;
            }
            int indexInPage = placeholdersBefore$paging_common + access.getIndexInPage();
            if (access.getPageOffset() < i) {
                indexInPage -= this.config.pageSize;
            }
            numValueOf = Integer.valueOf(indexInPage);
        } else {
            numValueOf = null;
        }
        return new PagingState<>(listC0, numValueOf, this.config, getPlaceholdersBefore$paging_common());
    }

    public final void drop(PageEvent.Drop<Value> drop) {
        AbstractC4492zt.h(drop, NotificationCompat.CATEGORY_EVENT);
        if (drop.getPageCount() > this.pages.size()) {
            throw new IllegalStateException(("invalid drop count. have " + this.pages.size() + " but wanted to drop " + drop.getPageCount()).toString());
        }
        this.failedHintsByLoadType.remove(drop.getLoadType());
        this.sourceLoadStates.set(drop.getLoadType(), LoadState.NotLoading.Companion.getIncomplete$paging_common());
        int i = WhenMappings.$EnumSwitchMapping$0[drop.getLoadType().ordinal()];
        if (i == 2) {
            int pageCount = drop.getPageCount();
            for (int i2 = 0; i2 < pageCount; i2++) {
                this._pages.remove(0);
            }
            this.initialPageIndex -= drop.getPageCount();
            setPlaceholdersBefore$paging_common(drop.getPlaceholdersRemaining());
            int i3 = this.prependGenerationId + 1;
            this.prependGenerationId = i3;
            this.prependGenerationIdCh.mo0trySendJP2dKIU(Integer.valueOf(i3));
            return;
        }
        if (i != 3) {
            throw new IllegalArgumentException("cannot drop " + drop.getLoadType());
        }
        int pageCount2 = drop.getPageCount();
        for (int i4 = 0; i4 < pageCount2; i4++) {
            this._pages.remove(this.pages.size() - 1);
        }
        setPlaceholdersAfter$paging_common(drop.getPlaceholdersRemaining());
        int i5 = this.appendGenerationId + 1;
        this.appendGenerationId = i5;
        this.appendGenerationIdCh.mo0trySendJP2dKIU(Integer.valueOf(i5));
    }

    public final PageEvent.Drop<Value> dropEventOrNull(LoadType loadType, ViewportHint viewportHint) {
        int size;
        AbstractC4492zt.h(loadType, "loadType");
        AbstractC4492zt.h(viewportHint, "hint");
        PageEvent.Drop<Value> drop = null;
        if (this.config.maxSize == Integer.MAX_VALUE || this.pages.size() <= 2 || getStorageCount$paging_common() <= this.config.maxSize) {
            return null;
        }
        if (loadType == LoadType.REFRESH) {
            throw new IllegalArgumentException(("Drop LoadType must be PREPEND or APPEND, but got " + loadType).toString());
        }
        int placeholdersBefore$paging_common = 0;
        int i = 0;
        int i2 = 0;
        while (i < this.pages.size() && getStorageCount$paging_common() - i2 > this.config.maxSize) {
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            if (iArr[loadType.ordinal()] == 2) {
                size = this.pages.get(i).getData().size();
            } else {
                List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
                size = list.get(AbstractC1886cc.o(list) - i).getData().size();
            }
            if (((iArr[loadType.ordinal()] == 2 ? viewportHint.getPresentedItemsBefore() : viewportHint.getPresentedItemsAfter()) - i2) - size < this.config.prefetchDistance) {
                break;
            }
            i2 += size;
            i++;
        }
        if (i != 0) {
            int[] iArr2 = WhenMappings.$EnumSwitchMapping$0;
            int iO = iArr2[loadType.ordinal()] == 2 ? -this.initialPageIndex : (AbstractC1886cc.o(this.pages) - this.initialPageIndex) - (i - 1);
            int iO2 = iArr2[loadType.ordinal()] == 2 ? (i - 1) - this.initialPageIndex : AbstractC1886cc.o(this.pages) - this.initialPageIndex;
            if (this.config.enablePlaceholders) {
                placeholdersBefore$paging_common = (loadType == LoadType.PREPEND ? getPlaceholdersBefore$paging_common() : getPlaceholdersAfter$paging_common()) + i2;
            }
            drop = new PageEvent.Drop<>(loadType, iO, iO2, placeholdersBefore$paging_common);
        }
        return drop;
    }

    public final int generationId$paging_common(LoadType loadType) {
        AbstractC4492zt.h(loadType, "loadType");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException("Cannot get loadId for loadType: REFRESH");
        }
        if (i == 2) {
            return this.prependGenerationId;
        }
        if (i == 3) {
            return this.appendGenerationId;
        }
        throw new AD();
    }

    public final Map<LoadType, ViewportHint> getFailedHintsByLoadType$paging_common() {
        return this.failedHintsByLoadType;
    }

    public final int getInitialPageIndex$paging_common() {
        return this.initialPageIndex;
    }

    public final List<PagingSource.LoadResult.Page<Key, Value>> getPages$paging_common() {
        return this.pages;
    }

    public final int getPlaceholdersAfter$paging_common() {
        if (this.config.enablePlaceholders) {
            return this._placeholdersAfter;
        }
        return 0;
    }

    public final int getPlaceholdersBefore$paging_common() {
        if (this.config.enablePlaceholders) {
            return this._placeholdersBefore;
        }
        return 0;
    }

    public final MutableLoadStateCollection getSourceLoadStates$paging_common() {
        return this.sourceLoadStates;
    }

    public final int getStorageCount$paging_common() {
        Iterator<T> it = this.pages.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((PagingSource.LoadResult.Page) it.next()).getData().size();
        }
        return size;
    }

    @CheckResult
    public final boolean insert(int i, LoadType loadType, PagingSource.LoadResult.Page<Key, Value> page) {
        AbstractC4492zt.h(loadType, "loadType");
        AbstractC4492zt.h(page, Annotation.PAGE);
        int i2 = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    if (this.pages.isEmpty()) {
                        throw new IllegalStateException("should've received an init before append");
                    }
                    if (i != this.appendGenerationId) {
                        return false;
                    }
                    this._pages.add(page);
                    setPlaceholdersAfter$paging_common(page.getItemsAfter() == Integer.MIN_VALUE ? AbstractC3871sJ.d(getPlaceholdersAfter$paging_common() - page.getData().size(), 0) : page.getItemsAfter());
                    this.failedHintsByLoadType.remove(LoadType.APPEND);
                }
            } else {
                if (this.pages.isEmpty()) {
                    throw new IllegalStateException("should've received an init before prepend");
                }
                if (i != this.prependGenerationId) {
                    return false;
                }
                this._pages.add(0, page);
                this.initialPageIndex++;
                setPlaceholdersBefore$paging_common(page.getItemsBefore() == Integer.MIN_VALUE ? AbstractC3871sJ.d(getPlaceholdersBefore$paging_common() - page.getData().size(), 0) : page.getItemsBefore());
                this.failedHintsByLoadType.remove(LoadType.PREPEND);
            }
        } else {
            if (!this.pages.isEmpty()) {
                throw new IllegalStateException("cannot receive multiple init calls");
            }
            if (i != 0) {
                throw new IllegalStateException("init loadId must be the initial value, 0");
            }
            this._pages.add(page);
            this.initialPageIndex = 0;
            setPlaceholdersAfter$paging_common(page.getItemsAfter());
            setPlaceholdersBefore$paging_common(page.getItemsBefore());
        }
        return true;
    }

    public final void setPlaceholdersAfter$paging_common(int i) {
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        this._placeholdersAfter = i;
    }

    public final void setPlaceholdersBefore$paging_common(int i) {
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        this._placeholdersBefore = i;
    }

    public final PageEvent<Value> toPageEvent$paging_common(PagingSource.LoadResult.Page<Key, Value> page, LoadType loadType) {
        AbstractC4492zt.h(page, "<this>");
        AbstractC4492zt.h(loadType, "loadType");
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i = iArr[loadType.ordinal()];
        int size = 0;
        if (i != 1) {
            if (i == 2) {
                size = 0 - this.initialPageIndex;
            } else {
                if (i != 3) {
                    throw new AD();
                }
                size = (this.pages.size() - this.initialPageIndex) - 1;
            }
        }
        List listE = AbstractC1805bc.e(new TransformablePage(size, page.getData()));
        int i2 = iArr[loadType.ordinal()];
        if (i2 == 1) {
            return PageEvent.Insert.Companion.Refresh(listE, getPlaceholdersBefore$paging_common(), getPlaceholdersAfter$paging_common(), this.sourceLoadStates.snapshot(), null);
        }
        if (i2 == 2) {
            return PageEvent.Insert.Companion.Prepend(listE, getPlaceholdersBefore$paging_common(), this.sourceLoadStates.snapshot(), null);
        }
        if (i2 == 3) {
            return PageEvent.Insert.Companion.Append(listE, getPlaceholdersAfter$paging_common(), this.sourceLoadStates.snapshot(), null);
        }
        throw new AD();
    }

    private PageFetcherSnapshotState(PagingConfig pagingConfig) {
        this.config = pagingConfig;
        ArrayList arrayList = new ArrayList();
        this._pages = arrayList;
        this.pages = arrayList;
        this.prependGenerationIdCh = AbstractC2287gb.b(-1, null, null, 6, null);
        this.appendGenerationIdCh = AbstractC2287gb.b(-1, null, null, 6, null);
        this.failedHintsByLoadType = new LinkedHashMap();
        MutableLoadStateCollection mutableLoadStateCollection = new MutableLoadStateCollection();
        mutableLoadStateCollection.set(LoadType.REFRESH, LoadState.Loading.INSTANCE);
        this.sourceLoadStates = mutableLoadStateCollection;
    }
}
