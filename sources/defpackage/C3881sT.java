package defpackage;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: renamed from: sT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3881sT extends RecyclerView.Adapter {
    public List a;
    public LayoutInflater b;
    public int c;

    /* JADX INFO: renamed from: sT$a */
    public class a extends RecyclerView.ViewHolder {
        public TextView a;

        public a(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.text1);
        }
    }

    public C3881sT(Context context, List list, int i) {
        this.a = list;
        this.b = LayoutInflater.from(context);
        this.c = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        int i2 = this.c;
        int i3 = i / i2;
        aVar.a.setText((String) ((List) this.a.get(i3)).get(i % i2));
        aVar.a.setGravity(17);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.b.inflate(R.layout.simple_list_item_1, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size() * this.c;
    }
}
