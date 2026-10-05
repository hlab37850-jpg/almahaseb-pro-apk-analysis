package com.google.common.collect;

import defpackage.AbstractC3590or;

/* JADX INFO: loaded from: classes3.dex */
public final class C extends ImmutableSet {
    public static final Object[] f;
    public static final C g;
    public final transient Object[] a;
    public final transient int b;
    public final transient Object[] c;
    public final transient int d;
    public final transient int e;

    static {
        Object[] objArr = new Object[0];
        f = objArr;
        g = new C(objArr, 0, objArr, 0, 0);
    }

    public C(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.a = objArr;
        this.b = i;
        this.c = objArr2;
        this.d = i2;
        this.e = i3;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Object[] objArr = this.c;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iD = AbstractC3590or.d(obj);
        while (true) {
            int i = iD & this.d;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iD = i + 1;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i) {
        System.arraycopy(this.a, 0, objArr, i, this.e);
        return i + this.e;
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList createAsList() {
        return ImmutableList.asImmutableList(this.a, this.e);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.b;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.a;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.e;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.e;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator iterator() {
        return asList().iterator();
    }
}
