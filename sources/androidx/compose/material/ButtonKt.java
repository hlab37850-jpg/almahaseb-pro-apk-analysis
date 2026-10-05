package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ButtonKt {

    /* JADX INFO: renamed from: androidx.compose.material.ButtonKt$Button$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SemanticsPropertyReceiver) obj);
            return FW.a;
        }

        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
            SemanticsPropertiesKt.m4564setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m4550getButtono7Vup1c());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ButtonKt$Button$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ State<Color> $contentColor$delegate;
        final /* synthetic */ PaddingValues $contentPadding;

        /* JADX INFO: renamed from: androidx.compose.material.ButtonKt$Button$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ InterfaceC0552Gp $content;
            final /* synthetic */ PaddingValues $contentPadding;

            /* JADX INFO: renamed from: androidx.compose.material.ButtonKt$Button$3$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00701 extends AbstractC2233fv implements InterfaceC0526Fp {
                final /* synthetic */ int $$dirty;
                final /* synthetic */ InterfaceC0552Gp $content;
                final /* synthetic */ PaddingValues $contentPadding;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00701(PaddingValues paddingValues, InterfaceC0552Gp interfaceC0552Gp, int i) {
                    super(2);
                    this.$contentPadding = paddingValues;
                    this.$content = interfaceC0552Gp;
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
                        ComposerKt.traceEventStart(-630330208, i, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:120)");
                    }
                    Modifier.Companion companion = Modifier.Companion;
                    ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m516defaultMinSizeVpY3zN4(companion, buttonDefaults.m1021getMinWidthD9Ej5fM(), buttonDefaults.m1020getMinHeightD9Ej5fM()), this.$contentPadding);
                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                    InterfaceC0552Gp interfaceC0552Gp = this.$content;
                    int i2 = ((this.$$dirty >> 18) & 7168) | 432;
                    composer.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
                    composer.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                    InterfaceC3588op constructor = companion2.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierPadding);
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor);
                    } else {
                        composer.useNode();
                    }
                    Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    InterfaceC0526Fp setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
                    composer.startReplaceableGroup(2058660585);
                    interfaceC0552Gp.invoke(RowScopeInstance.INSTANCE, composer, Integer.valueOf(((i2 >> 6) & 112) | 6));
                    composer.endReplaceableGroup();
                    composer.endNode();
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(PaddingValues paddingValues, InterfaceC0552Gp interfaceC0552Gp, int i) {
                super(2);
                this.$contentPadding = paddingValues;
                this.$content = interfaceC0552Gp;
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
                    ComposerKt.traceEventStart(-1699085201, i, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:117)");
                }
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getButton(), ComposableLambdaKt.composableLambda(composer, -630330208, true, new C00701(this.$contentPadding, this.$content, this.$$dirty)), composer, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(State<Color> state, PaddingValues paddingValues, InterfaceC0552Gp interfaceC0552Gp, int i) {
            super(2);
            this.$contentColor$delegate = state;
            this.$contentPadding = paddingValues;
            this.$content = interfaceC0552Gp;
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
                ComposerKt.traceEventStart(7524271, i, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:116)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3034getAlphaimpl(ButtonKt.Button$lambda$1(this.$contentColor$delegate))))}, ComposableLambdaKt.composableLambda(composer, -1699085201, true, new AnonymousClass1(this.$contentPadding, this.$content, this.$$dirty)), composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ButtonKt$Button$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ BorderStroke $border;
        final /* synthetic */ ButtonColors $colors;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ ButtonElevation $elevation;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;
        final /* synthetic */ Shape $shape;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
            super(2);
            this.$onClick = interfaceC3588op;
            this.$modifier = modifier;
            this.$enabled = z;
            this.$interactionSource = mutableInteractionSource;
            this.$elevation = buttonElevation;
            this.$shape = shape;
            this.$border = borderStroke;
            this.$colors = buttonColors;
            this.$contentPadding = paddingValues;
            this.$content = interfaceC0552Gp;
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
            ButtonKt.Button(this.$onClick, this.$modifier, this.$enabled, this.$interactionSource, this.$elevation, this.$shape, this.$border, this.$colors, this.$contentPadding, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0121  */
    /* JADX WARN: Code duplicated, block: B:104:0x0125  */
    /* JADX WARN: Code duplicated, block: B:106:0x012a  */
    /* JADX WARN: Code duplicated, block: B:108:0x0130  */
    /* JADX WARN: Code duplicated, block: B:109:0x0133  */
    /* JADX WARN: Code duplicated, block: B:113:0x0140  */
    /* JADX WARN: Code duplicated, block: B:117:0x0158  */
    /* JADX WARN: Code duplicated, block: B:119:0x016a  */
    /* JADX WARN: Code duplicated, block: B:132:0x0196 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:133:0x0198  */
    /* JADX WARN: Code duplicated, block: B:134:0x019d  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:137:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:139:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:143:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:146:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:147:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:150:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:151:0x0201  */
    /* JADX WARN: Code duplicated, block: B:153:0x0205  */
    /* JADX WARN: Code duplicated, block: B:154:0x0207  */
    /* JADX WARN: Code duplicated, block: B:157:0x020d  */
    /* JADX WARN: Code duplicated, block: B:158:0x0224  */
    /* JADX WARN: Code duplicated, block: B:160:0x0228  */
    /* JADX WARN: Code duplicated, block: B:161:0x023c  */
    /* JADX WARN: Code duplicated, block: B:164:0x0253  */
    /* JADX WARN: Code duplicated, block: B:168:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:171:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:173:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:176:0x0316  */
    /* JADX WARN: Code duplicated, block: B:181:0x0330  */
    /* JADX WARN: Code duplicated, block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
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
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00df  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ee A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:88:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:93:0x0106  */
    /* JADX WARN: Code duplicated, block: B:95:0x010a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0114  */
    /* JADX WARN: Code duplicated, block: B:98:0x0117  */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v7 */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void Button(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        int i4;
        boolean z2;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        ButtonElevation buttonElevationM1016elevationR_JCAzs;
        Shape shape2;
        int i8;
        int i9;
        int i10;
        PaddingValues paddingValues2;
        int i11;
        int i12;
        int i13;
        Modifier modifier2;
        boolean z3;
        MutableInteractionSource mutableInteractionSource3;
        boolean z4;
        Shape small;
        BorderStroke borderStroke2;
        ButtonColors buttonColorsM1015buttonColorsro_MJ88;
        PaddingValues contentPadding;
        Shape shape3;
        BorderStroke borderStroke3;
        ButtonColors buttonColors2;
        ButtonElevation buttonElevation2;
        Modifier modifier3;
        boolean z5;
        MutableInteractionSource mutableInteractionSource4;
        Object objRememberedValue;
        ?? r10;
        State<Dp> stateElevation;
        float fM5160constructorimpl;
        Composer composer2;
        Shape shape4;
        BorderStroke borderStroke4;
        ButtonElevation buttonElevation3;
        ButtonColors buttonColors3;
        Modifier modifier4;
        boolean z6;
        MutableInteractionSource mutableInteractionSource5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i14;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-2116133464);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i15 = i2 & 2;
        if (i15 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((57344 & i) == 0) {
                        if ((i2 & 16) == 0) {
                            buttonElevationM1016elevationR_JCAzs = buttonElevation;
                            int i16 = composerStartRestartGroup.changed(buttonElevationM1016elevationR_JCAzs) ? 16384 : 8192;
                            i3 |= i16;
                        } else {
                            buttonElevationM1016elevationR_JCAzs = buttonElevation;
                        }
                        i3 |= i16;
                    } else {
                        buttonElevationM1016elevationR_JCAzs = buttonElevation;
                    }
                    if ((458752 & i) == 0) {
                        shape2 = shape;
                        if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape2)) {
                            i14 = 65536;
                        } else {
                            i14 = 131072;
                        }
                        i3 |= i14;
                    } else {
                        shape2 = shape;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(borderStroke)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                        if ((i & 29360128) != 0) {
                            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
                        }
                        i10 = i2 & 256;
                        if (i10 != 0) {
                            if ((i & 234881024) == 0) {
                                paddingValues2 = paddingValues;
                                if (composerStartRestartGroup.changed(paddingValues2)) {
                                    i11 = 67108864;
                                } else {
                                    i11 = 33554432;
                                }
                                i3 |= i11;
                            }
                            if ((i2 & 512) != 0) {
                                i3 |= 805306368;
                            } else if ((1879048192 & i) == 0) {
                                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                    i12 = PropertyOptions.DELETE_EXISTING;
                                } else {
                                    i12 = 268435456;
                                }
                                i3 |= i12;
                            }
                            i13 = i3;
                            if ((1533916891 & i13) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i15 != 0) {
                                        modifier2 = Modifier.Companion;
                                    } else {
                                        modifier2 = modifier;
                                    }
                                    if (i4 != 0) {
                                        z3 = true;
                                    } else {
                                        z3 = z2;
                                    }
                                    if (i6 != 0) {
                                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        composerStartRestartGroup.endReplaceableGroup();
                                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                    }
                                    if ((i2 & 16) != 0) {
                                        z4 = true;
                                        i13 &= -57345;
                                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                    } else {
                                        z4 = true;
                                    }
                                    if ((i2 & 32) != 0) {
                                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                        i13 &= -458753;
                                    } else {
                                        small = shape;
                                    }
                                    if (i8 != 0) {
                                        borderStroke2 = null;
                                    } else {
                                        borderStroke2 = borderStroke;
                                    }
                                    if ((i2 & 128) != 0) {
                                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                        i13 &= -29360129;
                                    } else {
                                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                    }
                                    if (i10 != 0) {
                                        shape3 = small;
                                        borderStroke3 = borderStroke2;
                                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                        modifier3 = modifier2;
                                        z5 = z3;
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                        r10 = z4;
                                    } else {
                                        contentPadding = paddingValues;
                                        shape3 = small;
                                        borderStroke3 = borderStroke2;
                                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                        modifier3 = modifier2;
                                        z5 = z3;
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                        r10 = z4;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 16) != 0) {
                                        i13 &= -57345;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i13 &= -458753;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i13 &= -29360129;
                                    }
                                    modifier3 = modifier;
                                    borderStroke3 = borderStroke;
                                    buttonColors2 = buttonColors;
                                    mutableInteractionSource4 = mutableInteractionSource2;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    shape3 = shape2;
                                    r10 = 1;
                                    z5 = z2;
                                    contentPadding = paddingValues;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                                }
                                int i17 = i13 >> 6;
                                int i18 = (i17 & 14) | ((i13 >> 18) & 112);
                                State<Color> stateContentColor = buttonColors2.contentColor(z5, composerStartRestartGroup, i18);
                                Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                                long jM3042unboximpl = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i18).getValue().m3042unboximpl();
                                long jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                composerStartRestartGroup.startReplaceableGroup(-423487112);
                                stateElevation = buttonElevation2 != null ? buttonElevation2.elevation(z5, mutableInteractionSource4, composerStartRestartGroup, i17 & 1022) : null;
                                composerStartRestartGroup.endReplaceableGroup();
                                if (stateElevation != null) {
                                    fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                                } else {
                                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                                }
                                ButtonColors buttonColors4 = buttonColors2;
                                PaddingValues paddingValues3 = contentPadding;
                                MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                ButtonElevation buttonElevation4 = buttonElevation2;
                                boolean z7 = z5;
                                Modifier modifier5 = modifier3;
                                composer2 = composerStartRestartGroup;
                                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default, z5, shape3, jM3042unboximpl, jM3031copywmQWz5c$default, borderStroke3, fM5160constructorimpl, mutableInteractionSource6, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor, contentPadding, interfaceC0552Gp, i13)), composer2, (i17 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                shape4 = shape3;
                                borderStroke4 = borderStroke3;
                                buttonElevation3 = buttonElevation4;
                                buttonColors3 = buttonColors4;
                                paddingValues2 = paddingValues3;
                                modifier4 = modifier5;
                                z6 = z7;
                                mutableInteractionSource5 = mutableInteractionSource6;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier4 = modifier;
                                z6 = z2;
                                mutableInteractionSource5 = mutableInteractionSource2;
                                buttonElevation3 = buttonElevationM1016elevationR_JCAzs;
                                shape4 = shape2;
                                composer2 = composerStartRestartGroup;
                                borderStroke4 = borderStroke;
                                buttonColors3 = buttonColors;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
                        }
                        i3 |= 100663296;
                        paddingValues2 = paddingValues;
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i12 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i12 = 268435456;
                            }
                            i3 |= i12;
                        }
                        i13 = i3;
                        if ((1533916891 & i13) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                            }
                            int i19 = i13 >> 6;
                            int i110 = (i19 & 14) | ((i13 >> 18) & 112);
                            State<Color> stateContentColor2 = buttonColors2.contentColor(z5, composerStartRestartGroup, i110);
                            Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                            long jM3042unboximpl2 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i110).getValue().m3042unboximpl();
                            long jM3031copywmQWz5c$default2 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor2), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            composerStartRestartGroup.startReplaceableGroup(-423487112);
                            if (buttonElevation2 != null) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            if (stateElevation != null) {
                                fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                            } else {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            }
                            ButtonColors buttonColors5 = buttonColors2;
                            PaddingValues paddingValues4 = contentPadding;
                            MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource4;
                            ButtonElevation buttonElevation5 = buttonElevation2;
                            boolean z8 = z5;
                            Modifier modifier6 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default2, z5, shape3, jM3042unboximpl2, jM3031copywmQWz5c$default2, borderStroke3, fM5160constructorimpl, mutableInteractionSource7, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor2, contentPadding, interfaceC0552Gp, i13)), composer2, (i19 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            buttonElevation3 = buttonElevation5;
                            buttonColors3 = buttonColors5;
                            paddingValues2 = paddingValues4;
                            modifier4 = modifier6;
                            z6 = z8;
                            mutableInteractionSource5 = mutableInteractionSource7;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                            }
                            int i111 = i13 >> 6;
                            int i112 = (i111 & 14) | ((i13 >> 18) & 112);
                            State<Color> stateContentColor3 = buttonColors2.contentColor(z5, composerStartRestartGroup, i112);
                            Modifier modifierSemantics$default3 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                            long jM3042unboximpl3 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i112).getValue().m3042unboximpl();
                            long jM3031copywmQWz5c$default3 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor3), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            composerStartRestartGroup.startReplaceableGroup(-423487112);
                            if (buttonElevation2 != null) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            if (stateElevation != null) {
                                fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                            } else {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            }
                            ButtonColors buttonColors6 = buttonColors2;
                            PaddingValues paddingValues5 = contentPadding;
                            MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource4;
                            ButtonElevation buttonElevation6 = buttonElevation2;
                            boolean z9 = z5;
                            Modifier modifier7 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default3, z5, shape3, jM3042unboximpl3, jM3031copywmQWz5c$default3, borderStroke3, fM5160constructorimpl, mutableInteractionSource8, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor3, contentPadding, interfaceC0552Gp, i13)), composer2, (i111 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            buttonElevation3 = buttonElevation6;
                            buttonColors3 = buttonColors6;
                            paddingValues2 = paddingValues5;
                            modifier4 = modifier7;
                            z6 = z9;
                            mutableInteractionSource5 = mutableInteractionSource8;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
                    }
                    i3 |= 1572864;
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        if ((i & 234881024) == 0) {
                            paddingValues2 = paddingValues;
                            if (composerStartRestartGroup.changed(paddingValues2)) {
                                i11 = 67108864;
                            } else {
                                i11 = 33554432;
                            }
                            i3 |= i11;
                        }
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i12 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i12 = 268435456;
                            }
                            i3 |= i12;
                        }
                        i13 = i3;
                        if ((1533916891 & i13) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                            }
                            int i113 = i13 >> 6;
                            int i114 = (i113 & 14) | ((i13 >> 18) & 112);
                            State<Color> stateContentColor4 = buttonColors2.contentColor(z5, composerStartRestartGroup, i114);
                            Modifier modifierSemantics$default4 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                            long jM3042unboximpl4 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i114).getValue().m3042unboximpl();
                            long jM3031copywmQWz5c$default4 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor4), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            composerStartRestartGroup.startReplaceableGroup(-423487112);
                            if (buttonElevation2 != null) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            if (stateElevation != null) {
                                fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                            } else {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            }
                            ButtonColors buttonColors7 = buttonColors2;
                            PaddingValues paddingValues6 = contentPadding;
                            MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource4;
                            ButtonElevation buttonElevation7 = buttonElevation2;
                            boolean z10 = z5;
                            Modifier modifier8 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default4, z5, shape3, jM3042unboximpl4, jM3031copywmQWz5c$default4, borderStroke3, fM5160constructorimpl, mutableInteractionSource9, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor4, contentPadding, interfaceC0552Gp, i13)), composer2, (i113 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            buttonElevation3 = buttonElevation7;
                            buttonColors3 = buttonColors7;
                            paddingValues2 = paddingValues6;
                            modifier4 = modifier8;
                            z6 = z10;
                            mutableInteractionSource5 = mutableInteractionSource9;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                            }
                            int i115 = i13 >> 6;
                            int i116 = (i115 & 14) | ((i13 >> 18) & 112);
                            State<Color> stateContentColor5 = buttonColors2.contentColor(z5, composerStartRestartGroup, i116);
                            Modifier modifierSemantics$default5 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                            long jM3042unboximpl5 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i116).getValue().m3042unboximpl();
                            long jM3031copywmQWz5c$default5 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor5), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            composerStartRestartGroup.startReplaceableGroup(-423487112);
                            if (buttonElevation2 != null) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            if (stateElevation != null) {
                                fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                            } else {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            }
                            ButtonColors buttonColors8 = buttonColors2;
                            PaddingValues paddingValues7 = contentPadding;
                            MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource4;
                            ButtonElevation buttonElevation8 = buttonElevation2;
                            boolean z11 = z5;
                            Modifier modifier9 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default5, z5, shape3, jM3042unboximpl5, jM3031copywmQWz5c$default5, borderStroke3, fM5160constructorimpl, mutableInteractionSource10, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor5, contentPadding, interfaceC0552Gp, i13)), composer2, (i115 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            buttonElevation3 = buttonElevation8;
                            buttonColors3 = buttonColors8;
                            paddingValues2 = paddingValues7;
                            modifier4 = modifier9;
                            z6 = z11;
                            mutableInteractionSource5 = mutableInteractionSource10;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
                    }
                    i3 |= 100663296;
                    paddingValues2 = paddingValues;
                    if ((i2 & 512) != 0) {
                        i3 |= 805306368;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                        i3 |= i12;
                    }
                    i13 = i3;
                    if ((1533916891 & i13) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i117 = i13 >> 6;
                        int i118 = (i117 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor6 = buttonColors2.contentColor(z5, composerStartRestartGroup, i118);
                        Modifier modifierSemantics$default6 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl6 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i118).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default6 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor6), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors9 = buttonColors2;
                        PaddingValues paddingValues8 = contentPadding;
                        MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource4;
                        ButtonElevation buttonElevation9 = buttonElevation2;
                        boolean z12 = z5;
                        Modifier modifier10 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default6, z5, shape3, jM3042unboximpl6, jM3031copywmQWz5c$default6, borderStroke3, fM5160constructorimpl, mutableInteractionSource11, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor6, contentPadding, interfaceC0552Gp, i13)), composer2, (i117 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation9;
                        buttonColors3 = buttonColors9;
                        paddingValues2 = paddingValues8;
                        modifier4 = modifier10;
                        z6 = z12;
                        mutableInteractionSource5 = mutableInteractionSource11;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i119 = i13 >> 6;
                        int i1110 = (i119 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor7 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1110);
                        Modifier modifierSemantics$default7 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl7 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1110).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default7 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor7), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors10 = buttonColors2;
                        PaddingValues paddingValues9 = contentPadding;
                        MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource4;
                        ButtonElevation buttonElevation10 = buttonElevation2;
                        boolean z13 = z5;
                        Modifier modifier11 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default7, z5, shape3, jM3042unboximpl7, jM3031copywmQWz5c$default7, borderStroke3, fM5160constructorimpl, mutableInteractionSource12, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor7, contentPadding, interfaceC0552Gp, i13)), composer2, (i119 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation10;
                        buttonColors3 = buttonColors10;
                        paddingValues2 = paddingValues9;
                        modifier4 = modifier11;
                        z6 = z13;
                        mutableInteractionSource5 = mutableInteractionSource12;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
                }
                i3 |= 3072;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonElevationM1016elevationR_JCAzs = buttonElevation;
                        if (composerStartRestartGroup.changed(buttonElevationM1016elevationR_JCAzs)) {
                        }
                        i3 |= i16;
                    } else {
                        buttonElevationM1016elevationR_JCAzs = buttonElevation;
                    }
                    i3 |= i16;
                } else {
                    buttonElevationM1016elevationR_JCAzs = buttonElevation;
                }
                if ((458752 & i) == 0) {
                    shape2 = shape;
                    if ((i2 & 32) == 0) {
                        i14 = 65536;
                    } else {
                        i14 = 65536;
                    }
                    i3 |= i14;
                } else {
                    shape2 = shape;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        if ((i & 234881024) == 0) {
                            paddingValues2 = paddingValues;
                            if (composerStartRestartGroup.changed(paddingValues2)) {
                                i11 = 67108864;
                            } else {
                                i11 = 33554432;
                            }
                            i3 |= i11;
                        }
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i12 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i12 = 268435456;
                            }
                            i3 |= i12;
                        }
                        i13 = i3;
                        if ((1533916891 & i13) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                            }
                            int i1111 = i13 >> 6;
                            int i1112 = (i1111 & 14) | ((i13 >> 18) & 112);
                            State<Color> stateContentColor8 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1112);
                            Modifier modifierSemantics$default8 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                            long jM3042unboximpl8 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1112).getValue().m3042unboximpl();
                            long jM3031copywmQWz5c$default8 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor8), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            composerStartRestartGroup.startReplaceableGroup(-423487112);
                            if (buttonElevation2 != null) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            if (stateElevation != null) {
                                fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                            } else {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            }
                            ButtonColors buttonColors11 = buttonColors2;
                            PaddingValues paddingValues10 = contentPadding;
                            MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource4;
                            ButtonElevation buttonElevation11 = buttonElevation2;
                            boolean z14 = z5;
                            Modifier modifier12 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default8, z5, shape3, jM3042unboximpl8, jM3031copywmQWz5c$default8, borderStroke3, fM5160constructorimpl, mutableInteractionSource13, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor8, contentPadding, interfaceC0552Gp, i13)), composer2, (i1111 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            buttonElevation3 = buttonElevation11;
                            buttonColors3 = buttonColors11;
                            paddingValues2 = paddingValues10;
                            modifier4 = modifier12;
                            z6 = z14;
                            mutableInteractionSource5 = mutableInteractionSource13;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                            }
                            int i1113 = i13 >> 6;
                            int i1114 = (i1113 & 14) | ((i13 >> 18) & 112);
                            State<Color> stateContentColor9 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1114);
                            Modifier modifierSemantics$default9 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                            long jM3042unboximpl9 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1114).getValue().m3042unboximpl();
                            long jM3031copywmQWz5c$default9 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor9), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            composerStartRestartGroup.startReplaceableGroup(-423487112);
                            if (buttonElevation2 != null) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            if (stateElevation != null) {
                                fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                            } else {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            }
                            ButtonColors buttonColors12 = buttonColors2;
                            PaddingValues paddingValues11 = contentPadding;
                            MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource4;
                            ButtonElevation buttonElevation12 = buttonElevation2;
                            boolean z15 = z5;
                            Modifier modifier13 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default9, z5, shape3, jM3042unboximpl9, jM3031copywmQWz5c$default9, borderStroke3, fM5160constructorimpl, mutableInteractionSource14, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor9, contentPadding, interfaceC0552Gp, i13)), composer2, (i1113 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            buttonElevation3 = buttonElevation12;
                            buttonColors3 = buttonColors12;
                            paddingValues2 = paddingValues11;
                            modifier4 = modifier13;
                            z6 = z15;
                            mutableInteractionSource5 = mutableInteractionSource14;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
                    }
                    i3 |= 100663296;
                    paddingValues2 = paddingValues;
                    if ((i2 & 512) != 0) {
                        i3 |= 805306368;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                        i3 |= i12;
                    }
                    i13 = i3;
                    if ((1533916891 & i13) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i1115 = i13 >> 6;
                        int i1116 = (i1115 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor10 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1116);
                        Modifier modifierSemantics$default10 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl10 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1116).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default10 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor10), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors13 = buttonColors2;
                        PaddingValues paddingValues12 = contentPadding;
                        MutableInteractionSource mutableInteractionSource15 = mutableInteractionSource4;
                        ButtonElevation buttonElevation13 = buttonElevation2;
                        boolean z16 = z5;
                        Modifier modifier14 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default10, z5, shape3, jM3042unboximpl10, jM3031copywmQWz5c$default10, borderStroke3, fM5160constructorimpl, mutableInteractionSource15, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor10, contentPadding, interfaceC0552Gp, i13)), composer2, (i1115 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation13;
                        buttonColors3 = buttonColors13;
                        paddingValues2 = paddingValues12;
                        modifier4 = modifier14;
                        z6 = z16;
                        mutableInteractionSource5 = mutableInteractionSource15;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i1117 = i13 >> 6;
                        int i1118 = (i1117 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor11 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1118);
                        Modifier modifierSemantics$default11 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl11 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1118).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default11 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor11), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors14 = buttonColors2;
                        PaddingValues paddingValues13 = contentPadding;
                        MutableInteractionSource mutableInteractionSource16 = mutableInteractionSource4;
                        ButtonElevation buttonElevation14 = buttonElevation2;
                        boolean z17 = z5;
                        Modifier modifier15 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default11, z5, shape3, jM3042unboximpl11, jM3031copywmQWz5c$default11, borderStroke3, fM5160constructorimpl, mutableInteractionSource16, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor11, contentPadding, interfaceC0552Gp, i13)), composer2, (i1117 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation14;
                        buttonColors3 = buttonColors14;
                        paddingValues2 = paddingValues13;
                        modifier4 = modifier15;
                        z6 = z17;
                        mutableInteractionSource5 = mutableInteractionSource16;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
                }
                i3 |= 1572864;
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 234881024) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 512) != 0) {
                        i3 |= 805306368;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                        i3 |= i12;
                    }
                    i13 = i3;
                    if ((1533916891 & i13) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i1119 = i13 >> 6;
                        int i11110 = (i1119 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor12 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11110);
                        Modifier modifierSemantics$default12 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl12 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11110).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default12 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor12), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors15 = buttonColors2;
                        PaddingValues paddingValues14 = contentPadding;
                        MutableInteractionSource mutableInteractionSource17 = mutableInteractionSource4;
                        ButtonElevation buttonElevation15 = buttonElevation2;
                        boolean z18 = z5;
                        Modifier modifier16 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default12, z5, shape3, jM3042unboximpl12, jM3031copywmQWz5c$default12, borderStroke3, fM5160constructorimpl, mutableInteractionSource17, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor12, contentPadding, interfaceC0552Gp, i13)), composer2, (i1119 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation15;
                        buttonColors3 = buttonColors15;
                        paddingValues2 = paddingValues14;
                        modifier4 = modifier16;
                        z6 = z18;
                        mutableInteractionSource5 = mutableInteractionSource17;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i11111 = i13 >> 6;
                        int i11112 = (i11111 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor13 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11112);
                        Modifier modifierSemantics$default13 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl13 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11112).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default13 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor13), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors16 = buttonColors2;
                        PaddingValues paddingValues15 = contentPadding;
                        MutableInteractionSource mutableInteractionSource18 = mutableInteractionSource4;
                        ButtonElevation buttonElevation16 = buttonElevation2;
                        boolean z19 = z5;
                        Modifier modifier17 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default13, z5, shape3, jM3042unboximpl13, jM3031copywmQWz5c$default13, borderStroke3, fM5160constructorimpl, mutableInteractionSource18, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor13, contentPadding, interfaceC0552Gp, i13)), composer2, (i11111 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation16;
                        buttonColors3 = buttonColors16;
                        paddingValues2 = paddingValues15;
                        modifier4 = modifier17;
                        z6 = z19;
                        mutableInteractionSource5 = mutableInteractionSource18;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
                }
                i3 |= 100663296;
                paddingValues2 = paddingValues;
                if ((i2 & 512) != 0) {
                    i3 |= 805306368;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                i13 = i3;
                if ((1533916891 & i13) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i11113 = i13 >> 6;
                    int i11114 = (i11113 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor14 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11114);
                    Modifier modifierSemantics$default14 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl14 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11114).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default14 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor14), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors17 = buttonColors2;
                    PaddingValues paddingValues16 = contentPadding;
                    MutableInteractionSource mutableInteractionSource19 = mutableInteractionSource4;
                    ButtonElevation buttonElevation17 = buttonElevation2;
                    boolean z110 = z5;
                    Modifier modifier18 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default14, z5, shape3, jM3042unboximpl14, jM3031copywmQWz5c$default14, borderStroke3, fM5160constructorimpl, mutableInteractionSource19, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor14, contentPadding, interfaceC0552Gp, i13)), composer2, (i11113 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation17;
                    buttonColors3 = buttonColors17;
                    paddingValues2 = paddingValues16;
                    modifier4 = modifier18;
                    z6 = z110;
                    mutableInteractionSource5 = mutableInteractionSource19;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i11115 = i13 >> 6;
                    int i11116 = (i11115 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor15 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11116);
                    Modifier modifierSemantics$default15 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl15 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11116).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default15 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor15), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors18 = buttonColors2;
                    PaddingValues paddingValues17 = contentPadding;
                    MutableInteractionSource mutableInteractionSource110 = mutableInteractionSource4;
                    ButtonElevation buttonElevation18 = buttonElevation2;
                    boolean z111 = z5;
                    Modifier modifier19 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default15, z5, shape3, jM3042unboximpl15, jM3031copywmQWz5c$default15, borderStroke3, fM5160constructorimpl, mutableInteractionSource110, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor15, contentPadding, interfaceC0552Gp, i13)), composer2, (i11115 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation18;
                    buttonColors3 = buttonColors18;
                    paddingValues2 = paddingValues17;
                    modifier4 = modifier19;
                    z6 = z111;
                    mutableInteractionSource5 = mutableInteractionSource110;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
            }
            i3 |= 384;
            z2 = z;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonElevationM1016elevationR_JCAzs = buttonElevation;
                        if (composerStartRestartGroup.changed(buttonElevationM1016elevationR_JCAzs)) {
                        }
                        i3 |= i16;
                    } else {
                        buttonElevationM1016elevationR_JCAzs = buttonElevation;
                    }
                    i3 |= i16;
                } else {
                    buttonElevationM1016elevationR_JCAzs = buttonElevation;
                }
                if ((458752 & i) == 0) {
                    shape2 = shape;
                    if ((i2 & 32) == 0) {
                        i14 = 65536;
                    } else {
                        i14 = 65536;
                    }
                    i3 |= i14;
                } else {
                    shape2 = shape;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        if ((i & 234881024) == 0) {
                            paddingValues2 = paddingValues;
                            if (composerStartRestartGroup.changed(paddingValues2)) {
                                i11 = 67108864;
                            } else {
                                i11 = 33554432;
                            }
                            i3 |= i11;
                        }
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i12 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i12 = 268435456;
                            }
                            i3 |= i12;
                        }
                        i13 = i3;
                        if ((1533916891 & i13) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                            }
                            int i11117 = i13 >> 6;
                            int i11118 = (i11117 & 14) | ((i13 >> 18) & 112);
                            State<Color> stateContentColor16 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11118);
                            Modifier modifierSemantics$default16 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                            long jM3042unboximpl16 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11118).getValue().m3042unboximpl();
                            long jM3031copywmQWz5c$default16 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor16), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            composerStartRestartGroup.startReplaceableGroup(-423487112);
                            if (buttonElevation2 != null) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            if (stateElevation != null) {
                                fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                            } else {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            }
                            ButtonColors buttonColors19 = buttonColors2;
                            PaddingValues paddingValues18 = contentPadding;
                            MutableInteractionSource mutableInteractionSource111 = mutableInteractionSource4;
                            ButtonElevation buttonElevation19 = buttonElevation2;
                            boolean z112 = z5;
                            Modifier modifier110 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default16, z5, shape3, jM3042unboximpl16, jM3031copywmQWz5c$default16, borderStroke3, fM5160constructorimpl, mutableInteractionSource111, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor16, contentPadding, interfaceC0552Gp, i13)), composer2, (i11117 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            buttonElevation3 = buttonElevation19;
                            buttonColors3 = buttonColors19;
                            paddingValues2 = paddingValues18;
                            modifier4 = modifier110;
                            z6 = z112;
                            mutableInteractionSource5 = mutableInteractionSource111;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                            }
                            int i11119 = i13 >> 6;
                            int i111110 = (i11119 & 14) | ((i13 >> 18) & 112);
                            State<Color> stateContentColor17 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111110);
                            Modifier modifierSemantics$default17 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                            long jM3042unboximpl17 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111110).getValue().m3042unboximpl();
                            long jM3031copywmQWz5c$default17 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor17), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            composerStartRestartGroup.startReplaceableGroup(-423487112);
                            if (buttonElevation2 != null) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            if (stateElevation != null) {
                                fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                            } else {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            }
                            ButtonColors buttonColors110 = buttonColors2;
                            PaddingValues paddingValues19 = contentPadding;
                            MutableInteractionSource mutableInteractionSource112 = mutableInteractionSource4;
                            ButtonElevation buttonElevation110 = buttonElevation2;
                            boolean z113 = z5;
                            Modifier modifier111 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default17, z5, shape3, jM3042unboximpl17, jM3031copywmQWz5c$default17, borderStroke3, fM5160constructorimpl, mutableInteractionSource112, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor17, contentPadding, interfaceC0552Gp, i13)), composer2, (i11119 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            buttonElevation3 = buttonElevation110;
                            buttonColors3 = buttonColors110;
                            paddingValues2 = paddingValues19;
                            modifier4 = modifier111;
                            z6 = z113;
                            mutableInteractionSource5 = mutableInteractionSource112;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
                    }
                    i3 |= 100663296;
                    paddingValues2 = paddingValues;
                    if ((i2 & 512) != 0) {
                        i3 |= 805306368;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                        i3 |= i12;
                    }
                    i13 = i3;
                    if ((1533916891 & i13) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i111111 = i13 >> 6;
                        int i111112 = (i111111 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor18 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111112);
                        Modifier modifierSemantics$default18 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl18 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111112).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default18 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor18), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors111 = buttonColors2;
                        PaddingValues paddingValues110 = contentPadding;
                        MutableInteractionSource mutableInteractionSource113 = mutableInteractionSource4;
                        ButtonElevation buttonElevation111 = buttonElevation2;
                        boolean z114 = z5;
                        Modifier modifier112 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default18, z5, shape3, jM3042unboximpl18, jM3031copywmQWz5c$default18, borderStroke3, fM5160constructorimpl, mutableInteractionSource113, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor18, contentPadding, interfaceC0552Gp, i13)), composer2, (i111111 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation111;
                        buttonColors3 = buttonColors111;
                        paddingValues2 = paddingValues110;
                        modifier4 = modifier112;
                        z6 = z114;
                        mutableInteractionSource5 = mutableInteractionSource113;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i111113 = i13 >> 6;
                        int i111114 = (i111113 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor19 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111114);
                        Modifier modifierSemantics$default19 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl19 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111114).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default19 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor19), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors112 = buttonColors2;
                        PaddingValues paddingValues111 = contentPadding;
                        MutableInteractionSource mutableInteractionSource114 = mutableInteractionSource4;
                        ButtonElevation buttonElevation112 = buttonElevation2;
                        boolean z115 = z5;
                        Modifier modifier113 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default19, z5, shape3, jM3042unboximpl19, jM3031copywmQWz5c$default19, borderStroke3, fM5160constructorimpl, mutableInteractionSource114, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor19, contentPadding, interfaceC0552Gp, i13)), composer2, (i111113 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation112;
                        buttonColors3 = buttonColors112;
                        paddingValues2 = paddingValues111;
                        modifier4 = modifier113;
                        z6 = z115;
                        mutableInteractionSource5 = mutableInteractionSource114;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
                }
                i3 |= 1572864;
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 234881024) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 512) != 0) {
                        i3 |= 805306368;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                        i3 |= i12;
                    }
                    i13 = i3;
                    if ((1533916891 & i13) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i111115 = i13 >> 6;
                        int i111116 = (i111115 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor110 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111116);
                        Modifier modifierSemantics$default110 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl110 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111116).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default110 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor110), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors113 = buttonColors2;
                        PaddingValues paddingValues112 = contentPadding;
                        MutableInteractionSource mutableInteractionSource115 = mutableInteractionSource4;
                        ButtonElevation buttonElevation113 = buttonElevation2;
                        boolean z116 = z5;
                        Modifier modifier114 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default110, z5, shape3, jM3042unboximpl110, jM3031copywmQWz5c$default110, borderStroke3, fM5160constructorimpl, mutableInteractionSource115, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor110, contentPadding, interfaceC0552Gp, i13)), composer2, (i111115 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation113;
                        buttonColors3 = buttonColors113;
                        paddingValues2 = paddingValues112;
                        modifier4 = modifier114;
                        z6 = z116;
                        mutableInteractionSource5 = mutableInteractionSource115;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i111117 = i13 >> 6;
                        int i111118 = (i111117 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor111 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111118);
                        Modifier modifierSemantics$default111 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl111 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111118).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default111 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor111), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors114 = buttonColors2;
                        PaddingValues paddingValues113 = contentPadding;
                        MutableInteractionSource mutableInteractionSource116 = mutableInteractionSource4;
                        ButtonElevation buttonElevation114 = buttonElevation2;
                        boolean z117 = z5;
                        Modifier modifier115 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default111, z5, shape3, jM3042unboximpl111, jM3031copywmQWz5c$default111, borderStroke3, fM5160constructorimpl, mutableInteractionSource116, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor111, contentPadding, interfaceC0552Gp, i13)), composer2, (i111117 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation114;
                        buttonColors3 = buttonColors114;
                        paddingValues2 = paddingValues113;
                        modifier4 = modifier115;
                        z6 = z117;
                        mutableInteractionSource5 = mutableInteractionSource116;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
                }
                i3 |= 100663296;
                paddingValues2 = paddingValues;
                if ((i2 & 512) != 0) {
                    i3 |= 805306368;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                i13 = i3;
                if ((1533916891 & i13) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i111119 = i13 >> 6;
                    int i1111110 = (i111119 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor112 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1111110);
                    Modifier modifierSemantics$default112 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl112 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1111110).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default112 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor112), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors115 = buttonColors2;
                    PaddingValues paddingValues114 = contentPadding;
                    MutableInteractionSource mutableInteractionSource117 = mutableInteractionSource4;
                    ButtonElevation buttonElevation115 = buttonElevation2;
                    boolean z118 = z5;
                    Modifier modifier116 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default112, z5, shape3, jM3042unboximpl112, jM3031copywmQWz5c$default112, borderStroke3, fM5160constructorimpl, mutableInteractionSource117, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor112, contentPadding, interfaceC0552Gp, i13)), composer2, (i111119 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation115;
                    buttonColors3 = buttonColors115;
                    paddingValues2 = paddingValues114;
                    modifier4 = modifier116;
                    z6 = z118;
                    mutableInteractionSource5 = mutableInteractionSource117;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i1111111 = i13 >> 6;
                    int i1111112 = (i1111111 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor113 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1111112);
                    Modifier modifierSemantics$default113 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl113 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1111112).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default113 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor113), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors116 = buttonColors2;
                    PaddingValues paddingValues115 = contentPadding;
                    MutableInteractionSource mutableInteractionSource118 = mutableInteractionSource4;
                    ButtonElevation buttonElevation116 = buttonElevation2;
                    boolean z119 = z5;
                    Modifier modifier117 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default113, z5, shape3, jM3042unboximpl113, jM3031copywmQWz5c$default113, borderStroke3, fM5160constructorimpl, mutableInteractionSource118, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor113, contentPadding, interfaceC0552Gp, i13)), composer2, (i1111111 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation116;
                    buttonColors3 = buttonColors116;
                    paddingValues2 = paddingValues115;
                    modifier4 = modifier117;
                    z6 = z119;
                    mutableInteractionSource5 = mutableInteractionSource118;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
            }
            i3 |= 3072;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    buttonElevationM1016elevationR_JCAzs = buttonElevation;
                    if (composerStartRestartGroup.changed(buttonElevationM1016elevationR_JCAzs)) {
                    }
                    i3 |= i16;
                } else {
                    buttonElevationM1016elevationR_JCAzs = buttonElevation;
                }
                i3 |= i16;
            } else {
                buttonElevationM1016elevationR_JCAzs = buttonElevation;
            }
            if ((458752 & i) == 0) {
                shape2 = shape;
                if ((i2 & 32) == 0) {
                    i14 = 65536;
                } else {
                    i14 = 65536;
                }
                i3 |= i14;
            } else {
                shape2 = shape;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 234881024) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 512) != 0) {
                        i3 |= 805306368;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                        i3 |= i12;
                    }
                    i13 = i3;
                    if ((1533916891 & i13) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i1111113 = i13 >> 6;
                        int i1111114 = (i1111113 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor114 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1111114);
                        Modifier modifierSemantics$default114 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl114 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1111114).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default114 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor114), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors117 = buttonColors2;
                        PaddingValues paddingValues116 = contentPadding;
                        MutableInteractionSource mutableInteractionSource119 = mutableInteractionSource4;
                        ButtonElevation buttonElevation117 = buttonElevation2;
                        boolean z1110 = z5;
                        Modifier modifier118 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default114, z5, shape3, jM3042unboximpl114, jM3031copywmQWz5c$default114, borderStroke3, fM5160constructorimpl, mutableInteractionSource119, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor114, contentPadding, interfaceC0552Gp, i13)), composer2, (i1111113 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation117;
                        buttonColors3 = buttonColors117;
                        paddingValues2 = paddingValues116;
                        modifier4 = modifier118;
                        z6 = z1110;
                        mutableInteractionSource5 = mutableInteractionSource119;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i1111115 = i13 >> 6;
                        int i1111116 = (i1111115 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor115 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1111116);
                        Modifier modifierSemantics$default115 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl115 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1111116).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default115 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor115), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors118 = buttonColors2;
                        PaddingValues paddingValues117 = contentPadding;
                        MutableInteractionSource mutableInteractionSource1110 = mutableInteractionSource4;
                        ButtonElevation buttonElevation118 = buttonElevation2;
                        boolean z1111 = z5;
                        Modifier modifier119 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default115, z5, shape3, jM3042unboximpl115, jM3031copywmQWz5c$default115, borderStroke3, fM5160constructorimpl, mutableInteractionSource1110, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor115, contentPadding, interfaceC0552Gp, i13)), composer2, (i1111115 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation118;
                        buttonColors3 = buttonColors118;
                        paddingValues2 = paddingValues117;
                        modifier4 = modifier119;
                        z6 = z1111;
                        mutableInteractionSource5 = mutableInteractionSource1110;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
                }
                i3 |= 100663296;
                paddingValues2 = paddingValues;
                if ((i2 & 512) != 0) {
                    i3 |= 805306368;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                i13 = i3;
                if ((1533916891 & i13) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i1111117 = i13 >> 6;
                    int i1111118 = (i1111117 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor116 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1111118);
                    Modifier modifierSemantics$default116 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl116 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1111118).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default116 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor116), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors119 = buttonColors2;
                    PaddingValues paddingValues118 = contentPadding;
                    MutableInteractionSource mutableInteractionSource1111 = mutableInteractionSource4;
                    ButtonElevation buttonElevation119 = buttonElevation2;
                    boolean z1112 = z5;
                    Modifier modifier1110 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default116, z5, shape3, jM3042unboximpl116, jM3031copywmQWz5c$default116, borderStroke3, fM5160constructorimpl, mutableInteractionSource1111, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor116, contentPadding, interfaceC0552Gp, i13)), composer2, (i1111117 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation119;
                    buttonColors3 = buttonColors119;
                    paddingValues2 = paddingValues118;
                    modifier4 = modifier1110;
                    z6 = z1112;
                    mutableInteractionSource5 = mutableInteractionSource1111;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i1111119 = i13 >> 6;
                    int i11111110 = (i1111119 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor117 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11111110);
                    Modifier modifierSemantics$default117 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl117 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11111110).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default117 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor117), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors1110 = buttonColors2;
                    PaddingValues paddingValues119 = contentPadding;
                    MutableInteractionSource mutableInteractionSource1112 = mutableInteractionSource4;
                    ButtonElevation buttonElevation1110 = buttonElevation2;
                    boolean z1113 = z5;
                    Modifier modifier1111 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default117, z5, shape3, jM3042unboximpl117, jM3031copywmQWz5c$default117, borderStroke3, fM5160constructorimpl, mutableInteractionSource1112, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor117, contentPadding, interfaceC0552Gp, i13)), composer2, (i1111119 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation1110;
                    buttonColors3 = buttonColors1110;
                    paddingValues2 = paddingValues119;
                    modifier4 = modifier1111;
                    z6 = z1113;
                    mutableInteractionSource5 = mutableInteractionSource1112;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
            }
            i3 |= 1572864;
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 234881024) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    i3 |= 805306368;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                i13 = i3;
                if ((1533916891 & i13) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i11111111 = i13 >> 6;
                    int i11111112 = (i11111111 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor118 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11111112);
                    Modifier modifierSemantics$default118 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl118 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11111112).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default118 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor118), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors1111 = buttonColors2;
                    PaddingValues paddingValues1110 = contentPadding;
                    MutableInteractionSource mutableInteractionSource1113 = mutableInteractionSource4;
                    ButtonElevation buttonElevation1111 = buttonElevation2;
                    boolean z1114 = z5;
                    Modifier modifier1112 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default118, z5, shape3, jM3042unboximpl118, jM3031copywmQWz5c$default118, borderStroke3, fM5160constructorimpl, mutableInteractionSource1113, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor118, contentPadding, interfaceC0552Gp, i13)), composer2, (i11111111 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation1111;
                    buttonColors3 = buttonColors1111;
                    paddingValues2 = paddingValues1110;
                    modifier4 = modifier1112;
                    z6 = z1114;
                    mutableInteractionSource5 = mutableInteractionSource1113;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i11111113 = i13 >> 6;
                    int i11111114 = (i11111113 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor119 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11111114);
                    Modifier modifierSemantics$default119 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl119 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11111114).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default119 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor119), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors1112 = buttonColors2;
                    PaddingValues paddingValues1111 = contentPadding;
                    MutableInteractionSource mutableInteractionSource1114 = mutableInteractionSource4;
                    ButtonElevation buttonElevation1112 = buttonElevation2;
                    boolean z1115 = z5;
                    Modifier modifier1113 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default119, z5, shape3, jM3042unboximpl119, jM3031copywmQWz5c$default119, borderStroke3, fM5160constructorimpl, mutableInteractionSource1114, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor119, contentPadding, interfaceC0552Gp, i13)), composer2, (i11111113 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation1112;
                    buttonColors3 = buttonColors1112;
                    paddingValues2 = paddingValues1111;
                    modifier4 = modifier1113;
                    z6 = z1115;
                    mutableInteractionSource5 = mutableInteractionSource1114;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
            }
            i3 |= 100663296;
            paddingValues2 = paddingValues;
            if ((i2 & 512) != 0) {
                i3 |= 805306368;
            } else if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i12 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i12 = 268435456;
                }
                i3 |= i12;
            }
            i13 = i3;
            if ((1533916891 & i13) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                }
                int i11111115 = i13 >> 6;
                int i11111116 = (i11111115 & 14) | ((i13 >> 18) & 112);
                State<Color> stateContentColor1110 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11111116);
                Modifier modifierSemantics$default1110 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                long jM3042unboximpl1110 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11111116).getValue().m3042unboximpl();
                long jM3031copywmQWz5c$default1110 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor1110), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.startReplaceableGroup(-423487112);
                if (buttonElevation2 != null) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (stateElevation != null) {
                    fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                ButtonColors buttonColors1113 = buttonColors2;
                PaddingValues paddingValues1112 = contentPadding;
                MutableInteractionSource mutableInteractionSource1115 = mutableInteractionSource4;
                ButtonElevation buttonElevation1113 = buttonElevation2;
                boolean z1116 = z5;
                Modifier modifier1114 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default1110, z5, shape3, jM3042unboximpl1110, jM3031copywmQWz5c$default1110, borderStroke3, fM5160constructorimpl, mutableInteractionSource1115, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor1110, contentPadding, interfaceC0552Gp, i13)), composer2, (i11111115 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape4 = shape3;
                borderStroke4 = borderStroke3;
                buttonElevation3 = buttonElevation1113;
                buttonColors3 = buttonColors1113;
                paddingValues2 = paddingValues1112;
                modifier4 = modifier1114;
                z6 = z1116;
                mutableInteractionSource5 = mutableInteractionSource1115;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                }
                int i11111117 = i13 >> 6;
                int i11111118 = (i11111117 & 14) | ((i13 >> 18) & 112);
                State<Color> stateContentColor1111 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11111118);
                Modifier modifierSemantics$default1111 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                long jM3042unboximpl1111 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11111118).getValue().m3042unboximpl();
                long jM3031copywmQWz5c$default1111 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor1111), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.startReplaceableGroup(-423487112);
                if (buttonElevation2 != null) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (stateElevation != null) {
                    fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                ButtonColors buttonColors1114 = buttonColors2;
                PaddingValues paddingValues1113 = contentPadding;
                MutableInteractionSource mutableInteractionSource1116 = mutableInteractionSource4;
                ButtonElevation buttonElevation1114 = buttonElevation2;
                boolean z1117 = z5;
                Modifier modifier1115 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default1111, z5, shape3, jM3042unboximpl1111, jM3031copywmQWz5c$default1111, borderStroke3, fM5160constructorimpl, mutableInteractionSource1116, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor1111, contentPadding, interfaceC0552Gp, i13)), composer2, (i11111117 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape4 = shape3;
                borderStroke4 = borderStroke3;
                buttonElevation3 = buttonElevation1114;
                buttonColors3 = buttonColors1114;
                paddingValues2 = paddingValues1113;
                modifier4 = modifier1115;
                z6 = z1117;
                mutableInteractionSource5 = mutableInteractionSource1116;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonElevationM1016elevationR_JCAzs = buttonElevation;
                        if (composerStartRestartGroup.changed(buttonElevationM1016elevationR_JCAzs)) {
                        }
                        i3 |= i16;
                    } else {
                        buttonElevationM1016elevationR_JCAzs = buttonElevation;
                    }
                    i3 |= i16;
                } else {
                    buttonElevationM1016elevationR_JCAzs = buttonElevation;
                }
                if ((458752 & i) == 0) {
                    shape2 = shape;
                    if ((i2 & 32) == 0) {
                        i14 = 65536;
                    } else {
                        i14 = 65536;
                    }
                    i3 |= i14;
                } else {
                    shape2 = shape;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        if ((i & 234881024) == 0) {
                            paddingValues2 = paddingValues;
                            if (composerStartRestartGroup.changed(paddingValues2)) {
                                i11 = 67108864;
                            } else {
                                i11 = 33554432;
                            }
                            i3 |= i11;
                        }
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i12 = PropertyOptions.DELETE_EXISTING;
                            } else {
                                i12 = 268435456;
                            }
                            i3 |= i12;
                        }
                        i13 = i3;
                        if ((1533916891 & i13) == 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                            }
                            int i11111119 = i13 >> 6;
                            int i111111110 = (i11111119 & 14) | ((i13 >> 18) & 112);
                            State<Color> stateContentColor1112 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111111110);
                            Modifier modifierSemantics$default1112 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                            long jM3042unboximpl1112 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111111110).getValue().m3042unboximpl();
                            long jM3031copywmQWz5c$default1112 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor1112), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            composerStartRestartGroup.startReplaceableGroup(-423487112);
                            if (buttonElevation2 != null) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            if (stateElevation != null) {
                                fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                            } else {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            }
                            ButtonColors buttonColors1115 = buttonColors2;
                            PaddingValues paddingValues1114 = contentPadding;
                            MutableInteractionSource mutableInteractionSource1117 = mutableInteractionSource4;
                            ButtonElevation buttonElevation1115 = buttonElevation2;
                            boolean z1118 = z5;
                            Modifier modifier1116 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default1112, z5, shape3, jM3042unboximpl1112, jM3031copywmQWz5c$default1112, borderStroke3, fM5160constructorimpl, mutableInteractionSource1117, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor1112, contentPadding, interfaceC0552Gp, i13)), composer2, (i11111119 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            buttonElevation3 = buttonElevation1115;
                            buttonColors3 = buttonColors1115;
                            paddingValues2 = paddingValues1114;
                            modifier4 = modifier1116;
                            z6 = z1118;
                            mutableInteractionSource5 = mutableInteractionSource1117;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    z4 = true;
                                    i13 &= -57345;
                                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    z4 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i13 &= -458753;
                                } else {
                                    small = shape;
                                }
                                if (i8 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    i13 &= -29360129;
                                } else {
                                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                                }
                                if (i10 != 0) {
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    r10 = z4;
                                } else {
                                    contentPadding = paddingValues;
                                    shape3 = small;
                                    borderStroke3 = borderStroke2;
                                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                    modifier3 = modifier2;
                                    z5 = z3;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    r10 = z4;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                            }
                            int i111111111 = i13 >> 6;
                            int i111111112 = (i111111111 & 14) | ((i13 >> 18) & 112);
                            State<Color> stateContentColor1113 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111111112);
                            Modifier modifierSemantics$default1113 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                            long jM3042unboximpl1113 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111111112).getValue().m3042unboximpl();
                            long jM3031copywmQWz5c$default1113 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor1113), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            composerStartRestartGroup.startReplaceableGroup(-423487112);
                            if (buttonElevation2 != null) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            if (stateElevation != null) {
                                fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                            } else {
                                fM5160constructorimpl = Dp.m5160constructorimpl(0);
                            }
                            ButtonColors buttonColors1116 = buttonColors2;
                            PaddingValues paddingValues1115 = contentPadding;
                            MutableInteractionSource mutableInteractionSource1118 = mutableInteractionSource4;
                            ButtonElevation buttonElevation1116 = buttonElevation2;
                            boolean z1119 = z5;
                            Modifier modifier1117 = modifier3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default1113, z5, shape3, jM3042unboximpl1113, jM3031copywmQWz5c$default1113, borderStroke3, fM5160constructorimpl, mutableInteractionSource1118, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor1113, contentPadding, interfaceC0552Gp, i13)), composer2, (i111111111 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape3;
                            borderStroke4 = borderStroke3;
                            buttonElevation3 = buttonElevation1116;
                            buttonColors3 = buttonColors1116;
                            paddingValues2 = paddingValues1115;
                            modifier4 = modifier1117;
                            z6 = z1119;
                            mutableInteractionSource5 = mutableInteractionSource1118;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
                    }
                    i3 |= 100663296;
                    paddingValues2 = paddingValues;
                    if ((i2 & 512) != 0) {
                        i3 |= 805306368;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                        i3 |= i12;
                    }
                    i13 = i3;
                    if ((1533916891 & i13) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i111111113 = i13 >> 6;
                        int i111111114 = (i111111113 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor1114 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111111114);
                        Modifier modifierSemantics$default1114 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl1114 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111111114).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default1114 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor1114), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors1117 = buttonColors2;
                        PaddingValues paddingValues1116 = contentPadding;
                        MutableInteractionSource mutableInteractionSource1119 = mutableInteractionSource4;
                        ButtonElevation buttonElevation1117 = buttonElevation2;
                        boolean z11110 = z5;
                        Modifier modifier1118 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default1114, z5, shape3, jM3042unboximpl1114, jM3031copywmQWz5c$default1114, borderStroke3, fM5160constructorimpl, mutableInteractionSource1119, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor1114, contentPadding, interfaceC0552Gp, i13)), composer2, (i111111113 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation1117;
                        buttonColors3 = buttonColors1117;
                        paddingValues2 = paddingValues1116;
                        modifier4 = modifier1118;
                        z6 = z11110;
                        mutableInteractionSource5 = mutableInteractionSource1119;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i111111115 = i13 >> 6;
                        int i111111116 = (i111111115 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor1115 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111111116);
                        Modifier modifierSemantics$default1115 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl1115 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111111116).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default1115 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor1115), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors1118 = buttonColors2;
                        PaddingValues paddingValues1117 = contentPadding;
                        MutableInteractionSource mutableInteractionSource11110 = mutableInteractionSource4;
                        ButtonElevation buttonElevation1118 = buttonElevation2;
                        boolean z11111 = z5;
                        Modifier modifier1119 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default1115, z5, shape3, jM3042unboximpl1115, jM3031copywmQWz5c$default1115, borderStroke3, fM5160constructorimpl, mutableInteractionSource11110, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor1115, contentPadding, interfaceC0552Gp, i13)), composer2, (i111111115 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation1118;
                        buttonColors3 = buttonColors1118;
                        paddingValues2 = paddingValues1117;
                        modifier4 = modifier1119;
                        z6 = z11111;
                        mutableInteractionSource5 = mutableInteractionSource11110;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
                }
                i3 |= 1572864;
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 234881024) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 512) != 0) {
                        i3 |= 805306368;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                        i3 |= i12;
                    }
                    i13 = i3;
                    if ((1533916891 & i13) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i111111117 = i13 >> 6;
                        int i111111118 = (i111111117 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor1116 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111111118);
                        Modifier modifierSemantics$default1116 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl1116 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111111118).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default1116 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor1116), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors1119 = buttonColors2;
                        PaddingValues paddingValues1118 = contentPadding;
                        MutableInteractionSource mutableInteractionSource11111 = mutableInteractionSource4;
                        ButtonElevation buttonElevation1119 = buttonElevation2;
                        boolean z11112 = z5;
                        Modifier modifier11110 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default1116, z5, shape3, jM3042unboximpl1116, jM3031copywmQWz5c$default1116, borderStroke3, fM5160constructorimpl, mutableInteractionSource11111, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor1116, contentPadding, interfaceC0552Gp, i13)), composer2, (i111111117 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation1119;
                        buttonColors3 = buttonColors1119;
                        paddingValues2 = paddingValues1118;
                        modifier4 = modifier11110;
                        z6 = z11112;
                        mutableInteractionSource5 = mutableInteractionSource11111;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i111111119 = i13 >> 6;
                        int i1111111110 = (i111111119 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor1117 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1111111110);
                        Modifier modifierSemantics$default1117 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl1117 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1111111110).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default1117 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor1117), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors11110 = buttonColors2;
                        PaddingValues paddingValues1119 = contentPadding;
                        MutableInteractionSource mutableInteractionSource11112 = mutableInteractionSource4;
                        ButtonElevation buttonElevation11110 = buttonElevation2;
                        boolean z11113 = z5;
                        Modifier modifier11111 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default1117, z5, shape3, jM3042unboximpl1117, jM3031copywmQWz5c$default1117, borderStroke3, fM5160constructorimpl, mutableInteractionSource11112, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor1117, contentPadding, interfaceC0552Gp, i13)), composer2, (i111111119 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation11110;
                        buttonColors3 = buttonColors11110;
                        paddingValues2 = paddingValues1119;
                        modifier4 = modifier11111;
                        z6 = z11113;
                        mutableInteractionSource5 = mutableInteractionSource11112;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
                }
                i3 |= 100663296;
                paddingValues2 = paddingValues;
                if ((i2 & 512) != 0) {
                    i3 |= 805306368;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                i13 = i3;
                if ((1533916891 & i13) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i1111111111 = i13 >> 6;
                    int i1111111112 = (i1111111111 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor1118 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1111111112);
                    Modifier modifierSemantics$default1118 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl1118 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1111111112).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default1118 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor1118), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors11111 = buttonColors2;
                    PaddingValues paddingValues11110 = contentPadding;
                    MutableInteractionSource mutableInteractionSource11113 = mutableInteractionSource4;
                    ButtonElevation buttonElevation11111 = buttonElevation2;
                    boolean z11114 = z5;
                    Modifier modifier11112 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default1118, z5, shape3, jM3042unboximpl1118, jM3031copywmQWz5c$default1118, borderStroke3, fM5160constructorimpl, mutableInteractionSource11113, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor1118, contentPadding, interfaceC0552Gp, i13)), composer2, (i1111111111 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation11111;
                    buttonColors3 = buttonColors11111;
                    paddingValues2 = paddingValues11110;
                    modifier4 = modifier11112;
                    z6 = z11114;
                    mutableInteractionSource5 = mutableInteractionSource11113;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i1111111113 = i13 >> 6;
                    int i1111111114 = (i1111111113 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor1119 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1111111114);
                    Modifier modifierSemantics$default1119 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl1119 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1111111114).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default1119 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor1119), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors11112 = buttonColors2;
                    PaddingValues paddingValues11111 = contentPadding;
                    MutableInteractionSource mutableInteractionSource11114 = mutableInteractionSource4;
                    ButtonElevation buttonElevation11112 = buttonElevation2;
                    boolean z11115 = z5;
                    Modifier modifier11113 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default1119, z5, shape3, jM3042unboximpl1119, jM3031copywmQWz5c$default1119, borderStroke3, fM5160constructorimpl, mutableInteractionSource11114, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor1119, contentPadding, interfaceC0552Gp, i13)), composer2, (i1111111113 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation11112;
                    buttonColors3 = buttonColors11112;
                    paddingValues2 = paddingValues11111;
                    modifier4 = modifier11113;
                    z6 = z11115;
                    mutableInteractionSource5 = mutableInteractionSource11114;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
            }
            i3 |= 3072;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    buttonElevationM1016elevationR_JCAzs = buttonElevation;
                    if (composerStartRestartGroup.changed(buttonElevationM1016elevationR_JCAzs)) {
                    }
                    i3 |= i16;
                } else {
                    buttonElevationM1016elevationR_JCAzs = buttonElevation;
                }
                i3 |= i16;
            } else {
                buttonElevationM1016elevationR_JCAzs = buttonElevation;
            }
            if ((458752 & i) == 0) {
                shape2 = shape;
                if ((i2 & 32) == 0) {
                    i14 = 65536;
                } else {
                    i14 = 65536;
                }
                i3 |= i14;
            } else {
                shape2 = shape;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 234881024) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 512) != 0) {
                        i3 |= 805306368;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                        i3 |= i12;
                    }
                    i13 = i3;
                    if ((1533916891 & i13) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i1111111115 = i13 >> 6;
                        int i1111111116 = (i1111111115 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor11110 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1111111116);
                        Modifier modifierSemantics$default11110 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl11110 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1111111116).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default11110 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor11110), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors11113 = buttonColors2;
                        PaddingValues paddingValues11112 = contentPadding;
                        MutableInteractionSource mutableInteractionSource11115 = mutableInteractionSource4;
                        ButtonElevation buttonElevation11113 = buttonElevation2;
                        boolean z11116 = z5;
                        Modifier modifier11114 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default11110, z5, shape3, jM3042unboximpl11110, jM3031copywmQWz5c$default11110, borderStroke3, fM5160constructorimpl, mutableInteractionSource11115, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor11110, contentPadding, interfaceC0552Gp, i13)), composer2, (i1111111115 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation11113;
                        buttonColors3 = buttonColors11113;
                        paddingValues2 = paddingValues11112;
                        modifier4 = modifier11114;
                        z6 = z11116;
                        mutableInteractionSource5 = mutableInteractionSource11115;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i1111111117 = i13 >> 6;
                        int i1111111118 = (i1111111117 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor11111 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1111111118);
                        Modifier modifierSemantics$default11111 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl11111 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1111111118).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default11111 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor11111), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors11114 = buttonColors2;
                        PaddingValues paddingValues11113 = contentPadding;
                        MutableInteractionSource mutableInteractionSource11116 = mutableInteractionSource4;
                        ButtonElevation buttonElevation11114 = buttonElevation2;
                        boolean z11117 = z5;
                        Modifier modifier11115 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default11111, z5, shape3, jM3042unboximpl11111, jM3031copywmQWz5c$default11111, borderStroke3, fM5160constructorimpl, mutableInteractionSource11116, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor11111, contentPadding, interfaceC0552Gp, i13)), composer2, (i1111111117 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation11114;
                        buttonColors3 = buttonColors11114;
                        paddingValues2 = paddingValues11113;
                        modifier4 = modifier11115;
                        z6 = z11117;
                        mutableInteractionSource5 = mutableInteractionSource11116;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
                }
                i3 |= 100663296;
                paddingValues2 = paddingValues;
                if ((i2 & 512) != 0) {
                    i3 |= 805306368;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                i13 = i3;
                if ((1533916891 & i13) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i1111111119 = i13 >> 6;
                    int i11111111110 = (i1111111119 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor11112 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11111111110);
                    Modifier modifierSemantics$default11112 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl11112 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11111111110).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default11112 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor11112), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors11115 = buttonColors2;
                    PaddingValues paddingValues11114 = contentPadding;
                    MutableInteractionSource mutableInteractionSource11117 = mutableInteractionSource4;
                    ButtonElevation buttonElevation11115 = buttonElevation2;
                    boolean z11118 = z5;
                    Modifier modifier11116 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default11112, z5, shape3, jM3042unboximpl11112, jM3031copywmQWz5c$default11112, borderStroke3, fM5160constructorimpl, mutableInteractionSource11117, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor11112, contentPadding, interfaceC0552Gp, i13)), composer2, (i1111111119 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation11115;
                    buttonColors3 = buttonColors11115;
                    paddingValues2 = paddingValues11114;
                    modifier4 = modifier11116;
                    z6 = z11118;
                    mutableInteractionSource5 = mutableInteractionSource11117;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i11111111111 = i13 >> 6;
                    int i11111111112 = (i11111111111 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor11113 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11111111112);
                    Modifier modifierSemantics$default11113 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl11113 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11111111112).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default11113 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor11113), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors11116 = buttonColors2;
                    PaddingValues paddingValues11115 = contentPadding;
                    MutableInteractionSource mutableInteractionSource11118 = mutableInteractionSource4;
                    ButtonElevation buttonElevation11116 = buttonElevation2;
                    boolean z11119 = z5;
                    Modifier modifier11117 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default11113, z5, shape3, jM3042unboximpl11113, jM3031copywmQWz5c$default11113, borderStroke3, fM5160constructorimpl, mutableInteractionSource11118, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor11113, contentPadding, interfaceC0552Gp, i13)), composer2, (i11111111111 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation11116;
                    buttonColors3 = buttonColors11116;
                    paddingValues2 = paddingValues11115;
                    modifier4 = modifier11117;
                    z6 = z11119;
                    mutableInteractionSource5 = mutableInteractionSource11118;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
            }
            i3 |= 1572864;
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 234881024) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    i3 |= 805306368;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                i13 = i3;
                if ((1533916891 & i13) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i11111111113 = i13 >> 6;
                    int i11111111114 = (i11111111113 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor11114 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11111111114);
                    Modifier modifierSemantics$default11114 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl11114 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11111111114).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default11114 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor11114), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors11117 = buttonColors2;
                    PaddingValues paddingValues11116 = contentPadding;
                    MutableInteractionSource mutableInteractionSource11119 = mutableInteractionSource4;
                    ButtonElevation buttonElevation11117 = buttonElevation2;
                    boolean z111110 = z5;
                    Modifier modifier11118 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default11114, z5, shape3, jM3042unboximpl11114, jM3031copywmQWz5c$default11114, borderStroke3, fM5160constructorimpl, mutableInteractionSource11119, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor11114, contentPadding, interfaceC0552Gp, i13)), composer2, (i11111111113 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation11117;
                    buttonColors3 = buttonColors11117;
                    paddingValues2 = paddingValues11116;
                    modifier4 = modifier11118;
                    z6 = z111110;
                    mutableInteractionSource5 = mutableInteractionSource11119;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i11111111115 = i13 >> 6;
                    int i11111111116 = (i11111111115 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor11115 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11111111116);
                    Modifier modifierSemantics$default11115 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl11115 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11111111116).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default11115 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor11115), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors11118 = buttonColors2;
                    PaddingValues paddingValues11117 = contentPadding;
                    MutableInteractionSource mutableInteractionSource111110 = mutableInteractionSource4;
                    ButtonElevation buttonElevation11118 = buttonElevation2;
                    boolean z111111 = z5;
                    Modifier modifier11119 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default11115, z5, shape3, jM3042unboximpl11115, jM3031copywmQWz5c$default11115, borderStroke3, fM5160constructorimpl, mutableInteractionSource111110, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor11115, contentPadding, interfaceC0552Gp, i13)), composer2, (i11111111115 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation11118;
                    buttonColors3 = buttonColors11118;
                    paddingValues2 = paddingValues11117;
                    modifier4 = modifier11119;
                    z6 = z111111;
                    mutableInteractionSource5 = mutableInteractionSource111110;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
            }
            i3 |= 100663296;
            paddingValues2 = paddingValues;
            if ((i2 & 512) != 0) {
                i3 |= 805306368;
            } else if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i12 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i12 = 268435456;
                }
                i3 |= i12;
            }
            i13 = i3;
            if ((1533916891 & i13) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                }
                int i11111111117 = i13 >> 6;
                int i11111111118 = (i11111111117 & 14) | ((i13 >> 18) & 112);
                State<Color> stateContentColor11116 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11111111118);
                Modifier modifierSemantics$default11116 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                long jM3042unboximpl11116 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11111111118).getValue().m3042unboximpl();
                long jM3031copywmQWz5c$default11116 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor11116), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.startReplaceableGroup(-423487112);
                if (buttonElevation2 != null) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (stateElevation != null) {
                    fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                ButtonColors buttonColors11119 = buttonColors2;
                PaddingValues paddingValues11118 = contentPadding;
                MutableInteractionSource mutableInteractionSource111111 = mutableInteractionSource4;
                ButtonElevation buttonElevation11119 = buttonElevation2;
                boolean z111112 = z5;
                Modifier modifier111110 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default11116, z5, shape3, jM3042unboximpl11116, jM3031copywmQWz5c$default11116, borderStroke3, fM5160constructorimpl, mutableInteractionSource111111, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor11116, contentPadding, interfaceC0552Gp, i13)), composer2, (i11111111117 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape4 = shape3;
                borderStroke4 = borderStroke3;
                buttonElevation3 = buttonElevation11119;
                buttonColors3 = buttonColors11119;
                paddingValues2 = paddingValues11118;
                modifier4 = modifier111110;
                z6 = z111112;
                mutableInteractionSource5 = mutableInteractionSource111111;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                }
                int i11111111119 = i13 >> 6;
                int i111111111110 = (i11111111119 & 14) | ((i13 >> 18) & 112);
                State<Color> stateContentColor11117 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111111111110);
                Modifier modifierSemantics$default11117 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                long jM3042unboximpl11117 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111111111110).getValue().m3042unboximpl();
                long jM3031copywmQWz5c$default11117 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor11117), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.startReplaceableGroup(-423487112);
                if (buttonElevation2 != null) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (stateElevation != null) {
                    fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                ButtonColors buttonColors111110 = buttonColors2;
                PaddingValues paddingValues11119 = contentPadding;
                MutableInteractionSource mutableInteractionSource111112 = mutableInteractionSource4;
                ButtonElevation buttonElevation111110 = buttonElevation2;
                boolean z111113 = z5;
                Modifier modifier111111 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default11117, z5, shape3, jM3042unboximpl11117, jM3031copywmQWz5c$default11117, borderStroke3, fM5160constructorimpl, mutableInteractionSource111112, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor11117, contentPadding, interfaceC0552Gp, i13)), composer2, (i11111111119 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape4 = shape3;
                borderStroke4 = borderStroke3;
                buttonElevation3 = buttonElevation111110;
                buttonColors3 = buttonColors111110;
                paddingValues2 = paddingValues11119;
                modifier4 = modifier111111;
                z6 = z111113;
                mutableInteractionSource5 = mutableInteractionSource111112;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
        }
        i3 |= 384;
        z2 = z;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((57344 & i) == 0) {
                if ((i2 & 16) == 0) {
                    buttonElevationM1016elevationR_JCAzs = buttonElevation;
                    if (composerStartRestartGroup.changed(buttonElevationM1016elevationR_JCAzs)) {
                    }
                    i3 |= i16;
                } else {
                    buttonElevationM1016elevationR_JCAzs = buttonElevation;
                }
                i3 |= i16;
            } else {
                buttonElevationM1016elevationR_JCAzs = buttonElevation;
            }
            if ((458752 & i) == 0) {
                shape2 = shape;
                if ((i2 & 32) == 0) {
                    i14 = 65536;
                } else {
                    i14 = 65536;
                }
                i3 |= i14;
            } else {
                shape2 = shape;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 234881024) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i2 & 512) != 0) {
                        i3 |= 805306368;
                    } else if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i12 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i12 = 268435456;
                        }
                        i3 |= i12;
                    }
                    i13 = i3;
                    if ((1533916891 & i13) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i111111111111 = i13 >> 6;
                        int i111111111112 = (i111111111111 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor11118 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111111111112);
                        Modifier modifierSemantics$default11118 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl11118 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111111111112).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default11118 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor11118), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors111111 = buttonColors2;
                        PaddingValues paddingValues111110 = contentPadding;
                        MutableInteractionSource mutableInteractionSource111113 = mutableInteractionSource4;
                        ButtonElevation buttonElevation111111 = buttonElevation2;
                        boolean z111114 = z5;
                        Modifier modifier111112 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default11118, z5, shape3, jM3042unboximpl11118, jM3031copywmQWz5c$default11118, borderStroke3, fM5160constructorimpl, mutableInteractionSource111113, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor11118, contentPadding, interfaceC0552Gp, i13)), composer2, (i111111111111 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation111111;
                        buttonColors3 = buttonColors111111;
                        paddingValues2 = paddingValues111110;
                        modifier4 = modifier111112;
                        z6 = z111114;
                        mutableInteractionSource5 = mutableInteractionSource111113;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                z4 = true;
                                i13 &= -57345;
                                buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            } else {
                                z4 = true;
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i13 &= -458753;
                            } else {
                                small = shape;
                            }
                            if (i8 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                i13 &= -29360129;
                            } else {
                                buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                            }
                            if (i10 != 0) {
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                r10 = z4;
                            } else {
                                contentPadding = paddingValues;
                                shape3 = small;
                                borderStroke3 = borderStroke2;
                                buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                                buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                                modifier3 = modifier2;
                                z5 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                r10 = z4;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                        }
                        int i111111111113 = i13 >> 6;
                        int i111111111114 = (i111111111113 & 14) | ((i13 >> 18) & 112);
                        State<Color> stateContentColor11119 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111111111114);
                        Modifier modifierSemantics$default11119 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                        long jM3042unboximpl11119 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111111111114).getValue().m3042unboximpl();
                        long jM3031copywmQWz5c$default11119 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor11119), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.startReplaceableGroup(-423487112);
                        if (buttonElevation2 != null) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (stateElevation != null) {
                            fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                        } else {
                            fM5160constructorimpl = Dp.m5160constructorimpl(0);
                        }
                        ButtonColors buttonColors111112 = buttonColors2;
                        PaddingValues paddingValues111111 = contentPadding;
                        MutableInteractionSource mutableInteractionSource111114 = mutableInteractionSource4;
                        ButtonElevation buttonElevation111112 = buttonElevation2;
                        boolean z111115 = z5;
                        Modifier modifier111113 = modifier3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default11119, z5, shape3, jM3042unboximpl11119, jM3031copywmQWz5c$default11119, borderStroke3, fM5160constructorimpl, mutableInteractionSource111114, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor11119, contentPadding, interfaceC0552Gp, i13)), composer2, (i111111111113 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        buttonElevation3 = buttonElevation111112;
                        buttonColors3 = buttonColors111112;
                        paddingValues2 = paddingValues111111;
                        modifier4 = modifier111113;
                        z6 = z111115;
                        mutableInteractionSource5 = mutableInteractionSource111114;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
                }
                i3 |= 100663296;
                paddingValues2 = paddingValues;
                if ((i2 & 512) != 0) {
                    i3 |= 805306368;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                i13 = i3;
                if ((1533916891 & i13) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i111111111115 = i13 >> 6;
                    int i111111111116 = (i111111111115 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor111110 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111111111116);
                    Modifier modifierSemantics$default111110 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl111110 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111111111116).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default111110 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor111110), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors111113 = buttonColors2;
                    PaddingValues paddingValues111112 = contentPadding;
                    MutableInteractionSource mutableInteractionSource111115 = mutableInteractionSource4;
                    ButtonElevation buttonElevation111113 = buttonElevation2;
                    boolean z111116 = z5;
                    Modifier modifier111114 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default111110, z5, shape3, jM3042unboximpl111110, jM3031copywmQWz5c$default111110, borderStroke3, fM5160constructorimpl, mutableInteractionSource111115, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor111110, contentPadding, interfaceC0552Gp, i13)), composer2, (i111111111115 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation111113;
                    buttonColors3 = buttonColors111113;
                    paddingValues2 = paddingValues111112;
                    modifier4 = modifier111114;
                    z6 = z111116;
                    mutableInteractionSource5 = mutableInteractionSource111115;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i111111111117 = i13 >> 6;
                    int i111111111118 = (i111111111117 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor111111 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111111111118);
                    Modifier modifierSemantics$default111111 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl111111 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111111111118).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default111111 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor111111), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors111114 = buttonColors2;
                    PaddingValues paddingValues111113 = contentPadding;
                    MutableInteractionSource mutableInteractionSource111116 = mutableInteractionSource4;
                    ButtonElevation buttonElevation111114 = buttonElevation2;
                    boolean z111117 = z5;
                    Modifier modifier111115 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default111111, z5, shape3, jM3042unboximpl111111, jM3031copywmQWz5c$default111111, borderStroke3, fM5160constructorimpl, mutableInteractionSource111116, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor111111, contentPadding, interfaceC0552Gp, i13)), composer2, (i111111111117 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation111114;
                    buttonColors3 = buttonColors111114;
                    paddingValues2 = paddingValues111113;
                    modifier4 = modifier111115;
                    z6 = z111117;
                    mutableInteractionSource5 = mutableInteractionSource111116;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
            }
            i3 |= 1572864;
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 234881024) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    i3 |= 805306368;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                i13 = i3;
                if ((1533916891 & i13) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i111111111119 = i13 >> 6;
                    int i1111111111110 = (i111111111119 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor111112 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1111111111110);
                    Modifier modifierSemantics$default111112 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl111112 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1111111111110).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default111112 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor111112), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors111115 = buttonColors2;
                    PaddingValues paddingValues111114 = contentPadding;
                    MutableInteractionSource mutableInteractionSource111117 = mutableInteractionSource4;
                    ButtonElevation buttonElevation111115 = buttonElevation2;
                    boolean z111118 = z5;
                    Modifier modifier111116 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default111112, z5, shape3, jM3042unboximpl111112, jM3031copywmQWz5c$default111112, borderStroke3, fM5160constructorimpl, mutableInteractionSource111117, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor111112, contentPadding, interfaceC0552Gp, i13)), composer2, (i111111111119 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation111115;
                    buttonColors3 = buttonColors111115;
                    paddingValues2 = paddingValues111114;
                    modifier4 = modifier111116;
                    z6 = z111118;
                    mutableInteractionSource5 = mutableInteractionSource111117;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i1111111111111 = i13 >> 6;
                    int i1111111111112 = (i1111111111111 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor111113 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1111111111112);
                    Modifier modifierSemantics$default111113 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl111113 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1111111111112).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default111113 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor111113), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors111116 = buttonColors2;
                    PaddingValues paddingValues111115 = contentPadding;
                    MutableInteractionSource mutableInteractionSource111118 = mutableInteractionSource4;
                    ButtonElevation buttonElevation111116 = buttonElevation2;
                    boolean z111119 = z5;
                    Modifier modifier111117 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default111113, z5, shape3, jM3042unboximpl111113, jM3031copywmQWz5c$default111113, borderStroke3, fM5160constructorimpl, mutableInteractionSource111118, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor111113, contentPadding, interfaceC0552Gp, i13)), composer2, (i1111111111111 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation111116;
                    buttonColors3 = buttonColors111116;
                    paddingValues2 = paddingValues111115;
                    modifier4 = modifier111117;
                    z6 = z111119;
                    mutableInteractionSource5 = mutableInteractionSource111118;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
            }
            i3 |= 100663296;
            paddingValues2 = paddingValues;
            if ((i2 & 512) != 0) {
                i3 |= 805306368;
            } else if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i12 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i12 = 268435456;
                }
                i3 |= i12;
            }
            i13 = i3;
            if ((1533916891 & i13) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                }
                int i1111111111113 = i13 >> 6;
                int i1111111111114 = (i1111111111113 & 14) | ((i13 >> 18) & 112);
                State<Color> stateContentColor111114 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1111111111114);
                Modifier modifierSemantics$default111114 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                long jM3042unboximpl111114 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1111111111114).getValue().m3042unboximpl();
                long jM3031copywmQWz5c$default111114 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor111114), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.startReplaceableGroup(-423487112);
                if (buttonElevation2 != null) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (stateElevation != null) {
                    fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                ButtonColors buttonColors111117 = buttonColors2;
                PaddingValues paddingValues111116 = contentPadding;
                MutableInteractionSource mutableInteractionSource111119 = mutableInteractionSource4;
                ButtonElevation buttonElevation111117 = buttonElevation2;
                boolean z1111110 = z5;
                Modifier modifier111118 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default111114, z5, shape3, jM3042unboximpl111114, jM3031copywmQWz5c$default111114, borderStroke3, fM5160constructorimpl, mutableInteractionSource111119, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor111114, contentPadding, interfaceC0552Gp, i13)), composer2, (i1111111111113 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape4 = shape3;
                borderStroke4 = borderStroke3;
                buttonElevation3 = buttonElevation111117;
                buttonColors3 = buttonColors111117;
                paddingValues2 = paddingValues111116;
                modifier4 = modifier111118;
                z6 = z1111110;
                mutableInteractionSource5 = mutableInteractionSource111119;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                }
                int i1111111111115 = i13 >> 6;
                int i1111111111116 = (i1111111111115 & 14) | ((i13 >> 18) & 112);
                State<Color> stateContentColor111115 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1111111111116);
                Modifier modifierSemantics$default111115 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                long jM3042unboximpl111115 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1111111111116).getValue().m3042unboximpl();
                long jM3031copywmQWz5c$default111115 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor111115), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.startReplaceableGroup(-423487112);
                if (buttonElevation2 != null) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (stateElevation != null) {
                    fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                ButtonColors buttonColors111118 = buttonColors2;
                PaddingValues paddingValues111117 = contentPadding;
                MutableInteractionSource mutableInteractionSource1111110 = mutableInteractionSource4;
                ButtonElevation buttonElevation111118 = buttonElevation2;
                boolean z1111111 = z5;
                Modifier modifier111119 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default111115, z5, shape3, jM3042unboximpl111115, jM3031copywmQWz5c$default111115, borderStroke3, fM5160constructorimpl, mutableInteractionSource1111110, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor111115, contentPadding, interfaceC0552Gp, i13)), composer2, (i1111111111115 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape4 = shape3;
                borderStroke4 = borderStroke3;
                buttonElevation3 = buttonElevation111118;
                buttonColors3 = buttonColors111118;
                paddingValues2 = paddingValues111117;
                modifier4 = modifier111119;
                z6 = z1111111;
                mutableInteractionSource5 = mutableInteractionSource1111110;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
        }
        i3 |= 3072;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((57344 & i) == 0) {
            if ((i2 & 16) == 0) {
                buttonElevationM1016elevationR_JCAzs = buttonElevation;
                if (composerStartRestartGroup.changed(buttonElevationM1016elevationR_JCAzs)) {
                }
                i3 |= i16;
            } else {
                buttonElevationM1016elevationR_JCAzs = buttonElevation;
            }
            i3 |= i16;
        } else {
            buttonElevationM1016elevationR_JCAzs = buttonElevation;
        }
        if ((458752 & i) == 0) {
            shape2 = shape;
            if ((i2 & 32) == 0) {
                i14 = 65536;
            } else {
                i14 = 65536;
            }
            i3 |= i14;
        } else {
            shape2 = shape;
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 234881024) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    i3 |= 805306368;
                } else if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i12 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                i13 = i3;
                if ((1533916891 & i13) == 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i1111111111117 = i13 >> 6;
                    int i1111111111118 = (i1111111111117 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor111116 = buttonColors2.contentColor(z5, composerStartRestartGroup, i1111111111118);
                    Modifier modifierSemantics$default111116 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl111116 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i1111111111118).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default111116 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor111116), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors111119 = buttonColors2;
                    PaddingValues paddingValues111118 = contentPadding;
                    MutableInteractionSource mutableInteractionSource1111111 = mutableInteractionSource4;
                    ButtonElevation buttonElevation111119 = buttonElevation2;
                    boolean z1111112 = z5;
                    Modifier modifier1111110 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default111116, z5, shape3, jM3042unboximpl111116, jM3031copywmQWz5c$default111116, borderStroke3, fM5160constructorimpl, mutableInteractionSource1111111, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor111116, contentPadding, interfaceC0552Gp, i13)), composer2, (i1111111111117 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation111119;
                    buttonColors3 = buttonColors111119;
                    paddingValues2 = paddingValues111118;
                    modifier4 = modifier1111110;
                    z6 = z1111112;
                    mutableInteractionSource5 = mutableInteractionSource1111111;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            z4 = true;
                            i13 &= -57345;
                            buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        } else {
                            z4 = true;
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i13 &= -458753;
                        } else {
                            small = shape;
                        }
                        if (i8 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            i13 &= -29360129;
                        } else {
                            buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                        }
                        if (i10 != 0) {
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            r10 = z4;
                        } else {
                            contentPadding = paddingValues;
                            shape3 = small;
                            borderStroke3 = borderStroke2;
                            buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                            modifier3 = modifier2;
                            z5 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            r10 = z4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                    }
                    int i1111111111119 = i13 >> 6;
                    int i11111111111110 = (i1111111111119 & 14) | ((i13 >> 18) & 112);
                    State<Color> stateContentColor111117 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11111111111110);
                    Modifier modifierSemantics$default111117 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                    long jM3042unboximpl111117 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11111111111110).getValue().m3042unboximpl();
                    long jM3031copywmQWz5c$default111117 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor111117), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.startReplaceableGroup(-423487112);
                    if (buttonElevation2 != null) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (stateElevation != null) {
                        fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                    } else {
                        fM5160constructorimpl = Dp.m5160constructorimpl(0);
                    }
                    ButtonColors buttonColors1111110 = buttonColors2;
                    PaddingValues paddingValues111119 = contentPadding;
                    MutableInteractionSource mutableInteractionSource1111112 = mutableInteractionSource4;
                    ButtonElevation buttonElevation1111110 = buttonElevation2;
                    boolean z1111113 = z5;
                    Modifier modifier1111111 = modifier3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default111117, z5, shape3, jM3042unboximpl111117, jM3031copywmQWz5c$default111117, borderStroke3, fM5160constructorimpl, mutableInteractionSource1111112, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor111117, contentPadding, interfaceC0552Gp, i13)), composer2, (i1111111111119 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    buttonElevation3 = buttonElevation1111110;
                    buttonColors3 = buttonColors1111110;
                    paddingValues2 = paddingValues111119;
                    modifier4 = modifier1111111;
                    z6 = z1111113;
                    mutableInteractionSource5 = mutableInteractionSource1111112;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
            }
            i3 |= 100663296;
            paddingValues2 = paddingValues;
            if ((i2 & 512) != 0) {
                i3 |= 805306368;
            } else if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i12 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i12 = 268435456;
                }
                i3 |= i12;
            }
            i13 = i3;
            if ((1533916891 & i13) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                }
                int i11111111111111 = i13 >> 6;
                int i11111111111112 = (i11111111111111 & 14) | ((i13 >> 18) & 112);
                State<Color> stateContentColor111118 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11111111111112);
                Modifier modifierSemantics$default111118 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                long jM3042unboximpl111118 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11111111111112).getValue().m3042unboximpl();
                long jM3031copywmQWz5c$default111118 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor111118), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.startReplaceableGroup(-423487112);
                if (buttonElevation2 != null) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (stateElevation != null) {
                    fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                ButtonColors buttonColors1111111 = buttonColors2;
                PaddingValues paddingValues1111110 = contentPadding;
                MutableInteractionSource mutableInteractionSource1111113 = mutableInteractionSource4;
                ButtonElevation buttonElevation1111111 = buttonElevation2;
                boolean z1111114 = z5;
                Modifier modifier1111112 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default111118, z5, shape3, jM3042unboximpl111118, jM3031copywmQWz5c$default111118, borderStroke3, fM5160constructorimpl, mutableInteractionSource1111113, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor111118, contentPadding, interfaceC0552Gp, i13)), composer2, (i11111111111111 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape4 = shape3;
                borderStroke4 = borderStroke3;
                buttonElevation3 = buttonElevation1111111;
                buttonColors3 = buttonColors1111111;
                paddingValues2 = paddingValues1111110;
                modifier4 = modifier1111112;
                z6 = z1111114;
                mutableInteractionSource5 = mutableInteractionSource1111113;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                }
                int i11111111111113 = i13 >> 6;
                int i11111111111114 = (i11111111111113 & 14) | ((i13 >> 18) & 112);
                State<Color> stateContentColor111119 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11111111111114);
                Modifier modifierSemantics$default111119 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                long jM3042unboximpl111119 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11111111111114).getValue().m3042unboximpl();
                long jM3031copywmQWz5c$default111119 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor111119), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.startReplaceableGroup(-423487112);
                if (buttonElevation2 != null) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (stateElevation != null) {
                    fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                ButtonColors buttonColors1111112 = buttonColors2;
                PaddingValues paddingValues1111111 = contentPadding;
                MutableInteractionSource mutableInteractionSource1111114 = mutableInteractionSource4;
                ButtonElevation buttonElevation1111112 = buttonElevation2;
                boolean z1111115 = z5;
                Modifier modifier1111113 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default111119, z5, shape3, jM3042unboximpl111119, jM3031copywmQWz5c$default111119, borderStroke3, fM5160constructorimpl, mutableInteractionSource1111114, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor111119, contentPadding, interfaceC0552Gp, i13)), composer2, (i11111111111113 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape4 = shape3;
                borderStroke4 = borderStroke3;
                buttonElevation3 = buttonElevation1111112;
                buttonColors3 = buttonColors1111112;
                paddingValues2 = paddingValues1111111;
                modifier4 = modifier1111113;
                z6 = z1111115;
                mutableInteractionSource5 = mutableInteractionSource1111114;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
        }
        i3 |= 1572864;
        if ((i & 29360128) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
        }
        i10 = i2 & 256;
        if (i10 != 0) {
            if ((i & 234881024) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                i3 |= 805306368;
            } else if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i12 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i12 = 268435456;
                }
                i3 |= i12;
            }
            i13 = i3;
            if ((1533916891 & i13) == 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                }
                int i11111111111115 = i13 >> 6;
                int i11111111111116 = (i11111111111115 & 14) | ((i13 >> 18) & 112);
                State<Color> stateContentColor1111110 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11111111111116);
                Modifier modifierSemantics$default1111110 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                long jM3042unboximpl1111110 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11111111111116).getValue().m3042unboximpl();
                long jM3031copywmQWz5c$default1111110 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor1111110), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.startReplaceableGroup(-423487112);
                if (buttonElevation2 != null) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (stateElevation != null) {
                    fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                ButtonColors buttonColors1111113 = buttonColors2;
                PaddingValues paddingValues1111112 = contentPadding;
                MutableInteractionSource mutableInteractionSource1111115 = mutableInteractionSource4;
                ButtonElevation buttonElevation1111113 = buttonElevation2;
                boolean z1111116 = z5;
                Modifier modifier1111114 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default1111110, z5, shape3, jM3042unboximpl1111110, jM3031copywmQWz5c$default1111110, borderStroke3, fM5160constructorimpl, mutableInteractionSource1111115, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor1111110, contentPadding, interfaceC0552Gp, i13)), composer2, (i11111111111115 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape4 = shape3;
                borderStroke4 = borderStroke3;
                buttonElevation3 = buttonElevation1111113;
                buttonColors3 = buttonColors1111113;
                paddingValues2 = paddingValues1111112;
                modifier4 = modifier1111114;
                z6 = z1111116;
                mutableInteractionSource5 = mutableInteractionSource1111115;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        z4 = true;
                        i13 &= -57345;
                        buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    } else {
                        z4 = true;
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i13 &= -458753;
                    } else {
                        small = shape;
                    }
                    if (i8 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        i13 &= -29360129;
                    } else {
                        buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                    }
                    if (i10 != 0) {
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        r10 = z4;
                    } else {
                        contentPadding = paddingValues;
                        shape3 = small;
                        borderStroke3 = borderStroke2;
                        buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        r10 = z4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
                }
                int i11111111111117 = i13 >> 6;
                int i11111111111118 = (i11111111111117 & 14) | ((i13 >> 18) & 112);
                State<Color> stateContentColor1111111 = buttonColors2.contentColor(z5, composerStartRestartGroup, i11111111111118);
                Modifier modifierSemantics$default1111111 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
                long jM3042unboximpl1111111 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i11111111111118).getValue().m3042unboximpl();
                long jM3031copywmQWz5c$default1111111 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor1111111), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.startReplaceableGroup(-423487112);
                if (buttonElevation2 != null) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (stateElevation != null) {
                    fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
                } else {
                    fM5160constructorimpl = Dp.m5160constructorimpl(0);
                }
                ButtonColors buttonColors1111114 = buttonColors2;
                PaddingValues paddingValues1111113 = contentPadding;
                MutableInteractionSource mutableInteractionSource1111116 = mutableInteractionSource4;
                ButtonElevation buttonElevation1111114 = buttonElevation2;
                boolean z1111117 = z5;
                Modifier modifier1111115 = modifier3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default1111111, z5, shape3, jM3042unboximpl1111111, jM3031copywmQWz5c$default1111111, borderStroke3, fM5160constructorimpl, mutableInteractionSource1111116, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor1111111, contentPadding, interfaceC0552Gp, i13)), composer2, (i11111111111117 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape4 = shape3;
                borderStroke4 = borderStroke3;
                buttonElevation3 = buttonElevation1111114;
                buttonColors3 = buttonColors1111114;
                paddingValues2 = paddingValues1111113;
                modifier4 = modifier1111115;
                z6 = z1111117;
                mutableInteractionSource5 = mutableInteractionSource1111116;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
        }
        i3 |= 100663296;
        paddingValues2 = paddingValues;
        if ((i2 & 512) != 0) {
            i3 |= 805306368;
        } else if ((1879048192 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                i12 = PropertyOptions.DELETE_EXISTING;
            } else {
                i12 = 268435456;
            }
            i3 |= i12;
        }
        i13 = i3;
        if ((1533916891 & i13) == 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 16) != 0) {
                    z4 = true;
                    i13 &= -57345;
                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                } else {
                    z4 = true;
                }
                if ((i2 & 32) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i13 &= -458753;
                } else {
                    small = shape;
                }
                if (i8 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                if ((i2 & 128) != 0) {
                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i13 &= -29360129;
                } else {
                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                }
                if (i10 != 0) {
                    shape3 = small;
                    borderStroke3 = borderStroke2;
                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                    r10 = z4;
                } else {
                    contentPadding = paddingValues;
                    shape3 = small;
                    borderStroke3 = borderStroke2;
                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    r10 = z4;
                }
            } else {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 16) != 0) {
                    z4 = true;
                    i13 &= -57345;
                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                } else {
                    z4 = true;
                }
                if ((i2 & 32) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i13 &= -458753;
                } else {
                    small = shape;
                }
                if (i8 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                if ((i2 & 128) != 0) {
                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i13 &= -29360129;
                } else {
                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                }
                if (i10 != 0) {
                    shape3 = small;
                    borderStroke3 = borderStroke2;
                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                    r10 = z4;
                } else {
                    contentPadding = paddingValues;
                    shape3 = small;
                    borderStroke3 = borderStroke2;
                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    r10 = z4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
            }
            int i11111111111119 = i13 >> 6;
            int i111111111111110 = (i11111111111119 & 14) | ((i13 >> 18) & 112);
            State<Color> stateContentColor1111112 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111111111111110);
            Modifier modifierSemantics$default1111112 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
            long jM3042unboximpl1111112 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111111111111110).getValue().m3042unboximpl();
            long jM3031copywmQWz5c$default1111112 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor1111112), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
            composerStartRestartGroup.startReplaceableGroup(-423487112);
            if (buttonElevation2 != null) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (stateElevation != null) {
                fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
            } else {
                fM5160constructorimpl = Dp.m5160constructorimpl(0);
            }
            ButtonColors buttonColors1111115 = buttonColors2;
            PaddingValues paddingValues1111114 = contentPadding;
            MutableInteractionSource mutableInteractionSource1111117 = mutableInteractionSource4;
            ButtonElevation buttonElevation1111115 = buttonElevation2;
            boolean z1111118 = z5;
            Modifier modifier1111116 = modifier3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default1111112, z5, shape3, jM3042unboximpl1111112, jM3031copywmQWz5c$default1111112, borderStroke3, fM5160constructorimpl, mutableInteractionSource1111117, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor1111112, contentPadding, interfaceC0552Gp, i13)), composer2, (i11111111111119 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape4 = shape3;
            borderStroke4 = borderStroke3;
            buttonElevation3 = buttonElevation1111115;
            buttonColors3 = buttonColors1111115;
            paddingValues2 = paddingValues1111114;
            modifier4 = modifier1111116;
            z6 = z1111118;
            mutableInteractionSource5 = mutableInteractionSource1111117;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 16) != 0) {
                    z4 = true;
                    i13 &= -57345;
                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                } else {
                    z4 = true;
                }
                if ((i2 & 32) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i13 &= -458753;
                } else {
                    small = shape;
                }
                if (i8 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                if ((i2 & 128) != 0) {
                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i13 &= -29360129;
                } else {
                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                }
                if (i10 != 0) {
                    shape3 = small;
                    borderStroke3 = borderStroke2;
                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                    r10 = z4;
                } else {
                    contentPadding = paddingValues;
                    shape3 = small;
                    borderStroke3 = borderStroke2;
                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    r10 = z4;
                }
            } else {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                if ((i2 & 16) != 0) {
                    z4 = true;
                    i13 &= -57345;
                    buttonElevationM1016elevationR_JCAzs = ButtonDefaults.INSTANCE.m1016elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                } else {
                    z4 = true;
                }
                if ((i2 & 32) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i13 &= -458753;
                } else {
                    small = shape;
                }
                if (i8 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke;
                }
                if ((i2 & 128) != 0) {
                    buttonColorsM1015buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1015buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    i13 &= -29360129;
                } else {
                    buttonColorsM1015buttonColorsro_MJ88 = buttonColors;
                }
                if (i10 != 0) {
                    shape3 = small;
                    borderStroke3 = borderStroke2;
                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                    r10 = z4;
                } else {
                    contentPadding = paddingValues;
                    shape3 = small;
                    borderStroke3 = borderStroke2;
                    buttonColors2 = buttonColorsM1015buttonColorsro_MJ88;
                    buttonElevation2 = buttonElevationM1016elevationR_JCAzs;
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    r10 = z4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2116133464, i13, -1, "androidx.compose.material.Button (Button.kt:93)");
            }
            int i111111111111111 = i13 >> 6;
            int i111111111111112 = (i111111111111111 & 14) | ((i13 >> 18) & 112);
            State<Color> stateContentColor1111113 = buttonColors2.contentColor(z5, composerStartRestartGroup, i111111111111112);
            Modifier modifierSemantics$default1111113 = SemanticsModifierKt.semantics$default(modifier3, false, AnonymousClass2.INSTANCE, r10, null);
            long jM3042unboximpl1111113 = buttonColors2.backgroundColor(z5, composerStartRestartGroup, i111111111111112).getValue().m3042unboximpl();
            long jM3031copywmQWz5c$default1111113 = Color.m3031copywmQWz5c$default(Button$lambda$1(stateContentColor1111113), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
            composerStartRestartGroup.startReplaceableGroup(-423487112);
            if (buttonElevation2 != null) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (stateElevation != null) {
                fM5160constructorimpl = stateElevation.getValue().m5174unboximpl();
            } else {
                fM5160constructorimpl = Dp.m5160constructorimpl(0);
            }
            ButtonColors buttonColors1111116 = buttonColors2;
            PaddingValues paddingValues1111115 = contentPadding;
            MutableInteractionSource mutableInteractionSource1111118 = mutableInteractionSource4;
            ButtonElevation buttonElevation1111116 = buttonElevation2;
            boolean z1111119 = z5;
            Modifier modifier1111117 = modifier3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1228SurfaceLPr_se0(interfaceC3588op, modifierSemantics$default1111113, z5, shape3, jM3042unboximpl1111113, jM3031copywmQWz5c$default1111113, borderStroke3, fM5160constructorimpl, mutableInteractionSource1111118, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 7524271, r10, new AnonymousClass3(stateContentColor1111113, contentPadding, interfaceC0552Gp, i13)), composer2, (i111111111111111 & 7168) | (i13 & 14) | 805306368 | (i13 & 896) | (i13 & 3670016) | ((i13 << 15) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape4 = shape3;
            borderStroke4 = borderStroke3;
            buttonElevation3 = buttonElevation1111116;
            buttonColors3 = buttonColors1111116;
            paddingValues2 = paddingValues1111115;
            modifier4 = modifier1111117;
            z6 = z1111119;
            mutableInteractionSource5 = mutableInteractionSource1111118;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(interfaceC3588op, modifier4, z6, mutableInteractionSource5, buttonElevation3, shape4, borderStroke4, buttonColors3, paddingValues2, interfaceC0552Gp, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Button$lambda$1(State<Color> state) {
        return state.getValue().m3042unboximpl();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void OutlinedButton(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        MutableInteractionSource mutableInteractionSource2;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        composer.startReplaceableGroup(-1776134358);
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.Companion : modifier;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        if ((i2 & 8) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        ButtonElevation buttonElevation2 = (i2 & 16) != 0 ? null : buttonElevation;
        Shape small = (i2 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall() : shape;
        BorderStroke outlinedBorder = (i2 & 64) != 0 ? ButtonDefaults.INSTANCE.getOutlinedBorder(composer, 6) : borderStroke;
        ButtonColors buttonColorsM1023outlinedButtonColorsRGew2ao = (i2 & 128) != 0 ? ButtonDefaults.INSTANCE.m1023outlinedButtonColorsRGew2ao(0L, 0L, 0L, composer, 3072, 7) : buttonColors;
        PaddingValues contentPadding = (i2 & 256) != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1776134358, i, -1, "androidx.compose.material.OutlinedButton (Button.kt:167)");
        }
        Button(interfaceC3588op, modifier2, z2, mutableInteractionSource2, buttonElevation2, small, outlinedBorder, buttonColorsM1023outlinedButtonColorsRGew2ao, contentPadding, interfaceC0552Gp, composer, i & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void TextButton(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        MutableInteractionSource mutableInteractionSource2;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        composer.startReplaceableGroup(288797557);
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.Companion : modifier;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        if ((i2 & 8) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        ButtonElevation buttonElevation2 = (i2 & 16) != 0 ? null : buttonElevation;
        Shape small = (i2 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall() : shape;
        BorderStroke borderStroke2 = (i2 & 64) != 0 ? null : borderStroke;
        ButtonColors buttonColorsM1024textButtonColorsRGew2ao = (i2 & 128) != 0 ? ButtonDefaults.INSTANCE.m1024textButtonColorsRGew2ao(0L, 0L, 0L, composer, 3072, 7) : buttonColors;
        PaddingValues textButtonContentPadding = (i2 & 256) != 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(288797557, i, -1, "androidx.compose.material.TextButton (Button.kt:221)");
        }
        Button(interfaceC3588op, modifier2, z2, mutableInteractionSource2, buttonElevation2, small, borderStroke2, buttonColorsM1024textButtonColorsRGew2ao, textButtonContentPadding, interfaceC0552Gp, composer, i & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
