package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;

/* JADX INFO: renamed from: ur, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4075ur {
    public static final a c = new a(null);
    public final L8 a;
    public long b;

    /* JADX INFO: renamed from: ur$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
        }
    }

    public C4075ur(L8 l8) {
        AbstractC4492zt.h(l8, DublinCoreProperties.SOURCE);
        this.a = l8;
        this.b = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public final C3994tr a() {
        C3994tr.a aVar = new C3994tr.a();
        while (true) {
            String strB = b();
            if (strB.length() == 0) {
                return aVar.d();
            }
            aVar.b(strB);
        }
    }

    public final String b() {
        String strK = this.a.k(this.b);
        this.b -= (long) strK.length();
        return strK;
    }
}
