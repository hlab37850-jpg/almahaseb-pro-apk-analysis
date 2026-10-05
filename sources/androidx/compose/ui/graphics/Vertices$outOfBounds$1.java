package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Vertices$outOfBounds$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ List<Offset> $positions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Vertices$outOfBounds$1(List<Offset> list) {
        super(1);
        this.$positions = list;
    }

    public final Boolean invoke(int i) {
        return Boolean.valueOf(i < 0 || i >= this.$positions.size());
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
