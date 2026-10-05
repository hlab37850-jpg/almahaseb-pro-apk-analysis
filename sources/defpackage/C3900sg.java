package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import info.aalmoghalis.inventory.R;
import java.util.List;

/* JADX INFO: renamed from: sg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3900sg extends BaseAdapter {
    public Context a;
    public List b;

    public C3900sg(Context context, List list) {
        this.a = context;
        this.b = list;
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
        if (view == null) {
            view = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.list_item4, (ViewGroup) null);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        TextView textView = (TextView) view.findViewById(R.id.title);
        C3874sM c3874sM = (C3874sM) this.b.get(i);
        C0372Bn.e.a(this.a, textView);
        imageView.setImageResource(c3874sM.a());
        textView.setText(c3874sM.b());
        return view;
    }
}
