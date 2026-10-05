package androidx.compose.ui.platform;

import androidx.compose.runtime.snapshots.Snapshot;
import defpackage.AbstractC2133eg;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2287gb;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC1009Wa;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.O8;
import defpackage.XS;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class GlobalSnapshotManager {
    public static final GlobalSnapshotManager INSTANCE = new GlobalSnapshotManager();
    private static final AtomicBoolean started = new AtomicBoolean(false);

    /* JADX INFO: renamed from: androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1", f = "GlobalSnapshotManager.android.kt", l = {63}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC1009Wa $channel;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC1009Wa interfaceC1009Wa, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$channel = interfaceC1009Wa;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.$channel, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0037 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:19:0x0040 A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #1 {all -> 0x0017, blocks: (B:6:0x0013, B:17:0x0038, B:19:0x0040, B:14:0x002b, B:13:0x0026), top: B:29:0x0007 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0035 -> B:17:0x0038). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // defpackage.AbstractC2171f7
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = defpackage.AbstractC0378Bt.d()
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L21
                if (r1 != r2) goto L19
                java.lang.Object r1 = r4.L$1
                fb r1 = (defpackage.InterfaceC2205fb) r1
                java.lang.Object r3 = r4.L$0
                IJ r3 = (defpackage.IJ) r3
                defpackage.LL.b(r5)     // Catch: java.lang.Throwable -> L17
                goto L38
            L17:
                r5 = move-exception
                goto L53
            L19:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L21:
                defpackage.LL.b(r5)
                Wa r3 = r4.$channel
                fb r5 = r3.iterator()     // Catch: java.lang.Throwable -> L17
                r1 = r5
            L2b:
                r4.L$0 = r3     // Catch: java.lang.Throwable -> L17
                r4.L$1 = r1     // Catch: java.lang.Throwable -> L17
                r4.label = r2     // Catch: java.lang.Throwable -> L17
                java.lang.Object r5 = r1.a(r4)     // Catch: java.lang.Throwable -> L17
                if (r5 != r0) goto L38
                return r0
            L38:
                java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch: java.lang.Throwable -> L17
                boolean r5 = r5.booleanValue()     // Catch: java.lang.Throwable -> L17
                if (r5 == 0) goto L4c
                java.lang.Object r5 = r1.next()     // Catch: java.lang.Throwable -> L17
                FW r5 = (defpackage.FW) r5     // Catch: java.lang.Throwable -> L17
                androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch: java.lang.Throwable -> L17
                r5.sendApplyNotifications()     // Catch: java.lang.Throwable -> L17
                goto L2b
            L4c:
                r5 = 0
                defpackage.AbstractC3156jb.a(r3, r5)
                FW r5 = defpackage.FW.a
                return r5
            L53:
                throw r5     // Catch: java.lang.Throwable -> L54
            L54:
                r0 = move-exception
                defpackage.AbstractC3156jb.a(r3, r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.GlobalSnapshotManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC1009Wa $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC1009Wa interfaceC1009Wa) {
            super(1);
            this.$channel = interfaceC1009Wa;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m4495invoke(obj);
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m4495invoke(Object obj) {
            AbstractC4492zt.h(obj, "it");
            this.$channel.mo0trySendJP2dKIU(FW.a);
        }
    }

    private GlobalSnapshotManager() {
    }

    public final void ensureStarted() {
        if (started.compareAndSet(false, true)) {
            InterfaceC1009Wa interfaceC1009WaB = AbstractC2287gb.b(-1, null, null, 6, null);
            O8.d(AbstractC2133eg.a(AndroidUiDispatcher.Companion.getMain()), null, null, new AnonymousClass1(interfaceC1009WaB, null), 3, null);
            Snapshot.Companion.registerGlobalWriteObserver(new AnonymousClass2(interfaceC1009WaB));
        }
    }
}
