package androidx.paging;

import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC1224aP;
import defpackage.AbstractC1805bc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C0368Bj;
import defpackage.CC;
import defpackage.CR;
import defpackage.FW;
import defpackage.I8;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.KJ;
import defpackage.LL;
import defpackage.M8;
import defpackage.XS;
import defpackage.ZZ;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class PagingDataDiffer<T> {
    private final CC _onPagesUpdatedFlow;
    private final SingleRunner collectFromRunner;
    private final MutableCombinedLoadStateCollection combinedLoadStatesCollection;
    private final DifferCallback differCallback;
    private HintReceiver hintReceiver;
    private volatile int lastAccessedIndex;
    private volatile boolean lastAccessedIndexUnfulfilled;
    private final CR loadStateFlow;
    private final InterfaceC0988Vf mainContext;
    private final CopyOnWriteArrayList<InterfaceC3588op> onPagesUpdatedListeners;
    private PagePresenter<T> presenter;
    private final PagingDataDiffer$processPageEventCallback$1 processPageEventCallback;
    private UiReceiver uiReceiver;

    /* JADX INFO: renamed from: androidx.paging.PagingDataDiffer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ PagingDataDiffer<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PagingDataDiffer<T> pagingDataDiffer) {
            super(0);
            this.this$0 = pagingDataDiffer;
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m5436invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m5436invoke() {
            ((PagingDataDiffer) this.this$0)._onPagesUpdatedFlow.f(FW.a);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagingDataDiffer$collectFrom$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.PagingDataDiffer$collectFrom$2", f = "PagingDataDiffer.kt", l = {ShapeTypes.FLOW_CHART_PREPARATION}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC3750qp {
        final /* synthetic */ PagingData<T> $pagingData;
        int label;
        final /* synthetic */ PagingDataDiffer<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(PagingDataDiffer<T> pagingDataDiffer, PagingData<T> pagingData, InterfaceC0793Of interfaceC0793Of) {
            super(1, interfaceC0793Of);
            this.this$0 = pagingDataDiffer;
            this.$pagingData = pagingData;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(this.this$0, this.$pagingData, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                ((PagingDataDiffer) this.this$0).uiReceiver = this.$pagingData.getUiReceiver$paging_common();
                InterfaceC0939Tm flow$paging_common = this.$pagingData.getFlow$paging_common();
                final PagingDataDiffer<T> pagingDataDiffer = this.this$0;
                final PagingData<T> pagingData = this.$pagingData;
                InterfaceC0995Vm interfaceC0995Vm = new InterfaceC0995Vm() { // from class: androidx.paging.PagingDataDiffer.collectFrom.2.1

                    /* JADX INFO: renamed from: androidx.paging.PagingDataDiffer$collectFrom$2$1$2, reason: invalid class name and collision with other inner class name */
                    @InterfaceC3252ki(c = "androidx.paging.PagingDataDiffer$collectFrom$2$1$2", f = "PagingDataDiffer.kt", l = {ShapeTypes.FLOW_CHART_ALTERNATE_PROCESS, ShapeTypes.ACTION_BUTTON_RETURN, ShapeTypes.CHART_STAR}, m = "invokeSuspend")
                    public static final class C01552 extends XS implements InterfaceC0526Fp {
                        final /* synthetic */ PageEvent<T> $event;
                        final /* synthetic */ PagingData<T> $pagingData;
                        int label;
                        final /* synthetic */ PagingDataDiffer<T> this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C01552(PageEvent<T> pageEvent, PagingDataDiffer<T> pagingDataDiffer, PagingData<T> pagingData, InterfaceC0793Of interfaceC0793Of) {
                            super(2, interfaceC0793Of);
                            this.$event = pageEvent;
                            this.this$0 = pagingDataDiffer;
                            this.$pagingData = pagingData;
                        }

                        @Override // defpackage.AbstractC2171f7
                        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                            return new C01552(this.$event, this.this$0, this.$pagingData, interfaceC0793Of);
                        }

                        @Override // defpackage.InterfaceC0526Fp
                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                            return ((C01552) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                        }

                        /* JADX WARN: Code duplicated, block: B:35:0x00ec  */
                        /* JADX WARN: Code duplicated, block: B:38:0x00f7  */
                        /* JADX WARN: Code duplicated, block: B:40:0x0109  */
                        /* JADX WARN: Code duplicated, block: B:41:0x010e  */
                        /* JADX WARN: Code duplicated, block: B:43:0x0111  */
                        /* JADX WARN: Code duplicated, block: B:57:0x0159  */
                        /* JADX WARN: Code duplicated, block: B:60:0x0163  */
                        /* JADX WARN: Code duplicated, block: B:64:0x0176  */
                        /* JADX WARN: Code duplicated, block: B:65:0x017c  */
                        /* JADX WARN: Code duplicated, block: B:68:0x0186 A[DONT_INVERT] */
                        /* JADX WARN: Code duplicated, block: B:69:0x0188  */
                        /* JADX WARN: Code duplicated, block: B:75:0x01be  */
                        /* JADX WARN: Code duplicated, block: B:77:0x01c6  */
                        /* JADX WARN: Code duplicated, block: B:78:0x01da  */
                        /* JADX WARN: Code duplicated, block: B:93:0x0173 A[SYNTHETIC] */
                        /* JADX WARN: Code duplicated, block: B:94:? A[LOOP:0: B:58:0x015d->B:94:?, LOOP_END, SYNTHETIC] */
                        @Override // defpackage.AbstractC2171f7
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            CombinedLoadStates combinedLoadStates;
                            LoadStates source;
                            boolean z;
                            List<TransformablePage<T>> pages;
                            Iterator<T> it;
                            HintReceiver hintReceiver;
                            Object objD = AbstractC0378Bt.d();
                            int i = this.label;
                            boolean z2 = true;
                            if (i == 0) {
                                LL.b(obj);
                                PageEvent<T> pageEvent = this.$event;
                                if ((pageEvent instanceof PageEvent.Insert) && ((PageEvent.Insert) pageEvent).getLoadType() == LoadType.REFRESH) {
                                    PagingDataDiffer<T> pagingDataDiffer = this.this$0;
                                    List<TransformablePage<T>> pages2 = ((PageEvent.Insert) this.$event).getPages();
                                    int placeholdersBefore = ((PageEvent.Insert) this.$event).getPlaceholdersBefore();
                                    int placeholdersAfter = ((PageEvent.Insert) this.$event).getPlaceholdersAfter();
                                    LoadStates sourceLoadStates = ((PageEvent.Insert) this.$event).getSourceLoadStates();
                                    LoadStates mediatorLoadStates = ((PageEvent.Insert) this.$event).getMediatorLoadStates();
                                    HintReceiver hintReceiver$paging_common = this.$pagingData.getHintReceiver$paging_common();
                                    this.label = 1;
                                    if (pagingDataDiffer.presentNewList(pages2, placeholdersBefore, placeholdersAfter, true, sourceLoadStates, mediatorLoadStates, hintReceiver$paging_common, this) == objD) {
                                        return objD;
                                    }
                                } else if (this.$event instanceof PageEvent.StaticList) {
                                    PagingDataDiffer<T> pagingDataDiffer2 = this.this$0;
                                    List listE = AbstractC1805bc.e(new TransformablePage(0, ((PageEvent.StaticList) this.$event).getData()));
                                    boolean z3 = (((PageEvent.StaticList) this.$event).getSourceLoadStates() == null && ((PageEvent.StaticList) this.$event).getMediatorLoadStates() == null) ? false : true;
                                    LoadStates sourceLoadStates2 = ((PageEvent.StaticList) this.$event).getSourceLoadStates();
                                    LoadStates mediatorLoadStates2 = ((PageEvent.StaticList) this.$event).getMediatorLoadStates();
                                    HintReceiver hintReceiver$paging_common2 = this.$pagingData.getHintReceiver$paging_common();
                                    this.label = 2;
                                    if (pagingDataDiffer2.presentNewList(listE, 0, 0, z3, sourceLoadStates2, mediatorLoadStates2, hintReceiver$paging_common2, this) == objD) {
                                        return objD;
                                    }
                                } else {
                                    if (this.this$0.postEvents()) {
                                        this.label = 3;
                                        if (ZZ.a(this) == objD) {
                                            return objD;
                                        }
                                    }
                                    ((PagingDataDiffer) this.this$0).presenter.processEvent(this.$event, ((PagingDataDiffer) this.this$0).processPageEventCallback);
                                    if (this.$event instanceof PageEvent.Drop) {
                                        ((PagingDataDiffer) this.this$0).lastAccessedIndexUnfulfilled = false;
                                    }
                                    if (this.$event instanceof PageEvent.Insert) {
                                        combinedLoadStates = (CombinedLoadStates) ((PagingDataDiffer) this.this$0).combinedLoadStatesCollection.getStateFlow().getValue();
                                        if (combinedLoadStates != null) {
                                            source = combinedLoadStates.getSource();
                                        } else {
                                            source = null;
                                        }
                                        if (source != null) {
                                            throw new IllegalStateException("PagingDataDiffer.combinedLoadStatesCollection.stateFlow shouldnot hold null CombinedLoadStates after Insert event.");
                                        }
                                        if (((PageEvent.Insert) this.$event).getLoadType() == LoadType.PREPEND) {
                                        }
                                        pages = ((PageEvent.Insert) this.$event).getPages();
                                        if (pages instanceof Collection) {
                                            it = pages.iterator();
                                            while (it.hasNext()) {
                                                if (!((TransformablePage) it.next()).getData().isEmpty()) {
                                                    z2 = false;
                                                    break;
                                                }
                                            }
                                        } else {
                                            it = pages.iterator();
                                            while (it.hasNext()) {
                                                if (!((TransformablePage) it.next()).getData().isEmpty()) {
                                                    z2 = false;
                                                    break;
                                                }
                                            }
                                        }
                                        if (!z) {
                                            ((PagingDataDiffer) this.this$0).lastAccessedIndexUnfulfilled = false;
                                        } else if (((PagingDataDiffer) this.this$0).lastAccessedIndexUnfulfilled) {
                                            if (z2) {
                                                hintReceiver = ((PagingDataDiffer) this.this$0).hintReceiver;
                                                if (hintReceiver != null) {
                                                    hintReceiver.accessHint(((PagingDataDiffer) this.this$0).presenter.accessHintForPresenterIndex(((PagingDataDiffer) this.this$0).lastAccessedIndex));
                                                }
                                            } else {
                                                hintReceiver = ((PagingDataDiffer) this.this$0).hintReceiver;
                                                if (hintReceiver != null) {
                                                    hintReceiver.accessHint(((PagingDataDiffer) this.this$0).presenter.accessHintForPresenterIndex(((PagingDataDiffer) this.this$0).lastAccessedIndex));
                                                }
                                            }
                                        } else if (z2) {
                                            hintReceiver = ((PagingDataDiffer) this.this$0).hintReceiver;
                                            if (hintReceiver != null) {
                                                hintReceiver.accessHint(((PagingDataDiffer) this.this$0).presenter.accessHintForPresenterIndex(((PagingDataDiffer) this.this$0).lastAccessedIndex));
                                            }
                                        } else {
                                            hintReceiver = ((PagingDataDiffer) this.this$0).hintReceiver;
                                            if (hintReceiver != null) {
                                                hintReceiver.accessHint(((PagingDataDiffer) this.this$0).presenter.accessHintForPresenterIndex(((PagingDataDiffer) this.this$0).lastAccessedIndex));
                                            }
                                        }
                                    }
                                }
                            } else if (i == 1 || i == 2) {
                                LL.b(obj);
                            } else {
                                if (i != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                LL.b(obj);
                                ((PagingDataDiffer) this.this$0).presenter.processEvent(this.$event, ((PagingDataDiffer) this.this$0).processPageEventCallback);
                                if (this.$event instanceof PageEvent.Drop) {
                                    ((PagingDataDiffer) this.this$0).lastAccessedIndexUnfulfilled = false;
                                }
                                if (this.$event instanceof PageEvent.Insert) {
                                    combinedLoadStates = (CombinedLoadStates) ((PagingDataDiffer) this.this$0).combinedLoadStatesCollection.getStateFlow().getValue();
                                    if (combinedLoadStates != null) {
                                        source = combinedLoadStates.getSource();
                                    } else {
                                        source = null;
                                    }
                                    if (source != null) {
                                        throw new IllegalStateException("PagingDataDiffer.combinedLoadStatesCollection.stateFlow shouldnot hold null CombinedLoadStates after Insert event.");
                                    }
                                    z = (((PageEvent.Insert) this.$event).getLoadType() == LoadType.PREPEND || !source.getPrepend().getEndOfPaginationReached()) && !(((PageEvent.Insert) this.$event).getLoadType() == LoadType.APPEND && source.getAppend().getEndOfPaginationReached());
                                    pages = ((PageEvent.Insert) this.$event).getPages();
                                    if ((pages instanceof Collection) || !pages.isEmpty()) {
                                        it = pages.iterator();
                                        while (it.hasNext()) {
                                            if (!((TransformablePage) it.next()).getData().isEmpty()) {
                                                z2 = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        ((PagingDataDiffer) this.this$0).lastAccessedIndexUnfulfilled = false;
                                    } else if (((PagingDataDiffer) this.this$0).lastAccessedIndexUnfulfilled || z2) {
                                        if (z2 || ((PagingDataDiffer) this.this$0).lastAccessedIndex < ((PagingDataDiffer) this.this$0).presenter.getPlaceholdersBefore() || ((PagingDataDiffer) this.this$0).lastAccessedIndex > ((PagingDataDiffer) this.this$0).presenter.getPlaceholdersBefore() + ((PagingDataDiffer) this.this$0).presenter.getStorageCount()) {
                                            hintReceiver = ((PagingDataDiffer) this.this$0).hintReceiver;
                                            if (hintReceiver != null) {
                                                hintReceiver.accessHint(((PagingDataDiffer) this.this$0).presenter.accessHintForPresenterIndex(((PagingDataDiffer) this.this$0).lastAccessedIndex));
                                            }
                                        } else {
                                            ((PagingDataDiffer) this.this$0).lastAccessedIndexUnfulfilled = false;
                                        }
                                    }
                                }
                            }
                            PageEvent<T> pageEvent2 = this.$event;
                            if ((pageEvent2 instanceof PageEvent.Insert) || (pageEvent2 instanceof PageEvent.Drop) || (pageEvent2 instanceof PageEvent.StaticList)) {
                                Iterator<T> it2 = ((PagingDataDiffer) this.this$0).onPagesUpdatedListeners.iterator();
                                while (it2.hasNext()) {
                                    ((InterfaceC3588op) it2.next()).invoke();
                                }
                            }
                            return FW.a;
                        }
                    }

                    @Override // defpackage.InterfaceC0995Vm
                    public final Object emit(PageEvent<T> pageEvent, InterfaceC0793Of interfaceC0793Of) {
                        Logger logger = LoggerKt.getLOGGER();
                        if (logger != null && logger.isLoggable(2)) {
                            logger.log(2, "Collected " + pageEvent, null);
                        }
                        Object objG = M8.g(((PagingDataDiffer) pagingDataDiffer).mainContext, new C01552(pageEvent, pagingDataDiffer, pagingData, null), interfaceC0793Of);
                        return objG == AbstractC0378Bt.d() ? objG : FW.a;
                    }
                };
                this.label = 1;
                if (flow$paging_common.collect(interfaceC0995Vm, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagingDataDiffer$presentNewList$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.PagingDataDiffer", f = "PagingDataDiffer.kt", l = {460}, m = "presentNewList")
    public static final class C17161 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PagingDataDiffer<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17161(PagingDataDiffer<T> pagingDataDiffer, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = pagingDataDiffer;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.presentNewList(null, 0, 0, false, null, null, null, this);
        }
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.paging.PagingDataDiffer$processPageEventCallback$1] */
    public PagingDataDiffer(DifferCallback differCallback, InterfaceC0988Vf interfaceC0988Vf, PagingData<T> pagingData) {
        PageEvent.Insert<T> insertCachedEvent$paging_common;
        AbstractC4492zt.h(differCallback, "differCallback");
        AbstractC4492zt.h(interfaceC0988Vf, "mainContext");
        this.differCallback = differCallback;
        this.mainContext = interfaceC0988Vf;
        AbstractC0419Di abstractC0419Di = null;
        this.presenter = PagePresenter.Companion.initial$paging_common(pagingData != null ? pagingData.cachedEvent$paging_common() : null);
        MutableCombinedLoadStateCollection mutableCombinedLoadStateCollection = new MutableCombinedLoadStateCollection();
        if (pagingData != null && (insertCachedEvent$paging_common = pagingData.cachedEvent$paging_common()) != null) {
            mutableCombinedLoadStateCollection.set(insertCachedEvent$paging_common.getSourceLoadStates(), insertCachedEvent$paging_common.getMediatorLoadStates());
        }
        this.combinedLoadStatesCollection = mutableCombinedLoadStateCollection;
        this.onPagesUpdatedListeners = new CopyOnWriteArrayList<>();
        this.collectFromRunner = new SingleRunner(false, 1, abstractC0419Di);
        this.processPageEventCallback = new PagePresenter.ProcessPageEventCallback(this) { // from class: androidx.paging.PagingDataDiffer$processPageEventCallback$1
            final /* synthetic */ PagingDataDiffer<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.paging.PagePresenter.ProcessPageEventCallback
            public void onChanged(int i, int i2) {
                ((PagingDataDiffer) this.this$0).differCallback.onChanged(i, i2);
            }

            @Override // androidx.paging.PagePresenter.ProcessPageEventCallback
            public void onInserted(int i, int i2) {
                ((PagingDataDiffer) this.this$0).differCallback.onInserted(i, i2);
            }

            @Override // androidx.paging.PagePresenter.ProcessPageEventCallback
            public void onRemoved(int i, int i2) {
                ((PagingDataDiffer) this.this$0).differCallback.onRemoved(i, i2);
            }

            @Override // androidx.paging.PagePresenter.ProcessPageEventCallback
            public void onStateUpdate(LoadStates loadStates, LoadStates loadStates2) {
                AbstractC4492zt.h(loadStates, DublinCoreProperties.SOURCE);
                this.this$0.dispatchLoadStates$paging_common(loadStates, loadStates2);
            }

            @Override // androidx.paging.PagePresenter.ProcessPageEventCallback
            public void onStateUpdate(LoadType loadType, boolean z, LoadState loadState) {
                AbstractC4492zt.h(loadType, "loadType");
                AbstractC4492zt.h(loadState, "loadState");
                ((PagingDataDiffer) this.this$0).combinedLoadStatesCollection.set(loadType, z, loadState);
            }
        };
        this.loadStateFlow = mutableCombinedLoadStateCollection.getStateFlow();
        this._onPagesUpdatedFlow = AbstractC1224aP.a(0, 64, I8.DROP_OLDEST);
        addOnPagesUpdatedListener(new AnonymousClass1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    public final Object presentNewList(List<TransformablePage<T>> list, int i, int i2, boolean z, LoadStates loadStates, LoadStates loadStates2, HintReceiver hintReceiver, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C17161 c17161;
        LoadStates loadStates3;
        PagingDataDiffer pagingDataDiffer;
        PagePresenter pagePresenter;
        KJ kj;
        boolean z2 = z;
        LoadStates loadStates4 = loadStates;
        if (interfaceC0793Of instanceof C17161) {
            c17161 = (C17161) interfaceC0793Of;
            int i3 = c17161.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c17161.label = i3 - Integer.MIN_VALUE;
            } else {
                c17161 = new C17161(this, interfaceC0793Of);
            }
        } else {
            c17161 = new C17161(this, interfaceC0793Of);
        }
        C17161 c17162 = c17161;
        Object objPresentNewList = c17162.result;
        Object objD = AbstractC0378Bt.d();
        int i4 = c17162.label;
        if (i4 == 0) {
            LL.b(objPresentNewList);
            if (z2 && loadStates4 == null) {
                throw new IllegalArgumentException("Cannot dispatch LoadStates in PagingDataDiffer without source LoadStates set.");
            }
            this.lastAccessedIndexUnfulfilled = false;
            PagePresenter pagePresenter2 = new PagePresenter(list, i, i2);
            KJ kj2 = new KJ();
            NullPaddedList<T> nullPaddedList = this.presenter;
            int i5 = this.lastAccessedIndex;
            PagingDataDiffer$presentNewList$transformedLastAccessedIndex$1 pagingDataDiffer$presentNewList$transformedLastAccessedIndex$1 = new PagingDataDiffer$presentNewList$transformedLastAccessedIndex$1(this, pagePresenter2, kj2, hintReceiver, loadStates2, list, i, i2, loadStates);
            c17162.L$0 = this;
            c17162.L$1 = loadStates4;
            c17162.L$2 = loadStates2;
            c17162.L$3 = pagePresenter2;
            c17162.L$4 = kj2;
            c17162.Z$0 = z2;
            c17162.label = 1;
            objPresentNewList = presentNewList(nullPaddedList, pagePresenter2, i5, pagingDataDiffer$presentNewList$transformedLastAccessedIndex$1, c17162);
            if (objPresentNewList == objD) {
                return objD;
            }
            loadStates3 = loadStates2;
            pagingDataDiffer = this;
            pagePresenter = pagePresenter2;
            kj = kj2;
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z3 = c17162.Z$0;
            kj = (KJ) c17162.L$4;
            pagePresenter = (PagePresenter) c17162.L$3;
            loadStates3 = (LoadStates) c17162.L$2;
            LoadStates loadStates5 = (LoadStates) c17162.L$1;
            PagingDataDiffer pagingDataDiffer2 = (PagingDataDiffer) c17162.L$0;
            LL.b(objPresentNewList);
            z2 = z3;
            loadStates4 = loadStates5;
            pagingDataDiffer = pagingDataDiffer2;
        }
        Integer num = (Integer) objPresentNewList;
        if (!kj.a) {
            throw new IllegalStateException("Missing call to onListPresentable after new list was presented. If you are seeing\n this exception, it is generally an indication of an issue with Paging.\n Please file a bug so we can fix it at:\n https://issuetracker.google.com/issues/new?component=413106");
        }
        if (z2) {
            AbstractC4492zt.e(loadStates4);
            pagingDataDiffer.dispatchLoadStates$paging_common(loadStates4, loadStates3);
        }
        if (num == null) {
            HintReceiver hintReceiver2 = pagingDataDiffer.hintReceiver;
            if (hintReceiver2 != null) {
                hintReceiver2.accessHint(pagePresenter.initializeHint());
            }
        } else {
            pagingDataDiffer.lastAccessedIndex = num.intValue();
            HintReceiver hintReceiver3 = pagingDataDiffer.hintReceiver;
            if (hintReceiver3 != null) {
                hintReceiver3.accessHint(pagePresenter.accessHintForPresenterIndex(num.intValue()));
            }
        }
        return FW.a;
    }

    public final void addLoadStateListener(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.combinedLoadStatesCollection.addListener(interfaceC3750qp);
    }

    public final void addOnPagesUpdatedListener(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onPagesUpdatedListeners.add(interfaceC3588op);
    }

    public final Object collectFrom(PagingData<T> pagingData, InterfaceC0793Of interfaceC0793Of) {
        Object objRunInIsolation$default = SingleRunner.runInIsolation$default(this.collectFromRunner, 0, new AnonymousClass2(this, pagingData, null), interfaceC0793Of, 1, null);
        return objRunInIsolation$default == AbstractC0378Bt.d() ? objRunInIsolation$default : FW.a;
    }

    public final void dispatchLoadStates$paging_common(LoadStates loadStates, LoadStates loadStates2) {
        AbstractC4492zt.h(loadStates, DublinCoreProperties.SOURCE);
        this.combinedLoadStatesCollection.set(loadStates, loadStates2);
    }

    @MainThread
    public final T get(@IntRange(from = 0) int i) {
        this.lastAccessedIndexUnfulfilled = true;
        this.lastAccessedIndex = i;
        Logger logger = LoggerKt.getLOGGER();
        if (logger != null && logger.isLoggable(2)) {
            logger.log(2, "Accessing item index[" + i + ']', null);
        }
        HintReceiver hintReceiver = this.hintReceiver;
        if (hintReceiver != null) {
            hintReceiver.accessHint(this.presenter.accessHintForPresenterIndex(i));
        }
        return this.presenter.get(i);
    }

    public final CR getLoadStateFlow() {
        return this.loadStateFlow;
    }

    public final InterfaceC0939Tm getOnPagesUpdatedFlow() {
        return AbstractC1047Xm.a(this._onPagesUpdatedFlow);
    }

    public final int getSize() {
        return this.presenter.getSize();
    }

    @MainThread
    public final T peek(@IntRange(from = 0) int i) {
        return this.presenter.get(i);
    }

    public boolean postEvents() {
        return false;
    }

    public abstract Object presentNewList(NullPaddedList<T> nullPaddedList, NullPaddedList<T> nullPaddedList2, int i, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of);

    public final void refresh() {
        Logger logger = LoggerKt.getLOGGER();
        if (logger != null && logger.isLoggable(3)) {
            logger.log(3, "Refresh signal received", null);
        }
        UiReceiver uiReceiver = this.uiReceiver;
        if (uiReceiver != null) {
            uiReceiver.refresh();
        }
    }

    public final void removeLoadStateListener(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.combinedLoadStatesCollection.removeListener(interfaceC3750qp);
    }

    public final void removeOnPagesUpdatedListener(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onPagesUpdatedListeners.remove(interfaceC3588op);
    }

    public final void retry() {
        Logger logger = LoggerKt.getLOGGER();
        if (logger != null && logger.isLoggable(3)) {
            logger.log(3, "Retry signal received", null);
        }
        UiReceiver uiReceiver = this.uiReceiver;
        if (uiReceiver != null) {
            uiReceiver.retry();
        }
    }

    public final ItemSnapshotList<T> snapshot() {
        return this.presenter.snapshot();
    }

    public /* synthetic */ PagingDataDiffer(DifferCallback differCallback, InterfaceC0988Vf interfaceC0988Vf, PagingData pagingData, int i, AbstractC0419Di abstractC0419Di) {
        this(differCallback, (i & 2) != 0 ? C0368Bj.c() : interfaceC0988Vf, (i & 4) != 0 ? null : pagingData);
    }
}
