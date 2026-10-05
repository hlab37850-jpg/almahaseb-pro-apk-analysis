package androidx.compose.foundation.pager;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalFoundationApi
public interface PagerSnapDistance {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final PagerSnapDistance atMost(int i) {
            if (i >= 0) {
                return new PagerSnapDistanceMaxPages(i);
            }
            throw new IllegalArgumentException(("pages should be greater than or equal to 0. You have used " + i + '.').toString());
        }
    }

    int calculateTargetPage(int i, int i2, float f, int i3, int i4);
}
