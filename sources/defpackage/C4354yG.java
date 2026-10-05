package defpackage;

import android.net.NetworkInfo;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: yG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4354yG extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: yG$a */
    public static final class a extends FutureTask implements Comparable {
        public final RunnableC2091e8 a;

        public a(RunnableC2091e8 runnableC2091e8) {
            super(runnableC2091e8, null);
            this.a = runnableC2091e8;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            C4192wG.f fVarP = this.a.p();
            C4192wG.f fVarP2 = aVar.a.p();
            return fVarP == fVarP2 ? this.a.a - aVar.a.a : fVarP2.ordinal() - fVarP.ordinal();
        }
    }

    public C4354yG() {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new AbstractC4047uX.f());
    }

    public void a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            b(3);
            return;
        }
        int type = networkInfo.getType();
        if (type != 0) {
            if (type == 1 || type == 6 || type == 9) {
                b(4);
                return;
            } else {
                b(3);
                return;
            }
        }
        int subtype = networkInfo.getSubtype();
        switch (subtype) {
            case 1:
            case 2:
                b(1);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                switch (subtype) {
                    case 12:
                        break;
                    case 13:
                    case 14:
                    case 15:
                        b(3);
                        break;
                    default:
                        b(3);
                        break;
                }
                return;
        }
        b(2);
    }

    public final void b(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        a aVar = new a((RunnableC2091e8) runnable);
        execute(aVar);
        return aVar;
    }
}
