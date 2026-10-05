package com.google.common.collect;

import com.google.common.primitives.Ints;
import defpackage.AbstractC0455Es;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class B extends ImmutableMultiset {
    public static final B d = new B(w.b());
    public final transient w a;
    public final transient int b;
    public transient ImmutableSet c;

    public final class b extends AbstractC0455Es {
        public b() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return B.this.contains(obj);
        }

        @Override // defpackage.AbstractC0455Es
        public Object get(int i) {
            return B.this.a.i(i);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return B.this.a.C();
        }
    }

    public static class c implements Serializable {
        public final Object[] a;
        public final int[] b;

        public c(Multiset multiset) {
            int size = multiset.entrySet().size();
            this.a = new Object[size];
            this.b = new int[size];
            int i = 0;
            for (Multiset.Entry entry : multiset.entrySet()) {
                this.a[i] = entry.getElement();
                this.b[i] = entry.getCount();
                i++;
            }
        }
    }

    public B(w wVar) {
        this.a = wVar;
        long jK = 0;
        for (int i = 0; i < wVar.C(); i++) {
            jK += (long) wVar.k(i);
        }
        this.b = Ints.saturatedCast(jK);
    }

    @Override // com.google.common.collect.Multiset
    public int count(Object obj) {
        return this.a.f(obj);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public Multiset.Entry getEntry(int i) {
        return this.a.g(i);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return this.b;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new c(this);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public ImmutableSet elementSet() {
        ImmutableSet immutableSet = this.c;
        if (immutableSet != null) {
            return immutableSet;
        }
        b bVar = new b();
        this.c = bVar;
        return bVar;
    }
}
