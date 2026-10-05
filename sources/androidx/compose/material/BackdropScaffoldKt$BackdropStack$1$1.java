package androidx.compose.material;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class BackdropScaffoldKt$BackdropStack$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0526Fp $backLayer;
    final /* synthetic */ InterfaceC3750qp $calculateBackLayerConstraints;
    final /* synthetic */ InterfaceC0578Hp $frontLayer;

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ Placeable $backLayerPlaceable;
        final /* synthetic */ List<Placeable> $placeables;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Placeable placeable, List<? extends Placeable> list) {
            super(1);
            this.$backLayerPlaceable = placeable;
            this.$placeables = list;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Placeable.PlacementScope) obj);
            return FW.a;
        }

        public final void invoke(Placeable.PlacementScope placementScope) {
            AbstractC4492zt.h(placementScope, "$this$layout");
            Placeable.PlacementScope.placeRelative$default(placementScope, this.$backLayerPlaceable, 0, 0, 0.0f, 4, null);
            List<Placeable> list = this.$placeables;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i), 0, 0, 0.0f, 4, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldKt$BackdropStack$1$1(InterfaceC0526Fp interfaceC0526Fp, InterfaceC3750qp interfaceC3750qp, InterfaceC0578Hp interfaceC0578Hp, int i) {
        super(2);
        this.$backLayer = interfaceC0526Fp;
        this.$calculateBackLayerConstraints = interfaceC3750qp;
        this.$frontLayer = interfaceC0578Hp;
        this.$$dirty = i;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m992invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final MeasureResult m992invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        AbstractC4492zt.h(subcomposeMeasureScope, "$this$SubcomposeLayout");
        Placeable placeableMo4159measureBRTryo0 = ((Measurable) AbstractC3240kc.b0(subcomposeMeasureScope.subcompose(BackdropLayers.Back, this.$backLayer))).mo4159measureBRTryo0(((Constraints) this.$calculateBackLayerConstraints.invoke(Constraints.m5116boximpl(j))).m5134unboximpl());
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(BackdropLayers.Front, ComposableLambdaKt.composableLambdaInstance(-1222642649, true, new BackdropScaffoldKt$BackdropStack$1$1$placeables$1(this.$frontLayer, j, placeableMo4159measureBRTryo0.getHeight(), this.$$dirty)));
        ArrayList arrayList = new ArrayList(listSubcompose.size());
        int size = listSubcompose.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(listSubcompose.get(i).mo4159measureBRTryo0(j));
        }
        int iMax = Math.max(Constraints.m5130getMinWidthimpl(j), placeableMo4159measureBRTryo0.getWidth());
        int iMax2 = Math.max(Constraints.m5129getMinHeightimpl(j), placeableMo4159measureBRTryo0.getHeight());
        int size2 = arrayList.size();
        int iMax3 = iMax2;
        int iMax4 = iMax;
        for (int i2 = 0; i2 < size2; i2++) {
            Placeable placeable = (Placeable) arrayList.get(i2);
            iMax4 = Math.max(iMax4, placeable.getWidth());
            iMax3 = Math.max(iMax3, placeable.getHeight());
        }
        return MeasureScope.CC.q(subcomposeMeasureScope, iMax4, iMax3, null, new AnonymousClass2(placeableMo4159measureBRTryo0, arrayList), 4, null);
    }
}
