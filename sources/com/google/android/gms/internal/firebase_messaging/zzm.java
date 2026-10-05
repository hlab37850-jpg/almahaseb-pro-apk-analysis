package com.google.android.gms.internal.firebase_messaging;

import defpackage.AbstractC3497nh0;
import defpackage.C4227wh0;
import defpackage.Ph0;
import java.io.PrintStream;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes2.dex */
public final class zzm {
    private static final AbstractC3497nh0 zza;
    private static final int zzb;

    public static final class a extends AbstractC3497nh0 {
        @Override // defpackage.AbstractC3497nh0
        public final void a(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001e A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0006, B:6:0x000e, B:9:0x0016, B:11:0x001e, B:12:0x0024), top: B:24:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:12:0x0024 A[Catch: all -> 0x0014, TRY_LEAVE, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0006, B:6:0x000e, B:9:0x0016, B:11:0x001e, B:12:0x0024), top: B:24:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x0016 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0006, B:6:0x000e, B:9:0x0016, B:11:0x001e, B:12:0x0024), top: B:24:0x0006 }] */
    static {
        Integer numZza;
        AbstractC3497nh0 aVar;
        try {
            numZza = zza();
            if (numZza != null) {
                try {
                    if (numZza.intValue() >= 19) {
                        aVar = new Ph0();
                    } else if (Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
                        aVar = new a();
                    } else {
                        aVar = new C4227wh0();
                    }
                } catch (Throwable th) {
                    th = th;
                    PrintStream printStream = System.err;
                    String name = a.class.getName();
                    StringBuilder sb = new StringBuilder(name.length() + ShapeTypes.FLOW_CHART_DECISION);
                    sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
                    sb.append(name);
                    sb.append("will be used. The error is: ");
                    printStream.println(sb.toString());
                    th.printStackTrace(printStream);
                    aVar = new a();
                }
            } else if (Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
                aVar = new C4227wh0();
            } else {
                aVar = new a();
            }
        } catch (Throwable th2) {
            th = th2;
            numZza = null;
        }
        zza = aVar;
        zzb = numZza == null ? 1 : numZza.intValue();
    }

    public static void zza(Throwable th, Throwable th2) {
        zza.a(th, th2);
    }

    private static Integer zza() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            PrintStream printStream = System.err;
            printStream.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(printStream);
            return null;
        }
    }
}
