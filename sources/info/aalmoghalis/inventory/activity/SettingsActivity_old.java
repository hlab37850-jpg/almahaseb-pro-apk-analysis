package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.RingtonePreference;
import android.preference.SwitchPreference;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.documentfile.provider.DocumentFile;
import androidx.room.RoomDatabase;
import com.google.android.material.timepicker.TimeModel;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AQ;
import defpackage.AbstractC1197a4;
import defpackage.AbstractC2242g10;
import defpackage.AbstractC3132jE;
import defpackage.AbstractC3425mq;
import defpackage.C1839c10;
import defpackage.C2160f10;
import defpackage.C3966tX;
import defpackage.IN;
import defpackage.InterfaceC2295gf;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.SettingsActivity_old;
import info.aalmoghalis.inventory.helper.Approval_add;
import info.aalmoghalis.inventory.helper.Signature_add;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class SettingsActivity_old extends AppCompatPreferenceActivity implements info.aalmoghalis.inventory.activity.c.g {
    public static Preference.OnPreferenceChangeListener d = new a();
    public static boolean e = false;
    public SQLiteDatabase b;
    public Z00 c;

    public class a implements Preference.OnPreferenceChangeListener {
        @Override // android.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference preference, Object obj) {
            String string = obj.toString();
            if (preference instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) preference;
                int iFindIndexOfValue = listPreference.findIndexOfValue(string);
                preference.setSummary(iFindIndexOfValue >= 0 ? listPreference.getEntries()[iFindIndexOfValue] : null);
                return true;
            }
            if (!(preference instanceof RingtonePreference)) {
                preference.setSummary(string);
                return true;
            }
            if (TextUtils.isEmpty(string)) {
                preference.setSummary(R.string.pref_ringtone_silent);
                return true;
            }
            Ringtone ringtone = RingtoneManager.getRingtone(preference.getContext(), Uri.parse(string));
            if (ringtone == null) {
                preference.setSummary((CharSequence) null);
                return true;
            }
            preference.setSummary(ringtone.getTitle(preference.getContext()));
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
                if (SettingsActivity_old.this.c.Y5(Z00.R, Z00.S) == 0) {
                    SettingsActivity_old.this.c(this.a.getText().toString(), this.b);
                } else {
                    Toast.makeText(SettingsActivity_old.this.getApplicationContext(), "Already Activated!", 0).show();
                    this.b.dismiss();
                }
            } catch (Exception e) {
                Toast.makeText(SettingsActivity_old.this.getApplicationContext(), e.getMessage(), 1).show();
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

    public static class g extends PreferenceFragment {
        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.pref_ads);
            setHasOptionsMenu(true);
            FragmentStatePagerSupport_Main.a0 = true;
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            if (viewOnCreateView != null) {
            }
            return viewOnCreateView;
        }

        @Override // android.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity_old.class));
            return true;
        }
    }

    public static class h extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
        public Z00 a;
        public SQLiteDatabase b;

        public class a implements TimePickerDialog.OnTimeSetListener {
            public a() {
            }

            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i, int i2) {
                h.this.a.Lc("prefBackup_time_h", String.valueOf(i));
                h.this.a.Lc("prefBackup_time_m", String.valueOf(i2));
                h.this.a.Mc("prefAutoBackup", true);
                h.this.findPreference("prefBackup_time_h").setSummary(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Integer.parseInt(h.this.a.ia("prefBackup_time_h", "0")))) + ":" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Integer.parseInt(h.this.a.ia("prefBackup_time_m", "0")))));
                h.this.a.Lc("db_data_changed", "1");
                h.this.a.Lc("db_data_changed2", "1");
                h.this.a.Lc("last_backup_time", "0");
                h.this.a.Lc("auto_drive_date_save", "");
                Z00.t0 = false;
                h hVar = h.this;
                hVar.a.Pc(hVar.getActivity());
                ((SwitchPreference) h.this.findPreference("prefAutoBackup")).setChecked(true);
            }
        }

        public static /* synthetic */ void i(Integer num) {
        }

        public void c() {
            String strIa = this.a.ia("prefBackup_path", Z00.L);
            if (new C3966tX().l(new File(strIa), strIa, this.a) || !AbstractC3425mq.a(getActivity())) {
                e();
            } else {
                Z00.Y = "1";
                info.aalmoghalis.inventory.activity.c.m(info.aalmoghalis.inventory.activity.c.i.DirectorySelector, R.string.resourceID_OK, R.string.resourceID_Cancel, R.string.resourceID_Title2, android.R.drawable.ic_menu_set_as, android.R.drawable.ic_menu_directions, android.R.drawable.ic_menu_save);
            }
        }

        public void d() {
            Calendar.getInstance();
            TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new a(), Integer.parseInt(this.a.ia("prefBackup_time_h", "0")), Integer.parseInt(this.a.ia("prefBackup_time_m", "0")), true);
            timePickerDialog.setTitle(getActivity().getString(R.string.pref_backup_time));
            timePickerDialog.show();
        }

        public void e() {
            try {
                String strIa = this.a.ia("prefBackup_path", Z00.L);
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

        public final void f() {
            startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 2);
        }

        public final File g(Uri uri) {
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

        public final /* synthetic */ Integer h(DocumentFile documentFile) {
            for (DocumentFile documentFile2 : documentFile.listFiles()) {
                if (documentFile2.isFile() && documentFile2.getType().contains("image")) {
                    if ((new File(new C3966tX().t(documentFile2.getUri())).getParentFile().getPath() + "/").equals(Z00.M)) {
                        return 1;
                    }
                    g(documentFile2.getUri());
                }
            }
            return 1;
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) {
            if (i == 2 && i2 == -1) {
                if (intent != null) {
                    Log.d("result=", intent.getData().toString());
                    final DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(getActivity().getBaseContext(), intent.getData());
                    AbstractC3132jE.d(new Callable() { // from class: WO
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.a.h(documentFileFromTreeUri);
                        }
                    }).m(IN.c()).g().e(AbstractC1197a4.e()).i(new InterfaceC2295gf() { // from class: XO
                        @Override // defpackage.InterfaceC2295gf
                        public final void accept(Object obj) {
                            SettingsActivity_old.h.i((Integer) obj);
                        }
                    });
                    return;
                }
                return;
            }
            if (i == 3 && i2 == -1 && intent != null) {
                Uri data = intent.getData();
                this.a.Lc("app_path_uri", data.toString());
                int flags = intent.getFlags() & 3;
                getActivity().getContentResolver().takePersistableUriPermission(data, 1);
                getActivity().getContentResolver().takePersistableUriPermission(data, 2);
                getActivity().getContentResolver().takePersistableUriPermission(data, flags);
                DocumentFile documentFileFromTreeUri2 = DocumentFile.fromTreeUri(this.a.b, data);
                if (documentFileFromTreeUri2.canWrite() && documentFileFromTreeUri2.isDirectory()) {
                    this.a.Lc("prefBackup_path", new C3966tX().t(data));
                    this.a.he();
                    findPreference("prefBackup_path").setSummary(this.a.ia("prefBackup_path", Z00.L));
                }
                Log.d("trace_app_main=", "path=" + new C3966tX().t(data) + ":" + data.toString() + ":" + documentFileFromTreeUri2.canWrite());
            }
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.pref_backup);
            setHasOptionsMenu(true);
            this.a = new Z00(this.b, getActivity());
            findPreference("prefBackup_path").setSummary(this.a.ia("prefBackup_path", Z00.L));
            findPreference("prefBackup_time_h").setSummary(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Integer.parseInt(this.a.ia("prefBackup_time_h", "0")))) + ":" + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Integer.parseInt(this.a.ia("prefBackup_time_m", "0")))));
            SettingsActivity_old.g(findPreference("PREF_ACCOUNT_NAME"));
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            if (viewOnCreateView != null) {
            }
            return viewOnCreateView;
        }

        @Override // android.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity_old.class));
            return true;
        }

        @Override // android.app.Fragment
        public void onPause() {
            super.onPause();
            getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        }

        @Override // android.preference.PreferenceFragment
        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
            super.onPreferenceTreeClick(preferenceScreen, preference);
            if (preference != null && preference.getKey().equals("prefBackup_path")) {
                c();
                return false;
            }
            if (preference != null && preference.getKey().equals("prefBackup_pic_path")) {
                f();
                return false;
            }
            if (preference != null && preference.getKey().equals("prefBackup_time_h")) {
                d();
                return false;
            }
            if (preference != null && preference.getKey().equals("prefAutoBackup")) {
                this.a.Pc(getActivity());
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

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
            try {
                SettingsActivity_old.g(findPreference("PREF_ACCOUNT_NAME"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (str.equalsIgnoreCase("prefBackup_path")) {
                findPreference(str).setSummary(this.a.ia("prefBackup_path", Z00.L));
            }
        }
    }

    public static class i extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
        public static boolean c = false;
        public Z00 a;
        public SQLiteDatabase b;

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.pref_barcode);
            setHasOptionsMenu(true);
            this.a = new Z00(this.b, getActivity());
            SettingsActivity_old.g(findPreference("item_barcode_col_cnt2"));
            SettingsActivity_old.g(findPreference("item_barcode_col_cnt"));
            SettingsActivity_old.g(findPreference("item_barcode_img_h2"));
            SettingsActivity_old.g(findPreference("item_barcode_img_w2"));
            SettingsActivity_old.g(findPreference("item_barcode_img_m2"));
            SettingsActivity_old.g(findPreference("item_barcode_img_cnt2"));
            SettingsActivity_old.g(findPreference("item_barcode_img_cnt"));
            c = true;
            ListPreference listPreference = (ListPreference) findPreference("item_barcode_curr_id");
            ArrayList arrayListJ3 = this.a.j3();
            CharSequence[] charSequenceArr = new CharSequence[arrayListJ3.size()];
            CharSequence[] charSequenceArr2 = new CharSequence[arrayListJ3.size()];
            for (int i = 0; i < arrayListJ3.size(); i++) {
                charSequenceArr[i] = (CharSequence) ((HashMap) arrayListJ3.get(i)).get("name");
                charSequenceArr2[i] = (CharSequence) ((HashMap) arrayListJ3.get(i)).get(HTML.Attribute.ID);
            }
            listPreference.setEntries(charSequenceArr);
            listPreference.setEntryValues(charSequenceArr2);
            SettingsActivity_old.g(findPreference("item_barcode_curr_id"));
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            if (viewOnCreateView != null) {
            }
            return viewOnCreateView;
        }

        @Override // android.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity_old.class));
            return true;
        }

        @Override // android.app.Fragment
        public void onPause() {
            super.onPause();
            getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (str.equalsIgnoreCase("prefBackup_path")) {
                findPreference(str).setSummary(this.a.ia("prefBackup_path", Z00.L));
            }
        }
    }

    public static class j extends PreferenceFragment {
        public SQLiteDatabase a;
        public Z00 b;

        public class a implements Preference.OnPreferenceChangeListener {
            public a() {
            }

            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                Boolean bool = (Boolean) obj;
                if (((SwitchPreference) preference).isChecked() != bool.booleanValue()) {
                    boolean zBooleanValue = bool.booleanValue();
                    j.this.b.Lc("db_item_changed", "1");
                    if (zBooleanValue) {
                        j.this.b.Mc("prefOthers_item_end_date", true);
                        j.this.b.v0("update sys_conf set value_='1' where id=10");
                    }
                }
                return true;
            }
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.pref_data_sync);
            setHasOptionsMenu(true);
            SettingsActivity_old.g(findPreference("prefBlankLines"));
            SettingsActivity_old.g(findPreference("pref_credit"));
            SettingsActivity_old.g(findPreference("pref_debit"));
            SettingsActivity_old.g(findPreference("pref_print_remarks"));
            SettingsActivity_old.g(findPreference("pref_bill_remarks"));
            SwitchPreference switchPreference = (SwitchPreference) findPreference("prefOthers_print_end_date");
            this.b = new Z00(this.a, getActivity());
            getPreferenceScreen();
            if (switchPreference != null) {
                Z00.T = this.b.ia("PREF_ACCOUNT_NAME", "0");
                switchPreference.setOnPreferenceChangeListener(new a());
            }
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            if (viewOnCreateView != null) {
            }
            return viewOnCreateView;
        }

        @Override // android.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity_old.class));
            return true;
        }
    }

    public static class k extends PreferenceFragment {
        public static int i = 1;
        public SQLiteDatabase a;
        public Z00 b;
        public ImageView c;
        public Intent d;
        public String e;
        public String f;
        public View.OnClickListener g = new a();
        public View.OnClickListener h = new b();

        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ActivityResultContracts.PickVisualMedia.isPhotoPickerAvailable(k.this.getActivity())) {
                    k.this.getActivity().startActivity(new Intent(k.this.getActivity(), (Class<?>) logoActivity.class));
                    return;
                }
                new C3966tX().d(k.this.getActivity());
                if (Build.VERSION.SDK_INT >= 33) {
                    k.this.d = new Intent("android.provider.action.PICK_IMAGES");
                    k.this.d.setType("image/*");
                } else {
                    k.this.d = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                }
                k kVar = k.this;
                kVar.startActivityForResult(kVar.d, k.i);
            }
        }

        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.startActivity(new Intent(k.this.getActivity(), (Class<?>) Signature_add.class));
            }
        }

        public void b(String str, boolean z) {
            try {
                SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
                editorEdit.putBoolean(str, z);
                editorEdit.commit();
            } catch (Exception unused) {
            }
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onActivityResult(int i2, int i3, Intent intent) {
            super.onActivityResult(i2, i3, intent);
            try {
                if (i2 == i && i3 == -1 && intent != null) {
                    String[] strArr = {"_data"};
                    Cursor cursorQuery = getActivity().getContentResolver().query(intent.getData(), strArr, null, null, null);
                    cursorQuery.moveToFirst();
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex(strArr[0]));
                    cursorQuery.close();
                    Bitmap bitmapQ0 = this.b.q0(string, 100, 100);
                    ((ImageView) getActivity().findViewById(R.id.logo_image)).setImageBitmap(bitmapQ0);
                    String strD = Z00.d(bitmapQ0);
                    this.e = strD;
                    this.b.Lc("ImageDecode", strD);
                    b("prefPrintUser", true);
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getActivity(), "Please try again:", 1).show();
            }
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.pref_general);
            setHasOptionsMenu(true);
            this.b = new Z00(this.a, getActivity());
            SettingsActivity_old.g(findPreference("prefUsername"));
            SettingsActivity_old.g(findPreference("prefAddress"));
            SettingsActivity_old.g(findPreference("prefPhone"));
            SettingsActivity_old.g(findPreference("prefUsername_en"));
            SettingsActivity_old.g(findPreference("prefAddress_en"));
            SettingsActivity_old.g(findPreference("prefTax_no"));
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(R.layout.logo, viewGroup, false);
            this.c = (ImageView) viewInflate.findViewById(R.id.logo_image);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.sign_image);
            this.e = this.b.ia("ImageDecode", "0");
            this.f = this.b.ia("Sign_Decode", "");
            if (this.e.equals("0")) {
                this.c.setImageResource(R.mipmap.ic_launcher);
            } else {
                this.c.setImageBitmap(Z00.o0(this.e));
            }
            if (this.f.equals("")) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageBitmap(Z00.o0(this.f));
            }
            this.c.setOnClickListener(this.g);
            imageView.setOnClickListener(this.h);
            return viewInflate;
        }

        @Override // android.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == 16908332) {
                startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity_old.class));
                return true;
            }
            if (itemId != R.id.menu_edit) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) Customer_Det_List_edit.class));
            return true;
        }

        @Override // android.preference.PreferenceFragment
        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
            super.onPreferenceTreeClick(preferenceScreen, preference);
            if (preference != null && preference.getKey().equals("prefLogo")) {
                this.g.onClick(getView());
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
            b("prefPrintUser", true);
            return false;
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            if (Signature_add.i) {
                Signature_add.i = false;
                getActivity().recreate();
            }
            String strIa = this.b.ia("ImageDecode", "0");
            this.e = strIa;
            if (strIa.equals("0")) {
                this.c.setImageResource(R.mipmap.ic_launcher);
            } else {
                this.c.setImageBitmap(Z00.o0(this.e));
            }
        }
    }

    public static class l extends PreferenceFragment {
        public SQLiteDatabase a;
        public Z00 b;
        public AQ c;

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                l.this.c.f();
                l.this.getActivity().finish();
            }
        }

        public void b() {
            try {
                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(getActivity());
                View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_ip, (ViewGroup) null);
                builder.setView(viewInflate);
                TextView textView = (TextView) viewInflate.findViewById(R.id.ip_desc);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.ip);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setText(R.string.ip_msg);
                textView2.setText("http://" + this.b.r6() + ":7777");
                builder.setNegativeButton(getString(R.string.stop), new a());
                androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
                alertDialogCreate.getWindow().setSoftInputMode(4);
                alertDialogCreate.setCancelable(false);
                alertDialogCreate.show();
            } catch (Exception e) {
                Log.d("adv_search_error=", e.getMessage());
            }
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setHasOptionsMenu(true);
            this.b = new Z00(this.a, getActivity());
            this.c = new AQ(RoomDatabase.MAX_BIND_PARAMETER_CNT, getResources().getAssets(), getActivity(), this.b);
            Z00 z00 = this.b;
            z00.ve(z00.O1(), Z00.L, "index.html");
            this.c.e();
            b();
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            if (viewOnCreateView != null) {
            }
            return viewOnCreateView;
        }

        @Override // android.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity_old.class));
            return true;
        }

        @Override // android.app.Fragment
        public void onPause() {
            this.c.f();
            super.onPause();
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            AQ aq = new AQ(7777, getResources().getAssets(), getActivity(), this.b);
            this.c = aq;
            aq.e();
        }
    }

    public static class m extends PreferenceFragment {
        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.pref_notification);
            setHasOptionsMenu(true);
            SettingsActivity_old.g(findPreference("notifications_new_message_ringtone"));
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            if (viewOnCreateView != null) {
            }
            return viewOnCreateView;
        }

        @Override // android.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity_old.class));
            return true;
        }
    }

    public static class n extends PreferenceFragment {
        public SQLiteDatabase a;
        public Z00 b;
        public Dialog c = null;
        public Handler d = new a();
        public ListView e;

        public class a extends Handler {
            public a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Log.d("mProgress=f=", message.obj + "");
                message.obj.toString().equals("1");
                n.this.e(false);
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
                n.this.b.we(this.a, this.b);
                FragmentStatePagerSupport_Main.a0 = true;
                Toast.makeText(n.this.getActivity(), n.this.getActivity().getString(R.string.done), 0).show();
            }
        }

        public class d implements Preference.OnPreferenceChangeListener {
            public d() {
            }

            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                Boolean bool = (Boolean) obj;
                if (((SwitchPreference) preference).isChecked() == bool.booleanValue()) {
                    return true;
                }
                boolean zBooleanValue = bool.booleanValue();
                n.this.b.Lc("db_item_changed", "1");
                if (zBooleanValue) {
                    n.this.b.v0("update sys_conf set value_='1' where id=10");
                    return true;
                }
                n.this.b.v0("update sys_conf set value_='0' where id=10");
                return true;
            }
        }

        public class e implements Preference.OnPreferenceChangeListener {
            public e() {
            }

            @Override // android.preference.Preference.OnPreferenceChangeListener
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

            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                Boolean bool = (Boolean) obj;
                if (((SwitchPreference) preference).isChecked() == bool.booleanValue()) {
                    return true;
                }
                boolean zBooleanValue = bool.booleanValue();
                n.this.b.Lc("db_item_changed", "1");
                n.this.b.Lc("db_cus_changed", "1");
                n.this.c(zBooleanValue);
                return true;
            }
        }

        public class g implements Preference.OnPreferenceChangeListener {
            public g() {
            }

            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                SettingsActivity_old.e = true;
                FragmentStatePagerSupport_Main.c0 = true;
                n.this.getActivity().recreate();
                return true;
            }
        }

        public class h implements Preference.OnPreferenceChangeListener {
            public h() {
            }

            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                n.this.b.v0("update sys_conf set value_='" + obj.toString() + "' where id=1");
                n.this.b.Lc("pref_cash_id", obj.toString());
                SettingsActivity_old.g(n.this.findPreference("pref_cash_id"));
                return true;
            }
        }

        public class i implements Preference.OnPreferenceChangeListener {
            public i() {
            }

            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                Boolean bool = (Boolean) obj;
                if (((SwitchPreference) preference).isChecked() == bool.booleanValue()) {
                    return true;
                }
                if (bool.booleanValue()) {
                    n.this.b.Lc("db_item_changed", "1");
                    SettingsActivity_old.g(n.this.findPreference("pref_cost_avg"));
                    return true;
                }
                n.this.b.Lc("pref_cost_avg", "1");
                n.this.b.Lc("db_item_changed", "1");
                SettingsActivity_old.g(n.this.findPreference("pref_cost_avg"));
                return true;
            }
        }

        public class j implements Preference.OnPreferenceChangeListener {
            public j() {
            }

            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                n.this.b.Lc("pref_cost_avg", obj.toString());
                n.this.b.Lc("db_item_changed", "1");
                SettingsActivity_old.g(n.this.findPreference("pref_cost_avg"));
                return true;
            }
        }

        public class k implements Preference.OnPreferenceChangeListener {
            public k() {
            }

            @Override // android.preference.Preference.OnPreferenceChangeListener
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
                n.this.b.Lc("db_item_changed", "1");
                n.this.b.bc(this.a);
                n.this.b.Rd(200);
                Message message = new Message();
                message.obj = "1";
                n.this.d.sendMessage(message);
            }
        }

        public final void a(String str, String str2) {
            new AlertDialog.Builder(getActivity()).setTitle(getActivity().getString(R.string.yearly_closing_balance) + " " + str).setMessage(getActivity().getString(R.string.yearly_closing_balance_msg) + " " + str2).setCancelable(true).setPositiveButton(getActivity().getString(R.string.confirm_yes), new c(str, str2)).setNegativeButton(getActivity().getString(R.string.confirm_no), new b()).show();
        }

        public void b() {
            this.b.Y();
            new DateFormat();
            String string = DateFormat.format("yyyyMMddkkmmss", new Date()).toString();
            if (AbstractC2242g10.e(getActivity(), "inv.db", string + "-yearly.db", "info.aalmoghalis.inventory")) {
                this.b = new Z00(this.a, getActivity());
                Calendar calendar = Calendar.getInstance();
                new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                int i2 = calendar.get(1);
                StringBuilder sb = new StringBuilder();
                sb.append(i2 - 1);
                sb.append("-12-31");
                a(sb.toString(), i2 + "-01-01");
            }
        }

        public void c(boolean z) {
            e(true);
            new Thread(new l(z)).start();
        }

        public void d(ListPreference listPreference) {
            new ArrayList();
            ArrayList arrayListK2 = this.b.K2();
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

        public void e(boolean z) {
            Log.d("mProgress=", "....start..." + z);
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setView(getActivity().getLayoutInflater().inflate(R.layout.progress, (ViewGroup) null));
                if (z) {
                    AlertDialog alertDialogCreate = builder.create();
                    this.c = alertDialogCreate;
                    alertDialogCreate.setCancelable(false);
                    this.c.show();
                } else {
                    Dialog dialog = this.c;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            Preference.OnPreferenceChangeListener onPreferenceChangeListener = SettingsActivity_old.d;
            addPreferencesFromResource(R.xml.pref_others);
            setHasOptionsMenu(true);
            this.b = new Z00(this.a, getActivity());
            FragmentStatePagerSupport_Main.a0 = true;
            SettingsActivity_old.g(findPreference("pref_cost_avg"));
            SettingsActivity_old.g(findPreference("pref_barcode_type"));
            Z00 z00 = this.b;
            z00.Lc("pref_cash_id", z00.e5("1"));
            SettingsActivity_old.g(findPreference("pref_cash_id"));
            Log.d("oncreateview=", SettingsActivity_old.e + ":oncreate");
            SwitchPreference switchPreference = (SwitchPreference) findPreference("prefOthers_currency");
            ListPreference listPreference = (ListPreference) findPreference("prefLanguage");
            Preference preferenceFindPreference = findPreference("prefOthers_activation");
            SwitchPreference switchPreference2 = (SwitchPreference) findPreference("prefOthers_item_end_date");
            SwitchPreference switchPreference3 = (SwitchPreference) findPreference("prefOthers_closed_year");
            PreferenceScreen preferenceScreen = getPreferenceScreen();
            if (preferenceFindPreference != null && !this.b.R()) {
                preferenceScreen.removePreference(preferenceFindPreference);
            }
            if (switchPreference2 != null) {
                switchPreference2.setOnPreferenceChangeListener(new d());
            }
            if (switchPreference3 != null && this.b.N2() == 0) {
                preferenceScreen.removePreference(switchPreference3);
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
                d(listPreference2);
                SettingsActivity_old.g(findPreference("pref_cash_id"));
                listPreference2.setOnPreferenceChangeListener(new h());
            }
            SwitchPreference switchPreference4 = (SwitchPreference) findPreference("prefOthers_sales_out_qty");
            if (switchPreference4 != null) {
                switchPreference4.setOnPreferenceChangeListener(new i());
            }
            ListPreference listPreference3 = (ListPreference) findPreference("pref_cost_avg");
            if (listPreference3 != null) {
                SettingsActivity_old.g(findPreference("pref_cost_avg"));
                listPreference3.setOnPreferenceChangeListener(new j());
            }
            SwitchPreference switchPreference5 = (SwitchPreference) findPreference("pref_other_option_sales_tax");
            if (switchPreference5 != null) {
                switchPreference5.setOnPreferenceChangeListener(new k());
            }
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            Log.d("oncreateview=", SettingsActivity_old.e + "");
            if (viewOnCreateView != null) {
                this.e = (ListView) viewOnCreateView.findViewById(android.R.id.list);
            }
            return viewOnCreateView;
        }

        @Override // android.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity_old.class));
            return true;
        }

        @Override // android.preference.PreferenceFragment
        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
            super.onPreferenceTreeClick(preferenceScreen, preference);
            if (preference != null && preference.getKey().equals("prefCloseBalance")) {
                b();
            } else if (preference != null && preference.getKey().equals("prefOthers_activation")) {
                if (this.b.R()) {
                    this.b.r = getActivity();
                    this.b.qe(getActivity(), getActivity());
                } else {
                    Toast.makeText(getActivity(), getString(R.string.activated), 0).show();
                }
            }
            return false;
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
        }
    }

    public static class o extends PreferenceFragment {
        public Z00 a;
        public SQLiteDatabase b;
        public ListView c;

        public class a implements Preference.OnPreferenceChangeListener {
            public a() {
            }

            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                SwitchPreference switchPreference = (SwitchPreference) preference;
                Boolean bool = (Boolean) obj;
                if (switchPreference.isChecked() == bool.booleanValue()) {
                    return true;
                }
                if (!bool.booleanValue()) {
                    if (switchPreference.getKey().equals("prefAutoSMS")) {
                        o.this.a.v0("update customers set sms=0 where id>0 and sms=1 and wa=0 ");
                        return true;
                    }
                    if (!switchPreference.getKey().equals("prefAutoSMS_wa")) {
                        return true;
                    }
                    o.this.a.v0("update customers set wa=0 where id>0 and wa=1 and sms=0 ");
                    return true;
                }
                if (switchPreference.getKey().equals("prefAutoSMS")) {
                    o.this.a.Mc("prefAutoSMS_wa", false);
                    ((SwitchPreference) o.this.findPreference("prefAutoSMS_wa")).setChecked(false);
                    o.this.a.v0("update customers set sms=1 where id>0 and wa=0 and sms=0");
                    return true;
                }
                if (!switchPreference.getKey().equals("prefAutoSMS_wa")) {
                    return true;
                }
                o.this.a.Mc("prefAutoSMS", false);
                ((SwitchPreference) o.this.findPreference("prefAutoSMS")).setChecked(false);
                o.this.a.v0("update customers set wa=1 where id>0 and wa=0 and sms=0");
                return true;
            }
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            getView();
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.pref_sms_wa);
            setHasOptionsMenu(true);
            this.a = new Z00(this.b, getActivity());
            SettingsActivity_old.g(findPreference("prefSMS_header"));
            SettingsActivity_old.g(findPreference("prefSMS_footer"));
            SettingsActivity_old.g(findPreference("prefSMS_debit"));
            SettingsActivity_old.g(findPreference("prefSMS_credit"));
            SettingsActivity_old.g(findPreference("pref_notify_bill_type"));
            try {
                a aVar = new a();
                findPreference("prefAutoSMS").setOnPreferenceChangeListener(aVar);
                findPreference("prefAutoSMS_wa").setOnPreferenceChangeListener(aVar);
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("api_url=", ":" + e.getMessage());
            }
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            Log.d("oncreateview=", SettingsActivity_old.e + "");
            if (viewOnCreateView != null) {
                this.c = (ListView) viewOnCreateView.findViewById(android.R.id.list);
            }
            return viewOnCreateView;
        }

        @Override // android.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity_old.class));
            return true;
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
        }
    }

    public static class p extends PreferenceFragment {

        public class a implements Preference.OnPreferenceChangeListener {
            public a() {
            }

            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                Boolean bool = (Boolean) obj;
                if (((SwitchPreference) preference).isChecked() == bool.booleanValue()) {
                    return true;
                }
                boolean zBooleanValue = bool.booleanValue();
                String strB = p.this.b("prefPassword", "");
                if (zBooleanValue) {
                    p.this.a(0, strB);
                    return true;
                }
                if (strB.length() <= 0) {
                    return true;
                }
                p.this.a(2, strB);
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
            public final /* synthetic */ AlertDialog a;

            public d(AlertDialog alertDialog) {
                this.a = alertDialog;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.dismiss();
            }
        }

        public class e implements View.OnClickListener {
            public final /* synthetic */ EditText a;
            public final /* synthetic */ EditText b;
            public final /* synthetic */ String c;
            public final /* synthetic */ int d;
            public final /* synthetic */ AlertDialog e;

            public e(EditText editText, EditText editText2, String str, int i, AlertDialog alertDialog) {
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
                                    Toast.makeText(p.this.getActivity(), p.this.getString(R.string.pw_min), 0).show();
                                    return;
                                }
                                if ((!string.equals(this.c)) && (this.d >= 1)) {
                                    Toast.makeText(p.this.getActivity(), p.this.getString(R.string.settings_pwd_not_equal), 0).show();
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    if (this.d != 2) {
                        Toast.makeText(p.this.getActivity(), "Matching passwords=" + string2, 0).show();
                        p.this.c("prefPassword", string2);
                        SettingsActivity_old.g(p.this.findPreference("prefPassword"));
                    } else {
                        p.this.c("prefPassword", "");
                        SettingsActivity_old.g(p.this.findPreference("prefPassword"));
                        p.this.d("prefLogin", false);
                        ((SwitchPreference) p.this.findPreference("prefLogin")).setChecked(false);
                    }
                    if (this.d == 0) {
                        p.this.d("prefLogin", true);
                        ((SwitchPreference) p.this.findPreference("prefLogin")).setChecked(true);
                    }
                    this.e.dismiss();
                } catch (Exception e) {
                    Toast.makeText(p.this.getActivity(), e.getMessage(), 1).show();
                }
            }
        }

        public void a(int i, String str) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.password_dialog, (ViewGroup) getActivity().findViewById(R.id.root));
                builder.setView(viewInflate);
                EditText editText = (EditText) viewInflate.findViewById(R.id.EditText_Pwd1);
                EditText editText2 = (EditText) viewInflate.findViewById(R.id.EditText_Pwd2);
                TextView textView = (TextView) viewInflate.findViewById(R.id.TextView_PwdProblem);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.TextView_Pwd1);
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.TextView_Pwd2);
                if (i == 0) {
                    editText.setVisibility(8);
                    textView2.setVisibility(8);
                    textView3.setText(R.string.pref_password);
                } else if (i == 2) {
                    editText2.setVisibility(8);
                    textView3.setVisibility(8);
                    textView2.setText(R.string.pref_password);
                }
                editText2.addTextChangedListener(new b(editText, editText2, str, i, textView));
                builder.setPositiveButton(getString(R.string.resourceID_OK), new c());
                AlertDialog alertDialogCreate = builder.create();
                if (i == 0) {
                    alertDialogCreate.setTitle(getString(R.string.pref_login_screen));
                } else if (i == 2) {
                    alertDialogCreate.setTitle(getString(R.string.pref_login_screen_stop));
                } else {
                    alertDialogCreate.setTitle(getString(R.string.btn_change_pw));
                }
                alertDialogCreate.setCancelable(false);
                alertDialogCreate.getWindow().setSoftInputMode(4);
                alertDialogCreate.show();
                builder.setNegativeButton(getString(R.string.resourceID_Cancel), new d(alertDialogCreate));
                alertDialogCreate.getButton(-1).setOnClickListener(new e(editText, editText2, str, i, alertDialogCreate));
            } catch (Exception unused) {
            }
        }

        public String b(String str, String str2) {
            try {
                return PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(str, str2);
            } catch (Exception unused) {
                return str2;
            }
        }

        public void c(String str, String str2) {
            try {
                SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
                editorEdit.putString(str, str2);
                editorEdit.commit();
            } catch (Exception unused) {
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

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.pref_security);
            setHasOptionsMenu(true);
            SwitchPreference switchPreference = (SwitchPreference) findPreference("prefLogin");
            if (switchPreference != null) {
                switchPreference.setOnPreferenceChangeListener(new a());
            }
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            if (viewOnCreateView != null) {
            }
            return viewOnCreateView;
        }

        @Override // android.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity_old.class));
            return true;
        }

        @Override // android.preference.PreferenceFragment
        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
            super.onPreferenceTreeClick(preferenceScreen, preference);
            if (preference != null && preference.getKey().equals("prefPassword")) {
                String strB = b("prefPassword", "");
                if (strB.equals("")) {
                    a(0, strB);
                } else {
                    a(1, strB);
                }
            }
            return false;
        }
    }

    public static class q extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
        public static boolean c = false;
        public Z00 a;
        public SQLiteDatabase b;

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.pref_thermal);
            setHasOptionsMenu(true);
            this.a = new Z00(this.b, getActivity());
            SettingsActivity_old.g(findPreference("pref_thermal_remarks"));
            SettingsActivity_old.g(findPreference("prefPaperSize"));
            SettingsActivity_old.g(findPreference("prefThermalType"));
            SettingsActivity_old.g(findPreference("prefFontSize"));
            SettingsActivity_old.g(findPreference("prefNoPrinted"));
            SettingsActivity_old.g(findPreference("pref_codetable"));
            c = true;
        }

        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            if (viewOnCreateView != null) {
            }
            return viewOnCreateView;
        }

        @Override // android.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity_old.class));
            return true;
        }

        @Override // android.app.Fragment
        public void onPause() {
            super.onPause();
            getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (str.equalsIgnoreCase("prefBackup_path")) {
                findPreference(str).setSummary(this.a.ia("prefBackup_path", Z00.L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, AlertDialog alertDialog) {
        if (Z00.R != null) {
            try {
                if (Z00.S.substring(0, 14).equals(str.substring(0, 14))) {
                    this.c.v0("delete from valid ");
                    this.c.v0("insert into valid(imei,imei_code) values('" + Z00.R + "','" + Z00.S + "');");
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

    public static void g(Preference preference) {
        preference.setOnPreferenceChangeListener(d);
        if (preference instanceof SwitchPreference) {
            d.onPreferenceChange(preference, Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(preference.getContext()).getBoolean(preference.getKey(), false)));
        } else {
            d.onPreferenceChange(preference, PreferenceManager.getDefaultSharedPreferences(preference.getContext()).getString(preference.getKey(), ""));
        }
    }

    public static void h(File file, File file2) throws IOException {
        if (file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            String[] list = file.list();
            for (int i2 = 0; i2 < file.listFiles().length; i2++) {
                h(new File(file, list[i2]), new File(file2, list[i2]));
            }
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[1024];
        while (true) {
            int i3 = fileInputStream.read(bArr);
            if (i3 <= 0) {
                fileInputStream.close();
                fileOutputStream.close();
                return;
            }
            fileOutputStream.write(bArr, 0, i3);
        }
    }

    public static boolean j(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 4;
    }

    private void n() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    private void o() {
        ActionBar actionBarB = b();
        if (actionBarB != null) {
            actionBarB.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void f(int i2, String str) {
        try {
            if (this.c.Y5(Z00.R, Z00.S) != 0) {
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

    public boolean i(String str) {
        return str.startsWith(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "");
    }

    @Override // android.preference.PreferenceActivity
    public boolean isValidFragment(String str) {
        return PreferenceFragment.class.getName().equals(str) || k.class.getName().equals(str) || o.class.getName().equals(str) || j.class.getName().equals(str) || p.class.getName().equals(str) || h.class.getName().equals(str) || g.class.getName().equals(str) || l.class.getName().equals(str) || n.class.getName().equals(str) || q.class.getName().equals(str) || i.class.getName().equals(str) || m.class.getName().equals(str);
    }

    public String k(String str, String str2) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(this).getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // info.aalmoghalis.inventory.activity.c.g
    public void l(String str, String str2) {
        if (!m(str, str2) || str.equals(this.c.ia("prefBackup_path", Z00.L))) {
            return;
        }
        this.c.Lc("prefBackup_path", str);
        try {
            h(new File(Z00.L + "/Pictures/"), new File(this.c.ia("prefBackup_path", Z00.L) + "/Pictures/"));
        } catch (Exception e2) {
            Log.d("Copy_err", e2.getMessage());
            Toast.makeText(this, e2.getMessage(), 1).show();
        }
        Z00.L = this.c.ia("prefBackup_path", Z00.L);
    }

    @Override // info.aalmoghalis.inventory.activity.c.g
    public boolean m(String str, String str2) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isDirectory() && file.canWrite() && i(str);
    }

    @Override // android.preference.PreferenceActivity
    public void onBuildHeaders(List list) {
        this.c = new Z00(this.b, this);
        loadHeadersFromResource(R.xml.pref_headers, list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((PreferenceActivity.Header) it.next()).id == 2131297115 && !this.c.S()) {
                it.remove();
                break;
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            if (((PreferenceActivity.Header) it2.next()).id == 2131297305 && new C2160f10(this.c).v() > 0) {
                it2.remove();
                break;
            }
        }
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            PreferenceActivity.Header header = (PreferenceActivity.Header) it3.next();
            Log.d("header=", list.size() + ":" + ((Object) header.title) + ":" + header.iconRes);
            if (header.id == 2131296536) {
                this.c.ia("PREF_ACCOUNT_NAME", "0").equals("aalmoghalis@gmail.com");
                if ((this.c.Y5(Z00.R, Z00.S) <= 0 || this.c.ja("black_list", false)) && (this.c.ia("token", "").equals("") || this.c.ja("token_list", false))) {
                    header.title = getString(R.string.pref_activation);
                } else if (this.c.ia("expire_date_activation", "").length() > 0) {
                    C1839c10.z(this.c, "act=", "t=" + this.c.ia("expire_date_activation", "") + ":" + getString(R.string.renew_date) + ":" + ((Object) header.title) + ":" + this.c.ia("token", ""));
                    header.title = getString(R.string.renew_date);
                    header.fragment = null;
                    header.intent = null;
                    header.summary = this.c.ia("expire_date_activation", "");
                } else {
                    list.remove(header);
                }
            }
        }
    }

    @Override // info.aalmoghalis.inventory.activity.AppCompatPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d("Oncreate_Settings=", "Start..");
        o();
        Z00 z00 = new Z00(this.b, this);
        this.c = z00;
        z00.Mc("prefOthers_item_end_date", z00.e5("10").equals("1"));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_setting, menu);
        return true;
    }

    @Override // android.preference.PreferenceActivity
    public boolean onIsMultiPane() {
        return j(this);
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId != R.id.activation) {
            return super.onOptionsItemSelected(menuItem);
        }
        String strK = k("prefCode", "");
        if (strK.equals("")) {
            f(0, strK);
        } else {
            f(1, strK);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        Log.d("onrestart=", e + "");
        if (FragmentStatePagerSupport_Main.c0) {
            recreate();
            finish();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d("onResume=", "Settings_activity:" + activationActivity.f);
        if (activationActivity.f) {
            activationActivity.f = false;
            if ((this.c.Y5(Z00.R, Z00.S) <= 0 || this.c.ja("black_list", false)) && (this.c.ia("token", "").equals("") || this.c.ja("token_list", false))) {
                return;
            }
            n();
        }
    }
}
