package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidAlertDialog_androidKt {
    private static final float ButtonsMainAxisSpacing = Dp.m5160constructorimpl(8);
    private static final float ButtonsCrossAxisSpacing = Dp.m5160constructorimpl(12);

    /* JADX INFO: renamed from: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ InterfaceC0526Fp $confirmButton;
        final /* synthetic */ long $containerColor;
        final /* synthetic */ InterfaceC0526Fp $dismissButton;
        final /* synthetic */ InterfaceC0526Fp $icon;
        final /* synthetic */ long $iconContentColor;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ InterfaceC0526Fp $text;
        final /* synthetic */ long $textContentColor;
        final /* synthetic */ InterfaceC0526Fp $title;
        final /* synthetic */ long $titleContentColor;
        final /* synthetic */ float $tonalElevation;

        /* JADX INFO: renamed from: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00971 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ InterfaceC0526Fp $confirmButton;
            final /* synthetic */ InterfaceC0526Fp $dismissButton;

            /* JADX INFO: renamed from: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00981 extends AbstractC2233fv implements InterfaceC0526Fp {
                final /* synthetic */ int $$dirty;
                final /* synthetic */ InterfaceC0526Fp $confirmButton;
                final /* synthetic */ InterfaceC0526Fp $dismissButton;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00981(InterfaceC0526Fp interfaceC0526Fp, int i, InterfaceC0526Fp interfaceC0526Fp2) {
                    super(2);
                    this.$dismissButton = interfaceC0526Fp;
                    this.$$dirty = i;
                    this.$confirmButton = interfaceC0526Fp2;
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke */
                public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return FW.a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer, int i) {
                    if ((i & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(628285581, i, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:97)");
                    }
                    InterfaceC0526Fp interfaceC0526Fp = this.$dismissButton;
                    composer.startReplaceableGroup(-1969500715);
                    if (interfaceC0526Fp != null) {
                        interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((this.$$dirty >> 9) & 14));
                        FW fw = FW.a;
                    }
                    composer.endReplaceableGroup();
                    this.$confirmButton.mo13invoke(composer, Integer.valueOf((this.$$dirty >> 3) & 14));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00971(InterfaceC0526Fp interfaceC0526Fp, int i, InterfaceC0526Fp interfaceC0526Fp2) {
                super(2);
                this.$dismissButton = interfaceC0526Fp;
                this.$$dirty = i;
                this.$confirmButton = interfaceC0526Fp2;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return FW.a;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(Composer composer, int i) {
                if ((i & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1873210524, i, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:93)");
                }
                AlertDialogKt.m1326AlertDialogFlowRowixp7dh8(AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing, AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing, ComposableLambdaKt.composableLambda(composer, 628285581, true, new C00981(this.$dismissButton, this.$$dirty, this.$confirmButton)), composer, 438);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, Shape shape, long j, float f, long j2, long j3, long j4, int i, int i2, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5) {
            super(2);
            this.$icon = interfaceC0526Fp;
            this.$title = interfaceC0526Fp2;
            this.$text = interfaceC0526Fp3;
            this.$shape = shape;
            this.$containerColor = j;
            this.$tonalElevation = f;
            this.$iconContentColor = j2;
            this.$titleContentColor = j3;
            this.$textContentColor = j4;
            this.$$dirty = i;
            this.$$dirty1 = i2;
            this.$dismissButton = interfaceC0526Fp4;
            this.$confirmButton = interfaceC0526Fp5;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(741647174, i, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:91)");
            }
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1873210524, true, new C00971(this.$dismissButton, this.$$dirty, this.$confirmButton));
            InterfaceC0526Fp interfaceC0526Fp = this.$icon;
            InterfaceC0526Fp interfaceC0526Fp2 = this.$title;
            InterfaceC0526Fp interfaceC0526Fp3 = this.$text;
            Shape shape = this.$shape;
            long j = this.$containerColor;
            float f = this.$tonalElevation;
            long color = ColorSchemeKt.toColor(DialogTokens.INSTANCE.getActionLabelTextColor(), composer, 6);
            long j2 = this.$iconContentColor;
            long j3 = this.$titleContentColor;
            long j4 = this.$textContentColor;
            int i2 = this.$$dirty;
            int i3 = this.$$dirty1;
            AlertDialogKt.m1325AlertDialogContent4hvqGtA(composableLambda, null, interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, shape, j, f, color, j2, j3, j4, composer, ((i2 >> 6) & 896) | 6 | ((i2 >> 6) & 7168) | ((i2 >> 6) & 57344) | ((i2 >> 6) & 458752) | ((i2 >> 6) & 3670016) | ((i3 << 15) & 29360128) | (i2 & 1879048192), i3 & 126, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0526Fp $confirmButton;
        final /* synthetic */ long $containerColor;
        final /* synthetic */ InterfaceC0526Fp $dismissButton;
        final /* synthetic */ InterfaceC0526Fp $icon;
        final /* synthetic */ long $iconContentColor;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onDismissRequest;
        final /* synthetic */ DialogProperties $properties;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ InterfaceC0526Fp $text;
        final /* synthetic */ long $textContentColor;
        final /* synthetic */ InterfaceC0526Fp $title;
        final /* synthetic */ long $titleContentColor;
        final /* synthetic */ float $tonalElevation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, Shape shape, long j, long j2, long j3, long j4, float f, DialogProperties dialogProperties, int i, int i2, int i3) {
            super(2);
            this.$onDismissRequest = interfaceC3588op;
            this.$confirmButton = interfaceC0526Fp;
            this.$modifier = modifier;
            this.$dismissButton = interfaceC0526Fp2;
            this.$icon = interfaceC0526Fp3;
            this.$title = interfaceC0526Fp4;
            this.$text = interfaceC0526Fp5;
            this.$shape = shape;
            this.$containerColor = j;
            this.$iconContentColor = j2;
            this.$titleContentColor = j3;
            this.$textContentColor = j4;
            this.$tonalElevation = f;
            this.$properties = dialogProperties;
            this.$$changed = i;
            this.$$changed1 = i2;
            this.$$default = i3;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            AndroidAlertDialog_androidKt.m1327AlertDialogOix01E0(this.$onDismissRequest, this.$confirmButton, this.$modifier, this.$dismissButton, this.$icon, this.$title, this.$text, this.$shape, this.$containerColor, this.$iconContentColor, this.$titleContentColor, this.$textContentColor, this.$tonalElevation, this.$properties, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, int i) {
            super(2);
            this.$modifier = modifier;
            this.$content = interfaceC0526Fp;
            this.$$dirty = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(823217604, i, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:153)");
            }
            String strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1817getDialogadMyvUU(), composer, 6);
            Modifier modifierM536sizeInqDBjuR0$default = SizeKt.m536sizeInqDBjuR0$default(this.$modifier, AlertDialogKt.getDialogMinWidth(), 0.0f, AlertDialogKt.getDialogMaxWidth(), 0.0f, 10, null);
            Modifier.Companion companion = Modifier.Companion;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(strM1841getStringNWtq28);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new AndroidAlertDialog_androidKt$AlertDialog$3$1$1(strM1841getStringNWtq28);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            Modifier modifierThen = modifierM536sizeInqDBjuR0$default.then(SemanticsModifierKt.semantics$default(companion, false, (InterfaceC3750qp) objRememberedValue, 1, null));
            InterfaceC0526Fp interfaceC0526Fp = this.$content;
            int i2 = this.$$dirty;
            composer.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, composer, 48);
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierThen);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion2.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
            composer.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i2 >> 9) & 14));
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onDismissRequest;
        final /* synthetic */ DialogProperties $properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(InterfaceC3588op interfaceC3588op, Modifier modifier, DialogProperties dialogProperties, InterfaceC0526Fp interfaceC0526Fp, int i, int i2) {
            super(2);
            this.$onDismissRequest = interfaceC3588op;
            this.$modifier = modifier;
            this.$properties = dialogProperties;
            this.$content = interfaceC0526Fp;
            this.$$changed = i;
            this.$$default = i2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            AndroidAlertDialog_androidKt.AlertDialog(this.$onDismissRequest, this.$modifier, this.$properties, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:43:0x007a  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:55:0x0099  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:69:? A[RETURN, SYNTHETIC] */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void AlertDialog(InterfaceC3588op interfaceC3588op, Modifier modifier, DialogProperties dialogProperties, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        DialogProperties dialogProperties2;
        int i5;
        int i6;
        Modifier modifier3;
        DialogProperties dialogProperties3;
        Modifier modifier4;
        DialogProperties dialogProperties4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3588op, "onDismissRequest");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(63450171);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    dialogProperties2 = dialogProperties;
                    if (composerStartRestartGroup.changed(dialogProperties2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                if ((i3 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties3 = dialogProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(63450171, i3, -1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:144)");
                    }
                    AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 823217604, true, new AnonymousClass3(modifier3, interfaceC0526Fp, i3)), composerStartRestartGroup, (i3 & 14) | 384 | ((i3 >> 3) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    dialogProperties4 = dialogProperties3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier2;
                    dialogProperties4 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, dialogProperties4, interfaceC0526Fp, i, i2));
            }
            i3 |= 384;
            dialogProperties2 = dialogProperties;
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i3 & 5851) == 1170) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                } else {
                    dialogProperties3 = dialogProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(63450171, i3, -1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:144)");
                }
                AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 823217604, true, new AnonymousClass3(modifier3, interfaceC0526Fp, i3)), composerStartRestartGroup, (i3 & 14) | 384 | ((i3 >> 3) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                dialogProperties4 = dialogProperties3;
            } else {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                } else {
                    dialogProperties3 = dialogProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(63450171, i3, -1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:144)");
                }
                AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 823217604, true, new AnonymousClass3(modifier3, interfaceC0526Fp, i3)), composerStartRestartGroup, (i3 & 14) | 384 | ((i3 >> 3) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                dialogProperties4 = dialogProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, dialogProperties4, interfaceC0526Fp, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                dialogProperties2 = dialogProperties;
                if (composerStartRestartGroup.changed(dialogProperties2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i3 & 5851) == 1170) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                } else {
                    dialogProperties3 = dialogProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(63450171, i3, -1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:144)");
                }
                AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 823217604, true, new AnonymousClass3(modifier3, interfaceC0526Fp, i3)), composerStartRestartGroup, (i3 & 14) | 384 | ((i3 >> 3) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                dialogProperties4 = dialogProperties3;
            } else {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                } else {
                    dialogProperties3 = dialogProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(63450171, i3, -1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:144)");
                }
                AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 823217604, true, new AnonymousClass3(modifier3, interfaceC0526Fp, i3)), composerStartRestartGroup, (i3 & 14) | 384 | ((i3 >> 3) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                dialogProperties4 = dialogProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, dialogProperties4, interfaceC0526Fp, i, i2));
        }
        i3 |= 384;
        dialogProperties2 = dialogProperties;
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i3 & 5851) == 1170) {
            if (i7 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                dialogProperties3 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
            } else {
                dialogProperties3 = dialogProperties2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(63450171, i3, -1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:144)");
            }
            AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 823217604, true, new AnonymousClass3(modifier3, interfaceC0526Fp, i3)), composerStartRestartGroup, (i3 & 14) | 384 | ((i3 >> 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            dialogProperties4 = dialogProperties3;
        } else {
            if (i7 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                dialogProperties3 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
            } else {
                dialogProperties3 = dialogProperties2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(63450171, i3, -1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:144)");
            }
            AndroidDialog_androidKt.Dialog(interfaceC3588op, dialogProperties3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 823217604, true, new AnonymousClass3(modifier3, interfaceC0526Fp, i3)), composerStartRestartGroup, (i3 & 14) | 384 | ((i3 >> 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            dialogProperties4 = dialogProperties3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, dialogProperties4, interfaceC0526Fp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0130  */
    /* JADX WARN: Code duplicated, block: B:103:0x0139  */
    /* JADX WARN: Code duplicated, block: B:105:0x013e  */
    /* JADX WARN: Code duplicated, block: B:108:0x0144  */
    /* JADX WARN: Code duplicated, block: B:110:0x014a  */
    /* JADX WARN: Code duplicated, block: B:113:0x0153  */
    /* JADX WARN: Code duplicated, block: B:115:0x0158  */
    /* JADX WARN: Code duplicated, block: B:118:0x015f  */
    /* JADX WARN: Code duplicated, block: B:120:0x0163  */
    /* JADX WARN: Code duplicated, block: B:123:0x016e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:126:0x0175  */
    /* JADX WARN: Code duplicated, block: B:129:0x017b  */
    /* JADX WARN: Code duplicated, block: B:131:0x0180  */
    /* JADX WARN: Code duplicated, block: B:133:0x0184  */
    /* JADX WARN: Code duplicated, block: B:135:0x018c  */
    /* JADX WARN: Code duplicated, block: B:136:0x018f  */
    /* JADX WARN: Code duplicated, block: B:140:0x0197  */
    /* JADX WARN: Code duplicated, block: B:142:0x019c  */
    /* JADX WARN: Code duplicated, block: B:144:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:146:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:150:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:156:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:158:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:177:0x022e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:178:0x0230  */
    /* JADX WARN: Code duplicated, block: B:181:0x0236  */
    /* JADX WARN: Code duplicated, block: B:183:0x0239  */
    /* JADX WARN: Code duplicated, block: B:185:0x023c  */
    /* JADX WARN: Code duplicated, block: B:188:0x0240  */
    /* JADX WARN: Code duplicated, block: B:191:0x0246  */
    /* JADX WARN: Code duplicated, block: B:192:0x024f  */
    /* JADX WARN: Code duplicated, block: B:195:0x0254  */
    /* JADX WARN: Code duplicated, block: B:196:0x025d  */
    /* JADX WARN: Code duplicated, block: B:199:0x0263  */
    /* JADX WARN: Code duplicated, block: B:200:0x0271  */
    /* JADX WARN: Code duplicated, block: B:203:0x0277  */
    /* JADX WARN: Code duplicated, block: B:204:0x0280  */
    /* JADX WARN: Code duplicated, block: B:207:0x0286  */
    /* JADX WARN: Code duplicated, block: B:208:0x0290  */
    /* JADX WARN: Code duplicated, block: B:210:0x0294  */
    /* JADX WARN: Code duplicated, block: B:211:0x029b  */
    /* JADX WARN: Code duplicated, block: B:213:0x029f  */
    /* JADX WARN: Code duplicated, block: B:215:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:218:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:221:0x0341  */
    /* JADX WARN: Code duplicated, block: B:226:0x0360  */
    /* JADX WARN: Code duplicated, block: B:228:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0074  */
    /* JADX WARN: Code duplicated, block: B:40:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:43:0x0083  */
    /* JADX WARN: Code duplicated, block: B:47:0x008b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:50:0x0099  */
    /* JADX WARN: Code duplicated, block: B:52:0x009f  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:72:0x00df  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:85:0x0102  */
    /* JADX WARN: Code duplicated, block: B:88:0x010a  */
    /* JADX WARN: Code duplicated, block: B:90:0x0112  */
    /* JADX WARN: Code duplicated, block: B:93:0x011b  */
    /* JADX WARN: Code duplicated, block: B:95:0x0120  */
    /* JADX WARN: Code duplicated, block: B:98:0x012a  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: AlertDialog-Oix01E0, reason: not valid java name */
    public static final void m1327AlertDialogOix01E0(InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, Shape shape, long j, long j2, long j3, long j4, float f, DialogProperties dialogProperties, Composer composer, int i, int i2, int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        InterfaceC0526Fp interfaceC0526Fp6;
        int i6;
        int i7;
        InterfaceC0526Fp interfaceC0526Fp7;
        int i8;
        int i9;
        InterfaceC0526Fp interfaceC0526Fp8;
        int i10;
        int i11;
        InterfaceC0526Fp interfaceC0526Fp9;
        int i12;
        Shape shape2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Shape shape3;
        long containerColor;
        long iconContentColor;
        long titleContentColor;
        long textContentColor;
        float fM1324getTonalElevationD9Ej5fM;
        DialogProperties dialogProperties2;
        InterfaceC0526Fp interfaceC0526Fp10;
        InterfaceC0526Fp interfaceC0526Fp11;
        Shape shape4;
        long j5;
        Modifier modifier3;
        long j6;
        long j7;
        int i18;
        InterfaceC0526Fp interfaceC0526Fp12;
        InterfaceC0526Fp interfaceC0526Fp13;
        long j8;
        Composer composer2;
        Modifier modifier4;
        InterfaceC0526Fp interfaceC0526Fp14;
        InterfaceC0526Fp interfaceC0526Fp15;
        InterfaceC0526Fp interfaceC0526Fp16;
        Shape shape5;
        long j9;
        long j10;
        long j11;
        long j12;
        float f2;
        DialogProperties dialogProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i19;
        int i20;
        int i21;
        AbstractC4492zt.h(interfaceC3588op, "onDismissRequest");
        AbstractC4492zt.h(interfaceC0526Fp, "confirmButton");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2081346864);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        int i22 = i3 & 4;
        if (i22 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i & 7168) == 0) {
                    interfaceC0526Fp6 = interfaceC0526Fp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp6)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 16;
                if (i7 != 0) {
                    i4 |= 24576;
                    interfaceC0526Fp7 = interfaceC0526Fp3;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp3;
                    if ((i & 57344) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i4 |= i8;
                    }
                }
                i9 = i3 & 32;
                if (i9 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC0526Fp8 = interfaceC0526Fp4;
                } else {
                    interfaceC0526Fp8 = interfaceC0526Fp4;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp8)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i4 |= i10;
                    }
                }
                i11 = i3 & 64;
                if (i11 != 0) {
                    i4 |= 1572864;
                    interfaceC0526Fp9 = interfaceC0526Fp5;
                } else {
                    interfaceC0526Fp9 = interfaceC0526Fp5;
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i4 |= i12;
                    }
                }
                if ((i & 29360128) == 0) {
                    if ((i3 & 128) == 0) {
                        shape2 = shape;
                        int i23 = composerStartRestartGroup.changed(shape2) ? 8388608 : 4194304;
                        i4 |= i23;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i23;
                } else {
                    shape2 = shape;
                }
                if ((i & 234881024) == 0) {
                    int i24 = i4;
                    if ((i3 & 256) == 0 || !composerStartRestartGroup.changed(j)) {
                        i21 = 33554432;
                    } else {
                        i21 = 67108864;
                    }
                    i13 = i24 | i21;
                } else {
                    i13 = i4;
                }
                if ((i & 1879048192) != 0) {
                    if ((i3 & 512) == 0 || !composerStartRestartGroup.changed(j2)) {
                        i20 = 268435456;
                    } else {
                        i20 = PropertyOptions.DELETE_EXISTING;
                    }
                    i13 |= i20;
                }
                if ((i2 & 14) == 0) {
                    if ((i3 & 1024) == 0 || !composerStartRestartGroup.changed(j3)) {
                        i19 = 2;
                    } else {
                        i19 = 4;
                    }
                    i14 = i2 | i19;
                } else {
                    i14 = i2;
                }
                if ((i2 & 112) != 0) {
                    i14 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(j4)) ? 16 : 32;
                }
                i15 = i3 & 4096;
                if (i15 != 0) {
                    if ((i2 & 896) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i16 = 256;
                        } else {
                            i16 = 128;
                        }
                        i14 |= i16;
                    }
                    i17 = i3 & 8192;
                    if (i17 != 0) {
                        if ((i2 & 7168) == 0) {
                            i14 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                        }
                        if ((i13 & 1533916891) != 306783378 && (i14 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            j12 = j4;
                            f2 = f;
                            dialogProperties3 = dialogProperties;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                            interfaceC0526Fp16 = interfaceC0526Fp9;
                            shape5 = shape2;
                            modifier4 = modifier2;
                            j9 = j;
                            j10 = j2;
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                            composer2 = composerStartRestartGroup;
                            j11 = j3;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i22 != 0) {
                                    modifier2 = Modifier.Companion;
                                }
                                if (i5 != 0) {
                                    interfaceC0526Fp6 = null;
                                }
                                if (i7 != 0) {
                                    interfaceC0526Fp7 = null;
                                }
                                if (i9 != 0) {
                                    interfaceC0526Fp8 = null;
                                }
                                InterfaceC0526Fp interfaceC0526Fp17 = i11 == 0 ? interfaceC0526Fp9 : null;
                                if ((i3 & 128) != 0) {
                                    shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                    i13 &= -29360129;
                                } else {
                                    shape3 = shape2;
                                }
                                if ((i3 & 256) != 0) {
                                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i13 &= -234881025;
                                } else {
                                    containerColor = j;
                                }
                                if ((i3 & 512) != 0) {
                                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                    i13 &= -1879048193;
                                } else {
                                    iconContentColor = j2;
                                }
                                if ((i3 & 1024) != 0) {
                                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                    i14 &= -15;
                                } else {
                                    titleContentColor = j3;
                                }
                                if ((i3 & 2048) != 0) {
                                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                    i14 &= -113;
                                } else {
                                    textContentColor = j4;
                                }
                                if (i15 != 0) {
                                    fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                                } else {
                                    fM1324getTonalElevationD9Ej5fM = f;
                                }
                                if (i17 != 0) {
                                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                                } else {
                                    dialogProperties2 = dialogProperties;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp17;
                                interfaceC0526Fp11 = interfaceC0526Fp6;
                                shape4 = shape3;
                                j5 = textContentColor;
                                modifier3 = modifier2;
                                j6 = containerColor;
                                j7 = titleContentColor;
                                i18 = i13;
                                interfaceC0526Fp12 = interfaceC0526Fp7;
                                interfaceC0526Fp13 = interfaceC0526Fp8;
                                j8 = iconContentColor;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 128) != 0) {
                                    i13 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i13 &= -234881025;
                                }
                                if ((i3 & 512) != 0) {
                                    i13 &= -1879048193;
                                }
                                if ((i3 & 1024) != 0) {
                                    i14 &= -15;
                                }
                                if ((i3 & 2048) != 0) {
                                    i14 &= -113;
                                }
                                j6 = j;
                                j7 = j3;
                                j5 = j4;
                                fM1324getTonalElevationD9Ej5fM = f;
                                dialogProperties2 = dialogProperties;
                                interfaceC0526Fp11 = interfaceC0526Fp6;
                                interfaceC0526Fp12 = interfaceC0526Fp7;
                                interfaceC0526Fp13 = interfaceC0526Fp8;
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                shape4 = shape2;
                                modifier3 = modifier2;
                                i18 = i13;
                                j8 = j2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                            }
                            Modifier modifier5 = modifier3;
                            int i25 = i14;
                            int i26 = i18;
                            composer2 = composerStartRestartGroup;
                            AlertDialog(interfaceC3588op, modifier5, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i26, i25, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i26 & 14) | 3072 | ((i26 >> 3) & 112) | ((i25 >> 3) & 896), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier5;
                            interfaceC0526Fp14 = interfaceC0526Fp11;
                            interfaceC0526Fp15 = interfaceC0526Fp13;
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            shape5 = shape4;
                            j9 = j6;
                            j10 = j8;
                            j11 = j7;
                            j12 = j5;
                            f2 = fM1324getTonalElevationD9Ej5fM;
                            dialogProperties3 = dialogProperties2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, interfaceC0526Fp, modifier4, interfaceC0526Fp14, interfaceC0526Fp12, interfaceC0526Fp15, interfaceC0526Fp16, shape5, j9, j10, j11, j12, f2, dialogProperties3, i, i2, i3));
                    }
                    i14 |= 3072;
                    if ((i13 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i22 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i7 != 0) {
                                interfaceC0526Fp7 = null;
                            }
                            if (i9 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            if (i11 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                                shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i13 &= -29360129;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i13 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i13 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i14 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i14 &= -113;
                            } else {
                                textContentColor = j4;
                            }
                            if (i15 != 0) {
                                fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                            } else {
                                fM1324getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp17;
                            interfaceC0526Fp11 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j5 = textContentColor;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = titleContentColor;
                            i18 = i13;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp13 = interfaceC0526Fp8;
                            j8 = iconContentColor;
                        } else {
                            if (i22 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i7 != 0) {
                                interfaceC0526Fp7 = null;
                            }
                            if (i9 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            if (i11 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                                shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i13 &= -29360129;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i13 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i13 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i14 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i14 &= -113;
                            } else {
                                textContentColor = j4;
                            }
                            if (i15 != 0) {
                                fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                            } else {
                                fM1324getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp17;
                            interfaceC0526Fp11 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j5 = textContentColor;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = titleContentColor;
                            i18 = i13;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp13 = interfaceC0526Fp8;
                            j8 = iconContentColor;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                        }
                        Modifier modifier6 = modifier3;
                        int i27 = i14;
                        int i28 = i18;
                        composer2 = composerStartRestartGroup;
                        AlertDialog(interfaceC3588op, modifier6, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i28, i27, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i28 & 14) | 3072 | ((i28 >> 3) & 112) | ((i27 >> 3) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier6;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp13;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        shape5 = shape4;
                        j9 = j6;
                        j10 = j8;
                        j11 = j7;
                        j12 = j5;
                        f2 = fM1324getTonalElevationD9Ej5fM;
                        dialogProperties3 = dialogProperties2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i22 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i7 != 0) {
                                interfaceC0526Fp7 = null;
                            }
                            if (i9 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            if (i11 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                                shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i13 &= -29360129;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i13 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i13 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i14 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i14 &= -113;
                            } else {
                                textContentColor = j4;
                            }
                            if (i15 != 0) {
                                fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                            } else {
                                fM1324getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp17;
                            interfaceC0526Fp11 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j5 = textContentColor;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = titleContentColor;
                            i18 = i13;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp13 = interfaceC0526Fp8;
                            j8 = iconContentColor;
                        } else {
                            if (i22 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i7 != 0) {
                                interfaceC0526Fp7 = null;
                            }
                            if (i9 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            if (i11 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                                shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i13 &= -29360129;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i13 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i13 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i14 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i14 &= -113;
                            } else {
                                textContentColor = j4;
                            }
                            if (i15 != 0) {
                                fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                            } else {
                                fM1324getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp17;
                            interfaceC0526Fp11 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j5 = textContentColor;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = titleContentColor;
                            i18 = i13;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp13 = interfaceC0526Fp8;
                            j8 = iconContentColor;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                        }
                        Modifier modifier7 = modifier3;
                        int i29 = i14;
                        int i210 = i18;
                        composer2 = composerStartRestartGroup;
                        AlertDialog(interfaceC3588op, modifier7, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i210, i29, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i210 & 14) | 3072 | ((i210 >> 3) & 112) | ((i29 >> 3) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier7;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp13;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        shape5 = shape4;
                        j9 = j6;
                        j10 = j8;
                        j11 = j7;
                        j12 = j5;
                        f2 = fM1324getTonalElevationD9Ej5fM;
                        dialogProperties3 = dialogProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, interfaceC0526Fp, modifier4, interfaceC0526Fp14, interfaceC0526Fp12, interfaceC0526Fp15, interfaceC0526Fp16, shape5, j9, j10, j11, j12, f2, dialogProperties3, i, i2, i3));
                }
                i14 |= 384;
                i17 = i3 & 8192;
                if (i17 != 0) {
                    if ((i2 & 7168) == 0) {
                        i14 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                    }
                    if ((i13 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i22 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i7 != 0) {
                                interfaceC0526Fp7 = null;
                            }
                            if (i9 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            if (i11 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                                shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i13 &= -29360129;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i13 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i13 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i14 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i14 &= -113;
                            } else {
                                textContentColor = j4;
                            }
                            if (i15 != 0) {
                                fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                            } else {
                                fM1324getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp17;
                            interfaceC0526Fp11 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j5 = textContentColor;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = titleContentColor;
                            i18 = i13;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp13 = interfaceC0526Fp8;
                            j8 = iconContentColor;
                        } else {
                            if (i22 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i7 != 0) {
                                interfaceC0526Fp7 = null;
                            }
                            if (i9 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            if (i11 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                                shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i13 &= -29360129;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i13 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i13 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i14 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i14 &= -113;
                            } else {
                                textContentColor = j4;
                            }
                            if (i15 != 0) {
                                fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                            } else {
                                fM1324getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp17;
                            interfaceC0526Fp11 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j5 = textContentColor;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = titleContentColor;
                            i18 = i13;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp13 = interfaceC0526Fp8;
                            j8 = iconContentColor;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                        }
                        Modifier modifier8 = modifier3;
                        int i211 = i14;
                        int i212 = i18;
                        composer2 = composerStartRestartGroup;
                        AlertDialog(interfaceC3588op, modifier8, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i212, i211, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i212 & 14) | 3072 | ((i212 >> 3) & 112) | ((i211 >> 3) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier8;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp13;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        shape5 = shape4;
                        j9 = j6;
                        j10 = j8;
                        j11 = j7;
                        j12 = j5;
                        f2 = fM1324getTonalElevationD9Ej5fM;
                        dialogProperties3 = dialogProperties2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i22 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i7 != 0) {
                                interfaceC0526Fp7 = null;
                            }
                            if (i9 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            if (i11 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                                shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i13 &= -29360129;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i13 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i13 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i14 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i14 &= -113;
                            } else {
                                textContentColor = j4;
                            }
                            if (i15 != 0) {
                                fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                            } else {
                                fM1324getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp17;
                            interfaceC0526Fp11 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j5 = textContentColor;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = titleContentColor;
                            i18 = i13;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp13 = interfaceC0526Fp8;
                            j8 = iconContentColor;
                        } else {
                            if (i22 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i7 != 0) {
                                interfaceC0526Fp7 = null;
                            }
                            if (i9 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            if (i11 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                                shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i13 &= -29360129;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i13 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i13 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i14 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i14 &= -113;
                            } else {
                                textContentColor = j4;
                            }
                            if (i15 != 0) {
                                fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                            } else {
                                fM1324getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp17;
                            interfaceC0526Fp11 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j5 = textContentColor;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = titleContentColor;
                            i18 = i13;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp13 = interfaceC0526Fp8;
                            j8 = iconContentColor;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                        }
                        Modifier modifier9 = modifier3;
                        int i213 = i14;
                        int i214 = i18;
                        composer2 = composerStartRestartGroup;
                        AlertDialog(interfaceC3588op, modifier9, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i214, i213, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i214 & 14) | 3072 | ((i214 >> 3) & 112) | ((i213 >> 3) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier9;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp13;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        shape5 = shape4;
                        j9 = j6;
                        j10 = j8;
                        j11 = j7;
                        j12 = j5;
                        f2 = fM1324getTonalElevationD9Ej5fM;
                        dialogProperties3 = dialogProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, interfaceC0526Fp, modifier4, interfaceC0526Fp14, interfaceC0526Fp12, interfaceC0526Fp15, interfaceC0526Fp16, shape5, j9, j10, j11, j12, f2, dialogProperties3, i, i2, i3));
                }
                i14 |= 3072;
                if ((i13 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    } else {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                    }
                    Modifier modifier10 = modifier3;
                    int i215 = i14;
                    int i216 = i18;
                    composer2 = composerStartRestartGroup;
                    AlertDialog(interfaceC3588op, modifier10, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i216, i215, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i216 & 14) | 3072 | ((i216 >> 3) & 112) | ((i215 >> 3) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier10;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp13;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    shape5 = shape4;
                    j9 = j6;
                    j10 = j8;
                    j11 = j7;
                    j12 = j5;
                    f2 = fM1324getTonalElevationD9Ej5fM;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    } else {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                    }
                    Modifier modifier11 = modifier3;
                    int i217 = i14;
                    int i218 = i18;
                    composer2 = composerStartRestartGroup;
                    AlertDialog(interfaceC3588op, modifier11, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i218, i217, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i218 & 14) | 3072 | ((i218 >> 3) & 112) | ((i217 >> 3) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier11;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp13;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    shape5 = shape4;
                    j9 = j6;
                    j10 = j8;
                    j11 = j7;
                    j12 = j5;
                    f2 = fM1324getTonalElevationD9Ej5fM;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, interfaceC0526Fp, modifier4, interfaceC0526Fp14, interfaceC0526Fp12, interfaceC0526Fp15, interfaceC0526Fp16, shape5, j9, j10, j11, j12, f2, dialogProperties3, i, i2, i3));
            }
            i4 |= 3072;
            interfaceC0526Fp6 = interfaceC0526Fp2;
            i7 = i3 & 16;
            if (i7 != 0) {
                i4 |= 24576;
                interfaceC0526Fp7 = interfaceC0526Fp3;
            } else {
                interfaceC0526Fp7 = interfaceC0526Fp3;
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
            }
            i9 = i3 & 32;
            if (i9 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp8 = interfaceC0526Fp4;
            } else {
                interfaceC0526Fp8 = interfaceC0526Fp4;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp8)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 64;
            if (i11 != 0) {
                i4 |= 1572864;
                interfaceC0526Fp9 = interfaceC0526Fp5;
            } else {
                interfaceC0526Fp9 = interfaceC0526Fp5;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i4 |= i12;
                }
            }
            if ((i & 29360128) == 0) {
                if ((i3 & 128) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i4 |= i23;
                } else {
                    shape2 = shape;
                }
                i4 |= i23;
            } else {
                shape2 = shape;
            }
            if ((i & 234881024) == 0) {
                int i219 = i4;
                if ((i3 & 256) == 0) {
                    i21 = 33554432;
                } else {
                    i21 = 33554432;
                }
                i13 = i219 | i21;
            } else {
                i13 = i4;
            }
            if ((i & 1879048192) != 0) {
                if ((i3 & 512) == 0) {
                    i20 = 268435456;
                } else {
                    i20 = 268435456;
                }
                i13 |= i20;
            }
            if ((i2 & 14) == 0) {
                if ((i3 & 1024) == 0) {
                    i19 = 2;
                } else {
                    i19 = 2;
                }
                i14 = i2 | i19;
            } else {
                i14 = i2;
            }
            if ((i2 & 112) != 0) {
                i14 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(j4)) ? 16 : 32;
            }
            i15 = i3 & 4096;
            if (i15 != 0) {
                if ((i2 & 896) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i16 = 256;
                    } else {
                        i16 = 128;
                    }
                    i14 |= i16;
                }
                i17 = i3 & 8192;
                if (i17 != 0) {
                    if ((i2 & 7168) == 0) {
                        i14 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                    }
                    if ((i13 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i22 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i7 != 0) {
                                interfaceC0526Fp7 = null;
                            }
                            if (i9 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            if (i11 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                                shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i13 &= -29360129;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i13 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i13 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i14 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i14 &= -113;
                            } else {
                                textContentColor = j4;
                            }
                            if (i15 != 0) {
                                fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                            } else {
                                fM1324getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp17;
                            interfaceC0526Fp11 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j5 = textContentColor;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = titleContentColor;
                            i18 = i13;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp13 = interfaceC0526Fp8;
                            j8 = iconContentColor;
                        } else {
                            if (i22 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i7 != 0) {
                                interfaceC0526Fp7 = null;
                            }
                            if (i9 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            if (i11 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                                shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i13 &= -29360129;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i13 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i13 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i14 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i14 &= -113;
                            } else {
                                textContentColor = j4;
                            }
                            if (i15 != 0) {
                                fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                            } else {
                                fM1324getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp17;
                            interfaceC0526Fp11 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j5 = textContentColor;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = titleContentColor;
                            i18 = i13;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp13 = interfaceC0526Fp8;
                            j8 = iconContentColor;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                        }
                        Modifier modifier12 = modifier3;
                        int i2110 = i14;
                        int i2111 = i18;
                        composer2 = composerStartRestartGroup;
                        AlertDialog(interfaceC3588op, modifier12, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i2111, i2110, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i2111 & 14) | 3072 | ((i2111 >> 3) & 112) | ((i2110 >> 3) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier12;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp13;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        shape5 = shape4;
                        j9 = j6;
                        j10 = j8;
                        j11 = j7;
                        j12 = j5;
                        f2 = fM1324getTonalElevationD9Ej5fM;
                        dialogProperties3 = dialogProperties2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i22 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i7 != 0) {
                                interfaceC0526Fp7 = null;
                            }
                            if (i9 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            if (i11 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                                shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i13 &= -29360129;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i13 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i13 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i14 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i14 &= -113;
                            } else {
                                textContentColor = j4;
                            }
                            if (i15 != 0) {
                                fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                            } else {
                                fM1324getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp17;
                            interfaceC0526Fp11 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j5 = textContentColor;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = titleContentColor;
                            i18 = i13;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp13 = interfaceC0526Fp8;
                            j8 = iconContentColor;
                        } else {
                            if (i22 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i7 != 0) {
                                interfaceC0526Fp7 = null;
                            }
                            if (i9 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            if (i11 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                                shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i13 &= -29360129;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i13 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i13 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i14 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i14 &= -113;
                            } else {
                                textContentColor = j4;
                            }
                            if (i15 != 0) {
                                fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                            } else {
                                fM1324getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp17;
                            interfaceC0526Fp11 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j5 = textContentColor;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = titleContentColor;
                            i18 = i13;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp13 = interfaceC0526Fp8;
                            j8 = iconContentColor;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                        }
                        Modifier modifier13 = modifier3;
                        int i2112 = i14;
                        int i2113 = i18;
                        composer2 = composerStartRestartGroup;
                        AlertDialog(interfaceC3588op, modifier13, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i2113, i2112, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i2113 & 14) | 3072 | ((i2113 >> 3) & 112) | ((i2112 >> 3) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier13;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp13;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        shape5 = shape4;
                        j9 = j6;
                        j10 = j8;
                        j11 = j7;
                        j12 = j5;
                        f2 = fM1324getTonalElevationD9Ej5fM;
                        dialogProperties3 = dialogProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, interfaceC0526Fp, modifier4, interfaceC0526Fp14, interfaceC0526Fp12, interfaceC0526Fp15, interfaceC0526Fp16, shape5, j9, j10, j11, j12, f2, dialogProperties3, i, i2, i3));
                }
                i14 |= 3072;
                if ((i13 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    } else {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                    }
                    Modifier modifier14 = modifier3;
                    int i2114 = i14;
                    int i2115 = i18;
                    composer2 = composerStartRestartGroup;
                    AlertDialog(interfaceC3588op, modifier14, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i2115, i2114, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i2115 & 14) | 3072 | ((i2115 >> 3) & 112) | ((i2114 >> 3) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier14;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp13;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    shape5 = shape4;
                    j9 = j6;
                    j10 = j8;
                    j11 = j7;
                    j12 = j5;
                    f2 = fM1324getTonalElevationD9Ej5fM;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    } else {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                    }
                    Modifier modifier15 = modifier3;
                    int i2116 = i14;
                    int i2117 = i18;
                    composer2 = composerStartRestartGroup;
                    AlertDialog(interfaceC3588op, modifier15, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i2117, i2116, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i2117 & 14) | 3072 | ((i2117 >> 3) & 112) | ((i2116 >> 3) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier15;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp13;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    shape5 = shape4;
                    j9 = j6;
                    j10 = j8;
                    j11 = j7;
                    j12 = j5;
                    f2 = fM1324getTonalElevationD9Ej5fM;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, interfaceC0526Fp, modifier4, interfaceC0526Fp14, interfaceC0526Fp12, interfaceC0526Fp15, interfaceC0526Fp16, shape5, j9, j10, j11, j12, f2, dialogProperties3, i, i2, i3));
            }
            i14 |= 384;
            i17 = i3 & 8192;
            if (i17 != 0) {
                if ((i2 & 7168) == 0) {
                    i14 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                }
                if ((i13 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    } else {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                    }
                    Modifier modifier16 = modifier3;
                    int i2118 = i14;
                    int i2119 = i18;
                    composer2 = composerStartRestartGroup;
                    AlertDialog(interfaceC3588op, modifier16, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i2119, i2118, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i2119 & 14) | 3072 | ((i2119 >> 3) & 112) | ((i2118 >> 3) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier16;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp13;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    shape5 = shape4;
                    j9 = j6;
                    j10 = j8;
                    j11 = j7;
                    j12 = j5;
                    f2 = fM1324getTonalElevationD9Ej5fM;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    } else {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                    }
                    Modifier modifier17 = modifier3;
                    int i21110 = i14;
                    int i21111 = i18;
                    composer2 = composerStartRestartGroup;
                    AlertDialog(interfaceC3588op, modifier17, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i21111, i21110, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i21111 & 14) | 3072 | ((i21111 >> 3) & 112) | ((i21110 >> 3) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier17;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp13;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    shape5 = shape4;
                    j9 = j6;
                    j10 = j8;
                    j11 = j7;
                    j12 = j5;
                    f2 = fM1324getTonalElevationD9Ej5fM;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, interfaceC0526Fp, modifier4, interfaceC0526Fp14, interfaceC0526Fp12, interfaceC0526Fp15, interfaceC0526Fp16, shape5, j9, j10, j11, j12, f2, dialogProperties3, i, i2, i3));
            }
            i14 |= 3072;
            if ((i13 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i7 != 0) {
                        interfaceC0526Fp7 = null;
                    }
                    if (i9 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & 128) != 0) {
                        shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i13 &= -29360129;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i13 &= -1879048193;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i14 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i14 &= -113;
                    } else {
                        textContentColor = j4;
                    }
                    if (i15 != 0) {
                        fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                    } else {
                        fM1324getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp17;
                    interfaceC0526Fp11 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j5 = textContentColor;
                    modifier3 = modifier2;
                    j6 = containerColor;
                    j7 = titleContentColor;
                    i18 = i13;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    j8 = iconContentColor;
                } else {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i7 != 0) {
                        interfaceC0526Fp7 = null;
                    }
                    if (i9 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & 128) != 0) {
                        shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i13 &= -29360129;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i13 &= -1879048193;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i14 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i14 &= -113;
                    } else {
                        textContentColor = j4;
                    }
                    if (i15 != 0) {
                        fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                    } else {
                        fM1324getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp17;
                    interfaceC0526Fp11 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j5 = textContentColor;
                    modifier3 = modifier2;
                    j6 = containerColor;
                    j7 = titleContentColor;
                    i18 = i13;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    j8 = iconContentColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                }
                Modifier modifier18 = modifier3;
                int i21112 = i14;
                int i21113 = i18;
                composer2 = composerStartRestartGroup;
                AlertDialog(interfaceC3588op, modifier18, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i21113, i21112, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i21113 & 14) | 3072 | ((i21113 >> 3) & 112) | ((i21112 >> 3) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier18;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp13;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                shape5 = shape4;
                j9 = j6;
                j10 = j8;
                j11 = j7;
                j12 = j5;
                f2 = fM1324getTonalElevationD9Ej5fM;
                dialogProperties3 = dialogProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i7 != 0) {
                        interfaceC0526Fp7 = null;
                    }
                    if (i9 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & 128) != 0) {
                        shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i13 &= -29360129;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i13 &= -1879048193;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i14 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i14 &= -113;
                    } else {
                        textContentColor = j4;
                    }
                    if (i15 != 0) {
                        fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                    } else {
                        fM1324getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp17;
                    interfaceC0526Fp11 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j5 = textContentColor;
                    modifier3 = modifier2;
                    j6 = containerColor;
                    j7 = titleContentColor;
                    i18 = i13;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    j8 = iconContentColor;
                } else {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i7 != 0) {
                        interfaceC0526Fp7 = null;
                    }
                    if (i9 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & 128) != 0) {
                        shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i13 &= -29360129;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i13 &= -1879048193;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i14 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i14 &= -113;
                    } else {
                        textContentColor = j4;
                    }
                    if (i15 != 0) {
                        fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                    } else {
                        fM1324getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp17;
                    interfaceC0526Fp11 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j5 = textContentColor;
                    modifier3 = modifier2;
                    j6 = containerColor;
                    j7 = titleContentColor;
                    i18 = i13;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    j8 = iconContentColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                }
                Modifier modifier19 = modifier3;
                int i21114 = i14;
                int i21115 = i18;
                composer2 = composerStartRestartGroup;
                AlertDialog(interfaceC3588op, modifier19, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i21115, i21114, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i21115 & 14) | 3072 | ((i21115 >> 3) & 112) | ((i21114 >> 3) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier19;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp13;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                shape5 = shape4;
                j9 = j6;
                j10 = j8;
                j11 = j7;
                j12 = j5;
                f2 = fM1324getTonalElevationD9Ej5fM;
                dialogProperties3 = dialogProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, interfaceC0526Fp, modifier4, interfaceC0526Fp14, interfaceC0526Fp12, interfaceC0526Fp15, interfaceC0526Fp16, shape5, j9, j10, j11, j12, f2, dialogProperties3, i, i2, i3));
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i & 7168) == 0) {
                interfaceC0526Fp6 = interfaceC0526Fp2;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp6)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            i7 = i3 & 16;
            if (i7 != 0) {
                i4 |= 24576;
                interfaceC0526Fp7 = interfaceC0526Fp3;
            } else {
                interfaceC0526Fp7 = interfaceC0526Fp3;
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
            }
            i9 = i3 & 32;
            if (i9 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp8 = interfaceC0526Fp4;
            } else {
                interfaceC0526Fp8 = interfaceC0526Fp4;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp8)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 64;
            if (i11 != 0) {
                i4 |= 1572864;
                interfaceC0526Fp9 = interfaceC0526Fp5;
            } else {
                interfaceC0526Fp9 = interfaceC0526Fp5;
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i4 |= i12;
                }
            }
            if ((i & 29360128) == 0) {
                if ((i3 & 128) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i4 |= i23;
                } else {
                    shape2 = shape;
                }
                i4 |= i23;
            } else {
                shape2 = shape;
            }
            if ((i & 234881024) == 0) {
                int i2120 = i4;
                if ((i3 & 256) == 0) {
                    i21 = 33554432;
                } else {
                    i21 = 33554432;
                }
                i13 = i2120 | i21;
            } else {
                i13 = i4;
            }
            if ((i & 1879048192) != 0) {
                if ((i3 & 512) == 0) {
                    i20 = 268435456;
                } else {
                    i20 = 268435456;
                }
                i13 |= i20;
            }
            if ((i2 & 14) == 0) {
                if ((i3 & 1024) == 0) {
                    i19 = 2;
                } else {
                    i19 = 2;
                }
                i14 = i2 | i19;
            } else {
                i14 = i2;
            }
            if ((i2 & 112) != 0) {
                i14 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(j4)) ? 16 : 32;
            }
            i15 = i3 & 4096;
            if (i15 != 0) {
                if ((i2 & 896) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i16 = 256;
                    } else {
                        i16 = 128;
                    }
                    i14 |= i16;
                }
                i17 = i3 & 8192;
                if (i17 != 0) {
                    if ((i2 & 7168) == 0) {
                        i14 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                    }
                    if ((i13 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i22 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i7 != 0) {
                                interfaceC0526Fp7 = null;
                            }
                            if (i9 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            if (i11 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                                shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i13 &= -29360129;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i13 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i13 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i14 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i14 &= -113;
                            } else {
                                textContentColor = j4;
                            }
                            if (i15 != 0) {
                                fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                            } else {
                                fM1324getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp17;
                            interfaceC0526Fp11 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j5 = textContentColor;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = titleContentColor;
                            i18 = i13;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp13 = interfaceC0526Fp8;
                            j8 = iconContentColor;
                        } else {
                            if (i22 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i7 != 0) {
                                interfaceC0526Fp7 = null;
                            }
                            if (i9 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            if (i11 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                                shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i13 &= -29360129;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i13 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i13 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i14 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i14 &= -113;
                            } else {
                                textContentColor = j4;
                            }
                            if (i15 != 0) {
                                fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                            } else {
                                fM1324getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp17;
                            interfaceC0526Fp11 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j5 = textContentColor;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = titleContentColor;
                            i18 = i13;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp13 = interfaceC0526Fp8;
                            j8 = iconContentColor;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                        }
                        Modifier modifier110 = modifier3;
                        int i21116 = i14;
                        int i21117 = i18;
                        composer2 = composerStartRestartGroup;
                        AlertDialog(interfaceC3588op, modifier110, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i21117, i21116, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i21117 & 14) | 3072 | ((i21117 >> 3) & 112) | ((i21116 >> 3) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier110;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp13;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        shape5 = shape4;
                        j9 = j6;
                        j10 = j8;
                        j11 = j7;
                        j12 = j5;
                        f2 = fM1324getTonalElevationD9Ej5fM;
                        dialogProperties3 = dialogProperties2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i22 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i7 != 0) {
                                interfaceC0526Fp7 = null;
                            }
                            if (i9 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            if (i11 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                                shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i13 &= -29360129;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i13 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i13 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i14 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i14 &= -113;
                            } else {
                                textContentColor = j4;
                            }
                            if (i15 != 0) {
                                fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                            } else {
                                fM1324getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp17;
                            interfaceC0526Fp11 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j5 = textContentColor;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = titleContentColor;
                            i18 = i13;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp13 = interfaceC0526Fp8;
                            j8 = iconContentColor;
                        } else {
                            if (i22 != 0) {
                                modifier2 = Modifier.Companion;
                            }
                            if (i5 != 0) {
                                interfaceC0526Fp6 = null;
                            }
                            if (i7 != 0) {
                                interfaceC0526Fp7 = null;
                            }
                            if (i9 != 0) {
                                interfaceC0526Fp8 = null;
                            }
                            if (i11 == 0) {
                            }
                            if ((i3 & 128) != 0) {
                                shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i13 &= -29360129;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i13 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i13 &= -1879048193;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i14 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i14 &= -113;
                            } else {
                                textContentColor = j4;
                            }
                            if (i15 != 0) {
                                fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                            } else {
                                fM1324getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                            } else {
                                dialogProperties2 = dialogProperties;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp17;
                            interfaceC0526Fp11 = interfaceC0526Fp6;
                            shape4 = shape3;
                            j5 = textContentColor;
                            modifier3 = modifier2;
                            j6 = containerColor;
                            j7 = titleContentColor;
                            i18 = i13;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                            interfaceC0526Fp13 = interfaceC0526Fp8;
                            j8 = iconContentColor;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                        }
                        Modifier modifier111 = modifier3;
                        int i21118 = i14;
                        int i21119 = i18;
                        composer2 = composerStartRestartGroup;
                        AlertDialog(interfaceC3588op, modifier111, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i21119, i21118, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i21119 & 14) | 3072 | ((i21119 >> 3) & 112) | ((i21118 >> 3) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier111;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp13;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        shape5 = shape4;
                        j9 = j6;
                        j10 = j8;
                        j11 = j7;
                        j12 = j5;
                        f2 = fM1324getTonalElevationD9Ej5fM;
                        dialogProperties3 = dialogProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, interfaceC0526Fp, modifier4, interfaceC0526Fp14, interfaceC0526Fp12, interfaceC0526Fp15, interfaceC0526Fp16, shape5, j9, j10, j11, j12, f2, dialogProperties3, i, i2, i3));
                }
                i14 |= 3072;
                if ((i13 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    } else {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                    }
                    Modifier modifier112 = modifier3;
                    int i211110 = i14;
                    int i211111 = i18;
                    composer2 = composerStartRestartGroup;
                    AlertDialog(interfaceC3588op, modifier112, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i211111, i211110, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i211111 & 14) | 3072 | ((i211111 >> 3) & 112) | ((i211110 >> 3) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier112;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp13;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    shape5 = shape4;
                    j9 = j6;
                    j10 = j8;
                    j11 = j7;
                    j12 = j5;
                    f2 = fM1324getTonalElevationD9Ej5fM;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    } else {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                    }
                    Modifier modifier113 = modifier3;
                    int i211112 = i14;
                    int i211113 = i18;
                    composer2 = composerStartRestartGroup;
                    AlertDialog(interfaceC3588op, modifier113, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i211113, i211112, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i211113 & 14) | 3072 | ((i211113 >> 3) & 112) | ((i211112 >> 3) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier113;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp13;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    shape5 = shape4;
                    j9 = j6;
                    j10 = j8;
                    j11 = j7;
                    j12 = j5;
                    f2 = fM1324getTonalElevationD9Ej5fM;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, interfaceC0526Fp, modifier4, interfaceC0526Fp14, interfaceC0526Fp12, interfaceC0526Fp15, interfaceC0526Fp16, shape5, j9, j10, j11, j12, f2, dialogProperties3, i, i2, i3));
            }
            i14 |= 384;
            i17 = i3 & 8192;
            if (i17 != 0) {
                if ((i2 & 7168) == 0) {
                    i14 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                }
                if ((i13 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    } else {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                    }
                    Modifier modifier114 = modifier3;
                    int i211114 = i14;
                    int i211115 = i18;
                    composer2 = composerStartRestartGroup;
                    AlertDialog(interfaceC3588op, modifier114, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i211115, i211114, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i211115 & 14) | 3072 | ((i211115 >> 3) & 112) | ((i211114 >> 3) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier114;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp13;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    shape5 = shape4;
                    j9 = j6;
                    j10 = j8;
                    j11 = j7;
                    j12 = j5;
                    f2 = fM1324getTonalElevationD9Ej5fM;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    } else {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                    }
                    Modifier modifier115 = modifier3;
                    int i211116 = i14;
                    int i211117 = i18;
                    composer2 = composerStartRestartGroup;
                    AlertDialog(interfaceC3588op, modifier115, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i211117, i211116, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i211117 & 14) | 3072 | ((i211117 >> 3) & 112) | ((i211116 >> 3) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier115;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp13;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    shape5 = shape4;
                    j9 = j6;
                    j10 = j8;
                    j11 = j7;
                    j12 = j5;
                    f2 = fM1324getTonalElevationD9Ej5fM;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, interfaceC0526Fp, modifier4, interfaceC0526Fp14, interfaceC0526Fp12, interfaceC0526Fp15, interfaceC0526Fp16, shape5, j9, j10, j11, j12, f2, dialogProperties3, i, i2, i3));
            }
            i14 |= 3072;
            if ((i13 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i7 != 0) {
                        interfaceC0526Fp7 = null;
                    }
                    if (i9 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & 128) != 0) {
                        shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i13 &= -29360129;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i13 &= -1879048193;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i14 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i14 &= -113;
                    } else {
                        textContentColor = j4;
                    }
                    if (i15 != 0) {
                        fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                    } else {
                        fM1324getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp17;
                    interfaceC0526Fp11 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j5 = textContentColor;
                    modifier3 = modifier2;
                    j6 = containerColor;
                    j7 = titleContentColor;
                    i18 = i13;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    j8 = iconContentColor;
                } else {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i7 != 0) {
                        interfaceC0526Fp7 = null;
                    }
                    if (i9 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & 128) != 0) {
                        shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i13 &= -29360129;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i13 &= -1879048193;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i14 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i14 &= -113;
                    } else {
                        textContentColor = j4;
                    }
                    if (i15 != 0) {
                        fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                    } else {
                        fM1324getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp17;
                    interfaceC0526Fp11 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j5 = textContentColor;
                    modifier3 = modifier2;
                    j6 = containerColor;
                    j7 = titleContentColor;
                    i18 = i13;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    j8 = iconContentColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                }
                Modifier modifier116 = modifier3;
                int i211118 = i14;
                int i211119 = i18;
                composer2 = composerStartRestartGroup;
                AlertDialog(interfaceC3588op, modifier116, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i211119, i211118, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i211119 & 14) | 3072 | ((i211119 >> 3) & 112) | ((i211118 >> 3) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier116;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp13;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                shape5 = shape4;
                j9 = j6;
                j10 = j8;
                j11 = j7;
                j12 = j5;
                f2 = fM1324getTonalElevationD9Ej5fM;
                dialogProperties3 = dialogProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i7 != 0) {
                        interfaceC0526Fp7 = null;
                    }
                    if (i9 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & 128) != 0) {
                        shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i13 &= -29360129;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i13 &= -1879048193;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i14 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i14 &= -113;
                    } else {
                        textContentColor = j4;
                    }
                    if (i15 != 0) {
                        fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                    } else {
                        fM1324getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp17;
                    interfaceC0526Fp11 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j5 = textContentColor;
                    modifier3 = modifier2;
                    j6 = containerColor;
                    j7 = titleContentColor;
                    i18 = i13;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    j8 = iconContentColor;
                } else {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i7 != 0) {
                        interfaceC0526Fp7 = null;
                    }
                    if (i9 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & 128) != 0) {
                        shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i13 &= -29360129;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i13 &= -1879048193;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i14 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i14 &= -113;
                    } else {
                        textContentColor = j4;
                    }
                    if (i15 != 0) {
                        fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                    } else {
                        fM1324getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp17;
                    interfaceC0526Fp11 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j5 = textContentColor;
                    modifier3 = modifier2;
                    j6 = containerColor;
                    j7 = titleContentColor;
                    i18 = i13;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    j8 = iconContentColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                }
                Modifier modifier117 = modifier3;
                int i2111110 = i14;
                int i2111111 = i18;
                composer2 = composerStartRestartGroup;
                AlertDialog(interfaceC3588op, modifier117, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i2111111, i2111110, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i2111111 & 14) | 3072 | ((i2111111 >> 3) & 112) | ((i2111110 >> 3) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier117;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp13;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                shape5 = shape4;
                j9 = j6;
                j10 = j8;
                j11 = j7;
                j12 = j5;
                f2 = fM1324getTonalElevationD9Ej5fM;
                dialogProperties3 = dialogProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, interfaceC0526Fp, modifier4, interfaceC0526Fp14, interfaceC0526Fp12, interfaceC0526Fp15, interfaceC0526Fp16, shape5, j9, j10, j11, j12, f2, dialogProperties3, i, i2, i3));
        }
        i4 |= 3072;
        interfaceC0526Fp6 = interfaceC0526Fp2;
        i7 = i3 & 16;
        if (i7 != 0) {
            i4 |= 24576;
            interfaceC0526Fp7 = interfaceC0526Fp3;
        } else {
            interfaceC0526Fp7 = interfaceC0526Fp3;
            if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
        }
        i9 = i3 & 32;
        if (i9 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interfaceC0526Fp8 = interfaceC0526Fp4;
        } else {
            interfaceC0526Fp8 = interfaceC0526Fp4;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp8)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i4 |= i10;
            }
        }
        i11 = i3 & 64;
        if (i11 != 0) {
            i4 |= 1572864;
            interfaceC0526Fp9 = interfaceC0526Fp5;
        } else {
            interfaceC0526Fp9 = interfaceC0526Fp5;
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i4 |= i12;
            }
        }
        if ((i & 29360128) == 0) {
            if ((i3 & 128) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i4 |= i23;
            } else {
                shape2 = shape;
            }
            i4 |= i23;
        } else {
            shape2 = shape;
        }
        if ((i & 234881024) == 0) {
            int i2121 = i4;
            if ((i3 & 256) == 0) {
                i21 = 33554432;
            } else {
                i21 = 33554432;
            }
            i13 = i2121 | i21;
        } else {
            i13 = i4;
        }
        if ((i & 1879048192) != 0) {
            if ((i3 & 512) == 0) {
                i20 = 268435456;
            } else {
                i20 = 268435456;
            }
            i13 |= i20;
        }
        if ((i2 & 14) == 0) {
            if ((i3 & 1024) == 0) {
                i19 = 2;
            } else {
                i19 = 2;
            }
            i14 = i2 | i19;
        } else {
            i14 = i2;
        }
        if ((i2 & 112) != 0) {
            i14 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(j4)) ? 16 : 32;
        }
        i15 = i3 & 4096;
        if (i15 != 0) {
            if ((i2 & 896) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i16 = 256;
                } else {
                    i16 = 128;
                }
                i14 |= i16;
            }
            i17 = i3 & 8192;
            if (i17 != 0) {
                if ((i2 & 7168) == 0) {
                    i14 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                }
                if ((i13 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    } else {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                    }
                    Modifier modifier118 = modifier3;
                    int i2111112 = i14;
                    int i2111113 = i18;
                    composer2 = composerStartRestartGroup;
                    AlertDialog(interfaceC3588op, modifier118, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i2111113, i2111112, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i2111113 & 14) | 3072 | ((i2111113 >> 3) & 112) | ((i2111112 >> 3) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier118;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp13;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    shape5 = shape4;
                    j9 = j6;
                    j10 = j8;
                    j11 = j7;
                    j12 = j5;
                    f2 = fM1324getTonalElevationD9Ej5fM;
                    dialogProperties3 = dialogProperties2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    } else {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        }
                        if (i5 != 0) {
                            interfaceC0526Fp6 = null;
                        }
                        if (i7 != 0) {
                            interfaceC0526Fp7 = null;
                        }
                        if (i9 != 0) {
                            interfaceC0526Fp8 = null;
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & 128) != 0) {
                            shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i13 &= -29360129;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i13 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i13 &= -1879048193;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i14 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i14 &= -113;
                        } else {
                            textContentColor = j4;
                        }
                        if (i15 != 0) {
                            fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                        } else {
                            fM1324getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                        } else {
                            dialogProperties2 = dialogProperties;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp17;
                        interfaceC0526Fp11 = interfaceC0526Fp6;
                        shape4 = shape3;
                        j5 = textContentColor;
                        modifier3 = modifier2;
                        j6 = containerColor;
                        j7 = titleContentColor;
                        i18 = i13;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                        interfaceC0526Fp13 = interfaceC0526Fp8;
                        j8 = iconContentColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                    }
                    Modifier modifier119 = modifier3;
                    int i2111114 = i14;
                    int i2111115 = i18;
                    composer2 = composerStartRestartGroup;
                    AlertDialog(interfaceC3588op, modifier119, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i2111115, i2111114, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i2111115 & 14) | 3072 | ((i2111115 >> 3) & 112) | ((i2111114 >> 3) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier119;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp13;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    shape5 = shape4;
                    j9 = j6;
                    j10 = j8;
                    j11 = j7;
                    j12 = j5;
                    f2 = fM1324getTonalElevationD9Ej5fM;
                    dialogProperties3 = dialogProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, interfaceC0526Fp, modifier4, interfaceC0526Fp14, interfaceC0526Fp12, interfaceC0526Fp15, interfaceC0526Fp16, shape5, j9, j10, j11, j12, f2, dialogProperties3, i, i2, i3));
            }
            i14 |= 3072;
            if ((i13 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i7 != 0) {
                        interfaceC0526Fp7 = null;
                    }
                    if (i9 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & 128) != 0) {
                        shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i13 &= -29360129;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i13 &= -1879048193;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i14 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i14 &= -113;
                    } else {
                        textContentColor = j4;
                    }
                    if (i15 != 0) {
                        fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                    } else {
                        fM1324getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp17;
                    interfaceC0526Fp11 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j5 = textContentColor;
                    modifier3 = modifier2;
                    j6 = containerColor;
                    j7 = titleContentColor;
                    i18 = i13;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    j8 = iconContentColor;
                } else {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i7 != 0) {
                        interfaceC0526Fp7 = null;
                    }
                    if (i9 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & 128) != 0) {
                        shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i13 &= -29360129;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i13 &= -1879048193;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i14 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i14 &= -113;
                    } else {
                        textContentColor = j4;
                    }
                    if (i15 != 0) {
                        fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                    } else {
                        fM1324getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp17;
                    interfaceC0526Fp11 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j5 = textContentColor;
                    modifier3 = modifier2;
                    j6 = containerColor;
                    j7 = titleContentColor;
                    i18 = i13;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    j8 = iconContentColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                }
                Modifier modifier1110 = modifier3;
                int i2111116 = i14;
                int i2111117 = i18;
                composer2 = composerStartRestartGroup;
                AlertDialog(interfaceC3588op, modifier1110, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i2111117, i2111116, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i2111117 & 14) | 3072 | ((i2111117 >> 3) & 112) | ((i2111116 >> 3) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier1110;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp13;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                shape5 = shape4;
                j9 = j6;
                j10 = j8;
                j11 = j7;
                j12 = j5;
                f2 = fM1324getTonalElevationD9Ej5fM;
                dialogProperties3 = dialogProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i7 != 0) {
                        interfaceC0526Fp7 = null;
                    }
                    if (i9 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & 128) != 0) {
                        shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i13 &= -29360129;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i13 &= -1879048193;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i14 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i14 &= -113;
                    } else {
                        textContentColor = j4;
                    }
                    if (i15 != 0) {
                        fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                    } else {
                        fM1324getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp17;
                    interfaceC0526Fp11 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j5 = textContentColor;
                    modifier3 = modifier2;
                    j6 = containerColor;
                    j7 = titleContentColor;
                    i18 = i13;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    j8 = iconContentColor;
                } else {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i7 != 0) {
                        interfaceC0526Fp7 = null;
                    }
                    if (i9 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & 128) != 0) {
                        shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i13 &= -29360129;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i13 &= -1879048193;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i14 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i14 &= -113;
                    } else {
                        textContentColor = j4;
                    }
                    if (i15 != 0) {
                        fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                    } else {
                        fM1324getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp17;
                    interfaceC0526Fp11 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j5 = textContentColor;
                    modifier3 = modifier2;
                    j6 = containerColor;
                    j7 = titleContentColor;
                    i18 = i13;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    j8 = iconContentColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                }
                Modifier modifier1111 = modifier3;
                int i2111118 = i14;
                int i2111119 = i18;
                composer2 = composerStartRestartGroup;
                AlertDialog(interfaceC3588op, modifier1111, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i2111119, i2111118, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i2111119 & 14) | 3072 | ((i2111119 >> 3) & 112) | ((i2111118 >> 3) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier1111;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp13;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                shape5 = shape4;
                j9 = j6;
                j10 = j8;
                j11 = j7;
                j12 = j5;
                f2 = fM1324getTonalElevationD9Ej5fM;
                dialogProperties3 = dialogProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, interfaceC0526Fp, modifier4, interfaceC0526Fp14, interfaceC0526Fp12, interfaceC0526Fp15, interfaceC0526Fp16, shape5, j9, j10, j11, j12, f2, dialogProperties3, i, i2, i3));
        }
        i14 |= 384;
        i17 = i3 & 8192;
        if (i17 != 0) {
            if ((i2 & 7168) == 0) {
                i14 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
            }
            if ((i13 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i7 != 0) {
                        interfaceC0526Fp7 = null;
                    }
                    if (i9 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & 128) != 0) {
                        shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i13 &= -29360129;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i13 &= -1879048193;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i14 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i14 &= -113;
                    } else {
                        textContentColor = j4;
                    }
                    if (i15 != 0) {
                        fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                    } else {
                        fM1324getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp17;
                    interfaceC0526Fp11 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j5 = textContentColor;
                    modifier3 = modifier2;
                    j6 = containerColor;
                    j7 = titleContentColor;
                    i18 = i13;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    j8 = iconContentColor;
                } else {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i7 != 0) {
                        interfaceC0526Fp7 = null;
                    }
                    if (i9 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & 128) != 0) {
                        shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i13 &= -29360129;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i13 &= -1879048193;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i14 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i14 &= -113;
                    } else {
                        textContentColor = j4;
                    }
                    if (i15 != 0) {
                        fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                    } else {
                        fM1324getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp17;
                    interfaceC0526Fp11 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j5 = textContentColor;
                    modifier3 = modifier2;
                    j6 = containerColor;
                    j7 = titleContentColor;
                    i18 = i13;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    j8 = iconContentColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                }
                Modifier modifier1112 = modifier3;
                int i21111110 = i14;
                int i21111111 = i18;
                composer2 = composerStartRestartGroup;
                AlertDialog(interfaceC3588op, modifier1112, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i21111111, i21111110, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i21111111 & 14) | 3072 | ((i21111111 >> 3) & 112) | ((i21111110 >> 3) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier1112;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp13;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                shape5 = shape4;
                j9 = j6;
                j10 = j8;
                j11 = j7;
                j12 = j5;
                f2 = fM1324getTonalElevationD9Ej5fM;
                dialogProperties3 = dialogProperties2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i7 != 0) {
                        interfaceC0526Fp7 = null;
                    }
                    if (i9 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & 128) != 0) {
                        shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i13 &= -29360129;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i13 &= -1879048193;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i14 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i14 &= -113;
                    } else {
                        textContentColor = j4;
                    }
                    if (i15 != 0) {
                        fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                    } else {
                        fM1324getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp17;
                    interfaceC0526Fp11 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j5 = textContentColor;
                    modifier3 = modifier2;
                    j6 = containerColor;
                    j7 = titleContentColor;
                    i18 = i13;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    j8 = iconContentColor;
                } else {
                    if (i22 != 0) {
                        modifier2 = Modifier.Companion;
                    }
                    if (i5 != 0) {
                        interfaceC0526Fp6 = null;
                    }
                    if (i7 != 0) {
                        interfaceC0526Fp7 = null;
                    }
                    if (i9 != 0) {
                        interfaceC0526Fp8 = null;
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & 128) != 0) {
                        shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i13 &= -29360129;
                    } else {
                        shape3 = shape2;
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i13 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i13 &= -1879048193;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i14 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i14 &= -113;
                    } else {
                        textContentColor = j4;
                    }
                    if (i15 != 0) {
                        fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                    } else {
                        fM1324getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                    } else {
                        dialogProperties2 = dialogProperties;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp17;
                    interfaceC0526Fp11 = interfaceC0526Fp6;
                    shape4 = shape3;
                    j5 = textContentColor;
                    modifier3 = modifier2;
                    j6 = containerColor;
                    j7 = titleContentColor;
                    i18 = i13;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                    interfaceC0526Fp13 = interfaceC0526Fp8;
                    j8 = iconContentColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
                }
                Modifier modifier1113 = modifier3;
                int i21111112 = i14;
                int i21111113 = i18;
                composer2 = composerStartRestartGroup;
                AlertDialog(interfaceC3588op, modifier1113, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i21111113, i21111112, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i21111113 & 14) | 3072 | ((i21111113 >> 3) & 112) | ((i21111112 >> 3) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier1113;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp13;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                shape5 = shape4;
                j9 = j6;
                j10 = j8;
                j11 = j7;
                j12 = j5;
                f2 = fM1324getTonalElevationD9Ej5fM;
                dialogProperties3 = dialogProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, interfaceC0526Fp, modifier4, interfaceC0526Fp14, interfaceC0526Fp12, interfaceC0526Fp15, interfaceC0526Fp16, shape5, j9, j10, j11, j12, f2, dialogProperties3, i, i2, i3));
        }
        i14 |= 3072;
        if ((i13 & 1533916891) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i22 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i5 != 0) {
                    interfaceC0526Fp6 = null;
                }
                if (i7 != 0) {
                    interfaceC0526Fp7 = null;
                }
                if (i9 != 0) {
                    interfaceC0526Fp8 = null;
                }
                if (i11 == 0) {
                }
                if ((i3 & 128) != 0) {
                    shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i13 &= -29360129;
                } else {
                    shape3 = shape2;
                }
                if ((i3 & 256) != 0) {
                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i13 &= -234881025;
                } else {
                    containerColor = j;
                }
                if ((i3 & 512) != 0) {
                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                    i13 &= -1879048193;
                } else {
                    iconContentColor = j2;
                }
                if ((i3 & 1024) != 0) {
                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                    i14 &= -15;
                } else {
                    titleContentColor = j3;
                }
                if ((i3 & 2048) != 0) {
                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                    i14 &= -113;
                } else {
                    textContentColor = j4;
                }
                if (i15 != 0) {
                    fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                } else {
                    fM1324getTonalElevationD9Ej5fM = f;
                }
                if (i17 != 0) {
                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                } else {
                    dialogProperties2 = dialogProperties;
                }
                interfaceC0526Fp10 = interfaceC0526Fp17;
                interfaceC0526Fp11 = interfaceC0526Fp6;
                shape4 = shape3;
                j5 = textContentColor;
                modifier3 = modifier2;
                j6 = containerColor;
                j7 = titleContentColor;
                i18 = i13;
                interfaceC0526Fp12 = interfaceC0526Fp7;
                interfaceC0526Fp13 = interfaceC0526Fp8;
                j8 = iconContentColor;
            } else {
                if (i22 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i5 != 0) {
                    interfaceC0526Fp6 = null;
                }
                if (i7 != 0) {
                    interfaceC0526Fp7 = null;
                }
                if (i9 != 0) {
                    interfaceC0526Fp8 = null;
                }
                if (i11 == 0) {
                }
                if ((i3 & 128) != 0) {
                    shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i13 &= -29360129;
                } else {
                    shape3 = shape2;
                }
                if ((i3 & 256) != 0) {
                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i13 &= -234881025;
                } else {
                    containerColor = j;
                }
                if ((i3 & 512) != 0) {
                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                    i13 &= -1879048193;
                } else {
                    iconContentColor = j2;
                }
                if ((i3 & 1024) != 0) {
                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                    i14 &= -15;
                } else {
                    titleContentColor = j3;
                }
                if ((i3 & 2048) != 0) {
                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                    i14 &= -113;
                } else {
                    textContentColor = j4;
                }
                if (i15 != 0) {
                    fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                } else {
                    fM1324getTonalElevationD9Ej5fM = f;
                }
                if (i17 != 0) {
                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                } else {
                    dialogProperties2 = dialogProperties;
                }
                interfaceC0526Fp10 = interfaceC0526Fp17;
                interfaceC0526Fp11 = interfaceC0526Fp6;
                shape4 = shape3;
                j5 = textContentColor;
                modifier3 = modifier2;
                j6 = containerColor;
                j7 = titleContentColor;
                i18 = i13;
                interfaceC0526Fp12 = interfaceC0526Fp7;
                interfaceC0526Fp13 = interfaceC0526Fp8;
                j8 = iconContentColor;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
            }
            Modifier modifier1114 = modifier3;
            int i21111114 = i14;
            int i21111115 = i18;
            composer2 = composerStartRestartGroup;
            AlertDialog(interfaceC3588op, modifier1114, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i21111115, i21111114, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i21111115 & 14) | 3072 | ((i21111115 >> 3) & 112) | ((i21111114 >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier1114;
            interfaceC0526Fp14 = interfaceC0526Fp11;
            interfaceC0526Fp15 = interfaceC0526Fp13;
            interfaceC0526Fp16 = interfaceC0526Fp10;
            shape5 = shape4;
            j9 = j6;
            j10 = j8;
            j11 = j7;
            j12 = j5;
            f2 = fM1324getTonalElevationD9Ej5fM;
            dialogProperties3 = dialogProperties2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i22 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i5 != 0) {
                    interfaceC0526Fp6 = null;
                }
                if (i7 != 0) {
                    interfaceC0526Fp7 = null;
                }
                if (i9 != 0) {
                    interfaceC0526Fp8 = null;
                }
                if (i11 == 0) {
                }
                if ((i3 & 128) != 0) {
                    shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i13 &= -29360129;
                } else {
                    shape3 = shape2;
                }
                if ((i3 & 256) != 0) {
                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i13 &= -234881025;
                } else {
                    containerColor = j;
                }
                if ((i3 & 512) != 0) {
                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                    i13 &= -1879048193;
                } else {
                    iconContentColor = j2;
                }
                if ((i3 & 1024) != 0) {
                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                    i14 &= -15;
                } else {
                    titleContentColor = j3;
                }
                if ((i3 & 2048) != 0) {
                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                    i14 &= -113;
                } else {
                    textContentColor = j4;
                }
                if (i15 != 0) {
                    fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                } else {
                    fM1324getTonalElevationD9Ej5fM = f;
                }
                if (i17 != 0) {
                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                } else {
                    dialogProperties2 = dialogProperties;
                }
                interfaceC0526Fp10 = interfaceC0526Fp17;
                interfaceC0526Fp11 = interfaceC0526Fp6;
                shape4 = shape3;
                j5 = textContentColor;
                modifier3 = modifier2;
                j6 = containerColor;
                j7 = titleContentColor;
                i18 = i13;
                interfaceC0526Fp12 = interfaceC0526Fp7;
                interfaceC0526Fp13 = interfaceC0526Fp8;
                j8 = iconContentColor;
            } else {
                if (i22 != 0) {
                    modifier2 = Modifier.Companion;
                }
                if (i5 != 0) {
                    interfaceC0526Fp6 = null;
                }
                if (i7 != 0) {
                    interfaceC0526Fp7 = null;
                }
                if (i9 != 0) {
                    interfaceC0526Fp8 = null;
                }
                if (i11 == 0) {
                }
                if ((i3 & 128) != 0) {
                    shape3 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i13 &= -29360129;
                } else {
                    shape3 = shape2;
                }
                if ((i3 & 256) != 0) {
                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i13 &= -234881025;
                } else {
                    containerColor = j;
                }
                if ((i3 & 512) != 0) {
                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                    i13 &= -1879048193;
                } else {
                    iconContentColor = j2;
                }
                if ((i3 & 1024) != 0) {
                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                    i14 &= -15;
                } else {
                    titleContentColor = j3;
                }
                if ((i3 & 2048) != 0) {
                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                    i14 &= -113;
                } else {
                    textContentColor = j4;
                }
                if (i15 != 0) {
                    fM1324getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m1324getTonalElevationD9Ej5fM();
                } else {
                    fM1324getTonalElevationD9Ej5fM = f;
                }
                if (i17 != 0) {
                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (AbstractC0419Di) null);
                } else {
                    dialogProperties2 = dialogProperties;
                }
                interfaceC0526Fp10 = interfaceC0526Fp17;
                interfaceC0526Fp11 = interfaceC0526Fp6;
                shape4 = shape3;
                j5 = textContentColor;
                modifier3 = modifier2;
                j6 = containerColor;
                j7 = titleContentColor;
                i18 = i13;
                interfaceC0526Fp12 = interfaceC0526Fp7;
                interfaceC0526Fp13 = interfaceC0526Fp8;
                j8 = iconContentColor;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2081346864, i18, i14, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:76)");
            }
            Modifier modifier1115 = modifier3;
            int i21111116 = i14;
            int i21111117 = i18;
            composer2 = composerStartRestartGroup;
            AlertDialog(interfaceC3588op, modifier1115, dialogProperties2, ComposableLambdaKt.composableLambda(composer2, 741647174, true, new AnonymousClass1(interfaceC0526Fp12, interfaceC0526Fp13, interfaceC0526Fp10, shape4, j6, fM1324getTonalElevationD9Ej5fM, j8, j7, j5, i21111117, i21111116, interfaceC0526Fp11, interfaceC0526Fp)), composer2, (i21111117 & 14) | 3072 | ((i21111117 >> 3) & 112) | ((i21111116 >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier1115;
            interfaceC0526Fp14 = interfaceC0526Fp11;
            interfaceC0526Fp15 = interfaceC0526Fp13;
            interfaceC0526Fp16 = interfaceC0526Fp10;
            shape5 = shape4;
            j9 = j6;
            j10 = j8;
            j11 = j7;
            j12 = j5;
            f2 = fM1324getTonalElevationD9Ej5fM;
            dialogProperties3 = dialogProperties2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interfaceC3588op, interfaceC0526Fp, modifier4, interfaceC0526Fp14, interfaceC0526Fp12, interfaceC0526Fp15, interfaceC0526Fp16, shape5, j9, j10, j11, j12, f2, dialogProperties3, i, i2, i3));
    }
}
