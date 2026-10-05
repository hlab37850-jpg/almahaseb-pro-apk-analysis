package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import defpackage.AbstractC1163Zb;
import defpackage.AbstractC3574of;
import defpackage.Y;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
public class v extends AbstractMap implements ConcurrentMap, Serializable {
    public static final D j = new C1966a();
    public final transient int a;
    public final transient int b;
    public final transient m[] c;
    public final int d;
    public final Equivalence e;
    public final transient i f;
    public transient Set g;
    public transient Collection h;
    public transient Set i;

    public static final class A extends AbstractC1968c implements C {
        public volatile D c;

        public static final class a implements i {
            public static final a a = new a();

            public static a g() {
                return a;
            }

            @Override // com.google.common.collect.v.i
            public n b() {
                return n.b;
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public A a(B b, A a2, A a3) {
                if (a2.getKey() == null || m.p(a2)) {
                    return null;
                }
                return a2.c(b.h, b.i, a3);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public A e(B b, Object obj, int i, A a2) {
                return new A(b.h, obj, i, a2);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public B d(v vVar, int i, int i2) {
                return new B(vVar, i, i2);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public void c(B b, A a2, Object obj) {
                a2.d(obj, b.i);
            }
        }

        public A(ReferenceQueue referenceQueue, Object obj, int i, A a2) {
            super(referenceQueue, obj, i, a2);
            this.c = v.q();
        }

        @Override // com.google.common.collect.v.C
        public D a() {
            return this.c;
        }

        public A c(ReferenceQueue referenceQueue, ReferenceQueue referenceQueue2, A a2) {
            A a3 = new A(referenceQueue, getKey(), this.a, a2);
            a3.c = this.c.b(referenceQueue2, a3);
            return a3;
        }

        public void d(Object obj, ReferenceQueue referenceQueue) {
            D d = this.c;
            this.c = new E(referenceQueue, obj, this);
            d.clear();
        }

        @Override // com.google.common.collect.v.h
        public Object getValue() {
            return this.c.get();
        }
    }

    public static final class B extends m {
        public final ReferenceQueue h;
        public final ReferenceQueue i;

        public B(v vVar, int i, int i2) {
            super(vVar, i, i2);
            this.h = new ReferenceQueue();
            this.i = new ReferenceQueue();
        }

        @Override // com.google.common.collect.v.m
        /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
        public B F() {
            return this;
        }

        @Override // com.google.common.collect.v.m
        public void q() {
            b(this.h);
        }

        @Override // com.google.common.collect.v.m
        public void r() {
            f(this.h);
            h(this.i);
        }
    }

    public interface C extends h {
        D a();
    }

    public interface D {
        h a();

        D b(ReferenceQueue referenceQueue, h hVar);

        void clear();

        Object get();
    }

    public static final class E extends WeakReference implements D {
        public final h a;

        public E(ReferenceQueue referenceQueue, Object obj, h hVar) {
            super(obj, referenceQueue);
            this.a = hVar;
        }

        @Override // com.google.common.collect.v.D
        public h a() {
            return this.a;
        }

        @Override // com.google.common.collect.v.D
        public D b(ReferenceQueue referenceQueue, h hVar) {
            return new E(referenceQueue, get(), hVar);
        }
    }

    public final class F extends Y {
        public final Object a;
        public Object b;

        public F(Object obj, Object obj2) {
            this.a = obj;
            this.b = obj2;
        }

        @Override // defpackage.Y, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.a.equals(entry.getKey()) && this.b.equals(entry.getValue());
        }

        @Override // defpackage.Y, java.util.Map.Entry
        public Object getKey() {
            return this.a;
        }

        @Override // defpackage.Y, java.util.Map.Entry
        public Object getValue() {
            return this.b;
        }

        @Override // defpackage.Y, java.util.Map.Entry
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override // defpackage.Y, java.util.Map.Entry
        public Object setValue(Object obj) {
            Object objPut = v.this.put(this.a, obj);
            this.b = obj;
            return objPut;
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.v$a, reason: case insensitive filesystem */
    public class C1966a implements D {
        @Override // com.google.common.collect.v.D
        public /* bridge */ /* synthetic */ h a() {
            d();
            return null;
        }

        @Override // com.google.common.collect.v.D
        public /* bridge */ /* synthetic */ D b(ReferenceQueue referenceQueue, h hVar) {
            AbstractC3574of.a(hVar);
            return c(referenceQueue, null);
        }

        public D c(ReferenceQueue referenceQueue, C1969d c1969d) {
            return this;
        }

        @Override // com.google.common.collect.v.D
        public void clear() {
        }

        public C1969d d() {
            return null;
        }

        @Override // com.google.common.collect.v.D
        public Object get() {
            return null;
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.v$b, reason: case insensitive filesystem */
    public static abstract class AbstractC1967b implements h {
        public final Object a;
        public final int b;
        public final h c;

        public AbstractC1967b(Object obj, int i, h hVar) {
            this.a = obj;
            this.b = i;
            this.c = hVar;
        }

        @Override // com.google.common.collect.v.h
        public int b() {
            return this.b;
        }

        @Override // com.google.common.collect.v.h
        public Object getKey() {
            return this.a;
        }

        @Override // com.google.common.collect.v.h
        public h getNext() {
            return this.c;
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.v$c, reason: case insensitive filesystem */
    public static abstract class AbstractC1968c extends WeakReference implements h {
        public final int a;
        public final h b;

        public AbstractC1968c(ReferenceQueue referenceQueue, Object obj, int i, h hVar) {
            super(obj, referenceQueue);
            this.a = i;
            this.b = hVar;
        }

        @Override // com.google.common.collect.v.h
        public int b() {
            return this.a;
        }

        @Override // com.google.common.collect.v.h
        public Object getKey() {
            return get();
        }

        @Override // com.google.common.collect.v.h
        public h getNext() {
            return this.b;
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.v$d, reason: case insensitive filesystem */
    public static final class C1969d implements h {
    }

    /* JADX INFO: renamed from: com.google.common.collect.v$e, reason: case insensitive filesystem */
    public final class C1970e extends g {
        public C1970e(v vVar) {
            super();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            return c();
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.v$f, reason: case insensitive filesystem */
    public final class C1971f extends l {
        public C1971f() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            v.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = v.this.get(key)) != null && v.this.r().equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return v.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new C1970e(v.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && v.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return v.this.size();
        }
    }

    public abstract class g implements Iterator {
        public int a;
        public int b = -1;
        public m c;
        public AtomicReferenceArray d;
        public h e;
        public F f;
        public F g;

        public g() {
            this.a = v.this.c.length - 1;
            a();
        }

        public final void a() {
            this.f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i = this.a;
                if (i < 0) {
                    return;
                }
                m[] mVarArr = v.this.c;
                this.a = i - 1;
                m mVar = mVarArr[i];
                this.c = mVar;
                if (mVar.b != 0) {
                    AtomicReferenceArray atomicReferenceArray = this.c.e;
                    this.d = atomicReferenceArray;
                    this.b = atomicReferenceArray.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(h hVar) {
            m mVar;
            try {
                Object key = hVar.getKey();
                Object objH = v.this.h(hVar);
                if (objH == null) {
                    return false;
                }
                this.f = v.this.new F(key, objH);
                return true;
            } finally {
                this.c.t();
            }
        }

        public F c() {
            F f = this.f;
            if (f == null) {
                throw new NoSuchElementException();
            }
            this.g = f;
            a();
            return this.g;
        }

        public boolean d() {
            h hVar = this.e;
            if (hVar == null) {
                return false;
            }
            while (true) {
                this.e = hVar.getNext();
                h hVar2 = this.e;
                if (hVar2 == null) {
                    return false;
                }
                if (b(hVar2)) {
                    return true;
                }
                hVar = this.e;
            }
        }

        public boolean e() {
            while (true) {
                int i = this.b;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray atomicReferenceArray = this.d;
                this.b = i - 1;
                h hVar = (h) atomicReferenceArray.get(i);
                this.e = hVar;
                if (hVar != null && (b(hVar) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            AbstractC1163Zb.e(this.g != null);
            v.this.remove(this.g.getKey());
            this.g = null;
        }
    }

    public interface h {
        int b();

        Object getKey();

        h getNext();

        Object getValue();
    }

    public interface i {
        h a(m mVar, h hVar, h hVar2);

        n b();

        void c(m mVar, h hVar, Object obj);

        m d(v vVar, int i, int i2);

        h e(m mVar, Object obj, int i, h hVar);
    }

    public final class j extends g {
        public j(v vVar) {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return c().getKey();
        }
    }

    public final class k extends l {
        public k() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            v.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return v.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return v.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new j(v.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return v.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return v.this.size();
        }
    }

    public static abstract class l extends AbstractSet {
        public l() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return v.p(this).toArray();
        }

        public /* synthetic */ l(C1966a c1966a) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            return v.p(this).toArray(objArr);
        }
    }

    public static abstract class m extends ReentrantLock {
        public final v a;
        public volatile int b;
        public int c;
        public int d;
        public volatile AtomicReferenceArray e;
        public final int f;
        public final AtomicInteger g = new AtomicInteger();

        public m(v vVar, int i, int i2) {
            this.a = vVar;
            this.f = i2;
            o(s(i));
        }

        public static boolean p(h hVar) {
            return hVar.getValue() == null;
        }

        public h A(h hVar, h hVar2) {
            int i = this.b;
            h next = hVar2.getNext();
            while (hVar != hVar2) {
                h hVarE = e(hVar, next);
                if (hVarE != null) {
                    next = hVarE;
                } else {
                    i--;
                }
                hVar = hVar.getNext();
            }
            this.b = i;
            return next;
        }

        public Object B(Object obj, int i, Object obj2) {
            lock();
            try {
                u();
                AtomicReferenceArray atomicReferenceArray = this.e;
                int length = (atomicReferenceArray.length() - 1) & i;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h next = hVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.b() == i && key != null && this.a.e.equivalent(obj, key)) {
                        Object value = next.getValue();
                        if (value != null) {
                            this.c++;
                            G(next, obj2);
                            return value;
                        }
                        if (p(next)) {
                            this.c++;
                            h hVarA = A(hVar, next);
                            int i2 = this.b - 1;
                            atomicReferenceArray.set(length, hVarA);
                            this.b = i2;
                        }
                        return null;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        public boolean C(Object obj, int i, Object obj2, Object obj3) {
            lock();
            try {
                u();
                AtomicReferenceArray atomicReferenceArray = this.e;
                int length = (atomicReferenceArray.length() - 1) & i;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h next = hVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.b() == i && key != null && this.a.e.equivalent(obj, key)) {
                        Object value = next.getValue();
                        if (value != null) {
                            if (!this.a.r().equivalent(obj2, value)) {
                                return false;
                            }
                            this.c++;
                            G(next, obj3);
                            return true;
                        }
                        if (p(next)) {
                            this.c++;
                            h hVarA = A(hVar, next);
                            int i2 = this.b - 1;
                            atomicReferenceArray.set(length, hVarA);
                            this.b = i2;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public void D() {
            E();
        }

        public void E() {
            if (tryLock()) {
                try {
                    r();
                    this.g.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public abstract m F();

        public void G(h hVar, Object obj) {
            this.a.f.c(F(), hVar, obj);
        }

        public void H() {
            if (tryLock()) {
                try {
                    r();
                } finally {
                    unlock();
                }
            }
        }

        public void a() {
            if (this.b != 0) {
                lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = this.e;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        atomicReferenceArray.set(i, null);
                    }
                    q();
                    this.g.set(0);
                    this.c++;
                    this.b = 0;
                } finally {
                    unlock();
                }
            }
        }

        public void b(ReferenceQueue referenceQueue) {
            while (referenceQueue.poll() != null) {
            }
        }

        public boolean c(Object obj, int i) {
            try {
                boolean z = false;
                if (this.b == 0) {
                    return false;
                }
                h hVarM = m(obj, i);
                if (hVarM != null && hVarM.getValue() != null) {
                    z = true;
                }
                return z;
            } finally {
                t();
            }
        }

        public h e(h hVar, h hVar2) {
            return this.a.f.a(F(), hVar, hVar2);
        }

        public void f(ReferenceQueue referenceQueue) {
            int i = 0;
            do {
                Object objPoll = referenceQueue.poll();
                if (objPoll == null) {
                    return;
                }
                this.a.l((h) objPoll);
                i++;
            } while (i != 16);
        }

        public void h(ReferenceQueue referenceQueue) {
            int i = 0;
            do {
                Object objPoll = referenceQueue.poll();
                if (objPoll == null) {
                    return;
                }
                this.a.m((D) objPoll);
                i++;
            } while (i != 16);
        }

        public void i() {
            AtomicReferenceArray atomicReferenceArray = this.e;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.b;
            AtomicReferenceArray atomicReferenceArrayS = s(length << 1);
            this.d = (atomicReferenceArrayS.length() * 3) / 4;
            int length2 = atomicReferenceArrayS.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                h next = (h) atomicReferenceArray.get(i2);
                if (next != null) {
                    h next2 = next.getNext();
                    int iB = next.b() & length2;
                    if (next2 == null) {
                        atomicReferenceArrayS.set(iB, next);
                    } else {
                        h hVar = next;
                        while (next2 != null) {
                            int iB2 = next2.b() & length2;
                            if (iB2 != iB) {
                                hVar = next2;
                                iB = iB2;
                            }
                            next2 = next2.getNext();
                        }
                        atomicReferenceArrayS.set(iB, hVar);
                        while (next != hVar) {
                            int iB3 = next.b() & length2;
                            h hVarE = e(next, (h) atomicReferenceArrayS.get(iB3));
                            if (hVarE != null) {
                                atomicReferenceArrayS.set(iB3, hVarE);
                            } else {
                                i--;
                            }
                            next = next.getNext();
                        }
                    }
                }
            }
            this.e = atomicReferenceArrayS;
            this.b = i;
        }

        public Object j(Object obj, int i) {
            try {
                h hVarM = m(obj, i);
                if (hVarM == null) {
                    return null;
                }
                Object value = hVarM.getValue();
                if (value == null) {
                    H();
                }
                return value;
            } finally {
                t();
            }
        }

        public h k(Object obj, int i) {
            if (this.b == 0) {
                return null;
            }
            for (h hVarL = l(i); hVarL != null; hVarL = hVarL.getNext()) {
                if (hVarL.b() == i) {
                    Object key = hVarL.getKey();
                    if (key == null) {
                        H();
                    } else if (this.a.e.equivalent(obj, key)) {
                        return hVarL;
                    }
                }
            }
            return null;
        }

        public h l(int i) {
            AtomicReferenceArray atomicReferenceArray = this.e;
            return (h) atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        public h m(Object obj, int i) {
            return k(obj, i);
        }

        public Object n(h hVar) {
            if (hVar.getKey() == null) {
                H();
                return null;
            }
            Object value = hVar.getValue();
            if (value != null) {
                return value;
            }
            H();
            return null;
        }

        public void o(AtomicReferenceArray atomicReferenceArray) {
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.d = length;
            if (length == this.f) {
                this.d = length + 1;
            }
            this.e = atomicReferenceArray;
        }

        public void q() {
        }

        public void r() {
        }

        public AtomicReferenceArray s(int i) {
            return new AtomicReferenceArray(i);
        }

        public void t() {
            if ((this.g.incrementAndGet() & 63) == 0) {
                D();
            }
        }

        public void u() {
            E();
        }

        public Object v(Object obj, int i, Object obj2, boolean z) {
            lock();
            try {
                u();
                int i2 = this.b + 1;
                if (i2 > this.d) {
                    i();
                    i2 = this.b + 1;
                }
                AtomicReferenceArray atomicReferenceArray = this.e;
                int length = (atomicReferenceArray.length() - 1) & i;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h next = hVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.b() == i && key != null && this.a.e.equivalent(obj, key)) {
                        Object value = next.getValue();
                        if (value == null) {
                            this.c++;
                            G(next, obj2);
                            this.b = this.b;
                            return null;
                        }
                        if (z) {
                            return value;
                        }
                        this.c++;
                        G(next, obj2);
                        return value;
                    }
                }
                this.c++;
                h hVarE = this.a.f.e(F(), obj, i, hVar);
                G(hVarE, obj2);
                atomicReferenceArray.set(length, hVarE);
                this.b = i2;
                return null;
            } finally {
                unlock();
            }
        }

        public boolean w(h hVar, int i) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.e;
                int length = i & (atomicReferenceArray.length() - 1);
                h hVar2 = (h) atomicReferenceArray.get(length);
                for (h next = hVar2; next != null; next = next.getNext()) {
                    if (next == hVar) {
                        this.c++;
                        h hVarA = A(hVar2, next);
                        int i2 = this.b - 1;
                        atomicReferenceArray.set(length, hVarA);
                        this.b = i2;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public boolean x(Object obj, int i, D d) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.e;
                int length = (atomicReferenceArray.length() - 1) & i;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h next = hVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.b() == i && key != null && this.a.e.equivalent(obj, key)) {
                        if (((C) next).a() != d) {
                            return false;
                        }
                        this.c++;
                        h hVarA = A(hVar, next);
                        int i2 = this.b - 1;
                        atomicReferenceArray.set(length, hVarA);
                        this.b = i2;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public Object y(Object obj, int i) {
            lock();
            try {
                u();
                AtomicReferenceArray atomicReferenceArray = this.e;
                int length = (atomicReferenceArray.length() - 1) & i;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h next = hVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.b() == i && key != null && this.a.e.equivalent(obj, key)) {
                        Object value = next.getValue();
                        if (value == null && !p(next)) {
                            return null;
                        }
                        this.c++;
                        h hVarA = A(hVar, next);
                        int i2 = this.b - 1;
                        atomicReferenceArray.set(length, hVarA);
                        this.b = i2;
                        return value;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        public boolean z(Object obj, int i, Object obj2) {
            lock();
            try {
                u();
                AtomicReferenceArray atomicReferenceArray = this.e;
                int length = (atomicReferenceArray.length() - 1) & i;
                h hVar = (h) atomicReferenceArray.get(length);
                h next = hVar;
                while (true) {
                    boolean z = false;
                    if (next == null) {
                        return false;
                    }
                    Object key = next.getKey();
                    if (next.b() == i && key != null && this.a.e.equivalent(obj, key)) {
                        if (this.a.r().equivalent(obj2, next.getValue())) {
                            z = true;
                        } else if (!p(next)) {
                            return false;
                        }
                        this.c++;
                        h hVarA = A(hVar, next);
                        int i2 = this.b - 1;
                        atomicReferenceArray.set(length, hVarA);
                        this.b = i2;
                        return z;
                    }
                    next = next.getNext();
                }
            } finally {
                unlock();
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class n {
        public static final n a = new a("STRONG", 0);
        public static final n b = new b("WEAK", 1);
        public static final /* synthetic */ n[] c = a();

        public final enum a extends n {
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.v.n
            public Equivalence b() {
                return Equivalence.equals();
            }
        }

        public final enum b extends n {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.v.n
            public Equivalence b() {
                return Equivalence.identity();
            }
        }

        public n(String str, int i) {
            super(str, i);
        }

        public static /* synthetic */ n[] a() {
            return new n[]{a, b};
        }

        public static n valueOf(String str) {
            return (n) Enum.valueOf(n.class, str);
        }

        public static n[] values() {
            return (n[]) c.clone();
        }

        public abstract Equivalence b();

        public /* synthetic */ n(String str, int i, C1966a c1966a) {
            this(str, i);
        }
    }

    public static final class o extends AbstractC1967b implements h {

        public static final class a implements i {
            public static final a a = new a();

            public static a g() {
                return a;
            }

            @Override // com.google.common.collect.v.i
            public n b() {
                return n.a;
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public o a(p pVar, o oVar, o oVar2) {
                return oVar.c(oVar2);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public o e(p pVar, Object obj, int i, o oVar) {
                return new o(obj, i, oVar);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public p d(v vVar, int i, int i2) {
                return new p(vVar, i, i2);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public void c(p pVar, o oVar, MapMaker.a aVar) {
            }
        }

        public o(Object obj, int i, o oVar) {
            super(obj, i, oVar);
        }

        public o c(o oVar) {
            return new o(this.a, this.b, oVar);
        }

        @Override // com.google.common.collect.v.h
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public MapMaker.a getValue() {
            return MapMaker.a.VALUE;
        }
    }

    public static final class p extends m {
        public p(v vVar, int i, int i2) {
            super(vVar, i, i2);
        }

        @Override // com.google.common.collect.v.m
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public p F() {
            return this;
        }
    }

    public static final class q extends AbstractC1967b implements h {
        public volatile Object d;

        public static final class a implements i {
            public static final a a = new a();

            public static a g() {
                return a;
            }

            @Override // com.google.common.collect.v.i
            public n b() {
                return n.a;
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public q a(r rVar, q qVar, q qVar2) {
                return qVar.c(qVar2);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public q e(r rVar, Object obj, int i, q qVar) {
                return new q(obj, i, qVar);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public r d(v vVar, int i, int i2) {
                return new r(vVar, i, i2);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public void c(r rVar, q qVar, Object obj) {
                qVar.d(obj);
            }
        }

        public q(Object obj, int i, q qVar) {
            super(obj, i, qVar);
            this.d = null;
        }

        public q c(q qVar) {
            q qVar2 = new q(this.a, this.b, qVar);
            qVar2.d = this.d;
            return qVar2;
        }

        public void d(Object obj) {
            this.d = obj;
        }

        @Override // com.google.common.collect.v.h
        public Object getValue() {
            return this.d;
        }
    }

    public static final class r extends m {
        public r(v vVar, int i, int i2) {
            super(vVar, i, i2);
        }

        @Override // com.google.common.collect.v.m
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public r F() {
            return this;
        }
    }

    public static final class s extends AbstractC1967b implements C {
        public volatile D d;

        public static final class a implements i {
            public static final a a = new a();

            public static a g() {
                return a;
            }

            @Override // com.google.common.collect.v.i
            public n b() {
                return n.b;
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public s a(t tVar, s sVar, s sVar2) {
                if (m.p(sVar)) {
                    return null;
                }
                return sVar.c(tVar.h, sVar2);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public s e(t tVar, Object obj, int i, s sVar) {
                return new s(obj, i, sVar);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public t d(v vVar, int i, int i2) {
                return new t(vVar, i, i2);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public void c(t tVar, s sVar, Object obj) {
                sVar.d(obj, tVar.h);
            }
        }

        public s(Object obj, int i, s sVar) {
            super(obj, i, sVar);
            this.d = v.q();
        }

        @Override // com.google.common.collect.v.C
        public D a() {
            return this.d;
        }

        public s c(ReferenceQueue referenceQueue, s sVar) {
            s sVar2 = new s(this.a, this.b, sVar);
            sVar2.d = this.d.b(referenceQueue, sVar2);
            return sVar2;
        }

        public void d(Object obj, ReferenceQueue referenceQueue) {
            D d = this.d;
            this.d = new E(referenceQueue, obj, this);
            d.clear();
        }

        @Override // com.google.common.collect.v.h
        public Object getValue() {
            return this.d.get();
        }
    }

    public static final class t extends m {
        public final ReferenceQueue h;

        public t(v vVar, int i, int i2) {
            super(vVar, i, i2);
            this.h = new ReferenceQueue();
        }

        @Override // com.google.common.collect.v.m
        /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
        public t F() {
            return this;
        }

        @Override // com.google.common.collect.v.m
        public void q() {
            b(this.h);
        }

        @Override // com.google.common.collect.v.m
        public void r() {
            h(this.h);
        }
    }

    public final class u extends g {
        public u(v vVar) {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return c().getValue();
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.v$v, reason: collision with other inner class name */
    public final class C0243v extends AbstractCollection {
        public C0243v() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            v.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return v.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return v.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new u(v.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return v.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return v.p(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return v.p(this).toArray(objArr);
        }
    }

    public static final class w extends AbstractC1968c implements h {

        public static final class a implements i {
            public static final a a = new a();

            public static a g() {
                return a;
            }

            @Override // com.google.common.collect.v.i
            public n b() {
                return n.a;
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public w a(x xVar, w wVar, w wVar2) {
                if (wVar.getKey() == null) {
                    return null;
                }
                return wVar.c(xVar.h, wVar2);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public w e(x xVar, Object obj, int i, w wVar) {
                return new w(xVar.h, obj, i, wVar);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public x d(v vVar, int i, int i2) {
                return new x(vVar, i, i2);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public void c(x xVar, w wVar, MapMaker.a aVar) {
            }
        }

        public w(ReferenceQueue referenceQueue, Object obj, int i, w wVar) {
            super(referenceQueue, obj, i, wVar);
        }

        public w c(ReferenceQueue referenceQueue, w wVar) {
            return new w(referenceQueue, getKey(), this.a, wVar);
        }

        @Override // com.google.common.collect.v.h
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public MapMaker.a getValue() {
            return MapMaker.a.VALUE;
        }
    }

    public static final class x extends m {
        public final ReferenceQueue h;

        public x(v vVar, int i, int i2) {
            super(vVar, i, i2);
            this.h = new ReferenceQueue();
        }

        @Override // com.google.common.collect.v.m
        /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
        public x F() {
            return this;
        }

        @Override // com.google.common.collect.v.m
        public void q() {
            b(this.h);
        }

        @Override // com.google.common.collect.v.m
        public void r() {
            f(this.h);
        }
    }

    public static final class y extends AbstractC1968c implements h {
        public volatile Object c;

        public static final class a implements i {
            public static final a a = new a();

            public static a g() {
                return a;
            }

            @Override // com.google.common.collect.v.i
            public n b() {
                return n.a;
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public y a(z zVar, y yVar, y yVar2) {
                if (yVar.getKey() == null) {
                    return null;
                }
                return yVar.c(zVar.h, yVar2);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public y e(z zVar, Object obj, int i, y yVar) {
                return new y(zVar.h, obj, i, yVar);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public z d(v vVar, int i, int i2) {
                return new z(vVar, i, i2);
            }

            @Override // com.google.common.collect.v.i
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public void c(z zVar, y yVar, Object obj) {
                yVar.d(obj);
            }
        }

        public y(ReferenceQueue referenceQueue, Object obj, int i, y yVar) {
            super(referenceQueue, obj, i, yVar);
            this.c = null;
        }

        public y c(ReferenceQueue referenceQueue, y yVar) {
            y yVar2 = new y(referenceQueue, getKey(), this.a, yVar);
            yVar2.d(this.c);
            return yVar2;
        }

        public void d(Object obj) {
            this.c = obj;
        }

        @Override // com.google.common.collect.v.h
        public Object getValue() {
            return this.c;
        }
    }

    public static final class z extends m {
        public final ReferenceQueue h;

        public z(v vVar, int i, int i2) {
            super(vVar, i, i2);
            this.h = new ReferenceQueue();
        }

        @Override // com.google.common.collect.v.m
        /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
        public z F() {
            return this;
        }

        @Override // com.google.common.collect.v.m
        public void q() {
            b(this.h);
        }

        @Override // com.google.common.collect.v.m
        public void r() {
            f(this.h);
        }
    }

    public v(MapMaker mapMaker, i iVar) {
        this.d = Math.min(mapMaker.getConcurrencyLevel(), 65536);
        this.e = mapMaker.getKeyEquivalence();
        this.f = iVar;
        int iMin = Math.min(mapMaker.getInitialCapacity(), 1073741824);
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i4 < this.d) {
            i5++;
            i4 <<= 1;
        }
        this.b = 32 - i5;
        this.a = i4 - 1;
        this.c = k(i4);
        int i6 = iMin / i4;
        while (i3 < (i4 * i6 < iMin ? i6 + 1 : i6)) {
            i3 <<= 1;
        }
        while (true) {
            m[] mVarArr = this.c;
            if (i2 >= mVarArr.length) {
                return;
            }
            mVarArr[i2] = c(i3, -1);
            i2++;
        }
    }

    public static v b(MapMaker mapMaker) {
        n keyStrength = mapMaker.getKeyStrength();
        n nVar = n.a;
        if (keyStrength == nVar && mapMaker.getValueStrength() == nVar) {
            return new v(mapMaker, q.a.g());
        }
        if (mapMaker.getKeyStrength() == nVar && mapMaker.getValueStrength() == n.b) {
            return new v(mapMaker, s.a.g());
        }
        n keyStrength2 = mapMaker.getKeyStrength();
        n nVar2 = n.b;
        if (keyStrength2 == nVar2 && mapMaker.getValueStrength() == nVar) {
            return new v(mapMaker, y.a.g());
        }
        if (mapMaker.getKeyStrength() == nVar2 && mapMaker.getValueStrength() == nVar2) {
            return new v(mapMaker, A.a.g());
        }
        throw new AssertionError();
    }

    public static v e(MapMaker mapMaker) {
        n keyStrength = mapMaker.getKeyStrength();
        n nVar = n.a;
        if (keyStrength == nVar && mapMaker.getValueStrength() == nVar) {
            return new v(mapMaker, o.a.g());
        }
        n keyStrength2 = mapMaker.getKeyStrength();
        n nVar2 = n.b;
        if (keyStrength2 == nVar2 && mapMaker.getValueStrength() == nVar) {
            return new v(mapMaker, w.a.g());
        }
        if (mapMaker.getValueStrength() == nVar2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    public static int n(int i2) {
        int i3 = i2 + ((i2 << 15) ^ (-12931));
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    public static ArrayList p(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterators.addAll(arrayList, collection.iterator());
        return arrayList;
    }

    public static D q() {
        return j;
    }

    public m c(int i2, int i3) {
        return this.f.d(this, i2, i3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (m mVar : this.c) {
            mVar.a();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int iJ = j(obj);
        return o(iJ).c(obj, iJ);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        m[] mVarArr = this.c;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            for (m mVar : mVarArr) {
                int i3 = mVar.b;
                AtomicReferenceArray atomicReferenceArray = mVar.e;
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    for (h next = (h) atomicReferenceArray.get(i4); next != null; next = next.getNext()) {
                        Object objN = mVar.n(next);
                        if (objN != null && r().equivalent(obj, objN)) {
                            return true;
                        }
                    }
                }
                j3 += (long) mVar.c;
            }
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.i;
        if (set != null) {
            return set;
        }
        C1971f c1971f = new C1971f();
        this.i = c1971f;
        return c1971f;
    }

    public h f(Object obj) {
        if (obj == null) {
            return null;
        }
        int iJ = j(obj);
        return o(iJ).k(obj, iJ);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        int iJ = j(obj);
        return o(iJ).j(obj, iJ);
    }

    public Object h(h hVar) {
        if (hVar.getKey() == null) {
            return null;
        }
        return hVar.getValue();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        m[] mVarArr = this.c;
        long j2 = 0;
        for (int i2 = 0; i2 < mVarArr.length; i2++) {
            if (mVarArr[i2].b != 0) {
                return false;
            }
            j2 += (long) mVarArr[i2].c;
        }
        if (j2 == 0) {
            return true;
        }
        for (int i3 = 0; i3 < mVarArr.length; i3++) {
            if (mVarArr[i3].b != 0) {
                return false;
            }
            j2 -= (long) mVarArr[i3].c;
        }
        return j2 == 0;
    }

    public int j(Object obj) {
        return n(this.e.hash(obj));
    }

    public final m[] k(int i2) {
        return new m[i2];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.g;
        if (set != null) {
            return set;
        }
        k kVar = new k();
        this.g = kVar;
        return kVar;
    }

    public void l(h hVar) {
        int iB = hVar.b();
        o(iB).w(hVar, iB);
    }

    public void m(D d) {
        h hVarA = d.a();
        int iB = hVarA.b();
        o(iB).x(hVarA.getKey(), iB, d);
    }

    public m o(int i2) {
        return this.c[(i2 >>> this.b) & this.a];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int iJ = j(obj);
        return o(iJ).v(obj, iJ, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object putIfAbsent(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int iJ = j(obj);
        return o(iJ).v(obj, iJ, obj2, true);
    }

    public Equivalence r() {
        return this.f.b().b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int iJ = j(obj);
        return o(iJ).y(obj, iJ);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(Object obj, Object obj2, Object obj3) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj3);
        if (obj2 == null) {
            return false;
        }
        int iJ = j(obj);
        return o(iJ).C(obj, iJ, obj2, obj3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j2 = 0;
        for (m mVar : this.c) {
            j2 += (long) mVar.b;
        }
        return Ints.saturatedCast(j2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.h;
        if (collection != null) {
            return collection;
        }
        C0243v c0243v = new C0243v();
        this.h = c0243v;
        return c0243v;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int iJ = j(obj);
        return o(iJ).z(obj, iJ, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object replace(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int iJ = j(obj);
        return o(iJ).B(obj, iJ, obj2);
    }
}
