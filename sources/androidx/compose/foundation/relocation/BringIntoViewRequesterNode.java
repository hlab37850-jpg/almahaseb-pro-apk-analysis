package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public final class BringIntoViewRequesterNode extends BringIntoViewChildNode {
    private BringIntoViewRequester requester;

    /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewRequesterNode$bringIntoView$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ Rect $rect;
        final /* synthetic */ BringIntoViewRequesterNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Rect rect, BringIntoViewRequesterNode bringIntoViewRequesterNode) {
            super(0);
            this.$rect = rect;
            this.this$0 = bringIntoViewRequesterNode;
        }

        @Override // defpackage.InterfaceC3588op
        public final Rect invoke() {
            Rect rect = this.$rect;
            if (rect != null) {
                return rect;
            }
            LayoutCoordinates layoutCoordinates = this.this$0.getLayoutCoordinates();
            if (layoutCoordinates != null) {
                return SizeKt.m2888toRectuvyYCjk(IntSizeKt.m5330toSizeozmzZPI(layoutCoordinates.mo4166getSizeYbymL2g()));
            }
            return null;
        }
    }

    public BringIntoViewRequesterNode(BringIntoViewRequester bringIntoViewRequester) {
        AbstractC4492zt.h(bringIntoViewRequester, "requester");
        this.requester = bringIntoViewRequester;
    }

    private final void disposeRequester() {
        BringIntoViewRequester bringIntoViewRequester = this.requester;
        if (bringIntoViewRequester instanceof BringIntoViewRequesterImpl) {
            AbstractC4492zt.f(bringIntoViewRequester, "null cannot be cast to non-null type androidx.compose.foundation.relocation.BringIntoViewRequesterImpl");
            ((BringIntoViewRequesterImpl) bringIntoViewRequester).getModifiers().remove(this);
        }
    }

    public final Object bringIntoView(Rect rect, InterfaceC0793Of interfaceC0793Of) {
        BringIntoViewParent parent = getParent();
        LayoutCoordinates layoutCoordinates = getLayoutCoordinates();
        if (layoutCoordinates == null) {
            return FW.a;
        }
        Object objBringChildIntoView = parent.bringChildIntoView(layoutCoordinates, new AnonymousClass2(rect, this), interfaceC0793Of);
        return objBringChildIntoView == AbstractC0378Bt.d() ? objBringChildIntoView : FW.a;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateRequester(this.requester);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        disposeRequester();
    }

    public final void updateRequester(BringIntoViewRequester bringIntoViewRequester) {
        AbstractC4492zt.h(bringIntoViewRequester, "requester");
        disposeRequester();
        if (bringIntoViewRequester instanceof BringIntoViewRequesterImpl) {
            ((BringIntoViewRequesterImpl) bringIntoViewRequester).getModifiers().add(this);
        }
        this.requester = bringIntoViewRequester;
    }
}
