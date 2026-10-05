package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.graph.EndpointPair;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: nl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3502nl extends AbstractIterator {
    public final InterfaceC2417i7 a;
    public final Iterator b;
    public Object c;
    public Iterator d;

    /* JADX INFO: renamed from: nl$b */
    public static final class b extends AbstractC3502nl {
        @Override // com.google.common.collect.AbstractIterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public EndpointPair computeNext() {
            while (!this.d.hasNext()) {
                if (!a()) {
                    return (EndpointPair) endOfData();
                }
            }
            Object obj = this.c;
            Objects.requireNonNull(obj);
            return EndpointPair.ordered(obj, this.d.next());
        }

        public b(InterfaceC2417i7 interfaceC2417i7) {
            super(interfaceC2417i7);
        }
    }

    /* JADX INFO: renamed from: nl$c */
    public static final class c extends AbstractC3502nl {
        public Set e;

        @Override // com.google.common.collect.AbstractIterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public EndpointPair computeNext() {
            do {
                Objects.requireNonNull(this.e);
                while (this.d.hasNext()) {
                    Object next = this.d.next();
                    if (!this.e.contains(next)) {
                        Object obj = this.c;
                        Objects.requireNonNull(obj);
                        return EndpointPair.unordered(obj, next);
                    }
                }
                this.e.add(this.c);
            } while (a());
            this.e = null;
            return (EndpointPair) endOfData();
        }

        public c(InterfaceC2417i7 interfaceC2417i7) {
            super(interfaceC2417i7);
            this.e = Sets.newHashSetWithExpectedSize(interfaceC2417i7.nodes().size() + 1);
        }
    }

    public static AbstractC3502nl b(InterfaceC2417i7 interfaceC2417i7) {
        return interfaceC2417i7.isDirected() ? new b(interfaceC2417i7) : new c(interfaceC2417i7);
    }

    public final boolean a() {
        Preconditions.checkState(!this.d.hasNext());
        if (!this.b.hasNext()) {
            return false;
        }
        Object next = this.b.next();
        this.c = next;
        this.d = this.a.successors(next).iterator();
        return true;
    }

    public AbstractC3502nl(InterfaceC2417i7 interfaceC2417i7) {
        this.c = null;
        this.d = ImmutableSet.of().iterator();
        this.a = interfaceC2417i7;
        this.b = interfaceC2417i7.nodes().iterator();
    }
}
