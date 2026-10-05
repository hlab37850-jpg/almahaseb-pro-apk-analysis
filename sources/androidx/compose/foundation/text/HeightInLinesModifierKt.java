package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class HeightInLinesModifierKt {
    public static final int DefaultMinLines = 1;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.HeightInLinesModifierKt$heightInLines$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $maxLines;
        final /* synthetic */ int $minLines;
        final /* synthetic */ TextStyle $textStyle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i, int i2, TextStyle textStyle) {
            super(3);
            this.$minLines = i;
            this.$maxLines = i2;
            this.$textStyle = textStyle;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            AbstractC4492zt.h(modifier, "$this$composed");
            composer.startReplaceableGroup(408240218);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(408240218, i, -1, "androidx.compose.foundation.text.heightInLines.<anonymous> (HeightInLinesModifier.kt:58)");
            }
            HeightInLinesModifierKt.validateMinMaxLines(this.$minLines, this.$maxLines);
            if (this.$minLines == 1 && this.$maxLines == Integer.MAX_VALUE) {
                Modifier.Companion companion = Modifier.Companion;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return companion;
            }
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            FontFamily.Resolver resolver = (FontFamily.Resolver) composer.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            TextStyle textStyle = this.$textStyle;
            composer.startReplaceableGroup(511388516);
            boolean zChanged = composer.changed(textStyle) | composer.changed(layoutDirection);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = TextStyleKt.resolveDefaults(textStyle, layoutDirection);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            TextStyle textStyle2 = (TextStyle) objRememberedValue;
            composer.startReplaceableGroup(511388516);
            boolean zChanged2 = composer.changed(resolver) | composer.changed(textStyle2);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                FontFamily fontFamily = textStyle2.getFontFamily();
                FontWeight fontWeight = textStyle2.getFontWeight();
                if (fontWeight == null) {
                    fontWeight = FontWeight.Companion.getNormal();
                }
                FontStyle fontStyleM4728getFontStyle4Lr2A7w = textStyle2.m4728getFontStyle4Lr2A7w();
                int iM4804unboximpl = fontStyleM4728getFontStyle4Lr2A7w != null ? fontStyleM4728getFontStyle4Lr2A7w.m4804unboximpl() : FontStyle.Companion.m4806getNormal_LCdwA();
                FontSynthesis fontSynthesisM4729getFontSynthesisZQGJjVo = textStyle2.m4729getFontSynthesisZQGJjVo();
                objRememberedValue2 = resolver.mo4776resolveDPcqOEQ(fontFamily, fontWeight, iM4804unboximpl, fontSynthesisM4729getFontSynthesisZQGJjVo != null ? fontSynthesisM4729getFontSynthesisZQGJjVo.m4815unboximpl() : FontSynthesis.Companion.m4816getAllGVVA2EU());
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            State state = (State) objRememberedValue2;
            Object[] objArr = {density, resolver, this.$textStyle, layoutDirection, state.getValue()};
            composer.startReplaceableGroup(-568225417);
            boolean zChanged3 = false;
            for (int i2 = 0; i2 < 5; i2++) {
                zChanged3 |= composer.changed(objArr[i2]);
            }
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = Integer.valueOf(IntSize.m5319getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textStyle2, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement(), 1)));
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            int iIntValue = ((Number) objRememberedValue3).intValue();
            Object[] objArr2 = {density, resolver, this.$textStyle, layoutDirection, state.getValue()};
            composer.startReplaceableGroup(-568225417);
            boolean zChanged4 = false;
            for (int i3 = 0; i3 < 5; i3++) {
                zChanged4 |= composer.changed(objArr2[i3]);
            }
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged4 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = Integer.valueOf(IntSize.m5319getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textStyle2, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement() + '\n' + TextFieldDelegateKt.getEmptyTextReplacement(), 2)));
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceableGroup();
            int iIntValue2 = ((Number) objRememberedValue4).intValue() - iIntValue;
            int i4 = this.$minLines;
            Integer numValueOf = i4 == 1 ? null : Integer.valueOf(((i4 - 1) * iIntValue2) + iIntValue);
            int i5 = this.$maxLines;
            Integer numValueOf2 = i5 != Integer.MAX_VALUE ? Integer.valueOf(iIntValue + (iIntValue2 * (i5 - 1))) : null;
            Modifier modifierM519heightInVpY3zN4 = SizeKt.m519heightInVpY3zN4(Modifier.Companion, numValueOf != null ? density.mo330toDpu2uoSUM(numValueOf.intValue()) : Dp.Companion.m5180getUnspecifiedD9Ej5fM(), numValueOf2 != null ? density.mo330toDpu2uoSUM(numValueOf2.intValue()) : Dp.Companion.m5180getUnspecifiedD9Ej5fM());
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return modifierM519heightInVpY3zN4;
        }
    }

    public static final Modifier heightInLines(Modifier modifier, TextStyle textStyle, int i, int i2) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(textStyle, "textStyle");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new HeightInLinesModifierKt$heightInLines$$inlined$debugInspectorInfo$1(i, i2, textStyle) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(i, i2, textStyle));
    }

    public static /* synthetic */ Modifier heightInLines$default(Modifier modifier, TextStyle textStyle, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 1;
        }
        if ((i3 & 4) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return heightInLines(modifier, textStyle, i, i2);
    }

    public static final void validateMinMaxLines(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException(("both minLines " + i + " and maxLines " + i2 + " must be greater than zero").toString());
        }
        if (i <= i2) {
            return;
        }
        throw new IllegalArgumentException(("minLines " + i + " must be less than or equal to maxLines " + i2).toString());
    }
}
