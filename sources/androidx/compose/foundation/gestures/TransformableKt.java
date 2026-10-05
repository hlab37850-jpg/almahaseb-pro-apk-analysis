package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.InspectableValueKt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2287gb;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC1009Wa;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.OJ;
import defpackage.XS;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
public final class TransformableKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoom$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", l = {ShapeTypes.ACTION_BUTTON_RETURN, ShapeTypes.ACTION_BUTTON_SOUND, 215}, m = "detectZoom")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransformableKt.detectZoom(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13351 extends AbstractC2233fv implements InterfaceC3588op {
        public static final C13351 INSTANCE = new C13351();

        public C13351() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ InterfaceC3588op $canPan;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ boolean $lockRotationOnZoomPan;
        final /* synthetic */ TransformableState $state;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$3$1, reason: invalid class name */
        @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$3$1", f = "Transformable.kt", l = {105, 108}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ InterfaceC1009Wa $channel;
            final /* synthetic */ TransformableState $state;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$3$1$1, reason: invalid class name and collision with other inner class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$3$1$1", f = "Transformable.kt", l = {113}, m = "invokeSuspend")
            public static final class C00421 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ InterfaceC1009Wa $channel;
                final /* synthetic */ OJ $event;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00421(OJ oj, InterfaceC1009Wa interfaceC1009Wa, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$event = oj;
                    this.$channel = interfaceC1009Wa;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    C00421 c00421 = new C00421(this.$event, this.$channel, interfaceC0793Of);
                    c00421.L$0 = obj;
                    return c00421;
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(TransformScope transformScope, InterfaceC0793Of interfaceC0793Of) {
                    return ((C00421) create(transformScope, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                /* JADX WARN: Code duplicated, block: B:11:0x002f  */
                /* JADX WARN: Code duplicated, block: B:13:0x0033  */
                /* JADX WARN: Code duplicated, block: B:14:0x0036  */
                /* JADX WARN: Code duplicated, block: B:16:0x0039  */
                /* JADX WARN: Code duplicated, block: B:19:0x0058 A[RETURN] */
                /* JADX WARN: Code duplicated, block: B:21:0x005c  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0056 -> B:20:0x0059). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:11:0x002f
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                @Override // defpackage.AbstractC2171f7
                public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                    /*
                        r6 = this;
                        java.lang.Object r0 = defpackage.AbstractC0378Bt.d()
                        int r1 = r6.label
                        r2 = 1
                        if (r1 == 0) goto L1f
                        if (r1 != r2) goto L17
                        java.lang.Object r1 = r6.L$1
                        OJ r1 = (defpackage.OJ) r1
                        java.lang.Object r3 = r6.L$0
                        androidx.compose.foundation.gestures.TransformScope r3 = (androidx.compose.foundation.gestures.TransformScope) r3
                        defpackage.LL.b(r7)
                        goto L59
                    L17:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r0)
                        throw r7
                    L1f:
                        defpackage.LL.b(r7)
                        java.lang.Object r7 = r6.L$0
                        androidx.compose.foundation.gestures.TransformScope r7 = (androidx.compose.foundation.gestures.TransformScope) r7
                        r3 = r7
                    L27:
                        OJ r7 = r6.$event
                        java.lang.Object r7 = r7.a
                        boolean r1 = r7 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformStopped
                        if (r1 != 0) goto L5c
                        boolean r1 = r7 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformDelta
                        if (r1 == 0) goto L36
                        androidx.compose.foundation.gestures.TransformEvent$TransformDelta r7 = (androidx.compose.foundation.gestures.TransformEvent.TransformDelta) r7
                        goto L37
                    L36:
                        r7 = 0
                    L37:
                        if (r7 == 0) goto L48
                        float r1 = r7.getZoomChange()
                        long r4 = r7.m359getPanChangeF1C5BW0()
                        float r7 = r7.getRotationChange()
                        r3.mo263transformByd4ec7I(r1, r4, r7)
                    L48:
                        OJ r1 = r6.$event
                        Wa r7 = r6.$channel
                        r6.L$0 = r3
                        r6.L$1 = r1
                        r6.label = r2
                        java.lang.Object r7 = r7.f(r6)
                        if (r7 != r0) goto L59
                        return r0
                    L59:
                        r1.a = r7
                        goto L27
                    L5c:
                        FW r7 = defpackage.FW.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.AnonymousClass3.AnonymousClass1.C00421.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(InterfaceC1009Wa interfaceC1009Wa, TransformableState transformableState, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$channel = interfaceC1009Wa;
                this.$state = transformableState;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$channel, this.$state, interfaceC0793Of);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            /* JADX WARN: Code duplicated, block: B:16:0x003e  */
            /* JADX WARN: Code duplicated, block: B:18:0x0053 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:19:0x0054  */
            /* JADX WARN: Code duplicated, block: B:24:0x0079 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:31:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007b -> B:14:0x0038). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // defpackage.AbstractC2171f7
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    r9 = this;
                    java.lang.Object r0 = defpackage.AbstractC0378Bt.d()
                    int r1 = r9.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L31
                    if (r1 == r3) goto L21
                    if (r1 != r2) goto L19
                    java.lang.Object r1 = r9.L$0
                    dg r1 = (defpackage.InterfaceC2052dg) r1
                    defpackage.LL.b(r10)     // Catch: java.util.concurrent.CancellationException -> L17
                L15:
                    r10 = r1
                    goto L38
                L17:
                    goto L15
                L19:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r0)
                    throw r10
                L21:
                    java.lang.Object r1 = r9.L$2
                    OJ r1 = (defpackage.OJ) r1
                    java.lang.Object r4 = r9.L$1
                    OJ r4 = (defpackage.OJ) r4
                    java.lang.Object r5 = r9.L$0
                    dg r5 = (defpackage.InterfaceC2052dg) r5
                    defpackage.LL.b(r10)
                    goto L57
                L31:
                    defpackage.LL.b(r10)
                    java.lang.Object r10 = r9.L$0
                    dg r10 = (defpackage.InterfaceC2052dg) r10
                L38:
                    boolean r1 = defpackage.AbstractC2133eg.e(r10)
                    if (r1 == 0) goto L7d
                    OJ r1 = new OJ
                    r1.<init>()
                    Wa r4 = r9.$channel
                    r9.L$0 = r10
                    r9.L$1 = r1
                    r9.L$2 = r1
                    r9.label = r3
                    java.lang.Object r4 = r4.f(r9)
                    if (r4 != r0) goto L54
                    return r0
                L54:
                    r5 = r10
                    r10 = r4
                    r4 = r1
                L57:
                    r1.a = r10
                    java.lang.Object r10 = r4.a
                    boolean r10 = r10 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformStarted
                    if (r10 == 0) goto L7b
                    androidx.compose.foundation.gestures.TransformableState r10 = r9.$state     // Catch: java.util.concurrent.CancellationException -> L7a
                    androidx.compose.foundation.MutatePriority r1 = androidx.compose.foundation.MutatePriority.UserInput     // Catch: java.util.concurrent.CancellationException -> L7a
                    androidx.compose.foundation.gestures.TransformableKt$transformable$3$1$1 r6 = new androidx.compose.foundation.gestures.TransformableKt$transformable$3$1$1     // Catch: java.util.concurrent.CancellationException -> L7a
                    Wa r7 = r9.$channel     // Catch: java.util.concurrent.CancellationException -> L7a
                    r8 = 0
                    r6.<init>(r4, r7, r8)     // Catch: java.util.concurrent.CancellationException -> L7a
                    r9.L$0 = r5     // Catch: java.util.concurrent.CancellationException -> L7a
                    r9.L$1 = r8     // Catch: java.util.concurrent.CancellationException -> L7a
                    r9.L$2 = r8     // Catch: java.util.concurrent.CancellationException -> L7a
                    r9.label = r2     // Catch: java.util.concurrent.CancellationException -> L7a
                    java.lang.Object r10 = r10.transform(r1, r6, r9)     // Catch: java.util.concurrent.CancellationException -> L7a
                    if (r10 != r0) goto L7b
                    return r0
                L7a:
                L7b:
                    r10 = r5
                    goto L38
                L7d:
                    FW r10 = defpackage.FW.a
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.AnonymousClass3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(boolean z, InterfaceC3588op interfaceC3588op, boolean z2, TransformableState transformableState) {
            super(3);
            this.$lockRotationOnZoomPan = z;
            this.$canPan = interfaceC3588op;
            this.$enabled = z2;
            this.$state = transformableState;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            AbstractC4492zt.h(modifier, "$this$composed");
            composer.startReplaceableGroup(298661433);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(298661433, i, -1, "androidx.compose.foundation.gestures.transformable.<anonymous> (Transformable.kt:97)");
            }
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(this.$lockRotationOnZoomPan), composer, 0);
            State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(this.$canPan, composer, 0);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = AbstractC2287gb.b(Integer.MAX_VALUE, null, null, 6, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            InterfaceC1009Wa interfaceC1009Wa = (InterfaceC1009Wa) objRememberedValue;
            composer.startReplaceableGroup(-2015615917);
            if (this.$enabled) {
                TransformableState transformableState = this.$state;
                EffectsKt.LaunchedEffect(transformableState, new AnonymousClass1(interfaceC1009Wa, transformableState, null), composer, 64);
            }
            composer.endReplaceableGroup();
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new TransformableKt$transformable$3$block$1$1(stateRememberUpdatedState, interfaceC1009Wa, stateRememberUpdatedState2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            Modifier modifierPointerInput = this.$enabled ? SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, interfaceC1009Wa, (InterfaceC0526Fp) objRememberedValue2) : Modifier.Companion;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return modifierPointerInput;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:104:0x0141 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x013c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0130  */
    /* JADX WARN: Code duplicated, block: B:30:0x013e A[LOOP:2: B:26:0x012e->B:30:0x013e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0280 -> B:82:0x028f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope r29, androidx.compose.runtime.State<java.lang.Boolean> r30, defpackage.InterfaceC1009Wa r31, androidx.compose.runtime.State<? extends defpackage.InterfaceC3588op> r32, defpackage.InterfaceC0793Of r33) {
        /*
            Method dump skipped, instruction units count: 738
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.runtime.State, Wa, androidx.compose.runtime.State, Of):java.lang.Object");
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, boolean z, boolean z2) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(transformableState, "state");
        return transformable(modifier, transformableState, C13351.INSTANCE, z, z2);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    @ExperimentalFoundationApi
    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, InterfaceC3588op interfaceC3588op, boolean z, boolean z2) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(transformableState, "state");
        AbstractC4492zt.h(interfaceC3588op, "canPan");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TransformableKt$transformable$$inlined$debugInspectorInfo$1(transformableState, interfaceC3588op, z2, z) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass3(z, interfaceC3588op, z2, transformableState));
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, InterfaceC3588op interfaceC3588op, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, interfaceC3588op, z, z2);
    }
}
