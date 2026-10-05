package defpackage;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.Bill_edit;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: rg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3819rg extends BaseAdapter {
    public Context a;
    public List b;
    public String[] c;
    public String d;
    public String e;
    public Z00 f;
    public Bundle g;
    public ArrayList h = new ArrayList();

    /* JADX INFO: renamed from: rg$a */
    public class a implements View.OnClickListener {
        public final /* synthetic */ C3874sM a;

        public a(C3874sM c3874sM) {
            this.a = c3874sM;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.a.b().equals(C3819rg.this.c[1].toString())) {
                if (C2160f10.h > 0 && !new C2160f10(C3819rg.this.f).l("-6", "new")) {
                    Context context = C3819rg.this.a;
                    Toast.makeText(context, context.getString(R.string.no_priv), 0).show();
                    return;
                }
                Intent intent = new Intent(C3819rg.this.a, (Class<?>) Bill_edit.class);
                intent.putExtra("TR_TYPE", String.valueOf(1));
                intent.putExtra("g_id", C3819rg.this.d);
                intent.putExtra("g_name", C3819rg.this.e);
                intent.putExtra("back_recyclerview", 1);
                C3819rg.this.a.startActivity(intent);
                return;
            }
            if (this.a.b().equals(C3819rg.this.c[3].toString())) {
                if (C2160f10.h > 0 && !new C2160f10(C3819rg.this.f).l("-7", "new")) {
                    Context context2 = C3819rg.this.a;
                    Toast.makeText(context2, context2.getString(R.string.no_priv), 0).show();
                    return;
                }
                Intent intent2 = new Intent(C3819rg.this.a, (Class<?>) Bill_edit.class);
                intent2.putExtra("TR_TYPE", String.valueOf(2));
                intent2.putExtra("g_id", C3819rg.this.d);
                intent2.putExtra("g_name", C3819rg.this.e);
                intent2.putExtra("back_recyclerview", 1);
                C3819rg.this.a.startActivity(intent2);
                return;
            }
            if (this.a.b().equals(C3819rg.this.c[2].toString())) {
                try {
                    Intent intent3 = new Intent(C3819rg.this.a, (Class<?>) FragmentStatePagerSupport.class);
                    intent3.putExtra("title_", this.a.b());
                    intent3.putExtra("screen_no", "9");
                    C3819rg.this.b();
                    intent3.putExtras(C3819rg.this.g);
                    C3819rg.this.a();
                    C3819rg.this.a.startActivity(intent3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: renamed from: rg$b */
    public static class b {
        public ImageView a;
        public ImageView b;
        public ImageView c;
        public LinearLayout d;
        public LinearLayout e;
        public TextView f;

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public C3819rg(Context context, List list, String str, String str2, Z00 z00) {
        this.a = context;
        this.b = list;
        this.d = str;
        this.e = str2;
        this.f = z00;
        this.c = context.getResources().getStringArray(R.array.titles4);
    }

    public void a() {
        Cursor cursorS4 = this.f.s4();
        Z00.i0.clear();
        cursorS4.moveToFirst();
        while (!cursorS4.isAfterLast()) {
            Z00.i0.add(new C4145vh(cursorS4.getString(cursorS4.getColumnIndex("_id")), cursorS4.getString(cursorS4.getColumnIndex("f1")), cursorS4.getString(cursorS4.getColumnIndex("f2")), cursorS4.getString(cursorS4.getColumnIndex("f3")), cursorS4.getString(cursorS4.getColumnIndex("f4")), cursorS4.getString(cursorS4.getColumnIndex("f5")), "", "", ""));
            cursorS4.moveToNext();
        }
        cursorS4.close();
    }

    public void b() {
        Cursor cursorW5 = this.f.W5();
        this.h.clear();
        cursorW5.moveToFirst();
        while (!cursorW5.isAfterLast()) {
            this.h.add(new C0917Sq(cursorW5.getString(cursorW5.getColumnIndex("_id")), cursorW5.getString(cursorW5.getColumnIndex("g_name")), "", cursorW5.getString(cursorW5.getColumnIndex("cus_type"))));
            cursorW5.moveToNext();
        }
        cursorW5.close();
        Bundle bundle = new Bundle();
        this.g = bundle;
        bundle.putSerializable("dataGroups", this.h);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.b.indexOf(getItem(i));
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            b bVar = new b(null);
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.list_item3, (ViewGroup) null);
            bVar.a = (ImageView) view.findViewById(R.id.icon);
            bVar.b = (ImageView) view.findViewById(R.id.icon_add);
            bVar.c = (ImageView) view.findViewById(R.id.icon_add2);
            C3966tX c3966tX = new C3966tX();
            bVar.a.setOnTouchListener(c3966tX.b);
            bVar.b.setOnTouchListener(c3966tX.b);
            bVar.b.setOnTouchListener(c3966tX.b);
            bVar.d = (LinearLayout) view.findViewById(R.id.add_icon1_LL);
            bVar.e = (LinearLayout) view.findViewById(R.id.add_icon2_LL);
            bVar.f = (TextView) view.findViewById(R.id.title);
            C3874sM c3874sM = (C3874sM) this.b.get(i);
            view.setTag(bVar);
            C0372Bn.e.a(this.a, bVar.f);
            bVar.a.setImageResource(c3874sM.a());
            bVar.f.setText(c3874sM.b());
            if (this.d.equals("0") || C2160f10.h > 0) {
                for (int i2 = 0; i2 < this.c.length; i2++) {
                    if (i2 % 2 == 0 && c3874sM.b().equals(this.c[i2].toString())) {
                        bVar.d.setVisibility(8);
                        bVar.e.setVisibility(8);
                    }
                }
            } else {
                bVar.d.setVisibility(8);
                bVar.e.setVisibility(8);
            }
            bVar.b.setOnClickListener(new a(c3874sM));
            return view;
        } catch (Exception e) {
            e.printStackTrace();
            return view;
        }
    }
}
