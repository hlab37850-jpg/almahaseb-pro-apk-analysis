package defpackage;

import com.google.android.gms.internal.clearcut.zzcn;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Ha0 extends AbstractC4430z50 {
    public static final Ha0 b;
    public final List a;

    static {
        Ha0 ha0 = new Ha0();
        b = ha0;
        ha0.zzv();
    }

    public Ha0() {
        this(new ArrayList(10));
    }

    public static Ha0 a() {
        return b;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        zzw();
        this.a.add(i, obj);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.a.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        zzw();
        Object objRemove = this.a.remove(i);
        ((AbstractList) this).modCount++;
        return objRemove;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        zzw();
        Object obj2 = this.a.set(i, obj);
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.size();
    }

    @Override // com.google.android.gms.internal.clearcut.zzcn
    public final /* synthetic */ zzcn zzi(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.a);
        return new Ha0(arrayList);
    }

    public Ha0(List list) {
        this.a = list;
    }
}
