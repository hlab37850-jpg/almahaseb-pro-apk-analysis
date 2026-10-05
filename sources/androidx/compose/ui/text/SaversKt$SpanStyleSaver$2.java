package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$SpanStyleSaver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SaversKt$SpanStyleSaver$2 INSTANCE = new SaversKt$SpanStyleSaver$2();

    public SaversKt$SpanStyleSaver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final SpanStyle invoke(Object obj) {
        AbstractC4492zt.h(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Color.Companion companion = Color.Companion;
        Saver<Color, Object> saver = SaversKt.getSaver(companion);
        Boolean bool = Boolean.FALSE;
        Color colorRestore = (AbstractC4492zt.d(obj2, bool) || obj2 == null) ? null : saver.restore(obj2);
        AbstractC4492zt.e(colorRestore);
        long jM3042unboximpl = colorRestore.m3042unboximpl();
        Object obj3 = list.get(1);
        TextUnit.Companion companion2 = TextUnit.Companion;
        TextUnit textUnitRestore = (AbstractC4492zt.d(obj3, bool) || obj3 == null) ? null : SaversKt.getSaver(companion2).restore(obj3);
        AbstractC4492zt.e(textUnitRestore);
        long jM5350unboximpl = textUnitRestore.m5350unboximpl();
        Object obj4 = list.get(2);
        FontWeight fontWeightRestore = (AbstractC4492zt.d(obj4, bool) || obj4 == null) ? null : SaversKt.getSaver(FontWeight.Companion).restore(obj4);
        Object obj5 = list.get(3);
        FontStyle fontStyle = obj5 != null ? (FontStyle) obj5 : null;
        Object obj6 = list.get(4);
        FontSynthesis fontSynthesis = obj6 != null ? (FontSynthesis) obj6 : null;
        Object obj7 = list.get(6);
        String str = obj7 != null ? (String) obj7 : null;
        Object obj8 = list.get(7);
        TextUnit textUnitRestore2 = (AbstractC4492zt.d(obj8, bool) || obj8 == null) ? null : SaversKt.getSaver(companion2).restore(obj8);
        AbstractC4492zt.e(textUnitRestore2);
        long jM5350unboximpl2 = textUnitRestore2.m5350unboximpl();
        Object obj9 = list.get(8);
        BaselineShift baselineShiftRestore = (AbstractC4492zt.d(obj9, bool) || obj9 == null) ? null : SaversKt.getSaver(BaselineShift.Companion).restore(obj9);
        Object obj10 = list.get(9);
        TextGeometricTransform textGeometricTransformRestore = (AbstractC4492zt.d(obj10, bool) || obj10 == null) ? null : SaversKt.getSaver(TextGeometricTransform.Companion).restore(obj10);
        Object obj11 = list.get(10);
        LocaleList localeListRestore = (AbstractC4492zt.d(obj11, bool) || obj11 == null) ? null : SaversKt.getSaver(LocaleList.Companion).restore(obj11);
        Object obj12 = list.get(11);
        Color colorRestore2 = (AbstractC4492zt.d(obj12, bool) || obj12 == null) ? null : SaversKt.getSaver(companion).restore(obj12);
        AbstractC4492zt.e(colorRestore2);
        long jM3042unboximpl2 = colorRestore2.m3042unboximpl();
        Object obj13 = list.get(12);
        TextDecoration textDecorationRestore = (AbstractC4492zt.d(obj13, bool) || obj13 == null) ? null : SaversKt.getSaver(TextDecoration.Companion).restore(obj13);
        Object obj14 = list.get(13);
        return new SpanStyle(jM3042unboximpl, jM5350unboximpl, fontWeightRestore, fontStyle, fontSynthesis, (FontFamily) null, str, jM5350unboximpl2, baselineShiftRestore, textGeometricTransformRestore, localeListRestore, jM3042unboximpl2, textDecorationRestore, (AbstractC4492zt.d(obj14, bool) || obj14 == null) ? null : SaversKt.getSaver(Shadow.Companion).restore(obj14), (PlatformSpanStyle) null, (DrawStyle) null, 49184, (AbstractC0419Di) null);
    }
}
