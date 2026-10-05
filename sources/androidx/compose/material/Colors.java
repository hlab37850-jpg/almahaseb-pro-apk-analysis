package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@Stable
public final class Colors {
    public static final int $stable = 0;
    private final MutableState background$delegate;
    private final MutableState error$delegate;
    private final MutableState isLight$delegate;
    private final MutableState onBackground$delegate;
    private final MutableState onError$delegate;
    private final MutableState onPrimary$delegate;
    private final MutableState onSecondary$delegate;
    private final MutableState onSurface$delegate;
    private final MutableState primary$delegate;
    private final MutableState primaryVariant$delegate;
    private final MutableState secondary$delegate;
    private final MutableState secondaryVariant$delegate;
    private final MutableState surface$delegate;

    public /* synthetic */ Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z, AbstractC0419Di abstractC0419Di) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, z);
    }

    /* JADX INFO: renamed from: copy-pvPzIIM, reason: not valid java name */
    public final Colors m1043copypvPzIIM(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z) {
        return new Colors(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, z, null);
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m1044getBackground0d7_KjU() {
        return ((Color) this.background$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m1045getError0d7_KjU() {
        return ((Color) this.error$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m1046getOnBackground0d7_KjU() {
        return ((Color) this.onBackground$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m1047getOnError0d7_KjU() {
        return ((Color) this.onError$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m1048getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m1049getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m1050getOnSurface0d7_KjU() {
        return ((Color) this.onSurface$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m1051getPrimary0d7_KjU() {
        return ((Color) this.primary$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getPrimaryVariant-0d7_KjU, reason: not valid java name */
    public final long m1052getPrimaryVariant0d7_KjU() {
        return ((Color) this.primaryVariant$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m1053getSecondary0d7_KjU() {
        return ((Color) this.secondary$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getSecondaryVariant-0d7_KjU, reason: not valid java name */
    public final long m1054getSecondaryVariant0d7_KjU() {
        return ((Color) this.secondaryVariant$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m1055getSurface0d7_KjU() {
        return ((Color) this.surface$delegate.getValue()).m3042unboximpl();
    }

    public final boolean isLight() {
        return ((Boolean) this.isLight$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: setBackground-8_81llA$material_release, reason: not valid java name */
    public final void m1056setBackground8_81llA$material_release(long j) {
        this.background$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setError-8_81llA$material_release, reason: not valid java name */
    public final void m1057setError8_81llA$material_release(long j) {
        this.error$delegate.setValue(Color.m3022boximpl(j));
    }

    public final void setLight$material_release(boolean z) {
        this.isLight$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: setOnBackground-8_81llA$material_release, reason: not valid java name */
    public final void m1058setOnBackground8_81llA$material_release(long j) {
        this.onBackground$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOnError-8_81llA$material_release, reason: not valid java name */
    public final void m1059setOnError8_81llA$material_release(long j) {
        this.onError$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOnPrimary-8_81llA$material_release, reason: not valid java name */
    public final void m1060setOnPrimary8_81llA$material_release(long j) {
        this.onPrimary$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOnSecondary-8_81llA$material_release, reason: not valid java name */
    public final void m1061setOnSecondary8_81llA$material_release(long j) {
        this.onSecondary$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOnSurface-8_81llA$material_release, reason: not valid java name */
    public final void m1062setOnSurface8_81llA$material_release(long j) {
        this.onSurface$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setPrimary-8_81llA$material_release, reason: not valid java name */
    public final void m1063setPrimary8_81llA$material_release(long j) {
        this.primary$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setPrimaryVariant-8_81llA$material_release, reason: not valid java name */
    public final void m1064setPrimaryVariant8_81llA$material_release(long j) {
        this.primaryVariant$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setSecondary-8_81llA$material_release, reason: not valid java name */
    public final void m1065setSecondary8_81llA$material_release(long j) {
        this.secondary$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setSecondaryVariant-8_81llA$material_release, reason: not valid java name */
    public final void m1066setSecondaryVariant8_81llA$material_release(long j) {
        this.secondaryVariant$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setSurface-8_81llA$material_release, reason: not valid java name */
    public final void m1067setSurface8_81llA$material_release(long j) {
        this.surface$delegate.setValue(Color.m3022boximpl(j));
    }

    public String toString() {
        return "Colors(primary=" + ((Object) Color.m3040toStringimpl(m1051getPrimary0d7_KjU())) + ", primaryVariant=" + ((Object) Color.m3040toStringimpl(m1052getPrimaryVariant0d7_KjU())) + ", secondary=" + ((Object) Color.m3040toStringimpl(m1053getSecondary0d7_KjU())) + ", secondaryVariant=" + ((Object) Color.m3040toStringimpl(m1054getSecondaryVariant0d7_KjU())) + ", background=" + ((Object) Color.m3040toStringimpl(m1044getBackground0d7_KjU())) + ", surface=" + ((Object) Color.m3040toStringimpl(m1055getSurface0d7_KjU())) + ", error=" + ((Object) Color.m3040toStringimpl(m1045getError0d7_KjU())) + ", onPrimary=" + ((Object) Color.m3040toStringimpl(m1048getOnPrimary0d7_KjU())) + ", onSecondary=" + ((Object) Color.m3040toStringimpl(m1049getOnSecondary0d7_KjU())) + ", onBackground=" + ((Object) Color.m3040toStringimpl(m1046getOnBackground0d7_KjU())) + ", onSurface=" + ((Object) Color.m3040toStringimpl(m1050getOnSurface0d7_KjU())) + ", onError=" + ((Object) Color.m3040toStringimpl(m1047getOnError0d7_KjU())) + ", isLight=" + isLight() + ')';
    }

    private Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z) {
        this.primary$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j2), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j3), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j4), SnapshotStateKt.structuralEqualityPolicy());
        this.background$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j5), SnapshotStateKt.structuralEqualityPolicy());
        this.surface$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j6), SnapshotStateKt.structuralEqualityPolicy());
        this.error$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j7), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j8), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j9), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j10), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j11), SnapshotStateKt.structuralEqualityPolicy());
        this.onError$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j12), SnapshotStateKt.structuralEqualityPolicy());
        this.isLight$delegate = SnapshotStateKt.mutableStateOf(Boolean.valueOf(z), SnapshotStateKt.structuralEqualityPolicy());
    }
}
