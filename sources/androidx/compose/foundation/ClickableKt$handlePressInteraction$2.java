package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC3347lu;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.foundation.ClickableKt$handlePressInteraction$2", f = "Clickable.kt", l = {MetaDo.META_PAINTREGION, 301, 308, 309, 318}, m = "invokeSuspend")
public final class ClickableKt$handlePressInteraction$2 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ InterfaceC3588op $delayPressInteraction;
    final /* synthetic */ AbstractClickableNode.InteractionData $interactionData;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $pressPoint;
    final /* synthetic */ PressGestureScope $this_handlePressInteraction;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableKt$handlePressInteraction$2(PressGestureScope pressGestureScope, long j, MutableInteractionSource mutableInteractionSource, AbstractClickableNode.InteractionData interactionData, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$this_handlePressInteraction = pressGestureScope;
        this.$pressPoint = j;
        this.$interactionSource = mutableInteractionSource;
        this.$interactionData = interactionData;
        this.$delayPressInteraction = interfaceC3588op;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        ClickableKt$handlePressInteraction$2 clickableKt$handlePressInteraction$2 = new ClickableKt$handlePressInteraction$2(this.$this_handlePressInteraction, this.$pressPoint, this.$interactionSource, this.$interactionData, this.$delayPressInteraction, interfaceC0793Of);
        clickableKt$handlePressInteraction$2.L$0 = obj;
        return clickableKt$handlePressInteraction$2;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
        return ((ClickableKt$handlePressInteraction$2) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x008b  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b1 A[RETURN] */
    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        InterfaceC1830bu interfaceC1830buD;
        Object objTryAwaitRelease;
        boolean z;
        PressInteraction.Press press;
        PressInteraction.Release release;
        MutableInteractionSource mutableInteractionSource;
        PressInteraction.Release release2;
        MutableInteractionSource mutableInteractionSource2;
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                interfaceC1830buD = (InterfaceC1830bu) this.L$0;
                LL.b(obj);
                objTryAwaitRelease = obj;
            } else if (i == 2) {
                z = this.Z$0;
                LL.b(obj);
                if (z) {
                    press = new PressInteraction.Press(this.$pressPoint, null);
                    release = new PressInteraction.Release(press);
                    mutableInteractionSource = this.$interactionSource;
                    this.L$0 = release;
                    this.label = 3;
                    if (mutableInteractionSource.emit(press, this) == objD) {
                        return objD;
                    }
                    release2 = release;
                    mutableInteractionSource2 = this.$interactionSource;
                    this.L$0 = null;
                    this.label = 4;
                    if (mutableInteractionSource2.emit(release2, this) == objD) {
                        return objD;
                    }
                }
            } else if (i == 3) {
                release2 = (PressInteraction.Release) this.L$0;
                LL.b(obj);
                mutableInteractionSource2 = this.$interactionSource;
                this.L$0 = null;
                this.label = 4;
                if (mutableInteractionSource2.emit(release2, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 4 && i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            this.$interactionData.setPressInteraction(null);
            return FW.a;
        }
        LL.b(obj);
        interfaceC1830buD = O8.d((InterfaceC2052dg) this.L$0, null, null, new ClickableKt$handlePressInteraction$2$delayJob$1(this.$delayPressInteraction, this.$pressPoint, this.$interactionSource, this.$interactionData, null), 3, null);
        PressGestureScope pressGestureScope = this.$this_handlePressInteraction;
        this.L$0 = interfaceC1830buD;
        this.label = 1;
        objTryAwaitRelease = pressGestureScope.tryAwaitRelease(this);
        if (objTryAwaitRelease == objD) {
            return objD;
        }
        boolean zBooleanValue = ((Boolean) objTryAwaitRelease).booleanValue();
        if (interfaceC1830buD.isActive()) {
            this.L$0 = null;
            this.Z$0 = zBooleanValue;
            this.label = 2;
            if (AbstractC3347lu.g(interfaceC1830buD, this) == objD) {
                return objD;
            }
            z = zBooleanValue;
            if (z) {
                press = new PressInteraction.Press(this.$pressPoint, null);
                release = new PressInteraction.Release(press);
                mutableInteractionSource = this.$interactionSource;
                this.L$0 = release;
                this.label = 3;
                if (mutableInteractionSource.emit(press, this) == objD) {
                    return objD;
                }
                release2 = release;
                mutableInteractionSource2 = this.$interactionSource;
                this.L$0 = null;
                this.label = 4;
                if (mutableInteractionSource2.emit(release2, this) == objD) {
                    return objD;
                }
            }
        } else {
            PressInteraction.Press pressInteraction = this.$interactionData.getPressInteraction();
            if (pressInteraction != null) {
                MutableInteractionSource mutableInteractionSource3 = this.$interactionSource;
                Interaction release3 = zBooleanValue ? new PressInteraction.Release(pressInteraction) : new PressInteraction.Cancel(pressInteraction);
                this.L$0 = null;
                this.label = 5;
                if (mutableInteractionSource3.emit(release3, this) == objD) {
                    return objD;
                }
            }
        }
        this.$interactionData.setPressInteraction(null);
        return FW.a;
    }
}
