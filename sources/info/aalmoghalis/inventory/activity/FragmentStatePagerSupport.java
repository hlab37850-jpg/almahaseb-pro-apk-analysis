package info.aalmoghalis.inventory.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.autofill.HintConstants;
import androidx.viewpager.widget.ViewPager;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.C0566Hd;
import defpackage.C0917Sq;
import defpackage.C4143vg;
import defpackage.C4145vh;
import defpackage.JC;
import defpackage.K5;
import defpackage.Q00;
import defpackage.ViewOnClickListenerC0967Uo;
import defpackage.ViewOnClickListenerC1049Xo;
import defpackage.ViewOnClickListenerC3091io;
import defpackage.ViewOnClickListenerC4396yo;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.App;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentStatePagerSupport extends BaseActivity implements f.A, g.D, h.D, j.D, i.D, ViewOnClickListenerC0967Uo.B, k.C, ViewOnClickListenerC4396yo.H, ViewOnClickListenerC3091io.C, l.B, e.J, k.B, ViewOnClickListenerC1049Xo.x, K5.P0 {
    public static String D = null;
    public static String E = null;
    public static String F = null;
    public static String G = null;
    public static String H = null;
    public static String I = null;
    public static String J = null;
    public static String K = null;
    public static String L = null;
    public static String M = null;
    public static String N = null;
    public static String O = null;
    public static String P = null;
    public static String Q = null;
    public static int R = 0;
    public static int S = 0;
    public static int T = 0;
    public static boolean U = false;
    public static int V = 0;
    public static boolean W = false;
    public static String X = "";
    public JC c;
    public ViewPager d;
    public SQLiteDatabase e;
    public Z00 f;
    public List g = new ArrayList();
    public ArrayList h = new ArrayList();
    public ArrayList i = new ArrayList();
    public ArrayList j = new ArrayList();
    public int[] k = {R.drawable.up, 1, R.drawable.down};
    public AutoCompleteTextView l = null;
    public EditText n = null;
    public EditText p = null;
    public TextView q = null;
    public TextView t = null;
    public Button u = null;
    public LinearLayout v = null;
    public ImageButton w = null;
    public Toolbar x = null;
    public int y = 0;
    public int z = 0;
    public ViewPager.OnPageChangeListener A = new b();
    public int B = 0;
    public int C = 0;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = FragmentStatePagerSupport.V;
            if (i != 0) {
                FragmentStatePagerSupport.this.d.setCurrentItem(i);
            }
            FragmentStatePagerSupport fragmentStatePagerSupport = FragmentStatePagerSupport.this;
            int i2 = fragmentStatePagerSupport.y;
            if (i2 == 2) {
                if (fragmentStatePagerSupport.i.size() > 0) {
                    FragmentStatePagerSupport.this.setTitle(((C0917Sq) FragmentStatePagerSupport.this.i.get(FragmentStatePagerSupport.V)).e() + "#" + ((C0917Sq) FragmentStatePagerSupport.this.i.get(FragmentStatePagerSupport.V)).b());
                    return;
                }
                return;
            }
            if (i2 == 0) {
                try {
                    fragmentStatePagerSupport.setTitle(((C4143vg) fragmentStatePagerSupport.h.get(FragmentStatePagerSupport.V)).j());
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            String str = "";
            if (i2 == 7) {
                try {
                    ArrayList arrayList = fragmentStatePagerSupport.j;
                    if (arrayList != null && arrayList.size() != 0) {
                        if (FragmentStatePagerSupport.S != 1) {
                            FragmentStatePagerSupport fragmentStatePagerSupport2 = FragmentStatePagerSupport.this;
                            fragmentStatePagerSupport2.setTitle(((C4145vh) fragmentStatePagerSupport2.j.get(FragmentStatePagerSupport.V)).a());
                            return;
                        }
                        FragmentStatePagerSupport fragmentStatePagerSupport3 = FragmentStatePagerSupport.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(((C4145vh) FragmentStatePagerSupport.this.j.get(FragmentStatePagerSupport.V)).n());
                        if (((C4145vh) FragmentStatePagerSupport.this.j.get(FragmentStatePagerSupport.V)).b() != null && !((C4145vh) FragmentStatePagerSupport.this.j.get(FragmentStatePagerSupport.V)).b().equals(".")) {
                            str = "-" + ((C4145vh) FragmentStatePagerSupport.this.j.get(FragmentStatePagerSupport.V)).b();
                        }
                        sb.append(str);
                        fragmentStatePagerSupport3.setTitle(sb.toString());
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (i2 == 73) {
                try {
                    fragmentStatePagerSupport.setTitle(((C4145vh) fragmentStatePagerSupport.j.get(FragmentStatePagerSupport.V)).a());
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            if (i2 == 11) {
                if (FragmentStatePagerSupport.L != null) {
                    str = FragmentStatePagerSupport.L + "#" + FragmentStatePagerSupport.this.getString(R.string.cash_tran);
                }
                fragmentStatePagerSupport.setTitle(str);
                return;
            }
            if (i2 == 17 || (i2 == 18 && FragmentStatePagerSupport.T == 2 && fragmentStatePagerSupport.j.size() > 0)) {
                FragmentStatePagerSupport.this.setTitle(((C4145vh) FragmentStatePagerSupport.this.j.get(FragmentStatePagerSupport.V)).n() + "#" + ((C4145vh) FragmentStatePagerSupport.this.j.get(FragmentStatePagerSupport.V)).a());
                return;
            }
            FragmentStatePagerSupport fragmentStatePagerSupport4 = FragmentStatePagerSupport.this;
            int i3 = fragmentStatePagerSupport4.y;
            if (i3 == 18 && FragmentStatePagerSupport.T == 3) {
                fragmentStatePagerSupport4.setTitle(((C4145vh) FragmentStatePagerSupport.this.j.get(FragmentStatePagerSupport.V)).s() + "#" + ((C4145vh) FragmentStatePagerSupport.this.j.get(FragmentStatePagerSupport.V)).t());
                return;
            }
            try {
                if (i3 == 8) {
                    Log.d("title=", ((C0917Sq) FragmentStatePagerSupport.this.i.get(FragmentStatePagerSupport.V)).e() + "#" + ((C0917Sq) FragmentStatePagerSupport.this.i.get(FragmentStatePagerSupport.V)).b());
                    FragmentStatePagerSupport.this.setTitle(((C0917Sq) FragmentStatePagerSupport.this.i.get(FragmentStatePagerSupport.V)).e() + "#" + ((C0917Sq) FragmentStatePagerSupport.this.i.get(FragmentStatePagerSupport.V)).b());
                } else {
                    if (i3 != 9) {
                        if (i3 == 12) {
                            fragmentStatePagerSupport4.setTitle(fragmentStatePagerSupport4.getString(R.string.action_report_groups));
                            return;
                        }
                        return;
                    }
                    Log.d("title=", FragmentStatePagerSupport.this.y + ":" + ((C0917Sq) FragmentStatePagerSupport.this.i.get(FragmentStatePagerSupport.V)).e() + "#" + ((C0917Sq) FragmentStatePagerSupport.this.i.get(FragmentStatePagerSupport.V)).b());
                    FragmentStatePagerSupport fragmentStatePagerSupport5 = FragmentStatePagerSupport.this;
                    fragmentStatePagerSupport5.setTitle(((C0917Sq) fragmentStatePagerSupport5.i.get(FragmentStatePagerSupport.V)).b());
                }
            } catch (Exception unused) {
            }
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public Boolean a = Boolean.TRUE;

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Log.d("Page Created=", i + "");
            FragmentStatePagerSupport.this.z(i);
        }
    }

    public class c implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public c(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            FragmentStatePagerSupport.this.d.setCurrentItem(i);
            this.a.dismiss();
        }
    }

    public class d implements AdapterView.OnItemClickListener {
        public final /* synthetic */ Dialog a;

        public d(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            FragmentStatePagerSupport.this.d.setCurrentItem(i);
            this.a.dismiss();
        }
    }

    private void A() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override // info.aalmoghalis.inventory.activity.f.A, info.aalmoghalis.inventory.activity.g.D, info.aalmoghalis.inventory.activity.h.D, info.aalmoghalis.inventory.activity.j.D, info.aalmoghalis.inventory.activity.i.D, defpackage.ViewOnClickListenerC0967Uo.B, info.aalmoghalis.inventory.activity.k.C, defpackage.ViewOnClickListenerC4396yo.H, defpackage.ViewOnClickListenerC3091io.C, info.aalmoghalis.inventory.activity.l.B, defpackage.ViewOnClickListenerC1049Xo.x, K5.P0
    public void onButtonClicked(View view) {
        Log.d("onButtonClicked=", this.y + "");
        int i = this.y;
        if (i == 7 || i == 17 || i == 18 || i == 11 || i == 71 || i == 72 || i == 73) {
            int currentItem = this.d.getCurrentItem();
            switch (view.getId()) {
                case R.id.move_left /* 2131297061 */:
                    if (currentItem != 0) {
                        this.d.setCurrentItem(currentItem - 1);
                    }
                    break;
                case R.id.move_right /* 2131297062 */:
                    if (this.y == 11) {
                        if (100 > currentItem) {
                            this.d.setCurrentItem(currentItem + 1);
                        }
                    } else if (this.j.size() > currentItem) {
                        this.d.setCurrentItem(currentItem + 1);
                    }
                    break;
            }
        }
        if (i == 1 || i == 8 || i == 9 || i == 3 || i == 10 || i == 12) {
            int currentItem2 = this.d.getCurrentItem();
            switch (view.getId()) {
                case R.id.move_left /* 2131297061 */:
                    if (currentItem2 != 0) {
                        this.d.setCurrentItem(currentItem2 - 1);
                    }
                    break;
                case R.id.move_right /* 2131297062 */:
                    if (this.i.size() > currentItem2) {
                        this.d.setCurrentItem(currentItem2 + 1);
                    }
                    break;
            }
        }
    }

    @Override // info.aalmoghalis.inventory.activity.k.B
    public void onButtonClicked2(MenuItem menuItem) {
        Log.d("onItemClicked=", this.y + ":" + R.id.print + ":" + menuItem.getItemId() + ":" + ((Object) menuItem.getTitle()));
        if (this.y == 9 && menuItem.getItemId() == R.id.list) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.i.size(); i++) {
                arrayList.add(((C0917Sq) this.i.get(i)).b());
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrayList);
            Dialog dialog = new Dialog(this);
            LinearLayout linearLayout = new LinearLayout(this);
            ListView listView = new ListView(this);
            listView.setAdapter((ListAdapter) arrayAdapter);
            listView.setOnItemClickListener(new d(dialog));
            linearLayout.setFocusable(true);
            linearLayout.addView(listView, -1, -1);
            dialog.setContentView(linearLayout);
            dialog.setTitle(menuItem.getTitle().toString());
            dialog.show();
        }
    }

    /* JADX WARN: Code duplicated, block: B:146:0x07a2 A[Catch: Exception -> 0x00c6, TRY_LEAVE, TryCatch #9 {Exception -> 0x00c6, blocks: (B:3:0x0014, B:8:0x002c, B:11:0x005e, B:13:0x0068, B:15:0x00bd, B:19:0x00cc, B:22:0x00da, B:24:0x00e4, B:26:0x00f0, B:27:0x00f8, B:28:0x0121, B:30:0x0129, B:32:0x013d, B:37:0x0157, B:39:0x0190, B:41:0x0194, B:43:0x01b3, B:42:0x01a3, B:44:0x01b5, B:134:0x06eb, B:136:0x0712, B:138:0x0716, B:140:0x071f, B:142:0x0739, B:144:0x0753, B:145:0x079a, B:212:0x0a9f, B:214:0x0aa3, B:216:0x0aa7, B:146:0x07a2, B:149:0x07b0, B:151:0x07b5, B:153:0x07be, B:155:0x07c3, B:157:0x07dd, B:158:0x080e, B:160:0x0813, B:162:0x082d, B:164:0x0847, B:165:0x0892, B:166:0x0896, B:168:0x08a0, B:170:0x08a6, B:172:0x08af, B:174:0x08c9, B:176:0x08e3, B:177:0x0914, B:178:0x0917, B:180:0x0921, B:182:0x0927, B:186:0x0935, B:188:0x094f, B:190:0x0969, B:191:0x09a2, B:194:0x09a8, B:196:0x09c4, B:198:0x09de, B:199:0x0a19, B:200:0x0a1c, B:202:0x0a26, B:204:0x0a2c, B:206:0x0a35, B:208:0x0a4f, B:210:0x0a6b, B:211:0x0a9b, B:35:0x0153, B:47:0x01cb, B:49:0x01d5, B:52:0x01e7, B:53:0x0213, B:55:0x0223, B:56:0x0251, B:59:0x0263, B:60:0x028d, B:62:0x029f, B:63:0x02cb, B:67:0x02fc, B:71:0x0338, B:73:0x0348, B:74:0x0366, B:76:0x0376, B:77:0x038c, B:79:0x039c, B:80:0x03b8, B:88:0x043f, B:95:0x0496, B:102:0x04ed, B:109:0x0574, B:119:0x05e0, B:120:0x05e5, B:127:0x066a, B:133:0x06e8, B:126:0x0665, B:108:0x056f, B:101:0x04e8, B:94:0x0491, B:87:0x043a, B:90:0x044f, B:104:0x04fd, B:83:0x03ca, B:129:0x067a, B:97:0x04a6, B:122:0x05f7), top: B:241:0x0014, inners: #0, #1, #5, #7, #8, #10 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x07b0 A[Catch: Exception -> 0x00c6, TRY_ENTER, TryCatch #9 {Exception -> 0x00c6, blocks: (B:3:0x0014, B:8:0x002c, B:11:0x005e, B:13:0x0068, B:15:0x00bd, B:19:0x00cc, B:22:0x00da, B:24:0x00e4, B:26:0x00f0, B:27:0x00f8, B:28:0x0121, B:30:0x0129, B:32:0x013d, B:37:0x0157, B:39:0x0190, B:41:0x0194, B:43:0x01b3, B:42:0x01a3, B:44:0x01b5, B:134:0x06eb, B:136:0x0712, B:138:0x0716, B:140:0x071f, B:142:0x0739, B:144:0x0753, B:145:0x079a, B:212:0x0a9f, B:214:0x0aa3, B:216:0x0aa7, B:146:0x07a2, B:149:0x07b0, B:151:0x07b5, B:153:0x07be, B:155:0x07c3, B:157:0x07dd, B:158:0x080e, B:160:0x0813, B:162:0x082d, B:164:0x0847, B:165:0x0892, B:166:0x0896, B:168:0x08a0, B:170:0x08a6, B:172:0x08af, B:174:0x08c9, B:176:0x08e3, B:177:0x0914, B:178:0x0917, B:180:0x0921, B:182:0x0927, B:186:0x0935, B:188:0x094f, B:190:0x0969, B:191:0x09a2, B:194:0x09a8, B:196:0x09c4, B:198:0x09de, B:199:0x0a19, B:200:0x0a1c, B:202:0x0a26, B:204:0x0a2c, B:206:0x0a35, B:208:0x0a4f, B:210:0x0a6b, B:211:0x0a9b, B:35:0x0153, B:47:0x01cb, B:49:0x01d5, B:52:0x01e7, B:53:0x0213, B:55:0x0223, B:56:0x0251, B:59:0x0263, B:60:0x028d, B:62:0x029f, B:63:0x02cb, B:67:0x02fc, B:71:0x0338, B:73:0x0348, B:74:0x0366, B:76:0x0376, B:77:0x038c, B:79:0x039c, B:80:0x03b8, B:88:0x043f, B:95:0x0496, B:102:0x04ed, B:109:0x0574, B:119:0x05e0, B:120:0x05e5, B:127:0x066a, B:133:0x06e8, B:126:0x0665, B:108:0x056f, B:101:0x04e8, B:94:0x0491, B:87:0x043a, B:90:0x044f, B:104:0x04fd, B:83:0x03ca, B:129:0x067a, B:97:0x04a6, B:122:0x05f7), top: B:241:0x0014, inners: #0, #1, #5, #7, #8, #10 }] */
    /* JADX WARN: Code duplicated, block: B:166:0x0896 A[Catch: Exception -> 0x00c6, TryCatch #9 {Exception -> 0x00c6, blocks: (B:3:0x0014, B:8:0x002c, B:11:0x005e, B:13:0x0068, B:15:0x00bd, B:19:0x00cc, B:22:0x00da, B:24:0x00e4, B:26:0x00f0, B:27:0x00f8, B:28:0x0121, B:30:0x0129, B:32:0x013d, B:37:0x0157, B:39:0x0190, B:41:0x0194, B:43:0x01b3, B:42:0x01a3, B:44:0x01b5, B:134:0x06eb, B:136:0x0712, B:138:0x0716, B:140:0x071f, B:142:0x0739, B:144:0x0753, B:145:0x079a, B:212:0x0a9f, B:214:0x0aa3, B:216:0x0aa7, B:146:0x07a2, B:149:0x07b0, B:151:0x07b5, B:153:0x07be, B:155:0x07c3, B:157:0x07dd, B:158:0x080e, B:160:0x0813, B:162:0x082d, B:164:0x0847, B:165:0x0892, B:166:0x0896, B:168:0x08a0, B:170:0x08a6, B:172:0x08af, B:174:0x08c9, B:176:0x08e3, B:177:0x0914, B:178:0x0917, B:180:0x0921, B:182:0x0927, B:186:0x0935, B:188:0x094f, B:190:0x0969, B:191:0x09a2, B:194:0x09a8, B:196:0x09c4, B:198:0x09de, B:199:0x0a19, B:200:0x0a1c, B:202:0x0a26, B:204:0x0a2c, B:206:0x0a35, B:208:0x0a4f, B:210:0x0a6b, B:211:0x0a9b, B:35:0x0153, B:47:0x01cb, B:49:0x01d5, B:52:0x01e7, B:53:0x0213, B:55:0x0223, B:56:0x0251, B:59:0x0263, B:60:0x028d, B:62:0x029f, B:63:0x02cb, B:67:0x02fc, B:71:0x0338, B:73:0x0348, B:74:0x0366, B:76:0x0376, B:77:0x038c, B:79:0x039c, B:80:0x03b8, B:88:0x043f, B:95:0x0496, B:102:0x04ed, B:109:0x0574, B:119:0x05e0, B:120:0x05e5, B:127:0x066a, B:133:0x06e8, B:126:0x0665, B:108:0x056f, B:101:0x04e8, B:94:0x0491, B:87:0x043a, B:90:0x044f, B:104:0x04fd, B:83:0x03ca, B:129:0x067a, B:97:0x04a6, B:122:0x05f7), top: B:241:0x0014, inners: #0, #1, #5, #7, #8, #10 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x08a0 A[Catch: Exception -> 0x00c6, TryCatch #9 {Exception -> 0x00c6, blocks: (B:3:0x0014, B:8:0x002c, B:11:0x005e, B:13:0x0068, B:15:0x00bd, B:19:0x00cc, B:22:0x00da, B:24:0x00e4, B:26:0x00f0, B:27:0x00f8, B:28:0x0121, B:30:0x0129, B:32:0x013d, B:37:0x0157, B:39:0x0190, B:41:0x0194, B:43:0x01b3, B:42:0x01a3, B:44:0x01b5, B:134:0x06eb, B:136:0x0712, B:138:0x0716, B:140:0x071f, B:142:0x0739, B:144:0x0753, B:145:0x079a, B:212:0x0a9f, B:214:0x0aa3, B:216:0x0aa7, B:146:0x07a2, B:149:0x07b0, B:151:0x07b5, B:153:0x07be, B:155:0x07c3, B:157:0x07dd, B:158:0x080e, B:160:0x0813, B:162:0x082d, B:164:0x0847, B:165:0x0892, B:166:0x0896, B:168:0x08a0, B:170:0x08a6, B:172:0x08af, B:174:0x08c9, B:176:0x08e3, B:177:0x0914, B:178:0x0917, B:180:0x0921, B:182:0x0927, B:186:0x0935, B:188:0x094f, B:190:0x0969, B:191:0x09a2, B:194:0x09a8, B:196:0x09c4, B:198:0x09de, B:199:0x0a19, B:200:0x0a1c, B:202:0x0a26, B:204:0x0a2c, B:206:0x0a35, B:208:0x0a4f, B:210:0x0a6b, B:211:0x0a9b, B:35:0x0153, B:47:0x01cb, B:49:0x01d5, B:52:0x01e7, B:53:0x0213, B:55:0x0223, B:56:0x0251, B:59:0x0263, B:60:0x028d, B:62:0x029f, B:63:0x02cb, B:67:0x02fc, B:71:0x0338, B:73:0x0348, B:74:0x0366, B:76:0x0376, B:77:0x038c, B:79:0x039c, B:80:0x03b8, B:88:0x043f, B:95:0x0496, B:102:0x04ed, B:109:0x0574, B:119:0x05e0, B:120:0x05e5, B:127:0x066a, B:133:0x06e8, B:126:0x0665, B:108:0x056f, B:101:0x04e8, B:94:0x0491, B:87:0x043a, B:90:0x044f, B:104:0x04fd, B:83:0x03ca, B:129:0x067a, B:97:0x04a6, B:122:0x05f7), top: B:241:0x0014, inners: #0, #1, #5, #7, #8, #10 }] */
    /* JADX WARN: Code duplicated, block: B:178:0x0917 A[Catch: Exception -> 0x00c6, TryCatch #9 {Exception -> 0x00c6, blocks: (B:3:0x0014, B:8:0x002c, B:11:0x005e, B:13:0x0068, B:15:0x00bd, B:19:0x00cc, B:22:0x00da, B:24:0x00e4, B:26:0x00f0, B:27:0x00f8, B:28:0x0121, B:30:0x0129, B:32:0x013d, B:37:0x0157, B:39:0x0190, B:41:0x0194, B:43:0x01b3, B:42:0x01a3, B:44:0x01b5, B:134:0x06eb, B:136:0x0712, B:138:0x0716, B:140:0x071f, B:142:0x0739, B:144:0x0753, B:145:0x079a, B:212:0x0a9f, B:214:0x0aa3, B:216:0x0aa7, B:146:0x07a2, B:149:0x07b0, B:151:0x07b5, B:153:0x07be, B:155:0x07c3, B:157:0x07dd, B:158:0x080e, B:160:0x0813, B:162:0x082d, B:164:0x0847, B:165:0x0892, B:166:0x0896, B:168:0x08a0, B:170:0x08a6, B:172:0x08af, B:174:0x08c9, B:176:0x08e3, B:177:0x0914, B:178:0x0917, B:180:0x0921, B:182:0x0927, B:186:0x0935, B:188:0x094f, B:190:0x0969, B:191:0x09a2, B:194:0x09a8, B:196:0x09c4, B:198:0x09de, B:199:0x0a19, B:200:0x0a1c, B:202:0x0a26, B:204:0x0a2c, B:206:0x0a35, B:208:0x0a4f, B:210:0x0a6b, B:211:0x0a9b, B:35:0x0153, B:47:0x01cb, B:49:0x01d5, B:52:0x01e7, B:53:0x0213, B:55:0x0223, B:56:0x0251, B:59:0x0263, B:60:0x028d, B:62:0x029f, B:63:0x02cb, B:67:0x02fc, B:71:0x0338, B:73:0x0348, B:74:0x0366, B:76:0x0376, B:77:0x038c, B:79:0x039c, B:80:0x03b8, B:88:0x043f, B:95:0x0496, B:102:0x04ed, B:109:0x0574, B:119:0x05e0, B:120:0x05e5, B:127:0x066a, B:133:0x06e8, B:126:0x0665, B:108:0x056f, B:101:0x04e8, B:94:0x0491, B:87:0x043a, B:90:0x044f, B:104:0x04fd, B:83:0x03ca, B:129:0x067a, B:97:0x04a6, B:122:0x05f7), top: B:241:0x0014, inners: #0, #1, #5, #7, #8, #10 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x0921 A[Catch: Exception -> 0x00c6, TryCatch #9 {Exception -> 0x00c6, blocks: (B:3:0x0014, B:8:0x002c, B:11:0x005e, B:13:0x0068, B:15:0x00bd, B:19:0x00cc, B:22:0x00da, B:24:0x00e4, B:26:0x00f0, B:27:0x00f8, B:28:0x0121, B:30:0x0129, B:32:0x013d, B:37:0x0157, B:39:0x0190, B:41:0x0194, B:43:0x01b3, B:42:0x01a3, B:44:0x01b5, B:134:0x06eb, B:136:0x0712, B:138:0x0716, B:140:0x071f, B:142:0x0739, B:144:0x0753, B:145:0x079a, B:212:0x0a9f, B:214:0x0aa3, B:216:0x0aa7, B:146:0x07a2, B:149:0x07b0, B:151:0x07b5, B:153:0x07be, B:155:0x07c3, B:157:0x07dd, B:158:0x080e, B:160:0x0813, B:162:0x082d, B:164:0x0847, B:165:0x0892, B:166:0x0896, B:168:0x08a0, B:170:0x08a6, B:172:0x08af, B:174:0x08c9, B:176:0x08e3, B:177:0x0914, B:178:0x0917, B:180:0x0921, B:182:0x0927, B:186:0x0935, B:188:0x094f, B:190:0x0969, B:191:0x09a2, B:194:0x09a8, B:196:0x09c4, B:198:0x09de, B:199:0x0a19, B:200:0x0a1c, B:202:0x0a26, B:204:0x0a2c, B:206:0x0a35, B:208:0x0a4f, B:210:0x0a6b, B:211:0x0a9b, B:35:0x0153, B:47:0x01cb, B:49:0x01d5, B:52:0x01e7, B:53:0x0213, B:55:0x0223, B:56:0x0251, B:59:0x0263, B:60:0x028d, B:62:0x029f, B:63:0x02cb, B:67:0x02fc, B:71:0x0338, B:73:0x0348, B:74:0x0366, B:76:0x0376, B:77:0x038c, B:79:0x039c, B:80:0x03b8, B:88:0x043f, B:95:0x0496, B:102:0x04ed, B:109:0x0574, B:119:0x05e0, B:120:0x05e5, B:127:0x066a, B:133:0x06e8, B:126:0x0665, B:108:0x056f, B:101:0x04e8, B:94:0x0491, B:87:0x043a, B:90:0x044f, B:104:0x04fd, B:83:0x03ca, B:129:0x067a, B:97:0x04a6, B:122:0x05f7), top: B:241:0x0014, inners: #0, #1, #5, #7, #8, #10 }] */
    /* JADX WARN: Code duplicated, block: B:200:0x0a1c A[Catch: Exception -> 0x00c6, TryCatch #9 {Exception -> 0x00c6, blocks: (B:3:0x0014, B:8:0x002c, B:11:0x005e, B:13:0x0068, B:15:0x00bd, B:19:0x00cc, B:22:0x00da, B:24:0x00e4, B:26:0x00f0, B:27:0x00f8, B:28:0x0121, B:30:0x0129, B:32:0x013d, B:37:0x0157, B:39:0x0190, B:41:0x0194, B:43:0x01b3, B:42:0x01a3, B:44:0x01b5, B:134:0x06eb, B:136:0x0712, B:138:0x0716, B:140:0x071f, B:142:0x0739, B:144:0x0753, B:145:0x079a, B:212:0x0a9f, B:214:0x0aa3, B:216:0x0aa7, B:146:0x07a2, B:149:0x07b0, B:151:0x07b5, B:153:0x07be, B:155:0x07c3, B:157:0x07dd, B:158:0x080e, B:160:0x0813, B:162:0x082d, B:164:0x0847, B:165:0x0892, B:166:0x0896, B:168:0x08a0, B:170:0x08a6, B:172:0x08af, B:174:0x08c9, B:176:0x08e3, B:177:0x0914, B:178:0x0917, B:180:0x0921, B:182:0x0927, B:186:0x0935, B:188:0x094f, B:190:0x0969, B:191:0x09a2, B:194:0x09a8, B:196:0x09c4, B:198:0x09de, B:199:0x0a19, B:200:0x0a1c, B:202:0x0a26, B:204:0x0a2c, B:206:0x0a35, B:208:0x0a4f, B:210:0x0a6b, B:211:0x0a9b, B:35:0x0153, B:47:0x01cb, B:49:0x01d5, B:52:0x01e7, B:53:0x0213, B:55:0x0223, B:56:0x0251, B:59:0x0263, B:60:0x028d, B:62:0x029f, B:63:0x02cb, B:67:0x02fc, B:71:0x0338, B:73:0x0348, B:74:0x0366, B:76:0x0376, B:77:0x038c, B:79:0x039c, B:80:0x03b8, B:88:0x043f, B:95:0x0496, B:102:0x04ed, B:109:0x0574, B:119:0x05e0, B:120:0x05e5, B:127:0x066a, B:133:0x06e8, B:126:0x0665, B:108:0x056f, B:101:0x04e8, B:94:0x0491, B:87:0x043a, B:90:0x044f, B:104:0x04fd, B:83:0x03ca, B:129:0x067a, B:97:0x04a6, B:122:0x05f7), top: B:241:0x0014, inners: #0, #1, #5, #7, #8, #10 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x0a26 A[Catch: Exception -> 0x00c6, TryCatch #9 {Exception -> 0x00c6, blocks: (B:3:0x0014, B:8:0x002c, B:11:0x005e, B:13:0x0068, B:15:0x00bd, B:19:0x00cc, B:22:0x00da, B:24:0x00e4, B:26:0x00f0, B:27:0x00f8, B:28:0x0121, B:30:0x0129, B:32:0x013d, B:37:0x0157, B:39:0x0190, B:41:0x0194, B:43:0x01b3, B:42:0x01a3, B:44:0x01b5, B:134:0x06eb, B:136:0x0712, B:138:0x0716, B:140:0x071f, B:142:0x0739, B:144:0x0753, B:145:0x079a, B:212:0x0a9f, B:214:0x0aa3, B:216:0x0aa7, B:146:0x07a2, B:149:0x07b0, B:151:0x07b5, B:153:0x07be, B:155:0x07c3, B:157:0x07dd, B:158:0x080e, B:160:0x0813, B:162:0x082d, B:164:0x0847, B:165:0x0892, B:166:0x0896, B:168:0x08a0, B:170:0x08a6, B:172:0x08af, B:174:0x08c9, B:176:0x08e3, B:177:0x0914, B:178:0x0917, B:180:0x0921, B:182:0x0927, B:186:0x0935, B:188:0x094f, B:190:0x0969, B:191:0x09a2, B:194:0x09a8, B:196:0x09c4, B:198:0x09de, B:199:0x0a19, B:200:0x0a1c, B:202:0x0a26, B:204:0x0a2c, B:206:0x0a35, B:208:0x0a4f, B:210:0x0a6b, B:211:0x0a9b, B:35:0x0153, B:47:0x01cb, B:49:0x01d5, B:52:0x01e7, B:53:0x0213, B:55:0x0223, B:56:0x0251, B:59:0x0263, B:60:0x028d, B:62:0x029f, B:63:0x02cb, B:67:0x02fc, B:71:0x0338, B:73:0x0348, B:74:0x0366, B:76:0x0376, B:77:0x038c, B:79:0x039c, B:80:0x03b8, B:88:0x043f, B:95:0x0496, B:102:0x04ed, B:109:0x0574, B:119:0x05e0, B:120:0x05e5, B:127:0x066a, B:133:0x06e8, B:126:0x0665, B:108:0x056f, B:101:0x04e8, B:94:0x0491, B:87:0x043a, B:90:0x044f, B:104:0x04fd, B:83:0x03ca, B:129:0x067a, B:97:0x04a6, B:122:0x05f7), top: B:241:0x0014, inners: #0, #1, #5, #7, #8, #10 }] */
    /* JADX WARN: Code duplicated, block: B:206:0x0a35 A[Catch: Exception -> 0x00c6, TryCatch #9 {Exception -> 0x00c6, blocks: (B:3:0x0014, B:8:0x002c, B:11:0x005e, B:13:0x0068, B:15:0x00bd, B:19:0x00cc, B:22:0x00da, B:24:0x00e4, B:26:0x00f0, B:27:0x00f8, B:28:0x0121, B:30:0x0129, B:32:0x013d, B:37:0x0157, B:39:0x0190, B:41:0x0194, B:43:0x01b3, B:42:0x01a3, B:44:0x01b5, B:134:0x06eb, B:136:0x0712, B:138:0x0716, B:140:0x071f, B:142:0x0739, B:144:0x0753, B:145:0x079a, B:212:0x0a9f, B:214:0x0aa3, B:216:0x0aa7, B:146:0x07a2, B:149:0x07b0, B:151:0x07b5, B:153:0x07be, B:155:0x07c3, B:157:0x07dd, B:158:0x080e, B:160:0x0813, B:162:0x082d, B:164:0x0847, B:165:0x0892, B:166:0x0896, B:168:0x08a0, B:170:0x08a6, B:172:0x08af, B:174:0x08c9, B:176:0x08e3, B:177:0x0914, B:178:0x0917, B:180:0x0921, B:182:0x0927, B:186:0x0935, B:188:0x094f, B:190:0x0969, B:191:0x09a2, B:194:0x09a8, B:196:0x09c4, B:198:0x09de, B:199:0x0a19, B:200:0x0a1c, B:202:0x0a26, B:204:0x0a2c, B:206:0x0a35, B:208:0x0a4f, B:210:0x0a6b, B:211:0x0a9b, B:35:0x0153, B:47:0x01cb, B:49:0x01d5, B:52:0x01e7, B:53:0x0213, B:55:0x0223, B:56:0x0251, B:59:0x0263, B:60:0x028d, B:62:0x029f, B:63:0x02cb, B:67:0x02fc, B:71:0x0338, B:73:0x0348, B:74:0x0366, B:76:0x0376, B:77:0x038c, B:79:0x039c, B:80:0x03b8, B:88:0x043f, B:95:0x0496, B:102:0x04ed, B:109:0x0574, B:119:0x05e0, B:120:0x05e5, B:127:0x066a, B:133:0x06e8, B:126:0x0665, B:108:0x056f, B:101:0x04e8, B:94:0x0491, B:87:0x043a, B:90:0x044f, B:104:0x04fd, B:83:0x03ca, B:129:0x067a, B:97:0x04a6, B:122:0x05f7), top: B:241:0x0014, inners: #0, #1, #5, #7, #8, #10 }] */
    /* JADX WARN: Code duplicated, block: B:208:0x0a4f A[Catch: Exception -> 0x00c6, TryCatch #9 {Exception -> 0x00c6, blocks: (B:3:0x0014, B:8:0x002c, B:11:0x005e, B:13:0x0068, B:15:0x00bd, B:19:0x00cc, B:22:0x00da, B:24:0x00e4, B:26:0x00f0, B:27:0x00f8, B:28:0x0121, B:30:0x0129, B:32:0x013d, B:37:0x0157, B:39:0x0190, B:41:0x0194, B:43:0x01b3, B:42:0x01a3, B:44:0x01b5, B:134:0x06eb, B:136:0x0712, B:138:0x0716, B:140:0x071f, B:142:0x0739, B:144:0x0753, B:145:0x079a, B:212:0x0a9f, B:214:0x0aa3, B:216:0x0aa7, B:146:0x07a2, B:149:0x07b0, B:151:0x07b5, B:153:0x07be, B:155:0x07c3, B:157:0x07dd, B:158:0x080e, B:160:0x0813, B:162:0x082d, B:164:0x0847, B:165:0x0892, B:166:0x0896, B:168:0x08a0, B:170:0x08a6, B:172:0x08af, B:174:0x08c9, B:176:0x08e3, B:177:0x0914, B:178:0x0917, B:180:0x0921, B:182:0x0927, B:186:0x0935, B:188:0x094f, B:190:0x0969, B:191:0x09a2, B:194:0x09a8, B:196:0x09c4, B:198:0x09de, B:199:0x0a19, B:200:0x0a1c, B:202:0x0a26, B:204:0x0a2c, B:206:0x0a35, B:208:0x0a4f, B:210:0x0a6b, B:211:0x0a9b, B:35:0x0153, B:47:0x01cb, B:49:0x01d5, B:52:0x01e7, B:53:0x0213, B:55:0x0223, B:56:0x0251, B:59:0x0263, B:60:0x028d, B:62:0x029f, B:63:0x02cb, B:67:0x02fc, B:71:0x0338, B:73:0x0348, B:74:0x0366, B:76:0x0376, B:77:0x038c, B:79:0x039c, B:80:0x03b8, B:88:0x043f, B:95:0x0496, B:102:0x04ed, B:109:0x0574, B:119:0x05e0, B:120:0x05e5, B:127:0x066a, B:133:0x06e8, B:126:0x0665, B:108:0x056f, B:101:0x04e8, B:94:0x0491, B:87:0x043a, B:90:0x044f, B:104:0x04fd, B:83:0x03ca, B:129:0x067a, B:97:0x04a6, B:122:0x05f7), top: B:241:0x0014, inners: #0, #1, #5, #7, #8, #10 }] */
    /* JADX WARN: Code duplicated, block: B:273:0x0a9b A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        int size;
        int i;
        boolean z;
        super.onCreate(bundle);
        setContentView(R.layout.fragment_pager);
        V = 0;
        U = false;
        try {
            A();
            try {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(this);
                Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    declaredField.setBoolean(viewConfiguration, false);
                }
            } catch (Exception unused) {
            }
            this.f = new Z00(this.e, this);
            A();
            Intent intent = getIntent();
            if (getIntent().getStringExtra("CUS_NAME") == null || getIntent().getStringExtra("screen_no") != null) {
                if (getIntent().getStringExtra("screen_no") != null) {
                    if (getIntent().getStringExtra("screen_no").equals("1")) {
                        String stringExtra = getIntent().getStringExtra("g_id");
                        E = stringExtra;
                        this.i = y(stringExtra);
                        setTitle(getIntent().getStringExtra("title_"));
                        this.c = new JC(getSupportFragmentManager(), this.i, 1, (Context) this);
                        this.y = 1;
                    } else if (getIntent().getStringExtra("screen_no").equals("6")) {
                        this.i = x(getIntent().getIntExtra("TR_TYPE", 1));
                        setTitle(getIntent().getStringExtra("title_"));
                        this.c = new JC(getSupportFragmentManager(), this.i, 6, (Context) this);
                        this.y = 6;
                    } else if (getIntent().getStringExtra("screen_no").equals("3")) {
                        this.i = (ArrayList) intent.getExtras().getSerializable("dataGroups");
                        setTitle(getIntent().getStringExtra("title_"));
                        this.c = new JC(getSupportFragmentManager(), this.i, 3, (Context) this);
                        this.y = 3;
                    } else {
                        str = ":";
                        if (getIntent().getStringExtra("screen_no").equals("10")) {
                            this.i = (ArrayList) intent.getExtras().getSerializable("dataGroups");
                            setTitle(getIntent().getStringExtra("title_"));
                            this.c = new JC(getSupportFragmentManager(), this.i, 10, (Context) this);
                            this.y = 10;
                        } else {
                            try {
                                if (getIntent().getStringExtra("screen_no").equals("8")) {
                                    this.i = (ArrayList) intent.getExtras().getSerializable("dataGroups");
                                    this.c = new JC(getSupportFragmentManager(), this.i, 8, (Context) this);
                                    this.y = 8;
                                } else if (getIntent().getStringExtra("screen_no").equals("9")) {
                                    this.i = (ArrayList) intent.getExtras().getSerializable("dataGroups");
                                    setTitle(getIntent().getStringExtra("title_"));
                                    this.c = new JC(getSupportFragmentManager(), this.i, 9, (Context) this);
                                    this.y = 9;
                                } else if (getIntent().getStringExtra("screen_no").equals("2")) {
                                    this.i = (ArrayList) intent.getExtras().getSerializable("dataGroups");
                                    this.c = new JC(getSupportFragmentManager(), this.i, 2, (Context) this);
                                    this.y = 2;
                                } else if (getIntent().getStringExtra("screen_no").equals("5")) {
                                    intent.getExtras();
                                    this.c = new JC(getSupportFragmentManager(), this.i, 5, (Context) this);
                                    this.y = 5;
                                } else if (getIntent().getStringExtra("screen_no").equals("12")) {
                                    intent.getExtras();
                                    this.i = Z00.g0;
                                    this.c = new JC(getSupportFragmentManager(), this.i, 12, (Context) this);
                                    this.y = 12;
                                } else if (getIntent().getStringExtra("screen_no").equals("7")) {
                                    try {
                                        intent.getExtras();
                                        this.j = (ArrayList) ((App) getApplication()).a();
                                        Log.d("item_det=", "FragmentPager:" + this.j.size());
                                        M = getIntent().getStringExtra("br_name");
                                        S = getIntent().getIntExtra("report_type", 2);
                                        O = getIntent().getStringExtra("f_date");
                                        P = getIntent().getStringExtra("t_date");
                                        this.c = new JC(getSupportFragmentManager(), this.j, 7, this, M);
                                        this.y = 7;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else if (getIntent().getStringExtra("screen_no").equals("71")) {
                                    try {
                                        intent.getExtras();
                                        this.j = (ArrayList) ((App) getApplication()).a();
                                        M = getIntent().getStringExtra("br_name");
                                        S = getIntent().getIntExtra("report_type", 1);
                                        this.c = new JC(getSupportFragmentManager(), this.j, 71, this, M);
                                        this.y = 71;
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                } else {
                                    if (!getIntent().getStringExtra("screen_no").equals("72")) {
                                        if (getIntent().getStringExtra("screen_no").equals("73")) {
                                            try {
                                                intent.getExtras();
                                                this.j = (ArrayList) ((App) getApplication()).a();
                                                Log.d("item_det=", "FragmentPager:" + this.j.size());
                                                M = getIntent().getStringExtra("br_name");
                                                S = getIntent().getIntExtra("report_type", 2);
                                                O = getIntent().getStringExtra("f_date");
                                                P = getIntent().getStringExtra("t_date");
                                                this.c = new JC(getSupportFragmentManager(), this.j, 73, this, M);
                                                this.y = 73;
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                            }
                                        } else if (getIntent().getStringExtra("screen_no").equals("17")) {
                                            try {
                                                intent.getExtras();
                                                this.j = (ArrayList) ((App) getApplication()).a();
                                                M = getIntent().getStringExtra("br_name");
                                                str2 = "item_name";
                                                try {
                                                    N = getIntent().getStringExtra(str2);
                                                    O = getIntent().getStringExtra("f_date");
                                                    P = getIntent().getStringExtra("t_date");
                                                    this.c = new JC(getSupportFragmentManager(), this.j, 17, this, M);
                                                    this.y = 17;
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    e.printStackTrace();
                                                }
                                            } catch (Exception e5) {
                                                e = e5;
                                                str2 = "item_name";
                                            }
                                        } else {
                                            str2 = "item_name";
                                            if (getIntent().getStringExtra("screen_no").equals("18")) {
                                                try {
                                                    intent.getExtras();
                                                    this.j = (ArrayList) ((App) getApplication()).a();
                                                    M = getIntent().getStringExtra("br_name");
                                                    N = getIntent().getStringExtra(str2);
                                                    T = getIntent().getIntExtra("report_type2", 0);
                                                    O = getIntent().getStringExtra("f_date");
                                                    P = getIntent().getStringExtra("t_date");
                                                    Q = getIntent().getStringExtra("item_type");
                                                    this.c = new JC(getSupportFragmentManager(), this.j, 18, this, M);
                                                    this.y = 18;
                                                } catch (Exception e6) {
                                                    e6.printStackTrace();
                                                }
                                            } else if (getIntent().getStringExtra("screen_no").equals("11")) {
                                                try {
                                                    D = getIntent().getStringExtra("CUS_ID");
                                                    L = getIntent().getStringExtra("CUS_NAME");
                                                    K = getIntent().getStringExtra("CUS_GSM");
                                                    G = getIntent().getStringExtra("CURR_NAME");
                                                    F = getIntent().getStringExtra("g_name");
                                                    R = getIntent().getIntExtra("adv_search", 0);
                                                    O = getIntent().getStringExtra("f_date");
                                                    P = getIntent().getStringExtra("t_date");
                                                    this.c = new JC(getSupportFragmentManager(), this.j, 11, this, L);
                                                    this.y = 11;
                                                } catch (Exception e7) {
                                                    e7.printStackTrace();
                                                }
                                            }
                                        }
                                        e.printStackTrace();
                                    }
                                    try {
                                        intent.getExtras();
                                        this.j = (ArrayList) ((App) getApplication()).a();
                                        M = getIntent().getStringExtra("br_name");
                                        S = getIntent().getIntExtra("report_type", 1);
                                        this.c = new JC(getSupportFragmentManager(), this.j, 72, this, M);
                                        this.y = 72;
                                    } catch (Exception e8) {
                                        e8.printStackTrace();
                                    }
                                }
                            } catch (Exception unused2) {
                            }
                        }
                        str2 = "item_name";
                    }
                }
                ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
                this.d = viewPager;
                viewPager.setAdapter(this.c);
                this.d.addOnPageChangeListener(this.A);
                this.d.setOffscreenPageLimit(1);
                if (getIntent().getStringExtra("CUS_NAME") != null || this.y != 0) {
                    String str3 = str;
                    if (getIntent().getStringExtra(str2) == null && this.y == 7) {
                        int size2 = this.j.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            if (S == 2 && ((C4145vh) this.j.get(i2)).a().equals(getIntent().getStringExtra(str2))) {
                                Log.d("item_name2=", ((C4145vh) this.j.get(i2)).a() + str3 + getIntent().getStringExtra(str2));
                                z(i2);
                                U = true;
                                break;
                            } else {
                                if (S == 1 && ((C4145vh) this.j.get(i2)).n().equals(getIntent().getStringExtra(str2)) && ((C4145vh) this.j.get(i2)).a().equals(getIntent().getStringExtra("br_name"))) {
                                    Log.d("item_name2=", ((C4145vh) this.j.get(i2)).n() + str3 + getIntent().getStringExtra(str2) + str3 + ((C4145vh) this.j.get(i2)).a() + str3 + M);
                                    z(i2);
                                    U = true;
                                    break;
                                }
                            }
                        }
                    } else if (getIntent().getStringExtra(str2) == null && this.y == 17) {
                        int size3 = this.j.size();
                        for (int i3 = 0; i3 < size3; i3++) {
                            if (((C4145vh) this.j.get(i3)).n().equals(getIntent().getStringExtra(str2)) && ((C4145vh) this.j.get(i3)).a().equals(getIntent().getStringExtra("br_name"))) {
                                Log.d("item_name2=", ((C4145vh) this.j.get(i3)).n() + str3 + getIntent().getStringExtra(str2));
                                z(i3);
                                U = true;
                                break;
                            }
                        }
                    } else if (getIntent().getStringExtra(str2) == null && this.y == 18) {
                        int size4 = this.j.size();
                        if (T != 2) {
                            for (int i4 = 0; i4 < size4; i4++) {
                                if (((C4145vh) this.j.get(i4)).a().equals(getIntent().getStringExtra("item_name2")) && ((C4145vh) this.j.get(i4)).s().equals(getIntent().getStringExtra("br_name"))) {
                                    Log.d("item_name2=", ((C4145vh) this.j.get(i4)).a() + str3 + getIntent().getStringExtra("item_name2") + str3 + T);
                                    z(i4);
                                    U = true;
                                    break;
                                }
                            }
                        } else {
                            for (int i5 = 0; i5 < size4; i5++) {
                                if (((C4145vh) this.j.get(i5)).n().equals(getIntent().getStringExtra(str2)) && ((C4145vh) this.j.get(i5)).a().equals(getIntent().getStringExtra("br_name"))) {
                                    Log.d("item_name2=", ((C4145vh) this.j.get(i5)).n() + str3 + getIntent().getStringExtra(str2) + str3 + T);
                                    z(i5);
                                    U = true;
                                    break;
                                }
                            }
                        }
                    } else if (getIntent().getStringExtra(str2) != null && this.y == 73) {
                        size = this.j.size();
                        for (i = 0; i < size; i++) {
                            if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2)) && ((C4145vh) this.j.get(i)).n().equals(getIntent().getStringExtra("unit_name"))) {
                                Log.d("item_name2=", ((C4145vh) this.j.get(i)).n() + str3 + getIntent().getStringExtra(str2));
                                z(i);
                                U = true;
                                break;
                            }
                        }
                    }
                } else {
                    int size5 = this.h.size();
                    int i6 = 0;
                    while (i6 < size5) {
                        if (((C4143vg) this.h.get(i6)).j().equals(getIntent().getStringExtra("CUS_NAME")) && ((C4143vg) this.h.get(i6)).b().equals(getIntent().getStringExtra("CURR_NAME"))) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(((C4143vg) this.h.get(i6)).b());
                            String str4 = str;
                            sb.append(str4);
                            sb.append(L);
                            sb.append(str4);
                            sb.append(getIntent().getStringExtra("CURR_NAME"));
                            Log.d("cus_name2=", sb.toString());
                            X = getIntent().getStringExtra("CUS_NAME");
                            z(i6);
                            U = true;
                            break;
                        }
                        i6++;
                        str = str;
                    }
                }
                if (V == 0 || U) {
                }
                z(0);
                return;
            }
            String stringExtra2 = getIntent().getStringExtra("CUS_ID");
            D = stringExtra2;
            H = this.f.v3(stringExtra2);
            String stringExtra3 = getIntent().getStringExtra("CUS_NAME");
            L = stringExtra3;
            Log.d("cus_name1=", stringExtra3);
            J = getIntent().getStringExtra("CUS_BAL");
            K = getIntent().getStringExtra("CUS_GSM");
            E = getIntent().getStringExtra("g_id");
            G = getIntent().getStringExtra("CURR_NAME");
            I = getIntent().getStringExtra("show_move_tr") != null ? getIntent().getStringExtra("show_move_tr") : "0";
            String stringExtra4 = getIntent().getStringExtra("f_date");
            String stringExtra5 = CSS.Value.PERCENTAGE;
            O = stringExtra4 != null ? getIntent().getStringExtra("f_date") : CSS.Value.PERCENTAGE;
            if (getIntent().getStringExtra("t_date") != null) {
                stringExtra5 = getIntent().getStringExtra("t_date");
            }
            P = stringExtra5;
            R = getIntent().getIntExtra("adv_search", 0);
            intent.getExtras();
            List listB = ((App) getApplication()).b();
            ArrayList arrayList = new ArrayList(listB.size());
            this.h = arrayList;
            arrayList.addAll(listB);
            int i7 = 0;
            while (true) {
                if (i7 >= this.h.size()) {
                    z = false;
                    break;
                } else {
                    if (L.equals(((C4143vg) this.h.get(i7)).j()) && G.equals(((C4143vg) this.h.get(i7)).b())) {
                        z = true;
                        break;
                    }
                    i7++;
                }
            }
            Log.d("clicked_name=", L + ":" + z + ":" + E + ":" + G + "#" + this.h.size());
            if (!z) {
                this.h = !Z00.Z ? w(this.f.D4(E, H)) : w(this.f.H4(E, G, H));
            }
            this.c = new JC(getSupportFragmentManager(), (List) this.h, 0, (Context) this);
            this.y = 0;
            str = ":";
            str2 = "item_name";
            ViewPager viewPager2 = (ViewPager) findViewById(R.id.pager);
            this.d = viewPager2;
            viewPager2.setAdapter(this.c);
            this.d.addOnPageChangeListener(this.A);
            this.d.setOffscreenPageLimit(1);
            if (getIntent().getStringExtra("CUS_NAME") != null) {
                String str5 = str;
                if (getIntent().getStringExtra(str2) == null) {
                    if (getIntent().getStringExtra(str2) == null) {
                        if (getIntent().getStringExtra(str2) == null) {
                            if (getIntent().getStringExtra(str2) != null) {
                                size = this.j.size();
                                while (i < size) {
                                    if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2))) {
                                    }
                                }
                            }
                        } else if (getIntent().getStringExtra(str2) != null) {
                            size = this.j.size();
                            while (i < size) {
                                if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2))) {
                                }
                            }
                        }
                    } else if (getIntent().getStringExtra(str2) == null) {
                        if (getIntent().getStringExtra(str2) != null) {
                            size = this.j.size();
                            while (i < size) {
                                if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2))) {
                                }
                            }
                        }
                    } else if (getIntent().getStringExtra(str2) != null) {
                        size = this.j.size();
                        while (i < size) {
                            if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2))) {
                            }
                        }
                    }
                } else if (getIntent().getStringExtra(str2) == null) {
                    if (getIntent().getStringExtra(str2) == null) {
                        if (getIntent().getStringExtra(str2) != null) {
                            size = this.j.size();
                            while (i < size) {
                                if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2))) {
                                }
                            }
                        }
                    } else if (getIntent().getStringExtra(str2) != null) {
                        size = this.j.size();
                        while (i < size) {
                            if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2))) {
                            }
                        }
                    }
                } else if (getIntent().getStringExtra(str2) == null) {
                    if (getIntent().getStringExtra(str2) != null) {
                        size = this.j.size();
                        while (i < size) {
                            if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2))) {
                            }
                        }
                    }
                } else if (getIntent().getStringExtra(str2) != null) {
                    size = this.j.size();
                    while (i < size) {
                        if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2))) {
                        }
                    }
                }
            } else {
                String str6 = str;
                if (getIntent().getStringExtra(str2) == null) {
                    if (getIntent().getStringExtra(str2) == null) {
                        if (getIntent().getStringExtra(str2) == null) {
                            if (getIntent().getStringExtra(str2) != null) {
                                size = this.j.size();
                                while (i < size) {
                                    if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2))) {
                                    }
                                }
                            }
                        } else if (getIntent().getStringExtra(str2) != null) {
                            size = this.j.size();
                            while (i < size) {
                                if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2))) {
                                }
                            }
                        }
                    } else if (getIntent().getStringExtra(str2) == null) {
                        if (getIntent().getStringExtra(str2) != null) {
                            size = this.j.size();
                            while (i < size) {
                                if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2))) {
                                }
                            }
                        }
                    } else if (getIntent().getStringExtra(str2) != null) {
                        size = this.j.size();
                        while (i < size) {
                            if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2))) {
                            }
                        }
                    }
                } else if (getIntent().getStringExtra(str2) == null) {
                    if (getIntent().getStringExtra(str2) == null) {
                        if (getIntent().getStringExtra(str2) != null) {
                            size = this.j.size();
                            while (i < size) {
                                if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2))) {
                                }
                            }
                        }
                    } else if (getIntent().getStringExtra(str2) != null) {
                        size = this.j.size();
                        while (i < size) {
                            if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2))) {
                            }
                        }
                    }
                } else if (getIntent().getStringExtra(str2) == null) {
                    if (getIntent().getStringExtra(str2) != null) {
                        size = this.j.size();
                        while (i < size) {
                            if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2))) {
                            }
                        }
                    }
                } else if (getIntent().getStringExtra(str2) != null) {
                    size = this.j.size();
                    while (i < size) {
                        if (!((C4145vh) this.j.get(i)).a().equals(getIntent().getStringExtra(str2))) {
                        }
                    }
                }
            }
            if (V == 0) {
            }
        } catch (Exception e9) {
            e9.printStackTrace();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        Q00 q00 = FragmentStatePagerSupport_Main.S;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        U = false;
        super.onResume();
    }

    public ArrayList w(Cursor cursor) {
        Log.d("trace_S_Loader_g_cus=", FragmentStatePagerSupport_Main.X());
        ArrayList arrayList = new ArrayList();
        C0566Hd c0566Hd = new C0566Hd();
        arrayList.clear();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(new C4143vg(cursor.getString(c0566Hd.b(cursor, HTML.Attribute.ID)), cursor.getString(c0566Hd.b(cursor, "_id")), cursor.getString(c0566Hd.b(cursor, HintConstants.AUTOFILL_HINT_PHONE)), cursor.getDouble(c0566Hd.b(cursor, "amount")), this.k[cursor.getInt(c0566Hd.b(cursor, "_in"))], 0, cursor.getString(c0566Hd.b(cursor, "g_name")), cursor.getString(c0566Hd.b(cursor, "curr_name")), cursor.getString(c0566Hd.b(cursor, "cnt"))));
            cursor.moveToNext();
        }
        cursor.close();
        Log.d("trace_E_Loader_g_cus=", FragmentStatePagerSupport_Main.X());
        return arrayList;
    }

    public ArrayList x(int i) {
        ArrayList arrayList = new ArrayList();
        Log.d("tr_type=", i + "");
        Cursor cursorX1 = this.f.X1(i);
        Log.d("recCount_Det=", cursorX1.getCount() + "");
        this.g.clear();
        cursorX1.moveToFirst();
        while (!cursorX1.isAfterLast()) {
            arrayList.add(new C0917Sq(cursorX1.getString(cursorX1.getColumnIndex("_id")), cursorX1.getString(cursorX1.getColumnIndex("g_name")), cursorX1.getString(cursorX1.getColumnIndex("curr_name"))));
            cursorX1.moveToNext();
        }
        cursorX1.close();
        return arrayList;
    }

    public ArrayList y(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorG2 = str.equals("0") ? this.f.G2() : this.f.H2(str);
        cursorG2.getCount();
        arrayList.clear();
        cursorG2.moveToFirst();
        while (!cursorG2.isAfterLast()) {
            arrayList.add(new C0917Sq(cursorG2.getString(cursorG2.getColumnIndex("_id")), cursorG2.getString(cursorG2.getColumnIndex("g_name")), cursorG2.getString(cursorG2.getColumnIndex("curr_name"))));
            cursorG2.moveToNext();
        }
        cursorG2.close();
        return arrayList;
    }

    public void z(int i) {
        V = i;
        W = true;
        Log.d("myOnPageSelectedLogic=", V + ":" + this.y);
        new Handler().post(new a());
    }

    @Override // info.aalmoghalis.inventory.activity.e.J
    public void onButtonClicked(MenuItem menuItem) {
        Log.d("onItemClicked=", this.y + ":" + R.id.print + ":" + menuItem.getItemId() + ":" + ((Object) menuItem.getTitle()));
        if (this.y == 2 && menuItem.getItemId() == R.id.list) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.i.size(); i++) {
                arrayList.add(((C0917Sq) this.i.get(i)).b() + "(" + ((C0917Sq) this.i.get(i)).a() + ")" + ((C0917Sq) this.i.get(i)).e());
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrayList);
            Dialog dialog = new Dialog(this);
            LinearLayout linearLayout = new LinearLayout(this);
            ListView listView = new ListView(this);
            listView.setAdapter((ListAdapter) arrayAdapter);
            listView.setOnItemClickListener(new c(dialog));
            linearLayout.setFocusable(true);
            linearLayout.addView(listView, -1, -1);
            dialog.setContentView(linearLayout);
            dialog.setTitle(menuItem.getTitle().toString());
            dialog.show();
        }
    }
}
