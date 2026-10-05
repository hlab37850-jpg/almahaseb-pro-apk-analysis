package androidx.compose.ui.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1239ac;
import defpackage.AbstractC2371hc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0756Mu;
import defpackage.InterfaceC3750qp;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public interface SubcomposeSlotReusePolicy {

    @StabilityInferred(parameters = 0)
    public static final class SlotIdsSet implements Collection<Object>, InterfaceC0756Mu {
        public static final int $stable = 8;
        private final Set<Object> set;

        /* JADX WARN: Multi-variable type inference failed */
        public SlotIdsSet() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // java.util.Collection
        /* JADX INFO: renamed from: add$ui_release, reason: merged with bridge method [inline-methods] */
        public final boolean add(Object obj) {
            return this.set.add(obj);
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Collection
        public final void clear() {
            this.set.clear();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return this.set.contains(obj);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<? extends Object> collection) {
            AbstractC4492zt.h(collection, "elements");
            return this.set.containsAll(collection);
        }

        public int getSize() {
            return this.set.size();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.set.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return this.set.iterator();
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            return this.set.remove(obj);
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection<? extends Object> collection) {
            AbstractC4492zt.h(collection, "slotIds");
            return this.set.remove(collection);
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super Object> predicate) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<? extends Object> collection) {
            AbstractC4492zt.h(collection, "slotIds");
            return this.set.retainAll(collection);
        }

        @Override // java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return AbstractC1239ac.a(this);
        }

        public SlotIdsSet(Set<Object> set) {
            AbstractC4492zt.h(set, "set");
            this.set = set;
        }

        public final boolean removeAll(InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return AbstractC2371hc.I(this.set, interfaceC3750qp);
        }

        public final boolean retainAll(InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "predicate");
            return AbstractC2371hc.Q(this.set, interfaceC3750qp);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            AbstractC4492zt.h(tArr, "array");
            return (T[]) AbstractC1239ac.b(this, tArr);
        }

        public /* synthetic */ SlotIdsSet(Set set, int i, AbstractC0419Di abstractC0419Di) {
            this((i & 1) != 0 ? new LinkedHashSet() : set);
        }
    }

    boolean areCompatible(Object obj, Object obj2);

    void getSlotsToRetain(SlotIdsSet slotIdsSet);
}
