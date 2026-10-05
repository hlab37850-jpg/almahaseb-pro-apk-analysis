package androidx.compose.runtime.snapshots;

import defpackage.AbstractC4492zt;
import defpackage.HR;

/* JADX INFO: loaded from: classes.dex */
public interface StateObject {

    public static final class DefaultImpls {
        @Deprecated
        public static StateRecord mergeRecords(StateObject stateObject, StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
            AbstractC4492zt.h(stateRecord, "previous");
            AbstractC4492zt.h(stateRecord2, "current");
            AbstractC4492zt.h(stateRecord3, "applied");
            return HR.a(stateObject, stateRecord, stateRecord2, stateRecord3);
        }
    }

    StateRecord getFirstStateRecord();

    StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3);

    void prependStateRecord(StateRecord stateRecord);
}
