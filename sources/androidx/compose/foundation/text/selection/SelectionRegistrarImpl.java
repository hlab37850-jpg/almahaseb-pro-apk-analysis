package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.SelectionRegistrarImpl;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import defpackage.AbstractC0956Ud;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2289gc;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0604Ip;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class SelectionRegistrarImpl implements SelectionRegistrar {
    private InterfaceC3750qp afterSelectableUnsubscribe;
    private InterfaceC3750qp onPositionChangeCallback;
    private InterfaceC3750qp onSelectableChangeCallback;
    private InterfaceC0604Ip onSelectionUpdateCallback;
    private InterfaceC3588op onSelectionUpdateEndCallback;
    private InterfaceC3750qp onSelectionUpdateSelectAll;
    private InterfaceC0552Gp onSelectionUpdateStartCallback;
    private boolean sorted;
    private final List<Selectable> _selectables = new ArrayList();
    private final Map<Long, Selectable> _selectableMap = new LinkedHashMap();
    private AtomicLong incrementId = new AtomicLong(1);
    private final MutableState subselections$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AbstractC4243wx.g(), null, 2, null);

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionRegistrarImpl$sort$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ LayoutCoordinates $containerLayoutCoordinates;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LayoutCoordinates layoutCoordinates) {
            super(2);
            this.$containerLayoutCoordinates = layoutCoordinates;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer mo13invoke(Selectable selectable, Selectable selectable2) {
            AbstractC4492zt.h(selectable, "a");
            AbstractC4492zt.h(selectable2, "b");
            LayoutCoordinates layoutCoordinates = selectable.getLayoutCoordinates();
            LayoutCoordinates layoutCoordinates2 = selectable2.getLayoutCoordinates();
            long jMo4167localPositionOfR5De75A = layoutCoordinates != null ? this.$containerLayoutCoordinates.mo4167localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m2814getZeroF1C5BW0()) : Offset.Companion.m2814getZeroF1C5BW0();
            long jMo4167localPositionOfR5De75A2 = layoutCoordinates2 != null ? this.$containerLayoutCoordinates.mo4167localPositionOfR5De75A(layoutCoordinates2, Offset.Companion.m2814getZeroF1C5BW0()) : Offset.Companion.m2814getZeroF1C5BW0();
            return Integer.valueOf(Offset.m2799getYimpl(jMo4167localPositionOfR5De75A) == Offset.m2799getYimpl(jMo4167localPositionOfR5De75A2) ? AbstractC0956Ud.d(Float.valueOf(Offset.m2798getXimpl(jMo4167localPositionOfR5De75A)), Float.valueOf(Offset.m2798getXimpl(jMo4167localPositionOfR5De75A2))) : AbstractC0956Ud.d(Float.valueOf(Offset.m2799getYimpl(jMo4167localPositionOfR5De75A)), Float.valueOf(Offset.m2799getYimpl(jMo4167localPositionOfR5De75A2))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sort$lambda$2(InterfaceC0526Fp interfaceC0526Fp, Object obj, Object obj2) {
        AbstractC4492zt.h(interfaceC0526Fp, "$tmp0");
        return ((Number) interfaceC0526Fp.mo13invoke(obj, obj2)).intValue();
    }

    public final InterfaceC3750qp getAfterSelectableUnsubscribe$foundation_release() {
        return this.afterSelectableUnsubscribe;
    }

    public final InterfaceC3750qp getOnPositionChangeCallback$foundation_release() {
        return this.onPositionChangeCallback;
    }

    public final InterfaceC3750qp getOnSelectableChangeCallback$foundation_release() {
        return this.onSelectableChangeCallback;
    }

    public final InterfaceC0604Ip getOnSelectionUpdateCallback$foundation_release() {
        return this.onSelectionUpdateCallback;
    }

    public final InterfaceC3588op getOnSelectionUpdateEndCallback$foundation_release() {
        return this.onSelectionUpdateEndCallback;
    }

    public final InterfaceC3750qp getOnSelectionUpdateSelectAll$foundation_release() {
        return this.onSelectionUpdateSelectAll;
    }

    public final InterfaceC0552Gp getOnSelectionUpdateStartCallback$foundation_release() {
        return this.onSelectionUpdateStartCallback;
    }

    public final Map<Long, Selectable> getSelectableMap$foundation_release() {
        return this._selectableMap;
    }

    public final List<Selectable> getSelectables$foundation_release() {
        return this._selectables;
    }

    public final boolean getSorted$foundation_release() {
        return this.sorted;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public Map<Long, Selection> getSubselections() {
        return (Map) this.subselections$delegate.getValue();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public long nextSelectableId() {
        long andIncrement = this.incrementId.getAndIncrement();
        while (andIncrement == 0) {
            andIncrement = this.incrementId.getAndIncrement();
        }
        return andIncrement;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifyPositionChange(long j) {
        this.sorted = false;
        InterfaceC3750qp interfaceC3750qp = this.onPositionChangeCallback;
        if (interfaceC3750qp != null) {
            interfaceC3750qp.invoke(Long.valueOf(j));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectableChange(long j) {
        InterfaceC3750qp interfaceC3750qp = this.onSelectableChangeCallback;
        if (interfaceC3750qp != null) {
            interfaceC3750qp.invoke(Long.valueOf(j));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    /* JADX INFO: renamed from: notifySelectionUpdate-5iVPX68 */
    public boolean mo945notifySelectionUpdate5iVPX68(LayoutCoordinates layoutCoordinates, long j, long j2, boolean z, SelectionAdjustment selectionAdjustment) {
        AbstractC4492zt.h(layoutCoordinates, "layoutCoordinates");
        AbstractC4492zt.h(selectionAdjustment, "adjustment");
        InterfaceC0604Ip interfaceC0604Ip = this.onSelectionUpdateCallback;
        if (interfaceC0604Ip != null) {
            return ((Boolean) interfaceC0604Ip.invoke(layoutCoordinates, Offset.m2787boximpl(j), Offset.m2787boximpl(j2), Boolean.valueOf(z), selectionAdjustment)).booleanValue();
        }
        return true;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectionUpdateEnd() {
        InterfaceC3588op interfaceC3588op = this.onSelectionUpdateEndCallback;
        if (interfaceC3588op != null) {
            interfaceC3588op.invoke();
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectionUpdateSelectAll(long j) {
        InterfaceC3750qp interfaceC3750qp = this.onSelectionUpdateSelectAll;
        if (interfaceC3750qp != null) {
            interfaceC3750qp.invoke(Long.valueOf(j));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    /* JADX INFO: renamed from: notifySelectionUpdateStart-d-4ec7I */
    public void mo946notifySelectionUpdateStartd4ec7I(LayoutCoordinates layoutCoordinates, long j, SelectionAdjustment selectionAdjustment) {
        AbstractC4492zt.h(layoutCoordinates, "layoutCoordinates");
        AbstractC4492zt.h(selectionAdjustment, "adjustment");
        InterfaceC0552Gp interfaceC0552Gp = this.onSelectionUpdateStartCallback;
        if (interfaceC0552Gp != null) {
            interfaceC0552Gp.invoke(layoutCoordinates, Offset.m2787boximpl(j), selectionAdjustment);
        }
    }

    public final void setAfterSelectableUnsubscribe$foundation_release(InterfaceC3750qp interfaceC3750qp) {
        this.afterSelectableUnsubscribe = interfaceC3750qp;
    }

    public final void setOnPositionChangeCallback$foundation_release(InterfaceC3750qp interfaceC3750qp) {
        this.onPositionChangeCallback = interfaceC3750qp;
    }

    public final void setOnSelectableChangeCallback$foundation_release(InterfaceC3750qp interfaceC3750qp) {
        this.onSelectableChangeCallback = interfaceC3750qp;
    }

    public final void setOnSelectionUpdateCallback$foundation_release(InterfaceC0604Ip interfaceC0604Ip) {
        this.onSelectionUpdateCallback = interfaceC0604Ip;
    }

    public final void setOnSelectionUpdateEndCallback$foundation_release(InterfaceC3588op interfaceC3588op) {
        this.onSelectionUpdateEndCallback = interfaceC3588op;
    }

    public final void setOnSelectionUpdateSelectAll$foundation_release(InterfaceC3750qp interfaceC3750qp) {
        this.onSelectionUpdateSelectAll = interfaceC3750qp;
    }

    public final void setOnSelectionUpdateStartCallback$foundation_release(InterfaceC0552Gp interfaceC0552Gp) {
        this.onSelectionUpdateStartCallback = interfaceC0552Gp;
    }

    public final void setSorted$foundation_release(boolean z) {
        this.sorted = z;
    }

    public void setSubselections(Map<Long, Selection> map) {
        AbstractC4492zt.h(map, "<set-?>");
        this.subselections$delegate.setValue(map);
    }

    public final List<Selectable> sort(LayoutCoordinates layoutCoordinates) {
        AbstractC4492zt.h(layoutCoordinates, "containerLayoutCoordinates");
        if (!this.sorted) {
            List<Selectable> list = this._selectables;
            final AnonymousClass1 anonymousClass1 = new AnonymousClass1(layoutCoordinates);
            AbstractC2289gc.B(list, new Comparator() { // from class: qO
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return SelectionRegistrarImpl.sort$lambda$2(anonymousClass1, obj, obj2);
                }
            });
            this.sorted = true;
        }
        return getSelectables$foundation_release();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public Selectable subscribe(Selectable selectable) {
        AbstractC4492zt.h(selectable, "selectable");
        if (selectable.getSelectableId() == 0) {
            throw new IllegalArgumentException(("The selectable contains an invalid id: " + selectable.getSelectableId()).toString());
        }
        if (!this._selectableMap.containsKey(Long.valueOf(selectable.getSelectableId()))) {
            this._selectableMap.put(Long.valueOf(selectable.getSelectableId()), selectable);
            this._selectables.add(selectable);
            this.sorted = false;
            return selectable;
        }
        throw new IllegalArgumentException(("Another selectable with the id: " + selectable + ".selectableId has already subscribed.").toString());
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void unsubscribe(Selectable selectable) {
        AbstractC4492zt.h(selectable, "selectable");
        if (this._selectableMap.containsKey(Long.valueOf(selectable.getSelectableId()))) {
            this._selectables.remove(selectable);
            this._selectableMap.remove(Long.valueOf(selectable.getSelectableId()));
            InterfaceC3750qp interfaceC3750qp = this.afterSelectableUnsubscribe;
            if (interfaceC3750qp != null) {
                interfaceC3750qp.invoke(Long.valueOf(selectable.getSelectableId()));
            }
        }
    }
}
