package defpackage;

import android.os.Bundle;
import android.view.View;
import androidx.preference.PreferenceFragmentCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: k7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3204k7 extends PreferenceFragmentCompat {
    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView listView = getListView();
        listView.addItemDecoration(new DividerItemDecoration(listView.getContext(), 1));
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
    }
}
