package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class SliderDefaults$Track$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ State<Color> $activeTickColor;
    final /* synthetic */ State<Color> $activeTrackColor;
    final /* synthetic */ State<Color> $inactiveTickColor;
    final /* synthetic */ State<Color> $inactiveTrackColor;
    final /* synthetic */ SliderPositions $sliderPositions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliderDefaults$Track$1$1(State<Color> state, SliderPositions sliderPositions, State<Color> state2, State<Color> state3, State<Color> state4) {
        super(1);
        this.$inactiveTrackColor = state;
        this.$sliderPositions = sliderPositions;
        this.$activeTrackColor = state2;
        this.$inactiveTickColor = state3;
        this.$activeTickColor = state4;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return FW.a;
    }

    public final void invoke(DrawScope drawScope) {
        AbstractC4492zt.h(drawScope, "$this$Canvas");
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        long jOffset = OffsetKt.Offset(0.0f, Offset.m2799getYimpl(drawScope.mo3468getCenterF1C5BW0()));
        long jOffset2 = OffsetKt.Offset(Size.m2867getWidthimpl(drawScope.mo3469getSizeNHjbRc()), Offset.m2799getYimpl(drawScope.mo3468getCenterF1C5BW0()));
        long j = z ? jOffset2 : jOffset;
        long j2 = z ? jOffset : jOffset2;
        float fMo333toPx0680j_4 = drawScope.mo333toPx0680j_4(SliderKt.TickSize);
        float fMo333toPx0680j_5 = drawScope.mo333toPx0680j_4(SliderKt.getTrackHeight());
        long jM3042unboximpl = this.$inactiveTrackColor.getValue().m3042unboximpl();
        StrokeCap.Companion companion = StrokeCap.Companion;
        long j3 = j2;
        long j4 = j;
        AbstractC3255kk.C(drawScope, jM3042unboximpl, j, j2, fMo333toPx0680j_5, companion.m3357getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
        AbstractC3255kk.C(drawScope, this.$activeTrackColor.getValue().m3042unboximpl(), OffsetKt.Offset(Offset.m2798getXimpl(j4) + ((Offset.m2798getXimpl(j3) - Offset.m2798getXimpl(j4)) * ((Number) this.$sliderPositions.getActiveRange().getStart()).floatValue()), Offset.m2799getYimpl(drawScope.mo3468getCenterF1C5BW0())), OffsetKt.Offset(Offset.m2798getXimpl(j4) + ((Offset.m2798getXimpl(j3) - Offset.m2798getXimpl(j4)) * ((Number) this.$sliderPositions.getActiveRange().getEndInclusive()).floatValue()), Offset.m2799getYimpl(drawScope.mo3468getCenterF1C5BW0())), fMo333toPx0680j_5, companion.m3357getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
        float[] tickFractions = this.$sliderPositions.getTickFractions();
        SliderPositions sliderPositions = this.$sliderPositions;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = tickFractions.length;
        for (int i = 0; i < length; i++) {
            float f = tickFractions[i];
            Boolean boolValueOf = Boolean.valueOf(f > ((Number) sliderPositions.getActiveRange().getEndInclusive()).floatValue() || f < ((Number) sliderPositions.getActiveRange().getStart()).floatValue());
            Object arrayList = linkedHashMap.get(boolValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(boolValueOf, arrayList);
            }
            ((List) arrayList).add(Float.valueOf(f));
        }
        State<Color> state = this.$inactiveTickColor;
        State<Color> state2 = this.$activeTickColor;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            boolean zBooleanValue = ((Boolean) entry.getKey()).booleanValue();
            List list = (List) entry.getValue();
            ArrayList arrayList2 = new ArrayList(AbstractC2044dc.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Offset.m2787boximpl(OffsetKt.Offset(Offset.m2798getXimpl(OffsetKt.m2821lerpWko1d7g(j4, j3, ((Number) it.next()).floatValue())), Offset.m2799getYimpl(drawScope.mo3468getCenterF1C5BW0()))));
            }
            long j5 = j4;
            long j6 = j3;
            AbstractC3255kk.H(drawScope, arrayList2, PointMode.Companion.m3309getPointsr_lszbg(), (zBooleanValue ? state : state2).getValue().m3042unboximpl(), fMo333toPx0680j_4, StrokeCap.Companion.m3357getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
            j3 = j6;
            j4 = j5;
        }
    }
}
