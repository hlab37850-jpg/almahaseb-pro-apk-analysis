package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.itextpdf.tool.xml.html.HTML;
import com.zebra.sdk.comm.internal.BluetoothUuids;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: renamed from: p8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3616p8 {
    public static final UUID g = UUID.fromString(BluetoothUuids.PRINTING_CHANNEL_ID);
    public final Handler b;
    public a c;
    public b d;
    public c e;
    public final BluetoothAdapter a = BluetoothAdapter.getDefaultAdapter();
    public int f = 0;

    /* JADX INFO: renamed from: p8$a */
    public class a extends Thread {
        public final BluetoothServerSocket a;

        public a() {
            BluetoothServerSocket bluetoothServerSocketListenUsingRfcommWithServiceRecord;
            try {
                bluetoothServerSocketListenUsingRfcommWithServiceRecord = C3616p8.this.a.listenUsingRfcommWithServiceRecord("BTPrinter", C3616p8.g);
            } catch (IOException e) {
                Log.e("BluetoothService", "listen() failed", e);
                bluetoothServerSocketListenUsingRfcommWithServiceRecord = null;
            }
            this.a = bluetoothServerSocketListenUsingRfcommWithServiceRecord;
        }

        public void a() {
            Log.d("BluetoothService", "cancel " + this);
            try {
                this.a.close();
            } catch (IOException e) {
                Log.e("BluetoothService", "close() of server failed", e);
            }
        }

        /* JADX WARN: Code duplicated, block: B:35:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Log.d("BluetoothService", "BEGIN mAcceptThread" + this);
            setName("AcceptThread");
            while (C3616p8.this.f != 3) {
                Log.d("AcceptThread线程运行", "正在运行......");
                try {
                    BluetoothSocket bluetoothSocketAccept = this.a.accept();
                    if (bluetoothSocketAccept != null) {
                        synchronized (C3616p8.this) {
                            int i = C3616p8.this.f;
                            if (i == 0) {
                                try {
                                    bluetoothSocketAccept.close();
                                } catch (IOException e) {
                                    Log.e("BluetoothService", "Could not close unwanted socket", e);
                                }
                            } else if (i == 1 || i == 2) {
                                C3616p8.this.j(bluetoothSocketAccept, bluetoothSocketAccept.getRemoteDevice());
                            } else if (i == 3) {
                                bluetoothSocketAccept.close();
                            }
                        }
                    }
                } catch (IOException e2) {
                    Log.e("BluetoothService", "accept() failed", e2);
                }
            }
            Log.i("BluetoothService", "END mAcceptThread");
        }
    }

    /* JADX INFO: renamed from: p8$b */
    public class b extends Thread {
        public final BluetoothSocket a;
        public final BluetoothDevice b;

        public b(BluetoothDevice bluetoothDevice) {
            BluetoothSocket bluetoothSocketCreateRfcommSocketToServiceRecord;
            this.b = bluetoothDevice;
            try {
                bluetoothSocketCreateRfcommSocketToServiceRecord = bluetoothDevice.createRfcommSocketToServiceRecord(C3616p8.g);
            } catch (IOException e) {
                Log.e("BluetoothService", "create() failed", e);
                bluetoothSocketCreateRfcommSocketToServiceRecord = null;
            }
            this.a = bluetoothSocketCreateRfcommSocketToServiceRecord;
        }

        public void a() {
            try {
                this.a.close();
            } catch (IOException e) {
                Log.e("BluetoothService", "close() of connect socket failed", e);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Log.i("BluetoothService", "BEGIN mConnectThread");
            setName("ConnectThread");
            C3616p8.this.a.cancelDiscovery();
            try {
                this.a.connect();
                synchronized (C3616p8.this) {
                    C3616p8.this.d = null;
                }
                C3616p8.this.j(this.a, this.b);
            } catch (IOException unused) {
                C3616p8.this.k();
                try {
                    this.a.close();
                } catch (IOException e) {
                    Log.e("BluetoothService", "unable to close() socket during connection failure", e);
                }
                C3616p8.this.p();
            }
        }
    }

    /* JADX INFO: renamed from: p8$c */
    public class c extends Thread {
        public final BluetoothSocket a;
        public final InputStream b;
        public final OutputStream c;

        public c(BluetoothSocket bluetoothSocket) {
            InputStream inputStream;
            Log.d("BluetoothService", "create ConnectedThread");
            this.a = bluetoothSocket;
            OutputStream outputStream = null;
            try {
                inputStream = bluetoothSocket.getInputStream();
                try {
                    outputStream = bluetoothSocket.getOutputStream();
                } catch (IOException e) {
                    e = e;
                    Log.e("BluetoothService", "temp sockets not created", e);
                }
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
            }
            this.b = inputStream;
            this.c = outputStream;
        }

        public void a() {
            try {
                this.a.close();
            } catch (IOException e) {
                Log.e("BluetoothService", "close() of connect socket failed", e);
            }
        }

        public void b(byte[] bArr) {
            try {
                this.c.write(bArr);
                C3616p8.this.b.obtainMessage(3, -1, -1, bArr).sendToTarget();
            } catch (IOException e) {
                Log.e("BluetoothService", "Exception during write", e);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Log.d("ConnectedThread线程运行", "正在运行......");
            Log.i("BluetoothService", "BEGIN mConnectedThread");
            while (true) {
                try {
                    byte[] bArr = new byte[256];
                    int i = this.b.read(bArr);
                    if (i <= 0) {
                        break;
                    } else {
                        C3616p8.this.b.obtainMessage(2, i, -1, bArr).sendToTarget();
                    }
                } catch (IOException e) {
                    Log.e("BluetoothService", "disconnected", e);
                    C3616p8.this.l();
                    if (C3616p8.this.f != 0) {
                        C3616p8.this.p();
                        return;
                    }
                    return;
                }
            }
            Log.e("BluetoothService", "disconnected");
            C3616p8.this.l();
            if (C3616p8.this.f != 0) {
                Log.e("BluetoothService", "disconnected");
                C3616p8.this.p();
            }
        }
    }

    public C3616p8(Context context, Handler handler) {
        this.b = handler;
    }

    public synchronized boolean h() {
        return this.a.cancelDiscovery();
    }

    public synchronized void i(BluetoothDevice bluetoothDevice) {
        b bVar;
        try {
            Log.d("BluetoothService", "connect to: " + bluetoothDevice);
            if (this.f == 2 && (bVar = this.d) != null) {
                bVar.a();
                this.d = null;
            }
            c cVar = this.e;
            if (cVar != null) {
                cVar.a();
                this.e = null;
            }
            b bVar2 = new b(bluetoothDevice);
            this.d = bVar2;
            bVar2.start();
            o(2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void j(BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice) {
        try {
            Log.d("BluetoothService", "connected");
            b bVar = this.d;
            if (bVar != null) {
                bVar.a();
                this.d = null;
            }
            c cVar = this.e;
            if (cVar != null) {
                cVar.a();
                this.e = null;
            }
            a aVar = this.c;
            if (aVar != null) {
                aVar.a();
                this.c = null;
            }
            c cVar2 = new c(bluetoothSocket);
            this.e = cVar2;
            cVar2.start();
            this.b.sendMessage(this.b.obtainMessage(4));
            o(3);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void k() {
        o(1);
        this.b.sendMessage(this.b.obtainMessage(6));
    }

    public final void l() {
        this.b.sendMessage(this.b.obtainMessage(5));
    }

    public synchronized BluetoothDevice m(String str) {
        return this.a.getRemoteDevice(str);
    }

    public synchronized Set n() {
        return this.a.getBondedDevices();
    }

    public final synchronized void o(int i) {
        this.f = i;
        this.b.obtainMessage(1, i, -1).sendToTarget();
    }

    public synchronized void p() {
        try {
            Log.d("BluetoothService", HTML.Attribute.START);
            b bVar = this.d;
            if (bVar != null) {
                bVar.a();
                this.d = null;
            }
            c cVar = this.e;
            if (cVar != null) {
                cVar.a();
                this.e = null;
            }
            if (this.c == null) {
                a aVar = new a();
                this.c = aVar;
                aVar.start();
            }
            o(1);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void q(byte[] bArr) {
        synchronized (this) {
            try {
                if (this.f != 3) {
                    return;
                }
                this.e.b(bArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
