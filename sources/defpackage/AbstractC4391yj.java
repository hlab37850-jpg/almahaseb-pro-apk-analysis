package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: renamed from: yj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4391yj {

    /* JADX INFO: renamed from: yj$b */
    public static final class b extends AbstractC4391yj {
        public final ConcurrentLinkedQueue a;

        /* JADX INFO: renamed from: yj$b$a */
        public static final class a {
            public final Object a;
            public final MS b;

            public a(Object obj, MS ms) {
                this.a = obj;
                this.b = ms;
            }
        }

        public b() {
            this.a = Queues.newConcurrentLinkedQueue();
        }

        @Override // defpackage.AbstractC4391yj
        public void a(Object obj, Iterator it) {
            Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                this.a.add(new a(obj, (MS) it.next()));
            }
            while (true) {
                a aVar = (a) this.a.poll();
                if (aVar == null) {
                    return;
                } else {
                    aVar.b.d(aVar.a);
                }
            }
        }
    }

    /* JADX INFO: renamed from: yj$c */
    public static final class c extends AbstractC4391yj {
        public final ThreadLocal a;
        public final ThreadLocal b;

        /* JADX INFO: renamed from: yj$c$a */
        public class a extends ThreadLocal {
            public a(c cVar) {
            }

            @Override // java.lang.ThreadLocal
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Queue initialValue() {
                return Queues.newArrayDeque();
            }
        }

        /* JADX INFO: renamed from: yj$c$b */
        public class b extends ThreadLocal {
            public b(c cVar) {
            }

            @Override // java.lang.ThreadLocal
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean initialValue() {
                return Boolean.FALSE;
            }
        }

        /* JADX INFO: renamed from: yj$c$c, reason: collision with other inner class name */
        public static final class C0331c {
            public final Object a;
            public final Iterator b;

            public C0331c(Object obj, Iterator it) {
                this.a = obj;
                this.b = it;
            }
        }

        public c() {
            this.a = new a(this);
            this.b = new b(this);
        }

        @Override // defpackage.AbstractC4391yj
        public void a(Object obj, Iterator it) {
            Preconditions.checkNotNull(obj);
            Preconditions.checkNotNull(it);
            Queue queue = (Queue) this.a.get();
            queue.offer(new C0331c(obj, it));
            if (((Boolean) this.b.get()).booleanValue()) {
                return;
            }
            this.b.set(Boolean.TRUE);
            while (true) {
                try {
                    C0331c c0331c = (C0331c) queue.poll();
                    if (c0331c == null) {
                        this.b.remove();
                        this.a.remove();
                        return;
                    } else {
                        while (c0331c.b.hasNext()) {
                            ((MS) c0331c.b.next()).d(c0331c.a);
                        }
                    }
                } catch (Throwable th) {
                    this.b.remove();
                    this.a.remove();
                    throw th;
                }
            }
        }
    }

    public static AbstractC4391yj b() {
        return new b();
    }

    public static AbstractC4391yj c() {
        return new c();
    }

    public abstract void a(Object obj, Iterator it);
}
