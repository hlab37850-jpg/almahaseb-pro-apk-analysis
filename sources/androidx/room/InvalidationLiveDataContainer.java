package androidx.room;

import androidx.lifecycle.LiveData;
import defpackage.AbstractC4492zt;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class InvalidationLiveDataContainer {
    private final RoomDatabase database;
    private final Set<LiveData<?>> liveDataSet;

    public InvalidationLiveDataContainer(RoomDatabase roomDatabase) {
        AbstractC4492zt.h(roomDatabase, "database");
        this.database = roomDatabase;
        Set<LiveData<?>> setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        AbstractC4492zt.g(setNewSetFromMap, "newSetFromMap(IdentityHashMap())");
        this.liveDataSet = setNewSetFromMap;
    }

    public final <T> LiveData<T> create(String[] strArr, boolean z, Callable<T> callable) {
        AbstractC4492zt.h(strArr, "tableNames");
        AbstractC4492zt.h(callable, "computeFunction");
        return new RoomTrackingLiveData(this.database, this, z, callable, strArr);
    }

    public final Set<LiveData<?>> getLiveDataSet$room_runtime_release() {
        return this.liveDataSet;
    }

    public final void onActive(LiveData<?> liveData) {
        AbstractC4492zt.h(liveData, "liveData");
        this.liveDataSet.add(liveData);
    }

    public final void onInactive(LiveData<?> liveData) {
        AbstractC4492zt.h(liveData, "liveData");
        this.liveDataSet.remove(liveData);
    }
}
