package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AD;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C1172Zk;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.O8;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ModalBottomSheetKt {
    private static final float ModalBottomSheetPositionalThreshold = Dp.m5160constructorimpl(56);
    private static final float ModalBottomSheetVelocityThreshold = Dp.m5160constructorimpl(125);
    private static final float MaxModalBottomSheetWidth = Dp.m5160constructorimpl(640);

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name */
    public static final class AnonymousClass1 implements NestedScrollConnection {
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ AnchoredDraggableState<?> $state;

        public AnonymousClass1(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
            this.$state = anchoredDraggableState;
            this.$orientation = orientation;
        }

        private final float offsetToFloat(long j) {
            return this.$orientation == Orientation.Horizontal ? Offset.m2798getXimpl(j) : Offset.m2799getYimpl(j);
        }

        private final long toOffset(float f) {
            Orientation orientation = this.$orientation;
            float f2 = orientation == Orientation.Horizontal ? f : 0.0f;
            if (orientation != Orientation.Vertical) {
                f = 0.0f;
            }
            return OffsetKt.Offset(f2, f);
        }

        private final float velocityToFloat(long j) {
            return this.$orientation == Orientation.Horizontal ? Velocity.m5385getXimpl(j) : Velocity.m5386getYimpl(j);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
        public Object mo340onPostFlingRZ2iAVY(long j, long j2, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1;
            if (interfaceC0793Of instanceof ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) {
                modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = (ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) interfaceC0793Of;
                int i = modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label = i - Integer.MIN_VALUE;
                } else {
                    modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = new ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, interfaceC0793Of);
                }
            } else {
                modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = new ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, interfaceC0793Of);
            }
            Object obj = modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.result;
            Object objD = AbstractC0378Bt.d();
            int i2 = modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label;
            if (i2 == 0) {
                LL.b(obj);
                AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                float fVelocityToFloat = velocityToFloat(j2);
                modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.J$0 = j2;
                modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label = 1;
                if (anchoredDraggableState.settle(fVelocityToFloat, modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) == objD) {
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j2 = modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.J$0;
                LL.b(obj);
            }
            return Velocity.m5376boximpl(j2);
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
        public long mo341onPostScrollDzOQY0M(long j, long j2, int i) {
            return NestedScrollSource.m3958equalsimpl0(i, NestedScrollSource.Companion.m3963getDragWNlRxjI()) ? toOffset(this.$state.dispatchRawDelta(offsetToFloat(j2))) : Offset.Companion.m2814getZeroF1C5BW0();
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreFling-QWom1Mo */
        public Object mo342onPreFlingQWom1Mo(long j, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1;
            if (interfaceC0793Of instanceof ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) {
                modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = (ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) interfaceC0793Of;
                int i = modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label = i - Integer.MIN_VALUE;
                } else {
                    modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = new ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, interfaceC0793Of);
                }
            } else {
                modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = new ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, interfaceC0793Of);
            }
            Object obj = modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.result;
            Object objD = AbstractC0378Bt.d();
            int i2 = modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label;
            if (i2 == 0) {
                LL.b(obj);
                float fVelocityToFloat = velocityToFloat(j);
                float fRequireOffset = this.$state.requireOffset();
                if (fVelocityToFloat >= 0.0f || fRequireOffset <= this.$state.getMinOffset()) {
                    j = Velocity.Companion.m5396getZero9UxMQ8M();
                } else {
                    AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                    modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.J$0 = j;
                    modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label = 1;
                    if (anchoredDraggableState.settle(fVelocityToFloat, modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) == objD) {
                        return objD;
                    }
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.J$0;
                LL.b(obj);
            }
            return Velocity.m5376boximpl(j);
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
        public long mo343onPreScrollOzD1aCk(long j, int i) {
            float fOffsetToFloat = offsetToFloat(j);
            return (fOffsetToFloat >= 0.0f || !NestedScrollSource.m3958equalsimpl0(i, NestedScrollSource.Companion.m3963getDragWNlRxjI())) ? Offset.Companion.m2814getZeroF1C5BW0() : toOffset(this.$state.dispatchRawDelta(fOffsetToFloat));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetState$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14291 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C14291 INSTANCE = new C14291();

        public C14291() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(ModalBottomSheetValue modalBottomSheetValue) {
            AbstractC4492zt.h(modalBottomSheetValue, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetState$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(ModalBottomSheetValue modalBottomSheetValue) {
            AbstractC4492zt.h(modalBottomSheetValue, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14301 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C14301 INSTANCE = new C14301();

        public C14301() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(ModalBottomSheetValue modalBottomSheetValue) {
            AbstractC4492zt.h(modalBottomSheetValue, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ InterfaceC3750qp $confirmValueChange;
        final /* synthetic */ Density $density;
        final /* synthetic */ ModalBottomSheetValue $initialValue;
        final /* synthetic */ boolean $skipHalfExpanded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ModalBottomSheetValue modalBottomSheetValue, Density density, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, boolean z) {
            super(0);
            this.$initialValue = modalBottomSheetValue;
            this.$density = density;
            this.$animationSpec = animationSpec;
            this.$confirmValueChange = interfaceC3750qp;
            this.$skipHalfExpanded = z;
        }

        @Override // defpackage.InterfaceC3588op
        public final ModalBottomSheetState invoke() {
            return ModalBottomSheetKt.ModalBottomSheetState(this.$initialValue, this.$density, this.$animationSpec, this.$confirmValueChange, this.$skipHalfExpanded);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new AnonymousClass1(anchoredDraggableState, orientation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnchoredDraggableState.AnchorChangedCallback<ModalBottomSheetValue> ModalBottomSheetAnchorChangeCallback(final ModalBottomSheetState modalBottomSheetState, final InterfaceC2052dg interfaceC2052dg) {
        return new AnchoredDraggableState.AnchorChangedCallback<ModalBottomSheetValue>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetAnchorChangeCallback.1

            /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetAnchorChangeCallback$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ModalBottomSheetValue.values().length];
                    try {
                        iArr[ModalBottomSheetValue.Hidden.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ModalBottomSheetValue.HalfExpanded.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ModalBottomSheetValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // androidx.compose.material.AnchoredDraggableState.AnchorChangedCallback
            public final void onAnchorsChanged(ModalBottomSheetValue modalBottomSheetValue, Map<ModalBottomSheetValue, Float> map, Map<ModalBottomSheetValue, Float> map2) {
                ModalBottomSheetValue modalBottomSheetValue2;
                AbstractC4492zt.h(modalBottomSheetValue, "prevTarget");
                AbstractC4492zt.h(map, "prevAnchors");
                AbstractC4492zt.h(map2, "newAnchors");
                Float f = map.get(modalBottomSheetValue);
                int i = WhenMappings.$EnumSwitchMapping$0[modalBottomSheetValue.ordinal()];
                if (i == 1) {
                    modalBottomSheetValue2 = ModalBottomSheetValue.Hidden;
                } else {
                    if (i != 2 && i != 3) {
                        throw new AD();
                    }
                    modalBottomSheetValue2 = ModalBottomSheetValue.HalfExpanded;
                    if (!map2.containsKey(modalBottomSheetValue2)) {
                        modalBottomSheetValue2 = ModalBottomSheetValue.Expanded;
                        if (!map2.containsKey(modalBottomSheetValue2)) {
                            modalBottomSheetValue2 = ModalBottomSheetValue.Hidden;
                        }
                    }
                }
                if (AbstractC4492zt.a(((Number) AbstractC4243wx.h(map2, modalBottomSheetValue2)).floatValue(), f)) {
                    return;
                }
                if (modalBottomSheetState.isAnimationRunning$material_release()) {
                    O8.d(interfaceC2052dg, null, null, new ModalBottomSheetKt$ModalBottomSheetAnchorChangeCallback$1$onAnchorsChanged$1(modalBottomSheetState, modalBottomSheetValue2, null), 3, null);
                } else {
                    if (modalBottomSheetState.trySnapTo$material_release(modalBottomSheetValue2)) {
                        return;
                    }
                    O8.d(interfaceC2052dg, null, null, new ModalBottomSheetKt$ModalBottomSheetAnchorChangeCallback$1$onAnchorsChanged$2(modalBottomSheetState, modalBottomSheetValue2, null), 3, null);
                }
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0137  */
    /* JADX WARN: Code duplicated, block: B:107:0x014b  */
    /* JADX WARN: Code duplicated, block: B:127:0x0184 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:128:0x0186  */
    /* JADX WARN: Code duplicated, block: B:129:0x018b  */
    /* JADX WARN: Code duplicated, block: B:131:0x018f  */
    /* JADX WARN: Code duplicated, block: B:132:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:134:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:137:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:138:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:140:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:144:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:145:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:148:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:149:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:152:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:154:0x020b  */
    /* JADX WARN: Code duplicated, block: B:157:0x0221  */
    /* JADX WARN: Code duplicated, block: B:160:0x0236  */
    /* JADX WARN: Code duplicated, block: B:163:0x0264  */
    /* JADX WARN: Code duplicated, block: B:166:0x0296  */
    /* JADX WARN: Code duplicated, block: B:168:0x029c  */
    /* JADX WARN: Code duplicated, block: B:171:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:176:0x0314  */
    /* JADX WARN: Code duplicated, block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    /* JADX WARN: Code duplicated, block: B:29:0x0058  */
    /* JADX WARN: Code duplicated, block: B:30:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0063  */
    /* JADX WARN: Code duplicated, block: B:34:0x0069  */
    /* JADX WARN: Code duplicated, block: B:35:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:46:0x0088  */
    /* JADX WARN: Code duplicated, block: B:49:0x008e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0094  */
    /* JADX WARN: Code duplicated, block: B:52:0x009b  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:92:0x0102  */
    /* JADX WARN: Code duplicated, block: B:94:0x0107  */
    /* JADX WARN: Code duplicated, block: B:96:0x010d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0110  */
    /* JADX WARN: Code duplicated, block: B:99:0x0115  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ModalBottomSheetLayout-Gs3lGvM, reason: not valid java name */
    public static final void m1151ModalBottomSheetLayoutGs3lGvM(InterfaceC0552Gp interfaceC0552Gp, Modifier modifier, ModalBottomSheetState modalBottomSheetState, boolean z, Shape shape, float f, long j, long j2, long j3, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        boolean z2;
        int i6;
        Shape shape2;
        int i7;
        int i8;
        long j4;
        int i9;
        int i10;
        Modifier modifier3;
        ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState;
        Shape large;
        float fM1150getElevationD9Ej5fM;
        long jM1055getSurface0d7_KjU;
        long jM1069contentColorForek8zF_U;
        long scrimColor;
        ModalBottomSheetState modalBottomSheetState2;
        int i11;
        Object objRememberedValue;
        Composer.Companion companion;
        InterfaceC2052dg coroutineScope;
        boolean zChanged;
        Object objRememberedValue2;
        Composer composer2;
        boolean z3;
        Shape shape3;
        float f2;
        Modifier modifier4;
        long j5;
        ModalBottomSheetState modalBottomSheetState3;
        long j6;
        long j7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i12;
        int i13;
        int i14;
        int i15;
        AbstractC4492zt.h(interfaceC0552Gp, "sheetContent");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-92970288);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i16 = i2 & 2;
        if (i16 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                i3 |= 128;
            }
            i5 = i2 & 8;
            if (i5 != 0) {
                i3 |= 3072;
                z2 = z;
            } else {
                z2 = z;
                if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
            }
            if ((57344 & i) == 0) {
                shape2 = shape;
                if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(shape2)) {
                    i15 = 8192;
                } else {
                    i15 = 16384;
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i7 = i2 & 32;
            if (i7 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            }
            if ((3670016 & i) != 0) {
                if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(j)) {
                    i14 = 524288;
                } else {
                    i14 = 1048576;
                }
                i3 |= i14;
            }
            if ((29360128 & i) != 0) {
                if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                    i13 = 4194304;
                } else {
                    i13 = 8388608;
                }
                i3 |= i13;
            }
            if ((234881024 & i) == 0) {
                j4 = j3;
                if ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j4)) {
                    i12 = 33554432;
                } else {
                    i12 = 67108864;
                }
                i3 |= i12;
            } else {
                j4 = j3;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i9 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i9 = 268435456;
                    }
                }
                i10 = i3;
                if (i4 != 4 && (1533916891 & i10) == 306783378 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modalBottomSheetState3 = modalBottomSheetState;
                    f2 = f;
                    modifier4 = modifier2;
                    j7 = j4;
                    z3 = z2;
                    composer2 = composerStartRestartGroup;
                    shape3 = shape2;
                    j5 = j;
                    j6 = j2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i16 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, (AnimationSpec<Float>) null, (InterfaceC3750qp) null, false, composerStartRestartGroup, 6, 14);
                            i10 &= -897;
                        } else {
                            modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i10 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i7 != 0) {
                            fM1150getElevationD9Ej5fM = ModalBottomSheetDefaults.INSTANCE.m1150getElevationD9Ej5fM();
                        } else {
                            fM1150getElevationD9Ej5fM = f;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i10 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i10 >> 18) & 14);
                            i10 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i10 &= -234881025;
                            scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            scrimColor = j3;
                        }
                        modalBottomSheetState2 = modalBottomSheetStateRememberModalBottomSheetState;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if (i4 != 0) {
                            i10 &= -897;
                        }
                        if ((i2 & 16) != 0) {
                            i10 &= -57345;
                        }
                        if ((i2 & 64) != 0) {
                            i10 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                        }
                        if ((i2 & 256) != 0) {
                            i10 &= -234881025;
                        }
                        fM1150getElevationD9Ej5fM = f;
                        jM1055getSurface0d7_KjU = j;
                        jM1069contentColorForek8zF_U = j2;
                        modifier3 = modifier2;
                        scrimColor = j4;
                        z2 = z2;
                        large = shape2;
                        modalBottomSheetState2 = modalBottomSheetState;
                    }
                    i11 = i10;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-92970288, i11, -1, "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:561)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(502769027);
                    if (modalBottomSheetState2.getDensity$material_release() == null) {
                        EffectsKt.SideEffect(new ModalBottomSheetKt$ModalBottomSheetLayout$1(modalBottomSheetState2, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Orientation orientation = Orientation.Vertical;
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(modalBottomSheetState2) | composerStartRestartGroup.changed(coroutineScope);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = ModalBottomSheetAnchorChangeCallback(modalBottomSheetState2, coroutineScope);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    ModalBottomSheetState modalBottomSheetState4 = modalBottomSheetState2;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composer2, -1731958854, true, new ModalBottomSheetKt$ModalBottomSheetLayout$2(z2, modalBottomSheetState2, orientation, large, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U, fM1150getElevationD9Ej5fM, i11, interfaceC0526Fp, scrimColor, coroutineScope, (AnchoredDraggableState.AnchorChangedCallback) objRememberedValue2, interfaceC0552Gp)), composer2, ((i11 >> 3) & 14) | 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z3 = z2;
                    shape3 = large;
                    f2 = fM1150getElevationD9Ej5fM;
                    modifier4 = modifier3;
                    j5 = jM1055getSurface0d7_KjU;
                    modalBottomSheetState3 = modalBottomSheetState4;
                    j6 = jM1069contentColorForek8zF_U;
                    j7 = scrimColor;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheetKt$ModalBottomSheetLayout$3(interfaceC0552Gp, modifier4, modalBottomSheetState3, z3, shape3, f2, j5, j6, j7, interfaceC0526Fp, i, i2));
            }
            i9 = 805306368;
            i3 |= i9;
            i10 = i3;
            if (i4 != 4) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, (AnimationSpec<Float>) null, (InterfaceC3750qp) null, false, composerStartRestartGroup, 6, 14);
                        i10 &= -897;
                    } else {
                        modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i10 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1150getElevationD9Ej5fM = ModalBottomSheetDefaults.INSTANCE.m1150getElevationD9Ej5fM();
                    } else {
                        fM1150getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i10 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i10 >> 18) & 14);
                        i10 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 &= -234881025;
                        scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        scrimColor = j3;
                    }
                    modalBottomSheetState2 = modalBottomSheetStateRememberModalBottomSheetState;
                } else {
                    if (i16 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, (AnimationSpec<Float>) null, (InterfaceC3750qp) null, false, composerStartRestartGroup, 6, 14);
                        i10 &= -897;
                    } else {
                        modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i10 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1150getElevationD9Ej5fM = ModalBottomSheetDefaults.INSTANCE.m1150getElevationD9Ej5fM();
                    } else {
                        fM1150getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i10 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i10 >> 18) & 14);
                        i10 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 &= -234881025;
                        scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        scrimColor = j3;
                    }
                    modalBottomSheetState2 = modalBottomSheetStateRememberModalBottomSheetState;
                }
                i11 = i10;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-92970288, i11, -1, "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:561)");
                }
                composerStartRestartGroup.startReplaceableGroup(502769027);
                if (modalBottomSheetState2.getDensity$material_release() == null) {
                    EffectsKt.SideEffect(new ModalBottomSheetKt$ModalBottomSheetLayout$1(modalBottomSheetState2, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller2);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller2;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Orientation orientation2 = Orientation.Vertical;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(modalBottomSheetState2) | composerStartRestartGroup.changed(coroutineScope);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = ModalBottomSheetAnchorChangeCallback(modalBottomSheetState2, coroutineScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = ModalBottomSheetAnchorChangeCallback(modalBottomSheetState2, coroutineScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                ModalBottomSheetState modalBottomSheetState5 = modalBottomSheetState2;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composer2, -1731958854, true, new ModalBottomSheetKt$ModalBottomSheetLayout$2(z2, modalBottomSheetState2, orientation2, large, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U, fM1150getElevationD9Ej5fM, i11, interfaceC0526Fp, scrimColor, coroutineScope, (AnchoredDraggableState.AnchorChangedCallback) objRememberedValue2, interfaceC0552Gp)), composer2, ((i11 >> 3) & 14) | 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z2;
                shape3 = large;
                f2 = fM1150getElevationD9Ej5fM;
                modifier4 = modifier3;
                j5 = jM1055getSurface0d7_KjU;
                modalBottomSheetState3 = modalBottomSheetState5;
                j6 = jM1069contentColorForek8zF_U;
                j7 = scrimColor;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, (AnimationSpec<Float>) null, (InterfaceC3750qp) null, false, composerStartRestartGroup, 6, 14);
                        i10 &= -897;
                    } else {
                        modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i10 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1150getElevationD9Ej5fM = ModalBottomSheetDefaults.INSTANCE.m1150getElevationD9Ej5fM();
                    } else {
                        fM1150getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i10 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i10 >> 18) & 14);
                        i10 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 &= -234881025;
                        scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        scrimColor = j3;
                    }
                    modalBottomSheetState2 = modalBottomSheetStateRememberModalBottomSheetState;
                } else {
                    if (i16 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, (AnimationSpec<Float>) null, (InterfaceC3750qp) null, false, composerStartRestartGroup, 6, 14);
                        i10 &= -897;
                    } else {
                        modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i10 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1150getElevationD9Ej5fM = ModalBottomSheetDefaults.INSTANCE.m1150getElevationD9Ej5fM();
                    } else {
                        fM1150getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i10 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i10 >> 18) & 14);
                        i10 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 &= -234881025;
                        scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        scrimColor = j3;
                    }
                    modalBottomSheetState2 = modalBottomSheetStateRememberModalBottomSheetState;
                }
                i11 = i10;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-92970288, i11, -1, "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:561)");
                }
                composerStartRestartGroup.startReplaceableGroup(502769027);
                if (modalBottomSheetState2.getDensity$material_release() == null) {
                    EffectsKt.SideEffect(new ModalBottomSheetKt$ModalBottomSheetLayout$1(modalBottomSheetState2, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller3 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller3);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller3;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Orientation orientation3 = Orientation.Vertical;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(modalBottomSheetState2) | composerStartRestartGroup.changed(coroutineScope);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = ModalBottomSheetAnchorChangeCallback(modalBottomSheetState2, coroutineScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = ModalBottomSheetAnchorChangeCallback(modalBottomSheetState2, coroutineScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                ModalBottomSheetState modalBottomSheetState6 = modalBottomSheetState2;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composer2, -1731958854, true, new ModalBottomSheetKt$ModalBottomSheetLayout$2(z2, modalBottomSheetState2, orientation3, large, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U, fM1150getElevationD9Ej5fM, i11, interfaceC0526Fp, scrimColor, coroutineScope, (AnchoredDraggableState.AnchorChangedCallback) objRememberedValue2, interfaceC0552Gp)), composer2, ((i11 >> 3) & 14) | 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z2;
                shape3 = large;
                f2 = fM1150getElevationD9Ej5fM;
                modifier4 = modifier3;
                j5 = jM1055getSurface0d7_KjU;
                modalBottomSheetState3 = modalBottomSheetState6;
                j6 = jM1069contentColorForek8zF_U;
                j7 = scrimColor;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheetKt$ModalBottomSheetLayout$3(interfaceC0552Gp, modifier4, modalBottomSheetState3, z3, shape3, f2, j5, j6, j7, interfaceC0526Fp, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 128;
        }
        i5 = i2 & 8;
        if (i5 != 0) {
            i3 |= 3072;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
        }
        if ((57344 & i) == 0) {
            shape2 = shape;
            if ((i2 & 16) == 0) {
                i15 = 8192;
            } else {
                i15 = 8192;
            }
            i3 |= i15;
        } else {
            shape2 = shape;
        }
        i7 = i2 & 32;
        if (i7 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((458752 & i) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i8 = 131072;
            } else {
                i8 = 65536;
            }
            i3 |= i8;
        }
        if ((3670016 & i) != 0) {
            if ((i2 & 64) == 0) {
                i14 = 524288;
            } else {
                i14 = 524288;
            }
            i3 |= i14;
        }
        if ((29360128 & i) != 0) {
            if ((i2 & 128) == 0) {
                i13 = 4194304;
            } else {
                i13 = 4194304;
            }
            i3 |= i13;
        }
        if ((234881024 & i) == 0) {
            j4 = j3;
            if ((i2 & 256) == 0) {
                i12 = 33554432;
            } else {
                i12 = 33554432;
            }
            i3 |= i12;
        } else {
            j4 = j3;
        }
        if ((i2 & 512) != 0) {
            if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i9 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i9 = 268435456;
                }
            }
            i10 = i3;
            if (i4 != 4) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, (AnimationSpec<Float>) null, (InterfaceC3750qp) null, false, composerStartRestartGroup, 6, 14);
                        i10 &= -897;
                    } else {
                        modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i10 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1150getElevationD9Ej5fM = ModalBottomSheetDefaults.INSTANCE.m1150getElevationD9Ej5fM();
                    } else {
                        fM1150getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i10 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i10 >> 18) & 14);
                        i10 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 &= -234881025;
                        scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        scrimColor = j3;
                    }
                    modalBottomSheetState2 = modalBottomSheetStateRememberModalBottomSheetState;
                } else {
                    if (i16 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, (AnimationSpec<Float>) null, (InterfaceC3750qp) null, false, composerStartRestartGroup, 6, 14);
                        i10 &= -897;
                    } else {
                        modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i10 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1150getElevationD9Ej5fM = ModalBottomSheetDefaults.INSTANCE.m1150getElevationD9Ej5fM();
                    } else {
                        fM1150getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i10 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i10 >> 18) & 14);
                        i10 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 &= -234881025;
                        scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        scrimColor = j3;
                    }
                    modalBottomSheetState2 = modalBottomSheetStateRememberModalBottomSheetState;
                }
                i11 = i10;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-92970288, i11, -1, "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:561)");
                }
                composerStartRestartGroup.startReplaceableGroup(502769027);
                if (modalBottomSheetState2.getDensity$material_release() == null) {
                    EffectsKt.SideEffect(new ModalBottomSheetKt$ModalBottomSheetLayout$1(modalBottomSheetState2, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller4 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller4);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller4;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Orientation orientation4 = Orientation.Vertical;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(modalBottomSheetState2) | composerStartRestartGroup.changed(coroutineScope);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = ModalBottomSheetAnchorChangeCallback(modalBottomSheetState2, coroutineScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = ModalBottomSheetAnchorChangeCallback(modalBottomSheetState2, coroutineScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                ModalBottomSheetState modalBottomSheetState7 = modalBottomSheetState2;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composer2, -1731958854, true, new ModalBottomSheetKt$ModalBottomSheetLayout$2(z2, modalBottomSheetState2, orientation4, large, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U, fM1150getElevationD9Ej5fM, i11, interfaceC0526Fp, scrimColor, coroutineScope, (AnchoredDraggableState.AnchorChangedCallback) objRememberedValue2, interfaceC0552Gp)), composer2, ((i11 >> 3) & 14) | 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z2;
                shape3 = large;
                f2 = fM1150getElevationD9Ej5fM;
                modifier4 = modifier3;
                j5 = jM1055getSurface0d7_KjU;
                modalBottomSheetState3 = modalBottomSheetState7;
                j6 = jM1069contentColorForek8zF_U;
                j7 = scrimColor;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, (AnimationSpec<Float>) null, (InterfaceC3750qp) null, false, composerStartRestartGroup, 6, 14);
                        i10 &= -897;
                    } else {
                        modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i10 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1150getElevationD9Ej5fM = ModalBottomSheetDefaults.INSTANCE.m1150getElevationD9Ej5fM();
                    } else {
                        fM1150getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i10 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i10 >> 18) & 14);
                        i10 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 &= -234881025;
                        scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        scrimColor = j3;
                    }
                    modalBottomSheetState2 = modalBottomSheetStateRememberModalBottomSheetState;
                } else {
                    if (i16 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, (AnimationSpec<Float>) null, (InterfaceC3750qp) null, false, composerStartRestartGroup, 6, 14);
                        i10 &= -897;
                    } else {
                        modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i10 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1150getElevationD9Ej5fM = ModalBottomSheetDefaults.INSTANCE.m1150getElevationD9Ej5fM();
                    } else {
                        fM1150getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i10 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i10 >> 18) & 14);
                        i10 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 &= -234881025;
                        scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        scrimColor = j3;
                    }
                    modalBottomSheetState2 = modalBottomSheetStateRememberModalBottomSheetState;
                }
                i11 = i10;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-92970288, i11, -1, "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:561)");
                }
                composerStartRestartGroup.startReplaceableGroup(502769027);
                if (modalBottomSheetState2.getDensity$material_release() == null) {
                    EffectsKt.SideEffect(new ModalBottomSheetKt$ModalBottomSheetLayout$1(modalBottomSheetState2, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller5 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller5);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller5;
                }
                composerStartRestartGroup.endReplaceableGroup();
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Orientation orientation5 = Orientation.Vertical;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(modalBottomSheetState2) | composerStartRestartGroup.changed(coroutineScope);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = ModalBottomSheetAnchorChangeCallback(modalBottomSheetState2, coroutineScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = ModalBottomSheetAnchorChangeCallback(modalBottomSheetState2, coroutineScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                ModalBottomSheetState modalBottomSheetState8 = modalBottomSheetState2;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composer2, -1731958854, true, new ModalBottomSheetKt$ModalBottomSheetLayout$2(z2, modalBottomSheetState2, orientation5, large, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U, fM1150getElevationD9Ej5fM, i11, interfaceC0526Fp, scrimColor, coroutineScope, (AnchoredDraggableState.AnchorChangedCallback) objRememberedValue2, interfaceC0552Gp)), composer2, ((i11 >> 3) & 14) | 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = z2;
                shape3 = large;
                f2 = fM1150getElevationD9Ej5fM;
                modifier4 = modifier3;
                j5 = jM1055getSurface0d7_KjU;
                modalBottomSheetState3 = modalBottomSheetState8;
                j6 = jM1069contentColorForek8zF_U;
                j7 = scrimColor;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheetKt$ModalBottomSheetLayout$3(interfaceC0552Gp, modifier4, modalBottomSheetState3, z3, shape3, f2, j5, j6, j7, interfaceC0526Fp, i, i2));
        }
        i9 = 805306368;
        i3 |= i9;
        i10 = i3;
        if (i4 != 4) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, (AnimationSpec<Float>) null, (InterfaceC3750qp) null, false, composerStartRestartGroup, 6, 14);
                    i10 &= -897;
                } else {
                    modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i10 &= -57345;
                } else {
                    large = shape2;
                }
                if (i7 != 0) {
                    fM1150getElevationD9Ej5fM = ModalBottomSheetDefaults.INSTANCE.m1150getElevationD9Ej5fM();
                } else {
                    fM1150getElevationD9Ej5fM = f;
                }
                if ((i2 & 64) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i10 &= -3670017;
                } else {
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i2 & 128) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i10 >> 18) & 14);
                    i10 &= -29360129;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    i10 &= -234881025;
                    scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                } else {
                    scrimColor = j3;
                }
                modalBottomSheetState2 = modalBottomSheetStateRememberModalBottomSheetState;
            } else {
                if (i16 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, (AnimationSpec<Float>) null, (InterfaceC3750qp) null, false, composerStartRestartGroup, 6, 14);
                    i10 &= -897;
                } else {
                    modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i10 &= -57345;
                } else {
                    large = shape2;
                }
                if (i7 != 0) {
                    fM1150getElevationD9Ej5fM = ModalBottomSheetDefaults.INSTANCE.m1150getElevationD9Ej5fM();
                } else {
                    fM1150getElevationD9Ej5fM = f;
                }
                if ((i2 & 64) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i10 &= -3670017;
                } else {
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i2 & 128) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i10 >> 18) & 14);
                    i10 &= -29360129;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    i10 &= -234881025;
                    scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                } else {
                    scrimColor = j3;
                }
                modalBottomSheetState2 = modalBottomSheetStateRememberModalBottomSheetState;
            }
            i11 = i10;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-92970288, i11, -1, "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:561)");
            }
            composerStartRestartGroup.startReplaceableGroup(502769027);
            if (modalBottomSheetState2.getDensity$material_release() == null) {
                EffectsKt.SideEffect(new ModalBottomSheetKt$ModalBottomSheetLayout$1(modalBottomSheetState2, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller6 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller6);
                objRememberedValue = compositionScopedCoroutineScopeCanceller6;
            }
            composerStartRestartGroup.endReplaceableGroup();
            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            Orientation orientation6 = Orientation.Vertical;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(modalBottomSheetState2) | composerStartRestartGroup.changed(coroutineScope);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = ModalBottomSheetAnchorChangeCallback(modalBottomSheetState2, coroutineScope);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = ModalBottomSheetAnchorChangeCallback(modalBottomSheetState2, coroutineScope);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ModalBottomSheetState modalBottomSheetState9 = modalBottomSheetState2;
            composer2 = composerStartRestartGroup;
            BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composer2, -1731958854, true, new ModalBottomSheetKt$ModalBottomSheetLayout$2(z2, modalBottomSheetState2, orientation6, large, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U, fM1150getElevationD9Ej5fM, i11, interfaceC0526Fp, scrimColor, coroutineScope, (AnchoredDraggableState.AnchorChangedCallback) objRememberedValue2, interfaceC0552Gp)), composer2, ((i11 >> 3) & 14) | 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z3 = z2;
            shape3 = large;
            f2 = fM1150getElevationD9Ej5fM;
            modifier4 = modifier3;
            j5 = jM1055getSurface0d7_KjU;
            modalBottomSheetState3 = modalBottomSheetState9;
            j6 = jM1069contentColorForek8zF_U;
            j7 = scrimColor;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, (AnimationSpec<Float>) null, (InterfaceC3750qp) null, false, composerStartRestartGroup, 6, 14);
                    i10 &= -897;
                } else {
                    modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i10 &= -57345;
                } else {
                    large = shape2;
                }
                if (i7 != 0) {
                    fM1150getElevationD9Ej5fM = ModalBottomSheetDefaults.INSTANCE.m1150getElevationD9Ej5fM();
                } else {
                    fM1150getElevationD9Ej5fM = f;
                }
                if ((i2 & 64) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i10 &= -3670017;
                } else {
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i2 & 128) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i10 >> 18) & 14);
                    i10 &= -29360129;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    i10 &= -234881025;
                    scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                } else {
                    scrimColor = j3;
                }
                modalBottomSheetState2 = modalBottomSheetStateRememberModalBottomSheetState;
            } else {
                if (i16 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, (AnimationSpec<Float>) null, (InterfaceC3750qp) null, false, composerStartRestartGroup, 6, 14);
                    i10 &= -897;
                } else {
                    modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i10 &= -57345;
                } else {
                    large = shape2;
                }
                if (i7 != 0) {
                    fM1150getElevationD9Ej5fM = ModalBottomSheetDefaults.INSTANCE.m1150getElevationD9Ej5fM();
                } else {
                    fM1150getElevationD9Ej5fM = f;
                }
                if ((i2 & 64) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i10 &= -3670017;
                } else {
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i2 & 128) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i10 >> 18) & 14);
                    i10 &= -29360129;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    i10 &= -234881025;
                    scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                } else {
                    scrimColor = j3;
                }
                modalBottomSheetState2 = modalBottomSheetStateRememberModalBottomSheetState;
            }
            i11 = i10;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-92970288, i11, -1, "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:561)");
            }
            composerStartRestartGroup.startReplaceableGroup(502769027);
            if (modalBottomSheetState2.getDensity$material_release() == null) {
                EffectsKt.SideEffect(new ModalBottomSheetKt$ModalBottomSheetLayout$1(modalBottomSheetState2, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller7 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller7);
                objRememberedValue = compositionScopedCoroutineScopeCanceller7;
            }
            composerStartRestartGroup.endReplaceableGroup();
            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            Orientation orientation7 = Orientation.Vertical;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(modalBottomSheetState2) | composerStartRestartGroup.changed(coroutineScope);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = ModalBottomSheetAnchorChangeCallback(modalBottomSheetState2, coroutineScope);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = ModalBottomSheetAnchorChangeCallback(modalBottomSheetState2, coroutineScope);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ModalBottomSheetState modalBottomSheetState10 = modalBottomSheetState2;
            composer2 = composerStartRestartGroup;
            BoxWithConstraintsKt.BoxWithConstraints(modifier3, null, false, ComposableLambdaKt.composableLambda(composer2, -1731958854, true, new ModalBottomSheetKt$ModalBottomSheetLayout$2(z2, modalBottomSheetState2, orientation7, large, jM1055getSurface0d7_KjU, jM1069contentColorForek8zF_U, fM1150getElevationD9Ej5fM, i11, interfaceC0526Fp, scrimColor, coroutineScope, (AnchoredDraggableState.AnchorChangedCallback) objRememberedValue2, interfaceC0552Gp)), composer2, ((i11 >> 3) & 14) | 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z3 = z2;
            shape3 = large;
            f2 = fM1150getElevationD9Ej5fM;
            modifier4 = modifier3;
            j5 = jM1055getSurface0d7_KjU;
            modalBottomSheetState3 = modalBottomSheetState10;
            j6 = jM1069contentColorForek8zF_U;
            j7 = scrimColor;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheetKt$ModalBottomSheetLayout$3(interfaceC0552Gp, modifier4, modalBottomSheetState3, z3, shape3, f2, j5, j6, j7, interfaceC0526Fp, i, i2));
    }

    @ExperimentalMaterialApi
    public static final ModalBottomSheetState ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, Density density, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, boolean z) {
        AbstractC4492zt.h(modalBottomSheetValue, "initialValue");
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(animationSpec, "animationSpec");
        AbstractC4492zt.h(interfaceC3750qp, "confirmValueChange");
        ModalBottomSheetState modalBottomSheetState = new ModalBottomSheetState(modalBottomSheetValue, animationSpec, z, interfaceC3750qp);
        modalBottomSheetState.setDensity$material_release(density);
        return modalBottomSheetState;
    }

    public static /* synthetic */ ModalBottomSheetState ModalBottomSheetState$default(ModalBottomSheetValue modalBottomSheetValue, Density density, AnimationSpec animationSpec, InterfaceC3750qp interfaceC3750qp, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 8) != 0) {
            interfaceC3750qp = C14291.INSTANCE;
        }
        if ((i & 16) != 0) {
            z = false;
        }
        return ModalBottomSheetState(modalBottomSheetValue, density, animationSpec, interfaceC3750qp, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m1152Scrim3JVO9M(long j, InterfaceC3588op interfaceC3588op, boolean z, Composer composer, int i) {
        int i2;
        Modifier modifierSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(-526532668);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-526532668, i2, -1, "androidx.compose.material.Scrim (ModalBottomSheet.kt:694)");
            }
            if (j != Color.Companion.m3068getUnspecified0d7_KjU()) {
                State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                String strM1225getString4foXLRw = Strings_androidKt.m1225getString4foXLRw(Strings.Companion.m1219getCloseSheetUdPEhr4(), composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(1010559499);
                if (z) {
                    Modifier.Companion companion = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    boolean zChanged = composerStartRestartGroup.changed(interfaceC3588op);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new ModalBottomSheetKt$Scrim$dismissModifier$1$1(interfaceC3588op, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, interfaceC3588op, (InterfaceC0526Fp) objRememberedValue);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    boolean zChanged2 = composerStartRestartGroup.changed(strM1225getString4foXLRw) | composerStartRestartGroup.changed(interfaceC3588op);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = new ModalBottomSheetKt$Scrim$dismissModifier$2$1(strM1225getString4foXLRw, interfaceC3588op);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifierSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (InterfaceC3750qp) objRememberedValue2);
                } else {
                    modifierSemantics = Modifier.Companion;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null).then(modifierSemantics);
                Color colorM3022boximpl = Color.m3022boximpl(j);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                boolean zChanged3 = composerStartRestartGroup.changed(colorM3022boximpl) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                    objRememberedValue3 = new ModalBottomSheetKt$Scrim$1$1(j, stateAnimateFloatAsState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierThen, (InterfaceC3750qp) objRememberedValue3, composerStartRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheetKt$Scrim$2(j, interfaceC3588op, z, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    @Composable
    @ExperimentalMaterialApi
    public static final ModalBottomSheetState rememberModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, boolean z, Composer composer, int i, int i2) {
        AbstractC4492zt.h(modalBottomSheetValue, "initialValue");
        composer.startReplaceableGroup(-126412120);
        AnimationSpec<Float> animationSpec2 = (i2 & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec;
        InterfaceC3750qp interfaceC3750qp2 = (i2 & 4) != 0 ? C14301.INSTANCE : interfaceC3750qp;
        boolean z2 = (i2 & 8) != 0 ? false : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-126412120, i, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:436)");
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        composer.startMovableGroup(170051607, modalBottomSheetValue);
        ModalBottomSheetState modalBottomSheetState = (ModalBottomSheetState) RememberSaveableKt.m2674rememberSaveable(new Object[]{modalBottomSheetValue, animationSpec2, Boolean.valueOf(z2), interfaceC3750qp2, density}, (Saver) ModalBottomSheetState.Companion.Saver(animationSpec2, interfaceC3750qp2, z2, density), (String) null, (InterfaceC3588op) new AnonymousClass2(modalBottomSheetValue, density, animationSpec2, interfaceC3750qp2, z2), composer, 72, 4);
        composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modalBottomSheetState;
    }

    @ExperimentalMaterialApi
    public static final ModalBottomSheetState ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, boolean z) {
        AbstractC4492zt.h(modalBottomSheetValue, "initialValue");
        AbstractC4492zt.h(animationSpec, "animationSpec");
        AbstractC4492zt.h(interfaceC3750qp, "confirmValueChange");
        return new ModalBottomSheetState(modalBottomSheetValue, animationSpec, z, interfaceC3750qp);
    }

    public static /* synthetic */ ModalBottomSheetState ModalBottomSheetState$default(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec animationSpec, InterfaceC3750qp interfaceC3750qp, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 4) != 0) {
            interfaceC3750qp = AnonymousClass3.INSTANCE;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return ModalBottomSheetState(modalBottomSheetValue, animationSpec, interfaceC3750qp, z);
    }

    @Composable
    @ExperimentalMaterialApi
    public static final ModalBottomSheetState rememberModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, boolean z, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        AbstractC4492zt.h(modalBottomSheetValue, "initialValue");
        AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
        composer.startReplaceableGroup(-409288536);
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-409288536, i, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:490)");
        }
        ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(modalBottomSheetValue, animationSpec2, interfaceC3750qp, z, composer, (i & 14) | 64 | ((i >> 3) & 896) | ((i << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modalBottomSheetStateRememberModalBottomSheetState;
    }

    @Composable
    @ExperimentalMaterialApi
    public static final ModalBottomSheetState rememberModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        AbstractC4492zt.h(modalBottomSheetValue, "initialValue");
        AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
        composer.startReplaceableGroup(-1928569212);
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1928569212, i, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:519)");
        }
        ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(modalBottomSheetValue, animationSpec2, interfaceC3750qp, false, composer, (i & 14) | 3136 | (i & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modalBottomSheetStateRememberModalBottomSheetState;
    }
}
