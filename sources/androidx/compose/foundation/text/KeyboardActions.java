package androidx.compose.foundation.text;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@Stable
public final class KeyboardActions {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final KeyboardActions Default = new KeyboardActions(null, null, null, null, null, null, 63, null);
    private final InterfaceC3750qp onDone;
    private final InterfaceC3750qp onGo;
    private final InterfaceC3750qp onNext;
    private final InterfaceC3750qp onPrevious;
    private final InterfaceC3750qp onSearch;
    private final InterfaceC3750qp onSend;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        @Stable
        public static /* synthetic */ void getDefault$annotations() {
        }

        public final KeyboardActions getDefault() {
            return KeyboardActions.Default;
        }

        private Companion() {
        }
    }

    public KeyboardActions() {
        this(null, null, null, null, null, null, 63, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardActions)) {
            return false;
        }
        KeyboardActions keyboardActions = (KeyboardActions) obj;
        return AbstractC4492zt.d(this.onDone, keyboardActions.onDone) && AbstractC4492zt.d(this.onGo, keyboardActions.onGo) && AbstractC4492zt.d(this.onNext, keyboardActions.onNext) && AbstractC4492zt.d(this.onPrevious, keyboardActions.onPrevious) && AbstractC4492zt.d(this.onSearch, keyboardActions.onSearch) && AbstractC4492zt.d(this.onSend, keyboardActions.onSend);
    }

    public final InterfaceC3750qp getOnDone() {
        return this.onDone;
    }

    public final InterfaceC3750qp getOnGo() {
        return this.onGo;
    }

    public final InterfaceC3750qp getOnNext() {
        return this.onNext;
    }

    public final InterfaceC3750qp getOnPrevious() {
        return this.onPrevious;
    }

    public final InterfaceC3750qp getOnSearch() {
        return this.onSearch;
    }

    public final InterfaceC3750qp getOnSend() {
        return this.onSend;
    }

    public int hashCode() {
        InterfaceC3750qp interfaceC3750qp = this.onDone;
        int iHashCode = (interfaceC3750qp != null ? interfaceC3750qp.hashCode() : 0) * 31;
        InterfaceC3750qp interfaceC3750qp2 = this.onGo;
        int iHashCode2 = (iHashCode + (interfaceC3750qp2 != null ? interfaceC3750qp2.hashCode() : 0)) * 31;
        InterfaceC3750qp interfaceC3750qp3 = this.onNext;
        int iHashCode3 = (iHashCode2 + (interfaceC3750qp3 != null ? interfaceC3750qp3.hashCode() : 0)) * 31;
        InterfaceC3750qp interfaceC3750qp4 = this.onPrevious;
        int iHashCode4 = (iHashCode3 + (interfaceC3750qp4 != null ? interfaceC3750qp4.hashCode() : 0)) * 31;
        InterfaceC3750qp interfaceC3750qp5 = this.onSearch;
        int iHashCode5 = (iHashCode4 + (interfaceC3750qp5 != null ? interfaceC3750qp5.hashCode() : 0)) * 31;
        InterfaceC3750qp interfaceC3750qp6 = this.onSend;
        return iHashCode5 + (interfaceC3750qp6 != null ? interfaceC3750qp6.hashCode() : 0);
    }

    public KeyboardActions(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC3750qp interfaceC3750qp3, InterfaceC3750qp interfaceC3750qp4, InterfaceC3750qp interfaceC3750qp5, InterfaceC3750qp interfaceC3750qp6) {
        this.onDone = interfaceC3750qp;
        this.onGo = interfaceC3750qp2;
        this.onNext = interfaceC3750qp3;
        this.onPrevious = interfaceC3750qp4;
        this.onSearch = interfaceC3750qp5;
        this.onSend = interfaceC3750qp6;
    }

    public /* synthetic */ KeyboardActions(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC3750qp interfaceC3750qp3, InterfaceC3750qp interfaceC3750qp4, InterfaceC3750qp interfaceC3750qp5, InterfaceC3750qp interfaceC3750qp6, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? null : interfaceC3750qp, (i & 2) != 0 ? null : interfaceC3750qp2, (i & 4) != 0 ? null : interfaceC3750qp3, (i & 8) != 0 ? null : interfaceC3750qp4, (i & 16) != 0 ? null : interfaceC3750qp5, (i & 32) != 0 ? null : interfaceC3750qp6);
    }
}
