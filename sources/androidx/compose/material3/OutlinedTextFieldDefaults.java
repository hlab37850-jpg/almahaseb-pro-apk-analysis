package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
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
public final class OutlinedTextFieldDefaults {
    public static final int $stable = 0;
    public static final OutlinedTextFieldDefaults INSTANCE = new OutlinedTextFieldDefaults();
    private static final float MinHeight = Dp.m5160constructorimpl(56);
    private static final float MinWidth = Dp.m5160constructorimpl(TIFFConstants.TIFFTAG_MINSAMPLEVALUE);
    private static final float UnfocusedBorderThickness = Dp.m5160constructorimpl(1);
    private static final float FocusedBorderThickness = Dp.m5160constructorimpl(2);

    /* JADX INFO: renamed from: androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$1, reason: invalid class name */
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
                ComposerKt.traceEventStart(-1448570018, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox.<anonymous> (TextFieldDefaults.kt:1654)");
            }
            OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
            boolean z = this.$enabled;
            boolean z2 = this.$isError;
            InteractionSource interactionSource = this.$interactionSource;
            TextFieldColors textFieldColors = this.$colors;
            int i2 = this.$$dirty;
            outlinedTextFieldDefaults.m1685ContainerBoxnbWgWpA(z, z2, interactionSource, textFieldColors, null, 0.0f, 0.0f, composer, ((i2 >> 9) & 896) | ((i2 >> 6) & 14) | 12582912 | ((i2 >> 15) & 112) | ((this.$$dirty1 >> 3) & 7168), 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
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
        final /* synthetic */ String $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, InterfaceC0526Fp interfaceC0526Fp, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, InterfaceC0526Fp interfaceC0526Fp6, InterfaceC0526Fp interfaceC0526Fp7, InterfaceC0526Fp interfaceC0526Fp8, TextFieldColors textFieldColors, PaddingValues paddingValues, InterfaceC0526Fp interfaceC0526Fp9, int i, int i2, int i3) {
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
            this.$prefix = interfaceC0526Fp6;
            this.$suffix = interfaceC0526Fp7;
            this.$supportingText = interfaceC0526Fp8;
            this.$colors = textFieldColors;
            this.$contentPadding = paddingValues;
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
            OutlinedTextFieldDefaults.this.DecorationBox(this.$value, this.$innerTextField, this.$enabled, this.$singleLine, this.$visualTransformation, this.$interactionSource, this.$isError, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$prefix, this.$suffix, this.$supportingText, this.$colors, this.$contentPadding, this.$container, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
        }
    }

    private OutlinedTextFieldDefaults() {
    }

    /* JADX INFO: renamed from: contentPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1684contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults outlinedTextFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
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
        return outlinedTextFieldDefaults.m1687contentPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* JADX WARN: Code duplicated, block: B:118:0x016b  */
    /* JADX WARN: Code duplicated, block: B:121:0x01c6  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterial3Api
    /* JADX INFO: renamed from: ContainerBox-nbWgWpA, reason: not valid java name */
    public final void m1685ContainerBoxnbWgWpA(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, float f, float f2, Composer composer, int i, int i2) {
        int i3;
        Shape shape2;
        float f3;
        float f4;
        Shape shape3;
        float f5;
        float f6;
        Shape shape4;
        float f7;
        float f8;
        AbstractC4492zt.h(interactionSource, "interactionSource");
        AbstractC4492zt.h(textFieldColors, "colors");
        Composer composerStartRestartGroup = composer.startRestartGroup(1461761386);
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
                shape2 = shape;
                int i4 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                i3 |= i4;
            } else {
                shape2 = shape;
            }
            i3 |= i4;
        } else {
            shape2 = shape;
        }
        if ((i & 458752) == 0) {
            if ((i2 & 32) == 0) {
                f3 = f;
                int i5 = composerStartRestartGroup.changed(f3) ? 131072 : 65536;
                i3 |= i5;
            } else {
                f3 = f;
            }
            i3 |= i5;
        } else {
            f3 = f;
        }
        if ((3670016 & i) == 0) {
            if ((i2 & 64) == 0) {
                f4 = f2;
                int i6 = composerStartRestartGroup.changed(f4) ? 1048576 : 524288;
                i3 |= i6;
            } else {
                f4 = f2;
            }
            i3 |= i6;
        } else {
            f4 = f2;
        }
        if ((i2 & 128) != 0) {
            i3 |= 12582912;
        } else if ((29360128 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(this) ? 8388608 : 4194304;
        }
        if ((23967451 & i3) == 4793490 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            f7 = f3;
            f8 = f4;
            shape4 = shape2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 16) != 0) {
                    shape2 = ShapesKt.toShape(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    f3 = FocusedBorderThickness;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    shape3 = shape2;
                    f5 = UnfocusedBorderThickness;
                    f6 = f3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1461761386, i3, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.ContainerBox (TextFieldDefaults.kt:1389)");
                }
                int i7 = i3 & 8190;
                int i8 = i3 >> 3;
                Shape shape5 = shape3;
                BoxKt.Box(BackgroundKt.m166backgroundbw27NRU(BorderKt.border(Modifier.Companion, (BorderStroke) TextFieldDefaultsKt.m1919animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, textFieldColors, f6, f5, composerStartRestartGroup, (i8 & 57344) | i7 | (i8 & 458752)).getValue(), shape5), textFieldColors.containerColor$material3_release(z, z2, interactionSource, composerStartRestartGroup, i7).getValue().m3042unboximpl(), shape5), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape4 = shape5;
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
            shape3 = shape2;
            f6 = f3;
            f5 = f4;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1461761386, i3, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.ContainerBox (TextFieldDefaults.kt:1389)");
            }
            int i9 = i3 & 8190;
            int i10 = i3 >> 3;
            Shape shape6 = shape3;
            BoxKt.Box(BackgroundKt.m166backgroundbw27NRU(BorderKt.border(Modifier.Companion, (BorderStroke) TextFieldDefaultsKt.m1919animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, textFieldColors, f6, f5, composerStartRestartGroup, (i10 & 57344) | i9 | (i10 & 458752)).getValue(), shape6), textFieldColors.containerColor$material3_release(z, z2, interactionSource, composerStartRestartGroup, i9).getValue().m3042unboximpl(), shape6), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape4 = shape6;
            f7 = f6;
            f8 = f5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new OutlinedTextFieldDefaults$ContainerBox$1(this, z, z2, interactionSource, textFieldColors, shape4, f7, f8, i, i2));
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
    /* JADX WARN: Code duplicated, block: B:120:0x0179  */
    /* JADX WARN: Code duplicated, block: B:122:0x017f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0185  */
    /* JADX WARN: Code duplicated, block: B:125:0x0188  */
    /* JADX WARN: Code duplicated, block: B:129:0x0191  */
    /* JADX WARN: Code duplicated, block: B:131:0x0196  */
    /* JADX WARN: Code duplicated, block: B:133:0x019a  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:140:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:144:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:146:0x01be  */
    /* JADX WARN: Code duplicated, block: B:150:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:152:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:155:0x01d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:157:0x01da  */
    /* JADX WARN: Code duplicated, block: B:160:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:162:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:165:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:167:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:170:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:171:0x0206  */
    /* JADX WARN: Code duplicated, block: B:173:0x020c  */
    /* JADX WARN: Code duplicated, block: B:175:0x0212  */
    /* JADX WARN: Code duplicated, block: B:176:0x0215  */
    /* JADX WARN: Code duplicated, block: B:180:0x021d  */
    /* JADX WARN: Code duplicated, block: B:181:0x0224  */
    /* JADX WARN: Code duplicated, block: B:183:0x022a  */
    /* JADX WARN: Code duplicated, block: B:185:0x0230  */
    /* JADX WARN: Code duplicated, block: B:186:0x0233  */
    /* JADX WARN: Code duplicated, block: B:190:0x0241  */
    /* JADX WARN: Code duplicated, block: B:196:0x026e  */
    /* JADX WARN: Code duplicated, block: B:198:0x0275  */
    /* JADX WARN: Code duplicated, block: B:208:0x02a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:209:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:210:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:213:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:214:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:216:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:217:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:219:0x02be  */
    /* JADX WARN: Code duplicated, block: B:220:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:222:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:223:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:225:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:226:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:228:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:229:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:232:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:235:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:236:0x0354  */
    /* JADX WARN: Code duplicated, block: B:239:0x035d  */
    /* JADX WARN: Code duplicated, block: B:240:0x0381  */
    /* JADX WARN: Code duplicated, block: B:243:0x0387  */
    /* JADX WARN: Code duplicated, block: B:245:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:248:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:251:0x0457  */
    /* JADX WARN: Code duplicated, block: B:256:0x0477  */
    /* JADX WARN: Code duplicated, block: B:258:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x007d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0082  */
    /* JADX WARN: Code duplicated, block: B:40:0x0086  */
    /* JADX WARN: Code duplicated, block: B:42:0x008e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0091  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00de  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fe  */
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
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][_][_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public final void DecorationBox(String str, InterfaceC0526Fp interfaceC0526Fp, boolean z, boolean z2, VisualTransformation visualTransformation, InteractionSource interactionSource, boolean z3, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, InterfaceC0526Fp interfaceC0526Fp6, InterfaceC0526Fp interfaceC0526Fp7, InterfaceC0526Fp interfaceC0526Fp8, TextFieldColors textFieldColors, PaddingValues paddingValues, InterfaceC0526Fp interfaceC0526Fp9, Composer composer, int i, int i2, int i3) {
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
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        boolean z4;
        InterfaceC0526Fp interfaceC0526Fp10;
        InterfaceC0526Fp interfaceC0526Fp11;
        InterfaceC0526Fp interfaceC0526Fp12;
        InterfaceC0526Fp interfaceC0526Fp13;
        InterfaceC0526Fp interfaceC0526Fp14;
        InterfaceC0526Fp interfaceC0526Fp15;
        TextFieldColors textFieldColorsM1686colors0hiis_0;
        PaddingValues paddingValuesM1684contentPaddinga9UjIt4$default;
        InterfaceC0526Fp interfaceC0526Fp16;
        InterfaceC0526Fp interfaceC0526Fp17;
        InterfaceC0526Fp interfaceC0526Fp18;
        InterfaceC0526Fp interfaceC0526FpComposableLambda;
        InterfaceC0526Fp interfaceC0526Fp19;
        InterfaceC0526Fp interfaceC0526Fp20;
        InterfaceC0526Fp interfaceC0526Fp21;
        boolean z5;
        TextFieldColors textFieldColors2;
        InterfaceC0526Fp interfaceC0526Fp22;
        PaddingValues paddingValues2;
        Composer composer2;
        boolean z6;
        InterfaceC0526Fp interfaceC0526Fp23;
        InterfaceC0526Fp interfaceC0526Fp24;
        InterfaceC0526Fp interfaceC0526Fp25;
        InterfaceC0526Fp interfaceC0526Fp26;
        InterfaceC0526Fp interfaceC0526Fp27;
        InterfaceC0526Fp interfaceC0526Fp28;
        InterfaceC0526Fp interfaceC0526Fp29;
        TextFieldColors textFieldColors3;
        PaddingValues paddingValues3;
        InterfaceC0526Fp interfaceC0526Fp30;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i29;
        AbstractC4492zt.h(str, "value");
        AbstractC4492zt.h(interfaceC0526Fp, "innerTextField");
        AbstractC4492zt.h(visualTransformation, "visualTransformation");
        AbstractC4492zt.h(interactionSource, "interactionSource");
        Composer composerStartRestartGroup = composer.startRestartGroup(-350442135);
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
                i6 = 8192;
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(visualTransformation)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i4 |= i7;
                }
                if ((i3 & 32) != 0) {
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(interactionSource)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                        i4 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i4 |= i10;
                    }
                    i11 = i3 & 128;
                    if (i11 != 0) {
                        i4 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i4 |= i12;
                    }
                    i13 = i3 & 256;
                    if (i13 != 0) {
                        i4 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                            i14 = 67108864;
                        } else {
                            i14 = 33554432;
                        }
                        i4 |= i14;
                    }
                    i15 = i3 & 512;
                    if (i15 != 0) {
                        i4 |= 805306368;
                    } else if ((i & 1879048192) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                            i16 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i16 = 268435456;
                        }
                        i4 |= i16;
                    }
                    i17 = i3 & 1024;
                    if (i17 != 0) {
                        i18 = i2 | 6;
                    } else if ((i2 & 14) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                            i19 = 4;
                        } else {
                            i19 = 2;
                        }
                        i18 = i2 | i19;
                    } else {
                        i18 = i2;
                    }
                    i20 = i3 & 2048;
                    if (i20 != 0) {
                        i18 |= 48;
                    } else if ((i2 & 112) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp6)) {
                            i21 = 32;
                        } else {
                            i21 = 16;
                        }
                        i18 |= i21;
                    }
                    i22 = i18;
                    i23 = i3 & 4096;
                    if (i23 != 0) {
                        if ((i2 & 896) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                                i24 = 256;
                            } else {
                                i24 = 128;
                            }
                            i22 |= i24;
                        }
                        i25 = i3 & 8192;
                        if (i25 != 0) {
                            if ((i2 & 7168) == 0) {
                                i22 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 2048 : 1024;
                            }
                            if ((i2 & 57344) != 0) {
                                if ((i3 & 16384) == 0 && composerStartRestartGroup.changed(textFieldColors)) {
                                    i6 = 16384;
                                }
                                i22 |= i6;
                            }
                            if ((i2 & 458752) != 0) {
                                if ((i3 & 32768) == 0 || !composerStartRestartGroup.changed(paddingValues)) {
                                    i29 = 65536;
                                } else {
                                    i29 = 131072;
                                }
                                i22 |= i29;
                            }
                            i26 = i3 & 65536;
                            if (i26 != 0) {
                                i22 |= 1572864;
                            } else if ((i2 & 3670016) == 0) {
                                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                                    i27 = 1048576;
                                } else {
                                    i27 = 524288;
                                }
                                i22 |= i27;
                            }
                            if ((i3 & 131072) != 0) {
                                i22 |= 12582912;
                            } else if ((i2 & 29360128) == 0) {
                                if (composerStartRestartGroup.changed(this)) {
                                    i28 = 8388608;
                                } else {
                                    i28 = 4194304;
                                }
                                i22 |= i28;
                            }
                            if ((i4 & 1533916891) != 306783378 && (23967451 & i22) == 4793490 && composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.skipToGroupEnd();
                                interfaceC0526Fp23 = interfaceC0526Fp2;
                                interfaceC0526Fp24 = interfaceC0526Fp3;
                                interfaceC0526Fp25 = interfaceC0526Fp4;
                                interfaceC0526Fp26 = interfaceC0526Fp5;
                                interfaceC0526Fp27 = interfaceC0526Fp6;
                                interfaceC0526Fp28 = interfaceC0526Fp7;
                                interfaceC0526Fp29 = interfaceC0526Fp8;
                                textFieldColors3 = textFieldColors;
                                paddingValues3 = paddingValues;
                                interfaceC0526Fp30 = interfaceC0526Fp9;
                                composer2 = composerStartRestartGroup;
                                z6 = z3;
                            } else {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i9 != 0) {
                                        z4 = false;
                                    } else {
                                        z4 = z3;
                                    }
                                    if (i11 != 0) {
                                        interfaceC0526Fp10 = null;
                                    } else {
                                        interfaceC0526Fp10 = interfaceC0526Fp2;
                                    }
                                    if (i13 != 0) {
                                        interfaceC0526Fp11 = null;
                                    } else {
                                        interfaceC0526Fp11 = interfaceC0526Fp3;
                                    }
                                    if (i15 != 0) {
                                        interfaceC0526Fp12 = null;
                                    } else {
                                        interfaceC0526Fp12 = interfaceC0526Fp4;
                                    }
                                    if (i17 != 0) {
                                        interfaceC0526Fp13 = null;
                                    } else {
                                        interfaceC0526Fp13 = interfaceC0526Fp5;
                                    }
                                    if (i20 != 0) {
                                        interfaceC0526Fp14 = null;
                                    } else {
                                        interfaceC0526Fp14 = interfaceC0526Fp6;
                                    }
                                    if (i23 != 0) {
                                        interfaceC0526Fp15 = null;
                                    } else {
                                        interfaceC0526Fp15 = interfaceC0526Fp7;
                                    }
                                    InterfaceC0526Fp interfaceC0526Fp31 = i25 == 0 ? interfaceC0526Fp8 : null;
                                    if ((i3 & 16384) != 0) {
                                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                        i22 &= -57345;
                                    } else {
                                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                    }
                                    if ((i3 & 32768) != 0) {
                                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        i22 &= -458753;
                                    } else {
                                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                    }
                                    interfaceC0526Fp16 = interfaceC0526Fp12;
                                    if (i26 != 0) {
                                        interfaceC0526Fp17 = interfaceC0526Fp13;
                                        interfaceC0526Fp18 = interfaceC0526Fp14;
                                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                    } else {
                                        interfaceC0526Fp17 = interfaceC0526Fp13;
                                        interfaceC0526Fp18 = interfaceC0526Fp14;
                                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                    }
                                    interfaceC0526Fp19 = interfaceC0526Fp10;
                                    interfaceC0526Fp20 = interfaceC0526Fp11;
                                    interfaceC0526Fp21 = interfaceC0526Fp15;
                                    z5 = z4;
                                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                    interfaceC0526Fp22 = interfaceC0526Fp31;
                                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i3 & 16384) != 0) {
                                        i22 &= -57345;
                                    }
                                    if ((32768 & i3) != 0) {
                                        i22 &= -458753;
                                    }
                                    z5 = z3;
                                    interfaceC0526Fp19 = interfaceC0526Fp2;
                                    interfaceC0526Fp20 = interfaceC0526Fp3;
                                    interfaceC0526Fp16 = interfaceC0526Fp4;
                                    interfaceC0526Fp17 = interfaceC0526Fp5;
                                    interfaceC0526Fp18 = interfaceC0526Fp6;
                                    interfaceC0526Fp21 = interfaceC0526Fp7;
                                    interfaceC0526Fp22 = interfaceC0526Fp8;
                                    textFieldColors2 = textFieldColors;
                                    paddingValues2 = paddingValues;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                                }
                                int i30 = i4;
                                int i31 = i30 << 3;
                                int i32 = i30 >> 3;
                                int i33 = i30 >> 9;
                                int i34 = i22 << 21;
                                composer2 = composerStartRestartGroup;
                                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31 & 896) | (i31 & 112) | 6 | (i32 & 7168) | (i33 & 57344) | (i33 & 458752) | (i33 & 3670016) | (i34 & 29360128) | (234881024 & i34) | (i34 & 1879048192), ((i22 >> 9) & 14) | ((i30 >> 6) & 112) | (i30 & 896) | (i33 & 7168) | (i32 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z6 = z5;
                                interfaceC0526Fp23 = interfaceC0526Fp19;
                                interfaceC0526Fp24 = interfaceC0526Fp20;
                                interfaceC0526Fp25 = interfaceC0526Fp16;
                                interfaceC0526Fp26 = interfaceC0526Fp17;
                                interfaceC0526Fp27 = interfaceC0526Fp18;
                                interfaceC0526Fp28 = interfaceC0526Fp21;
                                interfaceC0526Fp29 = interfaceC0526Fp22;
                                textFieldColors3 = textFieldColors2;
                                paddingValues3 = paddingValues2;
                                interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
                        }
                        i22 |= 3072;
                        if ((i2 & 57344) != 0) {
                            if ((i3 & 16384) == 0) {
                                i6 = 16384;
                            }
                            i22 |= i6;
                        }
                        if ((i2 & 458752) != 0) {
                            if ((i3 & 32768) == 0) {
                                i29 = 65536;
                            } else {
                                i29 = 65536;
                            }
                            i22 |= i29;
                        }
                        i26 = i3 & 65536;
                        if (i26 != 0) {
                            i22 |= 1572864;
                        } else if ((i2 & 3670016) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                                i27 = 1048576;
                            } else {
                                i27 = 524288;
                            }
                            i22 |= i27;
                        }
                        if ((i3 & 131072) != 0) {
                            i22 |= 12582912;
                        } else if ((i2 & 29360128) == 0) {
                            if (composerStartRestartGroup.changed(this)) {
                                i28 = 8388608;
                            } else {
                                i28 = 4194304;
                            }
                            i22 |= i28;
                        }
                        if ((i4 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            } else {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                            }
                            int i35 = i4;
                            int i36 = i35 << 3;
                            int i37 = i35 >> 3;
                            int i38 = i35 >> 9;
                            int i39 = i22 << 21;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i36 & 896) | (i36 & 112) | 6 | (i37 & 7168) | (i38 & 57344) | (i38 & 458752) | (i38 & 3670016) | (i39 & 29360128) | (234881024 & i39) | (i39 & 1879048192), ((i22 >> 9) & 14) | ((i35 >> 6) & 112) | (i35 & 896) | (i38 & 7168) | (i37 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp23 = interfaceC0526Fp19;
                            interfaceC0526Fp24 = interfaceC0526Fp20;
                            interfaceC0526Fp25 = interfaceC0526Fp16;
                            interfaceC0526Fp26 = interfaceC0526Fp17;
                            interfaceC0526Fp27 = interfaceC0526Fp18;
                            interfaceC0526Fp28 = interfaceC0526Fp21;
                            interfaceC0526Fp29 = interfaceC0526Fp22;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            } else {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                            }
                            int i310 = i4;
                            int i311 = i310 << 3;
                            int i312 = i310 >> 3;
                            int i313 = i310 >> 9;
                            int i314 = i22 << 21;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311 & 896) | (i311 & 112) | 6 | (i312 & 7168) | (i313 & 57344) | (i313 & 458752) | (i313 & 3670016) | (i314 & 29360128) | (234881024 & i314) | (i314 & 1879048192), ((i22 >> 9) & 14) | ((i310 >> 6) & 112) | (i310 & 896) | (i313 & 7168) | (i312 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp23 = interfaceC0526Fp19;
                            interfaceC0526Fp24 = interfaceC0526Fp20;
                            interfaceC0526Fp25 = interfaceC0526Fp16;
                            interfaceC0526Fp26 = interfaceC0526Fp17;
                            interfaceC0526Fp27 = interfaceC0526Fp18;
                            interfaceC0526Fp28 = interfaceC0526Fp21;
                            interfaceC0526Fp29 = interfaceC0526Fp22;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
                    }
                    i22 |= 384;
                    i25 = i3 & 8192;
                    if (i25 != 0) {
                        if ((i2 & 7168) == 0) {
                            i22 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 2048 : 1024;
                        }
                        if ((i2 & 57344) != 0) {
                            if ((i3 & 16384) == 0) {
                                i6 = 16384;
                            }
                            i22 |= i6;
                        }
                        if ((i2 & 458752) != 0) {
                            if ((i3 & 32768) == 0) {
                                i29 = 65536;
                            } else {
                                i29 = 65536;
                            }
                            i22 |= i29;
                        }
                        i26 = i3 & 65536;
                        if (i26 != 0) {
                            i22 |= 1572864;
                        } else if ((i2 & 3670016) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                                i27 = 1048576;
                            } else {
                                i27 = 524288;
                            }
                            i22 |= i27;
                        }
                        if ((i3 & 131072) != 0) {
                            i22 |= 12582912;
                        } else if ((i2 & 29360128) == 0) {
                            if (composerStartRestartGroup.changed(this)) {
                                i28 = 8388608;
                            } else {
                                i28 = 4194304;
                            }
                            i22 |= i28;
                        }
                        if ((i4 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            } else {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                            }
                            int i315 = i4;
                            int i316 = i315 << 3;
                            int i317 = i315 >> 3;
                            int i318 = i315 >> 9;
                            int i319 = i22 << 21;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i316 & 896) | (i316 & 112) | 6 | (i317 & 7168) | (i318 & 57344) | (i318 & 458752) | (i318 & 3670016) | (i319 & 29360128) | (234881024 & i319) | (i319 & 1879048192), ((i22 >> 9) & 14) | ((i315 >> 6) & 112) | (i315 & 896) | (i318 & 7168) | (i317 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp23 = interfaceC0526Fp19;
                            interfaceC0526Fp24 = interfaceC0526Fp20;
                            interfaceC0526Fp25 = interfaceC0526Fp16;
                            interfaceC0526Fp26 = interfaceC0526Fp17;
                            interfaceC0526Fp27 = interfaceC0526Fp18;
                            interfaceC0526Fp28 = interfaceC0526Fp21;
                            interfaceC0526Fp29 = interfaceC0526Fp22;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            } else {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                            }
                            int i3110 = i4;
                            int i3111 = i3110 << 3;
                            int i3112 = i3110 >> 3;
                            int i3113 = i3110 >> 9;
                            int i3114 = i22 << 21;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111 & 896) | (i3111 & 112) | 6 | (i3112 & 7168) | (i3113 & 57344) | (i3113 & 458752) | (i3113 & 3670016) | (i3114 & 29360128) | (234881024 & i3114) | (i3114 & 1879048192), ((i22 >> 9) & 14) | ((i3110 >> 6) & 112) | (i3110 & 896) | (i3113 & 7168) | (i3112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp23 = interfaceC0526Fp19;
                            interfaceC0526Fp24 = interfaceC0526Fp20;
                            interfaceC0526Fp25 = interfaceC0526Fp16;
                            interfaceC0526Fp26 = interfaceC0526Fp17;
                            interfaceC0526Fp27 = interfaceC0526Fp18;
                            interfaceC0526Fp28 = interfaceC0526Fp21;
                            interfaceC0526Fp29 = interfaceC0526Fp22;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
                    }
                    i22 |= 3072;
                    if ((i2 & 57344) != 0) {
                        if ((i3 & 16384) == 0) {
                            i6 = 16384;
                        }
                        i22 |= i6;
                    }
                    if ((i2 & 458752) != 0) {
                        if ((i3 & 32768) == 0) {
                            i29 = 65536;
                        } else {
                            i29 = 65536;
                        }
                        i22 |= i29;
                    }
                    i26 = i3 & 65536;
                    if (i26 != 0) {
                        i22 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i27 = 1048576;
                        } else {
                            i27 = 524288;
                        }
                        i22 |= i27;
                    }
                    if ((i3 & 131072) != 0) {
                        i22 |= 12582912;
                    } else if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(this)) {
                            i28 = 8388608;
                        } else {
                            i28 = 4194304;
                        }
                        i22 |= i28;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i3115 = i4;
                        int i3116 = i3115 << 3;
                        int i3117 = i3115 >> 3;
                        int i3118 = i3115 >> 9;
                        int i3119 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3116 & 896) | (i3116 & 112) | 6 | (i3117 & 7168) | (i3118 & 57344) | (i3118 & 458752) | (i3118 & 3670016) | (i3119 & 29360128) | (234881024 & i3119) | (i3119 & 1879048192), ((i22 >> 9) & 14) | ((i3115 >> 6) & 112) | (i3115 & 896) | (i3118 & 7168) | (i3117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i31110 = i4;
                        int i31111 = i31110 << 3;
                        int i31112 = i31110 >> 3;
                        int i31113 = i31110 >> 9;
                        int i31114 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111 & 896) | (i31111 & 112) | 6 | (i31112 & 7168) | (i31113 & 57344) | (i31113 & 458752) | (i31113 & 3670016) | (i31114 & 29360128) | (234881024 & i31114) | (i31114 & 1879048192), ((i22 >> 9) & 14) | ((i31110 >> 6) & 112) | (i31110 & 896) | (i31113 & 7168) | (i31112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
                }
                i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i4 |= i8;
                i9 = i3 & 64;
                if (i9 != 0) {
                    i4 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 128;
                if (i11 != 0) {
                    i4 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 256;
                if (i13 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i4 |= i14;
                }
                i15 = i3 & 512;
                if (i15 != 0) {
                    i4 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i16 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i16 = 268435456;
                    }
                    i4 |= i16;
                }
                i17 = i3 & 1024;
                if (i17 != 0) {
                    i18 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i18 = i2 | i19;
                } else {
                    i18 = i2;
                }
                i20 = i3 & 2048;
                if (i20 != 0) {
                    i18 |= 48;
                } else if ((i2 & 112) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp6)) {
                        i21 = 32;
                    } else {
                        i21 = 16;
                    }
                    i18 |= i21;
                }
                i22 = i18;
                i23 = i3 & 4096;
                if (i23 != 0) {
                    if ((i2 & 896) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                            i24 = 256;
                        } else {
                            i24 = 128;
                        }
                        i22 |= i24;
                    }
                    i25 = i3 & 8192;
                    if (i25 != 0) {
                        if ((i2 & 7168) == 0) {
                            i22 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 2048 : 1024;
                        }
                        if ((i2 & 57344) != 0) {
                            if ((i3 & 16384) == 0) {
                                i6 = 16384;
                            }
                            i22 |= i6;
                        }
                        if ((i2 & 458752) != 0) {
                            if ((i3 & 32768) == 0) {
                                i29 = 65536;
                            } else {
                                i29 = 65536;
                            }
                            i22 |= i29;
                        }
                        i26 = i3 & 65536;
                        if (i26 != 0) {
                            i22 |= 1572864;
                        } else if ((i2 & 3670016) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                                i27 = 1048576;
                            } else {
                                i27 = 524288;
                            }
                            i22 |= i27;
                        }
                        if ((i3 & 131072) != 0) {
                            i22 |= 12582912;
                        } else if ((i2 & 29360128) == 0) {
                            if (composerStartRestartGroup.changed(this)) {
                                i28 = 8388608;
                            } else {
                                i28 = 4194304;
                            }
                            i22 |= i28;
                        }
                        if ((i4 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            } else {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                            }
                            int i31115 = i4;
                            int i31116 = i31115 << 3;
                            int i31117 = i31115 >> 3;
                            int i31118 = i31115 >> 9;
                            int i31119 = i22 << 21;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31116 & 896) | (i31116 & 112) | 6 | (i31117 & 7168) | (i31118 & 57344) | (i31118 & 458752) | (i31118 & 3670016) | (i31119 & 29360128) | (234881024 & i31119) | (i31119 & 1879048192), ((i22 >> 9) & 14) | ((i31115 >> 6) & 112) | (i31115 & 896) | (i31118 & 7168) | (i31117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp23 = interfaceC0526Fp19;
                            interfaceC0526Fp24 = interfaceC0526Fp20;
                            interfaceC0526Fp25 = interfaceC0526Fp16;
                            interfaceC0526Fp26 = interfaceC0526Fp17;
                            interfaceC0526Fp27 = interfaceC0526Fp18;
                            interfaceC0526Fp28 = interfaceC0526Fp21;
                            interfaceC0526Fp29 = interfaceC0526Fp22;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            } else {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                            }
                            int i311110 = i4;
                            int i311111 = i311110 << 3;
                            int i311112 = i311110 >> 3;
                            int i311113 = i311110 >> 9;
                            int i311114 = i22 << 21;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111 & 896) | (i311111 & 112) | 6 | (i311112 & 7168) | (i311113 & 57344) | (i311113 & 458752) | (i311113 & 3670016) | (i311114 & 29360128) | (234881024 & i311114) | (i311114 & 1879048192), ((i22 >> 9) & 14) | ((i311110 >> 6) & 112) | (i311110 & 896) | (i311113 & 7168) | (i311112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp23 = interfaceC0526Fp19;
                            interfaceC0526Fp24 = interfaceC0526Fp20;
                            interfaceC0526Fp25 = interfaceC0526Fp16;
                            interfaceC0526Fp26 = interfaceC0526Fp17;
                            interfaceC0526Fp27 = interfaceC0526Fp18;
                            interfaceC0526Fp28 = interfaceC0526Fp21;
                            interfaceC0526Fp29 = interfaceC0526Fp22;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
                    }
                    i22 |= 3072;
                    if ((i2 & 57344) != 0) {
                        if ((i3 & 16384) == 0) {
                            i6 = 16384;
                        }
                        i22 |= i6;
                    }
                    if ((i2 & 458752) != 0) {
                        if ((i3 & 32768) == 0) {
                            i29 = 65536;
                        } else {
                            i29 = 65536;
                        }
                        i22 |= i29;
                    }
                    i26 = i3 & 65536;
                    if (i26 != 0) {
                        i22 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i27 = 1048576;
                        } else {
                            i27 = 524288;
                        }
                        i22 |= i27;
                    }
                    if ((i3 & 131072) != 0) {
                        i22 |= 12582912;
                    } else if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(this)) {
                            i28 = 8388608;
                        } else {
                            i28 = 4194304;
                        }
                        i22 |= i28;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i311115 = i4;
                        int i311116 = i311115 << 3;
                        int i311117 = i311115 >> 3;
                        int i311118 = i311115 >> 9;
                        int i311119 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311116 & 896) | (i311116 & 112) | 6 | (i311117 & 7168) | (i311118 & 57344) | (i311118 & 458752) | (i311118 & 3670016) | (i311119 & 29360128) | (234881024 & i311119) | (i311119 & 1879048192), ((i22 >> 9) & 14) | ((i311115 >> 6) & 112) | (i311115 & 896) | (i311118 & 7168) | (i311117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i3111110 = i4;
                        int i3111111 = i3111110 << 3;
                        int i3111112 = i3111110 >> 3;
                        int i3111113 = i3111110 >> 9;
                        int i3111114 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111 & 896) | (i3111111 & 112) | 6 | (i3111112 & 7168) | (i3111113 & 57344) | (i3111113 & 458752) | (i3111113 & 3670016) | (i3111114 & 29360128) | (234881024 & i3111114) | (i3111114 & 1879048192), ((i22 >> 9) & 14) | ((i3111110 >> 6) & 112) | (i3111110 & 896) | (i3111113 & 7168) | (i3111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
                }
                i22 |= 384;
                i25 = i3 & 8192;
                if (i25 != 0) {
                    if ((i2 & 7168) == 0) {
                        i22 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 2048 : 1024;
                    }
                    if ((i2 & 57344) != 0) {
                        if ((i3 & 16384) == 0) {
                            i6 = 16384;
                        }
                        i22 |= i6;
                    }
                    if ((i2 & 458752) != 0) {
                        if ((i3 & 32768) == 0) {
                            i29 = 65536;
                        } else {
                            i29 = 65536;
                        }
                        i22 |= i29;
                    }
                    i26 = i3 & 65536;
                    if (i26 != 0) {
                        i22 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i27 = 1048576;
                        } else {
                            i27 = 524288;
                        }
                        i22 |= i27;
                    }
                    if ((i3 & 131072) != 0) {
                        i22 |= 12582912;
                    } else if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(this)) {
                            i28 = 8388608;
                        } else {
                            i28 = 4194304;
                        }
                        i22 |= i28;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i3111115 = i4;
                        int i3111116 = i3111115 << 3;
                        int i3111117 = i3111115 >> 3;
                        int i3111118 = i3111115 >> 9;
                        int i3111119 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111116 & 896) | (i3111116 & 112) | 6 | (i3111117 & 7168) | (i3111118 & 57344) | (i3111118 & 458752) | (i3111118 & 3670016) | (i3111119 & 29360128) | (234881024 & i3111119) | (i3111119 & 1879048192), ((i22 >> 9) & 14) | ((i3111115 >> 6) & 112) | (i3111115 & 896) | (i3111118 & 7168) | (i3111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i31111110 = i4;
                        int i31111111 = i31111110 << 3;
                        int i31111112 = i31111110 >> 3;
                        int i31111113 = i31111110 >> 9;
                        int i31111114 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111 & 896) | (i31111111 & 112) | 6 | (i31111112 & 7168) | (i31111113 & 57344) | (i31111113 & 458752) | (i31111113 & 3670016) | (i31111114 & 29360128) | (234881024 & i31111114) | (i31111114 & 1879048192), ((i22 >> 9) & 14) | ((i31111110 >> 6) & 112) | (i31111110 & 896) | (i31111113 & 7168) | (i31111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
                }
                i22 |= 3072;
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i6 = 16384;
                    }
                    i22 |= i6;
                }
                if ((i2 & 458752) != 0) {
                    if ((i3 & 32768) == 0) {
                        i29 = 65536;
                    } else {
                        i29 = 65536;
                    }
                    i22 |= i29;
                }
                i26 = i3 & 65536;
                if (i26 != 0) {
                    i22 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i22 |= i27;
                }
                if ((i3 & 131072) != 0) {
                    i22 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i28 = 8388608;
                    } else {
                        i28 = 4194304;
                    }
                    i22 |= i28;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i31111115 = i4;
                    int i31111116 = i31111115 << 3;
                    int i31111117 = i31111115 >> 3;
                    int i31111118 = i31111115 >> 9;
                    int i31111119 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111116 & 896) | (i31111116 & 112) | 6 | (i31111117 & 7168) | (i31111118 & 57344) | (i31111118 & 458752) | (i31111118 & 3670016) | (i31111119 & 29360128) | (234881024 & i31111119) | (i31111119 & 1879048192), ((i22 >> 9) & 14) | ((i31111115 >> 6) & 112) | (i31111115 & 896) | (i31111118 & 7168) | (i31111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i311111110 = i4;
                    int i311111111 = i311111110 << 3;
                    int i311111112 = i311111110 >> 3;
                    int i311111113 = i311111110 >> 9;
                    int i311111114 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111111 & 896) | (i311111111 & 112) | 6 | (i311111112 & 7168) | (i311111113 & 57344) | (i311111113 & 458752) | (i311111113 & 3670016) | (i311111114 & 29360128) | (234881024 & i311111114) | (i311111114 & 1879048192), ((i22 >> 9) & 14) | ((i311111110 >> 6) & 112) | (i311111110 & 896) | (i311111113 & 7168) | (i311111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
            }
            i4 |= 3072;
            i6 = 8192;
            if ((i3 & 16) != 0) {
                i4 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(visualTransformation)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i4 |= i7;
            }
            if ((i3 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(interactionSource)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                    i4 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 128;
                if (i11 != 0) {
                    i4 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 256;
                if (i13 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i4 |= i14;
                }
                i15 = i3 & 512;
                if (i15 != 0) {
                    i4 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i16 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i16 = 268435456;
                    }
                    i4 |= i16;
                }
                i17 = i3 & 1024;
                if (i17 != 0) {
                    i18 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i18 = i2 | i19;
                } else {
                    i18 = i2;
                }
                i20 = i3 & 2048;
                if (i20 != 0) {
                    i18 |= 48;
                } else if ((i2 & 112) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp6)) {
                        i21 = 32;
                    } else {
                        i21 = 16;
                    }
                    i18 |= i21;
                }
                i22 = i18;
                i23 = i3 & 4096;
                if (i23 != 0) {
                    if ((i2 & 896) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                            i24 = 256;
                        } else {
                            i24 = 128;
                        }
                        i22 |= i24;
                    }
                    i25 = i3 & 8192;
                    if (i25 != 0) {
                        if ((i2 & 7168) == 0) {
                            i22 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 2048 : 1024;
                        }
                        if ((i2 & 57344) != 0) {
                            if ((i3 & 16384) == 0) {
                                i6 = 16384;
                            }
                            i22 |= i6;
                        }
                        if ((i2 & 458752) != 0) {
                            if ((i3 & 32768) == 0) {
                                i29 = 65536;
                            } else {
                                i29 = 65536;
                            }
                            i22 |= i29;
                        }
                        i26 = i3 & 65536;
                        if (i26 != 0) {
                            i22 |= 1572864;
                        } else if ((i2 & 3670016) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                                i27 = 1048576;
                            } else {
                                i27 = 524288;
                            }
                            i22 |= i27;
                        }
                        if ((i3 & 131072) != 0) {
                            i22 |= 12582912;
                        } else if ((i2 & 29360128) == 0) {
                            if (composerStartRestartGroup.changed(this)) {
                                i28 = 8388608;
                            } else {
                                i28 = 4194304;
                            }
                            i22 |= i28;
                        }
                        if ((i4 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            } else {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                            }
                            int i311111115 = i4;
                            int i311111116 = i311111115 << 3;
                            int i311111117 = i311111115 >> 3;
                            int i311111118 = i311111115 >> 9;
                            int i311111119 = i22 << 21;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111116 & 896) | (i311111116 & 112) | 6 | (i311111117 & 7168) | (i311111118 & 57344) | (i311111118 & 458752) | (i311111118 & 3670016) | (i311111119 & 29360128) | (234881024 & i311111119) | (i311111119 & 1879048192), ((i22 >> 9) & 14) | ((i311111115 >> 6) & 112) | (i311111115 & 896) | (i311111118 & 7168) | (i311111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp23 = interfaceC0526Fp19;
                            interfaceC0526Fp24 = interfaceC0526Fp20;
                            interfaceC0526Fp25 = interfaceC0526Fp16;
                            interfaceC0526Fp26 = interfaceC0526Fp17;
                            interfaceC0526Fp27 = interfaceC0526Fp18;
                            interfaceC0526Fp28 = interfaceC0526Fp21;
                            interfaceC0526Fp29 = interfaceC0526Fp22;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            } else {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                            }
                            int i3111111110 = i4;
                            int i3111111111 = i3111111110 << 3;
                            int i3111111112 = i3111111110 >> 3;
                            int i3111111113 = i3111111110 >> 9;
                            int i3111111114 = i22 << 21;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111111 & 896) | (i3111111111 & 112) | 6 | (i3111111112 & 7168) | (i3111111113 & 57344) | (i3111111113 & 458752) | (i3111111113 & 3670016) | (i3111111114 & 29360128) | (234881024 & i3111111114) | (i3111111114 & 1879048192), ((i22 >> 9) & 14) | ((i3111111110 >> 6) & 112) | (i3111111110 & 896) | (i3111111113 & 7168) | (i3111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp23 = interfaceC0526Fp19;
                            interfaceC0526Fp24 = interfaceC0526Fp20;
                            interfaceC0526Fp25 = interfaceC0526Fp16;
                            interfaceC0526Fp26 = interfaceC0526Fp17;
                            interfaceC0526Fp27 = interfaceC0526Fp18;
                            interfaceC0526Fp28 = interfaceC0526Fp21;
                            interfaceC0526Fp29 = interfaceC0526Fp22;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
                    }
                    i22 |= 3072;
                    if ((i2 & 57344) != 0) {
                        if ((i3 & 16384) == 0) {
                            i6 = 16384;
                        }
                        i22 |= i6;
                    }
                    if ((i2 & 458752) != 0) {
                        if ((i3 & 32768) == 0) {
                            i29 = 65536;
                        } else {
                            i29 = 65536;
                        }
                        i22 |= i29;
                    }
                    i26 = i3 & 65536;
                    if (i26 != 0) {
                        i22 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i27 = 1048576;
                        } else {
                            i27 = 524288;
                        }
                        i22 |= i27;
                    }
                    if ((i3 & 131072) != 0) {
                        i22 |= 12582912;
                    } else if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(this)) {
                            i28 = 8388608;
                        } else {
                            i28 = 4194304;
                        }
                        i22 |= i28;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i3111111115 = i4;
                        int i3111111116 = i3111111115 << 3;
                        int i3111111117 = i3111111115 >> 3;
                        int i3111111118 = i3111111115 >> 9;
                        int i3111111119 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111116 & 896) | (i3111111116 & 112) | 6 | (i3111111117 & 7168) | (i3111111118 & 57344) | (i3111111118 & 458752) | (i3111111118 & 3670016) | (i3111111119 & 29360128) | (234881024 & i3111111119) | (i3111111119 & 1879048192), ((i22 >> 9) & 14) | ((i3111111115 >> 6) & 112) | (i3111111115 & 896) | (i3111111118 & 7168) | (i3111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i31111111110 = i4;
                        int i31111111111 = i31111111110 << 3;
                        int i31111111112 = i31111111110 >> 3;
                        int i31111111113 = i31111111110 >> 9;
                        int i31111111114 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111111 & 896) | (i31111111111 & 112) | 6 | (i31111111112 & 7168) | (i31111111113 & 57344) | (i31111111113 & 458752) | (i31111111113 & 3670016) | (i31111111114 & 29360128) | (234881024 & i31111111114) | (i31111111114 & 1879048192), ((i22 >> 9) & 14) | ((i31111111110 >> 6) & 112) | (i31111111110 & 896) | (i31111111113 & 7168) | (i31111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
                }
                i22 |= 384;
                i25 = i3 & 8192;
                if (i25 != 0) {
                    if ((i2 & 7168) == 0) {
                        i22 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 2048 : 1024;
                    }
                    if ((i2 & 57344) != 0) {
                        if ((i3 & 16384) == 0) {
                            i6 = 16384;
                        }
                        i22 |= i6;
                    }
                    if ((i2 & 458752) != 0) {
                        if ((i3 & 32768) == 0) {
                            i29 = 65536;
                        } else {
                            i29 = 65536;
                        }
                        i22 |= i29;
                    }
                    i26 = i3 & 65536;
                    if (i26 != 0) {
                        i22 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i27 = 1048576;
                        } else {
                            i27 = 524288;
                        }
                        i22 |= i27;
                    }
                    if ((i3 & 131072) != 0) {
                        i22 |= 12582912;
                    } else if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(this)) {
                            i28 = 8388608;
                        } else {
                            i28 = 4194304;
                        }
                        i22 |= i28;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i31111111115 = i4;
                        int i31111111116 = i31111111115 << 3;
                        int i31111111117 = i31111111115 >> 3;
                        int i31111111118 = i31111111115 >> 9;
                        int i31111111119 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111116 & 896) | (i31111111116 & 112) | 6 | (i31111111117 & 7168) | (i31111111118 & 57344) | (i31111111118 & 458752) | (i31111111118 & 3670016) | (i31111111119 & 29360128) | (234881024 & i31111111119) | (i31111111119 & 1879048192), ((i22 >> 9) & 14) | ((i31111111115 >> 6) & 112) | (i31111111115 & 896) | (i31111111118 & 7168) | (i31111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i311111111110 = i4;
                        int i311111111111 = i311111111110 << 3;
                        int i311111111112 = i311111111110 >> 3;
                        int i311111111113 = i311111111110 >> 9;
                        int i311111111114 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111111111 & 896) | (i311111111111 & 112) | 6 | (i311111111112 & 7168) | (i311111111113 & 57344) | (i311111111113 & 458752) | (i311111111113 & 3670016) | (i311111111114 & 29360128) | (234881024 & i311111111114) | (i311111111114 & 1879048192), ((i22 >> 9) & 14) | ((i311111111110 >> 6) & 112) | (i311111111110 & 896) | (i311111111113 & 7168) | (i311111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
                }
                i22 |= 3072;
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i6 = 16384;
                    }
                    i22 |= i6;
                }
                if ((i2 & 458752) != 0) {
                    if ((i3 & 32768) == 0) {
                        i29 = 65536;
                    } else {
                        i29 = 65536;
                    }
                    i22 |= i29;
                }
                i26 = i3 & 65536;
                if (i26 != 0) {
                    i22 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i22 |= i27;
                }
                if ((i3 & 131072) != 0) {
                    i22 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i28 = 8388608;
                    } else {
                        i28 = 4194304;
                    }
                    i22 |= i28;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i311111111115 = i4;
                    int i311111111116 = i311111111115 << 3;
                    int i311111111117 = i311111111115 >> 3;
                    int i311111111118 = i311111111115 >> 9;
                    int i311111111119 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111111116 & 896) | (i311111111116 & 112) | 6 | (i311111111117 & 7168) | (i311111111118 & 57344) | (i311111111118 & 458752) | (i311111111118 & 3670016) | (i311111111119 & 29360128) | (234881024 & i311111111119) | (i311111111119 & 1879048192), ((i22 >> 9) & 14) | ((i311111111115 >> 6) & 112) | (i311111111115 & 896) | (i311111111118 & 7168) | (i311111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i3111111111110 = i4;
                    int i3111111111111 = i3111111111110 << 3;
                    int i3111111111112 = i3111111111110 >> 3;
                    int i3111111111113 = i3111111111110 >> 9;
                    int i3111111111114 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111111111 & 896) | (i3111111111111 & 112) | 6 | (i3111111111112 & 7168) | (i3111111111113 & 57344) | (i3111111111113 & 458752) | (i3111111111113 & 3670016) | (i3111111111114 & 29360128) | (234881024 & i3111111111114) | (i3111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i3111111111110 >> 6) & 112) | (i3111111111110 & 896) | (i3111111111113 & 7168) | (i3111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
            }
            i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i4 |= i8;
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            i11 = i3 & 128;
            if (i11 != 0) {
                i4 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i4 |= i12;
            }
            i13 = i3 & 256;
            if (i13 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i4 |= i14;
            }
            i15 = i3 & 512;
            if (i15 != 0) {
                i4 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i16 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i16 = 268435456;
                }
                i4 |= i16;
            }
            i17 = i3 & 1024;
            if (i17 != 0) {
                i18 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i19 = 4;
                } else {
                    i19 = 2;
                }
                i18 = i2 | i19;
            } else {
                i18 = i2;
            }
            i20 = i3 & 2048;
            if (i20 != 0) {
                i18 |= 48;
            } else if ((i2 & 112) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp6)) {
                    i21 = 32;
                } else {
                    i21 = 16;
                }
                i18 |= i21;
            }
            i22 = i18;
            i23 = i3 & 4096;
            if (i23 != 0) {
                if ((i2 & 896) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                        i24 = 256;
                    } else {
                        i24 = 128;
                    }
                    i22 |= i24;
                }
                i25 = i3 & 8192;
                if (i25 != 0) {
                    if ((i2 & 7168) == 0) {
                        i22 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 2048 : 1024;
                    }
                    if ((i2 & 57344) != 0) {
                        if ((i3 & 16384) == 0) {
                            i6 = 16384;
                        }
                        i22 |= i6;
                    }
                    if ((i2 & 458752) != 0) {
                        if ((i3 & 32768) == 0) {
                            i29 = 65536;
                        } else {
                            i29 = 65536;
                        }
                        i22 |= i29;
                    }
                    i26 = i3 & 65536;
                    if (i26 != 0) {
                        i22 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i27 = 1048576;
                        } else {
                            i27 = 524288;
                        }
                        i22 |= i27;
                    }
                    if ((i3 & 131072) != 0) {
                        i22 |= 12582912;
                    } else if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(this)) {
                            i28 = 8388608;
                        } else {
                            i28 = 4194304;
                        }
                        i22 |= i28;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i3111111111115 = i4;
                        int i3111111111116 = i3111111111115 << 3;
                        int i3111111111117 = i3111111111115 >> 3;
                        int i3111111111118 = i3111111111115 >> 9;
                        int i3111111111119 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111111116 & 896) | (i3111111111116 & 112) | 6 | (i3111111111117 & 7168) | (i3111111111118 & 57344) | (i3111111111118 & 458752) | (i3111111111118 & 3670016) | (i3111111111119 & 29360128) | (234881024 & i3111111111119) | (i3111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i3111111111115 >> 6) & 112) | (i3111111111115 & 896) | (i3111111111118 & 7168) | (i3111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i31111111111110 = i4;
                        int i31111111111111 = i31111111111110 << 3;
                        int i31111111111112 = i31111111111110 >> 3;
                        int i31111111111113 = i31111111111110 >> 9;
                        int i31111111111114 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111111111 & 896) | (i31111111111111 & 112) | 6 | (i31111111111112 & 7168) | (i31111111111113 & 57344) | (i31111111111113 & 458752) | (i31111111111113 & 3670016) | (i31111111111114 & 29360128) | (234881024 & i31111111111114) | (i31111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i31111111111110 >> 6) & 112) | (i31111111111110 & 896) | (i31111111111113 & 7168) | (i31111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
                }
                i22 |= 3072;
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i6 = 16384;
                    }
                    i22 |= i6;
                }
                if ((i2 & 458752) != 0) {
                    if ((i3 & 32768) == 0) {
                        i29 = 65536;
                    } else {
                        i29 = 65536;
                    }
                    i22 |= i29;
                }
                i26 = i3 & 65536;
                if (i26 != 0) {
                    i22 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i22 |= i27;
                }
                if ((i3 & 131072) != 0) {
                    i22 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i28 = 8388608;
                    } else {
                        i28 = 4194304;
                    }
                    i22 |= i28;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i31111111111115 = i4;
                    int i31111111111116 = i31111111111115 << 3;
                    int i31111111111117 = i31111111111115 >> 3;
                    int i31111111111118 = i31111111111115 >> 9;
                    int i31111111111119 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111111116 & 896) | (i31111111111116 & 112) | 6 | (i31111111111117 & 7168) | (i31111111111118 & 57344) | (i31111111111118 & 458752) | (i31111111111118 & 3670016) | (i31111111111119 & 29360128) | (234881024 & i31111111111119) | (i31111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i31111111111115 >> 6) & 112) | (i31111111111115 & 896) | (i31111111111118 & 7168) | (i31111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i311111111111110 = i4;
                    int i311111111111111 = i311111111111110 << 3;
                    int i311111111111112 = i311111111111110 >> 3;
                    int i311111111111113 = i311111111111110 >> 9;
                    int i311111111111114 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111111111111 & 896) | (i311111111111111 & 112) | 6 | (i311111111111112 & 7168) | (i311111111111113 & 57344) | (i311111111111113 & 458752) | (i311111111111113 & 3670016) | (i311111111111114 & 29360128) | (234881024 & i311111111111114) | (i311111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i311111111111110 >> 6) & 112) | (i311111111111110 & 896) | (i311111111111113 & 7168) | (i311111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
            }
            i22 |= 384;
            i25 = i3 & 8192;
            if (i25 != 0) {
                if ((i2 & 7168) == 0) {
                    i22 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 2048 : 1024;
                }
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i6 = 16384;
                    }
                    i22 |= i6;
                }
                if ((i2 & 458752) != 0) {
                    if ((i3 & 32768) == 0) {
                        i29 = 65536;
                    } else {
                        i29 = 65536;
                    }
                    i22 |= i29;
                }
                i26 = i3 & 65536;
                if (i26 != 0) {
                    i22 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i22 |= i27;
                }
                if ((i3 & 131072) != 0) {
                    i22 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i28 = 8388608;
                    } else {
                        i28 = 4194304;
                    }
                    i22 |= i28;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i311111111111115 = i4;
                    int i311111111111116 = i311111111111115 << 3;
                    int i311111111111117 = i311111111111115 >> 3;
                    int i311111111111118 = i311111111111115 >> 9;
                    int i311111111111119 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111111111116 & 896) | (i311111111111116 & 112) | 6 | (i311111111111117 & 7168) | (i311111111111118 & 57344) | (i311111111111118 & 458752) | (i311111111111118 & 3670016) | (i311111111111119 & 29360128) | (234881024 & i311111111111119) | (i311111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i311111111111115 >> 6) & 112) | (i311111111111115 & 896) | (i311111111111118 & 7168) | (i311111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i3111111111111110 = i4;
                    int i3111111111111111 = i3111111111111110 << 3;
                    int i3111111111111112 = i3111111111111110 >> 3;
                    int i3111111111111113 = i3111111111111110 >> 9;
                    int i3111111111111114 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111111111111 & 896) | (i3111111111111111 & 112) | 6 | (i3111111111111112 & 7168) | (i3111111111111113 & 57344) | (i3111111111111113 & 458752) | (i3111111111111113 & 3670016) | (i3111111111111114 & 29360128) | (234881024 & i3111111111111114) | (i3111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i3111111111111110 >> 6) & 112) | (i3111111111111110 & 896) | (i3111111111111113 & 7168) | (i3111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
            }
            i22 |= 3072;
            if ((i2 & 57344) != 0) {
                if ((i3 & 16384) == 0) {
                    i6 = 16384;
                }
                i22 |= i6;
            }
            if ((i2 & 458752) != 0) {
                if ((i3 & 32768) == 0) {
                    i29 = 65536;
                } else {
                    i29 = 65536;
                }
                i22 |= i29;
            }
            i26 = i3 & 65536;
            if (i26 != 0) {
                i22 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                    i27 = 1048576;
                } else {
                    i27 = 524288;
                }
                i22 |= i27;
            }
            if ((i3 & 131072) != 0) {
                i22 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i28 = 8388608;
                } else {
                    i28 = 4194304;
                }
                i22 |= i28;
            }
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                } else {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                }
                int i3111111111111115 = i4;
                int i3111111111111116 = i3111111111111115 << 3;
                int i3111111111111117 = i3111111111111115 >> 3;
                int i3111111111111118 = i3111111111111115 >> 9;
                int i3111111111111119 = i22 << 21;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111111111116 & 896) | (i3111111111111116 & 112) | 6 | (i3111111111111117 & 7168) | (i3111111111111118 & 57344) | (i3111111111111118 & 458752) | (i3111111111111118 & 3670016) | (i3111111111111119 & 29360128) | (234881024 & i3111111111111119) | (i3111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i3111111111111115 >> 6) & 112) | (i3111111111111115 & 896) | (i3111111111111118 & 7168) | (i3111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp23 = interfaceC0526Fp19;
                interfaceC0526Fp24 = interfaceC0526Fp20;
                interfaceC0526Fp25 = interfaceC0526Fp16;
                interfaceC0526Fp26 = interfaceC0526Fp17;
                interfaceC0526Fp27 = interfaceC0526Fp18;
                interfaceC0526Fp28 = interfaceC0526Fp21;
                interfaceC0526Fp29 = interfaceC0526Fp22;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                } else {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                }
                int i31111111111111110 = i4;
                int i31111111111111111 = i31111111111111110 << 3;
                int i31111111111111112 = i31111111111111110 >> 3;
                int i31111111111111113 = i31111111111111110 >> 9;
                int i31111111111111114 = i22 << 21;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111111111111 & 896) | (i31111111111111111 & 112) | 6 | (i31111111111111112 & 7168) | (i31111111111111113 & 57344) | (i31111111111111113 & 458752) | (i31111111111111113 & 3670016) | (i31111111111111114 & 29360128) | (234881024 & i31111111111111114) | (i31111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i31111111111111110 >> 6) & 112) | (i31111111111111110 & 896) | (i31111111111111113 & 7168) | (i31111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp23 = interfaceC0526Fp19;
                interfaceC0526Fp24 = interfaceC0526Fp20;
                interfaceC0526Fp25 = interfaceC0526Fp16;
                interfaceC0526Fp26 = interfaceC0526Fp17;
                interfaceC0526Fp27 = interfaceC0526Fp18;
                interfaceC0526Fp28 = interfaceC0526Fp21;
                interfaceC0526Fp29 = interfaceC0526Fp22;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
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
            i6 = 8192;
            if ((i3 & 16) != 0) {
                i4 |= 24576;
            } else if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(visualTransformation)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i4 |= i7;
            }
            if ((i3 & 32) != 0) {
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(interactionSource)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                    i4 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 128;
                if (i11 != 0) {
                    i4 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i4 |= i12;
                }
                i13 = i3 & 256;
                if (i13 != 0) {
                    i4 |= 100663296;
                } else if ((i & 234881024) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i4 |= i14;
                }
                i15 = i3 & 512;
                if (i15 != 0) {
                    i4 |= 805306368;
                } else if ((i & 1879048192) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i16 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i16 = 268435456;
                    }
                    i4 |= i16;
                }
                i17 = i3 & 1024;
                if (i17 != 0) {
                    i18 = i2 | 6;
                } else if ((i2 & 14) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i18 = i2 | i19;
                } else {
                    i18 = i2;
                }
                i20 = i3 & 2048;
                if (i20 != 0) {
                    i18 |= 48;
                } else if ((i2 & 112) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp6)) {
                        i21 = 32;
                    } else {
                        i21 = 16;
                    }
                    i18 |= i21;
                }
                i22 = i18;
                i23 = i3 & 4096;
                if (i23 != 0) {
                    if ((i2 & 896) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                            i24 = 256;
                        } else {
                            i24 = 128;
                        }
                        i22 |= i24;
                    }
                    i25 = i3 & 8192;
                    if (i25 != 0) {
                        if ((i2 & 7168) == 0) {
                            i22 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 2048 : 1024;
                        }
                        if ((i2 & 57344) != 0) {
                            if ((i3 & 16384) == 0) {
                                i6 = 16384;
                            }
                            i22 |= i6;
                        }
                        if ((i2 & 458752) != 0) {
                            if ((i3 & 32768) == 0) {
                                i29 = 65536;
                            } else {
                                i29 = 65536;
                            }
                            i22 |= i29;
                        }
                        i26 = i3 & 65536;
                        if (i26 != 0) {
                            i22 |= 1572864;
                        } else if ((i2 & 3670016) == 0) {
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                                i27 = 1048576;
                            } else {
                                i27 = 524288;
                            }
                            i22 |= i27;
                        }
                        if ((i3 & 131072) != 0) {
                            i22 |= 12582912;
                        } else if ((i2 & 29360128) == 0) {
                            if (composerStartRestartGroup.changed(this)) {
                                i28 = 8388608;
                            } else {
                                i28 = 4194304;
                            }
                            i22 |= i28;
                        }
                        if ((i4 & 1533916891) != 306783378) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            } else {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                            }
                            int i31111111111111115 = i4;
                            int i31111111111111116 = i31111111111111115 << 3;
                            int i31111111111111117 = i31111111111111115 >> 3;
                            int i31111111111111118 = i31111111111111115 >> 9;
                            int i31111111111111119 = i22 << 21;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111111111116 & 896) | (i31111111111111116 & 112) | 6 | (i31111111111111117 & 7168) | (i31111111111111118 & 57344) | (i31111111111111118 & 458752) | (i31111111111111118 & 3670016) | (i31111111111111119 & 29360128) | (234881024 & i31111111111111119) | (i31111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i31111111111111115 >> 6) & 112) | (i31111111111111115 & 896) | (i31111111111111118 & 7168) | (i31111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp23 = interfaceC0526Fp19;
                            interfaceC0526Fp24 = interfaceC0526Fp20;
                            interfaceC0526Fp25 = interfaceC0526Fp16;
                            interfaceC0526Fp26 = interfaceC0526Fp17;
                            interfaceC0526Fp27 = interfaceC0526Fp18;
                            interfaceC0526Fp28 = interfaceC0526Fp21;
                            interfaceC0526Fp29 = interfaceC0526Fp22;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            } else {
                                if (i9 != 0) {
                                    z4 = false;
                                } else {
                                    z4 = z3;
                                }
                                if (i11 != 0) {
                                    interfaceC0526Fp10 = null;
                                } else {
                                    interfaceC0526Fp10 = interfaceC0526Fp2;
                                }
                                if (i13 != 0) {
                                    interfaceC0526Fp11 = null;
                                } else {
                                    interfaceC0526Fp11 = interfaceC0526Fp3;
                                }
                                if (i15 != 0) {
                                    interfaceC0526Fp12 = null;
                                } else {
                                    interfaceC0526Fp12 = interfaceC0526Fp4;
                                }
                                if (i17 != 0) {
                                    interfaceC0526Fp13 = null;
                                } else {
                                    interfaceC0526Fp13 = interfaceC0526Fp5;
                                }
                                if (i20 != 0) {
                                    interfaceC0526Fp14 = null;
                                } else {
                                    interfaceC0526Fp14 = interfaceC0526Fp6;
                                }
                                if (i23 != 0) {
                                    interfaceC0526Fp15 = null;
                                } else {
                                    interfaceC0526Fp15 = interfaceC0526Fp7;
                                }
                                if (i25 == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                    i22 &= -57345;
                                } else {
                                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                                }
                                if ((i3 & 32768) != 0) {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    i22 &= -458753;
                                } else {
                                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                                }
                                interfaceC0526Fp16 = interfaceC0526Fp12;
                                if (i26 != 0) {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                                } else {
                                    interfaceC0526Fp17 = interfaceC0526Fp13;
                                    interfaceC0526Fp18 = interfaceC0526Fp14;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                                }
                                interfaceC0526Fp19 = interfaceC0526Fp10;
                                interfaceC0526Fp20 = interfaceC0526Fp11;
                                interfaceC0526Fp21 = interfaceC0526Fp15;
                                z5 = z4;
                                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                                interfaceC0526Fp22 = interfaceC0526Fp31;
                                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                            }
                            int i311111111111111110 = i4;
                            int i311111111111111111 = i311111111111111110 << 3;
                            int i311111111111111112 = i311111111111111110 >> 3;
                            int i311111111111111113 = i311111111111111110 >> 9;
                            int i311111111111111114 = i22 << 21;
                            composer2 = composerStartRestartGroup;
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111111111111111 & 896) | (i311111111111111111 & 112) | 6 | (i311111111111111112 & 7168) | (i311111111111111113 & 57344) | (i311111111111111113 & 458752) | (i311111111111111113 & 3670016) | (i311111111111111114 & 29360128) | (234881024 & i311111111111111114) | (i311111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i311111111111111110 >> 6) & 112) | (i311111111111111110 & 896) | (i311111111111111113 & 7168) | (i311111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z5;
                            interfaceC0526Fp23 = interfaceC0526Fp19;
                            interfaceC0526Fp24 = interfaceC0526Fp20;
                            interfaceC0526Fp25 = interfaceC0526Fp16;
                            interfaceC0526Fp26 = interfaceC0526Fp17;
                            interfaceC0526Fp27 = interfaceC0526Fp18;
                            interfaceC0526Fp28 = interfaceC0526Fp21;
                            interfaceC0526Fp29 = interfaceC0526Fp22;
                            textFieldColors3 = textFieldColors2;
                            paddingValues3 = paddingValues2;
                            interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
                    }
                    i22 |= 3072;
                    if ((i2 & 57344) != 0) {
                        if ((i3 & 16384) == 0) {
                            i6 = 16384;
                        }
                        i22 |= i6;
                    }
                    if ((i2 & 458752) != 0) {
                        if ((i3 & 32768) == 0) {
                            i29 = 65536;
                        } else {
                            i29 = 65536;
                        }
                        i22 |= i29;
                    }
                    i26 = i3 & 65536;
                    if (i26 != 0) {
                        i22 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i27 = 1048576;
                        } else {
                            i27 = 524288;
                        }
                        i22 |= i27;
                    }
                    if ((i3 & 131072) != 0) {
                        i22 |= 12582912;
                    } else if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(this)) {
                            i28 = 8388608;
                        } else {
                            i28 = 4194304;
                        }
                        i22 |= i28;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i311111111111111115 = i4;
                        int i311111111111111116 = i311111111111111115 << 3;
                        int i311111111111111117 = i311111111111111115 >> 3;
                        int i311111111111111118 = i311111111111111115 >> 9;
                        int i311111111111111119 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111111111111116 & 896) | (i311111111111111116 & 112) | 6 | (i311111111111111117 & 7168) | (i311111111111111118 & 57344) | (i311111111111111118 & 458752) | (i311111111111111118 & 3670016) | (i311111111111111119 & 29360128) | (234881024 & i311111111111111119) | (i311111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i311111111111111115 >> 6) & 112) | (i311111111111111115 & 896) | (i311111111111111118 & 7168) | (i311111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i3111111111111111110 = i4;
                        int i3111111111111111111 = i3111111111111111110 << 3;
                        int i3111111111111111112 = i3111111111111111110 >> 3;
                        int i3111111111111111113 = i3111111111111111110 >> 9;
                        int i3111111111111111114 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111111111111111 & 896) | (i3111111111111111111 & 112) | 6 | (i3111111111111111112 & 7168) | (i3111111111111111113 & 57344) | (i3111111111111111113 & 458752) | (i3111111111111111113 & 3670016) | (i3111111111111111114 & 29360128) | (234881024 & i3111111111111111114) | (i3111111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i3111111111111111110 >> 6) & 112) | (i3111111111111111110 & 896) | (i3111111111111111113 & 7168) | (i3111111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
                }
                i22 |= 384;
                i25 = i3 & 8192;
                if (i25 != 0) {
                    if ((i2 & 7168) == 0) {
                        i22 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 2048 : 1024;
                    }
                    if ((i2 & 57344) != 0) {
                        if ((i3 & 16384) == 0) {
                            i6 = 16384;
                        }
                        i22 |= i6;
                    }
                    if ((i2 & 458752) != 0) {
                        if ((i3 & 32768) == 0) {
                            i29 = 65536;
                        } else {
                            i29 = 65536;
                        }
                        i22 |= i29;
                    }
                    i26 = i3 & 65536;
                    if (i26 != 0) {
                        i22 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i27 = 1048576;
                        } else {
                            i27 = 524288;
                        }
                        i22 |= i27;
                    }
                    if ((i3 & 131072) != 0) {
                        i22 |= 12582912;
                    } else if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(this)) {
                            i28 = 8388608;
                        } else {
                            i28 = 4194304;
                        }
                        i22 |= i28;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i3111111111111111115 = i4;
                        int i3111111111111111116 = i3111111111111111115 << 3;
                        int i3111111111111111117 = i3111111111111111115 >> 3;
                        int i3111111111111111118 = i3111111111111111115 >> 9;
                        int i3111111111111111119 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111111111111116 & 896) | (i3111111111111111116 & 112) | 6 | (i3111111111111111117 & 7168) | (i3111111111111111118 & 57344) | (i3111111111111111118 & 458752) | (i3111111111111111118 & 3670016) | (i3111111111111111119 & 29360128) | (234881024 & i3111111111111111119) | (i3111111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i3111111111111111115 >> 6) & 112) | (i3111111111111111115 & 896) | (i3111111111111111118 & 7168) | (i3111111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i31111111111111111110 = i4;
                        int i31111111111111111111 = i31111111111111111110 << 3;
                        int i31111111111111111112 = i31111111111111111110 >> 3;
                        int i31111111111111111113 = i31111111111111111110 >> 9;
                        int i31111111111111111114 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111111111111111 & 896) | (i31111111111111111111 & 112) | 6 | (i31111111111111111112 & 7168) | (i31111111111111111113 & 57344) | (i31111111111111111113 & 458752) | (i31111111111111111113 & 3670016) | (i31111111111111111114 & 29360128) | (234881024 & i31111111111111111114) | (i31111111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i31111111111111111110 >> 6) & 112) | (i31111111111111111110 & 896) | (i31111111111111111113 & 7168) | (i31111111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
                }
                i22 |= 3072;
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i6 = 16384;
                    }
                    i22 |= i6;
                }
                if ((i2 & 458752) != 0) {
                    if ((i3 & 32768) == 0) {
                        i29 = 65536;
                    } else {
                        i29 = 65536;
                    }
                    i22 |= i29;
                }
                i26 = i3 & 65536;
                if (i26 != 0) {
                    i22 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i22 |= i27;
                }
                if ((i3 & 131072) != 0) {
                    i22 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i28 = 8388608;
                    } else {
                        i28 = 4194304;
                    }
                    i22 |= i28;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i31111111111111111115 = i4;
                    int i31111111111111111116 = i31111111111111111115 << 3;
                    int i31111111111111111117 = i31111111111111111115 >> 3;
                    int i31111111111111111118 = i31111111111111111115 >> 9;
                    int i31111111111111111119 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111111111111116 & 896) | (i31111111111111111116 & 112) | 6 | (i31111111111111111117 & 7168) | (i31111111111111111118 & 57344) | (i31111111111111111118 & 458752) | (i31111111111111111118 & 3670016) | (i31111111111111111119 & 29360128) | (234881024 & i31111111111111111119) | (i31111111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i31111111111111111115 >> 6) & 112) | (i31111111111111111115 & 896) | (i31111111111111111118 & 7168) | (i31111111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i311111111111111111110 = i4;
                    int i311111111111111111111 = i311111111111111111110 << 3;
                    int i311111111111111111112 = i311111111111111111110 >> 3;
                    int i311111111111111111113 = i311111111111111111110 >> 9;
                    int i311111111111111111114 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111111111111111111 & 896) | (i311111111111111111111 & 112) | 6 | (i311111111111111111112 & 7168) | (i311111111111111111113 & 57344) | (i311111111111111111113 & 458752) | (i311111111111111111113 & 3670016) | (i311111111111111111114 & 29360128) | (234881024 & i311111111111111111114) | (i311111111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i311111111111111111110 >> 6) & 112) | (i311111111111111111110 & 896) | (i311111111111111111113 & 7168) | (i311111111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
            }
            i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i4 |= i8;
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            i11 = i3 & 128;
            if (i11 != 0) {
                i4 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i4 |= i12;
            }
            i13 = i3 & 256;
            if (i13 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i4 |= i14;
            }
            i15 = i3 & 512;
            if (i15 != 0) {
                i4 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i16 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i16 = 268435456;
                }
                i4 |= i16;
            }
            i17 = i3 & 1024;
            if (i17 != 0) {
                i18 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i19 = 4;
                } else {
                    i19 = 2;
                }
                i18 = i2 | i19;
            } else {
                i18 = i2;
            }
            i20 = i3 & 2048;
            if (i20 != 0) {
                i18 |= 48;
            } else if ((i2 & 112) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp6)) {
                    i21 = 32;
                } else {
                    i21 = 16;
                }
                i18 |= i21;
            }
            i22 = i18;
            i23 = i3 & 4096;
            if (i23 != 0) {
                if ((i2 & 896) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                        i24 = 256;
                    } else {
                        i24 = 128;
                    }
                    i22 |= i24;
                }
                i25 = i3 & 8192;
                if (i25 != 0) {
                    if ((i2 & 7168) == 0) {
                        i22 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 2048 : 1024;
                    }
                    if ((i2 & 57344) != 0) {
                        if ((i3 & 16384) == 0) {
                            i6 = 16384;
                        }
                        i22 |= i6;
                    }
                    if ((i2 & 458752) != 0) {
                        if ((i3 & 32768) == 0) {
                            i29 = 65536;
                        } else {
                            i29 = 65536;
                        }
                        i22 |= i29;
                    }
                    i26 = i3 & 65536;
                    if (i26 != 0) {
                        i22 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i27 = 1048576;
                        } else {
                            i27 = 524288;
                        }
                        i22 |= i27;
                    }
                    if ((i3 & 131072) != 0) {
                        i22 |= 12582912;
                    } else if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(this)) {
                            i28 = 8388608;
                        } else {
                            i28 = 4194304;
                        }
                        i22 |= i28;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i311111111111111111115 = i4;
                        int i311111111111111111116 = i311111111111111111115 << 3;
                        int i311111111111111111117 = i311111111111111111115 >> 3;
                        int i311111111111111111118 = i311111111111111111115 >> 9;
                        int i311111111111111111119 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111111111111111116 & 896) | (i311111111111111111116 & 112) | 6 | (i311111111111111111117 & 7168) | (i311111111111111111118 & 57344) | (i311111111111111111118 & 458752) | (i311111111111111111118 & 3670016) | (i311111111111111111119 & 29360128) | (234881024 & i311111111111111111119) | (i311111111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i311111111111111111115 >> 6) & 112) | (i311111111111111111115 & 896) | (i311111111111111111118 & 7168) | (i311111111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i3111111111111111111110 = i4;
                        int i3111111111111111111111 = i3111111111111111111110 << 3;
                        int i3111111111111111111112 = i3111111111111111111110 >> 3;
                        int i3111111111111111111113 = i3111111111111111111110 >> 9;
                        int i3111111111111111111114 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111111111111111111 & 896) | (i3111111111111111111111 & 112) | 6 | (i3111111111111111111112 & 7168) | (i3111111111111111111113 & 57344) | (i3111111111111111111113 & 458752) | (i3111111111111111111113 & 3670016) | (i3111111111111111111114 & 29360128) | (234881024 & i3111111111111111111114) | (i3111111111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i3111111111111111111110 >> 6) & 112) | (i3111111111111111111110 & 896) | (i3111111111111111111113 & 7168) | (i3111111111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
                }
                i22 |= 3072;
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i6 = 16384;
                    }
                    i22 |= i6;
                }
                if ((i2 & 458752) != 0) {
                    if ((i3 & 32768) == 0) {
                        i29 = 65536;
                    } else {
                        i29 = 65536;
                    }
                    i22 |= i29;
                }
                i26 = i3 & 65536;
                if (i26 != 0) {
                    i22 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i22 |= i27;
                }
                if ((i3 & 131072) != 0) {
                    i22 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i28 = 8388608;
                    } else {
                        i28 = 4194304;
                    }
                    i22 |= i28;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i3111111111111111111115 = i4;
                    int i3111111111111111111116 = i3111111111111111111115 << 3;
                    int i3111111111111111111117 = i3111111111111111111115 >> 3;
                    int i3111111111111111111118 = i3111111111111111111115 >> 9;
                    int i3111111111111111111119 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111111111111111116 & 896) | (i3111111111111111111116 & 112) | 6 | (i3111111111111111111117 & 7168) | (i3111111111111111111118 & 57344) | (i3111111111111111111118 & 458752) | (i3111111111111111111118 & 3670016) | (i3111111111111111111119 & 29360128) | (234881024 & i3111111111111111111119) | (i3111111111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i3111111111111111111115 >> 6) & 112) | (i3111111111111111111115 & 896) | (i3111111111111111111118 & 7168) | (i3111111111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i31111111111111111111110 = i4;
                    int i31111111111111111111111 = i31111111111111111111110 << 3;
                    int i31111111111111111111112 = i31111111111111111111110 >> 3;
                    int i31111111111111111111113 = i31111111111111111111110 >> 9;
                    int i31111111111111111111114 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111111111111111111 & 896) | (i31111111111111111111111 & 112) | 6 | (i31111111111111111111112 & 7168) | (i31111111111111111111113 & 57344) | (i31111111111111111111113 & 458752) | (i31111111111111111111113 & 3670016) | (i31111111111111111111114 & 29360128) | (234881024 & i31111111111111111111114) | (i31111111111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i31111111111111111111110 >> 6) & 112) | (i31111111111111111111110 & 896) | (i31111111111111111111113 & 7168) | (i31111111111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
            }
            i22 |= 384;
            i25 = i3 & 8192;
            if (i25 != 0) {
                if ((i2 & 7168) == 0) {
                    i22 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 2048 : 1024;
                }
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i6 = 16384;
                    }
                    i22 |= i6;
                }
                if ((i2 & 458752) != 0) {
                    if ((i3 & 32768) == 0) {
                        i29 = 65536;
                    } else {
                        i29 = 65536;
                    }
                    i22 |= i29;
                }
                i26 = i3 & 65536;
                if (i26 != 0) {
                    i22 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i22 |= i27;
                }
                if ((i3 & 131072) != 0) {
                    i22 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i28 = 8388608;
                    } else {
                        i28 = 4194304;
                    }
                    i22 |= i28;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i31111111111111111111115 = i4;
                    int i31111111111111111111116 = i31111111111111111111115 << 3;
                    int i31111111111111111111117 = i31111111111111111111115 >> 3;
                    int i31111111111111111111118 = i31111111111111111111115 >> 9;
                    int i31111111111111111111119 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111111111111111116 & 896) | (i31111111111111111111116 & 112) | 6 | (i31111111111111111111117 & 7168) | (i31111111111111111111118 & 57344) | (i31111111111111111111118 & 458752) | (i31111111111111111111118 & 3670016) | (i31111111111111111111119 & 29360128) | (234881024 & i31111111111111111111119) | (i31111111111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i31111111111111111111115 >> 6) & 112) | (i31111111111111111111115 & 896) | (i31111111111111111111118 & 7168) | (i31111111111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i311111111111111111111110 = i4;
                    int i311111111111111111111111 = i311111111111111111111110 << 3;
                    int i311111111111111111111112 = i311111111111111111111110 >> 3;
                    int i311111111111111111111113 = i311111111111111111111110 >> 9;
                    int i311111111111111111111114 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111111111111111111111 & 896) | (i311111111111111111111111 & 112) | 6 | (i311111111111111111111112 & 7168) | (i311111111111111111111113 & 57344) | (i311111111111111111111113 & 458752) | (i311111111111111111111113 & 3670016) | (i311111111111111111111114 & 29360128) | (234881024 & i311111111111111111111114) | (i311111111111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i311111111111111111111110 >> 6) & 112) | (i311111111111111111111110 & 896) | (i311111111111111111111113 & 7168) | (i311111111111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
            }
            i22 |= 3072;
            if ((i2 & 57344) != 0) {
                if ((i3 & 16384) == 0) {
                    i6 = 16384;
                }
                i22 |= i6;
            }
            if ((i2 & 458752) != 0) {
                if ((i3 & 32768) == 0) {
                    i29 = 65536;
                } else {
                    i29 = 65536;
                }
                i22 |= i29;
            }
            i26 = i3 & 65536;
            if (i26 != 0) {
                i22 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                    i27 = 1048576;
                } else {
                    i27 = 524288;
                }
                i22 |= i27;
            }
            if ((i3 & 131072) != 0) {
                i22 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i28 = 8388608;
                } else {
                    i28 = 4194304;
                }
                i22 |= i28;
            }
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                } else {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                }
                int i311111111111111111111115 = i4;
                int i311111111111111111111116 = i311111111111111111111115 << 3;
                int i311111111111111111111117 = i311111111111111111111115 >> 3;
                int i311111111111111111111118 = i311111111111111111111115 >> 9;
                int i311111111111111111111119 = i22 << 21;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111111111111111111116 & 896) | (i311111111111111111111116 & 112) | 6 | (i311111111111111111111117 & 7168) | (i311111111111111111111118 & 57344) | (i311111111111111111111118 & 458752) | (i311111111111111111111118 & 3670016) | (i311111111111111111111119 & 29360128) | (234881024 & i311111111111111111111119) | (i311111111111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i311111111111111111111115 >> 6) & 112) | (i311111111111111111111115 & 896) | (i311111111111111111111118 & 7168) | (i311111111111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp23 = interfaceC0526Fp19;
                interfaceC0526Fp24 = interfaceC0526Fp20;
                interfaceC0526Fp25 = interfaceC0526Fp16;
                interfaceC0526Fp26 = interfaceC0526Fp17;
                interfaceC0526Fp27 = interfaceC0526Fp18;
                interfaceC0526Fp28 = interfaceC0526Fp21;
                interfaceC0526Fp29 = interfaceC0526Fp22;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                } else {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                }
                int i3111111111111111111111110 = i4;
                int i3111111111111111111111111 = i3111111111111111111111110 << 3;
                int i3111111111111111111111112 = i3111111111111111111111110 >> 3;
                int i3111111111111111111111113 = i3111111111111111111111110 >> 9;
                int i3111111111111111111111114 = i22 << 21;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111111111111111111111 & 896) | (i3111111111111111111111111 & 112) | 6 | (i3111111111111111111111112 & 7168) | (i3111111111111111111111113 & 57344) | (i3111111111111111111111113 & 458752) | (i3111111111111111111111113 & 3670016) | (i3111111111111111111111114 & 29360128) | (234881024 & i3111111111111111111111114) | (i3111111111111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i3111111111111111111111110 >> 6) & 112) | (i3111111111111111111111110 & 896) | (i3111111111111111111111113 & 7168) | (i3111111111111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp23 = interfaceC0526Fp19;
                interfaceC0526Fp24 = interfaceC0526Fp20;
                interfaceC0526Fp25 = interfaceC0526Fp16;
                interfaceC0526Fp26 = interfaceC0526Fp17;
                interfaceC0526Fp27 = interfaceC0526Fp18;
                interfaceC0526Fp28 = interfaceC0526Fp21;
                interfaceC0526Fp29 = interfaceC0526Fp22;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
        }
        i4 |= 3072;
        i6 = 8192;
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i & 57344) == 0) {
            if (composerStartRestartGroup.changed(visualTransformation)) {
                i7 = 16384;
            } else {
                i7 = 8192;
            }
            i4 |= i7;
        }
        if ((i3 & 32) != 0) {
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(interactionSource)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
            }
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            i11 = i3 & 128;
            if (i11 != 0) {
                i4 |= 12582912;
            } else if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i4 |= i12;
            }
            i13 = i3 & 256;
            if (i13 != 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i4 |= i14;
            }
            i15 = i3 & 512;
            if (i15 != 0) {
                i4 |= 805306368;
            } else if ((i & 1879048192) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i16 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i16 = 268435456;
                }
                i4 |= i16;
            }
            i17 = i3 & 1024;
            if (i17 != 0) {
                i18 = i2 | 6;
            } else if ((i2 & 14) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                    i19 = 4;
                } else {
                    i19 = 2;
                }
                i18 = i2 | i19;
            } else {
                i18 = i2;
            }
            i20 = i3 & 2048;
            if (i20 != 0) {
                i18 |= 48;
            } else if ((i2 & 112) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp6)) {
                    i21 = 32;
                } else {
                    i21 = 16;
                }
                i18 |= i21;
            }
            i22 = i18;
            i23 = i3 & 4096;
            if (i23 != 0) {
                if ((i2 & 896) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                        i24 = 256;
                    } else {
                        i24 = 128;
                    }
                    i22 |= i24;
                }
                i25 = i3 & 8192;
                if (i25 != 0) {
                    if ((i2 & 7168) == 0) {
                        i22 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 2048 : 1024;
                    }
                    if ((i2 & 57344) != 0) {
                        if ((i3 & 16384) == 0) {
                            i6 = 16384;
                        }
                        i22 |= i6;
                    }
                    if ((i2 & 458752) != 0) {
                        if ((i3 & 32768) == 0) {
                            i29 = 65536;
                        } else {
                            i29 = 65536;
                        }
                        i22 |= i29;
                    }
                    i26 = i3 & 65536;
                    if (i26 != 0) {
                        i22 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                            i27 = 1048576;
                        } else {
                            i27 = 524288;
                        }
                        i22 |= i27;
                    }
                    if ((i3 & 131072) != 0) {
                        i22 |= 12582912;
                    } else if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(this)) {
                            i28 = 8388608;
                        } else {
                            i28 = 4194304;
                        }
                        i22 |= i28;
                    }
                    if ((i4 & 1533916891) != 306783378) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i3111111111111111111111115 = i4;
                        int i3111111111111111111111116 = i3111111111111111111111115 << 3;
                        int i3111111111111111111111117 = i3111111111111111111111115 >> 3;
                        int i3111111111111111111111118 = i3111111111111111111111115 >> 9;
                        int i3111111111111111111111119 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111111111111111111116 & 896) | (i3111111111111111111111116 & 112) | 6 | (i3111111111111111111111117 & 7168) | (i3111111111111111111111118 & 57344) | (i3111111111111111111111118 & 458752) | (i3111111111111111111111118 & 3670016) | (i3111111111111111111111119 & 29360128) | (234881024 & i3111111111111111111111119) | (i3111111111111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i3111111111111111111111115 >> 6) & 112) | (i3111111111111111111111115 & 896) | (i3111111111111111111111118 & 7168) | (i3111111111111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        } else {
                            if (i9 != 0) {
                                z4 = false;
                            } else {
                                z4 = z3;
                            }
                            if (i11 != 0) {
                                interfaceC0526Fp10 = null;
                            } else {
                                interfaceC0526Fp10 = interfaceC0526Fp2;
                            }
                            if (i13 != 0) {
                                interfaceC0526Fp11 = null;
                            } else {
                                interfaceC0526Fp11 = interfaceC0526Fp3;
                            }
                            if (i15 != 0) {
                                interfaceC0526Fp12 = null;
                            } else {
                                interfaceC0526Fp12 = interfaceC0526Fp4;
                            }
                            if (i17 != 0) {
                                interfaceC0526Fp13 = null;
                            } else {
                                interfaceC0526Fp13 = interfaceC0526Fp5;
                            }
                            if (i20 != 0) {
                                interfaceC0526Fp14 = null;
                            } else {
                                interfaceC0526Fp14 = interfaceC0526Fp6;
                            }
                            if (i23 != 0) {
                                interfaceC0526Fp15 = null;
                            } else {
                                interfaceC0526Fp15 = interfaceC0526Fp7;
                            }
                            if (i25 == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                                textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                                i22 &= -57345;
                            } else {
                                textFieldColorsM1686colors0hiis_0 = textFieldColors;
                            }
                            if ((i3 & 32768) != 0) {
                                paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                i22 &= -458753;
                            } else {
                                paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                            }
                            interfaceC0526Fp16 = interfaceC0526Fp12;
                            if (i26 != 0) {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                            } else {
                                interfaceC0526Fp17 = interfaceC0526Fp13;
                                interfaceC0526Fp18 = interfaceC0526Fp14;
                                interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                            }
                            interfaceC0526Fp19 = interfaceC0526Fp10;
                            interfaceC0526Fp20 = interfaceC0526Fp11;
                            interfaceC0526Fp21 = interfaceC0526Fp15;
                            z5 = z4;
                            textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                            interfaceC0526Fp22 = interfaceC0526Fp31;
                            paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                        }
                        int i31111111111111111111111110 = i4;
                        int i31111111111111111111111111 = i31111111111111111111111110 << 3;
                        int i31111111111111111111111112 = i31111111111111111111111110 >> 3;
                        int i31111111111111111111111113 = i31111111111111111111111110 >> 9;
                        int i31111111111111111111111114 = i22 << 21;
                        composer2 = composerStartRestartGroup;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111111111111111111111 & 896) | (i31111111111111111111111111 & 112) | 6 | (i31111111111111111111111112 & 7168) | (i31111111111111111111111113 & 57344) | (i31111111111111111111111113 & 458752) | (i31111111111111111111111113 & 3670016) | (i31111111111111111111111114 & 29360128) | (234881024 & i31111111111111111111111114) | (i31111111111111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i31111111111111111111111110 >> 6) & 112) | (i31111111111111111111111110 & 896) | (i31111111111111111111111113 & 7168) | (i31111111111111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z5;
                        interfaceC0526Fp23 = interfaceC0526Fp19;
                        interfaceC0526Fp24 = interfaceC0526Fp20;
                        interfaceC0526Fp25 = interfaceC0526Fp16;
                        interfaceC0526Fp26 = interfaceC0526Fp17;
                        interfaceC0526Fp27 = interfaceC0526Fp18;
                        interfaceC0526Fp28 = interfaceC0526Fp21;
                        interfaceC0526Fp29 = interfaceC0526Fp22;
                        textFieldColors3 = textFieldColors2;
                        paddingValues3 = paddingValues2;
                        interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
                }
                i22 |= 3072;
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i6 = 16384;
                    }
                    i22 |= i6;
                }
                if ((i2 & 458752) != 0) {
                    if ((i3 & 32768) == 0) {
                        i29 = 65536;
                    } else {
                        i29 = 65536;
                    }
                    i22 |= i29;
                }
                i26 = i3 & 65536;
                if (i26 != 0) {
                    i22 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i22 |= i27;
                }
                if ((i3 & 131072) != 0) {
                    i22 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i28 = 8388608;
                    } else {
                        i28 = 4194304;
                    }
                    i22 |= i28;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i31111111111111111111111115 = i4;
                    int i31111111111111111111111116 = i31111111111111111111111115 << 3;
                    int i31111111111111111111111117 = i31111111111111111111111115 >> 3;
                    int i31111111111111111111111118 = i31111111111111111111111115 >> 9;
                    int i31111111111111111111111119 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111111111111111111116 & 896) | (i31111111111111111111111116 & 112) | 6 | (i31111111111111111111111117 & 7168) | (i31111111111111111111111118 & 57344) | (i31111111111111111111111118 & 458752) | (i31111111111111111111111118 & 3670016) | (i31111111111111111111111119 & 29360128) | (234881024 & i31111111111111111111111119) | (i31111111111111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i31111111111111111111111115 >> 6) & 112) | (i31111111111111111111111115 & 896) | (i31111111111111111111111118 & 7168) | (i31111111111111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i311111111111111111111111110 = i4;
                    int i311111111111111111111111111 = i311111111111111111111111110 << 3;
                    int i311111111111111111111111112 = i311111111111111111111111110 >> 3;
                    int i311111111111111111111111113 = i311111111111111111111111110 >> 9;
                    int i311111111111111111111111114 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111111111111111111111111 & 896) | (i311111111111111111111111111 & 112) | 6 | (i311111111111111111111111112 & 7168) | (i311111111111111111111111113 & 57344) | (i311111111111111111111111113 & 458752) | (i311111111111111111111111113 & 3670016) | (i311111111111111111111111114 & 29360128) | (234881024 & i311111111111111111111111114) | (i311111111111111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i311111111111111111111111110 >> 6) & 112) | (i311111111111111111111111110 & 896) | (i311111111111111111111111113 & 7168) | (i311111111111111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
            }
            i22 |= 384;
            i25 = i3 & 8192;
            if (i25 != 0) {
                if ((i2 & 7168) == 0) {
                    i22 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 2048 : 1024;
                }
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i6 = 16384;
                    }
                    i22 |= i6;
                }
                if ((i2 & 458752) != 0) {
                    if ((i3 & 32768) == 0) {
                        i29 = 65536;
                    } else {
                        i29 = 65536;
                    }
                    i22 |= i29;
                }
                i26 = i3 & 65536;
                if (i26 != 0) {
                    i22 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i22 |= i27;
                }
                if ((i3 & 131072) != 0) {
                    i22 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i28 = 8388608;
                    } else {
                        i28 = 4194304;
                    }
                    i22 |= i28;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i311111111111111111111111115 = i4;
                    int i311111111111111111111111116 = i311111111111111111111111115 << 3;
                    int i311111111111111111111111117 = i311111111111111111111111115 >> 3;
                    int i311111111111111111111111118 = i311111111111111111111111115 >> 9;
                    int i311111111111111111111111119 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111111111111111111111116 & 896) | (i311111111111111111111111116 & 112) | 6 | (i311111111111111111111111117 & 7168) | (i311111111111111111111111118 & 57344) | (i311111111111111111111111118 & 458752) | (i311111111111111111111111118 & 3670016) | (i311111111111111111111111119 & 29360128) | (234881024 & i311111111111111111111111119) | (i311111111111111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i311111111111111111111111115 >> 6) & 112) | (i311111111111111111111111115 & 896) | (i311111111111111111111111118 & 7168) | (i311111111111111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i3111111111111111111111111110 = i4;
                    int i3111111111111111111111111111 = i3111111111111111111111111110 << 3;
                    int i3111111111111111111111111112 = i3111111111111111111111111110 >> 3;
                    int i3111111111111111111111111113 = i3111111111111111111111111110 >> 9;
                    int i3111111111111111111111111114 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111111111111111111111111 & 896) | (i3111111111111111111111111111 & 112) | 6 | (i3111111111111111111111111112 & 7168) | (i3111111111111111111111111113 & 57344) | (i3111111111111111111111111113 & 458752) | (i3111111111111111111111111113 & 3670016) | (i3111111111111111111111111114 & 29360128) | (234881024 & i3111111111111111111111111114) | (i3111111111111111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i3111111111111111111111111110 >> 6) & 112) | (i3111111111111111111111111110 & 896) | (i3111111111111111111111111113 & 7168) | (i3111111111111111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
            }
            i22 |= 3072;
            if ((i2 & 57344) != 0) {
                if ((i3 & 16384) == 0) {
                    i6 = 16384;
                }
                i22 |= i6;
            }
            if ((i2 & 458752) != 0) {
                if ((i3 & 32768) == 0) {
                    i29 = 65536;
                } else {
                    i29 = 65536;
                }
                i22 |= i29;
            }
            i26 = i3 & 65536;
            if (i26 != 0) {
                i22 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                    i27 = 1048576;
                } else {
                    i27 = 524288;
                }
                i22 |= i27;
            }
            if ((i3 & 131072) != 0) {
                i22 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i28 = 8388608;
                } else {
                    i28 = 4194304;
                }
                i22 |= i28;
            }
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                } else {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                }
                int i3111111111111111111111111115 = i4;
                int i3111111111111111111111111116 = i3111111111111111111111111115 << 3;
                int i3111111111111111111111111117 = i3111111111111111111111111115 >> 3;
                int i3111111111111111111111111118 = i3111111111111111111111111115 >> 9;
                int i3111111111111111111111111119 = i22 << 21;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111111111111111111111116 & 896) | (i3111111111111111111111111116 & 112) | 6 | (i3111111111111111111111111117 & 7168) | (i3111111111111111111111111118 & 57344) | (i3111111111111111111111111118 & 458752) | (i3111111111111111111111111118 & 3670016) | (i3111111111111111111111111119 & 29360128) | (234881024 & i3111111111111111111111111119) | (i3111111111111111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i3111111111111111111111111115 >> 6) & 112) | (i3111111111111111111111111115 & 896) | (i3111111111111111111111111118 & 7168) | (i3111111111111111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp23 = interfaceC0526Fp19;
                interfaceC0526Fp24 = interfaceC0526Fp20;
                interfaceC0526Fp25 = interfaceC0526Fp16;
                interfaceC0526Fp26 = interfaceC0526Fp17;
                interfaceC0526Fp27 = interfaceC0526Fp18;
                interfaceC0526Fp28 = interfaceC0526Fp21;
                interfaceC0526Fp29 = interfaceC0526Fp22;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                } else {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                }
                int i31111111111111111111111111110 = i4;
                int i31111111111111111111111111111 = i31111111111111111111111111110 << 3;
                int i31111111111111111111111111112 = i31111111111111111111111111110 >> 3;
                int i31111111111111111111111111113 = i31111111111111111111111111110 >> 9;
                int i31111111111111111111111111114 = i22 << 21;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111111111111111111111111 & 896) | (i31111111111111111111111111111 & 112) | 6 | (i31111111111111111111111111112 & 7168) | (i31111111111111111111111111113 & 57344) | (i31111111111111111111111111113 & 458752) | (i31111111111111111111111111113 & 3670016) | (i31111111111111111111111111114 & 29360128) | (234881024 & i31111111111111111111111111114) | (i31111111111111111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i31111111111111111111111111110 >> 6) & 112) | (i31111111111111111111111111110 & 896) | (i31111111111111111111111111113 & 7168) | (i31111111111111111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp23 = interfaceC0526Fp19;
                interfaceC0526Fp24 = interfaceC0526Fp20;
                interfaceC0526Fp25 = interfaceC0526Fp16;
                interfaceC0526Fp26 = interfaceC0526Fp17;
                interfaceC0526Fp27 = interfaceC0526Fp18;
                interfaceC0526Fp28 = interfaceC0526Fp21;
                interfaceC0526Fp29 = interfaceC0526Fp22;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
        }
        i8 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i4 |= i8;
        i9 = i3 & 64;
        if (i9 != 0) {
            i4 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(z3)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i4 |= i10;
        }
        i11 = i3 & 128;
        if (i11 != 0) {
            i4 |= 12582912;
        } else if ((i & 29360128) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp2)) {
                i12 = 8388608;
            } else {
                i12 = 4194304;
            }
            i4 |= i12;
        }
        i13 = i3 & 256;
        if (i13 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                i14 = 67108864;
            } else {
                i14 = 33554432;
            }
            i4 |= i14;
        }
        i15 = i3 & 512;
        if (i15 != 0) {
            i4 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                i16 = PropertyOptions.DELETE_EXISTING;
            } else {
                i16 = 268435456;
            }
            i4 |= i16;
        }
        i17 = i3 & 1024;
        if (i17 != 0) {
            i18 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp5)) {
                i19 = 4;
            } else {
                i19 = 2;
            }
            i18 = i2 | i19;
        } else {
            i18 = i2;
        }
        i20 = i3 & 2048;
        if (i20 != 0) {
            i18 |= 48;
        } else if ((i2 & 112) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp6)) {
                i21 = 32;
            } else {
                i21 = 16;
            }
            i18 |= i21;
        }
        i22 = i18;
        i23 = i3 & 4096;
        if (i23 != 0) {
            if ((i2 & 896) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp7)) {
                    i24 = 256;
                } else {
                    i24 = 128;
                }
                i22 |= i24;
            }
            i25 = i3 & 8192;
            if (i25 != 0) {
                if ((i2 & 7168) == 0) {
                    i22 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 2048 : 1024;
                }
                if ((i2 & 57344) != 0) {
                    if ((i3 & 16384) == 0) {
                        i6 = 16384;
                    }
                    i22 |= i6;
                }
                if ((i2 & 458752) != 0) {
                    if ((i3 & 32768) == 0) {
                        i29 = 65536;
                    } else {
                        i29 = 65536;
                    }
                    i22 |= i29;
                }
                i26 = i3 & 65536;
                if (i26 != 0) {
                    i22 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                        i27 = 1048576;
                    } else {
                        i27 = 524288;
                    }
                    i22 |= i27;
                }
                if ((i3 & 131072) != 0) {
                    i22 |= 12582912;
                } else if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i28 = 8388608;
                    } else {
                        i28 = 4194304;
                    }
                    i22 |= i28;
                }
                if ((i4 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i31111111111111111111111111115 = i4;
                    int i31111111111111111111111111116 = i31111111111111111111111111115 << 3;
                    int i31111111111111111111111111117 = i31111111111111111111111111115 >> 3;
                    int i31111111111111111111111111118 = i31111111111111111111111111115 >> 9;
                    int i31111111111111111111111111119 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111111111111111111111116 & 896) | (i31111111111111111111111111116 & 112) | 6 | (i31111111111111111111111111117 & 7168) | (i31111111111111111111111111118 & 57344) | (i31111111111111111111111111118 & 458752) | (i31111111111111111111111111118 & 3670016) | (i31111111111111111111111111119 & 29360128) | (234881024 & i31111111111111111111111111119) | (i31111111111111111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i31111111111111111111111111115 >> 6) & 112) | (i31111111111111111111111111115 & 896) | (i31111111111111111111111111118 & 7168) | (i31111111111111111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    } else {
                        if (i9 != 0) {
                            z4 = false;
                        } else {
                            z4 = z3;
                        }
                        if (i11 != 0) {
                            interfaceC0526Fp10 = null;
                        } else {
                            interfaceC0526Fp10 = interfaceC0526Fp2;
                        }
                        if (i13 != 0) {
                            interfaceC0526Fp11 = null;
                        } else {
                            interfaceC0526Fp11 = interfaceC0526Fp3;
                        }
                        if (i15 != 0) {
                            interfaceC0526Fp12 = null;
                        } else {
                            interfaceC0526Fp12 = interfaceC0526Fp4;
                        }
                        if (i17 != 0) {
                            interfaceC0526Fp13 = null;
                        } else {
                            interfaceC0526Fp13 = interfaceC0526Fp5;
                        }
                        if (i20 != 0) {
                            interfaceC0526Fp14 = null;
                        } else {
                            interfaceC0526Fp14 = interfaceC0526Fp6;
                        }
                        if (i23 != 0) {
                            interfaceC0526Fp15 = null;
                        } else {
                            interfaceC0526Fp15 = interfaceC0526Fp7;
                        }
                        if (i25 == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                            textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                            i22 &= -57345;
                        } else {
                            textFieldColorsM1686colors0hiis_0 = textFieldColors;
                        }
                        if ((i3 & 32768) != 0) {
                            paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                            i22 &= -458753;
                        } else {
                            paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                        }
                        interfaceC0526Fp16 = interfaceC0526Fp12;
                        if (i26 != 0) {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                        } else {
                            interfaceC0526Fp17 = interfaceC0526Fp13;
                            interfaceC0526Fp18 = interfaceC0526Fp14;
                            interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                        }
                        interfaceC0526Fp19 = interfaceC0526Fp10;
                        interfaceC0526Fp20 = interfaceC0526Fp11;
                        interfaceC0526Fp21 = interfaceC0526Fp15;
                        z5 = z4;
                        textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                        interfaceC0526Fp22 = interfaceC0526Fp31;
                        paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                    }
                    int i311111111111111111111111111110 = i4;
                    int i311111111111111111111111111111 = i311111111111111111111111111110 << 3;
                    int i311111111111111111111111111112 = i311111111111111111111111111110 >> 3;
                    int i311111111111111111111111111113 = i311111111111111111111111111110 >> 9;
                    int i311111111111111111111111111114 = i22 << 21;
                    composer2 = composerStartRestartGroup;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111111111111111111111111111 & 896) | (i311111111111111111111111111111 & 112) | 6 | (i311111111111111111111111111112 & 7168) | (i311111111111111111111111111113 & 57344) | (i311111111111111111111111111113 & 458752) | (i311111111111111111111111111113 & 3670016) | (i311111111111111111111111111114 & 29360128) | (234881024 & i311111111111111111111111111114) | (i311111111111111111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i311111111111111111111111111110 >> 6) & 112) | (i311111111111111111111111111110 & 896) | (i311111111111111111111111111113 & 7168) | (i311111111111111111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z5;
                    interfaceC0526Fp23 = interfaceC0526Fp19;
                    interfaceC0526Fp24 = interfaceC0526Fp20;
                    interfaceC0526Fp25 = interfaceC0526Fp16;
                    interfaceC0526Fp26 = interfaceC0526Fp17;
                    interfaceC0526Fp27 = interfaceC0526Fp18;
                    interfaceC0526Fp28 = interfaceC0526Fp21;
                    interfaceC0526Fp29 = interfaceC0526Fp22;
                    textFieldColors3 = textFieldColors2;
                    paddingValues3 = paddingValues2;
                    interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
            }
            i22 |= 3072;
            if ((i2 & 57344) != 0) {
                if ((i3 & 16384) == 0) {
                    i6 = 16384;
                }
                i22 |= i6;
            }
            if ((i2 & 458752) != 0) {
                if ((i3 & 32768) == 0) {
                    i29 = 65536;
                } else {
                    i29 = 65536;
                }
                i22 |= i29;
            }
            i26 = i3 & 65536;
            if (i26 != 0) {
                i22 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                    i27 = 1048576;
                } else {
                    i27 = 524288;
                }
                i22 |= i27;
            }
            if ((i3 & 131072) != 0) {
                i22 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i28 = 8388608;
                } else {
                    i28 = 4194304;
                }
                i22 |= i28;
            }
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                } else {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                }
                int i311111111111111111111111111115 = i4;
                int i311111111111111111111111111116 = i311111111111111111111111111115 << 3;
                int i311111111111111111111111111117 = i311111111111111111111111111115 >> 3;
                int i311111111111111111111111111118 = i311111111111111111111111111115 >> 9;
                int i311111111111111111111111111119 = i22 << 21;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111111111111111111111111116 & 896) | (i311111111111111111111111111116 & 112) | 6 | (i311111111111111111111111111117 & 7168) | (i311111111111111111111111111118 & 57344) | (i311111111111111111111111111118 & 458752) | (i311111111111111111111111111118 & 3670016) | (i311111111111111111111111111119 & 29360128) | (234881024 & i311111111111111111111111111119) | (i311111111111111111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i311111111111111111111111111115 >> 6) & 112) | (i311111111111111111111111111115 & 896) | (i311111111111111111111111111118 & 7168) | (i311111111111111111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp23 = interfaceC0526Fp19;
                interfaceC0526Fp24 = interfaceC0526Fp20;
                interfaceC0526Fp25 = interfaceC0526Fp16;
                interfaceC0526Fp26 = interfaceC0526Fp17;
                interfaceC0526Fp27 = interfaceC0526Fp18;
                interfaceC0526Fp28 = interfaceC0526Fp21;
                interfaceC0526Fp29 = interfaceC0526Fp22;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                } else {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                }
                int i3111111111111111111111111111110 = i4;
                int i3111111111111111111111111111111 = i3111111111111111111111111111110 << 3;
                int i3111111111111111111111111111112 = i3111111111111111111111111111110 >> 3;
                int i3111111111111111111111111111113 = i3111111111111111111111111111110 >> 9;
                int i3111111111111111111111111111114 = i22 << 21;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111111111111111111111111111 & 896) | (i3111111111111111111111111111111 & 112) | 6 | (i3111111111111111111111111111112 & 7168) | (i3111111111111111111111111111113 & 57344) | (i3111111111111111111111111111113 & 458752) | (i3111111111111111111111111111113 & 3670016) | (i3111111111111111111111111111114 & 29360128) | (234881024 & i3111111111111111111111111111114) | (i3111111111111111111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i3111111111111111111111111111110 >> 6) & 112) | (i3111111111111111111111111111110 & 896) | (i3111111111111111111111111111113 & 7168) | (i3111111111111111111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp23 = interfaceC0526Fp19;
                interfaceC0526Fp24 = interfaceC0526Fp20;
                interfaceC0526Fp25 = interfaceC0526Fp16;
                interfaceC0526Fp26 = interfaceC0526Fp17;
                interfaceC0526Fp27 = interfaceC0526Fp18;
                interfaceC0526Fp28 = interfaceC0526Fp21;
                interfaceC0526Fp29 = interfaceC0526Fp22;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
        }
        i22 |= 384;
        i25 = i3 & 8192;
        if (i25 != 0) {
            if ((i2 & 7168) == 0) {
                i22 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp8) ? 2048 : 1024;
            }
            if ((i2 & 57344) != 0) {
                if ((i3 & 16384) == 0) {
                    i6 = 16384;
                }
                i22 |= i6;
            }
            if ((i2 & 458752) != 0) {
                if ((i3 & 32768) == 0) {
                    i29 = 65536;
                } else {
                    i29 = 65536;
                }
                i22 |= i29;
            }
            i26 = i3 & 65536;
            if (i26 != 0) {
                i22 |= 1572864;
            } else if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                    i27 = 1048576;
                } else {
                    i27 = 524288;
                }
                i22 |= i27;
            }
            if ((i3 & 131072) != 0) {
                i22 |= 12582912;
            } else if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i28 = 8388608;
                } else {
                    i28 = 4194304;
                }
                i22 |= i28;
            }
            if ((i4 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                } else {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                }
                int i3111111111111111111111111111115 = i4;
                int i3111111111111111111111111111116 = i3111111111111111111111111111115 << 3;
                int i3111111111111111111111111111117 = i3111111111111111111111111111115 >> 3;
                int i3111111111111111111111111111118 = i3111111111111111111111111111115 >> 9;
                int i3111111111111111111111111111119 = i22 << 21;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i3111111111111111111111111111116 & 896) | (i3111111111111111111111111111116 & 112) | 6 | (i3111111111111111111111111111117 & 7168) | (i3111111111111111111111111111118 & 57344) | (i3111111111111111111111111111118 & 458752) | (i3111111111111111111111111111118 & 3670016) | (i3111111111111111111111111111119 & 29360128) | (234881024 & i3111111111111111111111111111119) | (i3111111111111111111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i3111111111111111111111111111115 >> 6) & 112) | (i3111111111111111111111111111115 & 896) | (i3111111111111111111111111111118 & 7168) | (i3111111111111111111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp23 = interfaceC0526Fp19;
                interfaceC0526Fp24 = interfaceC0526Fp20;
                interfaceC0526Fp25 = interfaceC0526Fp16;
                interfaceC0526Fp26 = interfaceC0526Fp17;
                interfaceC0526Fp27 = interfaceC0526Fp18;
                interfaceC0526Fp28 = interfaceC0526Fp21;
                interfaceC0526Fp29 = interfaceC0526Fp22;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                } else {
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z3;
                    }
                    if (i11 != 0) {
                        interfaceC0526Fp10 = null;
                    } else {
                        interfaceC0526Fp10 = interfaceC0526Fp2;
                    }
                    if (i13 != 0) {
                        interfaceC0526Fp11 = null;
                    } else {
                        interfaceC0526Fp11 = interfaceC0526Fp3;
                    }
                    if (i15 != 0) {
                        interfaceC0526Fp12 = null;
                    } else {
                        interfaceC0526Fp12 = interfaceC0526Fp4;
                    }
                    if (i17 != 0) {
                        interfaceC0526Fp13 = null;
                    } else {
                        interfaceC0526Fp13 = interfaceC0526Fp5;
                    }
                    if (i20 != 0) {
                        interfaceC0526Fp14 = null;
                    } else {
                        interfaceC0526Fp14 = interfaceC0526Fp6;
                    }
                    if (i23 != 0) {
                        interfaceC0526Fp15 = null;
                    } else {
                        interfaceC0526Fp15 = interfaceC0526Fp7;
                    }
                    if (i25 == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                        textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                        i22 &= -57345;
                    } else {
                        textFieldColorsM1686colors0hiis_0 = textFieldColors;
                    }
                    if ((i3 & 32768) != 0) {
                        paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                        i22 &= -458753;
                    } else {
                        paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                    }
                    interfaceC0526Fp16 = interfaceC0526Fp12;
                    if (i26 != 0) {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                    } else {
                        interfaceC0526Fp17 = interfaceC0526Fp13;
                        interfaceC0526Fp18 = interfaceC0526Fp14;
                        interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                    }
                    interfaceC0526Fp19 = interfaceC0526Fp10;
                    interfaceC0526Fp20 = interfaceC0526Fp11;
                    interfaceC0526Fp21 = interfaceC0526Fp15;
                    z5 = z4;
                    textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                    interfaceC0526Fp22 = interfaceC0526Fp31;
                    paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
                }
                int i31111111111111111111111111111110 = i4;
                int i31111111111111111111111111111111 = i31111111111111111111111111111110 << 3;
                int i31111111111111111111111111111112 = i31111111111111111111111111111110 >> 3;
                int i31111111111111111111111111111113 = i31111111111111111111111111111110 >> 9;
                int i31111111111111111111111111111114 = i22 << 21;
                composer2 = composerStartRestartGroup;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111111111111111111111111111 & 896) | (i31111111111111111111111111111111 & 112) | 6 | (i31111111111111111111111111111112 & 7168) | (i31111111111111111111111111111113 & 57344) | (i31111111111111111111111111111113 & 458752) | (i31111111111111111111111111111113 & 3670016) | (i31111111111111111111111111111114 & 29360128) | (234881024 & i31111111111111111111111111111114) | (i31111111111111111111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i31111111111111111111111111111110 >> 6) & 112) | (i31111111111111111111111111111110 & 896) | (i31111111111111111111111111111113 & 7168) | (i31111111111111111111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z5;
                interfaceC0526Fp23 = interfaceC0526Fp19;
                interfaceC0526Fp24 = interfaceC0526Fp20;
                interfaceC0526Fp25 = interfaceC0526Fp16;
                interfaceC0526Fp26 = interfaceC0526Fp17;
                interfaceC0526Fp27 = interfaceC0526Fp18;
                interfaceC0526Fp28 = interfaceC0526Fp21;
                interfaceC0526Fp29 = interfaceC0526Fp22;
                textFieldColors3 = textFieldColors2;
                paddingValues3 = paddingValues2;
                interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
        }
        i22 |= 3072;
        if ((i2 & 57344) != 0) {
            if ((i3 & 16384) == 0) {
                i6 = 16384;
            }
            i22 |= i6;
        }
        if ((i2 & 458752) != 0) {
            if ((i3 & 32768) == 0) {
                i29 = 65536;
            } else {
                i29 = 65536;
            }
            i22 |= i29;
        }
        i26 = i3 & 65536;
        if (i26 != 0) {
            i22 |= 1572864;
        } else if ((i2 & 3670016) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp9)) {
                i27 = 1048576;
            } else {
                i27 = 524288;
            }
            i22 |= i27;
        }
        if ((i3 & 131072) != 0) {
            i22 |= 12582912;
        } else if ((i2 & 29360128) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i28 = 8388608;
            } else {
                i28 = 4194304;
            }
            i22 |= i28;
        }
        if ((i4 & 1533916891) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    z4 = false;
                } else {
                    z4 = z3;
                }
                if (i11 != 0) {
                    interfaceC0526Fp10 = null;
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp2;
                }
                if (i13 != 0) {
                    interfaceC0526Fp11 = null;
                } else {
                    interfaceC0526Fp11 = interfaceC0526Fp3;
                }
                if (i15 != 0) {
                    interfaceC0526Fp12 = null;
                } else {
                    interfaceC0526Fp12 = interfaceC0526Fp4;
                }
                if (i17 != 0) {
                    interfaceC0526Fp13 = null;
                } else {
                    interfaceC0526Fp13 = interfaceC0526Fp5;
                }
                if (i20 != 0) {
                    interfaceC0526Fp14 = null;
                } else {
                    interfaceC0526Fp14 = interfaceC0526Fp6;
                }
                if (i23 != 0) {
                    interfaceC0526Fp15 = null;
                } else {
                    interfaceC0526Fp15 = interfaceC0526Fp7;
                }
                if (i25 == 0) {
                }
                if ((i3 & 16384) != 0) {
                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                    i22 &= -57345;
                } else {
                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                }
                if ((i3 & 32768) != 0) {
                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    i22 &= -458753;
                } else {
                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                }
                interfaceC0526Fp16 = interfaceC0526Fp12;
                if (i26 != 0) {
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    interfaceC0526Fp18 = interfaceC0526Fp14;
                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                } else {
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    interfaceC0526Fp18 = interfaceC0526Fp14;
                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                }
                interfaceC0526Fp19 = interfaceC0526Fp10;
                interfaceC0526Fp20 = interfaceC0526Fp11;
                interfaceC0526Fp21 = interfaceC0526Fp15;
                z5 = z4;
                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                interfaceC0526Fp22 = interfaceC0526Fp31;
                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
            } else {
                if (i9 != 0) {
                    z4 = false;
                } else {
                    z4 = z3;
                }
                if (i11 != 0) {
                    interfaceC0526Fp10 = null;
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp2;
                }
                if (i13 != 0) {
                    interfaceC0526Fp11 = null;
                } else {
                    interfaceC0526Fp11 = interfaceC0526Fp3;
                }
                if (i15 != 0) {
                    interfaceC0526Fp12 = null;
                } else {
                    interfaceC0526Fp12 = interfaceC0526Fp4;
                }
                if (i17 != 0) {
                    interfaceC0526Fp13 = null;
                } else {
                    interfaceC0526Fp13 = interfaceC0526Fp5;
                }
                if (i20 != 0) {
                    interfaceC0526Fp14 = null;
                } else {
                    interfaceC0526Fp14 = interfaceC0526Fp6;
                }
                if (i23 != 0) {
                    interfaceC0526Fp15 = null;
                } else {
                    interfaceC0526Fp15 = interfaceC0526Fp7;
                }
                if (i25 == 0) {
                }
                if ((i3 & 16384) != 0) {
                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                    i22 &= -57345;
                } else {
                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                }
                if ((i3 & 32768) != 0) {
                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    i22 &= -458753;
                } else {
                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                }
                interfaceC0526Fp16 = interfaceC0526Fp12;
                if (i26 != 0) {
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    interfaceC0526Fp18 = interfaceC0526Fp14;
                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                } else {
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    interfaceC0526Fp18 = interfaceC0526Fp14;
                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                }
                interfaceC0526Fp19 = interfaceC0526Fp10;
                interfaceC0526Fp20 = interfaceC0526Fp11;
                interfaceC0526Fp21 = interfaceC0526Fp15;
                z5 = z4;
                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                interfaceC0526Fp22 = interfaceC0526Fp31;
                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
            }
            int i31111111111111111111111111111115 = i4;
            int i31111111111111111111111111111116 = i31111111111111111111111111111115 << 3;
            int i31111111111111111111111111111117 = i31111111111111111111111111111115 >> 3;
            int i31111111111111111111111111111118 = i31111111111111111111111111111115 >> 9;
            int i31111111111111111111111111111119 = i22 << 21;
            composer2 = composerStartRestartGroup;
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i31111111111111111111111111111116 & 896) | (i31111111111111111111111111111116 & 112) | 6 | (i31111111111111111111111111111117 & 7168) | (i31111111111111111111111111111118 & 57344) | (i31111111111111111111111111111118 & 458752) | (i31111111111111111111111111111118 & 3670016) | (i31111111111111111111111111111119 & 29360128) | (234881024 & i31111111111111111111111111111119) | (i31111111111111111111111111111119 & 1879048192), ((i22 >> 9) & 14) | ((i31111111111111111111111111111115 >> 6) & 112) | (i31111111111111111111111111111115 & 896) | (i31111111111111111111111111111118 & 7168) | (i31111111111111111111111111111117 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z6 = z5;
            interfaceC0526Fp23 = interfaceC0526Fp19;
            interfaceC0526Fp24 = interfaceC0526Fp20;
            interfaceC0526Fp25 = interfaceC0526Fp16;
            interfaceC0526Fp26 = interfaceC0526Fp17;
            interfaceC0526Fp27 = interfaceC0526Fp18;
            interfaceC0526Fp28 = interfaceC0526Fp21;
            interfaceC0526Fp29 = interfaceC0526Fp22;
            textFieldColors3 = textFieldColors2;
            paddingValues3 = paddingValues2;
            interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    z4 = false;
                } else {
                    z4 = z3;
                }
                if (i11 != 0) {
                    interfaceC0526Fp10 = null;
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp2;
                }
                if (i13 != 0) {
                    interfaceC0526Fp11 = null;
                } else {
                    interfaceC0526Fp11 = interfaceC0526Fp3;
                }
                if (i15 != 0) {
                    interfaceC0526Fp12 = null;
                } else {
                    interfaceC0526Fp12 = interfaceC0526Fp4;
                }
                if (i17 != 0) {
                    interfaceC0526Fp13 = null;
                } else {
                    interfaceC0526Fp13 = interfaceC0526Fp5;
                }
                if (i20 != 0) {
                    interfaceC0526Fp14 = null;
                } else {
                    interfaceC0526Fp14 = interfaceC0526Fp6;
                }
                if (i23 != 0) {
                    interfaceC0526Fp15 = null;
                } else {
                    interfaceC0526Fp15 = interfaceC0526Fp7;
                }
                if (i25 == 0) {
                }
                if ((i3 & 16384) != 0) {
                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                    i22 &= -57345;
                } else {
                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                }
                if ((i3 & 32768) != 0) {
                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    i22 &= -458753;
                } else {
                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                }
                interfaceC0526Fp16 = interfaceC0526Fp12;
                if (i26 != 0) {
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    interfaceC0526Fp18 = interfaceC0526Fp14;
                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                } else {
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    interfaceC0526Fp18 = interfaceC0526Fp14;
                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                }
                interfaceC0526Fp19 = interfaceC0526Fp10;
                interfaceC0526Fp20 = interfaceC0526Fp11;
                interfaceC0526Fp21 = interfaceC0526Fp15;
                z5 = z4;
                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                interfaceC0526Fp22 = interfaceC0526Fp31;
                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
            } else {
                if (i9 != 0) {
                    z4 = false;
                } else {
                    z4 = z3;
                }
                if (i11 != 0) {
                    interfaceC0526Fp10 = null;
                } else {
                    interfaceC0526Fp10 = interfaceC0526Fp2;
                }
                if (i13 != 0) {
                    interfaceC0526Fp11 = null;
                } else {
                    interfaceC0526Fp11 = interfaceC0526Fp3;
                }
                if (i15 != 0) {
                    interfaceC0526Fp12 = null;
                } else {
                    interfaceC0526Fp12 = interfaceC0526Fp4;
                }
                if (i17 != 0) {
                    interfaceC0526Fp13 = null;
                } else {
                    interfaceC0526Fp13 = interfaceC0526Fp5;
                }
                if (i20 != 0) {
                    interfaceC0526Fp14 = null;
                } else {
                    interfaceC0526Fp14 = interfaceC0526Fp6;
                }
                if (i23 != 0) {
                    interfaceC0526Fp15 = null;
                } else {
                    interfaceC0526Fp15 = interfaceC0526Fp7;
                }
                if (i25 == 0) {
                }
                if ((i3 & 16384) != 0) {
                    textFieldColorsM1686colors0hiis_0 = m1686colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, (i22 >> 12) & 7168, Integer.MAX_VALUE, 4095);
                    i22 &= -57345;
                } else {
                    textFieldColorsM1686colors0hiis_0 = textFieldColors;
                }
                if ((i3 & 32768) != 0) {
                    paddingValuesM1684contentPaddinga9UjIt4$default = m1684contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    i22 &= -458753;
                } else {
                    paddingValuesM1684contentPaddinga9UjIt4$default = paddingValues;
                }
                interfaceC0526Fp16 = interfaceC0526Fp12;
                if (i26 != 0) {
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    interfaceC0526Fp18 = interfaceC0526Fp14;
                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1448570018, true, new AnonymousClass1(z, z4, interactionSource, textFieldColorsM1686colors0hiis_0, i4, i22));
                } else {
                    interfaceC0526Fp17 = interfaceC0526Fp13;
                    interfaceC0526Fp18 = interfaceC0526Fp14;
                    interfaceC0526FpComposableLambda = interfaceC0526Fp9;
                }
                interfaceC0526Fp19 = interfaceC0526Fp10;
                interfaceC0526Fp20 = interfaceC0526Fp11;
                interfaceC0526Fp21 = interfaceC0526Fp15;
                z5 = z4;
                textFieldColors2 = textFieldColorsM1686colors0hiis_0;
                interfaceC0526Fp22 = interfaceC0526Fp31;
                paddingValues2 = paddingValuesM1684contentPaddinga9UjIt4$default;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-350442135, i4, i22, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1637)");
            }
            int i311111111111111111111111111111110 = i4;
            int i311111111111111111111111111111111 = i311111111111111111111111111111110 << 3;
            int i311111111111111111111111111111112 = i311111111111111111111111111111110 >> 3;
            int i311111111111111111111111111111113 = i311111111111111111111111111111110 >> 9;
            int i311111111111111111111111111111114 = i22 << 21;
            composer2 = composerStartRestartGroup;
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, interfaceC0526Fp, visualTransformation, interfaceC0526Fp19, interfaceC0526Fp20, interfaceC0526Fp16, interfaceC0526Fp17, interfaceC0526Fp18, interfaceC0526Fp21, interfaceC0526Fp22, z2, z, z5, interactionSource, paddingValues2, textFieldColors2, interfaceC0526FpComposableLambda, composer2, (i311111111111111111111111111111111 & 896) | (i311111111111111111111111111111111 & 112) | 6 | (i311111111111111111111111111111112 & 7168) | (i311111111111111111111111111111113 & 57344) | (i311111111111111111111111111111113 & 458752) | (i311111111111111111111111111111113 & 3670016) | (i311111111111111111111111111111114 & 29360128) | (234881024 & i311111111111111111111111111111114) | (i311111111111111111111111111111114 & 1879048192), ((i22 >> 9) & 14) | ((i311111111111111111111111111111110 >> 6) & 112) | (i311111111111111111111111111111110 & 896) | (i311111111111111111111111111111113 & 7168) | (i311111111111111111111111111111112 & 57344) | (i22 & 458752) | ((i22 << 6) & 3670016) | ((i22 << 3) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z6 = z5;
            interfaceC0526Fp23 = interfaceC0526Fp19;
            interfaceC0526Fp24 = interfaceC0526Fp20;
            interfaceC0526Fp25 = interfaceC0526Fp16;
            interfaceC0526Fp26 = interfaceC0526Fp17;
            interfaceC0526Fp27 = interfaceC0526Fp18;
            interfaceC0526Fp28 = interfaceC0526Fp21;
            interfaceC0526Fp29 = interfaceC0526Fp22;
            textFieldColors3 = textFieldColors2;
            paddingValues3 = paddingValues2;
            interfaceC0526Fp30 = interfaceC0526FpComposableLambda;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(str, interfaceC0526Fp, z, z2, visualTransformation, interactionSource, z6, interfaceC0526Fp23, interfaceC0526Fp24, interfaceC0526Fp25, interfaceC0526Fp26, interfaceC0526Fp27, interfaceC0526Fp28, interfaceC0526Fp29, textFieldColors3, paddingValues3, interfaceC0526Fp30, i, i2, i3));
    }

    @Composable
    /* JADX INFO: renamed from: colors-0hiis_0, reason: not valid java name */
    public final TextFieldColors m1686colors0hiis_0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        composer.startReplaceableGroup(1767617725);
        long color = (i6 & 1) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusInputColor(), composer, 6) : j;
        long color2 = (i6 & 2) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputColor(), composer, 6) : j2;
        long jM3031copywmQWz5c$default = (i6 & 4) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long color3 = (i6 & 8) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorInputColor(), composer, 6) : j4;
        long jM3067getTransparent0d7_KjU = (i6 & 16) != 0 ? Color.Companion.m3067getTransparent0d7_KjU() : j5;
        long jM3067getTransparent0d7_KjU2 = (i6 & 32) != 0 ? Color.Companion.m3067getTransparent0d7_KjU() : j6;
        long jM3067getTransparent0d7_KjU3 = (i6 & 64) != 0 ? Color.Companion.m3067getTransparent0d7_KjU() : j7;
        long jM3067getTransparent0d7_KjU4 = (i6 & 128) != 0 ? Color.Companion.m3067getTransparent0d7_KjU() : j8;
        long color4 = (i6 & 256) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getCaretColor(), composer, 6) : j9;
        long color5 = (i6 & 512) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor(), composer, 6) : j10;
        TextSelectionColors textSelectionColors2 = (i6 & 1024) != 0 ? (TextSelectionColors) composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors()) : textSelectionColors;
        long color6 = (i6 & 2048) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor(), composer, 6) : j11;
        long color7 = (i6 & 4096) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getOutlineColor(), composer, 6) : j12;
        long jM3031copywmQWz5c$default2 = (i6 & 8192) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        long color8 = (i6 & 16384) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor(), composer, 6) : j14;
        long color9 = (32768 & i6) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor(), composer, 6) : j15;
        long color10 = (65536 & i6) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j16;
        long jM3031copywmQWz5c$default3 = (131072 & i6) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long color11 = (262144 & i6) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor(), composer, 6) : j18;
        long color12 = (524288 & i6) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor(), composer, 6) : j19;
        long color13 = (1048576 & i6) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j20;
        long jM3031copywmQWz5c$default4 = (2097152 & i6) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j21;
        long color14 = (4194304 & i6) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor(), composer, 6) : j22;
        long color15 = (8388608 & i6) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor(), composer, 6) : j23;
        long color16 = (16777216 & i6) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getLabelColor(), composer, 6) : j24;
        long jM3031copywmQWz5c$default5 = (33554432 & i6) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j25;
        long color17 = (67108864 & i6) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor(), composer, 6) : j26;
        long color18 = (134217728 & i6) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer, 6) : j27;
        long color19 = (268435456 & i6) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer, 6) : j28;
        long jM3031copywmQWz5c$default6 = (536870912 & i6) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j29;
        long color20 = (i6 & 1073741824) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor(), composer, 6) : j30;
        long color21 = (i7 & 1) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor(), composer, 6) : j31;
        long color22 = (i7 & 2) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getSupportingColor(), composer, 6) : j32;
        long jM3031copywmQWz5c$default7 = (i7 & 4) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j33;
        long color23 = (i7 & 8) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor(), composer, 6) : j34;
        long color24 = (i7 & 16) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6) : j35;
        long color25 = (i7 & 32) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6) : j36;
        long jM3031copywmQWz5c$default8 = (i7 & 64) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j37;
        long color26 = (i7 & 128) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6) : j38;
        long color27 = (i7 & 256) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6) : j39;
        long color28 = (i7 & 512) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6) : j40;
        long jM3031copywmQWz5c$default9 = (i7 & 1024) != 0 ? Color.m3031copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j41;
        long color29 = (i7 & 2048) != 0 ? ColorSchemeKt.toColor(OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6) : j42;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1767617725, i, i2, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1478)");
        }
        TextFieldColors textFieldColors = new TextFieldColors(color, color2, jM3031copywmQWz5c$default, color3, jM3067getTransparent0d7_KjU, jM3067getTransparent0d7_KjU2, jM3067getTransparent0d7_KjU3, jM3067getTransparent0d7_KjU4, color4, color5, textSelectionColors2, color6, color7, jM3031copywmQWz5c$default2, color8, color9, color10, jM3031copywmQWz5c$default3, color11, color12, color13, jM3031copywmQWz5c$default4, color14, color15, color16, jM3031copywmQWz5c$default5, color17, color18, color19, jM3031copywmQWz5c$default6, color20, color21, color22, jM3031copywmQWz5c$default7, color23, color24, color25, jM3031copywmQWz5c$default8, color26, color27, color28, jM3031copywmQWz5c$default9, color29, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return textFieldColors;
    }

    /* JADX INFO: renamed from: contentPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1687contentPaddinga9UjIt4(float f, float f2, float f3, float f4) {
        return PaddingKt.m481PaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1688getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1689getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1690getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    @Composable
    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(-1066756961);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1066756961, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-shape> (TextFieldDefaults.kt:1347)");
        }
        Shape shape = ShapesKt.toShape(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1691getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }
}
