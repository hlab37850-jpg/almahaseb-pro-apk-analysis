package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import com.zebra.sdk.util.internal.StringUtilities;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.Bill_adj;
import info.aalmoghalis.inventory.activity.Bill_adj2;
import info.aalmoghalis.inventory.activity.Bill_edit;
import info.aalmoghalis.inventory.activity.Bill_inv;
import info.aalmoghalis.inventory.activity.Bill_move;
import info.aalmoghalis.inventory.activity.Google_drive_list;
import info.aalmoghalis.inventory.activity.Offer_edit;
import info.aalmoghalis.inventory.activity.Order_edit;
import info.aalmoghalis.inventory.activity.item_price_exp;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: f10, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2160f10 {
    public static ArrayList g = new ArrayList();
    public static int h = -1;
    public static int i = 0;
    public static int j = -3;
    public static String k = "";
    public static int l = 100;
    public static int m = 5;
    public static int n = 20;
    public Dialog a;
    public Activity b;
    public Z00 c;
    public g d;
    public List e;
    public Context f;

    /* JADX INFO: renamed from: f10$a */
    public class a implements DL.b {
        public final /* synthetic */ Handler a;
        public final /* synthetic */ String b;

        public a(Handler handler, String str) {
            this.a = handler;
            this.b = str;
        }

        @Override // DL.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            try {
                Message message = new Message();
                message.obj = "20";
                Handler handler = this.a;
                if (handler != null) {
                    handler.sendMessage(message);
                }
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getBoolean("error")) {
                    return;
                }
                int i = Integer.parseInt(jSONObject.getString("error_type"));
                String string = jSONObject.getString("error_msg");
                long j = jSONObject.getLong("expire_time");
                int i2 = Integer.parseInt(jSONObject.getString("reset_check"));
                int i3 = Integer.parseInt(jSONObject.getString("user_id"));
                if ((i == 2 || i == 5 || i == 3) && i2 > 0) {
                    Calendar.getInstance().getTimeInMillis();
                    C2160f10.this.c.Lc("reset_user_id", this.b);
                    C2160f10.this.c.Lc("reset_expire", j + "");
                    C2160f10.this.c.Lc("reset_check", i2 + "");
                } else {
                    C2160f10.this.a0();
                }
                if (C2160f10.this.d != null) {
                    C2160f10.this.d.d(i3, i, string);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: f10$b */
    public class b implements DL.a {
        public final /* synthetic */ Handler a;

        public b(Handler handler) {
            this.a = handler;
        }

        @Override // DL.a
        public void a(C2119eY c2119eY) {
            Message message = new Message();
            message.obj = "20";
            Handler handler = this.a;
            if (handler != null) {
                handler.sendMessage(message);
            }
        }
    }

    /* JADX INFO: renamed from: f10$c */
    public class c extends C2441iS {
        public final /* synthetic */ String t;
        public final /* synthetic */ String u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i, String str, DL.b bVar, DL.a aVar, String str2, String str3) {
            super(i, str, bVar, aVar);
            this.t = str2;
            this.u = str3;
        }

        @Override // defpackage.AbstractC3712qL
        public String i() {
            return "application/x-www-form-urlencoded; charset=UTF-8";
        }

        @Override // defpackage.AbstractC3712qL
        public Map n() {
            HashMap map = new HashMap();
            map.put("user_id", this.t);
            map.put("app_id", "1");
            map.put("imei", C2160f10.this.c.ia("PREF_ACCOUNT_NAME", "0"));
            map.put(NotificationCompat.CATEGORY_STATUS, this.u);
            map.put("aid", Z00.R);
            return map;
        }
    }

    /* JADX INFO: renamed from: f10$f */
    public class f implements View.OnClickListener {
        public final /* synthetic */ C3172jj a;
        public final /* synthetic */ int b;
        public final /* synthetic */ EditText c;
        public final /* synthetic */ AlertDialog d;

        public f(C3172jj c3172jj, int i, EditText editText, AlertDialog alertDialog) {
            this.a = c3172jj;
            this.b = i;
            this.c = editText;
            this.d = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AbstractC4371yX.a(this.a.b)) {
                if (this.b >= 0) {
                    String strK = C2160f10.this.c.K("update users set pwd='" + C2160f10.this.f(this.a.b.getText().toString()) + "' where id= " + this.b);
                    if (strK == null || !strK.equals("1")) {
                        Activity activity = C2160f10.this.b;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Error:");
                        if (strK != null && strK.length() > 20) {
                            strK = strK.substring(0, 20);
                        }
                        sb.append(strK);
                        Toast.makeText(activity, sb.toString(), 0).show();
                        return;
                    }
                } else {
                    C2160f10.this.c.Lc("prefPassword", this.a.b.getText().toString());
                    Z00.W = this.a.b.getText().toString();
                }
                this.c.setText(this.a.b.getText().toString());
                Activity activity2 = C2160f10.this.b;
                Toast.makeText(activity2, activity2.getString(R.string.change_pwd_done), 0).show();
                this.d.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: f10$g */
    public interface g {
        void d(int i, int i2, String str);
    }

    public C2160f10() {
        this.a = null;
        this.d = null;
        this.e = new ArrayList();
    }

    public static String F(Z00 z00) {
        if (z00.ia("online_dev_id", "").equals("")) {
            String str = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(new Date());
            z00.Lc("online_dev_id", str);
            z00.v0("update sys_conf set value_='" + str + "' where id=100");
        }
        return z00.ia("online_dev_id", "");
    }

    public static ArrayList H(Z00 z00, String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = z00.a.rawQuery(str, null);
        cursorRawQuery.moveToFirst();
        while (!cursorRawQuery.isAfterLast()) {
            HashMap map = new HashMap();
            for (int i2 = 0; i2 < cursorRawQuery.getColumnCount(); i2++) {
                map.put(cursorRawQuery.getColumnName(i2), cursorRawQuery.getString(i2));
            }
            arrayList.add(map);
            cursorRawQuery.moveToNext();
        }
        cursorRawQuery.close();
        return arrayList;
    }

    public static JSONObject O(HashMap map) {
        try {
            return new JSONObject(new Gson().toJson(map));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static List Q(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            Object objR = jSONArray.get(i2);
            if (objR instanceof JSONArray) {
                objR = Q((JSONArray) objR);
            } else if (objR instanceof JSONObject) {
                objR = R((JSONObject) objR);
            }
            arrayList.add(objR);
        }
        return arrayList;
    }

    public static Map R(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objR = jSONObject.get(next);
            if (objR instanceof JSONArray) {
                objR = Q((JSONArray) objR);
            } else if (objR instanceof JSONObject) {
                objR = R((JSONObject) objR);
            }
            map.put(next, objR);
        }
        return map;
    }

    public static /* synthetic */ void S(AutoCompleteTextView autoCompleteTextView, Activity activity) {
        U(activity, autoCompleteTextView.getText().toString().trim());
    }

    public static /* synthetic */ boolean T(final AutoCompleteTextView autoCompleteTextView, List list, final Activity activity, int i2, TextView textView, int i3, KeyEvent keyEvent) {
        if (keyEvent != null && keyEvent.getAction() != 1) {
            return true;
        }
        String strTrim = autoCompleteTextView.getText().toString().trim();
        autoCompleteTextView.dismissDropDown();
        C4145vh c4145vhS = s(list, strTrim);
        if (c4145vhS != null) {
            autoCompleteTextView.setText((CharSequence) c4145vhS.a(), false);
            autoCompleteTextView.setSelection(autoCompleteTextView.length());
            Y(activity, i2, c4145vhS);
        } else if (strTrim.length() > 0) {
            autoCompleteTextView.postDelayed(new Runnable() { // from class: e10
                @Override // java.lang.Runnable
                public final void run() {
                    C2160f10.S(autoCompleteTextView, activity);
                }
            }, 500L);
        }
        return true;
    }

    public static void U(Activity activity, String str) {
        if (str.isEmpty() || str.length() == 0) {
            return;
        }
        if (activity instanceof Bill_edit) {
            ((Bill_edit) activity).N1(str);
            return;
        }
        if (activity instanceof Bill_adj) {
            ((Bill_adj) activity).D0(str);
            return;
        }
        if (activity instanceof Bill_adj2) {
            ((Bill_adj2) activity).J1(str);
            return;
        }
        if (activity instanceof Bill_move) {
            ((Bill_move) activity).u0(str);
            return;
        }
        if (activity instanceof Bill_inv) {
            ((Bill_inv) activity).t0(str);
            return;
        }
        if (activity instanceof Offer_edit) {
            ((Offer_edit) activity).A1(str);
        } else if (activity instanceof Order_edit) {
            ((Order_edit) activity).x1(str);
        } else if (activity instanceof item_price_exp) {
            ((item_price_exp) activity).b0(str);
        }
    }

    public static String X(String str) {
        return str == null ? "" : str;
    }

    public static void Y(Activity activity, int i2, C4145vh c4145vh) {
        if (activity instanceof Bill_edit) {
            if (i2 == 1) {
                ((Bill_edit) activity).t1(c4145vh.a());
                return;
            } else {
                if (i2 == 2) {
                    ((Bill_edit) activity).u1(c4145vh.a());
                    return;
                }
                return;
            }
        }
        if (activity instanceof Bill_adj) {
            if (i2 == 1) {
                ((Bill_adj) activity).w0(c4145vh.a());
                return;
            } else {
                if (i2 == 2) {
                    ((Bill_adj) activity).x0(c4145vh.a());
                    return;
                }
                return;
            }
        }
        if (activity instanceof Bill_adj2) {
            if (i2 == 1) {
                ((Bill_adj2) activity).q1(c4145vh.a());
                return;
            } else {
                if (i2 == 2) {
                    ((Bill_adj2) activity).r1(c4145vh.a());
                    return;
                }
                return;
            }
        }
        if (activity instanceof Bill_move) {
            if (i2 == 1) {
                ((Bill_move) activity).n0(c4145vh.a());
                return;
            } else {
                if (i2 == 2) {
                    ((Bill_move) activity).o0(c4145vh.a());
                    return;
                }
                return;
            }
        }
        if (activity instanceof Bill_inv) {
            if (i2 == 1) {
                ((Bill_inv) activity).m0(c4145vh.a());
                return;
            } else {
                if (i2 == 2) {
                    ((Bill_inv) activity).n0(c4145vh.a());
                    return;
                }
                return;
            }
        }
        if (activity instanceof Offer_edit) {
            if (i2 == 1) {
                ((Offer_edit) activity).i1(c4145vh.a());
                return;
            } else {
                if (i2 == 2) {
                    ((Offer_edit) activity).j1(c4145vh.a());
                    return;
                }
                return;
            }
        }
        if (!(activity instanceof Order_edit)) {
            if ((activity instanceof item_price_exp) && i2 == 1) {
                ((item_price_exp) activity).V(c4145vh.a());
                return;
            }
            return;
        }
        if (i2 == 1) {
            ((Order_edit) activity).h1(c4145vh.a());
        } else if (i2 == 2) {
            ((Order_edit) activity).i1(c4145vh.a());
        }
    }

    public static void c0(final Activity activity, final AutoCompleteTextView autoCompleteTextView, final List list, final int i2) {
        autoCompleteTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: d10
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                return C2160f10.T(autoCompleteTextView, list, activity, i2, textView, i3, keyEvent);
            }
        });
    }

    public static boolean p(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.toUpperCase().contains(str.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean q(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.toUpperCase().equals(str.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public static C4145vh s(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C4145vh c4145vh = (C4145vh) it.next();
            String str2 = c4145vh.d;
            if (str2 != null && str2.equals(str)) {
                return c4145vh;
            }
        }
        return null;
    }

    public static String z(String str) {
        return new SimpleDateFormat(str, Locale.ENGLISH).format(Calendar.getInstance().getTime());
    }

    public double[] A(String str, String str2, String str3, int i2, int i3, int i4, String str4) {
        String str5;
        String str6;
        Cursor cursorRawQuery;
        Log.d("Inputs=", str + ":" + str2 + ":" + str3 + ":" + i2 + ":" + i3 + ":" + str4);
        String str7 = "";
        String strReplace = str4.replace("'", "");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT a.tr_type tr_type ,  sum(out*(case when p_curr_price=0 then 1 else p_curr_price end ))  f13 from transactions_v a   where  a.bill_id=-3 and a.[in]=1 ");
        String str8 = " ";
        if (str == null || str.equals("") || str.equals("0") || str.equals("-3")) {
            str5 = " ";
        } else {
            str5 = " and a.cash_id=" + str;
        }
        sb.append(str5);
        if (h > 0) {
            str6 = " and a.user_id= " + h;
        } else {
            str6 = " ";
        }
        sb.append(str6);
        if (Z00.y0) {
            str8 = " and (a.tr_type,a.p_ref_no) in(" + Z00.z0 + ") ";
        }
        sb.append(str8);
        if (i4 != 0) {
            str7 = " and  ( a.p_ref_no||'|'||a.p_date||'|'|| a.p_remarks ||'|'||(select h.name from currency h where h.id=a.p_curr_id)||'|'|| (case when a.user_id is null then '' else (select name from users where id=a.user_id) end) ||'|'||(select h.name from tran_type h where h.id=a.tr_type)||'-'||(select h.name from customers h where h.id=a.cash_id)||'|'||(case when a.[in]=1 then ((a.[in]*out*(case when curr_price=0 then 1 else curr_price end )/(case when p_curr_price=0 then 1 else p_curr_price end ))) else 0 end ) like '%" + strReplace + "%') ";
        }
        sb.append(str7);
        String string = sb.toString();
        if (str2.equals(CSS.Value.PERCENTAGE) && str3.equals(CSS.Value.PERCENTAGE)) {
            Log.d("SQL=", string + "     group by a.tr_type ");
            cursorRawQuery = this.c.a.rawQuery(string + "     group by a.tr_type ", null);
        } else if (str2.equals(CSS.Value.PERCENTAGE) && !str3.equals(CSS.Value.PERCENTAGE)) {
            cursorRawQuery = this.c.a.rawQuery(string + "  and date(strftime('%Y-%m-%d',substr(a.p_date,7,4)||'-' ||substr(a.p_date,4,2)||'-'||substr(a.p_date,1,2) )) <= ?   group by a.tr_type ", new String[]{str3});
        } else if (str2.equals(CSS.Value.PERCENTAGE) || !str3.equals(CSS.Value.PERCENTAGE)) {
            cursorRawQuery = this.c.a.rawQuery(string + "   and date(strftime('%Y-%m-%d',substr(a.p_date,7,4)||'-' ||substr(a.p_date,4,2)||'-'||substr(a.p_date,1,2) )) between ? and ?  group by a.tr_type ", new String[]{str2, str3});
        } else {
            cursorRawQuery = this.c.a.rawQuery(string + "    and date(strftime('%Y-%m-%d',substr(a.p_date,7,4)||'-' ||substr(a.p_date,4,2)||'-'||substr(a.p_date,1,2) )) >= ?   group by a.tr_type ", new String[]{str2});
        }
        double[] dArr = {0.0d, 0.0d};
        cursorRawQuery.moveToFirst();
        while (!cursorRawQuery.isAfterLast()) {
            if (cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("tr_type")) == 5) {
                dArr[0] = cursorRawQuery.getDouble(cursorRawQuery.getColumnIndex("f13"));
            } else if (cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("tr_type")) == 6) {
                dArr[1] = cursorRawQuery.getDouble(cursorRawQuery.getColumnIndex("f13"));
            }
            cursorRawQuery.moveToNext();
        }
        cursorRawQuery.close();
        return dArr;
    }

    public double B(String str, String str2, int i2, int i3, int i4, String str3) {
        String str4;
        String str5;
        Cursor cursorRawQuery;
        Log.d("Inputs=", str + ":" + str2 + ":" + i2 + ":" + i3 + ":" + str3);
        String str6 = "";
        String strReplace = str3.replace("'", "");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT  sum(out*(case when p_curr_price=0 then 1 else p_curr_price end ))  f13 from transactions_v a   where  a.bill_id=-2 and a.[in]=1 ");
        if (h > 0) {
            str4 = " and a.user_id= " + h;
        } else {
            str4 = " ";
        }
        sb.append(str4);
        if (Z00.w0) {
            str5 = " and (a.tr_type,a.p_ref_no) in(" + Z00.x0 + ") ";
        } else {
            str5 = " ";
        }
        sb.append(str5);
        if (i4 != 0) {
            str6 = " and  ( ifnull(a.p_ref_no,'') ||'|'||a.date_||'|'|| ifnull(a.p_remarks,'') ||'|'||(select h.name from currency h where h.id=a.p_curr_id)||'|'|| (case when a.user_id is null then '' else (select name from users where id=a.user_id) end) ||'|'||(case when a.[in]=1 then ((a.[in]*out*(case when curr_price=0 then 1 else curr_price end )/(case when p_curr_price=0 then 1 else p_curr_price end ))) else 0 end ) like '%" + strReplace + "%') ";
        }
        sb.append(str6);
        String string = sb.toString();
        if (str.equals(CSS.Value.PERCENTAGE) && str2.equals(CSS.Value.PERCENTAGE)) {
            cursorRawQuery = this.c.a.rawQuery(string + "     ", null);
        } else if (str.equals(CSS.Value.PERCENTAGE) && !str2.equals(CSS.Value.PERCENTAGE)) {
            cursorRawQuery = this.c.a.rawQuery(string + "  and date(strftime('%Y-%m-%d',substr(a.p_date,7,4)||'-' ||substr(a.p_date,4,2)||'-'||substr(a.p_date,1,2) )) <= ?   ", new String[]{str2});
        } else if (str.equals(CSS.Value.PERCENTAGE) || !str2.equals(CSS.Value.PERCENTAGE)) {
            cursorRawQuery = this.c.a.rawQuery(string + "   and date(strftime('%Y-%m-%d',substr(a.p_date,7,4)||'-' ||substr(a.p_date,4,2)||'-'||substr(a.p_date,1,2) )) between ? and ?  ", new String[]{str, str2});
        } else {
            cursorRawQuery = this.c.a.rawQuery(string + "    and date(strftime('%Y-%m-%d',substr(a.p_date,7,4)||'-' ||substr(a.p_date,4,2)||'-'||substr(a.p_date,1,2) )) >= ?   ", new String[]{str});
        }
        cursorRawQuery.moveToFirst();
        double d2 = 0.0d;
        while (!cursorRawQuery.isAfterLast()) {
            d2 = cursorRawQuery.getDouble(cursorRawQuery.getColumnIndex("f13"));
            cursorRawQuery.moveToNext();
        }
        cursorRawQuery.close();
        return d2;
    }

    public String C(String str, String[] strArr) {
        C1839c10.o(this.c);
        JSONArray jSONArray = new JSONArray();
        Cursor cursorRawQuery = this.c.a.rawQuery(str, null);
        cursorRawQuery.moveToFirst();
        while (!cursorRawQuery.isAfterLast()) {
            JSONObject jSONObject = new JSONObject();
            int columnCount = cursorRawQuery.getColumnCount();
            for (int i2 = 0; i2 < columnCount; i2++) {
                if (cursorRawQuery.getColumnName(i2) != null) {
                    try {
                        if (cursorRawQuery.getString(i2) == null) {
                            jSONObject.put(cursorRawQuery.getColumnName(i2), "null");
                        } else if (!t(strArr, cursorRawQuery.getColumnName(i2))) {
                            int type = cursorRawQuery.getType(i2);
                            if (type == 0) {
                                jSONObject.put(cursorRawQuery.getColumnName(i2), (Object) null);
                            } else if (type == 1) {
                                jSONObject.put(cursorRawQuery.getColumnName(i2), cursorRawQuery.getLong(i2));
                            } else if (type == 2) {
                                jSONObject.put(cursorRawQuery.getColumnName(i2), cursorRawQuery.getDouble(i2));
                            } else if (type == 3) {
                                jSONObject.put(cursorRawQuery.getColumnName(i2), this.c.da(cursorRawQuery.getString(i2)) ? Double.valueOf(cursorRawQuery.getDouble(i2)) : cursorRawQuery.getString(i2));
                            } else if (type == 4) {
                                jSONObject.put(cursorRawQuery.getColumnName(i2), cursorRawQuery.getBlob(i2));
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            jSONArray.put(jSONObject);
            cursorRawQuery.moveToNext();
        }
        cursorRawQuery.close();
        str.contains(" items ");
        return jSONArray.toString().replace("^", "-");
    }

    public JSONArray D(String str) {
        JSONArray jSONArray = new JSONArray();
        Cursor cursorRawQuery = this.c.a.rawQuery(str, null);
        cursorRawQuery.moveToFirst();
        while (!cursorRawQuery.isAfterLast()) {
            JSONObject jSONObject = new JSONObject();
            int columnCount = cursorRawQuery.getColumnCount();
            for (int i2 = 0; i2 < columnCount; i2++) {
                if (cursorRawQuery.getColumnName(i2) != null) {
                    try {
                        if (cursorRawQuery.getString(i2) != null) {
                            jSONObject.put(cursorRawQuery.getColumnName(i2), cursorRawQuery.getString(i2));
                        } else {
                            jSONObject.put(cursorRawQuery.getColumnName(i2), "null");
                        }
                    } catch (Exception e2) {
                        Log.d("TAG_NAME", e2.getMessage() + ":");
                        e2.printStackTrace();
                    }
                }
            }
            jSONArray.put(jSONObject);
            cursorRawQuery.moveToNext();
        }
        cursorRawQuery.close();
        str.contains(" items ");
        return jSONArray;
    }

    public ArrayList E(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = this.c.a.rawQuery(str, null);
        cursorRawQuery.moveToFirst();
        while (!cursorRawQuery.isAfterLast()) {
            arrayList.add(cursorRawQuery.getString(0));
            cursorRawQuery.moveToNext();
        }
        cursorRawQuery.close();
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.google.api.services.drive.Drive$Files$List] */
    public List G(String str, Drive drive) {
        ArrayList arrayList = new ArrayList();
        String nextPageToken = null;
        do {
            FileList fileListExecute = drive.files().list().setQ("mimeType='application/vnd.google-apps.folder' and name contains '" + str + "'").setSpaces("drive").setFields2("nextPageToken, files(id, name)").setPageToken(nextPageToken).execute();
            Iterator<File> it = fileListExecute.getFiles().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getId());
            }
            nextPageToken = fileListExecute.getNextPageToken();
        } while (nextPageToken != null);
        return arrayList;
    }

    public String I(String str) {
        return this.c.X4("select  ifnull(substr( a.online_ref2, instr(a.online_ref2, ':')),'0') as _id from transactions_v a where a.id=" + str);
    }

    public double J(String str, String str2) {
        double d2;
        double d3;
        double d4;
        double d5 = 0.0d;
        try {
            Cursor cursorW8 = this.c.W8(str, str2);
            cursorW8.moveToFirst();
            while (!cursorW8.isAfterLast()) {
                if (cursorW8.getString(cursorW8.getColumnIndex("f5")).equals("2")) {
                    if (this.c.ja("pref_trail_balance_old_balance", false)) {
                        d2 = cursorW8.getDouble(cursorW8.getColumnIndex("f16"));
                        d3 = cursorW8.getDouble(cursorW8.getColumnIndex("f17"));
                    } else {
                        if (this.c.ja("pref_trail_balance_cr_db_total", false)) {
                            d2 = cursorW8.getDouble(cursorW8.getColumnIndex("f13"));
                            d3 = cursorW8.getDouble(cursorW8.getColumnIndex("f12"));
                        } else {
                            d4 = cursorW8.getDouble(cursorW8.getColumnIndex("f2"));
                        }
                        d5 += d4;
                    }
                    d4 = d2 - d3;
                    d5 += d4;
                }
                cursorW8.moveToNext();
            }
            cursorW8.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Log.d("trail_diff=", "" + d5);
        return b0(d5, 3);
    }

    public int K(String str) {
        try {
            return Integer.parseInt(this.c.X4("select ifnull(user_id,-1) as _id from transactions where id=" + str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public ArrayList L(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorN = N(str);
        cursorN.moveToFirst();
        while (!cursorN.isAfterLast()) {
            HashMap map = new HashMap();
            map.put(HTML.Attribute.ID, cursorN.getString(cursorN.getColumnIndex("_id")));
            map.put("screen_name", cursorN.getString(cursorN.getColumnIndex("screen_name")));
            map.put("screen_id", cursorN.getString(cursorN.getColumnIndex("screen_id")));
            map.put("user_id", cursorN.getString(cursorN.getColumnIndex("user_id")));
            map.put("new", cursorN.getString(cursorN.getColumnIndex("new")));
            map.put("edit", cursorN.getString(cursorN.getColumnIndex("edit")));
            map.put("view", cursorN.getString(cursorN.getColumnIndex("view")));
            map.put(HTML.Tag.DEL, cursorN.getString(cursorN.getColumnIndex(HTML.Tag.DEL)));
            arrayList.add(map);
            cursorN.moveToNext();
        }
        g = arrayList;
        return arrayList;
    }

    public Cursor M() {
        try {
            return this.c.a.rawQuery("SELECT a.id as _id, a.*,b.name branch_name,c.name cash_name  from users a ,branches b,customers c where ifnull(a.br_id,0)=b.id and ifnull(a.cash_id,-3)=c.id ", null);
        } catch (Exception unused) {
            return null;
        }
    }

    public Cursor N(String str) {
        try {
            return this.c.a.rawQuery("SELECT b.id as _id, b.*,c.name screen_name  from users a ,user_priv b,screens c where a.id=b.user_id and b.screen_id=c.id  and a.id=? order by c.p_id ", new String[]{str});
        } catch (Exception unused) {
            return null;
        }
    }

    public String P(String str, String str2) {
        String str3 = "";
        try {
            if (!str.equals(CSS.Value.PERCENTAGE) && !str2.equals(CSS.Value.PERCENTAGE)) {
                str3 = " " + this.f.getString(R.string.f_date_hdr) + ":" + str + "        " + this.f.getString(R.string.t_date_hdr) + ":" + str2 + " ";
            } else if (!str.equals(CSS.Value.PERCENTAGE) && str2.equals(CSS.Value.PERCENTAGE)) {
                str3 = " " + this.f.getString(R.string.f_date_hdr) + ":" + str + "         ";
            } else if (str.equals(CSS.Value.PERCENTAGE) && !str2.equals(CSS.Value.PERCENTAGE)) {
                str3 = StringUtilities.LF + this.f.getString(R.string.t_date_hdr) + ":" + str2 + "         ";
            }
        } catch (Exception unused) {
        }
        return str3;
    }

    public int V(String str) {
        return (str.length() != 0 && str.length() < 3) ? 1000 : 500;
    }

    public void W(String str) {
        if (str.equals(CSS.Value.PERCENTAGE)) {
            return;
        }
        this.c.ia("pref_cost_avg", "1").equals("2");
    }

    public void Z(Context context) {
        h = -1;
        i = 0;
        j = -3;
        k = "";
        MO.a(context);
    }

    public void a0() {
        this.c.Lc("reset_user_id", "");
        this.c.Lc("reset_expire", "0");
        this.c.Lc("reset_next", "0");
        this.c.Lc("reset_check", "0");
    }

    public double b0(double d2, int i2) {
        double dPow = Math.pow(10.0d, i2);
        return Math.round(d2 * dPow) / dPow;
    }

    public final double d() {
        int size = this.e.size() - 1;
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i2 = 0; i2 <= size; i2++) {
            arrayDeque.add((C4064uh) this.e.get(i2));
        }
        Log.d("onLoadFinished=", "trace1:" + size);
        double d2 = 0.0d;
        while (!arrayDeque.isEmpty()) {
            C4064uh c4064uh = (C4064uh) arrayDeque.pollLast();
            d2 += Double.parseDouble(c4064uh.c) * (Double.parseDouble(c4064uh.f()) - 1.0d);
            c4064uh.x(d2);
        }
        Log.d("onLoadFinished=", "trace2:" + d2);
        return d2;
    }

    public ArrayList d0(long j2, long j3, long j4, String str, boolean z, boolean z2, String str2, String str3, int i2, String str4, String str5) {
        String strC2 = str2;
        ArrayList arrayList = new ArrayList();
        if (z && z2) {
            if (i2 != 2 || this.c.ja("prefOthers_sales_out_qty", false)) {
                Z00 z00 = this.c;
                String strValueOf = String.valueOf(j4);
                if (strC2 == null) {
                    strC2 = this.c.C2(str3);
                }
                arrayList = z00.p7(strValueOf, str, strC2, this.c.ja("prefOthers_item_end_date", false));
            } else {
                Z00 z01 = this.c;
                String strValueOf2 = String.valueOf(j2);
                if (strC2 == null) {
                    strC2 = this.c.C2(str3);
                }
                arrayList = z01.m7(strValueOf2, str, strC2, this.c.ja("prefOthers_item_end_date", false));
            }
        } else if (i2 == 1 && z && !z2) {
            arrayList = this.c.o7(String.valueOf(j3), "0", strC2, this.c.ja("prefOthers_item_end_date", false));
        } else if (i2 == 8 || i2 == 1 || (i2 == 2 && !z2)) {
            Z00 z02 = this.c;
            String strValueOf3 = String.valueOf(j2);
            if (strC2 == null) {
                strC2 = this.c.C2(str3);
            }
            arrayList = z02.m7(strValueOf3, str, strC2, this.c.ja("prefOthers_item_end_date", false));
        } else if (i2 == 2 && z2) {
            Z00 z03 = this.c;
            String strValueOf4 = String.valueOf(j2);
            if (strC2 == null) {
                strC2 = this.c.C2(str3);
            }
            arrayList = z03.n7(strValueOf4, str, strC2, this.c.ja("prefOthers_item_end_date", false), str5);
        } else if (i2 == 11 && z && !z2) {
            arrayList = this.c.o7(String.valueOf(j3), "0", strC2, this.c.ja("prefOthers_item_end_date", false));
        } else if (i2 == 11 || (i2 == 21 && !z2)) {
            Z00 z04 = this.c;
            String strValueOf5 = String.valueOf(j2);
            if (strC2 == null) {
                strC2 = this.c.C2(str3);
            }
            arrayList = z04.m7(strValueOf5, str, strC2, this.c.ja("prefOthers_item_end_date", false));
        } else if (i2 == 4) {
            if (str4.equals("2") || str4.equals("4")) {
                Z00 z05 = this.c;
                String strValueOf6 = String.valueOf(j2);
                if (strC2 == null) {
                    strC2 = this.c.C2(str3);
                }
                arrayList = z05.n7(strValueOf6, str, strC2, this.c.ja("prefOthers_item_end_date", false), str5);
            } else {
                Z00 z06 = this.c;
                String strValueOf7 = String.valueOf(j2);
                if (strC2 == null) {
                    strC2 = this.c.C2(str3);
                }
                arrayList = z06.m7(strValueOf7, str, strC2, this.c.ja("prefOthers_item_end_date", false));
            }
        }
        Log.d("check_item_qty_cnt=", "" + arrayList.size() + ":" + j3 + ":" + str5 + ":" + j2 + ":" + i2);
        return arrayList;
    }

    public void e(int i2) {
        d();
    }

    public String f(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : bArrDigest) {
                stringBuffer.append(String.format("%02x", Byte.valueOf(b2)));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public void g(int i2, EditText editText) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
            C3172jj c3172jjC = C3172jj.c(this.b.getLayoutInflater());
            builder.setView(c3172jjC.getRoot());
            this.c.Zc(this.b, c3172jjC.b);
            c3172jjC.b.requestFocus();
            c3172jjC.b.setHint(this.b.getString(R.string.new_pwd));
            c3172jjC.b.setInputType(2);
            builder.setPositiveButton(this.b.getString(R.string.resourceID_OK), new d());
            builder.setNegativeButton(this.b.getString(R.string.resourceID_Cancel), new e());
            AlertDialog alertDialogCreate = builder.create();
            if (i2 == -1) {
                alertDialogCreate.setTitle(this.b.getString(R.string.btn_change_pw));
            } else {
                alertDialogCreate.setTitle(this.b.getString(R.string.btn_change_pw) + "(" + i2 + ")");
            }
            alertDialogCreate.getWindow().setSoftInputMode(16);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new f(c3172jjC, i2, editText, alertDialogCreate));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean h(String str, String str2) {
        return new java.io.File(new java.io.File(str), str2).exists();
    }

    public boolean i() {
        return System.currentTimeMillis() - Long.parseLong(this.c.ia("last_backup_time", "0")) > ((long) (m * 60000));
    }

    public boolean j(int i2) {
        Z00 z00 = this.c;
        StringBuilder sb = new StringBuilder();
        sb.append("select count(*) as _id from users where is_active=1 and id='");
        sb.append(i2);
        sb.append("' ");
        return Integer.parseInt(z00.X4(sb.toString())) > 0;
    }

    public boolean k(int i2, String str, Context context) {
        if (Integer.parseInt(this.c.X4("select count(*) as _id from users where is_active=1 and id='" + i2 + "' and pwd='" + f(str) + "' ")) <= 0) {
            MO.c(context, -1);
            return false;
        }
        h = i2;
        i = Integer.parseInt(this.c.X4("select br_id as _id from users where id=" + i2));
        j = Integer.parseInt(this.c.X4("select cash_id as _id from users where id=" + i2));
        k = this.c.X4("select user_name as _id from users where id=" + i2);
        L(h + "");
        MO.c(context, h);
        return true;
    }

    public boolean l(String str, String str2) {
        if (h == -1) {
            return false;
        }
        ArrayList arrayList = g;
        if (arrayList == null || arrayList.size() == 0) {
            L(h + "");
        }
        for (HashMap map : g) {
            if (((String) map.get("user_id")).equals(h + "") && ((String) map.get("screen_id")).equals(str) && ((String) map.get(str2)).equals("1")) {
                return true;
            }
        }
        return false;
    }

    public void m(TextView[] textViewArr, String[] strArr, String str) {
        if (str == null || textViewArr.length != strArr.length || textViewArr.length == 0 || strArr.length == 0 || str.length() == 0) {
            return;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String strReplace = strArr[i2].replace(",", "");
            try {
                if (strReplace.contains(str) || strArr[i2].contains(str)) {
                    int iIndexOf = str.contains(",") ? strArr[0].indexOf(str) : strReplace.indexOf(str.replace(",", ""));
                    int length = str.length() + iIndexOf;
                    int iIndexOf2 = strArr[i2].indexOf(",");
                    int length2 = strArr[i2].length() - strReplace.length();
                    if (length <= iIndexOf2) {
                        length2 = 0;
                    }
                    Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(textViewArr[i2].getText());
                    spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length + length2, 33);
                    textViewArr[i2].setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public List n(String str, Drive drive) {
        File file = new File();
        file.setName(str);
        file.setMimeType("application/vnd.google-apps.folder");
        if (G(str, drive) != null && G(str, drive).size() != 0) {
            return G(str, drive);
        }
        File fileExecute = drive.files().create(file).setFields2(HTML.Attribute.ID).execute();
        ArrayList arrayList = new ArrayList();
        arrayList.add(fileExecute.getId());
        return arrayList;
    }

    public void o(String str, String str2, Handler handler) {
        try {
            Calendar calendar = Calendar.getInstance();
            Locale locale = Locale.ENGLISH;
            new SimpleDateFormat("dd-MM-yyyy H", locale).format(calendar.getTime());
            new SimpleDateFormat("dd-MM-yyyy", locale).format(calendar.getTime());
            if (this.c.ia("PREF_ACCOUNT_NAME", "0").equals("0")) {
                Intent intent = new Intent(this.b, (Class<?>) Google_drive_list.class);
                intent.putExtra("change_email_flag", "1");
                this.b.startActivity(intent);
                return;
            }
            Z00.T = this.c.ia("PREF_ACCOUNT_NAME", "0");
            try {
                FirebaseInstanceId.getInstance().getToken();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            C4278xL c4278xLA = AbstractC2038dY.a(this.b);
            c cVar = new c(1, "https://mohaseb.dyndns.org:888/req_reset", new a(handler, str), new b(handler), str, str2);
            cVar.H(false);
            c4278xLA.a(cVar);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public ArrayList r(List list, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (p(new String[]{((C0634Jt) list.get(i2)).e(), ((C0634Jt) list.get(i2)).c(), ((C0634Jt) list.get(i2)).n().replace(",", ""), ((C0634Jt) list.get(i2)).h().replace(",", ""), ((C0634Jt) list.get(i2)).l()}, str)) {
                arrayList.add((C0634Jt) list.get(i2));
            }
        }
        return arrayList;
    }

    public boolean t(String[] strArr, String str) {
        if (strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str2.contains(str.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public int u() {
        try {
            return Integer.parseInt(this.c.X4("select count(*) as _id from users where is_active=1 and id=0"));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public int v() {
        try {
            return Integer.parseInt(this.c.X4("select count(*) as _id from users where is_active=1"));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public double w(String str, int i2, int i3, String str2, String str3, String str4, int i4, String str5) {
        String str6;
        String str7;
        String str8;
        Cursor cursorRawQuery;
        Log.d("inputs=", str + ":" + i2 + ":" + i3 + ":" + str2 + ":" + str3 + ":" + str4);
        String strReplace = str5.replace("'", "");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT sum(case when a.curr_id=0 then (case when a.is_back=0 then a.amount else -1*a.amount end) else (case when a.is_back=0 then a.curr_price*a.amount else -1*a.curr_price*a.amount end) end ) f13 from bills2 a,tran_type c,currency e,bill_type f  where  a.tr_type= ");
        sb.append(i2);
        sb.append(" and a.tr_type=c.id and a.curr_id=e.id  and a.bill_type=f.id");
        if (str.equals(CSS.Value.PERCENTAGE) || h > 0) {
            str6 = "";
        } else {
            str6 = " and br_id=" + str;
        }
        sb.append(str6);
        if (h > 0) {
            str7 = " and a.user_id= " + h;
        } else {
            str7 = " ";
        }
        sb.append(str7);
        if (i4 == 0) {
            str8 = "";
        } else {
            str8 = " and  ( a.bill_no2||'|'||a.date_||'|'||    (f.name || (case when a.is_back='1' then '- مرتجع' else '' end )) ||'|'|| (select f.name from customers f where  f.id=a.cus_id) ||'|'|| (select f.name from branches f where  f.id=a.br_id) ||'|'|| (case when a.user_id is null then '' else (select name from users where id=a.user_id) end)  like '%" + strReplace + "%') ";
        }
        sb.append(str8);
        String string = sb.toString();
        if (i3 == 0) {
            Log.d("Case#", "all regardless item_status");
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?   ", new String[]{"" + i2});
        } else if (!str2.equals(CSS.Value.PERCENTAGE) && !str3.equals(CSS.Value.PERCENTAGE) && !str4.equals(CSS.Value.PERCENTAGE)) {
            Log.d("Case#", "all");
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?   and date(a.date_) between date(?) and date(?)  and cus_id=(select id from customers where name=? ) ", new String[]{"" + i2, str2, str3, str4});
        } else if (str2.equals(CSS.Value.PERCENTAGE) && str3.equals(CSS.Value.PERCENTAGE) && !str4.equals(CSS.Value.PERCENTAGE)) {
            Log.d("Case#", "name");
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?  and cus_id=(select id from customers where name=? ) ", new String[]{"" + i2, str4});
        } else if (str2.equals(CSS.Value.PERCENTAGE) && !str3.equals(CSS.Value.PERCENTAGE) && !str4.equals(CSS.Value.PERCENTAGE)) {
            Log.d("Case#", "name&t_date");
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?   and date(a.date_) <= date(?)  and cus_id=(select id from customers where name=? ) ", new String[]{"" + i2, str3, str4});
        } else if (!str2.equals(CSS.Value.PERCENTAGE) && str3.equals(CSS.Value.PERCENTAGE) && !str4.equals(CSS.Value.PERCENTAGE)) {
            Log.d("Case#", "name&f_date");
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?   and date(a.date_) >= date(?)  and cus_id=(select id from customers where name=? ) ", new String[]{"" + i2, str2, str4});
        } else if (!str2.equals(CSS.Value.PERCENTAGE) && !str3.equals(CSS.Value.PERCENTAGE) && str4.equals(CSS.Value.PERCENTAGE)) {
            Log.d("Case#", DublinCoreProperties.DATE);
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?   and date( a.date_) between date(?) and date(?)  ", new String[]{"" + i2, str2, str3});
        } else if (str2.equals(CSS.Value.PERCENTAGE) && !str3.equals(CSS.Value.PERCENTAGE) && str4.equals(CSS.Value.PERCENTAGE)) {
            Log.d("Case#", "t_date");
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?   and date( a.date_) <= date(?)  ", new String[]{"" + i2, str3});
        } else if (!str2.equals(CSS.Value.PERCENTAGE) && str3.equals(CSS.Value.PERCENTAGE) && str4.equals(CSS.Value.PERCENTAGE)) {
            Log.d("Case#", "f_date");
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?   and date( a.date_) >= date(?)  ", new String[]{"" + i2, str2});
        } else {
            Log.d("Case#", "else");
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?   ", new String[]{"" + i2});
        }
        cursorRawQuery.moveToFirst();
        double d2 = 0.0d;
        while (!cursorRawQuery.isAfterLast()) {
            d2 = cursorRawQuery.getDouble(cursorRawQuery.getColumnIndex("f13"));
            cursorRawQuery.moveToNext();
        }
        cursorRawQuery.close();
        return d2;
    }

    public double x(String str, int i2, int i3, String str2, String str3, String str4, int i4, String str5) {
        String str6;
        String str7;
        String str8;
        Cursor cursorRawQuery;
        Log.d("inputs=", str + ":" + i2 + ":" + i3 + ":" + str2 + ":" + str3 + ":" + str4 + ":" + str5);
        String strReplace = str5.replace("'", "");
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT sum(case when a.curr_id=0 then (case when a.is_back=0 then a.amount else -1*a.amount end) else (case when a.is_back=0 then a.curr_price*a.amount else -1*a.curr_price*a.amount end) end ) f13 from bills_v a,tran_type c,currency e,bill_type f  where a.tr_type=c.id and a.curr_id=e.id  and a.bill_type=f.id");
        if (str.equals(CSS.Value.PERCENTAGE) || h > 0) {
            str6 = "";
        } else {
            str6 = " and br_id=" + str;
        }
        sb.append(str6);
        if (h > 0) {
            str7 = " and a.user_id= " + h;
        } else {
            str7 = " ";
        }
        sb.append(str7);
        if (i4 == 0) {
            str8 = "";
        } else {
            str8 = " and  ( a.bill_no2||'|'||a.date_||'|'||    (f.name || (case when a.is_back='1' then '- مرتجع' else '' end )) ||'|'|| (select f.name from customers f where  f.id=a.cus_id) ||'|'|| (select f.name from branches f where  f.id=a.br_id) ||'|'|| (case when a.user_id is null then '' else (select name from users where id=a.user_id) end)  like '%" + strReplace + "%') ";
        }
        sb.append(str8);
        String string = sb.toString();
        if (i3 == 0) {
            Log.d("Case#", "all regardless item_status");
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?   ", new String[]{"" + i2});
        } else if (!str2.equals(CSS.Value.PERCENTAGE) && !str3.equals(CSS.Value.PERCENTAGE) && !str4.equals(CSS.Value.PERCENTAGE)) {
            Log.d("Case#", "all");
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?   and date(a.date_) between date(?) and date(?)  and cus_id=(select id from customers where name=? ) ", new String[]{"" + i2, str2, str3, str4});
        } else if (str2.equals(CSS.Value.PERCENTAGE) && str3.equals(CSS.Value.PERCENTAGE) && !str4.equals(CSS.Value.PERCENTAGE)) {
            Log.d("Case#", "name");
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?  and cus_id=(select id from customers where name=? ) ", new String[]{"" + i2, str4});
        } else if (str2.equals(CSS.Value.PERCENTAGE) && !str3.equals(CSS.Value.PERCENTAGE) && !str4.equals(CSS.Value.PERCENTAGE)) {
            Log.d("Case#", "name&t_date");
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?   and date(a.date_) <= date(?)  and cus_id=(select id from customers where name=? ) ", new String[]{"" + i2, str3, str4});
        } else if (!str2.equals(CSS.Value.PERCENTAGE) && str3.equals(CSS.Value.PERCENTAGE) && !str4.equals(CSS.Value.PERCENTAGE)) {
            Log.d("Case#", "name&f_date");
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?   and date(a.date_) >= date(?)  and cus_id=(select id from customers where name=? ) ", new String[]{"" + i2, str2, str4});
        } else if (!str2.equals(CSS.Value.PERCENTAGE) && !str3.equals(CSS.Value.PERCENTAGE) && str4.equals(CSS.Value.PERCENTAGE)) {
            Log.d("Case#", DublinCoreProperties.DATE);
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?   and date( a.date_) between date(?) and date(?)  ", new String[]{"" + i2, str2, str3});
        } else if (str2.equals(CSS.Value.PERCENTAGE) && !str3.equals(CSS.Value.PERCENTAGE) && str4.equals(CSS.Value.PERCENTAGE)) {
            Log.d("Case#", "t_date");
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?   and date( a.date_) <= date(?)  ", new String[]{"" + i2, str3});
        } else if (!str2.equals(CSS.Value.PERCENTAGE) && str3.equals(CSS.Value.PERCENTAGE) && str4.equals(CSS.Value.PERCENTAGE)) {
            Log.d("Case#", "f_date");
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?   and date( a.date_) >= date(?)  ", new String[]{"" + i2, str2});
        } else {
            Log.d("Case#", "else");
            cursorRawQuery = this.c.a.rawQuery(string + " and a.tr_type =?   ", new String[]{"" + i2});
        }
        cursorRawQuery.moveToFirst();
        double d2 = 0.0d;
        while (!cursorRawQuery.isAfterLast()) {
            d2 = cursorRawQuery.getDouble(cursorRawQuery.getColumnIndex("f13"));
            cursorRawQuery.moveToNext();
        }
        cursorRawQuery.close();
        return d2;
    }

    public int y(String str, String str2) {
        try {
            return Integer.parseInt(this.c.X4("select ifnull(user_id,-1) as _id from " + str2 + " where id=" + str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public C2160f10(Z00 z00) {
        this.a = null;
        this.d = null;
        this.e = new ArrayList();
        this.c = z00;
    }

    public C2160f10(Z00 z00, Activity activity) {
        this.a = null;
        this.d = null;
        this.e = new ArrayList();
        this.c = z00;
        this.b = activity;
    }

    public C2160f10(Z00 z00, Activity activity, g gVar) {
        this.a = null;
        this.d = null;
        this.e = new ArrayList();
        this.c = z00;
        this.b = activity;
        this.d = gVar;
    }

    public C2160f10(List list) {
        this.a = null;
        this.d = null;
        new ArrayList();
        this.e = list;
    }

    public C2160f10(Context context, Z00 z00) {
        this.a = null;
        this.d = null;
        this.e = new ArrayList();
        this.c = z00;
        this.f = context;
    }

    /* JADX INFO: renamed from: f10$d */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* JADX INFO: renamed from: f10$e */
    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
