package androidx.compose.foundation.gestures;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4293xa;
import defpackage.KL;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class BringIntoViewRequestPriorityQueue {
    private final MutableVector<ContentInViewModifier.Request> requests = new MutableVector<>(new ContentInViewModifier.Request[16], 0);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue$enqueue$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ ContentInViewModifier.Request $request;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ContentInViewModifier.Request request) {
            super(1);
            this.$request = request;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return FW.a;
        }

        public final void invoke(Throwable th) {
            BringIntoViewRequestPriorityQueue.this.requests.remove(this.$request);
        }
    }

    public final void cancelAndRemoveAll(Throwable th) {
        MutableVector<ContentInViewModifier.Request> mutableVector = this.requests;
        int size = mutableVector.getSize();
        InterfaceC4293xa[] interfaceC4293xaArr = new InterfaceC4293xa[size];
        for (int i = 0; i < size; i++) {
            interfaceC4293xaArr[i] = mutableVector.getContent()[i].getContinuation();
        }
        for (int i2 = 0; i2 < size; i2++) {
            interfaceC4293xaArr[i2].m(th);
        }
        if (!this.requests.isEmpty()) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final boolean enqueue(ContentInViewModifier.Request request) {
        AbstractC4492zt.h(request, "request");
        Rect rect = (Rect) request.getCurrentBounds().invoke();
        if (rect == null) {
            InterfaceC4293xa continuation = request.getContinuation();
            KL.a aVar = KL.a;
            continuation.resumeWith(KL.a(FW.a));
            return false;
        }
        request.getContinuation().e(new AnonymousClass1(request));
        C1001Vs c1001Vs = new C1001Vs(0, this.requests.getSize() - 1);
        int iB = c1001Vs.b();
        int iC = c1001Vs.c();
        if (iB <= iC) {
            while (true) {
                Rect rect2 = (Rect) this.requests.getContent()[iC].getCurrentBounds().invoke();
                if (rect2 != null) {
                    Rect rectIntersect = rect.intersect(rect2);
                    if (!AbstractC4492zt.d(rectIntersect, rect)) {
                        if (!AbstractC4492zt.d(rectIntersect, rect2)) {
                            CancellationException cancellationException = new CancellationException("bringIntoView call interrupted by a newer, non-overlapping call");
                            int size = this.requests.getSize() - 1;
                            if (size <= iC) {
                                while (true) {
                                    this.requests.getContent()[iC].getContinuation().m(cancellationException);
                                    if (size == iC) {
                                        break;
                                    }
                                    size++;
                                }
                            }
                        }
                    } else {
                        this.requests.add(iC + 1, request);
                        return true;
                    }
                }
                if (iC != iB) {
                    iC--;
                }
            }
        }
        this.requests.add(0, request);
        return true;
    }

    public final void forEachFromSmallest(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        MutableVector mutableVector = this.requests;
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = size - 1;
            Object[] content = mutableVector.getContent();
            do {
                interfaceC3750qp.invoke(((ContentInViewModifier.Request) content[i]).getCurrentBounds().invoke());
                i--;
            } while (i >= 0);
        }
    }

    public final int getSize() {
        return this.requests.getSize();
    }

    public final boolean isEmpty() {
        return this.requests.isEmpty();
    }

    public final void resumeAndRemoveAll() {
        C1001Vs c1001Vs = new C1001Vs(0, this.requests.getSize() - 1);
        int iB = c1001Vs.b();
        int iC = c1001Vs.c();
        if (iB <= iC) {
            while (true) {
                this.requests.getContent()[iB].getContinuation().resumeWith(KL.a(FW.a));
                if (iB == iC) {
                    break;
                } else {
                    iB++;
                }
            }
        }
        this.requests.clear();
    }

    public final void resumeAndRemoveWhile(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        while (this.requests.isNotEmpty() && ((Boolean) interfaceC3750qp.invoke(((ContentInViewModifier.Request) this.requests.last()).getCurrentBounds().invoke())).booleanValue()) {
            ((ContentInViewModifier.Request) this.requests.removeAt(this.requests.getSize() - 1)).getContinuation().resumeWith(KL.a(FW.a));
        }
    }
}
