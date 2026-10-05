package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.itextpdf.text.xml.xmp.XmpWriter;
import com.itextpdf.tool.xml.html.HTML;
import info.aalmoghalis.inventory.R;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AQ implements Runnable {
    public final int a;
    public final AssetManager b;
    public boolean c;
    public ServerSocket d;
    public Z00 e;
    public Context f;
    public double g = 0.0d;
    public int[] h = {R.drawable.up, 1, R.drawable.down};
    public List i = new ArrayList();

    public AQ(int i, AssetManager assetManager, Context context, Z00 z00) {
        this.a = i;
        this.b = assetManager;
        this.e = z00;
        this.f = context;
    }

    public final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.endsWith(".html")) {
            return "text/html";
        }
        if (str.endsWith(".js")) {
            return "application/javascript";
        }
        return str.endsWith(".css") ? HTML.Attribute.Value.TEXTCSS : "application/octet-stream";
    }

    public byte[] b(File file) throws IOException {
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        byte[] bArr2 = new byte[length];
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            try {
                int i = fileInputStream.read(bArr, 0, length);
                if (i < length) {
                    int i2 = length - i;
                    while (i2 > 0) {
                        int i3 = fileInputStream.read(bArr2, 0, i2);
                        System.arraycopy(bArr2, 0, bArr, length - i2, i3);
                        i2 -= i3;
                    }
                }
                fileInputStream.close();
                return bArr;
            } catch (IOException e) {
                throw e;
            }
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    public void c(String str) {
        Cursor cursorL3 = this.e.L3(str);
        cursorL3.getCount();
        this.g = 0.0d;
        this.i.clear();
        cursorL3.moveToFirst();
        while (!cursorL3.isAfterLast()) {
            this.i.add(new C4064uh(cursorL3.getString(cursorL3.getColumnIndex("_id")), cursorL3.getString(cursorL3.getColumnIndex("date_")), cursorL3.getString(cursorL3.getColumnIndex("amount")), cursorL3.getString(cursorL3.getColumnIndex("remarks")), this.h[cursorL3.getInt(cursorL3.getColumnIndex("_in"))], String.valueOf(cursorL3.getInt(cursorL3.getColumnIndex("_in"))), cursorL3.getString(cursorL3.getColumnIndex("param1"))));
            cursorL3.moveToNext();
        }
        cursorL3.close();
        for (int size = this.i.size() - 1; size >= 0; size--) {
            this.g += Double.parseDouble(((C4064uh) this.i.get(size)).n().replaceAll(",", "")) * (Double.parseDouble(((C4064uh) this.i.get(size)).f()) - 1.0d);
            C4064uh c4064uh = (C4064uh) this.i.get(size);
            c4064uh.w(String.valueOf(this.g));
            this.i.set(size, c4064uh);
        }
    }

    public final void d(Socket socket) throws Throwable {
        BufferedReader bufferedReader;
        String strSubstring;
        PrintStream printStream = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (TextUtils.isEmpty(line)) {
                        strSubstring = null;
                        break;
                    } else if (line.startsWith("GET /")) {
                        int iIndexOf = line.indexOf(47) + 1;
                        strSubstring = line.substring(iIndexOf, line.indexOf(32, iIndexOf));
                        break;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            }
            String strDecode = (strSubstring == null || strSubstring.isEmpty()) ? "index.html" : URLDecoder.decode(strSubstring, XmpWriter.UTF8);
            Log.d("route=", strDecode);
            c(strDecode.replace(".pdf", ""));
            this.e.Za(this.i, strDecode.replace(".pdf", ""), this.g);
            PrintStream printStream2 = new PrintStream(socket.getOutputStream());
            try {
                if (!strDecode.equals("favicon.ico") && (strDecode.contains(".html") || strDecode.contains(".pdf"))) {
                    byte[] bArrB = b(new File(Z00.L, strDecode));
                    if (bArrB == null) {
                        g(printStream2);
                        printStream2.close();
                        bufferedReader.close();
                        return;
                    }
                    printStream2.println("HTTP/1.0 200 OK");
                    printStream2.println("Content-Type: " + a(strDecode));
                    printStream2.println("Content-Length: " + bArrB.length);
                    printStream2.println();
                    printStream2.write(bArrB);
                    printStream2.flush();
                    printStream2.close();
                    bufferedReader.close();
                    return;
                }
                g(printStream2);
                printStream2.close();
                bufferedReader.close();
            } catch (Throwable th2) {
                th = th2;
                printStream = printStream2;
                if (printStream != null) {
                    printStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }

    public void e() {
        this.c = true;
        new Thread(this).start();
    }

    public void f() {
        try {
            this.c = false;
            ServerSocket serverSocket = this.d;
            if (serverSocket != null) {
                serverSocket.close();
                this.d = null;
            }
        } catch (IOException e) {
            Log.e("SimpleWebServer", "Error closing the server socket.", e);
        }
    }

    public final void g(PrintStream printStream) {
        printStream.println("HTTP/1.0 500 Internal Server Error");
        printStream.flush();
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            this.d = new ServerSocket(this.a);
            while (this.c) {
                Socket socketAccept = this.d.accept();
                d(socketAccept);
                socketAccept.close();
            }
        } catch (SocketException unused) {
        } catch (IOException e) {
            Log.e("SimpleWebServer", "Web server error.", e);
        }
    }
}
