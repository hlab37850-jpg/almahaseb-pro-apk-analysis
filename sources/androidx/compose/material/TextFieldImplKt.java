package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableOpenTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0630Jp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    private static final Modifier IconDefaultSizeModifier;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String TextFieldId = "TextField";
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float TextFieldPadding = Dp.m5160constructorimpl(16);
    private static final float HorizontalIconPadding = Dp.m5160constructorimpl(12);

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0630Jp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ InterfaceC0526Fp $border;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InterfaceC0526Fp $innerTextField;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ InterfaceC0526Fp $label;
        final /* synthetic */ InterfaceC0526Fp $leadingIcon;
        final /* synthetic */ InterfaceC0526Fp $placeholder;
        final /* synthetic */ boolean $shouldOverrideTextStyleColor;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ InterfaceC0526Fp $trailingIcon;
        final /* synthetic */ String $transformedText;
        final /* synthetic */ TextFieldType $type;

        /* JADX INFO: renamed from: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TextFieldType.values().length];
                try {
                    iArr[TextFieldType.Filled.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TextFieldType.Outlined.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, String str, boolean z, int i, TextFieldColors textFieldColors, boolean z2, InteractionSource interactionSource, int i2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, TextFieldType textFieldType, InterfaceC0526Fp interfaceC0526Fp5, boolean z3, PaddingValues paddingValues, boolean z4, InterfaceC0526Fp interfaceC0526Fp6) {
            super(6);
            this.$label = interfaceC0526Fp;
            this.$placeholder = interfaceC0526Fp2;
            this.$transformedText = str;
            this.$isError = z;
            this.$$dirty1 = i;
            this.$colors = textFieldColors;
            this.$enabled = z2;
            this.$interactionSource = interactionSource;
            this.$$dirty = i2;
            this.$leadingIcon = interfaceC0526Fp3;
            this.$trailingIcon = interfaceC0526Fp4;
            this.$type = textFieldType;
            this.$innerTextField = interfaceC0526Fp5;
            this.$singleLine = z3;
            this.$contentPadding = paddingValues;
            this.$shouldOverrideTextStyleColor = z4;
            this.$border = interfaceC0526Fp6;
        }

        @Override // defpackage.InterfaceC0630Jp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            m1279invokeRIQooxk(((Number) obj).floatValue(), ((Color) obj2).m3042unboximpl(), ((Color) obj3).m3042unboximpl(), ((Number) obj4).floatValue(), (Composer) obj5, ((Number) obj6).intValue());
            return FW.a;
        }

        /* JADX WARN: Type inference failed for: r14v0 */
        /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r14v4 */
        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        /* JADX INFO: renamed from: invoke-RIQooxk, reason: not valid java name */
        public final void m1279invokeRIQooxk(float f, long j, long j2, float f2, Composer composer, int i) {
            int i2;
            ?? r14;
            ComposableLambda composableLambda;
            long jM3042unboximpl;
            long jM3042unboximpl2;
            if ((i & 14) == 0) {
                i2 = (composer.changed(f) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 112) == 0) {
                i2 |= composer.changed(j) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                i2 |= composer.changed(j2) ? 256 : 128;
            }
            if ((i & 7168) == 0) {
                i2 |= composer.changed(f2) ? 2048 : 1024;
            }
            int i3 = i2;
            if ((46811 & i3) == 9362 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(341865432, i3, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:118)");
            }
            InterfaceC0526Fp interfaceC0526Fp = this.$label;
            if (interfaceC0526Fp != null) {
                r14 = 1;
                composableLambda = ComposableLambdaKt.composableLambda(composer, 362863774, true, new TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1(f, j2, interfaceC0526Fp, i3, this.$shouldOverrideTextStyleColor, j));
            } else {
                r14 = 1;
                composableLambda = null;
            }
            ComposableLambda composableLambda2 = (this.$placeholder == null || this.$transformedText.length() != 0 || f2 <= 0.0f) ? null : ComposableLambdaKt.composableLambda(composer, 1120552650, r14, new TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1(f2, this.$colors, this.$enabled, this.$$dirty, this.$$dirty1, this.$placeholder));
            String strM1225getString4foXLRw = Strings_androidKt.m1225getString4foXLRw(Strings.Companion.m1220getDefaultErrorMessageUdPEhr4(), composer, 6);
            Modifier.Companion companion = Modifier.Companion;
            Object objValueOf = Boolean.valueOf(this.$isError);
            boolean z = this.$isError;
            composer.startReplaceableGroup(511388516);
            boolean zChanged = composer.changed(objValueOf) | composer.changed(strM1225getString4foXLRw);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1(z, strM1225getString4foXLRw);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (InterfaceC3750qp) objRememberedValue, r14, null);
            if (this.$colors instanceof TextFieldColorsWithIcons) {
                composer.startReplaceableGroup(-1083197701);
                TextFieldColorsWithIcons textFieldColorsWithIcons = (TextFieldColorsWithIcons) this.$colors;
                boolean z2 = this.$enabled;
                boolean z3 = this.$isError;
                InteractionSource interactionSource = this.$interactionSource;
                int i4 = (this.$$dirty >> 27) & 14;
                int i5 = this.$$dirty1;
                jM3042unboximpl = textFieldColorsWithIcons.leadingIconColor(z2, z3, interactionSource, composer, ((i5 << 3) & 896) | i4 | ((i5 << 3) & 112)).getValue().m3042unboximpl();
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-1083197605);
                TextFieldColors textFieldColors = this.$colors;
                boolean z4 = this.$enabled;
                boolean z5 = this.$isError;
                int i6 = (this.$$dirty >> 27) & 14;
                int i7 = this.$$dirty1;
                jM3042unboximpl = textFieldColors.leadingIconColor(z4, z5, composer, i6 | ((i7 << 3) & 112) | ((i7 >> 3) & 896)).getValue().m3042unboximpl();
                composer.endReplaceableGroup();
            }
            InterfaceC0526Fp interfaceC0526Fp2 = this.$leadingIcon;
            ComposableLambda composableLambda3 = interfaceC0526Fp2 != null ? ComposableLambdaKt.composableLambda(composer, 1505327088, r14, new TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1(jM3042unboximpl, interfaceC0526Fp2)) : null;
            if (this.$colors instanceof TextFieldColorsWithIcons) {
                composer.startReplaceableGroup(-1083197259);
                TextFieldColorsWithIcons textFieldColorsWithIcons2 = (TextFieldColorsWithIcons) this.$colors;
                boolean z6 = this.$enabled;
                boolean z7 = this.$isError;
                InteractionSource interactionSource2 = this.$interactionSource;
                int i8 = (this.$$dirty >> 27) & 14;
                int i9 = this.$$dirty1;
                jM3042unboximpl2 = textFieldColorsWithIcons2.trailingIconColor(z6, z7, interactionSource2, composer, ((i9 << 3) & 896) | i8 | ((i9 << 3) & 112)).getValue().m3042unboximpl();
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-1083197162);
                TextFieldColors textFieldColors2 = this.$colors;
                boolean z8 = this.$enabled;
                boolean z9 = this.$isError;
                int i10 = (this.$$dirty >> 27) & 14;
                int i11 = this.$$dirty1;
                jM3042unboximpl2 = textFieldColors2.trailingIconColor(z8, z9, composer, i10 | ((i11 << 3) & 112) | ((i11 >> 3) & 896)).getValue().m3042unboximpl();
                composer.endReplaceableGroup();
            }
            InterfaceC0526Fp interfaceC0526Fp3 = this.$trailingIcon;
            ComposableLambda composableLambda4 = interfaceC0526Fp3 != null ? ComposableLambdaKt.composableLambda(composer, -1894727196, r14, new TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1(jM3042unboximpl2, interfaceC0526Fp3)) : null;
            int i12 = WhenMappings.$EnumSwitchMapping$0[this.$type.ordinal()];
            if (i12 == r14) {
                composer.startReplaceableGroup(-1083196826);
                InterfaceC0526Fp interfaceC0526Fp4 = this.$innerTextField;
                boolean z10 = this.$singleLine;
                PaddingValues paddingValues = this.$contentPadding;
                int i13 = this.$$dirty;
                TextFieldKt.TextFieldLayout(modifierSemantics$default, interfaceC0526Fp4, composableLambda, composableLambda2, composableLambda3, composableLambda4, z10, f, paddingValues, composer, ((i13 >> 6) & 3670016) | ((i13 >> 3) & 112) | ((i3 << 21) & 29360128) | ((this.$$dirty1 << 18) & 234881024));
                composer.endReplaceableGroup();
            } else if (i12 != 2) {
                composer.startReplaceableGroup(-1083194783);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-1083196270);
                composer.startReplaceableGroup(-492369756);
                Object objRememberedValue2 = composer.rememberedValue();
                Composer.Companion companion2 = Composer.Companion;
                if (objRememberedValue2 == companion2.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m2855boximpl(Size.Companion.m2876getZeroNHjbRc()), null, 2, null);
                    composer.updateRememberedValue(objRememberedValue2);
                }
                composer.endReplaceableGroup();
                MutableState mutableState = (MutableState) objRememberedValue2;
                ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composer, 139886979, r14, new TextFieldImplKt$CommonDecorationBox$3$drawBorder$1(mutableState, this.$contentPadding, this.$border, this.$$dirty1));
                InterfaceC0526Fp interfaceC0526Fp5 = this.$innerTextField;
                boolean z11 = this.$singleLine;
                Object objValueOf2 = Float.valueOf(f);
                composer.startReplaceableGroup(511388516);
                boolean zChanged2 = composer.changed(objValueOf2) | composer.changed(mutableState);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue3 == companion2.getEmpty()) {
                    objRememberedValue3 = new TextFieldImplKt$CommonDecorationBox$3$1$1(f, mutableState);
                    composer.updateRememberedValue(objRememberedValue3);
                }
                composer.endReplaceableGroup();
                InterfaceC3750qp interfaceC3750qp = (InterfaceC3750qp) objRememberedValue3;
                PaddingValues paddingValues2 = this.$contentPadding;
                int i14 = this.$$dirty;
                OutlinedTextFieldKt.OutlinedTextFieldLayout(modifierSemantics$default, interfaceC0526Fp5, composableLambda2, composableLambda, composableLambda3, composableLambda4, z11, f, interfaceC3750qp, composableLambda5, paddingValues2, composer, ((i14 >> 6) & 3670016) | ((i14 >> 3) & 112) | 805306368 | ((i3 << 21) & 29360128), (this.$$dirty1 >> 6) & 14);
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0526Fp $border;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InterfaceC0526Fp $innerTextField;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ InterfaceC0526Fp $label;
        final /* synthetic */ InterfaceC0526Fp $leadingIcon;
        final /* synthetic */ InterfaceC0526Fp $placeholder;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ InterfaceC0526Fp $trailingIcon;
        final /* synthetic */ TextFieldType $type;
        final /* synthetic */ String $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(TextFieldType textFieldType, String str, InterfaceC0526Fp interfaceC0526Fp, VisualTransformation visualTransformation, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, boolean z, boolean z2, boolean z3, InteractionSource interactionSource, PaddingValues paddingValues, TextFieldColors textFieldColors, InterfaceC0526Fp interfaceC0526Fp6, int i, int i2, int i3) {
            super(2);
            this.$type = textFieldType;
            this.$value = str;
            this.$innerTextField = interfaceC0526Fp;
            this.$visualTransformation = visualTransformation;
            this.$label = interfaceC0526Fp2;
            this.$placeholder = interfaceC0526Fp3;
            this.$leadingIcon = interfaceC0526Fp4;
            this.$trailingIcon = interfaceC0526Fp5;
            this.$singleLine = z;
            this.$enabled = z2;
            this.$isError = z3;
            this.$interactionSource = interactionSource;
            this.$contentPadding = paddingValues;
            this.$colors = textFieldColors;
            this.$border = interfaceC0526Fp6;
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
            TextFieldImplKt.CommonDecorationBox(this.$type, this.$value, this.$innerTextField, this.$visualTransformation, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$singleLine, this.$enabled, this.$isError, this.$interactionSource, this.$contentPadding, this.$colors, this.$border, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
        }
    }

    static {
        float f = 48;
        IconDefaultSizeModifier = SizeKt.m516defaultMinSizeVpY3zN4(Modifier.Companion, Dp.m5160constructorimpl(f), Dp.m5160constructorimpl(f));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void CommonDecorationBox(TextFieldType textFieldType, String str, InterfaceC0526Fp interfaceC0526Fp, VisualTransformation visualTransformation, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, boolean z, boolean z2, boolean z3, InteractionSource interactionSource, PaddingValues paddingValues, TextFieldColors textFieldColors, InterfaceC0526Fp interfaceC0526Fp6, Composer composer, int i, int i2, int i3) {
        int i4;
        int i5;
        InputPhase inputPhase;
        Composer composer2;
        InterfaceC0526Fp interfaceC0526Fp7;
        InterfaceC0526Fp interfaceC0526Fp8;
        InterfaceC0526Fp interfaceC0526Fp9;
        boolean z4;
        boolean z5;
        boolean z6;
        InterfaceC0526Fp interfaceC0526Fp10;
        AbstractC4492zt.h(textFieldType, "type");
        AbstractC4492zt.h(str, "value");
        AbstractC4492zt.h(interfaceC0526Fp, "innerTextField");
        AbstractC4492zt.h(visualTransformation, "visualTransformation");
        AbstractC4492zt.h(interactionSource, "interactionSource");
        AbstractC4492zt.h(paddingValues, "contentPadding");
        AbstractC4492zt.h(textFieldColors, "colors");
        Composer composerStartRestartGroup = composer.startRestartGroup(-712568069);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(textFieldType) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(visualTransformation) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((57344 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 16384 : 8192;
        }
        int i6 = i3 & 32;
        if (i6 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & 458752) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? 131072 : 65536;
        }
        int i7 = i3 & 64;
        if (i7 != 0) {
            i4 |= 1572864;
        } else if ((i & 3670016) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp4) ? 1048576 : 524288;
        }
        int i8 = i3 & 128;
        if (i8 != 0) {
            i4 |= 12582912;
        } else if ((i & 29360128) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp5) ? 8388608 : 4194304;
        }
        int i9 = i3 & 256;
        if (i9 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
        }
        int i10 = i3 & 512;
        if (i10 != 0) {
            i4 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? PropertyOptions.DELETE_EXISTING : 268435456;
        }
        int i11 = i3 & 1024;
        if (i11 != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = i2 | (composerStartRestartGroup.changed(z3) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i3 & 2048) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(interactionSource) ? 32 : 16;
        }
        int i12 = i5;
        if ((i3 & 4096) != 0) {
            i12 |= 384;
        } else if ((i2 & 896) == 0) {
            i12 |= composerStartRestartGroup.changed(paddingValues) ? 256 : 128;
        }
        if ((i3 & 8192) != 0) {
            i12 |= 3072;
        } else if ((i2 & 7168) == 0) {
            i12 |= composerStartRestartGroup.changed(textFieldColors) ? 2048 : 1024;
        }
        int i13 = i3 & 16384;
        if (i13 != 0) {
            i12 |= 24576;
        } else if ((i2 & 57344) == 0) {
            i12 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp6) ? 16384 : 8192;
        }
        if ((i4 & 1533916891) == 306783378 && (46811 & i12) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            interfaceC0526Fp7 = interfaceC0526Fp3;
            interfaceC0526Fp8 = interfaceC0526Fp4;
            interfaceC0526Fp9 = interfaceC0526Fp5;
            z4 = z;
            z5 = z2;
            z6 = z3;
            interfaceC0526Fp10 = interfaceC0526Fp6;
            composer2 = composerStartRestartGroup;
        } else {
            InterfaceC0526Fp interfaceC0526Fp11 = i6 != 0 ? null : interfaceC0526Fp3;
            InterfaceC0526Fp interfaceC0526Fp12 = i7 != 0 ? null : interfaceC0526Fp4;
            InterfaceC0526Fp interfaceC0526Fp13 = i8 != 0 ? null : interfaceC0526Fp5;
            boolean z7 = i9 != 0 ? false : z;
            boolean z8 = i10 != 0 ? true : z2;
            boolean z9 = i11 != 0 ? false : z3;
            InterfaceC0526Fp interfaceC0526Fp14 = i13 != 0 ? null : interfaceC0526Fp6;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-712568069, i4, i12, "androidx.compose.material.CommonDecorationBox (TextFieldImpl.kt:63)");
            }
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            String text = ((TransformedText) objRememberedValue).getText().getText();
            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i12 >> 3) & 14).getValue().booleanValue()) {
                inputPhase = InputPhase.Focused;
            } else {
                inputPhase = text.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            }
            InputPhase inputPhase2 = inputPhase;
            int i14 = i4;
            TextFieldImplKt$CommonDecorationBox$labelColor$1 textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z8, z9, interactionSource, i14, i12);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            Typography typography = materialTheme.getTypography(composerStartRestartGroup, 6);
            TextStyle subtitle1 = typography.getSubtitle1();
            TextStyle caption = typography.getCaption();
            long jM4726getColor0d7_KjU = subtitle1.m4726getColor0d7_KjU();
            Color.Companion companion = Color.Companion;
            boolean z10 = (Color.m3033equalsimpl0(jM4726getColor0d7_KjU, companion.m3068getUnspecified0d7_KjU()) && !Color.m3033equalsimpl0(caption.m4726getColor0d7_KjU(), companion.m3068getUnspecified0d7_KjU())) || (!Color.m3033equalsimpl0(subtitle1.m4726getColor0d7_KjU(), companion.m3068getUnspecified0d7_KjU()) && Color.m3033equalsimpl0(caption.m4726getColor0d7_KjU(), companion.m3068getUnspecified0d7_KjU()));
            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(2129141006);
            long jM4726getColor0d7_KjU2 = materialTheme.getTypography(composerStartRestartGroup, 6).getCaption().m4726getColor0d7_KjU();
            if (z10 && jM4726getColor0d7_KjU2 == companion.m3068getUnspecified0d7_KjU()) {
                jM4726getColor0d7_KjU2 = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
            }
            long j = jM4726getColor0d7_KjU2;
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(2129141197);
            long jM4726getColor0d7_KjU3 = materialTheme.getTypography(composerStartRestartGroup, 6).getSubtitle1().m4726getColor0d7_KjU();
            if (z10 && jM4726getColor0d7_KjU3 == companion.m3068getUnspecified0d7_KjU()) {
                jM4726getColor0d7_KjU3 = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
            }
            long j2 = jM4726getColor0d7_KjU3;
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            textFieldTransitionScope.m1286TransitionDTcfvLk(inputPhase2, j, j2, textFieldImplKt$CommonDecorationBox$labelColor$1, interfaceC0526Fp2 != null, ComposableLambdaKt.composableLambda(composer2, 341865432, true, new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp11, text, z9, i12, textFieldColors, z8, interactionSource, i14, interfaceC0526Fp12, interfaceC0526Fp13, textFieldType, interfaceC0526Fp, z7, paddingValues, z10, interfaceC0526Fp14)), composer2, 1769472);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp7 = interfaceC0526Fp11;
            interfaceC0526Fp8 = interfaceC0526Fp12;
            interfaceC0526Fp9 = interfaceC0526Fp13;
            z4 = z7;
            z5 = z8;
            z6 = z9;
            interfaceC0526Fp10 = interfaceC0526Fp14;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp7, interfaceC0526Fp8, interfaceC0526Fp9, z4, z5, z6, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp10, i, i2, i3));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004a  */
    /* JADX WARN: Code duplicated, block: B:28:0x004f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0053  */
    /* JADX WARN: Code duplicated, block: B:32:0x005b  */
    /* JADX WARN: Code duplicated, block: B:33:0x005e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0065  */
    /* JADX WARN: Code duplicated, block: B:39:0x0069  */
    /* JADX WARN: Code duplicated, block: B:41:0x006d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x0076  */
    /* JADX WARN: Code duplicated, block: B:48:0x0080  */
    /* JADX WARN: Code duplicated, block: B:52:0x008c  */
    /* JADX WARN: Code duplicated, block: B:54:0x008f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0091  */
    /* JADX WARN: Code duplicated, block: B:57:0x0094  */
    /* JADX WARN: Code duplicated, block: B:58:0x0096  */
    /* JADX WARN: Code duplicated, block: B:61:0x009d  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:76:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableOpenTarget(index = 0)
    /* JADX INFO: renamed from: Decoration-euL9pac, reason: not valid java name */
    public static final void m1278DecorationeuL9pac(long j, TextStyle textStyle, Float f, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        TextStyle textStyle2;
        int i4;
        Float f2;
        int i5;
        int i6;
        int i7;
        TextStyle textStyle3;
        Float f3;
        ComposableLambda composableLambda;
        Float f4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-399493340);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 112) == 0) {
                textStyle2 = textStyle;
                i3 |= composerStartRestartGroup.changed(textStyle2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
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
                i7 = i3;
                if ((i7 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                    if (i8 != 0) {
                        textStyle3 = null;
                    } else {
                        textStyle3 = textStyle2;
                    }
                    if (i4 != 0) {
                        f3 = null;
                    } else {
                        f3 = f2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-399493340, i7, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:233)");
                    }
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 494684590, true, new TextFieldImplKt$Decoration$colorAndEmphasis$1(j, f3, interfaceC0526Fp, i7));
                    if (textStyle3 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-2009952671);
                        TextKt.ProvideTextStyle(textStyle3, composableLambda, composerStartRestartGroup, ((i7 >> 3) & 14) | 48);
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-2009952619);
                        composableLambda.mo13invoke(composerStartRestartGroup, 6);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    textStyle2 = textStyle3;
                    f4 = f3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    f4 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TextFieldImplKt$Decoration$1(j, textStyle2, f4, interfaceC0526Fp, i, i2));
            }
            i3 |= 384;
            f2 = f;
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
            i7 = i3;
            if ((i7 & 5851) == 1170) {
                if (i8 != 0) {
                    textStyle3 = null;
                } else {
                    textStyle3 = textStyle2;
                }
                if (i4 != 0) {
                    f3 = null;
                } else {
                    f3 = f2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-399493340, i7, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:233)");
                }
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 494684590, true, new TextFieldImplKt$Decoration$colorAndEmphasis$1(j, f3, interfaceC0526Fp, i7));
                if (textStyle3 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-2009952671);
                    TextKt.ProvideTextStyle(textStyle3, composableLambda, composerStartRestartGroup, ((i7 >> 3) & 14) | 48);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-2009952619);
                    composableLambda.mo13invoke(composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                textStyle2 = textStyle3;
                f4 = f3;
            } else {
                if (i8 != 0) {
                    textStyle3 = null;
                } else {
                    textStyle3 = textStyle2;
                }
                if (i4 != 0) {
                    f3 = null;
                } else {
                    f3 = f2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-399493340, i7, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:233)");
                }
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 494684590, true, new TextFieldImplKt$Decoration$colorAndEmphasis$1(j, f3, interfaceC0526Fp, i7));
                if (textStyle3 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-2009952671);
                    TextKt.ProvideTextStyle(textStyle3, composableLambda, composerStartRestartGroup, ((i7 >> 3) & 14) | 48);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-2009952619);
                    composableLambda.mo13invoke(composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                textStyle2 = textStyle3;
                f4 = f3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TextFieldImplKt$Decoration$1(j, textStyle2, f4, interfaceC0526Fp, i, i2));
        }
        i3 |= 48;
        textStyle2 = textStyle;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
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
            i7 = i3;
            if ((i7 & 5851) == 1170) {
                if (i8 != 0) {
                    textStyle3 = null;
                } else {
                    textStyle3 = textStyle2;
                }
                if (i4 != 0) {
                    f3 = null;
                } else {
                    f3 = f2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-399493340, i7, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:233)");
                }
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 494684590, true, new TextFieldImplKt$Decoration$colorAndEmphasis$1(j, f3, interfaceC0526Fp, i7));
                if (textStyle3 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-2009952671);
                    TextKt.ProvideTextStyle(textStyle3, composableLambda, composerStartRestartGroup, ((i7 >> 3) & 14) | 48);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-2009952619);
                    composableLambda.mo13invoke(composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                textStyle2 = textStyle3;
                f4 = f3;
            } else {
                if (i8 != 0) {
                    textStyle3 = null;
                } else {
                    textStyle3 = textStyle2;
                }
                if (i4 != 0) {
                    f3 = null;
                } else {
                    f3 = f2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-399493340, i7, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:233)");
                }
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 494684590, true, new TextFieldImplKt$Decoration$colorAndEmphasis$1(j, f3, interfaceC0526Fp, i7));
                if (textStyle3 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-2009952671);
                    TextKt.ProvideTextStyle(textStyle3, composableLambda, composerStartRestartGroup, ((i7 >> 3) & 14) | 48);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-2009952619);
                    composableLambda.mo13invoke(composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                textStyle2 = textStyle3;
                f4 = f3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TextFieldImplKt$Decoration$1(j, textStyle2, f4, interfaceC0526Fp, i, i2));
        }
        i3 |= 384;
        f2 = f;
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
        i7 = i3;
        if ((i7 & 5851) == 1170) {
            if (i8 != 0) {
                textStyle3 = null;
            } else {
                textStyle3 = textStyle2;
            }
            if (i4 != 0) {
                f3 = null;
            } else {
                f3 = f2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-399493340, i7, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:233)");
            }
            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 494684590, true, new TextFieldImplKt$Decoration$colorAndEmphasis$1(j, f3, interfaceC0526Fp, i7));
            if (textStyle3 != null) {
                composerStartRestartGroup.startReplaceableGroup(-2009952671);
                TextKt.ProvideTextStyle(textStyle3, composableLambda, composerStartRestartGroup, ((i7 >> 3) & 14) | 48);
            } else {
                composerStartRestartGroup.startReplaceableGroup(-2009952619);
                composableLambda.mo13invoke(composerStartRestartGroup, 6);
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            textStyle2 = textStyle3;
            f4 = f3;
        } else {
            if (i8 != 0) {
                textStyle3 = null;
            } else {
                textStyle3 = textStyle2;
            }
            if (i4 != 0) {
                f3 = null;
            } else {
                f3 = f2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-399493340, i7, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:233)");
            }
            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 494684590, true, new TextFieldImplKt$Decoration$colorAndEmphasis$1(j, f3, interfaceC0526Fp, i7));
            if (textStyle3 != null) {
                composerStartRestartGroup.startReplaceableGroup(-2009952671);
                TextKt.ProvideTextStyle(textStyle3, composableLambda, composerStartRestartGroup, ((i7 >> 3) & 14) | 48);
            } else {
                composerStartRestartGroup.startReplaceableGroup(-2009952619);
                composableLambda.mo13invoke(composerStartRestartGroup, 6);
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            textStyle2 = textStyle3;
            f4 = f3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TextFieldImplKt$Decoration$1(j, textStyle2, f4, interfaceC0526Fp, i, i2));
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }

    public static final Object getLayoutId(IntrinsicMeasurable intrinsicMeasurable) {
        AbstractC4492zt.h(intrinsicMeasurable, "<this>");
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }
}
