package androidx.window.embedding;

import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import defpackage.AbstractC4492zt;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
final class EmptyEmbeddingComponent implements ActivityEmbeddingComponent {
    public void setEmbeddingRules(Set<androidx.window.extensions.embedding.EmbeddingRule> set) {
        AbstractC4492zt.h(set, "splitRules");
    }

    public void setSplitInfoCallback(Consumer<List<androidx.window.extensions.embedding.SplitInfo>> consumer) {
        AbstractC4492zt.h(consumer, "consumer");
    }
}
