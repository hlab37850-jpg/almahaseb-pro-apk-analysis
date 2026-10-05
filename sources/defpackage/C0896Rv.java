package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.TextView;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: Rv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0896Rv extends ArrayAdapter implements Filterable {
    public Context a;
    public LayoutInflater b;
    public int c;
    public List d;
    public List e;
    public String f;
    public SparseBooleanArray g;
    public ArrayList h;
    public Bitmap i;
    public Bitmap j;
    public int[] k;

    /* JADX INFO: renamed from: Rv$b */
    public static class b {
        public TextView a;
        public TextView b;
        public TextView c;
        public TextView d;

        public b() {
        }
    }

    public C0896Rv(Context context, int i, List list) {
        super(context, i, list);
        this.f = "";
        this.h = new ArrayList();
        this.k = new int[]{R.drawable.up, 1, R.drawable.down};
        this.g = new SparseBooleanArray();
        this.a = context;
        this.d = list;
        this.e = list;
        this.c = i;
        this.b = LayoutInflater.from(context);
        this.i = ((BitmapDrawable) context.getResources().getDrawable(this.k[0])).getBitmap();
        this.j = ((BitmapDrawable) context.getResources().getDrawable(this.k[2])).getBitmap();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C4143vg getItem(int i) {
        return (C4143vg) this.d.get(i);
    }

    public SparseBooleanArray b() {
        return this.g;
    }

    @Override // android.widget.ArrayAdapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void remove(C4143vg c4143vg) {
        this.d.remove(c4143vg);
        notifyDataSetChanged();
    }

    public void d() {
        this.g = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void e(int i, boolean z) {
        if (z) {
            this.g.put(i, z);
        } else {
            this.g.delete(i);
        }
        notifyDataSetChanged();
    }

    public void f(int i) {
        if (this.h.contains(Integer.valueOf(i))) {
            this.h.remove(Integer.valueOf(i));
        } else {
            this.h.add(Integer.valueOf(i));
        }
        e(i, !this.g.get(i));
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.d.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return this.d.indexOf(getItem(i));
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            int i2 = this.c;
            if (i2 == R.layout.list_backup) {
                b bVar = new b();
                view = this.b.inflate(this.c, (ViewGroup) null);
                bVar.a = (TextView) view.findViewById(R.id.file_id);
                bVar.b = (TextView) view.findViewById(R.id.title);
                bVar.c = (TextView) view.findViewById(R.id.bk_date);
                bVar.d = (TextView) view.findViewById(R.id.bk_size);
                view.setTag(bVar);
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
                bVar.a.setText(((C4143vg) this.d.get(i)).i());
                bVar.b.setText(((C4143vg) this.d.get(i)).j());
                bVar.c.setText(((C4143vg) this.d.get(i)).h());
                bVar.d.setText(((C4143vg) this.d.get(i)).f());
            } else if (i2 == R.layout.info_item) {
                b bVar2 = new b();
                view = this.b.inflate(this.c, (ViewGroup) null);
                bVar2.a = (TextView) view.findViewById(R.id.info_name);
                view.setTag(bVar2);
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
                bVar2.a.setText(((C4143vg) this.d.get(i)).j());
            } else if (i2 == R.layout.info_item2) {
                b bVar3 = new b();
                view = this.b.inflate(this.c, (ViewGroup) null);
                bVar3.a = (TextView) view.findViewById(R.id.info_name);
                bVar3.b = (TextView) view.findViewById(R.id.info_address);
                bVar3.c = (TextView) view.findViewById(R.id.info_phone);
                view.setTag(bVar3);
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
                bVar3.a.setText(((C4143vg) this.d.get(i)).j());
                bVar3.b.setText(((C4143vg) this.d.get(i)).f());
                bVar3.c.setText(((C4143vg) this.d.get(i)).b());
            }
            if (this.h.contains(Integer.valueOf(i))) {
                view.setBackgroundColor(Color.parseColor(this.a.getString(R.string.bk_select_color)));
            } else {
                view.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        } catch (Exception unused) {
        }
        return view;
    }
}
