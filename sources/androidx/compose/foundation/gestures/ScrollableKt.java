package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Velocity;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2261gC;
import defpackage.AbstractC2262gD;
import defpackage.AbstractC4492zt;
import defpackage.C1172Zk;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LL;

/* JADX INFO: loaded from: classes.dex */
public final class ScrollableKt {
    private static final float DefaultScrollMotionDurationScaleFactor = 1.0f;
    private static final InterfaceC0552Gp NoOpOnDragStarted = new ScrollableKt$NoOpOnDragStarted$1(null);
    private static final ScrollScope NoOpScrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollableKt$NoOpScrollScope$1
        @Override // androidx.compose.foundation.gestures.ScrollScope
        public float scrollBy(float f) {
            return f;
        }
    };
    private static final ProvidableModifierLocal<Boolean> ModifierLocalScrollableContainer = ModifierLocalKt.modifierLocalOf(ScrollableKt$ModifierLocalScrollableContainer$1.INSTANCE);
    private static final MotionDurationScale DefaultScrollMotionDurationScale = new MotionDurationScale() { // from class: androidx.compose.foundation.gestures.ScrollableKt$DefaultScrollMotionDurationScale$1
        @Override // androidx.compose.ui.MotionDurationScale, defpackage.InterfaceC0988Vf
        public <R> R fold(R r, InterfaceC0526Fp interfaceC0526Fp) {
            return (R) MotionDurationScale.DefaultImpls.fold(this, r, interfaceC0526Fp);
        }

        @Override // androidx.compose.ui.MotionDurationScale, defpackage.InterfaceC0988Vf.b, defpackage.InterfaceC0988Vf
        public <E extends InterfaceC0988Vf.b> E get(InterfaceC0988Vf.c cVar) {
            return (E) MotionDurationScale.DefaultImpls.get(this, cVar);
        }

        @Override // androidx.compose.ui.MotionDurationScale, defpackage.InterfaceC0988Vf.b
        public /* synthetic */ InterfaceC0988Vf.c getKey() {
            return AbstractC2261gC.a(this);
        }

        @Override // androidx.compose.ui.MotionDurationScale
        public float getScaleFactor() {
            return 1.0f;
        }

        @Override // androidx.compose.ui.MotionDurationScale, defpackage.InterfaceC0988Vf
        public InterfaceC0988Vf minusKey(InterfaceC0988Vf.c cVar) {
            return MotionDurationScale.DefaultImpls.minusKey(this, cVar);
        }

        @Override // androidx.compose.ui.MotionDurationScale, defpackage.InterfaceC0988Vf
        public InterfaceC0988Vf plus(InterfaceC0988Vf interfaceC0988Vf) {
            return MotionDurationScale.DefaultImpls.plus(this, interfaceC0988Vf);
        }
    };

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.ScrollableKt", f = "Scrollable.kt", l = {371}, m = "awaitScrollEvent")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScrollableKt.awaitScrollEvent(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13291 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C13291 INSTANCE = new C13291();

        public C13291() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(PointerInputChange pointerInputChange) {
            AbstractC4492zt.h(pointerInputChange, "down");
            return Boolean.valueOf(!PointerType.m4112equalsimpl0(pointerInputChange.m4057getTypeT8wyACA(), PointerType.Companion.m4117getMouseT8wyACA()));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableKt$scrollable$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ OverscrollEffect $overscrollEffect;
        final /* synthetic */ boolean $reverseDirection;
        final /* synthetic */ ScrollableState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Orientation orientation, ScrollableState scrollableState, boolean z, MutableInteractionSource mutableInteractionSource, FlingBehavior flingBehavior, OverscrollEffect overscrollEffect, boolean z2) {
            super(3);
            this.$orientation = orientation;
            this.$state = scrollableState;
            this.$reverseDirection = z;
            this.$interactionSource = mutableInteractionSource;
            this.$flingBehavior = flingBehavior;
            this.$overscrollEffect = overscrollEffect;
            this.$enabled = z2;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            AbstractC4492zt.h(modifier, "$this$composed");
            composer.startReplaceableGroup(-629830927);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-629830927, i, -1, "androidx.compose.foundation.gestures.scrollable.<anonymous> (Scrollable.kt:161)");
            }
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composer.endReplaceableGroup();
            Object[] objArr = {coroutineScope, this.$orientation, this.$state, Boolean.valueOf(this.$reverseDirection)};
            Orientation orientation = this.$orientation;
            ScrollableState scrollableState = this.$state;
            boolean z = this.$reverseDirection;
            composer.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i2 = 0; i2 < 4; i2++) {
                zChanged |= composer.changed(objArr[i2]);
            }
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new ContentInViewModifier(coroutineScope, orientation, scrollableState, z);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            Modifier modifier2 = Modifier.Companion;
            Modifier modifierPointerScrollable = ScrollableKt.pointerScrollable(FocusableKt.focusGroup(modifier2).then(((ContentInViewModifier) objRememberedValue2).getModifier()), this.$interactionSource, this.$orientation, this.$reverseDirection, this.$state, this.$flingBehavior, this.$overscrollEffect, this.$enabled, composer, 0);
            if (this.$enabled) {
                modifier2 = ModifierLocalScrollableContainerProvider.INSTANCE;
            }
            Modifier modifierThen = modifierPointerScrollable.then(modifier2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return modifierThen;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13301 implements NestedScrollConnection {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ State<ScrollingLogic> $scrollLogic;

        public C13301(State<ScrollingLogic> state, boolean z) {
            this.$scrollLogic = state;
            this.$enabled = z;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
        public Object mo340onPostFlingRZ2iAVY(long j, long j2, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1;
            long jM5396getZero9UxMQ8M;
            C13301 c13301;
            if (interfaceC0793Of instanceof ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1) {
                scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 = (ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1) interfaceC0793Of;
                int i = scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.label = i - Integer.MIN_VALUE;
                } else {
                    scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 = new ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1(this, interfaceC0793Of);
                }
            } else {
                scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 = new ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1(this, interfaceC0793Of);
            }
            Object objM345doFlingAnimationQWom1Mo = scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.result;
            Object objD = AbstractC0378Bt.d();
            int i2 = scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.label;
            if (i2 == 0) {
                LL.b(objM345doFlingAnimationQWom1Mo);
                if (this.$enabled) {
                    ScrollingLogic value = this.$scrollLogic.getValue();
                    scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.L$0 = this;
                    scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.J$0 = j2;
                    scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.label = 1;
                    objM345doFlingAnimationQWom1Mo = value.m345doFlingAnimationQWom1Mo(j2, scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1);
                    if (objM345doFlingAnimationQWom1Mo == objD) {
                        return objD;
                    }
                    c13301 = this;
                } else {
                    jM5396getZero9UxMQ8M = Velocity.Companion.m5396getZero9UxMQ8M();
                    c13301 = this;
                }
                Velocity velocityM5376boximpl = Velocity.m5376boximpl(jM5396getZero9UxMQ8M);
                State<ScrollingLogic> state = c13301.$scrollLogic;
                velocityM5376boximpl.m5394unboximpl();
                state.getValue().registerNestedFling(false);
                return velocityM5376boximpl;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j2 = scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.J$0;
            c13301 = (C13301) scrollableKt$scrollableNestedScrollConnection$1$onPostFling$1.L$0;
            LL.b(objM345doFlingAnimationQWom1Mo);
            jM5396getZero9UxMQ8M = Velocity.m5388minusAH228Gc(j2, ((Velocity) objM345doFlingAnimationQWom1Mo).m5394unboximpl());
            Velocity velocityM5376boximpl2 = Velocity.m5376boximpl(jM5396getZero9UxMQ8M);
            State<ScrollingLogic> state2 = c13301.$scrollLogic;
            velocityM5376boximpl2.m5394unboximpl();
            state2.getValue().registerNestedFling(false);
            return velocityM5376boximpl2;
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
        public long mo341onPostScrollDzOQY0M(long j, long j2, int i) {
            return this.$enabled ? this.$scrollLogic.getValue().m347performRawScrollMKHz9U(j2) : Offset.Companion.m2814getZeroF1C5BW0();
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
        public /* synthetic */ Object mo342onPreFlingQWom1Mo(long j, InterfaceC0793Of interfaceC0793Of) {
            return AbstractC2262gD.c(this, j, interfaceC0793Of);
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
        public long mo343onPreScrollOzD1aCk(long j, int i) {
            if (NestedScrollSource.m3958equalsimpl0(i, NestedScrollSource.Companion.m3964getFlingWNlRxjI())) {
                this.$scrollLogic.getValue().registerNestedFling(true);
            }
            return Offset.Companion.m2814getZeroF1C5BW0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0043 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0056 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0041 -> B:18:0x0044). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object awaitScrollEvent(androidx.compose.ui.input.pointer.AwaitPointerEventScope r5, defpackage.InterfaceC0793Of r6) {
        /*
            boolean r0 = r6 instanceof androidx.compose.foundation.gestures.ScrollableKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1 r0 = (androidx.compose.foundation.gestures.ScrollableKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1 r0 = new androidx.compose.foundation.gestures.ScrollableKt$awaitScrollEvent$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = defpackage.AbstractC0378Bt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            defpackage.LL.b(r6)
            goto L44
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            defpackage.LL.b(r6)
        L38:
            r0.L$0 = r5
            r0.label = r3
            r6 = 0
            java.lang.Object r6 = defpackage.J6.t(r5, r6, r0, r3, r6)
            if (r6 != r1) goto L44
            return r1
        L44:
            androidx.compose.ui.input.pointer.PointerEvent r6 = (androidx.compose.ui.input.pointer.PointerEvent) r6
            int r2 = r6.m3996getType7fucELk()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.ui.input.pointer.PointerEventType.Companion
            int r4 = r4.m4012getScroll7fucELk()
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventType.m4003equalsimpl0(r2, r4)
            if (r2 == 0) goto L38
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.awaitScrollEvent(androidx.compose.ui.input.pointer.AwaitPointerEventScope, Of):java.lang.Object");
    }

    public static final MotionDurationScale getDefaultScrollMotionDurationScale() {
        return DefaultScrollMotionDurationScale;
    }

    public static final ProvidableModifierLocal<Boolean> getModifierLocalScrollableContainer() {
        return ModifierLocalScrollableContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final Modifier pointerScrollable(Modifier modifier, MutableInteractionSource mutableInteractionSource, Orientation orientation, boolean z, ScrollableState scrollableState, FlingBehavior flingBehavior, OverscrollEffect overscrollEffect, boolean z2, Composer composer, int i) {
        composer.startReplaceableGroup(-2012025036);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2012025036, i, -1, "androidx.compose.foundation.gestures.pointerScrollable (Scrollable.kt:247)");
        }
        composer.startReplaceableGroup(-1730185954);
        FlingBehavior flingBehavior2 = flingBehavior == null ? ScrollableDefaults.INSTANCE.flingBehavior(composer, 6) : flingBehavior;
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new NestedScrollDispatcher(), null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(new ScrollingLogic(orientation, z, mutableState, scrollableState, flingBehavior2, overscrollEffect), composer, 0);
        Object objValueOf = Boolean.valueOf(z2);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(objValueOf);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = scrollableNestedScrollConnection(stateRememberUpdatedState, z2);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        NestedScrollConnection nestedScrollConnection = (NestedScrollConnection) objRememberedValue2;
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = new ScrollDraggableState(stateRememberUpdatedState);
            composer.updateRememberedValue(objRememberedValue3);
        }
        composer.endReplaceableGroup();
        ScrollDraggableState scrollDraggableState = (ScrollDraggableState) objRememberedValue3;
        ScrollConfig scrollConfigPlatformScrollConfig = AndroidScrollable_androidKt.platformScrollConfig(composer, 0);
        InterfaceC0552Gp interfaceC0552Gp = NoOpOnDragStarted;
        C13291 c13291 = C13291.INSTANCE;
        composer.startReplaceableGroup(1157296644);
        boolean zChanged2 = composer.changed(stateRememberUpdatedState);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
            objRememberedValue4 = new ScrollableKt$pointerScrollable$2$1(stateRememberUpdatedState);
            composer.updateRememberedValue(objRememberedValue4);
        }
        composer.endReplaceableGroup();
        InterfaceC3588op interfaceC3588op = (InterfaceC3588op) objRememberedValue4;
        composer.startReplaceableGroup(511388516);
        boolean zChanged3 = composer.changed(mutableState) | composer.changed(stateRememberUpdatedState);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue5 == companion.getEmpty()) {
            objRememberedValue5 = new ScrollableKt$pointerScrollable$3$1(mutableState, stateRememberUpdatedState, null);
            composer.updateRememberedValue(objRememberedValue5);
        }
        composer.endReplaceableGroup();
        Modifier modifierNestedScroll = NestedScrollModifierKt.nestedScroll(modifier.then(new DraggableElement(scrollDraggableState, c13291, orientation, z2, mutableInteractionSource, interfaceC3588op, interfaceC0552Gp, (InterfaceC0552Gp) objRememberedValue5, false)).then(new MouseWheelScrollElement(stateRememberUpdatedState, scrollConfigPlatformScrollConfig)), nestedScrollConnection, (NestedScrollDispatcher) mutableState.getValue());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifierNestedScroll;
    }

    public static final Modifier scrollable(Modifier modifier, ScrollableState scrollableState, Orientation orientation, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(scrollableState, "state");
        AbstractC4492zt.h(orientation, "orientation");
        return scrollable(modifier, scrollableState, orientation, null, z, z2, flingBehavior, mutableInteractionSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection scrollableNestedScrollConnection(State<ScrollingLogic> state, boolean z) {
        return new C13301(state, z);
    }

    @ExperimentalFoundationApi
    public static final Modifier scrollable(Modifier modifier, ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(scrollableState, "state");
        AbstractC4492zt.h(orientation, "orientation");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ScrollableKt$scrollable$$inlined$debugInspectorInfo$1(orientation, scrollableState, overscrollEffect, z, z2, flingBehavior, mutableInteractionSource) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(orientation, scrollableState, z2, mutableInteractionSource, flingBehavior, overscrollEffect, z));
    }
}
