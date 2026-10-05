package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1043Xi;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.foundation.ClickableKt$handlePressInteraction$2$delayJob$1", f = "Clickable.kt", l = {TIFFConstants.TIFFTAG_GROUP4OPTIONS, TIFFConstants.TIFFTAG_RESOLUTIONUNIT}, m = "invokeSuspend")
public final class ClickableKt$handlePressInteraction$2$delayJob$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ InterfaceC3588op $delayPressInteraction;
    final /* synthetic */ AbstractClickableNode.InteractionData $interactionData;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $pressPoint;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableKt$handlePressInteraction$2$delayJob$1(InterfaceC3588op interfaceC3588op, long j, MutableInteractionSource mutableInteractionSource, AbstractClickableNode.InteractionData interactionData, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$delayPressInteraction = interfaceC3588op;
        this.$pressPoint = j;
        this.$interactionSource = mutableInteractionSource;
        this.$interactionData = interactionData;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        return new ClickableKt$handlePressInteraction$2$delayJob$1(this.$delayPressInteraction, this.$pressPoint, this.$interactionSource, this.$interactionData, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
        return ((ClickableKt$handlePressInteraction$2$delayJob$1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        PressInteraction.Press press;
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                LL.b(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                press = (PressInteraction.Press) this.L$0;
                LL.b(obj);
            }
            this.$interactionData.setPressInteraction(press);
            return FW.a;
        }
        LL.b(obj);
        if (((Boolean) this.$delayPressInteraction.invoke()).booleanValue()) {
            long tapIndicationDelay = Clickable_androidKt.getTapIndicationDelay();
            this.label = 1;
            if (AbstractC1043Xi.a(tapIndicationDelay, this) == objD) {
                return objD;
            }
        }
        PressInteraction.Press press2 = new PressInteraction.Press(this.$pressPoint, null);
        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
        this.L$0 = press2;
        this.label = 2;
        if (mutableInteractionSource.emit(press2, this) == objD) {
            return objD;
        }
        press = press2;
        this.$interactionData.setPressInteraction(press);
        return FW.a;
    }
}
