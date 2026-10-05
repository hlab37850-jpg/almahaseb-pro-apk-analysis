package androidx.paging;

import androidx.core.app.NotificationCompat;
import com.google.api.client.http.HttpStatusCodes;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import defpackage.AD;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2371hc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class SeparatorState<R, T extends R> {
    private boolean endTerminalSeparatorDeferred;
    private boolean footerAdded;
    private final InterfaceC0552Gp generator;
    private boolean headerAdded;
    private LoadStates mediatorStates;
    private final List<TransformablePage<T>> pageStash;
    private int placeholdersAfter;
    private int placeholdersBefore;
    private final MutableLoadStateCollection sourceStates;
    private boolean startTerminalSeparatorDeferred;
    private final TerminalSeparatorType terminalSeparatorType;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TerminalSeparatorType.values().length];
            try {
                iArr[TerminalSeparatorType.FULLY_COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TerminalSeparatorType.SOURCE_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.SeparatorState$onDrop$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ C1001Vs $pageOffsetsToDrop;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(C1001Vs c1001Vs) {
            super(1);
            this.$pageOffsetsToDrop = c1001Vs;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(TransformablePage<T> transformablePage) {
            AbstractC4492zt.h(transformablePage, "stash");
            int[] originalPageOffsets = transformablePage.getOriginalPageOffsets();
            C1001Vs c1001Vs = this.$pageOffsetsToDrop;
            boolean z = false;
            for (int i : originalPageOffsets) {
                if (c1001Vs.g(i)) {
                    z = true;
                    break;
                }
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.SeparatorState$onEvent$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.SeparatorState", f = "Separators.kt", l = {214, 216, 217}, m = "onEvent")
    public static final class C17241 extends AbstractC0819Pf {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeparatorState<R, T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17241(SeparatorState<R, T> separatorState, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = separatorState;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onEvent(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.SeparatorState$onInsert$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.SeparatorState", f = "Separators.kt", l = {307, 370, 382, 388, 400, HttpStatusCodes.STATUS_CODE_CONFLICT, 431, 440, 453, 464}, m = "onInsert")
    public static final class C17251 extends AbstractC0819Pf {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeparatorState<R, T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17251(SeparatorState<R, T> separatorState, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = separatorState;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onInsert(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.SeparatorState$onStaticList$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.SeparatorState", f = "Separators.kt", l = {MetaDo.META_SELECTPALETTE}, m = "onStaticList")
    public static final class C17261 extends AbstractC0819Pf {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeparatorState<R, T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17261(SeparatorState<R, T> separatorState, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = separatorState;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onStaticList(null, this);
        }
    }

    public SeparatorState(TerminalSeparatorType terminalSeparatorType, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(terminalSeparatorType, "terminalSeparatorType");
        AbstractC4492zt.h(interfaceC0552Gp, "generator");
        this.terminalSeparatorType = terminalSeparatorType;
        this.generator = interfaceC0552Gp;
        this.pageStash = new ArrayList();
        this.sourceStates = new MutableLoadStateCollection();
    }

    private final <T> TransformablePage<T> transformablePageToStash(TransformablePage<T> transformablePage) {
        int[] originalPageOffsets = transformablePage.getOriginalPageOffsets();
        List listP = AbstractC1886cc.p(AbstractC3240kc.b0(transformablePage.getData()), AbstractC3240kc.k0(transformablePage.getData()));
        int hintOriginalPageOffset = transformablePage.getHintOriginalPageOffset();
        List<Integer> hintOriginalIndices = transformablePage.getHintOriginalIndices();
        Integer numValueOf = Integer.valueOf(hintOriginalIndices != null ? ((Number) AbstractC3240kc.b0(hintOriginalIndices)).intValue() : 0);
        List<Integer> hintOriginalIndices2 = transformablePage.getHintOriginalIndices();
        return new TransformablePage<>(originalPageOffsets, listP, hintOriginalPageOffset, AbstractC1886cc.p(numValueOf, Integer.valueOf(hintOriginalIndices2 != null ? ((Number) AbstractC3240kc.k0(hintOriginalIndices2)).intValue() : AbstractC1886cc.o(transformablePage.getData()))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PageEvent.Insert<R> asRType(PageEvent.Insert<T> insert) {
        AbstractC4492zt.h(insert, "<this>");
        return insert;
    }

    public final boolean getEndTerminalSeparatorDeferred() {
        return this.endTerminalSeparatorDeferred;
    }

    public final boolean getFooterAdded() {
        return this.footerAdded;
    }

    public final InterfaceC0552Gp getGenerator() {
        return this.generator;
    }

    public final boolean getHeaderAdded() {
        return this.headerAdded;
    }

    public final LoadStates getMediatorStates() {
        return this.mediatorStates;
    }

    public final List<TransformablePage<T>> getPageStash() {
        return this.pageStash;
    }

    public final int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    public final int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    public final MutableLoadStateCollection getSourceStates() {
        return this.sourceStates;
    }

    public final boolean getStartTerminalSeparatorDeferred() {
        return this.startTerminalSeparatorDeferred;
    }

    public final TerminalSeparatorType getTerminalSeparatorType() {
        return this.terminalSeparatorType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PageEvent.Drop<R> onDrop(PageEvent.Drop<T> drop) {
        AbstractC4492zt.h(drop, NotificationCompat.CATEGORY_EVENT);
        this.sourceStates.set(drop.getLoadType(), LoadState.NotLoading.Companion.getIncomplete$paging_common());
        LoadType loadType = drop.getLoadType();
        LoadType loadType2 = LoadType.PREPEND;
        if (loadType == loadType2) {
            this.placeholdersBefore = drop.getPlaceholdersRemaining();
            this.headerAdded = false;
        } else if (drop.getLoadType() == LoadType.APPEND) {
            this.placeholdersAfter = drop.getPlaceholdersRemaining();
            this.footerAdded = false;
        }
        if (this.pageStash.isEmpty()) {
            if (drop.getLoadType() == loadType2) {
                this.startTerminalSeparatorDeferred = false;
            } else {
                this.endTerminalSeparatorDeferred = false;
            }
        }
        AbstractC2371hc.M(this.pageStash, new AnonymousClass1(new C1001Vs(drop.getMinPageOffset(), drop.getMaxPageOffset())));
        return drop;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object onEvent(PageEvent<T> pageEvent, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C17241 c17241;
        SeparatorState<R, T> separatorState;
        Object objOnDrop;
        if (interfaceC0793Of instanceof C17241) {
            c17241 = (C17241) interfaceC0793Of;
            int i = c17241.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c17241.label = i - Integer.MIN_VALUE;
            } else {
                c17241 = new C17241(this, interfaceC0793Of);
            }
        } else {
            c17241 = new C17241(this, interfaceC0793Of);
        }
        Object objOnStaticList = c17241.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c17241.label;
        if (i2 == 0) {
            LL.b(objOnStaticList);
            if (pageEvent instanceof PageEvent.Insert) {
                c17241.L$0 = this;
                c17241.label = 1;
                objOnStaticList = onInsert((PageEvent.Insert) pageEvent, c17241);
                if (objOnStaticList == objD) {
                    return objD;
                }
                separatorState = this;
                objOnDrop = (PageEvent) objOnStaticList;
            } else if (pageEvent instanceof PageEvent.Drop) {
                objOnDrop = onDrop((PageEvent.Drop) pageEvent);
                separatorState = this;
            } else if (pageEvent instanceof PageEvent.LoadStateUpdate) {
                c17241.L$0 = this;
                c17241.label = 2;
                objOnStaticList = onLoadStateUpdate((PageEvent.LoadStateUpdate) pageEvent, c17241);
                if (objOnStaticList == objD) {
                    return objD;
                }
                separatorState = this;
                objOnDrop = (PageEvent) objOnStaticList;
            } else {
                if (!(pageEvent instanceof PageEvent.StaticList)) {
                    throw new AD();
                }
                c17241.L$0 = this;
                c17241.label = 3;
                objOnStaticList = onStaticList((PageEvent.StaticList) pageEvent, c17241);
                if (objOnStaticList == objD) {
                    return objD;
                }
                separatorState = this;
                objOnDrop = (PageEvent) objOnStaticList;
            }
        } else if (i2 == 1) {
            separatorState = (SeparatorState) c17241.L$0;
            LL.b(objOnStaticList);
            objOnDrop = (PageEvent) objOnStaticList;
        } else if (i2 == 2) {
            separatorState = (SeparatorState) c17241.L$0;
            LL.b(objOnStaticList);
            objOnDrop = (PageEvent) objOnStaticList;
        } else {
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            separatorState = (SeparatorState) c17241.L$0;
            LL.b(objOnStaticList);
            objOnDrop = (PageEvent) objOnStaticList;
        }
        if (separatorState.endTerminalSeparatorDeferred && !separatorState.pageStash.isEmpty()) {
            throw new IllegalStateException("deferred endTerm, page stash should be empty");
        }
        if (!separatorState.startTerminalSeparatorDeferred || separatorState.pageStash.isEmpty()) {
            return objOnDrop;
        }
        throw new IllegalStateException("deferred startTerm, page stash should be empty");
    }

    /* JADX WARN: Code duplicated, block: B:132:0x0448  */
    /* JADX WARN: Code duplicated, block: B:134:0x047c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:135:0x047d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:135:0x047d -> B:136:0x0484). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:190:0x068b -> B:17:0x00d4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:216:0x0774 -> B:217:0x0775). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object onInsert(androidx.paging.PageEvent.Insert<T> r31, defpackage.InterfaceC0793Of r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2146
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.onInsert(androidx.paging.PageEvent$Insert, Of):java.lang.Object");
    }

    public final Object onLoadStateUpdate(PageEvent.LoadStateUpdate<T> loadStateUpdate, InterfaceC0793Of interfaceC0793Of) {
        LoadStates loadStates = this.mediatorStates;
        if (AbstractC4492zt.d(this.sourceStates.snapshot(), loadStateUpdate.getSource()) && AbstractC4492zt.d(loadStates, loadStateUpdate.getMediator())) {
            AbstractC4492zt.f(loadStateUpdate, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.SeparatorState>");
            return loadStateUpdate;
        }
        this.sourceStates.set(loadStateUpdate.getSource());
        this.mediatorStates = loadStateUpdate.getMediator();
        if (loadStateUpdate.getMediator() != null && loadStateUpdate.getMediator().getPrepend().getEndOfPaginationReached()) {
            if (!AbstractC4492zt.d(loadStates != null ? loadStates.getPrepend() : null, loadStateUpdate.getMediator().getPrepend())) {
                return onInsert(PageEvent.Insert.Companion.Prepend(AbstractC1886cc.m(), this.placeholdersBefore, loadStateUpdate.getSource(), loadStateUpdate.getMediator()), interfaceC0793Of);
            }
        }
        if (loadStateUpdate.getMediator() != null && loadStateUpdate.getMediator().getAppend().getEndOfPaginationReached()) {
            if (!AbstractC4492zt.d(loadStates != null ? loadStates.getAppend() : null, loadStateUpdate.getMediator().getAppend())) {
                return onInsert(PageEvent.Insert.Companion.Append(AbstractC1886cc.m(), this.placeholdersAfter, loadStateUpdate.getSource(), loadStateUpdate.getMediator()), interfaceC0793Of);
            }
        }
        AbstractC4492zt.f(loadStateUpdate, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.SeparatorState>");
        return loadStateUpdate;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0084 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0085  */
    /* JADX WARN: Code duplicated, block: B:22:0x008a  */
    /* JADX WARN: Code duplicated, block: B:24:0x008f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0094  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0085 -> B:21:0x0088). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object onStaticList(androidx.paging.PageEvent.StaticList<T> r11, defpackage.InterfaceC0793Of r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof androidx.paging.SeparatorState.C17261
            if (r0 == 0) goto L13
            r0 = r12
            androidx.paging.SeparatorState$onStaticList$1 r0 = (androidx.paging.SeparatorState.C17261) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.paging.SeparatorState$onStaticList$1 r0 = new androidx.paging.SeparatorState$onStaticList$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = defpackage.AbstractC0378Bt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            int r11 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$3
            java.lang.Object r5 = r0.L$2
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r0.L$1
            androidx.paging.PageEvent$StaticList r6 = (androidx.paging.PageEvent.StaticList) r6
            java.lang.Object r7 = r0.L$0
            androidx.paging.SeparatorState r7 = (androidx.paging.SeparatorState) r7
            defpackage.LL.b(r12)
            r9 = r4
            r4 = r11
            r11 = r6
            r6 = r9
            goto L88
        L3f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L47:
            defpackage.LL.b(r12)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.List r2 = r11.getData()
            int r2 = r2.size()
            if (r2 < 0) goto L9a
            r4 = 0
            r7 = r10
            r5 = r12
        L5c:
            java.util.List r12 = r11.getData()
            int r6 = r4 + (-1)
            java.lang.Object r12 = defpackage.AbstractC3240kc.e0(r12, r6)
            java.util.List r6 = r11.getData()
            java.lang.Object r6 = defpackage.AbstractC3240kc.e0(r6, r4)
            Gp r8 = r7.generator
            r0.L$0 = r7
            r0.L$1 = r11
            r0.L$2 = r5
            r0.L$3 = r6
            r0.I$0 = r4
            r0.I$1 = r2
            r0.label = r3
            java.lang.Object r12 = r8.invoke(r12, r6, r0)
            if (r12 != r1) goto L85
            return r1
        L85:
            r9 = r4
            r4 = r2
            r2 = r9
        L88:
            if (r12 == 0) goto L8d
            r5.add(r12)
        L8d:
            if (r6 == 0) goto L92
            r5.add(r6)
        L92:
            if (r2 == r4) goto L99
            int r12 = r2 + 1
            r2 = r4
            r4 = r12
            goto L5c
        L99:
            r12 = r5
        L9a:
            androidx.paging.PageEvent$StaticList r0 = new androidx.paging.PageEvent$StaticList
            androidx.paging.LoadStates r1 = r11.getSourceLoadStates()
            androidx.paging.LoadStates r11 = r11.getMediatorLoadStates()
            r0.<init>(r12, r1, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.onStaticList(androidx.paging.PageEvent$StaticList, Of):java.lang.Object");
    }

    public final void setEndTerminalSeparatorDeferred(boolean z) {
        this.endTerminalSeparatorDeferred = z;
    }

    public final void setFooterAdded(boolean z) {
        this.footerAdded = z;
    }

    public final void setHeaderAdded(boolean z) {
        this.headerAdded = z;
    }

    public final void setMediatorStates(LoadStates loadStates) {
        this.mediatorStates = loadStates;
    }

    public final void setPlaceholdersAfter(int i) {
        this.placeholdersAfter = i;
    }

    public final void setPlaceholdersBefore(int i) {
        this.placeholdersBefore = i;
    }

    public final void setStartTerminalSeparatorDeferred(boolean z) {
        this.startTerminalSeparatorDeferred = z;
    }

    public final <T> boolean terminatesEnd(PageEvent.Insert<T> insert, TerminalSeparatorType terminalSeparatorType) {
        LoadStates mediatorLoadStates;
        LoadState append;
        AbstractC4492zt.h(insert, "<this>");
        AbstractC4492zt.h(terminalSeparatorType, "terminalSeparatorType");
        if (insert.getLoadType() == LoadType.PREPEND) {
            return this.endTerminalSeparatorDeferred;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[terminalSeparatorType.ordinal()];
        if (i == 1) {
            return insert.getSourceLoadStates().getAppend().getEndOfPaginationReached() && ((mediatorLoadStates = insert.getMediatorLoadStates()) == null || (append = mediatorLoadStates.getAppend()) == null || append.getEndOfPaginationReached());
        }
        if (i == 2) {
            return insert.getSourceLoadStates().getAppend().getEndOfPaginationReached();
        }
        throw new AD();
    }

    public final <T> boolean terminatesStart(PageEvent.Insert<T> insert, TerminalSeparatorType terminalSeparatorType) {
        LoadStates mediatorLoadStates;
        LoadState prepend;
        AbstractC4492zt.h(insert, "<this>");
        AbstractC4492zt.h(terminalSeparatorType, "terminalSeparatorType");
        if (insert.getLoadType() == LoadType.APPEND) {
            return this.startTerminalSeparatorDeferred;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[terminalSeparatorType.ordinal()];
        if (i == 1) {
            return insert.getSourceLoadStates().getPrepend().getEndOfPaginationReached() && ((mediatorLoadStates = insert.getMediatorLoadStates()) == null || (prepend = mediatorLoadStates.getPrepend()) == null || prepend.getEndOfPaginationReached());
        }
        if (i == 2) {
            return insert.getSourceLoadStates().getPrepend().getEndOfPaginationReached();
        }
        throw new AD();
    }
}
