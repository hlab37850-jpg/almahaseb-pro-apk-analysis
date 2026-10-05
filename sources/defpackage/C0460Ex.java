package defpackage;

import com.itextpdf.tool.xml.html.HTML;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* JADX INFO: renamed from: Ex, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0460Ex implements InterfaceC0434Dx {
    public final Matcher a;
    public final CharSequence b;
    public final InterfaceC0408Cx c;

    /* JADX INFO: renamed from: Ex$a */
    public static final class a extends D implements InterfaceC0408Cx {

        /* JADX INFO: renamed from: Ex$a$a, reason: collision with other inner class name */
        public static final class C0004a extends AbstractC2233fv implements InterfaceC3750qp {
            public C0004a() {
                super(1);
            }

            public final C0382Bx a(int i) {
                return a.this.get(i);
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((Number) obj).intValue());
            }
        }

        public a() {
        }

        public /* bridge */ boolean a(C0382Bx c0382Bx) {
            return super.contains(c0382Bx);
        }

        @Override // defpackage.D, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof C0382Bx) {
                return a((C0382Bx) obj);
            }
            return false;
        }

        @Override // defpackage.InterfaceC0408Cx
        public C0382Bx get(int i) {
            C1001Vs c1001VsD = TJ.d(C0460Ex.this.c(), i);
            if (c1001VsD.getStart().intValue() < 0) {
                return null;
            }
            String strGroup = C0460Ex.this.c().group(i);
            AbstractC4492zt.g(strGroup, "group(...)");
            return new C0382Bx(strGroup, c1001VsD);
        }

        @Override // defpackage.D
        public int getSize() {
            return C0460Ex.this.c().groupCount() + 1;
        }

        @Override // defpackage.D, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return FO.r(AbstractC3240kc.T(AbstractC1886cc.n(this)), new C0004a()).iterator();
        }
    }

    public C0460Ex(Matcher matcher, CharSequence charSequence) {
        AbstractC4492zt.h(matcher, "matcher");
        AbstractC4492zt.h(charSequence, HTML.Tag.INPUT);
        this.a = matcher;
        this.b = charSequence;
        this.c = new a();
    }

    @Override // defpackage.InterfaceC0434Dx
    public InterfaceC0408Cx a() {
        return this.c;
    }

    public final MatchResult c() {
        return this.a;
    }
}
