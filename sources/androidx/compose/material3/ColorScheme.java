package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@Stable
public final class ColorScheme {
    public static final int $stable = 0;
    private final MutableState background$delegate;
    private final MutableState error$delegate;
    private final MutableState errorContainer$delegate;
    private final MutableState inverseOnSurface$delegate;
    private final MutableState inversePrimary$delegate;
    private final MutableState inverseSurface$delegate;
    private final MutableState onBackground$delegate;
    private final MutableState onError$delegate;
    private final MutableState onErrorContainer$delegate;
    private final MutableState onPrimary$delegate;
    private final MutableState onPrimaryContainer$delegate;
    private final MutableState onSecondary$delegate;
    private final MutableState onSecondaryContainer$delegate;
    private final MutableState onSurface$delegate;
    private final MutableState onSurfaceVariant$delegate;
    private final MutableState onTertiary$delegate;
    private final MutableState onTertiaryContainer$delegate;
    private final MutableState outline$delegate;
    private final MutableState outlineVariant$delegate;
    private final MutableState primary$delegate;
    private final MutableState primaryContainer$delegate;
    private final MutableState scrim$delegate;
    private final MutableState secondary$delegate;
    private final MutableState secondaryContainer$delegate;
    private final MutableState surface$delegate;
    private final MutableState surfaceTint$delegate;
    private final MutableState surfaceVariant$delegate;
    private final MutableState tertiary$delegate;
    private final MutableState tertiaryContainer$delegate;

    public /* synthetic */ ColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, AbstractC0419Di abstractC0419Di) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29);
    }

    /* JADX INFO: renamed from: copy-G1PFc-w, reason: not valid java name */
    public final ColorScheme m1388copyG1PFcw(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, null);
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m1389getBackground0d7_KjU() {
        return ((Color) this.background$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m1390getError0d7_KjU() {
        return ((Color) this.error$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getErrorContainer-0d7_KjU, reason: not valid java name */
    public final long m1391getErrorContainer0d7_KjU() {
        return ((Color) this.errorContainer$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getInverseOnSurface-0d7_KjU, reason: not valid java name */
    public final long m1392getInverseOnSurface0d7_KjU() {
        return ((Color) this.inverseOnSurface$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getInversePrimary-0d7_KjU, reason: not valid java name */
    public final long m1393getInversePrimary0d7_KjU() {
        return ((Color) this.inversePrimary$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getInverseSurface-0d7_KjU, reason: not valid java name */
    public final long m1394getInverseSurface0d7_KjU() {
        return ((Color) this.inverseSurface$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m1395getOnBackground0d7_KjU() {
        return ((Color) this.onBackground$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m1396getOnError0d7_KjU() {
        return ((Color) this.onError$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOnErrorContainer-0d7_KjU, reason: not valid java name */
    public final long m1397getOnErrorContainer0d7_KjU() {
        return ((Color) this.onErrorContainer$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m1398getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOnPrimaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1399getOnPrimaryContainer0d7_KjU() {
        return ((Color) this.onPrimaryContainer$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m1400getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOnSecondaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1401getOnSecondaryContainer0d7_KjU() {
        return ((Color) this.onSecondaryContainer$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m1402getOnSurface0d7_KjU() {
        return ((Color) this.onSurface$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOnSurfaceVariant-0d7_KjU, reason: not valid java name */
    public final long m1403getOnSurfaceVariant0d7_KjU() {
        return ((Color) this.onSurfaceVariant$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOnTertiary-0d7_KjU, reason: not valid java name */
    public final long m1404getOnTertiary0d7_KjU() {
        return ((Color) this.onTertiary$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOnTertiaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1405getOnTertiaryContainer0d7_KjU() {
        return ((Color) this.onTertiaryContainer$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOutline-0d7_KjU, reason: not valid java name */
    public final long m1406getOutline0d7_KjU() {
        return ((Color) this.outline$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getOutlineVariant-0d7_KjU, reason: not valid java name */
    public final long m1407getOutlineVariant0d7_KjU() {
        return ((Color) this.outlineVariant$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m1408getPrimary0d7_KjU() {
        return ((Color) this.primary$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getPrimaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1409getPrimaryContainer0d7_KjU() {
        return ((Color) this.primaryContainer$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getScrim-0d7_KjU, reason: not valid java name */
    public final long m1410getScrim0d7_KjU() {
        return ((Color) this.scrim$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m1411getSecondary0d7_KjU() {
        return ((Color) this.secondary$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getSecondaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1412getSecondaryContainer0d7_KjU() {
        return ((Color) this.secondaryContainer$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m1413getSurface0d7_KjU() {
        return ((Color) this.surface$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getSurfaceTint-0d7_KjU, reason: not valid java name */
    public final long m1414getSurfaceTint0d7_KjU() {
        return ((Color) this.surfaceTint$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getSurfaceVariant-0d7_KjU, reason: not valid java name */
    public final long m1415getSurfaceVariant0d7_KjU() {
        return ((Color) this.surfaceVariant$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getTertiary-0d7_KjU, reason: not valid java name */
    public final long m1416getTertiary0d7_KjU() {
        return ((Color) this.tertiary$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: getTertiaryContainer-0d7_KjU, reason: not valid java name */
    public final long m1417getTertiaryContainer0d7_KjU() {
        return ((Color) this.tertiaryContainer$delegate.getValue()).m3042unboximpl();
    }

    /* JADX INFO: renamed from: setBackground-8_81llA$material3_release, reason: not valid java name */
    public final void m1418setBackground8_81llA$material3_release(long j) {
        this.background$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setError-8_81llA$material3_release, reason: not valid java name */
    public final void m1419setError8_81llA$material3_release(long j) {
        this.error$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setErrorContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1420setErrorContainer8_81llA$material3_release(long j) {
        this.errorContainer$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setInverseOnSurface-8_81llA$material3_release, reason: not valid java name */
    public final void m1421setInverseOnSurface8_81llA$material3_release(long j) {
        this.inverseOnSurface$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setInversePrimary-8_81llA$material3_release, reason: not valid java name */
    public final void m1422setInversePrimary8_81llA$material3_release(long j) {
        this.inversePrimary$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setInverseSurface-8_81llA$material3_release, reason: not valid java name */
    public final void m1423setInverseSurface8_81llA$material3_release(long j) {
        this.inverseSurface$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOnBackground-8_81llA$material3_release, reason: not valid java name */
    public final void m1424setOnBackground8_81llA$material3_release(long j) {
        this.onBackground$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOnError-8_81llA$material3_release, reason: not valid java name */
    public final void m1425setOnError8_81llA$material3_release(long j) {
        this.onError$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOnErrorContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1426setOnErrorContainer8_81llA$material3_release(long j) {
        this.onErrorContainer$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOnPrimary-8_81llA$material3_release, reason: not valid java name */
    public final void m1427setOnPrimary8_81llA$material3_release(long j) {
        this.onPrimary$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOnPrimaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1428setOnPrimaryContainer8_81llA$material3_release(long j) {
        this.onPrimaryContainer$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOnSecondary-8_81llA$material3_release, reason: not valid java name */
    public final void m1429setOnSecondary8_81llA$material3_release(long j) {
        this.onSecondary$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOnSecondaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1430setOnSecondaryContainer8_81llA$material3_release(long j) {
        this.onSecondaryContainer$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOnSurface-8_81llA$material3_release, reason: not valid java name */
    public final void m1431setOnSurface8_81llA$material3_release(long j) {
        this.onSurface$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOnSurfaceVariant-8_81llA$material3_release, reason: not valid java name */
    public final void m1432setOnSurfaceVariant8_81llA$material3_release(long j) {
        this.onSurfaceVariant$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOnTertiary-8_81llA$material3_release, reason: not valid java name */
    public final void m1433setOnTertiary8_81llA$material3_release(long j) {
        this.onTertiary$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOnTertiaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1434setOnTertiaryContainer8_81llA$material3_release(long j) {
        this.onTertiaryContainer$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOutline-8_81llA$material3_release, reason: not valid java name */
    public final void m1435setOutline8_81llA$material3_release(long j) {
        this.outline$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setOutlineVariant-8_81llA$material3_release, reason: not valid java name */
    public final void m1436setOutlineVariant8_81llA$material3_release(long j) {
        this.outlineVariant$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setPrimary-8_81llA$material3_release, reason: not valid java name */
    public final void m1437setPrimary8_81llA$material3_release(long j) {
        this.primary$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setPrimaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1438setPrimaryContainer8_81llA$material3_release(long j) {
        this.primaryContainer$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setScrim-8_81llA$material3_release, reason: not valid java name */
    public final void m1439setScrim8_81llA$material3_release(long j) {
        this.scrim$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setSecondary-8_81llA$material3_release, reason: not valid java name */
    public final void m1440setSecondary8_81llA$material3_release(long j) {
        this.secondary$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setSecondaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1441setSecondaryContainer8_81llA$material3_release(long j) {
        this.secondaryContainer$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setSurface-8_81llA$material3_release, reason: not valid java name */
    public final void m1442setSurface8_81llA$material3_release(long j) {
        this.surface$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setSurfaceTint-8_81llA$material3_release, reason: not valid java name */
    public final void m1443setSurfaceTint8_81llA$material3_release(long j) {
        this.surfaceTint$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setSurfaceVariant-8_81llA$material3_release, reason: not valid java name */
    public final void m1444setSurfaceVariant8_81llA$material3_release(long j) {
        this.surfaceVariant$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setTertiary-8_81llA$material3_release, reason: not valid java name */
    public final void m1445setTertiary8_81llA$material3_release(long j) {
        this.tertiary$delegate.setValue(Color.m3022boximpl(j));
    }

    /* JADX INFO: renamed from: setTertiaryContainer-8_81llA$material3_release, reason: not valid java name */
    public final void m1446setTertiaryContainer8_81llA$material3_release(long j) {
        this.tertiaryContainer$delegate.setValue(Color.m3022boximpl(j));
    }

    public String toString() {
        return "ColorScheme(primary=" + ((Object) Color.m3040toStringimpl(m1408getPrimary0d7_KjU())) + "onPrimary=" + ((Object) Color.m3040toStringimpl(m1398getOnPrimary0d7_KjU())) + "primaryContainer=" + ((Object) Color.m3040toStringimpl(m1409getPrimaryContainer0d7_KjU())) + "onPrimaryContainer=" + ((Object) Color.m3040toStringimpl(m1399getOnPrimaryContainer0d7_KjU())) + "inversePrimary=" + ((Object) Color.m3040toStringimpl(m1393getInversePrimary0d7_KjU())) + "secondary=" + ((Object) Color.m3040toStringimpl(m1411getSecondary0d7_KjU())) + "onSecondary=" + ((Object) Color.m3040toStringimpl(m1400getOnSecondary0d7_KjU())) + "secondaryContainer=" + ((Object) Color.m3040toStringimpl(m1412getSecondaryContainer0d7_KjU())) + "onSecondaryContainer=" + ((Object) Color.m3040toStringimpl(m1401getOnSecondaryContainer0d7_KjU())) + "tertiary=" + ((Object) Color.m3040toStringimpl(m1416getTertiary0d7_KjU())) + "onTertiary=" + ((Object) Color.m3040toStringimpl(m1404getOnTertiary0d7_KjU())) + "tertiaryContainer=" + ((Object) Color.m3040toStringimpl(m1417getTertiaryContainer0d7_KjU())) + "onTertiaryContainer=" + ((Object) Color.m3040toStringimpl(m1405getOnTertiaryContainer0d7_KjU())) + "background=" + ((Object) Color.m3040toStringimpl(m1389getBackground0d7_KjU())) + "onBackground=" + ((Object) Color.m3040toStringimpl(m1395getOnBackground0d7_KjU())) + "surface=" + ((Object) Color.m3040toStringimpl(m1413getSurface0d7_KjU())) + "onSurface=" + ((Object) Color.m3040toStringimpl(m1402getOnSurface0d7_KjU())) + "surfaceVariant=" + ((Object) Color.m3040toStringimpl(m1415getSurfaceVariant0d7_KjU())) + "onSurfaceVariant=" + ((Object) Color.m3040toStringimpl(m1403getOnSurfaceVariant0d7_KjU())) + "surfaceTint=" + ((Object) Color.m3040toStringimpl(m1414getSurfaceTint0d7_KjU())) + "inverseSurface=" + ((Object) Color.m3040toStringimpl(m1394getInverseSurface0d7_KjU())) + "inverseOnSurface=" + ((Object) Color.m3040toStringimpl(m1392getInverseOnSurface0d7_KjU())) + "error=" + ((Object) Color.m3040toStringimpl(m1390getError0d7_KjU())) + "onError=" + ((Object) Color.m3040toStringimpl(m1396getOnError0d7_KjU())) + "errorContainer=" + ((Object) Color.m3040toStringimpl(m1391getErrorContainer0d7_KjU())) + "onErrorContainer=" + ((Object) Color.m3040toStringimpl(m1397getOnErrorContainer0d7_KjU())) + "outline=" + ((Object) Color.m3040toStringimpl(m1406getOutline0d7_KjU())) + "outlineVariant=" + ((Object) Color.m3040toStringimpl(m1407getOutlineVariant0d7_KjU())) + "scrim=" + ((Object) Color.m3040toStringimpl(m1410getScrim0d7_KjU())) + ')';
    }

    private ColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29) {
        this.primary$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j2), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j3), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j4), SnapshotStateKt.structuralEqualityPolicy());
        this.inversePrimary$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j5), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j6), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j7), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j8), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j9), SnapshotStateKt.structuralEqualityPolicy());
        this.tertiary$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j10), SnapshotStateKt.structuralEqualityPolicy());
        this.onTertiary$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j11), SnapshotStateKt.structuralEqualityPolicy());
        this.tertiaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j12), SnapshotStateKt.structuralEqualityPolicy());
        this.onTertiaryContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j13), SnapshotStateKt.structuralEqualityPolicy());
        this.background$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j14), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j15), SnapshotStateKt.structuralEqualityPolicy());
        this.surface$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j16), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j17), SnapshotStateKt.structuralEqualityPolicy());
        this.surfaceVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j18), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurfaceVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j19), SnapshotStateKt.structuralEqualityPolicy());
        this.surfaceTint$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j20), SnapshotStateKt.structuralEqualityPolicy());
        this.inverseSurface$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j21), SnapshotStateKt.structuralEqualityPolicy());
        this.inverseOnSurface$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j22), SnapshotStateKt.structuralEqualityPolicy());
        this.error$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j23), SnapshotStateKt.structuralEqualityPolicy());
        this.onError$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j24), SnapshotStateKt.structuralEqualityPolicy());
        this.errorContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j25), SnapshotStateKt.structuralEqualityPolicy());
        this.onErrorContainer$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j26), SnapshotStateKt.structuralEqualityPolicy());
        this.outline$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j27), SnapshotStateKt.structuralEqualityPolicy());
        this.outlineVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j28), SnapshotStateKt.structuralEqualityPolicy());
        this.scrim$delegate = SnapshotStateKt.mutableStateOf(Color.m3022boximpl(j29), SnapshotStateKt.structuralEqualityPolicy());
    }
}
