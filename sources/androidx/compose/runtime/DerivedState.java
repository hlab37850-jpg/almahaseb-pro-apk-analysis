package androidx.compose.runtime;

/* JADX INFO: loaded from: classes.dex */
public interface DerivedState<T> extends State<T> {

    public interface Record<T> {
        T getCurrentValue();

        Object[] getDependencies();
    }

    Record<T> getCurrentRecord();

    SnapshotMutationPolicy<T> getPolicy();
}
