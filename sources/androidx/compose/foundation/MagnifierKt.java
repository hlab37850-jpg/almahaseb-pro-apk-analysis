package androidx.compose.foundation;

import android.os.Build;
import android.view.View;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC1224aP;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.CC;
import defpackage.FW;
import defpackage.I8;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.NJ;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
public final class MagnifierKt {
    private static final SemanticsPropertyKey<InterfaceC3588op> MagnifierPositionInRoot = new SemanticsPropertyKey<>("MagnifierPositionInRoot", null, 2, null);

    /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierKt$magnifier$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Offset.m2787boximpl(m225invoketuRUvjQ((Density) obj));
        }

        /* JADX INFO: renamed from: invoke-tuRUvjQ, reason: not valid java name */
        public final long m225invoketuRUvjQ(Density density) {
            AbstractC4492zt.h(density, "$this$null");
            return Offset.Companion.m2813getUnspecifiedF1C5BW0();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ InterfaceC3750qp $magnifierCenter;
        final /* synthetic */ InterfaceC3750qp $onSizeChanged;
        final /* synthetic */ PlatformMagnifierFactory $platformMagnifierFactory;
        final /* synthetic */ InterfaceC3750qp $sourceCenter;
        final /* synthetic */ MagnifierStyle $style;
        final /* synthetic */ float $zoom;

        /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$1, reason: invalid class name */
        @InterfaceC3252ki(c = "androidx.compose.foundation.MagnifierKt$magnifier$4$1", f = "Magnifier.kt", l = {363}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ MutableState<Offset> $anchorPositionInRoot$delegate;
            final /* synthetic */ Density $density;
            final /* synthetic */ State<Boolean> $isMagnifierShown$delegate;
            final /* synthetic */ CC $onNeedsUpdate;
            final /* synthetic */ PlatformMagnifierFactory $platformMagnifierFactory;
            final /* synthetic */ State<Offset> $sourceCenterInRoot$delegate;
            final /* synthetic */ MagnifierStyle $style;
            final /* synthetic */ State<InterfaceC3750qp> $updatedMagnifierCenter$delegate;
            final /* synthetic */ State<InterfaceC3750qp> $updatedOnSizeChanged$delegate;
            final /* synthetic */ State<Float> $updatedZoom$delegate;
            final /* synthetic */ View $view;
            final /* synthetic */ float $zoom;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$1$1, reason: invalid class name and collision with other inner class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.MagnifierKt$magnifier$4$1$1", f = "Magnifier.kt", l = {}, m = "invokeSuspend")
            public static final class C00291 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ PlatformMagnifier $magnifier;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00291(PlatformMagnifier platformMagnifier, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$magnifier = platformMagnifier;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new C00291(this.$magnifier, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(FW fw, InterfaceC0793Of interfaceC0793Of) {
                    return ((C00291) create(fw, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    AbstractC0378Bt.d();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                    this.$magnifier.updateContent();
                    return FW.a;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$1$2, reason: invalid class name */
            public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
                final /* synthetic */ MutableState<Offset> $anchorPositionInRoot$delegate;
                final /* synthetic */ Density $density;
                final /* synthetic */ State<Boolean> $isMagnifierShown$delegate;
                final /* synthetic */ PlatformMagnifier $magnifier;
                final /* synthetic */ NJ $previousSize;
                final /* synthetic */ State<Offset> $sourceCenterInRoot$delegate;
                final /* synthetic */ State<InterfaceC3750qp> $updatedMagnifierCenter$delegate;
                final /* synthetic */ State<InterfaceC3750qp> $updatedOnSizeChanged$delegate;
                final /* synthetic */ State<Float> $updatedZoom$delegate;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass2(PlatformMagnifier platformMagnifier, Density density, State<Boolean> state, State<Offset> state2, State<? extends InterfaceC3750qp> state3, MutableState<Offset> mutableState, State<Float> state4, NJ nj, State<? extends InterfaceC3750qp> state5) {
                    super(0);
                    this.$magnifier = platformMagnifier;
                    this.$density = density;
                    this.$isMagnifierShown$delegate = state;
                    this.$sourceCenterInRoot$delegate = state2;
                    this.$updatedMagnifierCenter$delegate = state3;
                    this.$anchorPositionInRoot$delegate = mutableState;
                    this.$updatedZoom$delegate = state4;
                    this.$previousSize = nj;
                    this.$updatedOnSizeChanged$delegate = state5;
                }

                @Override // defpackage.InterfaceC3588op
                public /* bridge */ /* synthetic */ Object invoke() {
                    m226invoke();
                    return FW.a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m226invoke() {
                    if (!AnonymousClass4.invoke$lambda$10(this.$isMagnifierShown$delegate)) {
                        this.$magnifier.dismiss();
                        return;
                    }
                    PlatformMagnifier platformMagnifier = this.$magnifier;
                    long jInvoke$lambda$8 = AnonymousClass4.invoke$lambda$8(this.$sourceCenterInRoot$delegate);
                    Object objInvoke = AnonymousClass4.invoke$lambda$4(this.$updatedMagnifierCenter$delegate).invoke(this.$density);
                    MutableState<Offset> mutableState = this.$anchorPositionInRoot$delegate;
                    long jM2808unboximpl = ((Offset) objInvoke).m2808unboximpl();
                    platformMagnifier.mo253updateWko1d7g(jInvoke$lambda$8, OffsetKt.m2817isSpecifiedk4lQ0M(jM2808unboximpl) ? Offset.m2803plusMKHz9U(AnonymousClass4.invoke$lambda$1(mutableState), jM2808unboximpl) : Offset.Companion.m2813getUnspecifiedF1C5BW0(), AnonymousClass4.invoke$lambda$5(this.$updatedZoom$delegate));
                    long jMo252getSizeYbymL2g = this.$magnifier.mo252getSizeYbymL2g();
                    NJ nj = this.$previousSize;
                    Density density = this.$density;
                    State<InterfaceC3750qp> state = this.$updatedOnSizeChanged$delegate;
                    if (IntSize.m5318equalsimpl0(jMo252getSizeYbymL2g, nj.a)) {
                        return;
                    }
                    nj.a = jMo252getSizeYbymL2g;
                    InterfaceC3750qp interfaceC3750qpInvoke$lambda$6 = AnonymousClass4.invoke$lambda$6(state);
                    if (interfaceC3750qpInvoke$lambda$6 != null) {
                        interfaceC3750qpInvoke$lambda$6.invoke(DpSize.m5246boximpl(density.mo331toDpSizekrfVVM(IntSizeKt.m5330toSizeozmzZPI(jMo252getSizeYbymL2g))));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(PlatformMagnifierFactory platformMagnifierFactory, MagnifierStyle magnifierStyle, View view, Density density, float f, CC cc, State<? extends InterfaceC3750qp> state, State<Boolean> state2, State<Offset> state3, State<? extends InterfaceC3750qp> state4, MutableState<Offset> mutableState, State<Float> state5, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$platformMagnifierFactory = platformMagnifierFactory;
                this.$style = magnifierStyle;
                this.$view = view;
                this.$density = density;
                this.$zoom = f;
                this.$onNeedsUpdate = cc;
                this.$updatedOnSizeChanged$delegate = state;
                this.$isMagnifierShown$delegate = state2;
                this.$sourceCenterInRoot$delegate = state3;
                this.$updatedMagnifierCenter$delegate = state4;
                this.$anchorPositionInRoot$delegate = mutableState;
                this.$updatedZoom$delegate = state5;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$platformMagnifierFactory, this.$style, this.$view, this.$density, this.$zoom, this.$onNeedsUpdate, this.$updatedOnSizeChanged$delegate, this.$isMagnifierShown$delegate, this.$sourceCenterInRoot$delegate, this.$updatedMagnifierCenter$delegate, this.$anchorPositionInRoot$delegate, this.$updatedZoom$delegate, interfaceC0793Of);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                PlatformMagnifier platformMagnifier;
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    platformMagnifier = (PlatformMagnifier) this.L$0;
                    try {
                        LL.b(obj);
                        platformMagnifier.dismiss();
                        return FW.a;
                    } catch (Throwable th) {
                        th = th;
                        platformMagnifier.dismiss();
                        throw th;
                    }
                }
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.L$0;
                PlatformMagnifier platformMagnifierCreate = this.$platformMagnifierFactory.create(this.$style, this.$view, this.$density, this.$zoom);
                NJ nj = new NJ();
                long jMo252getSizeYbymL2g = platformMagnifierCreate.mo252getSizeYbymL2g();
                Density density = this.$density;
                InterfaceC3750qp interfaceC3750qpInvoke$lambda$6 = AnonymousClass4.invoke$lambda$6(this.$updatedOnSizeChanged$delegate);
                if (interfaceC3750qpInvoke$lambda$6 != null) {
                    interfaceC3750qpInvoke$lambda$6.invoke(DpSize.m5246boximpl(density.mo331toDpSizekrfVVM(IntSizeKt.m5330toSizeozmzZPI(jMo252getSizeYbymL2g))));
                }
                nj.a = jMo252getSizeYbymL2g;
                AbstractC1047Xm.v(AbstractC1047Xm.A(this.$onNeedsUpdate, new C00291(platformMagnifierCreate, null)), interfaceC2052dg);
                try {
                    InterfaceC0939Tm interfaceC0939TmSnapshotFlow = SnapshotStateKt.snapshotFlow(new AnonymousClass2(platformMagnifierCreate, this.$density, this.$isMagnifierShown$delegate, this.$sourceCenterInRoot$delegate, this.$updatedMagnifierCenter$delegate, this.$anchorPositionInRoot$delegate, this.$updatedZoom$delegate, nj, this.$updatedOnSizeChanged$delegate));
                    this.L$0 = platformMagnifierCreate;
                    this.label = 1;
                    if (AbstractC1047Xm.f(interfaceC0939TmSnapshotFlow, this) == objD) {
                        return objD;
                    }
                    platformMagnifier = platformMagnifierCreate;
                    platformMagnifier.dismiss();
                    return FW.a;
                } catch (Throwable th2) {
                    th = th2;
                    platformMagnifier = platformMagnifierCreate;
                    platformMagnifier.dismiss();
                    throw th;
                }
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$3, reason: invalid class name */
        public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ CC $onNeedsUpdate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(CC cc) {
                super(1);
                this.$onNeedsUpdate = cc;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return FW.a;
            }

            public final void invoke(DrawScope drawScope) {
                AbstractC4492zt.h(drawScope, "$this$drawBehind");
                this.$onNeedsUpdate.f(FW.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, float f, InterfaceC3750qp interfaceC3750qp3, PlatformMagnifierFactory platformMagnifierFactory, MagnifierStyle magnifierStyle) {
            super(3);
            this.$sourceCenter = interfaceC3750qp;
            this.$magnifierCenter = interfaceC3750qp2;
            this.$zoom = f;
            this.$onSizeChanged = interfaceC3750qp3;
            this.$platformMagnifierFactory = platformMagnifierFactory;
            this.$style = magnifierStyle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long invoke$lambda$1(MutableState<Offset> mutableState) {
            return mutableState.getValue().m2808unboximpl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invoke$lambda$10(State<Boolean> state) {
            return state.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2(MutableState<Offset> mutableState, long j) {
            mutableState.setValue(Offset.m2787boximpl(j));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InterfaceC3750qp invoke$lambda$3(State<? extends InterfaceC3750qp> state) {
            return state.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InterfaceC3750qp invoke$lambda$4(State<? extends InterfaceC3750qp> state) {
            return state.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$lambda$5(State<Float> state) {
            return state.getValue().floatValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InterfaceC3750qp invoke$lambda$6(State<? extends InterfaceC3750qp> state) {
            return state.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long invoke$lambda$8(State<Offset> state) {
            return state.getValue().m2808unboximpl();
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            AbstractC4492zt.h(modifier, "$this$composed");
            composer.startReplaceableGroup(-454877003);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-454877003, i, -1, "androidx.compose.foundation.magnifier.<anonymous> (Magnifier.kt:270)");
            }
            View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2787boximpl(Offset.Companion.m2813getUnspecifiedF1C5BW0()), null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue;
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$sourceCenter, composer, 0);
            State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(this.$magnifierCenter, composer, 0);
            State stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(Float.valueOf(this.$zoom), composer, 0);
            State stateRememberUpdatedState4 = SnapshotStateKt.rememberUpdatedState(this.$onSizeChanged, composer, 0);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new MagnifierKt$magnifier$4$sourceCenterInRoot$2$1(density, stateRememberUpdatedState, mutableState));
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            State state = (State) objRememberedValue2;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new MagnifierKt$magnifier$4$isMagnifierShown$2$1(state));
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            State state2 = (State) objRememberedValue3;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = AbstractC1224aP.b(1, 0, I8.DROP_OLDEST, 2, null);
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceableGroup();
            CC cc = (CC) objRememberedValue4;
            Float fValueOf = Float.valueOf(this.$platformMagnifierFactory.getCanUpdateZoom() ? 0.0f : this.$zoom);
            MagnifierStyle magnifierStyle = this.$style;
            EffectsKt.LaunchedEffect(new Object[]{view, density, fValueOf, magnifierStyle, Boolean.valueOf(AbstractC4492zt.d(magnifierStyle, MagnifierStyle.Companion.getTextDefault()))}, (InterfaceC0526Fp) new AnonymousClass1(this.$platformMagnifierFactory, this.$style, view, density, this.$zoom, cc, stateRememberUpdatedState4, state2, state, stateRememberUpdatedState2, mutableState, stateRememberUpdatedState3, null), composer, 72);
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(mutableState);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new MagnifierKt$magnifier$4$2$1(mutableState);
                composer.updateRememberedValue(objRememberedValue5);
            }
            composer.endReplaceableGroup();
            Modifier modifierDrawBehind = DrawModifierKt.drawBehind(OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, (InterfaceC3750qp) objRememberedValue5), new AnonymousClass3(cc));
            composer.startReplaceableGroup(1157296644);
            boolean zChanged2 = composer.changed(state);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new MagnifierKt$magnifier$4$4$1(state);
                composer.updateRememberedValue(objRememberedValue6);
            }
            composer.endReplaceableGroup();
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierDrawBehind, false, (InterfaceC3750qp) objRememberedValue6, 1, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return modifierSemantics$default;
        }
    }

    public static final SemanticsPropertyKey<InterfaceC3588op> getMagnifierPositionInRoot() {
        return MagnifierPositionInRoot;
    }

    @ChecksSdkIntAtLeast(api = 28)
    public static final boolean isPlatformMagnifierSupported(int i) {
        return i >= 28;
    }

    public static /* synthetic */ boolean isPlatformMagnifierSupported$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Build.VERSION.SDK_INT;
        }
        return isPlatformMagnifierSupported(i);
    }

    @RequiresApi(28)
    public static final Modifier magnifier(Modifier modifier, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, float f, MagnifierStyle magnifierStyle, InterfaceC3750qp interfaceC3750qp3, PlatformMagnifierFactory platformMagnifierFactory) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "sourceCenter");
        AbstractC4492zt.h(interfaceC3750qp2, "magnifierCenter");
        AbstractC4492zt.h(magnifierStyle, "style");
        AbstractC4492zt.h(platformMagnifierFactory, "platformMagnifierFactory");
        return ComposedModifierKt.composed$default(modifier, null, new AnonymousClass4(interfaceC3750qp, interfaceC3750qp2, f, interfaceC3750qp3, platformMagnifierFactory, magnifierStyle), 1, null);
    }

    public static /* synthetic */ Modifier magnifier$default(Modifier modifier, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, float f, MagnifierStyle magnifierStyle, InterfaceC3750qp interfaceC3750qp3, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC3750qp2 = AnonymousClass1.INSTANCE;
        }
        InterfaceC3750qp interfaceC3750qp4 = interfaceC3750qp2;
        float f2 = (i & 4) != 0 ? Float.NaN : f;
        if ((i & 8) != 0) {
            magnifierStyle = MagnifierStyle.Companion.getDefault();
        }
        MagnifierStyle magnifierStyle2 = magnifierStyle;
        if ((i & 16) != 0) {
            interfaceC3750qp3 = null;
        }
        return magnifier(modifier, interfaceC3750qp, interfaceC3750qp4, f2, magnifierStyle2, interfaceC3750qp3);
    }

    @ExperimentalFoundationApi
    public static final Modifier magnifier(Modifier modifier, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, float f, MagnifierStyle magnifierStyle, InterfaceC3750qp interfaceC3750qp3) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "sourceCenter");
        AbstractC4492zt.h(interfaceC3750qp2, "magnifierCenter");
        AbstractC4492zt.h(magnifierStyle, "style");
        InterfaceC3750qp magnifierKt$magnifier$$inlined$debugInspectorInfo$1 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new MagnifierKt$magnifier$$inlined$debugInspectorInfo$1(interfaceC3750qp, interfaceC3750qp2, f, magnifierStyle) : InspectableValueKt.getNoInspectorInfo();
        Modifier modifierMagnifier = Modifier.Companion;
        if (isPlatformMagnifierSupported$default(0, 1, null)) {
            modifierMagnifier = magnifier(modifierMagnifier, interfaceC3750qp, interfaceC3750qp2, f, magnifierStyle, interfaceC3750qp3, PlatformMagnifierFactory.Companion.getForCurrentPlatform());
        }
        return InspectableValueKt.inspectableWrapper(modifier, magnifierKt$magnifier$$inlined$debugInspectorInfo$1, modifierMagnifier);
    }
}
