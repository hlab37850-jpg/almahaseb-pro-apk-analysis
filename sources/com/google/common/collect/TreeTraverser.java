package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
@Deprecated
public abstract class TreeTraverser<T> {

    public class a extends TreeTraverser {
        public final /* synthetic */ Function a;

        public a(Function function) {
            this.a = function;
        }

        @Override // com.google.common.collect.TreeTraverser
        public Iterable children(Object obj) {
            return (Iterable) this.a.apply(obj);
        }
    }

    public class b extends FluentIterable {
        public final /* synthetic */ Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return TreeTraverser.this.preOrderIterator(this.a);
        }
    }

    public class c extends FluentIterable {
        public final /* synthetic */ Object a;

        public c(Object obj) {
            this.a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return TreeTraverser.this.postOrderIterator(this.a);
        }
    }

    public class d extends FluentIterable {
        public final /* synthetic */ Object a;

        public d(Object obj) {
            this.a = obj;
        }

        @Override // java.lang.Iterable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return new e(this.a);
        }
    }

    public final class e extends UnmodifiableIterator implements PeekingIterator {
        public final Queue a;

        public e(Object obj) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.a = arrayDeque;
            arrayDeque.add(obj);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.a.isEmpty();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator, com.google.common.collect.PeekingIterator
        public Object next() {
            Object objRemove = this.a.remove();
            Iterables.addAll(this.a, TreeTraverser.this.children(objRemove));
            return objRemove;
        }

        @Override // com.google.common.collect.PeekingIterator
        public Object peek() {
            return this.a.element();
        }
    }

    public final class f extends AbstractIterator {
        public final ArrayDeque a;

        public f(Object obj) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.a = arrayDeque;
            arrayDeque.addLast(a(obj));
        }

        public final g a(Object obj) {
            return new g(obj, TreeTraverser.this.children(obj).iterator());
        }

        @Override // com.google.common.collect.AbstractIterator
        public Object computeNext() {
            while (!this.a.isEmpty()) {
                g gVar = (g) this.a.getLast();
                if (!gVar.b.hasNext()) {
                    this.a.removeLast();
                    return gVar.a;
                }
                this.a.addLast(a(gVar.b.next()));
            }
            return endOfData();
        }
    }

    public static final class g {
        public final Object a;
        public final Iterator b;

        public g(Object obj, Iterator it) {
            this.a = Preconditions.checkNotNull(obj);
            this.b = (Iterator) Preconditions.checkNotNull(it);
        }
    }

    public final class h extends UnmodifiableIterator {
        public final Deque a;

        public h(Object obj) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.a = arrayDeque;
            arrayDeque.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(obj)));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.a.isEmpty();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator
        public Object next() {
            Iterator it = (Iterator) this.a.getLast();
            Object objCheckNotNull = Preconditions.checkNotNull(it.next());
            if (!it.hasNext()) {
                this.a.removeLast();
            }
            Iterator<T> it2 = TreeTraverser.this.children(objCheckNotNull).iterator();
            if (it2.hasNext()) {
                this.a.addLast(it2);
            }
            return objCheckNotNull;
        }
    }

    @Deprecated
    public static <T> TreeTraverser<T> using(Function<T, ? extends Iterable<T>> function) {
        Preconditions.checkNotNull(function);
        return new a(function);
    }

    @Deprecated
    public final FluentIterable<T> breadthFirstTraversal(T t) {
        Preconditions.checkNotNull(t);
        return new d(t);
    }

    public abstract Iterable<T> children(T t);

    public UnmodifiableIterator<T> postOrderIterator(T t) {
        return new f(t);
    }

    @Deprecated
    public final FluentIterable<T> postOrderTraversal(T t) {
        Preconditions.checkNotNull(t);
        return new c(t);
    }

    public UnmodifiableIterator<T> preOrderIterator(T t) {
        return new h(t);
    }

    @Deprecated
    public final FluentIterable<T> preOrderTraversal(T t) {
        Preconditions.checkNotNull(t);
        return new b(t);
    }
}
