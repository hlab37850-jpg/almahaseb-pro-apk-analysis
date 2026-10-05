package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import defpackage.AbstractC1163Zb;
import defpackage.BG;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class MultimapBuilder<K0, V0> {
    private static final int DEFAULT_EXPECTED_KEYS = 8;

    public static abstract class MultimapBuilderWithKeys<K0> {
        private static final int DEFAULT_EXPECTED_VALUES_PER_KEY = 2;

        public class a extends ListMultimapBuilder {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
            public ListMultimap build() {
                return Multimaps.newListMultimap(MultimapBuilderWithKeys.this.createMap(), new e(this.a));
            }
        }

        public class b extends ListMultimapBuilder {
            public b() {
            }

            @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
            public ListMultimap build() {
                return Multimaps.newListMultimap(MultimapBuilderWithKeys.this.createMap(), i.c());
            }
        }

        public class c extends SetMultimapBuilder {
            public final /* synthetic */ int a;

            public c(int i) {
                this.a = i;
            }

            @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            public SetMultimap build() {
                return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.createMap(), new g(this.a));
            }
        }

        public class d extends SetMultimapBuilder {
            public final /* synthetic */ int a;

            public d(int i) {
                this.a = i;
            }

            @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            public SetMultimap build() {
                return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.createMap(), new h(this.a));
            }
        }

        public class f extends SetMultimapBuilder {
            public final /* synthetic */ Class a;

            public f(Class cls) {
                this.a = cls;
            }

            @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            public SetMultimap build() {
                return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.createMap(), new f(this.a));
            }
        }

        public ListMultimapBuilder<K0, Object> arrayListValues() {
            return arrayListValues(2);
        }

        public abstract <K extends K0, V> Map<K, Collection<V>> createMap();

        public <V0 extends Enum<V0>> SetMultimapBuilder<K0, V0> enumSetValues(Class<V0> cls) {
            Preconditions.checkNotNull(cls, "valueClass");
            return new f(cls);
        }

        public SetMultimapBuilder<K0, Object> hashSetValues() {
            return hashSetValues(2);
        }

        public SetMultimapBuilder<K0, Object> linkedHashSetValues() {
            return linkedHashSetValues(2);
        }

        public ListMultimapBuilder<K0, Object> linkedListValues() {
            return new b();
        }

        public SortedSetMultimapBuilder<K0, Comparable> treeSetValues() {
            return treeSetValues(Ordering.natural());
        }

        public class e extends SortedSetMultimapBuilder {
            public final /* synthetic */ Comparator a;

            public e(Comparator comparator) {
                this.a = comparator;
            }

            @Override // com.google.common.collect.MultimapBuilder.SortedSetMultimapBuilder, com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            public SortedSetMultimap build() {
                return Multimaps.newSortedSetMultimap(MultimapBuilderWithKeys.this.createMap(), new j(this.a));
            }
        }

        public ListMultimapBuilder<K0, Object> arrayListValues(int i) {
            AbstractC1163Zb.b(i, "expectedValuesPerKey");
            return new a(i);
        }

        public SetMultimapBuilder<K0, Object> hashSetValues(int i) {
            AbstractC1163Zb.b(i, "expectedValuesPerKey");
            return new c(i);
        }

        public SetMultimapBuilder<K0, Object> linkedHashSetValues(int i) {
            AbstractC1163Zb.b(i, "expectedValuesPerKey");
            return new d(i);
        }

        public <V0> SortedSetMultimapBuilder<K0, V0> treeSetValues(Comparator<V0> comparator) {
            Preconditions.checkNotNull(comparator, "comparator");
            return new e(comparator);
        }
    }

    public class a extends MultimapBuilderWithKeys {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public Map createMap() {
            return BG.c(this.a);
        }
    }

    public class b extends MultimapBuilderWithKeys {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public Map createMap() {
            return BG.e(this.a);
        }
    }

    public class c extends MultimapBuilderWithKeys {
        public final /* synthetic */ Comparator a;

        public c(Comparator comparator) {
            this.a = comparator;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public Map createMap() {
            return new TreeMap(this.a);
        }
    }

    public class d extends MultimapBuilderWithKeys {
        public final /* synthetic */ Class a;

        public d(Class cls) {
            this.a = cls;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public Map createMap() {
            return new EnumMap(this.a);
        }
    }

    public static final class e implements Supplier, Serializable {
        public final int a;

        public e(int i) {
            this.a = AbstractC1163Zb.b(i, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List get() {
            return new ArrayList(this.a);
        }
    }

    public static final class f implements Supplier, Serializable {
        public final Class a;

        public f(Class cls) {
            this.a = (Class) Preconditions.checkNotNull(cls);
        }

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Set get() {
            return EnumSet.noneOf(this.a);
        }
    }

    public static final class g implements Supplier, Serializable {
        public final int a;

        public g(int i) {
            this.a = AbstractC1163Zb.b(i, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Set get() {
            return BG.d(this.a);
        }
    }

    public static final class h implements Supplier, Serializable {
        public final int a;

        public h(int i) {
            this.a = AbstractC1163Zb.b(i, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Set get() {
            return BG.f(this.a);
        }
    }

    public enum i implements Supplier {
        INSTANCE;

        public static Supplier c() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List get() {
            return new LinkedList();
        }
    }

    public static final class j implements Supplier, Serializable {
        public final Comparator a;

        public j(Comparator comparator) {
            this.a = (Comparator) Preconditions.checkNotNull(comparator);
        }

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SortedSet get() {
            return new TreeSet(this.a);
        }
    }

    public /* synthetic */ MultimapBuilder(a aVar) {
        this();
    }

    public static <K0 extends Enum<K0>> MultimapBuilderWithKeys<K0> enumKeys(Class<K0> cls) {
        Preconditions.checkNotNull(cls);
        return new d(cls);
    }

    public static MultimapBuilderWithKeys<Object> hashKeys() {
        return hashKeys(8);
    }

    public static MultimapBuilderWithKeys<Object> linkedHashKeys() {
        return linkedHashKeys(8);
    }

    public static MultimapBuilderWithKeys<Comparable> treeKeys() {
        return treeKeys(Ordering.natural());
    }

    public abstract <K extends K0, V extends V0> Multimap<K, V> build();

    public <K extends K0, V extends V0> Multimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
        Multimap<K, V> multimapBuild = build();
        multimapBuild.putAll(multimap);
        return multimapBuild;
    }

    public static abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        public ListMultimapBuilder() {
            super(null);
        }

        @Override // com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> ListMultimap<K, V> build();

        @Override // com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> ListMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (ListMultimap) super.build((Multimap) multimap);
        }
    }

    public static abstract class SetMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        public SetMultimapBuilder() {
            super(null);
        }

        @Override // com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> SetMultimap<K, V> build();

        @Override // com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> SetMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (SetMultimap) super.build((Multimap) multimap);
        }
    }

    private MultimapBuilder() {
    }

    public static MultimapBuilderWithKeys<Object> hashKeys(int i2) {
        AbstractC1163Zb.b(i2, "expectedKeys");
        return new a(i2);
    }

    public static MultimapBuilderWithKeys<Object> linkedHashKeys(int i2) {
        AbstractC1163Zb.b(i2, "expectedKeys");
        return new b(i2);
    }

    public static <K0> MultimapBuilderWithKeys<K0> treeKeys(Comparator<K0> comparator) {
        Preconditions.checkNotNull(comparator);
        return new c(comparator);
    }

    public static abstract class SortedSetMultimapBuilder<K0, V0> extends SetMultimapBuilder<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> SortedSetMultimap<K, V> build();

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> SortedSetMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (SortedSetMultimap) super.build((Multimap) multimap);
        }
    }
}
