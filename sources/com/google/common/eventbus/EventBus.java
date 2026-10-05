package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import defpackage.AbstractC4391yj;
import defpackage.OS;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class EventBus {
    private static final Logger logger = Logger.getLogger(EventBus.class.getName());
    private final AbstractC4391yj dispatcher;
    private final SubscriberExceptionHandler exceptionHandler;
    private final Executor executor;
    private final String identifier;
    private final OS subscribers;

    public static final class a implements SubscriberExceptionHandler {
        public static final a a = new a();

        public static Logger a(SubscriberExceptionContext subscriberExceptionContext) {
            String name = EventBus.class.getName();
            String strIdentifier = subscriberExceptionContext.getEventBus().identifier();
            StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(strIdentifier).length());
            sb.append(name);
            sb.append(".");
            sb.append(strIdentifier);
            return Logger.getLogger(sb.toString());
        }

        public static String b(SubscriberExceptionContext subscriberExceptionContext) {
            Method subscriberMethod = subscriberExceptionContext.getSubscriberMethod();
            String name = subscriberMethod.getName();
            String name2 = subscriberMethod.getParameterTypes()[0].getName();
            String strValueOf = String.valueOf(subscriberExceptionContext.getSubscriber());
            String strValueOf2 = String.valueOf(subscriberExceptionContext.getEvent());
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 80 + name2.length() + strValueOf.length() + strValueOf2.length());
            sb.append("Exception thrown by subscriber method ");
            sb.append(name);
            sb.append('(');
            sb.append(name2);
            sb.append(')');
            sb.append(" on subscriber ");
            sb.append(strValueOf);
            sb.append(" when dispatching event: ");
            sb.append(strValueOf2);
            return sb.toString();
        }

        @Override // com.google.common.eventbus.SubscriberExceptionHandler
        public void handleException(Throwable th, SubscriberExceptionContext subscriberExceptionContext) {
            Logger loggerA = a(subscriberExceptionContext);
            Level level = Level.SEVERE;
            if (loggerA.isLoggable(level)) {
                loggerA.log(level, b(subscriberExceptionContext), th);
            }
        }
    }

    public EventBus() {
        this("default");
    }

    public final Executor executor() {
        return this.executor;
    }

    public void handleSubscriberException(Throwable th, SubscriberExceptionContext subscriberExceptionContext) {
        Preconditions.checkNotNull(th);
        Preconditions.checkNotNull(subscriberExceptionContext);
        try {
            this.exceptionHandler.handleException(th, subscriberExceptionContext);
        } catch (Throwable th2) {
            logger.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", th2, th), th2);
        }
    }

    public final String identifier() {
        return this.identifier;
    }

    public void post(Object obj) {
        Iterator itF = this.subscribers.f(obj);
        if (itF.hasNext()) {
            this.dispatcher.a(obj, itF);
        } else {
            if (obj instanceof DeadEvent) {
                return;
            }
            post(new DeadEvent(this, obj));
        }
    }

    public void register(Object obj) {
        this.subscribers.g(obj);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(this.identifier).toString();
    }

    public void unregister(Object obj) {
        this.subscribers.h(obj);
    }

    public EventBus(String str) {
        this(str, MoreExecutors.directExecutor(), AbstractC4391yj.c(), a.a);
    }

    public EventBus(SubscriberExceptionHandler subscriberExceptionHandler) {
        this("default", MoreExecutors.directExecutor(), AbstractC4391yj.c(), subscriberExceptionHandler);
    }

    public EventBus(String str, Executor executor, AbstractC4391yj abstractC4391yj, SubscriberExceptionHandler subscriberExceptionHandler) {
        this.subscribers = new OS(this);
        this.identifier = (String) Preconditions.checkNotNull(str);
        this.executor = (Executor) Preconditions.checkNotNull(executor);
        this.dispatcher = (AbstractC4391yj) Preconditions.checkNotNull(abstractC4391yj);
        this.exceptionHandler = (SubscriberExceptionHandler) Preconditions.checkNotNull(subscriberExceptionHandler);
    }
}
