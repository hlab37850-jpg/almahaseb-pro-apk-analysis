package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import defpackage.C0916Sp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class SelectionAdjustment$Companion$Word$1$adjust$1 extends C0916Sp implements InterfaceC3750qp {
    public SelectionAdjustment$Companion$Word$1$adjust$1(Object obj) {
        super(1, obj, TextLayoutResult.class, "getWordBoundary", "getWordBoundary--jx7JFs(I)J", 0);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return TextRange.m4693boximpl(m897invokejx7JFs(((Number) obj).intValue()));
    }

    /* JADX INFO: renamed from: invoke--jx7JFs, reason: not valid java name */
    public final long m897invokejx7JFs(int i) {
        return ((TextLayoutResult) this.receiver).m4679getWordBoundaryjx7JFs(i);
    }
}
