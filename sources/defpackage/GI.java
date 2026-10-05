package defpackage;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface GI {
    public static final a a = a.a;
    public static final GI b = new a.C0006a();

    public static final class a {
        public static final /* synthetic */ a a = new a();

        /* JADX INFO: renamed from: GI$a$a, reason: collision with other inner class name */
        public static final class C0006a implements GI {
            @Override // defpackage.GI
            public void a(int i, EnumC4069ul enumC4069ul) {
                AbstractC4492zt.h(enumC4069ul, "errorCode");
            }

            @Override // defpackage.GI
            public boolean b(int i, List list) {
                AbstractC4492zt.h(list, "requestHeaders");
                return true;
            }

            @Override // defpackage.GI
            public boolean c(int i, List list, boolean z) {
                AbstractC4492zt.h(list, "responseHeaders");
                return true;
            }

            @Override // defpackage.GI
            public boolean d(int i, L8 l8, int i2, boolean z) {
                AbstractC4492zt.h(l8, DublinCoreProperties.SOURCE);
                l8.skip(i2);
                return true;
            }
        }
    }

    void a(int i, EnumC4069ul enumC4069ul);

    boolean b(int i, List list);

    boolean c(int i, List list, boolean z);

    boolean d(int i, L8 l8, int i2, boolean z);
}
