package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
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
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C1172Zk;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldPressGestureFilterKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ InterfaceC3750qp $onTap;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2, reason: invalid class name */
        @InterfaceC3252ki(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2", f = "TextFieldPressGestureFilter.kt", l = {54}, m = "invokeSuspend")
        public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ MutableInteractionSource $interactionSource;
            final /* synthetic */ State<InterfaceC3750qp> $onTapState;
            final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
            final /* synthetic */ InterfaceC2052dg $scope;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1, reason: invalid class name and collision with other inner class name */
            @InterfaceC3252ki(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1", f = "TextFieldPressGestureFilter.kt", l = {67}, m = "invokeSuspend")
            public static final class C00561 extends XS implements InterfaceC0552Gp {
                final /* synthetic */ MutableInteractionSource $interactionSource;
                final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
                final /* synthetic */ InterfaceC2052dg $scope;
                /* synthetic */ long J$0;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1, reason: invalid class name and collision with other inner class name */
                @InterfaceC3252ki(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1", f = "TextFieldPressGestureFilter.kt", l = {60, 64}, m = "invokeSuspend")
                public static final class C00571 extends XS implements InterfaceC0526Fp {
                    final /* synthetic */ MutableInteractionSource $interactionSource;
                    final /* synthetic */ long $it;
                    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
                    Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C00571(MutableState<PressInteraction.Press> mutableState, long j, MutableInteractionSource mutableInteractionSource, InterfaceC0793Of interfaceC0793Of) {
                        super(2, interfaceC0793Of);
                        this.$pressedInteraction = mutableState;
                        this.$it = j;
                        this.$interactionSource = mutableInteractionSource;
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                        return new C00571(this.$pressedInteraction, this.$it, this.$interactionSource, interfaceC0793Of);
                    }

                    @Override // defpackage.InterfaceC0526Fp
                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                        return ((C00571) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                    }

                    /* JADX WARN: Code duplicated, block: B:22:0x005a  */
                    /* JADX WARN: Code duplicated, block: B:24:0x0064 A[RETURN] */
                    /* JADX WARN: Code duplicated, block: B:25:0x0065  */
                    @Override // defpackage.AbstractC2171f7
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        MutableState<PressInteraction.Press> mutableState;
                        MutableState<PressInteraction.Press> mutableState2;
                        PressInteraction.Press press;
                        MutableInteractionSource mutableInteractionSource;
                        PressInteraction.Press press2;
                        Object objD = AbstractC0378Bt.d();
                        int i = this.label;
                        if (i != 0) {
                            if (i == 1) {
                                mutableState2 = (MutableState) this.L$0;
                                LL.b(obj);
                            } else {
                                if (i != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                press2 = (PressInteraction.Press) this.L$0;
                                LL.b(obj);
                            }
                            press = press2;
                            this.$pressedInteraction.setValue(press);
                            return FW.a;
                        }
                        LL.b(obj);
                        PressInteraction.Press value = this.$pressedInteraction.getValue();
                        if (value != null) {
                            MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
                            mutableState = this.$pressedInteraction;
                            PressInteraction.Cancel cancel = new PressInteraction.Cancel(value);
                            if (mutableInteractionSource2 != null) {
                                this.L$0 = mutableState;
                                this.label = 1;
                                if (mutableInteractionSource2.emit(cancel, this) == objD) {
                                    return objD;
                                }
                                mutableState2 = mutableState;
                            }
                            mutableState.setValue(null);
                            press = new PressInteraction.Press(this.$it, null);
                            mutableInteractionSource = this.$interactionSource;
                            if (mutableInteractionSource != null) {
                                this.L$0 = press;
                                this.label = 2;
                                if (mutableInteractionSource.emit(press, this) == objD) {
                                    return objD;
                                }
                                press2 = press;
                                press = press2;
                            }
                        } else {
                            press = new PressInteraction.Press(this.$it, null);
                            mutableInteractionSource = this.$interactionSource;
                            if (mutableInteractionSource != null) {
                                this.L$0 = press;
                                this.label = 2;
                                if (mutableInteractionSource.emit(press, this) == objD) {
                                    return objD;
                                }
                                press2 = press;
                                press = press2;
                            }
                        }
                        this.$pressedInteraction.setValue(press);
                        return FW.a;
                        mutableState = mutableState2;
                        mutableState.setValue(null);
                        press = new PressInteraction.Press(this.$it, null);
                        mutableInteractionSource = this.$interactionSource;
                        if (mutableInteractionSource != null) {
                            this.L$0 = press;
                            this.label = 2;
                            if (mutableInteractionSource.emit(press, this) == objD) {
                                return objD;
                            }
                            press2 = press;
                            press = press2;
                        }
                        this.$pressedInteraction.setValue(press);
                        return FW.a;
                    }
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$2, reason: invalid class name and collision with other inner class name */
                @InterfaceC3252ki(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$2", f = "TextFieldPressGestureFilter.kt", l = {76}, m = "invokeSuspend")
                public static final class C00582 extends XS implements InterfaceC0526Fp {
                    final /* synthetic */ MutableInteractionSource $interactionSource;
                    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
                    final /* synthetic */ boolean $success;
                    Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C00582(MutableState<PressInteraction.Press> mutableState, boolean z, MutableInteractionSource mutableInteractionSource, InterfaceC0793Of interfaceC0793Of) {
                        super(2, interfaceC0793Of);
                        this.$pressedInteraction = mutableState;
                        this.$success = z;
                        this.$interactionSource = mutableInteractionSource;
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                        return new C00582(this.$pressedInteraction, this.$success, this.$interactionSource, interfaceC0793Of);
                    }

                    @Override // defpackage.InterfaceC0526Fp
                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                        return ((C00582) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        MutableState<PressInteraction.Press> mutableState;
                        MutableState<PressInteraction.Press> mutableState2;
                        Object objD = AbstractC0378Bt.d();
                        int i = this.label;
                        if (i == 0) {
                            LL.b(obj);
                            PressInteraction.Press value = this.$pressedInteraction.getValue();
                            if (value != null) {
                                boolean z = this.$success;
                                MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                                mutableState = this.$pressedInteraction;
                                Interaction release = z ? new PressInteraction.Release(value) : new PressInteraction.Cancel(value);
                                if (mutableInteractionSource != null) {
                                    this.L$0 = mutableState;
                                    this.label = 1;
                                    if (mutableInteractionSource.emit(release, this) == objD) {
                                        return objD;
                                    }
                                    mutableState2 = mutableState;
                                }
                                mutableState.setValue(null);
                            }
                            return FW.a;
                        }
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutableState2 = (MutableState) this.L$0;
                        LL.b(obj);
                        mutableState = mutableState2;
                        mutableState.setValue(null);
                        return FW.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00561(InterfaceC2052dg interfaceC2052dg, MutableState<PressInteraction.Press> mutableState, MutableInteractionSource mutableInteractionSource, InterfaceC0793Of interfaceC0793Of) {
                    super(3, interfaceC0793Of);
                    this.$scope = interfaceC2052dg;
                    this.$pressedInteraction = mutableState;
                    this.$interactionSource = mutableInteractionSource;
                }

                @Override // defpackage.InterfaceC0552Gp
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return m828invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m2808unboximpl(), (InterfaceC0793Of) obj3);
                }

                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                public final Object m828invoked4ec7I(PressGestureScope pressGestureScope, long j, InterfaceC0793Of interfaceC0793Of) {
                    C00561 c00561 = new C00561(this.$scope, this.$pressedInteraction, this.$interactionSource, interfaceC0793Of);
                    c00561.L$0 = pressGestureScope;
                    c00561.J$0 = j;
                    return c00561.invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objD = AbstractC0378Bt.d();
                    int i = this.label;
                    if (i == 0) {
                        LL.b(obj);
                        PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                        O8.d(this.$scope, null, null, new C00571(this.$pressedInteraction, this.J$0, this.$interactionSource, null), 3, null);
                        this.label = 1;
                        obj = pressGestureScope.tryAwaitRelease(this);
                        if (obj == objD) {
                            return objD;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj);
                    }
                    O8.d(this.$scope, null, null, new C00582(this.$pressedInteraction, ((Boolean) obj).booleanValue(), this.$interactionSource, null), 3, null);
                    return FW.a;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$2, reason: invalid class name and collision with other inner class name */
            public static final class C00592 extends AbstractC2233fv implements InterfaceC3750qp {
                final /* synthetic */ State<InterfaceC3750qp> $onTapState;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C00592(State<? extends InterfaceC3750qp> state) {
                    super(1);
                    this.$onTapState = state;
                }

                @Override // defpackage.InterfaceC3750qp
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m829invokek4lQ0M(((Offset) obj).m2808unboximpl());
                    return FW.a;
                }

                /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m829invokek4lQ0M(long j) {
                    this.$onTapState.getValue().invoke(Offset.m2787boximpl(j));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(InterfaceC2052dg interfaceC2052dg, MutableState<PressInteraction.Press> mutableState, MutableInteractionSource mutableInteractionSource, State<? extends InterfaceC3750qp> state, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$scope = interfaceC2052dg;
                this.$pressedInteraction = mutableState;
                this.$interactionSource = mutableInteractionSource;
                this.$onTapState = state;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$scope, this.$pressedInteraction, this.$interactionSource, this.$onTapState, interfaceC0793Of);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
                return ((AnonymousClass2) create(pointerInputScope, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                    C00561 c00561 = new C00561(this.$scope, this.$pressedInteraction, this.$interactionSource, null);
                    C00592 c00592 = new C00592(this.$onTapState);
                    this.label = 1;
                    if (TapGestureDetectorKt.detectTapAndPress(pointerInputScope, c00561, c00592, this) == objD) {
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
        public AnonymousClass1(InterfaceC3750qp interfaceC3750qp, MutableInteractionSource mutableInteractionSource) {
            super(3);
            this.$onTap = interfaceC3750qp;
            this.$interactionSource = mutableInteractionSource;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            AbstractC4492zt.h(modifier, "$this$composed");
            composer.startReplaceableGroup(-102778667);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-102778667, i, -1, "androidx.compose.foundation.text.tapPressTextFieldModifier.<anonymous> (TextFieldPressGestureFilter.kt:39)");
            }
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composer.endReplaceableGroup();
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue2;
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$onTap, composer, 0);
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            composer.startReplaceableGroup(511388516);
            boolean zChanged = composer.changed(mutableState) | composer.changed(mutableInteractionSource);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$1$1(mutableState, mutableInteractionSource);
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            EffectsKt.DisposableEffect(mutableInteractionSource, (InterfaceC3750qp) objRememberedValue3, composer, 0);
            Modifier.Companion companion2 = Modifier.Companion;
            MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, mutableInteractionSource2, new AnonymousClass2(coroutineScope, mutableState, mutableInteractionSource2, stateRememberUpdatedState, null));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return modifierPointerInput;
        }
    }

    public static final Modifier tapPressTextFieldModifier(Modifier modifier, MutableInteractionSource mutableInteractionSource, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "onTap");
        return z ? ComposedModifierKt.composed$default(modifier, null, new AnonymousClass1(interfaceC3750qp, mutableInteractionSource), 1, null) : modifier;
    }

    public static /* synthetic */ Modifier tapPressTextFieldModifier$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, boolean z, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return tapPressTextFieldModifier(modifier, mutableInteractionSource, z, interfaceC3750qp);
    }
}
