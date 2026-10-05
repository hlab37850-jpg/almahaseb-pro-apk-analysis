package androidx.paging;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LoadStateAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private LoadState loadState = new LoadState.NotLoading(false);

    public boolean displayLoadStateAsItem(LoadState loadState) {
        AbstractC4492zt.h(loadState, "loadState");
        return (loadState instanceof LoadState.Loading) || (loadState instanceof LoadState.Error);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return displayLoadStateAsItem(this.loadState) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return getStateViewType(this.loadState);
    }

    public final LoadState getLoadState() {
        return this.loadState;
    }

    public int getStateViewType(LoadState loadState) {
        AbstractC4492zt.h(loadState, "loadState");
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(VH vh, int i) {
        AbstractC4492zt.h(vh, "holder");
        onBindViewHolder(vh, this.loadState);
    }

    public abstract void onBindViewHolder(VH vh, LoadState loadState);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC4492zt.h(viewGroup, "parent");
        return (VH) onCreateViewHolder(viewGroup, this.loadState);
    }

    public abstract VH onCreateViewHolder(ViewGroup viewGroup, LoadState loadState);

    public final void setLoadState(LoadState loadState) {
        AbstractC4492zt.h(loadState, "loadState");
        if (AbstractC4492zt.d(this.loadState, loadState)) {
            return;
        }
        boolean zDisplayLoadStateAsItem = displayLoadStateAsItem(this.loadState);
        boolean zDisplayLoadStateAsItem2 = displayLoadStateAsItem(loadState);
        if (zDisplayLoadStateAsItem && !zDisplayLoadStateAsItem2) {
            notifyItemRemoved(0);
        } else if (zDisplayLoadStateAsItem2 && !zDisplayLoadStateAsItem) {
            notifyItemInserted(0);
        } else if (zDisplayLoadStateAsItem && zDisplayLoadStateAsItem2) {
            notifyItemChanged(0);
        }
        this.loadState = loadState;
    }
}
