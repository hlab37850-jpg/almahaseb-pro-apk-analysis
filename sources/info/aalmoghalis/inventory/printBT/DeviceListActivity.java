package info.aalmoghalis.inventory.printBT;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.zebra.sdk.util.internal.StringUtilities;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceListActivity extends BaseActivity {
    public BluetoothAdapter c;
    public ArrayAdapter d;
    public AdapterView.OnItemClickListener e = new a();

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            try {
                DeviceListActivity.this.c.cancelDiscovery();
                String string = ((TextView) view).getText().toString();
                String strSubstring = string.substring(string.length() - 17);
                Log.v("TAG", "Device_Address " + strSubstring);
                Bundle bundle = new Bundle();
                bundle.putString("DeviceAddress", strSubstring);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                DeviceListActivity.this.setResult(-1, intent);
                DeviceListActivity.this.finish();
            } catch (Exception unused) {
            }
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(5);
        setContentView(R.layout.device_list);
        setResult(0);
        this.d = new ArrayAdapter(this, R.layout.device_name);
        ListView listView = (ListView) findViewById(R.id.paired_devices);
        listView.setAdapter((ListAdapter) this.d);
        listView.setOnItemClickListener(this.e);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.c = defaultAdapter;
        Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
        if (bondedDevices.size() <= 0) {
            this.d.add("None Paired");
            return;
        }
        findViewById(R.id.title_paired_devices).setVisibility(0);
        for (BluetoothDevice bluetoothDevice : bondedDevices) {
            this.d.add(bluetoothDevice.getName() + StringUtilities.LF + bluetoothDevice.getAddress());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BluetoothAdapter bluetoothAdapter = this.c;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.cancelDiscovery();
        }
    }
}
