package androidx.lifecycle;

import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC1040Xf;
import defpackage.AbstractC4492zt;
import defpackage.C0368Bj;
import defpackage.InterfaceC0988Vf;

/* JADX INFO: loaded from: classes2.dex */
public final class PausingDispatcher extends AbstractC1040Xf {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // defpackage.AbstractC1040Xf
    public void dispatch(InterfaceC0988Vf interfaceC0988Vf, Runnable runnable) {
        AbstractC4492zt.h(interfaceC0988Vf, "context");
        AbstractC4492zt.h(runnable, CSS.Value.BLOCK);
        this.dispatchQueue.dispatchAndEnqueue(interfaceC0988Vf, runnable);
    }

    @Override // defpackage.AbstractC1040Xf
    public boolean isDispatchNeeded(InterfaceC0988Vf interfaceC0988Vf) {
        AbstractC4492zt.h(interfaceC0988Vf, "context");
        if (C0368Bj.c().I().isDispatchNeeded(interfaceC0988Vf)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
