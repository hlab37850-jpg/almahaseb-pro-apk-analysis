package com.google.common.collect;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends ImmutableBiMap {
    public static final y f = new y();
    public final transient Object a;
    public final transient Object[] b;
    public final transient int c;
    public final transient int d;
    public final transient y e;

    public y() {
        this.a = null;
        this.b = new Object[0];
        this.c = 0;
        this.d = 0;
        this.e = this;
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet createEntrySet() {
        return new A.a(this, this.b, this.c, this.d);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet createKeySet() {
        return new A.b(this, new A.c(this.b, this.c, this.d));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public Object get(Object obj) {
        Object objF = A.f(this.a, this.b, this.d, this.c, obj);
        if (objF == null) {
            return null;
        }
        return objF;
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.d;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public ImmutableBiMap inverse() {
        return this.e;
    }

    public y(Object[] objArr, int i) {
        this.b = objArr;
        this.d = i;
        this.c = 0;
        int iChooseTableSize = i >= 2 ? ImmutableSet.chooseTableSize(i) : 0;
        this.a = A.e(objArr, i, iChooseTableSize, 0);
        this.e = new y(A.e(objArr, i, iChooseTableSize, 1), objArr, i, this);
    }

    public y(Object obj, Object[] objArr, int i, y yVar) {
        this.a = obj;
        this.b = objArr;
        this.c = 1;
        this.d = i;
        this.e = yVar;
    }
}
