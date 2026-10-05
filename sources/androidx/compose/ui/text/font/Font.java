package androidx.compose.ui.text.font;

import androidx.compose.runtime.Immutable;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public interface Font {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final long MaximumAsyncTimeoutMillis = 15000;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final long MaximumAsyncTimeoutMillis = 15000;

        private Companion() {
        }
    }

    public interface ResourceLoader {
        Object load(Font font);
    }

    /* JADX INFO: renamed from: getLoadingStrategy-PKNRLFQ */
    int mo4747getLoadingStrategyPKNRLFQ();

    /* JADX INFO: renamed from: getStyle-_-LCdwA */
    int mo4757getStyle_LCdwA();

    FontWeight getWeight();
}
