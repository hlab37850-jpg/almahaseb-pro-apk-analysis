package androidx.compose.runtime;

import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class Updater<T> {
    private final Composer composer;

    private /* synthetic */ Updater(Composer composer) {
        this.composer = composer;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Updater m2660boximpl(Composer composer) {
        return new Updater(composer);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> Composer m2661constructorimpl(Composer composer) {
        AbstractC4492zt.h(composer, "composer");
        return composer;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2662equalsimpl(Composer composer, Object obj) {
        return (obj instanceof Updater) && AbstractC4492zt.d(composer, ((Updater) obj).m2672unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2663equalsimpl0(Composer composer, Composer composer2) {
        return AbstractC4492zt.d(composer, composer2);
    }

    public static /* synthetic */ void getComposer$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2664hashCodeimpl(Composer composer) {
        return composer.hashCode();
    }

    /* JADX INFO: renamed from: init-impl, reason: not valid java name */
    public static final void m2665initimpl(Composer composer, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        if (composer.getInserting()) {
            composer.apply(FW.a, new Updater$init$1(interfaceC3750qp));
        }
    }

    /* JADX INFO: renamed from: reconcile-impl, reason: not valid java name */
    public static final void m2666reconcileimpl(Composer composer, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        composer.apply(FW.a, new Updater$reconcile$1(interfaceC3750qp));
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m2667setimpl(Composer composer, int i, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        if (composer.getInserting() || !AbstractC4492zt.d(composer.rememberedValue(), Integer.valueOf(i))) {
            composer.updateRememberedValue(Integer.valueOf(i));
            composer.apply(Integer.valueOf(i), interfaceC0526Fp);
        }
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2669toStringimpl(Composer composer) {
        return "Updater(composer=" + composer + ')';
    }

    /* JADX INFO: renamed from: update-impl, reason: not valid java name */
    public static final void m2670updateimpl(Composer composer, int i, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        boolean inserting = composer.getInserting();
        if (inserting || !AbstractC4492zt.d(composer.rememberedValue(), Integer.valueOf(i))) {
            composer.updateRememberedValue(Integer.valueOf(i));
            if (inserting) {
                return;
            }
            composer.apply(Integer.valueOf(i), interfaceC0526Fp);
        }
    }

    public boolean equals(Object obj) {
        return m2662equalsimpl(this.composer, obj);
    }

    public int hashCode() {
        return m2664hashCodeimpl(this.composer);
    }

    public String toString() {
        return m2669toStringimpl(this.composer);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Composer m2672unboximpl() {
        return this.composer;
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final <V> void m2668setimpl(Composer composer, V v, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        if (composer.getInserting() || !AbstractC4492zt.d(composer.rememberedValue(), v)) {
            composer.updateRememberedValue(v);
            composer.apply(v, interfaceC0526Fp);
        }
    }

    /* JADX INFO: renamed from: update-impl, reason: not valid java name */
    public static final <V> void m2671updateimpl(Composer composer, V v, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        boolean inserting = composer.getInserting();
        if (inserting || !AbstractC4492zt.d(composer.rememberedValue(), v)) {
            composer.updateRememberedValue(v);
            if (inserting) {
                return;
            }
            composer.apply(v, interfaceC0526Fp);
        }
    }
}
