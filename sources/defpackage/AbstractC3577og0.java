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

/* JADX INFO: renamed from: og0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC3577og0 extends AbstractMap {
    public final int a;
    public List b;
    public Map c;
    public boolean d;
    public volatile C4144vg0 e;
    public Map f;
    public volatile C3659pg0 g;

    public AbstractC3577og0(int i) {
        this.a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
        this.f = Collections.emptyMap();
    }

    public static AbstractC3577og0 d(int i) {
        return new C3495ng0(i);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0028  */
    /* JADX WARN: Code duplicated, block: B:17:0x0045  */
    /* JADX WARN: Code duplicated, block: B:21:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0040 A[SYNTHETIC] */
    public final int a(Comparable comparable) {
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
                iCompareTo = comparable.compareTo((Comparable) ((C3982tg0) this.b.get(i3)).getKey());
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
            int iCompareTo2 = comparable.compareTo((Comparable) ((C3982tg0) this.b.get(i4)).getKey());
            if (iCompareTo2 > 0) {
                i2 = size + 1;
            } else {
                if (iCompareTo2 == 0) {
                    return i4;
                }
                i = 0;
                while (i <= i4) {
                    i3 = (i + i4) / 2;
                    iCompareTo = comparable.compareTo((Comparable) ((C3982tg0) this.b.get(i3)).getKey());
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
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        q();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((C3982tg0) this.b.get(iA)).setValue(obj);
        }
        q();
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(this.a);
        }
        int i = -(iA + 1);
        if (i >= this.a) {
            return r().put(comparable, obj);
        }
        int size = this.b.size();
        int i2 = this.a;
        if (size == i2) {
            C3982tg0 c3982tg0 = (C3982tg0) this.b.remove(i2 - 1);
            r().put((Comparable) c3982tg0.getKey(), c3982tg0.getValue());
        }
        this.b.add(i, new C3982tg0(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        q();
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
        return a(comparable) >= 0 || this.c.containsKey(comparable);
    }

    public void e() {
        if (this.d) {
            return;
        }
        this.c = this.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.c);
        this.f = this.f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f);
        this.d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.e == null) {
            this.e = new C4144vg0(this, null);
        }
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC3577og0)) {
            return super.equals(obj);
        }
        AbstractC3577og0 abstractC3577og0 = (AbstractC3577og0) obj;
        int size = size();
        if (size != abstractC3577og0.size()) {
            return false;
        }
        int iK = k();
        if (iK != abstractC3577og0.k()) {
            return entrySet().equals(abstractC3577og0.entrySet());
        }
        for (int i = 0; i < iK; i++) {
            if (!h(i).equals(abstractC3577og0.h(i))) {
                return false;
            }
        }
        if (iK != size) {
            return this.c.equals(abstractC3577og0.c);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((C3982tg0) this.b.get(iA)).getValue() : this.c.get(comparable);
    }

    public final Map.Entry h(int i) {
        return (Map.Entry) this.b.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iK = k();
        int iHashCode = 0;
        for (int i = 0; i < iK; i++) {
            iHashCode += ((C3982tg0) this.b.get(i)).hashCode();
        }
        return this.c.size() > 0 ? iHashCode + this.c.hashCode() : iHashCode;
    }

    public final boolean j() {
        return this.d;
    }

    public final int k() {
        return this.b.size();
    }

    public final Object l(int i) {
        q();
        Object value = ((C3982tg0) this.b.remove(i)).getValue();
        if (!this.c.isEmpty()) {
            Iterator it = r().entrySet().iterator();
            this.b.add(new C3982tg0(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public final Iterable n() {
        return this.c.isEmpty() ? AbstractC3901sg0.a() : this.c.entrySet();
    }

    public final Set p() {
        if (this.g == null) {
            this.g = new C3659pg0(this, null);
        }
        return this.g;
    }

    public final void q() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    public final SortedMap r() {
        q();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.c = treeMap;
            this.f = treeMap.descendingMap();
        }
        return (SortedMap) this.c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        q();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return l(iA);
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

    public /* synthetic */ AbstractC3577og0(int i, C3495ng0 c3495ng0) {
        this(i);
    }
}
