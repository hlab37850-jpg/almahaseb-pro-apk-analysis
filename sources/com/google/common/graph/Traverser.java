package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.DoNotMock;
import defpackage.InterfaceC2417i7;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@DoNotMock("Call forGraph or forTree, passing a lambda or a Graph with the desired edges (built with GraphBuilder)")
@Beta
public abstract class Traverser<N> {
    private final SuccessorsFunction<N> successorFunction;

    public class a extends Traverser {
        public final /* synthetic */ SuccessorsFunction a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SuccessorsFunction successorsFunction, SuccessorsFunction successorsFunction2) {
            super(successorsFunction, null);
            this.a = successorsFunction2;
        }

        @Override // com.google.common.graph.Traverser
        public g newTraversal() {
            return g.b(this.a);
        }
    }

    public class b extends Traverser {
        public final /* synthetic */ SuccessorsFunction a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SuccessorsFunction successorsFunction, SuccessorsFunction successorsFunction2) {
            super(successorsFunction, null);
            this.a = successorsFunction2;
        }

        @Override // com.google.common.graph.Traverser
        public g newTraversal() {
            return g.c(this.a);
        }
    }

    public class c implements Iterable {
        public final /* synthetic */ ImmutableSet a;

        public c(ImmutableSet immutableSet) {
            this.a = immutableSet;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return Traverser.this.newTraversal().a(this.a.iterator());
        }
    }

    public class d implements Iterable {
        public final /* synthetic */ ImmutableSet a;

        public d(ImmutableSet immutableSet) {
            this.a = immutableSet;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return Traverser.this.newTraversal().e(this.a.iterator());
        }
    }

    public class e implements Iterable {
        public final /* synthetic */ ImmutableSet a;

        public e(ImmutableSet immutableSet) {
            this.a = immutableSet;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return Traverser.this.newTraversal().d(this.a.iterator());
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class f {
        public static final f a = new a("FRONT", 0);
        public static final f b = new b("BACK", 1);
        public static final /* synthetic */ f[] c = a();

        public final enum a extends f {
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.graph.Traverser.f
            public void b(Deque deque, Object obj) {
                deque.addFirst(obj);
            }
        }

        public final enum b extends f {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.graph.Traverser.f
            public void b(Deque deque, Object obj) {
                deque.addLast(obj);
            }
        }

        public f(String str, int i) {
            super(str, i);
        }

        public static /* synthetic */ f[] a() {
            return new f[]{a, b};
        }

        public static f valueOf(String str) {
            return (f) Enum.valueOf(f.class, str);
        }

        public static f[] values() {
            return (f[]) c.clone();
        }

        public abstract void b(Deque deque, Object obj);

        public /* synthetic */ f(String str, int i, a aVar) {
            this(str, i);
        }
    }

    public static abstract class g {
        public final SuccessorsFunction a;

        public class a extends g {
            public final /* synthetic */ Set b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(SuccessorsFunction successorsFunction, Set set) {
                super(successorsFunction);
                this.b = set;
            }

            @Override // com.google.common.graph.Traverser.g
            public Object g(Deque deque) {
                Iterator it = (Iterator) deque.getFirst();
                while (it.hasNext()) {
                    Object next = it.next();
                    Objects.requireNonNull(next);
                    if (this.b.add(next)) {
                        return next;
                    }
                }
                deque.removeFirst();
                return null;
            }
        }

        public class b extends g {
            public b(SuccessorsFunction successorsFunction) {
                super(successorsFunction);
            }

            @Override // com.google.common.graph.Traverser.g
            public Object g(Deque deque) {
                Iterator it = (Iterator) deque.getFirst();
                if (it.hasNext()) {
                    return Preconditions.checkNotNull(it.next());
                }
                deque.removeFirst();
                return null;
            }
        }

        public class c extends AbstractIterator {
            public final /* synthetic */ Deque a;
            public final /* synthetic */ f b;

            public c(Deque deque, f fVar) {
                this.a = deque;
                this.b = fVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                do {
                    Object objG = g.this.g(this.a);
                    if (objG != null) {
                        Iterator it = g.this.a.successors(objG).iterator();
                        if (it.hasNext()) {
                            this.b.b(this.a, it);
                        }
                        return objG;
                    }
                } while (!this.a.isEmpty());
                return endOfData();
            }
        }

        public class d extends AbstractIterator {
            public final /* synthetic */ Deque a;
            public final /* synthetic */ Deque b;

            public d(Deque deque, Deque deque2) {
                this.a = deque;
                this.b = deque2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                while (true) {
                    Object objG = g.this.g(this.a);
                    if (objG == null) {
                        return !this.b.isEmpty() ? this.b.pop() : endOfData();
                    }
                    Iterator it = g.this.a.successors(objG).iterator();
                    if (!it.hasNext()) {
                        return objG;
                    }
                    this.a.addFirst(it);
                    this.b.push(objG);
                }
            }
        }

        public g(SuccessorsFunction successorsFunction) {
            this.a = successorsFunction;
        }

        public static g b(SuccessorsFunction successorsFunction) {
            return new a(successorsFunction, new HashSet());
        }

        public static g c(SuccessorsFunction successorsFunction) {
            return new b(successorsFunction);
        }

        public final Iterator a(Iterator it) {
            return f(it, f.b);
        }

        public final Iterator d(Iterator it) {
            ArrayDeque arrayDeque = new ArrayDeque();
            ArrayDeque arrayDeque2 = new ArrayDeque();
            arrayDeque2.add(it);
            return new d(arrayDeque2, arrayDeque);
        }

        public final Iterator e(Iterator it) {
            return f(it, f.a);
        }

        public final Iterator f(Iterator it, f fVar) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(it);
            return new c(arrayDeque, fVar);
        }

        public abstract Object g(Deque deque);
    }

    public /* synthetic */ Traverser(SuccessorsFunction successorsFunction, a aVar) {
        this(successorsFunction);
    }

    public static <N> Traverser<N> forGraph(SuccessorsFunction<N> successorsFunction) {
        return new a(successorsFunction, successorsFunction);
    }

    public static <N> Traverser<N> forTree(SuccessorsFunction<N> successorsFunction) {
        if (successorsFunction instanceof InterfaceC2417i7) {
            Preconditions.checkArgument(((InterfaceC2417i7) successorsFunction).isDirected(), "Undirected graphs can never be trees.");
        }
        if (successorsFunction instanceof Network) {
            Preconditions.checkArgument(((Network) successorsFunction).isDirected(), "Undirected networks can never be trees.");
        }
        return new b(successorsFunction, successorsFunction);
    }

    private ImmutableSet<N> validate(Iterable<? extends N> iterable) {
        ImmutableSet<N> immutableSetCopyOf = ImmutableSet.copyOf(iterable);
        UnmodifiableIterator<N> it = immutableSetCopyOf.iterator();
        while (it.hasNext()) {
            this.successorFunction.successors(it.next());
        }
        return immutableSetCopyOf;
    }

    public final Iterable<N> breadthFirst(N n) {
        return breadthFirst((Iterable) ImmutableSet.of(n));
    }

    public final Iterable<N> depthFirstPostOrder(N n) {
        return depthFirstPostOrder((Iterable) ImmutableSet.of(n));
    }

    public final Iterable<N> depthFirstPreOrder(N n) {
        return depthFirstPreOrder((Iterable) ImmutableSet.of(n));
    }

    public abstract g newTraversal();

    private Traverser(SuccessorsFunction<N> successorsFunction) {
        this.successorFunction = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
    }

    public final Iterable<N> breadthFirst(Iterable<? extends N> iterable) {
        return new c(validate(iterable));
    }

    public final Iterable<N> depthFirstPostOrder(Iterable<? extends N> iterable) {
        return new e(validate(iterable));
    }

    public final Iterable<N> depthFirstPreOrder(Iterable<? extends N> iterable) {
        return new d(validate(iterable));
    }
}
