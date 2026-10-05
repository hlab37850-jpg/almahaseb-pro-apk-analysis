package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public abstract class I {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class b {
        public static final b a = new a("NEXT_LOWER", 0);
        public static final b b = new C0217b("NEXT_HIGHER", 1);
        public static final b c = new c("INVERTED_INSERTION_INDEX", 2);
        public static final /* synthetic */ b[] d = a();

        public final enum a extends b {
            public a(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.collect.I.b
            public int b(int i) {
                return i - 1;
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.I$b$b, reason: collision with other inner class name */
        public final enum C0217b extends b {
            public C0217b(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.collect.I.b
            public int b(int i) {
                return i;
            }
        }

        public final enum c extends b {
            public c(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.collect.I.b
            public int b(int i) {
                return ~i;
            }
        }

        public b(String str, int i) {
            super(str, i);
        }

        public static /* synthetic */ b[] a() {
            return new b[]{a, b, c};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) d.clone();
        }

        public abstract int b(int i);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class c {
        public static final c a = new a("ANY_PRESENT", 0);
        public static final c b = new b("LAST_PRESENT", 1);
        public static final c c = new C0218c("FIRST_PRESENT", 2);
        public static final c d = new d("FIRST_AFTER", 3);
        public static final c e = new e("LAST_BEFORE", 4);
        public static final /* synthetic */ c[] f = a();

        public final enum a extends c {
            public a(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.collect.I.c
            public int b(Comparator comparator, Object obj, List list, int i) {
                return i;
            }
        }

        public final enum b extends c {
            public b(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.collect.I.c
            public int b(Comparator comparator, Object obj, List list, int i) {
                int size = list.size() - 1;
                while (i < size) {
                    int i2 = ((i + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i2), obj) > 0) {
                        size = i2 - 1;
                    } else {
                        i = i2;
                    }
                }
                return i;
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.I$c$c, reason: collision with other inner class name */
        public final enum C0218c extends c {
            public C0218c(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.collect.I.c
            public int b(Comparator comparator, Object obj, List list, int i) {
                int i2 = 0;
                while (i2 < i) {
                    int i3 = (i2 + i) >>> 1;
                    if (comparator.compare(list.get(i3), obj) < 0) {
                        i2 = i3 + 1;
                    } else {
                        i = i3;
                    }
                }
                return i2;
            }
        }

        public final enum d extends c {
            public d(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.collect.I.c
            public int b(Comparator comparator, Object obj, List list, int i) {
                return c.b.b(comparator, obj, list, i) + 1;
            }
        }

        public final enum e extends c {
            public e(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.collect.I.c
            public int b(Comparator comparator, Object obj, List list, int i) {
                return c.c.b(comparator, obj, list, i) - 1;
            }
        }

        public c(String str, int i) {
            super(str, i);
        }

        public static /* synthetic */ c[] a() {
            return new c[]{a, b, c, d, e};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f.clone();
        }

        public abstract int b(Comparator comparator, Object obj, List list, int i);
    }

    public static int a(List list, Function function, Comparable comparable, c cVar, b bVar) {
        Preconditions.checkNotNull(comparable);
        return b(list, function, comparable, Ordering.natural(), cVar, bVar);
    }

    public static int b(List list, Function function, Object obj, Comparator comparator, c cVar, b bVar) {
        return c(Lists.transform(list, function), obj, comparator, cVar, bVar);
    }

    public static int c(List list, Object obj, Comparator comparator, c cVar, b bVar) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(cVar);
        Preconditions.checkNotNull(bVar);
        if (!(list instanceof RandomAccess)) {
            list = Lists.newArrayList(list);
        }
        int size = list.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            int iCompare = comparator.compare(obj, list.get(i2));
            if (iCompare < 0) {
                size = i2 - 1;
            } else {
                if (iCompare <= 0) {
                    return i + cVar.b(comparator, obj, list.subList(i, size + 1), i2 - i);
                }
                i = i2 + 1;
            }
        }
        return bVar.b(i);
    }
}
