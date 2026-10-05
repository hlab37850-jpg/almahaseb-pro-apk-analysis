package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.errorprone.annotations.CheckReturnValue;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible(emulated = true)
public abstract class CacheLoader<K, V> {

    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
    }

    public class a extends CacheLoader {
        public final /* synthetic */ Executor b;

        /* JADX INFO: renamed from: com.google.common.cache.CacheLoader$a$a, reason: collision with other inner class name */
        public class CallableC0206a implements Callable {
            public final /* synthetic */ Object a;
            public final /* synthetic */ Object b;

            public CallableC0206a(Object obj, Object obj2) {
                this.a = obj;
                this.b = obj2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public Object call() {
                return CacheLoader.this.reload(this.a, this.b).get();
            }
        }

        public a(Executor executor) {
            this.b = executor;
        }

        @Override // com.google.common.cache.CacheLoader
        public Object load(Object obj) {
            return CacheLoader.this.load(obj);
        }

        @Override // com.google.common.cache.CacheLoader
        public Map loadAll(Iterable iterable) {
            return CacheLoader.this.loadAll(iterable);
        }

        @Override // com.google.common.cache.CacheLoader
        public ListenableFuture reload(Object obj, Object obj2) {
            ListenableFutureTask listenableFutureTaskCreate = ListenableFutureTask.create(new CallableC0206a(obj, obj2));
            this.b.execute(listenableFutureTaskCreate);
            return listenableFutureTaskCreate;
        }
    }

    public static final class b extends CacheLoader implements Serializable {
        public final Function a;

        public b(Function function) {
            this.a = (Function) Preconditions.checkNotNull(function);
        }

        @Override // com.google.common.cache.CacheLoader
        public Object load(Object obj) {
            return this.a.apply(Preconditions.checkNotNull(obj));
        }
    }

    public static final class c extends CacheLoader implements Serializable {
        public final Supplier a;

        public c(Supplier supplier) {
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.cache.CacheLoader
        public Object load(Object obj) {
            Preconditions.checkNotNull(obj);
            return this.a.get();
        }
    }

    @CheckReturnValue
    @GwtIncompatible
    public static <K, V> CacheLoader<K, V> asyncReloading(CacheLoader<K, V> cacheLoader, Executor executor) {
        Preconditions.checkNotNull(cacheLoader);
        Preconditions.checkNotNull(executor);
        return cacheLoader.new a(executor);
    }

    @CheckReturnValue
    public static <K, V> CacheLoader<K, V> from(Function<K, V> function) {
        return new b(function);
    }

    public abstract V load(K k);

    public Map<K, V> loadAll(Iterable<? extends K> iterable) {
        throw new UnsupportedLoadingOperationException();
    }

    @GwtIncompatible
    public ListenableFuture<V> reload(K k, V v) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        return Futures.immediateFuture(load(k));
    }

    @CheckReturnValue
    public static <V> CacheLoader<Object, V> from(Supplier<V> supplier) {
        return new c(supplier);
    }
}
