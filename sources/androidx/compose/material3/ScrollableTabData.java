package androidx.compose.material3;

import androidx.compose.foundation.ScrollState;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC2052dg;
import defpackage.O8;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class ScrollableTabData {
    private final InterfaceC2052dg coroutineScope;
    private final ScrollState scrollState;
    private Integer selectedTab;

    public ScrollableTabData(ScrollState scrollState, InterfaceC2052dg interfaceC2052dg) {
        AbstractC4492zt.h(scrollState, "scrollState");
        AbstractC4492zt.h(interfaceC2052dg, "coroutineScope");
        this.scrollState = scrollState;
        this.coroutineScope = interfaceC2052dg;
    }

    private final int calculateTabOffset(TabPosition tabPosition, Density density, int i, List<TabPosition> list) {
        int iMo327roundToPx0680j_4 = density.mo327roundToPx0680j_4(((TabPosition) AbstractC3240kc.k0(list)).m1883getRightD9Ej5fM()) + i;
        int maxValue = iMo327roundToPx0680j_4 - this.scrollState.getMaxValue();
        return AbstractC3871sJ.l(density.mo327roundToPx0680j_4(tabPosition.m1882getLeftD9Ej5fM()) - ((maxValue / 2) - (density.mo327roundToPx0680j_4(tabPosition.m1884getWidthD9Ej5fM()) / 2)), 0, AbstractC3871sJ.d(iMo327roundToPx0680j_4 - maxValue, 0));
    }

    public final void onLaidOut(Density density, int i, List<TabPosition> list, int i2) {
        int iCalculateTabOffset;
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(list, "tabPositions");
        Integer num = this.selectedTab;
        if (num != null && num.intValue() == i2) {
            return;
        }
        this.selectedTab = Integer.valueOf(i2);
        TabPosition tabPosition = (TabPosition) AbstractC3240kc.e0(list, i2);
        if (tabPosition == null || this.scrollState.getValue() == (iCalculateTabOffset = calculateTabOffset(tabPosition, density, i, list))) {
            return;
        }
        O8.d(this.coroutineScope, null, null, new ScrollableTabData$onLaidOut$1$1(this, iCalculateTabOffset, null), 3, null);
    }
}
