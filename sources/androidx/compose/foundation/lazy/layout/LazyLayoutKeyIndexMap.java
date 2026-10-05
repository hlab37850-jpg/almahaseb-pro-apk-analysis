package androidx.compose.foundation.lazy.layout;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public interface LazyLayoutKeyIndexMap {
    public static final Empty Empty = Empty.$$INSTANCE;

    public static final class Empty implements LazyLayoutKeyIndexMap {
        static final /* synthetic */ Empty $$INSTANCE = new Empty();

        private Empty() {
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
        public int getIndex(Object obj) {
            AbstractC4492zt.h(obj, "key");
            return -1;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
        public Void getKey(int i) {
            return null;
        }
    }

    int getIndex(Object obj);

    Object getKey(int i);
}
