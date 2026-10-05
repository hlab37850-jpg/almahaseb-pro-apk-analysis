package com.journeyapps.barcodescanner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import com.google.zxing.DecodeHintType;
import com.google.zxing.client.android.R;
import defpackage.AbstractC3804rX;
import defpackage.C0341Ai;
import defpackage.C0367Bi;
import defpackage.C0445Ei;
import defpackage.C4390yi;
import defpackage.InterfaceC4481zi;
import defpackage.V6;
import defpackage.Y6;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BarcodeView extends CameraPreview {
    public b F;
    public V6 G;
    public C0367Bi H;
    public InterfaceC4481zi I;
    public Handler J;
    public final Handler.Callback K;

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == R.id.zxing_decode_succeeded) {
                Y6 y6 = (Y6) message.obj;
                if (y6 != null && BarcodeView.this.G != null && BarcodeView.this.F != b.NONE) {
                    BarcodeView.this.G.b(y6);
                    if (BarcodeView.this.F == b.SINGLE) {
                        BarcodeView.this.M();
                    }
                }
                return true;
            }
            if (i == R.id.zxing_decode_failed) {
                return true;
            }
            if (i != R.id.zxing_possible_result_points) {
                return false;
            }
            List list = (List) message.obj;
            if (BarcodeView.this.G != null && BarcodeView.this.F != b.NONE) {
                BarcodeView.this.G.a(list);
            }
            return true;
        }
    }

    public enum b {
        NONE,
        SINGLE,
        CONTINUOUS
    }

    public BarcodeView(Context context) {
        super(context);
        this.F = b.NONE;
        this.G = null;
        this.K = new a();
        J();
    }

    public final C4390yi G() {
        if (this.I == null) {
            this.I = H();
        }
        C0341Ai c0341Ai = new C0341Ai();
        HashMap map = new HashMap();
        map.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, c0341Ai);
        C4390yi c4390yiA = this.I.a(map);
        c0341Ai.a(c4390yiA);
        return c4390yiA;
    }

    public InterfaceC4481zi H() {
        return new C0445Ei();
    }

    public void I(V6 v6) {
        this.F = b.SINGLE;
        this.G = v6;
        K();
    }

    public final void J() {
        this.I = new C0445Ei();
        this.J = new Handler(this.K);
    }

    public final void K() {
        L();
        if (this.F == b.NONE || !t()) {
            return;
        }
        C0367Bi c0367Bi = new C0367Bi(getCameraInstance(), G(), this.J);
        this.H = c0367Bi;
        c0367Bi.i(getPreviewFramingRect());
        this.H.k();
    }

    public final void L() {
        C0367Bi c0367Bi = this.H;
        if (c0367Bi != null) {
            c0367Bi.l();
            this.H = null;
        }
    }

    public void M() {
        this.F = b.NONE;
        this.G = null;
        L();
    }

    public InterfaceC4481zi getDecoderFactory() {
        return this.I;
    }

    public void setDecoderFactory(InterfaceC4481zi interfaceC4481zi) {
        AbstractC3804rX.a();
        this.I = interfaceC4481zi;
        C0367Bi c0367Bi = this.H;
        if (c0367Bi != null) {
            c0367Bi.j(G());
        }
    }

    @Override // com.journeyapps.barcodescanner.CameraPreview
    public void u() {
        L();
        super.u();
    }

    @Override // com.journeyapps.barcodescanner.CameraPreview
    public void x() {
        super.x();
        K();
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = b.NONE;
        this.G = null;
        this.K = new a();
        J();
    }

    public BarcodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F = b.NONE;
        this.G = null;
        this.K = new a();
        J();
    }
}
