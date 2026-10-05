package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import defpackage.AbstractC4492zt;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class QueryInterceptorOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final SupportSQLiteOpenHelper.Factory delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;

    public QueryInterceptorOpenHelperFactory(SupportSQLiteOpenHelper.Factory factory, Executor executor, RoomDatabase.QueryCallback queryCallback) {
        AbstractC4492zt.h(factory, "delegate");
        AbstractC4492zt.h(executor, "queryCallbackExecutor");
        AbstractC4492zt.h(queryCallback, "queryCallback");
        this.delegate = factory;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        AbstractC4492zt.h(configuration, "configuration");
        return new QueryInterceptorOpenHelper(this.delegate.create(configuration), this.queryCallbackExecutor, this.queryCallback);
    }
}
