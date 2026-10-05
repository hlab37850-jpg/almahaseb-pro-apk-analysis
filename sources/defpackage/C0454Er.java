package defpackage;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: Er, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0454Er implements Closeable {
    public static final a e = new a(null);
    public static final Logger f;
    public final L8 a;
    public final boolean b;
    public final b c;
    public final C4490zr.a d;

    /* JADX INFO: renamed from: Er$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Logger a() {
            return C0454Er.f;
        }

        public final int b(int i, int i2, int i3) throws IOException {
            if ((i2 & 8) != 0) {
                i--;
            }
            if (i3 <= i) {
                return i - i3;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i3 + " > remaining length " + i);
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: Er$c */
    public interface c {
        void a(int i, EnumC4069ul enumC4069ul, W8 w8);

        void b();

        void c(int i, EnumC4069ul enumC4069ul);

        void d(boolean z, int i, int i2, List list);

        void e(boolean z, int i, L8 l8, int i2);

        void f(int i, long j);

        void g(boolean z, int i, int i2);

        void h(int i, int i2, int i3, boolean z);

        void i(boolean z, SO so);

        void j(int i, int i2, List list);
    }

    static {
        Logger logger = Logger.getLogger(C0376Br.class.getName());
        AbstractC4492zt.g(logger, "getLogger(Http2::class.java.name)");
        f = logger;
    }

    public C0454Er(L8 l8, boolean z) {
        AbstractC4492zt.h(l8, DublinCoreProperties.SOURCE);
        this.a = l8;
        this.b = z;
        b bVar = new b(l8);
        this.c = bVar;
        this.d = new C4490zr.a(bVar, 4096, 0, 4, null);
    }

    public final void A(c cVar, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int iD = (i2 & 8) != 0 ? AbstractC3724qX.d(this.a.readByte(), 255) : 0;
        cVar.j(i3, this.a.readInt() & Integer.MAX_VALUE, t(e.b(i - 4, i2, iD), iD, i2, i3));
    }

    public final void C(c cVar, int i, int i2, int i3) throws IOException {
        if (i != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i + " != 4");
        }
        if (i3 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int i4 = this.a.readInt();
        EnumC4069ul enumC4069ulA = EnumC4069ul.b.a(i4);
        if (enumC4069ulA != null) {
            cVar.c(i3, enumC4069ulA);
            return;
        }
        throw new IOException("TYPE_RST_STREAM unexpected error code: " + i4);
    }

    public final void F(c cVar, int i, int i2, int i3) throws IOException {
        if (i3 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i2 & 1) != 0) {
            if (i != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            cVar.b();
            return;
        }
        if (i % 6 != 0) {
            throw new IOException("TYPE_SETTINGS length % 6 != 0: " + i);
        }
        SO so = new SO();
        C0945Ts c0945TsR = AbstractC3871sJ.r(AbstractC3871sJ.s(0, i), 6);
        int iB = c0945TsR.b();
        int iC = c0945TsR.c();
        int iD = c0945TsR.d();
        if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
            while (true) {
                int iE = AbstractC3724qX.e(this.a.readShort(), 65535);
                int i4 = this.a.readInt();
                if (iE != 2) {
                    if (iE == 3) {
                        iE = 4;
                    } else if (iE != 4) {
                        if (iE == 5 && (i4 < 16384 || i4 > 16777215)) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + i4);
                        }
                    } else {
                        if (i4 < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                        iE = 7;
                    }
                } else if (i4 != 0 && i4 != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                so.h(iE, i4);
                if (iB != iC) {
                    iB += iD;
                }
            }
        }
        cVar.i(false, so);
    }

    public final void G(c cVar, int i, int i2, int i3) throws IOException {
        if (i != 4) {
            throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i);
        }
        long jF = AbstractC3724qX.f(this.a.readInt(), 2147483647L);
        if (jF == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        cVar.f(i3, jF);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    public final boolean d(boolean z, c cVar) throws IOException {
        AbstractC4492zt.h(cVar, "handler");
        try {
            this.a.D(9L);
            int iJ = AbstractC3724qX.J(this.a);
            if (iJ > 16384) {
                throw new IOException("FRAME_SIZE_ERROR: " + iJ);
            }
            int iD = AbstractC3724qX.d(this.a.readByte(), 255);
            int iD2 = AbstractC3724qX.d(this.a.readByte(), 255);
            int i = this.a.readInt() & Integer.MAX_VALUE;
            Logger logger = f;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(C0376Br.a.c(true, i, iJ, iD, iD2));
            }
            if (z && iD != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + C0376Br.a.b(iD));
            }
            switch (iD) {
                case 0:
                    i(cVar, iJ, iD2, i);
                    return true;
                case 1:
                    u(cVar, iJ, iD2, i);
                    return true;
                case 2:
                    z(cVar, iJ, iD2, i);
                    return true;
                case 3:
                    C(cVar, iJ, iD2, i);
                    return true;
                case 4:
                    F(cVar, iJ, iD2, i);
                    return true;
                case 5:
                    A(cVar, iJ, iD2, i);
                    return true;
                case 6:
                    v(cVar, iJ, iD2, i);
                    return true;
                case 7:
                    r(cVar, iJ, iD2, i);
                    return true;
                case 8:
                    G(cVar, iJ, iD2, i);
                    return true;
                default:
                    this.a.skip(iJ);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void g(c cVar) throws IOException {
        AbstractC4492zt.h(cVar, "handler");
        if (this.b) {
            if (!d(true, cVar)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        L8 l8 = this.a;
        W8 w8 = C0376Br.b;
        W8 w8E = l8.e(w8.u());
        Logger logger = f;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(AbstractC3724qX.t("<< CONNECTION " + w8E.k(), new Object[0]));
        }
        if (AbstractC4492zt.d(w8, w8E)) {
            return;
        }
        throw new IOException("Expected a connection header but was " + w8E.y());
    }

    public final void i(c cVar, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z = (i2 & 1) != 0;
        if ((i2 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int iD = (i2 & 8) != 0 ? AbstractC3724qX.d(this.a.readByte(), 255) : 0;
        cVar.e(z, i3, this.a, e.b(i, i2, iD));
        this.a.skip(iD);
    }

    public final void r(c cVar, int i, int i2, int i3) throws IOException {
        if (i < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + i);
        }
        if (i3 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i4 = this.a.readInt();
        int i5 = this.a.readInt();
        int i6 = i - 8;
        EnumC4069ul enumC4069ulA = EnumC4069ul.b.a(i5);
        if (enumC4069ulA == null) {
            throw new IOException("TYPE_GOAWAY unexpected error code: " + i5);
        }
        W8 w8E = W8.e;
        if (i6 > 0) {
            w8E = this.a.e(i6);
        }
        cVar.a(i4, enumC4069ulA, w8E);
    }

    public final List t(int i, int i2, int i3, int i4) throws IOException {
        this.c.i(i);
        b bVar = this.c;
        bVar.r(bVar.c());
        this.c.t(i2);
        this.c.g(i3);
        this.c.u(i4);
        this.d.k();
        return this.d.e();
    }

    public final void u(c cVar, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z = (i2 & 1) != 0;
        int iD = (i2 & 8) != 0 ? AbstractC3724qX.d(this.a.readByte(), 255) : 0;
        if ((i2 & 32) != 0) {
            x(cVar, i3);
            i -= 5;
        }
        cVar.d(z, i3, -1, t(e.b(i, i2, iD), iD, i2, i3));
    }

    public final void v(c cVar, int i, int i2, int i3) throws IOException {
        if (i != 8) {
            throw new IOException("TYPE_PING length != 8: " + i);
        }
        if (i3 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        cVar.g((i2 & 1) != 0, this.a.readInt(), this.a.readInt());
    }

    public final void x(c cVar, int i) {
        int i2 = this.a.readInt();
        cVar.h(i, i2 & Integer.MAX_VALUE, AbstractC3724qX.d(this.a.readByte(), 255) + 1, (Integer.MIN_VALUE & i2) != 0);
    }

    public final void z(c cVar, int i, int i2, int i3) throws IOException {
        if (i == 5) {
            if (i3 == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            x(cVar, i3);
        } else {
            throw new IOException("TYPE_PRIORITY length: " + i + " != 5");
        }
    }

    /* JADX INFO: renamed from: Er$b */
    public static final class b implements InterfaceC3309lR {
        public final L8 a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;

        public b(L8 l8) {
            AbstractC4492zt.h(l8, DublinCoreProperties.SOURCE);
            this.a = l8;
        }

        @Override // defpackage.InterfaceC3309lR
        public JU b() {
            return this.a.b();
        }

        public final int c() {
            return this.e;
        }

        public final void d() throws IOException {
            int i = this.d;
            int iJ = AbstractC3724qX.J(this.a);
            this.e = iJ;
            this.b = iJ;
            int iD = AbstractC3724qX.d(this.a.readByte(), 255);
            this.c = AbstractC3724qX.d(this.a.readByte(), 255);
            a aVar = C0454Er.e;
            if (aVar.a().isLoggable(Level.FINE)) {
                aVar.a().fine(C0376Br.a.c(true, this.d, this.b, iD, this.c));
            }
            int i2 = this.a.readInt() & Integer.MAX_VALUE;
            this.d = i2;
            if (iD == 9) {
                if (i2 != i) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(iD + " != TYPE_CONTINUATION");
            }
        }

        public final void g(int i) {
            this.c = i;
        }

        public final void i(int i) {
            this.e = i;
        }

        public final void r(int i) {
            this.b = i;
        }

        public final void t(int i) {
            this.f = i;
        }

        public final void u(int i) {
            this.d = i;
        }

        @Override // defpackage.InterfaceC3309lR
        public long y(H8 h8, long j) throws IOException {
            AbstractC4492zt.h(h8, "sink");
            while (true) {
                int i = this.e;
                if (i != 0) {
                    long jY = this.a.y(h8, Math.min(j, i));
                    if (jY == -1) {
                        return -1L;
                    }
                    this.e -= (int) jY;
                    return jY;
                }
                this.a.skip(this.f);
                this.f = 0;
                if ((this.c & 4) != 0) {
                    return -1L;
                }
                d();
            }
        }

        @Override // defpackage.InterfaceC3309lR, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() {
        }
    }
}
