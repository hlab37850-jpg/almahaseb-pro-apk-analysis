package info.aalmoghalis.inventory.activity;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC1197a4;
import defpackage.AbstractC2242g10;
import defpackage.AbstractC3132jE;
import defpackage.AbstractC3425mq;
import defpackage.C3204k7;
import defpackage.C3832rr;
import defpackage.C3966tX;
import defpackage.IN;
import defpackage.InterfaceC2295gf;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.SettingsActivity;
import info.aalmoghalis.inventory.helper.Approval_add;
import info.aalmoghalis.inventory.helper.Signature_add;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class SettingsActivity extends BaseActivity implements info.aalmoghalis.inventory.activity.c.g, PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {
    public static Preference.OnPreferenceChangeListener f = new a();
    public static boolean g = false;
    public SQLiteDatabase c;
    public Z00 d;
    public String e = "";

    @TargetApi(11)
    public static class BackupPreferenceFragment extends C3204k7 implements SharedPreferences.OnSharedPreferenceChangeListener {
        public Z00 g;
        public SQLiteDatabase h;

        public class a implements TimePickerDialog.OnTimeSetListener {
            public a() {
            }

            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i, int i2) {
                BackupPreferenceFragment.this.g.Lc("prefBackup_time_h", String.valueOf(i));
                BackupPreferenceFragment.this.g.Lc("prefBackup_time_m", String.valueOf(i2));
                BackupPreferenceFragment.this.g.Mc("prefAutoBackup", true);
                BackupPreferenceFragment.this.findPreference("prefBackup_time_h").setSummary(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Integer.parseInt(BackupPreferenceFragment.this.g.ia("prefBackup_time_h", "0")))) + ":" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Integer.parseInt(BackupPreferenceFragment.this.g.ia("prefBackup_time_m", "0")))));
                BackupPreferenceFragment.this.g.Lc("db_data_changed", "1");
                BackupPreferenceFragment.this.g.Lc("db_data_changed2", "1");
                BackupPreferenceFragment.this.g.Lc("last_backup_time", "0");
                BackupPreferenceFragment.this.g.Lc("auto_drive_date_save", "");
                Z00.t0 = false;
                BackupPreferenceFragment backupPreferenceFragment = BackupPreferenceFragment.this;
                backupPreferenceFragment.g.Pc(backupPreferenceFragment.getActivity());
                ((SwitchPreference) BackupPreferenceFragment.this.findPreference("prefAutoBackup")).setChecked(true);
            }
        }

        public static /* synthetic */ void l(Integer num) {
        }

        public void f() {
            String strIa = this.g.ia("prefBackup_path", Z00.L);
            if (new C3966tX().l(new File(strIa), strIa, this.g) || !AbstractC3425mq.a(getActivity())) {
                h();
            } else {
                Z00.Y = "1";
                info.aalmoghalis.inventory.activity.c.m(info.aalmoghalis.inventory.activity.c.i.DirectorySelector, R.string.resourceID_OK, R.string.resourceID_Cancel, R.string.resourceID_Title2, android.R.drawable.ic_menu_set_as, android.R.drawable.ic_menu_directions, android.R.drawable.ic_menu_save).show(requireActivity().getSupportFragmentManager(), "Test");
            }
        }

        public void g() {
            Calendar.getInstance();
            TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new a(), Integer.parseInt(this.g.ia("prefBackup_time_h", "0")), Integer.parseInt(this.g.ia("prefBackup_time_m", "0")), true);
            timePickerDialog.setTitle(getActivity().getString(R.string.pref_backup_time));
            timePickerDialog.show();
        }

        public void h() {
            try {
                String strIa = this.g.ia("prefBackup_path", Z00.L);
                new File(strIa);
                Log.d("trace_app_check=", "path=" + strIa);
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
                intent.putExtra("android.provider.extra.INITIAL_URI", Uri.parse(strIa));
                intent.addFlags(1);
                intent.addFlags(2);
                intent.addFlags(64);
                startActivityForResult(intent, 3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void i() {
            startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 2);
        }

        public final File j(Uri uri) {
            Cursor cursorQuery = getActivity().getContentResolver().query(uri, new String[]{"_display_name", "_size"}, null, null, null);
            int columnIndex = cursorQuery.getColumnIndex("_display_name");
            int columnIndex2 = cursorQuery.getColumnIndex("_size");
            cursorQuery.moveToFirst();
            String string = cursorQuery.getString(columnIndex);
            Long.toString(cursorQuery.getLong(columnIndex2));
            File file = new File(Z00.M);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(Z00.M + "/" + string);
            try {
                InputStream inputStreamOpenInputStream = getActivity().getContentResolver().openInputStream(uri);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStreamOpenInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
                inputStreamOpenInputStream.close();
                fileOutputStream.close();
            } catch (Exception e) {
                Log.e("copy_err", e.getMessage() + ":" + string + ":" + file2);
                e.printStackTrace();
            }
            return file2;
        }

        public final /* synthetic */ Integer k(DocumentFile documentFile) {
            for (DocumentFile documentFile2 : documentFile.listFiles()) {
                if (documentFile2.isFile() && documentFile2.getType().contains("image")) {
                    if ((new File(new C3966tX().t(documentFile2.getUri())).getParentFile().getPath() + "/").equals(Z00.M)) {
                        return 1;
                    }
                    j(documentFile2.getUri());
                }
            }
            return 1;
        }

        @Override // androidx.fragment.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) {
            if (i == 2 && i2 == -1) {
                if (intent != null) {
                    Log.d("result=", intent.getData().toString());
                    final DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(getActivity().getBaseContext(), intent.getData());
                    AbstractC3132jE.d(new Callable() { // from class: UO
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.a.k(documentFileFromTreeUri);
                        }
                    }).m(IN.c()).g().e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: VO
                        @Override // defpackage.InterfaceC2295gf
                        public final void accept(Object obj) {
                            SettingsActivity.BackupPreferenceFragment.l((Integer) obj);
                        }
                    });
                    return;
                }
                return;
            }
            if (i == 3 && i2 == -1 && intent != null) {
                Uri data = intent.getData();
                this.g.Lc("app_path_uri", data.toString());
                int flags = intent.getFlags() & 3;
                getActivity().getContentResolver().takePersistableUriPermission(data, 1);
                getActivity().getContentResolver().takePersistableUriPermission(data, 2);
                getActivity().getContentResolver().takePersistableUriPermission(data, flags);
                DocumentFile documentFileFromTreeUri2 = DocumentFile.fromTreeUri(this.g.b, data);
                if (documentFileFromTreeUri2.canWrite() && documentFileFromTreeUri2.isDirectory()) {
                    this.g.Lc("prefBackup_path", new C3966tX().t(data));
                    this.g.he();
                    findPreference("prefBackup_path").setSummary(this.g.ia("prefBackup_path", Z00.L));
                }
                Log.d("trace_app_main=", "path=" + new C3966tX().t(data) + ":" + data.toString() + ":" + documentFileFromTreeUri2.canWrite());
            }
        }

        @Override // defpackage.C3204k7, androidx.preference.PreferenceFragmentCompat
        public void onCreatePreferences(Bundle bundle, String str) {
            addPreferencesFromResource(R.xml.pref_backup);
            setHasOptionsMenu(true);
            this.g = new Z00(this.h, getActivity());
            findPreference("prefBackup_path").setSummary(this.g.ia("prefBackup_path", Z00.L));
            findPreference("prefBackup_time_h").setSummary(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Integer.parseInt(this.g.ia("prefBackup_time_h", "0")))) + ":" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Integer.parseInt(this.g.ia("prefBackup_time_m", "0")))));
            SettingsActivity.B(findPreference("PREF_ACCOUNT_NAME"));
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            if (viewOnCreateView != null) {
            }
            return viewOnCreateView;
        }

        @Override // androidx.fragment.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity.class));
            return true;
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            super.onPause();
            getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
        public boolean onPreferenceTreeClick(Preference preference) {
            super.onPreferenceTreeClick(preference);
            if (preference != null && preference.getKey().equals("prefBackup_path")) {
                f();
                return false;
            }
            if (preference != null && preference.getKey().equals("prefBackup_pic_path")) {
                i();
                return false;
            }
            if (preference != null && preference.getKey().equals("prefBackup_time_h")) {
                g();
                return false;
            }
            if (preference != null && preference.getKey().equals("prefAutoBackup")) {
                this.g.Pc(getActivity());
                return false;
            }
            if (preference == null || !preference.getKey().equals("PREF_ACCOUNT_NAME")) {
                return false;
            }
            Intent intent = new Intent(getActivity(), (Class<?>) Google_drive_list.class);
            intent.putExtra("change_email_flag", "1");
            startActivity(intent);
            return false;
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
            try {
                SettingsActivity.B(findPreference("PREF_ACCOUNT_NAME"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (str.equalsIgnoreCase("prefBackup_path")) {
                findPreference(str).setSummary(this.g.ia("prefBackup_path", Z00.L));
            }
        }
    }

    @TargetApi(11)
    public static class BarcodePreferenceFragment extends C3204k7 implements SharedPreferences.OnSharedPreferenceChangeListener {
        public static boolean i = false;
        public Z00 g;
        public SQLiteDatabase h;

        @Override // defpackage.C3204k7, androidx.preference.PreferenceFragmentCompat
        public void onCreatePreferences(Bundle bundle, String str) {
            addPreferencesFromResource(R.xml.pref_barcode);
            setHasOptionsMenu(true);
            this.g = new Z00(this.h, getActivity());
            SettingsActivity.B(findPreference("item_barcode_col_cnt2"));
            SettingsActivity.B(findPreference("item_barcode_col_cnt"));
            SettingsActivity.B(findPreference("item_barcode_img_h2"));
            SettingsActivity.B(findPreference("item_barcode_img_w2"));
            SettingsActivity.B(findPreference("item_barcode_img_m2"));
            SettingsActivity.B(findPreference("item_barcode_img_cnt2"));
            SettingsActivity.B(findPreference("item_barcode_img_cnt"));
            SettingsActivity.B(findPreference("prefThermalType"));
            i = true;
            ListPreference listPreference = (ListPreference) findPreference("item_barcode_curr_id");
            ArrayList arrayListJ3 = this.g.j3();
            CharSequence[] charSequenceArr = new CharSequence[arrayListJ3.size()];
            CharSequence[] charSequenceArr2 = new CharSequence[arrayListJ3.size()];
            for (int i2 = 0; i2 < arrayListJ3.size(); i2++) {
                charSequenceArr[i2] = (CharSequence) ((HashMap) arrayListJ3.get(i2)).get("name");
                charSequenceArr2[i2] = (CharSequence) ((HashMap) arrayListJ3.get(i2)).get(HTML.Attribute.ID);
            }
            listPreference.setEntries(charSequenceArr);
            listPreference.setEntryValues(charSequenceArr2);
            SettingsActivity.B(findPreference("item_barcode_curr_id"));
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            if (viewOnCreateView != null) {
            }
            return viewOnCreateView;
        }

        @Override // androidx.fragment.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity.class));
            return true;
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            super.onPause();
            getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (str.equalsIgnoreCase("prefBackup_path")) {
                findPreference(str).setSummary(this.g.ia("prefBackup_path", Z00.L));
            }
        }
    }

    @TargetApi(11)
    public static class DataSyncPreferenceFragment extends C3204k7 {
        public SQLiteDatabase g;
        public Z00 h;

        public class a implements Preference.OnPreferenceChangeListener {
            public a() {
            }

            @Override // androidx.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                Boolean bool = (Boolean) obj;
                if (((SwitchPreference) preference).isChecked() != bool.booleanValue()) {
                    boolean zBooleanValue = bool.booleanValue();
                    DataSyncPreferenceFragment.this.h.Lc("db_item_changed", "1");
                    if (zBooleanValue) {
                        DataSyncPreferenceFragment.this.h.Mc("prefOthers_item_end_date", true);
                        DataSyncPreferenceFragment.this.h.v0("update sys_conf set value_='1' where id=10");
                    }
                }
                return true;
            }
        }

        @Override // defpackage.C3204k7, androidx.preference.PreferenceFragmentCompat
        public void onCreatePreferences(Bundle bundle, String str) {
            addPreferencesFromResource(R.xml.pref_data_sync);
            setHasOptionsMenu(true);
            SettingsActivity.B(findPreference("prefBlankLines"));
            SettingsActivity.B(findPreference("pref_credit"));
            SettingsActivity.B(findPreference("pref_debit"));
            SettingsActivity.B(findPreference("pref_print_remarks"));
            SettingsActivity.B(findPreference("pref_bill_remarks"));
            SwitchPreference switchPreference = (SwitchPreference) findPreference("prefOthers_print_end_date");
            this.h = new Z00(this.g, getActivity());
            getPreferenceScreen();
            if (switchPreference != null) {
                Z00.T = this.h.ia("PREF_ACCOUNT_NAME", "0");
                switchPreference.setOnPreferenceChangeListener(new a());
            }
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            if (viewOnCreateView != null) {
            }
            return viewOnCreateView;
        }

        @Override // androidx.fragment.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity.class));
            return true;
        }
    }

    @TargetApi(11)
    public static class GeneralPreferenceFragment extends C3204k7 {
        public static int q = 1;
        public SQLiteDatabase g;
        public Z00 h;
        public ImageView i;
        public Intent j;
        public String k;
        public String l;
        public View.OnClickListener n = new a();
        public View.OnClickListener p = new b();

        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(GeneralPreferenceFragment.this.getActivity())) {
                    GeneralPreferenceFragment.this.getActivity().startActivity(new Intent(GeneralPreferenceFragment.this.getActivity(), (Class<?>) logoActivity.class));
                    return;
                }
                new C3966tX().d(GeneralPreferenceFragment.this.getActivity());
                if (Build.VERSION.SDK_INT >= 33) {
                    GeneralPreferenceFragment.this.j = new Intent("android.provider.action.PICK_IMAGES");
                    GeneralPreferenceFragment.this.j.setType("image/*");
                } else {
                    GeneralPreferenceFragment.this.j = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                }
                GeneralPreferenceFragment generalPreferenceFragment = GeneralPreferenceFragment.this;
                generalPreferenceFragment.startActivityForResult(generalPreferenceFragment.j, GeneralPreferenceFragment.q);
            }
        }

        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GeneralPreferenceFragment.this.startActivity(new Intent(GeneralPreferenceFragment.this.getActivity(), (Class<?>) Signature_add.class));
            }
        }

        public void d(String str, boolean z) {
            try {
                SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
                editorEdit.putBoolean(str, z);
                editorEdit.commit();
            } catch (Exception unused) {
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            try {
                if (i == q && i2 == -1 && intent != null) {
                    String[] strArr = {"_data"};
                    Cursor cursorQuery = getActivity().getContentResolver().query(intent.getData(), strArr, null, null, null);
                    cursorQuery.moveToFirst();
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex(strArr[0]));
                    cursorQuery.close();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(string, options);
                    int[] iArrB1 = Z00.b1(options, 80, 80, 300);
                    Bitmap bitmapQ0 = this.h.q0(string, iArrB1[0], iArrB1[1]);
                    ((ImageView) getActivity().findViewById(R.id.logo_image)).setImageBitmap(bitmapQ0);
                    String strD = Z00.d(bitmapQ0);
                    this.k = strD;
                    this.h.Lc("ImageDecode", strD);
                    d("prefPrintUser", true);
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getActivity(), "Please try again:", 1).show();
            }
        }

        @Override // defpackage.C3204k7, androidx.preference.PreferenceFragmentCompat
        public void onCreatePreferences(Bundle bundle, String str) {
            setPreferencesFromResource(R.xml.pref_general, str);
            setHasOptionsMenu(true);
            this.h = new Z00(this.g, getActivity());
            SettingsActivity.B(findPreference("prefUsername"));
            SettingsActivity.B(findPreference("prefAddress"));
            SettingsActivity.B(findPreference("prefPhone"));
            SettingsActivity.B(findPreference("prefUsername_en"));
            SettingsActivity.B(findPreference("prefAddress_en"));
            SettingsActivity.B(findPreference("prefTax_no"));
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            View viewInflate = layoutInflater.inflate(R.layout.logo, viewGroup, false);
            ((ViewGroup) viewInflate.findViewById(R.id.list_placeholder)).addView(viewOnCreateView, new FrameLayout.LayoutParams(-1, -1));
            this.i = (ImageView) viewInflate.findViewById(R.id.logo_image);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.sign_image);
            this.k = this.h.ia("ImageDecode", "0");
            this.l = this.h.ia("Sign_Decode", "");
            if (this.k.equals("0")) {
                this.i.setImageResource(R.mipmap.ic_launcher);
            } else {
                this.i.setImageBitmap(Z00.o0(this.k));
            }
            if (this.l.equals("")) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageBitmap(Z00.o0(this.l));
            }
            this.i.setOnClickListener(this.n);
            imageView.setOnClickListener(this.p);
            return viewInflate;
        }

        @Override // androidx.fragment.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == 16908332) {
                startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity.class));
                return true;
            }
            if (itemId != R.id.menu_edit) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) Customer_Det_List_edit.class));
            return true;
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
        public boolean onPreferenceTreeClick(Preference preference) {
            super.onPreferenceTreeClick(preference);
            if (preference != null && preference.getKey().equals("prefLogo")) {
                this.n.onClick(getView());
                return false;
            }
            if (preference != null && preference.getKey().equals("prefSign")) {
                startActivity(new Intent(getActivity(), (Class<?>) Signature_add.class));
                return false;
            }
            if (preference != null && preference.getKey().equals("prefApproval")) {
                startActivity(new Intent(getActivity(), (Class<?>) Approval_add.class));
                return false;
            }
            if ((preference == null || !preference.getKey().equals("prefUsername")) && ((preference == null || !preference.getKey().equals("prefAddress")) && ((preference == null || !preference.getKey().equals("prefPhone")) && ((preference == null || !preference.getKey().equals("prefUsername_en")) && (preference == null || !preference.getKey().equals("prefAddress_en")))))) {
                return false;
            }
            d("prefPrintUser", true);
            return false;
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            if (Signature_add.i) {
                Signature_add.i = false;
                getActivity().recreate();
            }
            String strIa = this.h.ia("ImageDecode", "0");
            this.k = strIa;
            if (strIa.equals("0")) {
                this.i.setImageResource(R.mipmap.ic_launcher);
            } else {
                this.i.setImageBitmap(Z00.o0(this.k));
            }
        }
    }

    @TargetApi(11)
    public static class OthersPreferenceFragment extends C3204k7 {
        public SQLiteDatabase g;
        public Z00 h;
        public Dialog i = null;
        public Handler j = new a();
        public ListView k;

        public class a extends Handler {
            public a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Log.d("mProgress=f=", message.obj + "");
                message.obj.toString().equals("1");
                OthersPreferenceFragment.this.h(false);
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public class c implements DialogInterface.OnClickListener {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;

            public c(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                OthersPreferenceFragment.this.h.we(this.a, this.b);
                FragmentStatePagerSupport_Main.a0 = true;
                Toast.makeText(OthersPreferenceFragment.this.getActivity(), OthersPreferenceFragment.this.getActivity().getString(R.string.done), 0).show();
            }
        }

        public class d implements Preference.OnPreferenceChangeListener {
            public d() {
            }

            @Override // androidx.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                Boolean bool = (Boolean) obj;
                if (((SwitchPreference) preference).isChecked() == bool.booleanValue()) {
                    return true;
                }
                boolean zBooleanValue = bool.booleanValue();
                OthersPreferenceFragment.this.h.Lc("db_item_changed", "1");
                if (zBooleanValue) {
                    OthersPreferenceFragment.this.h.v0("update sys_conf set value_='1' where id=10");
                    return true;
                }
                OthersPreferenceFragment.this.h.v0("update sys_conf set value_='0' where id=10");
                return true;
            }
        }

        public class e implements Preference.OnPreferenceChangeListener {
            public e() {
            }

            @Override // androidx.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                Boolean bool = (Boolean) obj;
                if (((SwitchPreference) preference).isChecked() != bool.booleanValue()) {
                    Z00.Z = bool.booleanValue();
                    FragmentStatePagerSupport_Main.a0 = true;
                }
                return true;
            }
        }

        public class f implements Preference.OnPreferenceChangeListener {
            public f() {
            }

            @Override // androidx.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                Boolean bool = (Boolean) obj;
                if (((SwitchPreference) preference).isChecked() == bool.booleanValue()) {
                    return true;
                }
                boolean zBooleanValue = bool.booleanValue();
                OthersPreferenceFragment.this.h.Lc("db_item_changed", "1");
                OthersPreferenceFragment.this.h.Lc("db_cus_changed", "1");
                OthersPreferenceFragment.this.f(zBooleanValue);
                return true;
            }
        }

        public class g implements Preference.OnPreferenceChangeListener {
            public g() {
            }

            @Override // androidx.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                SettingsActivity.g = true;
                FragmentStatePagerSupport_Main.c0 = true;
                OthersPreferenceFragment.this.getActivity().recreate();
                return true;
            }
        }

        public class h implements Preference.OnPreferenceChangeListener {
            public h() {
            }

            @Override // androidx.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                OthersPreferenceFragment.this.h.v0("update sys_conf set value_='" + obj.toString() + "' where id=1");
                OthersPreferenceFragment.this.h.Lc("pref_cash_id", obj.toString());
                SettingsActivity.B(OthersPreferenceFragment.this.findPreference("pref_cash_id"));
                return true;
            }
        }

        public class i implements Preference.OnPreferenceChangeListener {
            public i() {
            }

            @Override // androidx.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                Boolean bool = (Boolean) obj;
                if (((SwitchPreference) preference).isChecked() == bool.booleanValue()) {
                    return true;
                }
                if (bool.booleanValue()) {
                    OthersPreferenceFragment.this.h.Lc("db_item_changed", "1");
                    SettingsActivity.B(OthersPreferenceFragment.this.findPreference("pref_cost_avg"));
                    return true;
                }
                OthersPreferenceFragment.this.h.Lc("pref_cost_avg", "1");
                OthersPreferenceFragment.this.h.Lc("db_item_changed", "1");
                SettingsActivity.B(OthersPreferenceFragment.this.findPreference("pref_cost_avg"));
                return true;
            }
        }

        public class j implements Preference.OnPreferenceChangeListener {
            public j() {
            }

            @Override // androidx.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                OthersPreferenceFragment.this.h.Lc("pref_cost_avg", obj.toString());
                OthersPreferenceFragment.this.h.Lc("db_item_changed", "1");
                SettingsActivity.B(OthersPreferenceFragment.this.findPreference("pref_cost_avg"));
                return true;
            }
        }

        public class k implements Preference.OnPreferenceChangeListener {
            public k() {
            }

            @Override // androidx.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                return true;
            }
        }

        public class l implements Runnable {
            public final /* synthetic */ boolean a;

            public l(boolean z) {
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                OthersPreferenceFragment.this.h.Lc("db_item_changed", "1");
                OthersPreferenceFragment.this.h.bc(this.a);
                OthersPreferenceFragment.this.h.Rd(200);
                Message message = new Message();
                message.obj = "1";
                OthersPreferenceFragment.this.j.sendMessage(message);
            }
        }

        public final void b(String str, String str2) {
            new AlertDialog.Builder(getActivity()).setTitle(getActivity().getString(R.string.yearly_closing_balance) + " " + str).setMessage(getActivity().getString(R.string.yearly_closing_balance_msg) + " " + str2).setCancelable(true).setPositiveButton(getActivity().getString(R.string.confirm_yes), new c(str, str2)).setNegativeButton(getActivity().getString(R.string.confirm_no), new b()).show();
        }

        public void d() {
            this.h.Y();
            new DateFormat();
            String string = DateFormat.format("yyyyMMddkkmmss", new Date()).toString();
            if (AbstractC2242g10.e(getActivity(), "inv.db", string + "-yearly.db", "info.aalmoghalis.inventory")) {
                this.h = new Z00(this.g, getActivity());
                Calendar calendar = Calendar.getInstance();
                new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                int i2 = calendar.get(1);
                StringBuilder sb = new StringBuilder();
                sb.append(i2 - 1);
                sb.append("-12-31");
                b(sb.toString(), i2 + "-01-01");
            }
        }

        public void f(boolean z) {
            h(true);
            new Thread(new l(z)).start();
        }

        public void g(ListPreference listPreference) {
            new ArrayList();
            ArrayList arrayListK2 = this.h.K2();
            CharSequence[] charSequenceArr = new CharSequence[arrayListK2.size()];
            CharSequence[] charSequenceArr2 = new CharSequence[arrayListK2.size()];
            for (int i2 = 0; i2 < arrayListK2.size(); i2++) {
                charSequenceArr[i2] = ((String) ((HashMap) arrayListK2.get(i2)).get("name")).toString();
                charSequenceArr2[i2] = ((String) ((HashMap) arrayListK2.get(i2)).get(HTML.Attribute.ID)).toString();
            }
            listPreference.setEntries(charSequenceArr);
            listPreference.setDefaultValue("1");
            listPreference.setEntryValues(charSequenceArr2);
        }

        public void h(boolean z) {
            Log.d("mProgress=", "....start..." + z);
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setView(getActivity().getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
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

        @Override // defpackage.C3204k7, androidx.preference.PreferenceFragmentCompat
        public void onCreatePreferences(Bundle bundle, String str) {
            Preference.OnPreferenceChangeListener onPreferenceChangeListener = SettingsActivity.f;
            addPreferencesFromResource(R.xml.pref_others);
            setHasOptionsMenu(true);
            this.h = new Z00(this.g, getActivity());
            FragmentStatePagerSupport_Main.a0 = true;
            SettingsActivity.B(findPreference("pref_cost_avg"));
            SettingsActivity.B(findPreference("pref_barcode_type"));
            Z00 z00 = this.h;
            z00.Lc("pref_cash_id", z00.e5("1"));
            SettingsActivity.B(findPreference("pref_cash_id"));
            Log.d("oncreateview=", SettingsActivity.g + ":oncreate");
            SwitchPreference switchPreference = (SwitchPreference) findPreference("prefOthers_currency");
            ListPreference listPreference = (ListPreference) findPreference("prefLanguage");
            Preference preferenceFindPreference = findPreference("prefOthers_activation");
            SwitchPreference switchPreference2 = (SwitchPreference) findPreference("prefOthers_item_end_date");
            SwitchPreference switchPreference3 = (SwitchPreference) findPreference("prefOthers_closed_year");
            PreferenceScreen preferenceScreen = getPreferenceScreen();
            if (preferenceFindPreference != null && !this.h.R()) {
                preferenceScreen.removePreference(preferenceFindPreference);
            }
            if (switchPreference2 != null) {
                switchPreference2.setOnPreferenceChangeListener(new d());
            }
            if (switchPreference3 != null && this.h.N2() == 0) {
                preferenceScreen.removePreference(switchPreference3);
                this.h.Mc("prefOthers_closed_year", false);
            }
            if (switchPreference != null) {
                switchPreference.setOnPreferenceChangeListener(new e());
            }
            if (switchPreference3 != null) {
                switchPreference3.setOnPreferenceChangeListener(new f());
            }
            if (listPreference != null) {
                listPreference.setOnPreferenceChangeListener(new g());
            }
            ListPreference listPreference2 = (ListPreference) findPreference("pref_cash_id");
            if (listPreference2 != null) {
                g(listPreference2);
                SettingsActivity.B(findPreference("pref_cash_id"));
                listPreference2.setOnPreferenceChangeListener(new h());
            }
            SwitchPreference switchPreference4 = (SwitchPreference) findPreference("prefOthers_sales_out_qty");
            if (switchPreference4 != null) {
                switchPreference4.setOnPreferenceChangeListener(new i());
            }
            ListPreference listPreference3 = (ListPreference) findPreference("pref_cost_avg");
            if (listPreference3 != null) {
                SettingsActivity.B(findPreference("pref_cost_avg"));
                listPreference3.setOnPreferenceChangeListener(new j());
            }
            SwitchPreference switchPreference5 = (SwitchPreference) findPreference("pref_other_option_sales_tax");
            if (switchPreference5 != null) {
                switchPreference5.setOnPreferenceChangeListener(new k());
            }
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            Log.d("oncreateview=", SettingsActivity.g + "");
            if (viewOnCreateView != null) {
                this.k = (ListView) viewOnCreateView.findViewById(android.R.id.list);
            }
            return viewOnCreateView;
        }

        @Override // androidx.fragment.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity.class));
            return true;
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
        public boolean onPreferenceTreeClick(Preference preference) {
            super.onPreferenceTreeClick(preference);
            if (preference != null && preference.getKey().equals("prefCloseBalance")) {
                d();
            } else if (preference != null && preference.getKey().equals("prefOthers_activation")) {
                if (this.h.R()) {
                    this.h.r = getActivity();
                    this.h.qe(getActivity(), getActivity());
                } else {
                    Toast.makeText(getActivity(), getString(R.string.activated), 0).show();
                }
            }
            return false;
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
        }
    }

    @TargetApi(11)
    public static class SMS_WA_PreferenceFragment extends C3204k7 {
        public Z00 g;
        public SQLiteDatabase h;
        public ListView i;

        public class a implements Preference.OnPreferenceChangeListener {
            public a() {
            }

            @Override // androidx.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                SwitchPreference switchPreference = (SwitchPreference) preference;
                Boolean bool = (Boolean) obj;
                if (switchPreference.isChecked() == bool.booleanValue()) {
                    return true;
                }
                if (!bool.booleanValue()) {
                    if (switchPreference.getKey().equals("prefAutoSMS")) {
                        SMS_WA_PreferenceFragment.this.g.v0("update customers set sms=0 where id>0 and sms=1 and wa=0 ");
                        return true;
                    }
                    if (!switchPreference.getKey().equals("prefAutoSMS_wa")) {
                        return true;
                    }
                    SMS_WA_PreferenceFragment.this.g.v0("update customers set wa=0 where id>0 and wa=1 and sms=0 ");
                    return true;
                }
                if (switchPreference.getKey().equals("prefAutoSMS")) {
                    SMS_WA_PreferenceFragment.this.g.Mc("prefAutoSMS_wa", false);
                    ((SwitchPreference) SMS_WA_PreferenceFragment.this.findPreference("prefAutoSMS_wa")).setChecked(false);
                    SMS_WA_PreferenceFragment.this.g.v0("update customers set sms=1 where id>0 and wa=0 and sms=0");
                    return true;
                }
                if (!switchPreference.getKey().equals("prefAutoSMS_wa")) {
                    return true;
                }
                SMS_WA_PreferenceFragment.this.g.Mc("prefAutoSMS", false);
                ((SwitchPreference) SMS_WA_PreferenceFragment.this.findPreference("prefAutoSMS")).setChecked(false);
                SMS_WA_PreferenceFragment.this.g.v0("update customers set wa=1 where id>0 and wa=0 and sms=0");
                return true;
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            getView();
        }

        @Override // defpackage.C3204k7, androidx.preference.PreferenceFragmentCompat
        public void onCreatePreferences(Bundle bundle, String str) {
            addPreferencesFromResource(R.xml.pref_sms_wa);
            setHasOptionsMenu(true);
            this.g = new Z00(this.h, getActivity());
            SettingsActivity.B(findPreference("prefSMS_header"));
            SettingsActivity.B(findPreference("prefSMS_footer"));
            SettingsActivity.B(findPreference("prefSMS_debit"));
            SettingsActivity.B(findPreference("prefSMS_credit"));
            SettingsActivity.B(findPreference("pref_notify_bill_type"));
            try {
                a aVar = new a();
                findPreference("prefAutoSMS").setOnPreferenceChangeListener(aVar);
                findPreference("prefAutoSMS_wa").setOnPreferenceChangeListener(aVar);
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("api_url=", ":" + e.getMessage());
            }
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            Log.d("oncreateview=", SettingsActivity.g + "");
            if (viewOnCreateView != null) {
                this.i = (ListView) viewOnCreateView.findViewById(android.R.id.list);
            }
            return viewOnCreateView;
        }

        @Override // androidx.fragment.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity.class));
            return true;
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
        }
    }

    @TargetApi(11)
    public static class SecurityPreferenceFragment extends C3204k7 {

        public class a implements Preference.OnPreferenceChangeListener {
            public a() {
            }

            @Override // androidx.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                Boolean bool = (Boolean) obj;
                if (((SwitchPreference) preference).isChecked() == bool.booleanValue()) {
                    return true;
                }
                boolean zBooleanValue = bool.booleanValue();
                String strD = SecurityPreferenceFragment.this.d("prefPassword", "");
                if (zBooleanValue) {
                    SecurityPreferenceFragment.this.b(0, strD);
                    return true;
                }
                if (strD.length() <= 0) {
                    return true;
                }
                SecurityPreferenceFragment.this.b(2, strD);
                return false;
            }
        }

        public class b implements TextWatcher {
            public final /* synthetic */ EditText a;
            public final /* synthetic */ EditText b;
            public final /* synthetic */ String c;
            public final /* synthetic */ int d;
            public final /* synthetic */ TextView e;

            public b(EditText editText, EditText editText2, String str, int i, TextView textView) {
                this.a = editText;
                this.b = editText2;
                this.c = str;
                this.d = i;
                this.e = textView;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String string = this.a.getText().toString();
                this.b.getText().toString();
                if (!string.equals(this.c) && this.d >= 1) {
                    this.e.setText(R.string.settings_pwd_not_equal);
                } else if (this.d >= 1) {
                    this.e.setText(R.string.settings_pwd_equal);
                } else {
                    this.e.setText("");
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        }

        public class c implements DialogInterface.OnClickListener {
            public c() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public class d implements DialogInterface.OnClickListener {
            public d() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (SecurityPreferenceFragment.this.d("prefPassword", "").length() == 0) {
                    SecurityPreferenceFragment.this.g("prefLogin", false);
                    ((SwitchPreference) SecurityPreferenceFragment.this.findPreference("prefLogin")).setChecked(false);
                }
            }
        }

        public class e implements View.OnClickListener {
            public final /* synthetic */ EditText a;
            public final /* synthetic */ EditText b;
            public final /* synthetic */ String c;
            public final /* synthetic */ int d;
            public final /* synthetic */ androidx.appcompat.app.AlertDialog e;

            public e(EditText editText, EditText editText2, String str, int i, androidx.appcompat.app.AlertDialog alertDialog) {
                this.a = editText;
                this.b = editText2;
                this.c = str;
                this.d = i;
                this.e = alertDialog;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    String string = this.a.getText().toString();
                    String string2 = this.b.getText().toString();
                    if (!(string.equals(this.c) & (string2.length() >= 4) & (this.d == 1))) {
                        if (!((string2.length() >= 4) & (this.d == 0))) {
                            if (!(string.equals(this.c) & (this.d == 2))) {
                                if ((string2.length() < 4) && (this.d != 2)) {
                                    Toast.makeText(SecurityPreferenceFragment.this.getActivity(), SecurityPreferenceFragment.this.getString(R.string.pw_min), 0).show();
                                    return;
                                }
                                if ((!string.equals(this.c)) && (this.d >= 1)) {
                                    Toast.makeText(SecurityPreferenceFragment.this.getActivity(), SecurityPreferenceFragment.this.getString(R.string.settings_pwd_not_equal), 0).show();
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    if (this.d != 2) {
                        Toast.makeText(SecurityPreferenceFragment.this.getActivity(), "Matching passwords=" + string2, 0).show();
                        SecurityPreferenceFragment.this.f("prefPassword", string2);
                        SettingsActivity.B(SecurityPreferenceFragment.this.findPreference("prefPassword"));
                    } else {
                        SecurityPreferenceFragment.this.f("prefPassword", "");
                        SettingsActivity.B(SecurityPreferenceFragment.this.findPreference("prefPassword"));
                        SecurityPreferenceFragment.this.g("prefLogin", false);
                        ((SwitchPreference) SecurityPreferenceFragment.this.findPreference("prefLogin")).setChecked(false);
                    }
                    if (this.d == 0) {
                        SecurityPreferenceFragment.this.g("prefLogin", true);
                        ((SwitchPreference) SecurityPreferenceFragment.this.findPreference("prefLogin")).setChecked(true);
                    }
                    this.e.dismiss();
                } catch (Exception e) {
                    Toast.makeText(SecurityPreferenceFragment.this.getActivity(), e.getMessage(), 1).show();
                }
            }
        }

        public void b(int i, String str) {
            try {
                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(requireActivity());
                View viewInflate = requireActivity().getLayoutInflater().inflate(R.layout.password_dialog, (ViewGroup) null);
                builder.setView(viewInflate);
                EditText editText = (EditText) viewInflate.findViewById(R.id.EditText_Pwd1);
                EditText editText2 = (EditText) viewInflate.findViewById(R.id.EditText_Pwd2);
                TextView textView = (TextView) viewInflate.findViewById(R.id.TextView_PwdProblem);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.TextView_Pwd1);
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.TextView_Pwd2);
                if (i == 0) {
                    editText.setVisibility(8);
                    textView2.setVisibility(8);
                } else if (i == 2) {
                    editText2.setVisibility(8);
                    textView3.setVisibility(8);
                }
                editText2.addTextChangedListener(new b(editText, editText2, str, i, textView));
                builder.setPositiveButton(getString(R.string.resourceID_OK), new c());
                builder.setNegativeButton(getString(R.string.resourceID_Cancel), new d());
                androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
                alertDialogCreate.setTitle(getString(R.string.btn_change_pw));
                alertDialogCreate.setCancelable(false);
                alertDialogCreate.getWindow().setSoftInputMode(4);
                alertDialogCreate.show();
                alertDialogCreate.getButton(-1).setOnClickListener(new e(editText, editText2, str, i, alertDialogCreate));
            } catch (Exception unused) {
            }
        }

        public String d(String str, String str2) {
            try {
                return PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(str, str2);
            } catch (Exception unused) {
                return str2;
            }
        }

        public void f(String str, String str2) {
            try {
                SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
                editorEdit.putString(str, str2);
                editorEdit.commit();
            } catch (Exception unused) {
            }
        }

        public void g(String str, boolean z) {
            try {
                SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
                editorEdit.putBoolean(str, z);
                editorEdit.commit();
            } catch (Exception unused) {
            }
        }

        @Override // defpackage.C3204k7, androidx.preference.PreferenceFragmentCompat
        public void onCreatePreferences(Bundle bundle, String str) {
            addPreferencesFromResource(R.xml.pref_security);
            setHasOptionsMenu(true);
            SwitchPreference switchPreference = (SwitchPreference) findPreference("prefLogin");
            if (switchPreference != null) {
                switchPreference.setOnPreferenceChangeListener(new a());
            }
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            if (viewOnCreateView != null) {
            }
            return viewOnCreateView;
        }

        @Override // androidx.fragment.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity.class));
            return true;
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
        public boolean onPreferenceTreeClick(Preference preference) {
            super.onPreferenceTreeClick(preference);
            if (preference != null && preference.getKey().equals("prefPassword")) {
                String strD = d("prefPassword", "");
                if (strD.equals("")) {
                    b(0, strD);
                } else {
                    b(1, strD);
                }
            }
            return false;
        }
    }

    @TargetApi(11)
    public static class ThermalPreferenceFragment extends C3204k7 implements SharedPreferences.OnSharedPreferenceChangeListener {
        public static boolean i = false;
        public Z00 g;
        public SQLiteDatabase h;

        @Override // defpackage.C3204k7, androidx.preference.PreferenceFragmentCompat
        public void onCreatePreferences(Bundle bundle, String str) {
            addPreferencesFromResource(R.xml.pref_thermal);
            setHasOptionsMenu(true);
            this.g = new Z00(this.h, getActivity());
            SettingsActivity.B(findPreference("pref_thermal_remarks"));
            SettingsActivity.B(findPreference("prefPaperSize"));
            SettingsActivity.B(findPreference("prefThermalType"));
            SettingsActivity.B(findPreference("prefFontSize"));
            SettingsActivity.B(findPreference("prefNoPrinted"));
            SettingsActivity.B(findPreference("pref_codetable"));
            i = true;
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            if (viewOnCreateView != null) {
            }
            return viewOnCreateView;
        }

        @Override // androidx.fragment.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity.class));
            return true;
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            super.onPause();
            getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (str.equalsIgnoreCase("prefBackup_path")) {
                findPreference(str).setSummary(this.g.ia("prefBackup_path", Z00.L));
            }
        }
    }

    public class a implements Preference.OnPreferenceChangeListener {
        @Override // androidx.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference preference, Object obj) {
            String string = obj.toString();
            if (!(preference instanceof ListPreference)) {
                preference.setSummary(string);
                return true;
            }
            ListPreference listPreference = (ListPreference) preference;
            int iFindIndexOfValue = listPreference.findIndexOfValue(string);
            preference.setSummary(iFindIndexOfValue >= 0 ? listPreference.getEntries()[iFindIndexOfValue] : null);
            return true;
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ AlertDialog b;

        public c(EditText editText, AlertDialog alertDialog) {
            this.a = editText;
            this.b = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (SettingsActivity.this.d.Y5(Z00.R, Z00.S) == 0) {
                    SettingsActivity.this.x(this.a.getText().toString(), this.b);
                } else {
                    Toast.makeText(SettingsActivity.this.getApplicationContext(), "Already Activated!", 0).show();
                    this.b.dismiss();
                }
            } catch (Exception e) {
                Toast.makeText(SettingsActivity.this.getApplicationContext(), e.getMessage(), 1).show();
            }
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public d(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.dismiss();
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public static void B(Preference preference) {
        preference.setOnPreferenceChangeListener(f);
        if (preference instanceof SwitchPreference) {
            f.onPreferenceChange(preference, Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(preference.getContext()).getBoolean(preference.getKey(), false)));
        } else {
            f.onPreferenceChange(preference, PreferenceManager.getDefaultSharedPreferences(preference.getContext()).getString(preference.getKey(), ""));
        }
    }

    public static void C(File file, File file2) {
        if (file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            String[] list = file.list();
            for (int i = 0; i < file.listFiles().length; i++) {
                C(new File(file, list[i]), new File(file2, list[i]));
            }
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = fileInputStream.read(bArr);
            if (i2 <= 0) {
                fileInputStream.close();
                fileOutputStream.close();
                return;
            }
            fileOutputStream.write(bArr, 0, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        if (getSupportFragmentManager().findFragmentById(R.id.settings_container) instanceof C3832rr) {
            setTitle(R.string.setting_title);
        }
    }

    private void J() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void A(int i, String str) {
        try {
            if (this.d.Y5(Z00.R, Z00.S) != 0) {
                Toast.makeText(this, getString(R.string.activated), 0).show();
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_imei, (ViewGroup) null);
            builder.setView(viewInflate);
            EditText editText = (EditText) viewInflate.findViewById(R.id.imei);
            EditText editText2 = (EditText) viewInflate.findViewById(R.id.imei_code);
            editText.setText(Z00.R);
            editText2.setText(str);
            builder.setPositiveButton(getString(R.string.resourceID_OK), new b());
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            alertDialogCreate.getButton(-1).setOnClickListener(new c(editText2, alertDialogCreate));
            builder.setNegativeButton(getString(R.string.resourceID_Cancel), new d(alertDialogCreate));
        } catch (Exception unused) {
        }
    }

    public boolean D(String str) {
        return str.startsWith(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "");
    }

    public final void F() {
        getSupportFragmentManager().beginTransaction().replace(R.id.settings_container, new C3832rr(this.d)).commit();
    }

    public String G(String str, String str2) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(this).getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public final void H() {
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.settings_container);
        if (fragmentFindFragmentById instanceof C3832rr) {
            setTitle(R.string.setting_title);
            return;
        }
        if (fragmentFindFragmentById instanceof GeneralPreferenceFragment) {
            setTitle(R.string.pref_header_general);
            return;
        }
        if (fragmentFindFragmentById instanceof DataSyncPreferenceFragment) {
            setTitle(R.string.pref_header_data_sync);
            return;
        }
        if (fragmentFindFragmentById instanceof SecurityPreferenceFragment) {
            setTitle(R.string.pref_security);
            return;
        }
        if (fragmentFindFragmentById instanceof BackupPreferenceFragment) {
            setTitle(R.string.pref_backup);
            return;
        }
        if (fragmentFindFragmentById instanceof SMS_WA_PreferenceFragment) {
            setTitle(R.string.pref_SMS_WA_options);
            return;
        }
        if (fragmentFindFragmentById instanceof OthersPreferenceFragment) {
            setTitle(R.string.pref_other_options);
            return;
        }
        if (fragmentFindFragmentById instanceof ThermalPreferenceFragment) {
            setTitle(R.string.thermal_option);
            return;
        }
        boolean z = fragmentFindFragmentById instanceof BarcodePreferenceFragment;
        if (z) {
            setTitle(R.string.barcode_option);
        } else if (z) {
            setTitle(R.string.barcode_option);
        } else {
            setTitle(R.string.setting_title);
        }
    }

    public final void I() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override // info.aalmoghalis.inventory.activity.c.g
    public void l(String str, String str2) {
        if (!m(str, str2) || str.equals(this.d.ia("prefBackup_path", Z00.L))) {
            return;
        }
        this.d.Lc("prefBackup_path", str);
        try {
            C(new File(Z00.L + "/Pictures/"), new File(this.d.ia("prefBackup_path", Z00.L) + "/Pictures/"));
        } catch (Exception e2) {
            Log.d("Copy_err", e2.getMessage());
            Toast.makeText(this, e2.getMessage(), 1).show();
        }
        Z00.L = this.d.ia("prefBackup_path", Z00.L);
    }

    @Override // info.aalmoghalis.inventory.activity.c.g
    public boolean m(String str, String str2) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isDirectory() && file.canWrite() && D(str);
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        Log.d("Oncreate_Settings=", "Start..");
        J();
        setTitle(R.string.setting_title);
        Z00 z00 = new Z00(this.c, this);
        this.d = z00;
        z00.Mc("prefOthers_item_end_date", z00.e5("10").equals("1"));
        if (bundle == null) {
            String stringExtra = getIntent().getStringExtra("show_fragment");
            if (stringExtra != null) {
                try {
                    getSupportFragmentManager().beginTransaction().replace(R.id.settings_container, (Fragment) Class.forName(stringExtra).newInstance()).commit();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    F();
                }
            } else {
                F();
            }
        }
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: TO
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final void onBackStackChanged() {
                this.a.E();
            }
        });
        getSupportFragmentManager().executePendingTransactions();
        H();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_setting, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId != R.id.activation) {
            return super.onOptionsItemSelected(menuItem);
        }
        String strG = G("prefCode", "");
        if (strG.equals("")) {
            A(0, strG);
        } else {
            A(1, strG);
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.preference.PreferenceFragmentCompat.OnPreferenceStartFragmentCallback
    public boolean onPreferenceStartFragment(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference) {
        PreferenceFragmentCompat preferenceFragmentCompat2 = (PreferenceFragmentCompat) getSupportFragmentManager().getFragmentFactory().instantiate(getClassLoader(), preference.getFragment());
        preferenceFragmentCompat2.setArguments(preference.getExtras());
        getSupportFragmentManager().beginTransaction().replace(R.id.settings_container, preferenceFragmentCompat2).addToBackStack(null).commit();
        return true;
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        Log.d("onrestart=", g + "");
        if (FragmentStatePagerSupport_Main.c0) {
            recreate();
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d("onResume=", "Settings_activity:" + activationActivity.f);
        if (activationActivity.f) {
            activationActivity.f = false;
            if ((this.d.Y5(Z00.R, Z00.S) <= 0 || this.d.ja("black_list", false)) && (this.d.ia("token", "").equals("") || this.d.ja("token_list", false))) {
                return;
            }
            I();
        }
    }

    public final void x(String str, AlertDialog alertDialog) {
        if (Z00.R != null) {
            try {
                if (Z00.S.substring(0, 14).equals(str.substring(0, 14))) {
                    this.d.v0("delete from valid ");
                    this.d.v0("insert into valid(imei,imei_code) values('" + Z00.R + "','" + Z00.S + "');");
                    Toast.makeText(this, "Import Successful!", 0).show();
                    alertDialog.dismiss();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.contact_layout, (ViewGroup) null);
                    TextView textView = (TextView) viewInflate.findViewById(R.id.text);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    textView.setText(R.string.contact_msg2);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    builder.setView(viewInflate);
                    builder.setTitle(getString(R.string.contact_hdr));
                    builder.setCancelable(false).setPositiveButton("OK", new e());
                    builder.create().show();
                }
            } catch (Exception unused) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                View viewInflate2 = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.contact_layout, (ViewGroup) null);
                TextView textView2 = (TextView) viewInflate2.findViewById(R.id.text);
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                textView2.setText(R.string.contact_msg2);
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                builder2.setView(viewInflate2);
                builder2.setTitle(getString(R.string.contact_hdr));
                builder2.setCancelable(false).setPositiveButton("OK", new f());
                builder2.create().show();
            }
        }
    }
}
