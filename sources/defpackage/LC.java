package defpackage;

import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import info.aalmoghalis.inventory.R;

/* JADX INFO: loaded from: classes3.dex */
public class LC extends RecyclerView.Adapter {
    public String[] a;
    public String b;

    public static class a extends RecyclerView.ViewHolder {
        public TextView a;
        public TextView b;

        public a(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.info_text);
            this.b = (TextView) view.findViewById(R.id.title);
        }
    }

    public LC(String[] strArr, String str) {
        this.a = strArr;
        this.b = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            aVar.a.setText(Html.fromHtml(this.a[i], 0));
        } else {
            aVar.a.setText(Html.fromHtml(this.a[i]));
        }
        aVar.b.setText(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.length;
    }
}
