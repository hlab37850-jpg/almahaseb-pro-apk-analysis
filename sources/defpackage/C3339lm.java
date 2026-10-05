package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import info.aalmoghalis.inventory.R;
import java.util.ArrayList;
import java.util.Calendar;

/* JADX INFO: renamed from: lm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3339lm extends RecyclerView.Adapter implements Filterable {
    public static String g;
    public Context a;
    public ArrayList b;
    public ArrayList c;
    public b d;
    public String e = "";
    public LayoutInflater f;

    /* JADX INFO: renamed from: lm$b */
    public class b extends Filter {
        public b() {
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            C3339lm.this.e = charSequence.toString();
            if (charSequence.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < C3339lm.this.c.size(); i++) {
                    if (((C3257km) C3339lm.this.c.get(i)).h().toUpperCase().contains(charSequence.toString().toUpperCase()) || ((C3257km) C3339lm.this.c.get(i)).i().toUpperCase().contains(charSequence.toString().toUpperCase())) {
                        arrayList.add(new C3257km(((C3257km) C3339lm.this.c.get(i)).e(), ((C3257km) C3339lm.this.c.get(i)).i(), ((C3257km) C3339lm.this.c.get(i)).h(), ((C3257km) C3339lm.this.c.get(i)).b(), ((C3257km) C3339lm.this.c.get(i)).c(), ((C3257km) C3339lm.this.c.get(i)).f(), ((C3257km) C3339lm.this.c.get(i)).a()));
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
            } else {
                filterResults.count = C3339lm.this.c.size();
                filterResults.values = C3339lm.this.c;
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            C3339lm.this.b = (ArrayList) filterResults.values;
            C3339lm.this.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: lm$c */
    public static class c extends RecyclerView.ViewHolder {
        public TextView a;
        public TextView b;
        public TextView c;

        public c(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.info_title);
            this.c = (TextView) view.findViewById(R.id.info_date);
            this.b = (TextView) view.findViewById(R.id.info_text);
        }
    }

    public C3339lm(Context context, ArrayList arrayList) {
        this.a = context;
        this.b = arrayList;
        this.c = arrayList;
        g = String.valueOf(Calendar.getInstance().get(5));
        this.f = LayoutInflater.from(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i) {
        C3257km c3257km = (C3257km) this.b.get(i);
        try {
            Log.d("msg_id=", ((C3257km) this.b.get(i)).h() + ':' + ((C3257km) this.b.get(i)).e());
            cVar.a.setText(((C3257km) this.b.get(i)).h());
            cVar.b.setText(((C3257km) this.b.get(i)).c());
            cVar.c.setText(((C3257km) this.b.get(i)).b());
        } catch (Exception e) {
            Log.d("OnBindView error=", "msg_id=" + c3257km.e() + ":" + c3257km.i() + ":" + e.getMessage());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_notification, viewGroup, false));
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.d == null) {
            this.d = new b();
        }
        return this.d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList arrayList = this.b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }
}
