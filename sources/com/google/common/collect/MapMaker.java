package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class MapMaker {
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final int UNSET_INT = -1;
    Equivalence<Object> keyEquivalence;
    v.n keyStrength;
    boolean useCustomMap;
    v.n valueStrength;
    int initialCapacity = -1;
    int concurrencyLevel = -1;

    public enum a {
        VALUE
    }

    @CanIgnoreReturnValue
    public MapMaker concurrencyLevel(int i) {
        int i2 = this.concurrencyLevel;
        Preconditions.checkState(i2 == -1, "concurrency level was already set to %s", i2);
        Preconditions.checkArgument(i > 0);
        this.concurrencyLevel = i;
        return this;
    }

    public int getConcurrencyLevel() {
        int i = this.concurrencyLevel;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    public int getInitialCapacity() {
        int i = this.initialCapacity;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    public Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().b());
    }

    public v.n getKeyStrength() {
        return (v.n) MoreObjects.firstNonNull(this.keyStrength, v.n.a);
    }

    public v.n getValueStrength() {
        return (v.n) MoreObjects.firstNonNull(this.valueStrength, v.n.a);
    }

    @CanIgnoreReturnValue
    public MapMaker initialCapacity(int i) {
        int i2 = this.initialCapacity;
        Preconditions.checkState(i2 == -1, "initial capacity was already set to %s", i2);
        Preconditions.checkArgument(i >= 0);
        this.initialCapacity = i;
        return this;
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker keyEquivalence(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.keyEquivalence;
        Preconditions.checkState(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        this.useCustomMap = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> makeMap() {
        return !this.useCustomMap ? new ConcurrentHashMap(getInitialCapacity(), 0.75f, getConcurrencyLevel()) : v.b(this);
    }

    public MapMaker setKeyStrength(v.n nVar) {
        v.n nVar2 = this.keyStrength;
        Preconditions.checkState(nVar2 == null, "Key strength was already set to %s", nVar2);
        this.keyStrength = (v.n) Preconditions.checkNotNull(nVar);
        if (nVar != v.n.a) {
            this.useCustomMap = true;
        }
        return this;
    }

    public MapMaker setValueStrength(v.n nVar) {
        v.n nVar2 = this.valueStrength;
        Preconditions.checkState(nVar2 == null, "Value strength was already set to %s", nVar2);
        this.valueStrength = (v.n) Preconditions.checkNotNull(nVar);
        if (nVar != v.n.a) {
            this.useCustomMap = true;
        }
        return this;
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper(this);
        int i = this.initialCapacity;
        if (i != -1) {
            stringHelper.add("initialCapacity", i);
        }
        int i2 = this.concurrencyLevel;
        if (i2 != -1) {
            stringHelper.add("concurrencyLevel", i2);
        }
        v.n nVar = this.keyStrength;
        if (nVar != null) {
            stringHelper.add("keyStrength", Ascii.toLowerCase(nVar.toString()));
        }
        v.n nVar2 = this.valueStrength;
        if (nVar2 != null) {
            stringHelper.add("valueStrength", Ascii.toLowerCase(nVar2.toString()));
        }
        if (this.keyEquivalence != null) {
            stringHelper.addValue("keyEquivalence");
        }
        return stringHelper.toString();
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker weakKeys() {
        return setKeyStrength(v.n.b);
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker weakValues() {
        return setValueStrength(v.n.b);
    }
}
