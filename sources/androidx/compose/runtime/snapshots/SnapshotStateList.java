package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.Stable;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC1239ac;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.HR;
import defpackage.InterfaceC0782Nu;
import defpackage.InterfaceC3750qp;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
@Stable
public final class SnapshotStateList<T> implements List<T>, StateObject, InterfaceC0782Nu {
    public static final int $stable = 0;
    private StateRecord firstStateRecord = new StateListStateRecord(ExtensionsKt.persistentListOf());

    public static final class StateListStateRecord<T> extends StateRecord {
        private PersistentList<? extends T> list;
        private int modification;

        public StateListStateRecord(PersistentList<? extends T> persistentList) {
            AbstractC4492zt.h(persistentList, "list");
            this.list = persistentList;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord stateRecord) {
            AbstractC4492zt.h(stateRecord, "value");
            synchronized (SnapshotStateListKt.sync) {
                this.list = ((StateListStateRecord) stateRecord).list;
                this.modification = ((StateListStateRecord) stateRecord).modification;
                FW fw = FW.a;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new StateListStateRecord(this.list);
        }

        public final PersistentList<T> getList$runtime_release() {
            return this.list;
        }

        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setList$runtime_release(PersistentList<? extends T> persistentList) {
            AbstractC4492zt.h(persistentList, "<set-?>");
            this.list = persistentList;
        }

        public final void setModification$runtime_release(int i) {
            this.modification = i;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotStateList$addAll$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ Collection<T> $elements;
        final /* synthetic */ int $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(int i, Collection<? extends T> collection) {
            super(1);
            this.$index = i;
            this.$elements = collection;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(List<T> list) {
            AbstractC4492zt.h(list, "it");
            return Boolean.valueOf(list.addAll(this.$index, this.$elements));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotStateList$retainAll$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16461 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ Collection<T> $elements;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C16461(Collection<? extends T> collection) {
            super(1);
            this.$elements = collection;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(List<T> list) {
            AbstractC4492zt.h(list, "it");
            return Boolean.valueOf(list.retainAll(this.$elements));
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0087 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean conditionalUpdate(defpackage.InterfaceC3750qp r10) {
        /*
            r9 = this;
        L0:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            r1 = 1
            androidx.compose.runtime.snapshots.StateRecord r2 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            defpackage.AbstractC4492zt.f(r2, r3)     // Catch: java.lang.Throwable -> L99
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r2     // Catch: java.lang.Throwable -> L99
            androidx.compose.runtime.snapshots.StateRecord r2 = androidx.compose.runtime.snapshots.SnapshotKt.current(r2)     // Catch: java.lang.Throwable -> L99
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r2     // Catch: java.lang.Throwable -> L99
            int r3 = r2.getModification$runtime_release()     // Catch: java.lang.Throwable -> L99
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r2 = r2.getList$runtime_release()     // Catch: java.lang.Throwable -> L99
            FW r4 = defpackage.FW.a     // Catch: java.lang.Throwable -> L99
            defpackage.AbstractC0703Ks.b(r1)
            monitor-exit(r0)
            defpackage.AbstractC0703Ks.a(r1)
            defpackage.AbstractC4492zt.e(r2)
            java.lang.Object r0 = r10.invoke(r2)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList) r0
            boolean r2 = defpackage.AbstractC4492zt.d(r0, r2)
            r4 = 0
            if (r2 == 0) goto L3a
            r1 = 0
            goto L86
        L3a:
            androidx.compose.runtime.snapshots.StateRecord r2 = r9.getFirstStateRecord()
            java.lang.String r5 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            defpackage.AbstractC4492zt.f(r2, r5)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r2
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r5)
            androidx.compose.runtime.snapshots.Snapshot$Companion r6 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L87
            androidx.compose.runtime.snapshots.Snapshot r6 = r6.getCurrent()     // Catch: java.lang.Throwable -> L87
            androidx.compose.runtime.snapshots.StateRecord r2 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r2, r9, r6)     // Catch: java.lang.Throwable -> L87
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r2     // Catch: java.lang.Throwable -> L87
            java.lang.Object r7 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L87
            monitor-enter(r7)     // Catch: java.lang.Throwable -> L87
            int r8 = r2.getModification$runtime_release()     // Catch: java.lang.Throwable -> L71
            if (r8 != r3) goto L73
            r2.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L71
            int r0 = r2.getModification$runtime_release()     // Catch: java.lang.Throwable -> L71
            int r0 = r0 + r1
            r2.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L71
            r4 = 1
            goto L73
        L71:
            r10 = move-exception
            goto L89
        L73:
            defpackage.AbstractC0703Ks.b(r1)     // Catch: java.lang.Throwable -> L87
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L87
            defpackage.AbstractC0703Ks.a(r1)     // Catch: java.lang.Throwable -> L87
            defpackage.AbstractC0703Ks.b(r1)
            monitor-exit(r5)
            defpackage.AbstractC0703Ks.a(r1)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r6, r9)
            if (r4 == 0) goto L0
        L86:
            return r1
        L87:
            r10 = move-exception
            goto L91
        L89:
            defpackage.AbstractC0703Ks.b(r1)     // Catch: java.lang.Throwable -> L87
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L87
            defpackage.AbstractC0703Ks.a(r1)     // Catch: java.lang.Throwable -> L87
            throw r10     // Catch: java.lang.Throwable -> L87
        L91:
            defpackage.AbstractC0703Ks.b(r1)
            monitor-exit(r5)
            defpackage.AbstractC0703Ks.a(r1)
            throw r10
        L99:
            r10 = move-exception
            defpackage.AbstractC0703Ks.b(r1)
            monitor-exit(r0)
            defpackage.AbstractC0703Ks.a(r1)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate(qp):boolean");
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    private final <R> R mutate(InterfaceC3750qp interfaceC3750qp) {
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        R r;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord = getFirstStateRecord();
                    AbstractC4492zt.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                    modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    FW fw = FW.a;
                    AbstractC0703Ks.b(1);
                } catch (Throwable th) {
                    AbstractC0703Ks.b(1);
                    AbstractC0703Ks.a(1);
                    throw th;
                }
            }
            AbstractC0703Ks.a(1);
            AbstractC4492zt.e(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            r = (R) interfaceC3750qp.invoke(builder);
            PersistentList<T> persistentListBuild = builder.build();
            if (AbstractC4492zt.d(persistentListBuild, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            AbstractC4492zt.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                try {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    synchronized (SnapshotStateListKt.sync) {
                        try {
                            if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                                stateListStateRecord3.setList$runtime_release(persistentListBuild);
                                stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                                z = true;
                            } else {
                                z = false;
                            }
                            AbstractC0703Ks.b(1);
                        } catch (Throwable th2) {
                            AbstractC0703Ks.b(1);
                            AbstractC0703Ks.a(1);
                            throw th2;
                        }
                    }
                    AbstractC0703Ks.a(1);
                    AbstractC0703Ks.b(1);
                } catch (Throwable th3) {
                    AbstractC0703Ks.b(1);
                    AbstractC0703Ks.a(1);
                    throw th3;
                }
            }
            AbstractC0703Ks.a(1);
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return r;
    }

    private final boolean mutateBoolean(InterfaceC3750qp interfaceC3750qp) {
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        Object objInvoke;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                AbstractC4492zt.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                FW fw = FW.a;
            }
            AbstractC4492zt.e(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            objInvoke = interfaceC3750qp.invoke(builder);
            PersistentList<T> persistentListBuild = builder.build();
            if (AbstractC4492zt.d(persistentListBuild, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            AbstractC4492zt.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord3.setList$runtime_release(persistentListBuild);
                        z = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return ((Boolean) objInvoke).booleanValue();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0086 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void update(defpackage.InterfaceC3750qp r9) {
        /*
            r8 = this;
        L0:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            r1 = 1
            androidx.compose.runtime.snapshots.StateRecord r2 = r8.getFirstStateRecord()     // Catch: java.lang.Throwable -> L98
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            defpackage.AbstractC4492zt.f(r2, r3)     // Catch: java.lang.Throwable -> L98
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r2     // Catch: java.lang.Throwable -> L98
            androidx.compose.runtime.snapshots.StateRecord r2 = androidx.compose.runtime.snapshots.SnapshotKt.current(r2)     // Catch: java.lang.Throwable -> L98
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r2     // Catch: java.lang.Throwable -> L98
            int r3 = r2.getModification$runtime_release()     // Catch: java.lang.Throwable -> L98
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r2 = r2.getList$runtime_release()     // Catch: java.lang.Throwable -> L98
            FW r4 = defpackage.FW.a     // Catch: java.lang.Throwable -> L98
            defpackage.AbstractC0703Ks.b(r1)
            monitor-exit(r0)
            defpackage.AbstractC0703Ks.a(r1)
            defpackage.AbstractC4492zt.e(r2)
            java.lang.Object r0 = r9.invoke(r2)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList) r0
            boolean r2 = defpackage.AbstractC4492zt.d(r0, r2)
            if (r2 == 0) goto L38
            goto L85
        L38:
            androidx.compose.runtime.snapshots.StateRecord r2 = r8.getFirstStateRecord()
            java.lang.String r4 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            defpackage.AbstractC4492zt.f(r2, r4)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r2
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r4)
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L86
            androidx.compose.runtime.snapshots.Snapshot r5 = r5.getCurrent()     // Catch: java.lang.Throwable -> L86
            androidx.compose.runtime.snapshots.StateRecord r2 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r2, r8, r5)     // Catch: java.lang.Throwable -> L86
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r2 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r2     // Catch: java.lang.Throwable -> L86
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L86
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L86
            int r7 = r2.getModification$runtime_release()     // Catch: java.lang.Throwable -> L6f
            if (r7 != r3) goto L71
            r2.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L6f
            int r0 = r2.getModification$runtime_release()     // Catch: java.lang.Throwable -> L6f
            int r0 = r0 + r1
            r2.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L6f
            r0 = 1
            goto L72
        L6f:
            r9 = move-exception
            goto L88
        L71:
            r0 = 0
        L72:
            defpackage.AbstractC0703Ks.b(r1)     // Catch: java.lang.Throwable -> L86
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L86
            defpackage.AbstractC0703Ks.a(r1)     // Catch: java.lang.Throwable -> L86
            defpackage.AbstractC0703Ks.b(r1)
            monitor-exit(r4)
            defpackage.AbstractC0703Ks.a(r1)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r8)
            if (r0 == 0) goto L0
        L85:
            return
        L86:
            r9 = move-exception
            goto L90
        L88:
            defpackage.AbstractC0703Ks.b(r1)     // Catch: java.lang.Throwable -> L86
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L86
            defpackage.AbstractC0703Ks.a(r1)     // Catch: java.lang.Throwable -> L86
            throw r9     // Catch: java.lang.Throwable -> L86
        L90:
            defpackage.AbstractC0703Ks.b(r1)
            monitor-exit(r4)
            defpackage.AbstractC0703Ks.a(r1)
            throw r9
        L98:
            r9 = move-exception
            defpackage.AbstractC0703Ks.b(r1)
            monitor-exit(r0)
            defpackage.AbstractC0703Ks.a(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.update(qp):void");
    }

    private final <R> R withCurrent(InterfaceC3750qp interfaceC3750qp) {
        StateRecord firstStateRecord = getFirstStateRecord();
        AbstractC4492zt.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (R) interfaceC3750qp.invoke(SnapshotKt.current((StateListStateRecord) firstStateRecord));
    }

    private final <R> R writable(InterfaceC3750qp interfaceC3750qp) {
        Snapshot current;
        R r;
        StateRecord firstStateRecord = getFirstStateRecord();
        AbstractC4492zt.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord stateListStateRecord = (StateListStateRecord) firstStateRecord;
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                r = (R) interfaceC3750qp.invoke(SnapshotKt.writableRecord(stateListStateRecord, this, current));
                AbstractC0703Ks.b(1);
            } catch (Throwable th) {
                AbstractC0703Ks.b(1);
                AbstractC0703Ks.a(1);
                throw th;
            }
        }
        AbstractC0703Ks.a(1);
        SnapshotKt.notifyWrite(current, this);
        return r;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0073 */
    @Override // java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean add(T r10) {
        /*
            r9 = this;
        L0:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L79
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            defpackage.AbstractC4492zt.f(r1, r2)     // Catch: java.lang.Throwable -> L79
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L79
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch: java.lang.Throwable -> L79
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L79
            int r2 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L79
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L79
            FW r3 = defpackage.FW.a     // Catch: java.lang.Throwable -> L79
            monitor-exit(r0)
            defpackage.AbstractC4492zt.e(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r1.add(r10)
            boolean r1 = defpackage.AbstractC4492zt.d(r0, r1)
            r3 = 0
            if (r1 == 0) goto L30
            goto L72
        L30:
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()
            java.lang.String r4 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            defpackage.AbstractC4492zt.f(r1, r4)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r4)
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L73
            androidx.compose.runtime.snapshots.Snapshot r5 = r5.getCurrent()     // Catch: java.lang.Throwable -> L73
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r1, r9, r5)     // Catch: java.lang.Throwable -> L73
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L73
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L73
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L73
            int r7 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L68
            r8 = 1
            if (r7 != r2) goto L6a
            r1.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L68
            int r0 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L68
            int r0 = r0 + r8
            r1.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L68
            r3 = 1
            goto L6a
        L68:
            r10 = move-exception
            goto L75
        L6a:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L73
            monitor-exit(r4)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r9)
            if (r3 == 0) goto L0
            r3 = 1
        L72:
            return r3
        L73:
            r10 = move-exception
            goto L77
        L75:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L73
            throw r10     // Catch: java.lang.Throwable -> L73
        L77:
            monitor-exit(r4)
            throw r10
        L79:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.add(java.lang.Object):boolean");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        AbstractC4492zt.h(collection, "elements");
        return mutateBoolean(new AnonymousClass1(i, collection));
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        Snapshot current;
        StateRecord firstStateRecord = getFirstStateRecord();
        AbstractC4492zt.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord stateListStateRecord = (StateListStateRecord) firstStateRecord;
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            current = Snapshot.Companion.getCurrent();
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord, this, current);
            synchronized (SnapshotStateListKt.sync) {
                stateListStateRecord2.setList$runtime_release(ExtensionsKt.persistentListOf());
                stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
            }
        }
        SnapshotKt.notifyWrite(current, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        AbstractC4492zt.h(collection, "elements");
        return getReadable$runtime_release().getList$runtime_release().containsAll(collection);
    }

    @Override // java.util.List
    public T get(int i) {
        return getReadable$runtime_release().getList$runtime_release().get(i);
    }

    public final List<T> getDebuggerDisplayValue() {
        StateRecord firstStateRecord = getFirstStateRecord();
        AbstractC4492zt.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord)).getList$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public final int getModification$runtime_release() {
        StateRecord firstStateRecord = getFirstStateRecord();
        AbstractC4492zt.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord)).getModification$runtime_release();
    }

    public final StateListStateRecord<T> getReadable$runtime_release() {
        StateRecord firstStateRecord = getFirstStateRecord();
        AbstractC4492zt.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (StateListStateRecord) SnapshotKt.readable((StateListStateRecord) firstStateRecord, this);
    }

    public int getSize() {
        return getReadable$runtime_release().getList$runtime_release().size();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return getReadable$runtime_release().getList$runtime_release().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new StateListIterator(this, 0);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return HR.a(this, stateRecord, stateRecord2, stateRecord3);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord stateRecord) {
        AbstractC4492zt.h(stateRecord, "value");
        stateRecord.setNext$runtime_release(getFirstStateRecord());
        this.firstStateRecord = (StateListStateRecord) stateRecord;
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i) {
        return removeAt(i);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0078 */
    @Override // java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean removeAll(java.util.Collection<? extends java.lang.Object> r10) {
        /*
            r9 = this;
            java.lang.String r0 = "elements"
            defpackage.AbstractC4492zt.h(r10, r0)
        L5:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            defpackage.AbstractC4492zt.f(r1, r2)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7e
            int r2 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L7e
            FW r3 = defpackage.FW.a     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r0)
            defpackage.AbstractC4492zt.e(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r1.removeAll(r10)
            boolean r1 = defpackage.AbstractC4492zt.d(r0, r1)
            r3 = 0
            if (r1 == 0) goto L35
            goto L77
        L35:
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()
            java.lang.String r4 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            defpackage.AbstractC4492zt.f(r1, r4)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r4)
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L78
            androidx.compose.runtime.snapshots.Snapshot r5 = r5.getCurrent()     // Catch: java.lang.Throwable -> L78
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r1, r9, r5)     // Catch: java.lang.Throwable -> L78
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L78
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L78
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L78
            int r7 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L6d
            r8 = 1
            if (r7 != r2) goto L6f
            r1.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L6d
            int r0 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L6d
            int r0 = r0 + r8
            r1.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L6d
            r3 = 1
            goto L6f
        L6d:
            r10 = move-exception
            goto L7a
        L6f:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L78
            monitor-exit(r4)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r9)
            if (r3 == 0) goto L5
            r3 = 1
        L77:
            return r3
        L78:
            r10 = move-exception
            goto L7c
        L7a:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L78
            throw r10     // Catch: java.lang.Throwable -> L78
        L7c:
            monitor-exit(r4)
            throw r10
        L7e:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.removeAll(java.util.Collection):boolean");
    }

    public T removeAt(int i) {
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z;
        T t = get(i);
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                AbstractC4492zt.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                FW fw = FW.a;
            }
            AbstractC4492zt.e(list$runtime_release);
            PersistentList<T> persistentListRemoveAt = list$runtime_release.removeAt(i);
            if (AbstractC4492zt.d(persistentListRemoveAt, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            AbstractC4492zt.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord3.setList$runtime_release(persistentListRemoveAt);
                        z = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return t;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x007b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void removeRange(int r8, int r9) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r7.getFirstStateRecord()     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            defpackage.AbstractC4492zt.f(r1, r2)     // Catch: java.lang.Throwable -> L82
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L82
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch: java.lang.Throwable -> L82
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L82
            int r2 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L82
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L82
            FW r3 = defpackage.FW.a     // Catch: java.lang.Throwable -> L82
            monitor-exit(r0)
            defpackage.AbstractC4492zt.e(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder r0 = r1.builder()
            java.util.List r3 = r0.subList(r8, r9)
            r3.clear()
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r0.build()
            boolean r1 = defpackage.AbstractC4492zt.d(r0, r1)
            if (r1 != 0) goto L81
            androidx.compose.runtime.snapshots.StateRecord r1 = r7.getFirstStateRecord()
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            defpackage.AbstractC4492zt.f(r1, r3)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r3 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r3)
            androidx.compose.runtime.snapshots.Snapshot$Companion r4 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.Snapshot r4 = r4.getCurrent()     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r1, r7, r4)     // Catch: java.lang.Throwable -> L7b
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L7b
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L7b
            int r6 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L70
            if (r6 != r2) goto L72
            r1.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L70
            int r0 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L70
            r2 = 1
            int r0 = r0 + r2
            r1.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L70
            goto L73
        L70:
            r8 = move-exception
            goto L7d
        L72:
            r2 = 0
        L73:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r3)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r4, r7)
            if (r2 == 0) goto L0
            goto L81
        L7b:
            r8 = move-exception
            goto L7f
        L7d:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L7b
            throw r8     // Catch: java.lang.Throwable -> L7b
        L7f:
            monitor-exit(r3)
            throw r8
        L81:
            return
        L82:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.removeRange(int, int):void");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        AbstractC4492zt.h(collection, "elements");
        return mutateBoolean(new C16461(collection));
    }

    public final int retainAllInRange$runtime_release(Collection<? extends T> collection, int i, int i2) {
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z;
        AbstractC4492zt.h(collection, "elements");
        int size = size();
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                AbstractC4492zt.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                FW fw = FW.a;
            }
            AbstractC4492zt.e(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            builder.subList(i, i2).retainAll(collection);
            PersistentList<T> persistentListBuild = builder.build();
            if (AbstractC4492zt.d(persistentListBuild, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            AbstractC4492zt.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord3.setList$runtime_release(persistentListBuild);
                        z = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return size - size();
    }

    @Override // java.util.List
    public T set(int i, T t) {
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z;
        T t2 = get(i);
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord = getFirstStateRecord();
                AbstractC4492zt.f(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                FW fw = FW.a;
            }
            AbstractC4492zt.e(list$runtime_release);
            PersistentList<T> persistentList = list$runtime_release.set(i, t);
            if (AbstractC4492zt.d(persistentList, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            AbstractC4492zt.f(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord3.setList$runtime_release(persistentList);
                        z = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return t2;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public List<T> subList(int i, int i2) {
        if (i < 0 || i > i2 || i2 > size()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        return new SubList(this, i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return AbstractC1239ac.a(this);
    }

    public final List<T> toList() {
        return getReadable$runtime_release().getList$runtime_release();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0078 */
    @Override // java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean addAll(java.util.Collection<? extends T> r10) {
        /*
            r9 = this;
            java.lang.String r0 = "elements"
            defpackage.AbstractC4492zt.h(r10, r0)
        L5:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            defpackage.AbstractC4492zt.f(r1, r2)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L7e
            int r2 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L7e
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L7e
            FW r3 = defpackage.FW.a     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r0)
            defpackage.AbstractC4492zt.e(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r1.addAll(r10)
            boolean r1 = defpackage.AbstractC4492zt.d(r0, r1)
            r3 = 0
            if (r1 == 0) goto L35
            goto L77
        L35:
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()
            java.lang.String r4 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            defpackage.AbstractC4492zt.f(r1, r4)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r4)
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L78
            androidx.compose.runtime.snapshots.Snapshot r5 = r5.getCurrent()     // Catch: java.lang.Throwable -> L78
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r1, r9, r5)     // Catch: java.lang.Throwable -> L78
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L78
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L78
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L78
            int r7 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L6d
            r8 = 1
            if (r7 != r2) goto L6f
            r1.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L6d
            int r0 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L6d
            int r0 = r0 + r8
            r1.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L6d
            r3 = 1
            goto L6f
        L6d:
            r10 = move-exception
            goto L7a
        L6f:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L78
            monitor-exit(r4)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r9)
            if (r3 == 0) goto L5
            r3 = 1
        L77:
            return r3
        L78:
            r10 = move-exception
            goto L7c
        L7a:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L78
            throw r10     // Catch: java.lang.Throwable -> L78
        L7c:
            monitor-exit(r4)
            throw r10
        L7e:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.addAll(java.util.Collection):boolean");
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i) {
        return new StateListIterator(this, i);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0073 */
    @Override // java.util.List, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean remove(java.lang.Object r10) {
        /*
            r9 = this;
        L0:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()     // Catch: java.lang.Throwable -> L79
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            defpackage.AbstractC4492zt.f(r1, r2)     // Catch: java.lang.Throwable -> L79
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L79
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch: java.lang.Throwable -> L79
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L79
            int r2 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L79
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L79
            FW r3 = defpackage.FW.a     // Catch: java.lang.Throwable -> L79
            monitor-exit(r0)
            defpackage.AbstractC4492zt.e(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r1.remove(r10)
            boolean r1 = defpackage.AbstractC4492zt.d(r0, r1)
            r3 = 0
            if (r1 == 0) goto L30
            goto L72
        L30:
            androidx.compose.runtime.snapshots.StateRecord r1 = r9.getFirstStateRecord()
            java.lang.String r4 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            defpackage.AbstractC4492zt.f(r1, r4)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r4)
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L73
            androidx.compose.runtime.snapshots.Snapshot r5 = r5.getCurrent()     // Catch: java.lang.Throwable -> L73
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r1, r9, r5)     // Catch: java.lang.Throwable -> L73
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L73
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L73
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L73
            int r7 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L68
            r8 = 1
            if (r7 != r2) goto L6a
            r1.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L68
            int r0 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L68
            int r0 = r0 + r8
            r1.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L68
            r3 = 1
            goto L6a
        L68:
            r10 = move-exception
            goto L75
        L6a:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L73
            monitor-exit(r4)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r9)
            if (r3 == 0) goto L0
            r3 = 1
        L72:
            return r3
        L73:
            r10 = move-exception
            goto L77
        L75:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L73
            throw r10     // Catch: java.lang.Throwable -> L73
        L77:
            monitor-exit(r4)
            throw r10
        L79:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.remove(java.lang.Object):boolean");
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        AbstractC4492zt.h(tArr, "array");
        return (T[]) AbstractC1239ac.b(this, tArr);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0071 */
    @Override // java.util.List
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void add(int r8, T r9) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()
            monitor-enter(r0)
            androidx.compose.runtime.snapshots.StateRecord r1 = r7.getFirstStateRecord()     // Catch: java.lang.Throwable -> L77
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            defpackage.AbstractC4492zt.f(r1, r2)     // Catch: java.lang.Throwable -> L77
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L77
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch: java.lang.Throwable -> L77
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L77
            int r2 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L77
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.getList$runtime_release()     // Catch: java.lang.Throwable -> L77
            FW r3 = defpackage.FW.a     // Catch: java.lang.Throwable -> L77
            monitor-exit(r0)
            defpackage.AbstractC4492zt.e(r1)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r1.add(r8, r9)
            boolean r1 = defpackage.AbstractC4492zt.d(r0, r1)
            if (r1 == 0) goto L2f
            goto L70
        L2f:
            androidx.compose.runtime.snapshots.StateRecord r1 = r7.getFirstStateRecord()
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            defpackage.AbstractC4492zt.f(r1, r3)
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1
            androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            java.lang.Object r3 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r3)
            androidx.compose.runtime.snapshots.Snapshot$Companion r4 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L71
            androidx.compose.runtime.snapshots.Snapshot r4 = r4.getCurrent()     // Catch: java.lang.Throwable -> L71
            androidx.compose.runtime.snapshots.StateRecord r1 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r1, r7, r4)     // Catch: java.lang.Throwable -> L71
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch: java.lang.Throwable -> L71
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p()     // Catch: java.lang.Throwable -> L71
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L71
            int r6 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L66
            if (r6 != r2) goto L68
            r1.setList$runtime_release(r0)     // Catch: java.lang.Throwable -> L66
            int r0 = r1.getModification$runtime_release()     // Catch: java.lang.Throwable -> L66
            r2 = 1
            int r0 = r0 + r2
            r1.setModification$runtime_release(r0)     // Catch: java.lang.Throwable -> L66
            goto L69
        L66:
            r8 = move-exception
            goto L73
        L68:
            r2 = 0
        L69:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L71
            monitor-exit(r3)
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r4, r7)
            if (r2 == 0) goto L0
        L70:
            return
        L71:
            r8 = move-exception
            goto L75
        L73:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L71
            throw r8     // Catch: java.lang.Throwable -> L71
        L75:
            monitor-exit(r3)
            throw r8
        L77:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.add(int, java.lang.Object):void");
    }
}
