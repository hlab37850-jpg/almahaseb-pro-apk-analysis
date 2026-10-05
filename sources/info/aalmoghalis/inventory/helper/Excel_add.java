package info.aalmoghalis.inventory.helper;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.C0372Bn;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.Bill_edit;
import info.aalmoghalis.inventory.activity.Info_edit3;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

/* JADX INFO: loaded from: classes3.dex */
public class Excel_add extends BaseActivity {
    public TextView c;
    public Button d;
    public Button e;
    public SQLiteDatabase f;
    public Z00 g;
    public int h = 0;
    public int i = 0;
    public int j = 4;
    public boolean k = false;
    public Dialog l = null;
    public Handler n = new d();
    public StringBuilder p = new StringBuilder();
    public ArrayList q = new ArrayList();
    public ArrayList t = new ArrayList();
    public int u = 0;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Excel_add.this.A();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Excel_add.this.D();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Excel_add.this.c.getText().toString().contains(Excel_add.this.getString(R.string.excel_template))) {
                try {
                    File file = new File(Z00.L, "sample.xls");
                    file.createNewFile();
                    Excel_add excel_add = Excel_add.this;
                    int i = excel_add.h;
                    if (i == 1) {
                        excel_add.g.Rb("sample1.xls", file);
                    } else if (i == 2) {
                        excel_add.g.Rb("sample2.xls", file);
                    }
                    Excel_add.this.g.pa(file.getName());
                } catch (Exception e) {
                    Log.d("excel_log=", e.getMessage() + "");
                }
            }
        }
    }

    public class d extends Handler {
        public d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("0")) {
                Excel_add.this.H();
            } else if (message.obj.toString().equals("1")) {
                Excel_add.this.c.setText(Excel_add.this.getString(R.string.data_insert) + " " + Excel_add.this.u + StringUtilities.LF + Excel_add.this.p.toString());
                Excel_add.this.e.setEnabled(false);
                Excel_add excel_add = Excel_add.this;
                if (excel_add.u == excel_add.q.size() && Excel_add.this.q.size() > 0) {
                    Excel_add excel_add2 = Excel_add.this;
                    Toast.makeText(excel_add2, excel_add2.getString(R.string.done), 0).show();
                    Excel_add.this.finish();
                }
            }
            Excel_add.this.F(false);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Excel_add.this.G();
            Message message = new Message();
            message.obj = "0";
            Excel_add.this.n.sendMessage(message);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Excel_add.this.C();
            Message message = new Message();
            message.obj = "1";
            Excel_add.this.n.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        try {
            int i = Build.VERSION.SDK_INT;
            if (i < 31) {
                x();
            }
            new Intent();
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"});
            if (i >= 26) {
                intent.putExtra("android.provider.extra.INITIAL_URI", Uri.parse("content://com.android.externalstorage.documents/document/primary:" + Z00.L.replaceAll("/storage/emulated/0/", "").replaceAll("/", "%2F")));
            }
            startActivityForResult(intent, this.j);
        } catch (Exception e2) {
            this.p.append(e2.getMessage() + "");
        }
    }

    private File z(Uri uri, String str) {
        File file;
        Cursor cursorQuery = getContentResolver().query(uri, new String[]{"_display_name", "_size"}, null, null, null);
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        int columnIndex2 = cursorQuery.getColumnIndex("_size");
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(columnIndex);
        Long.toString(cursorQuery.getLong(columnIndex2));
        if (str.equals("")) {
            file = new File(getFilesDir() + "/" + string);
        } else {
            File file2 = new File(getFilesDir() + "/" + str);
            if (!file2.exists()) {
                file2.mkdir();
            }
            file = new File(getFilesDir() + "/" + str + "/" + string);
        }
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamOpenInputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, i);
            }
            inputStreamOpenInputStream.close();
            fileOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e("Exception", e2.getMessage());
            this.p.append("Error:" + e2.getMessage() + StringUtilities.LF);
        }
        return file;
    }

    public ArrayList B() {
        String str;
        Iterator<Row> it;
        String str2 = "";
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(Z00.L, this.k ? "template.xlsx" : "template.xls");
            Log.d("excel_log_exists=", file.exists() + "");
            if (!file.exists()) {
                return null;
            }
            Iterator<Row> itRowIterator = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(file))).getSheetAt(0).rowIterator();
            Log.d("excel_log_rows=", itRowIterator.hasNext() + "");
            this.p.append(StringUtilities.LF);
            int i = 0;
            while (itRowIterator.hasNext()) {
                Log.e("excel_log_r=", " row no " + i);
                HSSFRow hSSFRow = (HSSFRow) itRowIterator.next();
                if (i != 0) {
                    hSSFRow.cellIterator();
                    String string = str2;
                    String string2 = string;
                    String string3 = string2;
                    String string4 = string3;
                    String string5 = string4;
                    String string6 = string5;
                    String string7 = string6;
                    str = string7;
                    int i2 = 0;
                    while (true) {
                        it = itRowIterator;
                        if (i2 >= 7) {
                            break;
                        }
                        HSSFCell cell = hSSFRow.getCell(i2);
                        if (i2 == 0) {
                            string2 = cell == null ? str : cell.toString();
                        } else if (i2 == 1) {
                            string3 = cell == null ? str : cell.toString();
                        } else if (i2 == 2) {
                            string4 = cell == null ? str : cell.toString();
                        } else if (i2 == 3) {
                            string5 = cell == null ? str : cell.toString();
                        } else if (i2 == 4) {
                            string6 = cell == null ? str : cell.toString();
                        } else if (i2 == 5) {
                            string7 = cell == null ? str : cell.toString();
                        } else if (i2 == 6) {
                            string = cell == null ? str : cell.toString();
                        }
                        i2++;
                        itRowIterator = it;
                    }
                    if (this.h == 1) {
                        this.p.append(string2 + " -- " + string3 + " -- " + string4 + " -- " + string5 + " -- " + string6 + " -- " + string7 + " -- " + string + " -- \n");
                    } else {
                        this.p.append(string2 + " -- " + string3 + " -- " + string4 + " -- " + string5 + " -- " + string6 + " -- \n");
                    }
                    Log.d("excel_log_data=", string2 + " -- " + string3 + "  -- " + string4 + "  -- " + string5 + "  -- " + string6 + string7 + " -- " + string + " -- \n");
                    HashMap map = new HashMap();
                    map.put("f1", string2);
                    map.put("f2", string3);
                    map.put("f3", string4);
                    map.put("f4", string5);
                    map.put("f5", string6);
                    map.put("f6", string7);
                    map.put("f7", string);
                    arrayList.add(map);
                } else {
                    str = str2;
                    it = itRowIterator;
                }
                i++;
                str2 = str;
                itRowIterator = it;
            }
        } catch (Exception e2) {
            Log.e("excel_log_err=", "error " + e2.toString());
            this.p.append(e2.getMessage() + StringUtilities.LF);
        }
        return arrayList;
    }

    public void C() {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z = true;
        Bill_edit.P2 = true;
        this.p = new StringBuilder();
        ArrayList arrayListA7 = this.g.A7();
        this.q = arrayListA7;
        if (arrayListA7 == null) {
            return;
        }
        int i = 0;
        this.u = 0;
        int i2 = this.h;
        String str5 = "f3";
        String str6 = "f2";
        String str7 = "f4";
        String str8 = "Error..";
        if (i2 != 1) {
            Object obj = "f3";
            if (i2 == 2) {
                while (i < this.q.size()) {
                    double d2 = Double.parseDouble(((String) ((HashMap) this.q.get(i)).get(str7)).toString().replaceAll(",", "")) - Double.parseDouble(((String) ((HashMap) this.q.get(i)).get("f5")).toString().replaceAll(",", ""));
                    StringBuilder sb = new StringBuilder();
                    sb.append("insert into customers (name,gsm,address,acc_p_id,g_id) values ('");
                    sb.append(((String) ((HashMap) this.q.get(i)).get("f1")).toString());
                    sb.append("','");
                    sb.append(((String) ((HashMap) this.q.get(i)).get("f2")).toString());
                    sb.append("','");
                    Object obj2 = obj;
                    sb.append(((String) ((HashMap) this.q.get(i)).get(obj2)).toString());
                    sb.append("',");
                    sb.append(this.i);
                    sb.append(",0)");
                    String string = sb.toString();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("insert into transactions (cus_id,out,[in],date_,remarks,now_,param2,fund_id,curr_id,bill_id) values((select b.id from customers as b where b.name='");
                    sb2.append(((String) ((HashMap) this.q.get(i)).get("f1")).toString());
                    sb2.append("'),");
                    String str9 = str7;
                    sb2.append(Math.abs(d2));
                    sb2.append(",");
                    sb2.append(d2 > 0.0d ? 1 : -1);
                    sb2.append(",strftime('%d-%m-%Y','now'),'");
                    sb2.append(getString(R.string.opening_balance));
                    sb2.append("',strftime('%Y-%m-%d','now'),'");
                    sb2.append(this.g.B8());
                    sb2.append("',((select value_ from sys_conf where id=4)),0,-1 )");
                    String string2 = sb2.toString();
                    Log.d("excel_log=", d2 + "YR");
                    if (d2 == 0.0d) {
                        if (this.g.G(string) == 1) {
                            this.u++;
                        } else {
                            this.p.append("Error.." + ((String) ((HashMap) this.q.get(i)).get("f1")).toString());
                        }
                    } else if (this.g.H(string, string2) == 1) {
                        this.u++;
                    } else {
                        this.p.append("Error.." + ((String) ((HashMap) this.q.get(i)).get("f1")).toString());
                    }
                    i++;
                    str7 = str9;
                    obj = obj2;
                }
                return;
            }
            return;
        }
        while (i < this.q.size()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("insert into items(name,item_type_id,o_qty,o_cost,unit_id,barcode,e_date) values('");
            sb3.append(((String) ((HashMap) this.q.get(i)).get("f1")).toString());
            sb3.append("',0,'");
            sb3.append(((String) ((HashMap) this.q.get(i)).get(str6)).toString());
            sb3.append("','");
            sb3.append(((String) ((HashMap) this.q.get(i)).get(str5)).toString());
            sb3.append("',");
            String str10 = str5;
            if (((String) ((HashMap) this.q.get(i)).get("f5")).toString().equals("")) {
                str = "0";
            } else {
                str = "ifnull((select id from units where name='" + ((String) ((HashMap) this.q.get(i)).get("f5")).toString() + "'),0)";
            }
            sb3.append(str);
            sb3.append(",");
            String str11 = "null";
            String str12 = str8;
            if (((String) ((HashMap) this.q.get(i)).get("f6")).toString().equals("")) {
                str2 = "null";
            } else {
                str2 = "'" + ((String) ((HashMap) this.q.get(i)).get("f6")).toString() + "'";
            }
            sb3.append(str2);
            sb3.append(",");
            if (!((String) ((HashMap) this.q.get(i)).get("f7")).toString().equals("")) {
                str11 = "'" + ((String) ((HashMap) this.q.get(i)).get("f7")).toString() + "'";
            }
            sb3.append(str11);
            sb3.append(")");
            String string3 = sb3.toString();
            String str13 = "delete from item_price where item_id=(select a.id from items a where a.name='" + ((String) ((HashMap) this.q.get(i)).get("f1")).toString() + "') and curr_id=0 ";
            StringBuilder sb4 = new StringBuilder();
            sb4.append("insert into item_price(item_id,curr_id,SLS_U_PRICE,unit_id) values ((select a.id from items a where a.name='");
            sb4.append(((String) ((HashMap) this.q.get(i)).get("f1")).toString());
            sb4.append("'),0,'");
            sb4.append(((String) ((HashMap) this.q.get(i)).get("f4")).toString());
            sb4.append("',");
            if (((String) ((HashMap) this.q.get(i)).get("f5")).toString().equals("")) {
                str3 = r4;
            } else {
                str3 = "ifnull((select id from units where name='" + ((String) ((HashMap) this.q.get(i)).get("f5")).toString() + "'),0)";
            }
            sb4.append(str3);
            sb4.append(")");
            String string4 = sb4.toString();
            this.g.G("insert or ignore into units(id,name,code)  select (select max(id)+1 from units),'" + ((String) ((HashMap) this.q.get(i)).get("f5")).toString() + "','" + ((String) ((HashMap) this.q.get(i)).get("f5")).toString() + "' where length('" + ((String) ((HashMap) this.q.get(i)).get("f5")).toString() + "')>0 ");
            if (!((String) ((HashMap) this.q.get(i)).get("f4")).toString().equals("0")) {
                str4 = str12;
                if (this.g.I(string3, str13, string4) == 1) {
                    this.u++;
                } else {
                    this.p.append(str4 + ((String) ((HashMap) this.q.get(i)).get("f1")).toString());
                }
            } else if (this.g.G(string3) == 1) {
                this.u++;
                str4 = str12;
            } else {
                StringBuilder sb5 = this.p;
                StringBuilder sb6 = new StringBuilder();
                str4 = str12;
                sb6.append(str4);
                sb6.append(((String) ((HashMap) this.q.get(i)).get("f1")).toString());
                sb5.append(sb6.toString());
            }
            i++;
            str8 = str4;
            str5 = str10;
            str6 = str6;
            z = true;
        }
        Info_edit3.x0 = z;
    }

    public void D() {
        F(true);
        new Thread(new f()).start();
    }

    public final void E(Intent intent) {
        try {
            Log.d("excel_log:", "onSelectFromGalleryResult");
            if (intent != null) {
                try {
                    Log.d("excel_log:", "data_not_null");
                    File file = new File(Z00.M);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(Z00.L, "template.xls");
                    Uri data = intent.getData();
                    File file3 = new File(data.getPath());
                    if (file3.getName().endsWith(".xls") || file3.getName().endsWith(".xlsx")) {
                        this.k = false;
                        if (file3.getName().endsWith(".xlsx")) {
                            file2 = new File(Z00.L, "template.xlsx");
                            this.k = true;
                        }
                        y(z(data, "tmp"), file2);
                        I();
                        return;
                    }
                    return;
                } catch (IOException e2) {
                    this.p.append(e2.getMessage() + StringUtilities.LF);
                    return;
                }
                this.p.append(e.getMessage() + StringUtilities.LF);
            }
        } catch (Exception e3) {
            this.p.append(e3.getMessage() + StringUtilities.LF);
        }
    }

    public void F(boolean z) {
        Log.d("mProgress=", "....start..." + z);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
        if (z) {
            AlertDialog alertDialogCreate = builder.create();
            this.l = alertDialogCreate;
            alertDialogCreate.show();
        } else {
            Dialog dialog = this.l;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x01cf A[Catch: Exception -> 0x01df, TryCatch #1 {Exception -> 0x01df, blocks: (B:37:0x01ca, B:39:0x01cf, B:41:0x01d8, B:45:0x01ea, B:49:0x01f0, B:51:0x01f8, B:44:0x01e4), top: B:62:0x01ca }] */
    /* JADX WARN: Code duplicated, block: B:41:0x01d8 A[Catch: Exception -> 0x01df, TryCatch #1 {Exception -> 0x01df, blocks: (B:37:0x01ca, B:39:0x01cf, B:41:0x01d8, B:45:0x01ea, B:49:0x01f0, B:51:0x01f8, B:44:0x01e4), top: B:62:0x01ca }] */
    /* JADX WARN: Code duplicated, block: B:44:0x01e4 A[Catch: Exception -> 0x01df, TryCatch #1 {Exception -> 0x01df, blocks: (B:37:0x01ca, B:39:0x01cf, B:41:0x01d8, B:45:0x01ea, B:49:0x01f0, B:51:0x01f8, B:44:0x01e4), top: B:62:0x01ca }] */
    /* JADX WARN: Code duplicated, block: B:47:0x01ee A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:51:0x01f8 A[Catch: Exception -> 0x01df, TRY_LEAVE, TryCatch #1 {Exception -> 0x01df, blocks: (B:37:0x01ca, B:39:0x01cf, B:41:0x01d8, B:45:0x01ea, B:49:0x01f0, B:51:0x01f8, B:44:0x01e4), top: B:62:0x01ca }] */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    public void G() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i;
        String str7 = StringUtilities.LF;
        String str8 = "excel_log_error=";
        String str9 = "f5";
        String str10 = "f4";
        this.p = new StringBuilder();
        Log.d("excel_log=", "...start read file.." + this.h);
        try {
            try {
                if (this.h == 1) {
                    this.q.clear();
                    if (this.k) {
                        this.q = B();
                    } else {
                        this.q = B();
                    }
                    if (this.q == null) {
                        return;
                    }
                    int i2 = 0;
                    while (i2 < this.q.size()) {
                        Z00 z00 = this.g;
                        str = str7;
                        try {
                            StringBuilder sb = new StringBuilder();
                            str2 = str8;
                            try {
                                sb.append("insert into excel_data(f1,f2,f3,f4,f5,f6,f7) values('");
                                sb.append(((String) ((HashMap) this.q.get(i2)).get("f1")).toString());
                                sb.append("','");
                                sb.append(((String) ((HashMap) this.q.get(i2)).get("f2")).toString().replaceAll(",", "").replaceAll("-", ""));
                                sb.append("','");
                                sb.append(((String) ((HashMap) this.q.get(i2)).get("f3")).toString().replaceAll(",", "").replaceAll("-", ""));
                                sb.append("','");
                                sb.append(((String) ((HashMap) this.q.get(i2)).get("f4")).toString().replaceAll(",", "").replaceAll("-", ""));
                                sb.append("','");
                                sb.append(((String) ((HashMap) this.q.get(i2)).get(str9)).toString());
                                sb.append("','");
                                str3 = str9;
                                try {
                                    sb.append(((String) ((HashMap) this.q.get(i2)).get("f6")).toString());
                                    sb.append("','");
                                    sb.append(((String) ((HashMap) this.q.get(i2)).get("f7")).toString());
                                    sb.append("')");
                                    z00.v0(sb.toString());
                                    i2++;
                                    str7 = str;
                                    str8 = str2;
                                    str9 = str3;
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            } catch (Exception e3) {
                                e = e3;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            str2 = str8;
                        }
                    }
                    str = str7;
                    str2 = str8;
                    str3 = str9;
                    this.g.v0("update excel_data set f2=0 where f2='' or f2 is null ");
                    this.g.v0("update excel_data set f3=0 where f3='' or f3 is null ");
                    this.g.v0("update excel_data set f4=0 where f4='' or f4 is null ");
                    this.g.v0("update excel_data set f5=trim(ifnull(f5,'')),f6=trim(ifnull(f6,'')),f7=trim(ifnull(f7,''))");
                    this.t.clear();
                    this.t = this.g.M7();
                    str2 = str8;
                    str3 = str9;
                    str5 = str2;
                    Log.d(str5, e.getMessage() + "");
                    e.printStackTrace();
                    StringBuilder sb2 = this.p;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(e.getMessage());
                    str4 = str;
                    sb3.append(str4);
                    sb2.append(sb3.toString());
                    if (this.h == 2) {
                        this.q.clear();
                        if (this.k) {
                            this.q = B();
                        } else {
                            this.q = B();
                        }
                        if (this.q == null) {
                            return;
                        }
                        i = 0;
                        while (i < this.q.size()) {
                            Z00 z01 = this.g;
                            StringBuilder sb4 = new StringBuilder();
                            str6 = str4;
                            try {
                                sb4.append("insert into excel_data(f1,f2,f3,f4,f5) values('");
                                sb4.append(((String) ((HashMap) this.q.get(i)).get("f1")).toString());
                                sb4.append("','");
                                sb4.append(((String) ((HashMap) this.q.get(i)).get("f2")).toString());
                                sb4.append("','");
                                sb4.append(((String) ((HashMap) this.q.get(i)).get("f3")).toString());
                                sb4.append("','");
                                sb4.append(((String) ((HashMap) this.q.get(i)).get(str10)).toString().replaceAll(",", "").replaceAll("-", ""));
                                sb4.append("','");
                                String str11 = str10;
                                String str12 = str3;
                                sb4.append(((String) ((HashMap) this.q.get(i)).get(str12)).toString().replaceAll(",", "").replaceAll("-", ""));
                                sb4.append("')");
                                z01.v0(sb4.toString());
                                i++;
                                str3 = str12;
                                str10 = str11;
                                str4 = str6;
                            } catch (Exception e5) {
                                e = e5;
                            }
                        }
                        str6 = str4;
                        this.g.v0("update excel_data set f4=0 where f4='' or f4 is null ");
                        this.g.v0("update excel_data set f5=0 where f5='' or f5 is null ");
                        this.t.clear();
                        this.t = this.g.L7();
                        return;
                    }
                    return;
                }
                str = StringUtilities.LF;
                str2 = "excel_log_error=";
                str3 = "f5";
                if (this.h == 2) {
                    this.q.clear();
                    if (this.k) {
                        this.q = B();
                    } else {
                        this.q = B();
                    }
                    if (this.q == null) {
                        return;
                    }
                    i = 0;
                    while (i < this.q.size()) {
                        Z00 z02 = this.g;
                        StringBuilder sb5 = new StringBuilder();
                        str6 = str4;
                        sb5.append("insert into excel_data(f1,f2,f3,f4,f5) values('");
                        sb5.append(((String) ((HashMap) this.q.get(i)).get("f1")).toString());
                        sb5.append("','");
                        sb5.append(((String) ((HashMap) this.q.get(i)).get("f2")).toString());
                        sb5.append("','");
                        sb5.append(((String) ((HashMap) this.q.get(i)).get("f3")).toString());
                        sb5.append("','");
                        sb5.append(((String) ((HashMap) this.q.get(i)).get(str10)).toString().replaceAll(",", "").replaceAll("-", ""));
                        sb5.append("','");
                        String str13 = str10;
                        String str14 = str3;
                        sb5.append(((String) ((HashMap) this.q.get(i)).get(str14)).toString().replaceAll(",", "").replaceAll("-", ""));
                        sb5.append("')");
                        z02.v0(sb5.toString());
                        i++;
                        str3 = str14;
                        str10 = str13;
                        str4 = str6;
                    }
                    str6 = str4;
                    this.g.v0("update excel_data set f4=0 where f4='' or f4 is null ");
                    this.g.v0("update excel_data set f5=0 where f5='' or f5 is null ");
                    this.t.clear();
                    this.t = this.g.L7();
                    return;
                }
                return;
            } catch (Exception e6) {
                e = e6;
                str6 = str4;
            }
            str4 = str;
            str5 = str2;
        } catch (Exception e7) {
            e = e7;
            str = str7;
        }
        Log.d(str5, e.getMessage() + "");
        e.printStackTrace();
        this.p.append(e.getMessage() + str6);
    }

    public void H() {
        if (this.t.size() != 0 || this.q.size() <= 0) {
            this.e.setEnabled(false);
            this.p.append(getString(R.string.not_valid_data) + this.t.size());
            for (int i = 0; i < this.t.size(); i++) {
                this.p.append(((String) this.t.get(i)).toString() + StringUtilities.LF);
            }
        } else {
            this.e.setEnabled(true);
            this.p.insert(0, getString(R.string.valid_data) + " : " + this.q.size() + StringUtilities.LF);
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.file_data));
            sb.append(this.q.size());
            sb.append(StringUtilities.LF);
            Log.d("excel_log=", sb.toString());
        }
        this.c.setText(this.p.toString());
    }

    public void I() {
        F(true);
        new Thread(new e()).start();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Log.d("excel_log:requestCode=", "" + i + ":" + i2 + ":");
        if (i2 != 0) {
            try {
                if (i == this.j) {
                    E(intent);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.d("excel_log_error=", "results=" + e2.getMessage());
                this.p.append(e2.getMessage() + StringUtilities.LF);
            }
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_excel_import);
        Z00 z00 = new Z00(this.f, this);
        this.g = z00;
        z00.v0("create table excel_data (id integer primary key,f1 text,f2 text,f3 text, f4 text,f5 text,f6 text,f7 text,f8 text,f9 text,f10 text,log text);");
        this.g.v0("delete from excel_data");
        this.d = (Button) findViewById(R.id.browse);
        Button button = (Button) findViewById(R.id.save);
        this.e = button;
        button.setEnabled(false);
        TextView textView = (TextView) findViewById(R.id.desc_);
        this.c = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        C0372Bn c0372Bn = C0372Bn.f;
        c0372Bn.a(this, this.d);
        c0372Bn.a(this, this.e);
        c0372Bn.a(this, this.c);
        if (getIntent().getStringExtra("loader_id") != null) {
            this.h = Integer.parseInt(getIntent().getStringExtra("loader_id"));
            this.i = getIntent().getStringExtra("acc_id") != null ? Integer.parseInt(getIntent().getStringExtra("acc_id")) : 0;
        }
        this.d.setOnClickListener(new a());
        this.e.setOnClickListener(new b());
        this.c.setOnClickListener(new c());
        int i = this.h;
        if (i == 1) {
            this.c.setText(getString(R.string.item_excel_template) + getString(R.string.excel_template));
            int length = getString(R.string.item_excel_template).length();
            int length2 = (getString(R.string.item_excel_template) + getString(R.string.excel_template)).length();
            Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(this.c.getText());
            spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), length, length2, 33);
            this.c.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
            return;
        }
        if (i == 2) {
            this.c.setText(getString(R.string.account_excel_template) + getString(R.string.excel_template));
            int length3 = getString(R.string.account_excel_template).length();
            int length4 = (getString(R.string.account_excel_template) + getString(R.string.excel_template)).length();
            Spannable spannableNewSpannable2 = Spannable.Factory.getInstance().newSpannable(this.c.getText());
            spannableNewSpannable2.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), length3, length4, 33);
            this.c.setText(spannableNewSpannable2, TextView.BufferType.SPANNABLE);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void x() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
    }

    public void y(File file, File file2) {
        if (file.exists()) {
            try {
                FileChannel channel = new FileInputStream(file).getChannel();
                FileChannel channel2 = new FileOutputStream(file2).getChannel();
                if (channel2 != null && channel != null) {
                    channel2.transferFrom(channel, 0L, channel.size());
                }
                if (channel != null) {
                    channel.close();
                }
                if (channel2 != null) {
                    channel2.close();
                }
            } catch (Exception e2) {
                this.p.append(e2.getMessage() + StringUtilities.LF);
            }
        }
    }
}
