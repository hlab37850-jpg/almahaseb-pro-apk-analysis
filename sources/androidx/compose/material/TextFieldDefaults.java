package androidx.compose.material;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TextFieldDefaults {
    public static final int $stable = 0;
    public static final float BackgroundOpacity = 0.12f;
    public static final float IconOpacity = 0.54f;
    public static final float UnfocusedIndicatorLineOpacity = 0.42f;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = Dp.m5160constructorimpl(56);
    private static final float MinWidth = Dp.m5160constructorimpl(TIFFConstants.TIFFTAG_MINSAMPLEVALUE);
    private static final float UnfocusedBorderThickness = Dp.m5160constructorimpl(1);
    private static final float FocusedBorderThickness = Dp.m5160constructorimpl(2);

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, int i, int i2) {
            super(2);
            this.$enabled = z;
            this.$isError = z2;
            this.$interactionSource = interactionSource;
            this.$colors = textFieldColors;
            this.$$dirty = i;
            this.$$dirty1 = i2;
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
                ComposerKt.traceEventStart(1261916269, i, -1, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:648)");
            }
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            boolean z = this.$enabled;
            boolean z2 = this.$isError;
            InteractionSource interactionSource = this.$interactionSource;
            TextFieldColors textFieldColors = this.$colors;
            int i2 = this.$$dirty;
            textFieldDefaults.m1265BorderBoxnbWgWpA(z, z2, interactionSource, textFieldColors, null, 0.0f, 0.0f, composer, ((i2 >> 9) & 896) | ((i2 >> 6) & 14) | 12582912 | ((i2 >> 15) & 112) | ((this.$$dirty1 << 6) & 7168), 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
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
        final /* synthetic */ String $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, InterfaceC0526Fp interfaceC0526Fp, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, TextFieldColors textFieldColors, PaddingValues paddingValues, InterfaceC0526Fp interfaceC0526Fp6, int i, int i2, int i3) {
            super(2);
            this.$value = str;
            this.$innerTextField = interfaceC0526Fp;
            this.$enabled = z;
            this.$singleLine = z2;
            this.$visualTransformation = visualTransformation;
            this.$interactionSource = interactionSource;
            this.$isError = z3;
            this.$label = interfaceC0526Fp2;
            this.$placeholder = interfaceC0526Fp3;
            this.$leadingIcon = interfaceC0526Fp4;
            this.$trailingIcon = interfaceC0526Fp5;
            this.$colors = textFieldColors;
            this.$contentPadding = paddingValues;
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
            TextFieldDefaults.this.OutlinedTextFieldDecorationBox(this.$value, this.$innerTextField, this.$enabled, this.$singleLine, this.$visualTransformation, this.$interactionSource, this.$isError, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$colors, this.$contentPadding, this.$border, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldDefaults$TextFieldDecorationBox$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14571 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
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
        final /* synthetic */ String $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14571(String str, InterfaceC0526Fp interfaceC0526Fp, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, TextFieldColors textFieldColors, PaddingValues paddingValues, int i, int i2, int i3) {
            super(2);
            this.$value = str;
            this.$innerTextField = interfaceC0526Fp;
            this.$enabled = z;
            this.$singleLine = z2;
            this.$visualTransformation = visualTransformation;
            this.$interactionSource = interactionSource;
            this.$isError = z3;
            this.$label = interfaceC0526Fp2;
            this.$placeholder = interfaceC0526Fp3;
            this.$leadingIcon = interfaceC0526Fp4;
            this.$trailingIcon = interfaceC0526Fp5;
            this.$colors = textFieldColors;
            this.$contentPadding = paddingValues;
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
            TextFieldDefaults.this.TextFieldDecorationBox(this.$value, this.$innerTextField, this.$enabled, this.$singleLine, this.$visualTransformation, this.$interactionSource, this.$isError, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$colors, this.$contentPadding, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
        }
    }

    private TextFieldDefaults() {
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1262outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1272outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1263textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getFirstBaselineOffset();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldBottomPadding();
        }
        return textFieldDefaults.m1274textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1264textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1275textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0134 A[PHI: r1 r3 r5
      0x0134: PHI (r1v31 int) = (r1v21 int), (r1v33 int), (r1v34 int) binds: [B:114:0x0153, B:104:0x0131, B:105:0x0133] A[DONT_GENERATE, DONT_INLINE]
      0x0134: PHI (r3v10 androidx.compose.ui.graphics.Shape) = 
      (r3v3 androidx.compose.ui.graphics.Shape)
      (r3v2 androidx.compose.ui.graphics.Shape)
      (r3v2 androidx.compose.ui.graphics.Shape)
     binds: [B:114:0x0153, B:104:0x0131, B:105:0x0133] A[DONT_GENERATE, DONT_INLINE]
      0x0134: PHI (r5v6 float) = (r5v3 float), (r5v2 float), (r5v2 float) binds: [B:114:0x0153, B:104:0x0131, B:105:0x0133] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:107:0x013a  */
    /* JADX WARN: Code duplicated, block: B:109:0x013e  */
    /* JADX WARN: Code duplicated, block: B:112:0x014c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0155  */
    /* JADX WARN: Code duplicated, block: B:118:0x0166  */
    /* JADX WARN: Code duplicated, block: B:121:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:126:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x0109  */
    /* JADX WARN: Code duplicated, block: B:94:0x0119  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterialApi
    /* JADX INFO: renamed from: BorderBox-nbWgWpA, reason: not valid java name */
    public final void m1265BorderBoxnbWgWpA(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f, float f2, Composer composer, int i, int i2) {
        int i3;
        Shape outlinedTextFieldShape;
        float f3;
        float f4;
        int i4;
        Shape shape2;
        float f5;
        float f6;
        Shape shape3;
        float f7;
        float f8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(interactionSource, "interactionSource");
        AbstractC4492zt.h(textFieldColors, "colors");
        Composer composerStartRestartGroup = composer.startRestartGroup(943754022);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(interactionSource) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= composerStartRestartGroup.changed(textFieldColors) ? 2048 : 1024;
        }
        if ((i & 57344) == 0) {
            if ((i2 & 16) == 0) {
                outlinedTextFieldShape = shape;
                int i5 = composerStartRestartGroup.changed(outlinedTextFieldShape) ? 16384 : 8192;
                i3 |= i5;
            } else {
                outlinedTextFieldShape = shape;
            }
            i3 |= i5;
        } else {
            outlinedTextFieldShape = shape;
        }
        if ((i & 458752) == 0) {
            if ((i2 & 32) == 0) {
                f3 = f;
                int i6 = composerStartRestartGroup.changed(f3) ? 131072 : 65536;
                i3 |= i6;
            } else {
                f3 = f;
            }
            i3 |= i6;
        } else {
            f3 = f;
        }
        if ((3670016 & i) == 0) {
            if ((i2 & 64) == 0) {
                f4 = f2;
                int i7 = composerStartRestartGroup.changed(f4) ? 1048576 : 524288;
                i3 |= i7;
            } else {
                f4 = f2;
            }
            i3 |= i7;
        } else {
            f4 = f2;
        }
        if ((i2 & 128) == 0) {
            if ((29360128 & i) == 0) {
                i4 = composerStartRestartGroup.changed(this) ? 8388608 : 4194304;
            }
            if ((23967451 & i3) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if ((i2 & 16) != 0) {
                        outlinedTextFieldShape = getOutlinedTextFieldShape(composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        f3 = FocusedBorderThickness;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        shape2 = outlinedTextFieldShape;
                        f5 = UnfocusedBorderThickness;
                        f6 = f3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(943754022, i3, -1, "androidx.compose.material.TextFieldDefaults.BorderBox (TextFieldDefaults.kt:309)");
                    }
                    int i8 = i3 & 8190;
                    int i9 = i3 >> 3;
                    Shape shape4 = shape2;
                    BoxKt.Box(BorderKt.border(Modifier.Companion, (BorderStroke) TextFieldDefaultsKt.m1277animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, textFieldColors, f6, f5, composerStartRestartGroup, i8 | (57344 & i9) | (i9 & 458752)).getValue(), shape4), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape4;
                    f7 = f6;
                    f8 = f5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                    }
                }
                shape2 = outlinedTextFieldShape;
                f6 = f3;
                f5 = f4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(943754022, i3, -1, "androidx.compose.material.TextFieldDefaults.BorderBox (TextFieldDefaults.kt:309)");
                }
                int i10 = i3 & 8190;
                int i11 = i3 >> 3;
                Shape shape5 = shape2;
                BoxKt.Box(BorderKt.border(Modifier.Companion, (BorderStroke) TextFieldDefaultsKt.m1277animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, textFieldColors, f6, f5, composerStartRestartGroup, i10 | (57344 & i11) | (i11 & 458752)).getValue(), shape5), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape5;
                f7 = f6;
                f8 = f5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f7 = f3;
                f8 = f4;
                shape3 = outlinedTextFieldShape;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TextFieldDefaults$BorderBox$1(this, z, z2, interactionSource, textFieldColors, shape3, f7, f8, i, i2));
        }
        i4 = 12582912;
        i3 |= i4;
        if ((23967451 & i3) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if ((i2 & 16) != 0) {
                    outlinedTextFieldShape = getOutlinedTextFieldShape(composerStartRestartGroup, (i3 >> 21) & 14);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    f3 = FocusedBorderThickness;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    shape2 = outlinedTextFieldShape;
                    f5 = UnfocusedBorderThickness;
                    f6 = f3;
                } else {
                    shape2 = outlinedTextFieldShape;
                    f6 = f3;
                    f5 = f4;
                }
            } else {
                if ((i2 & 16) != 0) {
                    outlinedTextFieldShape = getOutlinedTextFieldShape(composerStartRestartGroup, (i3 >> 21) & 14);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    f3 = FocusedBorderThickness;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    shape2 = outlinedTextFieldShape;
                    f5 = UnfocusedBorderThickness;
                    f6 = f3;
                } else {
                    shape2 = outlinedTextFieldShape;
                    f6 = f3;
                    f5 = f4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(943754022, i3, -1, "androidx.compose.material.TextFieldDefaults.BorderBox (TextFieldDefaults.kt:309)");
            }
            int i12 = i3 & 8190;
            int i13 = i3 >> 3;
            Shape shape6 = shape2;
            BoxKt.Box(BorderKt.border(Modifier.Companion, (BorderStroke) TextFieldDefaultsKt.m1277animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, textFieldColors, f6, f5, composerStartRestartGroup, i12 | (57344 & i13) | (i13 & 458752)).getValue(), shape6), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape3 = shape6;
            f7 = f6;
            f8 = f5;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if ((i2 & 16) != 0) {
                    outlinedTextFieldShape = getOutlinedTextFieldShape(composerStartRestartGroup, (i3 >> 21) & 14);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    f3 = FocusedBorderThickness;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    shape2 = outlinedTextFieldShape;
                    f5 = UnfocusedBorderThickness;
                    f6 = f3;
                } else {
                    shape2 = outlinedTextFieldShape;
                    f6 = f3;
                    f5 = f4;
                }
            } else {
                if ((i2 & 16) != 0) {
                    outlinedTextFieldShape = getOutlinedTextFieldShape(composerStartRestartGroup, (i3 >> 21) & 14);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    f3 = FocusedBorderThickness;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    shape2 = outlinedTextFieldShape;
                    f5 = UnfocusedBorderThickness;
                    f6 = f3;
                } else {
                    shape2 = outlinedTextFieldShape;
                    f6 = f3;
                    f5 = f4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(943754022, i3, -1, "androidx.compose.material.TextFieldDefaults.BorderBox (TextFieldDefaults.kt:309)");
            }
            int i14 = i3 & 8190;
            int i15 = i3 >> 3;
            Shape shape7 = shape2;
            BoxKt.Box(BorderKt.border(Modifier.Companion, (BorderStroke) TextFieldDefaultsKt.m1277animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, textFieldColors, f6, f5, composerStartRestartGroup, i14 | (57344 & i15) | (i15 & 458752)).getValue(), shape7), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape3 = shape7;
            f7 = f6;
            f8 = f5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TextFieldDefaults$BorderBox$1(this, z, z2, interactionSource, textFieldColors, shape3, f7, f8, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0144  */
    /* JADX WARN: Code duplicated, block: B:102:0x014a  */
    /* JADX WARN: Code duplicated, block: B:103:0x014d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0155  */
    /* JADX WARN: Code duplicated, block: B:108:0x015a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0160  */
    /* JADX WARN: Code duplicated, block: B:112:0x0166  */
    /* JADX WARN: Code duplicated, block: B:113:0x0169  */
    /* JADX WARN: Code duplicated, block: B:115:0x016e  */
    /* JADX WARN: Code duplicated, block: B:118:0x0174  */
    /* JADX WARN: Code duplicated, block: B:120:0x0178  */
    /* JADX WARN: Code duplicated, block: B:123:0x0183 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:126:0x018a  */
    /* JADX WARN: Code duplicated, block: B:129:0x0190  */
    /* JADX WARN: Code duplicated, block: B:131:0x0194  */
    /* JADX WARN: Code duplicated, block: B:134:0x019d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:138:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:143:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:145:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:147:0x01be  */
    /* JADX WARN: Code duplicated, block: B:151:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:153:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:155:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:157:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:161:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:167:0x020b  */
    /* JADX WARN: Code duplicated, block: B:169:0x0212  */
    /* JADX WARN: Code duplicated, block: B:179:0x023a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:180:0x023c  */
    /* JADX WARN: Code duplicated, block: B:181:0x023e  */
    /* JADX WARN: Code duplicated, block: B:184:0x0243  */
    /* JADX WARN: Code duplicated, block: B:185:0x0245  */
    /* JADX WARN: Code duplicated, block: B:187:0x0249  */
    /* JADX WARN: Code duplicated, block: B:188:0x024b  */
    /* JADX WARN: Code duplicated, block: B:190:0x024f  */
    /* JADX WARN: Code duplicated, block: B:191:0x0251  */
    /* JADX WARN: Code duplicated, block: B:194:0x0256  */
    /* JADX WARN: Code duplicated, block: B:197:0x025c  */
    /* JADX WARN: Code duplicated, block: B:198:0x029c  */
    /* JADX WARN: Code duplicated, block: B:201:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:202:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:204:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:206:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:209:0x030f  */
    /* JADX WARN: Code duplicated, block: B:212:0x0389  */
    /* JADX WARN: Code duplicated, block: B:217:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:219:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x007f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0084  */
    /* JADX WARN: Code duplicated, block: B:40:0x0088  */
    /* JADX WARN: Code duplicated, block: B:42:0x0090  */
    /* JADX WARN: Code duplicated, block: B:43:0x0093  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:52:0x00af  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:80:0x0104  */
    /* JADX WARN: Code duplicated, block: B:82:0x010a  */
    /* JADX WARN: Code duplicated, block: B:83:0x010d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0115  */
    /* JADX WARN: Code duplicated, block: B:88:0x011c  */
    /* JADX WARN: Code duplicated, block: B:90:0x0124  */
    /* JADX WARN: Code duplicated, block: B:92:0x012a  */
    /* JADX WARN: Code duplicated, block: B:93:0x012d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0135  */
    /* JADX WARN: Code duplicated, block: B:98:0x013c  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public final void OutlinedTextFieldDecorationBox(String str, InterfaceC0526Fp interfaceC0526Fp, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, TextFieldColors textFieldColors, PaddingValues paddingValues, InterfaceC0526Fp interfaceC0526Fp6, Composer composer, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z4;
        InterfaceC0526Fp interfaceC0526Fp7;
        InterfaceC0526Fp interfaceC0526Fp8;
        InterfaceC0526Fp interfaceC0526Fp9;
        TextFieldColors textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
        InterfaceC0526Fp interfaceC0526Fp10;
        PaddingValues paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
        PaddingValues paddingValues2;
        TextFieldColors textFieldColors2;
        InterfaceC0526Fp interfaceC0526FpComposableLambda;
        InterfaceC0526Fp interfaceC0526Fp11;
        boolean z5;
        InterfaceC0526Fp interfaceC0526Fp12;
        InterfaceC0526Fp interfaceC0526Fp13;
        Composer composer2;
        boolean z6;
        InterfaceC0526Fp interfaceC0526Fp14;
        InterfaceC0526Fp interfaceC0526Fp15;
        InterfaceC0526Fp interfaceC0526Fp16;
        InterfaceC0526Fp interfaceC0526Fp17;
        TextFieldColors textFieldColors3;
        PaddingValues paddingValues3;
        InterfaceC0526Fp interfaceC0526Fp18;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(str, "value");
        AbstractC4492zt.h(interfaceC0526Fp, "innerTextField");
        AbstractC4492zt.h(visualTransformation, "visualTransformation");
        AbstractC4492zt.h(interactionSource, "interactionSource");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1280721485);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        if ((i3 & 4) == 0) {
            if ((i & 896) == 0) {
                i4 |= composerStartRestartGroup.changed(z) ? 256 : 128;
            }
            if ((i3 & 8) != 0) {
                if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i4 |= i5;
                }
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(visualTransformation)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i4 |= i6;
                }
                if ((i3 & 32) != 0) {
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(interactionSource)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                    }
                    i8 = i3 & 64;
                    if (i8 != 0) {
                        i4 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i4 |= i9;
                    }
                    i10 = i3 & 128;
                    if (i10 != 0) {
                        i4 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i4 |= i11;
                    }
                    i12 = i3 & 256;
                    if (i12 != 0) {
                        i4 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i4 |= i13;
                    }
                    i14 = i3 & 512;
                    if (i14 != 0) {
                        i4 |= 805306368;
                    } else if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                            i15 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i15 = 268435456;
                        }
                        i4 |= i15;
                    }
                    i16 = i3 & 1024;
                    if (i16 != 0) {
                        i17 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                            i18 = 4;
                        } else {
                            i18 = 2;
                        }
                        i17 = i2 | i18;
                    } else {
                        i17 = i2;
                    }
                    if ((i2 & 112) != 0) {
                        i17 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
                    }
                    if ((i2 & 896) != 0) {
                        i17 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
                    }
                    i19 = i17;
                    i20 = i3 & 8192;
                    if (i20 != 0) {
                        if ((i2 & 7168) == 0) {
                            i19 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp6) ? 2048 : 1024;
                        }
                        if ((i3 & 16384) != 0) {
                            if ((i2 & 57344) == 0) {
                                i19 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                            }
                            if ((i4 & 1533916891) != 306783378 && (46811 & i19) == 9362 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                interfaceC0526Fp14 = interfaceC0526Fp2;
                                interfaceC0526Fp15 = interfaceC0526Fp3;
                                interfaceC0526Fp16 = interfaceC0526Fp4;
                                interfaceC0526Fp17 = interfaceC0526Fp5;
                                textFieldColors3 = textFieldColors;
                                paddingValues3 = paddingValues;
                                interfaceC0526Fp18 = interfaceC0526Fp6;
                                composer2 = composerStartRestartGroup;
                                z6 = z3;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i8 != 0) {
                                        z4 = false;
                                    } else {
                                        z4 = z3;
                                    }
                                    if (i10 != 0) {
                                        interfaceC0526Fp7 = null;
                                    } else {
                                        interfaceC0526Fp7 = interfaceC0526Fp2;
                                    }
                                    if (i12 != 0) {
                                        interfaceC0526Fp8 = null;
                                    } else {
                                        interfaceC0526Fp8 = interfaceC0526Fp3;
                                    }
                                    if (i14 != 0) {
                                        interfaceC0526Fp9 = null;
                                    } else {
                                        interfaceC0526Fp9 = interfaceC0526Fp4;
                                    }
                                    InterfaceC0526Fp interfaceC0526Fp19 = i16 == 0 ? interfaceC0526Fp5 : null;
                                    if ((i3 & 2048) != 0) {
                                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                        i19 &= -113;
                                    } else {
                                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                    }
                                    interfaceC0526Fp10 = interfaceC0526Fp9;
                                    if ((i3 & 4096) != 0) {
                                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        i19 &= -897;
                                    } else {
                                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                    }
                                    if (i20 != 0) {
                                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                    } else {
                                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                    }
                                    interfaceC0526Fp11 = interfaceC0526Fp7;
                                    z5 = z4;
                                    interfaceC0526Fp12 = interfaceC0526Fp8;
                                    interfaceC0526Fp13 = interfaceC0526Fp19;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i3 & 2048) != 0) {
                                        i19 &= -113;
                                    }
                                    if ((i3 & 4096) != 0) {
                                        i19 &= -897;
                                    }
                                    z5 = z3;
                                    interfaceC0526Fp11 = interfaceC0526Fp2;
                                    interfaceC0526Fp12 = interfaceC0526Fp3;
                                    interfaceC0526Fp10 = interfaceC0526Fp4;
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                    textFieldColors2 = textFieldColors;
                                    paddingValues2 = paddingValues;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                                }
                                int i21 = i4 << 3;
                                int i22 = i4 >> 9;
                                composer2 = composerStartRestartGroup;
                                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21 & 896) | (i21 & 112) | 6 | ((i4 >> 3) & 7168) | (i22 & 57344) | (458752 & i22) | (i22 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z6 = z5;
                                interfaceC0526Fp14 = interfaceC0526Fp11;
                                interfaceC0526Fp15 = interfaceC0526Fp12;
                                interfaceC0526Fp16 = interfaceC0526Fp10;
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                textFieldColors3 = textFieldColors2;
                                paddingValues3 = paddingValues2;
                                interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
                        }
                        i19 |= 24576;
                        if ((i4 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            } else {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                            }
                            int i23 = i4 << 3;
                            int i24 = i4 >> 9;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i23 & 896) | (i23 & 112) | 6 | ((i4 >> 3) & 7168) | (i24 & 57344) | (458752 & i24) | (i24 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp14 = interfaceC0526Fp11;
                            interfaceC0526Fp15 = interfaceC0526Fp12;
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            } else {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                            }
                            int i25 = i4 << 3;
                            int i26 = i4 >> 9;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i25 & 896) | (i25 & 112) | 6 | ((i4 >> 3) & 7168) | (i26 & 57344) | (458752 & i26) | (i26 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp14 = interfaceC0526Fp11;
                            interfaceC0526Fp15 = interfaceC0526Fp12;
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
                    }
                    i19 |= 3072;
                    if ((i3 & 16384) != 0) {
                        if ((i2 & 57344) == 0) {
                            i19 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                        }
                        if ((i4 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            } else {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                            }
                            int i27 = i4 << 3;
                            int i28 = i4 >> 9;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i27 & 896) | (i27 & 112) | 6 | ((i4 >> 3) & 7168) | (i28 & 57344) | (458752 & i28) | (i28 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp14 = interfaceC0526Fp11;
                            interfaceC0526Fp15 = interfaceC0526Fp12;
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            } else {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                            }
                            int i29 = i4 << 3;
                            int i210 = i4 >> 9;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i29 & 896) | (i29 & 112) | 6 | ((i4 >> 3) & 7168) | (i210 & 57344) | (458752 & i210) | (i210 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp14 = interfaceC0526Fp11;
                            interfaceC0526Fp15 = interfaceC0526Fp12;
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
                    }
                    i19 |= 24576;
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i211 = i4 << 3;
                        int i212 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i211 & 896) | (i211 & 112) | 6 | ((i4 >> 3) & 7168) | (i212 & 57344) | (458752 & i212) | (i212 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i213 = i4 << 3;
                        int i214 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i213 & 896) | (i213 & 112) | 6 | ((i4 >> 3) & 7168) | (i214 & 57344) | (458752 & i214) | (i214 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
                }
                i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i4 |= i7;
                i8 = i3 & 64;
                if (i8 != 0) {
                    i4 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 128;
                if (i10 != 0) {
                    i4 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i4 |= i11;
                }
                i12 = i3 & 256;
                if (i12 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i4 |= i13;
                }
                i14 = i3 & 512;
                if (i14 != 0) {
                    i4 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i15 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i15 = 268435456;
                    }
                    i4 |= i15;
                }
                i16 = i3 & 1024;
                if (i16 != 0) {
                    i17 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i18 = 4;
                    } else {
                        i18 = 2;
                    }
                    i17 = i2 | i18;
                } else {
                    i17 = i2;
                }
                if ((i2 & 112) != 0) {
                    i17 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
                }
                if ((i2 & 896) != 0) {
                    i17 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
                }
                i19 = i17;
                i20 = i3 & 8192;
                if (i20 != 0) {
                    if ((i2 & 7168) == 0) {
                        i19 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp6) ? 2048 : 1024;
                    }
                    if ((i3 & 16384) != 0) {
                        if ((i2 & 57344) == 0) {
                            i19 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                        }
                        if ((i4 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            } else {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                            }
                            int i215 = i4 << 3;
                            int i216 = i4 >> 9;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i215 & 896) | (i215 & 112) | 6 | ((i4 >> 3) & 7168) | (i216 & 57344) | (458752 & i216) | (i216 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp14 = interfaceC0526Fp11;
                            interfaceC0526Fp15 = interfaceC0526Fp12;
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            } else {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                            }
                            int i217 = i4 << 3;
                            int i218 = i4 >> 9;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i217 & 896) | (i217 & 112) | 6 | ((i4 >> 3) & 7168) | (i218 & 57344) | (458752 & i218) | (i218 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp14 = interfaceC0526Fp11;
                            interfaceC0526Fp15 = interfaceC0526Fp12;
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
                    }
                    i19 |= 24576;
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i219 = i4 << 3;
                        int i2110 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i219 & 896) | (i219 & 112) | 6 | ((i4 >> 3) & 7168) | (i2110 & 57344) | (458752 & i2110) | (i2110 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i2111 = i4 << 3;
                        int i2112 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2111 & 896) | (i2111 & 112) | 6 | ((i4 >> 3) & 7168) | (i2112 & 57344) | (458752 & i2112) | (i2112 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
                }
                i19 |= 3072;
                if ((i3 & 16384) != 0) {
                    if ((i2 & 57344) == 0) {
                        i19 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i2113 = i4 << 3;
                        int i2114 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2113 & 896) | (i2113 & 112) | 6 | ((i4 >> 3) & 7168) | (i2114 & 57344) | (458752 & i2114) | (i2114 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i2115 = i4 << 3;
                        int i2116 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2115 & 896) | (i2115 & 112) | 6 | ((i4 >> 3) & 7168) | (i2116 & 57344) | (458752 & i2116) | (i2116 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
                }
                i19 |= 24576;
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i2117 = i4 << 3;
                    int i2118 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2117 & 896) | (i2117 & 112) | 6 | ((i4 >> 3) & 7168) | (i2118 & 57344) | (458752 & i2118) | (i2118 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i2119 = i4 << 3;
                    int i21110 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2119 & 896) | (i2119 & 112) | 6 | ((i4 >> 3) & 7168) | (i21110 & 57344) | (458752 & i21110) | (i21110 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
            }
            i4 |= 3072;
            if ((i3 & 16) != 0) {
                i4 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(visualTransformation)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            if ((i3 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(interactionSource)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                }
                i8 = i3 & 64;
                if (i8 != 0) {
                    i4 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 128;
                if (i10 != 0) {
                    i4 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i4 |= i11;
                }
                i12 = i3 & 256;
                if (i12 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i4 |= i13;
                }
                i14 = i3 & 512;
                if (i14 != 0) {
                    i4 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i15 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i15 = 268435456;
                    }
                    i4 |= i15;
                }
                i16 = i3 & 1024;
                if (i16 != 0) {
                    i17 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i18 = 4;
                    } else {
                        i18 = 2;
                    }
                    i17 = i2 | i18;
                } else {
                    i17 = i2;
                }
                if ((i2 & 112) != 0) {
                    i17 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
                }
                if ((i2 & 896) != 0) {
                    i17 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
                }
                i19 = i17;
                i20 = i3 & 8192;
                if (i20 != 0) {
                    if ((i2 & 7168) == 0) {
                        i19 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp6) ? 2048 : 1024;
                    }
                    if ((i3 & 16384) != 0) {
                        if ((i2 & 57344) == 0) {
                            i19 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                        }
                        if ((i4 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            } else {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                            }
                            int i21111 = i4 << 3;
                            int i21112 = i4 >> 9;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21111 & 896) | (i21111 & 112) | 6 | ((i4 >> 3) & 7168) | (i21112 & 57344) | (458752 & i21112) | (i21112 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp14 = interfaceC0526Fp11;
                            interfaceC0526Fp15 = interfaceC0526Fp12;
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            } else {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                            }
                            int i21113 = i4 << 3;
                            int i21114 = i4 >> 9;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21113 & 896) | (i21113 & 112) | 6 | ((i4 >> 3) & 7168) | (i21114 & 57344) | (458752 & i21114) | (i21114 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp14 = interfaceC0526Fp11;
                            interfaceC0526Fp15 = interfaceC0526Fp12;
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
                    }
                    i19 |= 24576;
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i21115 = i4 << 3;
                        int i21116 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21115 & 896) | (i21115 & 112) | 6 | ((i4 >> 3) & 7168) | (i21116 & 57344) | (458752 & i21116) | (i21116 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i21117 = i4 << 3;
                        int i21118 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21117 & 896) | (i21117 & 112) | 6 | ((i4 >> 3) & 7168) | (i21118 & 57344) | (458752 & i21118) | (i21118 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
                }
                i19 |= 3072;
                if ((i3 & 16384) != 0) {
                    if ((i2 & 57344) == 0) {
                        i19 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i21119 = i4 << 3;
                        int i211110 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21119 & 896) | (i21119 & 112) | 6 | ((i4 >> 3) & 7168) | (i211110 & 57344) | (458752 & i211110) | (i211110 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i211111 = i4 << 3;
                        int i211112 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i211111 & 896) | (i211111 & 112) | 6 | ((i4 >> 3) & 7168) | (i211112 & 57344) | (458752 & i211112) | (i211112 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
                }
                i19 |= 24576;
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i211113 = i4 << 3;
                    int i211114 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i211113 & 896) | (i211113 & 112) | 6 | ((i4 >> 3) & 7168) | (i211114 & 57344) | (458752 & i211114) | (i211114 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i211115 = i4 << 3;
                    int i211116 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i211115 & 896) | (i211115 & 112) | 6 | ((i4 >> 3) & 7168) | (i211116 & 57344) | (458752 & i211116) | (i211116 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
            }
            i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i4 |= i7;
            i8 = i3 & 64;
            if (i8 != 0) {
                i4 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i4 |= i9;
            }
            i10 = i3 & 128;
            if (i10 != 0) {
                i4 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i4 |= i11;
            }
            i12 = i3 & 256;
            if (i12 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i4 |= i13;
            }
            i14 = i3 & 512;
            if (i14 != 0) {
                i4 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i15 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i15 = 268435456;
                }
                i4 |= i15;
            }
            i16 = i3 & 1024;
            if (i16 != 0) {
                i17 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i18 = 4;
                } else {
                    i18 = 2;
                }
                i17 = i2 | i18;
            } else {
                i17 = i2;
            }
            if ((i2 & 112) != 0) {
                i17 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
            }
            if ((i2 & 896) != 0) {
                i17 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
            }
            i19 = i17;
            i20 = i3 & 8192;
            if (i20 != 0) {
                if ((i2 & 7168) == 0) {
                    i19 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp6) ? 2048 : 1024;
                }
                if ((i3 & 16384) != 0) {
                    if ((i2 & 57344) == 0) {
                        i19 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i211117 = i4 << 3;
                        int i211118 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i211117 & 896) | (i211117 & 112) | 6 | ((i4 >> 3) & 7168) | (i211118 & 57344) | (458752 & i211118) | (i211118 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i211119 = i4 << 3;
                        int i2111110 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i211119 & 896) | (i211119 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111110 & 57344) | (458752 & i2111110) | (i2111110 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
                }
                i19 |= 24576;
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i2111111 = i4 << 3;
                    int i2111112 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2111111 & 896) | (i2111111 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111112 & 57344) | (458752 & i2111112) | (i2111112 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i2111113 = i4 << 3;
                    int i2111114 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2111113 & 896) | (i2111113 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111114 & 57344) | (458752 & i2111114) | (i2111114 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
            }
            i19 |= 3072;
            if ((i3 & 16384) != 0) {
                if ((i2 & 57344) == 0) {
                    i19 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i2111115 = i4 << 3;
                    int i2111116 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2111115 & 896) | (i2111115 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111116 & 57344) | (458752 & i2111116) | (i2111116 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i2111117 = i4 << 3;
                    int i2111118 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2111117 & 896) | (i2111117 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111118 & 57344) | (458752 & i2111118) | (i2111118 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
            }
            i19 |= 24576;
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                }
                int i2111119 = i4 << 3;
                int i21111110 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2111119 & 896) | (i2111119 & 112) | 6 | ((i4 >> 3) & 7168) | (i21111110 & 57344) | (458752 & i21111110) | (i21111110 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp12;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp13;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                }
                int i21111111 = i4 << 3;
                int i21111112 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21111111 & 896) | (i21111111 & 112) | 6 | ((i4 >> 3) & 7168) | (i21111112 & 57344) | (458752 & i21111112) | (i21111112 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp12;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp13;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
        }
        i4 |= 384;
        if ((i3 & 8) != 0) {
            if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i4 |= i5;
            }
            if ((i3 & 16) != 0) {
                i4 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(visualTransformation)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            if ((i3 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(interactionSource)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                }
                i8 = i3 & 64;
                if (i8 != 0) {
                    i4 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 128;
                if (i10 != 0) {
                    i4 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i4 |= i11;
                }
                i12 = i3 & 256;
                if (i12 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i4 |= i13;
                }
                i14 = i3 & 512;
                if (i14 != 0) {
                    i4 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i15 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i15 = 268435456;
                    }
                    i4 |= i15;
                }
                i16 = i3 & 1024;
                if (i16 != 0) {
                    i17 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i18 = 4;
                    } else {
                        i18 = 2;
                    }
                    i17 = i2 | i18;
                } else {
                    i17 = i2;
                }
                if ((i2 & 112) != 0) {
                    i17 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
                }
                if ((i2 & 896) != 0) {
                    i17 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
                }
                i19 = i17;
                i20 = i3 & 8192;
                if (i20 != 0) {
                    if ((i2 & 7168) == 0) {
                        i19 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp6) ? 2048 : 1024;
                    }
                    if ((i3 & 16384) != 0) {
                        if ((i2 & 57344) == 0) {
                            i19 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                        }
                        if ((i4 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            } else {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                            }
                            int i21111113 = i4 << 3;
                            int i21111114 = i4 >> 9;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21111113 & 896) | (i21111113 & 112) | 6 | ((i4 >> 3) & 7168) | (i21111114 & 57344) | (458752 & i21111114) | (i21111114 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp14 = interfaceC0526Fp11;
                            interfaceC0526Fp15 = interfaceC0526Fp12;
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            } else {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp9 = null;
                                } else {
                                    interfaceC0526Fp9 = interfaceC0526Fp4;
                                }
                                if (i16 == 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp10 = interfaceC0526Fp9;
                                if ((i3 & 4096) != 0) {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i19 &= -897;
                                } else {
                                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                                }
                                if (i20 != 0) {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                                } else {
                                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                                }
                                interfaceC0526Fp11 = interfaceC0526Fp7;
                                z5 = z4;
                                interfaceC0526Fp12 = interfaceC0526Fp8;
                                interfaceC0526Fp13 = interfaceC0526Fp19;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                            }
                            int i21111115 = i4 << 3;
                            int i21111116 = i4 >> 9;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21111115 & 896) | (i21111115 & 112) | 6 | ((i4 >> 3) & 7168) | (i21111116 & 57344) | (458752 & i21111116) | (i21111116 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp14 = interfaceC0526Fp11;
                            interfaceC0526Fp15 = interfaceC0526Fp12;
                            interfaceC0526Fp16 = interfaceC0526Fp10;
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
                    }
                    i19 |= 24576;
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i21111117 = i4 << 3;
                        int i21111118 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21111117 & 896) | (i21111117 & 112) | 6 | ((i4 >> 3) & 7168) | (i21111118 & 57344) | (458752 & i21111118) | (i21111118 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i21111119 = i4 << 3;
                        int i211111110 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21111119 & 896) | (i21111119 & 112) | 6 | ((i4 >> 3) & 7168) | (i211111110 & 57344) | (458752 & i211111110) | (i211111110 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
                }
                i19 |= 3072;
                if ((i3 & 16384) != 0) {
                    if ((i2 & 57344) == 0) {
                        i19 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i211111111 = i4 << 3;
                        int i211111112 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i211111111 & 896) | (i211111111 & 112) | 6 | ((i4 >> 3) & 7168) | (i211111112 & 57344) | (458752 & i211111112) | (i211111112 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i211111113 = i4 << 3;
                        int i211111114 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i211111113 & 896) | (i211111113 & 112) | 6 | ((i4 >> 3) & 7168) | (i211111114 & 57344) | (458752 & i211111114) | (i211111114 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
                }
                i19 |= 24576;
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i211111115 = i4 << 3;
                    int i211111116 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i211111115 & 896) | (i211111115 & 112) | 6 | ((i4 >> 3) & 7168) | (i211111116 & 57344) | (458752 & i211111116) | (i211111116 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i211111117 = i4 << 3;
                    int i211111118 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i211111117 & 896) | (i211111117 & 112) | 6 | ((i4 >> 3) & 7168) | (i211111118 & 57344) | (458752 & i211111118) | (i211111118 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
            }
            i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i4 |= i7;
            i8 = i3 & 64;
            if (i8 != 0) {
                i4 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i4 |= i9;
            }
            i10 = i3 & 128;
            if (i10 != 0) {
                i4 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i4 |= i11;
            }
            i12 = i3 & 256;
            if (i12 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i4 |= i13;
            }
            i14 = i3 & 512;
            if (i14 != 0) {
                i4 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i15 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i15 = 268435456;
                }
                i4 |= i15;
            }
            i16 = i3 & 1024;
            if (i16 != 0) {
                i17 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i18 = 4;
                } else {
                    i18 = 2;
                }
                i17 = i2 | i18;
            } else {
                i17 = i2;
            }
            if ((i2 & 112) != 0) {
                i17 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
            }
            if ((i2 & 896) != 0) {
                i17 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
            }
            i19 = i17;
            i20 = i3 & 8192;
            if (i20 != 0) {
                if ((i2 & 7168) == 0) {
                    i19 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp6) ? 2048 : 1024;
                }
                if ((i3 & 16384) != 0) {
                    if ((i2 & 57344) == 0) {
                        i19 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i211111119 = i4 << 3;
                        int i2111111110 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i211111119 & 896) | (i211111119 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111111110 & 57344) | (458752 & i2111111110) | (i2111111110 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i2111111111 = i4 << 3;
                        int i2111111112 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2111111111 & 896) | (i2111111111 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111111112 & 57344) | (458752 & i2111111112) | (i2111111112 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
                }
                i19 |= 24576;
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i2111111113 = i4 << 3;
                    int i2111111114 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2111111113 & 896) | (i2111111113 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111111114 & 57344) | (458752 & i2111111114) | (i2111111114 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i2111111115 = i4 << 3;
                    int i2111111116 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2111111115 & 896) | (i2111111115 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111111116 & 57344) | (458752 & i2111111116) | (i2111111116 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
            }
            i19 |= 3072;
            if ((i3 & 16384) != 0) {
                if ((i2 & 57344) == 0) {
                    i19 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i2111111117 = i4 << 3;
                    int i2111111118 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2111111117 & 896) | (i2111111117 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111111118 & 57344) | (458752 & i2111111118) | (i2111111118 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i2111111119 = i4 << 3;
                    int i21111111110 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2111111119 & 896) | (i2111111119 & 112) | 6 | ((i4 >> 3) & 7168) | (i21111111110 & 57344) | (458752 & i21111111110) | (i21111111110 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
            }
            i19 |= 24576;
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                }
                int i21111111111 = i4 << 3;
                int i21111111112 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21111111111 & 896) | (i21111111111 & 112) | 6 | ((i4 >> 3) & 7168) | (i21111111112 & 57344) | (458752 & i21111111112) | (i21111111112 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp12;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp13;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                }
                int i21111111113 = i4 << 3;
                int i21111111114 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21111111113 & 896) | (i21111111113 & 112) | 6 | ((i4 >> 3) & 7168) | (i21111111114 & 57344) | (458752 & i21111111114) | (i21111111114 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp12;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp13;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
        }
        i4 |= 3072;
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i & 57344) == 0) {
            if (composerStartRestartGroup.changed(visualTransformation)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i4 |= i6;
        }
        if ((i3 & 32) != 0) {
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(interactionSource)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
            }
            i8 = i3 & 64;
            if (i8 != 0) {
                i4 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i4 |= i9;
            }
            i10 = i3 & 128;
            if (i10 != 0) {
                i4 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i4 |= i11;
            }
            i12 = i3 & 256;
            if (i12 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i4 |= i13;
            }
            i14 = i3 & 512;
            if (i14 != 0) {
                i4 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i15 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i15 = 268435456;
                }
                i4 |= i15;
            }
            i16 = i3 & 1024;
            if (i16 != 0) {
                i17 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i18 = 4;
                } else {
                    i18 = 2;
                }
                i17 = i2 | i18;
            } else {
                i17 = i2;
            }
            if ((i2 & 112) != 0) {
                i17 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
            }
            if ((i2 & 896) != 0) {
                i17 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
            }
            i19 = i17;
            i20 = i3 & 8192;
            if (i20 != 0) {
                if ((i2 & 7168) == 0) {
                    i19 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp6) ? 2048 : 1024;
                }
                if ((i3 & 16384) != 0) {
                    if ((i2 & 57344) == 0) {
                        i19 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i21111111115 = i4 << 3;
                        int i21111111116 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21111111115 & 896) | (i21111111115 & 112) | 6 | ((i4 >> 3) & 7168) | (i21111111116 & 57344) | (458752 & i21111111116) | (i21111111116 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp9 = null;
                            } else {
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp10 = interfaceC0526Fp9;
                            if ((i3 & 4096) != 0) {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i19 &= -897;
                            } else {
                                paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                            }
                            if (i20 != 0) {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                            } else {
                                paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                                textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                            }
                            interfaceC0526Fp11 = interfaceC0526Fp7;
                            z5 = z4;
                            interfaceC0526Fp12 = interfaceC0526Fp8;
                            interfaceC0526Fp13 = interfaceC0526Fp19;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                        }
                        int i21111111117 = i4 << 3;
                        int i21111111118 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21111111117 & 896) | (i21111111117 & 112) | 6 | ((i4 >> 3) & 7168) | (i21111111118 & 57344) | (458752 & i21111111118) | (i21111111118 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp14 = interfaceC0526Fp11;
                        interfaceC0526Fp15 = interfaceC0526Fp12;
                        interfaceC0526Fp16 = interfaceC0526Fp10;
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
                }
                i19 |= 24576;
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i21111111119 = i4 << 3;
                    int i211111111110 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21111111119 & 896) | (i21111111119 & 112) | 6 | ((i4 >> 3) & 7168) | (i211111111110 & 57344) | (458752 & i211111111110) | (i211111111110 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i211111111111 = i4 << 3;
                    int i211111111112 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i211111111111 & 896) | (i211111111111 & 112) | 6 | ((i4 >> 3) & 7168) | (i211111111112 & 57344) | (458752 & i211111111112) | (i211111111112 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
            }
            i19 |= 3072;
            if ((i3 & 16384) != 0) {
                if ((i2 & 57344) == 0) {
                    i19 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i211111111113 = i4 << 3;
                    int i211111111114 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i211111111113 & 896) | (i211111111113 & 112) | 6 | ((i4 >> 3) & 7168) | (i211111111114 & 57344) | (458752 & i211111111114) | (i211111111114 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i211111111115 = i4 << 3;
                    int i211111111116 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i211111111115 & 896) | (i211111111115 & 112) | 6 | ((i4 >> 3) & 7168) | (i211111111116 & 57344) | (458752 & i211111111116) | (i211111111116 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
            }
            i19 |= 24576;
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                }
                int i211111111117 = i4 << 3;
                int i211111111118 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i211111111117 & 896) | (i211111111117 & 112) | 6 | ((i4 >> 3) & 7168) | (i211111111118 & 57344) | (458752 & i211111111118) | (i211111111118 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp12;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp13;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                }
                int i211111111119 = i4 << 3;
                int i2111111111110 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i211111111119 & 896) | (i211111111119 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111111111110 & 57344) | (458752 & i2111111111110) | (i2111111111110 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp12;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp13;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
        }
        i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i4 |= i7;
        i8 = i3 & 64;
        if (i8 != 0) {
            i4 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(z3)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i4 |= i9;
        }
        i10 = i3 & 128;
        if (i10 != 0) {
            i4 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                i11 = 8388608;
            } else {
                i11 = 4194304;
            }
            i4 |= i11;
        }
        i12 = i3 & 256;
        if (i12 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                i13 = 67108864;
            } else {
                i13 = 33554432;
            }
            i4 |= i13;
        }
        i14 = i3 & 512;
        if (i14 != 0) {
            i4 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                i15 = PropertyOptions.DELETE_EXISTING;
            } else {
                i15 = 268435456;
            }
            i4 |= i15;
        }
        i16 = i3 & 1024;
        if (i16 != 0) {
            i17 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                i18 = 4;
            } else {
                i18 = 2;
            }
            i17 = i2 | i18;
        } else {
            i17 = i2;
        }
        if ((i2 & 112) != 0) {
            i17 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
        }
        if ((i2 & 896) != 0) {
            i17 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
        }
        i19 = i17;
        i20 = i3 & 8192;
        if (i20 != 0) {
            if ((i2 & 7168) == 0) {
                i19 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp6) ? 2048 : 1024;
            }
            if ((i3 & 16384) != 0) {
                if ((i2 & 57344) == 0) {
                    i19 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i2111111111111 = i4 << 3;
                    int i2111111111112 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2111111111111 & 896) | (i2111111111111 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111111111112 & 57344) | (458752 & i2111111111112) | (i2111111111112 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp9 = null;
                        } else {
                            interfaceC0526Fp9 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp10 = interfaceC0526Fp9;
                        if ((i3 & 4096) != 0) {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i19 &= -897;
                        } else {
                            paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                        }
                        if (i20 != 0) {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                        } else {
                            paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                            textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                        }
                        interfaceC0526Fp11 = interfaceC0526Fp7;
                        z5 = z4;
                        interfaceC0526Fp12 = interfaceC0526Fp8;
                        interfaceC0526Fp13 = interfaceC0526Fp19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                    }
                    int i2111111111113 = i4 << 3;
                    int i2111111111114 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2111111111113 & 896) | (i2111111111113 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111111111114 & 57344) | (458752 & i2111111111114) | (i2111111111114 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp14 = interfaceC0526Fp11;
                    interfaceC0526Fp15 = interfaceC0526Fp12;
                    interfaceC0526Fp16 = interfaceC0526Fp10;
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
            }
            i19 |= 24576;
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                }
                int i2111111111115 = i4 << 3;
                int i2111111111116 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2111111111115 & 896) | (i2111111111115 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111111111116 & 57344) | (458752 & i2111111111116) | (i2111111111116 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp12;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp13;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                }
                int i2111111111117 = i4 << 3;
                int i2111111111118 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2111111111117 & 896) | (i2111111111117 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111111111118 & 57344) | (458752 & i2111111111118) | (i2111111111118 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp12;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp13;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
        }
        i19 |= 3072;
        if ((i3 & 16384) != 0) {
            if ((i2 & 57344) == 0) {
                i19 |= composerStartRestartGroup.changed(this) ? 16384 : 8192;
            }
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                }
                int i2111111111119 = i4 << 3;
                int i21111111111110 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i2111111111119 & 896) | (i2111111111119 & 112) | 6 | ((i4 >> 3) & 7168) | (i21111111111110 & 57344) | (458752 & i21111111111110) | (i21111111111110 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp12;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp13;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp9 = null;
                    } else {
                        interfaceC0526Fp9 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp10 = interfaceC0526Fp9;
                    if ((i3 & 4096) != 0) {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i19 &= -897;
                    } else {
                        paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                    }
                    if (i20 != 0) {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                    } else {
                        paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                        textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                    }
                    interfaceC0526Fp11 = interfaceC0526Fp7;
                    z5 = z4;
                    interfaceC0526Fp12 = interfaceC0526Fp8;
                    interfaceC0526Fp13 = interfaceC0526Fp19;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
                }
                int i21111111111111 = i4 << 3;
                int i21111111111112 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21111111111111 & 896) | (i21111111111111 & 112) | 6 | ((i4 >> 3) & 7168) | (i21111111111112 & 57344) | (458752 & i21111111111112) | (i21111111111112 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp14 = interfaceC0526Fp11;
                interfaceC0526Fp15 = interfaceC0526Fp12;
                interfaceC0526Fp16 = interfaceC0526Fp10;
                interfaceC0526Fp17 = interfaceC0526Fp13;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
        }
        i19 |= 24576;
        if ((i4 & 1533916891) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    z4 = false;
                } else {
                    z4 = z3;
                }
                if (i10 != 0) {
                    interfaceC0526Fp7 = null;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp2;
                }
                if (i12 != 0) {
                    interfaceC0526Fp8 = null;
                } else {
                    interfaceC0526Fp8 = interfaceC0526Fp3;
                }
                if (i14 != 0) {
                    interfaceC0526Fp9 = null;
                } else {
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                }
                if (i16 == 0) {
                }
                if ((i3 & 2048) != 0) {
                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                    i19 &= -113;
                } else {
                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                }
                interfaceC0526Fp10 = interfaceC0526Fp9;
                if ((i3 & 4096) != 0) {
                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    i19 &= -897;
                } else {
                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                }
                if (i20 != 0) {
                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                } else {
                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                }
                interfaceC0526Fp11 = interfaceC0526Fp7;
                z5 = z4;
                interfaceC0526Fp12 = interfaceC0526Fp8;
                interfaceC0526Fp13 = interfaceC0526Fp19;
            } else {
                if (i8 != 0) {
                    z4 = false;
                } else {
                    z4 = z3;
                }
                if (i10 != 0) {
                    interfaceC0526Fp7 = null;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp2;
                }
                if (i12 != 0) {
                    interfaceC0526Fp8 = null;
                } else {
                    interfaceC0526Fp8 = interfaceC0526Fp3;
                }
                if (i14 != 0) {
                    interfaceC0526Fp9 = null;
                } else {
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                }
                if (i16 == 0) {
                }
                if ((i3 & 2048) != 0) {
                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                    i19 &= -113;
                } else {
                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                }
                interfaceC0526Fp10 = interfaceC0526Fp9;
                if ((i3 & 4096) != 0) {
                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    i19 &= -897;
                } else {
                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                }
                if (i20 != 0) {
                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                } else {
                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                }
                interfaceC0526Fp11 = interfaceC0526Fp7;
                z5 = z4;
                interfaceC0526Fp12 = interfaceC0526Fp8;
                interfaceC0526Fp13 = interfaceC0526Fp19;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
            }
            int i21111111111113 = i4 << 3;
            int i21111111111114 = i4 >> 9;
            composer2 = composerStartRestartGroup;
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21111111111113 & 896) | (i21111111111113 & 112) | 6 | ((i4 >> 3) & 7168) | (i21111111111114 & 57344) | (458752 & i21111111111114) | (i21111111111114 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z6 = z5;
            interfaceC0526Fp14 = interfaceC0526Fp11;
            interfaceC0526Fp15 = interfaceC0526Fp12;
            interfaceC0526Fp16 = interfaceC0526Fp10;
            interfaceC0526Fp17 = interfaceC0526Fp13;
            textFieldColors3 = textFieldColors2;
            paddingValues3 = paddingValues2;
            interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    z4 = false;
                } else {
                    z4 = z3;
                }
                if (i10 != 0) {
                    interfaceC0526Fp7 = null;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp2;
                }
                if (i12 != 0) {
                    interfaceC0526Fp8 = null;
                } else {
                    interfaceC0526Fp8 = interfaceC0526Fp3;
                }
                if (i14 != 0) {
                    interfaceC0526Fp9 = null;
                } else {
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                }
                if (i16 == 0) {
                }
                if ((i3 & 2048) != 0) {
                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                    i19 &= -113;
                } else {
                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                }
                interfaceC0526Fp10 = interfaceC0526Fp9;
                if ((i3 & 4096) != 0) {
                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    i19 &= -897;
                } else {
                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                }
                if (i20 != 0) {
                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                } else {
                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                }
                interfaceC0526Fp11 = interfaceC0526Fp7;
                z5 = z4;
                interfaceC0526Fp12 = interfaceC0526Fp8;
                interfaceC0526Fp13 = interfaceC0526Fp19;
            } else {
                if (i8 != 0) {
                    z4 = false;
                } else {
                    z4 = z3;
                }
                if (i10 != 0) {
                    interfaceC0526Fp7 = null;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp2;
                }
                if (i12 != 0) {
                    interfaceC0526Fp8 = null;
                } else {
                    interfaceC0526Fp8 = interfaceC0526Fp3;
                }
                if (i14 != 0) {
                    interfaceC0526Fp9 = null;
                } else {
                    interfaceC0526Fp9 = interfaceC0526Fp4;
                }
                if (i16 == 0) {
                }
                if ((i3 & 2048) != 0) {
                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = m1271outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 9) & 112, 2097151);
                    i19 &= -113;
                } else {
                    textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs = textFieldColors;
                }
                interfaceC0526Fp10 = interfaceC0526Fp9;
                if ((i3 & 4096) != 0) {
                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = m1262outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    i19 &= -897;
                } else {
                    paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default = paddingValues;
                }
                if (i20 != 0) {
                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1261916269, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs, i4, i19));
                } else {
                    paddingValues2 = paddingValuesM1262outlinedTextFieldPaddinga9UjIt4$default;
                    textFieldColors2 = textFieldColorsM1271outlinedTextFieldColorsdx8h9Zs;
                    interfaceC0526FpComposableLambda = interfaceC0526Fp6;
                }
                interfaceC0526Fp11 = interfaceC0526Fp7;
                z5 = z4;
                interfaceC0526Fp12 = interfaceC0526Fp8;
                interfaceC0526Fp13 = interfaceC0526Fp19;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1280721485, i4, i19, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)");
            }
            int i21111111111115 = i4 << 3;
            int i21111111111116 = i4 >> 9;
            composer2 = composerStartRestartGroup;
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp11, interfaceC0526Fp12, interfaceC0526Fp10, interfaceC0526Fp13, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i21111111111115 & 896) | (i21111111111115 & 112) | 6 | ((i4 >> 3) & 7168) | (i21111111111116 & 57344) | (458752 & i21111111111116) | (i21111111111116 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168) | ((i19 << 3) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z6 = z5;
            interfaceC0526Fp14 = interfaceC0526Fp11;
            interfaceC0526Fp15 = interfaceC0526Fp12;
            interfaceC0526Fp16 = interfaceC0526Fp10;
            interfaceC0526Fp17 = interfaceC0526Fp13;
            textFieldColors3 = textFieldColors2;
            paddingValues3 = paddingValues2;
            interfaceC0526Fp18 = interfaceC0526FpComposableLambda;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, interfaceC0526Fp17, textFieldColors3, paddingValues3, interfaceC0526Fp18, i, i2, i3));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0140  */
    /* JADX WARN: Code duplicated, block: B:102:0x0146  */
    /* JADX WARN: Code duplicated, block: B:103:0x0149  */
    /* JADX WARN: Code duplicated, block: B:107:0x0151  */
    /* JADX WARN: Code duplicated, block: B:108:0x0156  */
    /* JADX WARN: Code duplicated, block: B:110:0x015c  */
    /* JADX WARN: Code duplicated, block: B:112:0x0162  */
    /* JADX WARN: Code duplicated, block: B:113:0x0165  */
    /* JADX WARN: Code duplicated, block: B:115:0x016a  */
    /* JADX WARN: Code duplicated, block: B:118:0x0170  */
    /* JADX WARN: Code duplicated, block: B:120:0x0174  */
    /* JADX WARN: Code duplicated, block: B:123:0x017f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:126:0x0186  */
    /* JADX WARN: Code duplicated, block: B:129:0x018c  */
    /* JADX WARN: Code duplicated, block: B:131:0x0190  */
    /* JADX WARN: Code duplicated, block: B:134:0x0199 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:138:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:141:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:143:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:145:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:147:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:151:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:157:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:159:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:169:0x0217 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:170:0x0219  */
    /* JADX WARN: Code duplicated, block: B:171:0x021b  */
    /* JADX WARN: Code duplicated, block: B:174:0x0220  */
    /* JADX WARN: Code duplicated, block: B:175:0x0222  */
    /* JADX WARN: Code duplicated, block: B:177:0x0226  */
    /* JADX WARN: Code duplicated, block: B:178:0x0228  */
    /* JADX WARN: Code duplicated, block: B:180:0x022c  */
    /* JADX WARN: Code duplicated, block: B:181:0x022e  */
    /* JADX WARN: Code duplicated, block: B:184:0x0233  */
    /* JADX WARN: Code duplicated, block: B:187:0x0239  */
    /* JADX WARN: Code duplicated, block: B:188:0x0279  */
    /* JADX WARN: Code duplicated, block: B:191:0x0281 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:192:0x0283  */
    /* JADX WARN: Code duplicated, block: B:193:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:196:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:199:0x02df  */
    /* JADX WARN: Code duplicated, block: B:202:0x0351  */
    /* JADX WARN: Code duplicated, block: B:207:0x0369  */
    /* JADX WARN: Code duplicated, block: B:209:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x007f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0084  */
    /* JADX WARN: Code duplicated, block: B:40:0x0088  */
    /* JADX WARN: Code duplicated, block: B:42:0x0090  */
    /* JADX WARN: Code duplicated, block: B:43:0x0093  */
    /* JADX WARN: Code duplicated, block: B:47:0x009e  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00da  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:80:0x0100  */
    /* JADX WARN: Code duplicated, block: B:82:0x0106  */
    /* JADX WARN: Code duplicated, block: B:83:0x0109  */
    /* JADX WARN: Code duplicated, block: B:87:0x0111  */
    /* JADX WARN: Code duplicated, block: B:88:0x0118  */
    /* JADX WARN: Code duplicated, block: B:90:0x0120  */
    /* JADX WARN: Code duplicated, block: B:92:0x0126  */
    /* JADX WARN: Code duplicated, block: B:93:0x0129  */
    /* JADX WARN: Code duplicated, block: B:97:0x0131  */
    /* JADX WARN: Code duplicated, block: B:98:0x0138  */
    @Composable
    @ExperimentalMaterialApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public final void TextFieldDecorationBox(String str, InterfaceC0526Fp interfaceC0526Fp, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, TextFieldColors textFieldColors, PaddingValues paddingValues, Composer composer, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z4;
        InterfaceC0526Fp interfaceC0526Fp6;
        InterfaceC0526Fp interfaceC0526Fp7;
        InterfaceC0526Fp interfaceC0526Fp8;
        TextFieldColors textFieldColorsM1273textFieldColorsdx8h9Zs;
        InterfaceC0526Fp interfaceC0526Fp9;
        PaddingValues paddingValues2;
        TextFieldColors textFieldColors2;
        boolean z5;
        InterfaceC0526Fp interfaceC0526Fp10;
        InterfaceC0526Fp interfaceC0526Fp11;
        InterfaceC0526Fp interfaceC0526Fp12;
        PaddingValues paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
        Composer composer2;
        boolean z6;
        InterfaceC0526Fp interfaceC0526Fp13;
        InterfaceC0526Fp interfaceC0526Fp14;
        InterfaceC0526Fp interfaceC0526Fp15;
        InterfaceC0526Fp interfaceC0526Fp16;
        TextFieldColors textFieldColors3;
        PaddingValues paddingValues3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(str, "value");
        AbstractC4492zt.h(interfaceC0526Fp, "innerTextField");
        AbstractC4492zt.h(visualTransformation, "visualTransformation");
        AbstractC4492zt.h(interactionSource, "interactionSource");
        Composer composerStartRestartGroup = composer.startRestartGroup(1171040065);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        if ((i3 & 4) == 0) {
            if ((i & 896) == 0) {
                i4 |= composerStartRestartGroup.changed(z) ? 256 : 128;
            }
            if ((i3 & 8) != 0) {
                if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i4 |= i5;
                }
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(visualTransformation)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i4 |= i6;
                }
                if ((i3 & 32) != 0) {
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(interactionSource)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                    }
                    i8 = i3 & 64;
                    if (i8 != 0) {
                        i4 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i4 |= i9;
                    }
                    i10 = i3 & 128;
                    if (i10 != 0) {
                        i4 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i4 |= i11;
                    }
                    i12 = i3 & 256;
                    if (i12 != 0) {
                        i4 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i4 |= i13;
                    }
                    i14 = i3 & 512;
                    if (i14 != 0) {
                        i4 |= 805306368;
                    } else if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                            i15 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i15 = 268435456;
                        }
                        i4 |= i15;
                    }
                    i16 = i3 & 1024;
                    if (i16 != 0) {
                        i17 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                            i18 = 4;
                        } else {
                            i18 = 2;
                        }
                        i17 = i2 | i18;
                    } else {
                        i17 = i2;
                    }
                    if ((i2 & 112) != 0) {
                        i17 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
                    }
                    if ((i2 & 896) != 0) {
                        i17 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
                    }
                    i19 = i17;
                    if ((i3 & 8192) != 0) {
                        if ((i2 & 7168) == 0) {
                            i19 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
                        }
                        if ((i4 & 1533916891) != 306783378 && (i19 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            z6 = z3;
                            interfaceC0526Fp13 = interfaceC0526Fp2;
                            interfaceC0526Fp14 = interfaceC0526Fp3;
                            interfaceC0526Fp15 = interfaceC0526Fp4;
                            interfaceC0526Fp16 = interfaceC0526Fp5;
                            textFieldColors3 = textFieldColors;
                            paddingValues3 = paddingValues;
                            composer2 = composerStartRestartGroup;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i8 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526Fp6 = null;
                                } else {
                                    interfaceC0526Fp6 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    interfaceC0526Fp7 = null;
                                } else {
                                    interfaceC0526Fp7 = interfaceC0526Fp3;
                                }
                                if (i14 != 0) {
                                    interfaceC0526Fp8 = null;
                                } else {
                                    interfaceC0526Fp8 = interfaceC0526Fp4;
                                }
                                InterfaceC0526Fp interfaceC0526Fp17 = i16 == 0 ? interfaceC0526Fp5 : null;
                                if ((i3 & 2048) != 0) {
                                    textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                    i19 &= -113;
                                } else {
                                    textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                                }
                                interfaceC0526Fp9 = interfaceC0526Fp8;
                                if ((i3 & 4096) != 0) {
                                    if (interfaceC0526Fp6 == null) {
                                        paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    } else {
                                        paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    }
                                    i19 &= -897;
                                    paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                                } else {
                                    paddingValues2 = paddingValues;
                                }
                                textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                                z5 = z4;
                                interfaceC0526Fp10 = interfaceC0526Fp6;
                                interfaceC0526Fp11 = interfaceC0526Fp17;
                                interfaceC0526Fp12 = interfaceC0526Fp7;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 2048) != 0) {
                                    i19 &= -113;
                                }
                                if ((i3 & 4096) != 0) {
                                    i19 &= -897;
                                }
                                z5 = z3;
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                                interfaceC0526Fp12 = interfaceC0526Fp3;
                                interfaceC0526Fp9 = interfaceC0526Fp4;
                                interfaceC0526Fp11 = interfaceC0526Fp5;
                                textFieldColors2 = textFieldColors;
                                paddingValues2 = paddingValues;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                            }
                            int i20 = i4 << 3;
                            int i21 = i4 >> 9;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i20 & 896) | (i20 & 112) | 6 | ((i4 >> 3) & 7168) | (i21 & 57344) | (i21 & 458752) | (i21 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp13 = interfaceC0526Fp10;
                            interfaceC0526Fp14 = interfaceC0526Fp12;
                            interfaceC0526Fp15 = interfaceC0526Fp9;
                            interfaceC0526Fp16 = interfaceC0526Fp11;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new C14571(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, textFieldColors3, paddingValues3, i, i2, i3));
                    }
                    i19 |= 3072;
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp9 = interfaceC0526Fp8;
                            if ((i3 & 4096) != 0) {
                                if (interfaceC0526Fp6 == null) {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i19 &= -897;
                                paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                            z5 = z4;
                            interfaceC0526Fp10 = interfaceC0526Fp6;
                            interfaceC0526Fp11 = interfaceC0526Fp17;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp9 = interfaceC0526Fp8;
                            if ((i3 & 4096) != 0) {
                                if (interfaceC0526Fp6 == null) {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i19 &= -897;
                                paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                            z5 = z4;
                            interfaceC0526Fp10 = interfaceC0526Fp6;
                            interfaceC0526Fp11 = interfaceC0526Fp17;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                        }
                        int i22 = i4 << 3;
                        int i23 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i22 & 896) | (i22 & 112) | 6 | ((i4 >> 3) & 7168) | (i23 & 57344) | (i23 & 458752) | (i23 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp13 = interfaceC0526Fp10;
                        interfaceC0526Fp14 = interfaceC0526Fp12;
                        interfaceC0526Fp15 = interfaceC0526Fp9;
                        interfaceC0526Fp16 = interfaceC0526Fp11;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp9 = interfaceC0526Fp8;
                            if ((i3 & 4096) != 0) {
                                if (interfaceC0526Fp6 == null) {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i19 &= -897;
                                paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                            z5 = z4;
                            interfaceC0526Fp10 = interfaceC0526Fp6;
                            interfaceC0526Fp11 = interfaceC0526Fp17;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp9 = interfaceC0526Fp8;
                            if ((i3 & 4096) != 0) {
                                if (interfaceC0526Fp6 == null) {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i19 &= -897;
                                paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                            z5 = z4;
                            interfaceC0526Fp10 = interfaceC0526Fp6;
                            interfaceC0526Fp11 = interfaceC0526Fp17;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                        }
                        int i24 = i4 << 3;
                        int i25 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i24 & 896) | (i24 & 112) | 6 | ((i4 >> 3) & 7168) | (i25 & 57344) | (i25 & 458752) | (i25 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp13 = interfaceC0526Fp10;
                        interfaceC0526Fp14 = interfaceC0526Fp12;
                        interfaceC0526Fp15 = interfaceC0526Fp9;
                        interfaceC0526Fp16 = interfaceC0526Fp11;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14571(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, textFieldColors3, paddingValues3, i, i2, i3));
                }
                i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i4 |= i7;
                i8 = i3 & 64;
                if (i8 != 0) {
                    i4 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 128;
                if (i10 != 0) {
                    i4 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i4 |= i11;
                }
                i12 = i3 & 256;
                if (i12 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i4 |= i13;
                }
                i14 = i3 & 512;
                if (i14 != 0) {
                    i4 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i15 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i15 = 268435456;
                    }
                    i4 |= i15;
                }
                i16 = i3 & 1024;
                if (i16 != 0) {
                    i17 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i18 = 4;
                    } else {
                        i18 = 2;
                    }
                    i17 = i2 | i18;
                } else {
                    i17 = i2;
                }
                if ((i2 & 112) != 0) {
                    i17 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
                }
                if ((i2 & 896) != 0) {
                    i17 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
                }
                i19 = i17;
                if ((i3 & 8192) != 0) {
                    if ((i2 & 7168) == 0) {
                        i19 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp9 = interfaceC0526Fp8;
                            if ((i3 & 4096) != 0) {
                                if (interfaceC0526Fp6 == null) {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i19 &= -897;
                                paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                            z5 = z4;
                            interfaceC0526Fp10 = interfaceC0526Fp6;
                            interfaceC0526Fp11 = interfaceC0526Fp17;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp9 = interfaceC0526Fp8;
                            if ((i3 & 4096) != 0) {
                                if (interfaceC0526Fp6 == null) {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i19 &= -897;
                                paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                            z5 = z4;
                            interfaceC0526Fp10 = interfaceC0526Fp6;
                            interfaceC0526Fp11 = interfaceC0526Fp17;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                        }
                        int i26 = i4 << 3;
                        int i27 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i26 & 896) | (i26 & 112) | 6 | ((i4 >> 3) & 7168) | (i27 & 57344) | (i27 & 458752) | (i27 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp13 = interfaceC0526Fp10;
                        interfaceC0526Fp14 = interfaceC0526Fp12;
                        interfaceC0526Fp15 = interfaceC0526Fp9;
                        interfaceC0526Fp16 = interfaceC0526Fp11;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp9 = interfaceC0526Fp8;
                            if ((i3 & 4096) != 0) {
                                if (interfaceC0526Fp6 == null) {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i19 &= -897;
                                paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                            z5 = z4;
                            interfaceC0526Fp10 = interfaceC0526Fp6;
                            interfaceC0526Fp11 = interfaceC0526Fp17;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp9 = interfaceC0526Fp8;
                            if ((i3 & 4096) != 0) {
                                if (interfaceC0526Fp6 == null) {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i19 &= -897;
                                paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                            z5 = z4;
                            interfaceC0526Fp10 = interfaceC0526Fp6;
                            interfaceC0526Fp11 = interfaceC0526Fp17;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                        }
                        int i28 = i4 << 3;
                        int i29 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i28 & 896) | (i28 & 112) | 6 | ((i4 >> 3) & 7168) | (i29 & 57344) | (i29 & 458752) | (i29 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp13 = interfaceC0526Fp10;
                        interfaceC0526Fp14 = interfaceC0526Fp12;
                        interfaceC0526Fp15 = interfaceC0526Fp9;
                        interfaceC0526Fp16 = interfaceC0526Fp11;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14571(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, textFieldColors3, paddingValues3, i, i2, i3));
                }
                i19 |= 3072;
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                    }
                    int i210 = i4 << 3;
                    int i211 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i210 & 896) | (i210 & 112) | 6 | ((i4 >> 3) & 7168) | (i211 & 57344) | (i211 & 458752) | (i211 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp13 = interfaceC0526Fp10;
                    interfaceC0526Fp14 = interfaceC0526Fp12;
                    interfaceC0526Fp15 = interfaceC0526Fp9;
                    interfaceC0526Fp16 = interfaceC0526Fp11;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                    }
                    int i212 = i4 << 3;
                    int i213 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i212 & 896) | (i212 & 112) | 6 | ((i4 >> 3) & 7168) | (i213 & 57344) | (i213 & 458752) | (i213 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp13 = interfaceC0526Fp10;
                    interfaceC0526Fp14 = interfaceC0526Fp12;
                    interfaceC0526Fp15 = interfaceC0526Fp9;
                    interfaceC0526Fp16 = interfaceC0526Fp11;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14571(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, textFieldColors3, paddingValues3, i, i2, i3));
            }
            i4 |= 3072;
            if ((i3 & 16) != 0) {
                i4 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(visualTransformation)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            if ((i3 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(interactionSource)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                }
                i8 = i3 & 64;
                if (i8 != 0) {
                    i4 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 128;
                if (i10 != 0) {
                    i4 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i4 |= i11;
                }
                i12 = i3 & 256;
                if (i12 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i4 |= i13;
                }
                i14 = i3 & 512;
                if (i14 != 0) {
                    i4 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i15 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i15 = 268435456;
                    }
                    i4 |= i15;
                }
                i16 = i3 & 1024;
                if (i16 != 0) {
                    i17 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i18 = 4;
                    } else {
                        i18 = 2;
                    }
                    i17 = i2 | i18;
                } else {
                    i17 = i2;
                }
                if ((i2 & 112) != 0) {
                    i17 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
                }
                if ((i2 & 896) != 0) {
                    i17 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
                }
                i19 = i17;
                if ((i3 & 8192) != 0) {
                    if ((i2 & 7168) == 0) {
                        i19 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp9 = interfaceC0526Fp8;
                            if ((i3 & 4096) != 0) {
                                if (interfaceC0526Fp6 == null) {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i19 &= -897;
                                paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                            z5 = z4;
                            interfaceC0526Fp10 = interfaceC0526Fp6;
                            interfaceC0526Fp11 = interfaceC0526Fp17;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp9 = interfaceC0526Fp8;
                            if ((i3 & 4096) != 0) {
                                if (interfaceC0526Fp6 == null) {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i19 &= -897;
                                paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                            z5 = z4;
                            interfaceC0526Fp10 = interfaceC0526Fp6;
                            interfaceC0526Fp11 = interfaceC0526Fp17;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                        }
                        int i214 = i4 << 3;
                        int i215 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i214 & 896) | (i214 & 112) | 6 | ((i4 >> 3) & 7168) | (i215 & 57344) | (i215 & 458752) | (i215 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp13 = interfaceC0526Fp10;
                        interfaceC0526Fp14 = interfaceC0526Fp12;
                        interfaceC0526Fp15 = interfaceC0526Fp9;
                        interfaceC0526Fp16 = interfaceC0526Fp11;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp9 = interfaceC0526Fp8;
                            if ((i3 & 4096) != 0) {
                                if (interfaceC0526Fp6 == null) {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i19 &= -897;
                                paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                            z5 = z4;
                            interfaceC0526Fp10 = interfaceC0526Fp6;
                            interfaceC0526Fp11 = interfaceC0526Fp17;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp9 = interfaceC0526Fp8;
                            if ((i3 & 4096) != 0) {
                                if (interfaceC0526Fp6 == null) {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i19 &= -897;
                                paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                            z5 = z4;
                            interfaceC0526Fp10 = interfaceC0526Fp6;
                            interfaceC0526Fp11 = interfaceC0526Fp17;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                        }
                        int i216 = i4 << 3;
                        int i217 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i216 & 896) | (i216 & 112) | 6 | ((i4 >> 3) & 7168) | (i217 & 57344) | (i217 & 458752) | (i217 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp13 = interfaceC0526Fp10;
                        interfaceC0526Fp14 = interfaceC0526Fp12;
                        interfaceC0526Fp15 = interfaceC0526Fp9;
                        interfaceC0526Fp16 = interfaceC0526Fp11;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14571(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, textFieldColors3, paddingValues3, i, i2, i3));
                }
                i19 |= 3072;
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                    }
                    int i218 = i4 << 3;
                    int i219 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i218 & 896) | (i218 & 112) | 6 | ((i4 >> 3) & 7168) | (i219 & 57344) | (i219 & 458752) | (i219 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp13 = interfaceC0526Fp10;
                    interfaceC0526Fp14 = interfaceC0526Fp12;
                    interfaceC0526Fp15 = interfaceC0526Fp9;
                    interfaceC0526Fp16 = interfaceC0526Fp11;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                    }
                    int i2110 = i4 << 3;
                    int i2111 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i2110 & 896) | (i2110 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111 & 57344) | (i2111 & 458752) | (i2111 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp13 = interfaceC0526Fp10;
                    interfaceC0526Fp14 = interfaceC0526Fp12;
                    interfaceC0526Fp15 = interfaceC0526Fp9;
                    interfaceC0526Fp16 = interfaceC0526Fp11;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14571(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, textFieldColors3, paddingValues3, i, i2, i3));
            }
            i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i4 |= i7;
            i8 = i3 & 64;
            if (i8 != 0) {
                i4 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i4 |= i9;
            }
            i10 = i3 & 128;
            if (i10 != 0) {
                i4 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i4 |= i11;
            }
            i12 = i3 & 256;
            if (i12 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i4 |= i13;
            }
            i14 = i3 & 512;
            if (i14 != 0) {
                i4 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i15 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i15 = 268435456;
                }
                i4 |= i15;
            }
            i16 = i3 & 1024;
            if (i16 != 0) {
                i17 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i18 = 4;
                } else {
                    i18 = 2;
                }
                i17 = i2 | i18;
            } else {
                i17 = i2;
            }
            if ((i2 & 112) != 0) {
                i17 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
            }
            if ((i2 & 896) != 0) {
                i17 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
            }
            i19 = i17;
            if ((i3 & 8192) != 0) {
                if ((i2 & 7168) == 0) {
                    i19 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                    }
                    int i2112 = i4 << 3;
                    int i2113 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i2112 & 896) | (i2112 & 112) | 6 | ((i4 >> 3) & 7168) | (i2113 & 57344) | (i2113 & 458752) | (i2113 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp13 = interfaceC0526Fp10;
                    interfaceC0526Fp14 = interfaceC0526Fp12;
                    interfaceC0526Fp15 = interfaceC0526Fp9;
                    interfaceC0526Fp16 = interfaceC0526Fp11;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                    }
                    int i2114 = i4 << 3;
                    int i2115 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i2114 & 896) | (i2114 & 112) | 6 | ((i4 >> 3) & 7168) | (i2115 & 57344) | (i2115 & 458752) | (i2115 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp13 = interfaceC0526Fp10;
                    interfaceC0526Fp14 = interfaceC0526Fp12;
                    interfaceC0526Fp15 = interfaceC0526Fp9;
                    interfaceC0526Fp16 = interfaceC0526Fp11;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14571(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, textFieldColors3, paddingValues3, i, i2, i3));
            }
            i19 |= 3072;
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp9 = interfaceC0526Fp8;
                    if ((i3 & 4096) != 0) {
                        if (interfaceC0526Fp6 == null) {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i19 &= -897;
                        paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp6;
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp9 = interfaceC0526Fp8;
                    if ((i3 & 4096) != 0) {
                        if (interfaceC0526Fp6 == null) {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i19 &= -897;
                        paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp6;
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                }
                int i2116 = i4 << 3;
                int i2117 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i2116 & 896) | (i2116 & 112) | 6 | ((i4 >> 3) & 7168) | (i2117 & 57344) | (i2117 & 458752) | (i2117 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp13 = interfaceC0526Fp10;
                interfaceC0526Fp14 = interfaceC0526Fp12;
                interfaceC0526Fp15 = interfaceC0526Fp9;
                interfaceC0526Fp16 = interfaceC0526Fp11;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp9 = interfaceC0526Fp8;
                    if ((i3 & 4096) != 0) {
                        if (interfaceC0526Fp6 == null) {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i19 &= -897;
                        paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp6;
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp9 = interfaceC0526Fp8;
                    if ((i3 & 4096) != 0) {
                        if (interfaceC0526Fp6 == null) {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i19 &= -897;
                        paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp6;
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                }
                int i2118 = i4 << 3;
                int i2119 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i2118 & 896) | (i2118 & 112) | 6 | ((i4 >> 3) & 7168) | (i2119 & 57344) | (i2119 & 458752) | (i2119 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp13 = interfaceC0526Fp10;
                interfaceC0526Fp14 = interfaceC0526Fp12;
                interfaceC0526Fp15 = interfaceC0526Fp9;
                interfaceC0526Fp16 = interfaceC0526Fp11;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14571(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, textFieldColors3, paddingValues3, i, i2, i3));
        }
        i4 |= 384;
        if ((i3 & 8) != 0) {
            if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i4 |= i5;
            }
            if ((i3 & 16) != 0) {
                i4 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(visualTransformation)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            if ((i3 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(interactionSource)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                }
                i8 = i3 & 64;
                if (i8 != 0) {
                    i4 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 128;
                if (i10 != 0) {
                    i4 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i4 |= i11;
                }
                i12 = i3 & 256;
                if (i12 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i4 |= i13;
                }
                i14 = i3 & 512;
                if (i14 != 0) {
                    i4 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i15 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i15 = 268435456;
                    }
                    i4 |= i15;
                }
                i16 = i3 & 1024;
                if (i16 != 0) {
                    i17 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i18 = 4;
                    } else {
                        i18 = 2;
                    }
                    i17 = i2 | i18;
                } else {
                    i17 = i2;
                }
                if ((i2 & 112) != 0) {
                    i17 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
                }
                if ((i2 & 896) != 0) {
                    i17 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
                }
                i19 = i17;
                if ((i3 & 8192) != 0) {
                    if ((i2 & 7168) == 0) {
                        i19 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp9 = interfaceC0526Fp8;
                            if ((i3 & 4096) != 0) {
                                if (interfaceC0526Fp6 == null) {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i19 &= -897;
                                paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                            z5 = z4;
                            interfaceC0526Fp10 = interfaceC0526Fp6;
                            interfaceC0526Fp11 = interfaceC0526Fp17;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp9 = interfaceC0526Fp8;
                            if ((i3 & 4096) != 0) {
                                if (interfaceC0526Fp6 == null) {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i19 &= -897;
                                paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                            z5 = z4;
                            interfaceC0526Fp10 = interfaceC0526Fp6;
                            interfaceC0526Fp11 = interfaceC0526Fp17;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                        }
                        int i21110 = i4 << 3;
                        int i21111 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i21110 & 896) | (i21110 & 112) | 6 | ((i4 >> 3) & 7168) | (i21111 & 57344) | (i21111 & 458752) | (i21111 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp13 = interfaceC0526Fp10;
                        interfaceC0526Fp14 = interfaceC0526Fp12;
                        interfaceC0526Fp15 = interfaceC0526Fp9;
                        interfaceC0526Fp16 = interfaceC0526Fp11;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp9 = interfaceC0526Fp8;
                            if ((i3 & 4096) != 0) {
                                if (interfaceC0526Fp6 == null) {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i19 &= -897;
                                paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                            z5 = z4;
                            interfaceC0526Fp10 = interfaceC0526Fp6;
                            interfaceC0526Fp11 = interfaceC0526Fp17;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                        } else {
                            if (i8 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i10 != 0) {
                                interfaceC0526Fp6 = null;
                            } else {
                                interfaceC0526Fp6 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                interfaceC0526Fp7 = null;
                            } else {
                                interfaceC0526Fp7 = interfaceC0526Fp3;
                            }
                            if (i14 != 0) {
                                interfaceC0526Fp8 = null;
                            } else {
                                interfaceC0526Fp8 = interfaceC0526Fp4;
                            }
                            if (i16 == 0) {
                            }
                            if ((i3 & 2048) != 0) {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                                i19 &= -113;
                            } else {
                                textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                            }
                            interfaceC0526Fp9 = interfaceC0526Fp8;
                            if ((i3 & 4096) != 0) {
                                if (interfaceC0526Fp6 == null) {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                } else {
                                    paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                }
                                i19 &= -897;
                                paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                            } else {
                                paddingValues2 = paddingValues;
                            }
                            textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                            z5 = z4;
                            interfaceC0526Fp10 = interfaceC0526Fp6;
                            interfaceC0526Fp11 = interfaceC0526Fp17;
                            interfaceC0526Fp12 = interfaceC0526Fp7;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                        }
                        int i21112 = i4 << 3;
                        int i21113 = i4 >> 9;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i21112 & 896) | (i21112 & 112) | 6 | ((i4 >> 3) & 7168) | (i21113 & 57344) | (i21113 & 458752) | (i21113 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp13 = interfaceC0526Fp10;
                        interfaceC0526Fp14 = interfaceC0526Fp12;
                        interfaceC0526Fp15 = interfaceC0526Fp9;
                        interfaceC0526Fp16 = interfaceC0526Fp11;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new C14571(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, textFieldColors3, paddingValues3, i, i2, i3));
                }
                i19 |= 3072;
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                    }
                    int i21114 = i4 << 3;
                    int i21115 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i21114 & 896) | (i21114 & 112) | 6 | ((i4 >> 3) & 7168) | (i21115 & 57344) | (i21115 & 458752) | (i21115 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp13 = interfaceC0526Fp10;
                    interfaceC0526Fp14 = interfaceC0526Fp12;
                    interfaceC0526Fp15 = interfaceC0526Fp9;
                    interfaceC0526Fp16 = interfaceC0526Fp11;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                    }
                    int i21116 = i4 << 3;
                    int i21117 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i21116 & 896) | (i21116 & 112) | 6 | ((i4 >> 3) & 7168) | (i21117 & 57344) | (i21117 & 458752) | (i21117 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp13 = interfaceC0526Fp10;
                    interfaceC0526Fp14 = interfaceC0526Fp12;
                    interfaceC0526Fp15 = interfaceC0526Fp9;
                    interfaceC0526Fp16 = interfaceC0526Fp11;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14571(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, textFieldColors3, paddingValues3, i, i2, i3));
            }
            i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i4 |= i7;
            i8 = i3 & 64;
            if (i8 != 0) {
                i4 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i4 |= i9;
            }
            i10 = i3 & 128;
            if (i10 != 0) {
                i4 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i4 |= i11;
            }
            i12 = i3 & 256;
            if (i12 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i4 |= i13;
            }
            i14 = i3 & 512;
            if (i14 != 0) {
                i4 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i15 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i15 = 268435456;
                }
                i4 |= i15;
            }
            i16 = i3 & 1024;
            if (i16 != 0) {
                i17 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i18 = 4;
                } else {
                    i18 = 2;
                }
                i17 = i2 | i18;
            } else {
                i17 = i2;
            }
            if ((i2 & 112) != 0) {
                i17 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
            }
            if ((i2 & 896) != 0) {
                i17 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
            }
            i19 = i17;
            if ((i3 & 8192) != 0) {
                if ((i2 & 7168) == 0) {
                    i19 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                    }
                    int i21118 = i4 << 3;
                    int i21119 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i21118 & 896) | (i21118 & 112) | 6 | ((i4 >> 3) & 7168) | (i21119 & 57344) | (i21119 & 458752) | (i21119 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp13 = interfaceC0526Fp10;
                    interfaceC0526Fp14 = interfaceC0526Fp12;
                    interfaceC0526Fp15 = interfaceC0526Fp9;
                    interfaceC0526Fp16 = interfaceC0526Fp11;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                    }
                    int i211110 = i4 << 3;
                    int i211111 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i211110 & 896) | (i211110 & 112) | 6 | ((i4 >> 3) & 7168) | (i211111 & 57344) | (i211111 & 458752) | (i211111 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp13 = interfaceC0526Fp10;
                    interfaceC0526Fp14 = interfaceC0526Fp12;
                    interfaceC0526Fp15 = interfaceC0526Fp9;
                    interfaceC0526Fp16 = interfaceC0526Fp11;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14571(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, textFieldColors3, paddingValues3, i, i2, i3));
            }
            i19 |= 3072;
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp9 = interfaceC0526Fp8;
                    if ((i3 & 4096) != 0) {
                        if (interfaceC0526Fp6 == null) {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i19 &= -897;
                        paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp6;
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp9 = interfaceC0526Fp8;
                    if ((i3 & 4096) != 0) {
                        if (interfaceC0526Fp6 == null) {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i19 &= -897;
                        paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp6;
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                }
                int i211112 = i4 << 3;
                int i211113 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i211112 & 896) | (i211112 & 112) | 6 | ((i4 >> 3) & 7168) | (i211113 & 57344) | (i211113 & 458752) | (i211113 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp13 = interfaceC0526Fp10;
                interfaceC0526Fp14 = interfaceC0526Fp12;
                interfaceC0526Fp15 = interfaceC0526Fp9;
                interfaceC0526Fp16 = interfaceC0526Fp11;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp9 = interfaceC0526Fp8;
                    if ((i3 & 4096) != 0) {
                        if (interfaceC0526Fp6 == null) {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i19 &= -897;
                        paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp6;
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp9 = interfaceC0526Fp8;
                    if ((i3 & 4096) != 0) {
                        if (interfaceC0526Fp6 == null) {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i19 &= -897;
                        paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp6;
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                }
                int i211114 = i4 << 3;
                int i211115 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i211114 & 896) | (i211114 & 112) | 6 | ((i4 >> 3) & 7168) | (i211115 & 57344) | (i211115 & 458752) | (i211115 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp13 = interfaceC0526Fp10;
                interfaceC0526Fp14 = interfaceC0526Fp12;
                interfaceC0526Fp15 = interfaceC0526Fp9;
                interfaceC0526Fp16 = interfaceC0526Fp11;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14571(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, textFieldColors3, paddingValues3, i, i2, i3));
        }
        i4 |= 3072;
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i & 57344) == 0) {
            if (composerStartRestartGroup.changed(visualTransformation)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i4 |= i6;
        }
        if ((i3 & 32) != 0) {
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(interactionSource)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
            }
            i8 = i3 & 64;
            if (i8 != 0) {
                i4 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i4 |= i9;
            }
            i10 = i3 & 128;
            if (i10 != 0) {
                i4 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i4 |= i11;
            }
            i12 = i3 & 256;
            if (i12 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i4 |= i13;
            }
            i14 = i3 & 512;
            if (i14 != 0) {
                i4 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i15 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i15 = 268435456;
                }
                i4 |= i15;
            }
            i16 = i3 & 1024;
            if (i16 != 0) {
                i17 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i18 = 4;
                } else {
                    i18 = 2;
                }
                i17 = i2 | i18;
            } else {
                i17 = i2;
            }
            if ((i2 & 112) != 0) {
                i17 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
            }
            if ((i2 & 896) != 0) {
                i17 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
            }
            i19 = i17;
            if ((i3 & 8192) != 0) {
                if ((i2 & 7168) == 0) {
                    i19 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                    }
                    int i211116 = i4 << 3;
                    int i211117 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i211116 & 896) | (i211116 & 112) | 6 | ((i4 >> 3) & 7168) | (i211117 & 57344) | (i211117 & 458752) | (i211117 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp13 = interfaceC0526Fp10;
                    interfaceC0526Fp14 = interfaceC0526Fp12;
                    interfaceC0526Fp15 = interfaceC0526Fp9;
                    interfaceC0526Fp16 = interfaceC0526Fp11;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    } else {
                        if (i8 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i10 != 0) {
                            interfaceC0526Fp6 = null;
                        } else {
                            interfaceC0526Fp6 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            interfaceC0526Fp7 = null;
                        } else {
                            interfaceC0526Fp7 = interfaceC0526Fp3;
                        }
                        if (i14 != 0) {
                            interfaceC0526Fp8 = null;
                        } else {
                            interfaceC0526Fp8 = interfaceC0526Fp4;
                        }
                        if (i16 == 0) {
                        }
                        if ((i3 & 2048) != 0) {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                            i19 &= -113;
                        } else {
                            textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                        }
                        interfaceC0526Fp9 = interfaceC0526Fp8;
                        if ((i3 & 4096) != 0) {
                            if (interfaceC0526Fp6 == null) {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            } else {
                                paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            }
                            i19 &= -897;
                            paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                        z5 = z4;
                        interfaceC0526Fp10 = interfaceC0526Fp6;
                        interfaceC0526Fp11 = interfaceC0526Fp17;
                        interfaceC0526Fp12 = interfaceC0526Fp7;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                    }
                    int i211118 = i4 << 3;
                    int i211119 = i4 >> 9;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i211118 & 896) | (i211118 & 112) | 6 | ((i4 >> 3) & 7168) | (i211119 & 57344) | (i211119 & 458752) | (i211119 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp13 = interfaceC0526Fp10;
                    interfaceC0526Fp14 = interfaceC0526Fp12;
                    interfaceC0526Fp15 = interfaceC0526Fp9;
                    interfaceC0526Fp16 = interfaceC0526Fp11;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new C14571(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, textFieldColors3, paddingValues3, i, i2, i3));
            }
            i19 |= 3072;
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp9 = interfaceC0526Fp8;
                    if ((i3 & 4096) != 0) {
                        if (interfaceC0526Fp6 == null) {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i19 &= -897;
                        paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp6;
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp9 = interfaceC0526Fp8;
                    if ((i3 & 4096) != 0) {
                        if (interfaceC0526Fp6 == null) {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i19 &= -897;
                        paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp6;
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                }
                int i2111110 = i4 << 3;
                int i2111111 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i2111110 & 896) | (i2111110 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111111 & 57344) | (i2111111 & 458752) | (i2111111 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp13 = interfaceC0526Fp10;
                interfaceC0526Fp14 = interfaceC0526Fp12;
                interfaceC0526Fp15 = interfaceC0526Fp9;
                interfaceC0526Fp16 = interfaceC0526Fp11;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp9 = interfaceC0526Fp8;
                    if ((i3 & 4096) != 0) {
                        if (interfaceC0526Fp6 == null) {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i19 &= -897;
                        paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp6;
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp9 = interfaceC0526Fp8;
                    if ((i3 & 4096) != 0) {
                        if (interfaceC0526Fp6 == null) {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i19 &= -897;
                        paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp6;
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                }
                int i2111112 = i4 << 3;
                int i2111113 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i2111112 & 896) | (i2111112 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111113 & 57344) | (i2111113 & 458752) | (i2111113 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp13 = interfaceC0526Fp10;
                interfaceC0526Fp14 = interfaceC0526Fp12;
                interfaceC0526Fp15 = interfaceC0526Fp9;
                interfaceC0526Fp16 = interfaceC0526Fp11;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14571(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, textFieldColors3, paddingValues3, i, i2, i3));
        }
        i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i4 |= i7;
        i8 = i3 & 64;
        if (i8 != 0) {
            i4 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(z3)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i4 |= i9;
        }
        i10 = i3 & 128;
        if (i10 != 0) {
            i4 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                i11 = 8388608;
            } else {
                i11 = 4194304;
            }
            i4 |= i11;
        }
        i12 = i3 & 256;
        if (i12 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                i13 = 67108864;
            } else {
                i13 = 33554432;
            }
            i4 |= i13;
        }
        i14 = i3 & 512;
        if (i14 != 0) {
            i4 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                i15 = PropertyOptions.DELETE_EXISTING;
            } else {
                i15 = 268435456;
            }
            i4 |= i15;
        }
        i16 = i3 & 1024;
        if (i16 != 0) {
            i17 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                i18 = 4;
            } else {
                i18 = 2;
            }
            i17 = i2 | i18;
        } else {
            i17 = i2;
        }
        if ((i2 & 112) != 0) {
            i17 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(textFieldColors)) ? 16 : 32;
        }
        if ((i2 & 896) != 0) {
            i17 |= ((i3 & 4096) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? 128 : 256;
        }
        i19 = i17;
        if ((i3 & 8192) != 0) {
            if ((i2 & 7168) == 0) {
                i19 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
            }
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp9 = interfaceC0526Fp8;
                    if ((i3 & 4096) != 0) {
                        if (interfaceC0526Fp6 == null) {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i19 &= -897;
                        paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp6;
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp9 = interfaceC0526Fp8;
                    if ((i3 & 4096) != 0) {
                        if (interfaceC0526Fp6 == null) {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i19 &= -897;
                        paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp6;
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                }
                int i2111114 = i4 << 3;
                int i2111115 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i2111114 & 896) | (i2111114 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111115 & 57344) | (i2111115 & 458752) | (i2111115 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp13 = interfaceC0526Fp10;
                interfaceC0526Fp14 = interfaceC0526Fp12;
                interfaceC0526Fp15 = interfaceC0526Fp9;
                interfaceC0526Fp16 = interfaceC0526Fp11;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp9 = interfaceC0526Fp8;
                    if ((i3 & 4096) != 0) {
                        if (interfaceC0526Fp6 == null) {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i19 &= -897;
                        paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp6;
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                } else {
                    if (i8 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i10 != 0) {
                        interfaceC0526Fp6 = null;
                    } else {
                        interfaceC0526Fp6 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        interfaceC0526Fp7 = null;
                    } else {
                        interfaceC0526Fp7 = interfaceC0526Fp3;
                    }
                    if (i14 != 0) {
                        interfaceC0526Fp8 = null;
                    } else {
                        interfaceC0526Fp8 = interfaceC0526Fp4;
                    }
                    if (i16 == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                        i19 &= -113;
                    } else {
                        textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                    }
                    interfaceC0526Fp9 = interfaceC0526Fp8;
                    if ((i3 & 4096) != 0) {
                        if (interfaceC0526Fp6 == null) {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        } else {
                            paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        }
                        i19 &= -897;
                        paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                    z5 = z4;
                    interfaceC0526Fp10 = interfaceC0526Fp6;
                    interfaceC0526Fp11 = interfaceC0526Fp17;
                    interfaceC0526Fp12 = interfaceC0526Fp7;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
                }
                int i2111116 = i4 << 3;
                int i2111117 = i4 >> 9;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i2111116 & 896) | (i2111116 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111117 & 57344) | (i2111117 & 458752) | (i2111117 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp13 = interfaceC0526Fp10;
                interfaceC0526Fp14 = interfaceC0526Fp12;
                interfaceC0526Fp15 = interfaceC0526Fp9;
                interfaceC0526Fp16 = interfaceC0526Fp11;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C14571(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, textFieldColors3, paddingValues3, i, i2, i3));
        }
        i19 |= 3072;
        if ((i4 & 1533916891) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    z4 = false;
                } else {
                    z4 = z3;
                }
                if (i10 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp2;
                }
                if (i12 != 0) {
                    interfaceC0526Fp7 = null;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp3;
                }
                if (i14 != 0) {
                    interfaceC0526Fp8 = null;
                } else {
                    interfaceC0526Fp8 = interfaceC0526Fp4;
                }
                if (i16 == 0) {
                }
                if ((i3 & 2048) != 0) {
                    textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                    i19 &= -113;
                } else {
                    textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                }
                interfaceC0526Fp9 = interfaceC0526Fp8;
                if ((i3 & 4096) != 0) {
                    if (interfaceC0526Fp6 == null) {
                        paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    } else {
                        paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    }
                    i19 &= -897;
                    paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                } else {
                    paddingValues2 = paddingValues;
                }
                textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                z5 = z4;
                interfaceC0526Fp10 = interfaceC0526Fp6;
                interfaceC0526Fp11 = interfaceC0526Fp17;
                interfaceC0526Fp12 = interfaceC0526Fp7;
            } else {
                if (i8 != 0) {
                    z4 = false;
                } else {
                    z4 = z3;
                }
                if (i10 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp2;
                }
                if (i12 != 0) {
                    interfaceC0526Fp7 = null;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp3;
                }
                if (i14 != 0) {
                    interfaceC0526Fp8 = null;
                } else {
                    interfaceC0526Fp8 = interfaceC0526Fp4;
                }
                if (i16 == 0) {
                }
                if ((i3 & 2048) != 0) {
                    textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                    i19 &= -113;
                } else {
                    textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                }
                interfaceC0526Fp9 = interfaceC0526Fp8;
                if ((i3 & 4096) != 0) {
                    if (interfaceC0526Fp6 == null) {
                        paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    } else {
                        paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    }
                    i19 &= -897;
                    paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                } else {
                    paddingValues2 = paddingValues;
                }
                textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                z5 = z4;
                interfaceC0526Fp10 = interfaceC0526Fp6;
                interfaceC0526Fp11 = interfaceC0526Fp17;
                interfaceC0526Fp12 = interfaceC0526Fp7;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
            }
            int i2111118 = i4 << 3;
            int i2111119 = i4 >> 9;
            composer2 = composerStartRestartGroup;
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i2111118 & 896) | (i2111118 & 112) | 6 | ((i4 >> 3) & 7168) | (i2111119 & 57344) | (i2111119 & 458752) | (i2111119 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z6 = z5;
            interfaceC0526Fp13 = interfaceC0526Fp10;
            interfaceC0526Fp14 = interfaceC0526Fp12;
            interfaceC0526Fp15 = interfaceC0526Fp9;
            interfaceC0526Fp16 = interfaceC0526Fp11;
            textFieldColors3 = textFieldColors2;
            paddingValues3 = paddingValues2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    z4 = false;
                } else {
                    z4 = z3;
                }
                if (i10 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp2;
                }
                if (i12 != 0) {
                    interfaceC0526Fp7 = null;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp3;
                }
                if (i14 != 0) {
                    interfaceC0526Fp8 = null;
                } else {
                    interfaceC0526Fp8 = interfaceC0526Fp4;
                }
                if (i16 == 0) {
                }
                if ((i3 & 2048) != 0) {
                    textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                    i19 &= -113;
                } else {
                    textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                }
                interfaceC0526Fp9 = interfaceC0526Fp8;
                if ((i3 & 4096) != 0) {
                    if (interfaceC0526Fp6 == null) {
                        paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    } else {
                        paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    }
                    i19 &= -897;
                    paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                } else {
                    paddingValues2 = paddingValues;
                }
                textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                z5 = z4;
                interfaceC0526Fp10 = interfaceC0526Fp6;
                interfaceC0526Fp11 = interfaceC0526Fp17;
                interfaceC0526Fp12 = interfaceC0526Fp7;
            } else {
                if (i8 != 0) {
                    z4 = false;
                } else {
                    z4 = z3;
                }
                if (i10 != 0) {
                    interfaceC0526Fp6 = null;
                } else {
                    interfaceC0526Fp6 = interfaceC0526Fp2;
                }
                if (i12 != 0) {
                    interfaceC0526Fp7 = null;
                } else {
                    interfaceC0526Fp7 = interfaceC0526Fp3;
                }
                if (i14 != 0) {
                    interfaceC0526Fp8 = null;
                } else {
                    interfaceC0526Fp8 = interfaceC0526Fp4;
                }
                if (i16 == 0) {
                }
                if ((i3 & 2048) != 0) {
                    textFieldColorsM1273textFieldColorsdx8h9Zs = m1273textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, (i19 >> 6) & 112, 2097151);
                    i19 &= -113;
                } else {
                    textFieldColorsM1273textFieldColorsdx8h9Zs = textFieldColors;
                }
                interfaceC0526Fp9 = interfaceC0526Fp8;
                if ((i3 & 4096) != 0) {
                    if (interfaceC0526Fp6 == null) {
                        paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1264textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    } else {
                        paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default = m1263textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    }
                    i19 &= -897;
                    paddingValues2 = paddingValuesM1263textFieldWithLabelPaddinga9UjIt4$default;
                } else {
                    paddingValues2 = paddingValues;
                }
                textFieldColors2 = textFieldColorsM1273textFieldColorsdx8h9Zs;
                z5 = z4;
                interfaceC0526Fp10 = interfaceC0526Fp6;
                interfaceC0526Fp11 = interfaceC0526Fp17;
                interfaceC0526Fp12 = interfaceC0526Fp7;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1171040065, i4, i19, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)");
            }
            int i21111110 = i4 << 3;
            int i21111111 = i4 >> 9;
            composer2 = composerStartRestartGroup;
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp10, interfaceC0526Fp12, interfaceC0526Fp9, interfaceC0526Fp11, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, null, composer2, (i21111110 & 896) | (i21111110 & 112) | 6 | ((i4 >> 3) & 7168) | (i21111111 & 57344) | (i21111111 & 458752) | (i21111111 & 3670016) | ((i19 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 12) & 112) | ((i4 >> 18) & 14) | (i19 & 896) | ((i19 << 6) & 7168), 16384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z6 = z5;
            interfaceC0526Fp13 = interfaceC0526Fp10;
            interfaceC0526Fp14 = interfaceC0526Fp12;
            interfaceC0526Fp15 = interfaceC0526Fp9;
            interfaceC0526Fp16 = interfaceC0526Fp11;
            textFieldColors3 = textFieldColors2;
            paddingValues3 = paddingValues2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14571(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp13, interfaceC0526Fp14, interfaceC0526Fp15, interfaceC0526Fp16, textFieldColors3, paddingValues3, i, i2, i3));
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1266getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1267getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1268getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    @Composable
    @ReadOnlyComposable
    public final Shape getOutlinedTextFieldShape(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1899109048, i, -1, "androidx.compose.material.TextFieldDefaults.<get-OutlinedTextFieldShape> (TextFieldDefaults.kt:224)");
        }
        CornerBasedShape small = MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return small;
    }

    @Composable
    @ReadOnlyComposable
    public final Shape getTextFieldShape(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1117199624, i, -1, "androidx.compose.material.TextFieldDefaults.<get-TextFieldShape> (TextFieldDefaults.kt:215)");
        }
        CornerBasedShape cornerBasedShapeCopy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return cornerBasedShapeCopy$default;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1269getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    @ExperimentalMaterialApi
    /* JADX INFO: renamed from: indicatorLine-gv0btCI, reason: not valid java name */
    public final Modifier m1270indicatorLinegv0btCI(Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2) {
        AbstractC4492zt.h(modifier, "$this$indicatorLine");
        AbstractC4492zt.h(interactionSource, "interactionSource");
        AbstractC4492zt.h(textFieldColors, "colors");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TextFieldDefaults$indicatorLinegv0btCI$$inlined$debugInspectorInfo$1(z, z2, interactionSource, textFieldColors, f, f2) : InspectableValueKt.getNoInspectorInfo(), new TextFieldDefaults$indicatorLine$2(z, z2, interactionSource, textFieldColors, f, f2));
    }

    @Composable
    /* JADX INFO: renamed from: outlinedTextFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m1271outlinedTextFieldColorsdx8h9Zs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, Composer composer, int i, int i2, int i3, int i4) {
        long jM3031copywmQWz5c$default;
        long jM3031copywmQWz5c$default2;
        long jM3031copywmQWz5c$default3;
        long jM3031copywmQWz5c$default4;
        long jM3031copywmQWz5c$default5;
        long jM3031copywmQWz5c$default6;
        composer.startReplaceableGroup(1762667317);
        long jM3031copywmQWz5c$default7 = (i4 & 1) != 0 ? Color.m3031copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl(), ((Number) composer.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j;
        if ((i4 & 2) != 0) {
            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default7, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default = j2;
        }
        long jM3067getTransparent0d7_KjU = (i4 & 4) != 0 ? Color.Companion.m3067getTransparent0d7_KjU() : j3;
        long jM1051getPrimary0d7_KjU = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU() : j4;
        long jM1045getError0d7_KjU = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1045getError0d7_KjU() : j5;
        long jM3031copywmQWz5c$default8 = (i4 & 32) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM3031copywmQWz5c$default9 = (i4 & 64) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if ((i4 & 128) != 0) {
            jM3031copywmQWz5c$default2 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default9, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default2 = j8;
        }
        long jM1045getError0d7_KjU2 = (i4 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1045getError0d7_KjU() : j9;
        long jM3031copywmQWz5c$default10 = (i4 & 512) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if ((i4 & 1024) != 0) {
            jM3031copywmQWz5c$default3 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default10, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default3 = j11;
        }
        long j22 = (i4 & 2048) != 0 ? jM3031copywmQWz5c$default10 : j12;
        long jM3031copywmQWz5c$default11 = (i4 & 4096) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        if ((i4 & 8192) != 0) {
            jM3031copywmQWz5c$default4 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default11, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default4 = j14;
        }
        long jM1045getError0d7_KjU3 = (i4 & 16384) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1045getError0d7_KjU() : j15;
        long jM3031copywmQWz5c$default12 = (32768 & i4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long jM3031copywmQWz5c$default13 = (65536 & i4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        if ((131072 & i4) != 0) {
            jM3031copywmQWz5c$default5 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default13, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default5 = j18;
        }
        long jM1045getError0d7_KjU4 = (262144 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1045getError0d7_KjU() : j19;
        long jM3031copywmQWz5c$default14 = (524288 & i4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j20;
        if ((i4 & 1048576) != 0) {
            jM3031copywmQWz5c$default6 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default6 = j21;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1762667317, i, i2, "androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:434)");
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(jM3031copywmQWz5c$default7, jM3031copywmQWz5c$default, jM1051getPrimary0d7_KjU, jM1045getError0d7_KjU, jM3031copywmQWz5c$default8, jM3031copywmQWz5c$default9, jM1045getError0d7_KjU2, jM3031copywmQWz5c$default2, jM3031copywmQWz5c$default10, jM3031copywmQWz5c$default3, j22, jM3031copywmQWz5c$default11, jM3031copywmQWz5c$default4, jM1045getError0d7_KjU3, jM3067getTransparent0d7_KjU, jM3031copywmQWz5c$default12, jM3031copywmQWz5c$default13, jM3031copywmQWz5c$default5, jM1045getError0d7_KjU4, jM3031copywmQWz5c$default14, jM3031copywmQWz5c$default6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    @ExperimentalMaterialApi
    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1272outlinedTextFieldPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        return PaddingKt.m481PaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    @Composable
    /* JADX INFO: renamed from: textFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m1273textFieldColorsdx8h9Zs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, Composer composer, int i, int i2, int i3, int i4) {
        long jM3031copywmQWz5c$default;
        long jM3031copywmQWz5c$default2;
        long jM3031copywmQWz5c$default3;
        long jM3031copywmQWz5c$default4;
        long jM3031copywmQWz5c$default5;
        long jM3031copywmQWz5c$default6;
        composer.startReplaceableGroup(231892599);
        long jM3031copywmQWz5c$default7 = (i4 & 1) != 0 ? Color.m3031copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m3042unboximpl(), ((Number) composer.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j;
        if ((i4 & 2) != 0) {
            jM3031copywmQWz5c$default = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default7, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default = j2;
        }
        long jM3031copywmQWz5c$default8 = (i4 & 4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM1051getPrimary0d7_KjU = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU() : j4;
        long jM1045getError0d7_KjU = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1045getError0d7_KjU() : j5;
        long jM3031copywmQWz5c$default9 = (i4 & 32) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM3031copywmQWz5c$default10 = (i4 & 64) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if ((i4 & 128) != 0) {
            jM3031copywmQWz5c$default2 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default10, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default2 = j8;
        }
        long jM1045getError0d7_KjU2 = (i4 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1045getError0d7_KjU() : j9;
        long jM3031copywmQWz5c$default11 = (i4 & 512) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if ((i4 & 1024) != 0) {
            jM3031copywmQWz5c$default3 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default11, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default3 = j11;
        }
        long j22 = (i4 & 2048) != 0 ? jM3031copywmQWz5c$default11 : j12;
        long jM3031copywmQWz5c$default12 = (i4 & 4096) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        if ((i4 & 8192) != 0) {
            jM3031copywmQWz5c$default4 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default12, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default4 = j14;
        }
        long jM1045getError0d7_KjU3 = (i4 & 16384) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1045getError0d7_KjU() : j15;
        long jM3031copywmQWz5c$default13 = (32768 & i4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1051getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long jM3031copywmQWz5c$default14 = (65536 & i4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        if ((131072 & i4) != 0) {
            jM3031copywmQWz5c$default5 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default5 = j18;
        }
        long jM1045getError0d7_KjU4 = (262144 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1045getError0d7_KjU() : j19;
        long jM3031copywmQWz5c$default15 = (524288 & i4) != 0 ? Color.m3031copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1050getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j20;
        if ((i4 & 1048576) != 0) {
            jM3031copywmQWz5c$default6 = Color.m3031copywmQWz5c$default(jM3031copywmQWz5c$default15, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM3031copywmQWz5c$default6 = j21;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(231892599, i, i2, "androidx.compose.material.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:376)");
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(jM3031copywmQWz5c$default7, jM3031copywmQWz5c$default, jM1051getPrimary0d7_KjU, jM1045getError0d7_KjU, jM3031copywmQWz5c$default9, jM3031copywmQWz5c$default10, jM1045getError0d7_KjU2, jM3031copywmQWz5c$default2, jM3031copywmQWz5c$default11, jM3031copywmQWz5c$default3, j22, jM3031copywmQWz5c$default12, jM3031copywmQWz5c$default4, jM1045getError0d7_KjU3, jM3031copywmQWz5c$default8, jM3031copywmQWz5c$default13, jM3031copywmQWz5c$default14, jM3031copywmQWz5c$default5, jM1045getError0d7_KjU4, jM3031copywmQWz5c$default15, jM3031copywmQWz5c$default6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    @ExperimentalMaterialApi
    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1274textFieldWithLabelPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        return PaddingKt.m481PaddingValuesa9UjIt4(f, f3, f2, f4);
    }

    @ExperimentalMaterialApi
    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1275textFieldWithoutLabelPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        return PaddingKt.m481PaddingValuesa9UjIt4(f, f2, f3, f4);
    }
}
