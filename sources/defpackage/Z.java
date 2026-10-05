package defpackage;

import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Lists;
import com.google.api.client.util.Maps;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.store.AbstractDataStore;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.DataStoreFactory;
import com.google.api.client.util.store.DataStoreUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Z extends AbstractDataStore {
    public final Lock a;
    public HashMap b;

    public Z(DataStoreFactory dataStoreFactory, String str) {
        super(dataStoreFactory, str);
        this.a = new ReentrantLock();
        this.b = Maps.newHashMap();
    }

    @Override // com.google.api.client.util.store.DataStore
    public final DataStore clear() {
        this.a.lock();
        try {
            this.b.clear();
            a();
            return this;
        } finally {
            this.a.unlock();
        }
    }

    @Override // com.google.api.client.util.store.AbstractDataStore, com.google.api.client.util.store.DataStore
    public boolean containsKey(String str) {
        if (str == null) {
            return false;
        }
        this.a.lock();
        try {
            return this.b.containsKey(str);
        } finally {
            this.a.unlock();
        }
    }

    @Override // com.google.api.client.util.store.AbstractDataStore, com.google.api.client.util.store.DataStore
    public boolean containsValue(Serializable serializable) {
        if (serializable == null) {
            return false;
        }
        this.a.lock();
        try {
            byte[] bArrSerialize = IOUtils.serialize(serializable);
            Iterator it = this.b.values().iterator();
            while (it.hasNext()) {
                if (Arrays.equals(bArrSerialize, (byte[]) it.next())) {
                    return true;
                }
            }
            return false;
        } finally {
            this.a.unlock();
        }
    }

    @Override // com.google.api.client.util.store.DataStore
    public DataStore delete(String str) {
        if (str == null) {
            return this;
        }
        this.a.lock();
        try {
            this.b.remove(str);
            a();
            return this;
        } finally {
            this.a.unlock();
        }
    }

    @Override // com.google.api.client.util.store.DataStore
    public final Serializable get(String str) {
        if (str == null) {
            return null;
        }
        this.a.lock();
        try {
            return IOUtils.deserialize((byte[]) this.b.get(str));
        } finally {
            this.a.unlock();
        }
    }

    @Override // com.google.api.client.util.store.AbstractDataStore, com.google.api.client.util.store.DataStore
    public boolean isEmpty() {
        this.a.lock();
        try {
            return this.b.isEmpty();
        } finally {
            this.a.unlock();
        }
    }

    @Override // com.google.api.client.util.store.DataStore
    public final Set keySet() {
        this.a.lock();
        try {
            return Collections.unmodifiableSet(this.b.keySet());
        } finally {
            this.a.unlock();
        }
    }

    @Override // com.google.api.client.util.store.DataStore
    public final DataStore set(String str, Serializable serializable) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(serializable);
        this.a.lock();
        try {
            this.b.put(str, IOUtils.serialize(serializable));
            a();
            return this;
        } finally {
            this.a.unlock();
        }
    }

    @Override // com.google.api.client.util.store.AbstractDataStore, com.google.api.client.util.store.DataStore
    public int size() {
        this.a.lock();
        try {
            return this.b.size();
        } finally {
            this.a.unlock();
        }
    }

    public String toString() {
        return DataStoreUtils.toString(this);
    }

    @Override // com.google.api.client.util.store.DataStore
    public final Collection values() {
        this.a.lock();
        try {
            ArrayList arrayListNewArrayList = Lists.newArrayList();
            Iterator it = this.b.values().iterator();
            while (it.hasNext()) {
                arrayListNewArrayList.add(IOUtils.deserialize((byte[]) it.next()));
            }
            return Collections.unmodifiableList(arrayListNewArrayList);
        } finally {
            this.a.unlock();
        }
    }

    public void a() {
    }
}
