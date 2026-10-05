package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zebra.sdk.util.internal.StringUtilities;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.SettingsActivity;
import info.aalmoghalis.inventory.activity.activationActivity;
import info.aalmoghalis.inventory.fcm.online_status;
import info.aalmoghalis.inventory.old.GroupList_edit;
import info.aalmoghalis.inventory.old.Tax_edit;
import info.aalmoghalis.inventory.old.UnitList_edit;
import info.aalmoghalis.inventory.old.Users;
import info.aalmoghalis.inventory.old.itemType_edit;
import info.aalmoghalis.inventory.zatca.ZatcaSettingsActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: rr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3832rr extends Fragment {
    public Z00 g;

    /* JADX INFO: renamed from: rr$b */
    public class b extends RecyclerView.Adapter {
        public final List a;

        public b(List list) {
            this.a = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(c cVar, int i) {
            cVar.b((a) this.a.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c onCreateViewHolder(ViewGroup viewGroup, int i) {
            return C3832rr.this.new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_header, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.size();
        }
    }

    /* JADX INFO: renamed from: rr$c */
    public class c extends RecyclerView.ViewHolder {
        public final TextView a;
        public final ImageView b;

        public c(View view) {
            super(view);
            this.b = (ImageView) view.findViewById(R.id.row_icon);
            this.a = (TextView) view.findViewById(R.id.row_title);
        }

        public void b(final a aVar) {
            this.b.setImageResource(aVar.a);
            this.a.setText(aVar.b);
            if (aVar.c != null) {
                this.a.setText(((Object) this.a.getText()) + StringUtilities.LF + aVar.c + "");
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: sr
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.c(aVar, view);
                }
            });
        }

        public final /* synthetic */ void c(a aVar, View view) {
            Fragment fragment = aVar.d;
            if (fragment != null) {
                C3832rr.this.f(fragment, aVar.b);
                return;
            }
            Intent intent = aVar.e;
            if (intent != null) {
                C3832rr.this.startActivity(intent);
            }
        }
    }

    public C3832rr(Z00 z00) {
        this.g = z00;
    }

    public final List d() {
        Context context;
        Context contextRequireContext = requireContext();
        ArrayList arrayList = new ArrayList(Arrays.asList(new a(R.drawable.s_info, R.string.pref_header_general, new SettingsActivity.GeneralPreferenceFragment()), new a(R.drawable.s_print_option, R.string.pref_header_data_sync, new SettingsActivity.DataSyncPreferenceFragment()), new a(R.drawable.s_security_option, R.string.pref_security, new SettingsActivity.SecurityPreferenceFragment()), new a(R.drawable.s_security_option, R.string.users, new Intent(contextRequireContext, (Class<?>) Users.class)), new a(R.drawable.s_cat, R.string.pref_group_curr, new Intent(contextRequireContext, (Class<?>) GroupList_edit.class)), new a(R.drawable.s_g_cat, R.string.pref_item_type, new Intent(contextRequireContext, (Class<?>) itemType_edit.class)), new a(R.drawable.s_units, R.string.pref_unit, new Intent(contextRequireContext, (Class<?>) UnitList_edit.class)), new a(R.drawable.s_save_option, R.string.pref_backup, new SettingsActivity.BackupPreferenceFragment()), new a(R.drawable.s_thermal, R.string.pref_thermal_options, new SettingsActivity.ThermalPreferenceFragment()), new a(R.drawable.s_tax, R.string.tax_setting, new Intent(contextRequireContext, (Class<?>) Tax_edit.class)), new a(R.drawable.s_thermal, R.string.barcode_option, new SettingsActivity.BarcodePreferenceFragment()), new a(R.drawable.s_ther_remarks, R.string.pref_SMS_WA_options, new SettingsActivity.SMS_WA_PreferenceFragment()), new a(R.drawable.s_other_option, R.string.pref_other_options, new SettingsActivity.OthersPreferenceFragment()), new a(R.drawable.s_name, R.string.pref_activation, new Intent(contextRequireContext, (Class<?>) activationActivity.class))));
        Z00 z00 = this.g;
        if (z00 != null) {
            if (z00.S()) {
                context = contextRequireContext;
                arrayList.add(new a(R.drawable.s_node, R.string.pref_online, new Intent(context, (Class<?>) online_status.class)));
            } else {
                context = contextRequireContext;
            }
            if ((this.g.Y5(Z00.R, Z00.S) > 0 && !this.g.ja("black_list", false)) || (!this.g.ia("token", "").equals("") && !this.g.ja("token_list", false))) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (((a) arrayList.get(i)).b == R.string.pref_activation) {
                        if (this.g.ia("expire_date_activation", "").length() <= 0) {
                            break;
                        }
                        arrayList.set(i, new a(R.drawable.s_name, R.string.renew_date, this.g.ia("expire_date_activation", "")));
                        break;
                    }
                }
            }
            if (C1839c10.J(this.g) && this.g.ja("pref_show_qr_code", false) && C2160f10.h == 0) {
                arrayList.add(new a(R.drawable.s_tax, R.string.zatca_setting, new Intent(context, (Class<?>) ZatcaSettingsActivity.class)));
            }
        }
        return arrayList;
    }

    public final void f(Fragment fragment, int i) {
        requireActivity().setTitle(i);
        requireActivity().getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.settings_container, fragment).addToBackStack(null).commit();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView = new RecyclerView(requireContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new b(d()));
        return recyclerView;
    }

    public C3832rr() {
    }

    /* JADX INFO: renamed from: rr$a */
    public final class a {
        public final int a;
        public final int b;
        public final String c;
        public final Fragment d;
        public final Intent e;

        public a(int i, int i2, Fragment fragment) {
            this.a = i;
            this.b = i2;
            this.d = fragment;
            this.e = null;
            this.c = null;
        }

        public a(int i, int i2, Intent intent) {
            this.a = i;
            this.b = i2;
            this.e = intent;
            this.d = null;
            this.c = null;
        }

        public a(int i, int i2, String str) {
            this.a = i;
            this.b = i2;
            this.e = null;
            this.d = null;
            this.c = str;
        }
    }
}
