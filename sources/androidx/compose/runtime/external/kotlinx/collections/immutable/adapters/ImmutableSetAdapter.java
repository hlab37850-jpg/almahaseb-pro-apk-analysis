package androidx.compose.runtime.external.kotlinx.collections.immutable.adapters;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import defpackage.AbstractC4492zt;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ImmutableSetAdapter<E> extends ImmutableCollectionAdapter<E> implements ImmutableSet<E> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmutableSetAdapter(Set<? extends E> set) {
        super(set);
        AbstractC4492zt.h(set, "impl");
    }
}
