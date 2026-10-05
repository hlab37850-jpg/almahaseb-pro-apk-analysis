package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class MutableVectorWithMutationTracking<T> {
    private final InterfaceC3588op onVectorMutated;
    private final MutableVector<T> vector;

    public MutableVectorWithMutationTracking(MutableVector<T> mutableVector, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(mutableVector, "vector");
        AbstractC4492zt.h(interfaceC3588op, "onVectorMutated");
        this.vector = mutableVector;
        this.onVectorMutated = interfaceC3588op;
    }

    public final void add(int i, T t) {
        this.vector.add(i, t);
        this.onVectorMutated.invoke();
    }

    public final List<T> asList() {
        return this.vector.asMutableList();
    }

    public final void clear() {
        this.vector.clear();
        this.onVectorMutated.invoke();
    }

    public final void forEach(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        MutableVector<T> vector = getVector();
        int size = vector.getSize();
        if (size > 0) {
            T[] content = vector.getContent();
            int i = 0;
            do {
                interfaceC3750qp.invoke(content[i]);
                i++;
            } while (i < size);
        }
    }

    public final T get(int i) {
        return this.vector.getContent()[i];
    }

    public final InterfaceC3588op getOnVectorMutated() {
        return this.onVectorMutated;
    }

    public final int getSize() {
        return this.vector.getSize();
    }

    public final MutableVector<T> getVector() {
        return this.vector;
    }

    public final T removeAt(int i) {
        T tRemoveAt = this.vector.removeAt(i);
        this.onVectorMutated.invoke();
        return tRemoveAt;
    }
}
