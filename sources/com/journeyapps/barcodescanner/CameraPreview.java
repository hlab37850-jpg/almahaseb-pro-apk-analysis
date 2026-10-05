package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.google.zxing.client.android.R;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC3804rX;
import defpackage.C0546Gj;
import defpackage.C0575Hm;
import defpackage.C0601Im;
import defpackage.C0901Sa;
import defpackage.C3468nM;
import defpackage.C3564oa;
import defpackage.C3727qa;
import defpackage.C3807ra;
import defpackage.InterfaceC3386mM;
import defpackage.NH;
import defpackage.NQ;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CameraPreview extends ViewGroup {
    public static final String E = "CameraPreview";
    public final SurfaceHolder.Callback A;
    public final Handler.Callback B;
    public InterfaceC3386mM C;
    public final f D;
    public C3564oa a;
    public WindowManager b;
    public Handler c;
    public boolean d;
    public SurfaceView e;
    public TextureView f;
    public boolean g;
    public C3468nM h;
    public int i;
    public List j;
    public C0546Gj k;
    public C3727qa l;
    public NQ n;
    public NQ p;
    public Rect q;
    public NQ t;
    public Rect u;
    public Rect v;
    public NQ w;
    public double x;
    public NH y;
    public boolean z;

    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            CameraPreview.this.t = new NQ(i, i2);
            CameraPreview.this.C();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public class b implements SurfaceHolder.Callback {
        public b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (surfaceHolder == null) {
                Log.e(CameraPreview.E, "*** WARNING *** surfaceChanged() gave us a null surface!");
                return;
            }
            CameraPreview.this.t = new NQ(i2, i3);
            CameraPreview.this.C();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CameraPreview.this.t = null;
        }
    }

    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == R.id.zxing_prewiew_size_ready) {
                CameraPreview.this.w((NQ) message.obj);
                return true;
            }
            if (i != R.id.zxing_camera_error) {
                if (i != R.id.zxing_camera_closed) {
                    return false;
                }
                CameraPreview.this.D.d();
                return false;
            }
            Exception exc = (Exception) message.obj;
            if (!CameraPreview.this.r()) {
                return false;
            }
            CameraPreview.this.u();
            CameraPreview.this.D.b(exc);
            return false;
        }
    }

    public class d implements InterfaceC3386mM {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraPreview.this.z();
            }
        }

        public d() {
        }

        @Override // defpackage.InterfaceC3386mM
        public void a(int i) {
            CameraPreview.this.c.postDelayed(new a(), 250L);
        }
    }

    public class e implements f {
        public e() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void a() {
            Iterator it = CameraPreview.this.j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a();
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void b(Exception exc) {
            Iterator it = CameraPreview.this.j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).b(exc);
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void c() {
            Iterator it = CameraPreview.this.j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).c();
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void d() {
            Iterator it = CameraPreview.this.j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).d();
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void e() {
            Iterator it = CameraPreview.this.j.iterator();
            while (it.hasNext()) {
                ((f) it.next()).e();
            }
        }
    }

    public interface f {
        void a();

        void b(Exception exc);

        void c();

        void d();

        void e();
    }

    public CameraPreview(Context context) {
        super(context);
        this.d = false;
        this.g = false;
        this.i = -1;
        this.j = new ArrayList();
        this.l = new C3727qa();
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = 0.1d;
        this.y = null;
        this.z = false;
        this.A = new b();
        this.B = new c();
        this.C = new d();
        this.D = new e();
        p(context, null, 0, 0);
    }

    private int getDisplayRotation() {
        return this.b.getDefaultDisplay().getRotation();
    }

    public final void A() {
        if (this.d) {
            TextureView textureView = new TextureView(getContext());
            this.f = textureView;
            textureView.setSurfaceTextureListener(D());
            addView(this.f);
            return;
        }
        SurfaceView surfaceView = new SurfaceView(getContext());
        this.e = surfaceView;
        surfaceView.getHolder().addCallback(this.A);
        addView(this.e);
    }

    public final void B(C3807ra c3807ra) {
        if (this.g || this.a == null) {
            return;
        }
        Log.i(E, "Starting preview");
        this.a.u(c3807ra);
        this.a.w();
        this.g = true;
        x();
        this.D.e();
    }

    public final void C() {
        Rect rect;
        NQ nq = this.t;
        if (nq == null || this.p == null || (rect = this.q) == null) {
            return;
        }
        if (this.e != null && nq.equals(new NQ(rect.width(), this.q.height()))) {
            B(new C3807ra(this.e.getHolder()));
            return;
        }
        TextureView textureView = this.f;
        if (textureView == null || textureView.getSurfaceTexture() == null) {
            return;
        }
        if (this.p != null) {
            this.f.setTransform(l(new NQ(this.f.getWidth(), this.f.getHeight()), this.p));
        }
        B(new C3807ra(this.f.getSurfaceTexture()));
    }

    public final TextureView.SurfaceTextureListener D() {
        return new a();
    }

    public C3564oa getCameraInstance() {
        return this.a;
    }

    public C3727qa getCameraSettings() {
        return this.l;
    }

    public Rect getFramingRect() {
        return this.u;
    }

    public NQ getFramingRectSize() {
        return this.w;
    }

    public double getMarginFraction() {
        return this.x;
    }

    public Rect getPreviewFramingRect() {
        return this.v;
    }

    public NH getPreviewScalingStrategy() {
        NH nh = this.y;
        if (nh != null) {
            return nh;
        }
        return this.f != null ? new C0901Sa() : new C0575Hm();
    }

    public void i(f fVar) {
        this.j.add(fVar);
    }

    public final void j() {
        NQ nq;
        C0546Gj c0546Gj;
        NQ nq2 = this.n;
        if (nq2 == null || (nq = this.p) == null || (c0546Gj = this.k) == null) {
            this.v = null;
            this.u = null;
            this.q = null;
            throw new IllegalStateException("containerSize or previewSize is not set yet");
        }
        int i = nq.a;
        int i2 = nq.b;
        int i3 = nq2.a;
        int i4 = nq2.b;
        this.q = c0546Gj.d(nq);
        this.u = k(new Rect(0, 0, i3, i4), this.q);
        Rect rect = new Rect(this.u);
        Rect rect2 = this.q;
        rect.offset(-rect2.left, -rect2.top);
        Rect rect3 = new Rect((rect.left * i) / this.q.width(), (rect.top * i2) / this.q.height(), (rect.right * i) / this.q.width(), (rect.bottom * i2) / this.q.height());
        this.v = rect3;
        if (rect3.width() > 0 && this.v.height() > 0) {
            this.D.a();
            return;
        }
        this.v = null;
        this.u = null;
        Log.w(E, "Preview frame is too small");
    }

    public Rect k(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.w != null) {
            rect3.inset(Math.max(0, (rect3.width() - this.w.a) / 2), Math.max(0, (rect3.height() - this.w.b) / 2));
            return rect3;
        }
        int iMin = (int) Math.min(((double) rect3.width()) * this.x, ((double) rect3.height()) * this.x);
        rect3.inset(iMin, iMin);
        if (rect3.height() > rect3.width()) {
            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
        }
        return rect3;
    }

    public Matrix l(NQ nq, NQ nq2) {
        float f2;
        float f3 = nq.a / nq.b;
        float f4 = nq2.a / nq2.b;
        float f5 = 1.0f;
        if (f3 < f4) {
            f5 = f4 / f3;
            f2 = 1.0f;
        } else {
            f2 = f3 / f4;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f5, f2);
        int i = nq.a;
        int i2 = nq.b;
        matrix.postTranslate((i - (i * f5)) / 2.0f, (i2 - (i2 * f2)) / 2.0f);
        return matrix;
    }

    public final void m(NQ nq) {
        this.n = nq;
        C3564oa c3564oa = this.a;
        if (c3564oa == null || c3564oa.l() != null) {
            return;
        }
        C0546Gj c0546Gj = new C0546Gj(getDisplayRotation(), nq);
        this.k = c0546Gj;
        c0546Gj.e(getPreviewScalingStrategy());
        this.a.s(this.k);
        this.a.k();
        boolean z = this.z;
        if (z) {
            this.a.v(z);
        }
    }

    public C3564oa n() {
        C3564oa c3564oa = new C3564oa(getContext());
        c3564oa.r(this.l);
        return c3564oa;
    }

    public final void o() {
        if (this.a != null) {
            Log.w(E, "initCamera called twice");
            return;
        }
        C3564oa c3564oaN = n();
        this.a = c3564oaN;
        c3564oaN.t(this.c);
        this.a.p();
        this.i = getDisplayRotation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        A();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m(new NQ(i3 - i, i4 - i2));
        SurfaceView surfaceView = this.e;
        if (surfaceView == null) {
            TextureView textureView = this.f;
            if (textureView != null) {
                textureView.layout(0, 0, getWidth(), getHeight());
                return;
            }
            return;
        }
        Rect rect = this.q;
        if (rect == null) {
            surfaceView.layout(0, 0, getWidth(), getHeight());
        } else {
            surfaceView.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable(CSS.Value.SUPER));
        setTorch(bundle.getBoolean("torch"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable(CSS.Value.SUPER, parcelableOnSaveInstanceState);
        bundle.putBoolean("torch", this.z);
        return bundle;
    }

    public final void p(Context context, AttributeSet attributeSet, int i, int i2) {
        if (getBackground() == null) {
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        q(attributeSet);
        this.b = (WindowManager) context.getSystemService("window");
        this.c = new Handler(this.B);
        this.h = new C3468nM();
    }

    public void q(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_camera_preview);
        int dimension = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.zxing_camera_preview_zxing_framing_rect_width, -1.0f);
        int dimension2 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.zxing_camera_preview_zxing_framing_rect_height, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.w = new NQ(dimension, dimension2);
        }
        this.d = typedArrayObtainStyledAttributes.getBoolean(R.styleable.zxing_camera_preview_zxing_use_texture_view, true);
        int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.zxing_camera_preview_zxing_preview_scaling_strategy, -1);
        if (integer == 1) {
            this.y = new C0901Sa();
        } else if (integer == 2) {
            this.y = new C0575Hm();
        } else if (integer == 3) {
            this.y = new C0601Im();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public boolean r() {
        return this.a != null;
    }

    public boolean s() {
        C3564oa c3564oa = this.a;
        return c3564oa == null || c3564oa.n();
    }

    public void setCameraSettings(C3727qa c3727qa) {
        this.l = c3727qa;
    }

    public void setFramingRectSize(NQ nq) {
        this.w = nq;
    }

    public void setMarginFraction(double d2) {
        if (d2 >= 0.5d) {
            throw new IllegalArgumentException("The margin fraction must be less than 0.5");
        }
        this.x = d2;
    }

    public void setPreviewScalingStrategy(NH nh) {
        this.y = nh;
    }

    public void setTorch(boolean z) {
        this.z = z;
        C3564oa c3564oa = this.a;
        if (c3564oa != null) {
            c3564oa.v(z);
        }
    }

    public void setUseTextureView(boolean z) {
        this.d = z;
    }

    public boolean t() {
        return this.g;
    }

    public void u() {
        TextureView textureView;
        SurfaceView surfaceView;
        AbstractC3804rX.a();
        Log.d(E, "pause()");
        this.i = -1;
        C3564oa c3564oa = this.a;
        if (c3564oa != null) {
            c3564oa.j();
            this.a = null;
            this.g = false;
        } else {
            this.c.sendEmptyMessage(R.id.zxing_camera_closed);
        }
        if (this.t == null && (surfaceView = this.e) != null) {
            surfaceView.getHolder().removeCallback(this.A);
        }
        if (this.t == null && (textureView = this.f) != null) {
            textureView.setSurfaceTextureListener(null);
        }
        this.n = null;
        this.p = null;
        this.v = null;
        this.h.f();
        this.D.c();
    }

    public void v() {
        C3564oa cameraInstance = getCameraInstance();
        u();
        long jNanoTime = System.nanoTime();
        while (cameraInstance != null && !cameraInstance.n() && System.nanoTime() - jNanoTime <= 2000000000) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public final void w(NQ nq) {
        this.p = nq;
        if (this.n != null) {
            j();
            requestLayout();
            C();
        }
    }

    public void x() {
    }

    public void y() {
        AbstractC3804rX.a();
        Log.d(E, "resume()");
        o();
        if (this.t != null) {
            C();
        } else {
            SurfaceView surfaceView = this.e;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.A);
            } else {
                TextureView textureView = this.f;
                if (textureView != null) {
                    if (textureView.isAvailable()) {
                        D().onSurfaceTextureAvailable(this.f.getSurfaceTexture(), this.f.getWidth(), this.f.getHeight());
                    } else {
                        this.f.setSurfaceTextureListener(D());
                    }
                }
            }
        }
        requestLayout();
        this.h.e(getContext(), this.C);
    }

    public final void z() {
        if (!r() || getDisplayRotation() == this.i) {
            return;
        }
        u();
        y();
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = false;
        this.g = false;
        this.i = -1;
        this.j = new ArrayList();
        this.l = new C3727qa();
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = 0.1d;
        this.y = null;
        this.z = false;
        this.A = new b();
        this.B = new c();
        this.C = new d();
        this.D = new e();
        p(context, attributeSet, 0, 0);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = false;
        this.g = false;
        this.i = -1;
        this.j = new ArrayList();
        this.l = new C3727qa();
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = 0.1d;
        this.y = null;
        this.z = false;
        this.A = new b();
        this.B = new c();
        this.C = new d();
        this.D = new e();
        p(context, attributeSet, i, 0);
    }
}
