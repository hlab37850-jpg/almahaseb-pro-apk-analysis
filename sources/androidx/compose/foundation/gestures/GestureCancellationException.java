package androidx.compose.foundation.gestures;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0419Di;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class GestureCancellationException extends CancellationException {
    public static final int $stable = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public GestureCancellationException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public GestureCancellationException(String str) {
        super(str);
    }

    public /* synthetic */ GestureCancellationException(String str, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? null : str);
    }
}
