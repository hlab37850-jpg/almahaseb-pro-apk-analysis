package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes3.dex */
public class VH {
    public static VH c;
    public final XH a;
    public final BluetoothDevice b;

    public interface a {
        void a(VH vh);
    }

    public interface b {
        void a(String str);
    }

    public VH(Context context) {
        EH.b(context);
        BluetoothDevice bluetoothDeviceF = f();
        this.b = bluetoothDeviceF;
        this.a = new XH(bluetoothDeviceF);
    }

    public static BluetoothDevice f() {
        return g(EH.a("bonded_device"));
    }

    public static BluetoothDevice g(String str) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice bluetoothDevice = null;
        if (defaultAdapter == null) {
            return null;
        }
        for (BluetoothDevice bluetoothDevice2 : defaultAdapter.getBondedDevices()) {
            if (bluetoothDevice2.getAddress().equalsIgnoreCase(str)) {
                bluetoothDevice = bluetoothDevice2;
            }
        }
        return bluetoothDevice;
    }

    public static /* synthetic */ void i(b bVar) {
        if (bVar != null) {
            bVar.a("Failed to connect printer");
        }
    }

    public static VH l(Context context) {
        VH vh = new VH(context);
        c = vh;
        return vh;
    }

    public void c() {
        this.a.c();
    }

    public void d(final a aVar, final b bVar) {
        this.a.e(new XH.d() { // from class: TH
            @Override // XH.d
            public final void onConnected() {
                this.a.h(aVar);
            }
        }, new XH.c() { // from class: UH
            @Override // XH.c
            public final void a() {
                VH.i(bVar);
            }
        });
    }

    public BluetoothDevice e() {
        return f();
    }

    public final /* synthetic */ void h(a aVar) {
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public boolean j(Bitmap bitmap, int i) {
        return this.a.g(bitmap, i);
    }

    public void k() {
        this.a.j();
    }
}
