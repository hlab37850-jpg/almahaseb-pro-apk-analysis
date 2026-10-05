package androidx.compose.ui.layout;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0578Hp;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalComposeUiApi
public interface LookaheadScope {

    /* JADX INFO: renamed from: androidx.compose.ui.layout.LookaheadScope$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
        public static Modifier a(LookaheadScope lookaheadScope, Modifier modifier, InterfaceC0578Hp interfaceC0578Hp) {
            AbstractC4492zt.h(modifier, "<this>");
            AbstractC4492zt.h(interfaceC0578Hp, "measure");
            return LookaheadScopeKt.intermediateLayout(modifier, new AnonymousClass1(interfaceC0578Hp));
        }

        public static long b(LookaheadScope lookaheadScope, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2) {
            AbstractC4492zt.h(layoutCoordinates, "$this$localLookaheadPositionOf");
            AbstractC4492zt.h(layoutCoordinates2, "coordinates");
            return lookaheadScope.toLookaheadCoordinates(layoutCoordinates).mo4167localPositionOfR5De75A(lookaheadScope.toLookaheadCoordinates(layoutCoordinates2), Offset.Companion.m2814getZeroF1C5BW0());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.layout.LookaheadScope$intermediateLayout$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ InterfaceC0578Hp $measure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC0578Hp interfaceC0578Hp) {
            super(3);
            this.$measure = interfaceC0578Hp;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m4182invoke3p2s80s((IntermediateMeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m5134unboximpl());
        }

        /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
        public final MeasureResult m4182invoke3p2s80s(IntermediateMeasureScope intermediateMeasureScope, Measurable measurable, long j) {
            AbstractC4492zt.h(intermediateMeasureScope, "$this$intermediateLayout");
            AbstractC4492zt.h(measurable, "measurable");
            return (MeasureResult) this.$measure.invoke(intermediateMeasureScope, measurable, Constraints.m5116boximpl(j), IntSize.m5312boximpl(intermediateMeasureScope.mo4162getLookaheadSizeYbymL2g()));
        }
    }

    LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope placementScope);

    Modifier intermediateLayout(Modifier modifier, InterfaceC0578Hp interfaceC0578Hp);

    /* JADX INFO: renamed from: localLookaheadPositionOf-dBAh8RU */
    long mo4163localLookaheadPositionOfdBAh8RU(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2);

    Modifier onPlaced(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp);

    LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates layoutCoordinates);
}
