package androidx.compose.foundation.pager;

import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2133eg;
import defpackage.AbstractC3709qI;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC1003Vu;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.JL;
import defpackage.LL;
import defpackage.XS;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutPagerKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1", f = "LazyLayoutPager.kt", l = {TIFFConstants.TIFFTAG_CELLLENGTH}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ PagerState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1", f = "LazyLayoutPager.kt", l = {TIFFConstants.TIFFTAG_FILLORDER}, m = "invokeSuspend")
        public static final class C00461 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ PagerState $state;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1, reason: invalid class name and collision with other inner class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1", f = "LazyLayoutPager.kt", l = {268, TIFFConstants.TIFFTAG_MAKE}, m = "invokeSuspend")
            public static final class C00471 extends JL implements InterfaceC0526Fp {
                final /* synthetic */ PagerState $state;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00471(PagerState pagerState, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$state = pagerState;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    C00471 c00471 = new C00471(this.$state, interfaceC0793Of);
                    c00471.L$0 = obj;
                    return c00471;
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(AwaitPointerEventScope awaitPointerEventScope, InterfaceC0793Of interfaceC0793Of) {
                    return ((C00471) create(awaitPointerEventScope, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                /* JADX WARN: Code duplicated, block: B:20:0x006a  */
                /* JADX WARN: Code duplicated, block: B:23:0x0077 A[LOOP:0: B:19:0x0068->B:23:0x0077, LOOP_END] */
                /* JADX WARN: Code duplicated, block: B:27:0x007a A[SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:28:0x004a A[EDGE_INSN: B:28:0x004a->B:14:0x004a BREAK  A[LOOP:0: B:19:0x0068->B:23:0x0077], SYNTHETIC] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005a -> B:18:0x005d). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                @Override // defpackage.AbstractC2171f7
                public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                    /*
                        r10 = this;
                        java.lang.Object r0 = defpackage.AbstractC0378Bt.d()
                        int r1 = r10.label
                        r2 = 2
                        r3 = 0
                        r4 = 1
                        if (r1 == 0) goto L2f
                        if (r1 == r4) goto L27
                        if (r1 != r2) goto L1f
                        java.lang.Object r1 = r10.L$2
                        androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
                        java.lang.Object r4 = r10.L$1
                        androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                        java.lang.Object r5 = r10.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                        defpackage.LL.b(r11)
                        goto L5d
                    L1f:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r0)
                        throw r11
                    L27:
                        java.lang.Object r1 = r10.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        defpackage.LL.b(r11)
                        goto L44
                    L2f:
                        defpackage.LL.b(r11)
                        java.lang.Object r11 = r10.L$0
                        r1 = r11
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r10.L$0 = r1
                        r10.label = r4
                        java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r1, r3, r11, r10)
                        if (r11 != r0) goto L44
                        return r0
                    L44:
                        androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                        r4 = 0
                        r5 = r1
                        r1 = r4
                        r4 = r11
                    L4a:
                        if (r1 != 0) goto L86
                        androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r10.L$0 = r5
                        r10.L$1 = r4
                        r10.L$2 = r1
                        r10.label = r2
                        java.lang.Object r11 = r5.awaitPointerEvent(r11, r10)
                        if (r11 != r0) goto L5d
                        return r0
                    L5d:
                        androidx.compose.ui.input.pointer.PointerEvent r11 = (androidx.compose.ui.input.pointer.PointerEvent) r11
                        java.util.List r6 = r11.getChanges()
                        int r7 = r6.size()
                        r8 = 0
                    L68:
                        if (r8 >= r7) goto L7a
                        java.lang.Object r9 = r6.get(r8)
                        androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
                        boolean r9 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r9)
                        if (r9 != 0) goto L77
                        goto L4a
                    L77:
                        int r8 = r8 + 1
                        goto L68
                    L7a:
                        java.util.List r11 = r11.getChanges()
                        java.lang.Object r11 = r11.get(r3)
                        r1 = r11
                        androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
                        goto L4a
                    L86:
                        androidx.compose.foundation.pager.PagerState r11 = r10.$state
                        long r0 = r1.m4054getPositionF1C5BW0()
                        long r2 = r4.m4054getPositionF1C5BW0()
                        long r0 = androidx.compose.ui.geometry.Offset.m2802minusMKHz9U(r0, r2)
                        r11.m706setUpDownDifferencek4lQ0M$foundation_release(r0)
                        FW r11 = defpackage.FW.a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.LazyLayoutPagerKt.AnonymousClass1.C00461.C00471.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00461(PointerInputScope pointerInputScope, PagerState pagerState, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$$this$pointerInput = pointerInputScope;
                this.$state = pagerState;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                return new C00461(this.$$this$pointerInput, this.$state, interfaceC0793Of);
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((C00461) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    PointerInputScope pointerInputScope = this.$$this$pointerInput;
                    C00471 c00471 = new C00471(this.$state, null);
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture(pointerInputScope, c00471, this) == objD) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PagerState pagerState, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$state = pagerState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$state, interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(pointerInputScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                C00461 c00461 = new C00461((PointerInputScope) this.L$0, this.$state, null);
                this.label = 1;
                if (AbstractC2133eg.d(c00461, this) == objD) {
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

    /* JADX WARN: Code duplicated, block: B:25:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:30:0x0178  */
    /* JADX WARN: Code duplicated, block: B:33:0x018f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0197  */
    /* JADX WARN: Code duplicated, block: B:36:0x0199  */
    /* JADX WARN: Code duplicated, block: B:38:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:42:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:45:0x0247  */
    /* JADX WARN: Code duplicated, block: B:49:0x0251  */
    /* JADX WARN: Code duplicated, block: B:53:? A[RETURN, SYNTHETIC] */
    @Composable
    @ExperimentalFoundationApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Pager-fs30GE4, reason: not valid java name */
    public static final void m688Pagerfs30GE4(Modifier modifier, PagerState pagerState, PaddingValues paddingValues, boolean z, Orientation orientation, SnapFlingBehavior snapFlingBehavior, boolean z2, int i, float f, PageSize pageSize, NestedScrollConnection nestedScrollConnection, InterfaceC3750qp interfaceC3750qp, Alignment.Horizontal horizontal, Alignment.Vertical vertical, InterfaceC0578Hp interfaceC0578Hp, Composer composer, int i2, int i3, int i4) {
        OverscrollEffect overscrollEffect;
        int i5;
        boolean zChanged;
        Object objRememberedValue;
        int i6;
        boolean zChanged2;
        Object objRememberedValue2;
        Orientation orientation2;
        Modifier modifierPagerSemantics;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z3;
        AbstractC4492zt.h(modifier, "modifier");
        AbstractC4492zt.h(pagerState, "state");
        AbstractC4492zt.h(paddingValues, "contentPadding");
        AbstractC4492zt.h(orientation, "orientation");
        AbstractC4492zt.h(snapFlingBehavior, "flingBehavior");
        AbstractC4492zt.h(pageSize, "pageSize");
        AbstractC4492zt.h(nestedScrollConnection, "pageNestedScrollConnection");
        AbstractC4492zt.h(horizontal, "horizontalAlignment");
        AbstractC4492zt.h(vertical, CellUtil.VERTICAL_ALIGNMENT);
        AbstractC4492zt.h(interfaceC0578Hp, "pageContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(-301644943);
        int i7 = (i4 & 128) != 0 ? 0 : i;
        float fM5160constructorimpl = (i4 & 256) != 0 ? Dp.m5160constructorimpl(0) : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-301644943, i2, i3, "androidx.compose.foundation.pager.Pager (LazyLayoutPager.kt:58)");
        }
        if (i7 < 0) {
            throw new IllegalArgumentException(("beyondBoundsPageCount should be greater than or equal to 0, you selected " + i7).toString());
        }
        ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
        OverscrollEffect overscrollEffect2 = scrollableDefaults.overscrollEffect(composerStartRestartGroup, 6);
        int i8 = i2 >> 3;
        int i9 = i8 & 14;
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        boolean zChanged3 = composerStartRestartGroup.changed(pagerState);
        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
        if (!zChanged3) {
            overscrollEffect = overscrollEffect2;
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            i5 = i7;
            OverscrollEffect overscrollEffect3 = overscrollEffect;
            InterfaceC3588op interfaceC3588opRememberPagerItemProviderLambda = rememberPagerItemProviderLambda(pagerState, interfaceC0578Hp, interfaceC3750qp, (InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, i9 | ((i3 >> 9) & 112) | ((i3 << 3) & 896));
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(pagerState);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new LazyLayoutPagerKt$Pager$measurePolicy$1$1(pagerState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            i6 = i2 & 112;
            int i10 = i2 & 7168;
            int i11 = i2 & 57344;
            int i12 = i2 >> 6;
            int i13 = i3 << 18;
            InterfaceC0526Fp interfaceC0526FpM701rememberPagerMeasurePolicyBxUkNYg = PagerMeasurePolicyKt.m701rememberPagerMeasurePolicyBxUkNYg(interfaceC3588opRememberPagerItemProviderLambda, pagerState, paddingValues, z, orientation, i5, fM5160constructorimpl, pageSize, horizontal, vertical, (InterfaceC3588op) objRememberedValue, composerStartRestartGroup, (65520 & i2) | (i12 & 458752) | (i12 & 3670016) | (i12 & 29360128) | (234881024 & i13) | (i13 & 1879048192), 0);
            int i14 = i2 >> 15;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged2 = composerStartRestartGroup.changed(snapFlingBehavior) | composerStartRestartGroup.changed(pagerState);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new PagerWrapperFlingBehavior(snapFlingBehavior, pagerState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            PagerWrapperFlingBehavior pagerWrapperFlingBehavior = (PagerWrapperFlingBehavior) objRememberedValue2;
            composerStartRestartGroup.startReplaceableGroup(1445586192);
            if (z2) {
                Modifier.Companion companion = Modifier.Companion;
                orientation2 = orientation;
                if (orientation2 == Orientation.Vertical) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                modifierPagerSemantics = PagerKt.pagerSemantics(companion, pagerState, z3, composerStartRestartGroup, i6 | 6);
            } else {
                orientation2 = orientation;
                modifierPagerSemantics = Modifier.Companion;
            }
            composerStartRestartGroup.endReplaceableGroup();
            LazyLayoutKt.LazyLayout(interfaceC3588opRememberPagerItemProviderLambda, NestedScrollModifierKt.nestedScroll$default(dragDirectionDetector(ScrollableKt.scrollable(OverscrollKt.overscroll(PagerBeyondBoundsModifierKt.pagerBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(pagerState.getRemeasurementModifier$foundation_release()).then(pagerState.getAwaitLayoutModifier$foundation_release()).then(modifierPagerSemantics), interfaceC3588opRememberPagerItemProviderLambda, PagerSemanticsKt.rememberPagerSemanticState(pagerState, z, orientation2 == Orientation.Vertical, composerStartRestartGroup, i9 | (i12 & 112)), orientation, z2, z, composerStartRestartGroup, (i8 & 7168) | (i12 & 57344) | ((i2 << 6) & 458752)), orientation2), pagerState, i5, z, orientation, composerStartRestartGroup, i6 | (i14 & 896) | i10 | i11), overscrollEffect3), pagerState, orientation, overscrollEffect3, z2, scrollableDefaults.reverseDirection((LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation2, z), pagerWrapperFlingBehavior, pagerState.getInternalInteractionSource$foundation_release()), pagerState), nestedScrollConnection, null, 2, null), pagerState.getPrefetchState$foundation_release(), interfaceC0526FpM701rememberPagerMeasurePolicyBxUkNYg, composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new LazyLayoutPagerKt$Pager$2(modifier, pagerState, paddingValues, z, orientation, snapFlingBehavior, z2, i5, fM5160constructorimpl, pageSize, nestedScrollConnection, interfaceC3750qp, horizontal, vertical, interfaceC0578Hp, i2, i3, i4));
        }
        overscrollEffect = overscrollEffect2;
        objRememberedValue3 = new LazyLayoutPagerKt$Pager$pagerItemProvider$1$1(pagerState);
        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
        composerStartRestartGroup.endReplaceableGroup();
        i5 = i7;
        OverscrollEffect overscrollEffect4 = overscrollEffect;
        InterfaceC3588op interfaceC3588opRememberPagerItemProviderLambda2 = rememberPagerItemProviderLambda(pagerState, interfaceC0578Hp, interfaceC3750qp, (InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, i9 | ((i3 >> 9) & 112) | ((i3 << 3) & 896));
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        zChanged = composerStartRestartGroup.changed(pagerState);
        objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged) {
            objRememberedValue = new LazyLayoutPagerKt$Pager$measurePolicy$1$1(pagerState);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        } else {
            objRememberedValue = new LazyLayoutPagerKt$Pager$measurePolicy$1$1(pagerState);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        i6 = i2 & 112;
        int i15 = i2 & 7168;
        int i16 = i2 & 57344;
        int i17 = i2 >> 6;
        int i18 = i3 << 18;
        InterfaceC0526Fp interfaceC0526FpM701rememberPagerMeasurePolicyBxUkNYg2 = PagerMeasurePolicyKt.m701rememberPagerMeasurePolicyBxUkNYg(interfaceC3588opRememberPagerItemProviderLambda2, pagerState, paddingValues, z, orientation, i5, fM5160constructorimpl, pageSize, horizontal, vertical, (InterfaceC3588op) objRememberedValue, composerStartRestartGroup, (65520 & i2) | (i17 & 458752) | (i17 & 3670016) | (i17 & 29360128) | (234881024 & i18) | (i18 & 1879048192), 0);
        int i19 = i2 >> 15;
        composerStartRestartGroup.startReplaceableGroup(511388516);
        zChanged2 = composerStartRestartGroup.changed(snapFlingBehavior) | composerStartRestartGroup.changed(pagerState);
        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (zChanged2) {
            objRememberedValue2 = new PagerWrapperFlingBehavior(snapFlingBehavior, pagerState);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        } else {
            objRememberedValue2 = new PagerWrapperFlingBehavior(snapFlingBehavior, pagerState);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        composerStartRestartGroup.endReplaceableGroup();
        PagerWrapperFlingBehavior pagerWrapperFlingBehavior2 = (PagerWrapperFlingBehavior) objRememberedValue2;
        composerStartRestartGroup.startReplaceableGroup(1445586192);
        if (z2) {
            Modifier.Companion companion2 = Modifier.Companion;
            orientation2 = orientation;
            if (orientation2 == Orientation.Vertical) {
                z3 = true;
            } else {
                z3 = false;
            }
            modifierPagerSemantics = PagerKt.pagerSemantics(companion2, pagerState, z3, composerStartRestartGroup, i6 | 6);
        } else {
            orientation2 = orientation;
            modifierPagerSemantics = Modifier.Companion;
        }
        composerStartRestartGroup.endReplaceableGroup();
        LazyLayoutKt.LazyLayout(interfaceC3588opRememberPagerItemProviderLambda2, NestedScrollModifierKt.nestedScroll$default(dragDirectionDetector(ScrollableKt.scrollable(OverscrollKt.overscroll(PagerBeyondBoundsModifierKt.pagerBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(pagerState.getRemeasurementModifier$foundation_release()).then(pagerState.getAwaitLayoutModifier$foundation_release()).then(modifierPagerSemantics), interfaceC3588opRememberPagerItemProviderLambda2, PagerSemanticsKt.rememberPagerSemanticState(pagerState, z, orientation2 == Orientation.Vertical, composerStartRestartGroup, i9 | (i17 & 112)), orientation, z2, z, composerStartRestartGroup, (i8 & 7168) | (i17 & 57344) | ((i2 << 6) & 458752)), orientation2), pagerState, i5, z, orientation, composerStartRestartGroup, i6 | (i19 & 896) | i15 | i16), overscrollEffect4), pagerState, orientation, overscrollEffect4, z2, scrollableDefaults.reverseDirection((LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation2, z), pagerWrapperFlingBehavior2, pagerState.getInternalInteractionSource$foundation_release()), pagerState), nestedScrollConnection, null, 2, null), pagerState.getPrefetchState$foundation_release(), interfaceC0526FpM701rememberPagerMeasurePolicyBxUkNYg2, composerStartRestartGroup, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new LazyLayoutPagerKt$Pager$2(modifier, pagerState, paddingValues, z, orientation, snapFlingBehavior, z2, i5, fM5160constructorimpl, pageSize, nestedScrollConnection, interfaceC3750qp, horizontal, vertical, interfaceC0578Hp, i2, i3, i4));
    }

    private static final Modifier dragDirectionDetector(Modifier modifier, PagerState pagerState) {
        return modifier.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, pagerState, new AnonymousClass1(pagerState, null)));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    private static final InterfaceC3588op rememberPagerItemProviderLambda(PagerState pagerState, InterfaceC0578Hp interfaceC0578Hp, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, Composer composer, int i) {
        composer.startReplaceableGroup(-1372505274);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1372505274, i, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:234)");
        }
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC0578Hp, composer, (i >> 3) & 14);
        Object[] objArr = {pagerState, stateRememberUpdatedState, interfaceC3750qp, interfaceC3588op};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i2 = 0; i2 < 4; i2++) {
            zChanged |= composer.changed(objArr[i2]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            final State stateDerivedStateOf = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$itemProviderState$1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$intervalContentState$1(stateRememberUpdatedState, interfaceC3750qp, interfaceC3588op)), pagerState));
            objRememberedValue = new AbstractC3709qI(stateDerivedStateOf) { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1
                @Override // defpackage.InterfaceC1003Vu
                public Object get() {
                    return ((State) this.receiver).getValue();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        InterfaceC1003Vu interfaceC1003Vu = (InterfaceC1003Vu) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return interfaceC1003Vu;
    }
}
