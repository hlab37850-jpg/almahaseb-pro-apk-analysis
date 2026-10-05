package androidx.window.layout;

import defpackage.AbstractC4492zt;
import defpackage.C0916Sp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class WindowMetricsCalculator$Companion$overrideDecorator$1 extends C0916Sp implements InterfaceC3750qp {
    public WindowMetricsCalculator$Companion$overrideDecorator$1(Object obj) {
        super(1, obj, WindowMetricsCalculatorDecorator.class, "decorate", "decorate(Landroidx/window/layout/WindowMetricsCalculator;)Landroidx/window/layout/WindowMetricsCalculator;", 0);
    }

    @Override // defpackage.InterfaceC3750qp
    public final WindowMetricsCalculator invoke(WindowMetricsCalculator windowMetricsCalculator) {
        AbstractC4492zt.h(windowMetricsCalculator, "p0");
        return ((WindowMetricsCalculatorDecorator) this.receiver).decorate(windowMetricsCalculator);
    }
}
