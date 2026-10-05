package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LookaheadScopeImpl implements LookaheadScope {
    private InterfaceC3588op scopeCoordinates;

    /* JADX INFO: renamed from: androidx.compose.ui.layout.LookaheadScopeImpl$onPlaced$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC0526Fp $onPlaced;
        final /* synthetic */ LookaheadScopeImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC0526Fp interfaceC0526Fp, LookaheadScopeImpl lookaheadScopeImpl) {
            super(1);
            this.$onPlaced = interfaceC0526Fp;
            this.this$0 = lookaheadScopeImpl;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((LayoutCoordinates) obj);
            return FW.a;
        }

        public final void invoke(LayoutCoordinates layoutCoordinates) {
            AbstractC4492zt.h(layoutCoordinates, "coordinates");
            InterfaceC0526Fp interfaceC0526Fp = this.$onPlaced;
            LookaheadScopeImpl lookaheadScopeImpl = this.this$0;
            InterfaceC3588op scopeCoordinates = lookaheadScopeImpl.getScopeCoordinates();
            AbstractC4492zt.e(scopeCoordinates);
            LayoutCoordinates lookaheadCoordinates = lookaheadScopeImpl.toLookaheadCoordinates((LayoutCoordinates) scopeCoordinates.invoke());
            AbstractC4492zt.f(lookaheadCoordinates, "null cannot be cast to non-null type androidx.compose.ui.layout.LookaheadLayoutCoordinates");
            LayoutCoordinates lookaheadCoordinates2 = this.this$0.toLookaheadCoordinates(layoutCoordinates);
            AbstractC4492zt.f(lookaheadCoordinates2, "null cannot be cast to non-null type androidx.compose.ui.layout.LookaheadLayoutCoordinates");
            interfaceC0526Fp.mo13invoke((LookaheadLayoutCoordinates) lookaheadCoordinates, (LookaheadLayoutCoordinates) lookaheadCoordinates2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LookaheadScopeImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "<this>");
        InterfaceC3588op interfaceC3588op = this.scopeCoordinates;
        AbstractC4492zt.e(interfaceC3588op);
        return (LayoutCoordinates) interfaceC3588op.invoke();
    }

    public final InterfaceC3588op getScopeCoordinates() {
        return this.scopeCoordinates;
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public /* synthetic */ Modifier intermediateLayout(Modifier modifier, InterfaceC0578Hp interfaceC0578Hp) {
        return LookaheadScope.CC.a(this, modifier, interfaceC0578Hp);
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    /* JADX INFO: renamed from: localLookaheadPositionOf-dBAh8RU */
    public /* synthetic */ long mo4163localLookaheadPositionOfdBAh8RU(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2) {
        return LookaheadScope.CC.b(this, layoutCoordinates, layoutCoordinates2);
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public Modifier onPlaced(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(interfaceC0526Fp, "onPlaced");
        return OnPlacedModifierKt.onPlaced(modifier, new AnonymousClass1(interfaceC0526Fp, this));
    }

    public final void setScopeCoordinates(InterfaceC3588op interfaceC3588op) {
        this.scopeCoordinates = interfaceC3588op;
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates layoutCoordinates) {
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinates;
        AbstractC4492zt.h(layoutCoordinates, "<this>");
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl = layoutCoordinates instanceof LookaheadLayoutCoordinatesImpl ? (LookaheadLayoutCoordinatesImpl) layoutCoordinates : null;
        if (lookaheadLayoutCoordinatesImpl != null) {
            return lookaheadLayoutCoordinatesImpl;
        }
        NodeCoordinator nodeCoordinator = (NodeCoordinator) layoutCoordinates;
        LookaheadDelegate lookaheadDelegate = nodeCoordinator.getLookaheadDelegate();
        return (lookaheadDelegate == null || (lookaheadLayoutCoordinates = lookaheadDelegate.getLookaheadLayoutCoordinates()) == null) ? nodeCoordinator : lookaheadLayoutCoordinates;
    }

    public LookaheadScopeImpl(InterfaceC3588op interfaceC3588op) {
        this.scopeCoordinates = interfaceC3588op;
    }

    public /* synthetic */ LookaheadScopeImpl(InterfaceC3588op interfaceC3588op, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? null : interfaceC3588op);
    }
}
