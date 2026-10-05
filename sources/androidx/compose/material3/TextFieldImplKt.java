package androidx.compose.material3;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
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
import defpackage.InterfaceC0700Kp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    public static final String ContainerId = "Container";
    private static final Modifier IconDefaultSizeModifier;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final float MinFocusedLabelLineHeight;
    private static final float MinSupportingTextLineHeight;
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String PrefixId = "Prefix";
    public static final String SuffixId = "Suffix";
    public static final String SupportingId = "Supporting";
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding;
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float HorizontalIconPadding = Dp.m5160constructorimpl(12);
    private static final float SupportingTopPadding = Dp.m5160constructorimpl(4);
    private static final float PrefixSuffixTextPadding = Dp.m5160constructorimpl(2);
    private static final float MinTextLineHeight = Dp.m5160constructorimpl(24);

    /* JADX INFO: renamed from: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0700Kp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ TextStyle $bodyLarge;
        final /* synthetic */ TextStyle $bodySmall;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ InterfaceC0526Fp $container;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InterfaceC0526Fp $innerTextField;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ InterfaceC0526Fp $label;
        final /* synthetic */ InterfaceC0526Fp $leadingIcon;
        final /* synthetic */ InterfaceC0526Fp $placeholder;
        final /* synthetic */ InterfaceC0526Fp $prefix;
        final /* synthetic */ boolean $shouldOverrideTextStyleColor;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ InterfaceC0526Fp $suffix;
        final /* synthetic */ InterfaceC0526Fp $supportingText;
        final /* synthetic */ InterfaceC0526Fp $trailingIcon;
        final /* synthetic */ String $transformedText;
        final /* synthetic */ TextFieldType $type;

        /* JADX INFO: renamed from: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$WhenMappings */
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
        public AnonymousClass3(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, String str, TextFieldColors textFieldColors, boolean z, boolean z2, InteractionSource interactionSource, int i, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, InterfaceC0526Fp interfaceC0526Fp6, InterfaceC0526Fp interfaceC0526Fp7, TextFieldType textFieldType, InterfaceC0526Fp interfaceC0526Fp8, boolean z3, PaddingValues paddingValues, int i2, boolean z4, TextStyle textStyle, TextStyle textStyle2, InterfaceC0526Fp interfaceC0526Fp9) {
            super(7);
            this.$label = interfaceC0526Fp;
            this.$placeholder = interfaceC0526Fp2;
            this.$transformedText = str;
            this.$colors = textFieldColors;
            this.$enabled = z;
            this.$isError = z2;
            this.$interactionSource = interactionSource;
            this.$$dirty1 = i;
            this.$prefix = interfaceC0526Fp3;
            this.$suffix = interfaceC0526Fp4;
            this.$leadingIcon = interfaceC0526Fp5;
            this.$trailingIcon = interfaceC0526Fp6;
            this.$supportingText = interfaceC0526Fp7;
            this.$type = textFieldType;
            this.$innerTextField = interfaceC0526Fp8;
            this.$singleLine = z3;
            this.$contentPadding = paddingValues;
            this.$$dirty = i2;
            this.$shouldOverrideTextStyleColor = z4;
            this.$bodyLarge = textStyle;
            this.$bodySmall = textStyle2;
            this.$container = interfaceC0526Fp9;
        }

        @Override // defpackage.InterfaceC0700Kp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
            m1921invokeeopBjH0(((Number) obj).floatValue(), ((Color) obj2).m3042unboximpl(), ((Color) obj3).m3042unboximpl(), ((Number) obj4).floatValue(), ((Number) obj5).floatValue(), (Composer) obj6, ((Number) obj7).intValue());
            return FW.a;
        }

        /* JADX WARN: Type inference failed for: r13v0 */
        /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r13v9 */
        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        /* JADX INFO: renamed from: invoke-eopBjH0, reason: not valid java name */
        public final void m1921invokeeopBjH0(float f, long j, long j2, float f2, float f3, Composer composer, int i) {
            int i2;
            ?? r13;
            ComposableLambda composableLambda;
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
            if ((i & 57344) == 0) {
                i2 |= composer.changed(f3) ? 16384 : 8192;
            }
            int i3 = i2;
            if ((374491 & i3) == 74898 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1290853831, i3, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:113)");
            }
            InterfaceC0526Fp interfaceC0526Fp = this.$label;
            if (interfaceC0526Fp != null) {
                r13 = 1;
                composableLambda = ComposableLambdaKt.composableLambda(composer, -382297919, true, new TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1(f, j2, interfaceC0526Fp, i3, this.$shouldOverrideTextStyleColor, j));
            } else {
                r13 = 1;
                composableLambda = null;
            }
            ComposableLambda composableLambda2 = (this.$placeholder == null || this.$transformedText.length() != 0 || f2 <= 0.0f) ? null : ComposableLambdaKt.composableLambda(composer, -524658155, r13, new TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1(f2, this.$colors, this.$enabled, this.$isError, this.$interactionSource, this.$$dirty1, this.$placeholder, this.$$dirty));
            TextFieldColors textFieldColors = this.$colors;
            boolean z = this.$enabled;
            boolean z2 = this.$isError;
            InteractionSource interactionSource = this.$interactionSource;
            int i4 = this.$$dirty1;
            long jM3042unboximpl = textFieldColors.prefixColor$material3_release(z, z2, interactionSource, composer, ((i4 >> 6) & 896) | ((i4 >> 6) & 14) | ((i4 >> 6) & 112) | ((i4 >> 9) & 7168)).getValue().m3042unboximpl();
            InterfaceC0526Fp interfaceC0526Fp2 = this.$prefix;
            ComposableLambda composableLambda3 = (interfaceC0526Fp2 == null || f3 <= 0.0f) ? null : ComposableLambdaKt.composableLambda(composer, 1824482619, r13, new TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1(f3, jM3042unboximpl, this.$bodyLarge, interfaceC0526Fp2, this.$$dirty));
            TextFieldColors textFieldColors2 = this.$colors;
            boolean z3 = this.$enabled;
            boolean z4 = this.$isError;
            InteractionSource interactionSource2 = this.$interactionSource;
            int i5 = this.$$dirty1;
            long jM3042unboximpl2 = textFieldColors2.suffixColor$material3_release(z3, z4, interactionSource2, composer, ((i5 >> 6) & 896) | ((i5 >> 6) & 14) | ((i5 >> 6) & 112) | ((i5 >> 9) & 7168)).getValue().m3042unboximpl();
            InterfaceC0526Fp interfaceC0526Fp3 = this.$suffix;
            ComposableLambda composableLambda4 = (interfaceC0526Fp3 == null || f3 <= 0.0f) ? null : ComposableLambdaKt.composableLambda(composer, 907456412, r13, new TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1(f3, jM3042unboximpl2, this.$bodyLarge, interfaceC0526Fp3, this.$$dirty));
            String strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1816getDefaultErrorMessageadMyvUU(), composer, 6);
            Modifier.Companion companion = Modifier.Companion;
            Object objValueOf = Boolean.valueOf(this.$isError);
            boolean z5 = this.$isError;
            composer.startReplaceableGroup(511388516);
            boolean zChanged = composer.changed(objValueOf) | composer.changed(strM1841getStringNWtq28);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1(z5, strM1841getStringNWtq28);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (InterfaceC3750qp) objRememberedValue, r13, null);
            TextFieldColors textFieldColors3 = this.$colors;
            boolean z6 = this.$enabled;
            boolean z7 = this.$isError;
            InteractionSource interactionSource3 = this.$interactionSource;
            int i6 = this.$$dirty1;
            long jM3042unboximpl3 = textFieldColors3.leadingIconColor$material3_release(z6, z7, interactionSource3, composer, ((i6 >> 6) & 14) | ((i6 >> 6) & 112) | ((i6 >> 6) & 896) | ((i6 >> 9) & 7168)).getValue().m3042unboximpl();
            InterfaceC0526Fp interfaceC0526Fp4 = this.$leadingIcon;
            ComposableLambda composableLambda5 = interfaceC0526Fp4 != null ? ComposableLambdaKt.composableLambda(composer, 90769583, r13, new TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1(jM3042unboximpl3, interfaceC0526Fp4)) : null;
            TextFieldColors textFieldColors4 = this.$colors;
            boolean z8 = this.$enabled;
            boolean z9 = this.$isError;
            InteractionSource interactionSource4 = this.$interactionSource;
            int i7 = this.$$dirty1;
            long jM3042unboximpl4 = textFieldColors4.trailingIconColor$material3_release(z8, z9, interactionSource4, composer, ((i7 >> 6) & 14) | ((i7 >> 6) & 112) | ((i7 >> 6) & 896) | ((i7 >> 9) & 7168)).getValue().m3042unboximpl();
            InterfaceC0526Fp interfaceC0526Fp5 = this.$trailingIcon;
            ComposableLambda composableLambda6 = interfaceC0526Fp5 != null ? ComposableLambdaKt.composableLambda(composer, 2077796155, r13, new TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1(jM3042unboximpl4, interfaceC0526Fp5)) : null;
            TextFieldColors textFieldColors5 = this.$colors;
            boolean z10 = this.$enabled;
            boolean z11 = this.$isError;
            InteractionSource interactionSource5 = this.$interactionSource;
            int i8 = this.$$dirty1;
            long jM3042unboximpl5 = textFieldColors5.supportingTextColor$material3_release(z10, z11, interactionSource5, composer, ((i8 >> 9) & 7168) | ((i8 >> 6) & 14) | ((i8 >> 6) & 112) | ((i8 >> 6) & 896)).getValue().m3042unboximpl();
            InterfaceC0526Fp interfaceC0526Fp6 = this.$supportingText;
            ComposableLambda composableLambda7 = interfaceC0526Fp6 != null ? ComposableLambdaKt.composableLambda(composer, -1531019900, true, new TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1(jM3042unboximpl5, this.$bodySmall, interfaceC0526Fp6)) : null;
            int i9 = WhenMappings.$EnumSwitchMapping$0[this.$type.ordinal()];
            if (i9 == 1) {
                composer.startReplaceableGroup(404043011);
                ComposableLambda composableLambda8 = ComposableLambdaKt.composableLambda(composer, -2124779163, true, new TextFieldImplKt$CommonDecorationBox$3$containerWithId$1(this.$container, this.$$dirty1));
                InterfaceC0526Fp interfaceC0526Fp7 = this.$innerTextField;
                boolean z12 = this.$singleLine;
                PaddingValues paddingValues = this.$contentPadding;
                int i10 = (this.$$dirty >> 3) & 112;
                int i11 = this.$$dirty1;
                TextFieldKt.TextFieldLayout(modifierSemantics$default, interfaceC0526Fp7, composableLambda, composableLambda2, composableLambda5, composableLambda6, composableLambda3, composableLambda4, z12, f, composableLambda8, composableLambda7, paddingValues, composer, i10 | ((i11 << 21) & 234881024) | ((i3 << 27) & 1879048192), ((i11 >> 9) & 896) | 6);
                composer.endReplaceableGroup();
                FW fw = FW.a;
            } else if (i9 != 2) {
                composer.startReplaceableGroup(404045731);
                composer.endReplaceableGroup();
                FW fw2 = FW.a;
            } else {
                composer.startReplaceableGroup(404044017);
                composer.startReplaceableGroup(-492369756);
                Object objRememberedValue2 = composer.rememberedValue();
                Composer.Companion companion2 = Composer.Companion;
                if (objRememberedValue2 == companion2.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m2855boximpl(Size.Companion.m2876getZeroNHjbRc()), null, 2, null);
                    composer.updateRememberedValue(objRememberedValue2);
                }
                composer.endReplaceableGroup();
                MutableState mutableState = (MutableState) objRememberedValue2;
                ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composer, 1902535592, true, new TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1(mutableState, this.$contentPadding, this.$container, this.$$dirty1));
                InterfaceC0526Fp interfaceC0526Fp8 = this.$innerTextField;
                boolean z13 = this.$singleLine;
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
                int i12 = (this.$$dirty >> 3) & 112;
                int i13 = this.$$dirty1;
                OutlinedTextFieldKt.OutlinedTextFieldLayout(modifierSemantics$default, interfaceC0526Fp8, composableLambda2, composableLambda, composableLambda5, composableLambda6, composableLambda3, composableLambda4, z13, f, interfaceC3750qp, composableLambda9, composableLambda7, paddingValues2, composer, i12 | ((i13 << 21) & 234881024) | ((i3 << 27) & 1879048192), ((i13 >> 6) & 7168) | 48);
                composer.endReplaceableGroup();
                FW fw3 = FW.a;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ InterfaceC0526Fp $container;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InterfaceC0526Fp $innerTextField;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ InterfaceC0526Fp $label;
        final /* synthetic */ InterfaceC0526Fp $leadingIcon;
        final /* synthetic */ InterfaceC0526Fp $placeholder;
        final /* synthetic */ InterfaceC0526Fp $prefix;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ InterfaceC0526Fp $suffix;
        final /* synthetic */ InterfaceC0526Fp $supportingText;
        final /* synthetic */ InterfaceC0526Fp $trailingIcon;
        final /* synthetic */ TextFieldType $type;
        final /* synthetic */ String $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(TextFieldType textFieldType, String str, InterfaceC0526Fp interfaceC0526Fp, VisualTransformation visualTransformation, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, InterfaceC0526Fp interfaceC0526Fp6, InterfaceC0526Fp interfaceC0526Fp7, InterfaceC0526Fp interfaceC0526Fp8, boolean z, boolean z2, boolean z3, InteractionSource interactionSource, PaddingValues paddingValues, TextFieldColors textFieldColors, InterfaceC0526Fp interfaceC0526Fp9, int i, int i2, int i3) {
            super(2);
            this.$type = textFieldType;
            this.$value = str;
            this.$innerTextField = interfaceC0526Fp;
            this.$visualTransformation = visualTransformation;
            this.$label = interfaceC0526Fp2;
            this.$placeholder = interfaceC0526Fp3;
            this.$leadingIcon = interfaceC0526Fp4;
            this.$trailingIcon = interfaceC0526Fp5;
            this.$prefix = interfaceC0526Fp6;
            this.$suffix = interfaceC0526Fp7;
            this.$supportingText = interfaceC0526Fp8;
            this.$singleLine = z;
            this.$enabled = z2;
            this.$isError = z3;
            this.$interactionSource = interactionSource;
            this.$contentPadding = paddingValues;
            this.$colors = textFieldColors;
            this.$container = interfaceC0526Fp9;
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
            TextFieldImplKt.CommonDecorationBox(this.$type, this.$value, this.$innerTextField, this.$visualTransformation, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$prefix, this.$suffix, this.$supportingText, this.$singleLine, this.$enabled, this.$isError, this.$interactionSource, this.$contentPadding, this.$colors, this.$container, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
        }
    }

    static {
        float f = 16;
        TextFieldPadding = Dp.m5160constructorimpl(f);
        MinFocusedLabelLineHeight = Dp.m5160constructorimpl(f);
        MinSupportingTextLineHeight = Dp.m5160constructorimpl(f);
        float f2 = 48;
        IconDefaultSizeModifier = SizeKt.m516defaultMinSizeVpY3zN4(Modifier.Companion, Dp.m5160constructorimpl(f2), Dp.m5160constructorimpl(f2));
    }

    /* JADX WARN: Code duplicated, block: B:136:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:138:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:140:0x01da  */
    /* JADX WARN: Code duplicated, block: B:142:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:146:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:147:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:149:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:151:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:155:0x0203  */
    /* JADX WARN: Code duplicated, block: B:157:0x0207  */
    /* JADX WARN: Code duplicated, block: B:159:0x020c  */
    /* JADX WARN: Code duplicated, block: B:161:0x0212  */
    /* JADX WARN: Code duplicated, block: B:162:0x0215  */
    /* JADX WARN: Code duplicated, block: B:165:0x021c  */
    /* JADX WARN: Code duplicated, block: B:167:0x0220  */
    /* JADX WARN: Code duplicated, block: B:169:0x0225  */
    /* JADX WARN: Code duplicated, block: B:171:0x022b  */
    /* JADX WARN: Code duplicated, block: B:172:0x022e  */
    /* JADX WARN: Code duplicated, block: B:175:0x0235  */
    /* JADX WARN: Code duplicated, block: B:177:0x0239  */
    /* JADX WARN: Code duplicated, block: B:179:0x023e  */
    /* JADX WARN: Code duplicated, block: B:181:0x0244  */
    /* JADX WARN: Code duplicated, block: B:182:0x0247  */
    /* JADX WARN: Code duplicated, block: B:185:0x0253  */
    /* JADX WARN: Code duplicated, block: B:191:0x027b  */
    /* JADX WARN: Code duplicated, block: B:193:0x027e  */
    /* JADX WARN: Code duplicated, block: B:194:0x0281  */
    /* JADX WARN: Code duplicated, block: B:196:0x0285  */
    /* JADX WARN: Code duplicated, block: B:197:0x0288  */
    /* JADX WARN: Code duplicated, block: B:199:0x028c  */
    /* JADX WARN: Code duplicated, block: B:200:0x028f  */
    /* JADX WARN: Code duplicated, block: B:202:0x0293  */
    /* JADX WARN: Code duplicated, block: B:203:0x0296  */
    /* JADX WARN: Code duplicated, block: B:205:0x029a  */
    /* JADX WARN: Code duplicated, block: B:206:0x029d  */
    /* JADX WARN: Code duplicated, block: B:208:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:209:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:211:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:212:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:214:0x02af  */
    /* JADX WARN: Code duplicated, block: B:215:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:217:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:218:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:221:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:224:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:226:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:229:0x0328  */
    /* JADX WARN: Code duplicated, block: B:231:0x032c  */
    /* JADX WARN: Code duplicated, block: B:233:0x0332  */
    /* JADX WARN: Code duplicated, block: B:234:0x0335  */
    /* JADX WARN: Code duplicated, block: B:237:0x036a  */
    /* JADX WARN: Code duplicated, block: B:239:0x0378  */
    /* JADX WARN: Code duplicated, block: B:247:0x03af  */
    /* JADX WARN: Code duplicated, block: B:253:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:258:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:261:0x0402  */
    /* JADX WARN: Code duplicated, block: B:262:0x0405  */
    /* JADX WARN: Code duplicated, block: B:265:0x045e  */
    /* JADX WARN: Code duplicated, block: B:270:0x0478  */
    /* JADX WARN: Code duplicated, block: B:272:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][_][_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void CommonDecorationBox(TextFieldType textFieldType, String str, InterfaceC0526Fp interfaceC0526Fp, VisualTransformation visualTransformation, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, InterfaceC0526Fp interfaceC0526Fp6, InterfaceC0526Fp interfaceC0526Fp7, InterfaceC0526Fp interfaceC0526Fp8, boolean z, boolean z2, boolean z3, InteractionSource interactionSource, PaddingValues paddingValues, TextFieldColors textFieldColors, InterfaceC0526Fp interfaceC0526Fp9, Composer composer, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        InterfaceC0526Fp interfaceC0526Fp10;
        InterfaceC0526Fp interfaceC0526Fp11;
        InterfaceC0526Fp interfaceC0526Fp12;
        InterfaceC0526Fp interfaceC0526Fp13;
        InterfaceC0526Fp interfaceC0526Fp14;
        InterfaceC0526Fp interfaceC0526Fp15;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean zChanged;
        Object objRememberedValue;
        String text;
        InputPhase inputPhase;
        InputPhase inputPhase2;
        TextFieldImplKt$CommonDecorationBox$labelColor$1 textFieldImplKt$CommonDecorationBox$labelColor$1;
        boolean z7;
        long jM4726getColor0d7_KjU;
        boolean z8;
        Composer composer2;
        InterfaceC0526Fp interfaceC0526Fp16;
        InterfaceC0526Fp interfaceC0526Fp17;
        InterfaceC0526Fp interfaceC0526Fp18;
        InterfaceC0526Fp interfaceC0526Fp19;
        InterfaceC0526Fp interfaceC0526Fp20;
        InterfaceC0526Fp interfaceC0526Fp21;
        boolean z9;
        boolean z10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(textFieldType, "type");
        AbstractC4492zt.h(str, "value");
        AbstractC4492zt.h(interfaceC0526Fp, "innerTextField");
        AbstractC4492zt.h(visualTransformation, "visualTransformation");
        AbstractC4492zt.h(interactionSource, "interactionSource");
        AbstractC4492zt.h(paddingValues, "contentPadding");
        AbstractC4492zt.h(textFieldColors, "colors");
        AbstractC4492zt.h(interfaceC0526Fp9, "container");
        Composer composerStartRestartGroup = composer.startRestartGroup(-947035500);
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
        int i12 = i3 & 32;
        if (i12 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & 458752) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? 131072 : 65536;
        }
        int i13 = i3 & 64;
        if (i13 != 0) {
            i4 |= 1572864;
        } else if ((i & 3670016) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp4) ? 1048576 : 524288;
        }
        int i14 = i3 & 128;
        if (i14 != 0) {
            i4 |= 12582912;
        } else if ((i & 29360128) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp5) ? 8388608 : 4194304;
        }
        int i15 = i3 & 256;
        if (i15 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp6) ? 67108864 : 33554432;
        }
        int i16 = i3 & 512;
        if (i16 != 0) {
            i4 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp7) ? PropertyOptions.DELETE_EXISTING : 268435456;
        }
        int i17 = i3 & 1024;
        if (i17 != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = i2 | (composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 4 : 2);
        } else {
            i5 = i2;
        }
        int i18 = i3 & 2048;
        if (i18 != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        int i19 = i5;
        int i20 = i3 & 4096;
        if (i20 == 0) {
            i6 = i20;
            if ((i2 & 896) == 0) {
                i19 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
            }
            i7 = i3 & 8192;
            if (i7 != 0) {
                i8 = i7;
                if ((i2 & 7168) == 0) {
                    i19 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                }
                if ((i3 & 16384) != 0) {
                    i19 |= 24576;
                } else if ((57344 & i2) == 0) {
                    i19 |= composerStartRestartGroup.changed(interactionSource) ? 16384 : 8192;
                }
                if ((32768 & i3) != 0) {
                    if ((458752 & i2) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                    }
                    if ((i3 & 65536) != 0) {
                        if ((3670016 & i2) == 0) {
                            if (composerStartRestartGroup.changed(textFieldColors)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                        }
                        if ((i3 & 131072) != 0) {
                            if ((29360128 & i2) == 0) {
                                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                                    i11 = 8388608;
                                } else {
                                    i11 = 4194304;
                                }
                            }
                            if ((1533916891 & i4) != 306783378 && (23967451 & i19) == 4793490 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                interfaceC0526Fp16 = interfaceC0526Fp3;
                                interfaceC0526Fp17 = interfaceC0526Fp4;
                                interfaceC0526Fp18 = interfaceC0526Fp5;
                                interfaceC0526Fp19 = interfaceC0526Fp6;
                                interfaceC0526Fp20 = interfaceC0526Fp7;
                                interfaceC0526Fp21 = interfaceC0526Fp8;
                                z4 = z;
                                z9 = z2;
                                z10 = z3;
                                composer2 = composerStartRestartGroup;
                            } else {
                                if (i12 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp3;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp4;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp5;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp6;
                                }
                                if (i16 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp7;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp8;
                                }
                                if (i18 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z;
                                }
                                if (i6 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                }
                                if (i8 != 0) {
                                    z6 = false;
                                } else {
                                    z6 = z3;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                                }
                                composerStartRestartGroup.startReplaceableGroup(511388516);
                                zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                text = ((TransformedText) objRememberedValue).getText().getText();
                                if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                                    inputPhase = InputPhase.Focused;
                                } else if (text.length() == 0) {
                                    inputPhase = InputPhase.UnfocusedEmpty;
                                } else {
                                    inputPhase = InputPhase.UnfocusedNotEmpty;
                                }
                                inputPhase2 = inputPhase;
                                textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                                Typography typography = materialTheme.getTypography(composerStartRestartGroup, 6);
                                TextStyle bodyLarge = typography.getBodyLarge();
                                TextStyle bodySmall = typography.getBodySmall();
                                int i21 = i4;
                                long jM4726getColor0d7_KjU2 = bodyLarge.m4726getColor0d7_KjU();
                                Color.Companion companion = Color.Companion;
                                z7 = !(Color.m3033equalsimpl0(jM4726getColor0d7_KjU2, companion.m3068getUnspecified0d7_KjU()) || Color.m3033equalsimpl0(bodySmall.m4726getColor0d7_KjU(), companion.m3068getUnspecified0d7_KjU())) || (!Color.m3033equalsimpl0(bodyLarge.m4726getColor0d7_KjU(), companion.m3068getUnspecified0d7_KjU()) && Color.m3033equalsimpl0(bodySmall.m4726getColor0d7_KjU(), companion.m3068getUnspecified0d7_KjU()));
                                TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
                                composerStartRestartGroup.startReplaceableGroup(-646388253);
                                jM4726getColor0d7_KjU = materialTheme.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                                if (z7 && jM4726getColor0d7_KjU == companion.m3068getUnspecified0d7_KjU()) {
                                    jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                                }
                                long j = jM4726getColor0d7_KjU;
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.startReplaceableGroup(-646388060);
                                long jM4726getColor0d7_KjU3 = materialTheme.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                                if (!z7 && jM4726getColor0d7_KjU3 == companion.m3068getUnspecified0d7_KjU()) {
                                    jM4726getColor0d7_KjU3 = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                                }
                                long j2 = jM4726getColor0d7_KjU3;
                                composerStartRestartGroup.endReplaceableGroup();
                                if (interfaceC0526Fp2 != null) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                AnonymousClass3 anonymousClass3 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i21, z7, bodyLarge, bodySmall, interfaceC0526Fp9);
                                composer2 = composerStartRestartGroup;
                                textFieldTransitionScope.m1928TransitionDTcfvLk(inputPhase2, j, j2, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass3), composer2, 1769472);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp10;
                                interfaceC0526Fp17 = interfaceC0526Fp11;
                                interfaceC0526Fp18 = interfaceC0526Fp12;
                                interfaceC0526Fp19 = interfaceC0526Fp13;
                                interfaceC0526Fp20 = interfaceC0526Fp14;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z9 = z5;
                                z10 = z6;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
                        }
                        i11 = 12582912;
                        i19 |= i11;
                        if ((1533916891 & i4) != 306783378) {
                            if (i12 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp3;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp4;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp5;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp6;
                            }
                            if (i16 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp7;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp8;
                            }
                            if (i18 != 0) {
                                z4 = false;
                            } else {
                                z4 = z;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i8 != 0) {
                                z6 = false;
                            } else {
                                z6 = z3;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            text = ((TransformedText) objRememberedValue).getText().getText();
                            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                                inputPhase = InputPhase.Focused;
                            } else if (text.length() == 0) {
                                inputPhase = InputPhase.UnfocusedEmpty;
                            } else {
                                inputPhase = InputPhase.UnfocusedNotEmpty;
                            }
                            inputPhase2 = inputPhase;
                            textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                            Typography typography2 = materialTheme2.getTypography(composerStartRestartGroup, 6);
                            TextStyle bodyLarge2 = typography2.getBodyLarge();
                            TextStyle bodySmall2 = typography2.getBodySmall();
                            int i22 = i4;
                            long jM4726getColor0d7_KjU4 = bodyLarge2.m4726getColor0d7_KjU();
                            Color.Companion companion2 = Color.Companion;
                            if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU4, companion2.m3068getUnspecified0d7_KjU())) {
                            }
                            TextFieldTransitionScope textFieldTransitionScope2 = TextFieldTransitionScope.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-646388253);
                            jM4726getColor0d7_KjU = materialTheme2.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                            if (z7) {
                                jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                            }
                            long j3 = jM4726getColor0d7_KjU;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.startReplaceableGroup(-646388060);
                            long jM4726getColor0d7_KjU5 = materialTheme2.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                            if (!z7) {
                            }
                            long j4 = jM4726getColor0d7_KjU5;
                            composerStartRestartGroup.endReplaceableGroup();
                            if (interfaceC0526Fp2 != null) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            AnonymousClass3 anonymousClass4 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i22, z7, bodyLarge2, bodySmall2, interfaceC0526Fp9);
                            composer2 = composerStartRestartGroup;
                            textFieldTransitionScope2.m1928TransitionDTcfvLk(inputPhase2, j3, j4, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass4), composer2, 1769472);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp11;
                            interfaceC0526Fp18 = interfaceC0526Fp12;
                            interfaceC0526Fp19 = interfaceC0526Fp13;
                            interfaceC0526Fp20 = interfaceC0526Fp14;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z9 = z5;
                            z10 = z6;
                        } else {
                            if (i12 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp3;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp4;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp5;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp6;
                            }
                            if (i16 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp7;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp8;
                            }
                            if (i18 != 0) {
                                z4 = false;
                            } else {
                                z4 = z;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i8 != 0) {
                                z6 = false;
                            } else {
                                z6 = z3;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            text = ((TransformedText) objRememberedValue).getText().getText();
                            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                                inputPhase = InputPhase.Focused;
                            } else if (text.length() == 0) {
                                inputPhase = InputPhase.UnfocusedEmpty;
                            } else {
                                inputPhase = InputPhase.UnfocusedNotEmpty;
                            }
                            inputPhase2 = inputPhase;
                            textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                            MaterialTheme materialTheme3 = MaterialTheme.INSTANCE;
                            Typography typography3 = materialTheme3.getTypography(composerStartRestartGroup, 6);
                            TextStyle bodyLarge3 = typography3.getBodyLarge();
                            TextStyle bodySmall3 = typography3.getBodySmall();
                            int i23 = i4;
                            long jM4726getColor0d7_KjU6 = bodyLarge3.m4726getColor0d7_KjU();
                            Color.Companion companion3 = Color.Companion;
                            if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU6, companion3.m3068getUnspecified0d7_KjU())) {
                            }
                            TextFieldTransitionScope textFieldTransitionScope3 = TextFieldTransitionScope.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-646388253);
                            jM4726getColor0d7_KjU = materialTheme3.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                            if (z7) {
                                jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                            }
                            long j5 = jM4726getColor0d7_KjU;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.startReplaceableGroup(-646388060);
                            long jM4726getColor0d7_KjU7 = materialTheme3.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                            if (!z7) {
                            }
                            long j6 = jM4726getColor0d7_KjU7;
                            composerStartRestartGroup.endReplaceableGroup();
                            if (interfaceC0526Fp2 != null) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            AnonymousClass3 anonymousClass5 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i23, z7, bodyLarge3, bodySmall3, interfaceC0526Fp9);
                            composer2 = composerStartRestartGroup;
                            textFieldTransitionScope3.m1928TransitionDTcfvLk(inputPhase2, j5, j6, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass5), composer2, 1769472);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp11;
                            interfaceC0526Fp18 = interfaceC0526Fp12;
                            interfaceC0526Fp19 = interfaceC0526Fp13;
                            interfaceC0526Fp20 = interfaceC0526Fp14;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z9 = z5;
                            z10 = z6;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
                    }
                    i10 = 1572864;
                    i19 |= i10;
                    if ((i3 & 131072) != 0) {
                        if ((29360128 & i2) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                        }
                        if ((1533916891 & i4) != 306783378) {
                            if (i12 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp3;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp4;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp5;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp6;
                            }
                            if (i16 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp7;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp8;
                            }
                            if (i18 != 0) {
                                z4 = false;
                            } else {
                                z4 = z;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i8 != 0) {
                                z6 = false;
                            } else {
                                z6 = z3;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            text = ((TransformedText) objRememberedValue).getText().getText();
                            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                                inputPhase = InputPhase.Focused;
                            } else if (text.length() == 0) {
                                inputPhase = InputPhase.UnfocusedEmpty;
                            } else {
                                inputPhase = InputPhase.UnfocusedNotEmpty;
                            }
                            inputPhase2 = inputPhase;
                            textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                            MaterialTheme materialTheme4 = MaterialTheme.INSTANCE;
                            Typography typography4 = materialTheme4.getTypography(composerStartRestartGroup, 6);
                            TextStyle bodyLarge4 = typography4.getBodyLarge();
                            TextStyle bodySmall4 = typography4.getBodySmall();
                            int i24 = i4;
                            long jM4726getColor0d7_KjU8 = bodyLarge4.m4726getColor0d7_KjU();
                            Color.Companion companion4 = Color.Companion;
                            if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU8, companion4.m3068getUnspecified0d7_KjU())) {
                            }
                            TextFieldTransitionScope textFieldTransitionScope4 = TextFieldTransitionScope.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-646388253);
                            jM4726getColor0d7_KjU = materialTheme4.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                            if (z7) {
                                jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                            }
                            long j7 = jM4726getColor0d7_KjU;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.startReplaceableGroup(-646388060);
                            long jM4726getColor0d7_KjU9 = materialTheme4.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                            if (!z7) {
                            }
                            long j8 = jM4726getColor0d7_KjU9;
                            composerStartRestartGroup.endReplaceableGroup();
                            if (interfaceC0526Fp2 != null) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            AnonymousClass3 anonymousClass6 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i24, z7, bodyLarge4, bodySmall4, interfaceC0526Fp9);
                            composer2 = composerStartRestartGroup;
                            textFieldTransitionScope4.m1928TransitionDTcfvLk(inputPhase2, j7, j8, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass6), composer2, 1769472);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp11;
                            interfaceC0526Fp18 = interfaceC0526Fp12;
                            interfaceC0526Fp19 = interfaceC0526Fp13;
                            interfaceC0526Fp20 = interfaceC0526Fp14;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z9 = z5;
                            z10 = z6;
                        } else {
                            if (i12 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp3;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp4;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp5;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp6;
                            }
                            if (i16 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp7;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp8;
                            }
                            if (i18 != 0) {
                                z4 = false;
                            } else {
                                z4 = z;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i8 != 0) {
                                z6 = false;
                            } else {
                                z6 = z3;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            text = ((TransformedText) objRememberedValue).getText().getText();
                            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                                inputPhase = InputPhase.Focused;
                            } else if (text.length() == 0) {
                                inputPhase = InputPhase.UnfocusedEmpty;
                            } else {
                                inputPhase = InputPhase.UnfocusedNotEmpty;
                            }
                            inputPhase2 = inputPhase;
                            textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                            MaterialTheme materialTheme5 = MaterialTheme.INSTANCE;
                            Typography typography5 = materialTheme5.getTypography(composerStartRestartGroup, 6);
                            TextStyle bodyLarge5 = typography5.getBodyLarge();
                            TextStyle bodySmall5 = typography5.getBodySmall();
                            int i25 = i4;
                            long jM4726getColor0d7_KjU10 = bodyLarge5.m4726getColor0d7_KjU();
                            Color.Companion companion5 = Color.Companion;
                            if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU10, companion5.m3068getUnspecified0d7_KjU())) {
                            }
                            TextFieldTransitionScope textFieldTransitionScope5 = TextFieldTransitionScope.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-646388253);
                            jM4726getColor0d7_KjU = materialTheme5.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                            if (z7) {
                                jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                            }
                            long j9 = jM4726getColor0d7_KjU;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.startReplaceableGroup(-646388060);
                            long jM4726getColor0d7_KjU11 = materialTheme5.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                            if (!z7) {
                            }
                            long j10 = jM4726getColor0d7_KjU11;
                            composerStartRestartGroup.endReplaceableGroup();
                            if (interfaceC0526Fp2 != null) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            AnonymousClass3 anonymousClass7 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i25, z7, bodyLarge5, bodySmall5, interfaceC0526Fp9);
                            composer2 = composerStartRestartGroup;
                            textFieldTransitionScope5.m1928TransitionDTcfvLk(inputPhase2, j9, j10, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass7), composer2, 1769472);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp11;
                            interfaceC0526Fp18 = interfaceC0526Fp12;
                            interfaceC0526Fp19 = interfaceC0526Fp13;
                            interfaceC0526Fp20 = interfaceC0526Fp14;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z9 = z5;
                            z10 = z6;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
                    }
                    i11 = 12582912;
                    i19 |= i11;
                    if ((1533916891 & i4) != 306783378) {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme6 = MaterialTheme.INSTANCE;
                        Typography typography6 = materialTheme6.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge6 = typography6.getBodyLarge();
                        TextStyle bodySmall6 = typography6.getBodySmall();
                        int i26 = i4;
                        long jM4726getColor0d7_KjU12 = bodyLarge6.m4726getColor0d7_KjU();
                        Color.Companion companion6 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU12, companion6.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope6 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme6.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j11 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU13 = materialTheme6.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j12 = jM4726getColor0d7_KjU13;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass8 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i26, z7, bodyLarge6, bodySmall6, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope6.m1928TransitionDTcfvLk(inputPhase2, j11, j12, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass8), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    } else {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme7 = MaterialTheme.INSTANCE;
                        Typography typography7 = materialTheme7.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge7 = typography7.getBodyLarge();
                        TextStyle bodySmall7 = typography7.getBodySmall();
                        int i27 = i4;
                        long jM4726getColor0d7_KjU14 = bodyLarge7.m4726getColor0d7_KjU();
                        Color.Companion companion7 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU14, companion7.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope7 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme7.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j13 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU15 = materialTheme7.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j14 = jM4726getColor0d7_KjU15;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass9 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i27, z7, bodyLarge7, bodySmall7, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope7.m1928TransitionDTcfvLk(inputPhase2, j13, j14, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass9), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
                }
                i9 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i19 |= i9;
                if ((i3 & 65536) != 0) {
                    if ((3670016 & i2) == 0) {
                        if (composerStartRestartGroup.changed(textFieldColors)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                    }
                    if ((i3 & 131072) != 0) {
                        if ((29360128 & i2) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                        }
                        if ((1533916891 & i4) != 306783378) {
                            if (i12 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp3;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp4;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp5;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp6;
                            }
                            if (i16 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp7;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp8;
                            }
                            if (i18 != 0) {
                                z4 = false;
                            } else {
                                z4 = z;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i8 != 0) {
                                z6 = false;
                            } else {
                                z6 = z3;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            text = ((TransformedText) objRememberedValue).getText().getText();
                            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                                inputPhase = InputPhase.Focused;
                            } else if (text.length() == 0) {
                                inputPhase = InputPhase.UnfocusedEmpty;
                            } else {
                                inputPhase = InputPhase.UnfocusedNotEmpty;
                            }
                            inputPhase2 = inputPhase;
                            textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                            MaterialTheme materialTheme8 = MaterialTheme.INSTANCE;
                            Typography typography8 = materialTheme8.getTypography(composerStartRestartGroup, 6);
                            TextStyle bodyLarge8 = typography8.getBodyLarge();
                            TextStyle bodySmall8 = typography8.getBodySmall();
                            int i28 = i4;
                            long jM4726getColor0d7_KjU16 = bodyLarge8.m4726getColor0d7_KjU();
                            Color.Companion companion8 = Color.Companion;
                            if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU16, companion8.m3068getUnspecified0d7_KjU())) {
                            }
                            TextFieldTransitionScope textFieldTransitionScope8 = TextFieldTransitionScope.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-646388253);
                            jM4726getColor0d7_KjU = materialTheme8.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                            if (z7) {
                                jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                            }
                            long j15 = jM4726getColor0d7_KjU;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.startReplaceableGroup(-646388060);
                            long jM4726getColor0d7_KjU17 = materialTheme8.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                            if (!z7) {
                            }
                            long j16 = jM4726getColor0d7_KjU17;
                            composerStartRestartGroup.endReplaceableGroup();
                            if (interfaceC0526Fp2 != null) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            AnonymousClass3 anonymousClass10 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i28, z7, bodyLarge8, bodySmall8, interfaceC0526Fp9);
                            composer2 = composerStartRestartGroup;
                            textFieldTransitionScope8.m1928TransitionDTcfvLk(inputPhase2, j15, j16, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass10), composer2, 1769472);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp11;
                            interfaceC0526Fp18 = interfaceC0526Fp12;
                            interfaceC0526Fp19 = interfaceC0526Fp13;
                            interfaceC0526Fp20 = interfaceC0526Fp14;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z9 = z5;
                            z10 = z6;
                        } else {
                            if (i12 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp3;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp4;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp5;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp6;
                            }
                            if (i16 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp7;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp8;
                            }
                            if (i18 != 0) {
                                z4 = false;
                            } else {
                                z4 = z;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i8 != 0) {
                                z6 = false;
                            } else {
                                z6 = z3;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            text = ((TransformedText) objRememberedValue).getText().getText();
                            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                                inputPhase = InputPhase.Focused;
                            } else if (text.length() == 0) {
                                inputPhase = InputPhase.UnfocusedEmpty;
                            } else {
                                inputPhase = InputPhase.UnfocusedNotEmpty;
                            }
                            inputPhase2 = inputPhase;
                            textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                            MaterialTheme materialTheme9 = MaterialTheme.INSTANCE;
                            Typography typography9 = materialTheme9.getTypography(composerStartRestartGroup, 6);
                            TextStyle bodyLarge9 = typography9.getBodyLarge();
                            TextStyle bodySmall9 = typography9.getBodySmall();
                            int i29 = i4;
                            long jM4726getColor0d7_KjU18 = bodyLarge9.m4726getColor0d7_KjU();
                            Color.Companion companion9 = Color.Companion;
                            if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU18, companion9.m3068getUnspecified0d7_KjU())) {
                            }
                            TextFieldTransitionScope textFieldTransitionScope9 = TextFieldTransitionScope.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-646388253);
                            jM4726getColor0d7_KjU = materialTheme9.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                            if (z7) {
                                jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                            }
                            long j17 = jM4726getColor0d7_KjU;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.startReplaceableGroup(-646388060);
                            long jM4726getColor0d7_KjU19 = materialTheme9.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                            if (!z7) {
                            }
                            long j18 = jM4726getColor0d7_KjU19;
                            composerStartRestartGroup.endReplaceableGroup();
                            if (interfaceC0526Fp2 != null) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            AnonymousClass3 anonymousClass11 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i29, z7, bodyLarge9, bodySmall9, interfaceC0526Fp9);
                            composer2 = composerStartRestartGroup;
                            textFieldTransitionScope9.m1928TransitionDTcfvLk(inputPhase2, j17, j18, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass11), composer2, 1769472);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp11;
                            interfaceC0526Fp18 = interfaceC0526Fp12;
                            interfaceC0526Fp19 = interfaceC0526Fp13;
                            interfaceC0526Fp20 = interfaceC0526Fp14;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z9 = z5;
                            z10 = z6;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
                    }
                    i11 = 12582912;
                    i19 |= i11;
                    if ((1533916891 & i4) != 306783378) {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme10 = MaterialTheme.INSTANCE;
                        Typography typography10 = materialTheme10.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge10 = typography10.getBodyLarge();
                        TextStyle bodySmall10 = typography10.getBodySmall();
                        int i210 = i4;
                        long jM4726getColor0d7_KjU110 = bodyLarge10.m4726getColor0d7_KjU();
                        Color.Companion companion10 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU110, companion10.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope10 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme10.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j19 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU111 = materialTheme10.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j110 = jM4726getColor0d7_KjU111;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass12 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i210, z7, bodyLarge10, bodySmall10, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope10.m1928TransitionDTcfvLk(inputPhase2, j19, j110, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass12), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    } else {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme11 = MaterialTheme.INSTANCE;
                        Typography typography11 = materialTheme11.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge11 = typography11.getBodyLarge();
                        TextStyle bodySmall11 = typography11.getBodySmall();
                        int i211 = i4;
                        long jM4726getColor0d7_KjU112 = bodyLarge11.m4726getColor0d7_KjU();
                        Color.Companion companion11 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU112, companion11.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope11 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme11.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j111 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU113 = materialTheme11.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j112 = jM4726getColor0d7_KjU113;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass13 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i211, z7, bodyLarge11, bodySmall11, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope11.m1928TransitionDTcfvLk(inputPhase2, j111, j112, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass13), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
                }
                i10 = 1572864;
                i19 |= i10;
                if ((i3 & 131072) != 0) {
                    if ((29360128 & i2) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                    }
                    if ((1533916891 & i4) != 306783378) {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme12 = MaterialTheme.INSTANCE;
                        Typography typography12 = materialTheme12.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge12 = typography12.getBodyLarge();
                        TextStyle bodySmall12 = typography12.getBodySmall();
                        int i212 = i4;
                        long jM4726getColor0d7_KjU114 = bodyLarge12.m4726getColor0d7_KjU();
                        Color.Companion companion12 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU114, companion12.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope12 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme12.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j113 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU115 = materialTheme12.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j114 = jM4726getColor0d7_KjU115;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass14 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i212, z7, bodyLarge12, bodySmall12, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope12.m1928TransitionDTcfvLk(inputPhase2, j113, j114, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass14), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    } else {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme13 = MaterialTheme.INSTANCE;
                        Typography typography13 = materialTheme13.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge13 = typography13.getBodyLarge();
                        TextStyle bodySmall13 = typography13.getBodySmall();
                        int i213 = i4;
                        long jM4726getColor0d7_KjU116 = bodyLarge13.m4726getColor0d7_KjU();
                        Color.Companion companion13 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU116, companion13.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope13 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme13.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j115 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU117 = materialTheme13.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j116 = jM4726getColor0d7_KjU117;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass15 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i213, z7, bodyLarge13, bodySmall13, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope13.m1928TransitionDTcfvLk(inputPhase2, j115, j116, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass15), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
                }
                i11 = 12582912;
                i19 |= i11;
                if ((1533916891 & i4) != 306783378) {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme14 = MaterialTheme.INSTANCE;
                    Typography typography14 = materialTheme14.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge14 = typography14.getBodyLarge();
                    TextStyle bodySmall14 = typography14.getBodySmall();
                    int i214 = i4;
                    long jM4726getColor0d7_KjU118 = bodyLarge14.m4726getColor0d7_KjU();
                    Color.Companion companion14 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU118, companion14.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope14 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme14.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j117 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU119 = materialTheme14.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j118 = jM4726getColor0d7_KjU119;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass16 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i214, z7, bodyLarge14, bodySmall14, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope14.m1928TransitionDTcfvLk(inputPhase2, j117, j118, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass16), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                } else {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme15 = MaterialTheme.INSTANCE;
                    Typography typography15 = materialTheme15.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge15 = typography15.getBodyLarge();
                    TextStyle bodySmall15 = typography15.getBodySmall();
                    int i215 = i4;
                    long jM4726getColor0d7_KjU1110 = bodyLarge15.m4726getColor0d7_KjU();
                    Color.Companion companion15 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1110, companion15.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope15 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme15.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j119 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU1111 = materialTheme15.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j1110 = jM4726getColor0d7_KjU1111;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass17 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i215, z7, bodyLarge15, bodySmall15, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope15.m1928TransitionDTcfvLk(inputPhase2, j119, j1110, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass17), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
            }
            i19 |= 3072;
            i8 = i7;
            if ((i3 & 16384) != 0) {
                i19 |= 24576;
            } else if ((57344 & i2) == 0) {
                i19 |= composerStartRestartGroup.changed(interactionSource) ? 16384 : 8192;
            }
            if ((32768 & i3) != 0) {
                if ((458752 & i2) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                }
                if ((i3 & 65536) != 0) {
                    if ((3670016 & i2) == 0) {
                        if (composerStartRestartGroup.changed(textFieldColors)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                    }
                    if ((i3 & 131072) != 0) {
                        if ((29360128 & i2) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                        }
                        if ((1533916891 & i4) != 306783378) {
                            if (i12 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp3;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp4;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp5;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp6;
                            }
                            if (i16 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp7;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp8;
                            }
                            if (i18 != 0) {
                                z4 = false;
                            } else {
                                z4 = z;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i8 != 0) {
                                z6 = false;
                            } else {
                                z6 = z3;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            text = ((TransformedText) objRememberedValue).getText().getText();
                            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                                inputPhase = InputPhase.Focused;
                            } else if (text.length() == 0) {
                                inputPhase = InputPhase.UnfocusedEmpty;
                            } else {
                                inputPhase = InputPhase.UnfocusedNotEmpty;
                            }
                            inputPhase2 = inputPhase;
                            textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                            MaterialTheme materialTheme16 = MaterialTheme.INSTANCE;
                            Typography typography16 = materialTheme16.getTypography(composerStartRestartGroup, 6);
                            TextStyle bodyLarge16 = typography16.getBodyLarge();
                            TextStyle bodySmall16 = typography16.getBodySmall();
                            int i216 = i4;
                            long jM4726getColor0d7_KjU1112 = bodyLarge16.m4726getColor0d7_KjU();
                            Color.Companion companion16 = Color.Companion;
                            if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1112, companion16.m3068getUnspecified0d7_KjU())) {
                            }
                            TextFieldTransitionScope textFieldTransitionScope16 = TextFieldTransitionScope.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-646388253);
                            jM4726getColor0d7_KjU = materialTheme16.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                            if (z7) {
                                jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                            }
                            long j1111 = jM4726getColor0d7_KjU;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.startReplaceableGroup(-646388060);
                            long jM4726getColor0d7_KjU1113 = materialTheme16.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                            if (!z7) {
                            }
                            long j1112 = jM4726getColor0d7_KjU1113;
                            composerStartRestartGroup.endReplaceableGroup();
                            if (interfaceC0526Fp2 != null) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            AnonymousClass3 anonymousClass18 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i216, z7, bodyLarge16, bodySmall16, interfaceC0526Fp9);
                            composer2 = composerStartRestartGroup;
                            textFieldTransitionScope16.m1928TransitionDTcfvLk(inputPhase2, j1111, j1112, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass18), composer2, 1769472);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp11;
                            interfaceC0526Fp18 = interfaceC0526Fp12;
                            interfaceC0526Fp19 = interfaceC0526Fp13;
                            interfaceC0526Fp20 = interfaceC0526Fp14;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z9 = z5;
                            z10 = z6;
                        } else {
                            if (i12 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp3;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp4;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp5;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp6;
                            }
                            if (i16 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp7;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp8;
                            }
                            if (i18 != 0) {
                                z4 = false;
                            } else {
                                z4 = z;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i8 != 0) {
                                z6 = false;
                            } else {
                                z6 = z3;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            text = ((TransformedText) objRememberedValue).getText().getText();
                            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                                inputPhase = InputPhase.Focused;
                            } else if (text.length() == 0) {
                                inputPhase = InputPhase.UnfocusedEmpty;
                            } else {
                                inputPhase = InputPhase.UnfocusedNotEmpty;
                            }
                            inputPhase2 = inputPhase;
                            textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                            MaterialTheme materialTheme17 = MaterialTheme.INSTANCE;
                            Typography typography17 = materialTheme17.getTypography(composerStartRestartGroup, 6);
                            TextStyle bodyLarge17 = typography17.getBodyLarge();
                            TextStyle bodySmall17 = typography17.getBodySmall();
                            int i217 = i4;
                            long jM4726getColor0d7_KjU1114 = bodyLarge17.m4726getColor0d7_KjU();
                            Color.Companion companion17 = Color.Companion;
                            if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1114, companion17.m3068getUnspecified0d7_KjU())) {
                            }
                            TextFieldTransitionScope textFieldTransitionScope17 = TextFieldTransitionScope.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-646388253);
                            jM4726getColor0d7_KjU = materialTheme17.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                            if (z7) {
                                jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                            }
                            long j1113 = jM4726getColor0d7_KjU;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.startReplaceableGroup(-646388060);
                            long jM4726getColor0d7_KjU1115 = materialTheme17.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                            if (!z7) {
                            }
                            long j1114 = jM4726getColor0d7_KjU1115;
                            composerStartRestartGroup.endReplaceableGroup();
                            if (interfaceC0526Fp2 != null) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            AnonymousClass3 anonymousClass19 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i217, z7, bodyLarge17, bodySmall17, interfaceC0526Fp9);
                            composer2 = composerStartRestartGroup;
                            textFieldTransitionScope17.m1928TransitionDTcfvLk(inputPhase2, j1113, j1114, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass19), composer2, 1769472);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp11;
                            interfaceC0526Fp18 = interfaceC0526Fp12;
                            interfaceC0526Fp19 = interfaceC0526Fp13;
                            interfaceC0526Fp20 = interfaceC0526Fp14;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z9 = z5;
                            z10 = z6;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
                    }
                    i11 = 12582912;
                    i19 |= i11;
                    if ((1533916891 & i4) != 306783378) {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme18 = MaterialTheme.INSTANCE;
                        Typography typography18 = materialTheme18.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge18 = typography18.getBodyLarge();
                        TextStyle bodySmall18 = typography18.getBodySmall();
                        int i218 = i4;
                        long jM4726getColor0d7_KjU1116 = bodyLarge18.m4726getColor0d7_KjU();
                        Color.Companion companion18 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1116, companion18.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope18 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme18.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j1115 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU1117 = materialTheme18.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j1116 = jM4726getColor0d7_KjU1117;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass110 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i218, z7, bodyLarge18, bodySmall18, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope18.m1928TransitionDTcfvLk(inputPhase2, j1115, j1116, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass110), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    } else {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme19 = MaterialTheme.INSTANCE;
                        Typography typography19 = materialTheme19.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge19 = typography19.getBodyLarge();
                        TextStyle bodySmall19 = typography19.getBodySmall();
                        int i219 = i4;
                        long jM4726getColor0d7_KjU1118 = bodyLarge19.m4726getColor0d7_KjU();
                        Color.Companion companion19 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1118, companion19.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope19 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme19.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j1117 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU1119 = materialTheme19.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j1118 = jM4726getColor0d7_KjU1119;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass111 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i219, z7, bodyLarge19, bodySmall19, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope19.m1928TransitionDTcfvLk(inputPhase2, j1117, j1118, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass111), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
                }
                i10 = 1572864;
                i19 |= i10;
                if ((i3 & 131072) != 0) {
                    if ((29360128 & i2) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                    }
                    if ((1533916891 & i4) != 306783378) {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme110 = MaterialTheme.INSTANCE;
                        Typography typography110 = materialTheme110.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge110 = typography110.getBodyLarge();
                        TextStyle bodySmall110 = typography110.getBodySmall();
                        int i2110 = i4;
                        long jM4726getColor0d7_KjU11110 = bodyLarge110.m4726getColor0d7_KjU();
                        Color.Companion companion110 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU11110, companion110.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope110 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme110.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j1119 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU11111 = materialTheme110.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j11110 = jM4726getColor0d7_KjU11111;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass112 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2110, z7, bodyLarge110, bodySmall110, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope110.m1928TransitionDTcfvLk(inputPhase2, j1119, j11110, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass112), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    } else {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme111 = MaterialTheme.INSTANCE;
                        Typography typography111 = materialTheme111.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge111 = typography111.getBodyLarge();
                        TextStyle bodySmall111 = typography111.getBodySmall();
                        int i2111 = i4;
                        long jM4726getColor0d7_KjU11112 = bodyLarge111.m4726getColor0d7_KjU();
                        Color.Companion companion111 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU11112, companion111.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope111 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme111.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j11111 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU11113 = materialTheme111.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j11112 = jM4726getColor0d7_KjU11113;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass113 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2111, z7, bodyLarge111, bodySmall111, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope111.m1928TransitionDTcfvLk(inputPhase2, j11111, j11112, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass113), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
                }
                i11 = 12582912;
                i19 |= i11;
                if ((1533916891 & i4) != 306783378) {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme112 = MaterialTheme.INSTANCE;
                    Typography typography112 = materialTheme112.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge112 = typography112.getBodyLarge();
                    TextStyle bodySmall112 = typography112.getBodySmall();
                    int i2112 = i4;
                    long jM4726getColor0d7_KjU11114 = bodyLarge112.m4726getColor0d7_KjU();
                    Color.Companion companion112 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU11114, companion112.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope112 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme112.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j11113 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU11115 = materialTheme112.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j11114 = jM4726getColor0d7_KjU11115;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass114 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2112, z7, bodyLarge112, bodySmall112, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope112.m1928TransitionDTcfvLk(inputPhase2, j11113, j11114, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass114), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                } else {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme113 = MaterialTheme.INSTANCE;
                    Typography typography113 = materialTheme113.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge113 = typography113.getBodyLarge();
                    TextStyle bodySmall113 = typography113.getBodySmall();
                    int i2113 = i4;
                    long jM4726getColor0d7_KjU11116 = bodyLarge113.m4726getColor0d7_KjU();
                    Color.Companion companion113 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU11116, companion113.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope113 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme113.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j11115 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU11117 = materialTheme113.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j11116 = jM4726getColor0d7_KjU11117;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass115 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2113, z7, bodyLarge113, bodySmall113, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope113.m1928TransitionDTcfvLk(inputPhase2, j11115, j11116, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass115), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
            }
            i9 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i19 |= i9;
            if ((i3 & 65536) != 0) {
                if ((3670016 & i2) == 0) {
                    if (composerStartRestartGroup.changed(textFieldColors)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                }
                if ((i3 & 131072) != 0) {
                    if ((29360128 & i2) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                    }
                    if ((1533916891 & i4) != 306783378) {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme114 = MaterialTheme.INSTANCE;
                        Typography typography114 = materialTheme114.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge114 = typography114.getBodyLarge();
                        TextStyle bodySmall114 = typography114.getBodySmall();
                        int i2114 = i4;
                        long jM4726getColor0d7_KjU11118 = bodyLarge114.m4726getColor0d7_KjU();
                        Color.Companion companion114 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU11118, companion114.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope114 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme114.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j11117 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU11119 = materialTheme114.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j11118 = jM4726getColor0d7_KjU11119;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass116 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2114, z7, bodyLarge114, bodySmall114, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope114.m1928TransitionDTcfvLk(inputPhase2, j11117, j11118, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass116), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    } else {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme115 = MaterialTheme.INSTANCE;
                        Typography typography115 = materialTheme115.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge115 = typography115.getBodyLarge();
                        TextStyle bodySmall115 = typography115.getBodySmall();
                        int i2115 = i4;
                        long jM4726getColor0d7_KjU111110 = bodyLarge115.m4726getColor0d7_KjU();
                        Color.Companion companion115 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU111110, companion115.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope115 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme115.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j11119 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU111111 = materialTheme115.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j111110 = jM4726getColor0d7_KjU111111;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass117 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2115, z7, bodyLarge115, bodySmall115, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope115.m1928TransitionDTcfvLk(inputPhase2, j11119, j111110, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass117), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
                }
                i11 = 12582912;
                i19 |= i11;
                if ((1533916891 & i4) != 306783378) {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme116 = MaterialTheme.INSTANCE;
                    Typography typography116 = materialTheme116.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge116 = typography116.getBodyLarge();
                    TextStyle bodySmall116 = typography116.getBodySmall();
                    int i2116 = i4;
                    long jM4726getColor0d7_KjU111112 = bodyLarge116.m4726getColor0d7_KjU();
                    Color.Companion companion116 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU111112, companion116.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope116 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme116.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j111111 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU111113 = materialTheme116.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j111112 = jM4726getColor0d7_KjU111113;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass118 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2116, z7, bodyLarge116, bodySmall116, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope116.m1928TransitionDTcfvLk(inputPhase2, j111111, j111112, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass118), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                } else {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme117 = MaterialTheme.INSTANCE;
                    Typography typography117 = materialTheme117.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge117 = typography117.getBodyLarge();
                    TextStyle bodySmall117 = typography117.getBodySmall();
                    int i2117 = i4;
                    long jM4726getColor0d7_KjU111114 = bodyLarge117.m4726getColor0d7_KjU();
                    Color.Companion companion117 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU111114, companion117.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope117 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme117.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j111113 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU111115 = materialTheme117.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j111114 = jM4726getColor0d7_KjU111115;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass119 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2117, z7, bodyLarge117, bodySmall117, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope117.m1928TransitionDTcfvLk(inputPhase2, j111113, j111114, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass119), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
            }
            i10 = 1572864;
            i19 |= i10;
            if ((i3 & 131072) != 0) {
                if ((29360128 & i2) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                }
                if ((1533916891 & i4) != 306783378) {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme118 = MaterialTheme.INSTANCE;
                    Typography typography118 = materialTheme118.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge118 = typography118.getBodyLarge();
                    TextStyle bodySmall118 = typography118.getBodySmall();
                    int i2118 = i4;
                    long jM4726getColor0d7_KjU111116 = bodyLarge118.m4726getColor0d7_KjU();
                    Color.Companion companion118 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU111116, companion118.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope118 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme118.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j111115 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU111117 = materialTheme118.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j111116 = jM4726getColor0d7_KjU111117;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass1110 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2118, z7, bodyLarge118, bodySmall118, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope118.m1928TransitionDTcfvLk(inputPhase2, j111115, j111116, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass1110), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                } else {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme119 = MaterialTheme.INSTANCE;
                    Typography typography119 = materialTheme119.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge119 = typography119.getBodyLarge();
                    TextStyle bodySmall119 = typography119.getBodySmall();
                    int i2119 = i4;
                    long jM4726getColor0d7_KjU111118 = bodyLarge119.m4726getColor0d7_KjU();
                    Color.Companion companion119 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU111118, companion119.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope119 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme119.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j111117 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU111119 = materialTheme119.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j111118 = jM4726getColor0d7_KjU111119;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass1111 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2119, z7, bodyLarge119, bodySmall119, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope119.m1928TransitionDTcfvLk(inputPhase2, j111117, j111118, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass1111), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
            }
            i11 = 12582912;
            i19 |= i11;
            if ((1533916891 & i4) != 306783378) {
                if (i12 != 0) {
                    interfaceC0526Fp10 = null;
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp3;
                }
                if (i13 != 0) {
                    interfaceC0526Fp11 = null;
                } else {
                    interfaceC0526Fp11 = interfaceC0526Fp4;
                }
                if (i14 != 0) {
                    interfaceC0526Fp12 = null;
                } else {
                    interfaceC0526Fp12 = interfaceC0526Fp5;
                }
                if (i15 != 0) {
                    interfaceC0526Fp13 = null;
                } else {
                    interfaceC0526Fp13 = interfaceC0526Fp6;
                }
                if (i16 != 0) {
                    interfaceC0526Fp14 = null;
                } else {
                    interfaceC0526Fp14 = interfaceC0526Fp7;
                }
                if (i17 != 0) {
                    interfaceC0526Fp15 = null;
                } else {
                    interfaceC0526Fp15 = interfaceC0526Fp8;
                }
                if (i18 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                }
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                text = ((TransformedText) objRememberedValue).getText().getText();
                if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                    inputPhase = InputPhase.Focused;
                } else if (text.length() == 0) {
                    inputPhase = InputPhase.UnfocusedEmpty;
                } else {
                    inputPhase = InputPhase.UnfocusedNotEmpty;
                }
                inputPhase2 = inputPhase;
                textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                MaterialTheme materialTheme1110 = MaterialTheme.INSTANCE;
                Typography typography1110 = materialTheme1110.getTypography(composerStartRestartGroup, 6);
                TextStyle bodyLarge1110 = typography1110.getBodyLarge();
                TextStyle bodySmall1110 = typography1110.getBodySmall();
                int i21110 = i4;
                long jM4726getColor0d7_KjU1111110 = bodyLarge1110.m4726getColor0d7_KjU();
                Color.Companion companion1110 = Color.Companion;
                if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1111110, companion1110.m3068getUnspecified0d7_KjU())) {
                }
                TextFieldTransitionScope textFieldTransitionScope1110 = TextFieldTransitionScope.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-646388253);
                jM4726getColor0d7_KjU = materialTheme1110.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                if (z7) {
                    jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                }
                long j111119 = jM4726getColor0d7_KjU;
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-646388060);
                long jM4726getColor0d7_KjU1111111 = materialTheme1110.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                if (!z7) {
                }
                long j1111110 = jM4726getColor0d7_KjU1111111;
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC0526Fp2 != null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                AnonymousClass3 anonymousClass1112 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i21110, z7, bodyLarge1110, bodySmall1110, interfaceC0526Fp9);
                composer2 = composerStartRestartGroup;
                textFieldTransitionScope1110.m1928TransitionDTcfvLk(inputPhase2, j111119, j1111110, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass1112), composer2, 1769472);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp11;
                interfaceC0526Fp18 = interfaceC0526Fp12;
                interfaceC0526Fp19 = interfaceC0526Fp13;
                interfaceC0526Fp20 = interfaceC0526Fp14;
                interfaceC0526Fp21 = interfaceC0526Fp15;
                z9 = z5;
                z10 = z6;
            } else {
                if (i12 != 0) {
                    interfaceC0526Fp10 = null;
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp3;
                }
                if (i13 != 0) {
                    interfaceC0526Fp11 = null;
                } else {
                    interfaceC0526Fp11 = interfaceC0526Fp4;
                }
                if (i14 != 0) {
                    interfaceC0526Fp12 = null;
                } else {
                    interfaceC0526Fp12 = interfaceC0526Fp5;
                }
                if (i15 != 0) {
                    interfaceC0526Fp13 = null;
                } else {
                    interfaceC0526Fp13 = interfaceC0526Fp6;
                }
                if (i16 != 0) {
                    interfaceC0526Fp14 = null;
                } else {
                    interfaceC0526Fp14 = interfaceC0526Fp7;
                }
                if (i17 != 0) {
                    interfaceC0526Fp15 = null;
                } else {
                    interfaceC0526Fp15 = interfaceC0526Fp8;
                }
                if (i18 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                }
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                text = ((TransformedText) objRememberedValue).getText().getText();
                if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                    inputPhase = InputPhase.Focused;
                } else if (text.length() == 0) {
                    inputPhase = InputPhase.UnfocusedEmpty;
                } else {
                    inputPhase = InputPhase.UnfocusedNotEmpty;
                }
                inputPhase2 = inputPhase;
                textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                MaterialTheme materialTheme1111 = MaterialTheme.INSTANCE;
                Typography typography1111 = materialTheme1111.getTypography(composerStartRestartGroup, 6);
                TextStyle bodyLarge1111 = typography1111.getBodyLarge();
                TextStyle bodySmall1111 = typography1111.getBodySmall();
                int i21111 = i4;
                long jM4726getColor0d7_KjU1111112 = bodyLarge1111.m4726getColor0d7_KjU();
                Color.Companion companion1111 = Color.Companion;
                if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1111112, companion1111.m3068getUnspecified0d7_KjU())) {
                }
                TextFieldTransitionScope textFieldTransitionScope1111 = TextFieldTransitionScope.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-646388253);
                jM4726getColor0d7_KjU = materialTheme1111.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                if (z7) {
                    jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                }
                long j1111111 = jM4726getColor0d7_KjU;
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-646388060);
                long jM4726getColor0d7_KjU1111113 = materialTheme1111.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                if (!z7) {
                }
                long j1111112 = jM4726getColor0d7_KjU1111113;
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC0526Fp2 != null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                AnonymousClass3 anonymousClass1113 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i21111, z7, bodyLarge1111, bodySmall1111, interfaceC0526Fp9);
                composer2 = composerStartRestartGroup;
                textFieldTransitionScope1111.m1928TransitionDTcfvLk(inputPhase2, j1111111, j1111112, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass1113), composer2, 1769472);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp11;
                interfaceC0526Fp18 = interfaceC0526Fp12;
                interfaceC0526Fp19 = interfaceC0526Fp13;
                interfaceC0526Fp20 = interfaceC0526Fp14;
                interfaceC0526Fp21 = interfaceC0526Fp15;
                z9 = z5;
                z10 = z6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
        }
        i19 |= 384;
        i6 = i20;
        i7 = i3 & 8192;
        if (i7 != 0) {
            i8 = i7;
            if ((i2 & 7168) == 0) {
                i19 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
            }
            if ((i3 & 16384) != 0) {
                i19 |= 24576;
            } else if ((57344 & i2) == 0) {
                i19 |= composerStartRestartGroup.changed(interactionSource) ? 16384 : 8192;
            }
            if ((32768 & i3) != 0) {
                if ((458752 & i2) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                }
                if ((i3 & 65536) != 0) {
                    if ((3670016 & i2) == 0) {
                        if (composerStartRestartGroup.changed(textFieldColors)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                    }
                    if ((i3 & 131072) != 0) {
                        if ((29360128 & i2) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                        }
                        if ((1533916891 & i4) != 306783378) {
                            if (i12 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp3;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp4;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp5;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp6;
                            }
                            if (i16 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp7;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp8;
                            }
                            if (i18 != 0) {
                                z4 = false;
                            } else {
                                z4 = z;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i8 != 0) {
                                z6 = false;
                            } else {
                                z6 = z3;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            text = ((TransformedText) objRememberedValue).getText().getText();
                            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                                inputPhase = InputPhase.Focused;
                            } else if (text.length() == 0) {
                                inputPhase = InputPhase.UnfocusedEmpty;
                            } else {
                                inputPhase = InputPhase.UnfocusedNotEmpty;
                            }
                            inputPhase2 = inputPhase;
                            textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                            MaterialTheme materialTheme1112 = MaterialTheme.INSTANCE;
                            Typography typography1112 = materialTheme1112.getTypography(composerStartRestartGroup, 6);
                            TextStyle bodyLarge1112 = typography1112.getBodyLarge();
                            TextStyle bodySmall1112 = typography1112.getBodySmall();
                            int i21112 = i4;
                            long jM4726getColor0d7_KjU1111114 = bodyLarge1112.m4726getColor0d7_KjU();
                            Color.Companion companion1112 = Color.Companion;
                            if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1111114, companion1112.m3068getUnspecified0d7_KjU())) {
                            }
                            TextFieldTransitionScope textFieldTransitionScope1112 = TextFieldTransitionScope.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-646388253);
                            jM4726getColor0d7_KjU = materialTheme1112.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                            if (z7) {
                                jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                            }
                            long j1111113 = jM4726getColor0d7_KjU;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.startReplaceableGroup(-646388060);
                            long jM4726getColor0d7_KjU1111115 = materialTheme1112.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                            if (!z7) {
                            }
                            long j1111114 = jM4726getColor0d7_KjU1111115;
                            composerStartRestartGroup.endReplaceableGroup();
                            if (interfaceC0526Fp2 != null) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            AnonymousClass3 anonymousClass1114 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i21112, z7, bodyLarge1112, bodySmall1112, interfaceC0526Fp9);
                            composer2 = composerStartRestartGroup;
                            textFieldTransitionScope1112.m1928TransitionDTcfvLk(inputPhase2, j1111113, j1111114, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass1114), composer2, 1769472);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp11;
                            interfaceC0526Fp18 = interfaceC0526Fp12;
                            interfaceC0526Fp19 = interfaceC0526Fp13;
                            interfaceC0526Fp20 = interfaceC0526Fp14;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z9 = z5;
                            z10 = z6;
                        } else {
                            if (i12 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp3;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp4;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp5;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp6;
                            }
                            if (i16 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp7;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp8;
                            }
                            if (i18 != 0) {
                                z4 = false;
                            } else {
                                z4 = z;
                            }
                            if (i6 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i8 != 0) {
                                z6 = false;
                            } else {
                                z6 = z3;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                            }
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            text = ((TransformedText) objRememberedValue).getText().getText();
                            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                                inputPhase = InputPhase.Focused;
                            } else if (text.length() == 0) {
                                inputPhase = InputPhase.UnfocusedEmpty;
                            } else {
                                inputPhase = InputPhase.UnfocusedNotEmpty;
                            }
                            inputPhase2 = inputPhase;
                            textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                            MaterialTheme materialTheme1113 = MaterialTheme.INSTANCE;
                            Typography typography1113 = materialTheme1113.getTypography(composerStartRestartGroup, 6);
                            TextStyle bodyLarge1113 = typography1113.getBodyLarge();
                            TextStyle bodySmall1113 = typography1113.getBodySmall();
                            int i21113 = i4;
                            long jM4726getColor0d7_KjU1111116 = bodyLarge1113.m4726getColor0d7_KjU();
                            Color.Companion companion1113 = Color.Companion;
                            if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1111116, companion1113.m3068getUnspecified0d7_KjU())) {
                            }
                            TextFieldTransitionScope textFieldTransitionScope1113 = TextFieldTransitionScope.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-646388253);
                            jM4726getColor0d7_KjU = materialTheme1113.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                            if (z7) {
                                jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                            }
                            long j1111115 = jM4726getColor0d7_KjU;
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.startReplaceableGroup(-646388060);
                            long jM4726getColor0d7_KjU1111117 = materialTheme1113.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                            if (!z7) {
                            }
                            long j1111116 = jM4726getColor0d7_KjU1111117;
                            composerStartRestartGroup.endReplaceableGroup();
                            if (interfaceC0526Fp2 != null) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            AnonymousClass3 anonymousClass1115 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i21113, z7, bodyLarge1113, bodySmall1113, interfaceC0526Fp9);
                            composer2 = composerStartRestartGroup;
                            textFieldTransitionScope1113.m1928TransitionDTcfvLk(inputPhase2, j1111115, j1111116, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass1115), composer2, 1769472);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp11;
                            interfaceC0526Fp18 = interfaceC0526Fp12;
                            interfaceC0526Fp19 = interfaceC0526Fp13;
                            interfaceC0526Fp20 = interfaceC0526Fp14;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z9 = z5;
                            z10 = z6;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
                    }
                    i11 = 12582912;
                    i19 |= i11;
                    if ((1533916891 & i4) != 306783378) {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme1114 = MaterialTheme.INSTANCE;
                        Typography typography1114 = materialTheme1114.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge1114 = typography1114.getBodyLarge();
                        TextStyle bodySmall1114 = typography1114.getBodySmall();
                        int i21114 = i4;
                        long jM4726getColor0d7_KjU1111118 = bodyLarge1114.m4726getColor0d7_KjU();
                        Color.Companion companion1114 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1111118, companion1114.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope1114 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme1114.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j1111117 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU1111119 = materialTheme1114.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j1111118 = jM4726getColor0d7_KjU1111119;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass1116 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i21114, z7, bodyLarge1114, bodySmall1114, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope1114.m1928TransitionDTcfvLk(inputPhase2, j1111117, j1111118, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass1116), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    } else {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme1115 = MaterialTheme.INSTANCE;
                        Typography typography1115 = materialTheme1115.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge1115 = typography1115.getBodyLarge();
                        TextStyle bodySmall1115 = typography1115.getBodySmall();
                        int i21115 = i4;
                        long jM4726getColor0d7_KjU11111110 = bodyLarge1115.m4726getColor0d7_KjU();
                        Color.Companion companion1115 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU11111110, companion1115.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope1115 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme1115.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j1111119 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU11111111 = materialTheme1115.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j11111110 = jM4726getColor0d7_KjU11111111;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass1117 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i21115, z7, bodyLarge1115, bodySmall1115, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope1115.m1928TransitionDTcfvLk(inputPhase2, j1111119, j11111110, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass1117), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
                }
                i10 = 1572864;
                i19 |= i10;
                if ((i3 & 131072) != 0) {
                    if ((29360128 & i2) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                    }
                    if ((1533916891 & i4) != 306783378) {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme1116 = MaterialTheme.INSTANCE;
                        Typography typography1116 = materialTheme1116.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge1116 = typography1116.getBodyLarge();
                        TextStyle bodySmall1116 = typography1116.getBodySmall();
                        int i21116 = i4;
                        long jM4726getColor0d7_KjU11111112 = bodyLarge1116.m4726getColor0d7_KjU();
                        Color.Companion companion1116 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU11111112, companion1116.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope1116 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme1116.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j11111111 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU11111113 = materialTheme1116.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j11111112 = jM4726getColor0d7_KjU11111113;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass1118 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i21116, z7, bodyLarge1116, bodySmall1116, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope1116.m1928TransitionDTcfvLk(inputPhase2, j11111111, j11111112, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass1118), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    } else {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme1117 = MaterialTheme.INSTANCE;
                        Typography typography1117 = materialTheme1117.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge1117 = typography1117.getBodyLarge();
                        TextStyle bodySmall1117 = typography1117.getBodySmall();
                        int i21117 = i4;
                        long jM4726getColor0d7_KjU11111114 = bodyLarge1117.m4726getColor0d7_KjU();
                        Color.Companion companion1117 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU11111114, companion1117.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope1117 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme1117.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j11111113 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU11111115 = materialTheme1117.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j11111114 = jM4726getColor0d7_KjU11111115;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass1119 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i21117, z7, bodyLarge1117, bodySmall1117, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope1117.m1928TransitionDTcfvLk(inputPhase2, j11111113, j11111114, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass1119), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
                }
                i11 = 12582912;
                i19 |= i11;
                if ((1533916891 & i4) != 306783378) {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme1118 = MaterialTheme.INSTANCE;
                    Typography typography1118 = materialTheme1118.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge1118 = typography1118.getBodyLarge();
                    TextStyle bodySmall1118 = typography1118.getBodySmall();
                    int i21118 = i4;
                    long jM4726getColor0d7_KjU11111116 = bodyLarge1118.m4726getColor0d7_KjU();
                    Color.Companion companion1118 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU11111116, companion1118.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope1118 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme1118.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j11111115 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU11111117 = materialTheme1118.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j11111116 = jM4726getColor0d7_KjU11111117;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass11110 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i21118, z7, bodyLarge1118, bodySmall1118, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope1118.m1928TransitionDTcfvLk(inputPhase2, j11111115, j11111116, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass11110), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                } else {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme1119 = MaterialTheme.INSTANCE;
                    Typography typography1119 = materialTheme1119.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge1119 = typography1119.getBodyLarge();
                    TextStyle bodySmall1119 = typography1119.getBodySmall();
                    int i21119 = i4;
                    long jM4726getColor0d7_KjU11111118 = bodyLarge1119.m4726getColor0d7_KjU();
                    Color.Companion companion1119 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU11111118, companion1119.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope1119 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme1119.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j11111117 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU11111119 = materialTheme1119.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j11111118 = jM4726getColor0d7_KjU11111119;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass11111 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i21119, z7, bodyLarge1119, bodySmall1119, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope1119.m1928TransitionDTcfvLk(inputPhase2, j11111117, j11111118, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass11111), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
            }
            i9 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i19 |= i9;
            if ((i3 & 65536) != 0) {
                if ((3670016 & i2) == 0) {
                    if (composerStartRestartGroup.changed(textFieldColors)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                }
                if ((i3 & 131072) != 0) {
                    if ((29360128 & i2) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                    }
                    if ((1533916891 & i4) != 306783378) {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme11110 = MaterialTheme.INSTANCE;
                        Typography typography11110 = materialTheme11110.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge11110 = typography11110.getBodyLarge();
                        TextStyle bodySmall11110 = typography11110.getBodySmall();
                        int i211110 = i4;
                        long jM4726getColor0d7_KjU111111110 = bodyLarge11110.m4726getColor0d7_KjU();
                        Color.Companion companion11110 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU111111110, companion11110.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope11110 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme11110.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j11111119 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU111111111 = materialTheme11110.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j111111110 = jM4726getColor0d7_KjU111111111;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass11112 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i211110, z7, bodyLarge11110, bodySmall11110, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope11110.m1928TransitionDTcfvLk(inputPhase2, j11111119, j111111110, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass11112), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    } else {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme11111 = MaterialTheme.INSTANCE;
                        Typography typography11111 = materialTheme11111.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge11111 = typography11111.getBodyLarge();
                        TextStyle bodySmall11111 = typography11111.getBodySmall();
                        int i211111 = i4;
                        long jM4726getColor0d7_KjU111111112 = bodyLarge11111.m4726getColor0d7_KjU();
                        Color.Companion companion11111 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU111111112, companion11111.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope11111 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme11111.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j111111111 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU111111113 = materialTheme11111.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j111111112 = jM4726getColor0d7_KjU111111113;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass11113 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i211111, z7, bodyLarge11111, bodySmall11111, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope11111.m1928TransitionDTcfvLk(inputPhase2, j111111111, j111111112, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass11113), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
                }
                i11 = 12582912;
                i19 |= i11;
                if ((1533916891 & i4) != 306783378) {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme11112 = MaterialTheme.INSTANCE;
                    Typography typography11112 = materialTheme11112.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge11112 = typography11112.getBodyLarge();
                    TextStyle bodySmall11112 = typography11112.getBodySmall();
                    int i211112 = i4;
                    long jM4726getColor0d7_KjU111111114 = bodyLarge11112.m4726getColor0d7_KjU();
                    Color.Companion companion11112 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU111111114, companion11112.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope11112 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme11112.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j111111113 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU111111115 = materialTheme11112.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j111111114 = jM4726getColor0d7_KjU111111115;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass11114 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i211112, z7, bodyLarge11112, bodySmall11112, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope11112.m1928TransitionDTcfvLk(inputPhase2, j111111113, j111111114, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass11114), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                } else {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme11113 = MaterialTheme.INSTANCE;
                    Typography typography11113 = materialTheme11113.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge11113 = typography11113.getBodyLarge();
                    TextStyle bodySmall11113 = typography11113.getBodySmall();
                    int i211113 = i4;
                    long jM4726getColor0d7_KjU111111116 = bodyLarge11113.m4726getColor0d7_KjU();
                    Color.Companion companion11113 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU111111116, companion11113.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope11113 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme11113.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j111111115 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU111111117 = materialTheme11113.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j111111116 = jM4726getColor0d7_KjU111111117;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass11115 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i211113, z7, bodyLarge11113, bodySmall11113, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope11113.m1928TransitionDTcfvLk(inputPhase2, j111111115, j111111116, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass11115), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
            }
            i10 = 1572864;
            i19 |= i10;
            if ((i3 & 131072) != 0) {
                if ((29360128 & i2) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                }
                if ((1533916891 & i4) != 306783378) {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme11114 = MaterialTheme.INSTANCE;
                    Typography typography11114 = materialTheme11114.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge11114 = typography11114.getBodyLarge();
                    TextStyle bodySmall11114 = typography11114.getBodySmall();
                    int i211114 = i4;
                    long jM4726getColor0d7_KjU111111118 = bodyLarge11114.m4726getColor0d7_KjU();
                    Color.Companion companion11114 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU111111118, companion11114.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope11114 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme11114.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j111111117 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU111111119 = materialTheme11114.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j111111118 = jM4726getColor0d7_KjU111111119;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass11116 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i211114, z7, bodyLarge11114, bodySmall11114, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope11114.m1928TransitionDTcfvLk(inputPhase2, j111111117, j111111118, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass11116), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                } else {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme11115 = MaterialTheme.INSTANCE;
                    Typography typography11115 = materialTheme11115.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge11115 = typography11115.getBodyLarge();
                    TextStyle bodySmall11115 = typography11115.getBodySmall();
                    int i211115 = i4;
                    long jM4726getColor0d7_KjU1111111110 = bodyLarge11115.m4726getColor0d7_KjU();
                    Color.Companion companion11115 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1111111110, companion11115.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope11115 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme11115.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j111111119 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU1111111111 = materialTheme11115.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j1111111110 = jM4726getColor0d7_KjU1111111111;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass11117 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i211115, z7, bodyLarge11115, bodySmall11115, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope11115.m1928TransitionDTcfvLk(inputPhase2, j111111119, j1111111110, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass11117), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
            }
            i11 = 12582912;
            i19 |= i11;
            if ((1533916891 & i4) != 306783378) {
                if (i12 != 0) {
                    interfaceC0526Fp10 = null;
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp3;
                }
                if (i13 != 0) {
                    interfaceC0526Fp11 = null;
                } else {
                    interfaceC0526Fp11 = interfaceC0526Fp4;
                }
                if (i14 != 0) {
                    interfaceC0526Fp12 = null;
                } else {
                    interfaceC0526Fp12 = interfaceC0526Fp5;
                }
                if (i15 != 0) {
                    interfaceC0526Fp13 = null;
                } else {
                    interfaceC0526Fp13 = interfaceC0526Fp6;
                }
                if (i16 != 0) {
                    interfaceC0526Fp14 = null;
                } else {
                    interfaceC0526Fp14 = interfaceC0526Fp7;
                }
                if (i17 != 0) {
                    interfaceC0526Fp15 = null;
                } else {
                    interfaceC0526Fp15 = interfaceC0526Fp8;
                }
                if (i18 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                }
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                text = ((TransformedText) objRememberedValue).getText().getText();
                if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                    inputPhase = InputPhase.Focused;
                } else if (text.length() == 0) {
                    inputPhase = InputPhase.UnfocusedEmpty;
                } else {
                    inputPhase = InputPhase.UnfocusedNotEmpty;
                }
                inputPhase2 = inputPhase;
                textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                MaterialTheme materialTheme11116 = MaterialTheme.INSTANCE;
                Typography typography11116 = materialTheme11116.getTypography(composerStartRestartGroup, 6);
                TextStyle bodyLarge11116 = typography11116.getBodyLarge();
                TextStyle bodySmall11116 = typography11116.getBodySmall();
                int i211116 = i4;
                long jM4726getColor0d7_KjU1111111112 = bodyLarge11116.m4726getColor0d7_KjU();
                Color.Companion companion11116 = Color.Companion;
                if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1111111112, companion11116.m3068getUnspecified0d7_KjU())) {
                }
                TextFieldTransitionScope textFieldTransitionScope11116 = TextFieldTransitionScope.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-646388253);
                jM4726getColor0d7_KjU = materialTheme11116.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                if (z7) {
                    jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                }
                long j1111111111 = jM4726getColor0d7_KjU;
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-646388060);
                long jM4726getColor0d7_KjU1111111113 = materialTheme11116.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                if (!z7) {
                }
                long j1111111112 = jM4726getColor0d7_KjU1111111113;
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC0526Fp2 != null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                AnonymousClass3 anonymousClass11118 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i211116, z7, bodyLarge11116, bodySmall11116, interfaceC0526Fp9);
                composer2 = composerStartRestartGroup;
                textFieldTransitionScope11116.m1928TransitionDTcfvLk(inputPhase2, j1111111111, j1111111112, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass11118), composer2, 1769472);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp11;
                interfaceC0526Fp18 = interfaceC0526Fp12;
                interfaceC0526Fp19 = interfaceC0526Fp13;
                interfaceC0526Fp20 = interfaceC0526Fp14;
                interfaceC0526Fp21 = interfaceC0526Fp15;
                z9 = z5;
                z10 = z6;
            } else {
                if (i12 != 0) {
                    interfaceC0526Fp10 = null;
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp3;
                }
                if (i13 != 0) {
                    interfaceC0526Fp11 = null;
                } else {
                    interfaceC0526Fp11 = interfaceC0526Fp4;
                }
                if (i14 != 0) {
                    interfaceC0526Fp12 = null;
                } else {
                    interfaceC0526Fp12 = interfaceC0526Fp5;
                }
                if (i15 != 0) {
                    interfaceC0526Fp13 = null;
                } else {
                    interfaceC0526Fp13 = interfaceC0526Fp6;
                }
                if (i16 != 0) {
                    interfaceC0526Fp14 = null;
                } else {
                    interfaceC0526Fp14 = interfaceC0526Fp7;
                }
                if (i17 != 0) {
                    interfaceC0526Fp15 = null;
                } else {
                    interfaceC0526Fp15 = interfaceC0526Fp8;
                }
                if (i18 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                }
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                text = ((TransformedText) objRememberedValue).getText().getText();
                if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                    inputPhase = InputPhase.Focused;
                } else if (text.length() == 0) {
                    inputPhase = InputPhase.UnfocusedEmpty;
                } else {
                    inputPhase = InputPhase.UnfocusedNotEmpty;
                }
                inputPhase2 = inputPhase;
                textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                MaterialTheme materialTheme11117 = MaterialTheme.INSTANCE;
                Typography typography11117 = materialTheme11117.getTypography(composerStartRestartGroup, 6);
                TextStyle bodyLarge11117 = typography11117.getBodyLarge();
                TextStyle bodySmall11117 = typography11117.getBodySmall();
                int i211117 = i4;
                long jM4726getColor0d7_KjU1111111114 = bodyLarge11117.m4726getColor0d7_KjU();
                Color.Companion companion11117 = Color.Companion;
                if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1111111114, companion11117.m3068getUnspecified0d7_KjU())) {
                }
                TextFieldTransitionScope textFieldTransitionScope11117 = TextFieldTransitionScope.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-646388253);
                jM4726getColor0d7_KjU = materialTheme11117.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                if (z7) {
                    jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                }
                long j1111111113 = jM4726getColor0d7_KjU;
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-646388060);
                long jM4726getColor0d7_KjU1111111115 = materialTheme11117.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                if (!z7) {
                }
                long j1111111114 = jM4726getColor0d7_KjU1111111115;
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC0526Fp2 != null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                AnonymousClass3 anonymousClass11119 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i211117, z7, bodyLarge11117, bodySmall11117, interfaceC0526Fp9);
                composer2 = composerStartRestartGroup;
                textFieldTransitionScope11117.m1928TransitionDTcfvLk(inputPhase2, j1111111113, j1111111114, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass11119), composer2, 1769472);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp11;
                interfaceC0526Fp18 = interfaceC0526Fp12;
                interfaceC0526Fp19 = interfaceC0526Fp13;
                interfaceC0526Fp20 = interfaceC0526Fp14;
                interfaceC0526Fp21 = interfaceC0526Fp15;
                z9 = z5;
                z10 = z6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
        }
        i19 |= 3072;
        i8 = i7;
        if ((i3 & 16384) != 0) {
            i19 |= 24576;
        } else if ((57344 & i2) == 0) {
            i19 |= composerStartRestartGroup.changed(interactionSource) ? 16384 : 8192;
        }
        if ((32768 & i3) != 0) {
            if ((458752 & i2) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
            }
            if ((i3 & 65536) != 0) {
                if ((3670016 & i2) == 0) {
                    if (composerStartRestartGroup.changed(textFieldColors)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                }
                if ((i3 & 131072) != 0) {
                    if ((29360128 & i2) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                    }
                    if ((1533916891 & i4) != 306783378) {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme11118 = MaterialTheme.INSTANCE;
                        Typography typography11118 = materialTheme11118.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge11118 = typography11118.getBodyLarge();
                        TextStyle bodySmall11118 = typography11118.getBodySmall();
                        int i211118 = i4;
                        long jM4726getColor0d7_KjU1111111116 = bodyLarge11118.m4726getColor0d7_KjU();
                        Color.Companion companion11118 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1111111116, companion11118.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope11118 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme11118.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j1111111115 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU1111111117 = materialTheme11118.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j1111111116 = jM4726getColor0d7_KjU1111111117;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass111110 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i211118, z7, bodyLarge11118, bodySmall11118, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope11118.m1928TransitionDTcfvLk(inputPhase2, j1111111115, j1111111116, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass111110), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    } else {
                        if (i12 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp3;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp4;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp5;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp6;
                        }
                        if (i16 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp7;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp8;
                        }
                        if (i18 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i8 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        text = ((TransformedText) objRememberedValue).getText().getText();
                        if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                            inputPhase = InputPhase.Focused;
                        } else if (text.length() == 0) {
                            inputPhase = InputPhase.UnfocusedEmpty;
                        } else {
                            inputPhase = InputPhase.UnfocusedNotEmpty;
                        }
                        inputPhase2 = inputPhase;
                        textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                        MaterialTheme materialTheme11119 = MaterialTheme.INSTANCE;
                        Typography typography11119 = materialTheme11119.getTypography(composerStartRestartGroup, 6);
                        TextStyle bodyLarge11119 = typography11119.getBodyLarge();
                        TextStyle bodySmall11119 = typography11119.getBodySmall();
                        int i211119 = i4;
                        long jM4726getColor0d7_KjU1111111118 = bodyLarge11119.m4726getColor0d7_KjU();
                        Color.Companion companion11119 = Color.Companion;
                        if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1111111118, companion11119.m3068getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope11119 = TextFieldTransitionScope.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-646388253);
                        jM4726getColor0d7_KjU = materialTheme11119.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                        if (z7) {
                            jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                        }
                        long j1111111117 = jM4726getColor0d7_KjU;
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-646388060);
                        long jM4726getColor0d7_KjU1111111119 = materialTheme11119.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                        if (!z7) {
                        }
                        long j1111111118 = jM4726getColor0d7_KjU1111111119;
                        composerStartRestartGroup.endReplaceableGroup();
                        if (interfaceC0526Fp2 != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        AnonymousClass3 anonymousClass111111 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i211119, z7, bodyLarge11119, bodySmall11119, interfaceC0526Fp9);
                        composer2 = composerStartRestartGroup;
                        textFieldTransitionScope11119.m1928TransitionDTcfvLk(inputPhase2, j1111111117, j1111111118, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass111111), composer2, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp11;
                        interfaceC0526Fp18 = interfaceC0526Fp12;
                        interfaceC0526Fp19 = interfaceC0526Fp13;
                        interfaceC0526Fp20 = interfaceC0526Fp14;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z9 = z5;
                        z10 = z6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
                }
                i11 = 12582912;
                i19 |= i11;
                if ((1533916891 & i4) != 306783378) {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme111110 = MaterialTheme.INSTANCE;
                    Typography typography111110 = materialTheme111110.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge111110 = typography111110.getBodyLarge();
                    TextStyle bodySmall111110 = typography111110.getBodySmall();
                    int i2111110 = i4;
                    long jM4726getColor0d7_KjU11111111110 = bodyLarge111110.m4726getColor0d7_KjU();
                    Color.Companion companion111110 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU11111111110, companion111110.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope111110 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme111110.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j1111111119 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU11111111111 = materialTheme111110.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j11111111110 = jM4726getColor0d7_KjU11111111111;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass111112 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2111110, z7, bodyLarge111110, bodySmall111110, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope111110.m1928TransitionDTcfvLk(inputPhase2, j1111111119, j11111111110, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass111112), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                } else {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme111111 = MaterialTheme.INSTANCE;
                    Typography typography111111 = materialTheme111111.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge111111 = typography111111.getBodyLarge();
                    TextStyle bodySmall111111 = typography111111.getBodySmall();
                    int i2111111 = i4;
                    long jM4726getColor0d7_KjU11111111112 = bodyLarge111111.m4726getColor0d7_KjU();
                    Color.Companion companion111111 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU11111111112, companion111111.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope111111 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme111111.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j11111111111 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU11111111113 = materialTheme111111.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j11111111112 = jM4726getColor0d7_KjU11111111113;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass111113 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2111111, z7, bodyLarge111111, bodySmall111111, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope111111.m1928TransitionDTcfvLk(inputPhase2, j11111111111, j11111111112, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass111113), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
            }
            i10 = 1572864;
            i19 |= i10;
            if ((i3 & 131072) != 0) {
                if ((29360128 & i2) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                }
                if ((1533916891 & i4) != 306783378) {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme111112 = MaterialTheme.INSTANCE;
                    Typography typography111112 = materialTheme111112.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge111112 = typography111112.getBodyLarge();
                    TextStyle bodySmall111112 = typography111112.getBodySmall();
                    int i2111112 = i4;
                    long jM4726getColor0d7_KjU11111111114 = bodyLarge111112.m4726getColor0d7_KjU();
                    Color.Companion companion111112 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU11111111114, companion111112.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope111112 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme111112.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j11111111113 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU11111111115 = materialTheme111112.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j11111111114 = jM4726getColor0d7_KjU11111111115;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass111114 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2111112, z7, bodyLarge111112, bodySmall111112, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope111112.m1928TransitionDTcfvLk(inputPhase2, j11111111113, j11111111114, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass111114), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                } else {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme111113 = MaterialTheme.INSTANCE;
                    Typography typography111113 = materialTheme111113.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge111113 = typography111113.getBodyLarge();
                    TextStyle bodySmall111113 = typography111113.getBodySmall();
                    int i2111113 = i4;
                    long jM4726getColor0d7_KjU11111111116 = bodyLarge111113.m4726getColor0d7_KjU();
                    Color.Companion companion111113 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU11111111116, companion111113.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope111113 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme111113.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j11111111115 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU11111111117 = materialTheme111113.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j11111111116 = jM4726getColor0d7_KjU11111111117;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass111115 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2111113, z7, bodyLarge111113, bodySmall111113, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope111113.m1928TransitionDTcfvLk(inputPhase2, j11111111115, j11111111116, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass111115), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
            }
            i11 = 12582912;
            i19 |= i11;
            if ((1533916891 & i4) != 306783378) {
                if (i12 != 0) {
                    interfaceC0526Fp10 = null;
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp3;
                }
                if (i13 != 0) {
                    interfaceC0526Fp11 = null;
                } else {
                    interfaceC0526Fp11 = interfaceC0526Fp4;
                }
                if (i14 != 0) {
                    interfaceC0526Fp12 = null;
                } else {
                    interfaceC0526Fp12 = interfaceC0526Fp5;
                }
                if (i15 != 0) {
                    interfaceC0526Fp13 = null;
                } else {
                    interfaceC0526Fp13 = interfaceC0526Fp6;
                }
                if (i16 != 0) {
                    interfaceC0526Fp14 = null;
                } else {
                    interfaceC0526Fp14 = interfaceC0526Fp7;
                }
                if (i17 != 0) {
                    interfaceC0526Fp15 = null;
                } else {
                    interfaceC0526Fp15 = interfaceC0526Fp8;
                }
                if (i18 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                }
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                text = ((TransformedText) objRememberedValue).getText().getText();
                if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                    inputPhase = InputPhase.Focused;
                } else if (text.length() == 0) {
                    inputPhase = InputPhase.UnfocusedEmpty;
                } else {
                    inputPhase = InputPhase.UnfocusedNotEmpty;
                }
                inputPhase2 = inputPhase;
                textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                MaterialTheme materialTheme111114 = MaterialTheme.INSTANCE;
                Typography typography111114 = materialTheme111114.getTypography(composerStartRestartGroup, 6);
                TextStyle bodyLarge111114 = typography111114.getBodyLarge();
                TextStyle bodySmall111114 = typography111114.getBodySmall();
                int i2111114 = i4;
                long jM4726getColor0d7_KjU11111111118 = bodyLarge111114.m4726getColor0d7_KjU();
                Color.Companion companion111114 = Color.Companion;
                if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU11111111118, companion111114.m3068getUnspecified0d7_KjU())) {
                }
                TextFieldTransitionScope textFieldTransitionScope111114 = TextFieldTransitionScope.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-646388253);
                jM4726getColor0d7_KjU = materialTheme111114.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                if (z7) {
                    jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                }
                long j11111111117 = jM4726getColor0d7_KjU;
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-646388060);
                long jM4726getColor0d7_KjU11111111119 = materialTheme111114.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                if (!z7) {
                }
                long j11111111118 = jM4726getColor0d7_KjU11111111119;
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC0526Fp2 != null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                AnonymousClass3 anonymousClass111116 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2111114, z7, bodyLarge111114, bodySmall111114, interfaceC0526Fp9);
                composer2 = composerStartRestartGroup;
                textFieldTransitionScope111114.m1928TransitionDTcfvLk(inputPhase2, j11111111117, j11111111118, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass111116), composer2, 1769472);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp11;
                interfaceC0526Fp18 = interfaceC0526Fp12;
                interfaceC0526Fp19 = interfaceC0526Fp13;
                interfaceC0526Fp20 = interfaceC0526Fp14;
                interfaceC0526Fp21 = interfaceC0526Fp15;
                z9 = z5;
                z10 = z6;
            } else {
                if (i12 != 0) {
                    interfaceC0526Fp10 = null;
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp3;
                }
                if (i13 != 0) {
                    interfaceC0526Fp11 = null;
                } else {
                    interfaceC0526Fp11 = interfaceC0526Fp4;
                }
                if (i14 != 0) {
                    interfaceC0526Fp12 = null;
                } else {
                    interfaceC0526Fp12 = interfaceC0526Fp5;
                }
                if (i15 != 0) {
                    interfaceC0526Fp13 = null;
                } else {
                    interfaceC0526Fp13 = interfaceC0526Fp6;
                }
                if (i16 != 0) {
                    interfaceC0526Fp14 = null;
                } else {
                    interfaceC0526Fp14 = interfaceC0526Fp7;
                }
                if (i17 != 0) {
                    interfaceC0526Fp15 = null;
                } else {
                    interfaceC0526Fp15 = interfaceC0526Fp8;
                }
                if (i18 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                }
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                text = ((TransformedText) objRememberedValue).getText().getText();
                if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                    inputPhase = InputPhase.Focused;
                } else if (text.length() == 0) {
                    inputPhase = InputPhase.UnfocusedEmpty;
                } else {
                    inputPhase = InputPhase.UnfocusedNotEmpty;
                }
                inputPhase2 = inputPhase;
                textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                MaterialTheme materialTheme111115 = MaterialTheme.INSTANCE;
                Typography typography111115 = materialTheme111115.getTypography(composerStartRestartGroup, 6);
                TextStyle bodyLarge111115 = typography111115.getBodyLarge();
                TextStyle bodySmall111115 = typography111115.getBodySmall();
                int i2111115 = i4;
                long jM4726getColor0d7_KjU111111111110 = bodyLarge111115.m4726getColor0d7_KjU();
                Color.Companion companion111115 = Color.Companion;
                if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU111111111110, companion111115.m3068getUnspecified0d7_KjU())) {
                }
                TextFieldTransitionScope textFieldTransitionScope111115 = TextFieldTransitionScope.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-646388253);
                jM4726getColor0d7_KjU = materialTheme111115.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                if (z7) {
                    jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                }
                long j11111111119 = jM4726getColor0d7_KjU;
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-646388060);
                long jM4726getColor0d7_KjU111111111111 = materialTheme111115.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                if (!z7) {
                }
                long j111111111110 = jM4726getColor0d7_KjU111111111111;
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC0526Fp2 != null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                AnonymousClass3 anonymousClass111117 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2111115, z7, bodyLarge111115, bodySmall111115, interfaceC0526Fp9);
                composer2 = composerStartRestartGroup;
                textFieldTransitionScope111115.m1928TransitionDTcfvLk(inputPhase2, j11111111119, j111111111110, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass111117), composer2, 1769472);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp11;
                interfaceC0526Fp18 = interfaceC0526Fp12;
                interfaceC0526Fp19 = interfaceC0526Fp13;
                interfaceC0526Fp20 = interfaceC0526Fp14;
                interfaceC0526Fp21 = interfaceC0526Fp15;
                z9 = z5;
                z10 = z6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
        }
        i9 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i19 |= i9;
        if ((i3 & 65536) != 0) {
            if ((3670016 & i2) == 0) {
                if (composerStartRestartGroup.changed(textFieldColors)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
            }
            if ((i3 & 131072) != 0) {
                if ((29360128 & i2) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                }
                if ((1533916891 & i4) != 306783378) {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme111116 = MaterialTheme.INSTANCE;
                    Typography typography111116 = materialTheme111116.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge111116 = typography111116.getBodyLarge();
                    TextStyle bodySmall111116 = typography111116.getBodySmall();
                    int i2111116 = i4;
                    long jM4726getColor0d7_KjU111111111112 = bodyLarge111116.m4726getColor0d7_KjU();
                    Color.Companion companion111116 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU111111111112, companion111116.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope111116 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme111116.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j111111111111 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU111111111113 = materialTheme111116.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j111111111112 = jM4726getColor0d7_KjU111111111113;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass111118 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2111116, z7, bodyLarge111116, bodySmall111116, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope111116.m1928TransitionDTcfvLk(inputPhase2, j111111111111, j111111111112, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass111118), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                } else {
                    if (i12 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp3;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp4;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp5;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp6;
                    }
                    if (i16 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp7;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp8;
                    }
                    if (i18 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i8 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    text = ((TransformedText) objRememberedValue).getText().getText();
                    if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                        inputPhase = InputPhase.Focused;
                    } else if (text.length() == 0) {
                        inputPhase = InputPhase.UnfocusedEmpty;
                    } else {
                        inputPhase = InputPhase.UnfocusedNotEmpty;
                    }
                    inputPhase2 = inputPhase;
                    textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                    MaterialTheme materialTheme111117 = MaterialTheme.INSTANCE;
                    Typography typography111117 = materialTheme111117.getTypography(composerStartRestartGroup, 6);
                    TextStyle bodyLarge111117 = typography111117.getBodyLarge();
                    TextStyle bodySmall111117 = typography111117.getBodySmall();
                    int i2111117 = i4;
                    long jM4726getColor0d7_KjU111111111114 = bodyLarge111117.m4726getColor0d7_KjU();
                    Color.Companion companion111117 = Color.Companion;
                    if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU111111111114, companion111117.m3068getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope111117 = TextFieldTransitionScope.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-646388253);
                    jM4726getColor0d7_KjU = materialTheme111117.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                    if (z7) {
                        jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                    }
                    long j111111111113 = jM4726getColor0d7_KjU;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-646388060);
                    long jM4726getColor0d7_KjU111111111115 = materialTheme111117.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                    if (!z7) {
                    }
                    long j111111111114 = jM4726getColor0d7_KjU111111111115;
                    composerStartRestartGroup.endReplaceableGroup();
                    if (interfaceC0526Fp2 != null) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    AnonymousClass3 anonymousClass111119 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2111117, z7, bodyLarge111117, bodySmall111117, interfaceC0526Fp9);
                    composer2 = composerStartRestartGroup;
                    textFieldTransitionScope111117.m1928TransitionDTcfvLk(inputPhase2, j111111111113, j111111111114, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass111119), composer2, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp11;
                    interfaceC0526Fp18 = interfaceC0526Fp12;
                    interfaceC0526Fp19 = interfaceC0526Fp13;
                    interfaceC0526Fp20 = interfaceC0526Fp14;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z9 = z5;
                    z10 = z6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
            }
            i11 = 12582912;
            i19 |= i11;
            if ((1533916891 & i4) != 306783378) {
                if (i12 != 0) {
                    interfaceC0526Fp10 = null;
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp3;
                }
                if (i13 != 0) {
                    interfaceC0526Fp11 = null;
                } else {
                    interfaceC0526Fp11 = interfaceC0526Fp4;
                }
                if (i14 != 0) {
                    interfaceC0526Fp12 = null;
                } else {
                    interfaceC0526Fp12 = interfaceC0526Fp5;
                }
                if (i15 != 0) {
                    interfaceC0526Fp13 = null;
                } else {
                    interfaceC0526Fp13 = interfaceC0526Fp6;
                }
                if (i16 != 0) {
                    interfaceC0526Fp14 = null;
                } else {
                    interfaceC0526Fp14 = interfaceC0526Fp7;
                }
                if (i17 != 0) {
                    interfaceC0526Fp15 = null;
                } else {
                    interfaceC0526Fp15 = interfaceC0526Fp8;
                }
                if (i18 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                }
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                text = ((TransformedText) objRememberedValue).getText().getText();
                if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                    inputPhase = InputPhase.Focused;
                } else if (text.length() == 0) {
                    inputPhase = InputPhase.UnfocusedEmpty;
                } else {
                    inputPhase = InputPhase.UnfocusedNotEmpty;
                }
                inputPhase2 = inputPhase;
                textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                MaterialTheme materialTheme111118 = MaterialTheme.INSTANCE;
                Typography typography111118 = materialTheme111118.getTypography(composerStartRestartGroup, 6);
                TextStyle bodyLarge111118 = typography111118.getBodyLarge();
                TextStyle bodySmall111118 = typography111118.getBodySmall();
                int i2111118 = i4;
                long jM4726getColor0d7_KjU111111111116 = bodyLarge111118.m4726getColor0d7_KjU();
                Color.Companion companion111118 = Color.Companion;
                if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU111111111116, companion111118.m3068getUnspecified0d7_KjU())) {
                }
                TextFieldTransitionScope textFieldTransitionScope111118 = TextFieldTransitionScope.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-646388253);
                jM4726getColor0d7_KjU = materialTheme111118.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                if (z7) {
                    jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                }
                long j111111111115 = jM4726getColor0d7_KjU;
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-646388060);
                long jM4726getColor0d7_KjU111111111117 = materialTheme111118.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                if (!z7) {
                }
                long j111111111116 = jM4726getColor0d7_KjU111111111117;
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC0526Fp2 != null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                AnonymousClass3 anonymousClass1111110 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2111118, z7, bodyLarge111118, bodySmall111118, interfaceC0526Fp9);
                composer2 = composerStartRestartGroup;
                textFieldTransitionScope111118.m1928TransitionDTcfvLk(inputPhase2, j111111111115, j111111111116, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass1111110), composer2, 1769472);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp11;
                interfaceC0526Fp18 = interfaceC0526Fp12;
                interfaceC0526Fp19 = interfaceC0526Fp13;
                interfaceC0526Fp20 = interfaceC0526Fp14;
                interfaceC0526Fp21 = interfaceC0526Fp15;
                z9 = z5;
                z10 = z6;
            } else {
                if (i12 != 0) {
                    interfaceC0526Fp10 = null;
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp3;
                }
                if (i13 != 0) {
                    interfaceC0526Fp11 = null;
                } else {
                    interfaceC0526Fp11 = interfaceC0526Fp4;
                }
                if (i14 != 0) {
                    interfaceC0526Fp12 = null;
                } else {
                    interfaceC0526Fp12 = interfaceC0526Fp5;
                }
                if (i15 != 0) {
                    interfaceC0526Fp13 = null;
                } else {
                    interfaceC0526Fp13 = interfaceC0526Fp6;
                }
                if (i16 != 0) {
                    interfaceC0526Fp14 = null;
                } else {
                    interfaceC0526Fp14 = interfaceC0526Fp7;
                }
                if (i17 != 0) {
                    interfaceC0526Fp15 = null;
                } else {
                    interfaceC0526Fp15 = interfaceC0526Fp8;
                }
                if (i18 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                }
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                text = ((TransformedText) objRememberedValue).getText().getText();
                if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                    inputPhase = InputPhase.Focused;
                } else if (text.length() == 0) {
                    inputPhase = InputPhase.UnfocusedEmpty;
                } else {
                    inputPhase = InputPhase.UnfocusedNotEmpty;
                }
                inputPhase2 = inputPhase;
                textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                MaterialTheme materialTheme111119 = MaterialTheme.INSTANCE;
                Typography typography111119 = materialTheme111119.getTypography(composerStartRestartGroup, 6);
                TextStyle bodyLarge111119 = typography111119.getBodyLarge();
                TextStyle bodySmall111119 = typography111119.getBodySmall();
                int i2111119 = i4;
                long jM4726getColor0d7_KjU111111111118 = bodyLarge111119.m4726getColor0d7_KjU();
                Color.Companion companion111119 = Color.Companion;
                if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU111111111118, companion111119.m3068getUnspecified0d7_KjU())) {
                }
                TextFieldTransitionScope textFieldTransitionScope111119 = TextFieldTransitionScope.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-646388253);
                jM4726getColor0d7_KjU = materialTheme111119.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                if (z7) {
                    jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                }
                long j111111111117 = jM4726getColor0d7_KjU;
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-646388060);
                long jM4726getColor0d7_KjU111111111119 = materialTheme111119.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                if (!z7) {
                }
                long j111111111118 = jM4726getColor0d7_KjU111111111119;
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC0526Fp2 != null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                AnonymousClass3 anonymousClass1111111 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i2111119, z7, bodyLarge111119, bodySmall111119, interfaceC0526Fp9);
                composer2 = composerStartRestartGroup;
                textFieldTransitionScope111119.m1928TransitionDTcfvLk(inputPhase2, j111111111117, j111111111118, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass1111111), composer2, 1769472);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp11;
                interfaceC0526Fp18 = interfaceC0526Fp12;
                interfaceC0526Fp19 = interfaceC0526Fp13;
                interfaceC0526Fp20 = interfaceC0526Fp14;
                interfaceC0526Fp21 = interfaceC0526Fp15;
                z9 = z5;
                z10 = z6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
        }
        i10 = 1572864;
        i19 |= i10;
        if ((i3 & 131072) != 0) {
            if ((29360128 & i2) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
            }
            if ((1533916891 & i4) != 306783378) {
                if (i12 != 0) {
                    interfaceC0526Fp10 = null;
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp3;
                }
                if (i13 != 0) {
                    interfaceC0526Fp11 = null;
                } else {
                    interfaceC0526Fp11 = interfaceC0526Fp4;
                }
                if (i14 != 0) {
                    interfaceC0526Fp12 = null;
                } else {
                    interfaceC0526Fp12 = interfaceC0526Fp5;
                }
                if (i15 != 0) {
                    interfaceC0526Fp13 = null;
                } else {
                    interfaceC0526Fp13 = interfaceC0526Fp6;
                }
                if (i16 != 0) {
                    interfaceC0526Fp14 = null;
                } else {
                    interfaceC0526Fp14 = interfaceC0526Fp7;
                }
                if (i17 != 0) {
                    interfaceC0526Fp15 = null;
                } else {
                    interfaceC0526Fp15 = interfaceC0526Fp8;
                }
                if (i18 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                }
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                text = ((TransformedText) objRememberedValue).getText().getText();
                if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                    inputPhase = InputPhase.Focused;
                } else if (text.length() == 0) {
                    inputPhase = InputPhase.UnfocusedEmpty;
                } else {
                    inputPhase = InputPhase.UnfocusedNotEmpty;
                }
                inputPhase2 = inputPhase;
                textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                MaterialTheme materialTheme1111110 = MaterialTheme.INSTANCE;
                Typography typography1111110 = materialTheme1111110.getTypography(composerStartRestartGroup, 6);
                TextStyle bodyLarge1111110 = typography1111110.getBodyLarge();
                TextStyle bodySmall1111110 = typography1111110.getBodySmall();
                int i21111110 = i4;
                long jM4726getColor0d7_KjU1111111111110 = bodyLarge1111110.m4726getColor0d7_KjU();
                Color.Companion companion1111110 = Color.Companion;
                if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1111111111110, companion1111110.m3068getUnspecified0d7_KjU())) {
                }
                TextFieldTransitionScope textFieldTransitionScope1111110 = TextFieldTransitionScope.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-646388253);
                jM4726getColor0d7_KjU = materialTheme1111110.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                if (z7) {
                    jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                }
                long j111111111119 = jM4726getColor0d7_KjU;
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-646388060);
                long jM4726getColor0d7_KjU1111111111111 = materialTheme1111110.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                if (!z7) {
                }
                long j1111111111110 = jM4726getColor0d7_KjU1111111111111;
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC0526Fp2 != null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                AnonymousClass3 anonymousClass1111112 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i21111110, z7, bodyLarge1111110, bodySmall1111110, interfaceC0526Fp9);
                composer2 = composerStartRestartGroup;
                textFieldTransitionScope1111110.m1928TransitionDTcfvLk(inputPhase2, j111111111119, j1111111111110, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass1111112), composer2, 1769472);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp11;
                interfaceC0526Fp18 = interfaceC0526Fp12;
                interfaceC0526Fp19 = interfaceC0526Fp13;
                interfaceC0526Fp20 = interfaceC0526Fp14;
                interfaceC0526Fp21 = interfaceC0526Fp15;
                z9 = z5;
                z10 = z6;
            } else {
                if (i12 != 0) {
                    interfaceC0526Fp10 = null;
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp3;
                }
                if (i13 != 0) {
                    interfaceC0526Fp11 = null;
                } else {
                    interfaceC0526Fp11 = interfaceC0526Fp4;
                }
                if (i14 != 0) {
                    interfaceC0526Fp12 = null;
                } else {
                    interfaceC0526Fp12 = interfaceC0526Fp5;
                }
                if (i15 != 0) {
                    interfaceC0526Fp13 = null;
                } else {
                    interfaceC0526Fp13 = interfaceC0526Fp6;
                }
                if (i16 != 0) {
                    interfaceC0526Fp14 = null;
                } else {
                    interfaceC0526Fp14 = interfaceC0526Fp7;
                }
                if (i17 != 0) {
                    interfaceC0526Fp15 = null;
                } else {
                    interfaceC0526Fp15 = interfaceC0526Fp8;
                }
                if (i18 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
                }
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                text = ((TransformedText) objRememberedValue).getText().getText();
                if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                    inputPhase = InputPhase.Focused;
                } else if (text.length() == 0) {
                    inputPhase = InputPhase.UnfocusedEmpty;
                } else {
                    inputPhase = InputPhase.UnfocusedNotEmpty;
                }
                inputPhase2 = inputPhase;
                textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
                MaterialTheme materialTheme1111111 = MaterialTheme.INSTANCE;
                Typography typography1111111 = materialTheme1111111.getTypography(composerStartRestartGroup, 6);
                TextStyle bodyLarge1111111 = typography1111111.getBodyLarge();
                TextStyle bodySmall1111111 = typography1111111.getBodySmall();
                int i21111111 = i4;
                long jM4726getColor0d7_KjU1111111111112 = bodyLarge1111111.m4726getColor0d7_KjU();
                Color.Companion companion1111111 = Color.Companion;
                if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1111111111112, companion1111111.m3068getUnspecified0d7_KjU())) {
                }
                TextFieldTransitionScope textFieldTransitionScope1111111 = TextFieldTransitionScope.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-646388253);
                jM4726getColor0d7_KjU = materialTheme1111111.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
                if (z7) {
                    jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
                }
                long j1111111111111 = jM4726getColor0d7_KjU;
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-646388060);
                long jM4726getColor0d7_KjU1111111111113 = materialTheme1111111.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
                if (!z7) {
                }
                long j1111111111112 = jM4726getColor0d7_KjU1111111111113;
                composerStartRestartGroup.endReplaceableGroup();
                if (interfaceC0526Fp2 != null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                AnonymousClass3 anonymousClass1111113 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i21111111, z7, bodyLarge1111111, bodySmall1111111, interfaceC0526Fp9);
                composer2 = composerStartRestartGroup;
                textFieldTransitionScope1111111.m1928TransitionDTcfvLk(inputPhase2, j1111111111111, j1111111111112, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass1111113), composer2, 1769472);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp11;
                interfaceC0526Fp18 = interfaceC0526Fp12;
                interfaceC0526Fp19 = interfaceC0526Fp13;
                interfaceC0526Fp20 = interfaceC0526Fp14;
                interfaceC0526Fp21 = interfaceC0526Fp15;
                z9 = z5;
                z10 = z6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
        }
        i11 = 12582912;
        i19 |= i11;
        if ((1533916891 & i4) != 306783378) {
            if (i12 != 0) {
                interfaceC0526Fp10 = null;
            } else {
                interfaceC0526Fp10 = interfaceC0526Fp3;
            }
            if (i13 != 0) {
                interfaceC0526Fp11 = null;
            } else {
                interfaceC0526Fp11 = interfaceC0526Fp4;
            }
            if (i14 != 0) {
                interfaceC0526Fp12 = null;
            } else {
                interfaceC0526Fp12 = interfaceC0526Fp5;
            }
            if (i15 != 0) {
                interfaceC0526Fp13 = null;
            } else {
                interfaceC0526Fp13 = interfaceC0526Fp6;
            }
            if (i16 != 0) {
                interfaceC0526Fp14 = null;
            } else {
                interfaceC0526Fp14 = interfaceC0526Fp7;
            }
            if (i17 != 0) {
                interfaceC0526Fp15 = null;
            } else {
                interfaceC0526Fp15 = interfaceC0526Fp8;
            }
            if (i18 != 0) {
                z4 = false;
            } else {
                z4 = z;
            }
            if (i6 != 0) {
                z5 = true;
            } else {
                z5 = z2;
            }
            if (i8 != 0) {
                z6 = false;
            } else {
                z6 = z3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
            }
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            text = ((TransformedText) objRememberedValue).getText().getText();
            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                inputPhase = InputPhase.Focused;
            } else if (text.length() == 0) {
                inputPhase = InputPhase.UnfocusedEmpty;
            } else {
                inputPhase = InputPhase.UnfocusedNotEmpty;
            }
            inputPhase2 = inputPhase;
            textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
            MaterialTheme materialTheme1111112 = MaterialTheme.INSTANCE;
            Typography typography1111112 = materialTheme1111112.getTypography(composerStartRestartGroup, 6);
            TextStyle bodyLarge1111112 = typography1111112.getBodyLarge();
            TextStyle bodySmall1111112 = typography1111112.getBodySmall();
            int i21111112 = i4;
            long jM4726getColor0d7_KjU1111111111114 = bodyLarge1111112.m4726getColor0d7_KjU();
            Color.Companion companion1111112 = Color.Companion;
            if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1111111111114, companion1111112.m3068getUnspecified0d7_KjU())) {
            }
            TextFieldTransitionScope textFieldTransitionScope1111112 = TextFieldTransitionScope.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-646388253);
            jM4726getColor0d7_KjU = materialTheme1111112.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
            if (z7) {
                jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
            }
            long j1111111111113 = jM4726getColor0d7_KjU;
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-646388060);
            long jM4726getColor0d7_KjU1111111111115 = materialTheme1111112.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
            if (!z7) {
            }
            long j1111111111114 = jM4726getColor0d7_KjU1111111111115;
            composerStartRestartGroup.endReplaceableGroup();
            if (interfaceC0526Fp2 != null) {
                z8 = true;
            } else {
                z8 = false;
            }
            AnonymousClass3 anonymousClass1111114 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i21111112, z7, bodyLarge1111112, bodySmall1111112, interfaceC0526Fp9);
            composer2 = composerStartRestartGroup;
            textFieldTransitionScope1111112.m1928TransitionDTcfvLk(inputPhase2, j1111111111113, j1111111111114, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass1111114), composer2, 1769472);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp16 = interfaceC0526Fp10;
            interfaceC0526Fp17 = interfaceC0526Fp11;
            interfaceC0526Fp18 = interfaceC0526Fp12;
            interfaceC0526Fp19 = interfaceC0526Fp13;
            interfaceC0526Fp20 = interfaceC0526Fp14;
            interfaceC0526Fp21 = interfaceC0526Fp15;
            z9 = z5;
            z10 = z6;
        } else {
            if (i12 != 0) {
                interfaceC0526Fp10 = null;
            } else {
                interfaceC0526Fp10 = interfaceC0526Fp3;
            }
            if (i13 != 0) {
                interfaceC0526Fp11 = null;
            } else {
                interfaceC0526Fp11 = interfaceC0526Fp4;
            }
            if (i14 != 0) {
                interfaceC0526Fp12 = null;
            } else {
                interfaceC0526Fp12 = interfaceC0526Fp5;
            }
            if (i15 != 0) {
                interfaceC0526Fp13 = null;
            } else {
                interfaceC0526Fp13 = interfaceC0526Fp6;
            }
            if (i16 != 0) {
                interfaceC0526Fp14 = null;
            } else {
                interfaceC0526Fp14 = interfaceC0526Fp7;
            }
            if (i17 != 0) {
                interfaceC0526Fp15 = null;
            } else {
                interfaceC0526Fp15 = interfaceC0526Fp8;
            }
            if (i18 != 0) {
                z4 = false;
            } else {
                z4 = z;
            }
            if (i6 != 0) {
                z5 = true;
            } else {
                z5 = z2;
            }
            if (i8 != 0) {
                z6 = false;
            } else {
                z6 = z3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-947035500, i4, i19, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:61)");
            }
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(visualTransformation);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            text = ((TransformedText) objRememberedValue).getText().getText();
            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i19 >> 12) & 14).getValue().booleanValue()) {
                inputPhase = InputPhase.Focused;
            } else if (text.length() == 0) {
                inputPhase = InputPhase.UnfocusedEmpty;
            } else {
                inputPhase = InputPhase.UnfocusedNotEmpty;
            }
            inputPhase2 = inputPhase;
            textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(textFieldColors, z5, z6, interactionSource, i19);
            MaterialTheme materialTheme1111113 = MaterialTheme.INSTANCE;
            Typography typography1111113 = materialTheme1111113.getTypography(composerStartRestartGroup, 6);
            TextStyle bodyLarge1111113 = typography1111113.getBodyLarge();
            TextStyle bodySmall1111113 = typography1111113.getBodySmall();
            int i21111113 = i4;
            long jM4726getColor0d7_KjU1111111111116 = bodyLarge1111113.m4726getColor0d7_KjU();
            Color.Companion companion1111113 = Color.Companion;
            if (Color.m3033equalsimpl0(jM4726getColor0d7_KjU1111111111116, companion1111113.m3068getUnspecified0d7_KjU())) {
            }
            TextFieldTransitionScope textFieldTransitionScope1111113 = TextFieldTransitionScope.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-646388253);
            jM4726getColor0d7_KjU = materialTheme1111113.getTypography(composerStartRestartGroup, 6).getBodySmall().m4726getColor0d7_KjU();
            if (z7) {
                jM4726getColor0d7_KjU = ((Color) textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0)).m3042unboximpl();
            }
            long j1111111111115 = jM4726getColor0d7_KjU;
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-646388060);
            long jM4726getColor0d7_KjU1111111111117 = materialTheme1111113.getTypography(composerStartRestartGroup, 6).getBodyLarge().m4726getColor0d7_KjU();
            if (!z7) {
            }
            long j1111111111116 = jM4726getColor0d7_KjU1111111111117;
            composerStartRestartGroup.endReplaceableGroup();
            if (interfaceC0526Fp2 != null) {
                z8 = true;
            } else {
                z8 = false;
            }
            AnonymousClass3 anonymousClass1111115 = new AnonymousClass3(interfaceC0526Fp2, interfaceC0526Fp10, text, textFieldColors, z5, z6, interactionSource, i19, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp15, textFieldType, interfaceC0526Fp, z4, paddingValues, i21111113, z7, bodyLarge1111113, bodySmall1111113, interfaceC0526Fp9);
            composer2 = composerStartRestartGroup;
            textFieldTransitionScope1111113.m1928TransitionDTcfvLk(inputPhase2, j1111111111115, j1111111111116, textFieldImplKt$CommonDecorationBox$labelColor$1, z8, ComposableLambdaKt.composableLambda(composer2, 1290853831, true, anonymousClass1111115), composer2, 1769472);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp16 = interfaceC0526Fp10;
            interfaceC0526Fp17 = interfaceC0526Fp11;
            interfaceC0526Fp18 = interfaceC0526Fp12;
            interfaceC0526Fp19 = interfaceC0526Fp13;
            interfaceC0526Fp20 = interfaceC0526Fp14;
            interfaceC0526Fp21 = interfaceC0526Fp15;
            z9 = z5;
            z10 = z6;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(textFieldType, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp2, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp21, z4, z9, z10, interactionSource, paddingValues, textFieldColors, interfaceC0526Fp9, i, i2, i3));
    }

    @Composable
    /* JADX INFO: renamed from: Decoration-KTwxG1Y, reason: not valid java name */
    public static final void m1920DecorationKTwxG1Y(long j, TextStyle textStyle, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-1520066345);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 256 : 128;
        }
        if ((i3 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                textStyle = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520066345, i3, -1, "androidx.compose.material3.Decoration (TextFieldImpl.kt:274)");
            }
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1449369305, true, new TextFieldImplKt$Decoration$contentWithColor$1(j, interfaceC0526Fp, i3));
            if (textStyle != null) {
                composerStartRestartGroup.startReplaceableGroup(1830468032);
                TextKt.ProvideTextStyle(textStyle, composableLambda, composerStartRestartGroup, ((i3 >> 3) & 14) | 48);
            } else {
                composerStartRestartGroup.startReplaceableGroup(1830468084);
                composableLambda.mo13invoke(composerStartRestartGroup, 6);
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        TextStyle textStyle2 = textStyle;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TextFieldImplKt$Decoration$1(j, textStyle2, interfaceC0526Fp, i, i2));
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

    public static final float getMinFocusedLabelLineHeight() {
        return MinFocusedLabelLineHeight;
    }

    public static final float getMinSupportingTextLineHeight() {
        return MinSupportingTextLineHeight;
    }

    public static final float getMinTextLineHeight() {
        return MinTextLineHeight;
    }

    public static final float getPrefixSuffixTextPadding() {
        return PrefixSuffixTextPadding;
    }

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
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
