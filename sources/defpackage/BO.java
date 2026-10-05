package defpackage;

import com.itextpdf.tool.xml.css.CSS;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BO {

    public static final class a implements InterfaceC4362yO {
        public final /* synthetic */ InterfaceC0526Fp a;

        public a(InterfaceC0526Fp interfaceC0526Fp) {
            this.a = interfaceC0526Fp;
        }

        @Override // defpackage.InterfaceC4362yO
        public Iterator iterator() {
            return BO.a(this.a);
        }
    }

    public static Iterator a(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        C4453zO c4453zO = new C4453zO();
        c4453zO.l(AbstractC0352At.b(interfaceC0526Fp, c4453zO, c4453zO));
        return c4453zO;
    }

    public static InterfaceC4362yO b(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        return new a(interfaceC0526Fp);
    }
}
