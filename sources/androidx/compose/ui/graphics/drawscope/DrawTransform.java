package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.Path;
import defpackage.AbstractC3337lk;

/* JADX INFO: loaded from: classes.dex */
@DrawScopeMarker
public interface DrawTransform {

    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m3549getCenterF1C5BW0(DrawTransform drawTransform) {
            return AbstractC3337lk.a(drawTransform);
        }
    }

    /* JADX INFO: renamed from: clipPath-mtrdD-E */
    void mo3477clipPathmtrdDE(Path path, int i);

    /* JADX INFO: renamed from: clipRect-N_I0leg */
    void mo3478clipRectN_I0leg(float f, float f2, float f3, float f4, int i);

    /* JADX INFO: renamed from: getCenter-F1C5BW0 */
    long mo3479getCenterF1C5BW0();

    /* JADX INFO: renamed from: getSize-NH-jbRc */
    long mo3480getSizeNHjbRc();

    void inset(float f, float f2, float f3, float f4);

    /* JADX INFO: renamed from: rotate-Uv8p0NA */
    void mo3481rotateUv8p0NA(float f, long j);

    /* JADX INFO: renamed from: scale-0AR0LA0 */
    void mo3482scale0AR0LA0(float f, float f2, long j);

    /* JADX INFO: renamed from: transform-58bKbWc */
    void mo3483transform58bKbWc(float[] fArr);

    void translate(float f, float f2);
}
