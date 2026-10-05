package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
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
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C1172Zk;
import defpackage.HV;
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
public final class DrawerKt {
    private static final float BottomDrawerOpenFraction = 0.5f;
    private static final float DrawerPositionalThreshold;
    private static final float EndDrawerPadding;
    private static final float DrawerVelocityThreshold = Dp.m5160constructorimpl(400);
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$BottomDrawerState$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14181 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C14181 INSTANCE = new C14181();

        public C14181() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(BottomDrawerValue bottomDrawerValue) {
            AbstractC4492zt.h(bottomDrawerValue, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14191 implements NestedScrollConnection {
        final /* synthetic */ AnchoredDraggableState<?> $state;
        private final Orientation orientation = Orientation.Vertical;

        public C14191(AnchoredDraggableState<?> anchoredDraggableState) {
            this.$state = anchoredDraggableState;
        }

        private final float offsetToFloat(long j) {
            return this.orientation == Orientation.Horizontal ? Offset.m2798getXimpl(j) : Offset.m2799getYimpl(j);
        }

        private final long toOffset(float f) {
            Orientation orientation = this.orientation;
            float f2 = orientation == Orientation.Horizontal ? f : 0.0f;
            if (orientation != Orientation.Vertical) {
                f = 0.0f;
            }
            return OffsetKt.Offset(f2, f);
        }

        private final float velocityToFloat(long j) {
            return this.orientation == Orientation.Horizontal ? Velocity.m5385getXimpl(j) : Velocity.m5386getYimpl(j);
        }

        public final Orientation getOrientation() {
            return this.orientation;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
        public Object mo340onPostFlingRZ2iAVY(long j, long j2, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1;
            if (interfaceC0793Of instanceof DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) {
                drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = (DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) interfaceC0793Of;
                int i = drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label = i - Integer.MIN_VALUE;
                } else {
                    drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = new DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, interfaceC0793Of);
                }
            } else {
                drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = new DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, interfaceC0793Of);
            }
            Object obj = drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.result;
            Object objD = AbstractC0378Bt.d();
            int i2 = drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label;
            if (i2 == 0) {
                LL.b(obj);
                AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                float fVelocityToFloat = velocityToFloat(j2);
                drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.J$0 = j2;
                drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label = 1;
                if (anchoredDraggableState.settle(fVelocityToFloat, drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) == objD) {
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j2 = drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.J$0;
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
            DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1;
            if (interfaceC0793Of instanceof DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) {
                drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = (DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) interfaceC0793Of;
                int i = drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label = i - Integer.MIN_VALUE;
                } else {
                    drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = new DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, interfaceC0793Of);
                }
            } else {
                drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = new DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, interfaceC0793Of);
            }
            Object obj = drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.result;
            Object objD = AbstractC0378Bt.d();
            int i2 = drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label;
            if (i2 == 0) {
                LL.b(obj);
                float fVelocityToFloat = velocityToFloat(j);
                float fRequireOffset = this.$state.requireOffset();
                if (fVelocityToFloat >= 0.0f || fRequireOffset <= this.$state.getMinOffset()) {
                    j = Velocity.Companion.m5396getZero9UxMQ8M();
                } else {
                    AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                    drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.J$0 = j;
                    drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label = 1;
                    if (anchoredDraggableState.settle(fVelocityToFloat, drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) == objD) {
                        return objD;
                    }
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = drawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.J$0;
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

    /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$rememberBottomDrawerState$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14201 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C14201 INSTANCE = new C14201();

        public C14201() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(BottomDrawerValue bottomDrawerValue) {
            AbstractC4492zt.h(bottomDrawerValue, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$rememberDrawerState$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14211 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C14211 INSTANCE = new C14211();

        public C14211() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(DrawerValue drawerValue) {
            AbstractC4492zt.h(drawerValue, "it");
            return Boolean.TRUE;
        }
    }

    static {
        float f = 56;
        EndDrawerPadding = Dp.m5160constructorimpl(f);
        DrawerPositionalThreshold = Dp.m5160constructorimpl(f);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0118  */
    /* JADX WARN: Code duplicated, block: B:107:0x013b  */
    /* JADX WARN: Code duplicated, block: B:109:0x014e  */
    /* JADX WARN: Code duplicated, block: B:129:0x0192 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:130:0x0194  */
    /* JADX WARN: Code duplicated, block: B:131:0x0197  */
    /* JADX WARN: Code duplicated, block: B:134:0x019b  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:137:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:140:0x01af  */
    /* JADX WARN: Code duplicated, block: B:141:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:143:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:144:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:147:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:148:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:151:0x01df  */
    /* JADX WARN: Code duplicated, block: B:152:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:155:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:156:0x0207  */
    /* JADX WARN: Code duplicated, block: B:159:0x021f  */
    /* JADX WARN: Code duplicated, block: B:162:0x0234  */
    /* JADX WARN: Code duplicated, block: B:165:0x0262  */
    /* JADX WARN: Code duplicated, block: B:168:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:173:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0068  */
    /* JADX WARN: Code duplicated, block: B:36:0x006b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0074  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:45:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0096  */
    /* JADX WARN: Code duplicated, block: B:54:0x009e  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:91:0x0100  */
    /* JADX WARN: Code duplicated, block: B:94:0x0105  */
    /* JADX WARN: Code duplicated, block: B:96:0x010a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0110  */
    /* JADX WARN: Code duplicated, block: B:99:0x0113  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: BottomDrawer-Gs3lGvM, reason: not valid java name */
    public static final void m1092BottomDrawerGs3lGvM(InterfaceC0552Gp interfaceC0552Gp, Modifier modifier, BottomDrawerState bottomDrawerState, boolean z, Shape shape, float f, long j, long j2, long j3, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        boolean z2;
        int i6;
        Shape shape2;
        int i7;
        int i8;
        int i9;
        Modifier modifier3;
        BottomDrawerState bottomDrawerStateRememberBottomDrawerState;
        Shape large;
        float fM1091getElevationD9Ej5fM;
        long jM1055getSurface0d7_KjU;
        long jM1069contentColorForek8zF_U;
        int i10;
        boolean z3;
        Modifier modifier4;
        Shape shape3;
        Object objRememberedValue;
        Composer composer2;
        boolean z4;
        Shape shape4;
        float f2;
        BottomDrawerState bottomDrawerState2;
        long j4;
        long j5;
        long j6;
        Modifier modifier5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        int i12;
        int i13;
        AbstractC4492zt.h(interfaceC0552Gp, "drawerContent");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(625649286);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
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
                if ((i & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        int i15 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                        i3 |= i15;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i7 = i2 & 32;
                if (i7 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i3 |= i8;
                }
                if ((i & 3670016) != 0) {
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(j)) {
                        i13 = 524288;
                    } else {
                        i13 = 1048576;
                    }
                    i3 |= i13;
                }
                if ((i & 29360128) != 0) {
                    if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                        i12 = 4194304;
                    } else {
                        i12 = 8388608;
                    }
                    i3 |= i12;
                }
                if ((234881024 & i) != 0) {
                    if ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j3)) {
                        i11 = 33554432;
                    } else {
                        i11 = 67108864;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i9 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i9 = 268435456;
                        }
                    }
                    if (i4 != 4 && (1533916891 & i3) == 306783378 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        bottomDrawerState2 = bottomDrawerState;
                        f2 = f;
                        modifier5 = modifier2;
                        z4 = z2;
                        shape4 = shape2;
                        composer2 = composerStartRestartGroup;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i14 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                            }
                            if (i5 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i7 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f;
                            }
                            if ((i2 & 64) != 0) {
                                jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                jM1055getSurface0d7_KjU = j;
                            }
                            if ((i2 & 128) != 0) {
                                jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                jM1069contentColorForek8zF_U = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i10 = i3 & (-234881025);
                                z3 = z2;
                                j2 = jM1069contentColorForek8zF_U;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                shape3 = large;
                                f = fM1091getElevationD9Ej5fM;
                                j = jM1055getSurface0d7_KjU;
                                modifier4 = modifier3;
                                bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                            } else {
                                j3 = j3;
                                i10 = i3;
                                z3 = z2;
                                j = jM1055getSurface0d7_KjU;
                                j2 = jM1069contentColorForek8zF_U;
                                modifier4 = modifier3;
                                shape3 = large;
                                bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                                f = fM1091getElevationD9Ej5fM;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if (i4 != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                            }
                            i10 = (i2 & 256) != 0 ? i3 & (-234881025) : i3;
                            z3 = z2;
                            shape3 = shape2;
                            modifier4 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(625649286, i10, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:640)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-1561647407);
                        if (bottomDrawerState.getDensity$material_release() == null) {
                            EffectsKt.SideEffect(new DrawerKt$BottomDrawer$1(bottomDrawerState, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier6 = modifier4;
                        BottomDrawerState bottomDrawerState3 = bottomDrawerState;
                        composer2 = composerStartRestartGroup;
                        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$2(z3, bottomDrawerState, interfaceC0526Fp, i10, j3, coroutineScope, shape3, j, j2, f, interfaceC0552Gp)), composer2, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        shape4 = shape3;
                        f2 = f;
                        bottomDrawerState2 = bottomDrawerState3;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                        modifier5 = modifier6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$BottomDrawer$3(interfaceC0552Gp, modifier5, bottomDrawerState2, z4, shape4, f2, j4, j5, j6, interfaceC0526Fp, i, i2));
                }
                i9 = 805306368;
                i3 |= i9;
                if (i4 != 4) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i7 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i10 = i3 & (-234881025);
                            z3 = z2;
                            j2 = jM1069contentColorForek8zF_U;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            shape3 = large;
                            f = fM1091getElevationD9Ej5fM;
                            j = jM1055getSurface0d7_KjU;
                            modifier4 = modifier3;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        } else {
                            j3 = j3;
                            i10 = i3;
                            z3 = z2;
                            j = jM1055getSurface0d7_KjU;
                            j2 = jM1069contentColorForek8zF_U;
                            modifier4 = modifier3;
                            shape3 = large;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                            f = fM1091getElevationD9Ej5fM;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i7 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i10 = i3 & (-234881025);
                            z3 = z2;
                            j2 = jM1069contentColorForek8zF_U;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            shape3 = large;
                            f = fM1091getElevationD9Ej5fM;
                            j = jM1055getSurface0d7_KjU;
                            modifier4 = modifier3;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        } else {
                            j3 = j3;
                            i10 = i3;
                            z3 = z2;
                            j = jM1055getSurface0d7_KjU;
                            j2 = jM1069contentColorForek8zF_U;
                            modifier4 = modifier3;
                            shape3 = large;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                            f = fM1091getElevationD9Ej5fM;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(625649286, i10, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:640)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-1561647407);
                    if (bottomDrawerState.getDensity$material_release() == null) {
                        EffectsKt.SideEffect(new DrawerKt$BottomDrawer$1(bottomDrawerState, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller2);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller2;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier7 = modifier4;
                    BottomDrawerState bottomDrawerState4 = bottomDrawerState;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$2(z3, bottomDrawerState, interfaceC0526Fp, i10, j3, coroutineScope2, shape3, j, j2, f, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    shape4 = shape3;
                    f2 = f;
                    bottomDrawerState2 = bottomDrawerState4;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                    modifier5 = modifier7;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i7 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i10 = i3 & (-234881025);
                            z3 = z2;
                            j2 = jM1069contentColorForek8zF_U;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            shape3 = large;
                            f = fM1091getElevationD9Ej5fM;
                            j = jM1055getSurface0d7_KjU;
                            modifier4 = modifier3;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        } else {
                            j3 = j3;
                            i10 = i3;
                            z3 = z2;
                            j = jM1055getSurface0d7_KjU;
                            j2 = jM1069contentColorForek8zF_U;
                            modifier4 = modifier3;
                            shape3 = large;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                            f = fM1091getElevationD9Ej5fM;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i7 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i10 = i3 & (-234881025);
                            z3 = z2;
                            j2 = jM1069contentColorForek8zF_U;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            shape3 = large;
                            f = fM1091getElevationD9Ej5fM;
                            j = jM1055getSurface0d7_KjU;
                            modifier4 = modifier3;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        } else {
                            j3 = j3;
                            i10 = i3;
                            z3 = z2;
                            j = jM1055getSurface0d7_KjU;
                            j2 = jM1069contentColorForek8zF_U;
                            modifier4 = modifier3;
                            shape3 = large;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                            f = fM1091getElevationD9Ej5fM;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(625649286, i10, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:640)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-1561647407);
                    if (bottomDrawerState.getDensity$material_release() == null) {
                        EffectsKt.SideEffect(new DrawerKt$BottomDrawer$1(bottomDrawerState, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller3 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller3);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller3;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope3 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier8 = modifier4;
                    BottomDrawerState bottomDrawerState5 = bottomDrawerState;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$2(z3, bottomDrawerState, interfaceC0526Fp, i10, j3, coroutineScope3, shape3, j, j2, f, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    shape4 = shape3;
                    f2 = f;
                    bottomDrawerState2 = bottomDrawerState5;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                    modifier5 = modifier8;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$BottomDrawer$3(interfaceC0552Gp, modifier5, bottomDrawerState2, z4, shape4, f2, j4, j5, j6, interfaceC0526Fp, i, i2));
            }
            i3 |= 3072;
            z2 = z;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i7 = i2 & 32;
            if (i7 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i13 = 524288;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            if ((i & 29360128) != 0) {
                if ((i2 & 128) == 0) {
                    i12 = 4194304;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((234881024 & i) != 0) {
                if ((i2 & 256) == 0) {
                    i11 = 33554432;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i9 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i9 = 268435456;
                    }
                }
                if (i4 != 4) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i7 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i10 = i3 & (-234881025);
                            z3 = z2;
                            j2 = jM1069contentColorForek8zF_U;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            shape3 = large;
                            f = fM1091getElevationD9Ej5fM;
                            j = jM1055getSurface0d7_KjU;
                            modifier4 = modifier3;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        } else {
                            j3 = j3;
                            i10 = i3;
                            z3 = z2;
                            j = jM1055getSurface0d7_KjU;
                            j2 = jM1069contentColorForek8zF_U;
                            modifier4 = modifier3;
                            shape3 = large;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                            f = fM1091getElevationD9Ej5fM;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i7 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i10 = i3 & (-234881025);
                            z3 = z2;
                            j2 = jM1069contentColorForek8zF_U;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            shape3 = large;
                            f = fM1091getElevationD9Ej5fM;
                            j = jM1055getSurface0d7_KjU;
                            modifier4 = modifier3;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        } else {
                            j3 = j3;
                            i10 = i3;
                            z3 = z2;
                            j = jM1055getSurface0d7_KjU;
                            j2 = jM1069contentColorForek8zF_U;
                            modifier4 = modifier3;
                            shape3 = large;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                            f = fM1091getElevationD9Ej5fM;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(625649286, i10, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:640)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-1561647407);
                    if (bottomDrawerState.getDensity$material_release() == null) {
                        EffectsKt.SideEffect(new DrawerKt$BottomDrawer$1(bottomDrawerState, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller4 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller4);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller4;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope4 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier9 = modifier4;
                    BottomDrawerState bottomDrawerState6 = bottomDrawerState;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$2(z3, bottomDrawerState, interfaceC0526Fp, i10, j3, coroutineScope4, shape3, j, j2, f, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    shape4 = shape3;
                    f2 = f;
                    bottomDrawerState2 = bottomDrawerState6;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                    modifier5 = modifier9;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i7 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i10 = i3 & (-234881025);
                            z3 = z2;
                            j2 = jM1069contentColorForek8zF_U;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            shape3 = large;
                            f = fM1091getElevationD9Ej5fM;
                            j = jM1055getSurface0d7_KjU;
                            modifier4 = modifier3;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        } else {
                            j3 = j3;
                            i10 = i3;
                            z3 = z2;
                            j = jM1055getSurface0d7_KjU;
                            j2 = jM1069contentColorForek8zF_U;
                            modifier4 = modifier3;
                            shape3 = large;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                            f = fM1091getElevationD9Ej5fM;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i7 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i10 = i3 & (-234881025);
                            z3 = z2;
                            j2 = jM1069contentColorForek8zF_U;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            shape3 = large;
                            f = fM1091getElevationD9Ej5fM;
                            j = jM1055getSurface0d7_KjU;
                            modifier4 = modifier3;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        } else {
                            j3 = j3;
                            i10 = i3;
                            z3 = z2;
                            j = jM1055getSurface0d7_KjU;
                            j2 = jM1069contentColorForek8zF_U;
                            modifier4 = modifier3;
                            shape3 = large;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                            f = fM1091getElevationD9Ej5fM;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(625649286, i10, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:640)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-1561647407);
                    if (bottomDrawerState.getDensity$material_release() == null) {
                        EffectsKt.SideEffect(new DrawerKt$BottomDrawer$1(bottomDrawerState, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller5 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller5);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller5;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope5 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier10 = modifier4;
                    BottomDrawerState bottomDrawerState7 = bottomDrawerState;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$2(z3, bottomDrawerState, interfaceC0526Fp, i10, j3, coroutineScope5, shape3, j, j2, f, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    shape4 = shape3;
                    f2 = f;
                    bottomDrawerState2 = bottomDrawerState7;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                    modifier5 = modifier10;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$BottomDrawer$3(interfaceC0552Gp, modifier5, bottomDrawerState2, z4, shape4, f2, j4, j5, j6, interfaceC0526Fp, i, i2));
            }
            i9 = 805306368;
            i3 |= i9;
            if (i4 != 4) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 = i3 & (-234881025);
                        z3 = z2;
                        j2 = jM1069contentColorForek8zF_U;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        shape3 = large;
                        f = fM1091getElevationD9Ej5fM;
                        j = jM1055getSurface0d7_KjU;
                        modifier4 = modifier3;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                    } else {
                        j3 = j3;
                        i10 = i3;
                        z3 = z2;
                        j = jM1055getSurface0d7_KjU;
                        j2 = jM1069contentColorForek8zF_U;
                        modifier4 = modifier3;
                        shape3 = large;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        f = fM1091getElevationD9Ej5fM;
                    }
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 = i3 & (-234881025);
                        z3 = z2;
                        j2 = jM1069contentColorForek8zF_U;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        shape3 = large;
                        f = fM1091getElevationD9Ej5fM;
                        j = jM1055getSurface0d7_KjU;
                        modifier4 = modifier3;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                    } else {
                        j3 = j3;
                        i10 = i3;
                        z3 = z2;
                        j = jM1055getSurface0d7_KjU;
                        j2 = jM1069contentColorForek8zF_U;
                        modifier4 = modifier3;
                        shape3 = large;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        f = fM1091getElevationD9Ej5fM;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(625649286, i10, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:640)");
                }
                composerStartRestartGroup.startReplaceableGroup(-1561647407);
                if (bottomDrawerState.getDensity$material_release() == null) {
                    EffectsKt.SideEffect(new DrawerKt$BottomDrawer$1(bottomDrawerState, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller6 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller6);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller6;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope6 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier11 = modifier4;
                BottomDrawerState bottomDrawerState8 = bottomDrawerState;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$2(z3, bottomDrawerState, interfaceC0526Fp, i10, j3, coroutineScope6, shape3, j, j2, f, interfaceC0552Gp)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z3;
                shape4 = shape3;
                f2 = f;
                bottomDrawerState2 = bottomDrawerState8;
                j4 = j;
                j5 = j2;
                j6 = j3;
                modifier5 = modifier11;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 = i3 & (-234881025);
                        z3 = z2;
                        j2 = jM1069contentColorForek8zF_U;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        shape3 = large;
                        f = fM1091getElevationD9Ej5fM;
                        j = jM1055getSurface0d7_KjU;
                        modifier4 = modifier3;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                    } else {
                        j3 = j3;
                        i10 = i3;
                        z3 = z2;
                        j = jM1055getSurface0d7_KjU;
                        j2 = jM1069contentColorForek8zF_U;
                        modifier4 = modifier3;
                        shape3 = large;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        f = fM1091getElevationD9Ej5fM;
                    }
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 = i3 & (-234881025);
                        z3 = z2;
                        j2 = jM1069contentColorForek8zF_U;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        shape3 = large;
                        f = fM1091getElevationD9Ej5fM;
                        j = jM1055getSurface0d7_KjU;
                        modifier4 = modifier3;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                    } else {
                        j3 = j3;
                        i10 = i3;
                        z3 = z2;
                        j = jM1055getSurface0d7_KjU;
                        j2 = jM1069contentColorForek8zF_U;
                        modifier4 = modifier3;
                        shape3 = large;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        f = fM1091getElevationD9Ej5fM;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(625649286, i10, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:640)");
                }
                composerStartRestartGroup.startReplaceableGroup(-1561647407);
                if (bottomDrawerState.getDensity$material_release() == null) {
                    EffectsKt.SideEffect(new DrawerKt$BottomDrawer$1(bottomDrawerState, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller7 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller7);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller7;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope7 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier12 = modifier4;
                BottomDrawerState bottomDrawerState9 = bottomDrawerState;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$2(z3, bottomDrawerState, interfaceC0526Fp, i10, j3, coroutineScope7, shape3, j, j2, f, interfaceC0552Gp)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z3;
                shape4 = shape3;
                f2 = f;
                bottomDrawerState2 = bottomDrawerState9;
                j4 = j;
                j5 = j2;
                j6 = j3;
                modifier5 = modifier12;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$BottomDrawer$3(interfaceC0552Gp, modifier5, bottomDrawerState2, z4, shape4, f2, j4, j5, j6, interfaceC0526Fp, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 128;
        }
        i5 = i2 & 8;
        if (i5 != 0) {
            if ((i & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i7 = i2 & 32;
            if (i7 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            }
            if ((i & 3670016) != 0) {
                if ((i2 & 64) == 0) {
                    i13 = 524288;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            if ((i & 29360128) != 0) {
                if ((i2 & 128) == 0) {
                    i12 = 4194304;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((234881024 & i) != 0) {
                if ((i2 & 256) == 0) {
                    i11 = 33554432;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i9 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i9 = 268435456;
                    }
                }
                if (i4 != 4) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i7 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i10 = i3 & (-234881025);
                            z3 = z2;
                            j2 = jM1069contentColorForek8zF_U;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            shape3 = large;
                            f = fM1091getElevationD9Ej5fM;
                            j = jM1055getSurface0d7_KjU;
                            modifier4 = modifier3;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        } else {
                            j3 = j3;
                            i10 = i3;
                            z3 = z2;
                            j = jM1055getSurface0d7_KjU;
                            j2 = jM1069contentColorForek8zF_U;
                            modifier4 = modifier3;
                            shape3 = large;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                            f = fM1091getElevationD9Ej5fM;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i7 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i10 = i3 & (-234881025);
                            z3 = z2;
                            j2 = jM1069contentColorForek8zF_U;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            shape3 = large;
                            f = fM1091getElevationD9Ej5fM;
                            j = jM1055getSurface0d7_KjU;
                            modifier4 = modifier3;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        } else {
                            j3 = j3;
                            i10 = i3;
                            z3 = z2;
                            j = jM1055getSurface0d7_KjU;
                            j2 = jM1069contentColorForek8zF_U;
                            modifier4 = modifier3;
                            shape3 = large;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                            f = fM1091getElevationD9Ej5fM;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(625649286, i10, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:640)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-1561647407);
                    if (bottomDrawerState.getDensity$material_release() == null) {
                        EffectsKt.SideEffect(new DrawerKt$BottomDrawer$1(bottomDrawerState, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller8 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller8);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller8;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope8 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier13 = modifier4;
                    BottomDrawerState bottomDrawerState10 = bottomDrawerState;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$2(z3, bottomDrawerState, interfaceC0526Fp, i10, j3, coroutineScope8, shape3, j, j2, f, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    shape4 = shape3;
                    f2 = f;
                    bottomDrawerState2 = bottomDrawerState10;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                    modifier5 = modifier13;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i7 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i10 = i3 & (-234881025);
                            z3 = z2;
                            j2 = jM1069contentColorForek8zF_U;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            shape3 = large;
                            f = fM1091getElevationD9Ej5fM;
                            j = jM1055getSurface0d7_KjU;
                            modifier4 = modifier3;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        } else {
                            j3 = j3;
                            i10 = i3;
                            z3 = z2;
                            j = jM1055getSurface0d7_KjU;
                            j2 = jM1069contentColorForek8zF_U;
                            modifier4 = modifier3;
                            shape3 = large;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                            f = fM1091getElevationD9Ej5fM;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                        }
                        if (i5 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i7 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f;
                        }
                        if ((i2 & 64) != 0) {
                            jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            jM1055getSurface0d7_KjU = j;
                        }
                        if ((i2 & 128) != 0) {
                            jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            jM1069contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i10 = i3 & (-234881025);
                            z3 = z2;
                            j2 = jM1069contentColorForek8zF_U;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            shape3 = large;
                            f = fM1091getElevationD9Ej5fM;
                            j = jM1055getSurface0d7_KjU;
                            modifier4 = modifier3;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        } else {
                            j3 = j3;
                            i10 = i3;
                            z3 = z2;
                            j = jM1055getSurface0d7_KjU;
                            j2 = jM1069contentColorForek8zF_U;
                            modifier4 = modifier3;
                            shape3 = large;
                            bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                            f = fM1091getElevationD9Ej5fM;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(625649286, i10, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:640)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-1561647407);
                    if (bottomDrawerState.getDensity$material_release() == null) {
                        EffectsKt.SideEffect(new DrawerKt$BottomDrawer$1(bottomDrawerState, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller9 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller9);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller9;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope9 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier14 = modifier4;
                    BottomDrawerState bottomDrawerState11 = bottomDrawerState;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$2(z3, bottomDrawerState, interfaceC0526Fp, i10, j3, coroutineScope9, shape3, j, j2, f, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    shape4 = shape3;
                    f2 = f;
                    bottomDrawerState2 = bottomDrawerState11;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                    modifier5 = modifier14;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$BottomDrawer$3(interfaceC0552Gp, modifier5, bottomDrawerState2, z4, shape4, f2, j4, j5, j6, interfaceC0526Fp, i, i2));
            }
            i9 = 805306368;
            i3 |= i9;
            if (i4 != 4) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 = i3 & (-234881025);
                        z3 = z2;
                        j2 = jM1069contentColorForek8zF_U;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        shape3 = large;
                        f = fM1091getElevationD9Ej5fM;
                        j = jM1055getSurface0d7_KjU;
                        modifier4 = modifier3;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                    } else {
                        j3 = j3;
                        i10 = i3;
                        z3 = z2;
                        j = jM1055getSurface0d7_KjU;
                        j2 = jM1069contentColorForek8zF_U;
                        modifier4 = modifier3;
                        shape3 = large;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        f = fM1091getElevationD9Ej5fM;
                    }
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 = i3 & (-234881025);
                        z3 = z2;
                        j2 = jM1069contentColorForek8zF_U;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        shape3 = large;
                        f = fM1091getElevationD9Ej5fM;
                        j = jM1055getSurface0d7_KjU;
                        modifier4 = modifier3;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                    } else {
                        j3 = j3;
                        i10 = i3;
                        z3 = z2;
                        j = jM1055getSurface0d7_KjU;
                        j2 = jM1069contentColorForek8zF_U;
                        modifier4 = modifier3;
                        shape3 = large;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        f = fM1091getElevationD9Ej5fM;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(625649286, i10, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:640)");
                }
                composerStartRestartGroup.startReplaceableGroup(-1561647407);
                if (bottomDrawerState.getDensity$material_release() == null) {
                    EffectsKt.SideEffect(new DrawerKt$BottomDrawer$1(bottomDrawerState, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller10 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller10);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller10;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope10 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier15 = modifier4;
                BottomDrawerState bottomDrawerState12 = bottomDrawerState;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$2(z3, bottomDrawerState, interfaceC0526Fp, i10, j3, coroutineScope10, shape3, j, j2, f, interfaceC0552Gp)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z3;
                shape4 = shape3;
                f2 = f;
                bottomDrawerState2 = bottomDrawerState12;
                j4 = j;
                j5 = j2;
                j6 = j3;
                modifier5 = modifier15;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 = i3 & (-234881025);
                        z3 = z2;
                        j2 = jM1069contentColorForek8zF_U;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        shape3 = large;
                        f = fM1091getElevationD9Ej5fM;
                        j = jM1055getSurface0d7_KjU;
                        modifier4 = modifier3;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                    } else {
                        j3 = j3;
                        i10 = i3;
                        z3 = z2;
                        j = jM1055getSurface0d7_KjU;
                        j2 = jM1069contentColorForek8zF_U;
                        modifier4 = modifier3;
                        shape3 = large;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        f = fM1091getElevationD9Ej5fM;
                    }
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 = i3 & (-234881025);
                        z3 = z2;
                        j2 = jM1069contentColorForek8zF_U;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        shape3 = large;
                        f = fM1091getElevationD9Ej5fM;
                        j = jM1055getSurface0d7_KjU;
                        modifier4 = modifier3;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                    } else {
                        j3 = j3;
                        i10 = i3;
                        z3 = z2;
                        j = jM1055getSurface0d7_KjU;
                        j2 = jM1069contentColorForek8zF_U;
                        modifier4 = modifier3;
                        shape3 = large;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        f = fM1091getElevationD9Ej5fM;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(625649286, i10, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:640)");
                }
                composerStartRestartGroup.startReplaceableGroup(-1561647407);
                if (bottomDrawerState.getDensity$material_release() == null) {
                    EffectsKt.SideEffect(new DrawerKt$BottomDrawer$1(bottomDrawerState, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller11;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope11 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier16 = modifier4;
                BottomDrawerState bottomDrawerState13 = bottomDrawerState;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$2(z3, bottomDrawerState, interfaceC0526Fp, i10, j3, coroutineScope11, shape3, j, j2, f, interfaceC0552Gp)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z3;
                shape4 = shape3;
                f2 = f;
                bottomDrawerState2 = bottomDrawerState13;
                j4 = j;
                j5 = j2;
                j6 = j3;
                modifier5 = modifier16;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$BottomDrawer$3(interfaceC0552Gp, modifier5, bottomDrawerState2, z4, shape4, f2, j4, j5, j6, interfaceC0526Fp, i, i2));
        }
        i3 |= 3072;
        z2 = z;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i3 |= i15;
        } else {
            shape2 = shape;
        }
        i7 = i2 & 32;
        if (i7 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & 458752) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i8 = 131072;
            } else {
                i8 = 65536;
            }
            i3 |= i8;
        }
        if ((i & 3670016) != 0) {
            if ((i2 & 64) == 0) {
                i13 = 524288;
            } else {
                i13 = 524288;
            }
            i3 |= i13;
        }
        if ((i & 29360128) != 0) {
            if ((i2 & 128) == 0) {
                i12 = 4194304;
            } else {
                i12 = 4194304;
            }
            i3 |= i12;
        }
        if ((234881024 & i) != 0) {
            if ((i2 & 256) == 0) {
                i11 = 33554432;
            } else {
                i11 = 33554432;
            }
            i3 |= i11;
        }
        if ((i2 & 512) != 0) {
            if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i9 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i9 = 268435456;
                }
            }
            if (i4 != 4) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 = i3 & (-234881025);
                        z3 = z2;
                        j2 = jM1069contentColorForek8zF_U;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        shape3 = large;
                        f = fM1091getElevationD9Ej5fM;
                        j = jM1055getSurface0d7_KjU;
                        modifier4 = modifier3;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                    } else {
                        j3 = j3;
                        i10 = i3;
                        z3 = z2;
                        j = jM1055getSurface0d7_KjU;
                        j2 = jM1069contentColorForek8zF_U;
                        modifier4 = modifier3;
                        shape3 = large;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        f = fM1091getElevationD9Ej5fM;
                    }
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 = i3 & (-234881025);
                        z3 = z2;
                        j2 = jM1069contentColorForek8zF_U;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        shape3 = large;
                        f = fM1091getElevationD9Ej5fM;
                        j = jM1055getSurface0d7_KjU;
                        modifier4 = modifier3;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                    } else {
                        j3 = j3;
                        i10 = i3;
                        z3 = z2;
                        j = jM1055getSurface0d7_KjU;
                        j2 = jM1069contentColorForek8zF_U;
                        modifier4 = modifier3;
                        shape3 = large;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        f = fM1091getElevationD9Ej5fM;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(625649286, i10, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:640)");
                }
                composerStartRestartGroup.startReplaceableGroup(-1561647407);
                if (bottomDrawerState.getDensity$material_release() == null) {
                    EffectsKt.SideEffect(new DrawerKt$BottomDrawer$1(bottomDrawerState, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller12 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller12);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller12;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope12 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier17 = modifier4;
                BottomDrawerState bottomDrawerState14 = bottomDrawerState;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$2(z3, bottomDrawerState, interfaceC0526Fp, i10, j3, coroutineScope12, shape3, j, j2, f, interfaceC0552Gp)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z3;
                shape4 = shape3;
                f2 = f;
                bottomDrawerState2 = bottomDrawerState14;
                j4 = j;
                j5 = j2;
                j6 = j3;
                modifier5 = modifier17;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 = i3 & (-234881025);
                        z3 = z2;
                        j2 = jM1069contentColorForek8zF_U;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        shape3 = large;
                        f = fM1091getElevationD9Ej5fM;
                        j = jM1055getSurface0d7_KjU;
                        modifier4 = modifier3;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                    } else {
                        j3 = j3;
                        i10 = i3;
                        z3 = z2;
                        j = jM1055getSurface0d7_KjU;
                        j2 = jM1069contentColorForek8zF_U;
                        modifier4 = modifier3;
                        shape3 = large;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        f = fM1091getElevationD9Ej5fM;
                    }
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                    }
                    if (i5 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i7 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        jM1055getSurface0d7_KjU = j;
                    }
                    if ((i2 & 128) != 0) {
                        jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        jM1069contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i10 = i3 & (-234881025);
                        z3 = z2;
                        j2 = jM1069contentColorForek8zF_U;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        shape3 = large;
                        f = fM1091getElevationD9Ej5fM;
                        j = jM1055getSurface0d7_KjU;
                        modifier4 = modifier3;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                    } else {
                        j3 = j3;
                        i10 = i3;
                        z3 = z2;
                        j = jM1055getSurface0d7_KjU;
                        j2 = jM1069contentColorForek8zF_U;
                        modifier4 = modifier3;
                        shape3 = large;
                        bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                        f = fM1091getElevationD9Ej5fM;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(625649286, i10, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:640)");
                }
                composerStartRestartGroup.startReplaceableGroup(-1561647407);
                if (bottomDrawerState.getDensity$material_release() == null) {
                    EffectsKt.SideEffect(new DrawerKt$BottomDrawer$1(bottomDrawerState, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller13 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller13);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller13;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope13 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier18 = modifier4;
                BottomDrawerState bottomDrawerState15 = bottomDrawerState;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$2(z3, bottomDrawerState, interfaceC0526Fp, i10, j3, coroutineScope13, shape3, j, j2, f, interfaceC0552Gp)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z3;
                shape4 = shape3;
                f2 = f;
                bottomDrawerState2 = bottomDrawerState15;
                j4 = j;
                j5 = j2;
                j6 = j3;
                modifier5 = modifier18;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$BottomDrawer$3(interfaceC0552Gp, modifier5, bottomDrawerState2, z4, shape4, f2, j4, j5, j6, interfaceC0526Fp, i, i2));
        }
        i9 = 805306368;
        i3 |= i9;
        if (i4 != 4) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    i3 &= -897;
                } else {
                    bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i3 &= -57345;
                } else {
                    large = shape2;
                }
                if (i7 != 0) {
                    fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                } else {
                    fM1091getElevationD9Ej5fM = f;
                }
                if ((i2 & 64) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -3670017;
                } else {
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i2 & 128) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    i10 = i3 & (-234881025);
                    z3 = z2;
                    j2 = jM1069contentColorForek8zF_U;
                    j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    shape3 = large;
                    f = fM1091getElevationD9Ej5fM;
                    j = jM1055getSurface0d7_KjU;
                    modifier4 = modifier3;
                    bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                } else {
                    j3 = j3;
                    i10 = i3;
                    z3 = z2;
                    j = jM1055getSurface0d7_KjU;
                    j2 = jM1069contentColorForek8zF_U;
                    modifier4 = modifier3;
                    shape3 = large;
                    bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                    f = fM1091getElevationD9Ej5fM;
                }
            } else {
                if (i14 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    i3 &= -897;
                } else {
                    bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i3 &= -57345;
                } else {
                    large = shape2;
                }
                if (i7 != 0) {
                    fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                } else {
                    fM1091getElevationD9Ej5fM = f;
                }
                if ((i2 & 64) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -3670017;
                } else {
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i2 & 128) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    i10 = i3 & (-234881025);
                    z3 = z2;
                    j2 = jM1069contentColorForek8zF_U;
                    j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    shape3 = large;
                    f = fM1091getElevationD9Ej5fM;
                    j = jM1055getSurface0d7_KjU;
                    modifier4 = modifier3;
                    bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                } else {
                    j3 = j3;
                    i10 = i3;
                    z3 = z2;
                    j = jM1055getSurface0d7_KjU;
                    j2 = jM1069contentColorForek8zF_U;
                    modifier4 = modifier3;
                    shape3 = large;
                    bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                    f = fM1091getElevationD9Ej5fM;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(625649286, i10, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:640)");
            }
            composerStartRestartGroup.startReplaceableGroup(-1561647407);
            if (bottomDrawerState.getDensity$material_release() == null) {
                EffectsKt.SideEffect(new DrawerKt$BottomDrawer$1(bottomDrawerState, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller14 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller14);
                objRememberedValue = compositionScopedCoroutineScopeCanceller14;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope14 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifier19 = modifier4;
            BottomDrawerState bottomDrawerState16 = bottomDrawerState;
            composer2 = composerStartRestartGroup;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$2(z3, bottomDrawerState, interfaceC0526Fp, i10, j3, coroutineScope14, shape3, j, j2, f, interfaceC0552Gp)), composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z3;
            shape4 = shape3;
            f2 = f;
            bottomDrawerState2 = bottomDrawerState16;
            j4 = j;
            j5 = j2;
            j6 = j3;
            modifier5 = modifier19;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    i3 &= -897;
                } else {
                    bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i3 &= -57345;
                } else {
                    large = shape2;
                }
                if (i7 != 0) {
                    fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                } else {
                    fM1091getElevationD9Ej5fM = f;
                }
                if ((i2 & 64) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -3670017;
                } else {
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i2 & 128) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    i10 = i3 & (-234881025);
                    z3 = z2;
                    j2 = jM1069contentColorForek8zF_U;
                    j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    shape3 = large;
                    f = fM1091getElevationD9Ej5fM;
                    j = jM1055getSurface0d7_KjU;
                    modifier4 = modifier3;
                    bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                } else {
                    j3 = j3;
                    i10 = i3;
                    z3 = z2;
                    j = jM1055getSurface0d7_KjU;
                    j2 = jM1069contentColorForek8zF_U;
                    modifier4 = modifier3;
                    shape3 = large;
                    bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                    f = fM1091getElevationD9Ej5fM;
                }
            } else {
                if (i14 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    bottomDrawerStateRememberBottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    i3 &= -897;
                } else {
                    bottomDrawerStateRememberBottomDrawerState = bottomDrawerState;
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i3 &= -57345;
                } else {
                    large = shape2;
                }
                if (i7 != 0) {
                    fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                } else {
                    fM1091getElevationD9Ej5fM = f;
                }
                if ((i2 & 64) != 0) {
                    jM1055getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -3670017;
                } else {
                    jM1055getSurface0d7_KjU = j;
                }
                if ((i2 & 128) != 0) {
                    jM1069contentColorForek8zF_U = ColorsKt.m1069contentColorForek8zF_U(jM1055getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    jM1069contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    i10 = i3 & (-234881025);
                    z3 = z2;
                    j2 = jM1069contentColorForek8zF_U;
                    j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    shape3 = large;
                    f = fM1091getElevationD9Ej5fM;
                    j = jM1055getSurface0d7_KjU;
                    modifier4 = modifier3;
                    bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                } else {
                    j3 = j3;
                    i10 = i3;
                    z3 = z2;
                    j = jM1055getSurface0d7_KjU;
                    j2 = jM1069contentColorForek8zF_U;
                    modifier4 = modifier3;
                    shape3 = large;
                    bottomDrawerState = bottomDrawerStateRememberBottomDrawerState;
                    f = fM1091getElevationD9Ej5fM;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(625649286, i10, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:640)");
            }
            composerStartRestartGroup.startReplaceableGroup(-1561647407);
            if (bottomDrawerState.getDensity$material_release() == null) {
                EffectsKt.SideEffect(new DrawerKt$BottomDrawer$1(bottomDrawerState, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller15 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller15);
                objRememberedValue = compositionScopedCoroutineScopeCanceller15;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope15 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifier110 = modifier4;
            BottomDrawerState bottomDrawerState17 = bottomDrawerState;
            composer2 = composerStartRestartGroup;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 1220102512, true, new DrawerKt$BottomDrawer$2(z3, bottomDrawerState, interfaceC0526Fp, i10, j3, coroutineScope15, shape3, j, j2, f, interfaceC0552Gp)), composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z3;
            shape4 = shape3;
            f2 = f;
            bottomDrawerState2 = bottomDrawerState17;
            j4 = j;
            j5 = j2;
            j6 = j3;
            modifier5 = modifier110;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$BottomDrawer$3(interfaceC0552Gp, modifier5, bottomDrawerState2, z4, shape4, f2, j4, j5, j6, interfaceC0526Fp, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnchoredDraggableState.AnchorChangedCallback<BottomDrawerValue> BottomDrawerAnchorChangeCallback(final BottomDrawerState bottomDrawerState, final InterfaceC2052dg interfaceC2052dg) {
        return new AnchoredDraggableState.AnchorChangedCallback<BottomDrawerValue>() { // from class: androidx.compose.material.DrawerKt.BottomDrawerAnchorChangeCallback.1

            /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$BottomDrawerAnchorChangeCallback$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[BottomDrawerValue.values().length];
                    try {
                        iArr[BottomDrawerValue.Closed.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[BottomDrawerValue.Open.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[BottomDrawerValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // androidx.compose.material.AnchoredDraggableState.AnchorChangedCallback
            public final void onAnchorsChanged(BottomDrawerValue bottomDrawerValue, Map<BottomDrawerValue, Float> map, Map<BottomDrawerValue, Float> map2) {
                BottomDrawerValue bottomDrawerValue2;
                AbstractC4492zt.h(bottomDrawerValue, "previousTarget");
                AbstractC4492zt.h(map, "previousAnchors");
                AbstractC4492zt.h(map2, "newAnchors");
                Float f = map.get(bottomDrawerValue);
                int i = WhenMappings.$EnumSwitchMapping$0[bottomDrawerValue.ordinal()];
                if (i == 1) {
                    bottomDrawerValue2 = BottomDrawerValue.Closed;
                } else {
                    if (i != 2 && i != 3) {
                        throw new AD();
                    }
                    bottomDrawerValue2 = BottomDrawerValue.Open;
                    if (!map2.containsKey(bottomDrawerValue2)) {
                        bottomDrawerValue2 = BottomDrawerValue.Expanded;
                        if (!map2.containsKey(bottomDrawerValue2)) {
                            bottomDrawerValue2 = BottomDrawerValue.Closed;
                        }
                    }
                }
                if (AbstractC4492zt.a(((Number) AbstractC4243wx.h(map2, bottomDrawerValue2)).floatValue(), f)) {
                    return;
                }
                if (bottomDrawerState.isAnimationRunning$material_release()) {
                    O8.d(interfaceC2052dg, null, null, new DrawerKt$BottomDrawerAnchorChangeCallback$1$onAnchorsChanged$1(bottomDrawerState, bottomDrawerValue2, null), 3, null);
                } else {
                    if (bottomDrawerState.trySnapTo$material_release(bottomDrawerValue2)) {
                        return;
                    }
                    O8.d(interfaceC2052dg, null, null, new DrawerKt$BottomDrawerAnchorChangeCallback$1$onAnchorsChanged$2(bottomDrawerState, bottomDrawerValue2, null), 3, null);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: BottomDrawerScrim-3J-VO9M, reason: not valid java name */
    public static final void m1093BottomDrawerScrim3JVO9M(long j, InterfaceC3588op interfaceC3588op, boolean z, Composer composer, int i) {
        int i2;
        Modifier modifierSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(-513067266);
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
                ComposerKt.traceEventStart(-513067266, i2, -1, "androidx.compose.material.BottomDrawerScrim (Drawer.kt:799)");
            }
            if (j != Color.Companion.m3068getUnspecified0d7_KjU()) {
                State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                String strM1225getString4foXLRw = Strings_androidKt.m1225getString4foXLRw(Strings.Companion.m1218getCloseDrawerUdPEhr4(), composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1298942364);
                if (z) {
                    Modifier.Companion companion = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    boolean zChanged = composerStartRestartGroup.changed(interfaceC3588op);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(interfaceC3588op, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, interfaceC3588op, (InterfaceC0526Fp) objRememberedValue);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    boolean zChanged2 = composerStartRestartGroup.changed(strM1225getString4foXLRw) | composerStartRestartGroup.changed(interfaceC3588op);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = new DrawerKt$BottomDrawerScrim$dismissModifier$2$1(strM1225getString4foXLRw, interfaceC3588op);
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
                    objRememberedValue3 = new DrawerKt$BottomDrawerScrim$1$1(j, stateAnimateFloatAsState);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$BottomDrawerScrim$2(j, interfaceC3588op, z, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BottomDrawerScrim_3J_VO9M$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    @ExperimentalMaterialApi
    public static final BottomDrawerState BottomDrawerState(BottomDrawerValue bottomDrawerValue, Density density, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(bottomDrawerValue, "initialValue");
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
        BottomDrawerState bottomDrawerState = new BottomDrawerState(bottomDrawerValue, interfaceC3750qp);
        bottomDrawerState.setDensity$material_release(density);
        return bottomDrawerState;
    }

    public static /* synthetic */ BottomDrawerState BottomDrawerState$default(BottomDrawerValue bottomDrawerValue, Density density, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 4) != 0) {
            interfaceC3750qp = C14181.INSTANCE;
        }
        return BottomDrawerState(bottomDrawerValue, density, interfaceC3750qp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState) {
        return new C14191(anchoredDraggableState);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x011b  */
    /* JADX WARN: Code duplicated, block: B:103:0x011f  */
    /* JADX WARN: Code duplicated, block: B:105:0x0124  */
    /* JADX WARN: Code duplicated, block: B:107:0x012a  */
    /* JADX WARN: Code duplicated, block: B:108:0x012d  */
    /* JADX WARN: Code duplicated, block: B:111:0x0139  */
    /* JADX WARN: Code duplicated, block: B:115:0x0151  */
    /* JADX WARN: Code duplicated, block: B:117:0x0164  */
    /* JADX WARN: Code duplicated, block: B:137:0x01a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:138:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:139:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:143:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:145:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:148:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:149:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:151:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:152:0x01db  */
    /* JADX WARN: Code duplicated, block: B:155:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:156:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:159:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:160:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:163:0x0204  */
    /* JADX WARN: Code duplicated, block: B:165:0x021f  */
    /* JADX WARN: Code duplicated, block: B:168:0x0238  */
    /* JADX WARN: Code duplicated, block: B:171:0x0259  */
    /* JADX WARN: Code duplicated, block: B:174:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:179:0x02de  */
    /* JADX WARN: Code duplicated, block: B:181:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:30:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:63:0x00af  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00de  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:91:0x0102  */
    /* JADX WARN: Code duplicated, block: B:93:0x0108  */
    /* JADX WARN: Code duplicated, block: B:96:0x0111  */
    /* JADX WARN: Code duplicated, block: B:98:0x0115  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ModalDrawer-Gs3lGvM, reason: not valid java name */
    public static final void m1094ModalDrawerGs3lGvM(InterfaceC0552Gp interfaceC0552Gp, Modifier modifier, DrawerState drawerState, boolean z, Shape shape, float f, long j, long j2, long j3, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        DrawerState drawerState2;
        int i4;
        boolean z2;
        int i5;
        Shape shape2;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9;
        Modifier modifier3;
        DrawerState drawerStateRememberDrawerState;
        Shape large;
        float fM1091getElevationD9Ej5fM;
        int i10;
        Object objRememberedValue;
        Composer composer2;
        DrawerState drawerState3;
        boolean z3;
        Shape shape3;
        Modifier modifier4;
        float f3;
        long j4;
        long j5;
        long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        int i12;
        AbstractC4492zt.h(interfaceC0552Gp, "drawerContent");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1305806945);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i13 = i2 & 2;
        if (i13 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    drawerState2 = drawerState;
                    int i14 = composerStartRestartGroup.changed(drawerState2) ? 256 : 128;
                    i3 |= i14;
                } else {
                    drawerState2 = drawerState;
                }
                i3 |= i14;
            } else {
                drawerState2 = drawerState;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        int i15 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                        i3 |= i15;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((458752 & i) == 0) {
                        f2 = f;
                        if (composerStartRestartGroup.changed(f2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((i & 3670016) == 0) {
                        if ((i2 & 64) == 0) {
                            i8 = i13;
                            int i16 = composerStartRestartGroup.changed(j) ? 1048576 : 524288;
                            i3 |= i16;
                        } else {
                            i8 = i13;
                        }
                        i3 |= i16;
                    } else {
                        i8 = i13;
                    }
                    if ((i & 29360128) != 0) {
                        if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                            i12 = 4194304;
                        } else {
                            i12 = 8388608;
                        }
                        i3 |= i12;
                    }
                    if ((234881024 & i) != 0) {
                        if ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j3)) {
                            i11 = 33554432;
                        } else {
                            i11 = 67108864;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                                i9 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i9 = 268435456;
                            }
                        }
                        if ((1533916891 & i3) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i8 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if ((i2 & 4) != 0) {
                                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                    i3 &= -897;
                                } else {
                                    drawerStateRememberDrawerState = drawerState2;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                    i3 &= -57345;
                                } else {
                                    large = shape2;
                                }
                                if (i6 != 0) {
                                    fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                                } else {
                                    fM1091getElevationD9Ej5fM = f2;
                                }
                                if ((i2 & 64) != 0) {
                                    j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                    i3 &= -3670017;
                                } else {
                                    j = j;
                                }
                                if ((i2 & 128) != 0) {
                                    j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                    i3 &= -29360129;
                                } else {
                                    j2 = j2;
                                }
                                if ((i2 & 256) != 0) {
                                    i3 &= -234881025;
                                    j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                } else {
                                    j3 = j3;
                                }
                                i10 = i3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                i10 = (i2 & 256) != 0 ? i3 & (-234881025) : i3;
                                modifier3 = modifier2;
                                drawerStateRememberDrawerState = drawerState2;
                                z2 = z2;
                                large = shape2;
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(773894976);
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                objRememberedValue = compositionScopedCoroutineScopeCanceller;
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                            composerStartRestartGroup.endReplaceableGroup();
                            Modifier modifier5 = modifier3;
                            composer2 = composerStartRestartGroup;
                            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope, interfaceC0552Gp)), composer2, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            drawerState3 = drawerStateRememberDrawerState;
                            z3 = z2;
                            shape3 = large;
                            modifier4 = modifier5;
                            f3 = fM1091getElevationD9Ej5fM;
                            j4 = j;
                            j5 = j2;
                            j6 = j3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            drawerState3 = drawerState2;
                            z3 = z2;
                            shape3 = shape2;
                            f3 = f2;
                            composer2 = composerStartRestartGroup;
                            j4 = j;
                            j5 = j2;
                            j6 = j3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$ModalDrawer$2(interfaceC0552Gp, modifier4, drawerState3, z3, shape3, f3, j4, j5, j6, interfaceC0526Fp, i, i2));
                    }
                    i9 = 805306368;
                    i3 |= i9;
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i6 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j = j;
                            }
                            if ((i2 & 128) != 0) {
                                j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j2 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            } else {
                                j3 = j3;
                            }
                            i10 = i3;
                        } else {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i6 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j = j;
                            }
                            if ((i2 & 128) != 0) {
                                j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j2 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            } else {
                                j3 = j3;
                            }
                            i10 = i3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller2);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller2;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier6 = modifier3;
                        composer2 = composerStartRestartGroup;
                        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope2, interfaceC0552Gp)), composer2, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        drawerState3 = drawerStateRememberDrawerState;
                        z3 = z2;
                        shape3 = large;
                        modifier4 = modifier6;
                        f3 = fM1091getElevationD9Ej5fM;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i6 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j = j;
                            }
                            if ((i2 & 128) != 0) {
                                j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j2 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            } else {
                                j3 = j3;
                            }
                            i10 = i3;
                        } else {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i6 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j = j;
                            }
                            if ((i2 & 128) != 0) {
                                j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j2 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            } else {
                                j3 = j3;
                            }
                            i10 = i3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller3 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller3);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller3;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope3 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier7 = modifier3;
                        composer2 = composerStartRestartGroup;
                        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope3, interfaceC0552Gp)), composer2, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        drawerState3 = drawerStateRememberDrawerState;
                        z3 = z2;
                        shape3 = large;
                        modifier4 = modifier7;
                        f3 = fM1091getElevationD9Ej5fM;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$ModalDrawer$2(interfaceC0552Gp, modifier4, drawerState3, z3, shape3, f3, j4, j5, j6, interfaceC0526Fp, i, i2));
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f2 = f;
                if ((i & 3670016) == 0) {
                    if ((i2 & 64) == 0) {
                        i8 = i13;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i3 |= i16;
                    } else {
                        i8 = i13;
                    }
                    i3 |= i16;
                } else {
                    i8 = i13;
                }
                if ((i & 29360128) != 0) {
                    if ((i2 & 128) == 0) {
                        i12 = 4194304;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((234881024 & i) != 0) {
                    if ((i2 & 256) == 0) {
                        i11 = 33554432;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i9 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i9 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i6 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j = j;
                            }
                            if ((i2 & 128) != 0) {
                                j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j2 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            } else {
                                j3 = j3;
                            }
                            i10 = i3;
                        } else {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i6 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j = j;
                            }
                            if ((i2 & 128) != 0) {
                                j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j2 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            } else {
                                j3 = j3;
                            }
                            i10 = i3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller4 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller4);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller4;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope4 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier8 = modifier3;
                        composer2 = composerStartRestartGroup;
                        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope4, interfaceC0552Gp)), composer2, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        drawerState3 = drawerStateRememberDrawerState;
                        z3 = z2;
                        shape3 = large;
                        modifier4 = modifier8;
                        f3 = fM1091getElevationD9Ej5fM;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i6 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j = j;
                            }
                            if ((i2 & 128) != 0) {
                                j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j2 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            } else {
                                j3 = j3;
                            }
                            i10 = i3;
                        } else {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i6 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j = j;
                            }
                            if ((i2 & 128) != 0) {
                                j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j2 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            } else {
                                j3 = j3;
                            }
                            i10 = i3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller5 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller5);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller5;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope5 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier9 = modifier3;
                        composer2 = composerStartRestartGroup;
                        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope5, interfaceC0552Gp)), composer2, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        drawerState3 = drawerStateRememberDrawerState;
                        z3 = z2;
                        shape3 = large;
                        modifier4 = modifier9;
                        f3 = fM1091getElevationD9Ej5fM;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$ModalDrawer$2(interfaceC0552Gp, modifier4, drawerState3, z3, shape3, f3, j4, j5, j6, interfaceC0526Fp, i, i2));
                }
                i9 = 805306368;
                i3 |= i9;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller6 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller6);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller6;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope6 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier10 = modifier3;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope6, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    drawerState3 = drawerStateRememberDrawerState;
                    z3 = z2;
                    shape3 = large;
                    modifier4 = modifier10;
                    f3 = fM1091getElevationD9Ej5fM;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller7 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller7);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller7;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope7 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier11 = modifier3;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope7, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    drawerState3 = drawerStateRememberDrawerState;
                    z3 = z2;
                    shape3 = large;
                    modifier4 = modifier11;
                    f3 = fM1091getElevationD9Ej5fM;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$ModalDrawer$2(interfaceC0552Gp, modifier4, drawerState3, z3, shape3, f3, j4, j5, j6, interfaceC0526Fp, i, i2));
            }
            i3 |= 3072;
            z2 = z;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((458752 & i) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i & 3670016) == 0) {
                    if ((i2 & 64) == 0) {
                        i8 = i13;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i3 |= i16;
                    } else {
                        i8 = i13;
                    }
                    i3 |= i16;
                } else {
                    i8 = i13;
                }
                if ((i & 29360128) != 0) {
                    if ((i2 & 128) == 0) {
                        i12 = 4194304;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((234881024 & i) != 0) {
                    if ((i2 & 256) == 0) {
                        i11 = 33554432;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i9 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i9 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i6 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j = j;
                            }
                            if ((i2 & 128) != 0) {
                                j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j2 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            } else {
                                j3 = j3;
                            }
                            i10 = i3;
                        } else {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i6 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j = j;
                            }
                            if ((i2 & 128) != 0) {
                                j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j2 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            } else {
                                j3 = j3;
                            }
                            i10 = i3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller8 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller8);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller8;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope8 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier12 = modifier3;
                        composer2 = composerStartRestartGroup;
                        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope8, interfaceC0552Gp)), composer2, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        drawerState3 = drawerStateRememberDrawerState;
                        z3 = z2;
                        shape3 = large;
                        modifier4 = modifier12;
                        f3 = fM1091getElevationD9Ej5fM;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i6 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j = j;
                            }
                            if ((i2 & 128) != 0) {
                                j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j2 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            } else {
                                j3 = j3;
                            }
                            i10 = i3;
                        } else {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i6 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j = j;
                            }
                            if ((i2 & 128) != 0) {
                                j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j2 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            } else {
                                j3 = j3;
                            }
                            i10 = i3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller9 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller9);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller9;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope9 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier13 = modifier3;
                        composer2 = composerStartRestartGroup;
                        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope9, interfaceC0552Gp)), composer2, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        drawerState3 = drawerStateRememberDrawerState;
                        z3 = z2;
                        shape3 = large;
                        modifier4 = modifier13;
                        f3 = fM1091getElevationD9Ej5fM;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$ModalDrawer$2(interfaceC0552Gp, modifier4, drawerState3, z3, shape3, f3, j4, j5, j6, interfaceC0526Fp, i, i2));
                }
                i9 = 805306368;
                i3 |= i9;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller10 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller10);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller10;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope10 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier14 = modifier3;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope10, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    drawerState3 = drawerStateRememberDrawerState;
                    z3 = z2;
                    shape3 = large;
                    modifier4 = modifier14;
                    f3 = fM1091getElevationD9Ej5fM;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller11;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope11 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier15 = modifier3;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope11, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    drawerState3 = drawerStateRememberDrawerState;
                    z3 = z2;
                    shape3 = large;
                    modifier4 = modifier15;
                    f3 = fM1091getElevationD9Ej5fM;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$ModalDrawer$2(interfaceC0552Gp, modifier4, drawerState3, z3, shape3, f3, j4, j5, j6, interfaceC0526Fp, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f2 = f;
            if ((i & 3670016) == 0) {
                if ((i2 & 64) == 0) {
                    i8 = i13;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i3 |= i16;
                } else {
                    i8 = i13;
                }
                i3 |= i16;
            } else {
                i8 = i13;
            }
            if ((i & 29360128) != 0) {
                if ((i2 & 128) == 0) {
                    i12 = 4194304;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((234881024 & i) != 0) {
                if ((i2 & 256) == 0) {
                    i11 = 33554432;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i9 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i9 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller12 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller12);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller12;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope12 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier16 = modifier3;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope12, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    drawerState3 = drawerStateRememberDrawerState;
                    z3 = z2;
                    shape3 = large;
                    modifier4 = modifier16;
                    f3 = fM1091getElevationD9Ej5fM;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller13 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller13);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller13;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope13 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier17 = modifier3;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope13, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    drawerState3 = drawerStateRememberDrawerState;
                    z3 = z2;
                    shape3 = large;
                    modifier4 = modifier17;
                    f3 = fM1091getElevationD9Ej5fM;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$ModalDrawer$2(interfaceC0552Gp, modifier4, drawerState3, z3, shape3, f3, j4, j5, j6, interfaceC0526Fp, i, i2));
            }
            i9 = 805306368;
            i3 |= i9;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i6 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        j = j;
                    }
                    if ((i2 & 128) != 0) {
                        j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        j2 = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        j3 = j3;
                    }
                    i10 = i3;
                } else {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i6 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        j = j;
                    }
                    if ((i2 & 128) != 0) {
                        j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        j2 = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        j3 = j3;
                    }
                    i10 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                }
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller14 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller14);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller14;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope14 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier18 = modifier3;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope14, interfaceC0552Gp)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                drawerState3 = drawerStateRememberDrawerState;
                z3 = z2;
                shape3 = large;
                modifier4 = modifier18;
                f3 = fM1091getElevationD9Ej5fM;
                j4 = j;
                j5 = j2;
                j6 = j3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i6 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        j = j;
                    }
                    if ((i2 & 128) != 0) {
                        j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        j2 = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        j3 = j3;
                    }
                    i10 = i3;
                } else {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i6 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        j = j;
                    }
                    if ((i2 & 128) != 0) {
                        j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        j2 = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        j3 = j3;
                    }
                    i10 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                }
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller15 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller15);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller15;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope15 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier19 = modifier3;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope15, interfaceC0552Gp)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                drawerState3 = drawerStateRememberDrawerState;
                z3 = z2;
                shape3 = large;
                modifier4 = modifier19;
                f3 = fM1091getElevationD9Ej5fM;
                j4 = j;
                j5 = j2;
                j6 = j3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$ModalDrawer$2(interfaceC0552Gp, modifier4, drawerState3, z3, shape3, f3, j4, j5, j6, interfaceC0526Fp, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                drawerState2 = drawerState;
                if (composerStartRestartGroup.changed(drawerState2)) {
                }
                i3 |= i14;
            } else {
                drawerState2 = drawerState;
            }
            i3 |= i14;
        } else {
            drawerState2 = drawerState;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((458752 & i) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i & 3670016) == 0) {
                    if ((i2 & 64) == 0) {
                        i8 = i13;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i3 |= i16;
                    } else {
                        i8 = i13;
                    }
                    i3 |= i16;
                } else {
                    i8 = i13;
                }
                if ((i & 29360128) != 0) {
                    if ((i2 & 128) == 0) {
                        i12 = 4194304;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((234881024 & i) != 0) {
                    if ((i2 & 256) == 0) {
                        i11 = 33554432;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                            i9 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i9 = 268435456;
                        }
                    }
                    if ((1533916891 & i3) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i6 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j = j;
                            }
                            if ((i2 & 128) != 0) {
                                j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j2 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            } else {
                                j3 = j3;
                            }
                            i10 = i3;
                        } else {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i6 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j = j;
                            }
                            if ((i2 & 128) != 0) {
                                j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j2 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            } else {
                                j3 = j3;
                            }
                            i10 = i3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller16 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller16);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller16;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope16 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier110 = modifier3;
                        composer2 = composerStartRestartGroup;
                        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope16, interfaceC0552Gp)), composer2, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        drawerState3 = drawerStateRememberDrawerState;
                        z3 = z2;
                        shape3 = large;
                        modifier4 = modifier110;
                        f3 = fM1091getElevationD9Ej5fM;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i6 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j = j;
                            }
                            if ((i2 & 128) != 0) {
                                j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j2 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            } else {
                                j3 = j3;
                            }
                            i10 = i3;
                        } else {
                            if (i8 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                                i3 &= -897;
                            } else {
                                drawerStateRememberDrawerState = drawerState2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i3 &= -57345;
                            } else {
                                large = shape2;
                            }
                            if (i6 != 0) {
                                fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                            } else {
                                fM1091getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 64) != 0) {
                                j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j = j;
                            }
                            if ((i2 & 128) != 0) {
                                j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j2 = j2;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                                j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            } else {
                                j3 = j3;
                            }
                            i10 = i3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller17 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller17);
                            objRememberedValue = compositionScopedCoroutineScopeCanceller17;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope17 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifier111 = modifier3;
                        composer2 = composerStartRestartGroup;
                        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope17, interfaceC0552Gp)), composer2, 3072, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        drawerState3 = drawerStateRememberDrawerState;
                        z3 = z2;
                        shape3 = large;
                        modifier4 = modifier111;
                        f3 = fM1091getElevationD9Ej5fM;
                        j4 = j;
                        j5 = j2;
                        j6 = j3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$ModalDrawer$2(interfaceC0552Gp, modifier4, drawerState3, z3, shape3, f3, j4, j5, j6, interfaceC0526Fp, i, i2));
                }
                i9 = 805306368;
                i3 |= i9;
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller18 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller18);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller18;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope18 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier112 = modifier3;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope18, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    drawerState3 = drawerStateRememberDrawerState;
                    z3 = z2;
                    shape3 = large;
                    modifier4 = modifier112;
                    f3 = fM1091getElevationD9Ej5fM;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller19 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller19);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller19;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope19 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier113 = modifier3;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope19, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    drawerState3 = drawerStateRememberDrawerState;
                    z3 = z2;
                    shape3 = large;
                    modifier4 = modifier113;
                    f3 = fM1091getElevationD9Ej5fM;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$ModalDrawer$2(interfaceC0552Gp, modifier4, drawerState3, z3, shape3, f3, j4, j5, j6, interfaceC0526Fp, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f2 = f;
            if ((i & 3670016) == 0) {
                if ((i2 & 64) == 0) {
                    i8 = i13;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i3 |= i16;
                } else {
                    i8 = i13;
                }
                i3 |= i16;
            } else {
                i8 = i13;
            }
            if ((i & 29360128) != 0) {
                if ((i2 & 128) == 0) {
                    i12 = 4194304;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((234881024 & i) != 0) {
                if ((i2 & 256) == 0) {
                    i11 = 33554432;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i9 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i9 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller110 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller110);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller110;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope110 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier114 = modifier3;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope110, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    drawerState3 = drawerStateRememberDrawerState;
                    z3 = z2;
                    shape3 = large;
                    modifier4 = modifier114;
                    f3 = fM1091getElevationD9Ej5fM;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller111 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller111);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller111;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope111 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier115 = modifier3;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope111, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    drawerState3 = drawerStateRememberDrawerState;
                    z3 = z2;
                    shape3 = large;
                    modifier4 = modifier115;
                    f3 = fM1091getElevationD9Ej5fM;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$ModalDrawer$2(interfaceC0552Gp, modifier4, drawerState3, z3, shape3, f3, j4, j5, j6, interfaceC0526Fp, i, i2));
            }
            i9 = 805306368;
            i3 |= i9;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i6 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        j = j;
                    }
                    if ((i2 & 128) != 0) {
                        j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        j2 = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        j3 = j3;
                    }
                    i10 = i3;
                } else {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i6 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        j = j;
                    }
                    if ((i2 & 128) != 0) {
                        j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        j2 = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        j3 = j3;
                    }
                    i10 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                }
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller112 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller112);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller112;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope112 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier116 = modifier3;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope112, interfaceC0552Gp)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                drawerState3 = drawerStateRememberDrawerState;
                z3 = z2;
                shape3 = large;
                modifier4 = modifier116;
                f3 = fM1091getElevationD9Ej5fM;
                j4 = j;
                j5 = j2;
                j6 = j3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i6 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        j = j;
                    }
                    if ((i2 & 128) != 0) {
                        j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        j2 = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        j3 = j3;
                    }
                    i10 = i3;
                } else {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i6 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        j = j;
                    }
                    if ((i2 & 128) != 0) {
                        j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        j2 = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        j3 = j3;
                    }
                    i10 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                }
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller113 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller113);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller113;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope113 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier117 = modifier3;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope113, interfaceC0552Gp)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                drawerState3 = drawerStateRememberDrawerState;
                z3 = z2;
                shape3 = large;
                modifier4 = modifier117;
                f3 = fM1091getElevationD9Ej5fM;
                j4 = j;
                j5 = j2;
                j6 = j3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$ModalDrawer$2(interfaceC0552Gp, modifier4, drawerState3, z3, shape3, f3, j4, j5, j6, interfaceC0526Fp, i, i2));
        }
        i3 |= 3072;
        z2 = z;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i3 |= i15;
        } else {
            shape2 = shape;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((458752 & i) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((i & 3670016) == 0) {
                if ((i2 & 64) == 0) {
                    i8 = i13;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i3 |= i16;
                } else {
                    i8 = i13;
                }
                i3 |= i16;
            } else {
                i8 = i13;
            }
            if ((i & 29360128) != 0) {
                if ((i2 & 128) == 0) {
                    i12 = 4194304;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((234881024 & i) != 0) {
                if ((i2 & 256) == 0) {
                    i11 = 33554432;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i9 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i9 = 268435456;
                    }
                }
                if ((1533916891 & i3) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller114 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller114);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller114;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope114 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier118 = modifier3;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope114, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    drawerState3 = drawerStateRememberDrawerState;
                    z3 = z2;
                    shape3 = large;
                    modifier4 = modifier118;
                    f3 = fM1091getElevationD9Ej5fM;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    } else {
                        if (i8 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                            i3 &= -897;
                        } else {
                            drawerStateRememberDrawerState = drawerState2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i3 &= -57345;
                        } else {
                            large = shape2;
                        }
                        if (i6 != 0) {
                            fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                        } else {
                            fM1091getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 64) != 0) {
                            j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                            i3 &= -3670017;
                        } else {
                            j = j;
                        }
                        if ((i2 & 128) != 0) {
                            j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                            i3 &= -29360129;
                        } else {
                            j2 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i3 &= -234881025;
                            j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            j3 = j3;
                        }
                        i10 = i3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller115 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller115);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller115;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope115 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifier119 = modifier3;
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope115, interfaceC0552Gp)), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    drawerState3 = drawerStateRememberDrawerState;
                    z3 = z2;
                    shape3 = large;
                    modifier4 = modifier119;
                    f3 = fM1091getElevationD9Ej5fM;
                    j4 = j;
                    j5 = j2;
                    j6 = j3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$ModalDrawer$2(interfaceC0552Gp, modifier4, drawerState3, z3, shape3, f3, j4, j5, j6, interfaceC0526Fp, i, i2));
            }
            i9 = 805306368;
            i3 |= i9;
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i6 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        j = j;
                    }
                    if ((i2 & 128) != 0) {
                        j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        j2 = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        j3 = j3;
                    }
                    i10 = i3;
                } else {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i6 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        j = j;
                    }
                    if ((i2 & 128) != 0) {
                        j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        j2 = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        j3 = j3;
                    }
                    i10 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                }
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller116 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller116);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller116;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope116 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier1110 = modifier3;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope116, interfaceC0552Gp)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                drawerState3 = drawerStateRememberDrawerState;
                z3 = z2;
                shape3 = large;
                modifier4 = modifier1110;
                f3 = fM1091getElevationD9Ej5fM;
                j4 = j;
                j5 = j2;
                j6 = j3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i6 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        j = j;
                    }
                    if ((i2 & 128) != 0) {
                        j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        j2 = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        j3 = j3;
                    }
                    i10 = i3;
                } else {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i6 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        j = j;
                    }
                    if ((i2 & 128) != 0) {
                        j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        j2 = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        j3 = j3;
                    }
                    i10 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                }
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller117 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller117);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller117;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope117 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier1111 = modifier3;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope117, interfaceC0552Gp)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                drawerState3 = drawerStateRememberDrawerState;
                z3 = z2;
                shape3 = large;
                modifier4 = modifier1111;
                f3 = fM1091getElevationD9Ej5fM;
                j4 = j;
                j5 = j2;
                j6 = j3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$ModalDrawer$2(interfaceC0552Gp, modifier4, drawerState3, z3, shape3, f3, j4, j5, j6, interfaceC0526Fp, i, i2));
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        f2 = f;
        if ((i & 3670016) == 0) {
            if ((i2 & 64) == 0) {
                i8 = i13;
                if (composerStartRestartGroup.changed(j)) {
                }
                i3 |= i16;
            } else {
                i8 = i13;
            }
            i3 |= i16;
        } else {
            i8 = i13;
        }
        if ((i & 29360128) != 0) {
            if ((i2 & 128) == 0) {
                i12 = 4194304;
            } else {
                i12 = 4194304;
            }
            i3 |= i12;
        }
        if ((234881024 & i) != 0) {
            if ((i2 & 256) == 0) {
                i11 = 33554432;
            } else {
                i11 = 33554432;
            }
            i3 |= i11;
        }
        if ((i2 & 512) != 0) {
            if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i9 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i9 = 268435456;
                }
            }
            if ((1533916891 & i3) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i6 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        j = j;
                    }
                    if ((i2 & 128) != 0) {
                        j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        j2 = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        j3 = j3;
                    }
                    i10 = i3;
                } else {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i6 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        j = j;
                    }
                    if ((i2 & 128) != 0) {
                        j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        j2 = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        j3 = j3;
                    }
                    i10 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                }
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller118 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller118);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller118;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope118 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier1112 = modifier3;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope118, interfaceC0552Gp)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                drawerState3 = drawerStateRememberDrawerState;
                z3 = z2;
                shape3 = large;
                modifier4 = modifier1112;
                f3 = fM1091getElevationD9Ej5fM;
                j4 = j;
                j5 = j2;
                j6 = j3;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i6 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        j = j;
                    }
                    if ((i2 & 128) != 0) {
                        j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        j2 = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        j3 = j3;
                    }
                    i10 = i3;
                } else {
                    if (i8 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        i3 &= -897;
                    } else {
                        drawerStateRememberDrawerState = drawerState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i3 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if (i6 != 0) {
                        fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                    } else {
                        fM1091getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 64) != 0) {
                        j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                        i3 &= -3670017;
                    } else {
                        j = j;
                    }
                    if ((i2 & 128) != 0) {
                        j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -29360129;
                    } else {
                        j2 = j2;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        j3 = j3;
                    }
                    i10 = i3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
                }
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller119 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller119);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller119;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope119 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier1113 = modifier3;
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope119, interfaceC0552Gp)), composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                drawerState3 = drawerStateRememberDrawerState;
                z3 = z2;
                shape3 = large;
                modifier4 = modifier1113;
                f3 = fM1091getElevationD9Ej5fM;
                j4 = j;
                j5 = j2;
                j6 = j3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$ModalDrawer$2(interfaceC0552Gp, modifier4, drawerState3, z3, shape3, f3, j4, j5, j6, interfaceC0526Fp, i, i2));
        }
        i9 = 805306368;
        i3 |= i9;
        if ((1533916891 & i3) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    i3 &= -897;
                } else {
                    drawerStateRememberDrawerState = drawerState2;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i3 &= -57345;
                } else {
                    large = shape2;
                }
                if (i6 != 0) {
                    fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                } else {
                    fM1091getElevationD9Ej5fM = f2;
                }
                if ((i2 & 64) != 0) {
                    j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -3670017;
                } else {
                    j = j;
                }
                if ((i2 & 128) != 0) {
                    j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    j2 = j2;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                } else {
                    j3 = j3;
                }
                i10 = i3;
            } else {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    i3 &= -897;
                } else {
                    drawerStateRememberDrawerState = drawerState2;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i3 &= -57345;
                } else {
                    large = shape2;
                }
                if (i6 != 0) {
                    fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                } else {
                    fM1091getElevationD9Ej5fM = f2;
                }
                if ((i2 & 64) != 0) {
                    j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -3670017;
                } else {
                    j = j;
                }
                if ((i2 & 128) != 0) {
                    j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    j2 = j2;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                } else {
                    j3 = j3;
                }
                i10 = i3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
            }
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1110 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1110);
                objRememberedValue = compositionScopedCoroutineScopeCanceller1110;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope1110 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifier1114 = modifier3;
            composer2 = composerStartRestartGroup;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope1110, interfaceC0552Gp)), composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            drawerState3 = drawerStateRememberDrawerState;
            z3 = z2;
            shape3 = large;
            modifier4 = modifier1114;
            f3 = fM1091getElevationD9Ej5fM;
            j4 = j;
            j5 = j2;
            j6 = j3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    i3 &= -897;
                } else {
                    drawerStateRememberDrawerState = drawerState2;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i3 &= -57345;
                } else {
                    large = shape2;
                }
                if (i6 != 0) {
                    fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                } else {
                    fM1091getElevationD9Ej5fM = f2;
                }
                if ((i2 & 64) != 0) {
                    j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -3670017;
                } else {
                    j = j;
                }
                if ((i2 & 128) != 0) {
                    j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    j2 = j2;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                } else {
                    j3 = j3;
                }
                i10 = i3;
            } else {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    i3 &= -897;
                } else {
                    drawerStateRememberDrawerState = drawerState2;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i3 &= -57345;
                } else {
                    large = shape2;
                }
                if (i6 != 0) {
                    fM1091getElevationD9Ej5fM = DrawerDefaults.INSTANCE.m1091getElevationD9Ej5fM();
                } else {
                    fM1091getElevationD9Ej5fM = f2;
                }
                if ((i2 & 64) != 0) {
                    j = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1055getSurface0d7_KjU();
                    i3 &= -3670017;
                } else {
                    j = j;
                }
                if ((i2 & 128) != 0) {
                    j2 = ColorsKt.m1069contentColorForek8zF_U(j, composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -29360129;
                } else {
                    j2 = j2;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    j3 = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                } else {
                    j3 = j3;
                }
                i10 = i3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1305806945, i10, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:509)");
            }
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller1111 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller1111);
                objRememberedValue = compositionScopedCoroutineScopeCanceller1111;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope1111 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifier1115 = modifier3;
            composer2 = composerStartRestartGroup;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer2, 816674999, true, new DrawerKt$ModalDrawer$1(drawerStateRememberDrawerState, z2, i10, j3, large, j, j2, fM1091getElevationD9Ej5fM, interfaceC0526Fp, coroutineScope1111, interfaceC0552Gp)), composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            drawerState3 = drawerStateRememberDrawerState;
            z3 = z2;
            shape3 = large;
            modifier4 = modifier1115;
            f3 = fM1091getElevationD9Ej5fM;
            j4 = j;
            j5 = j2;
            j6 = j3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$ModalDrawer$2(interfaceC0552Gp, modifier4, drawerState3, z3, shape3, f3, j4, j5, j6, interfaceC0526Fp, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Scrim-Bx497Mc, reason: not valid java name */
    public static final void m1095ScrimBx497Mc(boolean z, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, long j, Composer composer, int i) {
        int i2;
        Modifier modifierSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(1983403750);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3588op2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i2 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1983403750, i2, -1, "androidx.compose.material.Scrim (Drawer.kt:834)");
            }
            String strM1225getString4foXLRw = Strings_androidKt.m1225getString4foXLRw(Strings.Companion.m1218getCloseDrawerUdPEhr4(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(1010561092);
            if (z) {
                Modifier.Companion companion = Modifier.Companion;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                boolean zChanged = composerStartRestartGroup.changed(interfaceC3588op);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new DrawerKt$Scrim$dismissDrawer$1$1(interfaceC3588op, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, interfaceC3588op, (InterfaceC0526Fp) objRememberedValue);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                boolean zChanged2 = composerStartRestartGroup.changed(strM1225getString4foXLRw) | composerStartRestartGroup.changed(interfaceC3588op);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new DrawerKt$Scrim$dismissDrawer$2$1(strM1225getString4foXLRw, interfaceC3588op);
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
            boolean zChanged3 = composerStartRestartGroup.changed(colorM3022boximpl) | composerStartRestartGroup.changed(interfaceC3588op2);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new DrawerKt$Scrim$1$1(j, interfaceC3588op2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierThen, (InterfaceC3750qp) objRememberedValue3, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new DrawerKt$Scrim$2(z, interfaceC3588op, interfaceC3588op2, j, i));
    }

    private static final Map<BottomDrawerValue, Float> calculateAnchors(float f, float f2, boolean z) {
        float f3 = 0.5f * f;
        float fMax = Math.max(0.0f, f - f2);
        if (f2 < f3 || z) {
            return AbstractC4243wx.j(HV.a(BottomDrawerValue.Closed, Float.valueOf(f)), HV.a(BottomDrawerValue.Expanded, f2 != 0.0f ? Float.valueOf(fMax) : null));
        }
        return AbstractC4243wx.j(HV.a(BottomDrawerValue.Closed, Float.valueOf(f)), HV.a(BottomDrawerValue.Open, Float.valueOf(f3)), HV.a(BottomDrawerValue.Expanded, f2 != 0.0f ? Float.valueOf(fMax) : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float f, float f2, float f3) {
        return AbstractC3871sJ.k((f3 - f) / (f2 - f), 0.0f, 1.0f);
    }

    @Composable
    @ExperimentalMaterialApi
    public static final BottomDrawerState rememberBottomDrawerState(BottomDrawerValue bottomDrawerValue, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        AbstractC4492zt.h(bottomDrawerValue, "initialValue");
        composer.startReplaceableGroup(-598115156);
        if ((i2 & 2) != 0) {
            interfaceC3750qp = C14201.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-598115156, i, -1, "androidx.compose.material.rememberBottomDrawerState (Drawer.kt:468)");
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        Object[] objArr = {density};
        Saver<BottomDrawerState, BottomDrawerValue> Saver = BottomDrawerState.Companion.Saver(density, interfaceC3750qp);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(bottomDrawerValue) | composer.changed(density) | composer.changed(interfaceC3750qp);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new DrawerKt$rememberBottomDrawerState$2$1(bottomDrawerValue, density, interfaceC3750qp);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        BottomDrawerState bottomDrawerState = (BottomDrawerState) RememberSaveableKt.m2674rememberSaveable(objArr, (Saver) Saver, (String) null, (InterfaceC3588op) objRememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bottomDrawerState;
    }

    @Composable
    public static final DrawerState rememberDrawerState(DrawerValue drawerValue, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        AbstractC4492zt.h(drawerValue, "initialValue");
        composer.startReplaceableGroup(-1435874229);
        if ((i2 & 2) != 0) {
            interfaceC3750qp = C14211.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1435874229, i, -1, "androidx.compose.material.rememberDrawerState (Drawer.kt:451)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.Companion.Saver(interfaceC3750qp);
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(drawerValue) | composer.changed(interfaceC3750qp);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new DrawerKt$rememberDrawerState$2$1(drawerValue, interfaceC3750qp);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m2674rememberSaveable(objArr, (Saver) Saver, (String) null, (InterfaceC3588op) objRememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return drawerState;
    }
}
