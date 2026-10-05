package androidx.paging;

import com.itextpdf.text.pdf.codec.TIFFConstants;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC3240kc;
import defpackage.C0529Fs;
import defpackage.FW;
import defpackage.GC;
import defpackage.IC;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class FlattenedPageController<T> {
    private final FlattenedPageEventStorage<T> list = new FlattenedPageEventStorage<>();
    private final GC lock = IC.b(false, 1, null);
    private int maxEventIndex = -1;

    /* JADX INFO: renamed from: androidx.paging.FlattenedPageController$getStateAsEvents$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.FlattenedPageController", f = "CachedPageEventFlow.kt", l = {TIFFConstants.TIFFTAG_FREEOFFSETS}, m = "getStateAsEvents")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlattenedPageController<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FlattenedPageController<T> flattenedPageController, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = flattenedPageController;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getStateAsEvents(this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.FlattenedPageController$record$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.FlattenedPageController", f = "CachedPageEventFlow.kt", l = {TIFFConstants.TIFFTAG_FREEOFFSETS}, m = "record")
    public static final class C16951 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlattenedPageController<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16951(FlattenedPageController<T> flattenedPageController, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = flattenedPageController;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.record(null, this);
        }
    }

    public final PageEvent.Insert<T> getCachedEvent() {
        PageEvent pageEvent = (PageEvent) AbstractC3240kc.d0(this.list.getAsEvents());
        if (pageEvent == null || !(pageEvent instanceof PageEvent.Insert)) {
            return null;
        }
        PageEvent.Insert<T> insert = (PageEvent.Insert) pageEvent;
        if (insert.getLoadType() == LoadType.REFRESH) {
            return insert;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getStateAsEvents(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
        FlattenedPageController<T> flattenedPageController;
        GC gc;
        if (interfaceC0793Of instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, interfaceC0793Of);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, interfaceC0793Of);
        }
        Object obj = anonymousClass1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            LL.b(obj);
            GC gc2 = this.lock;
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = gc2;
            anonymousClass1.label = 1;
            if (gc2.c(null, anonymousClass1) == objD) {
                return objD;
            }
            flattenedPageController = this;
            gc = gc2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            gc = (GC) anonymousClass1.L$1;
            flattenedPageController = (FlattenedPageController) anonymousClass1.L$0;
            LL.b(obj);
        }
        try {
            List<PageEvent<T>> asEvents = flattenedPageController.list.getAsEvents();
            int size = (flattenedPageController.maxEventIndex - asEvents.size()) + 1;
            List<PageEvent<T>> list = asEvents;
            ArrayList arrayList = new ArrayList(AbstractC2044dc.x(list, 10));
            int i3 = 0;
            for (T t : list) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    AbstractC1886cc.w();
                }
                arrayList.add(new C0529Fs(i3 + size, (PageEvent) t));
                i3 = i4;
            }
            return arrayList;
        } finally {
            gc.b(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object record(C0529Fs c0529Fs, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C16951 c16951;
        GC gc;
        FlattenedPageController<T> flattenedPageController;
        if (interfaceC0793Of instanceof C16951) {
            c16951 = (C16951) interfaceC0793Of;
            int i = c16951.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c16951.label = i - Integer.MIN_VALUE;
            } else {
                c16951 = new C16951(this, interfaceC0793Of);
            }
        } else {
            c16951 = new C16951(this, interfaceC0793Of);
        }
        Object obj = c16951.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c16951.label;
        if (i2 == 0) {
            LL.b(obj);
            gc = this.lock;
            c16951.L$0 = this;
            c16951.L$1 = c0529Fs;
            c16951.L$2 = gc;
            c16951.label = 1;
            if (gc.c(null, c16951) == objD) {
                return objD;
            }
            flattenedPageController = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            GC gc2 = (GC) c16951.L$2;
            C0529Fs c0529Fs2 = (C0529Fs) c16951.L$1;
            flattenedPageController = (FlattenedPageController) c16951.L$0;
            LL.b(obj);
            gc = gc2;
            c0529Fs = c0529Fs2;
        }
        try {
            flattenedPageController.maxEventIndex = c0529Fs.a();
            flattenedPageController.list.add((PageEvent) c0529Fs.b());
            FW fw = FW.a;
            return FW.a;
        } finally {
            gc.b(null);
        }
    }
}
