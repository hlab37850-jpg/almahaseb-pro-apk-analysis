package defpackage;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.internal.view.SupportMenu;
import com.itextpdf.tool.xml.html.HTML;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class RC extends BaseExpandableListAdapter implements Filterable {
    public Context a;
    public ArrayList b;
    public List c;
    public e d;
    public SQLiteDatabase f;
    public Z00 g;
    public d h;
    public String e = "";
    public Dialog i = null;
    public Handler j = new c();

    public class a implements View.OnClickListener {
        public final /* synthetic */ C3467nL a;
        public final /* synthetic */ int b;

        /* JADX INFO: renamed from: RC$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0014a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0014a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a aVar = a.this;
                ((C3549oL) RC.this.b.get(aVar.b)).e();
                RC.this.g.v0("delete from currency_price  where id='" + a.this.a.h() + "'  ");
                a aVar2 = a.this;
                C3549oL c3549oL = (C3549oL) RC.this.b.get(aVar2.b);
                a aVar3 = a.this;
                RC rc = RC.this;
                c3549oL.n(rc.c(((C3549oL) rc.b.get(aVar3.b)).j()));
                a aVar4 = a.this;
                RC rc2 = RC.this;
                rc2.e(rc2.g.i3(aVar4.a.i()));
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }

        public a(C3467nL c3467nL, int i) {
            this.a = c3467nL;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C2160f10.h > 0 && !new C2160f10(RC.this.g).l("20", HTML.Tag.DEL)) {
                Toast.makeText(RC.this.a, RC.this.a.getString(R.string.no_priv), 0).show();
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(RC.this.a);
            builder.setMessage(RC.this.a.getString(R.string.delete_msg) + "#" + this.a.i() + ":" + this.a.b() + "?");
            builder.setCancelable(false);
            builder.setPositiveButton(RC.this.a.getString(R.string.confirm_yes), new DialogInterfaceOnClickListenerC0014a());
            builder.setNegativeButton(RC.this.a.getString(R.string.confirm_no), new b());
            builder.create().show();
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RC.this.g.ne(this.a);
            Message message = new Message();
            message.obj = "1";
            RC.this.j.sendMessage(message);
        }
    }

    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("mProgress=f=", message.obj + "");
            if (message.obj.toString().equals("1")) {
                RC.this.notifyDataSetChanged();
                if (RC.this.h != null) {
                    RC.this.h.k();
                }
            }
            RC.this.d(false);
        }
    }

    public interface d {
        void k();
    }

    public class e extends Filter {
        public e() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            RC.this.e = charSequence.toString();
            if (charSequence.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < RC.this.c.size(); i++) {
                    if (((C3549oL) RC.this.c.get(i)).k().toUpperCase().contains(charSequence.toString().toUpperCase()) || ((C3549oL) RC.this.c.get(i)).i().toUpperCase().contains(charSequence.toString().toUpperCase())) {
                        C3549oL c3549oL = new C3549oL(((C3549oL) RC.this.c.get(i)).j(), ((C3549oL) RC.this.c.get(i)).k(), ((C3549oL) RC.this.c.get(i)).i(), ((C3549oL) RC.this.c.get(i)).b().replaceAll(",", ""), ((C3549oL) RC.this.c.get(i)).h().replaceAll(",", ""), ((C3549oL) RC.this.c.get(i)).m().replaceAll(",", ""), "", ((C3549oL) RC.this.c.get(i)).h.replaceAll(",", ""));
                        c3549oL.n(((C3549oL) RC.this.c.get(i)).e());
                        arrayList.add(c3549oL);
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            } else {
                filterResults.count = RC.this.c.size();
                filterResults.values = RC.this.c;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            RC rc = RC.this;
            rc.b = (ArrayList) filterResults.values;
            rc.notifyDataSetChanged();
        }

        public /* synthetic */ e(RC rc, a aVar) {
            this();
        }
    }

    public RC(Context context, ArrayList arrayList, d dVar) {
        this.a = context;
        this.b = arrayList;
        this.c = arrayList;
        this.g = new Z00(this.f, this.a);
        this.h = dVar;
    }

    public ArrayList c(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorDc = this.g.Dc(str);
        C0566Hd c0566Hd = new C0566Hd();
        cursorDc.moveToFirst();
        while (!cursorDc.isAfterLast()) {
            arrayList.add(new C3467nL(cursorDc.getString(c0566Hd.b(cursorDc, HTML.Attribute.ID)), cursorDc.getString(c0566Hd.b(cursorDc, "_id")), "", cursorDc.getString(c0566Hd.b(cursorDc, "price")), cursorDc.getString(c0566Hd.b(cursorDc, "f_date")), cursorDc.getString(c0566Hd.b(cursorDc, "t_date")), "", cursorDc.getString(c0566Hd.b(cursorDc, "price_sar"))));
            cursorDc.moveToNext();
        }
        c0566Hd.a();
        cursorDc.close();
        return arrayList;
    }

    public void d(boolean z) {
        Log.d("mProgress=", "....start..." + z);
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            builder.setView(((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.progress, (ViewGroup) null));
            if (z) {
                AlertDialog alertDialogCreate = builder.create();
                this.i = alertDialogCreate;
                alertDialogCreate.setCancelable(false);
                this.i.show();
            } else {
                Dialog dialog = this.i;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e(String str) {
        d(true);
        new Thread(new b(str)).start();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return ((C3549oL) this.b.get(i)).e().get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C3467nL c3467nL = (C3467nL) getChild(i, i2);
        if (view == null) {
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.report6_balance_group_exp, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.item_name);
        TextView textView2 = (TextView) view.findViewById(R.id.item_price);
        TextView textView3 = (TextView) view.findViewById(R.id.item_curr);
        TextView textView4 = (TextView) view.findViewById(R.id.start_date);
        ImageView imageView = (ImageView) view.findViewById(R.id.tr_delete);
        textView.setText(c3467nL.i());
        textView2.setText(c3467nL.b());
        textView3.setText(c3467nL.e());
        textView4.setText(c3467nL.k());
        TextView textView5 = (TextView) view.findViewById(R.id.item_price_sar);
        textView5.setVisibility(8);
        if (info.aalmoghalis.inventory.zatca.d.E(this.a)) {
            textView5.setVisibility(0);
            textView5.setText(c3467nL.h);
        }
        imageView.setOnClickListener(new a(c3467nL, i));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return ((C3549oL) this.b.get(i)).e().size();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.d == null) {
            this.d = new e(this, null);
        }
        return this.d;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.b.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C3549oL c3549oL = (C3549oL) getGroup(i);
        if (view == null) {
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.report3_balance_group_, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.item_name);
        TextView textView2 = (TextView) view.findViewById(R.id.item_price);
        TextView textView3 = (TextView) view.findViewById(R.id.item_curr);
        TextView textView4 = (TextView) view.findViewById(R.id.start_date);
        textView.setText(c3549oL.k());
        textView2.setText(c3549oL.b());
        textView3.setText(c3549oL.h());
        textView4.setText(c3549oL.m());
        TextView textView5 = (TextView) view.findViewById(R.id.item_price_sar);
        textView5.setVisibility(8);
        if (info.aalmoghalis.inventory.zatca.d.E(this.a)) {
            textView5.setVisibility(0);
            textView5.setText(c3549oL.h);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.indicator);
        imageView.setVisibility(0);
        if (z) {
            imageView.setImageResource(R.drawable.sort_up_);
        } else {
            imageView.setImageResource(R.drawable.sort_down_);
        }
        String lowerCase = c3549oL.k().toLowerCase(Locale.getDefault());
        if (lowerCase.contains(this.e)) {
            int iIndexOf = lowerCase.indexOf(this.e);
            int length = this.e.length() + iIndexOf;
            Spannable spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(textView.getText());
            spannableNewSpannable.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), iIndexOf, length, 33);
            textView.setText(spannableNewSpannable, TextView.BufferType.SPANNABLE);
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
