package defpackage;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import com.google.zxing.client.android.AmbientLightManager;
import com.google.zxing.client.android.camera.CameraConfigurationUtils;
import com.google.zxing.client.android.camera.open.OpenCameraInterface;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: pa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3646pa {
    public static final String n = "pa";
    public Camera a;
    public Camera.CameraInfo b;
    public C2415i6 c;
    public AmbientLightManager d;
    public boolean e;
    public String f;
    public C0546Gj h;
    public NQ i;
    public NQ j;
    public Context l;
    public C3727qa g = new C3727qa();
    public int k = -1;
    public final a m = new a();

    /* JADX INFO: renamed from: pa$a */
    public final class a implements Camera.PreviewCallback {
        public LH a;
        public NQ b;

        public a() {
        }

        public void a(LH lh) {
            this.a = lh;
        }

        public void b(NQ nq) {
            this.b = nq;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            NQ nq = this.b;
            LH lh = this.a;
            if (nq == null || lh == null) {
                Log.d(C3646pa.n, "Got preview callback, but no handler or resolution available");
                if (lh != null) {
                    lh.a(new Exception("No resolution available"));
                    return;
                }
                return;
            }
            try {
                if (bArr == null) {
                    throw new NullPointerException("No preview data received");
                }
                lh.b(new C3391mR(bArr, nq.a, nq.b, camera.getParameters().getPreviewFormat(), C3646pa.this.e()));
            } catch (RuntimeException e) {
                Log.e(C3646pa.n, "Camera preview failed", e);
                lh.a(e);
            }
        }
    }

    public C3646pa(Context context) {
        this.l = context;
    }

    public static List h(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                arrayList.add(new NQ(previewSize.width, previewSize.height));
            }
            return arrayList;
        }
        for (Camera.Size size : supportedPreviewSizes) {
            arrayList.add(new NQ(size.width, size.height));
        }
        return arrayList;
    }

    public final int b() {
        int iC = this.h.c();
        int i = 0;
        if (iC != 0) {
            if (iC == 1) {
                i = 90;
            } else if (iC == 2) {
                i = ShapeTypes.MATH_EQUAL;
            } else if (iC == 3) {
                i = TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
            }
        }
        Camera.CameraInfo cameraInfo = this.b;
        int i2 = cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i) % 360)) % 360 : ((cameraInfo.orientation - i) + 360) % 360;
        Log.i(n, "Camera Display Orientation: " + i2);
        return i2;
    }

    public void c() {
        Camera camera = this.a;
        if (camera != null) {
            camera.release();
            this.a = null;
        }
    }

    public void d() {
        if (this.a == null) {
            throw new RuntimeException("Camera not open");
        }
        q();
    }

    public int e() {
        return this.k;
    }

    public final Camera.Parameters f() {
        Camera.Parameters parameters = this.a.getParameters();
        String str = this.f;
        if (str == null) {
            this.f = parameters.flatten();
        } else {
            parameters.unflatten(str);
        }
        return parameters;
    }

    public NQ g() {
        if (this.j == null) {
            return null;
        }
        return i() ? this.j.b() : this.j;
    }

    public boolean i() {
        int i = this.k;
        if (i != -1) {
            return i % ShapeTypes.MATH_EQUAL != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public boolean j() {
        String flashMode;
        Camera.Parameters parameters = this.a.getParameters();
        if (parameters == null || (flashMode = parameters.getFlashMode()) == null) {
            return false;
        }
        return "on".equals(flashMode) || "torch".equals(flashMode);
    }

    public void k() {
        Camera cameraOpen = OpenCameraInterface.open(this.g.b());
        this.a = cameraOpen;
        if (cameraOpen == null) {
            throw new RuntimeException("Failed to open camera");
        }
        int cameraId = OpenCameraInterface.getCameraId(this.g.b());
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.b = cameraInfo;
        Camera.getCameraInfo(cameraId, cameraInfo);
    }

    public void l(LH lh) {
        Camera camera = this.a;
        if (camera == null || !this.e) {
            return;
        }
        this.m.a(lh);
        camera.setOneShotPreviewCallback(this.m);
    }

    public final void m(int i) {
        this.a.setDisplayOrientation(i);
    }

    public void n(C3727qa c3727qa) {
        this.g = c3727qa;
    }

    public final void o(boolean z) {
        Camera.Parameters parametersF = f();
        if (parametersF == null) {
            Log.w(n, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        String str = n;
        Log.i(str, "Initial camera parameters: " + parametersF.flatten());
        if (z) {
            Log.w(str, "In camera config safe mode -- most settings will not be honored");
        }
        CameraConfigurationUtils.setFocus(parametersF, this.g.a(), z);
        if (!z) {
            CameraConfigurationUtils.setTorch(parametersF, false);
            if (this.g.h()) {
                CameraConfigurationUtils.setInvertColor(parametersF);
            }
            if (this.g.e()) {
                CameraConfigurationUtils.setBarcodeSceneMode(parametersF);
            }
            if (this.g.g()) {
                CameraConfigurationUtils.setVideoStabilization(parametersF);
                CameraConfigurationUtils.setFocusArea(parametersF);
                CameraConfigurationUtils.setMetering(parametersF);
            }
        }
        List listH = h(parametersF);
        if (listH.size() == 0) {
            this.i = null;
        } else {
            NQ nqA = this.h.a(listH, i());
            this.i = nqA;
            parametersF.setPreviewSize(nqA.a, nqA.b);
        }
        if (Build.DEVICE.equals("glass-1")) {
            CameraConfigurationUtils.setBestPreviewFPS(parametersF);
        }
        Log.i(str, "Final camera parameters: " + parametersF.flatten());
        this.a.setParameters(parametersF);
    }

    public void p(C0546Gj c0546Gj) {
        this.h = c0546Gj;
    }

    public final void q() {
        try {
            int iB = b();
            this.k = iB;
            m(iB);
        } catch (Exception unused) {
            Log.w(n, "Failed to set rotation.");
        }
        try {
            o(false);
        } catch (Exception unused2) {
            try {
                o(true);
            } catch (Exception unused3) {
                Log.w(n, "Camera rejected even safe-mode parameters! No configuration");
            }
        }
        Camera.Size previewSize = this.a.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.j = this.i;
        } else {
            this.j = new NQ(previewSize.width, previewSize.height);
        }
        this.m.b(this.j);
    }

    public void r(C3807ra c3807ra) throws IOException {
        c3807ra.a(this.a);
    }

    public void s(boolean z) {
        if (this.a != null) {
            try {
                if (z != j()) {
                    C2415i6 c2415i6 = this.c;
                    if (c2415i6 != null) {
                        c2415i6.j();
                    }
                    Camera.Parameters parameters = this.a.getParameters();
                    CameraConfigurationUtils.setTorch(parameters, z);
                    if (this.g.f()) {
                        CameraConfigurationUtils.setBestExposure(parameters, z);
                    }
                    this.a.setParameters(parameters);
                    C2415i6 c2415i7 = this.c;
                    if (c2415i7 != null) {
                        c2415i7.i();
                    }
                }
            } catch (RuntimeException e) {
                Log.e(n, "Failed to set torch", e);
            }
        }
    }

    public void t() {
        Camera camera = this.a;
        if (camera == null || this.e) {
            return;
        }
        camera.startPreview();
        this.e = true;
        this.c = new C2415i6(this.a, this.g);
        AmbientLightManager ambientLightManager = new AmbientLightManager(this.l, this, this.g);
        this.d = ambientLightManager;
        ambientLightManager.start();
    }

    public void u() {
        C2415i6 c2415i6 = this.c;
        if (c2415i6 != null) {
            c2415i6.j();
            this.c = null;
        }
        AmbientLightManager ambientLightManager = this.d;
        if (ambientLightManager != null) {
            ambientLightManager.stop();
            this.d = null;
        }
        Camera camera = this.a;
        if (camera == null || !this.e) {
            return;
        }
        camera.stopPreview();
        this.m.a(null);
        this.e = false;
    }
}
