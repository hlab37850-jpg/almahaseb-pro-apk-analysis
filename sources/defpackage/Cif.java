package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import java.util.Queue;

/* JADX INFO: renamed from: if, reason: invalid class name */
/* JADX INFO: loaded from: classes3.dex */
public final class Cif extends AbstractIterator {
    public final Queue a;

    public Cif(Queue queue) {
        this.a = (Queue) Preconditions.checkNotNull(queue);
    }

    @Override // com.google.common.collect.AbstractIterator
    public Object computeNext() {
        return this.a.isEmpty() ? endOfData() : this.a.remove();
    }
}
