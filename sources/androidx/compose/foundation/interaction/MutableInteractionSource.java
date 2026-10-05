package androidx.compose.foundation.interaction;

import androidx.compose.runtime.Stable;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface MutableInteractionSource extends InteractionSource {
    Object emit(Interaction interaction, InterfaceC0793Of interfaceC0793Of);

    boolean tryEmit(Interaction interaction);
}
