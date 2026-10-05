package androidx.window.layout;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
final class EmptyDecorator implements WindowInfoTrackerDecorator {
    public static final EmptyDecorator INSTANCE = new EmptyDecorator();

    private EmptyDecorator() {
    }

    @Override // androidx.window.layout.WindowInfoTrackerDecorator
    public WindowInfoTracker decorate(WindowInfoTracker windowInfoTracker) {
        AbstractC4492zt.h(windowInfoTracker, "tracker");
        return windowInfoTracker;
    }
}
