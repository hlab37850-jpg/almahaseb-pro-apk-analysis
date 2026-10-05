package androidx.compose.ui.graphics;

/* JADX INFO: loaded from: classes.dex */
public interface PathMeasure {

    public static final class DefaultImpls {
    }

    float getLength();

    /* JADX INFO: renamed from: getPosition-tuRUvjQ */
    long mo2938getPositiontuRUvjQ(float f);

    boolean getSegment(float f, float f2, Path path, boolean z);

    /* JADX INFO: renamed from: getTangent-tuRUvjQ */
    long mo2939getTangenttuRUvjQ(float f);

    void setPath(Path path, boolean z);
}
