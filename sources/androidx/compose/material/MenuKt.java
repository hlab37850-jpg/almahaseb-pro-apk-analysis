package androidx.compose.material;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C0774Nm;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class MenuKt {
    private static final float DropdownMenuItemDefaultMinHeight;
    private static final float DropdownMenuVerticalPadding;
    public static final int InTransitionDuration = 120;
    private static final float MenuElevation;
    private static final float MenuVerticalMargin;
    public static final int OutTransitionDuration = 75;
    private static final float DropdownMenuItemHorizontalPadding = Dp.m5160constructorimpl(16);
    private static final float DropdownMenuItemDefaultMinWidth = Dp.m5160constructorimpl(112);
    private static final float DropdownMenuItemDefaultMaxWidth = Dp.m5160constructorimpl(TIFFConstants.TIFFTAG_MINSAMPLEVALUE);

    /* JADX INFO: renamed from: androidx.compose.material.MenuKt$DropdownMenuContent$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ ScrollState $scrollState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Modifier modifier, ScrollState scrollState, InterfaceC0552Gp interfaceC0552Gp, int i) {
            super(2);
            this.$modifier = modifier;
            this.$scrollState = scrollState;
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
                ComposerKt.traceEventStart(895555282, i, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:123)");
            }
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(IntrinsicKt.width(PaddingKt.m487paddingVpY3zN4$default(this.$modifier, 0.0f, MenuKt.getDropdownMenuVerticalPadding(), 1, null), IntrinsicSize.Max), this.$scrollState, false, null, false, 14, null);
            InterfaceC0552Gp interfaceC0552Gp = this.$content;
            int i2 = (this.$$dirty >> 3) & 7168;
            composer.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            composer.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierVerticalScroll$default);
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            interfaceC0552Gp.invoke(ColumnScopeInstance.INSTANCE, composer, Integer.valueOf(((i2 >> 6) & 112) | 6));
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.MenuKt$DropdownMenuContent$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ MutableTransitionState<Boolean> $expandedStates;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ ScrollState $scrollState;
        final /* synthetic */ MutableState<TransformOrigin> $transformOriginState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(MutableTransitionState<Boolean> mutableTransitionState, MutableState<TransformOrigin> mutableState, ScrollState scrollState, Modifier modifier, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
            super(2);
            this.$expandedStates = mutableTransitionState;
            this.$transformOriginState = mutableState;
            this.$scrollState = scrollState;
            this.$modifier = modifier;
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
            MenuKt.DropdownMenuContent(this.$expandedStates, this.$transformOriginState, this.$scrollState, this.$modifier, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.MenuKt$DropdownMenuItemContent$3, reason: invalid class name and case insensitive filesystem */
    public static final class C14273 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14273(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
            super(2);
            this.$onClick = interfaceC3588op;
            this.$modifier = modifier;
            this.$enabled = z;
            this.$contentPadding = paddingValues;
            this.$interactionSource = mutableInteractionSource;
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
            MenuKt.DropdownMenuItemContent(this.$onClick, this.$modifier, this.$enabled, this.$contentPadding, this.$interactionSource, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    static {
        float f = 8;
        MenuElevation = Dp.m5160constructorimpl(f);
        float f2 = 48;
        MenuVerticalMargin = Dp.m5160constructorimpl(f2);
        DropdownMenuVerticalPadding = Dp.m5160constructorimpl(f);
        DropdownMenuItemDefaultMinHeight = Dp.m5160constructorimpl(f2);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:107:0x0226  */
    /* JADX WARN: Code duplicated, block: B:109:0x022e  */
    /* JADX WARN: Code duplicated, block: B:112:0x0265  */
    /* JADX WARN: Code duplicated, block: B:117:0x0270  */
    /* JADX WARN: Code duplicated, block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x008b  */
    /* JADX WARN: Code duplicated, block: B:48:0x008f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0095  */
    /* JADX WARN: Code duplicated, block: B:52:0x009b  */
    /* JADX WARN: Code duplicated, block: B:53:0x009e  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:69:0x0103  */
    /* JADX WARN: Code duplicated, block: B:72:0x010d  */
    /* JADX WARN: Code duplicated, block: B:73:0x0110  */
    /* JADX WARN: Code duplicated, block: B:76:0x0119  */
    /* JADX WARN: Code duplicated, block: B:79:0x0136  */
    /* JADX WARN: Code duplicated, block: B:81:0x013b  */
    /* JADX WARN: Code duplicated, block: B:84:0x0143  */
    /* JADX WARN: Code duplicated, block: B:87:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:88:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:91:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:92:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:95:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d2  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void DropdownMenuContent(MutableTransitionState<Boolean> mutableTransitionState, MutableState<TransformOrigin> mutableState, ScrollState scrollState, Modifier modifier, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        Modifier modifier3;
        boolean zBooleanValue;
        float f;
        State stateCreateTransitionAnimation;
        boolean zBooleanValue2;
        int i6;
        float f2;
        State stateCreateTransitionAnimation2;
        boolean zChanged;
        Object objRememberedValue;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(mutableTransitionState, "expandedStates");
        AbstractC4492zt.h(mutableState, "transformOriginState");
        AbstractC4492zt.h(scrollState, "scrollState");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(435109845);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(mutableTransitionState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(mutableState) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(scrollState) ? 256 : 128;
        }
        int i7 = i2 & 8;
        if (i7 == 0) {
            if ((i & 7168) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i4 = 16384;
                } else {
                    i4 = 8192;
                }
                i3 |= i4;
            }
            i5 = i3;
            if ((46811 & i5) == 9362 || !composerStartRestartGroup.getSkipping()) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(435109845, i5, -1, "androidx.compose.material.DropdownMenuContent (Menu.kt:60)");
                }
                Transition transitionUpdateTransition = TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, "DropDownMenu", composerStartRestartGroup, MutableTransitionState.$stable | 48 | (i5 & 14), 0);
                MenuKt$DropdownMenuContent$scale$2 menuKt$DropdownMenuContent$scale$2 = MenuKt$DropdownMenuContent$scale$2.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-1338768149);
                C0774Nm c0774Nm = C0774Nm.a;
                TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(c0774Nm);
                composerStartRestartGroup.startReplaceableGroup(-142660079);
                zBooleanValue = ((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue();
                composerStartRestartGroup.startReplaceableGroup(1652594929);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1652594929, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:86)");
                }
                if (zBooleanValue) {
                    f = 1.0f;
                } else {
                    f = 0.8f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf = Float.valueOf(f);
                boolean zBooleanValue3 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
                composerStartRestartGroup.startReplaceableGroup(1652594929);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1652594929, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:86)");
                }
                float f3 = zBooleanValue3 ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifier4 = modifier3;
                stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f3), (FiniteAnimationSpec) menuKt$DropdownMenuContent$scale$2.invoke((Object) transitionUpdateTransition.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                MenuKt$DropdownMenuContent$alpha$2 menuKt$DropdownMenuContent$alpha$2 = MenuKt$DropdownMenuContent$alpha$2.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-1338768149);
                TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(c0774Nm);
                composerStartRestartGroup.startReplaceableGroup(-142660079);
                zBooleanValue2 = ((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue();
                composerStartRestartGroup.startReplaceableGroup(388050693);
                if (ComposerKt.isTraceInProgress()) {
                    i6 = 0;
                    ComposerKt.traceEventStart(388050693, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:106)");
                } else {
                    i6 = 0;
                }
                if (zBooleanValue2) {
                    f2 = 1.0f;
                } else {
                    f2 = 0.0f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                Float fValueOf2 = Float.valueOf(f2);
                boolean zBooleanValue4 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
                composerStartRestartGroup.startReplaceableGroup(388050693);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(388050693, i6, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:106)");
                }
                float f4 = zBooleanValue4 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceableGroup();
                stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f4), (FiniteAnimationSpec) menuKt$DropdownMenuContent$alpha$2.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, Integer.valueOf(i6)), vectorConverter2, "FloatAnimation", composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier.Companion companion = Modifier.Companion;
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                zChanged = composerStartRestartGroup.changed(stateCreateTransitionAnimation) | composerStartRestartGroup.changed(stateCreateTransitionAnimation2) | composerStartRestartGroup.changed(mutableState);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new MenuKt$DropdownMenuContent$1$1(mutableState, stateCreateTransitionAnimation, stateCreateTransitionAnimation2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CardKt.m1026CardFjzlyU(GraphicsLayerModifierKt.graphicsLayer(companion, (InterfaceC3750qp) objRememberedValue), null, 0L, 0L, null, MenuElevation, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 895555282, true, new AnonymousClass2(modifier4, scrollState, interfaceC0552Gp, i5)), composerStartRestartGroup, 1769472, 30);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(mutableTransitionState, mutableState, scrollState, modifier2, interfaceC0552Gp, i, i2));
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((57344 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                i4 = 16384;
            } else {
                i4 = 8192;
            }
            i3 |= i4;
        }
        i5 = i3;
        if ((46811 & i5) == 9362) {
            if (i7 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(435109845, i5, -1, "androidx.compose.material.DropdownMenuContent (Menu.kt:60)");
            }
            Transition transitionUpdateTransition2 = TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, "DropDownMenu", composerStartRestartGroup, MutableTransitionState.$stable | 48 | (i5 & 14), 0);
            MenuKt$DropdownMenuContent$scale$2 menuKt$DropdownMenuContent$scale$3 = MenuKt$DropdownMenuContent$scale$2.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-1338768149);
            C0774Nm c0774Nm2 = C0774Nm.a;
            TwoWayConverter<Float, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(c0774Nm2);
            composerStartRestartGroup.startReplaceableGroup(-142660079);
            zBooleanValue = ((Boolean) transitionUpdateTransition2.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(1652594929);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1652594929, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:86)");
            }
            if (zBooleanValue) {
                f = 1.0f;
            } else {
                f = 0.8f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf3 = Float.valueOf(f);
            boolean zBooleanValue5 = ((Boolean) transitionUpdateTransition2.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(1652594929);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1652594929, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:86)");
            }
            if (zBooleanValue5) {
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifier5 = modifier3;
            stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition2, fValueOf3, Float.valueOf(f3), (FiniteAnimationSpec) menuKt$DropdownMenuContent$scale$3.invoke((Object) transitionUpdateTransition2.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter3, "FloatAnimation", composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            MenuKt$DropdownMenuContent$alpha$2 menuKt$DropdownMenuContent$alpha$3 = MenuKt$DropdownMenuContent$alpha$2.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-1338768149);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter4 = VectorConvertersKt.getVectorConverter(c0774Nm2);
            composerStartRestartGroup.startReplaceableGroup(-142660079);
            zBooleanValue2 = ((Boolean) transitionUpdateTransition2.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(388050693);
            if (ComposerKt.isTraceInProgress()) {
                i6 = 0;
                ComposerKt.traceEventStart(388050693, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:106)");
            } else {
                i6 = 0;
            }
            if (zBooleanValue2) {
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf4 = Float.valueOf(f2);
            boolean zBooleanValue6 = ((Boolean) transitionUpdateTransition2.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(388050693);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(388050693, i6, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:106)");
            }
            if (zBooleanValue6) {
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition2, fValueOf4, Float.valueOf(f4), (FiniteAnimationSpec) menuKt$DropdownMenuContent$alpha$3.invoke(transitionUpdateTransition2.getSegment(), composerStartRestartGroup, Integer.valueOf(i6)), vectorConverter4, "FloatAnimation", composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier.Companion companion2 = Modifier.Companion;
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            zChanged = composerStartRestartGroup.changed(stateCreateTransitionAnimation) | composerStartRestartGroup.changed(stateCreateTransitionAnimation2) | composerStartRestartGroup.changed(mutableState);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new MenuKt$DropdownMenuContent$1$1(mutableState, stateCreateTransitionAnimation, stateCreateTransitionAnimation2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new MenuKt$DropdownMenuContent$1$1(mutableState, stateCreateTransitionAnimation, stateCreateTransitionAnimation2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CardKt.m1026CardFjzlyU(GraphicsLayerModifierKt.graphicsLayer(companion2, (InterfaceC3750qp) objRememberedValue), null, 0L, 0L, null, MenuElevation, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 895555282, true, new AnonymousClass2(modifier5, scrollState, interfaceC0552Gp, i5)), composerStartRestartGroup, 1769472, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        } else {
            if (i7 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(435109845, i5, -1, "androidx.compose.material.DropdownMenuContent (Menu.kt:60)");
            }
            Transition transitionUpdateTransition3 = TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, "DropDownMenu", composerStartRestartGroup, MutableTransitionState.$stable | 48 | (i5 & 14), 0);
            MenuKt$DropdownMenuContent$scale$2 menuKt$DropdownMenuContent$scale$4 = MenuKt$DropdownMenuContent$scale$2.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-1338768149);
            C0774Nm c0774Nm3 = C0774Nm.a;
            TwoWayConverter<Float, AnimationVector1D> vectorConverter5 = VectorConvertersKt.getVectorConverter(c0774Nm3);
            composerStartRestartGroup.startReplaceableGroup(-142660079);
            zBooleanValue = ((Boolean) transitionUpdateTransition3.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(1652594929);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1652594929, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:86)");
            }
            if (zBooleanValue) {
                f = 1.0f;
            } else {
                f = 0.8f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf5 = Float.valueOf(f);
            boolean zBooleanValue7 = ((Boolean) transitionUpdateTransition3.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(1652594929);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1652594929, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:86)");
            }
            if (zBooleanValue7) {
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifier6 = modifier3;
            stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition3, fValueOf5, Float.valueOf(f3), (FiniteAnimationSpec) menuKt$DropdownMenuContent$scale$4.invoke((Object) transitionUpdateTransition3.getSegment(), (Object) composerStartRestartGroup, (Object) 0), vectorConverter5, "FloatAnimation", composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            MenuKt$DropdownMenuContent$alpha$2 menuKt$DropdownMenuContent$alpha$4 = MenuKt$DropdownMenuContent$alpha$2.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-1338768149);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter6 = VectorConvertersKt.getVectorConverter(c0774Nm3);
            composerStartRestartGroup.startReplaceableGroup(-142660079);
            zBooleanValue2 = ((Boolean) transitionUpdateTransition3.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(388050693);
            if (ComposerKt.isTraceInProgress()) {
                i6 = 0;
                ComposerKt.traceEventStart(388050693, 0, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:106)");
            } else {
                i6 = 0;
            }
            if (zBooleanValue2) {
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Float fValueOf6 = Float.valueOf(f2);
            boolean zBooleanValue8 = ((Boolean) transitionUpdateTransition3.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceableGroup(388050693);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(388050693, i6, -1, "androidx.compose.material.DropdownMenuContent.<anonymous> (Menu.kt:106)");
            }
            if (zBooleanValue8) {
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition3, fValueOf6, Float.valueOf(f4), (FiniteAnimationSpec) menuKt$DropdownMenuContent$alpha$4.invoke(transitionUpdateTransition3.getSegment(), composerStartRestartGroup, Integer.valueOf(i6)), vectorConverter6, "FloatAnimation", composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier.Companion companion3 = Modifier.Companion;
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            zChanged = composerStartRestartGroup.changed(stateCreateTransitionAnimation) | composerStartRestartGroup.changed(stateCreateTransitionAnimation2) | composerStartRestartGroup.changed(mutableState);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new MenuKt$DropdownMenuContent$1$1(mutableState, stateCreateTransitionAnimation, stateCreateTransitionAnimation2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new MenuKt$DropdownMenuContent$1$1(mutableState, stateCreateTransitionAnimation, stateCreateTransitionAnimation2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CardKt.m1026CardFjzlyU(GraphicsLayerModifierKt.graphicsLayer(companion3, (InterfaceC3750qp) objRememberedValue), null, 0L, 0L, null, MenuElevation, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 895555282, true, new AnonymousClass2(modifier6, scrollState, interfaceC0552Gp, i5)), composerStartRestartGroup, 1769472, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier6;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(mutableTransitionState, mutableState, scrollState, modifier2, interfaceC0552Gp, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DropdownMenuContent$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DropdownMenuContent$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:102:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:105:0x0225  */
    /* JADX WARN: Code duplicated, block: B:110:0x0234  */
    /* JADX WARN: Code duplicated, block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:44:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x0098  */
    /* JADX WARN: Code duplicated, block: B:55:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:79:0x00db  */
    /* JADX WARN: Code duplicated, block: B:80:0x00de  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:84:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:90:0x0110  */
    /* JADX WARN: Code duplicated, block: B:93:0x018e  */
    /* JADX WARN: Code duplicated, block: B:96:0x019a  */
    /* JADX WARN: Code duplicated, block: B:97:0x019e  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void DropdownMenuItemContent(InterfaceC3588op interfaceC3588op, Modifier modifier, boolean z, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        PaddingValues dropdownMenuItemContentPadding;
        int i7;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        int i9;
        int i10;
        int i11;
        Modifier modifier3;
        boolean z3;
        int currentCompositeKeyHash;
        InterfaceC3588op constructor;
        Composer composerM2661constructorimpl;
        InterfaceC0526Fp setCompositeKeyHash;
        PaddingValues paddingValues2;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier4;
        boolean z4;
        Object objRememberedValue;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC3588op, "onClick");
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(87134531);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
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
                        dropdownMenuItemContentPadding = paddingValues;
                        if (composerStartRestartGroup.changed(dropdownMenuItemContentPadding)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((57344 & i) == 0) {
                            mutableInteractionSource2 = mutableInteractionSource;
                            if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        if ((i2 & 32) != 0) {
                            if ((458752 & i) == 0) {
                                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                    i10 = 131072;
                                } else {
                                    i10 = 65536;
                                }
                            }
                            i11 = i3;
                            if ((374491 & i11) == 74898 || !composerStartRestartGroup.getSkipping()) {
                                if (i12 != 0) {
                                    modifier3 = Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                if (i6 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                }
                                if (i8 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                                }
                                PaddingValues paddingValues3 = dropdownMenuItemContentPadding;
                                Modifier modifierPadding = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues3);
                                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                composerStartRestartGroup.startReplaceableGroup(693286680);
                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                                constructor = companion.getConstructor();
                                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierPadding);
                                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.createNode(constructor);
                                } else {
                                    composerStartRestartGroup.useNode();
                                }
                                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
                                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                                setCompositeKeyHash = companion.getSetCompositeKeyHash();
                                if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                                composerStartRestartGroup.startReplaceableGroup(2058660585);
                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endNode();
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                paddingValues2 = paddingValues3;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                modifier4 = modifier3;
                                z4 = z3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier4 = modifier2;
                                z4 = z2;
                                paddingValues2 = dropdownMenuItemContentPadding;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                        }
                        i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        i3 |= i10;
                        i11 = i3;
                        if ((374491 & i11) == 74898) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                            }
                            PaddingValues paddingValues4 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding2 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues4);
                            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                            constructor = companion2.getConstructor();
                            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierPadding2);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy2, companion2.getSetMeasurePolicy());
                            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                            if (composerM2661constructorimpl.getInserting()) {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            } else {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues2 = paddingValues4;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                            }
                            PaddingValues paddingValues5 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding3 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues5);
                            Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                            constructor = companion3.getConstructor();
                            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierPadding3);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy3, companion3.getSetMeasurePolicy());
                            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                            if (composerM2661constructorimpl.getInserting()) {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            } else {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            interfaceC0552GpModifierMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues2 = paddingValues5;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                    }
                    i3 |= 24576;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i2 & 32) != 0) {
                        if ((458752 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                        }
                        i11 = i3;
                        if ((374491 & i11) == 74898) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                            }
                            PaddingValues paddingValues6 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding4 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues6);
                            Alignment.Vertical centerVertically4 = Alignment.Companion.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically4, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
                            constructor = companion4.getConstructor();
                            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(modifierPadding4);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy4, companion4.getSetMeasurePolicy());
                            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                            if (composerM2661constructorimpl.getInserting()) {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            } else {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            interfaceC0552GpModifierMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues2 = paddingValues6;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                            }
                            PaddingValues paddingValues7 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding5 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues7);
                            Alignment.Vertical centerVertically5 = Alignment.Companion.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically5, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            ComposeUiNode.Companion companion5 = ComposeUiNode.Companion;
                            constructor = companion5.getConstructor();
                            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(modifierPadding5);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy5, companion5.getSetMeasurePolicy());
                            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap5, companion5.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = companion5.getSetCompositeKeyHash();
                            if (composerM2661constructorimpl.getInserting()) {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            } else {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            interfaceC0552GpModifierMaterializerOf5.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues2 = paddingValues7;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                    }
                    i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i3 |= i10;
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues8 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding6 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues8);
                        Alignment.Vertical centerVertically6 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically6, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion6 = ComposeUiNode.Companion;
                        constructor = companion6.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(modifierPadding6);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy6, companion6.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap6, companion6.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion6.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf6.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues8;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues9 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding7 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues9);
                        Alignment.Vertical centerVertically7 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically7, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion7 = ComposeUiNode.Companion;
                        constructor = companion7.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(modifierPadding7);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy7, companion7.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap7, companion7.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion7.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf7.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues9;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i3 |= 3072;
                dropdownMenuItemContentPadding = paddingValues;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        if ((458752 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                        }
                        i11 = i3;
                        if ((374491 & i11) == 74898) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                            }
                            PaddingValues paddingValues10 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding8 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues10);
                            Alignment.Vertical centerVertically8 = Alignment.Companion.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically8, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            ComposeUiNode.Companion companion8 = ComposeUiNode.Companion;
                            constructor = companion8.getConstructor();
                            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf8 = LayoutKt.modifierMaterializerOf(modifierPadding8);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy8, companion8.getSetMeasurePolicy());
                            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap8, companion8.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = companion8.getSetCompositeKeyHash();
                            if (composerM2661constructorimpl.getInserting()) {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            } else {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            interfaceC0552GpModifierMaterializerOf8.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues2 = paddingValues10;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                            }
                            PaddingValues paddingValues11 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding9 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11);
                            Alignment.Vertical centerVertically9 = Alignment.Companion.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyRowMeasurePolicy9 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically9, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            ComposeUiNode.Companion companion9 = ComposeUiNode.Companion;
                            constructor = companion9.getConstructor();
                            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf9 = LayoutKt.modifierMaterializerOf(modifierPadding9);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy9, companion9.getSetMeasurePolicy());
                            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap9, companion9.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = companion9.getSetCompositeKeyHash();
                            if (composerM2661constructorimpl.getInserting()) {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            } else {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            interfaceC0552GpModifierMaterializerOf9.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues2 = paddingValues11;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                    }
                    i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i3 |= i10;
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues12 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding10 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues12);
                        Alignment.Vertical centerVertically10 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy10 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically10, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion10 = ComposeUiNode.Companion;
                        constructor = companion10.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf10 = LayoutKt.modifierMaterializerOf(modifierPadding10);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy10, companion10.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap10, companion10.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion10.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf10.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues12;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues13 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding11 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues13);
                        Alignment.Vertical centerVertically11 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy11 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion11 = ComposeUiNode.Companion;
                        constructor = companion11.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf11 = LayoutKt.modifierMaterializerOf(modifierPadding11);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy11, companion11.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap11, companion11.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion11.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf11.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues13;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues14 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding12 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues14);
                        Alignment.Vertical centerVertically12 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy12 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically12, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion12 = ComposeUiNode.Companion;
                        constructor = companion12.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf12 = LayoutKt.modifierMaterializerOf(modifierPadding12);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy12, companion12.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap12, companion12.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion12.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf12.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues14;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues15 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding13 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues15);
                        Alignment.Vertical centerVertically13 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy13 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically13, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion13 = ComposeUiNode.Companion;
                        constructor = companion13.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf13 = LayoutKt.modifierMaterializerOf(modifierPadding13);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy13, companion13.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap13, companion13.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion13.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf13.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues15;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues16 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding14 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues16);
                    Alignment.Vertical centerVertically14 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy14 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically14, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion14 = ComposeUiNode.Companion;
                    constructor = companion14.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf14 = LayoutKt.modifierMaterializerOf(modifierPadding14);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy14, companion14.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap14, companion14.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion14.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf14.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues16;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues17 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding15 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues17);
                    Alignment.Vertical centerVertically15 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy15 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically15, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion15 = ComposeUiNode.Companion;
                    constructor = companion15.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf15 = LayoutKt.modifierMaterializerOf(modifierPadding15);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy15, companion15.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap15, companion15.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion15.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf15.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues17;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i3 |= 384;
            z2 = z;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    dropdownMenuItemContentPadding = paddingValues;
                    if (composerStartRestartGroup.changed(dropdownMenuItemContentPadding)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        if ((458752 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                        }
                        i11 = i3;
                        if ((374491 & i11) == 74898) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                            }
                            PaddingValues paddingValues18 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding16 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues18);
                            Alignment.Vertical centerVertically16 = Alignment.Companion.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyRowMeasurePolicy16 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically16, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            ComposeUiNode.Companion companion16 = ComposeUiNode.Companion;
                            constructor = companion16.getConstructor();
                            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf16 = LayoutKt.modifierMaterializerOf(modifierPadding16);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy16, companion16.getSetMeasurePolicy());
                            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap16, companion16.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = companion16.getSetCompositeKeyHash();
                            if (composerM2661constructorimpl.getInserting()) {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            } else {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            interfaceC0552GpModifierMaterializerOf16.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues2 = paddingValues18;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                            }
                            PaddingValues paddingValues19 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding17 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues19);
                            Alignment.Vertical centerVertically17 = Alignment.Companion.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyRowMeasurePolicy17 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically17, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            ComposeUiNode.Companion companion17 = ComposeUiNode.Companion;
                            constructor = companion17.getConstructor();
                            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf17 = LayoutKt.modifierMaterializerOf(modifierPadding17);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy17, companion17.getSetMeasurePolicy());
                            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap17, companion17.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = companion17.getSetCompositeKeyHash();
                            if (composerM2661constructorimpl.getInserting()) {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            } else {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            interfaceC0552GpModifierMaterializerOf17.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues2 = paddingValues19;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                    }
                    i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i3 |= i10;
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues110 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding18 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues110);
                        Alignment.Vertical centerVertically18 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy18 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically18, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap18 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion18 = ComposeUiNode.Companion;
                        constructor = companion18.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf18 = LayoutKt.modifierMaterializerOf(modifierPadding18);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy18, companion18.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap18, companion18.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion18.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf18.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues110;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues111 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding19 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111);
                        Alignment.Vertical centerVertically19 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy19 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically19, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion19 = ComposeUiNode.Companion;
                        constructor = companion19.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf19 = LayoutKt.modifierMaterializerOf(modifierPadding19);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy19, companion19.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap19, companion19.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion19.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf19.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues111;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues112 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding110 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues112);
                        Alignment.Vertical centerVertically110 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy110 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically110, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion110 = ComposeUiNode.Companion;
                        constructor = companion110.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf110 = LayoutKt.modifierMaterializerOf(modifierPadding110);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy110, companion110.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap110, companion110.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion110.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf110.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues112;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues113 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding111 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues113);
                        Alignment.Vertical centerVertically111 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy111 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion111 = ComposeUiNode.Companion;
                        constructor = companion111.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf111 = LayoutKt.modifierMaterializerOf(modifierPadding111);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy111, companion111.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap111, companion111.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion111.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf111.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues113;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues114 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding112 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues114);
                    Alignment.Vertical centerVertically112 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy112 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically112, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion112 = ComposeUiNode.Companion;
                    constructor = companion112.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf112 = LayoutKt.modifierMaterializerOf(modifierPadding112);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy112, companion112.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap112, companion112.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion112.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf112.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues114;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues115 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding113 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues115);
                    Alignment.Vertical centerVertically113 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy113 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically113, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion113 = ComposeUiNode.Companion;
                    constructor = companion113.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf113 = LayoutKt.modifierMaterializerOf(modifierPadding113);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy113, companion113.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap113, companion113.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion113.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf113.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues115;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i3 |= 3072;
            dropdownMenuItemContentPadding = paddingValues;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues116 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding114 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues116);
                        Alignment.Vertical centerVertically114 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy114 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically114, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion114 = ComposeUiNode.Companion;
                        constructor = companion114.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf114 = LayoutKt.modifierMaterializerOf(modifierPadding114);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy114, companion114.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap114, companion114.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion114.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf114.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues116;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues117 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding115 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues117);
                        Alignment.Vertical centerVertically115 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy115 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically115, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion115 = ComposeUiNode.Companion;
                        constructor = companion115.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf115 = LayoutKt.modifierMaterializerOf(modifierPadding115);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy115, companion115.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap115, companion115.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion115.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf115.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues117;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues118 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding116 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues118);
                    Alignment.Vertical centerVertically116 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy116 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically116, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion116 = ComposeUiNode.Companion;
                    constructor = companion116.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf116 = LayoutKt.modifierMaterializerOf(modifierPadding116);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy116, companion116.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap116, companion116.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion116.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf116.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues118;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues119 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding117 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues119);
                    Alignment.Vertical centerVertically117 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy117 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically117, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion117 = ComposeUiNode.Companion;
                    constructor = companion117.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf117 = LayoutKt.modifierMaterializerOf(modifierPadding117);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy117, companion117.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap117, companion117.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion117.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf117.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues119;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                }
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues1110 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding118 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1110);
                    Alignment.Vertical centerVertically118 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy118 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically118, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap118 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion118 = ComposeUiNode.Companion;
                    constructor = companion118.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf118 = LayoutKt.modifierMaterializerOf(modifierPadding118);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy118, companion118.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap118, companion118.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion118.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf118.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues1110;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues1111 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding119 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1111);
                    Alignment.Vertical centerVertically119 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy119 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically119, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion119 = ComposeUiNode.Companion;
                    constructor = companion119.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf119 = LayoutKt.modifierMaterializerOf(modifierPadding119);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy119, companion119.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap119, companion119.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion119.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf119.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues1111;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i10;
            i11 = i3;
            if ((374491 & i11) == 74898) {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                }
                PaddingValues paddingValues1112 = dropdownMenuItemContentPadding;
                Modifier modifierPadding1110 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1112);
                Alignment.Vertical centerVertically1110 = Alignment.Companion.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy1110 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1110, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap1110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion1110 = ComposeUiNode.Companion;
                constructor = companion1110.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf1110 = LayoutKt.modifierMaterializerOf(modifierPadding1110);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy1110, companion1110.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap1110, companion1110.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion1110.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf1110.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues1112;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                }
                PaddingValues paddingValues1113 = dropdownMenuItemContentPadding;
                Modifier modifierPadding1111 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1113);
                Alignment.Vertical centerVertically1111 = Alignment.Companion.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy1111 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1111, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap1111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion1111 = ComposeUiNode.Companion;
                constructor = companion1111.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf1111 = LayoutKt.modifierMaterializerOf(modifierPadding1111);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy1111, companion1111.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap1111, companion1111.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion1111.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf1111.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues1113;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
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
                    dropdownMenuItemContentPadding = paddingValues;
                    if (composerStartRestartGroup.changed(dropdownMenuItemContentPadding)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        if ((458752 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                        }
                        i11 = i3;
                        if ((374491 & i11) == 74898) {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                            }
                            PaddingValues paddingValues1114 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding1112 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1114);
                            Alignment.Vertical centerVertically1112 = Alignment.Companion.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyRowMeasurePolicy1112 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1112, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap1112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            ComposeUiNode.Companion companion1112 = ComposeUiNode.Companion;
                            constructor = companion1112.getConstructor();
                            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf1112 = LayoutKt.modifierMaterializerOf(modifierPadding1112);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy1112, companion1112.getSetMeasurePolicy());
                            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap1112, companion1112.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = companion1112.getSetCompositeKeyHash();
                            if (composerM2661constructorimpl.getInserting()) {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            } else {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            interfaceC0552GpModifierMaterializerOf1112.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues2 = paddingValues1114;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                        } else {
                            if (i12 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i6 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                            }
                            PaddingValues paddingValues1115 = dropdownMenuItemContentPadding;
                            Modifier modifierPadding1113 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1115);
                            Alignment.Vertical centerVertically1113 = Alignment.Companion.getCenterVertically();
                            composerStartRestartGroup.startReplaceableGroup(693286680);
                            MeasurePolicy measurePolicyRowMeasurePolicy1113 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1113, composerStartRestartGroup, 48);
                            composerStartRestartGroup.startReplaceableGroup(-1323940314);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap1113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            ComposeUiNode.Companion companion1113 = ComposeUiNode.Companion;
                            constructor = companion1113.getConstructor();
                            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf1113 = LayoutKt.modifierMaterializerOf(modifierPadding1113);
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy1113, companion1113.getSetMeasurePolicy());
                            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap1113, companion1113.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = companion1113.getSetCompositeKeyHash();
                            if (composerM2661constructorimpl.getInserting()) {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            } else {
                                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            interfaceC0552GpModifierMaterializerOf1113.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.startReplaceableGroup(2058660585);
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            paddingValues2 = paddingValues1115;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier4 = modifier3;
                            z4 = z3;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                    }
                    i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i3 |= i10;
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues1116 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding1114 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1116);
                        Alignment.Vertical centerVertically1114 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy1114 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1114, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap1114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion1114 = ComposeUiNode.Companion;
                        constructor = companion1114.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf1114 = LayoutKt.modifierMaterializerOf(modifierPadding1114);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy1114, companion1114.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap1114, companion1114.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion1114.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf1114.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues1116;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues1117 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding1115 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1117);
                        Alignment.Vertical centerVertically1115 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy1115 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1115, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap1115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion1115 = ComposeUiNode.Companion;
                        constructor = companion1115.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf1115 = LayoutKt.modifierMaterializerOf(modifierPadding1115);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy1115, companion1115.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap1115, companion1115.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion1115.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf1115.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues1117;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues1118 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding1116 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1118);
                        Alignment.Vertical centerVertically1116 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy1116 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1116, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap1116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion1116 = ComposeUiNode.Companion;
                        constructor = companion1116.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf1116 = LayoutKt.modifierMaterializerOf(modifierPadding1116);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy1116, companion1116.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap1116, companion1116.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion1116.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf1116.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues1118;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues1119 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding1117 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1119);
                        Alignment.Vertical centerVertically1117 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy1117 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1117, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap1117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion1117 = ComposeUiNode.Companion;
                        constructor = companion1117.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf1117 = LayoutKt.modifierMaterializerOf(modifierPadding1117);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy1117, companion1117.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap1117, companion1117.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion1117.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf1117.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues1119;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues11110 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding1118 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11110);
                    Alignment.Vertical centerVertically1118 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy1118 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1118, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap1118 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion1118 = ComposeUiNode.Companion;
                    constructor = companion1118.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf1118 = LayoutKt.modifierMaterializerOf(modifierPadding1118);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy1118, companion1118.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap1118, companion1118.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion1118.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf1118.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues11110;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues11111 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding1119 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11111);
                    Alignment.Vertical centerVertically1119 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy1119 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1119, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap1119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion1119 = ComposeUiNode.Companion;
                    constructor = companion1119.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf1119 = LayoutKt.modifierMaterializerOf(modifierPadding1119);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy1119, companion1119.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap1119, companion1119.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion1119.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf1119.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues11111;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i3 |= 3072;
            dropdownMenuItemContentPadding = paddingValues;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues11112 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding11110 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11112);
                        Alignment.Vertical centerVertically11110 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy11110 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11110, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap11110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion11110 = ComposeUiNode.Companion;
                        constructor = companion11110.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf11110 = LayoutKt.modifierMaterializerOf(modifierPadding11110);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy11110, companion11110.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap11110, companion11110.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion11110.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf11110.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues11112;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues11113 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding11111 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11113);
                        Alignment.Vertical centerVertically11111 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy11111 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11111, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap11111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion11111 = ComposeUiNode.Companion;
                        constructor = companion11111.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf11111 = LayoutKt.modifierMaterializerOf(modifierPadding11111);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy11111, companion11111.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap11111, companion11111.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion11111.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf11111.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues11113;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues11114 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding11112 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11114);
                    Alignment.Vertical centerVertically11112 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy11112 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11112, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap11112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion11112 = ComposeUiNode.Companion;
                    constructor = companion11112.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf11112 = LayoutKt.modifierMaterializerOf(modifierPadding11112);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy11112, companion11112.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap11112, companion11112.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion11112.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf11112.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues11114;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues11115 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding11113 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11115);
                    Alignment.Vertical centerVertically11113 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy11113 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11113, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap11113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion11113 = ComposeUiNode.Companion;
                    constructor = companion11113.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf11113 = LayoutKt.modifierMaterializerOf(modifierPadding11113);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy11113, companion11113.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap11113, companion11113.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion11113.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf11113.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues11115;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                }
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues11116 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding11114 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11116);
                    Alignment.Vertical centerVertically11114 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy11114 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11114, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap11114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion11114 = ComposeUiNode.Companion;
                    constructor = companion11114.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf11114 = LayoutKt.modifierMaterializerOf(modifierPadding11114);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy11114, companion11114.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap11114, companion11114.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion11114.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf11114.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues11116;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues11117 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding11115 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11117);
                    Alignment.Vertical centerVertically11115 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy11115 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11115, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap11115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion11115 = ComposeUiNode.Companion;
                    constructor = companion11115.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf11115 = LayoutKt.modifierMaterializerOf(modifierPadding11115);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy11115, companion11115.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap11115, companion11115.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion11115.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf11115.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues11117;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i10;
            i11 = i3;
            if ((374491 & i11) == 74898) {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                }
                PaddingValues paddingValues11118 = dropdownMenuItemContentPadding;
                Modifier modifierPadding11116 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11118);
                Alignment.Vertical centerVertically11116 = Alignment.Companion.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy11116 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11116, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap11116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion11116 = ComposeUiNode.Companion;
                constructor = companion11116.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf11116 = LayoutKt.modifierMaterializerOf(modifierPadding11116);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy11116, companion11116.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap11116, companion11116.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion11116.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf11116.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues11118;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                }
                PaddingValues paddingValues11119 = dropdownMenuItemContentPadding;
                Modifier modifierPadding11117 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues11119);
                Alignment.Vertical centerVertically11117 = Alignment.Companion.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy11117 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11117, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap11117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion11117 = ComposeUiNode.Companion;
                constructor = companion11117.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf11117 = LayoutKt.modifierMaterializerOf(modifierPadding11117);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy11117, companion11117.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap11117, companion11117.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion11117.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf11117.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues11119;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
        }
        i3 |= 384;
        z2 = z;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                dropdownMenuItemContentPadding = paddingValues;
                if (composerStartRestartGroup.changed(dropdownMenuItemContentPadding)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    if ((458752 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                    }
                    i11 = i3;
                    if ((374491 & i11) == 74898) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues111110 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding11118 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111110);
                        Alignment.Vertical centerVertically11118 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy11118 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11118, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap11118 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion11118 = ComposeUiNode.Companion;
                        constructor = companion11118.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf11118 = LayoutKt.modifierMaterializerOf(modifierPadding11118);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy11118, companion11118.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap11118, companion11118.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion11118.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf11118.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues111110;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    } else {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i6 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                        }
                        PaddingValues paddingValues111111 = dropdownMenuItemContentPadding;
                        Modifier modifierPadding11119 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111111);
                        Alignment.Vertical centerVertically11119 = Alignment.Companion.getCenterVertically();
                        composerStartRestartGroup.startReplaceableGroup(693286680);
                        MeasurePolicy measurePolicyRowMeasurePolicy11119 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11119, composerStartRestartGroup, 48);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap11119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion11119 = ComposeUiNode.Companion;
                        constructor = companion11119.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf11119 = LayoutKt.modifierMaterializerOf(modifierPadding11119);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy11119, companion11119.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap11119, companion11119.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = companion11119.getSetCompositeKeyHash();
                        if (composerM2661constructorimpl.getInserting()) {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        interfaceC0552GpModifierMaterializerOf11119.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues2 = paddingValues111111;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier4 = modifier3;
                        z4 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
                }
                i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i10;
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues111112 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding111110 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111112);
                    Alignment.Vertical centerVertically111110 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy111110 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111110, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap111110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion111110 = ComposeUiNode.Companion;
                    constructor = companion111110.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf111110 = LayoutKt.modifierMaterializerOf(modifierPadding111110);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy111110, companion111110.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap111110, companion111110.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion111110.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf111110.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues111112;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues111113 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding111111 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111113);
                    Alignment.Vertical centerVertically111111 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy111111 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111111, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap111111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion111111 = ComposeUiNode.Companion;
                    constructor = companion111111.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf111111 = LayoutKt.modifierMaterializerOf(modifierPadding111111);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy111111, companion111111.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap111111, companion111111.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion111111.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf111111.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues111113;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                }
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues111114 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding111112 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111114);
                    Alignment.Vertical centerVertically111112 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy111112 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111112, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap111112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion111112 = ComposeUiNode.Companion;
                    constructor = companion111112.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf111112 = LayoutKt.modifierMaterializerOf(modifierPadding111112);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy111112, companion111112.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap111112, companion111112.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion111112.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf111112.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues111114;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues111115 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding111113 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111115);
                    Alignment.Vertical centerVertically111113 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy111113 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111113, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap111113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion111113 = ComposeUiNode.Companion;
                    constructor = companion111113.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf111113 = LayoutKt.modifierMaterializerOf(modifierPadding111113);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy111113, companion111113.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap111113, companion111113.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion111113.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf111113.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues111115;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i10;
            i11 = i3;
            if ((374491 & i11) == 74898) {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                }
                PaddingValues paddingValues111116 = dropdownMenuItemContentPadding;
                Modifier modifierPadding111114 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111116);
                Alignment.Vertical centerVertically111114 = Alignment.Companion.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy111114 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111114, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap111114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion111114 = ComposeUiNode.Companion;
                constructor = companion111114.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf111114 = LayoutKt.modifierMaterializerOf(modifierPadding111114);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy111114, companion111114.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap111114, companion111114.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion111114.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf111114.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues111116;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                }
                PaddingValues paddingValues111117 = dropdownMenuItemContentPadding;
                Modifier modifierPadding111115 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111117);
                Alignment.Vertical centerVertically111115 = Alignment.Companion.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy111115 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111115, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap111115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion111115 = ComposeUiNode.Companion;
                constructor = companion111115.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf111115 = LayoutKt.modifierMaterializerOf(modifierPadding111115);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy111115, companion111115.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap111115, companion111115.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion111115.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf111115.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues111117;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
        }
        i3 |= 3072;
        dropdownMenuItemContentPadding = paddingValues;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((57344 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i2 & 32) != 0) {
                if ((458752 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                }
                i11 = i3;
                if ((374491 & i11) == 74898) {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues111118 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding111116 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111118);
                    Alignment.Vertical centerVertically111116 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy111116 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111116, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap111116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion111116 = ComposeUiNode.Companion;
                    constructor = companion111116.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf111116 = LayoutKt.modifierMaterializerOf(modifierPadding111116);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy111116, companion111116.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap111116, companion111116.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion111116.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf111116.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues111118;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                } else {
                    if (i12 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i6 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                    }
                    PaddingValues paddingValues111119 = dropdownMenuItemContentPadding;
                    Modifier modifierPadding111117 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues111119);
                    Alignment.Vertical centerVertically111117 = Alignment.Companion.getCenterVertically();
                    composerStartRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy111117 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111117, composerStartRestartGroup, 48);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap111117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion111117 = ComposeUiNode.Companion;
                    constructor = companion111117.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf111117 = LayoutKt.modifierMaterializerOf(modifierPadding111117);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy111117, companion111117.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap111117, companion111117.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = companion111117.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting()) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf111117.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues2 = paddingValues111119;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier4 = modifier3;
                    z4 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
            }
            i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i3 |= i10;
            i11 = i3;
            if ((374491 & i11) == 74898) {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                }
                PaddingValues paddingValues1111110 = dropdownMenuItemContentPadding;
                Modifier modifierPadding111118 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1111110);
                Alignment.Vertical centerVertically111118 = Alignment.Companion.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy111118 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111118, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap111118 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion111118 = ComposeUiNode.Companion;
                constructor = companion111118.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf111118 = LayoutKt.modifierMaterializerOf(modifierPadding111118);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy111118, companion111118.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap111118, companion111118.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion111118.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf111118.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues1111110;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                }
                PaddingValues paddingValues1111111 = dropdownMenuItemContentPadding;
                Modifier modifierPadding111119 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1111111);
                Alignment.Vertical centerVertically111119 = Alignment.Companion.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy111119 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111119, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap111119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion111119 = ComposeUiNode.Companion;
                constructor = companion111119.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf111119 = LayoutKt.modifierMaterializerOf(modifierPadding111119);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy111119, companion111119.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap111119, companion111119.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion111119.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf111119.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues1111111;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & 32) != 0) {
            if ((458752 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
            }
            i11 = i3;
            if ((374491 & i11) == 74898) {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                }
                PaddingValues paddingValues1111112 = dropdownMenuItemContentPadding;
                Modifier modifierPadding1111110 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1111112);
                Alignment.Vertical centerVertically1111110 = Alignment.Companion.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy1111110 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1111110, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap1111110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion1111110 = ComposeUiNode.Companion;
                constructor = companion1111110.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf1111110 = LayoutKt.modifierMaterializerOf(modifierPadding1111110);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy1111110, companion1111110.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap1111110, companion1111110.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion1111110.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf1111110.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues1111112;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
            } else {
                if (i12 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i6 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                }
                if (i8 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
                }
                PaddingValues paddingValues1111113 = dropdownMenuItemContentPadding;
                Modifier modifierPadding1111111 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1111113);
                Alignment.Vertical centerVertically1111111 = Alignment.Companion.getCenterVertically();
                composerStartRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy1111111 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1111111, composerStartRestartGroup, 48);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap1111111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion1111111 = ComposeUiNode.Companion;
                constructor = companion1111111.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf1111111 = LayoutKt.modifierMaterializerOf(modifierPadding1111111);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy1111111, companion1111111.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap1111111, companion1111111.getSetResolvedCompositionLocals());
                setCompositeKeyHash = companion1111111.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting()) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf1111111.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paddingValues2 = paddingValues1111113;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier4 = modifier3;
                z4 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
        }
        i10 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i3 |= i10;
        i11 = i3;
        if ((374491 & i11) == 74898) {
            if (i12 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            if (i6 != 0) {
                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
            }
            if (i8 != 0) {
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
            }
            PaddingValues paddingValues1111114 = dropdownMenuItemContentPadding;
            Modifier modifierPadding1111112 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1111114);
            Alignment.Vertical centerVertically1111112 = Alignment.Companion.getCenterVertically();
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy1111112 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1111112, composerStartRestartGroup, 48);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap1111112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion1111112 = ComposeUiNode.Companion;
            constructor = companion1111112.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf1111112 = LayoutKt.modifierMaterializerOf(modifierPadding1111112);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy1111112, companion1111112.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap1111112, companion1111112.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion1111112.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf1111112.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            paddingValues2 = paddingValues1111114;
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier4 = modifier3;
            z4 = z3;
        } else {
            if (i12 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            if (i6 != 0) {
                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
            }
            if (i8 != 0) {
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(87134531, i11, -1, "androidx.compose.material.DropdownMenuItemContent (Menu.kt:135)");
            }
            PaddingValues paddingValues1111115 = dropdownMenuItemContentPadding;
            Modifier modifierPadding1111113 = PaddingKt.padding(SizeKt.m536sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m197clickableO2vRcR0(modifier3, mutableInteractionSource2, RippleKt.m1318rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6), (24 & 4) != 0 ? true : z3, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, interfaceC3588op), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, DropdownMenuItemDefaultMinHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues1111115);
            Alignment.Vertical centerVertically1111113 = Alignment.Companion.getCenterVertically();
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy1111113 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1111113, composerStartRestartGroup, 48);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap1111113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion1111113 = ComposeUiNode.Companion;
            constructor = companion1111113.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf1111113 = LayoutKt.modifierMaterializerOf(modifierPadding1111113);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy1111113, companion1111113.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap1111113, companion1111113.getSetResolvedCompositionLocals());
            setCompositeKeyHash = companion1111113.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting()) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf1111113.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getSubtitle1(), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1190489496, true, new MenuKt$DropdownMenuItemContent$2$1(z3, interfaceC0552Gp, RowScopeInstance.INSTANCE, 6, i11)), composerStartRestartGroup, 48);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            paddingValues2 = paddingValues1111115;
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier4 = modifier3;
            z4 = z3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14273(interfaceC3588op, modifier4, z4, paddingValues2, mutableInteractionSource3, interfaceC0552Gp, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005e  */
    /* JADX WARN: Code duplicated, block: B:4:0x0017  */
    public static final long calculateTransformOrigin(IntRect intRect, IntRect intRect2) {
        float fMax;
        AbstractC4492zt.h(intRect, "parentBounds");
        AbstractC4492zt.h(intRect2, "menuBounds");
        float fMax2 = 1.0f;
        if (intRect2.getLeft() >= intRect.getRight()) {
            fMax = 0.0f;
        } else if (intRect2.getRight() <= intRect.getLeft()) {
            fMax = 1.0f;
        } else if (intRect2.getWidth() == 0) {
            fMax = 0.0f;
        } else {
            fMax = (((Math.max(intRect.getLeft(), intRect2.getLeft()) + Math.min(intRect.getRight(), intRect2.getRight())) / 2) - intRect2.getLeft()) / intRect2.getWidth();
        }
        if (intRect2.getTop() >= intRect.getBottom()) {
            fMax2 = 0.0f;
        } else if (intRect2.getBottom() > intRect.getTop()) {
            if (intRect2.getHeight() == 0) {
                fMax2 = 0.0f;
            } else {
                fMax2 = (((Math.max(intRect.getTop(), intRect2.getTop()) + Math.min(intRect.getBottom(), intRect2.getBottom())) / 2) - intRect2.getTop()) / intRect2.getHeight();
            }
        }
        return TransformOriginKt.TransformOrigin(fMax, fMax2);
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }
}
