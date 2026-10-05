package androidx.compose.ui.text.caches;

import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.NV;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashSet<K> keySet;
    private final HashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private final SynchronizedObject monitor = Synchronization_jvmKt.createSynchronizedObject();
    private int putCount;
    private int size;

    public LruCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new HashMap<>(0, 0.75f);
        this.keySet = new LinkedHashSet<>();
    }

    private final int safeSizeOf(K k, V v) {
        int iSizeOf = sizeOf(k, v);
        if (iSizeOf >= 0) {
            return iSizeOf;
        }
        throw new IllegalStateException(("Negative size: " + k + '=' + v).toString());
    }

    public V create(K k) {
        return null;
    }

    public final int createCount() {
        int i;
        synchronized (this.monitor) {
            i = this.createCount;
        }
        return i;
    }

    public void entryRemoved(boolean z, K k, V v, V v2) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        int i;
        synchronized (this.monitor) {
            i = this.evictionCount;
        }
        return i;
    }

    public final V get(K k) {
        synchronized (this.monitor) {
            V v = this.map.get(k);
            if (v != null) {
                this.keySet.remove(k);
                this.keySet.add(k);
                this.hitCount++;
                return v;
            }
            this.missCount++;
            V vCreate = create(k);
            if (vCreate == null) {
                return null;
            }
            synchronized (this.monitor) {
                try {
                    this.createCount++;
                    V vPut = this.map.put(k, vCreate);
                    this.keySet.remove(k);
                    this.keySet.add(k);
                    if (vPut != null) {
                        this.map.put(k, vPut);
                        v = vPut;
                    } else {
                        this.size = size() + safeSizeOf(k, vCreate);
                    }
                    FW fw = FW.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (v != null) {
                entryRemoved(false, k, vCreate, v);
                return v;
            }
            trimToSize(this.maxSize);
            return vCreate;
        }
    }

    public final int hitCount() {
        int i;
        synchronized (this.monitor) {
            i = this.hitCount;
        }
        return i;
    }

    public final int maxSize() {
        int i;
        synchronized (this.monitor) {
            i = this.maxSize;
        }
        return i;
    }

    public final int missCount() {
        int i;
        synchronized (this.monitor) {
            i = this.missCount;
        }
        return i;
    }

    public final V put(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw null;
        }
        synchronized (this.monitor) {
            try {
                this.putCount++;
                this.size = size() + safeSizeOf(k, v);
                vPut = this.map.put(k, v);
                if (vPut != null) {
                    this.size = size() - safeSizeOf(k, vPut);
                }
                if (this.keySet.contains(k)) {
                    this.keySet.remove(k);
                }
                this.keySet.add(k);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (vPut != null) {
            entryRemoved(false, k, vPut, v);
        }
        trimToSize(this.maxSize);
        return vPut;
    }

    public final int putCount() {
        int i;
        synchronized (this.monitor) {
            i = this.putCount;
        }
        return i;
    }

    public final V remove(K k) {
        V vRemove;
        k.getClass();
        synchronized (this.monitor) {
            try {
                vRemove = this.map.remove(k);
                this.keySet.remove(k);
                if (vRemove != null) {
                    this.size = size() - safeSizeOf(k, vRemove);
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (vRemove != null) {
            entryRemoved(false, k, vRemove, null);
        }
        return vRemove;
    }

    public void resize(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this.monitor) {
            this.maxSize = i;
            FW fw = FW.a;
        }
        trimToSize(i);
    }

    public final int size() {
        int i;
        synchronized (this.monitor) {
            i = this.size;
        }
        return i;
    }

    public int sizeOf(K k, V v) {
        return 1;
    }

    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap;
        synchronized (this.monitor) {
            linkedHashMap = new LinkedHashMap();
            for (K k : this.keySet) {
                V v = this.map.get(k);
                AbstractC4492zt.e(v);
                linkedHashMap.put(k, v);
            }
        }
        return linkedHashMap;
    }

    public final <R> R synchronizedValue$ui_text_release(InterfaceC3588op interfaceC3588op) {
        R r;
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        synchronized (this.monitor) {
            try {
                r = (R) interfaceC3588op.invoke();
                AbstractC0703Ks.b(1);
            } finally {
                AbstractC0703Ks.b(1);
                AbstractC0703Ks.a(1);
            }
        }
        return r;
    }

    public String toString() {
        String str;
        synchronized (this.monitor) {
            try {
                int i = this.hitCount;
                int i2 = this.missCount + i;
                str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void trimToSize(int i) {
        Object objA0;
        V v;
        while (true) {
            synchronized (this.monitor) {
                try {
                    if (size() >= 0 && (!this.map.isEmpty() || size() == 0)) {
                        if (this.map.isEmpty() != this.keySet.isEmpty()) {
                            break;
                        }
                        if (size() <= i || this.map.isEmpty()) {
                            objA0 = null;
                            v = null;
                        } else {
                            objA0 = AbstractC3240kc.a0(this.keySet);
                            v = this.map.get(objA0);
                            if (v == null) {
                                throw new IllegalStateException("inconsistent state");
                            }
                            NV.c(this.map).remove(objA0);
                            NV.a(this.keySet).remove(objA0);
                            int size = size();
                            AbstractC4492zt.e(objA0);
                            AbstractC4492zt.e(v);
                            this.size = size - safeSizeOf(objA0, v);
                            this.evictionCount++;
                        }
                        FW fw = FW.a;
                    } else {
                        break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (objA0 == null && v == null) {
                return;
            }
            AbstractC4492zt.e(objA0);
            AbstractC4492zt.e(v);
            entryRemoved(true, objA0, v, null);
        }
        throw new IllegalStateException("map/keySet size inconsistency");
    }
}
