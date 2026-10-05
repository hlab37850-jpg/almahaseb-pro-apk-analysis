package androidx.compose.material3;

import android.view.View;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.IntSize;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AD;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C0916Sp;
import defpackage.C1172Zk;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.QO;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class ModalBottomSheet_androidKt {

    /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15311 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ ModalBottomSheetWindow $modalBottomSheetWindow;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15311(ModalBottomSheetWindow modalBottomSheetWindow) {
            super(1);
            this.$modalBottomSheetWindow = modalBottomSheetWindow;
        }

        @Override // defpackage.InterfaceC3750qp
        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
            AbstractC4492zt.h(disposableEffectScope, "$this$DisposableEffect");
            this.$modalBottomSheetWindow.show();
            final ModalBottomSheetWindow modalBottomSheetWindow = this.$modalBottomSheetWindow;
            return new DisposableEffectResult() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    modalBottomSheetWindow.disposeComposition();
                    modalBottomSheetWindow.dismiss();
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ InterfaceC3588op $onDismissRequest;
        final /* synthetic */ WindowInsets $windowInsets;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC3588op interfaceC3588op, WindowInsets windowInsets, InterfaceC0526Fp interfaceC0526Fp, int i) {
            super(2);
            this.$onDismissRequest = interfaceC3588op;
            this.$windowInsets = windowInsets;
            this.$content = interfaceC0526Fp;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            ModalBottomSheet_androidKt.ModalBottomSheetPopup(this.$onDismissRequest, this.$windowInsets, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$modalBottomSheetSwipeable$1, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C15321 extends C0916Sp implements InterfaceC0552Gp {
        public C15321(Object obj) {
            super(3, obj, AbstractC4492zt.a.class, "suspendConversion0", "modalBottomSheetSwipeable$suspendConversion0(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CoroutineScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final Object invoke(InterfaceC2052dg interfaceC2052dg, float f, InterfaceC0793Of interfaceC0793Of) {
            return ModalBottomSheet_androidKt.modalBottomSheetSwipeable$suspendConversion0((InterfaceC0526Fp) this.receiver, interfaceC2052dg, f, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((InterfaceC2052dg) obj, ((Number) obj2).floatValue(), (InterfaceC0793Of) obj3);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$modalBottomSheetSwipeable$2, reason: invalid class name and case insensitive filesystem */
    public static final class C15332 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ float $screenHeight;
        final /* synthetic */ SheetState $sheetState;

        /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$modalBottomSheetSwipeable$2$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SheetValue.values().length];
                try {
                    iArr[SheetValue.Hidden.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SheetValue.Expanded.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15332(float f, SheetState sheetState) {
            super(2);
            this.$screenHeight = f;
            this.$sheetState = sheetState;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return m1654invokeO0kMr_c((SheetValue) obj, ((IntSize) obj2).m5324unboximpl());
        }

        /* JADX INFO: renamed from: invoke-O0kMr_c, reason: not valid java name */
        public final Float m1654invokeO0kMr_c(SheetValue sheetValue, long j) {
            AbstractC4492zt.h(sheetValue, "value");
            int i = WhenMappings.$EnumSwitchMapping$0[sheetValue.ordinal()];
            if (i == 1) {
                return Float.valueOf(this.$screenHeight);
            }
            if (i == 2) {
                if (IntSize.m5319getHeightimpl(j) >= this.$screenHeight / 2 && !this.$sheetState.getSkipPartiallyExpanded$material3_release()) {
                    return Float.valueOf(this.$screenHeight / 2.0f);
                }
                return null;
            }
            if (i != 3) {
                throw new AD();
            }
            if (IntSize.m5319getHeightimpl(j) != 0) {
                return Float.valueOf(Math.max(0.0f, this.$screenHeight - IntSize.m5319getHeightimpl(j)));
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$rememberModalBottomSheetState$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15341 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C15341 INSTANCE = new C15341();

        public C15341() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(SheetValue sheetValue) {
            AbstractC4492zt.h(sheetValue, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0123  */
    /* JADX WARN: Code duplicated, block: B:109:0x0139  */
    /* JADX WARN: Code duplicated, block: B:112:0x013f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0142  */
    /* JADX WARN: Code duplicated, block: B:115:0x0146  */
    /* JADX WARN: Code duplicated, block: B:117:0x014c  */
    /* JADX WARN: Code duplicated, block: B:118:0x014e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0152  */
    /* JADX WARN: Code duplicated, block: B:129:0x017e  */
    /* JADX WARN: Code duplicated, block: B:131:0x0191  */
    /* JADX WARN: Code duplicated, block: B:154:0x01d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:155:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:156:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:159:0x01da  */
    /* JADX WARN: Code duplicated, block: B:160:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:163:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:164:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:167:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:168:0x0201  */
    /* JADX WARN: Code duplicated, block: B:171:0x0206  */
    /* JADX WARN: Code duplicated, block: B:172:0x0211  */
    /* JADX WARN: Code duplicated, block: B:174:0x0215  */
    /* JADX WARN: Code duplicated, block: B:175:0x021c  */
    /* JADX WARN: Code duplicated, block: B:178:0x0222  */
    /* JADX WARN: Code duplicated, block: B:179:0x022a  */
    /* JADX WARN: Code duplicated, block: B:181:0x022e  */
    /* JADX WARN: Code duplicated, block: B:182:0x0235  */
    /* JADX WARN: Code duplicated, block: B:185:0x023b  */
    /* JADX WARN: Code duplicated, block: B:187:0x0255  */
    /* JADX WARN: Code duplicated, block: B:190:0x026a  */
    /* JADX WARN: Code duplicated, block: B:193:0x028a  */
    /* JADX WARN: Code duplicated, block: B:196:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:198:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:201:0x0335  */
    /* JADX WARN: Code duplicated, block: B:203:0x0347  */
    /* JADX WARN: Code duplicated, block: B:205:0x034d  */
    /* JADX WARN: Code duplicated, block: B:207:0x0361  */
    /* JADX WARN: Code duplicated, block: B:210:0x0369  */
    /* JADX WARN: Code duplicated, block: B:215:0x0383  */
    /* JADX WARN: Code duplicated, block: B:217:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:30:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:91:0x0101  */
    /* JADX WARN: Code duplicated, block: B:92:0x0108  */
    /* JADX WARN: Code duplicated, block: B:94:0x0110  */
    /* JADX WARN: Code duplicated, block: B:96:0x0116  */
    /* JADX WARN: Code duplicated, block: B:97:0x0119  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ModalBottomSheet-EP0qOeE, reason: not valid java name */
    public static final void m1646ModalBottomSheetEP0qOeE(InterfaceC3588op interfaceC3588op, Modifier modifier, SheetState sheetState, Shape shape, long j, long j2, float f, long j3, InterfaceC0526Fp interfaceC0526Fp, WindowInsets windowInsets, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2, int i3) {
        int i4;
        Modifier modifier2;
        SheetState sheetState2;
        Shape shape2;
        long j4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Modifier modifier3;
        SheetState sheetStateRememberModalBottomSheetState;
        Shape expandedShape;
        long containerColor;
        long jM1449contentColorForek8zF_U;
        float fM1347getElevationD9Ej5fM;
        long scrimColor;
        InterfaceC0526Fp interfaceC0526FpM1472getLambda1$material3_release;
        WindowInsets windowInsets2;
        Shape shape3;
        long j5;
        int i12;
        Object objRememberedValue;
        Composer.Companion companion;
        InterfaceC2052dg coroutineScope;
        int i13;
        boolean zChanged;
        Object objRememberedValue2;
        Composer composer2;
        SheetState sheetState3;
        SheetState sheetState4;
        Modifier modifier4;
        WindowInsets windowInsets3;
        SheetState sheetState5;
        Shape shape4;
        long j6;
        long j7;
        float f2;
        long j8;
        InterfaceC0526Fp interfaceC0526Fp2;
        boolean zChanged2;
        Object objRememberedValue3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3588op, "onDismissRequest");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-879758728);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i14 = i3 & 2;
        if (i14 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i3 & 4) == 0) {
                    sheetState2 = sheetState;
                    int i15 = composerStartRestartGroup.changed(sheetState2) ? 256 : 128;
                    i4 |= i15;
                } else {
                    sheetState2 = sheetState;
                }
                i4 |= i15;
            } else {
                sheetState2 = sheetState;
            }
            if ((i & 7168) == 0) {
                if ((i3 & 8) == 0) {
                    shape2 = shape;
                    int i16 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                    i4 |= i16;
                } else {
                    shape2 = shape;
                }
                i4 |= i16;
            } else {
                shape2 = shape;
            }
            if ((57344 & i) == 0) {
                if ((i3 & 16) == 0) {
                    j4 = j;
                    int i17 = composerStartRestartGroup.changed(j4) ? 16384 : 8192;
                    i4 |= i17;
                } else {
                    j4 = j;
                }
                i4 |= i17;
            } else {
                j4 = j;
            }
            if ((458752 & i) == 0) {
                if ((i3 & 32) == 0) {
                    i5 = i14;
                    int i18 = composerStartRestartGroup.changed(j2) ? 131072 : 65536;
                    i4 |= i18;
                } else {
                    i5 = i14;
                }
                i4 |= i18;
            } else {
                i5 = i14;
            }
            i6 = i3 & 64;
            if (i6 != 0) {
                i4 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i4 |= i7;
            }
            if ((i & 29360128) != 0) {
                i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(j3)) ? 4194304 : 8388608;
            }
            i8 = i3 & 256;
            if (i8 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
                i4 |= i9;
            }
            if ((i & 1879048192) != 0) {
                i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 268435456 : PropertyOptions.DELETE_EXISTING;
            }
            if ((i3 & 1024) != 0) {
                i10 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i11 = 4;
                } else {
                    i11 = 2;
                }
                i10 = i2 | i11;
            } else {
                i10 = i2;
            }
            if ((i4 & 1533916891) != 306783378 && (i10 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
                windowInsets3 = windowInsets;
                modifier4 = modifier2;
                sheetState5 = sheetState2;
                shape4 = shape2;
                j6 = j4;
                composer2 = composerStartRestartGroup;
                j7 = j2;
                f2 = f;
                j8 = j3;
                interfaceC0526Fp2 = interfaceC0526Fp;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 4) != 0) {
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        sheetStateRememberModalBottomSheetState = sheetState2;
                    }
                    if ((i3 & 8) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        expandedShape = shape2;
                    }
                    if ((i3 & 16) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        containerColor = j4;
                    }
                    if ((i3 & 32) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                        i4 &= -458753;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i6 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f;
                    }
                    if ((i3 & 128) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i4 &= -29360129;
                    } else {
                        scrimColor = j3;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpM1472getLambda1$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1472getLambda1$material3_release();
                    } else {
                        interfaceC0526FpM1472getLambda1$material3_release = interfaceC0526Fp;
                    }
                    if ((i3 & 512) != 0) {
                        i4 &= -1879048193;
                        windowInsets2 = BottomSheetDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    shape3 = expandedShape;
                    j5 = containerColor;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                    }
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                    }
                    if ((i3 & 512) != 0) {
                        i4 &= -1879048193;
                    }
                    jM1449contentColorForek8zF_U = j2;
                    fM1347getElevationD9Ej5fM = f;
                    scrimColor = j3;
                    interfaceC0526FpM1472getLambda1$material3_release = interfaceC0526Fp;
                    modifier3 = modifier2;
                    sheetStateRememberModalBottomSheetState = sheetState2;
                    shape3 = shape2;
                    j5 = j4;
                    windowInsets2 = windowInsets;
                }
                i12 = i4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-879758728, i12, i10, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:122)");
                }
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
                ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1 modalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1 = new ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1(sheetStateRememberModalBottomSheetState, coroutineScope, interfaceC3588op);
                ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1 modalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1 = new ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1(coroutineScope, sheetStateRememberModalBottomSheetState, interfaceC3588op);
                i13 = ((i12 >> 6) & 14) | 64;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState) | composerStartRestartGroup.changed(coroutineScope);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = ModalBottomSheetAnchorChangeHandler(sheetStateRememberModalBottomSheetState, new ModalBottomSheet_androidKt$ModalBottomSheet$anchorChangeHandler$1$1(coroutineScope, sheetStateRememberModalBottomSheetState), new ModalBottomSheet_androidKt$ModalBottomSheet$anchorChangeHandler$1$2(sheetStateRememberModalBottomSheetState, coroutineScope));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier5 = modifier3;
                Modifier modifier6 = modifier3;
                WindowInsets windowInsets4 = windowInsets2;
                composer2 = composerStartRestartGroup;
                sheetState3 = sheetStateRememberModalBottomSheetState;
                ModalBottomSheetPopup(new ModalBottomSheet_androidKt$ModalBottomSheet$1(sheetStateRememberModalBottomSheetState, coroutineScope, interfaceC3588op), windowInsets4, ComposableLambdaKt.composableLambda(composer2, 1424497392, true, new ModalBottomSheet_androidKt$ModalBottomSheet$2(scrimColor, modalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1, sheetStateRememberModalBottomSheetState, i12, modifier5, (AnchorChangeHandler) objRememberedValue2, modalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1, shape3, j5, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, interfaceC0526FpM1472getLambda1$material3_release, interfaceC0552Gp, i10, coroutineScope)), composer2, ((i12 >> 24) & 112) | 384);
                if (sheetState3.getHasExpandedState()) {
                    composer2.startReplaceableGroup(1157296644);
                    sheetState4 = sheetState3;
                    zChanged2 = composer2.changed(sheetState4);
                    objRememberedValue3 = composer2.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                        objRememberedValue3 = new ModalBottomSheet_androidKt$ModalBottomSheet$3$1(sheetState4, null);
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    composer2.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(sheetState4, (InterfaceC0526Fp) objRememberedValue3, composer2, i13);
                } else {
                    sheetState4 = sheetState3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier6;
                windowInsets3 = windowInsets4;
                sheetState5 = sheetState4;
                shape4 = shape3;
                j6 = j5;
                j7 = jM1449contentColorForek8zF_U;
                f2 = fM1347getElevationD9Ej5fM;
                j8 = scrimColor;
                interfaceC0526Fp2 = interfaceC0526FpM1472getLambda1$material3_release;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheet_androidKt$ModalBottomSheet$4(interfaceC3588op, modifier4, sheetState5, shape4, j6, j7, f2, j8, interfaceC0526Fp2, windowInsets3, interfaceC0552Gp, i, i2, i3));
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i & 896) == 0) {
            if ((i3 & 4) == 0) {
                sheetState2 = sheetState;
                if (composerStartRestartGroup.changed(sheetState2)) {
                }
                i4 |= i15;
            } else {
                sheetState2 = sheetState;
            }
            i4 |= i15;
        } else {
            sheetState2 = sheetState;
        }
        if ((i & 7168) == 0) {
            if ((i3 & 8) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i4 |= i16;
            } else {
                shape2 = shape;
            }
            i4 |= i16;
        } else {
            shape2 = shape;
        }
        if ((57344 & i) == 0) {
            if ((i3 & 16) == 0) {
                j4 = j;
                if (composerStartRestartGroup.changed(j4)) {
                }
                i4 |= i17;
            } else {
                j4 = j;
            }
            i4 |= i17;
        } else {
            j4 = j;
        }
        if ((458752 & i) == 0) {
            if ((i3 & 32) == 0) {
                i5 = i14;
                if (composerStartRestartGroup.changed(j2)) {
                }
                i4 |= i18;
            } else {
                i5 = i14;
            }
            i4 |= i18;
        } else {
            i5 = i14;
        }
        i6 = i3 & 64;
        if (i6 != 0) {
            i4 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i7 = 1048576;
            } else {
                i7 = 524288;
            }
            i4 |= i7;
        }
        if ((i & 29360128) != 0) {
            i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(j3)) ? 4194304 : 8388608;
        }
        i8 = i3 & 256;
        if (i8 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                i9 = 67108864;
            } else {
                i9 = 33554432;
            }
            i4 |= i9;
        }
        if ((i & 1879048192) != 0) {
            i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 268435456 : PropertyOptions.DELETE_EXISTING;
        }
        if ((i3 & 1024) != 0) {
            i10 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                i11 = 4;
            } else {
                i11 = 2;
            }
            i10 = i2 | i11;
        } else {
            i10 = i2;
        }
        if ((i4 & 1533916891) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i3 & 4) != 0) {
                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    i4 &= -897;
                } else {
                    sheetStateRememberModalBottomSheetState = sheetState2;
                }
                if ((i3 & 8) != 0) {
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    expandedShape = shape2;
                }
                if ((i3 & 16) != 0) {
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    containerColor = j4;
                }
                if ((i3 & 32) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                    i4 &= -458753;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if (i6 != 0) {
                    fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                } else {
                    fM1347getElevationD9Ej5fM = f;
                }
                if ((i3 & 128) != 0) {
                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i4 &= -29360129;
                } else {
                    scrimColor = j3;
                }
                if (i8 != 0) {
                    interfaceC0526FpM1472getLambda1$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1472getLambda1$material3_release();
                } else {
                    interfaceC0526FpM1472getLambda1$material3_release = interfaceC0526Fp;
                }
                if ((i3 & 512) != 0) {
                    i4 &= -1879048193;
                    windowInsets2 = BottomSheetDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    windowInsets2 = windowInsets;
                }
                shape3 = expandedShape;
                j5 = containerColor;
            } else {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i3 & 4) != 0) {
                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    i4 &= -897;
                } else {
                    sheetStateRememberModalBottomSheetState = sheetState2;
                }
                if ((i3 & 8) != 0) {
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    expandedShape = shape2;
                }
                if ((i3 & 16) != 0) {
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    containerColor = j4;
                }
                if ((i3 & 32) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                    i4 &= -458753;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if (i6 != 0) {
                    fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                } else {
                    fM1347getElevationD9Ej5fM = f;
                }
                if ((i3 & 128) != 0) {
                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i4 &= -29360129;
                } else {
                    scrimColor = j3;
                }
                if (i8 != 0) {
                    interfaceC0526FpM1472getLambda1$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1472getLambda1$material3_release();
                } else {
                    interfaceC0526FpM1472getLambda1$material3_release = interfaceC0526Fp;
                }
                if ((i3 & 512) != 0) {
                    i4 &= -1879048193;
                    windowInsets2 = BottomSheetDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    windowInsets2 = windowInsets;
                }
                shape3 = expandedShape;
                j5 = containerColor;
            }
            i12 = i4;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-879758728, i12, i10, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:122)");
            }
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
            ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1 modalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$2 = new ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1(sheetStateRememberModalBottomSheetState, coroutineScope, interfaceC3588op);
            ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1 modalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$2 = new ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1(coroutineScope, sheetStateRememberModalBottomSheetState, interfaceC3588op);
            i13 = ((i12 >> 6) & 14) | 64;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState) | composerStartRestartGroup.changed(coroutineScope);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = ModalBottomSheetAnchorChangeHandler(sheetStateRememberModalBottomSheetState, new ModalBottomSheet_androidKt$ModalBottomSheet$anchorChangeHandler$1$1(coroutineScope, sheetStateRememberModalBottomSheetState), new ModalBottomSheet_androidKt$ModalBottomSheet$anchorChangeHandler$1$2(sheetStateRememberModalBottomSheetState, coroutineScope));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = ModalBottomSheetAnchorChangeHandler(sheetStateRememberModalBottomSheetState, new ModalBottomSheet_androidKt$ModalBottomSheet$anchorChangeHandler$1$1(coroutineScope, sheetStateRememberModalBottomSheetState), new ModalBottomSheet_androidKt$ModalBottomSheet$anchorChangeHandler$1$2(sheetStateRememberModalBottomSheetState, coroutineScope));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifier7 = modifier3;
            Modifier modifier8 = modifier3;
            WindowInsets windowInsets5 = windowInsets2;
            composer2 = composerStartRestartGroup;
            sheetState3 = sheetStateRememberModalBottomSheetState;
            ModalBottomSheetPopup(new ModalBottomSheet_androidKt$ModalBottomSheet$1(sheetStateRememberModalBottomSheetState, coroutineScope, interfaceC3588op), windowInsets5, ComposableLambdaKt.composableLambda(composer2, 1424497392, true, new ModalBottomSheet_androidKt$ModalBottomSheet$2(scrimColor, modalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$2, sheetStateRememberModalBottomSheetState, i12, modifier7, (AnchorChangeHandler) objRememberedValue2, modalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$2, shape3, j5, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, interfaceC0526FpM1472getLambda1$material3_release, interfaceC0552Gp, i10, coroutineScope)), composer2, ((i12 >> 24) & 112) | 384);
            if (sheetState3.getHasExpandedState()) {
                composer2.startReplaceableGroup(1157296644);
                sheetState4 = sheetState3;
                zChanged2 = composer2.changed(sheetState4);
                objRememberedValue3 = composer2.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new ModalBottomSheet_androidKt$ModalBottomSheet$3$1(sheetState4, null);
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ModalBottomSheet_androidKt$ModalBottomSheet$3$1(sheetState4, null);
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                composer2.endReplaceableGroup();
                EffectsKt.LaunchedEffect(sheetState4, (InterfaceC0526Fp) objRememberedValue3, composer2, i13);
            } else {
                sheetState4 = sheetState3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier8;
            windowInsets3 = windowInsets5;
            sheetState5 = sheetState4;
            shape4 = shape3;
            j6 = j5;
            j7 = jM1449contentColorForek8zF_U;
            f2 = fM1347getElevationD9Ej5fM;
            j8 = scrimColor;
            interfaceC0526Fp2 = interfaceC0526FpM1472getLambda1$material3_release;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i3 & 4) != 0) {
                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    i4 &= -897;
                } else {
                    sheetStateRememberModalBottomSheetState = sheetState2;
                }
                if ((i3 & 8) != 0) {
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    expandedShape = shape2;
                }
                if ((i3 & 16) != 0) {
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    containerColor = j4;
                }
                if ((i3 & 32) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                    i4 &= -458753;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if (i6 != 0) {
                    fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                } else {
                    fM1347getElevationD9Ej5fM = f;
                }
                if ((i3 & 128) != 0) {
                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i4 &= -29360129;
                } else {
                    scrimColor = j3;
                }
                if (i8 != 0) {
                    interfaceC0526FpM1472getLambda1$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1472getLambda1$material3_release();
                } else {
                    interfaceC0526FpM1472getLambda1$material3_release = interfaceC0526Fp;
                }
                if ((i3 & 512) != 0) {
                    i4 &= -1879048193;
                    windowInsets2 = BottomSheetDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    windowInsets2 = windowInsets;
                }
                shape3 = expandedShape;
                j5 = containerColor;
            } else {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i3 & 4) != 0) {
                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    i4 &= -897;
                } else {
                    sheetStateRememberModalBottomSheetState = sheetState2;
                }
                if ((i3 & 8) != 0) {
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    expandedShape = shape2;
                }
                if ((i3 & 16) != 0) {
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    containerColor = j4;
                }
                if ((i3 & 32) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                    i4 &= -458753;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if (i6 != 0) {
                    fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                } else {
                    fM1347getElevationD9Ej5fM = f;
                }
                if ((i3 & 128) != 0) {
                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i4 &= -29360129;
                } else {
                    scrimColor = j3;
                }
                if (i8 != 0) {
                    interfaceC0526FpM1472getLambda1$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1472getLambda1$material3_release();
                } else {
                    interfaceC0526FpM1472getLambda1$material3_release = interfaceC0526Fp;
                }
                if ((i3 & 512) != 0) {
                    i4 &= -1879048193;
                    windowInsets2 = BottomSheetDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    windowInsets2 = windowInsets;
                }
                shape3 = expandedShape;
                j5 = containerColor;
            }
            i12 = i4;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-879758728, i12, i10, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:122)");
            }
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
            ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1 modalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$3 = new ModalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$1(sheetStateRememberModalBottomSheetState, coroutineScope, interfaceC3588op);
            ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1 modalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$3 = new ModalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$1(coroutineScope, sheetStateRememberModalBottomSheetState, interfaceC3588op);
            i13 = ((i12 >> 6) & 14) | 64;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState) | composerStartRestartGroup.changed(coroutineScope);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = ModalBottomSheetAnchorChangeHandler(sheetStateRememberModalBottomSheetState, new ModalBottomSheet_androidKt$ModalBottomSheet$anchorChangeHandler$1$1(coroutineScope, sheetStateRememberModalBottomSheetState), new ModalBottomSheet_androidKt$ModalBottomSheet$anchorChangeHandler$1$2(sheetStateRememberModalBottomSheetState, coroutineScope));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = ModalBottomSheetAnchorChangeHandler(sheetStateRememberModalBottomSheetState, new ModalBottomSheet_androidKt$ModalBottomSheet$anchorChangeHandler$1$1(coroutineScope, sheetStateRememberModalBottomSheetState), new ModalBottomSheet_androidKt$ModalBottomSheet$anchorChangeHandler$1$2(sheetStateRememberModalBottomSheetState, coroutineScope));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifier9 = modifier3;
            Modifier modifier10 = modifier3;
            WindowInsets windowInsets6 = windowInsets2;
            composer2 = composerStartRestartGroup;
            sheetState3 = sheetStateRememberModalBottomSheetState;
            ModalBottomSheetPopup(new ModalBottomSheet_androidKt$ModalBottomSheet$1(sheetStateRememberModalBottomSheetState, coroutineScope, interfaceC3588op), windowInsets6, ComposableLambdaKt.composableLambda(composer2, 1424497392, true, new ModalBottomSheet_androidKt$ModalBottomSheet$2(scrimColor, modalBottomSheet_androidKt$ModalBottomSheet$animateToDismiss$3, sheetStateRememberModalBottomSheetState, i12, modifier9, (AnchorChangeHandler) objRememberedValue2, modalBottomSheet_androidKt$ModalBottomSheet$settleToDismiss$3, shape3, j5, jM1449contentColorForek8zF_U, fM1347getElevationD9Ej5fM, interfaceC0526FpM1472getLambda1$material3_release, interfaceC0552Gp, i10, coroutineScope)), composer2, ((i12 >> 24) & 112) | 384);
            if (sheetState3.getHasExpandedState()) {
                composer2.startReplaceableGroup(1157296644);
                sheetState4 = sheetState3;
                zChanged2 = composer2.changed(sheetState4);
                objRememberedValue3 = composer2.rememberedValue();
                if (zChanged2) {
                    objRememberedValue3 = new ModalBottomSheet_androidKt$ModalBottomSheet$3$1(sheetState4, null);
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new ModalBottomSheet_androidKt$ModalBottomSheet$3$1(sheetState4, null);
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                composer2.endReplaceableGroup();
                EffectsKt.LaunchedEffect(sheetState4, (InterfaceC0526Fp) objRememberedValue3, composer2, i13);
            } else {
                sheetState4 = sheetState3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier10;
            windowInsets3 = windowInsets6;
            sheetState5 = sheetState4;
            shape4 = shape3;
            j6 = j5;
            j7 = jM1449contentColorForek8zF_U;
            f2 = fM1347getElevationD9Ej5fM;
            j8 = scrimColor;
            interfaceC0526Fp2 = interfaceC0526FpM1472getLambda1$material3_release;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheet_androidKt$ModalBottomSheet$4(interfaceC3588op, modifier4, sheetState5, shape4, j6, j7, f2, j8, interfaceC0526Fp2, windowInsets3, interfaceC0552Gp, i, i2, i3));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0121  */
    /* JADX WARN: Code duplicated, block: B:103:0x0125  */
    /* JADX WARN: Code duplicated, block: B:105:0x012a  */
    /* JADX WARN: Code duplicated, block: B:107:0x0130  */
    /* JADX WARN: Code duplicated, block: B:108:0x0133  */
    /* JADX WARN: Code duplicated, block: B:111:0x013f  */
    /* JADX WARN: Code duplicated, block: B:115:0x0159  */
    /* JADX WARN: Code duplicated, block: B:117:0x0169  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:137:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:145:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:146:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:149:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:153:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:154:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:156:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:157:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:160:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:161:0x0200  */
    /* JADX WARN: Code duplicated, block: B:163:0x0204  */
    /* JADX WARN: Code duplicated, block: B:165:0x021b  */
    /* JADX WARN: Code duplicated, block: B:168:0x0227  */
    /* JADX WARN: Code duplicated, block: B:171:0x025d  */
    /* JADX WARN: Code duplicated, block: B:176:0x0277  */
    /* JADX WARN: Code duplicated, block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:30:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00da  */
    /* JADX WARN: Code duplicated, block: B:75:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:90:0x0103  */
    /* JADX WARN: Code duplicated, block: B:92:0x0109  */
    /* JADX WARN: Code duplicated, block: B:94:0x010e  */
    /* JADX WARN: Code duplicated, block: B:96:0x0116  */
    /* JADX WARN: Code duplicated, block: B:97:0x0119  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ModalBottomSheet-xOkiWaM, reason: not valid java name */
    public static final /* synthetic */ void m1647ModalBottomSheetxOkiWaM(InterfaceC3588op interfaceC3588op, Modifier modifier, SheetState sheetState, Shape shape, long j, long j2, float f, long j3, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        SheetState sheetState2;
        Shape shape2;
        long j4;
        int i4;
        int i5;
        float f2;
        int i6;
        int i7;
        int i8;
        int i9;
        Modifier modifier2;
        SheetState sheetStateRememberModalBottomSheetState;
        Shape expandedShape;
        long containerColor;
        long jM1449contentColorForek8zF_U;
        float fM1347getElevationD9Ej5fM;
        long scrimColor;
        InterfaceC0526Fp interfaceC0526FpM1473getLambda2$material3_release;
        Modifier modifier3;
        long j5;
        float f3;
        long j6;
        long j7;
        SheetState sheetState3;
        Shape shape3;
        Composer composer2;
        Modifier modifier4;
        SheetState sheetState4;
        Shape shape4;
        long j8;
        long j9;
        float f4;
        long j10;
        InterfaceC0526Fp interfaceC0526Fp2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        AbstractC4492zt.h(interfaceC3588op, "onDismissRequest");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-1311611302);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    sheetState2 = sheetState;
                    int i12 = composerStartRestartGroup.changed(sheetState2) ? 256 : 128;
                    i3 |= i12;
                } else {
                    sheetState2 = sheetState;
                }
                i3 |= i12;
            } else {
                sheetState2 = sheetState;
            }
            if ((i & 7168) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    int i13 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    j4 = j;
                    int i14 = composerStartRestartGroup.changed(j4) ? 16384 : 8192;
                    i3 |= i14;
                } else {
                    j4 = j;
                }
                i3 |= i14;
            } else {
                j4 = j;
            }
            if ((458752 & i) == 0) {
                int i15 = i3;
                if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(j2)) {
                    i10 = 65536;
                } else {
                    i10 = 131072;
                }
                i4 = i15 | i10;
            } else {
                i4 = i3;
            }
            i5 = i2 & 64;
            if (i5 != 0) {
                i4 |= 1572864;
                f2 = f;
            } else {
                f2 = f;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                    i4 |= i6;
                }
            }
            if ((i & 29360128) != 0) {
                i4 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j3)) ? 4194304 : 8388608;
            }
            i7 = i2 & 256;
            if (i7 != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i8 = 67108864;
                    } else {
                        i8 = 33554432;
                    }
                    i4 |= i8;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i9 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i9 = 268435456;
                        }
                    }
                    if ((1533916891 & i4) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                sheetStateRememberModalBottomSheetState = sheetState2;
                            }
                            if ((i2 & 8) != 0) {
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                i4 &= -7169;
                            } else {
                                expandedShape = shape2;
                            }
                            if ((i2 & 16) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -57345;
                            } else {
                                containerColor = j4;
                            }
                            if ((i2 & 32) != 0) {
                                jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                                i4 &= -458753;
                            } else {
                                jM1449contentColorForek8zF_U = j2;
                            }
                            if (i5 != 0) {
                                fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                            } else {
                                fM1347getElevationD9Ej5fM = f2;
                            }
                            if ((i2 & 128) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i4 = (-29360129) & i4;
                            } else {
                                scrimColor = j3;
                            }
                            if (i7 != 0) {
                                interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                            } else {
                                interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                            }
                            modifier3 = modifier2;
                            j5 = containerColor;
                            f3 = fM1347getElevationD9Ej5fM;
                            j6 = scrimColor;
                            j7 = jM1449contentColorForek8zF_U;
                            sheetState3 = sheetStateRememberModalBottomSheetState;
                            shape3 = expandedShape;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i4 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i4 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i4 &= -458753;
                            }
                            if ((i2 & 128) != 0) {
                                i4 &= -29360129;
                            }
                            modifier3 = modifier;
                            j7 = j2;
                            j6 = j3;
                            interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                            sheetState3 = sheetState2;
                            shape3 = shape2;
                            j5 = j4;
                            f3 = f2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1311611302, i4, -1, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:281)");
                        }
                        composer2 = composerStartRestartGroup;
                        m1646ModalBottomSheetEP0qOeE(interfaceC3588op, modifier3, sheetState3, shape3, j5, j7, f3, j6, interfaceC0526FpM1473getLambda2$material3_release, null, interfaceC0552Gp, composer2, i4 & 268435454, (i4 >> 27) & 14, 512);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        sheetState4 = sheetState3;
                        shape4 = shape3;
                        j8 = j5;
                        j9 = j7;
                        f4 = f3;
                        j10 = j6;
                        interfaceC0526Fp2 = interfaceC0526FpM1473getLambda2$material3_release;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier4 = modifier;
                        interfaceC0526Fp2 = interfaceC0526Fp;
                        sheetState4 = sheetState2;
                        shape4 = shape2;
                        j8 = j4;
                        f4 = f2;
                        composer2 = composerStartRestartGroup;
                        j9 = j2;
                        j10 = j3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheet_androidKt$ModalBottomSheet$5(interfaceC3588op, modifier4, sheetState4, shape4, j8, j9, f4, j10, interfaceC0526Fp2, interfaceC0552Gp, i, i2));
                }
                i9 = 805306368;
                i4 |= i9;
                if ((1533916891 & i4) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            sheetStateRememberModalBottomSheetState = sheetState2;
                        }
                        if ((i2 & 8) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            expandedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            containerColor = j4;
                        }
                        if ((i2 & 32) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                            i4 &= -458753;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i5 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 128) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i4 = (-29360129) & i4;
                        } else {
                            scrimColor = j3;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                        j5 = containerColor;
                        f3 = fM1347getElevationD9Ej5fM;
                        j6 = scrimColor;
                        j7 = jM1449contentColorForek8zF_U;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        shape3 = expandedShape;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            sheetStateRememberModalBottomSheetState = sheetState2;
                        }
                        if ((i2 & 8) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            expandedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            containerColor = j4;
                        }
                        if ((i2 & 32) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                            i4 &= -458753;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i5 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 128) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i4 = (-29360129) & i4;
                        } else {
                            scrimColor = j3;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                        j5 = containerColor;
                        f3 = fM1347getElevationD9Ej5fM;
                        j6 = scrimColor;
                        j7 = jM1449contentColorForek8zF_U;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        shape3 = expandedShape;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1311611302, i4, -1, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:281)");
                    }
                    composer2 = composerStartRestartGroup;
                    m1646ModalBottomSheetEP0qOeE(interfaceC3588op, modifier3, sheetState3, shape3, j5, j7, f3, j6, interfaceC0526FpM1473getLambda2$material3_release, null, interfaceC0552Gp, composer2, i4 & 268435454, (i4 >> 27) & 14, 512);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    sheetState4 = sheetState3;
                    shape4 = shape3;
                    j8 = j5;
                    j9 = j7;
                    f4 = f3;
                    j10 = j6;
                    interfaceC0526Fp2 = interfaceC0526FpM1473getLambda2$material3_release;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            sheetStateRememberModalBottomSheetState = sheetState2;
                        }
                        if ((i2 & 8) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            expandedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            containerColor = j4;
                        }
                        if ((i2 & 32) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                            i4 &= -458753;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i5 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 128) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i4 = (-29360129) & i4;
                        } else {
                            scrimColor = j3;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                        j5 = containerColor;
                        f3 = fM1347getElevationD9Ej5fM;
                        j6 = scrimColor;
                        j7 = jM1449contentColorForek8zF_U;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        shape3 = expandedShape;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            sheetStateRememberModalBottomSheetState = sheetState2;
                        }
                        if ((i2 & 8) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            expandedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            containerColor = j4;
                        }
                        if ((i2 & 32) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                            i4 &= -458753;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i5 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 128) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i4 = (-29360129) & i4;
                        } else {
                            scrimColor = j3;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                        j5 = containerColor;
                        f3 = fM1347getElevationD9Ej5fM;
                        j6 = scrimColor;
                        j7 = jM1449contentColorForek8zF_U;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        shape3 = expandedShape;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1311611302, i4, -1, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:281)");
                    }
                    composer2 = composerStartRestartGroup;
                    m1646ModalBottomSheetEP0qOeE(interfaceC3588op, modifier3, sheetState3, shape3, j5, j7, f3, j6, interfaceC0526FpM1473getLambda2$material3_release, null, interfaceC0552Gp, composer2, i4 & 268435454, (i4 >> 27) & 14, 512);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    sheetState4 = sheetState3;
                    shape4 = shape3;
                    j8 = j5;
                    j9 = j7;
                    f4 = f3;
                    j10 = j6;
                    interfaceC0526Fp2 = interfaceC0526FpM1473getLambda2$material3_release;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheet_androidKt$ModalBottomSheet$5(interfaceC3588op, modifier4, sheetState4, shape4, j8, j9, f4, j10, interfaceC0526Fp2, interfaceC0552Gp, i, i2));
            }
            i4 |= 100663296;
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i9 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i9 = 268435456;
                    }
                }
                if ((1533916891 & i4) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            sheetStateRememberModalBottomSheetState = sheetState2;
                        }
                        if ((i2 & 8) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            expandedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            containerColor = j4;
                        }
                        if ((i2 & 32) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                            i4 &= -458753;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i5 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 128) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i4 = (-29360129) & i4;
                        } else {
                            scrimColor = j3;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                        j5 = containerColor;
                        f3 = fM1347getElevationD9Ej5fM;
                        j6 = scrimColor;
                        j7 = jM1449contentColorForek8zF_U;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        shape3 = expandedShape;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            sheetStateRememberModalBottomSheetState = sheetState2;
                        }
                        if ((i2 & 8) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            expandedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            containerColor = j4;
                        }
                        if ((i2 & 32) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                            i4 &= -458753;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i5 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 128) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i4 = (-29360129) & i4;
                        } else {
                            scrimColor = j3;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                        j5 = containerColor;
                        f3 = fM1347getElevationD9Ej5fM;
                        j6 = scrimColor;
                        j7 = jM1449contentColorForek8zF_U;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        shape3 = expandedShape;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1311611302, i4, -1, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:281)");
                    }
                    composer2 = composerStartRestartGroup;
                    m1646ModalBottomSheetEP0qOeE(interfaceC3588op, modifier3, sheetState3, shape3, j5, j7, f3, j6, interfaceC0526FpM1473getLambda2$material3_release, null, interfaceC0552Gp, composer2, i4 & 268435454, (i4 >> 27) & 14, 512);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    sheetState4 = sheetState3;
                    shape4 = shape3;
                    j8 = j5;
                    j9 = j7;
                    f4 = f3;
                    j10 = j6;
                    interfaceC0526Fp2 = interfaceC0526FpM1473getLambda2$material3_release;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            sheetStateRememberModalBottomSheetState = sheetState2;
                        }
                        if ((i2 & 8) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            expandedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            containerColor = j4;
                        }
                        if ((i2 & 32) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                            i4 &= -458753;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i5 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 128) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i4 = (-29360129) & i4;
                        } else {
                            scrimColor = j3;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                        j5 = containerColor;
                        f3 = fM1347getElevationD9Ej5fM;
                        j6 = scrimColor;
                        j7 = jM1449contentColorForek8zF_U;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        shape3 = expandedShape;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            sheetStateRememberModalBottomSheetState = sheetState2;
                        }
                        if ((i2 & 8) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            expandedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            containerColor = j4;
                        }
                        if ((i2 & 32) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                            i4 &= -458753;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i5 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 128) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i4 = (-29360129) & i4;
                        } else {
                            scrimColor = j3;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                        j5 = containerColor;
                        f3 = fM1347getElevationD9Ej5fM;
                        j6 = scrimColor;
                        j7 = jM1449contentColorForek8zF_U;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        shape3 = expandedShape;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1311611302, i4, -1, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:281)");
                    }
                    composer2 = composerStartRestartGroup;
                    m1646ModalBottomSheetEP0qOeE(interfaceC3588op, modifier3, sheetState3, shape3, j5, j7, f3, j6, interfaceC0526FpM1473getLambda2$material3_release, null, interfaceC0552Gp, composer2, i4 & 268435454, (i4 >> 27) & 14, 512);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    sheetState4 = sheetState3;
                    shape4 = shape3;
                    j8 = j5;
                    j9 = j7;
                    f4 = f3;
                    j10 = j6;
                    interfaceC0526Fp2 = interfaceC0526FpM1473getLambda2$material3_release;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheet_androidKt$ModalBottomSheet$5(interfaceC3588op, modifier4, sheetState4, shape4, j8, j9, f4, j10, interfaceC0526Fp2, interfaceC0552Gp, i, i2));
            }
            i9 = 805306368;
            i4 |= i9;
            if ((1533916891 & i4) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        sheetStateRememberModalBottomSheetState = sheetState2;
                    }
                    if ((i2 & 8) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        expandedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        containerColor = j4;
                    }
                    if ((i2 & 32) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                        i4 &= -458753;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 128) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i4 = (-29360129) & i4;
                    } else {
                        scrimColor = j3;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                    j5 = containerColor;
                    f3 = fM1347getElevationD9Ej5fM;
                    j6 = scrimColor;
                    j7 = jM1449contentColorForek8zF_U;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    shape3 = expandedShape;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        sheetStateRememberModalBottomSheetState = sheetState2;
                    }
                    if ((i2 & 8) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        expandedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        containerColor = j4;
                    }
                    if ((i2 & 32) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                        i4 &= -458753;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 128) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i4 = (-29360129) & i4;
                    } else {
                        scrimColor = j3;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                    j5 = containerColor;
                    f3 = fM1347getElevationD9Ej5fM;
                    j6 = scrimColor;
                    j7 = jM1449contentColorForek8zF_U;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    shape3 = expandedShape;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1311611302, i4, -1, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:281)");
                }
                composer2 = composerStartRestartGroup;
                m1646ModalBottomSheetEP0qOeE(interfaceC3588op, modifier3, sheetState3, shape3, j5, j7, f3, j6, interfaceC0526FpM1473getLambda2$material3_release, null, interfaceC0552Gp, composer2, i4 & 268435454, (i4 >> 27) & 14, 512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                sheetState4 = sheetState3;
                shape4 = shape3;
                j8 = j5;
                j9 = j7;
                f4 = f3;
                j10 = j6;
                interfaceC0526Fp2 = interfaceC0526FpM1473getLambda2$material3_release;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        sheetStateRememberModalBottomSheetState = sheetState2;
                    }
                    if ((i2 & 8) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        expandedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        containerColor = j4;
                    }
                    if ((i2 & 32) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                        i4 &= -458753;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 128) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i4 = (-29360129) & i4;
                    } else {
                        scrimColor = j3;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                    j5 = containerColor;
                    f3 = fM1347getElevationD9Ej5fM;
                    j6 = scrimColor;
                    j7 = jM1449contentColorForek8zF_U;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    shape3 = expandedShape;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        sheetStateRememberModalBottomSheetState = sheetState2;
                    }
                    if ((i2 & 8) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        expandedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        containerColor = j4;
                    }
                    if ((i2 & 32) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                        i4 &= -458753;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 128) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i4 = (-29360129) & i4;
                    } else {
                        scrimColor = j3;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                    j5 = containerColor;
                    f3 = fM1347getElevationD9Ej5fM;
                    j6 = scrimColor;
                    j7 = jM1449contentColorForek8zF_U;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    shape3 = expandedShape;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1311611302, i4, -1, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:281)");
                }
                composer2 = composerStartRestartGroup;
                m1646ModalBottomSheetEP0qOeE(interfaceC3588op, modifier3, sheetState3, shape3, j5, j7, f3, j6, interfaceC0526FpM1473getLambda2$material3_release, null, interfaceC0552Gp, composer2, i4 & 268435454, (i4 >> 27) & 14, 512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                sheetState4 = sheetState3;
                shape4 = shape3;
                j8 = j5;
                j9 = j7;
                f4 = f3;
                j10 = j6;
                interfaceC0526Fp2 = interfaceC0526FpM1473getLambda2$material3_release;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheet_androidKt$ModalBottomSheet$5(interfaceC3588op, modifier4, sheetState4, shape4, j8, j9, f4, j10, interfaceC0526Fp2, interfaceC0552Gp, i, i2));
        }
        i3 |= 48;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                sheetState2 = sheetState;
                if (composerStartRestartGroup.changed(sheetState2)) {
                }
                i3 |= i12;
            } else {
                sheetState2 = sheetState;
            }
            i3 |= i12;
        } else {
            sheetState2 = sheetState;
        }
        if ((i & 7168) == 0) {
            if ((i2 & 8) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            i3 |= i13;
        } else {
            shape2 = shape;
        }
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                j4 = j;
                if (composerStartRestartGroup.changed(j4)) {
                }
                i3 |= i14;
            } else {
                j4 = j;
            }
            i3 |= i14;
        } else {
            j4 = j;
        }
        if ((458752 & i) == 0) {
            int i16 = i3;
            if ((i2 & 32) == 0) {
                i10 = 65536;
            } else {
                i10 = 65536;
            }
            i4 = i16 | i10;
        } else {
            i4 = i3;
        }
        i5 = i2 & 64;
        if (i5 != 0) {
            i4 |= 1572864;
            f2 = f;
        } else {
            f2 = f;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i4 |= i6;
            }
        }
        if ((i & 29360128) != 0) {
            i4 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j3)) ? 4194304 : 8388608;
        }
        i7 = i2 & 256;
        if (i7 != 0) {
            if ((234881024 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i4 |= i8;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i9 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i9 = 268435456;
                    }
                }
                if ((1533916891 & i4) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            sheetStateRememberModalBottomSheetState = sheetState2;
                        }
                        if ((i2 & 8) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            expandedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            containerColor = j4;
                        }
                        if ((i2 & 32) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                            i4 &= -458753;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i5 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 128) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i4 = (-29360129) & i4;
                        } else {
                            scrimColor = j3;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                        j5 = containerColor;
                        f3 = fM1347getElevationD9Ej5fM;
                        j6 = scrimColor;
                        j7 = jM1449contentColorForek8zF_U;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        shape3 = expandedShape;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            sheetStateRememberModalBottomSheetState = sheetState2;
                        }
                        if ((i2 & 8) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            expandedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            containerColor = j4;
                        }
                        if ((i2 & 32) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                            i4 &= -458753;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i5 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 128) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i4 = (-29360129) & i4;
                        } else {
                            scrimColor = j3;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                        j5 = containerColor;
                        f3 = fM1347getElevationD9Ej5fM;
                        j6 = scrimColor;
                        j7 = jM1449contentColorForek8zF_U;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        shape3 = expandedShape;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1311611302, i4, -1, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:281)");
                    }
                    composer2 = composerStartRestartGroup;
                    m1646ModalBottomSheetEP0qOeE(interfaceC3588op, modifier3, sheetState3, shape3, j5, j7, f3, j6, interfaceC0526FpM1473getLambda2$material3_release, null, interfaceC0552Gp, composer2, i4 & 268435454, (i4 >> 27) & 14, 512);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    sheetState4 = sheetState3;
                    shape4 = shape3;
                    j8 = j5;
                    j9 = j7;
                    f4 = f3;
                    j10 = j6;
                    interfaceC0526Fp2 = interfaceC0526FpM1473getLambda2$material3_release;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            sheetStateRememberModalBottomSheetState = sheetState2;
                        }
                        if ((i2 & 8) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            expandedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            containerColor = j4;
                        }
                        if ((i2 & 32) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                            i4 &= -458753;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i5 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 128) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i4 = (-29360129) & i4;
                        } else {
                            scrimColor = j3;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                        j5 = containerColor;
                        f3 = fM1347getElevationD9Ej5fM;
                        j6 = scrimColor;
                        j7 = jM1449contentColorForek8zF_U;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        shape3 = expandedShape;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            i4 &= -897;
                        } else {
                            sheetStateRememberModalBottomSheetState = sheetState2;
                        }
                        if ((i2 & 8) != 0) {
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            expandedShape = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -57345;
                        } else {
                            containerColor = j4;
                        }
                        if ((i2 & 32) != 0) {
                            jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                            i4 &= -458753;
                        } else {
                            jM1449contentColorForek8zF_U = j2;
                        }
                        if (i5 != 0) {
                            fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                        } else {
                            fM1347getElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 128) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i4 = (-29360129) & i4;
                        } else {
                            scrimColor = j3;
                        }
                        if (i7 != 0) {
                            interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                        } else {
                            interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                        }
                        modifier3 = modifier2;
                        j5 = containerColor;
                        f3 = fM1347getElevationD9Ej5fM;
                        j6 = scrimColor;
                        j7 = jM1449contentColorForek8zF_U;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        shape3 = expandedShape;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1311611302, i4, -1, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:281)");
                    }
                    composer2 = composerStartRestartGroup;
                    m1646ModalBottomSheetEP0qOeE(interfaceC3588op, modifier3, sheetState3, shape3, j5, j7, f3, j6, interfaceC0526FpM1473getLambda2$material3_release, null, interfaceC0552Gp, composer2, i4 & 268435454, (i4 >> 27) & 14, 512);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    sheetState4 = sheetState3;
                    shape4 = shape3;
                    j8 = j5;
                    j9 = j7;
                    f4 = f3;
                    j10 = j6;
                    interfaceC0526Fp2 = interfaceC0526FpM1473getLambda2$material3_release;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheet_androidKt$ModalBottomSheet$5(interfaceC3588op, modifier4, sheetState4, shape4, j8, j9, f4, j10, interfaceC0526Fp2, interfaceC0552Gp, i, i2));
            }
            i9 = 805306368;
            i4 |= i9;
            if ((1533916891 & i4) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        sheetStateRememberModalBottomSheetState = sheetState2;
                    }
                    if ((i2 & 8) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        expandedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        containerColor = j4;
                    }
                    if ((i2 & 32) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                        i4 &= -458753;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 128) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i4 = (-29360129) & i4;
                    } else {
                        scrimColor = j3;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                    j5 = containerColor;
                    f3 = fM1347getElevationD9Ej5fM;
                    j6 = scrimColor;
                    j7 = jM1449contentColorForek8zF_U;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    shape3 = expandedShape;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        sheetStateRememberModalBottomSheetState = sheetState2;
                    }
                    if ((i2 & 8) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        expandedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        containerColor = j4;
                    }
                    if ((i2 & 32) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                        i4 &= -458753;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 128) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i4 = (-29360129) & i4;
                    } else {
                        scrimColor = j3;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                    j5 = containerColor;
                    f3 = fM1347getElevationD9Ej5fM;
                    j6 = scrimColor;
                    j7 = jM1449contentColorForek8zF_U;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    shape3 = expandedShape;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1311611302, i4, -1, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:281)");
                }
                composer2 = composerStartRestartGroup;
                m1646ModalBottomSheetEP0qOeE(interfaceC3588op, modifier3, sheetState3, shape3, j5, j7, f3, j6, interfaceC0526FpM1473getLambda2$material3_release, null, interfaceC0552Gp, composer2, i4 & 268435454, (i4 >> 27) & 14, 512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                sheetState4 = sheetState3;
                shape4 = shape3;
                j8 = j5;
                j9 = j7;
                f4 = f3;
                j10 = j6;
                interfaceC0526Fp2 = interfaceC0526FpM1473getLambda2$material3_release;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        sheetStateRememberModalBottomSheetState = sheetState2;
                    }
                    if ((i2 & 8) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        expandedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        containerColor = j4;
                    }
                    if ((i2 & 32) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                        i4 &= -458753;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 128) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i4 = (-29360129) & i4;
                    } else {
                        scrimColor = j3;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                    j5 = containerColor;
                    f3 = fM1347getElevationD9Ej5fM;
                    j6 = scrimColor;
                    j7 = jM1449contentColorForek8zF_U;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    shape3 = expandedShape;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        sheetStateRememberModalBottomSheetState = sheetState2;
                    }
                    if ((i2 & 8) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        expandedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        containerColor = j4;
                    }
                    if ((i2 & 32) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                        i4 &= -458753;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 128) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i4 = (-29360129) & i4;
                    } else {
                        scrimColor = j3;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                    j5 = containerColor;
                    f3 = fM1347getElevationD9Ej5fM;
                    j6 = scrimColor;
                    j7 = jM1449contentColorForek8zF_U;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    shape3 = expandedShape;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1311611302, i4, -1, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:281)");
                }
                composer2 = composerStartRestartGroup;
                m1646ModalBottomSheetEP0qOeE(interfaceC3588op, modifier3, sheetState3, shape3, j5, j7, f3, j6, interfaceC0526FpM1473getLambda2$material3_release, null, interfaceC0552Gp, composer2, i4 & 268435454, (i4 >> 27) & 14, 512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                sheetState4 = sheetState3;
                shape4 = shape3;
                j8 = j5;
                j9 = j7;
                f4 = f3;
                j10 = j6;
                interfaceC0526Fp2 = interfaceC0526FpM1473getLambda2$material3_release;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheet_androidKt$ModalBottomSheet$5(interfaceC3588op, modifier4, sheetState4, shape4, j8, j9, f4, j10, interfaceC0526Fp2, interfaceC0552Gp, i, i2));
        }
        i4 |= 100663296;
        if ((i2 & 512) != 0) {
            if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i9 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i9 = 268435456;
                }
            }
            if ((1533916891 & i4) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        sheetStateRememberModalBottomSheetState = sheetState2;
                    }
                    if ((i2 & 8) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        expandedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        containerColor = j4;
                    }
                    if ((i2 & 32) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                        i4 &= -458753;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 128) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i4 = (-29360129) & i4;
                    } else {
                        scrimColor = j3;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                    j5 = containerColor;
                    f3 = fM1347getElevationD9Ej5fM;
                    j6 = scrimColor;
                    j7 = jM1449contentColorForek8zF_U;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    shape3 = expandedShape;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        sheetStateRememberModalBottomSheetState = sheetState2;
                    }
                    if ((i2 & 8) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        expandedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        containerColor = j4;
                    }
                    if ((i2 & 32) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                        i4 &= -458753;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 128) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i4 = (-29360129) & i4;
                    } else {
                        scrimColor = j3;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                    j5 = containerColor;
                    f3 = fM1347getElevationD9Ej5fM;
                    j6 = scrimColor;
                    j7 = jM1449contentColorForek8zF_U;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    shape3 = expandedShape;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1311611302, i4, -1, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:281)");
                }
                composer2 = composerStartRestartGroup;
                m1646ModalBottomSheetEP0qOeE(interfaceC3588op, modifier3, sheetState3, shape3, j5, j7, f3, j6, interfaceC0526FpM1473getLambda2$material3_release, null, interfaceC0552Gp, composer2, i4 & 268435454, (i4 >> 27) & 14, 512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                sheetState4 = sheetState3;
                shape4 = shape3;
                j8 = j5;
                j9 = j7;
                f4 = f3;
                j10 = j6;
                interfaceC0526Fp2 = interfaceC0526FpM1473getLambda2$material3_release;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        sheetStateRememberModalBottomSheetState = sheetState2;
                    }
                    if ((i2 & 8) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        expandedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        containerColor = j4;
                    }
                    if ((i2 & 32) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                        i4 &= -458753;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 128) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i4 = (-29360129) & i4;
                    } else {
                        scrimColor = j3;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                    j5 = containerColor;
                    f3 = fM1347getElevationD9Ej5fM;
                    j6 = scrimColor;
                    j7 = jM1449contentColorForek8zF_U;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    shape3 = expandedShape;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        i4 &= -897;
                    } else {
                        sheetStateRememberModalBottomSheetState = sheetState2;
                    }
                    if ((i2 & 8) != 0) {
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        expandedShape = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        containerColor = j4;
                    }
                    if ((i2 & 32) != 0) {
                        jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                        i4 &= -458753;
                    } else {
                        jM1449contentColorForek8zF_U = j2;
                    }
                    if (i5 != 0) {
                        fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                    } else {
                        fM1347getElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 128) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i4 = (-29360129) & i4;
                    } else {
                        scrimColor = j3;
                    }
                    if (i7 != 0) {
                        interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                    } else {
                        interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                    }
                    modifier3 = modifier2;
                    j5 = containerColor;
                    f3 = fM1347getElevationD9Ej5fM;
                    j6 = scrimColor;
                    j7 = jM1449contentColorForek8zF_U;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    shape3 = expandedShape;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1311611302, i4, -1, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:281)");
                }
                composer2 = composerStartRestartGroup;
                m1646ModalBottomSheetEP0qOeE(interfaceC3588op, modifier3, sheetState3, shape3, j5, j7, f3, j6, interfaceC0526FpM1473getLambda2$material3_release, null, interfaceC0552Gp, composer2, i4 & 268435454, (i4 >> 27) & 14, 512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                sheetState4 = sheetState3;
                shape4 = shape3;
                j8 = j5;
                j9 = j7;
                f4 = f3;
                j10 = j6;
                interfaceC0526Fp2 = interfaceC0526FpM1473getLambda2$material3_release;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheet_androidKt$ModalBottomSheet$5(interfaceC3588op, modifier4, sheetState4, shape4, j8, j9, f4, j10, interfaceC0526Fp2, interfaceC0552Gp, i, i2));
        }
        i9 = 805306368;
        i4 |= i9;
        if ((1533916891 & i4) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    i4 &= -897;
                } else {
                    sheetStateRememberModalBottomSheetState = sheetState2;
                }
                if ((i2 & 8) != 0) {
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    expandedShape = shape2;
                }
                if ((i2 & 16) != 0) {
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    containerColor = j4;
                }
                if ((i2 & 32) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                    i4 &= -458753;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if (i5 != 0) {
                    fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                } else {
                    fM1347getElevationD9Ej5fM = f2;
                }
                if ((i2 & 128) != 0) {
                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i4 = (-29360129) & i4;
                } else {
                    scrimColor = j3;
                }
                if (i7 != 0) {
                    interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                } else {
                    interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                }
                modifier3 = modifier2;
                j5 = containerColor;
                f3 = fM1347getElevationD9Ej5fM;
                j6 = scrimColor;
                j7 = jM1449contentColorForek8zF_U;
                sheetState3 = sheetStateRememberModalBottomSheetState;
                shape3 = expandedShape;
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    i4 &= -897;
                } else {
                    sheetStateRememberModalBottomSheetState = sheetState2;
                }
                if ((i2 & 8) != 0) {
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    expandedShape = shape2;
                }
                if ((i2 & 16) != 0) {
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    containerColor = j4;
                }
                if ((i2 & 32) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                    i4 &= -458753;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if (i5 != 0) {
                    fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                } else {
                    fM1347getElevationD9Ej5fM = f2;
                }
                if ((i2 & 128) != 0) {
                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i4 = (-29360129) & i4;
                } else {
                    scrimColor = j3;
                }
                if (i7 != 0) {
                    interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                } else {
                    interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                }
                modifier3 = modifier2;
                j5 = containerColor;
                f3 = fM1347getElevationD9Ej5fM;
                j6 = scrimColor;
                j7 = jM1449contentColorForek8zF_U;
                sheetState3 = sheetStateRememberModalBottomSheetState;
                shape3 = expandedShape;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1311611302, i4, -1, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:281)");
            }
            composer2 = composerStartRestartGroup;
            m1646ModalBottomSheetEP0qOeE(interfaceC3588op, modifier3, sheetState3, shape3, j5, j7, f3, j6, interfaceC0526FpM1473getLambda2$material3_release, null, interfaceC0552Gp, composer2, i4 & 268435454, (i4 >> 27) & 14, 512);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            sheetState4 = sheetState3;
            shape4 = shape3;
            j8 = j5;
            j9 = j7;
            f4 = f3;
            j10 = j6;
            interfaceC0526Fp2 = interfaceC0526FpM1473getLambda2$material3_release;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    i4 &= -897;
                } else {
                    sheetStateRememberModalBottomSheetState = sheetState2;
                }
                if ((i2 & 8) != 0) {
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    expandedShape = shape2;
                }
                if ((i2 & 16) != 0) {
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    containerColor = j4;
                }
                if ((i2 & 32) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                    i4 &= -458753;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if (i5 != 0) {
                    fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                } else {
                    fM1347getElevationD9Ej5fM = f2;
                }
                if ((i2 & 128) != 0) {
                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i4 = (-29360129) & i4;
                } else {
                    scrimColor = j3;
                }
                if (i7 != 0) {
                    interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                } else {
                    interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                }
                modifier3 = modifier2;
                j5 = containerColor;
                f3 = fM1347getElevationD9Ej5fM;
                j6 = scrimColor;
                j7 = jM1449contentColorForek8zF_U;
                sheetState3 = sheetStateRememberModalBottomSheetState;
                shape3 = expandedShape;
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 4) != 0) {
                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    i4 &= -897;
                } else {
                    sheetStateRememberModalBottomSheetState = sheetState2;
                }
                if ((i2 & 8) != 0) {
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    expandedShape = shape2;
                }
                if ((i2 & 16) != 0) {
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    containerColor = j4;
                }
                if ((i2 & 32) != 0) {
                    jM1449contentColorForek8zF_U = ColorSchemeKt.m1449contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i4 >> 12) & 14);
                    i4 &= -458753;
                } else {
                    jM1449contentColorForek8zF_U = j2;
                }
                if (i5 != 0) {
                    fM1347getElevationD9Ej5fM = BottomSheetDefaults.INSTANCE.m1347getElevationD9Ej5fM();
                } else {
                    fM1347getElevationD9Ej5fM = f2;
                }
                if ((i2 & 128) != 0) {
                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i4 = (-29360129) & i4;
                } else {
                    scrimColor = j3;
                }
                if (i7 != 0) {
                    interfaceC0526FpM1473getLambda2$material3_release = ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.m1473getLambda2$material3_release();
                } else {
                    interfaceC0526FpM1473getLambda2$material3_release = interfaceC0526Fp;
                }
                modifier3 = modifier2;
                j5 = containerColor;
                f3 = fM1347getElevationD9Ej5fM;
                j6 = scrimColor;
                j7 = jM1449contentColorForek8zF_U;
                sheetState3 = sheetStateRememberModalBottomSheetState;
                shape3 = expandedShape;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1311611302, i4, -1, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:281)");
            }
            composer2 = composerStartRestartGroup;
            m1646ModalBottomSheetEP0qOeE(interfaceC3588op, modifier3, sheetState3, shape3, j5, j7, f3, j6, interfaceC0526FpM1473getLambda2$material3_release, null, interfaceC0552Gp, composer2, i4 & 268435454, (i4 >> 27) & 14, 512);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            sheetState4 = sheetState3;
            shape4 = shape3;
            j8 = j5;
            j9 = j7;
            f4 = f3;
            j10 = j6;
            interfaceC0526Fp2 = interfaceC0526FpM1473getLambda2$material3_release;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheet_androidKt$ModalBottomSheet$5(interfaceC3588op, modifier4, sheetState4, shape4, j8, j9, f4, j10, interfaceC0526Fp2, interfaceC0552Gp, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalMaterial3Api
    public static final AnchorChangeHandler<SheetValue> ModalBottomSheetAnchorChangeHandler(final SheetState sheetState, final InterfaceC0526Fp interfaceC0526Fp, final InterfaceC3750qp interfaceC3750qp) {
        return new AnchorChangeHandler<SheetValue>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt.ModalBottomSheetAnchorChangeHandler.1

            /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetAnchorChangeHandler$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[SheetValue.values().length];
                    try {
                        iArr[SheetValue.Hidden.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[SheetValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // androidx.compose.material3.AnchorChangeHandler
            public final void onAnchorsChanged(SheetValue sheetValue, Map<SheetValue, Float> map, Map<SheetValue, Float> map2) {
                SheetValue sheetValue2;
                AbstractC4492zt.h(sheetValue, "previousTarget");
                AbstractC4492zt.h(map, "previousAnchors");
                AbstractC4492zt.h(map2, "newAnchors");
                Float f = map.get(sheetValue);
                int i = WhenMappings.$EnumSwitchMapping$0[sheetValue.ordinal()];
                if (i == 1) {
                    sheetValue2 = SheetValue.Hidden;
                } else {
                    if (i != 2 && i != 3) {
                        throw new AD();
                    }
                    sheetValue2 = SheetValue.PartiallyExpanded;
                    if (!map2.containsKey(sheetValue2)) {
                        sheetValue2 = SheetValue.Expanded;
                        if (!map2.containsKey(sheetValue2)) {
                            sheetValue2 = SheetValue.Hidden;
                        }
                    }
                }
                if (AbstractC4492zt.a(((Number) AbstractC4243wx.h(map2, sheetValue2)).floatValue(), f)) {
                    return;
                }
                if (sheetState.getSwipeableState$material3_release().isAnimationRunning() || map.isEmpty()) {
                    interfaceC0526Fp.mo13invoke(sheetValue2, Float.valueOf(sheetState.getSwipeableState$material3_release().getLastVelocity()));
                } else {
                    interfaceC3750qp.invoke(sheetValue2);
                }
            }
        };
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void ModalBottomSheetPopup(InterfaceC3588op interfaceC3588op, WindowInsets windowInsets, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        int i2;
        AbstractC4492zt.h(interfaceC3588op, "onDismissRequest");
        AbstractC4492zt.h(windowInsets, "windowInsets");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-627217336);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(windowInsets) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-627217336, i3, -1, "androidx.compose.material3.ModalBottomSheetPopup (ModalBottomSheet.android.kt:415)");
            }
            View view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            UUID uuid = (UUID) RememberSaveableKt.m2674rememberSaveable(new Object[0], (Saver) null, (String) null, (InterfaceC3588op) ModalBottomSheet_androidKt$ModalBottomSheetPopup$id$1.INSTANCE, composerStartRestartGroup, 3080, 6);
            CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC0526Fp, composerStartRestartGroup, (i3 >> 6) & 14);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Object obj = objRememberedValue;
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                AbstractC4492zt.g(uuid, HTML.Attribute.ID);
                ModalBottomSheetWindow modalBottomSheetWindow = new ModalBottomSheetWindow(interfaceC3588op, view, uuid);
                modalBottomSheetWindow.setCustomContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(861223805, true, new ModalBottomSheet_androidKt$ModalBottomSheetPopup$modalBottomSheetWindow$1$1$1(windowInsets, stateRememberUpdatedState)));
                composerStartRestartGroup.updateRememberedValue(modalBottomSheetWindow);
                obj = modalBottomSheetWindow;
            }
            composerStartRestartGroup.endReplaceableGroup();
            ModalBottomSheetWindow modalBottomSheetWindow2 = (ModalBottomSheetWindow) obj;
            EffectsKt.DisposableEffect(modalBottomSheetWindow2, new C15311(modalBottomSheetWindow2), composerStartRestartGroup, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, windowInsets, interfaceC0526Fp, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC0526Fp ModalBottomSheetPopup$lambda$5(State<? extends InterfaceC0526Fp> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m1648Scrim3JVO9M(long j, InterfaceC3588op interfaceC3588op, boolean z, Composer composer, int i) {
        int i2;
        Modifier modifierClearAndSetSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(1053897700);
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
                ComposerKt.traceEventStart(1053897700, i2, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.android.kt:321)");
            }
            if (j != Color.Companion.m3068getUnspecified0d7_KjU()) {
                State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                composerStartRestartGroup.startReplaceableGroup(-1858721447);
                if (z) {
                    Modifier.Companion companion = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    boolean zChanged = composerStartRestartGroup.changed(interfaceC3588op);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new ModalBottomSheet_androidKt$Scrim$dismissSheet$1$1(interfaceC3588op, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(SuspendingPointerInputFilterKt.pointerInput(companion, interfaceC3588op, (InterfaceC0526Fp) objRememberedValue), ModalBottomSheet_androidKt$Scrim$dismissSheet$2.INSTANCE);
                } else {
                    modifierClearAndSetSemantics = Modifier.Companion;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null).then(modifierClearAndSetSemantics);
                Color colorM3022boximpl = Color.m3022boximpl(j);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                boolean zChanged2 = composerStartRestartGroup.changed(colorM3022boximpl) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new ModalBottomSheet_androidKt$Scrim$1$1(j, stateAnimateFloatAsState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierThen, (InterfaceC3750qp) objRememberedValue2, composerStartRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheet_androidKt$Scrim$2(j, interfaceC3588op, z, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalMaterial3Api
    public static final Modifier modalBottomSheetSwipeable(Modifier modifier, SheetState sheetState, AnchorChangeHandler<SheetValue> anchorChangeHandler, float f, InterfaceC0526Fp interfaceC0526Fp) {
        return SwipeableV2Kt.swipeAnchors(DraggableKt.draggable(modifier, sheetState.getSwipeableState$material3_release().getSwipeDraggableState$material3_release(), Orientation.Vertical, (188 & 4) != 0 ? true : sheetState.isVisible(), (188 & 8) != 0 ? null : null, (188 & 16) != 0 ? false : sheetState.getSwipeableState$material3_release().isAnimationRunning(), (188 & 32) != 0 ? new DraggableKt.C13201(null) : null, (188 & 64) != 0 ? new DraggableKt.AnonymousClass2(null) : new C15321(interfaceC0526Fp), (188 & 128) != 0 ? false : false), sheetState.getSwipeableState$material3_release(), QO.h(SheetValue.Hidden, SheetValue.PartiallyExpanded, SheetValue.Expanded), anchorChangeHandler, new C15332(f, sheetState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object modalBottomSheetSwipeable$suspendConversion0(InterfaceC0526Fp interfaceC0526Fp, InterfaceC2052dg interfaceC2052dg, float f, InterfaceC0793Of interfaceC0793Of) {
        interfaceC0526Fp.mo13invoke(interfaceC2052dg, E8.b(f));
        return FW.a;
    }

    @Composable
    @ExperimentalMaterial3Api
    public static final SheetState rememberModalBottomSheetState(boolean z, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1261794383);
        boolean z2 = (i2 & 1) != 0 ? false : z;
        if ((i2 & 2) != 0) {
            interfaceC3750qp = C15341.INSTANCE;
        }
        InterfaceC3750qp interfaceC3750qp2 = interfaceC3750qp;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1261794383, i, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.android.kt:315)");
        }
        SheetState sheetStateRememberSheetState = SheetDefaultsKt.rememberSheetState(z2, interfaceC3750qp2, SheetValue.Hidden, false, composer, (i & 14) | 384 | (i & 112), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return sheetStateRememberSheetState;
    }
}
