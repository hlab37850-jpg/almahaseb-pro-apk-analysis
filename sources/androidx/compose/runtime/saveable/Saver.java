package androidx.compose.runtime.saveable;

/* JADX INFO: loaded from: classes.dex */
public interface Saver<Original, Saveable> {
    Original restore(Saveable saveable);

    Saveable save(SaverScope saverScope, Original original);
}
