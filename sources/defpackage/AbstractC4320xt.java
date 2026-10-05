package defpackage;

import androidx.compose.foundation.lazy.layout.IntervalList;

/* JADX INFO: renamed from: xt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC4320xt {
    public static /* synthetic */ void a(IntervalList intervalList, int i, int i2, InterfaceC3750qp interfaceC3750qp, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: forEach");
        }
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = intervalList.getSize() - 1;
        }
        intervalList.forEach(i, i2, interfaceC3750qp);
    }
}
