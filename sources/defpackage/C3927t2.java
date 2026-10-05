package defpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/* JADX INFO: renamed from: t2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3927t2 {
    public static HashMap a;
    public static HashMap b;
    public static Thread c;

    /* JADX INFO: renamed from: t2$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/com/sun/pdfview/font/ttf/resource/glyphlist.txt")));
            while (true) {
                try {
                    arrayList.clear();
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        return;
                    }
                    String strTrim = line.trim();
                    if (strTrim.length() > 0 && !strTrim.startsWith("#")) {
                        StringTokenizer stringTokenizer = new StringTokenizer(strTrim, ";");
                        String strNextToken = stringTokenizer.nextToken();
                        StringTokenizer stringTokenizer2 = new StringTokenizer(stringTokenizer.nextToken(), " ");
                        while (stringTokenizer2.hasMoreTokens()) {
                            arrayList.add(stringTokenizer2.nextToken());
                        }
                        int[] iArr = new int[arrayList.size()];
                        for (int i = 0; i < arrayList.size(); i++) {
                            iArr[i] = Integer.parseInt((String) arrayList.get(i), 16);
                            C3927t2.b.put(new Integer(iArr[i]), strNextToken);
                        }
                        C3927t2.a.put(strNextToken, iArr);
                    }
                } catch (IOException unused) {
                    return;
                }
            }
        }
    }

    static {
        new C3927t2();
    }

    public C3927t2() {
        a = new HashMap(4500);
        b = new HashMap(4500);
        Thread thread = new Thread(new a(), "Adobe Glyph Loader Thread");
        c = thread;
        thread.setDaemon(true);
        c.setPriority(1);
        c.start();
    }

    public static Integer c(String str) {
        int[] iArrD = d(str);
        if (iArrD == null) {
            return null;
        }
        return new Integer(iArrD[0]);
    }

    public static int[] d(String str) {
        while (true) {
            Thread thread = c;
            if (thread == null || !thread.isAlive()) {
                break;
            }
            synchronized (a) {
                try {
                    a.wait(250L);
                } catch (InterruptedException unused) {
                }
            }
        }
        return (int[]) a.get(str);
    }
}
