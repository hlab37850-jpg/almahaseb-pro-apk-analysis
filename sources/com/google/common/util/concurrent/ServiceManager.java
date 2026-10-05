package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final class ServiceManager {
    private final ImmutableList<Service> services;
    private final f state;
    private static final Logger logger = Logger.getLogger(ServiceManager.class.getName());
    private static final h.a HEALTHY_EVENT = new a();
    private static final h.a STOPPED_EVENT = new b();

    public static abstract class Listener {
        public void failure(Service service) {
        }

        public void healthy() {
        }

        public void stopped() {
        }
    }

    public class a implements h.a {
        @Override // com.google.common.util.concurrent.h.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Listener listener) {
            listener.healthy();
        }

        public String toString() {
            return "healthy()";
        }
    }

    public class b implements h.a {
        @Override // com.google.common.util.concurrent.h.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Listener listener) {
            listener.stopped();
        }

        public String toString() {
            return "stopped()";
        }
    }

    public static final class c extends Throwable {
        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public static final class d extends AbstractService {
        public d() {
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public void doStart() {
            notifyStarted();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public void doStop() {
            notifyStopped();
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public static final class e extends Service.Listener {
        public final Service a;
        public final WeakReference b;

        public e(Service service, WeakReference weakReference) {
            this.a = service;
            this.b = weakReference;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void failed(Service.State state, Throwable th) {
            f fVar = (f) this.b.get();
            if (fVar != null) {
                if (!(this.a instanceof d)) {
                    Logger logger = ServiceManager.logger;
                    Level level = Level.SEVERE;
                    String strValueOf = String.valueOf(this.a);
                    String strValueOf2 = String.valueOf(state);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 34 + strValueOf2.length());
                    sb.append("Service ");
                    sb.append(strValueOf);
                    sb.append(" has failed in the ");
                    sb.append(strValueOf2);
                    sb.append(" state.");
                    logger.log(level, sb.toString(), th);
                }
                fVar.n(this.a, state, Service.State.FAILED);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void running() {
            f fVar = (f) this.b.get();
            if (fVar != null) {
                fVar.n(this.a, Service.State.STARTING, Service.State.RUNNING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void starting() {
            f fVar = (f) this.b.get();
            if (fVar != null) {
                fVar.n(this.a, Service.State.NEW, Service.State.STARTING);
                if (this.a instanceof d) {
                    return;
                }
                ServiceManager.logger.log(Level.FINE, "Starting {0}.", this.a);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void stopping(Service.State state) {
            f fVar = (f) this.b.get();
            if (fVar != null) {
                fVar.n(this.a, state, Service.State.STOPPING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void terminated(Service.State state) {
            f fVar = (f) this.b.get();
            if (fVar != null) {
                if (!(this.a instanceof d)) {
                    ServiceManager.logger.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.a, state});
                }
                fVar.n(this.a, state, Service.State.TERMINATED);
            }
        }
    }

    public static final class f {
        public final Monitor a = new Monitor();
        public final SetMultimap b;
        public final Multiset c;
        public final Map d;
        public boolean e;
        public boolean f;
        public final int g;
        public final Monitor.Guard h;
        public final Monitor.Guard i;
        public final h j;

        public class a implements Function {
            public a(f fVar) {
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Long apply(Map.Entry entry) {
                return (Long) entry.getValue();
            }
        }

        public class b implements h.a {
            public final /* synthetic */ Service a;

            public b(f fVar, Service service) {
                this.a = service;
            }

            @Override // com.google.common.util.concurrent.h.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(Listener listener) {
                listener.failure(this.a);
            }

            public String toString() {
                String strValueOf = String.valueOf(this.a);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
                sb.append("failed({service=");
                sb.append(strValueOf);
                sb.append("})");
                return sb.toString();
            }
        }

        public final class c extends Monitor.Guard {
            public c() {
                super(f.this.a);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            public boolean isSatisfied() {
                int iCount = f.this.c.count(Service.State.RUNNING);
                f fVar = f.this;
                return iCount == fVar.g || fVar.c.contains(Service.State.STOPPING) || f.this.c.contains(Service.State.TERMINATED) || f.this.c.contains(Service.State.FAILED);
            }
        }

        public final class d extends Monitor.Guard {
            public d() {
                super(f.this.a);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            public boolean isSatisfied() {
                return f.this.c.count(Service.State.TERMINATED) + f.this.c.count(Service.State.FAILED) == f.this.g;
            }
        }

        public f(ImmutableCollection immutableCollection) {
            SetMultimap setMultimapBuild = MultimapBuilder.enumKeys(Service.State.class).linkedHashSetValues().build();
            this.b = setMultimapBuild;
            this.c = setMultimapBuild.keys();
            this.d = Maps.newIdentityHashMap();
            this.h = new c();
            this.i = new d();
            this.j = new h();
            this.g = immutableCollection.size();
            setMultimapBuild.putAll(Service.State.NEW, immutableCollection);
        }

        public void a(Listener listener, Executor executor) {
            this.j.b(listener, executor);
        }

        public void b() {
            this.a.enterWhenUninterruptibly(this.h);
            try {
                f();
            } finally {
                this.a.leave();
            }
        }

        public void c(long j, TimeUnit timeUnit) {
            this.a.enter();
            try {
                if (this.a.waitForUninterruptibly(this.h, j, timeUnit)) {
                    f();
                    this.a.leave();
                } else {
                    String strValueOf = String.valueOf(Multimaps.filterKeys(this.b, Predicates.in(ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 93);
                    sb.append("Timeout waiting for the services to become healthy. The following services have not started: ");
                    sb.append(strValueOf);
                    throw new TimeoutException(sb.toString());
                }
            } catch (Throwable th) {
                this.a.leave();
                throw th;
            }
        }

        public void d() {
            this.a.enterWhenUninterruptibly(this.i);
            this.a.leave();
        }

        public void e(long j, TimeUnit timeUnit) {
            this.a.enter();
            try {
                if (this.a.waitForUninterruptibly(this.i, j, timeUnit)) {
                    this.a.leave();
                    return;
                }
                String strValueOf = String.valueOf(Multimaps.filterKeys(this.b, Predicates.not(Predicates.in(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
                StringBuilder sb = new StringBuilder(strValueOf.length() + 83);
                sb.append("Timeout waiting for the services to stop. The following services have not stopped: ");
                sb.append(strValueOf);
                throw new TimeoutException(sb.toString());
            } catch (Throwable th) {
                this.a.leave();
                throw th;
            }
        }

        public void f() {
            Multiset multiset = this.c;
            Service.State state = Service.State.RUNNING;
            if (multiset.count(state) == this.g) {
                return;
            }
            String strValueOf = String.valueOf(Multimaps.filterKeys(this.b, Predicates.not(Predicates.equalTo(state))));
            StringBuilder sb = new StringBuilder(strValueOf.length() + 79);
            sb.append("Expected to be healthy after starting. The following services are not running: ");
            sb.append(strValueOf);
            throw new IllegalStateException(sb.toString());
        }

        public void g() {
            Preconditions.checkState(!this.a.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
            this.j.c();
        }

        public void h(Service service) {
            this.j.d(new b(this, service));
        }

        public void i() {
            this.j.d(ServiceManager.HEALTHY_EVENT);
        }

        public void j() {
            this.j.d(ServiceManager.STOPPED_EVENT);
        }

        public void k() {
            this.a.enter();
            try {
                if (!this.f) {
                    this.e = true;
                    this.a.leave();
                    return;
                }
                ArrayList arrayListNewArrayList = Lists.newArrayList();
                UnmodifiableIterator it = l().values().iterator();
                while (it.hasNext()) {
                    Service service = (Service) it.next();
                    if (service.state() != Service.State.NEW) {
                        arrayListNewArrayList.add(service);
                    }
                }
                String strValueOf = String.valueOf(arrayListNewArrayList);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 89);
                sb.append("Services started transitioning asynchronously before the ServiceManager was constructed: ");
                sb.append(strValueOf);
                throw new IllegalArgumentException(sb.toString());
            } catch (Throwable th) {
                this.a.leave();
                throw th;
            }
        }

        public ImmutableSetMultimap l() {
            ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
            this.a.enter();
            try {
                for (Map.Entry entry : this.b.entries()) {
                    if (!(entry.getValue() instanceof d)) {
                        builder.put(entry);
                    }
                }
                this.a.leave();
                return builder.build();
            } catch (Throwable th) {
                this.a.leave();
                throw th;
            }
        }

        public ImmutableMap m() {
            this.a.enter();
            try {
                ArrayList arrayListNewArrayListWithCapacity = Lists.newArrayListWithCapacity(this.d.size());
                for (Map.Entry entry : this.d.entrySet()) {
                    Service service = (Service) entry.getKey();
                    Stopwatch stopwatch = (Stopwatch) entry.getValue();
                    if (!stopwatch.isRunning() && !(service instanceof d)) {
                        arrayListNewArrayListWithCapacity.add(Maps.immutableEntry(service, Long.valueOf(stopwatch.elapsed(TimeUnit.MILLISECONDS))));
                    }
                }
                this.a.leave();
                Collections.sort(arrayListNewArrayListWithCapacity, Ordering.natural().onResultOf(new a(this)));
                return ImmutableMap.copyOf(arrayListNewArrayListWithCapacity);
            } catch (Throwable th) {
                this.a.leave();
                throw th;
            }
        }

        public void n(Service service, Service.State state, Service.State state2) {
            Preconditions.checkNotNull(service);
            Preconditions.checkArgument(state != state2);
            this.a.enter();
            try {
                this.f = true;
                if (this.e) {
                    Preconditions.checkState(this.b.remove(state, service), "Service %s not at the expected location in the state map %s", service, state);
                    Preconditions.checkState(this.b.put(state2, service), "Service %s in the state map unexpectedly at %s", service, state2);
                    Stopwatch stopwatchCreateStarted = (Stopwatch) this.d.get(service);
                    if (stopwatchCreateStarted == null) {
                        stopwatchCreateStarted = Stopwatch.createStarted();
                        this.d.put(service, stopwatchCreateStarted);
                    }
                    Service.State state3 = Service.State.RUNNING;
                    if (state2.compareTo(state3) >= 0 && stopwatchCreateStarted.isRunning()) {
                        stopwatchCreateStarted.stop();
                        if (!(service instanceof d)) {
                            ServiceManager.logger.log(Level.FINE, "Started {0} in {1}.", new Object[]{service, stopwatchCreateStarted});
                        }
                    }
                    Service.State state4 = Service.State.FAILED;
                    if (state2 == state4) {
                        h(service);
                    }
                    if (this.c.count(state3) == this.g) {
                        i();
                    } else if (this.c.count(Service.State.TERMINATED) + this.c.count(state4) == this.g) {
                        j();
                    }
                }
            } finally {
                this.a.leave();
                g();
            }
        }

        public void o(Service service) {
            this.a.enter();
            try {
                if (((Stopwatch) this.d.get(service)) == null) {
                    this.d.put(service, Stopwatch.createStarted());
                }
            } finally {
                this.a.leave();
            }
        }
    }

    public ServiceManager(Iterable<? extends Service> iterable) {
        ImmutableList<Service> immutableListCopyOf = ImmutableList.copyOf(iterable);
        if (immutableListCopyOf.isEmpty()) {
            a aVar = null;
            logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", (Throwable) new c(aVar));
            immutableListCopyOf = ImmutableList.of(new d(aVar));
        }
        f fVar = new f(immutableListCopyOf);
        this.state = fVar;
        this.services = immutableListCopyOf;
        WeakReference weakReference = new WeakReference(fVar);
        UnmodifiableIterator<Service> it = immutableListCopyOf.iterator();
        while (it.hasNext()) {
            Service next = it.next();
            next.addListener(new e(next, weakReference), MoreExecutors.directExecutor());
            Preconditions.checkArgument(next.state() == Service.State.NEW, "Can only manage NEW services, %s", next);
        }
        this.state.k();
    }

    public void addListener(Listener listener, Executor executor) {
        this.state.a(listener, executor);
    }

    public void awaitHealthy() {
        this.state.b();
    }

    public void awaitStopped() {
        this.state.d();
    }

    public boolean isHealthy() {
        UnmodifiableIterator<Service> it = this.services.iterator();
        while (it.hasNext()) {
            if (!it.next().isRunning()) {
                return false;
            }
        }
        return true;
    }

    @CanIgnoreReturnValue
    public ServiceManager startAsync() {
        UnmodifiableIterator<Service> it = this.services.iterator();
        while (it.hasNext()) {
            Preconditions.checkState(it.next().state() == Service.State.NEW, "Not all services are NEW, cannot start %s", this);
        }
        UnmodifiableIterator<Service> it2 = this.services.iterator();
        while (it2.hasNext()) {
            Service next = it2.next();
            try {
                this.state.o(next);
                next.startAsync();
            } catch (IllegalStateException e2) {
                Logger logger2 = logger;
                Level level = Level.WARNING;
                String strValueOf = String.valueOf(next);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
                sb.append("Unable to start Service ");
                sb.append(strValueOf);
                logger2.log(level, sb.toString(), (Throwable) e2);
            }
        }
        return this;
    }

    public ImmutableMap<Service, Long> startupTimes() {
        return this.state.m();
    }

    @CanIgnoreReturnValue
    public ServiceManager stopAsync() {
        UnmodifiableIterator<Service> it = this.services.iterator();
        while (it.hasNext()) {
            it.next().stopAsync();
        }
        return this;
    }

    public String toString() {
        return MoreObjects.toStringHelper((Class<?>) ServiceManager.class).add("services", Collections2.filter(this.services, Predicates.not(Predicates.instanceOf(d.class)))).toString();
    }

    public void awaitHealthy(long j, TimeUnit timeUnit) {
        this.state.c(j, timeUnit);
    }

    public void awaitStopped(long j, TimeUnit timeUnit) {
        this.state.e(j, timeUnit);
    }

    public ImmutableSetMultimap<Service.State, Service> servicesByState() {
        return this.state.l();
    }
}
