package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3790rJ;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0789Ob;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@Stable
public final class SliderPositions {
    public static final int $stable = 0;
    private final MutableState activeRange$delegate;
    private final MutableState tickFractions$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public SliderPositions() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SliderPositions)) {
            return false;
        }
        SliderPositions sliderPositions = (SliderPositions) obj;
        return AbstractC4492zt.d(getActiveRange(), sliderPositions.getActiveRange()) && Arrays.equals(getTickFractions(), sliderPositions.getTickFractions());
    }

    public final InterfaceC0789Ob getActiveRange() {
        return (InterfaceC0789Ob) this.activeRange$delegate.getValue();
    }

    public final float[] getTickFractions() {
        return (float[]) this.tickFractions$delegate.getValue();
    }

    public int hashCode() {
        return (getActiveRange().hashCode() * 31) + Arrays.hashCode(getTickFractions());
    }

    public final void setActiveRange$material3_release(InterfaceC0789Ob interfaceC0789Ob) {
        AbstractC4492zt.h(interfaceC0789Ob, "<set-?>");
        this.activeRange$delegate.setValue(interfaceC0789Ob);
    }

    public final void setTickFractions$material3_release(float[] fArr) {
        AbstractC4492zt.h(fArr, "<set-?>");
        this.tickFractions$delegate.setValue(fArr);
    }

    public SliderPositions(InterfaceC0789Ob interfaceC0789Ob, float[] fArr) {
        AbstractC4492zt.h(interfaceC0789Ob, "initialActiveRange");
        AbstractC4492zt.h(fArr, "initialTickFractions");
        this.activeRange$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(interfaceC0789Ob, null, 2, null);
        this.tickFractions$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fArr, null, 2, null);
    }

    public /* synthetic */ SliderPositions(InterfaceC0789Ob interfaceC0789Ob, float[] fArr, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? AbstractC3790rJ.b(0.0f, 1.0f) : interfaceC0789Ob, (i & 2) != 0 ? new float[0] : fArr);
    }
}
