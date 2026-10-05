package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ ScrollAxisRange $accessibilityScrollState;
    final /* synthetic */ CollectionInfo $collectionInfo;
    final /* synthetic */ InterfaceC3750qp $indexForKeyMapping;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ InterfaceC0526Fp $scrollByAction;
    final /* synthetic */ InterfaceC3750qp $scrollToIndexAction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutSemanticsKt$lazyLayoutSemantics$1$1(InterfaceC3750qp interfaceC3750qp, boolean z, ScrollAxisRange scrollAxisRange, InterfaceC0526Fp interfaceC0526Fp, InterfaceC3750qp interfaceC3750qp2, CollectionInfo collectionInfo) {
        super(1);
        this.$indexForKeyMapping = interfaceC3750qp;
        this.$isVertical = z;
        this.$accessibilityScrollState = scrollAxisRange;
        this.$scrollByAction = interfaceC0526Fp;
        this.$scrollToIndexAction = interfaceC3750qp2;
        this.$collectionInfo = collectionInfo;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return FW.a;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        SemanticsPropertiesKt.indexForKey(semanticsPropertyReceiver, this.$indexForKeyMapping);
        if (this.$isVertical) {
            SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, this.$accessibilityScrollState);
        } else {
            SemanticsPropertiesKt.setHorizontalScrollAxisRange(semanticsPropertyReceiver, this.$accessibilityScrollState);
        }
        InterfaceC0526Fp interfaceC0526Fp = this.$scrollByAction;
        if (interfaceC0526Fp != null) {
            SemanticsPropertiesKt.scrollBy$default(semanticsPropertyReceiver, null, interfaceC0526Fp, 1, null);
        }
        InterfaceC3750qp interfaceC3750qp = this.$scrollToIndexAction;
        if (interfaceC3750qp != null) {
            SemanticsPropertiesKt.scrollToIndex$default(semanticsPropertyReceiver, null, interfaceC3750qp, 1, null);
        }
        SemanticsPropertiesKt.setCollectionInfo(semanticsPropertyReceiver, this.$collectionInfo);
    }
}
