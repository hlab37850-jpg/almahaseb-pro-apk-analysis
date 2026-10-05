package androidx.activity;

import androidx.annotation.ColorInt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SystemBarStyle {
    public static final Companion Companion = new Companion(null);
    private final int darkScrim;
    private final InterfaceC3750qp detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public static /* synthetic */ SystemBarStyle auto$default(Companion companion, int i, int i2, InterfaceC3750qp interfaceC3750qp, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                interfaceC3750qp = SystemBarStyle$Companion$auto$1.INSTANCE;
            }
            return companion.auto(i, i2, interfaceC3750qp);
        }

        public final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2) {
            return auto$default(this, i, i2, null, 4, null);
        }

        public final SystemBarStyle dark(@ColorInt int i) {
            return new SystemBarStyle(i, i, 2, SystemBarStyle$Companion$dark$1.INSTANCE, null);
        }

        public final SystemBarStyle light(@ColorInt int i, @ColorInt int i2) {
            return new SystemBarStyle(i, i2, 1, SystemBarStyle$Companion$light$1.INSTANCE, null);
        }

        private Companion() {
        }

        public final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "detectDarkMode");
            return new SystemBarStyle(i, i2, 0, interfaceC3750qp, null);
        }
    }

    public /* synthetic */ SystemBarStyle(int i, int i2, int i3, InterfaceC3750qp interfaceC3750qp, AbstractC0419Di abstractC0419Di) {
        this(i, i2, i3, interfaceC3750qp);
    }

    public static final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2) {
        return Companion.auto(i, i2);
    }

    public static final SystemBarStyle dark(@ColorInt int i) {
        return Companion.dark(i);
    }

    public static final SystemBarStyle light(@ColorInt int i, @ColorInt int i2) {
        return Companion.light(i, i2);
    }

    public final int getDarkScrim$activity_release() {
        return this.darkScrim;
    }

    public final InterfaceC3750qp getDetectDarkMode$activity_release() {
        return this.detectDarkMode;
    }

    public final int getNightMode$activity_release() {
        return this.nightMode;
    }

    public final int getScrim$activity_release(boolean z) {
        return z ? this.darkScrim : this.lightScrim;
    }

    public final int getScrimWithEnforcedContrast$activity_release(boolean z) {
        if (this.nightMode == 0) {
            return 0;
        }
        return z ? this.darkScrim : this.lightScrim;
    }

    private SystemBarStyle(int i, int i2, int i3, InterfaceC3750qp interfaceC3750qp) {
        this.lightScrim = i;
        this.darkScrim = i2;
        this.nightMode = i3;
        this.detectDarkMode = interfaceC3750qp;
    }

    public static final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2, InterfaceC3750qp interfaceC3750qp) {
        return Companion.auto(i, i2, interfaceC3750qp);
    }
}
