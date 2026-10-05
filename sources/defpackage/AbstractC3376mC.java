package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: mC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3376mC extends AbstractSet {
    public final Map a;
    public final Object b;

    /* JADX INFO: renamed from: mC$a */
    public class a extends AbstractIterator {
        public final /* synthetic */ Iterator a;

        public a(Iterator it) {
            this.a = it;
        }

        @Override // com.google.common.collect.AbstractIterator
        public Object computeNext() {
            while (this.a.hasNext()) {
                Map.Entry entry = (Map.Entry) this.a.next();
                if (AbstractC3376mC.this.b.equals(entry.getValue())) {
                    return entry.getKey();
                }
            }
            return endOfData();
        }
    }

    public AbstractC3376mC(Map map, Object obj) {
        this.a = (Map) Preconditions.checkNotNull(map);
        this.b = Preconditions.checkNotNull(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public UnmodifiableIterator iterator() {
        return new a(this.a.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.b.equals(this.a.get(obj));
    }
}
