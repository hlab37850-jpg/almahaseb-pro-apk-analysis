package androidx.compose.ui.layout;

import androidx.compose.runtime.Immutable;
import defpackage.AbstractC0419Di;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public abstract class AlignmentLine {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    public static final int Unspecified = Integer.MIN_VALUE;
    private final InterfaceC0526Fp merger;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ AlignmentLine(InterfaceC0526Fp interfaceC0526Fp, AbstractC0419Di abstractC0419Di) {
        this(interfaceC0526Fp);
    }

    public final InterfaceC0526Fp getMerger$ui_release() {
        return this.merger;
    }

    private AlignmentLine(InterfaceC0526Fp interfaceC0526Fp) {
        this.merger = interfaceC0526Fp;
    }
}
