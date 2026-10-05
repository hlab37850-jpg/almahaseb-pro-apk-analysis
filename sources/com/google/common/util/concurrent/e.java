package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends c {
    public List i;

    public static final class a extends e {
        public a(ImmutableCollection immutableCollection, boolean z) {
            super(immutableCollection, z);
            p();
        }

        @Override // com.google.common.util.concurrent.e
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public List v(List list) {
            ArrayList arrayListNewArrayListWithCapacity = Lists.newArrayListWithCapacity(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                arrayListNewArrayListWithCapacity.add(bVar != null ? bVar.a : null);
            }
            return Collections.unmodifiableList(arrayListNewArrayListWithCapacity);
        }
    }

    public static final class b {
        public Object a;

        public b(Object obj) {
            this.a = obj;
        }
    }

    public e(ImmutableCollection immutableCollection, boolean z) {
        super(immutableCollection, z, true);
        List listEmptyList = immutableCollection.isEmpty() ? Collections.emptyList() : Lists.newArrayListWithCapacity(immutableCollection.size());
        for (int i = 0; i < immutableCollection.size(); i++) {
            listEmptyList.add(null);
        }
        this.i = listEmptyList;
    }

    @Override // com.google.common.util.concurrent.c
    public final void k(int i, Object obj) {
        List list = this.i;
        if (list != null) {
            list.set(i, new b(obj));
        }
    }

    @Override // com.google.common.util.concurrent.c
    public final void n() {
        List list = this.i;
        if (list != null) {
            set(v(list));
        }
    }

    @Override // com.google.common.util.concurrent.c
    public void u(c.a aVar) {
        super.u(aVar);
        this.i = null;
    }

    public abstract Object v(List list);
}
