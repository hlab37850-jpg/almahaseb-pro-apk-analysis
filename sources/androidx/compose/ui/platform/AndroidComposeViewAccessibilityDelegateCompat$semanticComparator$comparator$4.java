package androidx.compose.ui.platform;

import androidx.compose.ui.semantics.SemanticsNode;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$comparator$4 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$comparator$4 INSTANCE = new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$comparator$4();

    public AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$comparator$4() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Comparable<?> invoke(SemanticsNode semanticsNode) {
        AbstractC4492zt.h(semanticsNode, "it");
        return Float.valueOf(semanticsNode.getBoundsInWindow().getRight());
    }
}
