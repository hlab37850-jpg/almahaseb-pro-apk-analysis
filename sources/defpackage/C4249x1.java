package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.paging.LoadState;
import androidx.paging.LoadStateAdapter;
import androidx.recyclerview.widget.RecyclerView;
import info.aalmoghalis.inventory.R;

/* JADX INFO: renamed from: x1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4249x1 extends LoadStateAdapter {
    public View.OnClickListener a;

    /* JADX INFO: renamed from: x1$a */
    public static class a extends RecyclerView.ViewHolder {
        public ProgressBar a;

        public a(ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.progress2, viewGroup, false));
            this.a = C3464nI.a(this.itemView).b;
        }

        public void a(LoadState loadState) {
            this.a.setVisibility(loadState instanceof LoadState.Loading ? 0 : 8);
        }
    }

    public C4249x1(View.OnClickListener onClickListener) {
        this.a = onClickListener;
    }

    @Override // androidx.paging.LoadStateAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, LoadState loadState) {
        aVar.a(loadState);
    }

    @Override // androidx.paging.LoadStateAdapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, LoadState loadState) {
        return new a(viewGroup, this.a);
    }
}
