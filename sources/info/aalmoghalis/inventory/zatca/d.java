package info.aalmoghalis.inventory.zatca;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.json.Json;
import com.google.common.net.HttpHeaders;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.C1839c10;
import defpackage.C2160f10;
import defpackage.MO;
import defpackage.W7;
import defpackage.Z00;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static final CookieManager e = new CookieManager();
    public final Context a;
    public final ExecutorService b;
    public String c;
    public final info.aalmoghalis.inventory.zatca.c d;

    public static class b {
        public boolean a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;

        public b() {
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
        }
    }

    public static class c {
        public int b;
        public String a = "";
        public String c = "";
        public List d = new ArrayList();
    }

    /* JADX INFO: renamed from: info.aalmoghalis.inventory.zatca.d$d, reason: collision with other inner class name */
    public interface InterfaceC0322d {
        void onError(String str);

        void onSuccess(Object obj);
    }

    public static class e {
        public long a;
        public int f;
        public String b = "";
        public String c = "";
        public String d = "";
        public String e = "";
        public List g = new ArrayList();
        public List h = new ArrayList();
        public String i = "";
        public String j = "";
        public String k = "";
        public String l = "";
        public String m = "";
        public String n = "";
        public String o = "";
    }

    public static class f {
        public final int a;
        public final String b;

        public f(int i, String str) {
            this.a = i;
            this.b = str;
        }
    }

    public static class g {
        public String a;
        public String b;
        public String c;
        public String d;
        public Double e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public boolean k;
        public String l;
        public String m;
    }

    public static class h {
        public String a;
        public double b;
        public String c;
        public double d;
        public double e;
        public double f;
        public double g;
    }

    public static class i {
        public n a;
        public String b;
        public String c;
        public String d;
        public String e;
    }

    public static class j {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;
    }

    public static class k {
        public boolean a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
    }

    public static class l {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
    }

    public static class m {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
    }

    public static class n {
        public double A;
        public double B;
        public double C;
        public Double D;
        public String E;
        public String F;
        public String G;
        public int H;
        public String I;
        public String J;
        public Double K;
        public List L = new ArrayList();
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;
        public String t;
        public String u;
        public String v;
        public String w;
        public String x;
        public double y;
        public double z;
    }

    public static class o {
        public String a;
        public String b;
        public double c;
        public String d;
        public double e;
        public double f;
        public double g;
        public String h;
        public double i;
        public double j;
        public double k;
    }

    public d(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = Executors.newSingleThreadExecutor();
        CookieHandler.setDefault(e);
        this.d = new info.aalmoghalis.inventory.zatca.c(applicationContext);
    }

    public static String B(String str) {
        String strReplace = str.replace("https://bkp2.dyndns.org:5002", HttpHeaders.SERVER);
        String strReplace2 = "https://bkp2.dyndns.org:5002".replace("https://", "");
        String strReplace3 = strReplace.replace(strReplace2, HttpHeaders.SERVER).replace(strReplace2.replace(":5002", ""), HttpHeaders.SERVER);
        return strReplace3.startsWith("Unable to resolve host") ? "Unable to connect" : strReplace3;
    }

    public static String C(String str) {
        int iIndexOf = str.indexOf("Error:");
        if (iIndexOf != -1) {
            return str.substring(iIndexOf);
        }
        int iIndexOf2 = str.indexOf("Warning:");
        return iIndexOf2 != -1 ? str.substring(iIndexOf2) : "";
    }

    public static boolean E(Context context) {
        int iB = MO.b(context);
        C2160f10.h = iB;
        if (iB == -1) {
            return false;
        }
        info.aalmoghalis.inventory.zatca.c cVar = new info.aalmoghalis.inventory.zatca.c(context);
        String strR = new d(context).r();
        int iH = cVar.h(Integer.valueOf(C2160f10.i), strR + "");
        return iH != -1 && iH > 0;
    }

    public static double Y(double d) {
        return Math.round(d * 1000000.0d) / 1000000.0d;
    }

    public static boolean g(Context context, Z00 z00, W7 w7) {
        if (w7 != null) {
            try {
                if (w7.g.intValue() == 1) {
                    if (z00.a == null || w7.g.intValue() != 1 || w7.a.longValue() <= 0) {
                        return false;
                    }
                    int iH = new info.aalmoghalis.inventory.zatca.c(context).h(w7.i, new d(context).r());
                    C1839c10.z(z00, "Zatca=", "z=" + iH + ":s=" + w7.P + ":zz=" + w7.Q + ":qr=" + TextUtils.isEmpty(w7.O));
                    if (iH == -1 && TextUtils.isEmpty(w7.O)) {
                        return true;
                    }
                    if (iH == -1) {
                        return false;
                    }
                    Integer num = w7.P;
                    return num == null || num.intValue() == 0 || TextUtils.isEmpty(w7.O);
                }
            } catch (Exception e2) {
                Log.e("allowEditBill", "Error: " + e2.getMessage(), e2);
                return false;
            }
        }
        return true;
    }

    public static boolean h(Context context, Z00 z00, W7 w7) {
        Integer num;
        if (w7 != null) {
            try {
                if (w7.g.intValue() == 1 && z00.a != null && w7.g.intValue() == 1 && w7.a.longValue() > 0) {
                    info.aalmoghalis.inventory.zatca.c cVar = new info.aalmoghalis.inventory.zatca.c(context);
                    String strR = new d(context).r();
                    int iH = cVar.h(w7.i, strR + "");
                    C1839c10.z(z00, "Zatca=", "zz=" + iH + ":s=" + w7.P + ":zz=" + w7.Q + ":qr=" + TextUtils.isEmpty(w7.O));
                    if (iH != -1 && iH != -1 && ((num = w7.P) == null || num.intValue() <= 0 || TextUtils.isEmpty(w7.O))) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                Log.e("allowSendBill", "Error: " + e2.getMessage(), e2);
            }
        }
        return false;
    }

    public final String A(Date date, String str) {
        return new SimpleDateFormat(str, Locale.US).format(date);
    }

    public String D(String str) {
        try {
            NodeList elementsByTagNameNS = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(Base64.decode(str, 0))).getElementsByTagNameNS("urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2", "AdditionalDocumentReference");
            for (int i2 = 0; i2 < elementsByTagNameNS.getLength(); i2++) {
                Node nodeItem = elementsByTagNameNS.item(i2);
                if ("QR".equals(w(nodeItem, "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", "ID"))) {
                    String strX = x(nodeItem, "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", "EmbeddedDocumentBinaryObject");
                    if (!TextUtils.isEmpty(strX)) {
                        return strX;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public final /* synthetic */ void I(String str, JSONObject jSONObject, JSONObject jSONObject2, InterfaceC0322d interfaceC0322d) throws Throwable {
        try {
            f fVarS = s(str, jSONObject);
            if (fVarS.a == 401 && jSONObject2 != null) {
                if (!L(jSONObject2)) {
                    R(interfaceC0322d, "Invalid login");
                    return;
                }
                fVarS = s(str, jSONObject);
            }
            int i2 = fVarS.a;
            if (i2 >= 200 && i2 < 300) {
                k kVarP = P(fVarS.b);
                kVarP.a = true;
                V(interfaceC0322d, kVarP);
                return;
            }
            String strT = t(fVarS.b);
            if (TextUtils.isEmpty(strT)) {
                strT = "Request failed: " + fVarS.a;
            }
            R(interfaceC0322d, strT);
        } catch (Exception e2) {
            R(interfaceC0322d, e2.getMessage() == null ? "Network error" : e2.getMessage());
        }
    }

    public final /* synthetic */ void K(JSONObject jSONObject, JSONObject jSONObject2, InterfaceC0322d interfaceC0322d) throws Throwable {
        try {
            f fVarS = s("/api/invoices/create-and-submit", jSONObject);
            if (fVarS.a == 401 && jSONObject2 != null) {
                if (!L(jSONObject2)) {
                    e eVar = new e();
                    eVar.e = "Invalid login";
                    eVar.g.add("Invalid login");
                    T(interfaceC0322d, eVar);
                    return;
                }
                fVarS = s("/api/invoices/create-and-submit", jSONObject);
            }
            int i2 = fVarS.a;
            if (i2 >= 200 && i2 < 300) {
                e eVarO = O(fVarS.b);
                if (eVarO != null) {
                    T(interfaceC0322d, eVarO);
                    return;
                }
                e eVar2 = new e();
                eVar2.e = "Invalid response";
                eVar2.g.add("Invalid response");
                T(interfaceC0322d, eVar2);
                return;
            }
            c cVarN = N(fVarS.b);
            e eVar3 = new e();
            int i3 = cVarN.b;
            if (i3 <= 0) {
                i3 = fVarS.a;
            }
            eVar3.f = i3;
            eVar3.e = TextUtils.isEmpty(fVarS.b) ? "Request failed" : fVarS.b;
            eVar3.g.addAll(cVarN.d);
            if (eVar3.g.isEmpty()) {
                eVar3.g.add(t(fVarS.b));
            }
            T(interfaceC0322d, eVar3);
        } catch (Exception e2) {
            S(interfaceC0322d, e2.getMessage() == null ? "Network error" : e2.getMessage());
        }
    }

    public final boolean L(JSONObject jSONObject) throws Throwable {
        f fVarS = s("/api/auth/login", jSONObject);
        int i2 = fVarS.a;
        if (i2 < 200 || i2 >= 300) {
            return false;
        }
        p(fVarS.b);
        return true;
    }

    public final String M(String str) {
        if (TextUtils.isEmpty(str)) {
            return A(new Date(), "yyyy-MM-dd'T'HH:mm:ss");
        }
        String strTrim = str.replace("T", " ").trim();
        String[] strArr = {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd"};
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strArr[i2], Locale.US);
                simpleDateFormat.setLenient(false);
                Date date = simpleDateFormat.parse(strTrim);
                if (date != null) {
                    return A(date, "yyyy-MM-dd'T'HH:mm:ss");
                }
                continue;
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public final c N(String str) {
        JSONArray jSONArrayNames;
        c cVar = new c();
        if (TextUtils.isEmpty(str)) {
            return cVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("value");
            if (!TextUtils.isEmpty(strOptString) && strOptString.trim().startsWith("{")) {
                jSONObject = new JSONObject(strOptString);
            }
            cVar.a = z(jSONObject.optString("title"), jSONObject.optString("message"));
            cVar.b = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, 0);
            cVar.c = z(jSONObject.optString(HTML.Tag.DETAILS), str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("errors");
            if (jSONObjectOptJSONObject != null && (jSONArrayNames = jSONObjectOptJSONObject.names()) != null) {
                for (int i2 = 0; i2 < jSONArrayNames.length(); i2++) {
                    String strOptString2 = jSONArrayNames.optString(i2);
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(strOptString2);
                    if (jSONArrayOptJSONArray != null) {
                        for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                            cVar.d.add(strOptString2 + ": " + jSONArrayOptJSONArray.optString(i3));
                        }
                    }
                }
            }
        } catch (JSONException unused) {
            cVar.c = str;
        }
        return cVar;
    }

    public final e O(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            e eVar = new e();
            eVar.a = jSONObject.optLong("invoiceId", jSONObject.optLong("InvoiceId", 0L));
            eVar.b = z(jSONObject.optString("invoiceNo"), jSONObject.optString("InvoiceNo"));
            eVar.c = z(jSONObject.optString("uuid"), jSONObject.optString("Uuid"));
            eVar.d = z(jSONObject.optString("zatcaStatus"), jSONObject.optString("ZatcaStatus"));
            eVar.e = z(jSONObject.optString("validationStatus"), jSONObject.optString("ValidationStatus"));
            eVar.f = jSONObject.optInt("httpStatusCode", jSONObject.optInt("HttpStatusCode", 0));
            eVar.i = z(jSONObject.optString("icv"), jSONObject.optString("Icv"));
            eVar.j = z(jSONObject.optString("pih"), jSONObject.optString("Pih"));
            eVar.k = z(jSONObject.optString("qr"), jSONObject.optString("Qr"));
            eVar.l = z(jSONObject.optString("signedXml"), jSONObject.optString("SignedXml"));
            eVar.m = z(jSONObject.optString("invoiceHash"), jSONObject.optString("InvoiceHash"));
            eVar.n = z(jSONObject.optString("clearedInvoice"), jSONObject.optString("ClearedInvoice"));
            eVar.g = Q(jSONObject.optJSONArray("errors"), jSONObject.optJSONArray("Errors"));
            eVar.h = Q(jSONObject.optJSONArray("warnings"), jSONObject.optJSONArray("Warnings"));
            return eVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final k P(String str) {
        k kVar = new k();
        kVar.c = str;
        if (TextUtils.isEmpty(str)) {
            return kVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            kVar.b = z(jSONObject.optString("errorMessage"), jSONObject.optString("message"), jSONObject.optString("title"));
            kVar.d = z(jSONObject.optString("taxpayerId"), jSONObject.optString("taxerId"), jSONObject.optString("taxpayerID"));
            kVar.e = z(jSONObject.optString("egsUnitId"), jSONObject.optString("egsUnitID"), jSONObject.optString("unitId"));
            kVar.f = z(jSONObject.optString("certificateId"), jSONObject.optString("certId"), jSONObject.optString("certificateID"));
            kVar.g = jSONObject.optString("unitName");
        } catch (JSONException unused) {
            kVar.b = str;
        }
        return kVar;
    }

    public final List Q(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null) {
            jSONArray = jSONArray2;
        }
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.optString(i2));
        }
        return arrayList;
    }

    public final void R(final InterfaceC0322d interfaceC0322d, final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: e00
            @Override // java.lang.Runnable
            public final void run() {
                interfaceC0322d.onError(str);
            }
        });
    }

    public final void S(final InterfaceC0322d interfaceC0322d, final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: b00
            @Override // java.lang.Runnable
            public final void run() {
                interfaceC0322d.onError(str);
            }
        });
    }

    public final void T(final InterfaceC0322d interfaceC0322d, final e eVar) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: c00
            @Override // java.lang.Runnable
            public final void run() {
                interfaceC0322d.onSuccess(eVar);
            }
        });
    }

    public final void U(final String str, final JSONObject jSONObject, final JSONObject jSONObject2, final InterfaceC0322d interfaceC0322d) {
        this.b.execute(new Runnable() { // from class: d00
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.a.I(str, jSONObject, jSONObject2, interfaceC0322d);
            }
        });
    }

    public final void V(final InterfaceC0322d interfaceC0322d, final k kVar) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: f00
            @Override // java.lang.Runnable
            public final void run() {
                interfaceC0322d.onSuccess(kVar);
            }
        });
    }

    public final String W(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return sb.toString();
                }
                sb.append(line);
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public void X(l lVar, InterfaceC0322d interfaceC0322d) {
        lVar.f = r();
        U("/api/zatca/onboarding/restart-existing", l(lVar), k(lVar.a, lVar.b, lVar.c, lVar.d, lVar.e, lVar.f), interfaceC0322d);
    }

    public final Integer Z(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public final String a0(Long l2, String str, boolean z, String str2, String str3) {
        try {
            byte[] bArrDecode = Base64.decode(str3, 0);
            File file = new File(Z00.L, "Zatca");
            if (!file.exists() && !file.mkdirs()) {
                return "";
            }
            String str4 = "_" + Math.abs(new Random().nextInt());
            StringBuilder sb = new StringBuilder();
            sb.append(i0(String.valueOf(l2)));
            sb.append("_");
            sb.append(i0(str));
            sb.append(str4);
            sb.append(z ? "_CreditNote" : "");
            sb.append("_");
            sb.append(i0(str2));
            sb.append("_signed.xml");
            File file2 = new File(file, sb.toString());
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                fileOutputStream.write(bArrDecode);
                fileOutputStream.close();
                return file2.getAbsolutePath();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception unused) {
            return "";
        }
    }

    public void b0(j jVar, InterfaceC0322d interfaceC0322d) {
        jVar.r = r();
        U("/api/zatca/onboarding/start", m(jVar), null, interfaceC0322d);
    }

    public void c0(m mVar, InterfaceC0322d interfaceC0322d) {
        mVar.f = r();
        U("/api/zatca/onboarding/stop-existing", n(mVar), k(mVar.a, mVar.b, mVar.c, mVar.d, mVar.e, mVar.f), interfaceC0322d);
    }

    public void d0(i iVar, final InterfaceC0322d interfaceC0322d) {
        if (iVar == null || iVar.a == null) {
            S(interfaceC0322d, "Invoice payload is required");
            return;
        }
        iVar.e = r();
        final JSONObject jSONObjectJ = j(iVar.a);
        n nVar = iVar.a;
        final JSONObject jSONObjectK = k(nVar.a, nVar.b, iVar.b, iVar.c, iVar.d, iVar.e);
        this.b.execute(new Runnable() { // from class: a00
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.a.K(jSONObjectJ, jSONObjectK, interfaceC0322d);
            }
        });
    }

    public final boolean e0(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name=? LIMIT 1", new String[]{str});
            try {
                boolean zMoveToFirst = cursorRawQuery.moveToFirst();
                cursorRawQuery.close();
                return zMoveToFirst;
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception unused) {
            return false;
        }
    }

    public String f0(Z00 z00, W7 w7, e eVar, g gVar, double d, Integer num) {
        String strA0 = "";
        try {
            if (z00.a != null && w7 != null && eVar != null && gVar != null) {
                w7.O = eVar.k;
                w7.W = eVar.j;
                w7.V = eVar.c;
                w7.X = eVar.m;
                w7.R = num;
                w7.S = A(new Date(), "yyyy-MM-dd");
                w7.U = o(eVar);
                String str = eVar.n;
                w7.Y = str;
                if (!TextUtils.isEmpty(str)) {
                    String strD = D(eVar.n);
                    if (!TextUtils.isEmpty(strD)) {
                        w7.O = strD;
                    }
                }
                w7.T = String.valueOf(eVar.f);
                Integer numY = y(z00.a, eVar.d);
                if (numY != null) {
                    w7.P = numY;
                }
                w7.a0 = Double.valueOf(d);
                if (!TextUtils.isEmpty(eVar.l)) {
                    Long l2 = w7.a;
                    String str2 = w7.b;
                    Integer num2 = w7.h;
                    strA0 = a0(l2, str2, num2 != null && num2.intValue() == 1, gVar.g, eVar.l);
                    eVar.o = strA0;
                }
                w7.Z = strA0;
                w7.l(z00.a);
                Integer num3 = w7.Q;
                if (num3 != null) {
                    g0(z00.a, num3.intValue(), eVar.j, Z(eVar.i));
                }
            }
        } catch (Exception unused) {
        }
        return strA0;
    }

    public final void g0(SQLiteDatabase sQLiteDatabase, int i2, String str, Integer num) {
        if (sQLiteDatabase == null || !e0(sQLiteDatabase, "z_units")) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        if (q(sQLiteDatabase, "z_units", "pih")) {
            contentValues.put("pih", i0(str));
        }
        if (num != null && q(sQLiteDatabase, "z_units", "icv")) {
            contentValues.put("icv", num);
        }
        if (contentValues.size() == 0) {
            return;
        }
        sQLiteDatabase.update("z_units", contentValues, "id=?", new String[]{String.valueOf(i2)});
    }

    public final b h0(String str) {
        b bVar = new b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length != 5) {
            return bVar;
        }
        boolean z = false;
        bVar.b = strArrSplit[0].trim();
        bVar.c = strArrSplit[1].trim();
        bVar.d = strArrSplit[2].trim();
        bVar.e = strArrSplit[3].trim();
        bVar.f = strArrSplit[4].trim();
        if (bVar.b.matches("\\d{4}") && bVar.e.matches("\\d{5}") && !TextUtils.isEmpty(bVar.c) && !TextUtils.isEmpty(bVar.d) && !TextUtils.isEmpty(bVar.f)) {
            z = true;
        }
        bVar.a = z;
        return bVar;
    }

    public n i(g gVar, List list) {
        g gVar2 = gVar;
        String str = "SAR";
        String str2 = "";
        if (gVar2 == null) {
            return null;
        }
        try {
            info.aalmoghalis.inventory.zatca.e.g gVarE = this.d.e(i0(gVar2.a), r());
            if (gVarE == null) {
                return null;
            }
            List arrayList = list == null ? new ArrayList() : list;
            ArrayList arrayList2 = new ArrayList();
            double d = 0.0d;
            double d2 = 0.0d;
            double d3 = 0.0d;
            double d4 = 0.0d;
            double d5 = 0.0d;
            int i2 = 0;
            while (i2 < arrayList.size()) {
                try {
                    h hVar = (h) arrayList.get(i2);
                    String str3 = str;
                    String str4 = str2;
                    double d6 = hVar.b;
                    if (d6 == d) {
                        d6 = 1.0d;
                    }
                    double dY = Y(hVar.d / d6);
                    List list2 = arrayList;
                    o oVar = new o();
                    int i3 = i2 + 1;
                    oVar.a = String.valueOf(i3);
                    oVar.b = i0(hVar.a);
                    oVar.c = d6;
                    oVar.d = i0(hVar.c);
                    oVar.e = dY;
                    oVar.f = hVar.e;
                    oVar.g = hVar.g;
                    oVar.h = "S";
                    double d7 = hVar.d;
                    oVar.i = d7;
                    double d8 = hVar.f;
                    oVar.j = d8;
                    oVar.k = d7 + d8;
                    arrayList2.add(oVar);
                    double d9 = hVar.d;
                    double d10 = hVar.e;
                    double d11 = d3 + (d9 - d10);
                    d4 += hVar.f;
                    d5 += d10;
                    d2 += d9;
                    gVar2 = gVar;
                    i2 = i3;
                    str = str3;
                    str2 = str4;
                    arrayList = list2;
                    d3 = d11;
                    d = 0.0d;
                } catch (Exception unused) {
                    return null;
                }
            }
            String str5 = str;
            String str6 = str2;
            b bVarH0 = h0(gVar2.j);
            boolean zIsEmpty = TextUtils.isEmpty(i0(gVar2.i).trim());
            boolean z = bVarH0.a && !zIsEmpty;
            String strM = M(gVar2.c);
            String strU = u(strM);
            n nVar = new n();
            nVar.a = i0(gVarE.l);
            nVar.b = i0(gVarE.m);
            nVar.c = i0(gVar2.b);
            nVar.d = UUID.randomUUID().toString();
            nVar.e = !zIsEmpty ? "standard" : "simplified";
            nVar.f = strM;
            nVar.g = v(gVar2.d, str5);
            nVar.h = str5;
            Double d12 = gVar2.e;
            nVar.K = Double.valueOf(d12 == null ? 0.0d : d12.doubleValue());
            nVar.i = i0(gVar2.f);
            nVar.j = i0(gVar2.g);
            nVar.k = str6;
            nVar.l = str6;
            nVar.m = str6;
            nVar.n = str6;
            nVar.o = str6;
            nVar.p = i0(gVar2.h);
            nVar.q = i0(gVar2.i);
            nVar.r = z ? bVarH0.c : str6;
            nVar.s = z ? bVarH0.b : str6;
            nVar.t = z ? bVarH0.d : str6;
            nVar.u = z ? bVarH0.f : str6;
            nVar.v = z ? bVarH0.e : str6;
            nVar.w = "SA";
            nVar.x = strU;
            nVar.y = d2;
            nVar.z = d3;
            double d13 = d3 + d4;
            nVar.A = d13;
            nVar.B = d13;
            nVar.C = d4;
            nVar.D = Double.valueOf(d5);
            nVar.E = str6;
            nVar.F = String.valueOf(Math.max(gVarE.j + 1, 1));
            nVar.G = str6;
            nVar.H = gVar2.k ? 1 : 0;
            nVar.I = i0(gVar2.l);
            nVar.J = i0(gVar2.m);
            nVar.L = arrayList2;
            return nVar;
        } catch (Exception unused2) {
            return null;
        }
    }

    public final String i0(String str) {
        return str == null ? "" : str;
    }

    public final JSONObject j(n nVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("taxpayerId", nVar.a);
            jSONObject.put("egsUnitId", nVar.b);
            jSONObject.put("invoiceNo", nVar.c);
            jSONObject.put("uuid", nVar.d);
            jSONObject.put("invoiceType", nVar.e);
            jSONObject.put("invoiceDateTime", nVar.f);
            jSONObject.put("currencyCode", nVar.g);
            jSONObject.put("taxCurrencyCode", nVar.h);
            jSONObject.put("sellerName", nVar.i);
            jSONObject.put("vatNumber", nVar.j);
            jSONObject.put("sellerStreet", i0(nVar.k));
            jSONObject.put("sellerBuildingNumber", i0(nVar.l));
            jSONObject.put("sellerDistrict", i0(nVar.m));
            jSONObject.put("sellerCity", i0(nVar.n));
            jSONObject.put("sellerPostalCode", i0(nVar.o));
            jSONObject.put("buyerName", i0(nVar.p));
            jSONObject.put("buyerVatNumber", i0(nVar.q));
            jSONObject.put("buyerStreet", i0(nVar.r));
            jSONObject.put("buyerBuildingNumber", i0(nVar.s));
            jSONObject.put("buyerDistrict", i0(nVar.t));
            jSONObject.put("buyerCity", i0(nVar.u));
            jSONObject.put("buyerPostalCode", i0(nVar.v));
            jSONObject.put("buyerCountryCode", i0(nVar.w));
            jSONObject.put("supplyDate", nVar.x);
            jSONObject.put("lineExtensionAmount", nVar.y);
            jSONObject.put("taxExclusiveAmount", nVar.z);
            jSONObject.put("taxInclusiveAmount", nVar.A);
            jSONObject.put("payableAmount", nVar.B);
            jSONObject.put("vatAmount", nVar.C);
            Object obj = nVar.D;
            if (obj == null) {
                obj = JSONObject.NULL;
            }
            jSONObject.put("AllowanceAmount", obj);
            jSONObject.put("qrPlaceholder", i0(nVar.E));
            jSONObject.put("icv", i0(nVar.F));
            jSONObject.put("pihBase64", i0(nVar.G));
            jSONObject.put("is_back", nVar.H);
            jSONObject.put("reasonText", i0(nVar.I));
            jSONObject.put("originalInvoiceId", i0(nVar.J));
            Object obj2 = nVar.K;
            if (obj2 == null) {
                obj2 = JSONObject.NULL;
            }
            jSONObject.put("currencyRate", obj2);
            JSONArray jSONArray = new JSONArray();
            for (o oVar : nVar.L) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("lineId", oVar.a);
                jSONObject2.put("itemName", oVar.b);
                jSONObject2.put("quantity", oVar.c);
                jSONObject2.put("unitCode", oVar.d);
                jSONObject2.put("unitPrice", oVar.e);
                jSONObject2.put("discountAmount", oVar.f);
                jSONObject2.put("taxPercent", oVar.g);
                jSONObject2.put("taxCategoryId", oVar.h);
                jSONObject2.put("lineExtensionAmount", oVar.i);
                jSONObject2.put("taxAmount", oVar.j);
                jSONObject2.put("lineTotalWithVat", oVar.k);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("lines", jSONArray);
            return jSONObject;
        } catch (JSONException e2) {
            throw new IllegalStateException("Failed to build invoice payload", e2);
        }
    }

    public final JSONObject k(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("taxerId", str);
                jSONObject.put("egsId", str2);
                jSONObject.put("certId", str3);
                jSONObject.put("otp", str4);
                jSONObject.put("vat_number", str5);
                jSONObject.put("deviceId", str6);
                jSONObject.put("email", Z00.T);
                return jSONObject;
            } catch (JSONException e2) {
                throw new IllegalStateException("Failed to build login payload", e2);
            }
        }
        Log.d("Zatac", "LogIn:Error1:t=" + str + ":u=" + str2 + ":c=" + str3 + ":o=" + str4 + ":v=" + str5 + ":" + str6);
        return null;
    }

    public final JSONObject l(l lVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("taxpayerId", lVar.a);
            jSONObject.put("egsUnitId", lVar.b);
            jSONObject.put("certificateId", lVar.c);
            jSONObject.put("otp", lVar.d);
            jSONObject.put("device_id", lVar.f);
            return jSONObject;
        } catch (JSONException e2) {
            throw new IllegalStateException("Failed to build restart payload", e2);
        }
    }

    public final JSONObject m(j jVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vatNumber", jVar.a);
            jSONObject.put("crNumber", jVar.b);
            jSONObject.put("commonName", jVar.c);
            jSONObject.put("companyName", jVar.d);
            jSONObject.put("unitName", jVar.e);
            jSONObject.put("egsSerialNumber", i0(jVar.f));
            jSONObject.put("countryCode", jVar.g);
            jSONObject.put("registeredAddress", jVar.h);
            jSONObject.put("industry", jVar.i);
            jSONObject.put("businessCategory", jVar.j);
            jSONObject.put("city", jVar.k);
            jSONObject.put("addressLine1", jVar.l);
            jSONObject.put("addressLine2", jVar.m);
            jSONObject.put(HintConstants.AUTOFILL_HINT_POSTAL_CODE, jVar.n);
            jSONObject.put("location", jVar.o);
            jSONObject.put("environment_Type", jVar.p);
            jSONObject.put("otp", jVar.q);
            jSONObject.put("device_id", jVar.r);
            jSONObject.put("email", jVar.s);
            return jSONObject;
        } catch (JSONException e2) {
            throw new IllegalStateException("Failed to build onboarding payload", e2);
        }
    }

    public final JSONObject n(m mVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("taxpayerId", mVar.a);
            jSONObject.put("egsUnitId", mVar.b);
            jSONObject.put("certificateId", mVar.c);
            jSONObject.put("device_id", mVar.f);
            return jSONObject;
        } catch (JSONException e2) {
            throw new IllegalStateException("Failed to build stop payload", e2);
        }
    }

    public final String o(e eVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(i0(eVar.d));
        sb.append("|");
        sb.append(i0(eVar.e));
        for (String str : eVar.g) {
            sb.append("|Error:");
            sb.append(i0(str));
        }
        for (String str2 : eVar.h) {
            sb.append("|Warning:");
            sb.append(i0(str2));
        }
        return sb.toString();
    }

    public final void p(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.c = z(jSONObject.optString("token"), jSONObject.optString("accessToken"), jSONObject.optString("jwt"), jSONObject.optString("access_token"));
        } catch (JSONException unused) {
        }
    }

    public final boolean q(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("PRAGMA table_info(" + str + ")", null);
            while (cursorRawQuery.moveToNext()) {
                try {
                    int columnIndex = cursorRawQuery.getColumnIndex("name");
                    if (columnIndex >= 0 && str2.equalsIgnoreCase(cursorRawQuery.getString(columnIndex))) {
                        cursorRawQuery.close();
                        return true;
                    }
                } catch (Throwable th) {
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            cursorRawQuery.close();
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public String r() {
        SharedPreferences sharedPreferences = this.a.getSharedPreferences("zatca_service_prefs", 0);
        String string = sharedPreferences.getString("device_id", "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        sharedPreferences.edit().putString("device_id", string2).apply();
        return string2;
    }

    public final f s(String str, JSONObject jSONObject) throws Throwable {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL("https://bkp2.dyndns.org:5002" + str).openConnection();
            try {
                httpURLConnection2.setRequestMethod(HttpMethods.POST);
                httpURLConnection2.setConnectTimeout(15000);
                httpURLConnection2.setReadTimeout(25000);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestProperty(HttpHeaders.CONTENT_TYPE, Json.MEDIA_TYPE);
                httpURLConnection2.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
                if (!TextUtils.isEmpty(this.c)) {
                    httpURLConnection2.setRequestProperty(HttpHeaders.AUTHORIZATION, "Bearer " + this.c);
                }
                byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                try {
                    outputStream.write(bytes);
                    outputStream.close();
                    int responseCode = httpURLConnection2.getResponseCode();
                    f fVar = new f(responseCode, W((responseCode < 200 || responseCode >= 300) ? httpURLConnection2.getErrorStream() : httpURLConnection2.getInputStream()));
                    httpURLConnection2.disconnect();
                    return fVar;
                } catch (Throwable th) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final String t(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return z(jSONObject.optString("errorMessage"), jSONObject.optString("message"), jSONObject.optString("title"), str);
        } catch (JSONException unused) {
            return str;
        }
    }

    public final String u(String str) {
        if (TextUtils.isEmpty(str)) {
            return A(new Date(), "yyyy-MM-dd");
        }
        int iIndexOf = str.indexOf(84);
        if (iIndexOf > 0) {
            return str.substring(0, iIndexOf);
        }
        return str.length() >= 10 ? str.substring(0, 10) : str;
    }

    public final String v(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public final String w(Node node, String str, String str2) {
        if (node != null && node.hasChildNodes()) {
            NodeList childNodes = node.getChildNodes();
            for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                Node nodeItem = childNodes.item(i2);
                if (str2.equals(nodeItem.getLocalName()) && str.equals(nodeItem.getNamespaceURI())) {
                    return nodeItem.getTextContent();
                }
            }
        }
        return "";
    }

    public final String x(Node node, String str, String str2) {
        if (node == null) {
            return "";
        }
        if (str2.equals(node.getLocalName()) && str.equals(node.getNamespaceURI())) {
            return node.getTextContent();
        }
        NodeList childNodes = node.getChildNodes();
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            String strX = x(childNodes.item(i2), str, str2);
            if (!TextUtils.isEmpty(strX)) {
                return strX;
            }
        }
        return "";
    }

    public final Integer y(SQLiteDatabase sQLiteDatabase, String str) {
        if (sQLiteDatabase != null && !TextUtils.isEmpty(str) && e0(sQLiteDatabase, "z_status")) {
            try {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT id FROM z_status WHERE LOWER(name) = LOWER(?) LIMIT 1", new String[]{str});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        cursorRawQuery.close();
                        return null;
                    }
                    Integer numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                    cursorRawQuery.close();
                    return numValueOf;
                } catch (Throwable th) {
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final String z(String... strArr) {
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }
}
