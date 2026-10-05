package defpackage;

import android.os.SystemClock;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: renamed from: rj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C3824rj implements InterfaceC2339h9 {
    public final Map a;
    public long b;
    public final File c;
    public final int d;

    /* JADX INFO: renamed from: rj$b */
    public static class b {
        public long a;
        public String b;
        public String c;
        public long d;
        public long e;
        public long f;
        public Map g;

        public b() {
        }

        public static b a(InputStream inputStream) throws IOException {
            b bVar = new b();
            if (C3824rj.g(inputStream) != 538051844) {
                throw new IOException();
            }
            bVar.b = C3824rj.i(inputStream);
            String strI = C3824rj.i(inputStream);
            bVar.c = strI;
            if (strI.equals("")) {
                bVar.c = null;
            }
            bVar.d = C3824rj.h(inputStream);
            bVar.e = C3824rj.h(inputStream);
            bVar.f = C3824rj.h(inputStream);
            bVar.g = C3824rj.j(inputStream);
            return bVar;
        }

        public InterfaceC2339h9.a b(byte[] bArr) {
            InterfaceC2339h9.a aVar = new InterfaceC2339h9.a();
            aVar.a = bArr;
            aVar.b = this.c;
            aVar.c = this.d;
            aVar.d = this.e;
            aVar.e = this.f;
            aVar.f = this.g;
            return aVar;
        }

        public boolean c(OutputStream outputStream) {
            try {
                C3824rj.n(outputStream, 538051844);
                C3824rj.p(outputStream, this.b);
                String str = this.c;
                if (str == null) {
                    str = "";
                }
                C3824rj.p(outputStream, str);
                C3824rj.o(outputStream, this.d);
                C3824rj.o(outputStream, this.e);
                C3824rj.o(outputStream, this.f);
                C3824rj.q(this.g, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                AbstractC2201fY.b("%s", e.toString());
                return false;
            }
        }

        public b(String str, InterfaceC2339h9.a aVar) {
            this.b = str;
            this.a = aVar.a.length;
            this.c = aVar.b;
            this.d = aVar.c;
            this.e = aVar.d;
            this.f = aVar.e;
            this.g = aVar.f;
        }
    }

    /* JADX INFO: renamed from: rj$c */
    public static class c extends FilterInputStream {
        public int a;

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i = super.read();
            if (i != -1) {
                this.a++;
            }
            return i;
        }

        public c(InputStream inputStream) {
            super(inputStream);
            this.a = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = super.read(bArr, i, i2);
            if (i3 != -1) {
                this.a += i3;
            }
            return i3;
        }
    }

    public C3824rj(File file, int i) {
        this.a = new LinkedHashMap(16, 0.75f, true);
        this.b = 0L;
        this.c = file;
        this.d = i;
    }

    public static int f(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    public static int g(InputStream inputStream) {
        return (f(inputStream) << 24) | f(inputStream) | (f(inputStream) << 8) | (f(inputStream) << 16);
    }

    public static long h(InputStream inputStream) {
        return (((long) f(inputStream)) & 255) | ((((long) f(inputStream)) & 255) << 8) | ((((long) f(inputStream)) & 255) << 16) | ((((long) f(inputStream)) & 255) << 24) | ((((long) f(inputStream)) & 255) << 32) | ((((long) f(inputStream)) & 255) << 40) | ((((long) f(inputStream)) & 255) << 48) | ((255 & ((long) f(inputStream))) << 56);
    }

    public static String i(InputStream inputStream) {
        return new String(m(inputStream, (int) h(inputStream)), XmpWriter.UTF8);
    }

    public static Map j(InputStream inputStream) {
        int iG = g(inputStream);
        Map mapEmptyMap = iG == 0 ? Collections.emptyMap() : new HashMap(iG);
        for (int i = 0; i < iG; i++) {
            mapEmptyMap.put(i(inputStream).intern(), i(inputStream).intern());
        }
        return mapEmptyMap;
    }

    public static byte[] m(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 == -1) {
                break;
            }
            i2 += i3;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    public static void n(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    public static void o(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    public static void p(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(XmpWriter.UTF8);
        o(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    public static void q(Map map, OutputStream outputStream) throws IOException {
        if (map == null) {
            n(outputStream, 0);
            return;
        }
        n(outputStream, map.size());
        for (Map.Entry entry : map.entrySet()) {
            p(outputStream, (String) entry.getKey());
            p(outputStream, (String) entry.getValue());
        }
    }

    @Override // defpackage.InterfaceC2339h9
    public synchronized void a(String str, InterfaceC2339h9.a aVar) {
        d(aVar.a.length);
        File fileB = b(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileB);
            b bVar = new b(str, aVar);
            bVar.c(fileOutputStream);
            fileOutputStream.write(aVar.a);
            fileOutputStream.close();
            e(str, bVar);
        } catch (IOException unused) {
            if (fileB.delete()) {
                return;
            }
            AbstractC2201fY.b("Could not clean up file %s", fileB.getAbsolutePath());
        }
    }

    public File b(String str) {
        return new File(this.c, c(str));
    }

    public final String c(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    public final void d(int i) {
        int i2;
        long j = i;
        if (this.b + j < this.d) {
            return;
        }
        if (AbstractC2201fY.b) {
            AbstractC2201fY.e("Pruning old cache entries.", new Object[0]);
        }
        long j2 = this.b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator it = this.a.entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            b bVar = (b) ((Map.Entry) it.next()).getValue();
            if (b(bVar.b).delete()) {
                this.b -= bVar.a;
                i2 = 1;
            } else {
                String str = bVar.b;
                String strC = c(str);
                i2 = 1;
                AbstractC2201fY.b("Could not delete cache entry for key=%s, filename=%s", str, strC);
            }
            it.remove();
            i3 += i2;
            if (this.b + j < this.d * 0.9f) {
                break;
            }
        }
        if (AbstractC2201fY.b) {
            AbstractC2201fY.e("pruned %d files, %d bytes, %d ms", Integer.valueOf(i3), Long.valueOf(this.b - j2), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    public final void e(String str, b bVar) {
        if (this.a.containsKey(str)) {
            this.b += bVar.a - ((b) this.a.get(str)).a;
        } else {
            this.b += bVar.a;
        }
        this.a.put(str, bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.InterfaceC2339h9
    public synchronized InterfaceC2339h9.a get(String str) {
        c cVar;
        b bVar = (b) this.a.get(str);
        InputStream inputStream = null;
        Object[] objArr = 0;
        if (bVar == null) {
            return null;
        }
        try {
            File fileB = b(str);
            try {
                cVar = new c(new FileInputStream(fileB));
                try {
                    b.a(cVar);
                    InterfaceC2339h9.a aVarB = bVar.b(m(cVar, (int) (fileB.length() - ((long) cVar.a))));
                    try {
                        cVar.close();
                        return aVarB;
                    } catch (IOException unused) {
                        return null;
                    }
                } catch (IOException e) {
                    e = e;
                    AbstractC2201fY.b("%s: %s", fileB.getAbsolutePath(), e.toString());
                    k(str);
                    if (cVar != null) {
                        try {
                            cVar.close();
                        } catch (IOException unused2) {
                            return null;
                        }
                    }
                    return null;
                }
            } catch (IOException e2) {
                e = e2;
                cVar = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                        return null;
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // defpackage.InterfaceC2339h9
    public synchronized void initialize() {
        synchronized (this) {
            if (!this.c.exists()) {
                if (!this.c.mkdirs()) {
                    AbstractC2201fY.c("Unable to create cache dir %s", this.c.getAbsolutePath());
                }
                return;
            }
            File[] fileArrListFiles = this.c.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (File file : fileArrListFiles) {
                FileInputStream fileInputStream = null;
                try {
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            b bVarA = b.a(fileInputStream2);
                            bVarA.a = file.length();
                            e(bVarA.b, bVarA);
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused) {
                            }
                        } catch (IOException unused2) {
                            fileInputStream = fileInputStream2;
                            if (file != null) {
                                file.delete();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException unused4) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }

    public synchronized void k(String str) {
        boolean zDelete = b(str).delete();
        l(str);
        if (!zDelete) {
            AbstractC2201fY.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
        }
    }

    public final void l(String str) {
        b bVar = (b) this.a.get(str);
        if (bVar != null) {
            this.b -= bVar.a;
            this.a.remove(str);
        }
    }

    public C3824rj(File file) {
        this(file, 5242880);
    }
}
