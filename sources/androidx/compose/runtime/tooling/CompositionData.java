package androidx.compose.runtime.tooling;

/* JADX INFO: loaded from: classes.dex */
public interface CompositionData {
    CompositionGroup find(Object obj);

    Iterable<CompositionGroup> getCompositionGroups();

    boolean isEmpty();
}
