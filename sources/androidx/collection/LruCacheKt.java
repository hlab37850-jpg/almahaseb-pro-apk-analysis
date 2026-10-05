package androidx.collection;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LruCacheKt {

    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        public final int invoke(Object obj, Object obj2) {
            AbstractC4492zt.i(obj, "<anonymous parameter 0>");
            AbstractC4492zt.i(obj2, "<anonymous parameter 1>");
            return 1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return Integer.valueOf(invoke(obj, obj2));
        }
    }

    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Object invoke(Object obj) {
            AbstractC4492zt.i(obj, "it");
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0578Hp {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(4);
        }

        @Override // defpackage.InterfaceC0578Hp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke(((Boolean) obj).booleanValue(), obj2, obj3, obj4);
            return FW.a;
        }

        public final void invoke(boolean z, Object obj, Object obj2, Object obj3) {
            AbstractC4492zt.i(obj, "<anonymous parameter 1>");
            AbstractC4492zt.i(obj2, "<anonymous parameter 2>");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$4, reason: invalid class name */
    public static final class AnonymousClass4<K, V> extends LruCache<K, V> {
        final /* synthetic */ InterfaceC3750qp $create;
        final /* synthetic */ int $maxSize;
        final /* synthetic */ InterfaceC0578Hp $onEntryRemoved;
        final /* synthetic */ InterfaceC0526Fp $sizeOf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(InterfaceC0526Fp interfaceC0526Fp, InterfaceC3750qp interfaceC3750qp, InterfaceC0578Hp interfaceC0578Hp, int i, int i2) {
            super(i2);
            this.$sizeOf = interfaceC0526Fp;
            this.$create = interfaceC3750qp;
            this.$onEntryRemoved = interfaceC0578Hp;
            this.$maxSize = i;
        }

        @Override // androidx.collection.LruCache
        public V create(K k) {
            AbstractC4492zt.i(k, "key");
            return (V) this.$create.invoke(k);
        }

        @Override // androidx.collection.LruCache
        public void entryRemoved(boolean z, K k, V v, V v2) {
            AbstractC4492zt.i(k, "key");
            AbstractC4492zt.i(v, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(z), k, v, v2);
        }

        @Override // androidx.collection.LruCache
        public int sizeOf(K k, V v) {
            AbstractC4492zt.i(k, "key");
            AbstractC4492zt.i(v, "value");
            return ((Number) this.$sizeOf.mo13invoke(k, v)).intValue();
        }
    }

    public static final <K, V> LruCache<K, V> lruCache(int i, InterfaceC0526Fp interfaceC0526Fp, InterfaceC3750qp interfaceC3750qp, InterfaceC0578Hp interfaceC0578Hp) {
        AbstractC4492zt.i(interfaceC0526Fp, "sizeOf");
        AbstractC4492zt.i(interfaceC3750qp, "create");
        AbstractC4492zt.i(interfaceC0578Hp, "onEntryRemoved");
        return new AnonymousClass4(interfaceC0526Fp, interfaceC3750qp, interfaceC0578Hp, i, i);
    }

    public static /* synthetic */ LruCache lruCache$default(int i, InterfaceC0526Fp interfaceC0526Fp, InterfaceC3750qp interfaceC3750qp, InterfaceC0578Hp interfaceC0578Hp, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            interfaceC0526Fp = AnonymousClass1.INSTANCE;
        }
        InterfaceC0526Fp interfaceC0526Fp2 = interfaceC0526Fp;
        if ((i2 & 4) != 0) {
            interfaceC3750qp = AnonymousClass2.INSTANCE;
        }
        InterfaceC3750qp interfaceC3750qp2 = interfaceC3750qp;
        if ((i2 & 8) != 0) {
            interfaceC0578Hp = AnonymousClass3.INSTANCE;
        }
        InterfaceC0578Hp interfaceC0578Hp2 = interfaceC0578Hp;
        AbstractC4492zt.i(interfaceC0526Fp2, "sizeOf");
        AbstractC4492zt.i(interfaceC3750qp2, "create");
        AbstractC4492zt.i(interfaceC0578Hp2, "onEntryRemoved");
        return new AnonymousClass4(interfaceC0526Fp2, interfaceC3750qp2, interfaceC0578Hp2, i, i);
    }
}
