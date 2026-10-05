package defpackage;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Za0 extends AbstractMap {
    public final int a;
    public List b;
    public Map c;
    public boolean d;
    public volatile C3485nb0 e;
    public Map f;
    public volatile C2043db0 g;

    public Za0(int i) {
        this.a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
        this.f = Collections.emptyMap();
    }

    public static Za0 f(int i) {
        return new C1804bb0(i);
    }

    public final boolean a() {
        return this.d;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0028  */
    /* JADX WARN: Code duplicated, block: B:17:0x0045  */
    /* JADX WARN: Code duplicated, block: B:21:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0040 A[SYNTHETIC] */
    public final int b(Comparable comparable) {
        int i;
        int i2;
        int i3;
        int iCompareTo;
        int size = this.b.size();
        int i4 = size - 1;
        if (i4 < 0) {
            i = 0;
            while (i <= i4) {
                i3 = (i + i4) / 2;
                iCompareTo = comparable.compareTo((Comparable) ((C3239kb0) this.b.get(i3)).getKey());
                if (iCompareTo < 0) {
                    i4 = i3 - 1;
                } else {
                    if (iCompareTo > 0) {
                        return i3;
                    }
                    i = i3 + 1;
                }
            }
            i2 = i + 1;
        } else {
            int iCompareTo2 = comparable.compareTo((Comparable) ((C3239kb0) this.b.get(i4)).getKey());
            if (iCompareTo2 > 0) {
                i2 = size + 1;
            } else {
                if (iCompareTo2 == 0) {
                    return i4;
                }
                i = 0;
                while (i <= i4) {
                    i3 = (i + i4) / 2;
                    iCompareTo = comparable.compareTo((Comparable) ((C3239kb0) this.b.get(i3)).getKey());
                    if (iCompareTo < 0) {
                        i4 = i3 - 1;
                    } else {
                        if (iCompareTo > 0) {
                            return i3;
                        }
                        i = i3 + 1;
                    }
                }
                i2 = i + 1;
            }
        }
        return -i2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        p();
        int iB = b(comparable);
        if (iB >= 0) {
            return ((C3239kb0) this.b.get(iB)).setValue(obj);
        }
        p();
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(this.a);
        }
        int i = -(iB + 1);
        if (i >= this.a) {
            return q().put(comparable, obj);
        }
        int size = this.b.size();
        int i2 = this.a;
        if (size == i2) {
            C3239kb0 c3239kb0 = (C3239kb0) this.b.remove(i2 - 1);
            q().put((Comparable) c3239kb0.getKey(), c3239kb0.getValue());
        }
        this.b.add(i, new C3239kb0(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        p();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (this.c.isEmpty()) {
            return;
        }
        this.c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return b(comparable) >= 0 || this.c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.e == null) {
            this.e = new C3485nb0(this, null);
        }
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Za0)) {
            return super.equals(obj);
        }
        Za0 za0 = (Za0) obj;
        int size = size();
        if (size != za0.size()) {
            return false;
        }
        int iM = m();
        if (iM != za0.m()) {
            return entrySet().equals(za0.entrySet());
        }
        for (int i = 0; i < iM; i++) {
            if (!g(i).equals(za0.g(i))) {
                return false;
            }
        }
        if (iM != size) {
            return this.c.equals(za0.c);
        }
        return true;
    }

    public final Map.Entry g(int i) {
        return (Map.Entry) this.b.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iB = b(comparable);
        return iB >= 0 ? ((C3239kb0) this.b.get(iB)).getValue() : this.c.get(comparable);
    }

    public final Object h(int i) {
        p();
        Object value = ((C3239kb0) this.b.remove(i)).getValue();
        if (!this.c.isEmpty()) {
            Iterator it = q().entrySet().iterator();
            this.b.add(new C3239kb0(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iM = m();
        int iHashCode = 0;
        for (int i = 0; i < iM; i++) {
            iHashCode += ((C3239kb0) this.b.get(i)).hashCode();
        }
        return this.c.size() > 0 ? iHashCode + this.c.hashCode() : iHashCode;
    }

    public final int m() {
        return this.b.size();
    }

    public final Iterable n() {
        return this.c.isEmpty() ? AbstractC2206fb0.a() : this.c.entrySet();
    }

    public final Set o() {
        if (this.g == null) {
            this.g = new C2043db0(this, null);
        }
        return this.g;
    }

    public final void p() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    public final SortedMap q() {
        p();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.c = treeMap;
            this.f = treeMap.descendingMap();
        }
        return (SortedMap) this.c;
    }

    public void r() {
        if (this.d) {
            return;
        }
        this.c = this.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.c);
        this.f = this.f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f);
        this.d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        p();
        Comparable comparable = (Comparable) obj;
        int iB = b(comparable);
        if (iB >= 0) {
            return h(iB);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.b.size() + this.c.size();
    }

    public /* synthetic */ Za0(int i, C1804bb0 c1804bb0) {
        this(i);
    }
}
