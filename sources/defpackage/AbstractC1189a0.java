package defpackage;

import java.util.AbstractCollection;
import java.util.Collection;

/* JADX INFO: renamed from: a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1189a0 extends AbstractCollection implements Collection, InterfaceC0782Nu {
    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }
}
