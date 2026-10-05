package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public abstract class AbstractService implements Service {
    private static final com.google.common.util.concurrent.h.a STOPPING_FROM_RUNNING_EVENT;
    private static final com.google.common.util.concurrent.h.a STOPPING_FROM_STARTING_EVENT;
    private static final com.google.common.util.concurrent.h.a TERMINATED_FROM_NEW_EVENT;
    private static final com.google.common.util.concurrent.h.a TERMINATED_FROM_RUNNING_EVENT;
    private static final com.google.common.util.concurrent.h.a TERMINATED_FROM_STARTING_EVENT;
    private static final com.google.common.util.concurrent.h.a TERMINATED_FROM_STOPPING_EVENT;
    private static final com.google.common.util.concurrent.h.a STARTING_EVENT = new a();
    private static final com.google.common.util.concurrent.h.a RUNNING_EVENT = new b();
    private final Monitor monitor = new Monitor();
    private final Monitor.Guard isStartable = new h();
    private final Monitor.Guard isStoppable = new i();
    private final Monitor.Guard hasReachedRunning = new g();
    private final Monitor.Guard isStopped = new j();
    private final com.google.common.util.concurrent.h listeners = new com.google.common.util.concurrent.h();
    private volatile k snapshot = new k(Service.State.NEW);

    public class a implements com.google.common.util.concurrent.h.a {
        @Override // com.google.common.util.concurrent.h.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Service.Listener listener) {
            listener.starting();
        }

        public String toString() {
            return "starting()";
        }
    }

    public class b implements com.google.common.util.concurrent.h.a {
        @Override // com.google.common.util.concurrent.h.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Service.Listener listener) {
            listener.running();
        }

        public String toString() {
            return "running()";
        }
    }

    public class c implements com.google.common.util.concurrent.h.a {
        public final /* synthetic */ Service.State a;

        public c(Service.State state) {
            this.a = state;
        }

        @Override // com.google.common.util.concurrent.h.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Service.Listener listener) {
            listener.terminated(this.a);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 21);
            sb.append("terminated({from = ");
            sb.append(strValueOf);
            sb.append("})");
            return sb.toString();
        }
    }

    public class d implements com.google.common.util.concurrent.h.a {
        public final /* synthetic */ Service.State a;

        public d(Service.State state) {
            this.a = state;
        }

        @Override // com.google.common.util.concurrent.h.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Service.Listener listener) {
            listener.stopping(this.a);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 19);
            sb.append("stopping({from = ");
            sb.append(strValueOf);
            sb.append("})");
            return sb.toString();
        }
    }

    public class e implements com.google.common.util.concurrent.h.a {
        public final /* synthetic */ Service.State a;
        public final /* synthetic */ Throwable b;

        public e(AbstractService abstractService, Service.State state, Throwable th) {
            this.a = state;
            this.b = th;
        }

        @Override // com.google.common.util.concurrent.h.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Service.Listener listener) {
            listener.failed(this.a, this.b);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            String strValueOf2 = String.valueOf(this.b);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 27 + strValueOf2.length());
            sb.append("failed({from = ");
            sb.append(strValueOf);
            sb.append(", cause = ");
            sb.append(strValueOf2);
            sb.append("})");
            return sb.toString();
        }
    }

    public static /* synthetic */ class f {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Service.State.values().length];
            a = iArr;
            try {
                iArr[Service.State.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Service.State.STARTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Service.State.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Service.State.STOPPING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Service.State.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Service.State.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public final class g extends Monitor.Guard {
        public g() {
            super(AbstractService.this.monitor);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return AbstractService.this.state().compareTo(Service.State.RUNNING) >= 0;
        }
    }

    public final class h extends Monitor.Guard {
        public h() {
            super(AbstractService.this.monitor);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return AbstractService.this.state() == Service.State.NEW;
        }
    }

    public final class i extends Monitor.Guard {
        public i() {
            super(AbstractService.this.monitor);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return AbstractService.this.state().compareTo(Service.State.RUNNING) <= 0;
        }
    }

    public final class j extends Monitor.Guard {
        public j() {
            super(AbstractService.this.monitor);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return AbstractService.this.state().compareTo(Service.State.TERMINATED) >= 0;
        }
    }

    public static final class k {
        public final Service.State a;
        public final boolean b;
        public final Throwable c;

        public k(Service.State state) {
            this(state, false, null);
        }

        public Service.State a() {
            return (this.b && this.a == Service.State.STARTING) ? Service.State.STOPPING : this.a;
        }

        public Throwable b() {
            Service.State state = this.a;
            Preconditions.checkState(state == Service.State.FAILED, "failureCause() is only valid if the service has failed, service is %s", state);
            Throwable th = this.c;
            Objects.requireNonNull(th);
            return th;
        }

        public k(Service.State state, boolean z, Throwable th) {
            Preconditions.checkArgument(!z || state == Service.State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            Preconditions.checkArgument((th != null) == (state == Service.State.FAILED), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th);
            this.a = state;
            this.b = z;
            this.c = th;
        }
    }

    static {
        Service.State state = Service.State.STARTING;
        STOPPING_FROM_STARTING_EVENT = stoppingEvent(state);
        Service.State state2 = Service.State.RUNNING;
        STOPPING_FROM_RUNNING_EVENT = stoppingEvent(state2);
        TERMINATED_FROM_NEW_EVENT = terminatedEvent(Service.State.NEW);
        TERMINATED_FROM_STARTING_EVENT = terminatedEvent(state);
        TERMINATED_FROM_RUNNING_EVENT = terminatedEvent(state2);
        TERMINATED_FROM_STOPPING_EVENT = terminatedEvent(Service.State.STOPPING);
    }

    @GuardedBy("monitor")
    private void checkCurrentState(Service.State state) {
        Service.State state2 = state();
        if (state2 != state) {
            if (state2 == Service.State.FAILED) {
                String strValueOf = String.valueOf(this);
                String strValueOf2 = String.valueOf(state);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 56 + strValueOf2.length());
                sb.append("Expected the service ");
                sb.append(strValueOf);
                sb.append(" to be ");
                sb.append(strValueOf2);
                sb.append(", but the service has FAILED");
                throw new IllegalStateException(sb.toString(), failureCause());
            }
            String strValueOf3 = String.valueOf(this);
            String strValueOf4 = String.valueOf(state);
            String strValueOf5 = String.valueOf(state2);
            StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 38 + strValueOf4.length() + strValueOf5.length());
            sb2.append("Expected the service ");
            sb2.append(strValueOf3);
            sb2.append(" to be ");
            sb2.append(strValueOf4);
            sb2.append(", but was ");
            sb2.append(strValueOf5);
            throw new IllegalStateException(sb2.toString());
        }
    }

    private void dispatchListenerEvents() {
        if (this.monitor.isOccupiedByCurrentThread()) {
            return;
        }
        this.listeners.c();
    }

    private void enqueueFailedEvent(Service.State state, Throwable th) {
        this.listeners.d(new e(this, state, th));
    }

    private void enqueueRunningEvent() {
        this.listeners.d(RUNNING_EVENT);
    }

    private void enqueueStartingEvent() {
        this.listeners.d(STARTING_EVENT);
    }

    private void enqueueStoppingEvent(Service.State state) {
        if (state == Service.State.STARTING) {
            this.listeners.d(STOPPING_FROM_STARTING_EVENT);
        } else {
            if (state != Service.State.RUNNING) {
                throw new AssertionError();
            }
            this.listeners.d(STOPPING_FROM_RUNNING_EVENT);
        }
    }

    private void enqueueTerminatedEvent(Service.State state) {
        switch (f.a[state.ordinal()]) {
            case 1:
                this.listeners.d(TERMINATED_FROM_NEW_EVENT);
                return;
            case 2:
                this.listeners.d(TERMINATED_FROM_STARTING_EVENT);
                return;
            case 3:
                this.listeners.d(TERMINATED_FROM_RUNNING_EVENT);
                return;
            case 4:
                this.listeners.d(TERMINATED_FROM_STOPPING_EVENT);
                return;
            case 5:
            case 6:
                throw new AssertionError();
            default:
                return;
        }
    }

    private static com.google.common.util.concurrent.h.a stoppingEvent(Service.State state) {
        return new d(state);
    }

    private static com.google.common.util.concurrent.h.a terminatedEvent(Service.State state) {
        return new c(state);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.listeners.b(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.monitor.enterWhenUninterruptibly(this.hasReachedRunning);
        try {
            checkCurrentState(Service.State.RUNNING);
        } finally {
            this.monitor.leave();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.monitor.enterWhenUninterruptibly(this.isStopped);
        try {
            checkCurrentState(Service.State.TERMINATED);
        } finally {
            this.monitor.leave();
        }
    }

    @Beta
    @ForOverride
    public void doCancelStart() {
    }

    @ForOverride
    public abstract void doStart();

    @ForOverride
    public abstract void doStop();

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.snapshot.b();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return state() == Service.State.RUNNING;
    }

    public final void notifyFailed(Throwable th) {
        Preconditions.checkNotNull(th);
        this.monitor.enter();
        try {
            Service.State state = state();
            int i2 = f.a[state.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3 || i2 == 4) {
                    this.snapshot = new k(Service.State.FAILED, false, th);
                    enqueueFailedEvent(state, th);
                } else if (i2 != 5) {
                }
                this.monitor.leave();
                dispatchListenerEvents();
                return;
            }
            String strValueOf = String.valueOf(state);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
            sb.append("Failed while in state:");
            sb.append(strValueOf);
            throw new IllegalStateException(sb.toString(), th);
        } catch (Throwable th2) {
            this.monitor.leave();
            dispatchListenerEvents();
            throw th2;
        }
    }

    public final void notifyStarted() {
        this.monitor.enter();
        try {
            if (this.snapshot.a != Service.State.STARTING) {
                String strValueOf = String.valueOf(this.snapshot.a);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 43);
                sb.append("Cannot notifyStarted() when the service is ");
                sb.append(strValueOf);
                IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
                notifyFailed(illegalStateException);
                throw illegalStateException;
            }
            if (this.snapshot.b) {
                this.snapshot = new k(Service.State.STOPPING);
                doStop();
            } else {
                this.snapshot = new k(Service.State.RUNNING);
                enqueueRunningEvent();
            }
            this.monitor.leave();
            dispatchListenerEvents();
        } catch (Throwable th) {
            this.monitor.leave();
            dispatchListenerEvents();
            throw th;
        }
    }

    public final void notifyStopped() {
        this.monitor.enter();
        try {
            Service.State state = state();
            switch (f.a[state.ordinal()]) {
                case 1:
                case 5:
                case 6:
                    String strValueOf = String.valueOf(state);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 43);
                    sb.append("Cannot notifyStopped() when the service is ");
                    sb.append(strValueOf);
                    throw new IllegalStateException(sb.toString());
                case 2:
                case 3:
                case 4:
                    this.snapshot = new k(Service.State.TERMINATED);
                    enqueueTerminatedEvent(state);
                    break;
            }
            this.monitor.leave();
            dispatchListenerEvents();
        } catch (Throwable th) {
            this.monitor.leave();
            dispatchListenerEvents();
            throw th;
        }
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        if (!this.monitor.enterIf(this.isStartable)) {
            String strValueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 33);
            sb.append("Service ");
            sb.append(strValueOf);
            sb.append(" has already been started");
            throw new IllegalStateException(sb.toString());
        }
        try {
            this.snapshot = new k(Service.State.STARTING);
            enqueueStartingEvent();
            doStart();
        } catch (Throwable th) {
            try {
                notifyFailed(th);
            } finally {
                this.monitor.leave();
                dispatchListenerEvents();
            }
        }
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.snapshot.a();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        if (this.monitor.enterIf(this.isStoppable)) {
            try {
                Service.State state = state();
                switch (f.a[state.ordinal()]) {
                    case 1:
                        this.snapshot = new k(Service.State.TERMINATED);
                        enqueueTerminatedEvent(Service.State.NEW);
                        break;
                    case 2:
                        Service.State state2 = Service.State.STARTING;
                        this.snapshot = new k(state2, true, null);
                        enqueueStoppingEvent(state2);
                        doCancelStart();
                        break;
                    case 3:
                        this.snapshot = new k(Service.State.STOPPING);
                        enqueueStoppingEvent(Service.State.RUNNING);
                        doStop();
                        break;
                    case 4:
                    case 5:
                    case 6:
                        String strValueOf = String.valueOf(state);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 45);
                        sb.append("isStoppable is incorrectly implemented, saw: ");
                        sb.append(strValueOf);
                        throw new AssertionError(sb.toString());
                }
            } catch (Throwable th) {
                try {
                    notifyFailed(th);
                } finally {
                    this.monitor.leave();
                    dispatchListenerEvents();
                }
            }
        }
        return this;
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        String strValueOf = String.valueOf(state());
        StringBuilder sb = new StringBuilder(simpleName.length() + 3 + strValueOf.length());
        sb.append(simpleName);
        sb.append(" [");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j2, TimeUnit timeUnit) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.hasReachedRunning, j2, timeUnit)) {
            try {
                checkCurrentState(Service.State.RUNNING);
            } finally {
                this.monitor.leave();
            }
        } else {
            String strValueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 50);
            sb.append("Timed out waiting for ");
            sb.append(strValueOf);
            sb.append(" to reach the RUNNING state.");
            throw new TimeoutException(sb.toString());
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j2, TimeUnit timeUnit) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.isStopped, j2, timeUnit)) {
            try {
                checkCurrentState(Service.State.TERMINATED);
                return;
            } finally {
                this.monitor.leave();
            }
        }
        String strValueOf = String.valueOf(this);
        String strValueOf2 = String.valueOf(state());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 65 + strValueOf2.length());
        sb.append("Timed out waiting for ");
        sb.append(strValueOf);
        sb.append(" to reach a terminal state. Current state: ");
        sb.append(strValueOf2);
        throw new TimeoutException(sb.toString());
    }
}
