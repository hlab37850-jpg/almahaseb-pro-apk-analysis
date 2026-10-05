package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: com.google.common.collect.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1962l extends F {
    public final ImmutableMap a;
    public final ImmutableMap b;
    public final ImmutableMap c;
    public final ImmutableMap d;
    public final int[] e;
    public final int[] f;
    public final Object[][] g;
    public final int[] h;
    public final int[] i;

    /* JADX INFO: renamed from: com.google.common.collect.l$b */
    public final class b extends d {
        public final int b;

        public b(int i) {
            super(C1962l.this.f[i]);
            this.b = i;
        }

        @Override // com.google.common.collect.C1962l.d
        public Object c(int i) {
            return C1962l.this.g[i][this.b];
        }

        @Override // com.google.common.collect.C1962l.d
        public ImmutableMap f() {
            return C1962l.this.a;
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.l$c */
    public final class c extends d {
        @Override // com.google.common.collect.C1962l.d
        public ImmutableMap f() {
            return C1962l.this.b;
        }

        @Override // com.google.common.collect.C1962l.d
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public ImmutableMap c(int i) {
            return C1962l.this.new b(i);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        public c() {
            super(C1962l.this.f.length);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.l$d */
    public static abstract class d extends ImmutableMap.b {
        public final int a;

        /* JADX INFO: renamed from: com.google.common.collect.l$d$a */
        public class a extends AbstractIterator {
            public int a = -1;
            public final int b;

            public a() {
                this.b = d.this.f().size();
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry computeNext() {
                int i = this.a;
                while (true) {
                    this.a = i + 1;
                    int i2 = this.a;
                    if (i2 >= this.b) {
                        return (Map.Entry) endOfData();
                    }
                    Object objC = d.this.c(i2);
                    if (objC != null) {
                        return Maps.immutableEntry(d.this.b(this.a), objC);
                    }
                    i = this.a;
                }
            }
        }

        public d(int i) {
            this.a = i;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public UnmodifiableIterator a() {
            return new a();
        }

        public Object b(int i) {
            return f().keySet().asList().get(i);
        }

        public abstract Object c(int i);

        @Override // com.google.common.collect.ImmutableMap.b, com.google.common.collect.ImmutableMap
        public ImmutableSet createKeySet() {
            return e() ? f().keySet() : super.createKeySet();
        }

        public final boolean e() {
            return this.a == f().size();
        }

        public abstract ImmutableMap f();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public Object get(Object obj) {
            Integer num = (Integer) f().get(obj);
            if (num == null) {
                return null;
            }
            return c(num.intValue());
        }

        @Override // java.util.Map
        public int size() {
            return this.a;
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.l$e */
    public final class e extends d {
        public final int b;

        public e(int i) {
            super(C1962l.this.e[i]);
            this.b = i;
        }

        @Override // com.google.common.collect.C1962l.d
        public Object c(int i) {
            return C1962l.this.g[this.b][i];
        }

        @Override // com.google.common.collect.C1962l.d
        public ImmutableMap f() {
            return C1962l.this.b;
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.l$f */
    public final class f extends d {
        @Override // com.google.common.collect.C1962l.d
        public ImmutableMap f() {
            return C1962l.this.a;
        }

        @Override // com.google.common.collect.C1962l.d
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public ImmutableMap c(int i) {
            return C1962l.this.new e(i);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        public f() {
            super(C1962l.this.e.length);
        }
    }

    public C1962l(ImmutableList immutableList, ImmutableSet immutableSet, ImmutableSet immutableSet2) {
        this.g = (Object[][]) Array.newInstance((Class<?>) Object.class, immutableSet.size(), immutableSet2.size());
        ImmutableMap immutableMapIndexMap = Maps.indexMap(immutableSet);
        this.a = immutableMapIndexMap;
        ImmutableMap immutableMapIndexMap2 = Maps.indexMap(immutableSet2);
        this.b = immutableMapIndexMap2;
        this.e = new int[immutableMapIndexMap.size()];
        this.f = new int[immutableMapIndexMap2.size()];
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            Table.Cell cell = (Table.Cell) immutableList.get(i);
            Object rowKey = cell.getRowKey();
            Object columnKey = cell.getColumnKey();
            Integer num = (Integer) this.a.get(rowKey);
            Objects.requireNonNull(num);
            int iIntValue = num.intValue();
            Integer num2 = (Integer) this.b.get(columnKey);
            Objects.requireNonNull(num2);
            int iIntValue2 = num2.intValue();
            b(rowKey, columnKey, this.g[iIntValue][iIntValue2], cell.getValue());
            this.g[iIntValue][iIntValue2] = cell.getValue();
            int[] iArr3 = this.e;
            iArr3[iIntValue] = iArr3[iIntValue] + 1;
            int[] iArr4 = this.f;
            iArr4[iIntValue2] = iArr4[iIntValue2] + 1;
            iArr[i] = iIntValue;
            iArr2[i] = iIntValue2;
        }
        this.h = iArr;
        this.i = iArr2;
        this.c = new f();
        this.d = new c();
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.a createSerializedForm() {
        return ImmutableTable.a.a(this, this.h, this.i);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public Object get(Object obj, Object obj2) {
        Integer num = (Integer) this.a.get(obj);
        Integer num2 = (Integer) this.b.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return this.g[num.intValue()][num2.intValue()];
    }

    @Override // com.google.common.collect.F
    public Table.Cell getCell(int i) {
        int i2 = this.h[i];
        int i3 = this.i[i];
        Object obj = rowKeySet().asList().get(i2);
        Object obj2 = columnKeySet().asList().get(i3);
        Object obj3 = this.g[i2][i3];
        Objects.requireNonNull(obj3);
        return ImmutableTable.cellOf(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.F
    public Object getValue(int i) {
        Object obj = this.g[this.h[i]][this.i[i]];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.h.length;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap columnMap() {
        return ImmutableMap.copyOf((Map) this.d);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap rowMap() {
        return ImmutableMap.copyOf((Map) this.c);
    }
}
