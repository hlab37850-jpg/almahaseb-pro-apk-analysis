package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.graph.EndpointPair;
import defpackage.InterfaceC0778Nq;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements InterfaceC0778Nq {
    public final Map a;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ElementOrder.Type.values().length];
            a = iArr;
            try {
                iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ElementOrder.Type.STABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public g(Map map) {
        this.a = (Map) Preconditions.checkNotNull(map);
    }

    public static g l(ElementOrder elementOrder) {
        int i = a.a[elementOrder.type().ordinal()];
        if (i == 1) {
            return new g(new HashMap(2, 1.0f));
        }
        if (i == 2) {
            return new g(new LinkedHashMap(2, 1.0f));
        }
        throw new AssertionError(elementOrder.type());
    }

    public static g m(Map map) {
        return new g(ImmutableMap.copyOf(map));
    }

    @Override // defpackage.InterfaceC0778Nq
    public Set a() {
        return Collections.unmodifiableSet(this.a.keySet());
    }

    @Override // defpackage.InterfaceC0778Nq
    public Set b() {
        return a();
    }

    @Override // defpackage.InterfaceC0778Nq
    public Set c() {
        return a();
    }

    @Override // defpackage.InterfaceC0778Nq
    public Object d(Object obj) {
        return this.a.remove(obj);
    }

    @Override // defpackage.InterfaceC0778Nq
    public Object e(Object obj) {
        return this.a.get(obj);
    }

    @Override // defpackage.InterfaceC0778Nq
    public void f(Object obj) {
        d(obj);
    }

    @Override // defpackage.InterfaceC0778Nq
    public Iterator g(final Object obj) {
        return Iterators.transform(this.a.keySet().iterator(), new Function() { // from class: uW
            @Override // com.google.common.base.Function
            public final Object apply(Object obj2) {
                return EndpointPair.unordered(obj, obj2);
            }
        });
    }

    @Override // defpackage.InterfaceC0778Nq
    public Object h(Object obj, Object obj2) {
        return this.a.put(obj, obj2);
    }

    @Override // defpackage.InterfaceC0778Nq
    public void i(Object obj, Object obj2) {
        h(obj, obj2);
    }
}
