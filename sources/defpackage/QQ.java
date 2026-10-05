package defpackage;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class QQ {

    public static final class a extends JL implements InterfaceC0526Fp {
        public Object a;
        public Object b;
        public int c;
        public int d;
        public /* synthetic */ Object e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;
        public final /* synthetic */ Iterator h;
        public final /* synthetic */ boolean i;
        public final /* synthetic */ boolean j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, int i2, Iterator it, boolean z, boolean z2, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.f = i;
            this.g = i2;
            this.h = it;
            this.i = z;
            this.j = z2;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            a aVar = new a(this.f, this.g, this.h, this.i, this.j, interfaceC0793Of);
            aVar.e = obj;
            return aVar;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(AO ao, InterfaceC0793Of interfaceC0793Of) {
            return ((a) create(ao, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:47:0x00e6  */
        /* JADX WARN: Code duplicated, block: B:54:0x0104  */
        /* JADX WARN: Code duplicated, block: B:55:0x0106  */
        /* JADX WARN: Code duplicated, block: B:58:0x0119 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:80:0x00f3 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:82:0x0100 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a2 -> B:16:0x0055). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0117 -> B:59:0x011a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0145 -> B:72:0x0148). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // defpackage.AbstractC2171f7
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 358
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: QQ.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final void a(int i, int i2) {
        String str;
        if (i <= 0 || i2 <= 0) {
            if (i != i2) {
                str = "Both size " + i + " and step " + i2 + " must be greater than zero.";
            } else {
                str = "size " + i + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    public static final Iterator b(Iterator it, int i, int i2, boolean z, boolean z2) {
        AbstractC4492zt.h(it, "iterator");
        return !it.hasNext() ? C2060dl.a : BO.a(new a(i, i2, it, z2, z, null));
    }
}
