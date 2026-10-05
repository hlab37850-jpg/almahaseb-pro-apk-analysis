package defpackage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: hr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2393hr {
    public String a;
    public String[] b;
    public long c;
    public long d;

    public C2393hr(String str) {
        this(new JSONObject(str));
    }

    public C2393hr(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("upgrades");
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArray.getString(i);
        }
        this.a = jSONObject.getString("sid");
        this.b = strArr;
        this.c = jSONObject.getLong("pingInterval");
        this.d = jSONObject.getLong("pingTimeout");
    }
}
