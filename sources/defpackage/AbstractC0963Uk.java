package defpackage;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: renamed from: Uk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0963Uk {
    public ConcurrentMap a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: Uk$a */
    public interface a {
        void call(Object... objArr);
    }

    /* JADX INFO: renamed from: Uk$b */
    public class b implements a {
        public final String a;
        public final a b;

        public b(String str, a aVar) {
            this.a = str;
            this.b = aVar;
        }

        @Override // defpackage.AbstractC0963Uk.a
        public void call(Object... objArr) {
            AbstractC0963Uk.this.d(this.a, this);
            this.b.call(objArr);
        }
    }

    public static boolean g(a aVar, a aVar2) {
        if (aVar.equals(aVar2)) {
            return true;
        }
        if (aVar2 instanceof b) {
            return aVar.equals(((b) aVar2).b);
        }
        return false;
    }

    public AbstractC0963Uk a(String str, Object... objArr) {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.a.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                ((a) it.next()).call(objArr);
            }
        }
        return this;
    }

    public AbstractC0963Uk b() {
        this.a.clear();
        return this;
    }

    public AbstractC0963Uk c(String str) {
        this.a.remove(str);
        return this;
    }

    public AbstractC0963Uk d(String str, a aVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.a.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                if (g(aVar, (a) it.next())) {
                    it.remove();
                    break;
                }
            }
        }
        return this;
    }

    public AbstractC0963Uk e(String str, a aVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.a.get(str);
        if (concurrentLinkedQueue == null) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
            ConcurrentLinkedQueue concurrentLinkedQueue2 = (ConcurrentLinkedQueue) this.a.putIfAbsent(str, concurrentLinkedQueue);
            if (concurrentLinkedQueue2 != null) {
                concurrentLinkedQueue = concurrentLinkedQueue2;
            }
        }
        concurrentLinkedQueue.add(aVar);
        return this;
    }

    public AbstractC0963Uk f(String str, a aVar) {
        e(str, new b(str, aVar));
        return this;
    }
}
