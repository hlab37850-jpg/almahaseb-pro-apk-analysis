package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import defpackage.AI;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends f {
    public AI a;
    public AI b;
    public AI c;
    public AI d;
    public AI e;
    public AI f;
    public AI g;
    public AI h;
    public AI i;
    public AI j;
    public AI k;
    public AI l;
    public AI n;

    public static final class b implements f.a {
        public Context a;

        public b() {
        }

        @Override // com.google.android.datatransport.runtime.f.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Context context) {
            this.a = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.f.a
        public f build() {
            Preconditions.checkBuilderRequirement(this.a, Context.class);
            return new d(this.a);
        }
    }

    public static f.a g() {
        return new b();
    }

    @Override // com.google.android.datatransport.runtime.f
    public EventStore c() {
        return (EventStore) this.g.get();
    }

    @Override // com.google.android.datatransport.runtime.f
    public TransportRuntime d() {
        return (TransportRuntime) this.n.get();
    }

    public final void i(Context context) {
        this.a = DoubleCheck.provider(ExecutionModule_ExecutorFactory.create());
        Factory factoryCreate = InstanceFactory.create(context);
        this.b = factoryCreate;
        CreationContextFactory_Factory creationContextFactory_FactoryCreate = CreationContextFactory_Factory.create(factoryCreate, TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create());
        this.c = creationContextFactory_FactoryCreate;
        this.d = DoubleCheck.provider(MetadataBackendRegistry_Factory.create(this.b, creationContextFactory_FactoryCreate));
        this.e = SchemaManager_Factory.create(this.b, EventStoreModule_DbNameFactory.create(), EventStoreModule_SchemaVersionFactory.create());
        this.f = DoubleCheck.provider(EventStoreModule_PackageNameFactory.create(this.b));
        this.g = DoubleCheck.provider(SQLiteEventStore_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), EventStoreModule_StoreConfigFactory.create(), this.e, this.f));
        SchedulingConfigModule_ConfigFactory schedulingConfigModule_ConfigFactoryCreate = SchedulingConfigModule_ConfigFactory.create(TimeModule_EventClockFactory.create());
        this.h = schedulingConfigModule_ConfigFactoryCreate;
        SchedulingModule_WorkSchedulerFactory schedulingModule_WorkSchedulerFactoryCreate = SchedulingModule_WorkSchedulerFactory.create(this.b, this.g, schedulingConfigModule_ConfigFactoryCreate, TimeModule_UptimeClockFactory.create());
        this.i = schedulingModule_WorkSchedulerFactoryCreate;
        AI ai = this.a;
        AI ai2 = this.d;
        AI ai3 = this.g;
        this.j = DefaultScheduler_Factory.create(ai, ai2, schedulingModule_WorkSchedulerFactoryCreate, ai3, ai3);
        AI ai4 = this.b;
        AI ai5 = this.d;
        AI ai6 = this.g;
        this.k = Uploader_Factory.create(ai4, ai5, ai6, this.i, this.a, ai6, TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), this.g);
        AI ai7 = this.a;
        AI ai8 = this.g;
        this.l = WorkInitializer_Factory.create(ai7, ai8, this.i, ai8);
        this.n = DoubleCheck.provider(TransportRuntime_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), this.j, this.k, this.l));
    }

    public d(Context context) {
        i(context);
    }
}
