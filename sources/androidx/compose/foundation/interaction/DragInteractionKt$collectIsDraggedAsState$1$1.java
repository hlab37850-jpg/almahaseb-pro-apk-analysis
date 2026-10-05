package androidx.compose.foundation.interaction;

import androidx.compose.runtime.MutableState;
import defpackage.AbstractC0378Bt;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.XS;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.foundation.interaction.DragInteractionKt$collectIsDraggedAsState$1$1", f = "DragInteraction.kt", l = {84}, m = "invokeSuspend")
public final class DragInteractionKt$collectIsDraggedAsState$1$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ MutableState<Boolean> $isDragged;
    final /* synthetic */ InteractionSource $this_collectIsDraggedAsState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragInteractionKt$collectIsDraggedAsState$1$1(InteractionSource interactionSource, MutableState<Boolean> mutableState, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$this_collectIsDraggedAsState = interactionSource;
        this.$isDragged = mutableState;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        return new DragInteractionKt$collectIsDraggedAsState$1$1(this.$this_collectIsDraggedAsState, this.$isDragged, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
        return ((DragInteractionKt$collectIsDraggedAsState$1$1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            final ArrayList arrayList = new ArrayList();
            InterfaceC0939Tm interactions = this.$this_collectIsDraggedAsState.getInteractions();
            final MutableState<Boolean> mutableState = this.$isDragged;
            InterfaceC0995Vm interfaceC0995Vm = new InterfaceC0995Vm() { // from class: androidx.compose.foundation.interaction.DragInteractionKt$collectIsDraggedAsState$1$1.1
                @Override // defpackage.InterfaceC0995Vm
                public final Object emit(Interaction interaction, InterfaceC0793Of interfaceC0793Of) {
                    if (interaction instanceof DragInteraction.Start) {
                        arrayList.add(interaction);
                    } else if (interaction instanceof DragInteraction.Stop) {
                        arrayList.remove(((DragInteraction.Stop) interaction).getStart());
                    } else if (interaction instanceof DragInteraction.Cancel) {
                        arrayList.remove(((DragInteraction.Cancel) interaction).getStart());
                    }
                    mutableState.setValue(E8.a(!arrayList.isEmpty()));
                    return FW.a;
                }
            };
            this.label = 1;
            if (interactions.collect(interfaceC0995Vm, this) == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
        }
        return FW.a;
    }
}
