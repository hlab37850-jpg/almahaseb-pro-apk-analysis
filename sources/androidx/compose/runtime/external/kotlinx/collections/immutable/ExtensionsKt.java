package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.UtilsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetBuilder;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC2371hc;
import defpackage.AbstractC4123vS;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4362yO;
import defpackage.Q5;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ExtensionsKt {
    public static final <K, V> PersistentMap<K, V> immutableHashMapOf(C2020dG... c2020dGArr) {
        AbstractC4492zt.h(c2020dGArr, "pairs");
        return persistentHashMapOf((C2020dG[]) Arrays.copyOf(c2020dGArr, c2020dGArr.length));
    }

    public static final <E> PersistentSet<E> immutableHashSetOf(E... eArr) {
        AbstractC4492zt.h(eArr, "elements");
        return persistentHashSetOf(Arrays.copyOf(eArr, eArr.length));
    }

    public static final <E> PersistentList<E> immutableListOf(E... eArr) {
        AbstractC4492zt.h(eArr, "elements");
        return persistentListOf(Arrays.copyOf(eArr, eArr.length));
    }

    public static final <K, V> PersistentMap<K, V> immutableMapOf(C2020dG... c2020dGArr) {
        AbstractC4492zt.h(c2020dGArr, "pairs");
        return persistentMapOf((C2020dG[]) Arrays.copyOf(c2020dGArr, c2020dGArr.length));
    }

    public static final <E> PersistentSet<E> immutableSetOf(E... eArr) {
        AbstractC4492zt.h(eArr, "elements");
        return persistentSetOf(Arrays.copyOf(eArr, eArr.length));
    }

    public static final <E> PersistentSet<E> intersect(PersistentSet<? extends E> persistentSet, Iterable<? extends E> iterable) {
        AbstractC4492zt.h(persistentSet, "<this>");
        AbstractC4492zt.h(iterable, "elements");
        if (iterable instanceof Collection) {
            return persistentSet.retainAll((Collection<? extends Object>) iterable);
        }
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        AbstractC2371hc.R(builder, iterable);
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentCollection<E> minus(PersistentCollection<? extends E> persistentCollection, E e) {
        AbstractC4492zt.h(persistentCollection, "<this>");
        return persistentCollection.remove((Object) e);
    }

    public static final <T> PersistentSet<T> mutate(PersistentSet<? extends T> persistentSet, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(persistentSet, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "mutator");
        PersistentSet.Builder<? extends T> builder = persistentSet.builder();
        interfaceC3750qp.invoke(builder);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> persistentHashMapOf(C2020dG... c2020dGArr) {
        AbstractC4492zt.h(c2020dGArr, "pairs");
        PersistentHashMap<K, V> persistentHashMapEmptyOf$runtime_release = PersistentHashMap.Companion.emptyOf$runtime_release();
        AbstractC4492zt.f(persistentHashMapEmptyOf$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder<K, V> builder = persistentHashMapEmptyOf$runtime_release.builder2();
        AbstractC4243wx.p(builder, c2020dGArr);
        return builder.build2();
    }

    public static final <E> PersistentSet<E> persistentHashSetOf(E... eArr) {
        AbstractC4492zt.h(eArr, "elements");
        return PersistentHashSet.Companion.emptyOf$runtime_release().addAll((Collection) Q5.c(eArr));
    }

    public static final <E> PersistentList<E> persistentListOf(E... eArr) {
        AbstractC4492zt.h(eArr, "elements");
        return UtilsKt.persistentVectorOf().addAll((Collection) Q5.c(eArr));
    }

    public static final <K, V> PersistentMap<K, V> persistentMapOf(C2020dG... c2020dGArr) {
        AbstractC4492zt.h(c2020dGArr, "pairs");
        PersistentOrderedMap<K, V> persistentOrderedMapEmptyOf$runtime_release = PersistentOrderedMap.Companion.emptyOf$runtime_release();
        AbstractC4492zt.f(persistentOrderedMapEmptyOf$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder<K, V> builder = persistentOrderedMapEmptyOf$runtime_release.builder2();
        AbstractC4243wx.p(builder, c2020dGArr);
        return builder.build2();
    }

    public static final <E> PersistentSet<E> persistentSetOf(E... eArr) {
        AbstractC4492zt.h(eArr, "elements");
        return PersistentOrderedSet.Companion.emptyOf$runtime_release().addAll((Collection) Q5.c(eArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentCollection<E> plus(PersistentCollection<? extends E> persistentCollection, E e) {
        AbstractC4492zt.h(persistentCollection, "<this>");
        return persistentCollection.add((Object) e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> PersistentMap<K, V> putAll(PersistentMap<? extends K, ? extends V> persistentMap, Map<? extends K, ? extends V> map) {
        AbstractC4492zt.h(persistentMap, "<this>");
        AbstractC4492zt.h(map, HTML.Tag.MAP);
        return persistentMap.putAll((Map<? extends Object, ? extends Object>) map);
    }

    public static final <T> ImmutableList<T> toImmutableList(Iterable<? extends T> iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        ImmutableList<T> immutableList = iterable instanceof ImmutableList ? (ImmutableList) iterable : null;
        return immutableList == null ? toPersistentList(iterable) : immutableList;
    }

    public static final <K, V> ImmutableMap<K, V> toImmutableMap(Map<K, ? extends V> map) {
        AbstractC4492zt.h(map, "<this>");
        ImmutableMap<K, V> immutableMap = map instanceof ImmutableMap ? (ImmutableMap) map : null;
        if (immutableMap != null) {
            return immutableMap;
        }
        PersistentMap.Builder builder = map instanceof PersistentMap.Builder ? (PersistentMap.Builder) map : null;
        PersistentMap<K, V> persistentMapBuild = builder != null ? builder.build2() : null;
        return persistentMapBuild != null ? persistentMapBuild : persistentMapOf().putAll((Map) map);
    }

    public static final <T> ImmutableSet<T> toImmutableSet(Iterable<? extends T> iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        ImmutableSet<T> immutableSet = iterable instanceof ImmutableSet ? (ImmutableSet) iterable : null;
        if (immutableSet != null) {
            return immutableSet;
        }
        PersistentSet.Builder builder = iterable instanceof PersistentSet.Builder ? (PersistentSet.Builder) iterable : null;
        PersistentSet persistentSetBuild = builder != null ? builder.build() : null;
        return persistentSetBuild != null ? persistentSetBuild : plus(persistentSetOf(), (Iterable) iterable);
    }

    public static final <K, V> PersistentMap<K, V> toPersistentHashMap(Map<K, ? extends V> map) {
        AbstractC4492zt.h(map, "<this>");
        PersistentHashMap persistentHashMap = map instanceof PersistentHashMap ? (PersistentHashMap) map : null;
        if (persistentHashMap != null) {
            return persistentHashMap;
        }
        PersistentHashMapBuilder persistentHashMapBuilder = map instanceof PersistentHashMapBuilder ? (PersistentHashMapBuilder) map : null;
        PersistentHashMap<K, V> persistentHashMapBuild = persistentHashMapBuilder != null ? persistentHashMapBuilder.build2() : null;
        return persistentHashMapBuild != null ? persistentHashMapBuild : PersistentHashMap.Companion.emptyOf$runtime_release().putAll((Map) map);
    }

    public static final <T> PersistentSet<T> toPersistentHashSet(Iterable<? extends T> iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        PersistentHashSet persistentHashSet = iterable instanceof PersistentHashSet ? (PersistentHashSet) iterable : null;
        if (persistentHashSet != null) {
            return persistentHashSet;
        }
        PersistentHashSetBuilder persistentHashSetBuilder = iterable instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) iterable : null;
        PersistentHashSet persistentHashSetBuild = persistentHashSetBuilder != null ? persistentHashSetBuilder.build() : null;
        return persistentHashSetBuild != null ? persistentHashSetBuild : plus(PersistentHashSet.Companion.emptyOf$runtime_release(), (Iterable) iterable);
    }

    public static final <T> PersistentList<T> toPersistentList(Iterable<? extends T> iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        PersistentList<T> persistentList = iterable instanceof PersistentList ? (PersistentList) iterable : null;
        if (persistentList != null) {
            return persistentList;
        }
        PersistentList.Builder builder = iterable instanceof PersistentList.Builder ? (PersistentList.Builder) iterable : null;
        PersistentList<T> persistentListBuild = builder != null ? builder.build() : null;
        return persistentListBuild == null ? plus(persistentListOf(), (Iterable) iterable) : persistentListBuild;
    }

    public static final <K, V> PersistentMap<K, V> toPersistentMap(Map<K, ? extends V> map) {
        AbstractC4492zt.h(map, "<this>");
        PersistentOrderedMap persistentOrderedMap = map instanceof PersistentOrderedMap ? (PersistentOrderedMap) map : null;
        if (persistentOrderedMap != null) {
            return persistentOrderedMap;
        }
        PersistentOrderedMapBuilder persistentOrderedMapBuilder = map instanceof PersistentOrderedMapBuilder ? (PersistentOrderedMapBuilder) map : null;
        PersistentMap<K, V> persistentMapBuild = persistentOrderedMapBuilder != null ? persistentOrderedMapBuilder.build2() : null;
        return persistentMapBuild == null ? PersistentOrderedMap.Companion.emptyOf$runtime_release().putAll((Map) map) : persistentMapBuild;
    }

    public static final <T> PersistentSet<T> toPersistentSet(Iterable<? extends T> iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        PersistentOrderedSet persistentOrderedSet = iterable instanceof PersistentOrderedSet ? (PersistentOrderedSet) iterable : null;
        if (persistentOrderedSet != null) {
            return persistentOrderedSet;
        }
        PersistentOrderedSetBuilder persistentOrderedSetBuilder = iterable instanceof PersistentOrderedSetBuilder ? (PersistentOrderedSetBuilder) iterable : null;
        PersistentSet<T> persistentSetBuild = persistentOrderedSetBuilder != null ? persistentOrderedSetBuilder.build() : null;
        return persistentSetBuild == null ? plus(PersistentOrderedSet.Companion.emptyOf$runtime_release(), (Iterable) iterable) : persistentSetBuild;
    }

    public static final <E> PersistentList<E> immutableListOf() {
        return persistentListOf();
    }

    public static final <E> PersistentSet<E> immutableSetOf() {
        return persistentSetOf();
    }

    public static final <E> PersistentCollection<E> minus(PersistentCollection<? extends E> persistentCollection, Iterable<? extends E> iterable) {
        AbstractC4492zt.h(persistentCollection, "<this>");
        AbstractC4492zt.h(iterable, "elements");
        if (iterable instanceof Collection) {
            return persistentCollection.removeAll((Collection<? extends Object>) iterable);
        }
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        AbstractC2371hc.K(builder, iterable);
        return builder.build();
    }

    public static final <T> PersistentList<T> mutate(PersistentList<? extends T> persistentList, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(persistentList, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "mutator");
        PersistentList.Builder<? extends T> builder = persistentList.builder();
        interfaceC3750qp.invoke(builder);
        return builder.build();
    }

    public static final <E> PersistentSet<E> persistentHashSetOf() {
        return PersistentHashSet.Companion.emptyOf$runtime_release();
    }

    public static final <E> PersistentList<E> persistentListOf() {
        return UtilsKt.persistentVectorOf();
    }

    public static final <E> PersistentSet<E> persistentSetOf() {
        return PersistentOrderedSet.Companion.emptyOf$runtime_release();
    }

    public static final <E> PersistentCollection<E> plus(PersistentCollection<? extends E> persistentCollection, Iterable<? extends E> iterable) {
        AbstractC4492zt.h(persistentCollection, "<this>");
        AbstractC4492zt.h(iterable, "elements");
        if (iterable instanceof Collection) {
            return persistentCollection.addAll((Collection<? extends Object>) iterable);
        }
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        AbstractC2371hc.D(builder, iterable);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> putAll(PersistentMap<? extends K, ? extends V> persistentMap, Iterable<? extends C2020dG> iterable) {
        AbstractC4492zt.h(persistentMap, "<this>");
        AbstractC4492zt.h(iterable, "pairs");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder2();
        AbstractC4243wx.o(builder, iterable);
        return builder.build2();
    }

    public static final <E> PersistentCollection<E> minus(PersistentCollection<? extends E> persistentCollection, E[] eArr) {
        AbstractC4492zt.h(persistentCollection, "<this>");
        AbstractC4492zt.h(eArr, "elements");
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        AbstractC2371hc.L(builder, eArr);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> mutate(PersistentMap<? extends K, ? extends V> persistentMap, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(persistentMap, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "mutator");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder2();
        interfaceC3750qp.invoke(builder);
        return builder.build2();
    }

    public static final <E> PersistentCollection<E> plus(PersistentCollection<? extends E> persistentCollection, E[] eArr) {
        AbstractC4492zt.h(persistentCollection, "<this>");
        AbstractC4492zt.h(eArr, "elements");
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        AbstractC2371hc.E(builder, eArr);
        return builder.build();
    }

    public static final <T> ImmutableList<T> toImmutableList(InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        return toPersistentList(interfaceC4362yO);
    }

    public static final <E> PersistentCollection<E> minus(PersistentCollection<? extends E> persistentCollection, InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(persistentCollection, "<this>");
        AbstractC4492zt.h(interfaceC4362yO, "elements");
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        AbstractC2371hc.J(builder, interfaceC4362yO);
        return builder.build();
    }

    public static final <E> PersistentCollection<E> plus(PersistentCollection<? extends E> persistentCollection, InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(persistentCollection, "<this>");
        AbstractC4492zt.h(interfaceC4362yO, "elements");
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        AbstractC2371hc.C(builder, interfaceC4362yO);
        return builder.build();
    }

    public static final ImmutableList<Character> toImmutableList(CharSequence charSequence) {
        AbstractC4492zt.h(charSequence, "<this>");
        return toPersistentList(charSequence);
    }

    public static final <T> ImmutableSet<T> toImmutableSet(InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        return toPersistentSet(interfaceC4362yO);
    }

    public static final <T> PersistentSet<T> toPersistentHashSet(InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        return plus(persistentHashSetOf(), interfaceC4362yO);
    }

    public static final <T> PersistentList<T> toPersistentList(InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        return plus(persistentListOf(), interfaceC4362yO);
    }

    public static final <T> PersistentSet<T> toPersistentSet(InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(interfaceC4362yO, "<this>");
        return plus(persistentSetOf(), interfaceC4362yO);
    }

    public static final <E> PersistentSet<E> intersect(PersistentCollection<? extends E> persistentCollection, Iterable<? extends E> iterable) {
        AbstractC4492zt.h(persistentCollection, "<this>");
        AbstractC4492zt.h(iterable, "elements");
        return intersect(toPersistentSet(persistentCollection), (Iterable) iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentList<E> minus(PersistentList<? extends E> persistentList, E e) {
        AbstractC4492zt.h(persistentList, "<this>");
        return persistentList.remove((Object) e);
    }

    public static final <K, V> PersistentMap<K, V> persistentHashMapOf() {
        return PersistentHashMap.Companion.emptyOf$runtime_release();
    }

    public static final <K, V> PersistentMap<K, V> persistentMapOf() {
        return PersistentOrderedMap.Companion.emptyOf$runtime_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentList<E> plus(PersistentList<? extends E> persistentList, E e) {
        AbstractC4492zt.h(persistentList, "<this>");
        return persistentList.add((Object) e);
    }

    public static final <K, V> PersistentMap<K, V> putAll(PersistentMap<? extends K, ? extends V> persistentMap, C2020dG[] c2020dGArr) {
        AbstractC4492zt.h(persistentMap, "<this>");
        AbstractC4492zt.h(c2020dGArr, "pairs");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder2();
        AbstractC4243wx.p(builder, c2020dGArr);
        return builder.build2();
    }

    public static final PersistentSet<Character> toImmutableSet(CharSequence charSequence) {
        AbstractC4492zt.h(charSequence, "<this>");
        return toPersistentSet(charSequence);
    }

    public static final PersistentSet<Character> toPersistentHashSet(CharSequence charSequence) {
        AbstractC4492zt.h(charSequence, "<this>");
        PersistentSet.Builder builder = persistentHashSetOf().builder();
        AbstractC4123vS.H0(charSequence, builder);
        return builder.build();
    }

    public static final PersistentList<Character> toPersistentList(CharSequence charSequence) {
        AbstractC4492zt.h(charSequence, "<this>");
        PersistentList.Builder builder = persistentListOf().builder();
        AbstractC4123vS.H0(charSequence, builder);
        return builder.build();
    }

    public static final PersistentSet<Character> toPersistentSet(CharSequence charSequence) {
        AbstractC4492zt.h(charSequence, "<this>");
        PersistentSet.Builder builder = persistentSetOf().builder();
        AbstractC4123vS.H0(charSequence, builder);
        return builder.build();
    }

    public static final <E> PersistentList<E> minus(PersistentList<? extends E> persistentList, Iterable<? extends E> iterable) {
        AbstractC4492zt.h(persistentList, "<this>");
        AbstractC4492zt.h(iterable, "elements");
        if (iterable instanceof Collection) {
            return persistentList.removeAll((Collection<? extends Object>) iterable);
        }
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        AbstractC2371hc.K(builder, iterable);
        return builder.build();
    }

    public static final <E> PersistentList<E> plus(PersistentList<? extends E> persistentList, Iterable<? extends E> iterable) {
        AbstractC4492zt.h(persistentList, "<this>");
        AbstractC4492zt.h(iterable, "elements");
        if (iterable instanceof Collection) {
            return persistentList.addAll((Collection<? extends Object>) iterable);
        }
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        AbstractC2371hc.D(builder, iterable);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> putAll(PersistentMap<? extends K, ? extends V> persistentMap, InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(persistentMap, "<this>");
        AbstractC4492zt.h(interfaceC4362yO, "pairs");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder2();
        AbstractC4243wx.n(builder, interfaceC4362yO);
        return builder.build2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentSet<E> minus(PersistentSet<? extends E> persistentSet, E e) {
        AbstractC4492zt.h(persistentSet, "<this>");
        return persistentSet.remove((Object) e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentSet<E> plus(PersistentSet<? extends E> persistentSet, E e) {
        AbstractC4492zt.h(persistentSet, "<this>");
        return persistentSet.add((Object) e);
    }

    public static final <E> PersistentSet<E> minus(PersistentSet<? extends E> persistentSet, Iterable<? extends E> iterable) {
        AbstractC4492zt.h(persistentSet, "<this>");
        AbstractC4492zt.h(iterable, "elements");
        if (iterable instanceof Collection) {
            return persistentSet.removeAll((Collection<? extends Object>) iterable);
        }
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        AbstractC2371hc.K(builder, iterable);
        return builder.build();
    }

    public static final <E> PersistentSet<E> plus(PersistentSet<? extends E> persistentSet, Iterable<? extends E> iterable) {
        AbstractC4492zt.h(persistentSet, "<this>");
        AbstractC4492zt.h(iterable, "elements");
        if (iterable instanceof Collection) {
            return persistentSet.addAll((Collection<? extends Object>) iterable);
        }
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        AbstractC2371hc.D(builder, iterable);
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> PersistentMap<K, V> minus(PersistentMap<? extends K, ? extends V> persistentMap, K k) {
        AbstractC4492zt.h(persistentMap, "<this>");
        return persistentMap.remove((Object) k);
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> persistentMap, C2020dG c2020dG) {
        AbstractC4492zt.h(persistentMap, "<this>");
        AbstractC4492zt.h(c2020dG, "pair");
        return persistentMap.put(c2020dG.c(), c2020dG.e());
    }

    public static final <E> PersistentList<E> minus(PersistentList<? extends E> persistentList, E[] eArr) {
        AbstractC4492zt.h(persistentList, "<this>");
        AbstractC4492zt.h(eArr, "elements");
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        AbstractC2371hc.L(builder, eArr);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> persistentMap, Iterable<? extends C2020dG> iterable) {
        AbstractC4492zt.h(persistentMap, "<this>");
        AbstractC4492zt.h(iterable, "pairs");
        return putAll(persistentMap, iterable);
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> persistentMap, C2020dG[] c2020dGArr) {
        AbstractC4492zt.h(persistentMap, "<this>");
        AbstractC4492zt.h(c2020dGArr, "pairs");
        return putAll(persistentMap, c2020dGArr);
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> persistentMap, InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(persistentMap, "<this>");
        AbstractC4492zt.h(interfaceC4362yO, "pairs");
        return putAll(persistentMap, interfaceC4362yO);
    }

    public static final <E> PersistentList<E> minus(PersistentList<? extends E> persistentList, InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(persistentList, "<this>");
        AbstractC4492zt.h(interfaceC4362yO, "elements");
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        AbstractC2371hc.J(builder, interfaceC4362yO);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> persistentMap, Map<? extends K, ? extends V> map) {
        AbstractC4492zt.h(persistentMap, "<this>");
        AbstractC4492zt.h(map, HTML.Tag.MAP);
        return putAll(persistentMap, map);
    }

    public static final <E> PersistentList<E> plus(PersistentList<? extends E> persistentList, E[] eArr) {
        AbstractC4492zt.h(persistentList, "<this>");
        AbstractC4492zt.h(eArr, "elements");
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        AbstractC2371hc.E(builder, eArr);
        return builder.build();
    }

    public static final <E> PersistentSet<E> minus(PersistentSet<? extends E> persistentSet, E[] eArr) {
        AbstractC4492zt.h(persistentSet, "<this>");
        AbstractC4492zt.h(eArr, "elements");
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        AbstractC2371hc.L(builder, eArr);
        return builder.build();
    }

    public static final <E> PersistentList<E> plus(PersistentList<? extends E> persistentList, InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(persistentList, "<this>");
        AbstractC4492zt.h(interfaceC4362yO, "elements");
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        AbstractC2371hc.C(builder, interfaceC4362yO);
        return builder.build();
    }

    public static final <E> PersistentSet<E> minus(PersistentSet<? extends E> persistentSet, InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(persistentSet, "<this>");
        AbstractC4492zt.h(interfaceC4362yO, "elements");
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        AbstractC2371hc.J(builder, interfaceC4362yO);
        return builder.build();
    }

    public static final <E> PersistentSet<E> plus(PersistentSet<? extends E> persistentSet, E[] eArr) {
        AbstractC4492zt.h(persistentSet, "<this>");
        AbstractC4492zt.h(eArr, "elements");
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        AbstractC2371hc.E(builder, eArr);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> minus(PersistentMap<? extends K, ? extends V> persistentMap, Iterable<? extends K> iterable) {
        AbstractC4492zt.h(persistentMap, "<this>");
        AbstractC4492zt.h(iterable, "keys");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder2();
        AbstractC2371hc.K(builder.keySet(), iterable);
        return builder.build2();
    }

    public static final <E> PersistentSet<E> plus(PersistentSet<? extends E> persistentSet, InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(persistentSet, "<this>");
        AbstractC4492zt.h(interfaceC4362yO, "elements");
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        AbstractC2371hc.C(builder, interfaceC4362yO);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> minus(PersistentMap<? extends K, ? extends V> persistentMap, K[] kArr) {
        AbstractC4492zt.h(persistentMap, "<this>");
        AbstractC4492zt.h(kArr, "keys");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder2();
        AbstractC2371hc.L(builder.keySet(), kArr);
        return builder.build2();
    }

    public static final <K, V> PersistentMap<K, V> minus(PersistentMap<? extends K, ? extends V> persistentMap, InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(persistentMap, "<this>");
        AbstractC4492zt.h(interfaceC4362yO, "keys");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder2();
        AbstractC2371hc.J(builder.keySet(), interfaceC4362yO);
        return builder.build2();
    }
}
