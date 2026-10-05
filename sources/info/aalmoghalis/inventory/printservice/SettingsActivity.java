package info.aalmoghalis.inventory.printservice;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.text.TextUtils;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import info.aalmoghalis.inventory.R;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SettingsActivity extends AppCompatPreferenceActivity {
    public static Preference.OnPreferenceChangeListener b = new a();

    @TargetApi(11)
    public static class DataSyncPreferenceFragment extends PreferenceFragment {
        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.pref_data_sync3);
            setHasOptionsMenu(true);
            SettingsActivity.d(findPreference("sync_frequency"));
        }

        @Override // android.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity.class));
            return true;
        }
    }

    @TargetApi(11)
    public static class GeneralPreferenceFragment extends PreferenceFragment {
        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.pref_general3);
            setHasOptionsMenu(true);
            SettingsActivity.d(findPreference("example_text"));
            SettingsActivity.d(findPreference("example_list"));
        }

        @Override // android.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity.class));
            return true;
        }
    }

    @TargetApi(11)
    public static class NotificationPreferenceFragment extends PreferenceFragment {
        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.pref_notification3);
            setHasOptionsMenu(true);
            SettingsActivity.d(findPreference("notifications_new_message_ringtone"));
        }

        @Override // android.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity.class));
            return true;
        }
    }

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

    public static void d(Preference preference) {
        preference.setOnPreferenceChangeListener(b);
        b.onPreferenceChange(preference, PreferenceManager.getDefaultSharedPreferences(preference.getContext()).getString(preference.getKey(), ""));
    }

    public static boolean e(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 4;
    }

    public final void f() {
        ActionBar actionBarB = b();
        if (actionBarB != null) {
            actionBarB.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override // android.preference.PreferenceActivity
    public boolean isValidFragment(String str) {
        return PreferenceFragment.class.getName().equals(str) || GeneralPreferenceFragment.class.getName().equals(str) || DataSyncPreferenceFragment.class.getName().equals(str) || NotificationPreferenceFragment.class.getName().equals(str);
    }

    @Override // android.preference.PreferenceActivity
    public void onBuildHeaders(List list) {
        loadHeadersFromResource(R.xml.pref_headers3, list);
    }

    @Override // info.aalmoghalis.inventory.printservice.AppCompatPreferenceActivity, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f();
    }

    @Override // android.preference.PreferenceActivity
    public boolean onIsMultiPane() {
        return e(this);
    }
}
