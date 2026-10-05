package androidx.compose.material3;

import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
final class FadeInFadeOutAnimationItem<T> {
    private final T key;
    private final InterfaceC0552Gp transition;

    public FadeInFadeOutAnimationItem(T t, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(interfaceC0552Gp, "transition");
        this.key = t;
        this.transition = interfaceC0552Gp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FadeInFadeOutAnimationItem copy$default(FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem, Object obj, InterfaceC0552Gp interfaceC0552Gp, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = fadeInFadeOutAnimationItem.key;
        }
        if ((i & 2) != 0) {
            interfaceC0552Gp = fadeInFadeOutAnimationItem.transition;
        }
        return fadeInFadeOutAnimationItem.copy(obj, interfaceC0552Gp);
    }

    public final T component1() {
        return this.key;
    }

    public final InterfaceC0552Gp component2() {
        return this.transition;
    }

    public final FadeInFadeOutAnimationItem<T> copy(T t, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(interfaceC0552Gp, "transition");
        return new FadeInFadeOutAnimationItem<>(t, interfaceC0552Gp);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FadeInFadeOutAnimationItem)) {
            return false;
        }
        FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = (FadeInFadeOutAnimationItem) obj;
        return AbstractC4492zt.d(this.key, fadeInFadeOutAnimationItem.key) && AbstractC4492zt.d(this.transition, fadeInFadeOutAnimationItem.transition);
    }

    public final T getKey() {
        return this.key;
    }

    public final InterfaceC0552Gp getTransition() {
        return this.transition;
    }

    public int hashCode() {
        T t = this.key;
        return ((t == null ? 0 : t.hashCode()) * 31) + this.transition.hashCode();
    }

    public String toString() {
        return "FadeInFadeOutAnimationItem(key=" + this.key + ", transition=" + this.transition + ')';
    }
}
