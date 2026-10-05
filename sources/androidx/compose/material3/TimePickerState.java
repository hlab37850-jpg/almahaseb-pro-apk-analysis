package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2233fv;
import defpackage.C2020dG;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
public final class TimePickerState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final MutableState center$delegate;
    private final Animatable<Float, AnimationVector1D> currentAngle;
    private final MutableState hourAngle$delegate;
    private final boolean is24hour;
    private final State isAfternoon$delegate;
    private final MutableState isAfternoonToggle$delegate;
    private final MutableState isInnerCircle$delegate;
    private final MutableState minuteAngle$delegate;
    private final MutatorMutex mutex;
    private final MutableState selection$delegate;
    private final State selectorPos$delegate;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Saver<TimePickerState, ?> Saver() {
            return SaverKt.Saver(TimePickerState$Companion$Saver$1.INSTANCE, TimePickerState$Companion$Saver$2.INSTANCE);
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerState$isAfternoon$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
        public AnonymousClass2() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final Boolean invoke() {
            return Boolean.valueOf((TimePickerState.this.is24hour() && TimePickerState.this.isInnerCircle$material3_release()) || TimePickerState.this.isAfternoonToggle$material3_release());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerState$settle$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material3.TimePickerState", f = "TimePicker.kt", l = {616, 617}, m = "settle")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TimePickerState.this.settle(this);
        }
    }

    public TimePickerState(int i, int i2, boolean z) {
        if (i < 0 || i >= 24) {
            throw new IllegalArgumentException("initialHour should in [0..23] range");
        }
        if (i < 0 || i >= 60) {
            throw new IllegalArgumentException("initialMinute should be in [0..59] range");
        }
        this.is24hour = z;
        this.selectorPos$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new TimePickerState$selectorPos$2(this, z));
        this.center$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m5269boximpl(IntOffset.Companion.m5288getZeronOccac()), null, 2, null);
        this.selection$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Selection.m1743boximpl(Selection.Companion.m1750getHourJiIwxys()), null, 2, null);
        this.isAfternoonToggle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i > 12 && !z), null, 2, null);
        this.isInnerCircle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i >= 12), null, 2, null);
        this.hourAngle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(((i * 0.5235988f) % 12) - 1.5707964f), null, 2, null);
        this.minuteAngle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf((i2 * 0.10471976f) - 1.5707964f), null, 2, null);
        this.mutex = new MutatorMutex();
        this.isAfternoon$delegate = SnapshotStateKt.derivedStateOf(new AnonymousClass2());
        this.currentAngle = AnimatableKt.Animatable$default(getHourAngle$material3_release(), 0.0f, 2, null);
    }

    private final int hourForDisplay(int i) {
        if (!this.is24hour || !isInnerCircle$material3_release() || i != 0) {
            if (this.is24hour) {
                return i % 24;
            }
            if (i % 12 != 0) {
                return isAfternoon() ? i - 12 : i;
            }
        }
        return 12;
    }

    private final boolean isAfternoon() {
        return ((Boolean) this.isAfternoon$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float offsetHour(float f) {
        float f2 = f + 1.5707964f;
        return f2 < 0.0f ? f2 + 6.2831855f : f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toHour(float f) {
        return ((int) ((((double) f) + (((double) 0.2617994f) + 1.5707963267948966d)) / ((double) 0.5235988f))) % 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toMinute(float f) {
        return ((int) ((((double) f) + (((double) 0.05235988f) + 1.5707963267948966d)) / ((double) 0.10471976f))) % 60;
    }

    public static /* synthetic */ Object update$material3_release$default(TimePickerState timePickerState, float f, boolean z, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return timePickerState.update$material3_release(f, z, interfaceC0793Of);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object animateToCurrent$material3_release(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        TimePickerState$animateToCurrent$1 timePickerState$animateToCurrent$1;
        TimePickerState timePickerState;
        float f;
        if (interfaceC0793Of instanceof TimePickerState$animateToCurrent$1) {
            timePickerState$animateToCurrent$1 = (TimePickerState$animateToCurrent$1) interfaceC0793Of;
            int i = timePickerState$animateToCurrent$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                timePickerState$animateToCurrent$1.label = i - Integer.MIN_VALUE;
            } else {
                timePickerState$animateToCurrent$1 = new TimePickerState$animateToCurrent$1(this, interfaceC0793Of);
            }
        } else {
            timePickerState$animateToCurrent$1 = new TimePickerState$animateToCurrent$1(this, interfaceC0793Of);
        }
        TimePickerState$animateToCurrent$1 timePickerState$animateToCurrent$2 = timePickerState$animateToCurrent$1;
        Object obj = timePickerState$animateToCurrent$2.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = timePickerState$animateToCurrent$2.label;
        if (i2 != 0) {
            if (i2 == 1) {
                f = timePickerState$animateToCurrent$2.F$0;
                timePickerState = (TimePickerState) timePickerState$animateToCurrent$2.L$0;
                LL.b(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
        LL.b(obj);
        C2020dG c2020dGValuesForAnimation = Selection.m1746equalsimpl0(m1974getSelectionJiIwxys$material3_release(), Selection.Companion.m1750getHourJiIwxys()) ? TimePickerKt.valuesForAnimation(getMinuteAngle$material3_release(), getHourAngle$material3_release()) : TimePickerKt.valuesForAnimation(getHourAngle$material3_release(), getMinuteAngle$material3_release());
        float fFloatValue = ((Number) c2020dGValuesForAnimation.a()).floatValue();
        float fFloatValue2 = ((Number) c2020dGValuesForAnimation.b()).floatValue();
        Animatable<Float, AnimationVector1D> animatable = this.currentAngle;
        Float fB = E8.b(fFloatValue);
        timePickerState$animateToCurrent$2.L$0 = this;
        timePickerState$animateToCurrent$2.F$0 = fFloatValue2;
        timePickerState$animateToCurrent$2.label = 1;
        if (animatable.snapTo(fB, timePickerState$animateToCurrent$2) == objD) {
            return objD;
        }
        timePickerState = this;
        f = fFloatValue2;
        Animatable<Float, AnimationVector1D> animatable2 = timePickerState.currentAngle;
        Float fB2 = E8.b(f);
        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(200, 0, null, 6, null);
        timePickerState$animateToCurrent$2.L$0 = null;
        timePickerState$animateToCurrent$2.label = 2;
        if (Animatable.animateTo$default(animatable2, fB2, tweenSpecTween$default, null, null, timePickerState$animateToCurrent$2, 12, null) == objD) {
            return objD;
        }
        return FW.a;
    }

    /* JADX INFO: renamed from: getCenter-nOcc-ac$material3_release, reason: not valid java name */
    public final long m1973getCenternOccac$material3_release() {
        return ((IntOffset) this.center$delegate.getValue()).m5287unboximpl();
    }

    public final Animatable<Float, AnimationVector1D> getCurrentAngle$material3_release() {
        return this.currentAngle;
    }

    public final int getHour() {
        return toHour(getHourAngle$material3_release()) + (isAfternoon() ? 12 : 0);
    }

    public final float getHourAngle$material3_release() {
        return ((Number) this.hourAngle$delegate.getValue()).floatValue();
    }

    public final int getHourForDisplay$material3_release() {
        return hourForDisplay(getHour());
    }

    public final int getMinute() {
        return toMinute(getMinuteAngle$material3_release());
    }

    public final float getMinuteAngle$material3_release() {
        return ((Number) this.minuteAngle$delegate.getValue()).floatValue();
    }

    /* JADX INFO: renamed from: getSelection-JiIwxys$material3_release, reason: not valid java name */
    public final int m1974getSelectionJiIwxys$material3_release() {
        return ((Selection) this.selection$delegate.getValue()).m1749unboximpl();
    }

    /* JADX INFO: renamed from: getSelectorPos-RKDOV3M$material3_release, reason: not valid java name */
    public final long m1975getSelectorPosRKDOV3M$material3_release() {
        return ((DpOffset) this.selectorPos$delegate.getValue()).m5229unboximpl();
    }

    public final List<Integer> getValues$material3_release() {
        return Selection.m1746equalsimpl0(m1974getSelectionJiIwxys$material3_release(), Selection.Companion.m1751getMinuteJiIwxys()) ? TimePickerKt.Minutes : TimePickerKt.Hours;
    }

    public final boolean is24hour() {
        return this.is24hour;
    }

    public final boolean isAfternoonToggle$material3_release() {
        return ((Boolean) this.isAfternoonToggle$delegate.getValue()).booleanValue();
    }

    public final boolean isInnerCircle$material3_release() {
        return ((Boolean) this.isInnerCircle$delegate.getValue()).booleanValue();
    }

    public final boolean isSelected$material3_release(int i) {
        if (!Selection.m1746equalsimpl0(m1974getSelectionJiIwxys$material3_release(), Selection.Companion.m1751getMinuteJiIwxys())) {
            if (getHour() == i + (isAfternoon() ? 12 : 0)) {
                return true;
            }
        } else if (i == getMinute()) {
            return true;
        }
        return false;
    }

    public final void moveSelector$material3_release(float f, float f2, float f3) {
        if (Selection.m1746equalsimpl0(m1974getSelectionJiIwxys$material3_release(), Selection.Companion.m1750getHourJiIwxys()) && this.is24hour) {
            setInnerCircle$material3_release(TimePickerKt.dist(f, f2, IntOffset.m5278getXimpl(m1973getCenternOccac$material3_release()), IntOffset.m5279getYimpl(m1973getCenternOccac$material3_release())) < f3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00fe A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object onTap$material3_release(float f, float f2, float f3, boolean z, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        TimePickerState$onTap$1 timePickerState$onTap$1;
        boolean z2;
        float f4;
        float f5;
        TimePickerState timePickerState;
        C2020dG c2020dGValuesForAnimation;
        Animatable<Float, AnimationVector1D> animatable;
        Object objE;
        TweenSpec tweenSpecTween$default;
        if (interfaceC0793Of instanceof TimePickerState$onTap$1) {
            timePickerState$onTap$1 = (TimePickerState$onTap$1) interfaceC0793Of;
            int i = timePickerState$onTap$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                timePickerState$onTap$1.label = i - Integer.MIN_VALUE;
            } else {
                timePickerState$onTap$1 = new TimePickerState$onTap$1(this, interfaceC0793Of);
            }
        } else {
            timePickerState$onTap$1 = new TimePickerState$onTap$1(this, interfaceC0793Of);
        }
        TimePickerState$onTap$1 timePickerState$onTap$2 = timePickerState$onTap$1;
        Object obj = timePickerState$onTap$2.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = timePickerState$onTap$2.label;
        if (i2 == 0) {
            LL.b(obj);
            float fAtan = TimePickerKt.atan(f2 - IntOffset.m5279getYimpl(m1973getCenternOccac$material3_release()), f - IntOffset.m5278getXimpl(m1973getCenternOccac$material3_release()));
            timePickerState$onTap$2.L$0 = this;
            timePickerState$onTap$2.F$0 = f;
            timePickerState$onTap$2.F$1 = f2;
            timePickerState$onTap$2.F$2 = f3;
            timePickerState$onTap$2.Z$0 = z;
            timePickerState$onTap$2.label = 1;
            if (update$material3_release(fAtan, true, timePickerState$onTap$2) == objD) {
                return objD;
            }
            z2 = z;
            f4 = f3;
            f5 = f2;
            timePickerState = this;
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    c2020dGValuesForAnimation = (C2020dG) timePickerState$onTap$2.L$1;
                    timePickerState = (TimePickerState) timePickerState$onTap$2.L$0;
                    LL.b(obj);
                    animatable = timePickerState.currentAngle;
                    objE = c2020dGValuesForAnimation.e();
                    tweenSpecTween$default = AnimationSpecKt.tween$default(200, 0, null, 6, null);
                    timePickerState$onTap$2.L$0 = null;
                    timePickerState$onTap$2.L$1 = null;
                    timePickerState$onTap$2.label = 3;
                    if (Animatable.animateTo$default(animatable, objE, tweenSpecTween$default, null, null, timePickerState$onTap$2, 12, null) == objD) {
                        return objD;
                    }
                } else {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj);
                        return FW.a;
                    }
                    LL.b(obj);
                }
                return FW.a;
            }
            boolean z3 = timePickerState$onTap$2.Z$0;
            float f6 = timePickerState$onTap$2.F$2;
            float f7 = timePickerState$onTap$2.F$1;
            f = timePickerState$onTap$2.F$0;
            TimePickerState timePickerState2 = (TimePickerState) timePickerState$onTap$2.L$0;
            LL.b(obj);
            z2 = z3;
            f4 = f6;
            f5 = f7;
            timePickerState = timePickerState2;
        }
        timePickerState.moveSelector$material3_release(f, f5, f4);
        int iM1974getSelectionJiIwxys$material3_release = timePickerState.m1974getSelectionJiIwxys$material3_release();
        Selection.Companion companion = Selection.Companion;
        if (!Selection.m1746equalsimpl0(iM1974getSelectionJiIwxys$material3_release, companion.m1750getHourJiIwxys())) {
            timePickerState$onTap$2.L$0 = null;
            timePickerState$onTap$2.label = 4;
            if (timePickerState.settle(timePickerState$onTap$2) == objD) {
                return objD;
            }
            return FW.a;
        }
        if (z2) {
            timePickerState.m1977setSelectioniHAOin8$material3_release(companion.m1751getMinuteJiIwxys());
            return FW.a;
        }
        c2020dGValuesForAnimation = TimePickerKt.valuesForAnimation(timePickerState.currentAngle.getValue().floatValue(), timePickerState.getHourAngle$material3_release());
        Animatable<Float, AnimationVector1D> animatable2 = timePickerState.currentAngle;
        Object objC = c2020dGValuesForAnimation.c();
        timePickerState$onTap$2.L$0 = timePickerState;
        timePickerState$onTap$2.L$1 = c2020dGValuesForAnimation;
        timePickerState$onTap$2.label = 2;
        if (animatable2.snapTo((Float) objC, timePickerState$onTap$2) == objD) {
            return objD;
        }
        animatable = timePickerState.currentAngle;
        objE = c2020dGValuesForAnimation.e();
        tweenSpecTween$default = AnimationSpecKt.tween$default(200, 0, null, 6, null);
        timePickerState$onTap$2.L$0 = null;
        timePickerState$onTap$2.L$1 = null;
        timePickerState$onTap$2.label = 3;
        if (Animatable.animateTo$default(animatable, objE, tweenSpecTween$default, null, null, timePickerState$onTap$2, 12, null) == objD) {
            return objD;
        }
        return FW.a;
    }

    public final void setAfternoonToggle$material3_release(boolean z) {
        this.isAfternoonToggle$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: setCenter--gyyYBs$material3_release, reason: not valid java name */
    public final void m1976setCentergyyYBs$material3_release(long j) {
        this.center$delegate.setValue(IntOffset.m5269boximpl(j));
    }

    public final void setHour$material3_release(int i) {
        setInnerCircle$material3_release(i > 12 || i == 0);
        setHourAngle$material3_release(((i * 0.5235988f) % 12) - 1.5707964f);
    }

    public final void setHourAngle$material3_release(float f) {
        this.hourAngle$delegate.setValue(Float.valueOf(f));
    }

    public final void setInnerCircle$material3_release(boolean z) {
        this.isInnerCircle$delegate.setValue(Boolean.valueOf(z));
    }

    public final void setMinute$material3_release(int i) {
        setMinuteAngle$material3_release((i * 0.10471976f) - 1.5707964f);
    }

    public final void setMinuteAngle$material3_release(float f) {
        this.minuteAngle$delegate.setValue(Float.valueOf(f));
    }

    /* JADX INFO: renamed from: setSelection-iHAOin8$material3_release, reason: not valid java name */
    public final void m1977setSelectioniHAOin8$material3_release(int i) {
        this.selection$delegate.setValue(Selection.m1743boximpl(i));
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object settle(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AnonymousClass1 anonymousClass1;
        C2020dG c2020dGValuesForAnimation;
        TimePickerState timePickerState;
        if (interfaceC0793Of instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass2.label;
        if (i2 != 0) {
            if (i2 == 1) {
                c2020dGValuesForAnimation = (C2020dG) anonymousClass2.L$1;
                timePickerState = (TimePickerState) anonymousClass2.L$0;
                LL.b(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
        LL.b(obj);
        c2020dGValuesForAnimation = TimePickerKt.valuesForAnimation(this.currentAngle.getValue().floatValue(), getMinuteAngle$material3_release());
        Animatable<Float, AnimationVector1D> animatable = this.currentAngle;
        Object objC = c2020dGValuesForAnimation.c();
        anonymousClass2.L$0 = this;
        anonymousClass2.L$1 = c2020dGValuesForAnimation;
        anonymousClass2.label = 1;
        if (animatable.snapTo((Float) objC, anonymousClass2) == objD) {
            return objD;
        }
        timePickerState = this;
        Animatable<Float, AnimationVector1D> animatable2 = timePickerState.currentAngle;
        Object objE = c2020dGValuesForAnimation.e();
        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(200, 0, null, 6, null);
        anonymousClass2.L$0 = null;
        anonymousClass2.L$1 = null;
        anonymousClass2.label = 2;
        if (Animatable.animateTo$default(animatable2, objE, tweenSpecTween$default, null, null, anonymousClass2, 12, null) == objD) {
            return objD;
        }
        return FW.a;
    }

    public final Object update$material3_release(float f, boolean z, InterfaceC0793Of interfaceC0793Of) {
        Object objMutate = this.mutex.mutate(MutatePriority.UserInput, new TimePickerState$update$2(this, f, z, null), interfaceC0793Of);
        return objMutate == AbstractC0378Bt.d() ? objMutate : FW.a;
    }
}
