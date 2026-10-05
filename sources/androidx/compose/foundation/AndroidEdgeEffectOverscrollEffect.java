package androidx.compose.foundation;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    private final List<EdgeEffect> allEffects;
    private final EdgeEffect bottomEffect;
    private final EdgeEffect bottomEffectNegation;
    private long containerSize;
    private final Modifier effectModifier;
    private boolean invalidationEnabled;
    private final EdgeEffect leftEffect;
    private final EdgeEffect leftEffectNegation;
    private final InterfaceC3750qp onNewSize;
    private final OverscrollConfiguration overscrollConfig;
    private PointerId pointerId;
    private Offset pointerPosition;
    private final MutableState<FW> redrawSignal;
    private final EdgeEffect rightEffect;
    private final EdgeEffect rightEffectNegation;
    private boolean scrollCycleInProgress;
    private final EdgeEffect topEffect;
    private final EdgeEffect topEffectNegation;

    public AndroidEdgeEffectOverscrollEffect(Context context, OverscrollConfiguration overscrollConfiguration) {
        AbstractC4492zt.h(context, "context");
        AbstractC4492zt.h(overscrollConfiguration, "overscrollConfig");
        this.overscrollConfig = overscrollConfiguration;
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        EdgeEffect edgeEffectCreate = edgeEffectCompat.create(context, null);
        this.topEffect = edgeEffectCreate;
        EdgeEffect edgeEffectCreate2 = edgeEffectCompat.create(context, null);
        this.bottomEffect = edgeEffectCreate2;
        EdgeEffect edgeEffectCreate3 = edgeEffectCompat.create(context, null);
        this.leftEffect = edgeEffectCreate3;
        EdgeEffect edgeEffectCreate4 = edgeEffectCompat.create(context, null);
        this.rightEffect = edgeEffectCreate4;
        List<EdgeEffect> listP = AbstractC1886cc.p(edgeEffectCreate3, edgeEffectCreate, edgeEffectCreate4, edgeEffectCreate2);
        this.allEffects = listP;
        this.topEffectNegation = edgeEffectCompat.create(context, null);
        this.bottomEffectNegation = edgeEffectCompat.create(context, null);
        this.leftEffectNegation = edgeEffectCompat.create(context, null);
        this.rightEffectNegation = edgeEffectCompat.create(context, null);
        int size = listP.size();
        for (int i = 0; i < size; i++) {
            listP.get(i).setColor(ColorKt.m3086toArgb8_81llA(this.overscrollConfig.m251getGlowColor0d7_KjU()));
        }
        FW fw = FW.a;
        this.redrawSignal = SnapshotStateKt.mutableStateOf(fw, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.Companion.m2876getZeroNHjbRc();
        AndroidEdgeEffectOverscrollEffect$onNewSize$1 androidEdgeEffectOverscrollEffect$onNewSize$1 = new AndroidEdgeEffectOverscrollEffect$onNewSize$1(this);
        this.onNewSize = androidEdgeEffectOverscrollEffect$onNewSize$1;
        this.effectModifier = OnRemeasuredModifierKt.onSizeChanged(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion.then(AndroidOverscrollKt.StretchOverscrollNonClippingLayer), fw, new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, null)), androidEdgeEffectOverscrollEffect$onNewSize$1).then(new DrawOverscrollModifier(this, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1(this) : InspectableValueKt.getNoInspectorInfo()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateToRelease() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            EdgeEffect edgeEffect = list.get(i);
            edgeEffect.onRelease();
            z = edgeEffect.isFinished() || z;
        }
        if (z) {
            invalidateOverscroll();
        }
    }

    private final boolean drawBottom(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(180.0f);
        canvas.translate(-Size.m2867getWidthimpl(this.containerSize), (-Size.m2864getHeightimpl(this.containerSize)) + drawScope.mo333toPx0680j_4(this.overscrollConfig.getDrawPadding().mo435calculateBottomPaddingD9Ej5fM()));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    private final boolean drawLeft(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(270.0f);
        canvas.translate(-Size.m2864getHeightimpl(this.containerSize), drawScope.mo333toPx0680j_4(this.overscrollConfig.getDrawPadding().mo436calculateLeftPaddingu2uoSUM(drawScope.getLayoutDirection())));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    private final boolean drawRight(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        int iC = AbstractC1210aB.c(Size.m2867getWidthimpl(this.containerSize));
        float fMo437calculateRightPaddingu2uoSUM = this.overscrollConfig.getDrawPadding().mo437calculateRightPaddingu2uoSUM(drawScope.getLayoutDirection());
        canvas.rotate(90.0f);
        canvas.translate(0.0f, (-iC) + drawScope.mo333toPx0680j_4(fMo437calculateRightPaddingu2uoSUM));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    private final boolean drawTop(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.translate(0.0f, drawScope.mo333toPx0680j_4(this.overscrollConfig.getDrawPadding().mo438calculateTopPaddingD9Ej5fM()));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    @VisibleForTesting
    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOverscroll() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(FW.a);
        }
    }

    /* JADX INFO: renamed from: pullBottom-0a9Yr6o, reason: not valid java name */
    private final float m156pullBottom0a9Yr6o(long j, long j2) {
        float fM2798getXimpl = Offset.m2798getXimpl(j2) / Size.m2867getWidthimpl(this.containerSize);
        float fM2799getYimpl = Offset.m2799getYimpl(j) / Size.m2864getHeightimpl(this.containerSize);
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(this.bottomEffect) == 0.0f ? (-edgeEffectCompat.onPullDistanceCompat(this.bottomEffect, -fM2799getYimpl, 1 - fM2798getXimpl)) * Size.m2864getHeightimpl(this.containerSize) : Offset.m2799getYimpl(j);
    }

    /* JADX INFO: renamed from: pullLeft-0a9Yr6o, reason: not valid java name */
    private final float m157pullLeft0a9Yr6o(long j, long j2) {
        float fM2799getYimpl = Offset.m2799getYimpl(j2) / Size.m2864getHeightimpl(this.containerSize);
        float fM2798getXimpl = Offset.m2798getXimpl(j) / Size.m2867getWidthimpl(this.containerSize);
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(this.leftEffect) == 0.0f ? edgeEffectCompat.onPullDistanceCompat(this.leftEffect, fM2798getXimpl, 1 - fM2799getYimpl) * Size.m2867getWidthimpl(this.containerSize) : Offset.m2798getXimpl(j);
    }

    /* JADX INFO: renamed from: pullRight-0a9Yr6o, reason: not valid java name */
    private final float m158pullRight0a9Yr6o(long j, long j2) {
        float fM2799getYimpl = Offset.m2799getYimpl(j2) / Size.m2864getHeightimpl(this.containerSize);
        float fM2798getXimpl = Offset.m2798getXimpl(j) / Size.m2867getWidthimpl(this.containerSize);
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(this.rightEffect) == 0.0f ? (-edgeEffectCompat.onPullDistanceCompat(this.rightEffect, -fM2798getXimpl, fM2799getYimpl)) * Size.m2867getWidthimpl(this.containerSize) : Offset.m2798getXimpl(j);
    }

    /* JADX INFO: renamed from: pullTop-0a9Yr6o, reason: not valid java name */
    private final float m159pullTop0a9Yr6o(long j, long j2) {
        float fM2798getXimpl = Offset.m2798getXimpl(j2) / Size.m2867getWidthimpl(this.containerSize);
        float fM2799getYimpl = Offset.m2799getYimpl(j) / Size.m2864getHeightimpl(this.containerSize);
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        return edgeEffectCompat.getDistanceCompat(this.topEffect) == 0.0f ? edgeEffectCompat.onPullDistanceCompat(this.topEffect, fM2799getYimpl, fM2798getXimpl) * Size.m2864getHeightimpl(this.containerSize) : Offset.m2799getYimpl(j);
    }

    /* JADX INFO: renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    private final boolean m160releaseOppositeOverscrollk4lQ0M(long j) {
        boolean zIsFinished;
        if (this.leftEffect.isFinished() || Offset.m2798getXimpl(j) >= 0.0f) {
            zIsFinished = false;
        } else {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.leftEffect, Offset.m2798getXimpl(j));
            zIsFinished = this.leftEffect.isFinished();
        }
        if (!this.rightEffect.isFinished() && Offset.m2798getXimpl(j) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.rightEffect, Offset.m2798getXimpl(j));
            zIsFinished = zIsFinished || this.rightEffect.isFinished();
        }
        if (!this.topEffect.isFinished() && Offset.m2799getYimpl(j) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.topEffect, Offset.m2799getYimpl(j));
            zIsFinished = zIsFinished || this.topEffect.isFinished();
        }
        if (this.bottomEffect.isFinished() || Offset.m2799getYimpl(j) <= 0.0f) {
            return zIsFinished;
        }
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.bottomEffect, Offset.m2799getYimpl(j));
        return zIsFinished || this.bottomEffect.isFinished();
    }

    private final boolean stopOverscrollAnimation() {
        boolean z;
        long jM2877getCenteruvyYCjk = SizeKt.m2877getCenteruvyYCjk(this.containerSize);
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        if (edgeEffectCompat.getDistanceCompat(this.leftEffect) == 0.0f) {
            z = false;
        } else {
            m157pullLeft0a9Yr6o(Offset.Companion.m2814getZeroF1C5BW0(), jM2877getCenteruvyYCjk);
            z = true;
        }
        if (edgeEffectCompat.getDistanceCompat(this.rightEffect) != 0.0f) {
            m158pullRight0a9Yr6o(Offset.Companion.m2814getZeroF1C5BW0(), jM2877getCenteruvyYCjk);
            z = true;
        }
        if (edgeEffectCompat.getDistanceCompat(this.topEffect) != 0.0f) {
            m159pullTop0a9Yr6o(Offset.Companion.m2814getZeroF1C5BW0(), jM2877getCenteruvyYCjk);
            z = true;
        }
        if (edgeEffectCompat.getDistanceCompat(this.bottomEffect) == 0.0f) {
            return z;
        }
        m156pullBottom0a9Yr6o(Offset.Companion.m2814getZeroF1C5BW0(), jM2877getCenteruvyYCjk);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0082  */
    /* JADX WARN: Code duplicated, block: B:31:0x008a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0097  */
    /* JADX WARN: Code duplicated, block: B:35:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00da  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:58:0x0139  */
    /* JADX WARN: Code duplicated, block: B:59:0x0149  */
    /* JADX WARN: Code duplicated, block: B:61:0x0151  */
    /* JADX WARN: Code duplicated, block: B:64:0x0169  */
    /* JADX WARN: Code duplicated, block: B:65:0x0179  */
    /* JADX WARN: Code duplicated, block: B:67:0x0181  */
    /* JADX WARN: Code duplicated, block: B:70:0x019d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    public Object mo161applyToFlingBMRW4eQ(long j, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        AndroidEdgeEffectOverscrollEffect$applyToFling$1 androidEdgeEffectOverscrollEffect$applyToFling$1;
        float fM5385getXimpl;
        EdgeEffectCompat edgeEffectCompat;
        float fM5386getYimpl;
        EdgeEffectCompat edgeEffectCompat2;
        long jM5388minusAH228Gc;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect;
        long jM5388minusAH228Gc2;
        if (interfaceC0793Of instanceof AndroidEdgeEffectOverscrollEffect$applyToFling$1) {
            androidEdgeEffectOverscrollEffect$applyToFling$1 = (AndroidEdgeEffectOverscrollEffect$applyToFling$1) interfaceC0793Of;
            int i = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                androidEdgeEffectOverscrollEffect$applyToFling$1.label = i - Integer.MIN_VALUE;
            } else {
                androidEdgeEffectOverscrollEffect$applyToFling$1 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, interfaceC0793Of);
            }
        } else {
            androidEdgeEffectOverscrollEffect$applyToFling$1 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, interfaceC0793Of);
        }
        Object objMo13invoke = androidEdgeEffectOverscrollEffect$applyToFling$1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                LL.b(objMo13invoke);
                return FW.a;
            }
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jM5388minusAH228Gc = androidEdgeEffectOverscrollEffect$applyToFling$1.J$0;
            androidEdgeEffectOverscrollEffect = (AndroidEdgeEffectOverscrollEffect) androidEdgeEffectOverscrollEffect$applyToFling$1.L$0;
            LL.b(objMo13invoke);
            jM5388minusAH228Gc2 = Velocity.m5388minusAH228Gc(jM5388minusAH228Gc, ((Velocity) objMo13invoke).m5394unboximpl());
            androidEdgeEffectOverscrollEffect.scrollCycleInProgress = false;
            if (Velocity.m5385getXimpl(jM5388minusAH228Gc2) > 0.0f) {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.leftEffect, AbstractC1210aB.c(Velocity.m5385getXimpl(jM5388minusAH228Gc2)));
            } else if (Velocity.m5385getXimpl(jM5388minusAH228Gc2) < 0.0f) {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.rightEffect, -AbstractC1210aB.c(Velocity.m5385getXimpl(jM5388minusAH228Gc2)));
            }
            if (Velocity.m5386getYimpl(jM5388minusAH228Gc2) > 0.0f) {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.topEffect, AbstractC1210aB.c(Velocity.m5386getYimpl(jM5388minusAH228Gc2)));
            } else if (Velocity.m5386getYimpl(jM5388minusAH228Gc2) < 0.0f) {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.bottomEffect, -AbstractC1210aB.c(Velocity.m5386getYimpl(jM5388minusAH228Gc2)));
            }
            if (!Velocity.m5384equalsimpl0(jM5388minusAH228Gc2, Velocity.Companion.m5396getZero9UxMQ8M())) {
                androidEdgeEffectOverscrollEffect.invalidateOverscroll();
            }
            androidEdgeEffectOverscrollEffect.animateToRelease();
            return FW.a;
        }
        LL.b(objMo13invoke);
        if (Size.m2869isEmptyimpl(this.containerSize)) {
            Object objM5376boximpl = Velocity.m5376boximpl(j);
            androidEdgeEffectOverscrollEffect$applyToFling$1.label = 1;
            if (interfaceC0526Fp.mo13invoke(objM5376boximpl, androidEdgeEffectOverscrollEffect$applyToFling$1) == objD) {
                return objD;
            }
            return FW.a;
        }
        if (Velocity.m5385getXimpl(j) > 0.0f) {
            EdgeEffectCompat edgeEffectCompat3 = EdgeEffectCompat.INSTANCE;
            if (edgeEffectCompat3.getDistanceCompat(this.leftEffect) != 0.0f) {
                edgeEffectCompat3.onAbsorbCompat(this.leftEffect, AbstractC1210aB.c(Velocity.m5385getXimpl(j)));
                fM5385getXimpl = Velocity.m5385getXimpl(j);
            } else if (Velocity.m5385getXimpl(j) < 0.0f) {
                edgeEffectCompat = EdgeEffectCompat.INSTANCE;
                if (edgeEffectCompat.getDistanceCompat(this.rightEffect) == 0.0f) {
                    fM5385getXimpl = 0.0f;
                } else {
                    edgeEffectCompat.onAbsorbCompat(this.rightEffect, -AbstractC1210aB.c(Velocity.m5385getXimpl(j)));
                    fM5385getXimpl = Velocity.m5385getXimpl(j);
                }
            } else {
                fM5385getXimpl = 0.0f;
            }
        } else if (Velocity.m5385getXimpl(j) < 0.0f) {
            edgeEffectCompat = EdgeEffectCompat.INSTANCE;
            if (edgeEffectCompat.getDistanceCompat(this.rightEffect) == 0.0f) {
                fM5385getXimpl = 0.0f;
            } else {
                edgeEffectCompat.onAbsorbCompat(this.rightEffect, -AbstractC1210aB.c(Velocity.m5385getXimpl(j)));
                fM5385getXimpl = Velocity.m5385getXimpl(j);
            }
        } else {
            fM5385getXimpl = 0.0f;
        }
        if (Velocity.m5386getYimpl(j) > 0.0f) {
            EdgeEffectCompat edgeEffectCompat4 = EdgeEffectCompat.INSTANCE;
            if (edgeEffectCompat4.getDistanceCompat(this.topEffect) != 0.0f) {
                edgeEffectCompat4.onAbsorbCompat(this.topEffect, AbstractC1210aB.c(Velocity.m5386getYimpl(j)));
                fM5386getYimpl = Velocity.m5386getYimpl(j);
            } else if (Velocity.m5386getYimpl(j) < 0.0f) {
                edgeEffectCompat2 = EdgeEffectCompat.INSTANCE;
                if (edgeEffectCompat2.getDistanceCompat(this.bottomEffect) == 0.0f) {
                    fM5386getYimpl = 0.0f;
                } else {
                    edgeEffectCompat2.onAbsorbCompat(this.bottomEffect, -AbstractC1210aB.c(Velocity.m5386getYimpl(j)));
                    fM5386getYimpl = Velocity.m5386getYimpl(j);
                }
            } else {
                fM5386getYimpl = 0.0f;
            }
        } else if (Velocity.m5386getYimpl(j) < 0.0f) {
            edgeEffectCompat2 = EdgeEffectCompat.INSTANCE;
            if (edgeEffectCompat2.getDistanceCompat(this.bottomEffect) == 0.0f) {
                fM5386getYimpl = 0.0f;
            } else {
                edgeEffectCompat2.onAbsorbCompat(this.bottomEffect, -AbstractC1210aB.c(Velocity.m5386getYimpl(j)));
                fM5386getYimpl = Velocity.m5386getYimpl(j);
            }
        } else {
            fM5386getYimpl = 0.0f;
        }
        long jVelocity = VelocityKt.Velocity(fM5385getXimpl, fM5386getYimpl);
        if (!Velocity.m5384equalsimpl0(jVelocity, Velocity.Companion.m5396getZero9UxMQ8M())) {
            invalidateOverscroll();
        }
        jM5388minusAH228Gc = Velocity.m5388minusAH228Gc(j, jVelocity);
        Object objM5376boximpl2 = Velocity.m5376boximpl(jM5388minusAH228Gc);
        androidEdgeEffectOverscrollEffect$applyToFling$1.L$0 = this;
        androidEdgeEffectOverscrollEffect$applyToFling$1.J$0 = jM5388minusAH228Gc;
        androidEdgeEffectOverscrollEffect$applyToFling$1.label = 2;
        objMo13invoke = interfaceC0526Fp.mo13invoke(objM5376boximpl2, androidEdgeEffectOverscrollEffect$applyToFling$1);
        if (objMo13invoke == objD) {
            return objD;
        }
        androidEdgeEffectOverscrollEffect = this;
        jM5388minusAH228Gc2 = Velocity.m5388minusAH228Gc(jM5388minusAH228Gc, ((Velocity) objMo13invoke).m5394unboximpl());
        androidEdgeEffectOverscrollEffect.scrollCycleInProgress = false;
        if (Velocity.m5385getXimpl(jM5388minusAH228Gc2) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.leftEffect, AbstractC1210aB.c(Velocity.m5385getXimpl(jM5388minusAH228Gc2)));
        } else if (Velocity.m5385getXimpl(jM5388minusAH228Gc2) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.rightEffect, -AbstractC1210aB.c(Velocity.m5385getXimpl(jM5388minusAH228Gc2)));
        }
        if (Velocity.m5386getYimpl(jM5388minusAH228Gc2) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.topEffect, AbstractC1210aB.c(Velocity.m5386getYimpl(jM5388minusAH228Gc2)));
        } else if (Velocity.m5386getYimpl(jM5388minusAH228Gc2) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.bottomEffect, -AbstractC1210aB.c(Velocity.m5386getYimpl(jM5388minusAH228Gc2)));
        }
        if (!Velocity.m5384equalsimpl0(jM5388minusAH228Gc2, Velocity.Companion.m5396getZero9UxMQ8M())) {
            androidEdgeEffectOverscrollEffect.invalidateOverscroll();
        }
        androidEdgeEffectOverscrollEffect.animateToRelease();
        return FW.a;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0044  */
    /* JADX WARN: Code duplicated, block: B:57:0x012b  */
    /* JADX WARN: Code duplicated, block: B:59:0x0130  */
    /* JADX WARN: Code duplicated, block: B:61:0x0138  */
    /* JADX WARN: Code duplicated, block: B:62:0x013c  */
    /* JADX WARN: Code duplicated, block: B:64:0x013f A[ADDED_TO_REGION] */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: applyToScroll-Rhakbz0, reason: not valid java name */
    public long mo162applyToScrollRhakbz0(long j, int i, InterfaceC3750qp interfaceC3750qp) {
        float fM159pullTop0a9Yr6o;
        boolean z;
        boolean z2;
        float fM157pullLeft0a9Yr6o;
        AbstractC4492zt.h(interfaceC3750qp, "performScroll");
        if (Size.m2869isEmptyimpl(this.containerSize)) {
            return ((Offset) interfaceC3750qp.invoke(Offset.m2787boximpl(j))).m2808unboximpl();
        }
        boolean z3 = true;
        if (!this.scrollCycleInProgress) {
            stopOverscrollAnimation();
            this.scrollCycleInProgress = true;
        }
        Offset offset = this.pointerPosition;
        long jM2808unboximpl = offset != null ? offset.m2808unboximpl() : SizeKt.m2877getCenteruvyYCjk(this.containerSize);
        float f = 0.0f;
        if (Offset.m2799getYimpl(j) == 0.0f) {
            fM159pullTop0a9Yr6o = 0.0f;
        } else {
            EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
            if (edgeEffectCompat.getDistanceCompat(this.topEffect) != 0.0f) {
                fM159pullTop0a9Yr6o = m159pullTop0a9Yr6o(j, jM2808unboximpl);
                if (edgeEffectCompat.getDistanceCompat(this.topEffect) == 0.0f) {
                    this.topEffect.onRelease();
                }
            } else if (edgeEffectCompat.getDistanceCompat(this.bottomEffect) == 0.0f) {
                fM159pullTop0a9Yr6o = 0.0f;
            } else {
                fM159pullTop0a9Yr6o = m156pullBottom0a9Yr6o(j, jM2808unboximpl);
                if (edgeEffectCompat.getDistanceCompat(this.bottomEffect) == 0.0f) {
                    this.bottomEffect.onRelease();
                }
            }
        }
        if (Offset.m2798getXimpl(j) != 0.0f) {
            EdgeEffectCompat edgeEffectCompat2 = EdgeEffectCompat.INSTANCE;
            if (edgeEffectCompat2.getDistanceCompat(this.leftEffect) != 0.0f) {
                fM157pullLeft0a9Yr6o = m157pullLeft0a9Yr6o(j, jM2808unboximpl);
                if (edgeEffectCompat2.getDistanceCompat(this.leftEffect) == 0.0f) {
                    this.leftEffect.onRelease();
                }
            } else if (edgeEffectCompat2.getDistanceCompat(this.rightEffect) != 0.0f) {
                fM157pullLeft0a9Yr6o = m158pullRight0a9Yr6o(j, jM2808unboximpl);
                if (edgeEffectCompat2.getDistanceCompat(this.rightEffect) == 0.0f) {
                    this.rightEffect.onRelease();
                }
            }
            f = fM157pullLeft0a9Yr6o;
        }
        long jOffset = OffsetKt.Offset(f, fM159pullTop0a9Yr6o);
        if (!Offset.m2795equalsimpl0(jOffset, Offset.Companion.m2814getZeroF1C5BW0())) {
            invalidateOverscroll();
        }
        long jM2802minusMKHz9U = Offset.m2802minusMKHz9U(j, jOffset);
        long jM2808unboximpl2 = ((Offset) interfaceC3750qp.invoke(Offset.m2787boximpl(jM2802minusMKHz9U))).m2808unboximpl();
        long jM2802minusMKHz9U2 = Offset.m2802minusMKHz9U(jM2802minusMKHz9U, jM2808unboximpl2);
        boolean z4 = false;
        if (NestedScrollSource.m3958equalsimpl0(i, NestedScrollSource.Companion.m3963getDragWNlRxjI())) {
            if (Offset.m2798getXimpl(jM2802minusMKHz9U2) > 0.5f) {
                m157pullLeft0a9Yr6o(jM2802minusMKHz9U2, jM2808unboximpl);
            } else {
                if (Offset.m2798getXimpl(jM2802minusMKHz9U2) < -0.5f) {
                    m158pullRight0a9Yr6o(jM2802minusMKHz9U2, jM2808unboximpl);
                } else {
                    z = false;
                }
                if (Offset.m2799getYimpl(jM2802minusMKHz9U2) > 0.5f) {
                    m159pullTop0a9Yr6o(jM2802minusMKHz9U2, jM2808unboximpl);
                } else {
                    if (Offset.m2799getYimpl(jM2802minusMKHz9U2) < -0.5f) {
                        m156pullBottom0a9Yr6o(jM2802minusMKHz9U2, jM2808unboximpl);
                    } else {
                        z2 = false;
                    }
                    if (!z && !z2) {
                        z3 = false;
                    }
                    z4 = z3;
                }
                z2 = true;
                if (!z) {
                    z3 = false;
                }
                z4 = z3;
            }
            z = true;
            if (Offset.m2799getYimpl(jM2802minusMKHz9U2) > 0.5f) {
                m159pullTop0a9Yr6o(jM2802minusMKHz9U2, jM2808unboximpl);
            } else {
                if (Offset.m2799getYimpl(jM2802minusMKHz9U2) < -0.5f) {
                    m156pullBottom0a9Yr6o(jM2802minusMKHz9U2, jM2808unboximpl);
                } else {
                    z2 = false;
                }
                if (!z) {
                    z3 = false;
                }
                z4 = z3;
            }
            z2 = true;
            if (!z) {
                z3 = false;
            }
            z4 = z3;
        }
        if (m160releaseOppositeOverscrollk4lQ0M(j) || z4) {
            invalidateOverscroll();
        }
        return Offset.m2803plusMKHz9U(jOffset, jM2808unboximpl2);
    }

    public final void drawOverscroll(DrawScope drawScope) {
        boolean zDrawLeft;
        AbstractC4492zt.h(drawScope, "<this>");
        if (Size.m2869isEmptyimpl(this.containerSize)) {
            return;
        }
        androidx.compose.ui.graphics.Canvas canvas = drawScope.getDrawContext().getCanvas();
        this.redrawSignal.getValue();
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        if (edgeEffectCompat.getDistanceCompat(this.leftEffectNegation) != 0.0f) {
            drawRight(drawScope, this.leftEffectNegation, nativeCanvas);
            this.leftEffectNegation.finish();
        }
        if (this.leftEffect.isFinished()) {
            zDrawLeft = false;
        } else {
            zDrawLeft = drawLeft(drawScope, this.leftEffect, nativeCanvas);
            edgeEffectCompat.onPullDistanceCompat(this.leftEffectNegation, edgeEffectCompat.getDistanceCompat(this.leftEffect), 0.0f);
        }
        if (edgeEffectCompat.getDistanceCompat(this.topEffectNegation) != 0.0f) {
            drawBottom(drawScope, this.topEffectNegation, nativeCanvas);
            this.topEffectNegation.finish();
        }
        if (!this.topEffect.isFinished()) {
            zDrawLeft = drawTop(drawScope, this.topEffect, nativeCanvas) || zDrawLeft;
            edgeEffectCompat.onPullDistanceCompat(this.topEffectNegation, edgeEffectCompat.getDistanceCompat(this.topEffect), 0.0f);
        }
        if (edgeEffectCompat.getDistanceCompat(this.rightEffectNegation) != 0.0f) {
            drawLeft(drawScope, this.rightEffectNegation, nativeCanvas);
            this.rightEffectNegation.finish();
        }
        if (!this.rightEffect.isFinished()) {
            zDrawLeft = drawRight(drawScope, this.rightEffect, nativeCanvas) || zDrawLeft;
            edgeEffectCompat.onPullDistanceCompat(this.rightEffectNegation, edgeEffectCompat.getDistanceCompat(this.rightEffect), 0.0f);
        }
        if (edgeEffectCompat.getDistanceCompat(this.bottomEffectNegation) != 0.0f) {
            drawTop(drawScope, this.bottomEffectNegation, nativeCanvas);
            this.bottomEffectNegation.finish();
        }
        if (!this.bottomEffect.isFinished()) {
            boolean z = drawBottom(drawScope, this.bottomEffect, nativeCanvas) || zDrawLeft;
            edgeEffectCompat.onPullDistanceCompat(this.bottomEffectNegation, edgeEffectCompat.getDistanceCompat(this.bottomEffect), 0.0f);
            zDrawLeft = z;
        }
        if (zDrawLeft) {
            invalidateOverscroll();
        }
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final boolean getInvalidationEnabled$foundation_release() {
        return this.invalidationEnabled;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(list.get(i)) == 0.0f)) {
                return true;
            }
        }
        return false;
    }

    public final void setInvalidationEnabled$foundation_release(boolean z) {
        this.invalidationEnabled = z;
    }
}
